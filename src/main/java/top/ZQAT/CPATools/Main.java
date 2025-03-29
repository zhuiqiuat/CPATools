package top.ZQAT.CPATools;

import com.alibaba.excel.EasyExcel;

import java.util.*;


public class Main {

    public static void main(String[] args){
        checkDMKJ(); // 检查到梦空间与组队表
//        ReadTeam.read();
    }

    public static void checkDMKJ(){
        List<Person> personList = ReadDMKJ.read();
        List<Team> teams = ReadTeam.read(personList);
        List<Team> endteams = new ArrayList<>();
        for(Team t : teams){
            if(t.memberList.size() == 5){
                endteams.add(t);
            }
        }
        System.out.println("team size = " + teams.size());
        System.out.println("end team size = " + endteams.size());
        List<ExcelMember> end = new ArrayList<>();
        for(Team t : endteams){
            for(Person p : t.memberList){
                ExcelMember em = new ExcelMember();
                em.setTeamname(t.name);
                em.setName(p.name);
                em.setNum(p.num);
                end.add(em);
            }
        }
        String outfile = "G:\\通过名单.xlsx";
        EasyExcel.write(outfile,ExcelMember.class).sheet("通过名单").doWrite(end);
    }
}
