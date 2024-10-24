package com.diskord.diskord.model;

public class Reply {
    private int replyOf;
    private int repliedTo;

    // Constructors
    public Reply() {}

    public Reply(int replyOf, int repliedTo) {
        this.replyOf = replyOf;
        this.repliedTo = repliedTo;
    }

    // Getters and setters
    public int getReplyOf() {
        return replyOf;
    }

    public void setReplyOf(int replyOf) {
        this.replyOf = replyOf;
    }

    public int getRepliedTo() {
        return repliedTo;
    }

    public void setRepliedTo(int repliedTo) {
        this.repliedTo = repliedTo;
    }
}