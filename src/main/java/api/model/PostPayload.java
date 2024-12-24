package api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostPayload {
    private String title;
    private String body;
    private int userId;
}
