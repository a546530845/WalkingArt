package com.zxgzeroapp.workingart.mvplistener;

/**
 * 一般数据请求
 * @param <T>
 */
public interface OnHttpTaskListener<T> {
	/**
	 * 执行Http Task前的预处理
	 */
	public void onPreTask();

	/**
	 * Http Task出现错误
	 */
	public void onTaskError(Throwable throwable);

	/**
	 * Http Task成功执行结束
	 * 
	 */
	public void onSuccessTask(T bean);
	public void onFinishTask();
	public void onCancel();
	
}
