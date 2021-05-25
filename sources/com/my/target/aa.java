package com.my.target;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
public class aa {
    @NonNull
    public final ArrayList<bw> a = new ArrayList<>();
    @Nullable
    public WeakReference<View> b;
    public float c = -1.0f;
    public long d;

    public aa(@NonNull cz czVar) {
        Iterator<cv> it = czVar.cz().iterator();
        while (it.hasNext()) {
            cv next = it.next();
            if (next instanceof bw) {
                this.a.add((bw) next);
            }
        }
    }

    @NonNull
    public static aa b(@NonNull cz czVar) {
        return new aa(czVar);
    }

    public void c(int i) {
        View view;
        float f = (float) i;
        float f2 = this.c;
        if (f != f2) {
            if (!(f >= f2 && (this.d <= 0 || (((long) (f - f2)) * 1000) - (System.currentTimeMillis() - this.d) <= 1000))) {
                Iterator<bw> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().k(-1.0f);
                }
            }
            Context context = null;
            double d2 = 0.0d;
            WeakReference<View> weakReference = this.b;
            if (!(weakReference == null || (view = weakReference.get()) == null)) {
                d2 = iq.l(view);
                context = view.getContext();
            }
            if (!this.a.isEmpty()) {
                if (context == null) {
                    Iterator<bw> it2 = this.a.iterator();
                    while (it2.hasNext()) {
                        it2.next().k(-1.0f);
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator<bw> it3 = this.a.iterator();
                    while (it3.hasNext()) {
                        bw next = it3.next();
                        int bB = next.bB();
                        int bC = next.bC();
                        if (!(bB <= i && (bC == 0 || bC >= i)) || ((double) next.cD()) > d2) {
                            next.k(-1.0f);
                        } else if (next.cs() < 0.0f || f <= next.cs()) {
                            next.k(f);
                        } else if (f - next.cs() >= next.getDuration()) {
                            arrayList.add(next);
                            it3.remove();
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        im.a(arrayList, context);
                    }
                }
            }
            this.c = f;
            this.d = System.currentTimeMillis();
        }
    }

    public void setView(@Nullable View view) {
        WeakReference<View> weakReference;
        if (view != null || (weakReference = this.b) == null) {
            this.b = new WeakReference<>(view);
        } else {
            weakReference.clear();
        }
    }
}
