package service;

import domain.ArticleBean;
import java.util.*;

public interface BoardService {
	//Create
	public int addArticle(ArticleBean param) throws Exception;
	//Read
	public ArticleBean findRecentArticle(ArticleBean param)  throws Exception;//1개만을 검색하는 일이 없더라도 꼭 만들어야한다.
	public ArticleBean findBySeq(ArticleBean param)  throws Exception;//1개만을 검색하는 일이 없더라도 꼭 만들어야한다.
	public List<ArticleBean> findSome(String[] param)  throws Exception;
	public List<ArticleBean> boardList()  throws Exception;
	//Update
	public int changeContent(ArticleBean param)  throws Exception;
	//Delete
	public int removeContent(ArticleBean param)  throws Exception;
	//util
	public int changeSeq(int seq)  throws Exception;
}
