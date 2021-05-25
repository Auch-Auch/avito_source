package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
@SuppressLint({"ParcelCreator"})
public class ab extends ResultReceiver {
    @NonNull
    private final a a;

    public interface a {
        void a(int i, @NonNull Bundle bundle);
    }

    public ab(Handler handler, @NonNull a aVar) {
        super(handler);
        this.a = aVar;
    }

    public static void a(@Nullable ResultReceiver resultReceiver, @NonNull yb ybVar) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            a(bundle, ybVar);
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.setClassLoader(aag.class.getClassLoader());
        this.a.a(i, bundle);
    }

    public static void a(ResultReceiver resultReceiver, xv xvVar, @Nullable yb ybVar) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            xvVar.a(bundle);
            if (ybVar != null) {
                a(bundle, ybVar);
            }
            resultReceiver.send(2, bundle);
        }
    }

    private static void a(@NonNull Bundle bundle, @NonNull yb ybVar) {
        bundle.putString("Uuid", ybVar.a);
        bundle.putString("DeviceId", ybVar.b);
        bundle.putString("DeviceIdHash", ybVar.d);
        bundle.putString("AdUrlGet", ybVar.f);
        bundle.putString("AdUrlReport", ybVar.g);
        bundle.putLong("ServerTimeOffset", abu.c());
        Map a3 = abq.a(ybVar.m);
        if (a3.isEmpty()) {
            a3 = new HashMap();
        }
        bundle.putString("Clids", abc.a((Map<String, String>) a3));
        bundle.putString("RequestClids", ybVar.n);
        bundle.putParcelable("UiAcessConfig", new aag(ybVar));
    }
}
