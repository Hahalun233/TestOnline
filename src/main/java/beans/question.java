package beans;

public class question {
    private int question_id;
    private String question_type;//题型
    private String question_level;//难度
    private String question_chapter;//章节
    private String question_stem;//题干
    private String question_answer;//答案
    private String question_subject;//科目

    @Override
    public String toString() {
        return "question{" +
                "question_id=" + question_id +
                ", question_type='" + question_type + '\'' +
                ", question_level='" + question_level + '\'' +
                ", question_chapter='" + question_chapter + '\'' +
                ", question_stem='" + question_stem + '\'' +
                ", question_answer='" + question_answer + '\'' +
                ", question_subject='" + question_subject + '\'' +
                '}';
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_type() {
        return question_type;
    }

    public void setQuestion_type(String question_type) {
        this.question_type = question_type;
    }

    public String getQuestion_level() {
        return question_level;
    }

    public void setQuestion_level(String question_level) {
        this.question_level = question_level;
    }

    public String getQuestion_chapter() {
        return question_chapter;
    }

    public void setQuestion_chapter(String question_chapter) {
        this.question_chapter = question_chapter;
    }

    public String getQuestion_stem() {
        return question_stem;
    }

    public void setQuestion_stem(String question_stem) {
        this.question_stem = question_stem;
    }

    public String getQuestion_answer() {
        return question_answer;
    }

    public void setQuestion_answer(String question_answer) {
        this.question_answer = question_answer;
    }


    public String getQuestion_subject() {
        return question_subject;
    }

    public void setQuestion_subject(String question_subject) {
        this.question_subject = question_subject;
    }
}
