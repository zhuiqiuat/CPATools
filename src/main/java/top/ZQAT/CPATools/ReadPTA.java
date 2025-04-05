package top.ZQAT.CPATools;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;

import java.util.ArrayList;
import java.util.List;

public class ReadPTA {

    public static List<Person> read(){

        List<Person> personList = new ArrayList<>();
        String filename = "G:\\76d57cb4-3a3b-4aca-b9c5-3b93848a825c.xlsx";
        EasyExcel.read(filename,ExcelPTA.class, new ReadListener<ExcelPTA>() {
            @Override
            public void invoke(ExcelPTA ep, AnalysisContext analysisContext) {
                Person p = new Person();
                p.num = ep.num;
                p.name = ep.name;
                if(ep.score.equals("缺考")){
                    p.score = 0;
                    p.credit = false;
                }else{
                    int score = Integer.parseInt(ep.score);
                    int time = Integer.parseInt(ep.time);
                    if(score > 0){
                        p.credit = true;
                    }
                    p.score = score;
                    p.time = time;
                }
                personList.add(p);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet().headRowNumber(3).doRead();

        return personList;
    }
}
