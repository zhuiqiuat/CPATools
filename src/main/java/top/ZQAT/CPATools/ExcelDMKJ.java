package top.ZQAT.CPATools;

import com.alibaba.excel.annotation.ExcelProperty;

public class ExcelDMKJ {
    @ExcelProperty(value = "姓名")
    String name;
    @ExcelProperty(value = "学号")
    String num;

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(String num) {
        this.num = num;
    }

}
