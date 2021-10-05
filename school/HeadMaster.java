package school;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * HeadMaster class inherits SignupDeatils and storeHeadMaster will store details into detailsList ArrayList
 */

public class HeadMaster extends SignupDetails {
	
	
	private String subject,headMasterId;
	public HeadMaster( String headMasterIdNo,String role,String firstName, String lastName, String middleName,String gender,String dob,String email,String address,String phoneNo){
    headMasterId = headMasterIdNo;
	}
	
/**
 * This method will take subject input which is optional and store it along with details inherited from singupDetails.	
 * 
 * @param headMasterObj
 * @param detailsList
 * @throws IOException
 * @throws InterruptedException 
 * @throws ParseException 
 * @throws RuntimeException 
 * 
 * 
 */
	public void storeHeadMaster(HeadMaster headMasterObj,ArrayList<Object> detailsList)throws IOException, RuntimeException, ParseException, InterruptedException {
		super.storeDetails(detailsList);
		subjectDetail();
		detailsList.add(headMasterObj);
	}
	public String getSubject() {
		return subject;
	}

	public String getHeadMasterId() {
		return headMasterId;
	}

//	@Override
	public void subjectDetail() throws IOException {
		System.out.println("Subject :");
	    subject = br.readLine();
		boolean isEmptySubject = subject == null || subject.trim().length() == 0;
		if (isEmptySubject) {
		    subject = " ";
		}
	}

}