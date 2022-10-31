
/**
 * 
 * @author boyd1
 *
 */
public class CourseDBElement implements Comparable{
	
	private String courseID;
	private int CRN;
	private int numberOfCredits;
    private String roomNumber;
    private String instructorName;
    
    CourseDBElement(){
    	
    }
    
    CourseDBElement(String cID, int crn, int numOfCred, String rNum, String instName){
    	
    	
    	this.courseID = cID;
    	this.CRN = crn;
    	this.numberOfCredits = numOfCred;
    	this.roomNumber = rNum;
    	this.instructorName = instName;
    	
    	
    }
    
    

	public String getID() {
		return courseID;
	}



	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}



	public int getCRN() {
		return CRN;
	}



	public void setCRN(int cRN) {
		CRN = cRN;
	}



	public int getNumberOfCredits() {
		return numberOfCredits;
	}



	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}



	public String getRoomNum() {
		return roomNumber;
	}



	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}



	public String getInstructorName() {
		return instructorName;
	}



	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}



	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
