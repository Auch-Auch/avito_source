package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.metrica.impl.ob.aam;
import org.json.JSONArray;
import org.json.JSONObject;
public class aad extends aam {
    @NonNull
    public String a;
    public final int b;
    @Nullable
    public Integer c;
    public final boolean d;
    @NonNull
    public final a e;
    @Nullable
    public final Float f;
    @Nullable
    public final Float g;
    @Nullable
    public final Float h;
    @Nullable
    public final String i;
    @Nullable
    public final Boolean j;
    @Nullable
    public final Boolean k;
    @Nullable
    public Integer l;

    /* renamed from: com.yandex.metrica.impl.ob.aad$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TextUtils.TruncateAt.values().length];
            a = iArr;
            try {
                iArr[TextUtils.TruncateAt.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TextUtils.TruncateAt.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TextUtils.TruncateAt.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TextUtils.TruncateAt.MARQUEE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum a {
        START("START"),
        END("END"),
        MIDDLE("MIDDLE"),
        MARQUEE("MARQUEE"),
        NONE("NONE"),
        UNKNOWN("UNKNOWN");
        
        @NonNull
        public final String g;

        private a(String str) {
            this.g = str;
        }

        @NonNull
        public static a a(@Nullable TextUtils.TruncateAt truncateAt) {
            if (truncateAt == null) {
                return NONE;
            }
            int i = AnonymousClass1.a[truncateAt.ordinal()];
            if (i == 1) {
                return START;
            }
            if (i == 2) {
                return END;
            }
            if (i == 3) {
                return MIDDLE;
            }
            if (i != 4) {
                return UNKNOWN;
            }
            return MARQUEE;
        }
    }

    public aad(@NonNull String str, @NonNull String str2, @Nullable aam.c cVar, int i2, boolean z, @NonNull aam.a aVar, @NonNull String str3, @Nullable Float f2, @Nullable Float f3, @Nullable Float f4, @Nullable String str4, @Nullable Boolean bool, @Nullable Boolean bool2, boolean z2, int i3, @NonNull a aVar2) {
        super(str, str2, cVar, i2, z, aam.d.VIEW, aVar);
        this.a = str3;
        this.b = i3;
        this.e = aVar2;
        this.d = z2;
        this.f = f2;
        this.g = f3;
        this.h = f4;
        this.i = str4;
        this.j = bool;
        this.k = bool2;
    }

    @Override // com.yandex.metrica.impl.ob.aam
    @Nullable
    public JSONArray a(@NonNull aah aah) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.a;
            if (str.length() > aah.i) {
                this.c = Integer.valueOf(this.a.length());
                str = this.a.substring(0, aah.i);
            }
            jSONObject.put("t", aam.b.TEXT.c);
            jSONObject.put(AuthSource.OPEN_VAS_LIST, str);
            jSONObject.put("i", a(aah, str));
            jSONArray.put(jSONObject);
        } catch (Throwable unused) {
        }
        return jSONArray;
    }

    @Override // com.yandex.metrica.impl.ob.aam
    public boolean a() {
        return true;
    }

    @Override // com.yandex.metrica.impl.ob.aam
    @Nullable
    public aam.c b(@NonNull aah aah) {
        aam.c b2 = super.b(aah);
        return (b2 != null || this.a.length() <= aah.h) ? b2 : aam.c.TEXT_TOO_LONG;
    }

    @Override // com.yandex.metrica.impl.ob.aam
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("TextViewElement{mText='");
        a2.b.a.a.a.k1(L, this.a, '\'', ", mVisibleTextLength=");
        L.append(this.b);
        L.append(", mOriginalTextLength=");
        L.append(this.c);
        L.append(", mIsVisible=");
        L.append(this.d);
        L.append(", mTextShorteningType=");
        L.append(this.e);
        L.append(", mSizePx=");
        L.append(this.f);
        L.append(", mSizeDp=");
        L.append(this.g);
        L.append(", mSizeSp=");
        L.append(this.h);
        L.append(", mColor='");
        a2.b.a.a.a.k1(L, this.i, '\'', ", mIsBold=");
        L.append(this.j);
        L.append(", mIsItalic=");
        L.append(this.k);
        L.append(", mRelativeTextSize=");
        L.append(this.l);
        L.append(", mClassName='");
        a2.b.a.a.a.k1(L, this.m, '\'', ", mId='");
        a2.b.a.a.a.k1(L, this.n, '\'', ", mFilterReason=");
        L.append(this.o);
        L.append(", mDepth=");
        L.append(this.p);
        L.append(", mListItem=");
        L.append(this.q);
        L.append(", mViewType=");
        L.append(this.r);
        L.append(", mClassType=");
        L.append(this.s);
        L.append('}');
        return L.toString();
    }

    @NonNull
    private JSONObject a(@NonNull aah aah, @NonNull String str) {
        int i2;
        JSONObject jSONObject = new JSONObject();
        try {
            if (aah.a) {
                jSONObject.putOpt("sp", this.f).putOpt("sd", this.g).putOpt(AuthSource.OPEN_SEARCH_SUBSCRIPTIONS, this.h);
            }
            if (aah.b) {
                jSONObject.put("rts", this.l);
            }
            if (aah.d) {
                jSONObject.putOpt("c", this.i).putOpt("ib", this.j).putOpt("ii", this.k);
            }
            if (aah.c) {
                jSONObject.put("vtl", this.b).put("iv", this.d).put("tst", this.e.g);
            }
            Integer num = this.c;
            if (num != null) {
                i2 = num.intValue();
            } else {
                i2 = this.a.length();
            }
            if (aah.g) {
                jSONObject.put("tl", str.length()).put("otl", i2);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
