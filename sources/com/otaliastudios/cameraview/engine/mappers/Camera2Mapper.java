package com.otaliastudios.cameraview.engine.mappers;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.controls.Control;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RequiresApi(21)
public class Camera2Mapper {
    public static Camera2Mapper a;
    public static final Map<Facing, Integer> b;
    public static final Map<WhiteBalance, Integer> c;
    public static final Map<Hdr, Integer> d;

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        HashMap hashMap2 = new HashMap();
        c = hashMap2;
        HashMap hashMap3 = new HashMap();
        d = hashMap3;
        hashMap.put(Facing.BACK, 1);
        hashMap.put(Facing.FRONT, 0);
        hashMap2.put(WhiteBalance.AUTO, 1);
        hashMap2.put(WhiteBalance.CLOUDY, 6);
        hashMap2.put(WhiteBalance.DAYLIGHT, 5);
        hashMap2.put(WhiteBalance.FLUORESCENT, 3);
        hashMap2.put(WhiteBalance.INCANDESCENT, 2);
        hashMap3.put(Hdr.OFF, 0);
        hashMap3.put(Hdr.ON, 18);
    }

    public static Camera2Mapper get() {
        if (a == null) {
            a = new Camera2Mapper();
        }
        return a;
    }

    @Nullable
    public final <C extends Control, T> C a(@NonNull Map<C, T> map, @NonNull T t) {
        for (C c2 : map.keySet()) {
            if (t.equals(map.get(c2))) {
                return c2;
            }
        }
        return null;
    }

    public int mapFacing(@NonNull Facing facing) {
        return b.get(facing).intValue();
    }

    @NonNull
    public List<Pair<Integer, Integer>> mapFlash(@NonNull Flash flash) {
        ArrayList arrayList = new ArrayList();
        int ordinal = flash.ordinal();
        if (ordinal == 0) {
            arrayList.add(new Pair(1, 0));
            arrayList.add(new Pair(0, 0));
        } else if (ordinal == 1) {
            arrayList.add(new Pair(3, 0));
        } else if (ordinal == 2) {
            arrayList.add(new Pair(2, 0));
            arrayList.add(new Pair(4, 0));
        } else if (ordinal == 3) {
            arrayList.add(new Pair(1, 2));
            arrayList.add(new Pair(0, 2));
        }
        return arrayList;
    }

    public int mapHdr(@NonNull Hdr hdr) {
        return d.get(hdr).intValue();
    }

    public int mapWhiteBalance(@NonNull WhiteBalance whiteBalance) {
        return c.get(whiteBalance).intValue();
    }

    @Nullable
    public Facing unmapFacing(int i) {
        return (Facing) a(b, Integer.valueOf(i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
        if (r3 != 4) goto L_0x002a;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Set<com.otaliastudios.cameraview.controls.Flash> unmapFlash(int r3) {
        /*
            r2 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            if (r3 == 0) goto L_0x0020
            r1 = 1
            if (r3 == r1) goto L_0x0020
            r1 = 2
            if (r3 == r1) goto L_0x001a
            r1 = 3
            if (r3 == r1) goto L_0x0014
            r1 = 4
            if (r3 == r1) goto L_0x001a
            goto L_0x002a
        L_0x0014:
            com.otaliastudios.cameraview.controls.Flash r3 = com.otaliastudios.cameraview.controls.Flash.ON
            r0.add(r3)
            goto L_0x002a
        L_0x001a:
            com.otaliastudios.cameraview.controls.Flash r3 = com.otaliastudios.cameraview.controls.Flash.AUTO
            r0.add(r3)
            goto L_0x002a
        L_0x0020:
            com.otaliastudios.cameraview.controls.Flash r3 = com.otaliastudios.cameraview.controls.Flash.OFF
            r0.add(r3)
            com.otaliastudios.cameraview.controls.Flash r3 = com.otaliastudios.cameraview.controls.Flash.TORCH
            r0.add(r3)
        L_0x002a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.engine.mappers.Camera2Mapper.unmapFlash(int):java.util.Set");
    }

    @Nullable
    public Hdr unmapHdr(int i) {
        return (Hdr) a(d, Integer.valueOf(i));
    }

    @Nullable
    public WhiteBalance unmapWhiteBalance(int i) {
        return (WhiteBalance) a(c, Integer.valueOf(i));
    }
}
