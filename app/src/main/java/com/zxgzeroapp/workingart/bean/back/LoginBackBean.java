package com.zxgzeroapp.workingart.bean.back;


import com.zxgzeroapp.workingart.base.BaseBean;

import java.util.List;

/**
 * 作者：zxg on 2016/9/30 14:15
 * 登录返回bean
 */


public class LoginBackBean extends BaseBean {


    /**
     * id : 2
     * msuUserType : 1
     * msuMsId : 2
     * msuUserName : shop001
     * msuUserPassword : 4QrcOUm6Wau+VuBX8g+IPg==
     * msuUserMobile : 18612596130
     * msuUserStatus : 1
     * msuLastLogintime : 1479366998676
     * msuLastLoginaddress : 192.168.1.103
     * msuCreateTime : 1474976382000
     * msuCreator : admin
     * shopMemberVo : {"id":2,"msShopCode":"S002","msShopRegName":"望湘园餐饮连锁有限公司","msShopBusinessName":"望湘园12","msShopShortName":"望湘园","msShopLevel":"2","msMcId":4,"msEstateId":203,"msOpenDate":1474560000000,"msBusinessType":"1","msMccCode":"2","msRegistrationFile":"00D816299D9145AF9855894E1555CB45","msStatus":"1","msMaster":"李四","msMasterPhone":"0757-6598365","msMasterMobile":"13012345001","msMasterEmail":"","msMasterIdentifi":"360733198510012525","msMasterIdentifi1":"","msMasterIdentifi0":"","msFinanceMaster":"","msFinanceMasterMobile":"13916846301","msFinanceMasterEmail":"","msAcBank":"","msAcPerson":"","msAcType":"","msAcAccount":"","msCreateTime":1474630018000,"msCreator":"admin","msLastUpdatedTime":1479112116000,"msLastUpdatedOperator":"01","msRemark":"","headUrl":"http://192.168.1.118:8888/file-provider/upload/pos/D4FE3B54537340999975DB3869105BFB.jpg","payCodeUrl":"http://192.168.1.118:8888/file-provider/upload/pos/EDAF61FE06684B8C879E4D0160796A00.jpg"}
     * shopVos : [{"id":23,"sMsId":2,"sBunk":"A2","sRentalStart":"","sRentalEnd":"","sShopArean":"","sRent":"","sContractFile":"","sShopStatus":"","sCreateTime":1476927100000,"sCreator":"admin","sLastUpdatedTime":1478135644000,"sLastUpdatedOperator":"01"}]
     * firstLogin : false
     * msuName : 陈永远
     */

    private SubjectBean subject;

    public SubjectBean getSubject() {
        return subject;
    }

    public void setSubject(SubjectBean subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "LoginBackBean{" +
                "subject=" + subject +
                "} " + super.toString();
    }

    public static class SubjectBean {
        private int id;
        private String msuUserType;
        private int msuMsId;
        private String msuUserName;
        private String msuUserPassword;
        private String msuUserMobile;
        private String msuUserStatus;
        private long msuLastLogintime;
        private String msuLastLoginaddress;
        private long msuCreateTime;
        private String msuCreator;
        /**
         * id : 2
         * msShopCode : S002
         * msShopRegName : 望湘园餐饮连锁有限公司
         * msShopBusinessName : 望湘园12
         * msShopShortName : 望湘园
         * msShopLevel : 2
         * msMcId : 4
         * msEstateId : 203
         * msOpenDate : 1474560000000
         * msBusinessType : 1
         * msMccCode : 2
         * msRegistrationFile : 00D816299D9145AF9855894E1555CB45
         * msStatus : 1
         * msMaster : 李四
         * msMasterPhone : 0757-6598365
         * msMasterMobile : 13012345001
         * msMasterEmail :
         * msMasterIdentifi : 360733198510012525
         * msMasterIdentifi1 :
         * msMasterIdentifi0 :
         * msFinanceMaster :
         * msFinanceMasterMobile : 13916846301
         * msFinanceMasterEmail :
         * msAcBank :
         * msAcPerson :
         * msAcType :
         * msAcAccount :
         * msCreateTime : 1474630018000
         * msCreator : admin
         * msLastUpdatedTime : 1479112116000
         * msLastUpdatedOperator : 01
         * msRemark :
         * headUrl : http://192.168.1.118:8888/file-provider/upload/pos/D4FE3B54537340999975DB3869105BFB.jpg
         * payCodeUrl : http://192.168.1.118:8888/file-provider/upload/pos/EDAF61FE06684B8C879E4D0160796A00.jpg
         */

