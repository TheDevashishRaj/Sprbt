package com.diskord.diskord.model;

public class Reaction {
    private int messageId;
    private int reactionId;
    private String reaction;
    private int reactedBy;

    // Getters and Setters
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getReactionId() {
        return reactionId;
    }

    public void setReactionId(int reactionId) {
        this.reactionId = reactionId;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public int getReactedBy() {
        return reactedBy;
    }

    @Override
    public String toString() {
        return "Reaction [messageId=" + messageId + ", reactionId=" + reactionId + ", reaction=" + reaction
                + ", reactedBy=" + reactedBy + "]";
    }

    public void setReactedBy(int reactedBy) {
        this.reactedBy = reactedBy;
    }
}