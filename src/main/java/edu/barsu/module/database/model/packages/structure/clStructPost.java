package edu.barsu.module.database.model.packages.structure;

import java.io.Serializable;

public class clStructPost implements Serializable {
    private String title;

    private int amount;

    private String rankLimit;

    public clStructPost() {}

    public clStructPost(String title, int amount, String rankLimit) {
        this.title = title;
        this.amount = amount;
        this.rankLimit = rankLimit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getRankLimit() {
        return rankLimit;
    }

    public void setRankLimit(String rankLimit) {
        this.rankLimit = rankLimit;
    }
}
