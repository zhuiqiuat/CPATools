package top.ZQAT.CPATools;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadDMKJ {

    public static List<Person> read(){
        List<Person> personList = new ArrayList<>();
        String filename = "G:\\活动参与名单导出（个人） (1).xls";
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
}
