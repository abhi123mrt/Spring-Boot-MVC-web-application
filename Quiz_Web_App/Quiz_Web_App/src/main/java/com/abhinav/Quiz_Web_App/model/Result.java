package com.abhinav.Quiz_Web_App.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String category;
    private int total_question;
    private int attempted;
    private int correct_answer;
    private int wrong_answer;
    private int score;

    public Result(){

    }

    public Result(int id, String username, String category, int total_question, int attempted, int correct_answer, int wrong_answer, int score) {
        this.id = id;
        this.username = username;
        this.category = category;
        this.total_question = total_question;
        this.attempted = attempted;
        this.correct_answer = correct_answer;
        this.wrong_answer = wrong_answer;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotal_question() {
        return total_question;
    }

    public void setTotal_question(int total_question) {
        this.total_question = total_question;
    }

    public int getAttempted() {
        return attempted;
    }

    public void setAttempted(int attempted) {
        this.attempted = attempted;
    }

    public int getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(int correct_answer) {
        this.correct_answer = correct_answer;
    }

    public int getWrong_answer() {
        return wrong_answer;
    }

    public void setWrong_answer(int wrong_answer) {
        this.wrong_answer = wrong_answer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", category='" + category + '\'' +
                ", total_question=" + total_question +
                ", attempted=" + attempted +
                ", correct_answer=" + correct_answer +
                ", wrong_answer=" + wrong_answer +
                ", score=" + score +
                '}';
    }
}
