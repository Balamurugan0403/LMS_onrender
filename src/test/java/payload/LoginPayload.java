package payload;

import java.util.HashMap;

public class LoginPayload {

    public static HashMap<String, Object> getLoginBody(String email, String password) {

        HashMap<String, Object> payload = new HashMap<>();

        payload.put("email", email);
        payload.put("password", password);

        return payload;
    }
}