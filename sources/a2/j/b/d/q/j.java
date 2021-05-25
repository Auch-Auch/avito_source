package a2.j.b.d.q;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import com.google.android.material.snackbar.BaseTransientBottomBar;
public class j implements BaseTransientBottomBar.OnAttachStateChangeListener {
    public final /* synthetic */ BaseTransientBottomBar a;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.a.c(3);
        }
    }

    public j(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = this.a.view.getRootWindowInsets()) != null) {
            this.a.n = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            this.a.g();
        }
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        if (this.a.isShownOrQueued()) {
            BaseTransientBottomBar.t.post(new a());
        }
    }
}
