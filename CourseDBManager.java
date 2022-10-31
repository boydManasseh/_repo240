import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author boyd1
 *
 */
public class CourseDBManager implements CourseDBManagerInterface{
	
	CourseDBStructure cds;
	
	public CourseDBManager() {
		
		cds= new CourseDBStructure(50);
		
	}

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement cde = new CourseDBElement();
		cde.setCourseID(id);
		cde.setCRN(crn);
		cde.setNumberOfCredits(credits);
		cde.setRoomNumber(roomNum);
		cde.setInstructorName(instructor);
		
		cds.add(cde);
		
	}

	@Override
	public CourseDBElement get(int crn) {
		
	
		
		try {
			return cds.get(crn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		
		CourseDBElement cde = new CourseDBElement();
		Scanner scan = null;
		try {
			scan = new Scanner(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new FileNotFoundException();
		}
		
		
		
		
		while(scan.hasNext()) {
			
			String s = scan.next();
			int a = scan.nextInt();
			int b = scan.nextInt();
			String c = scan.next();
			String d = scan.nextLine();
			
			cde.setCourseID(s);
			cde.setCRN(a);
			cde.setNumberOfCredits(b);
			cde.setRoomNumber(c);
			cde.setInstructorName(d);
			
			
		}
		
		cds.add(cde);
		
	}

	@Override
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		return cds.showAll();
	}

}
