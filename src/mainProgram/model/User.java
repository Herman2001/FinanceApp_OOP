package mainProgram.model;

import java.time.LocalDateTime;

public class User {
    private final int userId;
    private final String username;
    private final String passwordHash;
    private final LocalDateTime createdAt;

    //Från databasen
    public User(int userId, String username, String passwordHash, LocalDateTime createdAt) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.createdAt = createdAt;
    }
    // För ny registrering, userId och createdAt sätts av databsen.
    public User(String username, String passwordHash) {
        this(0, username, passwordHash, null);
    }

    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
