package school;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * SchoolApp is Main class that passes control to different classes based on user input
 */

public class SchoolApp {
	
	enum Role{
		STUDENT,TEACHER,HEADMASTER;
	}
	
	/**
	 *  Based on user choice control is passed to different classes of this application.
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InValidPositionException
	 * @throws RuntimeException
	 * @throws ParseException
	 * @throws InterruptedException
	 */
	
	public static void main(String[] args) throws IOException,InValidPositionException, RuntimeException, ParseException, InterruptedException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Object> detailsList = new ArrayList<>();
		String choice ;
		String next = "yes";
		int studentId = 1; 
		int headMasterId = 1;
		int teacherId = 1;
		while(next.equals("yes")) {
			System.out.println("1.SingUp     2.Details");
			System.out.println("please select an option : ");
			choice = br.readLine();
			boolean isValidChoice= !choice.equals("1") && !choice.equals("2");
			while(isValidChoice) {
				try{
					if(isValidChoice)
						throw new InValidPositionException("Invalid Option");
					}
					catch(InValidPositionException e) {
						System.err.println(e.getMessage());
						Thread.sleep(100);
					}
				System.out.println("Enter correct option : ");
				choice = br.readLine();
				isValidChoice = !choice.equals("1") && !choice.equals("2");
			}
		if(choice.equals("1")) {
//			SchoolFactory schoolFactory = new SchoolFactory();
			System.out.println("1.Student 2.Teacher 3.HeadMaster");
			System.out.println("select your position : ");
			String position  = br.readLine();
			boolean isValidPosition = !position.equals("1") && !position.equals("2") && !position.equals("3");
			while(isValidPosition) {
				try {
					if(isValidPosition)
					throw new InValidPositionException("Invalid Option");
				}
				catch(InValidPositionException e) {
					System.err.println(e.getMessage());
					Thread.sleep(100);
				}
				System.out.println("Enter correct option : ");
				position = br.readLine();
				isValidPosition = !position.equals("1") && !position.equals("2") && !position.equals("3");
			}
			SignupDetails signupDetailsObj = new SignupDetails();
			//factory 
			if(position.equals("1")) {
				String studentIdNo = String.valueOf(studentId);
				Student studentObj = new Student(studentIdNo,String.valueOf(Role.STUDENT),signupDetailsObj.getFirstName(),signupDetailsObj.getLastName(),signupDetailsObj.getMiddleName(),signupDetailsObj.getGender(),signupDetailsObj.getDob(),signupDetailsObj.getEmail(),signupDetailsObj.getAddress(),signupDetailsObj.getPhoneNo());
				studentObj.storeStudent(studentObj,detailsList);
				 studentId++;
			}
			else if(position.equals("2")) {
				String teacherIdNo = String.valueOf(teacherId);
				Teacher teacherObj = new Teacher(teacherIdNo,String.valueOf(Role.TEACHER),signupDetailsObj.getFirstName(),signupDetailsObj.getLastName(),signupDetailsObj.getMiddleName(),signupDetailsObj.getGender(),signupDetailsObj.getDob(),signupDetailsObj.getEmail(),signupDetailsObj.getAddress(),signupDetailsObj.getPhoneNo());
				teacherObj.storeTeacher(teacherObj,detailsList);
				teacherId++;
			}
			else if(position.equals("3")) {
				String headMasterIdNo = String.valueOf(headMasterId);
				HeadMaster headMasterObj = new HeadMaster(headMasterIdNo,String.valueOf(Role.HEADMASTER),signupDetailsObj.getFirstName(),signupDetailsObj.getLastName(),signupDetailsObj.getMiddleName(),signupDetailsObj.getGender(),signupDetailsObj.getDob(),signupDetailsObj.getEmail(),signupDetailsObj.getAddress(),signupDetailsObj.getPhoneNo());
				headMasterObj.storeHeadMaster(headMasterObj,detailsList);
				headMasterId++;
			}
//			SignupDetails detail = schoolFactory.getFactory(position);
		}
		else if(choice.equals("2")) {
			System.out.println("\nDetails");
			ViewDetails viewDetailsObj = new ViewDetails();
			System.out.println("Enter text to be searched : ");
			String searchElement = br.readLine();
			viewDetailsObj.display(searchElement,detailsList);
		}
		System.out.println("Contine or terminate :(yes/no) ");
		next = br.readLine();
		}
		System.out.println("Thank you...");
	}

}