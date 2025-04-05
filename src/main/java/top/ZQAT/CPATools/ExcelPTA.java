package top.ZQAT.CPATools;

import com.alibaba.excel.annotation.ExcelProperty;

public class ExcelPTA {

    @ExcelProperty(value = "学号/邮箱、电话")
    String num;

    @ExcelProperty(value = "姓名/昵称")
    String name;

    @ExcelProperty(value = "总分(200.0)")
    String score;

    @ExcelProperty(value = "耗时(秒)")
    String time;

    public void setNum(String num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public String getTime() {
        return time;
    }
}
