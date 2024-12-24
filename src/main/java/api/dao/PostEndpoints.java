package api.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostEndpoints {
    GET_POST("/posts/{id}"),
    CREATE_POST("/posts");

    private final String endpoint;
}
