package top.ZQAT.CPATools;

import com.alibaba.excel.annotation.ExcelProperty;

public class ExcelDMKJ {
    @ExcelProperty(value = "姓名")
    String name;
    @ExcelProperty(value = "学号")
    String num;
    @ExcelProperty(value = "院系")
    String college;
    @ExcelProperty(value = "班级")
    String clas;

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public String getCollege() {
        return college;
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

    public void setCollege(String college) {
        this.college = college;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }
}
