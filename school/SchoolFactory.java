package school;

import school.SchoolApp.Role;

public class SchoolFactory {
	private int  studentId = 1,headMasterId = 1,teacherId = 1;
	private String studentIdNo,teacherIdNo,headMasterIdNo;
	public SignupDetails getFactory(String factoryType){
	      if(factoryType == null){
	         return null;
	      }		
	      if(factoryType.equalsIgnoreCase("1")){
	    	  studentIdNo = String.valueOf(studentId) ;
	         return new Student(studentIdNo,String.valueOf(Role.STUDENT),signupDetailsObj.getFirstName(),signupDetailsObj.getLastName(),signupDetailsObj.getMiddleName(),signupDetailsObj.getGender(),signupDetailsObj.getDob(),signupDetailsObj.getEmail(),signupDetailsObj.getAddress(),signupDetailsObj.getPhoneNo());
	         
	      } else if(factoryType.equalsIgnoreCase("2")){
	         return new Teacher();
	         
	      } else if(factoryType.equalsIgnoreCase("3")){
	         return new HeadMaster();
	      }
	      
	      return null;
	   }

}