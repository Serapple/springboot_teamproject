package com.example.intermediate.domain;

import com.example.intermediate.controller.request.ReplyRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reply extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "member_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @JoinColumn(name = "post_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @JoinColumn(name = "comment_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Comment comment;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private long replyLikeCount;

    public void update(ReplyRequestDto requestDto){
        this.content = requestDto.getContent();
    }

    public boolean validateMember(Member member){
        return !this.member.equals(member);
    }
    public long pluslikecount(){
        return replyLikeCount++;
    }

    public long minuslikecount(){return replyLikeCount--; }

}
