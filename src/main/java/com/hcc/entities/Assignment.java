package com.hcc.entities;

import javax.persistence.*;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "number")
    private Integer number;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "branch")
    private String branch;

    @Column(name = "code_review_video_url")
    private String codeReviewVideoUrl;

    @ManyToOne
    private User user;

    public Assignment(String status, Integer number, String githubUrl,
                      String branch, String codeReviewVideoUrl, User user) {
        this.status = status;
        this.number = number;
        this.githubUrl = githubUrl;
        this.branch = branch;
        this.codeReviewVideoUrl = codeReviewVideoUrl;
        this.user = user;
    }

    public Assignment() {
    }
}
