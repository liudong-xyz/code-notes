package xyz.liudong;

/**
 * UserDTO
 *
 * @author: liudong
 * @date: 2019/10/24
 */
public class UserDTO {

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

    /**
     * age
     */
    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
