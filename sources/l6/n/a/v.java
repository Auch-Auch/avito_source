package l6.n.a;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;
import l6.n.a.w;
public final class v implements Runnable {
    public final /* synthetic */ FragmentTransitionImpl a;
    public final /* synthetic */ ArrayMap b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ w.b d;
    public final /* synthetic */ ArrayList e;
    public final /* synthetic */ View f;
    public final /* synthetic */ Fragment g;
    public final /* synthetic */ Fragment h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ ArrayList j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ Rect l;

    public v(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap arrayMap, Object obj, w.b bVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.a = fragmentTransitionImpl;
        this.b = arrayMap;
        this.c = obj;
        this.d = bVar;
        this.e = arrayList;
        this.f = view;
        this.g = fragment;
        this.h = fragment2;
        this.i = z;
        this.j = arrayList2;
        this.k = obj2;
        this.l = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayMap<String, View> e2 = w.e(this.a, this.b, this.c, this.d);
        if (e2 != null) {
            this.e.addAll(e2.values());
            this.e.add(this.f);
        }
        w.c(this.g, this.h, this.i, e2, false);
        Object obj = this.c;
        if (obj != null) {
            this.a.swapSharedElementTargets(obj, this.j, this.e);
            View l2 = w.l(e2, this.d, this.k, this.i);
            if (l2 != null) {
                this.a.getBoundsOnScreen(l2, this.l);
            }
        }
    }
}
