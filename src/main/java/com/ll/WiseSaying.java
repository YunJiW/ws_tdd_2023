package com.ll;

public class WiseSaying {
    long num;
    String authorName;
    String content;

    public WiseSaying(long num, String authorName, String content) {
        this.num = num;
        this.authorName = authorName;
        this.content = content;
    }

    public long getNum() {
        return num;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getContent() {
        return content;
    }
}
