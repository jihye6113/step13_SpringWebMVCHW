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
		//���� üũ
		if(productDTO.getPrice() < 1000 || productDTO.getPrice() > 10000) { // getter ����
			throw new MyErrorException("������ 1000 ~ 10000�� ���̸� �Է����ּ���");
		}
		
		productDAO.insert(productDTO);
		
		return 0;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		if( productDAO.delete(code)==0) {
			throw new MyErrorException("�������� �ʾҽ��ϴ�.");
		}
		return 1;
	}
	
	@Override
	public ProductDTO detail(String code) throws MyErrorException {
		ProductDTO product = productDAO.detail(code);
		if(product == null) throw new MyErrorException(code+"�� ������ �����ϴ�.");
		return product;
	}

}





