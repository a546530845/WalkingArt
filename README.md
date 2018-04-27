# WalkingArt
MVP测试
1.主要部分包括imodel,model,mvplistenter,presenter,http,acitvity几个大部分则可以组成<br>
2.代码如下
ILoginModel.java<br>
public interface ILoginModel {
	<T>void getLoginBackBean(RxAppCompatActivity mContext, LoginRequestBean mLoginRequestBean, OnMVPHttpTaskListener<T> mvpHttpTaskListener);
}
