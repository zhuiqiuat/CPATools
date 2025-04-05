package top.ZQAT.CPATools;

public class Person {
    String num = "";
    String name = "";
    String teamName = "";
    String clas = "";
    int score = 0;
    int time = 0;
    boolean reward = false; // 有没有拿奖
    boolean credit = false; // 能不能拿入围分
    boolean xgy = false;
    int rank = -1;

    @Override
    public boolean equals(Object obj) {
        Person p = (Person) obj;
        return p.name.equals(this.name) && p.num.equals(this.num);
    }
}
