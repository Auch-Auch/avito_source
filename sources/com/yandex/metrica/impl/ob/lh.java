package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.us;
import java.util.List;
public class lh implements nq<StackTraceElement, us.d> {
    @NonNull
    private li a = new li();

    @NonNull
    /* renamed from: a */
    public us.d[] b(@NonNull List<StackTraceElement> list) {
        us.d[] dVarArr = new us.d[list.size()];
        int i = 0;
        for (StackTraceElement stackTraceElement : list) {
            dVarArr[i] = this.a.b(stackTraceElement);
            i++;
        }
        return dVarArr;
    }

    @NonNull
    public List<StackTraceElement> a(us.d[] dVarArr) {
        throw new UnsupportedOperationException();
    }
}
