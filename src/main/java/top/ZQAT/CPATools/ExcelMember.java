package top.ZQAT.CPATools;

import com.alibaba.excel.annotation.ExcelProperty;

public class ExcelMember {

    @ExcelProperty(index = 0,value = "队伍")
    String teamname;
    @ExcelProperty(index = 1,value = "学号")
    String num;
    @ExcelProperty(index = 2,value = "姓名")
    String name;


    public String getTeamname() {
        return teamname;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
