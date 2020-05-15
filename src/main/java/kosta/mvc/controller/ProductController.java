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
@RequiredArgsConstructor // 생성자를 이용해서 final을 초기화(주입)
public class ProductController {
	
//	@Autowired
//   private ProductService service;
	
	private final ProductService service; // @RequiredArgsConstructor을 사용해서 @Autowired 사용 엑스
	
	/**
	 * 전체 검색
	 * */
	@RequestMapping("/start.kosta")
	public ModelAndView list() {
		List<ProductDTO> list = service.select();
		return new ModelAndView("productList", "list" , list); // ${requestScope.list}
	}
	
	/**
	 * 등록 폼
	 * */
	@RequestMapping("/{url}.kosta")
	public void url() {}
	
	/**
	 * 등록하기
	 * */
	@RequestMapping("/insert.kosta")
	public String insert(ProductDTO dto) {
		
		service.insert(dto);
		
		return "redirect:start.kosta";
		// return "start.kosta"; 로 한다면, 값 입력 후 등록 버튼을 누르면 그냥 start.kosta.jsp 페이지를 호출하는데,
		// 우리는 view로 가고싶은 것이 아니고 Controller로 가고싶다. 컨트롤러에서 컨트롤러를 콜할 때,
		// redirect:"" forward:""를 사용한다.
	}
	
	/**
	 * 삭제하기
	 * */
	@RequestMapping("/{code}") // /del/{code}는 틀림
	public String delete(@PathVariable String code) {
	    service.delete(code);
		return "redirect:start.kosta";
	}
	
	/**
	 * 상세보기
	 * */
	@RequestMapping("/read.kosta")
	public void detail(Model model, String code) {
		ProductDTO productDTO = service.detail(code);
		model.addAttribute("product", productDTO);
	}
	
	/**
	 * 예외처리
	 * */
	@ExceptionHandler(MyErrorException.class)
	public ModelAndView error(MyErrorException e) {
		return new ModelAndView("error/error" , "errMessage" , e.getMessage() );
	}
}





