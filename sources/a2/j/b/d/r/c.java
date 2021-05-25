package a2.j.b.d.r;

import android.view.View;
import com.google.android.material.tabs.TabLayout;
public class c implements View.OnLayoutChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ TabLayout.TabView b;

    public c(TabLayout.TabView tabView, View view) {
        this.b = tabView;
        this.a = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.a.getVisibility() == 0) {
            TabLayout.TabView tabView = this.b;
            View view2 = this.a;
            int i9 = TabLayout.TabView.l;
            tabView.h(view2);
        }
    }
}
