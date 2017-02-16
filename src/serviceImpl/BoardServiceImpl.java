package serviceImpl;

import java.util.*;

import dao.BoardDAO;
import daoImpl.BoardDAOImpl;
import domain.ArticleBean;
import service.BoardService;

public class BoardServiceImpl implements BoardService{
	public static BoardServiceImpl getInstance() {
		return new BoardServiceImpl();
	}
	private BoardDAO dao;
	private List<ArticleBean> list;
	private int seq;
	public BoardServiceImpl() {
		list=new ArrayList<ArticleBean>();
		seq=1;
		dao=BoardDAOImpl.getInstance();
	}
	
	@Override
	public int addArticle(ArticleBean param) throws Exception {
		return dao.insertArticle(param);
	}
	@Override
	public ArticleBean findRecentArticle(ArticleBean param) throws Exception {
		ArticleBean article=new ArticleBean();
		for(int i=0;i<list.size();i++){
			if(i==(list.size()-1)){
				article=list.get(i);
				list.get(i).setReadCount(String.valueOf((Integer.parseInt((list.get(i).getReadCount()))+1)));
			}
		}
		return article;
	}
	@Override
	public ArticleBean findBySeq(ArticleBean param) throws Exception {
		return dao.selectBySeq(param);
	}
	@Override
	public List<ArticleBean> findSome(String[] param) throws Exception {
		return dao.selectByWord(param);
	}

	@Override
	public List<ArticleBean> boardList() throws Exception {
		return dao.selectAll();
	}

	@Override
	public int changeContent(ArticleBean param) throws Exception {
		int rs=0;
		for(ArticleBean i : list){
			if(param.getSeq().equals(i.getSeq())){
				i.setTitle((param.getTitle().equals(""))?i.getTitle():param.getTitle());
				i.setContent((param.getContent().equals(""))?i.getContent():param.getContent());
			}
		}
		return rs;
	}

	@Override
	public int removeContent(ArticleBean param) throws Exception {
		return dao.delete(param);
	}

	@Override
	public int changeSeq(int seq) throws Exception {
		int rs=0;
		for(int i=seq;i<list.size()+1;i++){
			list.get(i-1).setSeq(String.valueOf(seq));
			seq++;
		}
		this.seq=seq;
		return rs;
	}
}
