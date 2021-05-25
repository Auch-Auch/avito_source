package a2.c.a;

import android.view.View;
import com.androidadvance.topsnackbar.TSnackbar;
import com.google.android.material.behavior.SwipeDismissBehavior;
public class b implements SwipeDismissBehavior.OnDismissListener {
    public final /* synthetic */ TSnackbar a;

    public b(TSnackbar tSnackbar) {
        this.a = tSnackbar;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
    public void onDismiss(View view) {
        TSnackbar tSnackbar = this.a;
        int i = TSnackbar.LENGTH_INDEFINITE;
        tSnackbar.b(0);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
    public void onDragStateChanged(int i) {
        if (i == 0) {
            a.c().g(this.a.f);
        } else if (i == 1 || i == 2) {
            a.c().b(this.a.f);
        }
    }
}
