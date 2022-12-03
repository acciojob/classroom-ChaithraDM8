package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }

    public void addPair(String student, String teacher) {
        studentRepository.addPair(student,teacher);
    }

    public Student getStudentByName(String name) {
       return  studentRepository.getStudentByname(name);
    }

    public Teacher getTeacherByName(String name) {
       return studentRepository.getTeacherByname(name);
    }

    public List<String> getStudentByTeacherName(String teacher) {
        return studentRepository.getStudentByTeachername(teacher);
    }

    public List<String> getAllStudent() {
       return studentRepository.getAllStudent();
    }

    public void deleteTeacherByName(String teacher) {
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllStudents();
    }
}
