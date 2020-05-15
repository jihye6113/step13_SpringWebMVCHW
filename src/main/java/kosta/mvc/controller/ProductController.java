package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;
import kosta.mvc.model.service.ProductService;
import lombok.RequiredArgsConstructor;

@Controller 
@RequiredArgsConstructor // �����ڸ� �̿��ؼ� final�� �ʱ�ȭ(����)
public class ProductController {
	
//	@Autowired
//   private ProductService service;
	
	private final ProductService service; // @RequiredArgsConstructor�� ����ؼ� @Autowired ��� ����
	
	/**
	 * ��ü �˻�
	 * */
	@RequestMapping("/start.kosta")
	public ModelAndView list() {
		List<ProductDTO> list = service.select();
		return new ModelAndView("productList", "list" , list); // ${requestScope.list}
	}
	
	/**
	 * ��� ��
	 * */
	@RequestMapping("/{url}.kosta")
	public void url() {}
	
	/**
	 * ����ϱ�
	 * */
	@RequestMapping("/insert.kosta")
	public String insert(ProductDTO dto) {
		
		service.insert(dto);
		
		return "redirect:start.kosta";
		// return "start.kosta"; �� �Ѵٸ�, �� �Է� �� ��� ��ư�� ������ �׳� start.kosta.jsp �������� ȣ���ϴµ�,
		// �츮�� view�� ������� ���� �ƴϰ� Controller�� ����ʹ�. ��Ʈ�ѷ����� ��Ʈ�ѷ��� ���� ��,
		// redirect:"" forward:""�� ����Ѵ�.
	}
	
	/**
	 * �����ϱ�
	 * */
	@RequestMapping("/{code}") // /del/{code}�� Ʋ��
	public String delete(@PathVariable String code) {
	    service.delete(code);
		return "redirect:start.kosta";
	}
	
	/**
	 * �󼼺���
	 * */
	@RequestMapping("/read.kosta")
	public void detail(Model model, String code) {
		ProductDTO productDTO = service.detail(code);
		model.addAttribute("product", productDTO);
	}
	
	/**
	 * ����ó��
	 * */
	@ExceptionHandler(MyErrorException.class)
	public ModelAndView error(MyErrorException e) {
		return new ModelAndView("error/error" , "errMessage" , e.getMessage() );
	}
}





