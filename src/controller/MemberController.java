package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import domain.MemberBean;
import enums.Butt;
import serviceImpl.MemberServiceImpl;

public class MemberController {
	public static void main(String[] args) {
		MemberController test=new MemberController();
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
						if(MemberServiceImpl.getInstance().findById(member.getId())==null){
							test.showMsg("id�� �������� �ʽ��ϴ�.");
						}else{
							test.showMsg(MemberServiceImpl.getInstance().login(member)?member.getId()+"�� ȯ���մϴ�.":"password����ġ,�α��� ����");
						}
						
					} catch (SQLException e) {
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
						MemberServiceImpl.getInstance().join(member);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case UPDATE:
					member=new MemberBean();
					member.setName(test.input("������ �̸��� �Է��ϼ���."));
					member.setPassword(test.input("������ ��й�ȣ�� �Է��ϼ���."));
					member.setPhone(test.input("������ �޴��� ��ȣ�� �Է��ϼ���."));
					member.setEmail(test.input("������ email�� �Է��ϼ���."));
					member.setProfileImg(test.input("������ progileImg�� �Է��ϼ���."));
					try {
						MemberServiceImpl.getInstance().change(member);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case DELETE:
					member=new MemberBean();
					try {
						MemberServiceImpl.getInstance().remove(member);
					} catch (SQLException e) {
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
