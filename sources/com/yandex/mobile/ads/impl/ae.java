package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.MobileAds;
import com.yandex.mobile.ads.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class ae {
    private final String A;
    private final String B;
    private final String C;
    private final String D;
    private final Map<String, String> E;
    private final Long F;
    private final String G;
    private final String H;
    private final String I;
    @Nullable
    private final String J;
    private final String K;
    private final String L;
    private final String M;
    private final String N;
    private final String O;
    private final String P;
    private final String Q;
    private final String R;
    private final String S;
    private final String T;
    private final Integer U;
    private final String V;
    private final String W;
    private final Boolean X;
    private final String Y;
    private final String Z;
    private final String a;
    private StringBuilder aa;
    private final String b;
    private final String c;
    private final Integer d;
    private final Integer e;
    private final String f;
    private final String g;
    private final Integer h;
    private final Integer i;
    private final Float j;
    private final Location k;
    private final Integer l;
    private final Integer m;
    private final String n;
    private final String o;
    private final AdRequest p;
    private final Integer q;
    private final Integer r;
    private final String s;
    private final Boolean t;
    private final String u;
    private final Boolean v;
    private final String w;
    private final Integer x;
    private final String y;
    private final String z;

    public static final class a<T> {
        private Boolean A;
        private String B;
        private Integer C;
        private String D;
        private String E;
        private String F;
        private String G;
        private String H;
        private String I;
        private Long J;
        private String K;
        private String L;
        private String M;
        @Nullable
        private String N;
        private String O;
        private String P;
        private String Q;
        private String R;
        private String S;
        private String T;
        private String U;
        private String V;
        private String W;
        private String X;
        private int Y;
        private String Z;
        @NonNull
        private final ga a;
        private String aa;
        private String ab;
        private String ac;
        @NonNull
        private final z b;
        private final boolean c;
        @NonNull
        private final Map<String, String> d;
        @Nullable
        private Boolean e;
        private String f;
        private String g;
        private String h;
        private Integer i;
        private Integer j;
        private String k;
        private String l;
        private Location m;
        private Integer n;
        private Integer o;
        private Float p;
        private Integer q;
        private Integer r;
        private String s;
        private String t;
        private AdRequest u;
        private Integer v;
        private Integer w;
        private String x;
        private Boolean y;
        private String z;

        public /* synthetic */ a(boolean z2, byte b2) {
            this(z2);
        }

        private a(boolean z2) {
            this.d = new HashMap();
            this.c = z2;
            this.a = new ga();
            this.b = new z();
        }

        @NonNull
        public final a<T> a(String str) {
            this.f = str;
            return this;
        }

        @NonNull
        public final a<T> b(@Nullable String str) {
            this.g = str;
            return this;
        }

        @NonNull
        public final a<T> c(String str) {
            this.L = str;
            return this;
        }

        @NonNull
        public final a<T> d(Context context) {
            this.q = ea.a(context);
            this.r = ea.b(context);
            this.s = ea.d(context);
            this.t = ea.c(context);
            return this;
        }

        @NonNull
        public final a<T> e(Context context) {
            this.v = ea.e(context);
            this.w = ea.f(context);
            this.x = ea.g(context);
            return this;
        }

        @NonNull
        public final a<T> f(String str) {
            this.K = str;
            return this;
        }

        @NonNull
        public final a<T> a(b bVar) {
            if (bVar != null) {
                this.h = bVar.a();
            }
            return this;
        }

        @NonNull
        public final a<T> b(Context context) {
            this.n = Integer.valueOf(eg.c(context));
            this.o = Integer.valueOf(eg.d(context));
            this.p = Float.valueOf(eg.e(context));
            this.Y = context.getResources().getDisplayMetrics().densityDpi;
            return this;
        }

        @NonNull
        public final a<T> c(Context context) {
            if (1 == context.getResources().getConfiguration().orientation) {
                this.l = "portrait";
            } else {
                this.l = "landscape";
            }
            return this;
        }

        @NonNull
        public final a<T> f(Context context) {
            this.U = context.getPackageName();
            this.V = du.a(context);
            this.W = du.b(context);
            return this;
        }

        @NonNull
        public final a<T> a(@NonNull Context context, @Nullable am amVar) {
            if (amVar != null) {
                this.k = amVar.c().a();
                this.i = Integer.valueOf(amVar.b(context));
                this.j = Integer.valueOf(amVar.a(context));
            }
            return this;
        }

        @Nullable
        private static String c(@Nullable String[] strArr) {
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            String str = "";
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(str);
                    sb.append(str2);
                    str = ",";
                }
            }
            return sb.toString();
        }

        @NonNull
        public final a<T> a(@NonNull Context context) {
            this.m = this.c ? null : hd.a(context).a();
            return this;
        }

        @NonNull
        public final a<T> b(@Nullable String[] strArr) {
            this.G = c(strArr);
            return this;
        }

        @NonNull
        public final a<T> e(@Nullable String str) {
            this.N = str;
            return this;
        }

        @NonNull
        public final a<T> a(Integer num) {
            this.C = num;
            return this;
        }

        @NonNull
        public final a<T> b() {
            this.ab = MobileAds.getLibraryVersion();
            return this;
        }

        @NonNull
        public final a<T> a(@Nullable AdRequest adRequest) {
            String str;
            if (adRequest != null) {
                String str2 = null;
                this.u = this.c ? null : adRequest;
                String contextQuery = adRequest.getContextQuery();
                if (!TextUtils.isEmpty(contextQuery)) {
                    String encode = Uri.encode(contextQuery);
                    if (encode != null && encode.length() > 1024) {
                        ij.b("Exceeded the length of the parameter! The maximum size of the parameter is %s bytes. First %s bytes of the parameter will be used", 1024, 1024);
                        String encode2 = Uri.encode(" ");
                        String substring = encode.substring(0, 1024);
                        encode = encode.startsWith(encode2, 1024) ? substring : substring.substring(0, substring.lastIndexOf(encode2));
                    }
                    str = Uri.decode(encode);
                } else {
                    str = null;
                }
                this.D = str;
                List<String> contextTags = adRequest.getContextTags();
                StringBuilder sb = new StringBuilder();
                if (contextTags != null) {
                    String str3 = "";
                    for (String str4 : contextTags) {
                        if (!TextUtils.isEmpty(str4)) {
                            a2.b.a.a.a.m1(sb, str3, str4, "\n");
                            str3 = ExifInterface.GPS_MEASUREMENT_3D;
                        }
                    }
                }
                String sb2 = sb.toString();
                if (!TextUtils.isEmpty(sb2)) {
                    String encode3 = Uri.encode(sb2);
                    if (encode3 != null && encode3.length() > 2048) {
                        ij.b("Exceeded the length of the parameter! The maximum size of the parameter is %s bytes. First %s bytes of the parameter will be used", 2048, 2048);
                        String encode4 = Uri.encode("\n");
                        encode3 = encode3.substring(0, 2048);
                        if (!encode3.endsWith(encode4)) {
                            encode3 = encode3.substring(0, encode3.lastIndexOf(encode4));
                        }
                    }
                    str2 = Uri.decode(encode3);
                }
                this.E = str2;
                this.Z = cj.a(adRequest.getAge());
                this.aa = cj.a(adRequest.getGender());
                a(cj.a(adRequest.getParameters()));
            }
            return this;
        }

        @NonNull
        public final a<T> b(@Nullable gq gqVar) {
            if (gqVar != null) {
                Boolean valueOf = Boolean.valueOf(gqVar.b());
                this.A = valueOf;
                if (!this.c && !valueOf.booleanValue()) {
                    this.B = gqVar.a();
                }
            }
            return this;
        }

        public final a<T> d(@Nullable String str) {
            this.M = str;
            return this;
        }

        @NonNull
        public final String d() {
            return new ae(this, (byte) 0).toString();
        }

        @NonNull
        public final a<T> c() {
            this.e = fy.a().e();
            return this;
        }

        @NonNull
        public final a<T> a(@Nullable String[] strArr) {
            this.F = c(strArr);
            return this;
        }

        @NonNull
        public final a<T> a(@Nullable af afVar) {
            if (afVar != null) {
                this.H = afVar.a();
            }
            return this;
        }

        @NonNull
        public final a<T> a(@Nullable ag agVar) {
            if (agVar != null && ag.PROMO == agVar) {
                this.I = agVar.a();
            }
            return this;
        }

        @NonNull
        public final a<T> a(@Nullable Map<String, String> map) {
            if (map != null) {
                this.d.putAll(map);
            }
            return this;
        }

        @NonNull
        public final a<T> a(@NonNull Context context, @Nullable String str) {
            this.O = this.a.a(context);
            this.P = "android";
            this.Q = Build.VERSION.RELEASE;
            this.R = Build.MANUFACTURER;
            this.S = Build.MODEL;
            this.T = gc.a(context);
            if (this.c) {
                str = null;
            }
            this.X = str;
            return this;
        }

        @NonNull
        public final a<T> a() {
            this.ac = z.a();
            return this;
        }

        @NonNull
        public final a<T> a(@Nullable gq gqVar) {
            if (gqVar != null) {
                Boolean valueOf = Boolean.valueOf(gqVar.b());
                this.y = valueOf;
                if (!this.c && !valueOf.booleanValue()) {
                    this.z = gqVar.a();
                }
            }
            return this;
        }

        @NonNull
        public final a<T> a(long j2) {
            this.J = Long.valueOf(j2);
            return this;
        }
    }

    public /* synthetic */ ae(a aVar, byte b2) {
        this(aVar);
    }

    public static a<?> a(boolean z2) {
        return new a<>(z2, (byte) 0);
    }

    public final String toString() {
        if (!TextUtils.isEmpty(this.aa)) {
            return this.aa.toString();
        }
        this.aa = new StringBuilder();
        a("ad_unit_id", this.a);
        a("uuid", this.b);
        a(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.d);
        a(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.e);
        a("ad_size_type", this.f);
        a("orientation", this.g);
        a("screen_width", this.h);
        a("screen_height", this.i);
        a("scalefactor", this.j);
        a("mcc", this.l);
        a("mnc", this.m);
        a(AppEventsConstants.EVENT_PARAM_AD_TYPE, this.c);
        a("network_type", this.n);
        a("carrier", this.o);
        a("cellid", this.q);
        a("lac", this.r);
        a("wifi", this.s);
        a("dnt", this.t);
        a("google_aid", this.u);
        a("huawei_dnt", this.v);
        a("huawei_oaid", this.w);
        a("battery_charge", this.x);
        a("context_query", this.y);
        a("context_taglist", this.z);
        a("image_sizes", this.A);
        a("app_supported_features", this.B);
        a("response_ad_format", this.C);
        a("ad_source", this.D);
        a("debug_yandexuid", this.H);
        a("user_id", this.I);
        a("session_random", this.F);
        a("charset", this.G);
        a("device_type", this.K);
        a("os_name", this.L);
        a("os_version", this.M);
        a("manufacturer", this.N);
        a(VerticalFilterCloseDialogEventKt.MODEL_DIALOG, this.O);
        a("locale", this.P);
        a("app_id", this.Q);
        a("app_version_code", this.R);
        a("app_version_name", this.S);
        a("appmetrica_version", this.Z);
        a("device-id", this.T);
        a("screen_dpi", this.U);
        a("age", this.V);
        a("gender", this.W);
        a("user_consent", this.X);
        a("autograb", this.J);
        a("sdk_version", this.Y);
        a(this.E);
        AdRequest adRequest = this.p;
        if (adRequest != null) {
            a(adRequest.getLocation());
        }
        AdRequest adRequest2 = this.p;
        if (adRequest2 == null || adRequest2.getLocation() == null) {
            a(this.k);
        }
        return this.aa.toString();
    }

    private ae(a<?> aVar) {
        this.a = ((a) aVar).f;
        this.b = ((a) aVar).g;
        this.c = ((a) aVar).h;
        this.d = ((a) aVar).i;
        this.e = ((a) aVar).j;
        this.f = ((a) aVar).k;
        this.g = ((a) aVar).l;
        this.h = ((a) aVar).n;
        this.i = ((a) aVar).o;
        this.j = ((a) aVar).p;
        this.k = ((a) aVar).m;
        this.l = ((a) aVar).q;
        this.m = ((a) aVar).r;
        this.n = ((a) aVar).s;
        this.o = ((a) aVar).t;
        this.p = ((a) aVar).u;
        this.q = ((a) aVar).v;
        this.r = ((a) aVar).w;
        this.s = ((a) aVar).x;
        this.t = ((a) aVar).y;
        this.u = ((a) aVar).z;
        this.v = ((a) aVar).A;
        this.w = ((a) aVar).B;
        this.x = ((a) aVar).C;
        this.y = ((a) aVar).D;
        this.z = ((a) aVar).E;
        this.A = ((a) aVar).F;
        this.B = ((a) aVar).G;
        this.C = ((a) aVar).H;
        this.D = ((a) aVar).I;
        this.E = ((a) aVar).d;
        this.F = ((a) aVar).J;
        this.G = ((a) aVar).K;
        this.H = ((a) aVar).L;
        this.I = ((a) aVar).M;
        this.J = ((a) aVar).N;
        this.K = ((a) aVar).O;
        this.L = ((a) aVar).P;
        this.M = ((a) aVar).Q;
        this.N = ((a) aVar).R;
        this.O = ((a) aVar).S;
        this.P = ((a) aVar).T;
        this.Q = ((a) aVar).U;
        this.R = ((a) aVar).V;
        this.S = ((a) aVar).W;
        this.T = ((a) aVar).X;
        this.U = Integer.valueOf(((a) aVar).Y);
        this.V = ((a) aVar).Z;
        this.W = ((a) aVar).aa;
        this.X = ((a) aVar).e;
        this.Z = ((a) aVar).ac;
        this.Y = ((a) aVar).ab;
    }

    private void a(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        }
    }

    private void a(String str, Object obj) {
        if (obj != null) {
            a();
            StringBuilder sb = this.aa;
            sb.append(Uri.encode(str));
            sb.append("=");
            sb.append(Uri.encode(obj.toString()));
        }
    }

    private void a(String str, Boolean bool) {
        if (bool != null) {
            a(str, Integer.valueOf(bool.booleanValue() ? 1 : 0));
        }
    }

    private void a(Location location) {
        if (location != null) {
            a("lat", String.valueOf(location.getLatitude()));
            a(MessageBody.Location.LONGITUDE, String.valueOf(location.getLongitude()));
            a("location_timestamp", String.valueOf(location.getTime()));
            a("precision", String.valueOf((int) location.getAccuracy()));
        }
    }

    private void a() {
        StringBuilder sb = this.aa;
        sb.append(TextUtils.isEmpty(sb) ? "" : "&");
    }

    @Nullable
    public static String a(@NonNull fo foVar) {
        String f2 = foVar.f();
        if (TextUtils.isEmpty(f2)) {
            return null;
        }
        StringBuilder L2 = a2.b.a.a.a.L(f2);
        String str = "/";
        if (f2.endsWith(str)) {
            str = "";
        }
        return a2.b.a.a.a.t(L2, str, "v4/ad");
    }

    @NonNull
    public static a a(@NonNull Context context, @NonNull fo foVar) {
        return a(fq.a(context)).a(foVar.c()).a(foVar.a()).a(foVar.i()).b(foVar.j()).f(context).a().a(ea.h(context)).a(foVar.e()).f("UTF-8").c(foVar.h()).a(context, foVar.g()).a(foVar.o()).e(context).a(context).c(context).d(context).a(foVar.p()).b(context).b().a(dt.a).a(context, foVar.b()).a(foVar.q()).b(foVar.s()).d(foVar.t()).e(foVar.v()).b(foVar.d());
    }
}
