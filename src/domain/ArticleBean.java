package domain;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ArticleBean {
	@Getter@Setter
	private String seq,id,title,content,regdate,readCount;
	
	@Override
	public String toString() {
		return String.format("[ %s | %s | %s | %s | %s | %s ]\n", seq,id,title,content,readCount,regdate);
	}
}
