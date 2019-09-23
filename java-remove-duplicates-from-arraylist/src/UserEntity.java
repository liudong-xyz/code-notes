/**
 * UserEntity
 *
 * @author: liudong
 * @date: 2019/9/23
 */
public class UserEntity {

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

    public UserEntity(Integer id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }


}
