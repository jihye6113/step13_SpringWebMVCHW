package kosta.mvc.model.service;

import java.util.List;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;

public interface ProductService {
	/**
	    * �˻�
	    * */
		List<ProductDTO> select();
		
		/**
		 * ���
		 * */
		int insert(ProductDTO productDTO)throws MyErrorException;
		
		/**
		 * ����
		 * */
		 int delete(String code)throws MyErrorException;
		 
		 /**
		  * ��
		  * */
		 ProductDTO detail(String code) throws MyErrorException;
}
