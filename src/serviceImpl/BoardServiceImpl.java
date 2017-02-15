package serviceImpl;

import java.util.*;

import daoImpl.BoardDAOImpl;
import domain.ArticleBean;
import service.BoardService;

public class BoardServiceImpl implements BoardService{
	private List<ArticleBean> list;
	private int seq;
	public BoardServiceImpl() {
		list=new ArrayList<ArticleBean>();
		seq=1;
	}
	public static BoardServiceImpl getInstance() {return new BoardServiceImpl();}
	
	@Override
	public int addArticle(ArticleBean param) throws Exception {
		return BoardDAOImpl.getInstance().insertArticle(param);
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
		return BoardDAOImpl.getInstance().selectBySeq(param);
	}
	@Override
	public List<ArticleBean> findSome(ArticleBean param) throws Exception {
		List<ArticleBean> someList=new ArrayList<ArticleBean>();
		for(ArticleBean i:list){
			if(param.getId().equals(i.getId())){
				someList.add(i);
				i.setReadCount(String.valueOf((Integer.parseInt((i.getReadCount()))+1)));
			}
		}
		return someList;
	}

	@Override
	public List<ArticleBean> boardList() throws Exception {
		return BoardDAOImpl.getInstance().selectAll();
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
		int rs=0;
		Iterator<ArticleBean> it=list.iterator();
		while(it.hasNext()){
			if(it.next().getSeq().equals(param.getSeq())){
				it.remove();
				//changeSeq(Integer.parseInt(it.next().getSeq()));
				break;
			}
		}
		changeSeq(Integer.parseInt(param.getSeq()));
		return rs;
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
