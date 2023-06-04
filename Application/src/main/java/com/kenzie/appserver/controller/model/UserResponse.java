@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("userName")
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}