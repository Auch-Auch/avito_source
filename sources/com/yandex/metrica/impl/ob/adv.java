package com.yandex.metrica.impl.ob;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
public class adv implements adw<List<adu>> {
    public adu a(@Nullable List<adu> list) {
        LinkedList linkedList = new LinkedList();
        boolean z = true;
        for (adu adu : list) {
            if (!adu.a()) {
                linkedList.add(adu.b());
                z = false;
            }
        }
        if (z) {
            return adu.a(this);
        }
        return adu.a(this, TextUtils.join(", ", linkedList));
    }
}
