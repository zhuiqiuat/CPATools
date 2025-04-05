package top.ZQAT.CPATools;

import com.alibaba.excel.EasyExcel;

import java.util.*;


public class Main {

    public static void main(String[] args){
//        checkDMKJ(); // 检查到梦空间与组队表
//        ReadTeam.read();
        calculateRank();
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

    public static void calculateRank(){
        List<Person> personList = ReadPTA.read();
        ReadDMKJ.read(personList);
        List<Team> teamList = ReadTeam.read2(personList);
        List<Team> xgyteamList = new ArrayList<>();
        List<Team> otherteamList = new ArrayList<>();
        for(Team t : teamList){
            boolean flag = false;
            for(Person p : t.memberList){
                flag = p.xgy;
                if(flag) break;
            }
            if(flag) xgyteamList.add(t);
            else otherteamList.add(t);
        }
        System.out.println("total = " + teamList.size());
        System.out.println("xgy = " + xgyteamList.size());
        System.out.println("other = " + otherteamList.size());
        xgyteamList.sort(new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                if(o1.totalScore != o2.totalScore){
                    return o2.totalScore - o1.totalScore;
                }else if(o1.totalTime != o2.totalTime){
                    return o1.totalTime - o2.totalTime;
                }else{
                    return -1;
                }
            }
        });
        otherteamList.sort(new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                if(o1.totalScore != o2.totalScore){
                    return o2.totalScore - o1.totalScore;
                }else if(o1.totalTime != o2.totalTime){
                    return o1.totalTime - o2.totalTime;
                }else{
                    return -1;
                }
            }
        });
//        teamList.sort(new Comparator<Team>() {
//            @Override
//            public int compare(Team o1, Team o2) {
//                if(o1.totalScore != o2.totalScore){
//                    return o2.totalScore - o1.totalScore;
//                }else if(o1.totalTime != o2.totalTime){
//                    return o1.totalTime - o2.totalTime;
//                }else{
//                    return -1;
//                }
//            }
//        });
//        List<ExcelRank> endrank = new ArrayList<>();
//        int rank = 1;
//        for(Team t : teamList){
//            t.rank = rank++;
//            ExcelRank er = new ExcelRank();
//            er.rank = t.rank;
//            er.name = t.name;
//            er.totalScore = t.totalScore;
//            er.totalTime = t.totalTime;
//            endrank.add(er);
//        }
        int rank = 1;
//        System.out.println("信工院排名:");
        for(Team t : xgyteamList){
            t.rank = rank++;
            if(t.rank <= 11){
                for(Person p : t.memberList){
                    if(p.score * 100 / t.totalScore >= 10){
                        p.reward = true;
                        p.rank = t.rank;
                    }
                }
            }
//            System.out.println(t.rank + " - team = " + t.name + " score = " + t.totalScore + " time = " + t.totalTime);
        }
//        System.out.println("外院排名:");
        int rank2 = 1;
        for(Team t : otherteamList){
            t.rank = rank2++;
            if(t.rank <= 11){
                for(Person p : t.memberList){
                    if(p.score * 100 / t.totalScore >= 10){
                        p.reward = true;
                        p.rank = t.rank;
                    }
                }
            }
//            System.out.println(t.rank + " - team = " + t.name + " score = " + t.totalScore + " time = " + t.totalTime);
        }
        List<ExcelCredit> creditList = new ArrayList<>();
        List<ExcelReward> rewardList = new ArrayList<>();
        for(Person p : personList){
            if(p.reward){
                ExcelReward er = new ExcelReward();
                er.setName(p.name);
                er.setNum(p.num);
                if(p.rank > 2){
                    if(p.rank == 3) er.setRank(2);
                    else if(p.rank >= 4 && p.rank <= 6) er.setRank(3);
                    else er.setRank(4);
                }else{
                    er.setRank(p.rank);
                }
                rewardList.add(er);
            }else if(p.credit){
                ExcelCredit ec = new ExcelCredit();
                ec.setClas(p.clas);
                ec.setName(p.name);
                ec.setNum(p.num);
                creditList.add(ec);
            }
        }
        creditList.sort(new Comparator<ExcelCredit>() {
            @Override
            public int compare(ExcelCredit o1, ExcelCredit o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        String creditfile = "G:\\入围名单.xlsx";
        EasyExcel.write(creditfile,ExcelCredit.class).sheet("入围名单").doWrite(creditList);
        String rewardfile = "G:\\颁奖名单.xlsx";
        EasyExcel.write(rewardfile,ExcelReward.class).sheet("颁奖名单").doWrite(rewardList);
    }
}
