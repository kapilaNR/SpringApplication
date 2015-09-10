package hms.mchoice.helloworld.beans;

/**
 * Created by kapila on 9/8/15.
 */
public class UserBeans {
    //private long userId;
    private String firstName;
    private String middleName;
    //private int age;
    private String age;
    private String userId;



    public String getUserId() {
            return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAge(){
        return age ;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
