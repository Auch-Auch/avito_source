package com.my.target;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
public class ir {
    @NonNull
    public final ArrayList<cw> a;
    @NonNull
    public final ArrayList<cv> b;
    @Nullable
    public WeakReference<View> c;
    public float d = -1.0f;

    public ir(@NonNull ArrayList<cw> arrayList, @NonNull ArrayList<cv> arrayList2) {
        this.b = arrayList2;
        this.a = arrayList;
    }

    public static ir c(@NonNull cz czVar) {
        return new ir(czVar.cy(), czVar.cz());
    }

    public void a(double d2, float f, @Nullable Context context) {
        if (this.a.isEmpty() && this.b.isEmpty()) {
            return;
        }
        if (context == null) {
            Iterator<cv> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().k(-1.0f);
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (!this.a.isEmpty()) {
            ArrayList<cw> arrayList2 = this.a;
            if (arrayList2.get(arrayList2.size() - 1).cu() > f) {
                break;
            }
            ArrayList<cw> arrayList3 = this.a;
            cw remove = arrayList3.remove(arrayList3.size() - 1);
            int cD = remove.cD();
            boolean ct = remove.ct();
            double d3 = (double) cD;
            if ((d3 <= d2 && ct) || (d3 > d2 && !ct)) {
                arrayList.add(remove);
            }
        }
        Iterator<cv> it2 = this.b.iterator();
        while (it2.hasNext()) {
            cv next = it2.next();
            if (((double) next.cD()) > d2) {
                next.k(-1.0f);
            } else if (next.cs() < 0.0f || f <= next.cs()) {
                next.k(f);
            } else if (f - next.cs() >= next.getDuration()) {
                arrayList.add(next);
                it2.remove();
            }
        }
        if (!arrayList.isEmpty()) {
            im.a(arrayList, context);
        }
    }

    public void destroy() {
        WeakReference<View> weakReference = this.c;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.b.clear();
        this.a.clear();
        this.c = null;
    }

    public void p(float f) {
        View view;
        if (Math.abs(f - this.d) >= 1.0f) {
            Context context = null;
            double d2 = 0.0d;
            WeakReference<View> weakReference = this.c;
            if (!(weakReference == null || (view = weakReference.get()) == null)) {
                d2 = iq.l(view);
                context = view.getContext();
            }
            a(d2, f, context);
            this.d = f;
        }
    }

    public void setView(@Nullable View view) {
        WeakReference<View> weakReference;
        if (view != null || (weakReference = this.c) == null) {
            this.c = new WeakReference<>(view);
        } else {
            weakReference.clear();
        }
    }
}
