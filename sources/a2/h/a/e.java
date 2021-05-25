package a2.h.a;

import android.view.View;
import android.view.ViewTreeObserver;
public final class e implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ ViewTreeObserver a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Runnable c;

    public e(ViewTreeObserver viewTreeObserver, View view, Runnable runnable) {
        this.a = viewTreeObserver;
        this.b = view;
        this.c = runnable;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ViewTreeObserver viewTreeObserver;
        if (this.a.isAlive()) {
            viewTreeObserver = this.a;
        } else {
            viewTreeObserver = this.b.getViewTreeObserver();
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this);
        this.c.run();
    }
}
