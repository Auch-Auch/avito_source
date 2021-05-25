package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.abc;
import com.yandex.metrica.impl.ob.ve;
import com.yandex.metrica.impl.ob.xk;
import org.json.JSONException;
import org.json.JSONObject;
public class yk {
    public void a(@NonNull yx yxVar, @NonNull abc.a aVar) {
        ve.a.b bVar = new ve.a.b();
        try {
            JSONObject optJSONObject = ((JSONObject) aVar.a("features", new JSONObject())).optJSONObject("list");
            if (optJSONObject != null) {
                xk a = new xk.a().a(a(optJSONObject, "easy_collecting", bVar.b)).b(a(optJSONObject, "package_info", bVar.c)).c(a(optJSONObject, "permissions_collecting", bVar.d)).d(a(optJSONObject, "features_collecting", bVar.e)).e(a(optJSONObject, "sdk_list", bVar.o)).f(a(optJSONObject, "ble_collecting", bVar.q)).g(a(optJSONObject, "android_id", bVar.f)).h(a(optJSONObject, "google_aid", bVar.g)).i(a(optJSONObject, "wifi_around", bVar.h)).j(a(optJSONObject, "wifi_connected", bVar.i)).k(a(optJSONObject, "own_macs", bVar.j)).l(a(optJSONObject, "cells_around", bVar.k)).m(a(optJSONObject, "sim_info", bVar.l)).n(a(optJSONObject, "sim_imei", bVar.m)).o(a(optJSONObject, "access_point", bVar.n)).p(a(optJSONObject, "identity_light_collecting", bVar.p)).q(a(optJSONObject, "location_collecting", bVar.r)).r(a(optJSONObject, "lbs_collecting", bVar.s)).t(a(optJSONObject, "gpl_collecting", bVar.u)).s(a(optJSONObject, "wakeup", bVar.t)).u(a(optJSONObject, "ui_parsing", bVar.v)).v(a(optJSONObject, "ui_event_sending", bVar.w)).w(a(optJSONObject, "ui_collecting_for_bridge", bVar.x)).a();
                yxVar.a(a(optJSONObject, "socket", false));
                yxVar.a(a);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean a(JSONObject jSONObject, String str, boolean z) throws JSONException {
        return jSONObject.has(str) ? jSONObject.getJSONObject(str).optBoolean("enabled", z) : z;
    }
}
