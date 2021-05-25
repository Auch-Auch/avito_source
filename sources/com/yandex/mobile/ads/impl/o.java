package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.AdActivity;
import com.yandex.mobile.ads.impl.hv;
import java.util.concurrent.atomic.AtomicLong;
public final class o {

    public static final class a {
        public static final AtomicLong a = new AtomicLong(SystemClock.elapsedRealtime() - 2000);

        public static boolean a() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long andSet = elapsedRealtime - a.getAndSet(elapsedRealtime);
            return andSet < 0 || andSet > 1000;
        }
    }

    private static void a(Context context, String str, ResultReceiver resultReceiver) {
        if (context != null) {
            try {
                context.startActivity(b(context, str, resultReceiver));
            } catch (Exception unused) {
            }
        }
    }

    private static Intent b(Context context, String str, ResultReceiver resultReceiver) {
        Intent intent = new Intent(context, AdActivity.class);
        intent.putExtra("window_type", "window_type_browser");
        intent.putExtra("extra_receiver", dt.a(resultReceiver));
        intent.putExtra("extra_browser_url", str);
        intent.addFlags(268435456);
        return intent;
    }

    public static void a(@Nullable Context context, @NonNull cq cqVar, @Nullable String str, @Nullable ResultReceiver resultReceiver, boolean z) {
        cqVar.a(hv.b.CLICK, a2.b.a.a.a.k0("click_type", "default"));
        if (resultReceiver != null) {
            resultReceiver.send(9, null);
        }
        if (context != null && a.a()) {
            if (z && ee.d(str)) {
                a(context, str, resultReceiver);
            } else if (!ee.a(context, str, true)) {
                a(context, str, resultReceiver);
            } else if (resultReceiver != null) {
                resultReceiver.send(7, null);
            }
        }
    }
}
