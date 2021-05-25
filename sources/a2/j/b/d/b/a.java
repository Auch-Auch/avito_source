package a2.j.b.d.b;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeDrawable;
public class a implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ FrameLayout b;
    public final /* synthetic */ BadgeDrawable c;

    public a(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        this.c = badgeDrawable;
        this.a = view;
        this.b = frameLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.updateBadgeCoordinates(this.a, this.b);
    }
}
