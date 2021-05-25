package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.models.ad.Creative;
import com.yandex.mobile.ads.video.models.ad.Icon;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
public final class vv {
    @NonNull
    private static Set<String> a(@NonNull Creative creative) {
        HashSet hashSet = new HashSet();
        for (Icon icon : creative.getIcons()) {
            hashSet.add(icon.getProgram());
        }
        return hashSet;
    }

    @NonNull
    public static List<Icon> a(@NonNull Creative creative, @NonNull List<Creative> list) {
        ArrayList arrayList = new ArrayList();
        for (Creative creative2 : list) {
            arrayList.addAll(creative2.getIcons());
        }
        Set<String> a = a(creative);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Icon icon = (Icon) it.next();
            String program = icon.getProgram();
            if (!a.contains(program)) {
                arrayList2.add(icon);
                a.add(program);
            }
        }
        return arrayList2;
    }
}
