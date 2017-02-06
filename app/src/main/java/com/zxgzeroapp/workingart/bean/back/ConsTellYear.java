package com.zxgzeroapp.workingart.bean.back;

import com.zxgzeroapp.workingart.base.BaseBean;

/**
 * 作者：zxg on 2017/1/17 15:53
 * /*本年运势
 */

public class ConsTellYear extends BaseBean {

    /**
     * name : 白羊座
     * date : 2016年
     * year : 2016
     * resultcode : 200
     * error_code : 0
     * mima : {"info":"变身完成的调整之年","text":"2016年将会是白羊座暂时放缓节奏，开始调整个人生活作息以及细分工作内容的一年。土星 来到射手座对白羊座而言实际属于利好，让你们可以更加客观地看待当下面临的问题，并根据现状调整预 期，为今后相当长一段时间（可能影响未来10年）做好最合适的计划和目...","career":"土星的移位意味着你们的工作重心会有所转移，从前的忙乱筹备已经落实到目标更加明确的层面。对创业者而言，前景目标相对比较明确，只要按预期计划踏踏实实执行下去就可以。你也可以将更多精力投入于长远规划以及专业研究、发行出版、异域涉外等方面去，都会获得行业认可的业绩，在相关行业崭露头角，奠定行业地位。自由职业者则有机会产出一些惊为天人的作品，叫..... ","love":"上半年，木星仍然停留在白羊座的恋爱宫，感情将继续精彩纷呈，尤其容易与旧人擦出火花，展 开异地恋情，同学聚会及老友聚会都是桃花高爆区域，也要小心计划外怀孕。单身人士不乏追求对象，尤其 在3月间可能出现让自己一见钟情的人，但极有可能只是昙花一现的惊心动魄，更像是一场因果牵引的缘分重 聚。4月上旬到中旬则是另一个值得注意的时段，有对象的个人在这两段时间都容.... \t","finance":"上半年木星落在投资宫，会给你们带来很好的偏财运。但年后开始的一个月"}
     */

    private String name;
    private String date;
    private int year;
    private String resultcode;
    private int error_code;
    /**
     * info : 变身完成的调整之年
     * text : 2016年将会是白羊座暂时放缓节奏，开始调整个人生活作息以及细分工作内容的一年。土星 来到射手座对白羊座而言实际属于利好，让你们可以更加客观地看待当下面临的问题，并根据现状调整预 期，为今后相当长一段时间（可能影响未来10年）做好最合适的计划和目...
     * career : 土星的移位意味着你们的工作重心会有所转移，从前的忙乱筹备已经落实到目标更加明确的层面。对创业者而言，前景目标相对比较明确，只要按预期计划踏踏实实执行下去就可以。你也可以将更多精力投入于长远规划以及专业研究、发行出版、异域涉外等方面去，都会获得行业认可的业绩，在相关行业崭露头角，奠定行业地位。自由职业者则有机会产出一些惊为天人的作品，叫.....
     * love : 上半年，木星仍然停留在白羊座的恋爱宫，感情将继续精彩纷呈，尤其容易与旧人擦出火花，展 开异地恋情，同学聚会及老友聚会都是桃花高爆区域，也要小心计划外怀孕。单身人士不乏追求对象，尤其 在3月间可能出现让自己一见钟情的人，但极有可能只是昙花一现的惊心动魄，更像是一场因果牵引的缘分重 聚。4月上旬到中旬则是另一个值得注意的时段，有对象的个人在这两段时间都容....
     * finance : 上半年木星落在投资宫，会给你们带来很好的偏财运。但年后开始的一个月
     */

    private MimaBean mima;

    @Override
    public String toString() {
        return "ConsTellYear{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", resultcode='" + resultcode + '\'' +
                ", error_code=" + error_code +
                ", mima=" + mima +
                "} " + super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public MimaBean getMima() {
        return mima;
    }

    public void setMima(MimaBean mima) {
        this.mima = mima;
    }

    public static class MimaBean {
        private String info;
        private String text;
        private String career;
        private String love;
        private String finance;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCareer() {
            return career;
        }

        public void setCareer(String career) {
            this.career = career;
        }

        public String getLove() {
            return love;
        }

        public void setLove(String love) {
            this.love = love;
        }

        public String getFinance() {
            return finance;
        }

        public void setFinance(String finance) {
            this.finance = finance;
        }
    }
}
