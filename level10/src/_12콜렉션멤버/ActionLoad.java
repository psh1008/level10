package _12콜렉션멤버;



public class ActionLoad implements Action{

	@Override
	public void excute() {
		MemberDAO.getInstance().clearData();
		String data = Utils.getInstance().loadMemberList();
		String temp[] = data.split("\n");
		for(int i=0;i<temp.length;i++) {
			String info[] = temp[i].split("/");
			MemberDAO.getInstance().loadMemberData(info[0], info[1], info[2]);
		}
	}

}
