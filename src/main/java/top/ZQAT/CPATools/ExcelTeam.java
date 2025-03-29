package top.ZQAT.CPATools;

import com.alibaba.excel.annotation.ExcelProperty;

public class ExcelTeam {
    @ExcelProperty(value = "队名")
    String teamname;
    @ExcelProperty(value = "学号")
    String num;
    @ExcelProperty(value = "姓名")
    String name;

    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }
}
