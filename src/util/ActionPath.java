package util;

public class ActionPath {
	public static String[] getAction(String path){
		String[] action=new String[4];
		action[0]="/WEB-INF/jsp/"+path.split("\\.")[0].split("/")[1]+"/";
		action[1]=path.split("/")[2].split("\\.")[0];
		action[2]=".jsp";
		action[3]=action[0]+action[1]+action[2];
		return action;
	}
}
