package top.ZQAT.CPATools;

import com.alibaba.excel.annotation.ExcelProperty;

public class ExcelReward {
    @ExcelProperty(value = "排名",index = 0)
    int rank;
    @ExcelProperty(value = "学号",index = 1)
    String num;
    @ExcelProperty(value = "姓名",index = 2)
    String name;

    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
