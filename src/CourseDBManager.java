//@author David Do
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure structure;
	
    public CourseDBManager() {
        this.structure = new CourseDBStructure(100);
    }
	
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
        structure.add(element);
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
        	CourseDBElement element = structure.get(crn);
        	String courseInfo = "\nCourse:"+element.getCourseId()+ " CRN:"+element.getCRN() +
                    " Credits:"+ element.getNumberOfCredits()+" Instructor:"+ element.getInstructorName()+
                    " Room:"+ element.getRoomNumber();
			System.out.println(courseInfo);
        	return structure.get(crn);
		
        } catch (IOException e) {
			
        	e.getMessage();
			return null;
		}
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		 Scanner file;
	        try {
	            file = new Scanner(input);
	        } catch (FileNotFoundException e){
	            throw new FileNotFoundException("File not found");
	        }

	        structure = new CourseDBStructure(100);

	        while(file.hasNextLine()){
	            Scanner scanner = new Scanner(file.nextLine());
	            String courseId = scanner.next();
	            int CRN = scanner.nextInt();
	            int numberOfCredits = scanner.nextInt();
	            String roomNumber = scanner.next();
	            String instructorName = "";
	            while (scanner.hasNext()){
	                instructorName += scanner.next()+ " ";
	            }

	            CourseDBElement element = new CourseDBElement(courseId, CRN, numberOfCredits, roomNumber, instructorName);
	            structure.add(element);
	        }
	       file.close();

	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> myList = new ArrayList<String>();
        int numberOfCourses = structure.getTableSize();

        for (LinkedList<?> linkedList: structure.hashTable) {
            if (linkedList!=null) {
                CourseDBElement[] cdeArray = (CourseDBElement[]) linkedList.toArray(new CourseDBElement[linkedList.size()]);

                for (CourseDBElement element: cdeArray) {
                    String courseInfo = "\nCourse:"+element.getCourseId()+ " CRN:"+element.getCRN() +
                            " Credits:"+ element.getNumberOfCredits()+" Instructor:"+ element.getInstructorName()+
                            " Room:"+ element.getRoomNumber();
                    myList.add(courseInfo);
                }
            }
        }
        return myList;
	}

}
