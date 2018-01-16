package mockSample;

public class StuController {

    private StudentDAO mStudentDAO;

    public Student getStudentInfo(int sid){
        Student student = null;
        if(mStudentDAO != null){
            // 从数据库中获取
            student = mStudentDAO.getStudentFromDB(sid);
        }
        if(student == null){
            // 从网络上获取
            student = fetchStudentInfo(sid);
        }
        return student;

    }

    private Student fetchStudentInfo(int sid){
        System.out.println("从网络上获取学生信息");
        // 模拟一个学生数据
        Student student = new Student();
        student.id = 45;
        student.name = "alen";
        return student;
    }
    public void setStudentDAO(StudentDAO dao){
        this.mStudentDAO = dao;
    }
}
