package kosta.mvc.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor // �ݵ�� �����ڰ� �־�ߵȴ� -> ��� �ʵ带 �������� �����ڸ� �����.
public class ProductDTO {
   private String code;
   private String name;
   private int price;
   private String detail;
   
   
}