        private ShopMemberVoBean shopMemberVo;
        private boolean firstLogin;
        private String msuName;

        @Override
        public String toString() {
            return "SubjectBean{" +
                    "firstLogin=" + firstLogin +
                    ", id=" + id +
                    ", msuUserType='" + msuUserType + '\'' +
                    ", msuMsId=" + msuMsId +
                    ", msuUserName='" + msuUserName + '\'' +
                    ", msuUserPassword='" + msuUserPassword + '\'' +
                    ", msuUserMobile='" + msuUserMobile + '\'' +
                    ", msuUserStatus='" + msuUserStatus + '\'' +
                    ", msuLastLogintime=" + msuLastLogintime +
                    ", msuLastLoginaddress='" + msuLastLoginaddress + '\'' +
                    ", msuCreateTime=" + msuCreateTime +
                    ", msuCreator='" + msuCreator + '\'' +
                    ", shopMemberVo=" + shopMemberVo +
                    ", msuName='" + msuName + '\'' +
                    ", shopVos=" + shopVos +
                    '}';
        }

        /**
         * id : 23
         * sMsId : 2
         * sBunk : A2
         * sRentalStart :
         * sRentalEnd :
         * sShopArean :
         * sRent :
         * sContractFile :
         * sShopStatus :
         * sCreateTime : 1476927100000
         * sCreator : admin
         * sLastUpdatedTime : 1478135644000
         * sLastUpdatedOperator : 01
         */

        private List<ShopVosBean> shopVos;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMsuUserType() {
            return msuUserType;
        }

        public void setMsuUserType(String msuUserType) {
            this.msuUserType = msuUserType;
        }

        public int getMsuMsId() {
            return msuMsId;
        }

        public void setMsuMsId(int msuMsId) {
            this.msuMsId = msuMsId;
        }

        public String getMsuUserName() {
            return msuUserName;
        }

        public void setMsuUserName(String msuUserName) {
            this.msuUserName = msuUserName;
        }

        public String getMsuUserPassword() {
            return msuUserPassword;
        }

        public void setMsuUserPassword(String msuUserPassword) {
            this.msuUserPassword = msuUserPassword;
        }

        public String getMsuUserMobile() {
            return msuUserMobile;
        }

        public void setMsuUserMobile(String msuUserMobile) {
            this.msuUserMobile = msuUserMobile;
        }

        public String getMsuUserStatus() {
            return msuUserStatus;
        }

        public void setMsuUserStatus(String msuUserStatus) {
            this.msuUserStatus = msuUserStatus;
        }

        public long getMsuLastLogintime() {
            return msuLastLogintime;
        }

        public void setMsuLastLogintime(long msuLastLogintime) {
            this.msuLastLogintime = msuLastLogintime;
        }

        public String getMsuLastLoginaddress() {
            return msuLastLoginaddress;
        }

        public void setMsuLastLoginaddress(String msuLastLoginaddress) {
            this.msuLastLoginaddress = msuLastLoginaddress;
        }

        public long getMsuCreateTime() {
            return msuCreateTime;
        }

        public void setMsuCreateTime(long msuCreateTime) {
            this.msuCreateTime = msuCreateTime;
        }

        public String getMsuCreator() {
            return msuCreator;
        }

        public void setMsuCreator(String msuCreator) {
            this.msuCreator = msuCreator;
        }

        public ShopMemberVoBean getShopMemberVo() {
            return shopMemberVo;
        }

        public void setShopMemberVo(ShopMemberVoBean shopMemberVo) {
            this.shopMemberVo = shopMemberVo;
        }

        public boolean isFirstLogin() {
            return firstLogin;
        }

        public void setFirstLogin(boolean firstLogin) {
            this.firstLogin = firstLogin;
        }

        public String getMsuName() {
            return msuName;
        }

        public void setMsuName(String msuName) {
            this.msuName = msuName;
        }

        public List<ShopVosBean> getShopVos() {
            return shopVos;
        }

