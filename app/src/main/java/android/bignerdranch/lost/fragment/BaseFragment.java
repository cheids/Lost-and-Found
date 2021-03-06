package android.bignerdranch.lost.fragment;

import android.view.View;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    /**
     * Fragment当前状态是否可见
     */
    public boolean isVisible;

    /**
     * inflate布局文件 返回的view
     */
    public View mView;

    /**
     * 简化 findViewById
     *
     * @param viewId
     * @param <T>
     * @return
     */
    protected <T extends View> T find(int viewId) {
        return (T) mView.findViewById(viewId);
    }

    /**
     * setUserVisibleHint是在onCreateView之前调用的
     * 设置Fragment可见状态
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        /**
         * 判断是否可见
         */
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }
    private void onVisible() {
        lazyLoad();
    }

    private void onInvisible() {
    }

    /**
     * 延迟加载
     * 子类必须重写此方法
     */
    public abstract void lazyLoad();

//    @Subscribe(threadMode = ThreadMode.MainThread, sticky = true)
//    public void onEvent(EventMessage msg) {
//
//    }
//
//    @Subscribe(threadMode = ThreadMode.MainThread, sticky = true)
//    public void onEventSticky(EventMessage msg) {
//
//    }

}


