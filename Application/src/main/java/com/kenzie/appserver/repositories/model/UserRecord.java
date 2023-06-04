@DynamoDBTable(tableName = "User")
public class UserRecord {
    private String userId;
    private String userName;

    @DynamoDBHashKey(attributeName = "userId")
    public String getUserId() {
        return userId;
    }
    @DynamoDBAttribute(attributeName = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        UserRecord that = (UserRecord) object;
        return java.util.Objects.equals(userId, that.userId) && java.util.Objects.equals(userName, that.userName);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, userName);
    }
}