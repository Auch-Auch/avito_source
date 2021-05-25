package com.my.target;

import androidx.annotation.NonNull;
import com.my.target.eq;
import com.my.target.hu;
import java.util.ArrayList;
import java.util.List;
public class ep implements eq, hu.a {
    @NonNull
    public final hu a;
    @NonNull
    public final eq.a b;
    @NonNull
    public final boolean[] c;
    @NonNull
    public final List<by> d = new ArrayList();
    @NonNull
    public final List<cb> e;

    public ep(@NonNull hu huVar, @NonNull List<cb> list, @NonNull eq.a aVar) {
        this.a = huVar;
        this.b = aVar;
        this.e = new ArrayList(list);
        this.c = new boolean[list.size()];
        huVar.setListener(this);
    }

    @NonNull
    public static eq a(@NonNull hu huVar, @NonNull List<cb> list, @NonNull eq.a aVar) {
        return new ep(huVar, list, aVar);
    }

    @Override // com.my.target.ek.a
    public void a(@NonNull by byVar, boolean z, int i) {
        if (!this.a.H(i)) {
            this.a.I(i);
        } else if (z) {
            this.b.c(byVar);
        }
    }

    @Override // com.my.target.hu.a
    public void a(@NonNull int[] iArr) {
        for (int i : iArr) {
            if (i >= 0) {
                boolean[] zArr = this.c;
                if (i < zArr.length && !zArr[i]) {
                    zArr[i] = true;
                    this.b.d(this.e.get(i));
                }
            }
        }
    }

    @Override // com.my.target.ek.a
    public void b(@NonNull by byVar) {
        if (!this.d.contains(byVar)) {
            this.b.e(byVar);
            this.d.add(byVar);
        }
    }
}
