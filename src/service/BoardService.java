package service;

import domain.ArticleBean;
import java.util.*;

public interface BoardService {
	//Create
	public void addArticle(ArticleBean param);
	//Read
	public ArticleBean findRecentArticle(ArticleBean param);//1������ �˻��ϴ� ���� ������ �� �������Ѵ�.
	public ArticleBean findBySeq(ArticleBean param);//1������ �˻��ϴ� ���� ������ �� �������Ѵ�.
	public List<ArticleBean> findSome(ArticleBean param);
	public List<ArticleBean> boardList();
	//Update
	public void changeContent(ArticleBean param);
	//Delete
	public void removeContent(ArticleBean param);
	//util
	public void changeSeq(int seq);
}
