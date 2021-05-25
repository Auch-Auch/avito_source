package com.otaliastudios.cameraview.internal;

import android.annotation.SuppressLint;
import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.size.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
public class CamcorderProfiles {
    public static final CameraLogger a = CameraLogger.create(CamcorderProfiles.class.getSimpleName());
    @SuppressLint({"UseSparseArrays"})
    public static Map<Size, Integer> b;

    public static class a implements Comparator<Size> {
        public final /* synthetic */ long a;

        public a(long j) {
            this.a = j;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Size size, Size size2) {
            Size size3 = size;
            Size size4 = size2;
            int i = (Math.abs(((long) (size3.getHeight() * size3.getWidth())) - this.a) > Math.abs(((long) (size4.getHeight() * size4.getWidth())) - this.a) ? 1 : (Math.abs(((long) (size3.getHeight() * size3.getWidth())) - this.a) == Math.abs(((long) (size4.getHeight() * size4.getWidth())) - this.a) ? 0 : -1));
            if (i < 0) {
                return -1;
            }
            return i == 0 ? 0 : 1;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put(new Size(176, 144), 2);
        b.put(new Size(320, 240), 7);
        b.put(new Size(352, 288), 3);
        b.put(new Size(720, 480), 4);
        b.put(new Size(1280, 720), 5);
        b.put(new Size(1920, 1080), 6);
        b.put(new Size(3840, 2160), 8);
    }

    @NonNull
    public static CamcorderProfile get(@NonNull String str, @NonNull Size size) {
        try {
            return get(Integer.parseInt(str), size);
        } catch (NumberFormatException unused) {
            a.w("NumberFormatException for Camera2 id:", str);
            return CamcorderProfile.get(0);
        }
    }

    @NonNull
    public static CamcorderProfile get(int i, @NonNull Size size) {
        long width = ((long) size.getWidth()) * ((long) size.getHeight());
        ArrayList arrayList = new ArrayList(b.keySet());
        Collections.sort(arrayList, new a(width));
        while (arrayList.size() > 0) {
            int intValue = b.get((Size) arrayList.remove(0)).intValue();
            if (CamcorderProfile.hasProfile(i, intValue)) {
                return CamcorderProfile.get(i, intValue);
            }
        }
        return CamcorderProfile.get(i, 0);
    }
}
