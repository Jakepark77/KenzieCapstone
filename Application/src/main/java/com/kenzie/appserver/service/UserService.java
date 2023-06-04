public class UserService {
    private UserRepository userRepository;
    public UserService(UserService userService) {
        this.userRepository = userRepository;
    }
    public User addNewUser(User user) {
        UserRecord userRecord = new UserRecord();
        userRecord.setUserId(user.getUserId());
        userRecord.setUserName(user.getUserName());
        userRepository.save(userRecord);
        return user;
    }
    public User findUserById(String userId) {
        User userFromRepository = userRepository.findByUserId(userId)
                .map(user -> new User(user.getUserId(),
                        user.getUserName()))
                .orElse(null);
        return userFromRepository;
    }
}