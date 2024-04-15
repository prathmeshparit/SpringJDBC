package Dao;

import entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao
{
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int  insert(Student student) {
        String sql = "insert into student values(?,?,?)";
        int result = jdbcTemplate.update(sql, String.valueOf(student.getId()),student.getName(),student.getCity());
        return result;
    }

    @Override
    public int update(Student student) {
        String sql = "update student set name=?,city=? where id=?";
        int result = jdbcTemplate.update(sql, student.getName(),student.getCity(),student.getId());
        return result;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from student where id=?";
        int result = this.jdbcTemplate.update(sql, id);
        return result;
    }

    @Override
    public Student getStudent(int id) {
        String sql = "select * from student where id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = jdbcTemplate.queryForObject(sql, rowMapper,id);
        return student;

    }

    @Override
    public List<Student> getStudents() {
        String sql = "select * from student ";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        List<Student> student = jdbcTemplate.query(sql, rowMapper);
        return student;
    }

}
