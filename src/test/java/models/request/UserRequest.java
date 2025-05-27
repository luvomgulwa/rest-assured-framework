package models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private boolean isActive;
    private String address;
    private String phone;
}
