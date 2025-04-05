package top.ZQAT.CPATools;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadDMKJ {
    static String filename = "G:\\活动参与名单导出（个人） (5).xls";

    public static List<Person> read(){
        List<Person> personList = new ArrayList<>();
        EasyExcel.read(filename,ExcelDMKJ.class, new ReadListener<ExcelDMKJ>() {
            @Override
            public void invoke(ExcelDMKJ ep, AnalysisContext analysisContext) {
                Person p = new Person();
                p.num = ep.num;
                p.name = ep.name;
                personList.add(p);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet().headRowNumber(1).doRead();

        return personList;
    }

    public static void read(List<Person> personList){
        EasyExcel.read(filename,ExcelDMKJ.class, new ReadListener<ExcelDMKJ>() {
            @Override
            public void invoke(ExcelDMKJ ep, AnalysisContext analysisContext) {
                Person p = find(personList,ep.name,ep.num);
                if(p == null) return;
                p.clas = ep.getClas();
//                System.out.println("name = " + ep.name + " num = " + ep.num);
                if(ep.getCollege().equals("信息工程学院")) p.xgy = true;
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet().headRowNumber(1).doRead();
    }

    static Person find(List<Person> personList, String name,String num){
        for(Person p : personList){
            if(p.name.equals(name) && p.num.equals(num)){
                return p;
            }
        }
        return null;
    }
}
