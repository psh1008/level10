package _12콜렉션멤버;

public class Member{
	private String id;
	private String pw;
	private String name;
	@Override
	public String toString() {
		return String.format("%s/%s/%s\n", id,pw,name);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	Member(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	

	
}
