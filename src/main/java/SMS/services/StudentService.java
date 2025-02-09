package SMS.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SMS.entities.Students;
import SMS.repositories.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	// creating or adding student
	public String createStudent(String name, String branch) {
		Students students = new Students(name, branch);
		studentRepo.save(students);
		return "Added Sucessfully";
	}

	// viewing all students
	public List<Students> getAllStudent() {
		List<Students> listOfStudents = studentRepo.findAll();
		return listOfStudents;
	}

	// viewing student by id
	public Students studentById(int roll_no) {
		return studentRepo.findById(roll_no).get();
	}

	// deleting a student by id
	public String removeStudent(int roll_no) {
		studentRepo.deleteById(roll_no);
		return "Success";
	}

	// updating a student details
	public Students updateStudent(int rollNo, String name, String branch) {
		return studentRepo.findById(rollNo).map(student -> {
			student.setName(name);
			student.setBranch(branch);
			return studentRepo.save(student);
		}).orElseThrow(() -> new RuntimeException("Student not found with roll number: " + rollNo));
	}
}