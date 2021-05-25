package l6.b.a;

import android.view.View;
import androidx.appcompat.app.AlertController;
import androidx.core.widget.NestedScrollView;
public class a implements NestedScrollView.OnScrollChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;

    public a(AlertController alertController, View view, View view2) {
        this.a = view;
        this.b = view2;
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        AlertController.c(nestedScrollView, this.a, this.b);
    }
}
