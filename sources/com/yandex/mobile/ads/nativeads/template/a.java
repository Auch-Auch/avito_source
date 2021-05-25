package com.yandex.mobile.ads.nativeads.template;

import android.content.Context;
import com.yandex.mobile.ads.impl.dv;
public abstract class a {
    public final float a;

    /* renamed from: com.yandex.mobile.ads.nativeads.template.a$a  reason: collision with other inner class name */
    public static class C0367a extends a {
        public C0367a(float f) {
            super(f);
        }

        @Override // com.yandex.mobile.ads.nativeads.template.a
        public final float a(float f) {
            if (f < 10.0f) {
                return 10.0f;
            }
            return f;
        }

        @Override // com.yandex.mobile.ads.nativeads.template.a
        public final d a(Context context, int i, int i2, int i3) {
            int min = Math.min(dv.a(context, this.a), i);
            return new d(min, Math.round(((float) i3) * (((float) min) / ((float) i2))));
        }
    }

    public static class c extends a {
        public c(float f) {
            super(f);
        }

        @Override // com.yandex.mobile.ads.nativeads.template.a
        public final float a(float f) {
            return a.b(f);
        }

        @Override // com.yandex.mobile.ads.nativeads.template.a
        public final d a(Context context, int i, int i2, int i3) {
            int a = dv.a(context, 140.0f);
            int round = Math.round(((float) i) * this.a);
            if (i2 > round) {
                i3 = Math.round(((float) i3) / (((float) i2) / ((float) round)));
                i2 = round;
            }
            if (i3 > a) {
                i2 = Math.round(((float) i2) / (((float) i3) / ((float) a)));
            } else {
                a = i3;
            }
            return new d(i2, a);
        }
    }

    public static class d {
        private final int a;
        private final int b;

        public d(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && d.class == obj.getClass()) {
                d dVar = (d) obj;
                if (this.a == dVar.a && this.b == dVar.b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }
    }

    public a(float f) {
        this.a = a(f);
    }

    public static float b(float f) {
        if (f < 0.01f) {
            return 0.01f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public abstract float a(float f);

    public abstract d a(Context context, int i, int i2, int i3);

    public static class b extends a {
        public b(float f) {
            super(f);
        }

        @Override // com.yandex.mobile.ads.nativeads.template.a
        public final d a(Context context, int i, int i2, int i3) {
            int round = Math.round(((float) i) * this.a);
            return new d(round, Math.round(((float) i3) * (((float) round) / ((float) i2))));
        }

        @Override // com.yandex.mobile.ads.nativeads.template.a
        public final float a(float f) {
            return a.b(f);
        }
    }
}
