
package model;

/**
 *
 * @author 
 */
public class Role {
    
    /* An enum cannot be used to create objects, and it cannot extend other 
    classes (but ut can implement interfaces)*/
    public enum Type {
        admin, expert, sale, marketing, customer
    }
    
    private int role_id;
    private String role_name;

    public Role() {
    }
    
    public Role(int role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    public Role(int role_id) {
        this.role_id = role_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
