package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
public class z {
    @NonNull
    public final ArrayList<bv> a;
    @NonNull
    public final ArrayList<cx> b;
    public int c = -1;

    public z(@NonNull cz czVar) {
        ArrayList<bv> arrayList = new ArrayList<>();
        Iterator<cy> it = czVar.K("playheadTimerValue").iterator();
        while (it.hasNext()) {
            cy next = it.next();
            if (next instanceof bv) {
                arrayList.add((bv) next);
            }
        }
        this.a = arrayList;
        ArrayList<cx> arrayList2 = new ArrayList<>();
        this.b = arrayList2;
        czVar.c(arrayList2);
    }

    @NonNull
    public static z a(@NonNull cz czVar) {
        return new z(czVar);
    }

    public void a(int i, int i2, @NonNull Context context) {
        if (i2 >= 0 && i >= 0 && i != this.c) {
            this.c = i;
            if (!this.a.isEmpty() && i != 0) {
                Iterator<bv> it = this.a.iterator();
                while (it.hasNext()) {
                    bv next = it.next();
                    int bB = next.bB();
                    int bC = next.bC();
                    if ((bB <= i && (bC == 0 || bC >= i)) && (i - bB) % next.bD() == 0) {
                        String replace = next.getUrl().replace("[CONTENTPLAYHEAD]", String.valueOf(i));
                        if (!TextUtils.isEmpty(replace)) {
                            im.o(replace, context);
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            while (!this.b.isEmpty()) {
                ArrayList<cx> arrayList2 = this.b;
                if (arrayList2.get(arrayList2.size() - 1).cu() > ((float) i)) {
                    break;
                }
                ArrayList<cx> arrayList3 = this.b;
                arrayList.add(arrayList3.remove(arrayList3.size() - 1));
            }
            if (!arrayList.isEmpty()) {
                im.a(arrayList, context);
            }
        }
    }
}
