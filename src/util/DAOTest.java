package util;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.MemberDAO;
import daoImpl.MemberDAOImpl;
import domain.MemberBean;
import enums.Butt;

public class DAOTest {
	public static void main(String[] args) {
		DAOTest test=new DAOTest();
		MemberDAO dao=MemberDAOImpl.getInstance();
		MemberBean member=null;
		Butt[] buttons ={Butt.CLOSE,Butt.LOGIN,Butt.MEMBER_ADD,Butt.FIND_BY_ID,Butt.UPDATE,Butt.DELETE};
		while(true){
			Butt select=(Butt)JOptionPane.showInputDialog(
					null, //frame
					"MEMBER PAGE", //frame title
					"SELECT MENU", //order
					JOptionPane.QUESTION_MESSAGE, //type
					null, //icon
					buttons, //Array of choices
					buttons[1] //default
					);
			switch(select){
				case CLOSE:return;
				case LOGIN:
					member=new MemberBean();
					String[] loginArr=test.input("���̵�, ��й�ȣ").split(" ");
					member.setId(loginArr[0]);
					member.setPassword(loginArr[1]);
				try {
					test.showMsg(dao.login(member)?member.getId()+"�� ȯ���մϴ�.":"�α��� ����");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case MEMBER_ADD:
					member = new MemberBean();
					String[] memberInfoArr=test.input("���̵�, �̸�, �ֹε�Ϲ�ȣ, ��й�ȣ, �����ʻ���, �޴�����ȣ, �̸���").split(" ");
					member.setId((memberInfoArr[0]));
					member.setName((memberInfoArr[1]));
					member.setSsn((memberInfoArr[2]));
					member.setPassword((memberInfoArr[3]));
					member.setProfileImg((memberInfoArr[4]));
					member.setPhone((memberInfoArr[5]));
					member.setEmail((memberInfoArr[6]));
				try {
					dao.insert(member);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case FIND_BY_ID:
					member = new MemberBean();
				try {
					member=dao.selectById(test.input("�˻��� ���̵� �Է��ϼ���."));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					test.showMsg((member.getId()==null)?"ȸ���� �������� �ʽ��ϴ�.":member.toString());
					break;
				case UPDATE:
					member=new MemberBean();
					member.setName(test.input("������ �̸��� �Է��ϼ���."));
					member.setPassword(test.input("������ ��й�ȣ�� �Է��ϼ���."));
					member.setPhone(test.input("������ �޴��� ��ȣ�� �Է��ϼ���."));
					member.setEmail(test.input("������ email�� �Է��ϼ���."));
					member.setProfileImg(test.input("������ progileImg�� �Է��ϼ���."));
				try {
					dao.update(member);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case DELETE:
					member=new MemberBean();
					member.setId((test.input("���� �� ���̵� �Է��ϼ���.")));
				try {
					dao.delete(member);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
			}
		}
	}
	public String input(String str){
		return JOptionPane.showInputDialog(str);
	}
	public void showMsg(String str){
		JOptionPane.showMessageDialog(null, str);
	}
}
