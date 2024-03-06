package PLAYTINO.commentex.controller;

import PLAYTINO.commentex.domain.RequestCommentHeartDeleteDTO;
import PLAYTINO.commentex.domain.RequestCommentHeartSaveDTO;
import PLAYTINO.commentex.service.CommentHeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CommentHeartController {

    private final CommentHeartService commentHeartService;

    @Autowired
    public CommentHeartController(CommentHeartService commentHeartService){

        this.commentHeartService = commentHeartService;
    }

    // 댓글 하트 생성
    @PostMapping("/comment-heart")
    public UUID save(@RequestBody RequestCommentHeartSaveDTO requestCommentHeartSaveDTO){

        return commentHeartService.save(requestCommentHeartSaveDTO);
    }

    // 댓글 하트 제거
    @DeleteMapping("/comment-heart")
    public UUID delete(@RequestBody RequestCommentHeartDeleteDTO requestCommentHeartDeleteDTO){

        return commentHeartService.delete(requestCommentHeartDeleteDTO);
    }

}
