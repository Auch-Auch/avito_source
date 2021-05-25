package com.bumptech.glide.load.engine.bitmap_recycle;

import a2.d.a.d.b.u.d;
import a2.d.a.d.b.u.e;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
@RequiresApi(19)
public class SizeConfigStrategy implements d {
    public static final Bitmap.Config[] d;
    public static final Bitmap.Config[] e;
    public static final Bitmap.Config[] f = {Bitmap.Config.RGB_565};
    public static final Bitmap.Config[] g = {Bitmap.Config.ARGB_4444};
    public static final Bitmap.Config[] h = {Bitmap.Config.ALPHA_8};
    public final c a = new c();
    public final a2.d.a.d.b.u.c<b, Bitmap> b = new a2.d.a.d.b.u.c<>();
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> c = new HashMap();

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @VisibleForTesting
    public static final class b implements e {
        public final c a;
        public int b;
        public Bitmap.Config c;

        public b(c cVar) {
            this.a = cVar;
        }

        @Override // a2.d.a.d.b.u.e
        public void a() {
            this.a.c(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.b != bVar.b || !Util.bothNullOrEqual(this.c, bVar.c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.b * 31;
            Bitmap.Config config = this.c;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return SizeConfigStrategy.b(this.b, this.c);
        }
    }

    @VisibleForTesting
    public static class c extends a2.d.a.d.b.u.b<b> {
        /* Return type fixed from 'a2.d.a.d.b.u.e' to match base method */
        @Override // a2.d.a.d.b.u.b
        public b a() {
            return new b(this);
        }

        public b d(int i, Bitmap.Config config) {
            b bVar = (b) b();
            bVar.b = i;
            bVar.c = config;
            return bVar;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        d = configArr;
        e = configArr;
    }

    public static String b(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> c2 = c(bitmap.getConfig());
        Integer num2 = (Integer) c2.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + logBitmap(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            c2.remove(num);
        } else {
            c2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public final NavigableMap<Integer, Integer> c(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(config, treeMap);
        return treeMap;
    }

    @Override // a2.d.a.d.b.u.d
    @Nullable
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int bitmapByteSize = Util.getBitmapByteSize(i, i2, config);
        b bVar = (b) this.a.b();
        bVar.b = bitmapByteSize;
        bVar.c = config;
        int i3 = 0;
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            int i4 = a.a[config.ordinal()];
            if (i4 == 1) {
                configArr = d;
            } else if (i4 == 2) {
                configArr = f;
            } else if (i4 != 3) {
                configArr = i4 != 4 ? new Bitmap.Config[]{config} : h;
            } else {
                configArr = g;
            }
        } else {
            configArr = e;
        }
        int length = configArr.length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            Bitmap.Config config2 = configArr[i3];
            Integer ceilingKey = c(config2).ceilingKey(Integer.valueOf(bitmapByteSize));
            if (ceilingKey == null || ceilingKey.intValue() > bitmapByteSize * 8) {
                i3++;
            } else if (ceilingKey.intValue() != bitmapByteSize || (config2 != null ? !config2.equals(config) : config != null)) {
                this.a.c(bVar);
                bVar = this.a.d(ceilingKey.intValue(), config2);
            }
        }
        Bitmap a3 = this.b.a(bVar);
        if (a3 != null) {
            a(Integer.valueOf(bVar.b), a3);
            a3.reconfigure(i, i2, config);
        }
        return a3;
    }

    @Override // a2.d.a.d.b.u.d
    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    @Override // a2.d.a.d.b.u.d
    public String logBitmap(Bitmap bitmap) {
        return b(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
    }

    @Override // a2.d.a.d.b.u.d
    public void put(Bitmap bitmap) {
        b d2 = this.a.d(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
        this.b.b(d2, bitmap);
        NavigableMap<Integer, Integer> c2 = c(bitmap.getConfig());
        Integer num = (Integer) c2.get(Integer.valueOf(d2.b));
        Integer valueOf = Integer.valueOf(d2.b);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        c2.put(valueOf, Integer.valueOf(i));
    }

    @Override // a2.d.a.d.b.u.d
    @Nullable
    public Bitmap removeLast() {
        Bitmap c2 = this.b.c();
        if (c2 != null) {
            a(Integer.valueOf(Util.getBitmapByteSize(c2)), c2);
        }
        return c2;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("SizeConfigStrategy{groupedMap=");
        L.append(this.b);
        L.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.c.entrySet()) {
            L.append(entry.getKey());
            L.append('[');
            L.append(entry.getValue());
            L.append("], ");
        }
        if (!this.c.isEmpty()) {
            L.replace(L.length() - 2, L.length(), "");
        }
        L.append(")}");
        return L.toString();
    }

    @Override // a2.d.a.d.b.u.d
    public String logBitmap(int i, int i2, Bitmap.Config config) {
        return b(Util.getBitmapByteSize(i, i2, config), config);
    }
}
