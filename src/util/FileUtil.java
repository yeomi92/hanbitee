package util;

import java.util.Scanner;
import java.io.*;

public class FileUtil {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		File file=new File("C:\\Users\\hb2008\\eclipse\\jee-neon\\eclipse\\yeomhyeseon.txt");
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(file,true));//true�� ��� ���� �Ϳ� �̾ ����.
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String msg="";
			while(true){
				System.out.println("�޴� 0.���� 1.�ۼ� 2.����");
				switch (s.next()) {
				case "0":
					writer.close();
					return;
				case "1":
					System.out.println("�޼����� �Է��ϼ���.");
					writer.write(s.next());
					writer.newLine();
					writer.flush();//�ݵ�� ���������.
					break;
				case "2":
					System.out.println("�޽��� ����");
					while ((msg=reader.readLine())!=null) {
						System.out.println(msg);
					}
					reader.close();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
