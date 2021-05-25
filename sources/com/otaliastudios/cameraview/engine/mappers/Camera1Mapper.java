package com.otaliastudios.cameraview.engine.mappers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.otaliastudios.cameraview.controls.Control;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import java.util.HashMap;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
public class Camera1Mapper {
    public static Camera1Mapper a;
    public static final Map<Flash, String> b;
    public static final Map<WhiteBalance, String> c;
    public static final Map<Facing, Integer> d;
    public static final Map<Hdr, String> e;

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        HashMap hashMap2 = new HashMap();
        c = hashMap2;
        HashMap hashMap3 = new HashMap();
        d = hashMap3;
        HashMap hashMap4 = new HashMap();
        e = hashMap4;
        hashMap.put(Flash.OFF, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        hashMap.put(Flash.ON, DebugKt.DEBUG_PROPERTY_VALUE_ON);
        hashMap.put(Flash.AUTO, DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        hashMap.put(Flash.TORCH, "torch");
        hashMap3.put(Facing.BACK, 0);
        hashMap3.put(Facing.FRONT, 1);
        hashMap2.put(WhiteBalance.AUTO, DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        hashMap2.put(WhiteBalance.INCANDESCENT, "incandescent");
        hashMap2.put(WhiteBalance.FLUORESCENT, "fluorescent");
        hashMap2.put(WhiteBalance.DAYLIGHT, "daylight");
        hashMap2.put(WhiteBalance.CLOUDY, "cloudy-daylight");
        hashMap4.put(Hdr.OFF, DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        hashMap4.put(Hdr.ON, "hdr");
    }

    @NonNull
    public static Camera1Mapper get() {
        if (a == null) {
            a = new Camera1Mapper();
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
        return d.get(facing).intValue();
    }

    @NonNull
    public String mapFlash(@NonNull Flash flash) {
        return b.get(flash);
    }

    @NonNull
    public String mapHdr(@NonNull Hdr hdr) {
        return e.get(hdr);
    }

    @NonNull
    public String mapWhiteBalance(@NonNull WhiteBalance whiteBalance) {
        return c.get(whiteBalance);
    }

    @Nullable
    public Facing unmapFacing(int i) {
        return (Facing) a(d, Integer.valueOf(i));
    }

    @Nullable
    public Flash unmapFlash(@NonNull String str) {
        return (Flash) a(b, str);
    }

    @Nullable
    public Hdr unmapHdr(@NonNull String str) {
        return (Hdr) a(e, str);
    }

    @Nullable
    public WhiteBalance unmapWhiteBalance(@NonNull String str) {
        return (WhiteBalance) a(c, str);
    }
}
