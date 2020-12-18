package it.solvingteam.jerseydemo.dto;

public class ErrorDto {

    public ErrorDto(String message) {
        this.message = message;
    }

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
