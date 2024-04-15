package Dao;

import entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RowMapperImpl  implements RowMapper<Student>
{
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student  = new Student();
        student.setId(rs.getInt(1));
        student.setName(rs.getString(2));
        student.setCity(rs.getString(3));

        return student;
    }




}
