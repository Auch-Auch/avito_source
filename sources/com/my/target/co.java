package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.VideoData;
import com.yandex.mobile.ads.video.models.vmap.AdBreak;
import java.util.ArrayList;
import java.util.HashMap;
public class co extends cn {
    @NonNull
    public final HashMap<String, cr<VideoData>> b;

    public co() {
        HashMap<String, cr<VideoData>> hashMap = new HashMap<>();
        this.b = hashMap;
        hashMap.put(AdBreak.BreakId.PREROLL, cr.x(AdBreak.BreakId.PREROLL));
        hashMap.put(AdBreak.BreakId.PAUSEROLL, cr.x(AdBreak.BreakId.PAUSEROLL));
        hashMap.put(AdBreak.BreakId.MIDROLL, cr.x(AdBreak.BreakId.MIDROLL));
        hashMap.put(AdBreak.BreakId.POSTROLL, cr.x(AdBreak.BreakId.POSTROLL));
    }

    @NonNull
    public static co bR() {
        return new co();
    }

    @NonNull
    public ArrayList<cr<VideoData>> bS() {
        return new ArrayList<>(this.b.values());
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean bT() {
        /*
            r3 = this;
            java.util.HashMap<java.lang.String, com.my.target.cr<com.my.target.common.models.VideoData>> r0 = r3.b
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0024
            java.lang.Object r1 = r0.next()
            com.my.target.cr r1 = (com.my.target.cr) r1
            int r2 = r1.getBannersCount()
            if (r2 > 0) goto L_0x0022
            boolean r1 = r1.ce()
            if (r1 == 0) goto L_0x000a
        L_0x0022:
            r0 = 1
            return r0
        L_0x0024:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.co.bT():boolean");
    }

    @Override // com.my.target.cn
    public int getBannersCount() {
        int i = 0;
        for (cr<VideoData> crVar : this.b.values()) {
            i += crVar.getBannersCount();
        }
        return i;
    }

    @Nullable
    public cr<VideoData> v(@NonNull String str) {
        return this.b.get(str);
    }
}