        public void setShopVos(List<ShopVosBean> shopVos) {
            this.shopVos = shopVos;
        }

        public static class ShopMemberVoBean {
            private int id;
            private String msShopCode;
            private String msShopRegName;
            private String msShopBusinessName;
            private String msShopShortName;
            private String msShopLevel;
            private int msMcId;
            private int msEstateId;
            private long msOpenDate;
            private String msBusinessType;
            private String msMccCode;
            private String msRegistrationFile;
            private String msStatus;
            private String msMaster;
            private String msMasterPhone;
            private String msMasterMobile;
            private String msMasterEmail;
            private String msMasterIdentifi;
            private String msMasterIdentifi1;
            private String msMasterIdentifi0;
            private String msFinanceMaster;
            private String msFinanceMasterMobile;
            private String msFinanceMasterEmail;
            private String msAcBank;
            private String msAcPerson;
            private String msAcType;
            private String msAcAccount;
            private long msCreateTime;
            private String msCreator;
            private long msLastUpdatedTime;
            private String msLastUpdatedOperator;
            private String msRemark;
            private String headUrl;
            private String payCodeUrl;

            @Override
            public String toString() {
                return "ShopMemberVoBean{" +
                        "headUrl='" + headUrl + '\'' +
                        ", id=" + id +
                        ", msShopCode='" + msShopCode + '\'' +
                        ", msShopRegName='" + msShopRegName + '\'' +
                        ", msShopBusinessName='" + msShopBusinessName + '\'' +
                        ", msShopShortName='" + msShopShortName + '\'' +
                        ", msShopLevel='" + msShopLevel + '\'' +
                        ", msMcId=" + msMcId +
                        ", msEstateId=" + msEstateId +
                        ", msOpenDate=" + msOpenDate +
                        ", msBusinessType='" + msBusinessType + '\'' +
                        ", msMccCode='" + msMccCode + '\'' +
                        ", msRegistrationFile='" + msRegistrationFile + '\'' +
                        ", msStatus='" + msStatus + '\'' +
                        ", msMaster='" + msMaster + '\'' +
                        ", msMasterPhone='" + msMasterPhone + '\'' +
                        ", msMasterMobile='" + msMasterMobile + '\'' +
                        ", msMasterEmail='" + msMasterEmail + '\'' +
                        ", msMasterIdentifi='" + msMasterIdentifi + '\'' +
                        ", msMasterIdentifi1='" + msMasterIdentifi1 + '\'' +
                        ", msMasterIdentifi0='" + msMasterIdentifi0 + '\'' +
                        ", msFinanceMaster='" + msFinanceMaster + '\'' +
                        ", msFinanceMasterMobile='" + msFinanceMasterMobile + '\'' +
                        ", msFinanceMasterEmail='" + msFinanceMasterEmail + '\'' +
                        ", msAcBank='" + msAcBank + '\'' +
                        ", msAcPerson='" + msAcPerson + '\'' +
                        ", msAcType='" + msAcType + '\'' +
                        ", msAcAccount='" + msAcAccount + '\'' +
                        ", msCreateTime=" + msCreateTime +
                        ", msCreator='" + msCreator + '\'' +
                        ", msLastUpdatedTime=" + msLastUpdatedTime +
                        ", msLastUpdatedOperator='" + msLastUpdatedOperator + '\'' +
                        ", msRemark='" + msRemark + '\'' +
                        ", payCodeUrl='" + payCodeUrl + '\'' +
                        '}';
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMsShopCode() {
                return msShopCode;
            }

            public void setMsShopCode(String msShopCode) {
                this.msShopCode = msShopCode;
            }

            public String getMsShopRegName() {
                return msShopRegName;
            }

            public void setMsShopRegName(String msShopRegName) {
                this.msShopRegName = msShopRegName;
            }

            public String getMsShopBusinessName() {
                return msShopBusinessName;
            }

            public void setMsShopBusinessName(String msShopBusinessName) {
                this.msShopBusinessName = msShopBusinessName;
            }

            public String getMsShopShortName() {
                return msShopShortName;
            }

            public void setMsShopShortName(String msShopShortName) {
                this.msShopShortName = msShopShortName;
            }

            public String getMsShopLevel() {
                return msShopLevel;
            }

            public void setMsShopLevel(String msShopLevel) {
                this.msShopLevel = msShopLevel;
            }

            public int getMsMcId() {
                return msMcId;
            }

            public void setMsMcId(int msMcId) {
                this.msMcId = msMcId;
            }

            public int getMsEstateId() {
                return msEstateId;
            }

            public void setMsEstateId(int msEstateId) {
                this.msEstateId = msEstateId;
            }

            public long getMsOpenDate() {
                return msOpenDate;
            }

            public void setMsOpenDate(long msOpenDate) {
                this.msOpenDate = msOpenDate;
            }

            public String getMsBusinessType() {
                return msBusinessType;
            }

            public void setMsBusinessType(String msBusinessType) {
                this.msBusinessType = msBusinessType;
            }

            public String getMsMccCode() {
                return msMccCode;
            }

            public void setMsMccCode(String msMccCode) {
                this.msMccCode = msMccCode;
            }

            public String getMsRegistrationFile() {
                return msRegistrationFile;
            }

            public void setMsRegistrationFile(String msRegistrationFile) {
                this.msRegistrationFile = msRegistrationFile;
            }

            public String getMsStatus() {
                return msStatus;
            }

            public void setMsStatus(String msStatus) {
                this.msStatus = msStatus;
            }

            public String getMsMaster() {
                return msMaster;
            }

            public void setMsMaster(String msMaster) {
                this.msMaster = msMaster;
            }

            public String getMsMasterPhone() {
                return msMasterPhone;
            }

            public void setMsMasterPhone(String msMasterPhone) {
                this.msMasterPhone = msMasterPhone;
            }

            public String getMsMasterMobile() {
                return msMasterMobile;
            }

            public void setMsMasterMobile(String msMasterMobile) {
                this.msMasterMobile = msMasterMobile;
            }

            public String getMsMasterEmail() {
                return msMasterEmail;
            }

            public void setMsMasterEmail(String msMasterEmail) {
                this.msMasterEmail = msMasterEmail;
            }

            public String getMsMasterIdentifi() {
                return msMasterIdentifi;
            }

            public void setMsMasterIdentifi(String msMasterIdentifi) {
                this.msMasterIdentifi = msMasterIdentifi;
            }

            public String getMsMasterIdentifi1() {
                return msMasterIdentifi1;
            }

            public void setMsMasterIdentifi1(String msMasterIdentifi1) {
                this.msMasterIdentifi1 = msMasterIdentifi1;
            }

            public String getMsMasterIdentifi0() {
                return msMasterIdentifi0;
            }

            public void setMsMasterIdentifi0(String msMasterIdentifi0) {
                this.msMasterIdentifi0 = msMasterIdentifi0;
            }

            public String getMsFinanceMaster() {
                return msFinanceMaster;
            }

            public void setMsFinanceMaster(String msFinanceMaster) {
                this.msFinanceMaster = msFinanceMaster;
            }

            public String getMsFinanceMasterMobile() {
                return msFinanceMasterMobile;
            }

            public void setMsFinanceMasterMobile(String msFinanceMasterMobile) {
                this.msFinanceMasterMobile = msFinanceMasterMobile;
            }

            public String getMsFinanceMasterEmail() {
                return msFinanceMasterEmail;
            }

            public void setMsFinanceMasterEmail(String msFinanceMasterEmail) {
                this.msFinanceMasterEmail = msFinanceMasterEmail;
            }

            public String getMsAcBank() {
                return msAcBank;
            }

            public void setMsAcBank(String msAcBank) {
                this.msAcBank = msAcBank;
            }

            public String getMsAcPerson() {
                return msAcPerson;
            }

            public void setMsAcPerson(String msAcPerson) {
                this.msAcPerson = msAcPerson;
            }

            public String getMsAcType() {
                return msAcType;
            }

            public void setMsAcType(String msAcType) {
                this.msAcType = msAcType;
            }

            public String getMsAcAccount() {
                return msAcAccount;
            }

            public void setMsAcAccount(String msAcAccount) {
                this.msAcAccount = msAcAccount;
            }

            public long getMsCreateTime() {
                return msCreateTime;
            }

            public void setMsCreateTime(long msCreateTime) {
                this.msCreateTime = msCreateTime;
            }

            public String getMsCreator() {
                return msCreator;
            }

            public void setMsCreator(String msCreator) {
                this.msCreator = msCreator;
            }

            public long getMsLastUpdatedTime() {
                return msLastUpdatedTime;
            }

            public void setMsLastUpdatedTime(long msLastUpdatedTime) {
                this.msLastUpdatedTime = msLastUpdatedTime;
            }

            public String getMsLastUpdatedOperator() {
                return msLastUpdatedOperator;
            }

            public void setMsLastUpdatedOperator(String msLastUpdatedOperator) {
                this.msLastUpdatedOperator = msLastUpdatedOperator;
            }

            public String getMsRemark() {
                return msRemark;
            }

            public void setMsRemark(String msRemark) {
                this.msRemark = msRemark;
            }

            public String getHeadUrl() {
                return headUrl;
            }

            public void setHeadUrl(String headUrl) {
                this.headUrl = headUrl;
            }

            public String getPayCodeUrl() {
                return payCodeUrl;
            }

            public void setPayCodeUrl(String payCodeUrl) {
                this.payCodeUrl = payCodeUrl;
            }
        }

