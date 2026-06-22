package routes;

public class ApiRoutes {

    public static final String BASE_URL = "https://lms-server-3-wedg.onrender.com";

    public static final String HEALTH = BASE_URL + "/";

    public static final String LOGIN = BASE_URL + "/user/login";

    public static final String USERS = BASE_URL + "/user";
    
    public static final String INSTITUTION = BASE_URL + "/getAll/institution";
    
    public static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY5YzM4NGE2NmFiZjZjNTUwZmU0NWY3NSIsImlhdCI6MTc4MTcxNjA2OCwiZXhwIjoxNzgxOTc1MjY4fQ.Pc6eOzDcuOCY2M8_6TxLkVPVE6ZLdLhDK3O5Lkwk7O8";

    public static final String ROLES = BASE_URL + "/roles/getAll";
    
    public static final String COURSE_STRUCTURE = BASE_URL + "/courses-structure/getAll";
    
    public static final String NOTES = BASE_URL + "/create/notes";
    
    public static final String GETALL_NOTES = BASE_URL + "/getAll/notes";
    
    public static final String GET_ID = BASE_URL + "/getById/notes/";
    
    public static final String GET_ID_PATH_PARAM = BASE_URL + "/getById/notes/{id}";
    
    public static final String UPDATE_NOTE = BASE_URL + "/update/notes/";
    
    public static final String UPDATE_NOTE_PATH_PARAM = BASE_URL + "/update/notes/{id}";
  
    public static final String TOGGLE_PIN_PATH_PARAM = BASE_URL + "/toggle-pin/notes/{id}";
    
    public static final String DELETE_NOTE_PATH_PARAM = BASE_URL + "/delete/notes/ById/{id}";
    public static final String DELETE_NOTES = BASE_URL + "/delete/notes/ById/";
    
    
    
    
}