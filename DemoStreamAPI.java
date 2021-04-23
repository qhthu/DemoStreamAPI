/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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

public class DemoStreamAPI {

    public static void main(String[] args) {

        Student s = new Student(0, "", 0, "");
        s.setId(0);
        s.setName("Thu");
        s.setGender("nu");
        s.setAge(10);

        Student s1 = new Student(0, "", 0, "");
        s1.setId(0);
        s1.setName("Nhung");
        s1.setGender("nu");
        s1.setAge(27);

        Student s2 = new Student(0, "", 0, "");
        s2.setId(0);
        s2.setName("Tan");
        s2.setGender("nam");
        s2.setAge(22);
        List<Student> student = Arrays.asList(s, s1, s2);

        List<Student> filterGender = student.stream().filter(st -> (st.getGender().equals("nam"))).collect(Collectors.toList());
        Iterator it = filterGender.iterator();
        System.out.println("Nam sinh vien:");
        while (it.hasNext()) {
            Student next = (Student) it.next();
            System.out.println(next.getName());
        }

        int countAge = (int) student.stream().filter(st -> (st.getAge() >= 20)).count();

        System.out.println("So sinh vien lon hon 20 tuoi la: " + countAge);

    }

}
