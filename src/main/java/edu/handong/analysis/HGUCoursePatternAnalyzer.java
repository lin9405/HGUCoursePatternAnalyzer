package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;
import java.util.*;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	Student[] students;
	Course[] courses;

	private Object studentName;


	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	public Student[] initiateStudentArrayFromLines(String[] lines) {
		
		Student[] stuName = new Student[numOfStudents];
		for(int i = 0; i < stuName.length ; i++) {
			stuName[i] = new Student("");
		}
		String[] nameTemp;
		int index = 0;
		
	for(int i = 0; i <lines.length ;i ++) {
		nameTemp = lines[i].split(",");
	//	System.out.println(nameTemp[1]);
		
		String trimName = nameTemp[1].trim();
		Student name  =  new Student(trimName);
		
		
		if(!studentExist(stuName,name)) {
				
			stuName[index] = name;
			index++;
		}
		
	}


return stuName;

		
	}

	

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
	for(int i = 0; i<students.length; i++) {
		if(students[i].getName().equals(student.getName())) {
			return true;	
		}
		
		
	}
	return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {

		Course[] courseName = new Course[numOfCourses];
		for(int i = 0; i < courseName.length ; i++) {
			courseName[i] = new Course("");
		}
		String[] courseTemp;
		
		int index = 0;
		
	for(int i = 0; i <lines.length ;i ++) {
		courseTemp = lines[i].split(",");
	//	System.out.println(courseTemp[1]);
		String trimCourse = courseTemp[2].trim();
		Course name  =  new Course(trimCourse);
		
		
		if(!courseExist(courseName,name)) {
			courseName[index] = name;
			index++;
		}
		
	}
return courseName;
	}

	
	
	
	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		for(int i = 0; i<courses.length; i++) {
			if(courses[i].getCourseName().contains(course.getCourseName())) {
				return true;	
			}

	}

		return false;
		
	}
}


