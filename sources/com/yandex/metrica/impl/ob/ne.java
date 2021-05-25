package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.uz;
import java.util.ArrayList;
public class ne implements nh<sk, uz.a> {
    @NonNull
    private final nf a;

    public ne() {
        this(new nf());
    }

    @VisibleForTesting
    public ne(@NonNull nf nfVar) {
        this.a = nfVar;
    }

    @NonNull
    /* renamed from: a */
    public uz.a b(@NonNull sk skVar) {
        uz.a aVar = new uz.a();
        aVar.b = new uz.a.b[skVar.a.size()];
        int i = 0;
        int i2 = 0;
        for (sr srVar : skVar.a) {
            aVar.b[i2] = a(srVar);
            i2++;
        }
        m mVar = skVar.b;
        if (mVar != null) {
            aVar.c = this.a.b(mVar);
        }
        aVar.d = new String[skVar.c.size()];
        for (String str : skVar.c) {
            aVar.d[i] = str;
            i++;
        }
        return aVar;
    }

    @NonNull
    public sk a(@NonNull uz.a aVar) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            uz.a.b[] bVarArr = aVar.b;
            if (i2 >= bVarArr.length) {
                break;
            }
            arrayList.add(a(bVarArr[i2]));
            i2++;
        }
        m mVar = null;
        uz.a.C0347a aVar2 = aVar.c;
        if (aVar2 != null) {
            mVar = this.a.a(aVar2);
        }
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            String[] strArr = aVar.d;
            if (i >= strArr.length) {
                return new sk(arrayList, mVar, arrayList2);
            }
            arrayList2.add(strArr[i]);
            i++;
        }
    }

    private uz.a.b a(@NonNull sr srVar) {
        uz.a.b bVar = new uz.a.b();
        bVar.b = srVar.a;
        bVar.c = srVar.b;
        return bVar;
    }

    private sr a(@NonNull uz.a.b bVar) {
        return new sr(bVar.b, bVar.c);
    }
}
