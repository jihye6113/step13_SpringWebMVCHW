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
	private List<ProductDTO> list; //db����(���Ӽ�)
	
	// class ���� @RequiredArgsConstructor ������ �ϰ�, @Autowired�� list�� final ǥ�ø� �ϸ�, �ʱ� ������ ������ �̷����� �ʴ´�.
	
	@Override
	public List<ProductDTO> select() {
		return list;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		for(ProductDTO dto : list) {
			if(dto.getCode().equals(productDTO.getCode())) {
				throw new MyErrorException(productDTO.getCode()+"�� �ߺ��Դϴ�.");
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
				return 1;//���ſϷ�~~~
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