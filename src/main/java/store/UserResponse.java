package store;

import static store.Exceptions.INVALID_INPUT;

public enum UserResponse {
    YES("Y"),
    NO("N");

    private final String response;

    UserResponse(String response) {
        this.response = response;
    }

    public static UserResponse of(String input) {
        for (UserResponse response : UserResponse.values()) {
            if (response.getResponse().equals(input)) {
                return response;
            }
        }
        throw new IllegalArgumentException(INVALID_INPUT.getMessage());
    }

    public String getResponse() {
        return response;
    }
}
