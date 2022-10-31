
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * 
 * @author boyd1
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface{
	
	int n;
	final float LOAD_FACTOR = 1.5f;
	private int tableSize;
	private HashEntry[] data;
	
	/**
	 * 
	 * @author boyd1
	 *
	 */
	class HashEntry{
		
		int key;
		CourseDBElement value;
		HashEntry next;
		
		HashEntry(int key, CourseDBElement value){
			this.key = key;
			this.value = value;
			this.next = null;
			
		}
		
	}
	
	
	public CourseDBStructure(int n){
		this.n = n;
		tableSize = find4k3Prime(n/LOAD_FACTOR);
		data = new HashEntry[tableSize];
		
	}

	public CourseDBStructure(String Testing, int h){
		
		this.n = h;
		tableSize = find4k3Prime(n/LOAD_FACTOR);
		data = new HashEntry[tableSize];
		
	}
	
	@Override
	public void add(CourseDBElement element) {
		
		int crn = element.getCRN();
		int key = hashCode(crn);
		
		HashEntry entry = new HashEntry(crn,element);
		
		if(data[key] == null) {
			data[key] = entry;
		}else {
			
			HashEntry entries = data[key];
			while(entries.next != null) {
				entries = entries.next;
			}
			
			entries.next = entry;
		}
		
	}


	private int hashCode(Integer crn) {
		
		
		return crn%tableSize;
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {

		int key = hashCode(crn);
		
		HashEntry entries = data[key];
		
		if(entries != null) {
			while (!(entries.key == crn) && entries.next != null) {
				entries = entries.next;
			}
			
			return entries.value;
		}else {
			
			throw new IOException();
		}
		
		
	}

	@Override
	public ArrayList<String> showAll() {
		
		ArrayList<String> arr = new ArrayList<String>(data.length);
		String s = "";
		int i = 0;
		
		for(HashEntry h :data) {
			
			s = " \nCourse: " + h.value.getID() + " CRN: " + h.value.getCRN() + " Credits: " + h.value.getNumberOfCredits() + " Instructor: " + h.value.getInstructorName() + " Room: " + h.value.getRoomNum();
			arr.add(s);
			i++;
		}
		
		return arr;
	}

	@Override
	public int getTableSize() {
		
		return tableSize;
	}
	
	private int find4k3Prime(float lOAD_FACTOR2) {
		int p = 0;
		boolean found = false;
		int q = (int) (n/lOAD_FACTOR2);
		
		while(found != true) {
			
			for(int i = q; i < n; i++ ) {
				
				if(isPrime(i)) {
					
					if((i + 3)%4 == 0) {
						
						p = i;
						found = true;
						break;
						
					}
					
				}
				
			}
			
		}
		
		return p;
	}
	
	static boolean isPrime(int n)
	{
	        // Corner case
	        if (n <= 1)
	            return false;
	  
	        // Check from 2 to square_root(n)
	        for (int i = 2; i <= Math.sqrt(n); i++)
	            if (n % i == 0)
	                return false;
	  
	        return true;
	}
	
	
}
