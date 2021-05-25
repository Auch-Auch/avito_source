package a2.c.a;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.androidadvance.topsnackbar.TSnackbar;
public class f extends ViewPropertyAnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ TSnackbar b;

    public f(TSnackbar tSnackbar, int i) {
        this.b = tSnackbar;
        this.a = i;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        TSnackbar tSnackbar = this.b;
        int i = this.a;
        int i2 = TSnackbar.LENGTH_INDEFINITE;
        tSnackbar.d(i);
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        TSnackbar.SnackbarLayout snackbarLayout = this.b.c;
        ViewCompat.setAlpha(snackbarLayout.a, 1.0f);
        long j = (long) 180;
        long j2 = (long) 0;
        ViewCompat.animate(snackbarLayout.a).alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (snackbarLayout.b.getVisibility() == 0) {
            ViewCompat.setAlpha(snackbarLayout.b, 1.0f);
            ViewCompat.animate(snackbarLayout.b).alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }
}
