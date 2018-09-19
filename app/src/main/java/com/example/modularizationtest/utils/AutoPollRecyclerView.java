package com.example.modularizationtest.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import java.lang.ref.WeakReference;


/**
 * Author：白树 on 2018/9/5 10:10
 * <p>  自定义滚动适配器
 * Email:  gusumobai@163.com
 */
public class AutoPollRecyclerView extends RecyclerView {

    private static final long TIME_AUTO_POLL = 16;
    AutoPollTask autoPollTask;
    private boolean running; //表示是否正在自动轮询
    private boolean canRun; //表示是否可以自动轮询

    public AutoPollRecyclerView(Context context) {
        super(context);
        autoPollTask = new AutoPollTask(this);
    }

    static class AutoPollTask implements Runnable {
        private final WeakReference<AutoPollRecyclerView> mReference;

        //使用弱引用持有外部类引用  防止内存泄露
        AutoPollTask(AutoPollRecyclerView reference) {
            this.mReference = new WeakReference<AutoPollRecyclerView>(reference);
        }

        @Override
        public void run() {
            AutoPollRecyclerView recyclerView = mReference.get();
            if (recyclerView != null && recyclerView.running && recyclerView.canRun){
                    recyclerView.scrollBy(2,2);
                    recyclerView.postDelayed(recyclerView.autoPollTask,TIME_AUTO_POLL);
            }
        }
    }

    //开始滚动
    public void start(){
        if (running){
            stop();
            canRun = true;
            running = true;
            postDelayed(autoPollTask,TIME_AUTO_POLL);
        }
    }

    public void stop(){
        running = false;
        removeCallbacks(autoPollTask);
    }

    //点击的时候会停止
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()){
            //触碰停止
            case MotionEvent.ACTION_DOWN:
                if (running)
                    stop();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
            //当没有点击的时候，开启滚动
            case MotionEvent.ACTION_OUTSIDE:
                  if (canRun)
                      start();
                  break;
        }
        return super.onTouchEvent(e);
    }
}
