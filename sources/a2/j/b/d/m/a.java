package a2.j.b.d.m;

import android.app.Activity;
import android.graphics.Color;
import android.view.ViewTreeObserver;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.navigation.NavigationView;
public class a implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ NavigationView a;

    public a(NavigationView navigationView) {
        this.a = navigationView;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        NavigationView navigationView = this.a;
        navigationView.getLocationOnScreen(navigationView.j);
        NavigationView navigationView2 = this.a;
        boolean z = true;
        boolean z2 = navigationView2.j[1] == 0;
        navigationView2.g.setBehindStatusBar(z2);
        this.a.setDrawTopInsetForeground(z2);
        Activity activity = ContextUtils.getActivity(this.a.getContext());
        if (activity != null) {
            boolean z3 = activity.findViewById(16908290).getHeight() == this.a.getHeight();
            boolean z4 = Color.alpha(activity.getWindow().getNavigationBarColor()) != 0;
            NavigationView navigationView3 = this.a;
            if (!z3 || !z4) {
                z = false;
            }
            navigationView3.setDrawBottomInsetForeground(z);
        }
    }
}
