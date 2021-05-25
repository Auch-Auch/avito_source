package a2.j.b.d.q;

import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
public class l implements SwipeDismissBehavior.OnDismissListener {
    public final /* synthetic */ BaseTransientBottomBar a;

    public l(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
    public void onDismiss(@NonNull View view) {
        if (view.getParent() != null) {
            view.setVisibility(8);
        }
        this.a.dispatchDismiss(0);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
    public void onDragStateChanged(int i) {
        if (i == 0) {
            m.b().f(this.a.s);
        } else if (i == 1 || i == 2) {
            m.b().e(this.a.s);
        }
    }
}
