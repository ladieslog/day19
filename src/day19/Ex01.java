package day19;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Ex01_DBClass db= new Ex01_DBClass();
		
		Scanner input =new Scanner(System.in);
		int num;
		while(true) {
			System.out.print("1.등록 2.전체보기 3.삭제 4.수정 : ");
			num=input.nextInt();
			switch(num) {
			case 1:	
				System.out.print("학번 입력");
				String  stNum =input.next();
				System.out.print("이름 입력");
				String  name =input.next();
				System.out.print("나이 입력");
				int age =input.nextInt();
				
				//int result = db.saveData(stNum,name,age);
				int result = db.saveData02(stNum,name,age);
				
				if(result ==1) {
					System.out.println("성공적인 저장");
				} else {
					System.out.println("동일한 아이디가 존재합니다.");
				}
				break;
			case 2:
				ArrayList<Ex01_Dto> list =db.getUsers();
					if(list.size()==0) {
						System.out.println("저장되 데이터가 없습니다.");
					}else {
						for(int i=0;i<list.size();i++) {
							System.out.println("학번 : "+list.get(i).getStNum());	
							System.out.println("이름 : "+list.get(i).getName());					
							System.out.println("나이 : "+list.get(i).getAge());
							System.out.println("===============");
						}
					}break;
			case 3: 
				System.out.print("삭제 학번 입력 : ");
				String userNum = input.next();
				int re =db.delete(userNum);
				if(re==1) {
					System.out.println("삭제 되었습니다.");
				}else {
					System.out.println("그런 아이디는 없습니다. ");
				}
				break;
			case 4: 
				System.out.print("수정 아이디 입력해주세요 : ");
				String stNum1=input.next();
				System.out.println("수정할 이름 입력 : ");
				String name1=input.next();
				System.out.println("수정할 나이 입력 : ");
				int age1=input.nextInt();
				if(db.modify(stNum1,name1,age1)==1) {
					System.out.println("수정 완료 되었습니다. ");
				}else {
					System.out.println("수정할수 없습니다. ");
				}
				
				break;
			}
		}
	}
	
}







