package top.ZQAT.CPATools;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadTeam {

    public static List<Team> read(List<Person> personList){
        List<Team> teams = new ArrayList<>();
        Map<String,Team> mp = new HashMap<>();
        Map<String,Team> mp2 = new HashMap<>();
        Map<Integer,Integer> arr = new HashMap<>();
        Map<Integer,String> names = new HashMap<>();
        Map<Integer,Integer> arr2 = new HashMap<>();
        Map<Integer,String> names2 = new HashMap<>();
        for(int i = 1;i <= 1000;i++){
            arr.put(i,i);
            arr2.put(i,i);
        }
        String filename = "G:\\2025年程序设计团体赛报名表 (2).xlsx";
        EasyExcel.read(filename, ExcelTeam.class, new ReadListener<ExcelTeam>() {
            @Override
            public void invoke(ExcelTeam data, AnalysisContext context) {
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }

            @Override
            public void extra(CellExtra extra, AnalysisContext context) {
                if(extra.getType() == CellExtraTypeEnum.MERGE){
                    int start = extra.getFirstRowIndex();
                    int end = extra.getLastRowIndex();
                    for(int i = start;i <= end;i++){
                        arr.put(i,start);
                    }

                }

            }
        }).extraRead(CellExtraTypeEnum.MERGE).sheet(0).headRowNumber(2).doRead();
        EasyExcel.read(filename, ExcelTeam.class, new ReadListener<ExcelTeam>() {
            @Override
            public void invoke(ExcelTeam data, AnalysisContext context) {
                int row = context.readRowHolder().getRowIndex();
                if(data.teamname != null){
                    names.put(row, data.getTeamname());
                }
                String teamname = names.get(arr.get(row));
                Person p = new Person();
                p.name = data.getName();
                p.num = data.getNum();
                if(!personList.contains(p)) return;
                if(mp.containsKey(teamname) && mp.get(teamname).memberList.size() < 5){
                    mp.get(teamname).memberList.add(p);
                }else{
                    Team t = new Team();
                    t.name = teamname;
                    t.memberList.add(p);
                    teams.add(t);
                    mp.put(teamname,t);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet(0).headRowNumber(2).doRead();
        EasyExcel.read(filename, ExcelTeam.class, new ReadListener<ExcelTeam>() {
            @Override
            public void invoke(ExcelTeam data, AnalysisContext context) {
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }

            @Override
            public void extra(CellExtra extra, AnalysisContext context) {
                if(extra.getType() == CellExtraTypeEnum.MERGE){
                    int start = extra.getFirstRowIndex();
                    int end = extra.getLastRowIndex();
                    for(int i = start;i <= end;i++){
                        arr2.put(i,start);
                    }

                }

            }
        }).extraRead(CellExtraTypeEnum.MERGE).sheet(1).headRowNumber(2).doRead();
        EasyExcel.read(filename, ExcelTeam.class, new ReadListener<ExcelTeam>() {
            @Override
            public void invoke(ExcelTeam data, AnalysisContext context) {
                int row = context.readRowHolder().getRowIndex();
                if(data.teamname != null){
                    names2.put(row, data.getTeamname());
                }
                String teamname = names2.get(arr2.get(row));
                Person p = new Person();
                p.name = data.getName();
                p.num = data.getNum();
                if(!personList.contains(p)) return;
                if(mp2.containsKey(teamname) && mp2.get(teamname).memberList.size() < 5){
                    mp2.get(teamname).memberList.add(p);
                }else{
                    Team t = new Team();
                    t.name = teamname;
                    t.memberList.add(p);
                    teams.add(t);
                    mp2.put(teamname,t);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet(1).headRowNumber(2).doRead();
        return teams;
    }

}
