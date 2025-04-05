package top.ZQAT.CPATools;

import java.util.ArrayList;
import java.util.List;

public class Team {
    String name = "";
    List<Person> memberList = new ArrayList<>();
    int totalScore = 0;
    int totalTime = 0;
    int rank = -1;
    boolean xgy = false;


    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        Team t = (Team) obj;
        return t.name.equals(name);
    }
}
