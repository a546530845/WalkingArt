package com.zxgzeroapp.workingart.bean.back;

/**
 * 作者：zxg on 2017/1/17 15:49
 * /*本月运势
 */

public class ConsTellMonth {

    /**
     * date : 2016年12月
     * name : 白羊座
     * all : 本月运势有两个重要的节点，一个是在上旬，水星进入事业宫，更加关注事业发展，目标性加 强；而金星随之离开事业宫，原先的经验不能再为你赢得加分，反而是人脉上。。。
     * happyMagic :
     * health : 上旬和中旬，运动能量高，适合开展锻炼计划，尤其是练习耐力的运动。下旬，水逆开启，出行要小心意外了。
     * love : 现实的比较太累，你更喜欢朋友式的轻松相处，如果和爱人之间做不到，你会更眷恋友人的陪伴。因而本月“友情已达，恋人未满”的状况，会有更大的发生几率。
     * money : 人际生财，多往人气旺的地方是有利打听到财富资讯，广开财路的。虽然人际开销也会增多 ，但可以当做是投资。
     * month : 12
     * work : 本月的目标性和计划性都很强，两个阶段的区别在于行动力。上旬和中旬，行动力分散，下旬，行动力足够，但受水逆影响，意外多。
     * resultcode : 200
     * error_code : 0
     */

    private String date;
    private String name;
    private String all;
    private String happyMagic;
    private String health;
    private String love;
    private String money;
    private int month;
    private String work;
    private String resultcode;
    private int error_code;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getHappyMagic() {
        return happyMagic;
    }

    public void setHappyMagic(String happyMagic) {
        this.happyMagic = happyMagic;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
