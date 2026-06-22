package payload;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NotesPayload {

    public static HashMap<String, Object> getNotes() {

        HashMap<String, Object> payload = new HashMap<>();

        payload.put("title", "API Test Note");
        payload.put("content", "Created by tester");
        List<String> tags = Arrays.asList("qa", "demo");
        payload.put("tags", tags);
        payload.put("color", "#ffeb3b");
        payload.put("isPinned", false);

        return payload;
    }
}