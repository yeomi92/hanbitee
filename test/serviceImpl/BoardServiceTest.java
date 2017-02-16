package serviceImpl;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import domain.ArticleBean;

public class BoardServiceTest {
	BoardServiceImpl service=BoardServiceImpl.getInstance();
	@Test @Ignore
	public void testAddArticle() {
	}

	@Test @Ignore
	public void testFindBySeq() {
		ArticleBean bean=new ArticleBean();
		bean.setSeq("1");
		try {
			assertTrue(service.findBySeq(bean).getId().equals("lee"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test @Ignore
	public void testFindSome() {
		fail("Not yet implemented");
	}

	@Test @Ignore
	public void testBoardList() {
		fail("Not yet implemented");
	}

}
