package PLAYTINO.commentex.service;

import PLAYTINO.commentex.domain.CommentHeart;
import PLAYTINO.commentex.domain.RequestCommentHeartDeleteDTO;
import PLAYTINO.commentex.domain.RequestCommentHeartSaveDTO;
import PLAYTINO.commentex.repository.JpaCommentHeartRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentHeartService {

    JpaCommentHeartRepository jpaCommentHeartRepository;
    CommentService commentService;

    public CommentHeartService(JpaCommentHeartRepository jpaCommentHeartRepository, CommentService commentService){
        this.jpaCommentHeartRepository = jpaCommentHeartRepository;
        this.commentService = commentService;
    }

    // 댓글 하트 생성
    public UUID save(RequestCommentHeartSaveDTO requestCommentHeartSaveDTO){
        // dto를 이용해서 dao를 만들어줌
        CommentHeart commentHeart = new CommentHeart();

        //dao 값 초기화
        commentHeart.setCommentId(requestCommentHeartSaveDTO.getCommentId());
        commentHeart.setUserId(requestCommentHeartSaveDTO.getUserId());

        //dao를 저장
        jpaCommentHeartRepository.save(commentHeart);

        // 댓글 하트 증가 : heartCount + 1

        // commentService에 구현해둔 메서드 호출



        // PK값 반환
        return commentHeart.getCommentHeartId();
    }

    // 댓글 하트 삭제
    public UUID delete(RequestCommentHeartDeleteDTO requestCommentHeartDeleteDTO){

        // commentId, userId를 통해서 객체를 찾아 -> DAO
        UUID userId = requestCommentHeartDeleteDTO.getUserId();
        UUID commentId = requestCommentHeartDeleteDTO.getCommentId();
        CommentHeart commentHeart = jpaCommentHeartRepository.findByCommentIdAndUserId(commentId, userId);

        // DAO를 삭제시키면 됨 -> repository.delete(DAO 객체)
        jpaCommentHeartRepository.delete(commentHeart);

        // 삭제된 객체의 commentHeartId를 반환시켜줌
        return commentHeart.getCommentHeartId();
    }

    // 하트 갯수 증가


}
