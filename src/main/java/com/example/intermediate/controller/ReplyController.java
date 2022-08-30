package com.example.intermediate.controller;

import com.example.intermediate.controller.request.ReplyRequestDto;
import com.example.intermediate.controller.response.ResponseDto;
import com.example.intermediate.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Validated
@RequiredArgsConstructor
@RestController
public class ReplyController {
    private final ReplyService replyService;

    @RequestMapping(value = "/api/auth/reply", method = RequestMethod.POST)
    public ResponseDto<?> createReply(@RequestBody ReplyRequestDto requestDto,
                                        HttpServletRequest request) {
        return replyService.createReply(requestDto, request);
    }

    @RequestMapping(value = "/api/reply/{id}", method = RequestMethod.GET)
    public ResponseDto<?> getAllReply(@PathVariable Long id) {

        return replyService.getAllReplysByComment(id);
    }

    @RequestMapping(value = "/api/auth/reply/{id}", method = RequestMethod.PUT)
    public ResponseDto<?> updateReply(@PathVariable Long id, @RequestBody ReplyRequestDto requestDto,
                                        HttpServletRequest request) {
        return replyService.updateReply(id, requestDto, request);
    }

    @RequestMapping(value = "/api/auth/reply/{id}", method = RequestMethod.DELETE)
    public ResponseDto<?> deleteReply(@PathVariable Long id,
                                        HttpServletRequest request) {
        return replyService.deleteReply(id, request);
    }
}
