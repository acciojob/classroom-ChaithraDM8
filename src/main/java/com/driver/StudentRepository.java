package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String,Student> studentHashMap =new HashMap<>();
    HashMap<String,Teacher> teacherHashMap =new HashMap<>();
    HashMap<String,List<String>> pairHashMap =new HashMap<>();
    public void addStudent(Student student) {
        studentHashMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher) {
        teacherHashMap.put(teacher.getName(),teacher);
    }

    public void addPair(String student, String teacher) {
        List<String> list =new ArrayList<>();
        if (pairHashMap.containsKey(teacher)) {
            list = pairHashMap.get(teacher);
            list.add(student);
            pairHashMap.put(teacher, list);
        } else {
            list.add(student);
            pairHashMap.put(teacher, list);
        }

    }

    public Student getStudentByname(String name) {
        return studentHashMap.get(name);
    }

    public Teacher getTeacherByname(String name) {
        return teacherHashMap.get(name);
    }

    public List<String> getStudentByTeachername(String teacher) {
      return  pairHashMap.get(teacher);
    }

    public List<String> getAllStudent() {
        List<String> list =new ArrayList<>();
        for(String name: studentHashMap.keySet()){
            list.add(name);
        }
        return list;
    }

    public void deleteTeacherByName(String teacher) {
        List<String> list =new ArrayList<>();
        teacherHashMap.remove(teacher);
        list=pairHashMap.remove(teacher);
        for(String name:list) {
            if (studentHashMap.containsKey(name))
                studentHashMap.remove(name);
        }
    }

    public void deleteAllStudents() {
        for(String name:pairHashMap.keySet())
        deleteTeacherByName(name);
    }
}
