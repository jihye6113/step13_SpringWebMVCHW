package kosta.mvc.model.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;
import lombok.RequiredArgsConstructor;

@Repository //id="productDAOImpl"
public class ProductDAOImpl  implements ProductDAO{

	@Autowired
	private List<ProductDTO> list; //db역할(영속성)
	
	// class 위에 @RequiredArgsConstructor 선언을 하고, @Autowired한 list에 final 표시를 하면, 초기 데이터 세팅이 이뤄지지 않는다.
	
	@Override
	public List<ProductDTO> select() {
		return list;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		for(ProductDTO dto : list) {
			if(dto.getCode().equals(productDTO.getCode())) {
				throw new MyErrorException(productDTO.getCode()+"는 중복입니다.");
			}
		}		
		list.add(productDTO);
		
		return 0;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		for(ProductDTO dto : list) {
			if(dto.getCode().equals(code)) {
				list.remove(dto);
				return 1;//제거완료~~~
			}
		}		
		return 0; 
	}
	
	@Override
	public ProductDTO detail(String code) throws MyErrorException {
		for(ProductDTO dto : list) {
			if(dto.getCode().equals(code)) {
				
				return dto;
			}
		}			
		return null;
	}
}