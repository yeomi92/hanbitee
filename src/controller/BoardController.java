package controller;

import service.BoardService;
import serviceImpl.BoardServiceImpl;

import java.awt.HeadlessException;
import java.util.*;

import javax.swing.JOptionPane;

import domain.ArticleBean;
import enums.BoardButt;
import enums.Butt;

public class BoardController {
	public void start() {
		BoardService service = new BoardServiceImpl();
		List<ArticleBean> list=new ArrayList<ArticleBean>();
		ArticleBean param=null;
		BoardButt[] buttons ={BoardButt.EXIT,BoardButt.ADD,BoardButt.FIND_RECENT_ARTICLE,BoardButt.FIND_BY_SEQ,BoardButt.FIND_BY_ID,BoardButt.LIST,BoardButt.CHANGE,BoardButt.REMOVE};
		while(true){
			BoardButt select=(BoardButt)JOptionPane.showInputDialog(
					null, //frame
					"BOARD", //frame title
					"SELECT MENU", //order
					JOptionPane.QUESTION_MESSAGE, //type
					null, //icon
					buttons, //Array of choices
					buttons[1] //default
					);
			switch(select){
			case EXIT:return;
			case ADD:
				param=new ArticleBean();
				String[] articleArr=JOptionPane.showInputDialog("아이디, 타이틀, 내용을 입력하세요.").split(" ");
				param.setId(articleArr[0]);
				param.setTitle(articleArr[1]);
				param.setContent(articleArr[2]);
				param.setReadCount("0");
				try {
					if(service.addArticle(param)==1){
						System.out.println("추가 됬습니다.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case FIND_RECENT_ARTICLE:
				try {
					JOptionPane.showMessageDialog(null, service.findRecentArticle(param).toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case FIND_BY_SEQ:
				param=new ArticleBean();
				param.setSeq(JOptionPane.showInputDialog("찾고싶은 article의 시퀀스를 입력하세요."));
				try {
					param=service.findBySeq(param);
					JOptionPane.showMessageDialog(null, (param==null)?"해당 article가 없습니다.":param);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case FIND_BY_ID:
				String[] arr=JOptionPane.showInputDialog("id yeom").split(" ");
				try {
					JOptionPane.showMessageDialog(null, service.findSome(arr));
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case LIST:
				try {
					list=service.boardList();
				} catch (Exception e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, (list.size()==0)?"article목록이 없습니다.":list);
				break;
			case CHANGE:
				param=new ArticleBean();
				param.setSeq(JOptionPane.showInputDialog("Title을 변경하고싶은 article의 시퀀스를 입력하세요."));
				param.setTitle(JOptionPane.showInputDialog("변경할 제목을 입력하세요."));
				param.setContent(JOptionPane.showInputDialog("변경할 내용을 입력하세요."));
				try {
					service.changeContent(param);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case REMOVE:
				param=new ArticleBean();
				param.setSeq(JOptionPane.showInputDialog("삭제하고싶은 article의 시퀀스를 입력하세요."));
				try {
					service.removeContent(param);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}
}
