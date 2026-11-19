package com.example.SpringBootStudentDemo.controller;

import com.example.SpringBootStudentDemo.entity.Student;
import com.example.SpringBootStudentDemo.servise.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Create
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createStudent=studentService.createStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(createStudent);

    }

    //Read
    @GetMapping("/get/{id}")
    public ResponseEntity<Student>getStudent(@PathVariable Long id){
        Student studentResp=studentService.getStudent(id);
        if(studentResp==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }
    //ReadAllStudent
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList=studentService.getAllStudent();
        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }

    //Update
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student studentReq){
        Student studentResp=studentService.updateStudent(id,studentReq);

        if(studentResp==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }
    //DeleteStudent
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Boolean isDeleted =studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record is Deleted");
    }
}
