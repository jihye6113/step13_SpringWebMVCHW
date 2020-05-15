package kosta.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.ProductDAO;
import kosta.mvc.model.dao.ProductDAOImpl;
import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;
import lombok.RequiredArgsConstructor;

@Service("productService")  //id="productService"
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
//	@Autowired
//	private ProductDAO productDAO  ;
	private final ProductDAO productDAO  ;

	@Override
	public List<ProductDTO> select() {
		
		return productDAO.select();
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		//가격 체크
		if(productDTO.getPrice() < 1000 || productDTO.getPrice() > 10000) { // getter 주의
			throw new MyErrorException("가격은 1000 ~ 10000원 사이만 입력해주세요");
		}
		
		productDAO.insert(productDTO);
		
		return 0;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		if( productDAO.delete(code)==0) {
			throw new MyErrorException("삭제되지 않았습니다.");
		}
		return 1;
	}
	
	@Override
	public ProductDTO detail(String code) throws MyErrorException {
		ProductDTO product = productDAO.detail(code);
		if(product == null) throw new MyErrorException(code+"의 정보가 없습니다.");
		return product;
	}

}





