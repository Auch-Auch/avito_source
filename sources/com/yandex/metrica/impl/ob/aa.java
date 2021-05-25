package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Base64;
import android.util.Pair;
import com.yandex.metrica.impl.ob.al;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
public class aa implements Parcelable {
    public static final Parcelable.Creator<aa> CREATOR = new Parcelable.Creator<aa>() { // from class: com.yandex.metrica.impl.ob.aa.1
        /* renamed from: a */
        public aa createFromParcel(Parcel parcel) {
            Bundle readBundle = parcel.readBundle(ab.class.getClassLoader());
            aa a3 = new aa().a(readBundle.getInt("CounterReport.Type", al.a.EVENT_TYPE_UNDEFINED.a())).b(readBundle.getInt("CounterReport.CustomType")).c(dh.b(readBundle.getString("CounterReport.Value"), "")).a(readBundle.getString("CounterReport.UserInfo")).e(readBundle.getString("CounterReport.Environment")).b(readBundle.getString("CounterReport.Event")).a(aa.d(readBundle)).c(readBundle.getInt("CounterReport.TRUNCATED")).d(readBundle.getString("CounterReport.ProfileID")).a(readBundle.getLong("CounterReport.CreationElapsedRealtime")).b(readBundle.getLong("CounterReport.CreationTimestamp")).a(ap.a(Integer.valueOf(readBundle.getInt("CounterReport.UniquenessStatus"))));
            ba baVar = (ba) readBundle.getParcelable("CounterReport.IdentifiersData");
            if (baVar != null) {
                a3.a(baVar);
            }
            return a3;
        }

        /* renamed from: a */
        public aa[] newArray(int i2) {
            return new aa[i2];
        }
    };
    public String a;
    public String b;
    public int c;
    public int d;
    public int e;
    private String f;
    private String g;
    @Nullable
    private Pair<String, String> h;
    private String i;
    private long j;
    private long k;
    @NonNull
    private ap l;
    @Nullable
    private ba m;

    public aa() {
        this("", 0);
    }

    public static aa t() {
        return new aa().a(al.a.EVENT_TYPE_UPDATE_PRE_ACTIVATION_CONFIG.a());
    }

    public aa b(String str) {
        this.a = str;
        return this;
    }

