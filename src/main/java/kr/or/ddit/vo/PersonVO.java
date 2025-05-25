package kr.or.ddit.vo;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class PersonVO implements Serializable{
	@NotBlank
	private String id;
	@NotBlank
	private String name;
	@NotBlank
	@Pattern(regexp = "^[FM]$", message = "성별은 'F' 또는 'M'만 가능합니다.")
	private String gender;
	@NotNull
	private Integer age;
	@NotBlank
	private String address;
}
