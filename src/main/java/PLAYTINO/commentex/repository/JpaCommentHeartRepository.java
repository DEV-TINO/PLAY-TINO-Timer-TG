package PLAYTINO.commentex.repository;

import PLAYTINO.commentex.domain.CommentHeart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository

public interface JpaCommentHeartRepository extends JpaRepository<CommentHeart, UUID> {

    CommentHeart findByCommentIdAndUserId(UUID commentId, UUID userId);

}
