package controller;

import service.BoardService;
import serviceImpl.BoardServiceImpl;
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
				String[] articleArr=JOptionPane.showInputDialog("���̵�, Ÿ��Ʋ, ������ �Է��ϼ���.").split(" ");
				param.setId(articleArr[0]);
				param.setTitle(articleArr[1]);
				param.setContent(articleArr[2]);
				param.setReadCount("0");
				service.addArticle(param);
				break;
			case FIND_RECENT_ARTICLE:
				JOptionPane.showMessageDialog(null, service.findRecentArticle(param).toString());
				break;
			case FIND_BY_SEQ:
				param=new ArticleBean();
				param.setSeq(JOptionPane.showInputDialog("ã����� article�� �������� �Է��ϼ���."));
				JOptionPane.showMessageDialog(null, service.findBySeq(param).toString());
				break;
			case FIND_BY_ID:
				param=new ArticleBean();
				param.setId(JOptionPane.showInputDialog("ã����� article�� �ۼ��� ����� ID�� �Է��ϼ���."));
				JOptionPane.showMessageDialog(null, service.findSome(param));
				break;
			case LIST:
				list=service.boardList();
				JOptionPane.showMessageDialog(null, (list.size()==0)?"article����� �����ϴ�.":list);
				break;
			case CHANGE:
				param=new ArticleBean();
				param.setSeq(JOptionPane.showInputDialog("Title�� �����ϰ���� article�� �������� �Է��ϼ���."));
				param.setTitle(JOptionPane.showInputDialog("������ ������ �Է��ϼ���."));
				param.setContent(JOptionPane.showInputDialog("������ ������ �Է��ϼ���."));
				service.changeContent(param);
				break;
			case REMOVE:
				param=new ArticleBean();
				param.setSeq(JOptionPane.showInputDialog("�����ϰ���� article�� �������� �Է��ϼ���."));
				service.removeContent(param);
				break;
			}
		}
	}
}
