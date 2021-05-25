package com.my.target;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
public class cz {
    public final Set<cy> a = new HashSet();
    public final Set<cx> b = new HashSet();
    public final ArrayList<cw> c = new ArrayList<>();
    public final ArrayList<cv> d = new ArrayList<>();

    public class a implements Comparator<cx> {
        public a(cz czVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(cx cxVar, cx cxVar2) {
            return (int) (cxVar2.cu() - cxVar.cu());
        }
    }

    @NonNull
    public static cz cx() {
        return new cz();
    }

    @NonNull
    public ArrayList<cy> K(@NonNull String str) {
        ArrayList<cy> arrayList = new ArrayList<>();
        for (cy cyVar : this.a) {
            if (str.equals(cyVar.getType())) {
                arrayList.add(cyVar);
            }
        }
        return arrayList;
    }

    public void a(@NonNull cz czVar, float f) {
        this.a.addAll(czVar.cB());
        this.d.addAll(czVar.cz());
        if (f <= 0.0f) {
            this.b.addAll(czVar.cA());
            this.c.addAll(czVar.cy());
            return;
        }
        for (cx cxVar : czVar.cA()) {
            float cv = cxVar.cv();
            if (cv >= 0.0f) {
                cxVar.l((cv * f) / 100.0f);
                cxVar.m(-1.0f);
            }
            b(cxVar);
        }
        Iterator<cw> it = czVar.cy().iterator();
        while (it.hasNext()) {
            cw next = it.next();
            float cv2 = next.cv();
            if (cv2 >= 0.0f) {
                next.l((cv2 * f) / 100.0f);
                next.m(-1.0f);
            }
            b(next);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.ArrayList<com.my.target.cw> */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(@NonNull cy cyVar) {
        da daVar;
        ArrayList arrayList;
        Set set;
        if (cyVar instanceof cx) {
            set = this.b;
            cyVar = (cx) cyVar;
        } else {
            if (cyVar instanceof cw) {
                daVar = (cw) cyVar;
                if (this.c.isEmpty()) {
                    arrayList = this.c;
                } else {
                    int size = this.c.size();
                    while (size > 0 && this.c.get(size - 1).cu() < daVar.cu()) {
                        size--;
                    }
                    this.c.add(size, daVar);
                    return;
                }
            } else if (cyVar instanceof cv) {
                arrayList = this.d;
                daVar = (cv) cyVar;
            } else {
                set = this.a;
            }
            arrayList.add(daVar);
            return;
        }
        set.add(cyVar);
    }

    public void c(@NonNull List<cx> list) {
        list.addAll(this.b);
        Collections.sort(list, new a(this));
    }

    @NonNull
    public Set<cx> cA() {
        return new HashSet(this.b);
    }

    @NonNull
    public Set<cy> cB() {
        return new HashSet(this.a);
    }

    public boolean cC() {
        return !this.a.isEmpty() || !this.b.isEmpty() || !this.c.isEmpty() || !this.d.isEmpty();
    }

    @NonNull
    public ArrayList<cw> cy() {
        return new ArrayList<>(this.c);
    }

    @NonNull
    public ArrayList<cv> cz() {
        return new ArrayList<>(this.d);
    }

    public void e(@NonNull ArrayList<cy> arrayList) {
        Iterator<cy> it = arrayList.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public void f(@NonNull ArrayList<cx> arrayList) {
        this.b.addAll(arrayList);
    }
}
