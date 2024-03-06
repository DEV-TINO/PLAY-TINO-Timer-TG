package PLAYTINO.commentex.repository;

import PLAYTINO.commentex.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaCommentRepository extends JpaRepository<Comment, UUID> {
}
