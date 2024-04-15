package dev.prathmesh;


import Dao.StudentDao;
import Dao.StudentDaoImpl;
import entity.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
public class App
{

    public static void main(String ards[])
    {
        System.out.println("My program is started.");
        //Spring jdbc -> Jdbc template

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
       StudentDaoImpl obj =  context.getBean("StudentDao", StudentDaoImpl.class);
//Insertion
//       Student student = new Student();
//       student.setCity("Pune");
//       student.setId(5);
//       student.setName("sharvari");
////       int res = obj.insert(student);

        //for update
//        Student student = new Student();
//        student.setName("Ashutosh");
//        student.setCity("Latur");
//        student.setId(2);
//        int res = obj.update(student);

        //for delete
     //   int res = obj.delete(4);

        //for select
     //   Student student = obj.getStudent(1);
      // System.out.println("Name : " + student.getName() + "Id : " + student.getId() + " City : " + student.getCity() );


        //for select multiple
        List<Student> student = obj.getStudents();
        for(Student s : student)
        {
            System.out.println("Name : " + s.getName() + "Id : " + s.getId() + " City : " + s.getCity() );
        }
    }

}
