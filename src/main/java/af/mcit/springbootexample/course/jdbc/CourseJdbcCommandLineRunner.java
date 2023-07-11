package af.mcit.springbootexample.course.jdbc;

import af.mcit.springbootexample.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    private  CourseRepository courseRepository;
    @Override
    public void run(String... args) throws Exception {
        courseRepository.insertQuery(new Course(1,"Learn Spring boot Now","FROM UDEMY"));
        courseRepository.insertQuery(new Course(2,"Learn Spring boot Now","FROM UDEMY"));
        courseRepository.insertQuery(new Course(3,"Learn Spring boot Now","FROM UDEMY"));
        courseRepository.deleteQuery(1);
        System.out.println(courseRepository.selectById(3));

    }
}
