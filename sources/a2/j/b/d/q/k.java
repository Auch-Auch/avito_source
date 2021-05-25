package a2.j.b.d.q;

import android.view.View;
import com.google.android.material.snackbar.BaseTransientBottomBar;
public class k implements BaseTransientBottomBar.OnLayoutChangeListener {
    public final /* synthetic */ BaseTransientBottomBar a;

    public k(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4) {
        this.a.view.setOnLayoutChangeListener(null);
        this.a.f();
    }
}
