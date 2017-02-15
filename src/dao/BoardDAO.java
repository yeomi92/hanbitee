package dao;

import java.util.List;

import domain.ArticleBean;

public interface BoardDAO {
	//Create
		public int insertArticle(ArticleBean param) throws Exception;
		//Read
		public ArticleBean selectBySeq(ArticleBean param) throws Exception;//1������ �˻��ϴ� ���� ������ �� �������Ѵ�.
		public List<ArticleBean> selectByWord(ArticleBean param)  throws Exception;
		public List<ArticleBean> selectAll() throws Exception;;
		//Update
		public int update(ArticleBean param) throws Exception;
		//Delete
		public int delete(ArticleBean param) throws Exception;
}