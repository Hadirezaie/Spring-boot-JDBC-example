package af.mcit.springbootexample.course.jdbc;

import af.mcit.springbootexample.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository  {
    @Autowired
private JdbcTemplate jdbcTemplate;

private static String INSERT_QUERY=
        """
                INSERT INTO course(id, name, author) VALUES(?, ?,?)
                """;

private static String DELETE_QUERY=
        """
                DELETE FROM course WHERE id=?
                """;

private static String SELECT_QUERY=
            """
                    SELECT * FROM course WHERE id=?
                    """;
public void insertQuery(Course course){
    jdbcTemplate.update(INSERT_QUERY,course.getId(), course.getName(), course.getAuthor());

}

public void deleteQuery(Integer id){
    jdbcTemplate.update(DELETE_QUERY,id);
}

public Course selectById(Integer id){
    return jdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
}
}
