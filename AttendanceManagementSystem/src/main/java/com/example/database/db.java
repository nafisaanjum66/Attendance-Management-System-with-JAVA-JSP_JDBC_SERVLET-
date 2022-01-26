package com.example.database;

import com.example.model.Login;
import com.example.model.Registration;
import com.example.model.Student;

import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class db {
    static String url = "jdbc:mysql://localhost:3307/attendancems?autoReconnect=true&useSSL=false";
    static String username="root";
    static String password="Shefat@66";

    private static final String INSERT_REGISTRATION_SQL = "INSERT INTO attendancems.registration" + "  (username, password, fullname, mobile, dob, qualification) VALUES "+ " (?, ?, ?, ?, ?, ?);";

    private static final String INSERT_LOGIN_SQL = "INSERT INTO attendancems.login" + "  (username, password) VALUES "+ " (?, ?);";

    private static final String VALID_LOGIN_SQL = "select * from attendancems.login where username = ? and password = ?;";

    private static final String UPDATE_DATE_LOGIN_SQL = "update attendancems.login set todaydate = ? where username = ? and password = ?;";

    private static final String SELECT_CHANGE_PASS_PERSON = "select username,password from attendancems.login where username = ?;";

    private static final String CHANGE_PASSWORD_SQL = "update attendancems.login set password = ? where username = ?;";

    private static final String SELECT_LOGIN_PERSON = "select username,password,todaydate from attendancems.login where username = ? and password = ?;";


    private static final String SELECT_ALL_STUDENT = "select id,sname,rollno,course,semester,branch,attendance from attendancems.student where username = ? and todaydate = ?;";

    private static final String INSERT_NEW_STUDENT_SQL = "INSERT INTO attendancems.student" + "  (username, todaydate, sname, rollno, course, semester, branch, attendance) VALUES "+ " (?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String DELETE_STUDENT_SQL = "delete from attendancems.student where id = ?;";

    private static final String SELECT_STUDENT_BY_ID = "select * from attendancems.student where id = ?;";

    private static final String UPDATE_ATTENDANCE_SQL = "update attendancems.student set attendance = ? where id = ?;";

    private static final String UPDATE_STUDENT_SQL = "update attendancems.student set username= ?, todaydate= ?, sname= ?, rollno= ?, course= ?, semester= ?, branch= ? where id = ?;";

    private static final String SELECT_STUDENT_WITHOUT_ATTENDANCE = "select username, todaydate, sname, rollno, course, semester, branch from attendancems.student where id = ?;";

    private static final String SELECT_ALL_MY_STUDENT = "select id,todaydate,sname,rollno,course,semester,branch,attendance from attendancems.student where username = ?;";

    private static final String SEARCH_ALL_MY_STUDENT = "select * from attendancems.student where todaydate LIKE ? ESCAPE '!' or sname LIKE ? ESCAPE '!' or rollno LIKE ? ESCAPE '!' or course LIKE ? ESCAPE '!' or semester LIKE ? ESCAPE '!' or branch LIKE ? ESCAPE '!' or attendance LIKE ? ESCAPE '!' and username=?;";
//    private static final String SEARCH_ALL_MY_STUDENT = "select * from attendancems.student where sname like '%"+"?"+"%';";

    private static final String SEARCH_DASHBOARD_STUDENT = "select * from attendancems.student where sname LIKE ? ESCAPE '!' or rollno LIKE ? ESCAPE '!' or course LIKE ? ESCAPE '!' or semester LIKE ? ESCAPE '!' or branch LIKE ? ESCAPE '!' or attendance LIKE ? ESCAPE '!' and username=? and todaydate=?;";

    private static final String SELECT_FACULTY_BY_USERNAME = "select * from attendancems.registration where username = ?;";

    private static final String UPDATE_FACULTY_PROFILE = "update attendancems.registration set fullname= ?, mobile= ?, dob= ?, qualification= ? where username = ?;";
    private static final String UPDATE_MY_PASSWORD_REG = "update attendancems.registration set password= ? where username = ?;";
    private static final String UPDATE_MY_PASSWORD_LOGIN = "update attendancems.login set password= ? where username = ?;";




    public db(){}

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertRegistration(Registration registration) {
        System.out.println(INSERT_REGISTRATION_SQL);

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REGISTRATION_SQL)) {
            preparedStatement.setString(1, registration.getUsername());
            preparedStatement.setString(2, registration.getPassword());
            preparedStatement.setString(3, registration.getFullname());
            preparedStatement.setString(4, registration.getMobile());
            preparedStatement.setString(5, registration.getDob());
            preparedStatement.setString(6, registration.getQualification());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertLogin(Registration registration) {
        System.out.println(INSERT_LOGIN_SQL);

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOGIN_SQL)) {
            preparedStatement.setString(1, registration.getUsername());
            preparedStatement.setString(2, registration.getPassword());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean validLogin(Login login) {
        System.out.println(VALID_LOGIN_SQL);
        boolean status=false;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(VALID_LOGIN_SQL)) {
            preparedStatement.setString(1, login.getUsername());
            preparedStatement.setString(2, login.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public Login selectLoginPerson(String username,String password) {
        Login login = null;

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN_PERSON)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                //String name = rs.getString("name");
                //String username = rs.getString("username");
                //String password = rs.getString("password");
                String todaydate = rs.getString("todaydate");
                //String id = rs.getString("id");
                login = new Login(username,password,todaydate);

                //return login;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }

    public boolean updateDateInLogin(Login login) {
        System.out.println(UPDATE_DATE_LOGIN_SQL);

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DATE_LOGIN_SQL)) {

            preparedStatement.setString(1, login.getTodaydate());
            preparedStatement.setString(2, login.getUsername());
            preparedStatement.setString(3, login.getPassword());

            System.out.println(preparedStatement);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Login selectChangePassPerson(String username) {
        Login login = null;

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CHANGE_PASS_PERSON)) {
            preparedStatement.setString(1, username);
            //preparedStatement.setString(2, password);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                //String name = rs.getString("name");
//                String username = rs.getString("username");
                String password = rs.getString("password");
                //String todaydate = rs.getString("todaydate");
                //String id = rs.getString("id");
                login = new Login(username,password);

                //return login;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }

    public boolean changePassword(Login login) {
        System.out.println(CHANGE_PASSWORD_SQL);

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_PASSWORD_SQL)) {

            preparedStatement.setString(1, login.getPassword());
            //preparedStatement.setString(2, login.getTodaydate());
            preparedStatement.setString(2, login.getUsername());

            System.out.println(preparedStatement);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Student> selectStudentsDashboard(String username,String todaydate) {

        List<Student> student = new ArrayList<>();
        //Student student = null;

        try (Connection connection = getConnection();


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, todaydate);
            System.out.println(preparedStatement);

            try (ResultSet rs = preparedStatement.executeQuery()) {


                while (rs.next()) {
                    int id = rs.getInt("id");
                    String sname = rs.getString("sname");
                    String rollno = rs.getString("rollno");
                    String course = rs.getString("course");
                    String semester = rs.getString("semester");
                    String branch = rs.getString("branch");
                    String attendance = rs.getString("attendance");

                    student.add(new Student(id,username,todaydate,sname,rollno,course,semester,branch,attendance )) ;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return student;
    }

    public void insertNewStudent(Student student) {
        System.out.println(INSERT_NEW_STUDENT_SQL);

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_STUDENT_SQL)) {
            preparedStatement.setString(1, student.getUsername());
            preparedStatement.setString(2, student.getTodaydate());
            preparedStatement.setString(3, student.getSname());
            preparedStatement.setString(4, student.getRollno());
            preparedStatement.setString(5, student.getCourse());
            preparedStatement.setString(6, student.getSemester());
            preparedStatement.setString(7, student.getBranch());
            preparedStatement.setString(8, "");

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteStudent(int id)  {
        //boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
            //statement.setInt(1, id);
            statement.setInt(1, id);
            //rowDeleted = statement.executeUpdate() > 0;
            int count = statement.executeUpdate();
            if (count > 0) {
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Student selectStudent(int id) {
        Student student = null;

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                String username = rs.getString("username");
                String todaydate = rs.getString("todaydate");
                String sname = rs.getString("sname");
                String rollno = rs.getString("rollno");
                String course = rs.getString("course");
                String semester = rs.getString("semester");
                String branch = rs.getString("branch");
                String attendance = rs.getString("attendance");
                student = new Student(id, username, todaydate, sname, rollno,course,semester,branch,attendance );

                //return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public Student selectStudentWithoutAttendance(int id) {
        Student student = null;

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_WITHOUT_ATTENDANCE)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                String username = rs.getString("username");
                String todaydate = rs.getString("todaydate");
                String sname = rs.getString("sname");
                String rollno = rs.getString("rollno");
                String course = rs.getString("course");
                String semester = rs.getString("semester");
                String branch = rs.getString("branch");
                //String attendance = rs.getString("attendance");
                student = new Student(id, username, todaydate, sname, rollno,course,semester,branch);

                //return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public boolean updateStudent(Student student)  {
        //boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
            //statement.setInt(1, person.getId());
            statement.setString(1, student.getUsername());
            statement.setString(2, student.getTodaydate());
            statement.setString(3, student.getSname());
            statement.setString(4, student.getRollno());
            statement.setString(5, student.getCourse());
            statement.setString(6, student.getSemester());
            statement.setString(7, student.getBranch());
            //statement.setString(8, "");
            statement.setInt(8, student.getId());

            int count = statement.executeUpdate();

            //rowUpdated = statement.executeUpdate(UPDATE_PERSON_SQL)>0;
            //rowUpdated = true;
            if (count > 0) {
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        //return rowUpdated;
        // return false;
    }

    public boolean updateAttendancePresent( int id)  {
        //boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ATTENDANCE_SQL))       {
            //statement.setInt(1, person.getId());
            statement.setString(1, "present");
            statement.setInt(2, id);

            int count = statement.executeUpdate();

            //rowUpdated = statement.executeUpdate(UPDATE_PERSON_SQL)>0;
            //rowUpdated = true;
            if (count > 0) {
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        //return rowUpdated;
        // return false;
    }

    public boolean updateAttendanceAbsent( int id) {
        //boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ATTENDANCE_SQL)) {
            //statement.setInt(1, person.getId());
            statement.setString(1, "absent");
            statement.setInt(2, id);

            int count = statement.executeUpdate();

            //rowUpdated = statement.executeUpdate(UPDATE_PERSON_SQL)>0;
            //rowUpdated = true;
            if (count > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        //return rowUpdated;
        // return false;
    }

    public boolean updateAttendance( int id, String attendance) {
        //boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ATTENDANCE_SQL)) {
            //statement.setInt(1, person.getId());
            statement.setString(1, attendance);
            statement.setInt(2, id);

            int count = statement.executeUpdate();

            //rowUpdated = statement.executeUpdate(UPDATE_PERSON_SQL)>0;
            //rowUpdated = true;
            if (count > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        //return rowUpdated;
        // return false;
    }

    public List<Student> selectAllMyStudent(String username) {

        List<Student> student = new ArrayList<>();
        //Student student = null;

        try (Connection connection = getConnection();


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MY_STUDENT)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, username);
            //preparedStatement.setString(2, todaydate);
            System.out.println(preparedStatement);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String todaydate = rs.getString("todaydate");
                    String sname = rs.getString("sname");
                    String rollno = rs.getString("rollno");
                    String course = rs.getString("course");
                    String semester = rs.getString("semester");
                    String branch = rs.getString("branch");
                    String attendance = rs.getString("attendance");

                    student.add(new Student(id,username,todaydate,sname,rollno,course,semester,branch,attendance)) ;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return student;
    }

    public List<Student> searchAllMyStudent(String search, String username) {

        List<Student> students = new ArrayList<>();
        //Student student = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ALL_MY_STUDENT)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%" + search + "%");
            preparedStatement.setString(2, "%" + search + "%");
            preparedStatement.setString(3, "%" + search + "%");
            preparedStatement.setString(4, "%" + search + "%");
            preparedStatement.setString(5, "%" + search + "%");
            preparedStatement.setString(6, "%" + search + "%");
            preparedStatement.setString(7, "%" + search + "%");
            preparedStatement.setString(8, username);
            //preparedStatement.setString(2, todaydate);
            //System.out.println(preparedStatement);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String todaydate = rs.getString("todaydate");
                    String sname = rs.getString("sname");
                    String rollno = rs.getString("rollno");
                    String course = rs.getString("course");
                    String semester = rs.getString("semester");
                    String branch = rs.getString("branch");
                    String attendance = rs.getString("attendance");

                    students.add(new Student(id,username,todaydate,sname,rollno,course,semester,branch,attendance                    )) ;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return students;
    }

    public List<Student> searchDashboardStudent(String search, String username, String todaydate) {

        List<Student> students = new ArrayList<>();
        //Student student = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_DASHBOARD_STUDENT)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%" + search + "%");
            preparedStatement.setString(2, "%" + search + "%");
            preparedStatement.setString(3, "%" + search + "%");
            preparedStatement.setString(4, "%" + search + "%");
            preparedStatement.setString(5, "%" + search + "%");
            preparedStatement.setString(6, "%" + search + "%");
            preparedStatement.setString(7, username);
            preparedStatement.setString(8, todaydate);
            //System.out.println(preparedStatement);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String sname = rs.getString("sname");
                    String rollno = rs.getString("rollno");
                    String course = rs.getString("course");
                    String semester = rs.getString("semester");
                    String branch = rs.getString("branch");
                    String attendance = rs.getString("attendance");

                    students.add(new Student(id,username,todaydate,sname,rollno,course,semester,branch,attendance)) ;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return students;
    }

    public Registration selectMyProfile(String uname) {
        Registration faculty = null;

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FACULTY_BY_USERNAME)) {
            preparedStatement.setString(1, uname);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                String mobile = rs.getString("mobile");
                String dob = rs.getString("dob");
                String qualification = rs.getString("qualification");
                faculty = new Registration(id, username, password, fullname, mobile,dob,qualification);

                //return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faculty;
    }

    public boolean updateFacultyProfile(Registration myfaculty)  {
        //boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_FACULTY_PROFILE)) {
            //statement.setInt(1, person.getId());
            statement.setString(1, myfaculty.getFullname());
            statement.setString(2, myfaculty.getMobile());
            statement.setString(3, myfaculty.getDob());
            statement.setString(4, myfaculty.getQualification());
            statement.setString(5, myfaculty.getUsername());
            //statement.setString(8, "");


            int count = statement.executeUpdate();

            //rowUpdated = statement.executeUpdate(UPDATE_PERSON_SQL)>0;
            //rowUpdated = true;
            if (count > 0) {
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        //return rowUpdated;
        // return false;
    }

    public boolean updateMyPassword(Registration myfaculty)  {
        //boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_MY_PASSWORD_REG)) {
            //statement.setInt(1, person.getId());
            statement.setString(1, myfaculty.getPassword());
            statement.setString(2, myfaculty.getUsername());
            //statement.setString(8, "");


            int count = statement.executeUpdate();

            //rowUpdated = statement.executeUpdate(UPDATE_PERSON_SQL)>0;
            //rowUpdated = true;
            if (count > 0) {
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        //return rowUpdated;
        // return false;
    }

    public boolean updateMyPasswordLogin(Login mypass)  {
        //boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_MY_PASSWORD_LOGIN)) {
            //statement.setInt(1, person.getId());
            statement.setString(1, mypass.getPassword());
            statement.setString(2, mypass.getUsername());
            //statement.setString(8, "");


            int count = statement.executeUpdate();

            //rowUpdated = statement.executeUpdate(UPDATE_PERSON_SQL)>0;
            //rowUpdated = true;
            if (count > 0) {
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        //return rowUpdated;
        // return false;
    }




}
