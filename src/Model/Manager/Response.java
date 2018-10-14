package Model.Manager;

public class Response {
    private boolean result;
    private String description;
    private String u_id;

    public Response(boolean result, String description) {
        this.result = result;
        this.description = description;
    }

    public Response(boolean result, String description, String u_id) {
        this.result = result;
        this.description = description;
        this.u_id = u_id;
    }

    public boolean getResult() {
        return result;
    }

    public String getDescription() {
        return description;
    }

    public String u_id() {
        return u_id;
    }
}
