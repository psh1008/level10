package _09제네릭클래스;

import java.util.Arrays;

class MyArrayList<T>{
	private T[] arr;
	private int capacity = 10;
	private int size = 0;
	@Override
	public String toString() {
		if(size == 0)return "[]";
		return Arrays.toString(arr);
	}
	MyArrayList(){
//		arr = new T[capacity]; // 제네릭클래스로 배열 선언을 할수 없다
		arr = (T[]) new Object[capacity];
	}
	public void print() {
		System.out.println(Arrays.toString(arr));
	}
	
	public void add(int idx, T val) {
		arr[idx] = val;
		size++;
		sizeCheck(size);
	}
	public void add(T val) {
		arr[size++] = val;
		sizeCheck(size);
	}
	public int size() {
		return this.size;
	}
	public int capacity() {
		return this.capacity;
	}
	public void sizeCheck(int size) {
		if(size == 0) {
			capacity = 10;
		}else if(size > capacity) {
			capacity +=10;
		}else if(capacity >= 10 && size + 10 == capacity) {
			capacity -= 10;
		}
	}
	public T get(int idx) {
		return arr[idx];
	}
	public void set(int idx , T val) {
		arr[idx] = val;
	}
	public void remove(int idx) {
		if(idx < 0 || idx >= size) {
			throw new ArrayIndexOutOfBoundsException("배열의 방 길이를 초과했습니다");
		}
		T[] temp = arr;
		sizeCheck(size);
		arr = (T[]) new Object[temp.length];
		int index = 0;
		for(int i=0;i<arr.length;i++) {
			if(i == idx) continue;
			arr[index++] = temp[i];
		}
		size--;
	}
	public void clear() {
		size = 0;
		sizeCheck(size);
		arr = arr = (T[]) new Object[capacity];;
	}
}

public class _02어레이리스트구현 {
	public static void main(String[] args) {
		MyArrayList<Double> v1 = new MyArrayList();
		
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		
		for(int i=0;i<10;i++) {
			v1.add((i+1) * 10*1.0);
		}
		
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		System.out.println(v1.get(1));
		
		v1.set(1,1000.0);
		System.out.println(v1);
		
		v1.add(1,20.0);
		v1.remove(3);
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		
		v1.clear();
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		
	}
}
