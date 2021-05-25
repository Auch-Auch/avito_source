package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.nativeads.ag;
import com.yandex.mobile.ads.nativeads.j;
public final class ra {
    @NonNull
    private final cq a;
    @NonNull
    private final j b;
    @NonNull
    private final qz c;
    @NonNull
    private final rg d;

    public ra(@NonNull Context context, @NonNull cq cqVar, @NonNull ag agVar) {
        this.a = cqVar;
        this.b = agVar.f();
        this.c = new qz(context);
        this.d = new rg(context);
    }

    public final void a(@NonNull Context context, @NonNull pd pdVar) {
        Parcelable a3;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(pdVar.d()));
        if (this.d.a(intent) && (a3 = this.b.a(this.c.a(pdVar.b()))) != null) {
            this.a.a(hv.b.SHORTCUT);
            String c2 = pdVar.c();
            Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent2.putExtra("android.intent.extra.shortcut.NAME", c2);
            intent2.putExtra("android.intent.extra.shortcut.ICON", a3);
            intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
            intent2.putExtra("duplicate", false);
            try {
                context.sendBroadcast(intent2);
            } catch (Exception unused) {
            }
        }
    }
}
