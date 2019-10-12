/**
 * User 实体类
 *
 * @author: liudong
 * @date: 2019/10/12
 */
public class User {

    /**
     * id
     */
    private Integer id;

    /**
     * username
     */
    private String username;

    /**
     * email
     */
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {

    }

    public User(Integer id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }


}
