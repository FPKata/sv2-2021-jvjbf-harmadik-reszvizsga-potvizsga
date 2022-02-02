package examinformation;

public class ExamResult {
    private int practice;
    private int theory;

    public ExamResult(int practice, int theory) {
        this.practice = practice;
        this.theory = theory;
    }

    public int getPractice() {
        return practice;
    }

    public int getTheory() {
        return theory;
    }
}
