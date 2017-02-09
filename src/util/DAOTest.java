package util;

import javax.swing.JOptionPane;

import dao.MemberDAO;
import daoImpl.MemberDAOImpl;
import domain.MemberBean;
import enums.Butt;
import service.AdminService;
import serviceImpl.AdminServiceImpl;

public class DAOTest {
	public static void main(String[] args) {
		DAOTest test=new DAOTest();
		MemberDAO dao=new MemberDAOImpl();
		MemberBean member=null;
		int i=0;
		Butt[] buttons ={Butt.CLOSE,Butt.MEMBER_ADD,Butt.FIND_BY_ID,Butt.FIND_BY_NAME,Butt.MAP_FIND_BY_NAME,Butt.LIST,Butt.UPDATE,Butt.DELETE,Butt.KEY_LIST};
		while(true){
			Butt select=(Butt)JOptionPane.showInputDialog(
					null, //frame
					"ADMIN PAGE", //frame title
					"SELECT ADMIN MENU", //order
					JOptionPane.QUESTION_MESSAGE, //type
					null, //icon
					buttons, //Array of choices
					buttons[1] //default
					);
			switch(select){
				case CLOSE:JOptionPane.showConfirmDialog(null, "EXIT Ok??");return;
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
					dao.insert(member);
					break;
				case FIND_BY_ID:
					member = new MemberBean();
					member=dao.selectById(test.input("�˻��� ���̵� �Է��ϼ���."));
					test.showMsg((member==null)?"ȸ���� �������� �ʽ��ϴ�.":member.toString());
					break;
				/*case LIST:
					test.showMsg((service.count()==0)?"ȸ���� �������� �ʽ��ϴ�.":service.memberList().toString());
					break;*/
				case UPDATE:
					member=new MemberBean();
					member.setId(test.input("������ ���̵� �Է��ϼ���."));
					member.setName(test.input("������ �̸��� �Է��ϼ���."));
					member.setPhone(test.input("������ �޴��� ��ȣ�� �Է��ϼ���."));
					member.setEmail(test.input("������ email�� �Է��ϼ���."));
					member.setProfileImg(test.input("������ progileImg�� �Է��ϼ���."));
					dao.update(member);
					break;
				case DELETE:
					member=new MemberBean();
					member.setId((test.input("���� �� ���̵� �Է��ϼ���.")));
					dao.delete(member);
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
