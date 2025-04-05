package top.ZQAT.CPATools;

import com.alibaba.excel.annotation.ExcelProperty;

public class ExcelCredit {
    @ExcelProperty(value = "学号",index = 1)
    String num;
    @ExcelProperty(value = "姓名",index = 2)
    String name;
    @ExcelProperty(value = "班级",index = 0)
    String clas;

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public String getClas() {
        return clas;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }
}
