package vod.web.rest.dto;

import lombok.Data;

@Data
public class BookDTO {
    private String title;
    private String cover;
    private int authorId;
    private float rating;
}
