package kosta.mvc.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor // 반드시 생성자가 있어야된다 -> 모든 필드를 기준으로 생성자를 만든다.
public class ProductDTO {
   private String code;
   private String name;
   private int price;
   private String detail;
   
   
}
