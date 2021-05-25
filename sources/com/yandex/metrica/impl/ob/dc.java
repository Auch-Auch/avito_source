package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import com.yandex.metrica.IMetricaService;
public final class dc {
    private static final ado a = new ado();

    public static Intent a(Context context) {
        Intent intent = new Intent(IMetricaService.class.getName(), c(context));
        a(intent);
        return intent;
    }

    public static Intent b(Context context) {
        Intent putExtras = a(context).putExtras(d(context));
        putExtras.setData(putExtras.getData().buildUpon().path("client").appendQueryParameter("pid", String.valueOf(Process.myPid())).appendQueryParameter("psid", eu.a).build());
        return putExtras.setPackage(context.getApplicationContext().getPackageName());
    }

    private static Uri c(Context context) {
        return new Uri.Builder().scheme("metrica").authority(context.getPackageName()).build();
    }

    private static Bundle d(Context context) {
        try {
            Bundle bundle = a.b(context, context.getPackageName(), 128).metaData;
            return bundle == null ? new Bundle() : bundle;
        } catch (Throwable unused) {
            return new Bundle();
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(Intent intent) {
        if (dl.b(11)) {
            intent.addFlags(32);
        }
    }
}
