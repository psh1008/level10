package _15함수형프로그래밍;

import java.util.Objects;

public class Item {

	private int itemNo;
	private String category;
	private String name;
	private int price;
	
	Item(int itemNo, String categroy, String name, int price) {
		super();
		this.itemNo = itemNo;
		this.category = categroy;
		this.name = name;
		this.price = price;
	}

	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getCategroy() {
		return category;
	}
	public void setCategroy(String categroy) {
		this.category = categroy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return String.format("%s %s %s %d원 \n", itemNo,category,name,price);
	}
	public boolean equals(Object o) {
        if (this == o) return true; // 동일 객체인지 확인
        if (o == null || getClass() != o.getClass()) return false; // 클래스가 다른 경우 false
        Item item = (Item) o;
        return itemNo == item.itemNo; // itemNo가 같으면 동일 객체로 판단
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemNo); // itemNo를 기준으로 해시값 생성
    }
	
}
