package models.response;

import lombok.Data;

@Data
public class UserResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String active;
}
