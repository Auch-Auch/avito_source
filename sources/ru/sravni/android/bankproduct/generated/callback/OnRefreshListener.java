package ru.sravni.android.bankproduct.generated.callback;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
public final class OnRefreshListener implements SwipeRefreshLayout.OnRefreshListener {
    public final Listener a;
    public final int b;

    public interface Listener {
        void _internalCallbackOnRefresh(int i);
    }

    public OnRefreshListener(Listener listener, int i) {
        this.a = listener;
        this.b = i;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        this.a._internalCallbackOnRefresh(this.b);
    }
}
