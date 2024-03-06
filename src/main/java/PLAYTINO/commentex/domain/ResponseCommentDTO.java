package PLAYTINO.commentex.domain;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ResponseCommentDTO {
    UUID commentId;
    UUID userId;
    String content;
    int heartCount;
    LocalDateTime uploadTime;
}
