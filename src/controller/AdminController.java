package controller;

import javax.swing.*;
import domain.MemberBean;
import enums.Butt;
import service.AdminService;
import serviceImpl.AdminServiceImpl;

public class AdminController {
	public void start(){
		MemberBean member=null;
		AdminService service = new AdminServiceImpl();//����� �� ������ �����Ƿ� ������ ����
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
					String[] memberInfoArr=input("���̵�, ��й�ȣ, �̸�, �ֹε�Ϲ�ȣ, �̸���, �����ʻ���, �޴�����ȣ").split(" ");
					member.setId((memberInfoArr[0]));
					member.setPassword((memberInfoArr[1]));
					member.setName((memberInfoArr[2]));
					member.setSsn((memberInfoArr[3]));
					member.setEmail((memberInfoArr[4]));
					member.setProfileImg((memberInfoArr[5]));
					member.setPhone((memberInfoArr[6]));
					member.setRank("C");
					service.regist(member);
					break;
				case FIND_BY_ID:
					member = new MemberBean();
					member=service.findById(input("�˻��� ���̵� �Է��ϼ���."));
					showMsg((member==null)?"ȸ���� �������� �ʽ��ϴ�.":member.toString());
					break;
				case FIND_BY_NAME:
					String nameResult=input("�˻��� �̸��� �Է��ϼ���.");
					showMsg((service.count()==0)?"ȸ���� �������� �ʽ��ϴ�.":service.findByName(nameResult).toString());
					break;
				case MAP_FIND_BY_NAME:
					String mapNameResult=input("�˻��� �̸��� �Է��ϼ���.");
					showMsg((service.count()==0)?"ȸ���� �������� �ʽ��ϴ�.":service.mapFindByName(mapNameResult).toString());
					break;
				case LIST:
					showMsg((service.count()==0)?"ȸ���� �������� �ʽ��ϴ�.":service.memberList().toString());
					break;
				case UPDATE:
					member=new MemberBean();
					member.setId(input("������ ���̵� �Է��ϼ���."));
					member.setName(input("������ �̸��� �Է��ϼ���."));
					member.setPhone(input("������ �޴��� ��ȣ�� �Է��ϼ���."));
					member.setEmail(input("������ email�� �Է��ϼ���."));
					service.update(member);
					break;
				case DELETE:
					service.remove(input("���� �� ���̵� �Է��ϼ���."));
					break;
				case KEY_LIST:
					showMsg(service.keyList().toString());
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
