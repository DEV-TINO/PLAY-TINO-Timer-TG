package PLAYTINO.commentex.controller;

import PLAYTINO.commentex.domain.RequestCommentDTO;
import PLAYTINO.commentex.domain.RequestCommentUpdateDTO;
import PLAYTINO.commentex.domain.RequestCommentDeleteDTO;
import PLAYTINO.commentex.domain.ResponseCommentDTO;
import PLAYTINO.commentex.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    // 일단 CRUD다 -> create, read, update, delete -> 개발은 언제나 이순서대로 한다.

    // DAO마다 Controller, Service, Repository, 각종 DTO 생성
    // Repository 선언 -> extend JpaRep~~
    // Service 코드 작성
    // Controller코드 작성
    // postman을 통해서 url 확인

    // 댓글 1개 조회
    @GetMapping("/comment/{commentId}")
    public ResponseCommentDTO read(@PathVariable UUID commentId){
        return commentService.read(commentId);
    }

    // 댓글 전체 조회
    @GetMapping("/comment/all")
    public List<ResponseCommentDTO> readAll(){
        return commentService.readAll();
    }

    // 댓글 생성
    @PostMapping("/comment")
    public UUID create(@RequestBody RequestCommentDTO requestCommentDTO){
        return commentService.join(requestCommentDTO);
    }

    // 댓글 수정
    @PutMapping("/comment")
    public UUID update(@RequestBody RequestCommentUpdateDTO requestCommentUpdateDTO){
        return commentService.update(requestCommentUpdateDTO);
    }

    // 댓글 삭제
    @DeleteMapping("/comment")
    public UUID delete(@RequestBody RequestCommentDeleteDTO requestCommentDeleteDTO){
        return commentService.delete(requestCommentDeleteDTO);
    }



}