        public static class ShopVosBean {
            private int id;
            private int sMsId;
            private String sBunk;
            private String sRentalStart;
            private String sRentalEnd;
            private String sShopArean;
            private String sRent;
            private String sContractFile;
            private String sShopStatus;
            private long sCreateTime;
            private String sCreator;
            private long sLastUpdatedTime;
            private String sLastUpdatedOperator;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSMsId() {
                return sMsId;
            }

            public void setSMsId(int sMsId) {
                this.sMsId = sMsId;
            }

            public String getSBunk() {
                return sBunk;
            }

            public void setSBunk(String sBunk) {
                this.sBunk = sBunk;
            }

            public String getSRentalStart() {
                return sRentalStart;
            }

            public void setSRentalStart(String sRentalStart) {
                this.sRentalStart = sRentalStart;
            }

            public String getSRentalEnd() {
                return sRentalEnd;
            }

            public void setSRentalEnd(String sRentalEnd) {
                this.sRentalEnd = sRentalEnd;
            }

            public String getSShopArean() {
                return sShopArean;
            }

            public void setSShopArean(String sShopArean) {
                this.sShopArean = sShopArean;
            }

            public String getSRent() {
                return sRent;
            }

            public void setSRent(String sRent) {
                this.sRent = sRent;
            }

