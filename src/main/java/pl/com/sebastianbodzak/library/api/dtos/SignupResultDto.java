package pl.com.sebastianbodzak.library.api.dtos;

/**
 * Created by Dell on 2016-10-11.
 */
public class SignupResultDto {

    private boolean success;
    private String failureReason;

    public SignupResultDto() {
        this.success = true;
    }

    public SignupResultDto(String failureReason) {
        this.failureReason = failureReason;
        this.success = false;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getFailureReason() {
        return failureReason;
    }
}
