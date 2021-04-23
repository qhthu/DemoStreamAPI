/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author quach
 */
class Student {

    private int id;
    private String name;
    private int age;
    private String gender;

    public Student(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}

class StudentDTO {

    private int id;
    private String name;
    private int age;
    private String gender;

    public StudentDTO(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

public class DemoStreamAPI {

    public static void main(String[] args) throws Exception {

        Student s1 = new Student(1, "Nhung", 22, "female");
        Student s2 = new Student(2, "An", 18, "male");
        Student s3 = new Student(3, "Thu", 19, "female");
        Student s4 = new Student(4, "Bao", 23, "male");

        List<Student> student = Arrays.asList(s1, s2, s3, s4);

        List<Student> filterGender = student.stream().filter(st -> (st.getGender().equals("male"))).collect(Collectors.toList());
        Iterator it = filterGender.iterator();
        System.out.println("Nam sinh vien:");
        System.out.printf("%-20s%-20s%-20s", "ID", "NAME", "AGE");
        System.out.println();
        while (it.hasNext()) {
            Student next = (Student) it.next();
            System.out.printf("%-20s%-20s%-20s", next.getId(), next.getName(), next.getAge());
            System.out.println();
        }

        int countAge = (int) student.stream().filter(st -> (st.getAge() >= 20)).count();

        System.out.println("So sinh vien lon hon 20 tuoi la: " + countAge);

        List<StudentDTO> studentDTOs = student.stream().map(s -> new StudentDTO(s.getId(), s.getName(), s.getAge(), s.getGender())).collect(Collectors.toList());

        int countAgeDTO = (int) studentDTOs.stream().filter(st -> (st.getAge() >= 20)).count();
        Iterator i = studentDTOs.iterator();
        System.out.println("Student DTO:");
        System.out.printf("%-20s%-20s%-20s%-20s", "ID", "NAME", "AGE", "GENDER");
        System.out.println();
        while (i.hasNext()) {
            StudentDTO next = (StudentDTO) i.next();
            System.out.printf("%-20s%-20s%-20s%-20s", next.getId(), next.getName(), next.getAge(), next.getGender());
            System.out.println();
        }
    }

}
