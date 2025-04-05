package top.ZQAT.CPATools;

import com.alibaba.excel.annotation.ExcelProperty;

public class ExcelRank {

    @ExcelProperty(value = "排名",index = 0)
    int rank = -1;
    @ExcelProperty(value = "队伍",index = 1)
    String name;
    @ExcelProperty(value = "队伍总分",index = 2)
    int totalScore = 0;
    @ExcelProperty(value = "总用时",index = 3)
    int totalTime = 0;

    public int getTotalTime() {
        return totalTime;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
