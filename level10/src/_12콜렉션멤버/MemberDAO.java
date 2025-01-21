package _12콜렉션멤버;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class MemberDAO {
	
	private static MemberDAO dao;
	
	public static MemberDAO getInstance() {
		if(dao == null)dao = new MemberDAO();
		return dao;
	}
	
	private ArrayList<Member> memberList;
	
	public void clearData() {
		memberList.clear();
	}
	
	public void loadMemberData(String id,String pw, String name) {
		memberList.add(new Member(id,pw,name));
	}
	
	public void updateUser(int idx) {
		String name = Utils.getInstance().getStringValue("수정할 이름 입력>>");
		memberList.get(idx).setName(name);
	}
	
	public boolean checkPw(String pw , int idx) {
		if(memberList.get(idx).getPw().equals(pw)) {
			return true;
		}
		return false;
	}
	
	public boolean sizeCheck() {
		if(memberList.size() == 0) {
			return false;
		}
		return true;
	}
	
	public String getMemberList() {
		
		ArrayList<Member> tempList = (ArrayList<Member>) memberList.clone();
		Collections.sort(tempList,new MemberComp(MemberComp.SortBy.ID,MemberComp.SortDir.ASC));
		String data = "";
		for(int i=0;i<tempList.size();i++) {
			data += tempList.get(i).getId()+"/";
			data += tempList.get(i).getPw()+"/";
			data += tempList.get(i).getName()+"\n";
		}
		return data;
//		TreeSet[] treeSets = {
//				new TreeSet<>(new MemberComp(MemberComp.SortBy.ID,MemberComp.SortDir.ASC))	
//			};
//			
//			for(Member m : memberList) {
//				for(TreeSet ts : treeSets) {
//					ts.add(m);
//				}
//			}
//			String data = "";
//			for(TreeSet ts : treeSets) {
//				for(Object m : treeSets) {
//					data += m;
//				}
//			}
//			data = data.substring(0,data.length()-1);
//			return data;
	};
	
	public void printAll() {
		TreeSet[] treeSets = {
			new TreeSet<>(new MemberComp(MemberComp.SortBy.NAME,MemberComp.SortDir.ASC))	
		};
		
		for(Member m : memberList) {
			for(TreeSet ts : treeSets) {
				ts.add(m);
			}
		}
		for(TreeSet ts : treeSets) {
			for(Object m : treeSets) {
				System.out.println(m);
			}
			System.out.println("-------------");
		}
		
	}
	
	public void delUserId(int idx) {
		memberList.remove(idx);
	}
	
	public int CheckIdDup(String id) {
		int idx = -1;
		for(int i=0;i<memberList.size();i++) {
			if(memberList.get(i).getId().equals(id)) {
				idx = i;
				return idx;
			}
		}
		return idx;
	}
	
	public void addMember(String id,String pw,String name) {
		memberList.add(new Member(id,pw,name));
	}
	
	public void init() {
		memberList = new ArrayList<Member>();
	}
	
}
