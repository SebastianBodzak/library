package pl.com.sebastianbodzak.library.api.responses;

/**
 * Created by Dell on 2016-10-12.
 */
public class CreateEmployeeResponse {

    public String id;

    public CreateEmployeeResponse(Long id) {
        this.id = id.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
