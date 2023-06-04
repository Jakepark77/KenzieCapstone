public class User {
    private final String userName;
    private final String userId;
    private List<Recipes> recipeList;

    public User (String userName) {
        this.userName = userName;
        this.userId = randomUUID().toString();
        this.recipeList = new ArrayList<>();
    }
    public User (String userName, String userId) {
        this.userName = userName;
        this.userId = userId
    }
    public User (String userName, String userId, List<Recipes> recipeList) {
        this.userName = userName;
        this.userId = userId;
        this.recipeList = recipeList;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public List<Recipes> getRecipeList() {
        return recipeList;
    }
}