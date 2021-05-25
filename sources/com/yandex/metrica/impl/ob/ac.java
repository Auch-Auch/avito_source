package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.avito.android.db.SearchSubscriptionsContract;
import com.vk.sdk.api.VKApiConst;
import com.yandex.metrica.impl.ob.i;
import com.yandex.metrica.impl.ob.qm;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class ac {
    @NonNull
    private final Context a;
    @NonNull
    private final p b;
    @NonNull
    private final k c;
    @NonNull
    private final qp d;
    @NonNull
    private final Cdo e;
    @NonNull
    private final dn f;
    private ContentValues g;
    private we h;

    public ac(Context context) {
        this(context, as.a().n(), as.a().o(), qp.a(context), dn.a(context));
    }

    private void d() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
        } catch (Throwable unused) {
            jSONObject = new JSONObject();
        }
        this.g.put("report_request_parameters", jSONObject.toString());
    }

    private void e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enabled", this.h.Q());
            dp b2 = b();
            if (b2 != null) {
                a(jSONObject, b2);
            }
            this.g.put("location_info", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    private void f() {
        JSONArray jSONArray = (JSONArray) this.e.a();
        if (jSONArray != null) {
            this.g.put("wifi_network_info", jSONArray.toString());
        }
    }

    private void g() {
        zk l = as.a().l();
        l.a(new zn() { // from class: com.yandex.metrica.impl.ob.ac.2
            @Override // com.yandex.metrica.impl.ob.zn
            public void a(zm zmVar) {
                zb b2 = zmVar.b();
                if (b2 != null) {
                    ac.this.g.put("cellular_connection_type", b2.g());
                }
            }
        });
        a(l);
    }

    private void h() {
        g();
        f();
        c();
    }

    private void i() {
        this.g.put("battery_charge_type", Integer.valueOf(this.b.d().a()));
    }

    private void j() {
        this.g.put("collection_mode", qm.a.a(this.c.c()).a());
    }

    @VisibleForTesting
    public dp b() {
        Location location;
        dp dpVar = null;
        if (this.h.Q()) {
            location = this.h.R();
            if (location == null) {
                location = this.d.a();
            } else {
                dpVar = dp.a(location);
            }
        } else {
            location = null;
        }
        return (dpVar != null || location == null) ? dpVar : dp.b(location);
    }

    @VisibleForTesting
    public void c() {
        String b2 = this.f.b(this.a);
        if (!TextUtils.isEmpty(b2)) {
            int c2 = this.f.c(this.a);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SearchSubscriptionsContract.Columns.SSID, b2);
                jSONObject.put("state", c2);
                this.g.put("wifi_access_point", jSONObject.toString());
            } catch (Throwable unused) {
            }
        }
    }

    public ac a(ContentValues contentValues) {
        this.g = contentValues;
        return this;
    }

    public ac a(@NonNull we weVar) {
        this.h = weVar;
        return this;
    }

    public void a() {
        d();
    }

    private void a(@NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.putOpt("dId", this.h.s()).putOpt("uId", this.h.u()).putOpt("appVer", this.h.r()).putOpt("appBuild", this.h.q()).putOpt("analyticsSdkVersionName", this.h.j()).putOpt("kitBuildNumber", this.h.k()).putOpt("kitBuildType", this.h.l()).putOpt("osVer", this.h.o()).putOpt("osApiLev", Integer.valueOf(this.h.p())).putOpt(VKApiConst.LANG, this.h.B()).putOpt("root", this.h.v()).putOpt("app_debuggable", this.h.G()).putOpt("app_framework", this.h.w()).putOpt("attribution_id", Integer.valueOf(this.h.Y())).putOpt("commit_hash", this.h.F());
    }

    @VisibleForTesting
    public ac(@NonNull Context context, @NonNull p pVar, @NonNull k kVar, @NonNull qp qpVar, @NonNull dn dnVar) {
        this.a = context;
        this.b = pVar;
        this.c = kVar;
        this.d = qpVar;
        this.f = dnVar;
        this.e = dnVar.d();
    }

    private void a(@NonNull JSONObject jSONObject, @NonNull dp dpVar) throws JSONException {
        abc.a(jSONObject, dpVar);
    }

    private void a(za zaVar) {
        zaVar.a(new zc() { // from class: com.yandex.metrica.impl.ob.ac.1
            @Override // com.yandex.metrica.impl.ob.zc
            public void a(zb[] zbVarArr) {
                ac.this.g.put("cell_info", abc.a(zbVarArr).toString());
            }
        });
    }

    private void a(i.a aVar) {
        this.g.put("app_environment", aVar.a);
        this.g.put("app_environment_revision", Long.valueOf(aVar.b));
    }

    public void a(@NonNull aci aci, @NonNull i.a aVar) {
        aa aaVar = aci.a;
        this.g.put("name", aaVar.d());
        this.g.put("value", aaVar.e());
        this.g.put("type", Integer.valueOf(aaVar.g()));
        this.g.put("custom_type", Integer.valueOf(aaVar.h()));
        this.g.put("error_environment", aaVar.j());
        this.g.put("user_info", aaVar.l());
        this.g.put("truncated", Integer.valueOf(aaVar.o()));
        this.g.put("connection_type", Integer.valueOf(cg.e(this.a)));
        this.g.put("profile_id", aaVar.p());
        this.g.put("encrypting_mode", Integer.valueOf(aci.b.a()));
        this.g.put("first_occurrence_status", Integer.valueOf(aci.a.q().d));
        a(aVar);
        e();
        h();
        i();
        j();
    }
}
