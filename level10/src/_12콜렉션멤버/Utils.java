package _12콜렉션멤버;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Utils {
	private static final String CUR_PATH = System.getProperty("user.dir") + "\\src\\" + Utils.class.getPackageName()+"\\";
	private static final String filePath = CUR_PATH + "member.txt";
	private static File file = new File(filePath);
	Scanner sc = new Scanner(System.in);
	private static Utils utils;
	
	public static Utils getInstance() {
		if(utils == null) utils = new Utils(); 
		return utils;
	}
	
	public String loadMemberList() {
		
		String dataReader = "";
		
		try(FileReader fr = new FileReader(filePath);
				BufferedReader br = new BufferedReader(fr)){
			while(true) {
				String line = br.readLine();
				if(line == null)
					break;
				dataReader += line + "\n";
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		dataReader = dataReader.substring(0, dataReader.length() - 1);
		return dataReader;
	}
	
	public void saveMemberList() {
		String data = MemberDAO.getInstance().getMemberList();
		data = data.substring(0,data.length()-1);
		try(FileWriter fw = new FileWriter(filePath)){
			fw.write(data);
			System.out.println("파일 저장 성공");
		} catch (IOException e) {
			System.out.println("파일 저장 실패");
		}
	}
	
	public String getStringValue(String msg) {
		System.out.println(msg);
		String val = sc.next();
		return val;
	}
	
	public int getIntValue(String msg,int start,int end) {
		
	
		while(true) {
			System.out.println(msg);
			int num = sc.nextInt();
			if(num < start || num > end) {
				System.out.printf("%d - %d 사이 정수 입력 \n",start,end);
				continue;
			}
			return num;
		}
		
	}
}
