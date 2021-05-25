package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.avito.android.BuildConfig;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.yandex.metrica.impl.ob.pc;
import java.util.Map;
public class wn implements wj<wf> {
    @NonNull
    private final wd a;

    public wn(@NonNull wd wdVar) {
        this.a = wdVar;
    }

    public void a(@NonNull Uri.Builder builder, @NonNull wf wfVar) {
        builder.path("analytics/startup");
        builder.appendQueryParameter(this.a.a("deviceid"), wfVar.s());
        builder.appendQueryParameter(this.a.a("deviceid2"), wfVar.t());
        a(builder, as.a().i(), wfVar);
        builder.appendQueryParameter(this.a.a("app_platform"), wfVar.m());
        builder.appendQueryParameter(this.a.a("protocol_version"), wfVar.i());
        builder.appendQueryParameter(this.a.a("analytics_sdk_version_name"), wfVar.j());
        builder.appendQueryParameter(this.a.a(VerticalFilterCloseDialogEventKt.MODEL_DIALOG), wfVar.n());
        builder.appendQueryParameter(this.a.a("manufacturer"), wfVar.h());
        builder.appendQueryParameter(this.a.a("os_version"), wfVar.o());
        builder.appendQueryParameter(this.a.a("screen_width"), String.valueOf(wfVar.x()));
        builder.appendQueryParameter(this.a.a("screen_height"), String.valueOf(wfVar.y()));
        builder.appendQueryParameter(this.a.a("screen_dpi"), String.valueOf(wfVar.z()));
        builder.appendQueryParameter(this.a.a("scalefactor"), String.valueOf(wfVar.A()));
        builder.appendQueryParameter(this.a.a("locale"), wfVar.B());
        builder.appendQueryParameter(this.a.a("device_type"), wfVar.D());
        builder.appendQueryParameter(this.a.a("queries"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("query_hosts"), String.valueOf(2));
        builder.appendQueryParameter(this.a.a("features"), dh.b(this.a.a("easy_collecting"), this.a.a("package_info"), this.a.a("socket"), this.a.a("permissions_collecting"), this.a.a("features_collecting"), this.a.a("location_collecting"), this.a.a("wakeup"), this.a.a("lbs_collecting"), this.a.a("telephony_restricted_to_location_tracking"), this.a.a("android_id"), this.a.a("google_aid"), this.a.a("wifi_around"), this.a.a("wifi_connected"), this.a.a("own_macs"), this.a.a("cells_around"), this.a.a("sim_info"), this.a.a("sim_imei"), this.a.a("access_point"), this.a.a("sdk_list"), this.a.a("identity_light_collecting"), this.a.a("ble_collecting"), this.a.a("gpl_collecting"), this.a.a("ui_parsing"), this.a.a("ui_collecting_for_bridge"), this.a.a("ui_event_sending")));
        builder.appendQueryParameter(this.a.a("socket"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("app_id"), wfVar.d());
        builder.appendQueryParameter(this.a.a("location_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("app_debuggable"), wfVar.G());
        builder.appendQueryParameter(this.a.a("sdk_list"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("wakeup"), String.valueOf(1));
        if (wfVar.b()) {
            String O = wfVar.O();
            if (!TextUtils.isEmpty(O)) {
                builder.appendQueryParameter(this.a.a("country_init"), O);
            }
        } else {
            builder.appendQueryParameter(this.a.a("detect_locale"), String.valueOf(1));
        }
        Map<String, String> J = wfVar.J();
        String K = wfVar.K();
        if (!dl.a((Map) J)) {
            builder.appendQueryParameter(this.a.a("distribution_customization"), String.valueOf(1));
            a(builder, "clids_set", abq.a(J));
            if (!TextUtils.isEmpty(K)) {
                builder.appendQueryParameter(this.a.a(Constants.INSTALL_REFERRER), K);
                builder.appendQueryParameter(this.a.a("install_referrer_source"), (String) abw.b(wfVar.L(), BuildConfig.ADJUST_DEFAULT_TRACKER));
            }
        }
        a(builder, "uuid", wfVar.u());
        builder.appendQueryParameter(this.a.a("time"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("requests"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("stat_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("permissions"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("identity_light_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("ble_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("ui_parsing"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("ui_collecting_for_bridge"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("ui_event_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("retry_policy"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("app_system_flag"), wfVar.H());
    }

    public void a(@NonNull Uri.Builder builder, @NonNull df dfVar, @NonNull wf wfVar) {
        Map<pc.a, pc> E = wfVar.E();
        if (dfVar.a()) {
            for (String str : wg.a.values()) {
                builder.appendQueryParameter(this.a.a(str), "");
            }
            return;
        }
        pc.a[] values = pc.a.values();
        for (int i = 0; i < 2; i++) {
            pc.a aVar = values[i];
            a(builder, E.get(aVar), wg.a.get(aVar));
        }
    }

    private void a(@NonNull Uri.Builder builder, @Nullable pc pcVar, @NonNull String str) {
        if (pcVar == null || TextUtils.isEmpty(pcVar.b)) {
            builder.appendQueryParameter(this.a.a(str), "");
        } else {
            builder.appendQueryParameter(this.a.a(str), pcVar.b);
        }
    }

    private void a(Uri.Builder builder, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            builder.appendQueryParameter(this.a.a(str), str2);
        }
    }
}
