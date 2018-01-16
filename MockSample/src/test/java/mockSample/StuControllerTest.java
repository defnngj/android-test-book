package mockSample;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StuControllerTest {
    StuController stuController;
    StudentDAO studentDAO;

    @Before
    public void setUp(){
        stuController = new StuController();
        // Mock 一个StudentDAO对象
        studentDAO = mock(StudentDAO.class);
        // 注入对象
        stuController.setStudentDAO(studentDAO);
    }

    @Test
    public void testGetStudentInfo(){
        Student returnStudent = new Student();
        returnStudent.id = 123;
        returnStudent.name = "tom";
        // 调用 getStudentFromDB 时返回 returnStudent 对象;
        when(studentDAO.getStudentFromDB(anyInt())).thenReturn(returnStudent);

        // 调用getStudentInfo
        Student student = stuController.getStudentInfo(123);
        // 验证数据
        assertEquals(student.id, 123);
        assertEquals(student.name, "tom");
    }
}
