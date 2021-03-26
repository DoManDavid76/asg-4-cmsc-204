//@author David Do

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBStructure implements CourseDBStructureInterface {
	
	public LinkedList<CourseDBElement>[] hashTable;
    
	public CourseDBStructure(int numberOfCourses) {
        hashTable = new LinkedList[numberOfCourses];
    }
	
    public CourseDBStructure(String string, int hashTableSize){
        hashTable = new LinkedList[hashTableSize];
    }
	
	@Override
	public void add(CourseDBElement element) {
		int hashCode = element.hashCode();
        int index = hashCode%hashTable.length;
        if (hashTable[index] == null){
            hashTable[index] = new LinkedList<CourseDBElement>();
            hashTable[index].add(element);
        }
        else if (hashTable[index] != null){
            hashTable[index].add(element);
        }
		
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
    	String stringCRN = Integer.toString(crn);
        int hashCode = stringCRN.hashCode();
        int index = hashCode%hashTable.length;

        for ( int x = 0 ; x < hashTable[index].size(); x++) {
        	if (hashTable[index].get(x).getCRN() == crn)
        		return hashTable[index].get(x);
        }
        throw new IOException();
	}

	@Override
	public int getTableSize() {
		 return hashTable.length;
	}


}
