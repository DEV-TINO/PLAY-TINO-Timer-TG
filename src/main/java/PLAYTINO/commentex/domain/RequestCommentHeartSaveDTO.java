package PLAYTINO.commentex.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestCommentHeartSaveDTO {
    UUID commentHeartId;
    UUID userId;
    UUID CommentId;
}
