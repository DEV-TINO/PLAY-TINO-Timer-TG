package PLAYTINO.commentex.service;

import PLAYTINO.commentex.domain.*;
import PLAYTINO.commentex.repository.JpaCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    JpaCommentRepository jpaCommentRepository;

    @Autowired
    public CommentService(JpaCommentRepository jpaCommentRepository){
        this.jpaCommentRepository = jpaCommentRepository;
    }

    // 댓글 생성
    public UUID join(RequestCommentDTO requestCommentDTO){

        // DTO를 통해서 DAO를 만들어줌
        Comment comment = new Comment();

        // DAO 값 초기화
        comment.setUserId(requestCommentDTO.getUserId());
        comment.setContent(requestCommentDTO.getContent());

        // DAO를 저장
        jpaCommentRepository.save(comment);

        // 만들어진 comment에 PK값 반환
        return comment.getCommentId();
    }

    // 댓글 1개 조회
    public ResponseCommentDTO read(UUID commentId){

        //id를 통해서 comment 객체를 찾아
        // findById -> PK값을 통해서 해당 객체를 찾아서 반환해줌
        Comment comment = jpaCommentRepository.findById(commentId).get();

        // 찾은 객체는 DAO임
        // DAO -> DTO로 변환하는 과정
        ResponseCommentDTO responseCommentDTO = new ResponseCommentDTO();

        // DTO객체 값을 초기화
        responseCommentDTO.setCommentId(comment.getCommentId());
        responseCommentDTO.setUserId(comment.getUserId());
        responseCommentDTO.setContent(comment.getContent());
        responseCommentDTO.setHeartCount(comment.getHeartCount());
        responseCommentDTO.setUploadTime(comment.getUploadTime());

        // 생성된 DTO를 반환
        return responseCommentDTO;
    }

    // 댓글 전체 조회
    @Transactional(readOnly = true)
    public List<ResponseCommentDTO> readAll(){

        //Comment(DAO)로 이루어진 리스트 만듦
        List<Comment> commentList = jpaCommentRepository.findAll();

        //DTO 리스트 생성(new)
        List<ResponseCommentDTO> commentDTOList = new ArrayList<>();

        //for문으로 하나씩 꺼내서 DTO로 변환
        for(Comment comment : commentList){
            // dto 생성
            ResponseCommentDTO responseCommentDTO = new ResponseCommentDTO();

            // dto에다가 dao의 값을 넣어준다
            responseCommentDTO.setCommentId(comment.getCommentId());
            responseCommentDTO.setUserId(comment.getUserId());
            responseCommentDTO.setContent(comment.getContent());
            responseCommentDTO.setHeartCount(comment.getHeartCount());
            responseCommentDTO.setUploadTime(comment.getUploadTime());

            // list에 dto 값을 add 해준다.
            commentDTOList.add(responseCommentDTO);
        }

        //return List(DTO 리스트 반환)
        return commentDTOList;

    }

    //댓글 수정
    public UUID update(RequestCommentUpdateDTO requestCommentUpdateDTO){

        // id를 통해서 DAO 객체를 찾는다
        Comment comment = jpaCommentRepository.findById(requestCommentUpdateDTO.getCommentId()).get();


        //comment.setCommentId(requestCommentUpdateDTO.getCommentId());
        //comment.setUserId(requestCommentUpdateDTO.getUserId());
        // 받은 userId가 DB에 있는 userId와 같은지 확인



        comment.setContent(requestCommentUpdateDTO.getContent());


        jpaCommentRepository.save(comment);

        return comment.getCommentId();
    }

    //댓글 삭제
    public UUID delete(RequestCommentDeleteDTO requestCommentDeleteDTO){

        Comment comment = jpaCommentRepository.findById(requestCommentDeleteDTO.getCommentId()).get();

        jpaCommentRepository.delete(comment);

        return comment.getCommentId();

    }

    //댓글 하트 증가
    public Comment commentHeartUp(RequestCommentDTO requestCommentDTO) {

        // 댓글 아이디 가져오기
        Comment comment = jpaCommentRepository.findById(requestCommentDTO.getCommentId()).get();

        // 아이디의 있는 하트카운트 올리기
        comment.setHeartCount(comment.getHeartCount()+1);

        return comment;
    }

    public Comment commentHeartDown(RequestCommentDTO requestCommentDTO){

        Comment comment = jpaCommentRepository.findById(requestCommentDTO.getCommentId()).get();

        comment.setHeartCount(comment.getHeartCount()-1);

        return comment;
    }

}