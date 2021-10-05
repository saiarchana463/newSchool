package school;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Student class inherits SignupDeatils and storeStudent() will store details into detailsList ArrayList
 */
class Student extends SignupDetails{
	
	private String studentId;
	public Student(String studentIdNo,String role,String firstName, String lastName, String middleName,String gender,String dob,String email,String address,String phoneNo){
 	studentId = studentIdNo;
	}
	
	/**
	 * storeStudent will store the details received from signupDetails class into detailsList.
	 * @param studentObj
	 * @param detailsList
	 * @throws IOException
	 * @throws InterruptedException 
	 * @throws ParseException 
	 * @throws RuntimeException 
	 */
	public void storeStudent(Student studentObj,ArrayList<Object> detailsList) throws IOException, RuntimeException, ParseException, InterruptedException {
		
//			streams
//		List<ArrayList<String>> emailFoundList = detailsList.stream().filter(c -> c.stream().anyMatch(a->a.equals(email))).collect(Collectors.toList());
//		if(emailFoundList.size()!=0) {
//			toRole  = emailFoundList.get(0).get(1);
//			foundEmail = true;
//		}
		
//		List<ArrayList<String>> phoneNoFoundList = detailsList.stream().filter(c -> c.stream().anyMatch(a->a.equals(phoneNo))).collect(Collectors.toList());
//		if(phoneNoFoundList.size()!=0) {
//			toRole  = phoneNoFoundList.get(1).get(0);
//			foundPhoneNo = true;
//		}
	
		super.storeDetails(detailsList);
		detailsList.add(studentObj);
	}
	/**
	 * Returns StudentId.
	 * @return
	 */
	public String getStudentId() {
		return studentId;
	}

//	@Override
//	void subjectDetail() {}
}