    public String d() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.b;
    }

    public byte[] f() {
        return Base64.decode(this.b, 0);
    }

    public int g() {
        return this.c;
    }

    public int h() {
        return this.d;
    }

    @Nullable
    public ba i() {
        return this.m;
    }

    public String j() {
        return this.g;
    }

    public Pair<String, String> k() {
        return this.h;
    }

    public String l() {
        return this.f;
    }

    public boolean m() {
        return this.a == null;
    }

    public boolean n() {
        return al.a.EVENT_TYPE_UNDEFINED.a() == this.c;
    }

    public int o() {
        return this.e;
    }

    @Nullable
    public String p() {
        return this.i;
    }

    @NonNull
    public ap q() {
        return this.l;
    }

    public long r() {
        return this.j;
    }

    public long s() {
        return this.k;
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format(Locale.US, "[event: %s, type: %s, value: %s]", this.a, al.a.a(this.c).b(), this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("CounterReport.Event", this.a);
        bundle.putString("CounterReport.Value", this.b);
        bundle.putInt("CounterReport.Type", this.c);
        bundle.putInt("CounterReport.CustomType", this.d);
        bundle.putInt("CounterReport.TRUNCATED", this.e);
        bundle.putString("CounterReport.ProfileID", this.i);
        bundle.putInt("CounterReport.UniquenessStatus", this.l.d);
        ba baVar = this.m;
        if (baVar != null) {
            bundle.putParcelable("CounterReport.IdentifiersData", baVar);
        }
        String str = this.g;
        if (str != null) {
            bundle.putString("CounterReport.Environment", str);
        }
        String str2 = this.f;
        if (str2 != null) {
            bundle.putString("CounterReport.UserInfo", str2);
        }
        Pair<String, String> pair = this.h;
        if (pair != null) {
            a(bundle, pair);
        }
        bundle.putLong("CounterReport.CreationElapsedRealtime", this.j);
        bundle.putLong("CounterReport.CreationTimestamp", this.k);
        parcel.writeBundle(bundle);
    }

    public aa(@Nullable aa aaVar) {
        this.l = ap.UNKNOWN;
        if (aaVar != null) {
            this.a = aaVar.d();
            this.b = aaVar.e();
            this.c = aaVar.g();
            this.d = aaVar.h();
            this.f = aaVar.l();
            this.g = aaVar.j();
            this.h = aaVar.k();
            this.e = aaVar.o();
            this.i = aaVar.i;
            this.j = aaVar.r();
            this.k = aaVar.s();
            this.l = aaVar.l;
            this.m = aaVar.m;
        }
    }

    public aa a(@Nullable byte[] bArr) {
        this.b = new String(Base64.encode(bArr, 0));
        return this;
    }

    public aa b(int i2) {
        this.d = i2;
        return this;
    }

    public aa c(String str) {
        this.b = str;
        return this;
    }

    public aa d(@Nullable String str) {
        this.i = str;
        return this;
    }

    public aa e(String str) {
        this.g = str;
        return this;
    }

    /* access modifiers changed from: private */
    @Nullable
    public static Pair<String, String> d(Bundle bundle) {
        if (!bundle.containsKey("CounterReport.AppEnvironmentDiffKey") || !bundle.containsKey("CounterReport.AppEnvironmentDiffValue")) {
            return null;
        }
        return new Pair<>(bundle.getString("CounterReport.AppEnvironmentDiffKey"), bundle.getString("CounterReport.AppEnvironmentDiffValue"));
    }

    public static aa e(aa aaVar) {
        return a(aaVar, al.a.EVENT_TYPE_APP_UPDATE);
    }

    public aa a(int i2) {
        this.c = i2;
        return this;
    }

    public aa b(String str, String str2) {
        if (this.h == null) {
            this.h = new Pair<>(str, str2);
        }
        return this;
    }

    public aa c(int i2) {
        this.e = i2;
        return this;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private aa a(@Nullable Pair<String, String> pair) {
        this.h = pair;
        return this;
    }

    public static aa c(aa aaVar) {
        return a(aaVar, al.a.EVENT_TYPE_INIT);
    }

    public aa a(String str) {
        this.f = str;
        return this;
    }

    public aa b(long j2) {
        this.k = j2;
        return this;
    }

    @NonNull
    public static aa b(Bundle bundle) {
        if (bundle != null) {
            try {
                aa aaVar = (aa) bundle.getParcelable("CounterReport.Object");
                if (aaVar != null) {
                    return aaVar;
                }
            } catch (Throwable unused) {
                return new aa();
            }
        }
        return new aa();
    }

    public aa a(long j2) {
        this.j = j2;
        return this;
    }

    public aa a(@NonNull ba baVar) {
        this.m = baVar;
        return this;
    }

    public static aa d(aa aaVar) {
        return a(aaVar, al.a.EVENT_TYPE_FIRST_ACTIVATION);
    }

    @NonNull
    public aa a(@NonNull ap apVar) {
        this.l = apVar;
        return this;
    }

    public static aa b(aa aaVar) {
        return a(aaVar, al.a.EVENT_TYPE_ALIVE);
    }

    @NonNull
    public Bundle a(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putParcelable("CounterReport.Object", this);
        return bundle;
    }

    private static void a(@NonNull Bundle bundle, @NonNull Pair<String, String> pair) {
        bundle.putString("CounterReport.AppEnvironmentDiffKey", (String) pair.first);
        bundle.putString("CounterReport.AppEnvironmentDiffValue", (String) pair.second);
    }

    public static aa a(aa aaVar, al.a aVar) {
        aa a3 = a(aaVar);
        a3.a(aVar.a());
        return a3;
    }

    public static aa a(@NonNull aa aaVar) {
        aa aaVar2 = new aa(aaVar);
        aaVar2.b("");
        aaVar2.c("");
        return aaVar2;
    }

    public aa(String str, int i2) {
        this("", str, i2);
    }

    public aa(String str, String str2, int i2) {
        this(str, str2, i2, new abs());
    }

    public static aa a(aa aaVar, @NonNull am amVar) {
        aa a3 = a(aaVar, al.a.EVENT_TYPE_START);
        a3.a(e.a(new ak().b(new aj(amVar.a()))));
        return a3;
    }

    @VisibleForTesting
    public aa(String str, String str2, int i2, abs abs) {
        this.l = ap.UNKNOWN;
        this.a = str2;
        this.c = i2;
        this.b = str;
        this.j = abs.c();
        this.k = abs.a();
    }

    public static aa a(@NonNull Context context) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            Integer c2 = as.a().n().c();
            if (c2 != null) {
                jSONObject2.put("battery", c2);
            }
            jSONObject2.put("boot_time_seconds", abu.d());
            jSONObject.put("dfid", jSONObject2);
        } catch (Throwable unused) {
        }
        aa b2 = new aa().b("");
        b2.a(al.a.EVENT_TYPE_IDENTITY_LIGHT.a()).c(jSONObject.toString());
        return b2;
    }

    public static aa a(aa aaVar, fe feVar) {
        bc a3 = new bc(feVar.k()).a();
        try {
            if (feVar.w()) {
                a3.e();
            }
            we i2 = feVar.i();
            if (i2.I()) {
                a3.a(i2.J());
            }
            a3.c();
        } catch (Throwable unused) {
        }
        aa a4 = a(aaVar);
        a4.a(al.a.EVENT_TYPE_IDENTITY.a()).c(a3.g());
        return a4;
    }

    public static aa a(aa aaVar, @NonNull Collection<sr> collection, @Nullable m mVar, @NonNull j jVar, @NonNull List<String> list) {
        String str;
        aa a3 = a(aaVar);
        try {
            JSONArray jSONArray = new JSONArray();
            for (sr srVar : collection) {
                jSONArray.put(new JSONObject().put("name", srVar.a).put("granted", srVar.b));
            }
            JSONObject jSONObject = new JSONObject();
            if (mVar != null) {
                jSONObject.put("background_restricted", mVar.b);
                jSONObject.put("app_standby_bucket", jVar.a(mVar.a));
            }
            str = new JSONObject().put("permissions", jSONArray).put("background_restrictions", jSONObject).put("available_providers", new JSONArray((Collection) list)).toString();
        } catch (Throwable unused) {
            str = "";
        }
        return a3.a(al.a.EVENT_TYPE_PERMISSIONS.a()).c(str);
    }

    public static aa a(aa aaVar, String str) {
        return a(aaVar).a(al.a.EVENT_TYPE_APP_FEATURES.a()).c(str);
    }
}
