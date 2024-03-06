package PLAYTINO.commentex.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class RequestCommentUpdateDTO {
    UUID commentId;
    UUID userId;
    String content;
}
