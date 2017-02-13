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
					String[] loginArr=test.input("아이디, 비밀번호").split(" ");
					member.setId(loginArr[0]);
					member.setPassword(loginArr[1]);
					try {
						if(MemberServiceImpl.getInstance().findById(member.getId())==null){
							test.showMsg("id가 존재하지 않습니다.");
						}else{
							test.showMsg(MemberServiceImpl.getInstance().login(member)?member.getId()+"님 환영합니다.":"password불일치,로그인 실패");
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
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
					try {
						MemberServiceImpl.getInstance().join(member);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case UPDATE:
					member=new MemberBean();
					member.setName(test.input("변경할 이름을 입력하세요."));
					member.setPassword(test.input("변경할 비밀번호를 입력하세요."));
					member.setPhone(test.input("변경할 휴대폰 번호를 입력하세요."));
					member.setEmail(test.input("변경할 email를 입력하세요."));
					member.setProfileImg(test.input("변경할 progileImg를 입력하세요."));
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
