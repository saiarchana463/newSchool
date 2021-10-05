package school;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * SignupDetails class takes all user inputs and validates them.
 * @author savant
 */

 class SignupDetails implements IMainSchool  {

	private String firstName, lastName,middleName,gender,dob,email,address,phoneNo;
	 
	protected BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Sets the firstName taken from user to firstName variable;
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Returns First Name
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the lastName taken from user to lastName variable;
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Returns LastName
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the middleName taken from user to middleName variable;
	 * @param middleName
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	/**
	 * Returns Middle Name
	 * @return
	 */
	public String getMiddleName() {
		return middleName;
	}
	
	/**
	 * Sets the gender taken from user to gender variable;
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * Returns Gender
	 * @return
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Sets the Date of Birth taken from user to dob variable;
	 * @param dob
	 */
	public void setdob(String dob) {
		this.dob = dob;
	}
	
	/**
	 * Returns Date Of Birth
	 * @return
	 */
	public String getDob() {
		return dob;
	}
	
	/**
	 * Sets the email taken from user to email variable;
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns Email
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the Address taken from user to address variable;
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Returns Address
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the Phone Number taken from user to phoneNo variable;
	 * @param phoneNo
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Returns Phone Number
	 * @return
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	
	
	/**
	 * checks whether the email entered is duplicate or not.
	 * @param detailsList
	 * @return
	 */
	public boolean isFoundEmail(ArrayList<Object> detailsList) {
		for(int i = 0;i<detailsList.size();i++) {
			if(((SignupDetails) detailsList.get(i)).getEmail().equals(email)) {
				return true;
			}
	}
		return false;
	}
	
	/**
	 * checks whether the Phone Number entered is duplicate or not.
	 * @param detailsList
	 * @return
	 */
	public boolean isFoundPhoneNo(ArrayList<Object> detailsList) {
		for(int i = 0;i<detailsList.size();i++) {
			if(((SignupDetails) detailsList.get(i)).getPhoneNo().equals(phoneNo)) {
				return true;
			}
	}
		return false;
	}
	
	/**
	 * Validates the input and makes sure that this field is not empty
	 * @throws IOException 
	 * 
	 */
	public String validate(String detail) throws IOException {
		boolean isEmpty = detail == null || detail.trim().length() == 0;
		if(!isEmpty)
			return detail;
		String mandatoryDetail="";
		while (isEmpty) {
		    System.out.println("This field is mandatory* : ");
		    mandatoryDetail = br.readLine();
		    isEmpty = mandatoryDetail == null || mandatoryDetail.trim().length() == 0;
		}
		return mandatoryDetail;
	}
	
	/**
	 * Validates Gender and makes sure to set correct gender.
	 * @throws InterruptedException 
	 * @throws IOException 
	 * 
	 */
	public String genderValidation(String gender) throws InterruptedException, IOException {
		String genderInput="";
		boolean isEmptyGender = gender == null || gender.trim().length() == 0;
		boolean wrongGender = !gender.equalsIgnoreCase("f") && !gender.equalsIgnoreCase("M");
		if(!isEmptyGender && !wrongGender)
			return gender;
		while (isEmptyGender || wrongGender) {
		    try {
		    	if (isEmptyGender){
		    		throw new ValidateException("Gender is Mandatory* : ");
					}
		    	else if (wrongGender){
		    		throw new ValidateException("Enter the correct gender : ");
					}
		    }
		    catch(ValidateException e){
		    	System.err.println(e.getMessage());
		    	Thread.sleep(100);
		    }
		    genderInput = br.readLine();
		    wrongGender = !genderInput.equalsIgnoreCase("f") && !genderInput.equalsIgnoreCase("M");
		    isEmptyGender = genderInput == null || genderInput.trim().length() == 0;
		}
		return genderInput;
	}
	
	/**
	 * Validates Date of Birth and makes to set correct Date of Birth
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public String dobValidation(String dob) throws InterruptedException, IOException {
		String dobInput = "";
		boolean isEmptyDob = dob == null || dob.trim().length() == 0;
		boolean wrongDate;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);
		try {
		sdf.parse(dob);
		setdob(dob);
		wrongDate = false;
		} catch (Exception e) {
			wrongDate = true;
		}
		if(!isEmptyDob || !wrongDate)
			return dob;
		while (isEmptyDob || wrongDate) {
			try {
				if(isEmptyDob)
					throw new ValidateException("Date Of Birth is Mandatory* : ");
				else if(wrongDate)
					throw new ValidateException("Enter correct Date : ");
			}
			catch(ValidateException e) {
				System.err.println(e.getMessage());
				Thread.sleep(100);
			}
		    dobInput = br.readLine();
		    isEmptyDob = dobInput == null || dobInput.trim().length() == 0;
		    SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
			sdf1.setLenient(false);
			try {
			sdf1.parse(dobInput);
			setdob(dobInput);
			wrongDate = false;
			} catch (Exception e) {
				wrongDate = true;
			}
		}
		return dobInput;
	}
	
	/**
	 * Validates Email id and makes sure to enter correct email id.
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void emailValidation(ArrayList<Object> detailsList) throws InterruptedException, IOException {
		boolean isEmptyEmail = email == null || email.trim().length() == 0;
		boolean isValidEmail = !(email.contains("@")) && email.trim().length()>0;
		boolean duplicateEmailFound= isFoundEmail(detailsList);
			while(isEmptyEmail || isValidEmail || duplicateEmailFound ) {
				try {
					if (isEmptyEmail) {
						throw new ValidateException("Email is Mandatory* :");
					}
					else if(isValidEmail)
						throw new ValidateException("Enter correct Email : ");
					if(duplicateEmailFound)
						throw new ValidateException("An Account is already present with "+email+"\n Enter unique email : ");
				}
				catch(ValidateException e) {
					System.err.println(e.getMessage());
					Thread.sleep(100);
				}
			    setEmail(br.readLine()) ;
			    isEmptyEmail = email == null || email.trim().length() == 0 ;
			    isValidEmail =  ! (email.contains("@")) && email.trim().length()>0;
			    duplicateEmailFound=isFoundEmail(detailsList);
		}
	}
	
	/**
	 * Validates Phone Number and makes sure to enter correct Phone number
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void phoneNumberValidation( ArrayList<Object> detailsList) throws InterruptedException, IOException {
		boolean isEmptyPhoneNo = phoneNo == null || phoneNo.trim().length() == 0;
		boolean isValidPhoneNo = phoneNo.length()<10 || phoneNo.charAt(0) == '0';
		boolean duplicatePhoneNoFound = isFoundPhoneNo(detailsList);
		while (isEmptyPhoneNo || duplicatePhoneNoFound || isValidPhoneNo) {
			try {
				if(isEmptyPhoneNo)
				throw new ValidateException("Phone Number is Mandatory* :");
				else if(isValidPhoneNo)
					throw new ValidateException("Enter correct Phone Number : ");
				else if(duplicatePhoneNoFound)
					throw new ValidateException("An Account is already present with "+phoneNo+"\n Enter unique phoneNo :");
			}
			catch(ValidateException e) {
				System.err.println(e.getMessage());
				Thread.sleep(100);
			}
		   setPhoneNo(br.readLine()); 
		    isEmptyPhoneNo = phoneNo == null || phoneNo.trim().length() == 0 ;
		    isValidPhoneNo = phoneNo.length()<10 || phoneNo.charAt(0) == '0';
		    duplicatePhoneNoFound = isFoundPhoneNo(detailsList);
		}
	
	}
	
	/**
	 *  This method will take inputs(firstName, lastName, middleName, gender, dob,email, address, phoneNo ) from user and calls set methods.
	 */
	public void storeDetails(ArrayList<Object> detailsList) throws RuntimeException, IOException, ParseException, InterruptedException
	{
		
		
		System.out.println("Enter your Details : ");
		
		System.out.println("FirstName : ");
		setFirstName(validate(br.readLine()));
					
		System.out.println("LastName : ");
		setLastName(validate(br.readLine()));
			
		System.out.println("MiddleName : ");
		setMiddleName(br.readLine());
		
		System.out.println("Gender(F/M) : ");
		setGender(genderValidation(br.readLine()));
			
		System.out.println("Date of Birth(MM/DD/YYYY) : ");
		setdob(dobValidation(br.readLine()));
		
		System.out.println("Email id : ");
		setEmail(br.readLine());
		emailValidation(detailsList);
		
		
		System.out.println("Address : ");
		setAddress(validate(br.readLine()));
			
		System.out.println("Phone No : ");
		setPhoneNo(br.readLine());
		phoneNumberValidation(detailsList);
		
	
//	abstract void subjectDetail() throws IOException;
	}
}