            public String getSContractFile() {
                return sContractFile;
            }

            public void setSContractFile(String sContractFile) {
                this.sContractFile = sContractFile;
            }

            public String getSShopStatus() {
                return sShopStatus;
            }

            public void setSShopStatus(String sShopStatus) {
                this.sShopStatus = sShopStatus;
            }

            public long getSCreateTime() {
                return sCreateTime;
            }

            public void setSCreateTime(long sCreateTime) {
                this.sCreateTime = sCreateTime;
            }

            public String getSCreator() {
                return sCreator;
            }

            public void setSCreator(String sCreator) {
                this.sCreator = sCreator;
            }

            public long getSLastUpdatedTime() {
                return sLastUpdatedTime;
            }

            public void setSLastUpdatedTime(long sLastUpdatedTime) {
                this.sLastUpdatedTime = sLastUpdatedTime;
            }

            @Override
            public String toString() {
                return "ShopVosBean{" +
                        "id=" + id +
                        ", sMsId=" + sMsId +
                        ", sBunk='" + sBunk + '\'' +
                        ", sRentalStart='" + sRentalStart + '\'' +
                        ", sRentalEnd='" + sRentalEnd + '\'' +
                        ", sShopArean='" + sShopArean + '\'' +
                        ", sRent='" + sRent + '\'' +
                        ", sContractFile='" + sContractFile + '\'' +
                        ", sShopStatus='" + sShopStatus + '\'' +
                        ", sCreateTime=" + sCreateTime +
                        ", sCreator='" + sCreator + '\'' +
                        ", sLastUpdatedTime=" + sLastUpdatedTime +
                        ", sLastUpdatedOperator='" + sLastUpdatedOperator + '\'' +
                        '}';
            }

            public String getSLastUpdatedOperator() {
                return sLastUpdatedOperator;
            }

            public void setSLastUpdatedOperator(String sLastUpdatedOperator) {
                this.sLastUpdatedOperator = sLastUpdatedOperator;
            }
        }
    }
}
