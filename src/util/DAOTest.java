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
					String[] memberInfoArr=test.input("아이디, 이름, 주민등록번호, 비밀번호, 프로필사진, 휴대폰번호, 이메일").split(" ");
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
					member=dao.selectById(test.input("검색할 아이디를 입력하세요."));
					test.showMsg((member==null)?"회원이 존재하지 않습니다.":member.toString());
					break;
				/*case LIST:
					test.showMsg((service.count()==0)?"회원이 존재하지 않습니다.":service.memberList().toString());
					break;*/
				case UPDATE:
					member=new MemberBean();
					member.setId(test.input("변경할 아이디를 입력하세요."));
					member.setName(test.input("변경할 이름을 입력하세요."));
					member.setPhone(test.input("변경할 휴대폰 번호를 입력하세요."));
					member.setEmail(test.input("변경할 email를 입력하세요."));
					member.setProfileImg(test.input("변경할 progileImg를 입력하세요."));
					dao.update(member);
					break;
				case DELETE:
					member=new MemberBean();
					member.setId((test.input("삭제 할 아이디를 입력하세요.")));
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
