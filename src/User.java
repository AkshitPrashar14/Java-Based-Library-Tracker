public class User {
    int userId;
    String name;
    String email;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public void display() {
        System.out.println("User ID: " + userId +
                ", Name: " + name +
                ", Email: " + email);
    }
}