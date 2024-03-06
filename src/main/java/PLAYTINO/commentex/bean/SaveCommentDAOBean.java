package PLAYTINO.commentex.bean;

import PLAYTINO.commentex.domain.Comment;
import PLAYTINO.commentex.repository.JpaCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveCommentDAOBean {

    JpaCommentRepository jpaCommentRepository;

    @Autowired
    public SaveCommentDAOBean(JpaCommentRepository jpaCommentRepository){
        this.jpaCommentRepository = jpaCommentRepository;
    }

    //댓글 저장
    public void exec(Comment comment){
        jpaCommentRepository.save(comment);
    }

}
