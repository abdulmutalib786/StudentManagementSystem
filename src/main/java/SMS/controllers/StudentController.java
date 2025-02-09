package SMS.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SMS.entities.Students;
import SMS.services.StudentService;

@RestController
@RequestMapping("/sms")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// creating or adding student
	@PostMapping("/add")
	public String createStudent(@RequestBody Students students) {
		return studentService.createStudent(students.getName(), students.getBranch());
	}
	

	// viewing all students
	@GetMapping("/all")
	public List<Students> getAllStudents() {
		List<Students> listOfStudents = studentService.getAllStudent();
		return listOfStudents;
	}

	// viewing student by id
	@GetMapping("/rollNo/{roll_no}")
	public Students studentById(@PathVariable int roll_no) {
		return studentService.studentById(roll_no);
	}

	// deleting a student by id
	@DeleteMapping("/remove/{roll_no}")
	public String removeStudent(@PathVariable int roll_no) {
		String status = studentService.removeStudent(roll_no);   
		if (status.equalsIgnoreCase("Success")) {
			return "Student Deleted";
		} else {
			return "Failed To Delete";
		}
	}
	
	// updating details of student
	@PutMapping("/update/{rollNo}")
    public ResponseEntity<Students> updateStudent(@PathVariable int rollNo, @RequestBody Students students) {
        Students updatedStudent = studentService.updateStudent(rollNo, students.getName(), students.getBranch());
        return ResponseEntity.ok(updatedStudent);
    }
	

}
