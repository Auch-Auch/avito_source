package a2.j.b.d.d;

import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;
public class c implements Runnable {
    public final /* synthetic */ ActionMenuView a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ BottomAppBar d;

    public c(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        this.d = bottomAppBar;
        this.a = actionMenuView;
        this.b = i;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActionMenuView actionMenuView = this.a;
        actionMenuView.setTranslationX((float) this.d.getActionMenuViewTranslationX(actionMenuView, this.b, this.c));
    }
}
