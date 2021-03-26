


public class CourseDBElement implements Comparable{

	private String courseId, room ,instructor ;
	private int courseNum, creditNum;
	
	
	public CourseDBElement() {

	}
	
    public CourseDBElement(String courseId, int courseNum, int creditNum, String room, String instructor) {
        this.courseId = courseId;
        this.courseNum = courseNum;
        this.creditNum = creditNum;
        this.room = room;
        this.instructor = instructor;
    }
    
    public int getCRN() {
        return courseNum;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getNumberOfCredits() {
        return creditNum;
    }

    public void setNumberOfCredits(int creditNum) {
        this.creditNum = creditNum;
    }

    public String getRoomNumber() {
        return room;
    }

    public void setRoomNumber(String room) {
        this.room = room;
    }

    public String getInstructorName() {
        return instructor;
    }

    public void setInstructorName(String instructor) {
        this.instructor = instructor;
    }
    
	@Override
    public int compareTo(CourseDBElement element) {
        if ( element.courseNum < this.courseNum )
            return 1;
        else if (this.courseNum < element.courseNum)
            return -1;
        else
            return 0;
	}

	 @Override
    public int hashCode() {
        String crn = Integer.toString(courseNum);
        int hashCode = crn.hashCode();
        return hashCode;
    }

	 
   public void setCRN(int crn) {
        this.courseNum = crn;
    }
    
    
	
}
