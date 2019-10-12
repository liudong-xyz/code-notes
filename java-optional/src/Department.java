import java.util.List;

/**
 * Department 实体类
 *
 * @author: liudong
 * @date: 2019/10/12
 */
public class Department {

    /**
     * id
     */
    private Integer id;

    /**
     * deptName
     */
    private String deptName;

    /**
     * userList
     */
    private List<User> userList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }


}
