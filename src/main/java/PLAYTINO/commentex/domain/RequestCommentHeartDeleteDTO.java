package PLAYTINO.commentex.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestCommentHeartDeleteDTO {
    UUID commentId;
    UUID userId;
    UUID commentHeartId;
}
