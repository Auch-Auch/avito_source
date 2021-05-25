package l6.n.a;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
public final class u implements Runnable {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ ArrayMap d;
    public final /* synthetic */ View e;
    public final /* synthetic */ FragmentTransitionImpl f;
    public final /* synthetic */ Rect g;

    public u(Fragment fragment, Fragment fragment2, boolean z, ArrayMap arrayMap, View view, FragmentTransitionImpl fragmentTransitionImpl, Rect rect) {
        this.a = fragment;
        this.b = fragment2;
        this.c = z;
        this.d = arrayMap;
        this.e = view;
        this.f = fragmentTransitionImpl;
        this.g = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        w.c(this.a, this.b, this.c, this.d, false);
        View view = this.e;
        if (view != null) {
            this.f.getBoundsOnScreen(view, this.g);
        }
    }
}
