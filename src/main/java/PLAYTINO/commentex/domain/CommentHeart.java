package PLAYTINO.commentex.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentHeart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID commentHeartId;
    UUID userId;
    UUID commentId;
}
