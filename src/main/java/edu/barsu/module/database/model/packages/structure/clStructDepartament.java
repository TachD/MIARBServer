package edu.barsu.module.database.model.packages.structure;

import java.io.Serializable;
import java.util.ArrayList;

public class clStructDepartament implements Serializable {
    private String title;

    private ArrayList<clStructPost> postList;

    public clStructDepartament() {}

    public clStructDepartament(String title, ArrayList<clStructPost> postList) {
        this.title = title;
        this.postList = postList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public final String[] values() {
        String[] postListTitle = new String[postList.size()];

        for (int i = 0; i < postList.size(); ++i)
            postListTitle[i] = postList.get(i).getTitle();

        return postListTitle;
    }

    public final int valueOf(String name) {
        for (int i = 0; i < postList.size(); ++i)
            if (postList.get(i).getTitle().equals(name))
                return i;

        return -1;
    }

    public final clStructPost getPost(int ind) {
        return postList.get(ind);
    }

    public final clStructPost getPost(String name) {
        for (clStructPost post: postList)
            if (post.getTitle().equals(name))
                return post;

        return null;
    }
}
