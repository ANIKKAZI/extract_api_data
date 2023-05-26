package data_processing;

public class ArticleObject {
    String title;

    /**
     * @return title
     */

    public String getTitle() {
        return title;
    }
    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return content
     */    public String getContent() {
        return content;
    }

    String content ;
}
