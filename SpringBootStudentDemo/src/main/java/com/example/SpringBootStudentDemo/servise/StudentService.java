package com.example.SpringBootStudentDemo.servise;

import com.example.SpringBootStudentDemo.entity.Student;
import com.example.SpringBootStudentDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public Student createStudent(Student studentReq) {
        Student studentResp=studentRepository.save(studentReq);
        return studentReq;
    }

    public Student getStudent(Long id) {
       Optional<Student> studentResp= studentRepository.findById(id);
       if(studentResp.isPresent()){
           return studentResp.get();
       }
       return null;
    }

    public List<Student> getAllStudent() {
        List<Student>studentList = studentRepository.findAll();
        return studentList;
    }

    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student>studentExist=studentRepository.findById(id);
        if(studentExist.isEmpty()){
            return null;
        }
        Student studentToSave=studentExist.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setAge(studentReq.getAge());

        return studentRepository.save(studentToSave);

    }

    public Boolean deleteStudent(Long id) {
        Boolean isExist=studentRepository.existsById(id);
        if(!isExist)return false;
        studentRepository.deleteById(id);
        return true;
    }
}
