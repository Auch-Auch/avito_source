package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
public class wm extends wl<we> {
    private wh a = new wh();
    @Nullable
    private wc b;
    private int c;

    private void b(@NonNull Uri.Builder builder, @NonNull we weVar) {
        wc wcVar = this.b;
        if (wcVar != null) {
            a(builder, "deviceid", wcVar.a, weVar.s());
            a(builder, "uuid", this.b.b, weVar.u());
            a(builder, "analytics_sdk_version", this.b.c);
            a(builder, "analytics_sdk_version_name", this.b.d);
            a(builder, "app_version_name", this.b.g, weVar.r());
            a(builder, "app_build_number", this.b.i, weVar.q());
            a(builder, "os_version", this.b.j, weVar.o());
            a(builder, "os_api_level", this.b.k);
            a(builder, "analytics_sdk_build_number", this.b.e);
            a(builder, "analytics_sdk_build_type", this.b.f);
            a(builder, "app_debuggable", this.b.h);
            a(builder, "locale", this.b.l, weVar.B());
            a(builder, "is_rooted", this.b.m, weVar.v());
            a(builder, "app_framework", this.b.n, weVar.w());
            a(builder, "attribution_id", this.b.o);
            wc wcVar2 = this.b;
            a(wcVar2.f, wcVar2.p, builder);
        }
    }

    private void c(@NonNull Uri.Builder builder, @NonNull we weVar) {
        builder.appendQueryParameter("api_key_128", weVar.c());
        builder.appendQueryParameter("app_id", weVar.d());
        builder.appendQueryParameter("app_platform", weVar.m());
        builder.appendQueryParameter(VerticalFilterCloseDialogEventKt.MODEL_DIALOG, weVar.n());
        builder.appendQueryParameter("manufacturer", weVar.h());
        builder.appendQueryParameter("screen_width", String.valueOf(weVar.x()));
        builder.appendQueryParameter("screen_height", String.valueOf(weVar.y()));
        builder.appendQueryParameter("screen_dpi", String.valueOf(weVar.z()));
        builder.appendQueryParameter("scalefactor", String.valueOf(weVar.A()));
        builder.appendQueryParameter("device_type", weVar.D());
        builder.appendQueryParameter("android_id", weVar.C());
        a(builder, "clids_set", weVar.a());
        this.a.a(builder, weVar.E());
    }

    public void a(@NonNull wc wcVar) {
        this.b = wcVar;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(@NonNull Uri.Builder builder, @NonNull we weVar) {
        super.a(builder, (Uri.Builder) weVar);
        builder.path("report");
        b(builder, weVar);
        c(builder, weVar);
        builder.appendQueryParameter(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, String.valueOf(this.c));
    }

    private void a(Uri.Builder builder, String str, String str2, String str3) {
        builder.appendQueryParameter(str, dh.c(str2, str3));
    }

    private void a(Uri.Builder builder, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            builder.appendQueryParameter(str, str2);
        }
    }
}
