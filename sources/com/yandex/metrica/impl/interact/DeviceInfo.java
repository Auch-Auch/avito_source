package com.yandex.metrica.impl.interact;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.cg;
import com.yandex.metrica.impl.ob.eh;
import com.yandex.metrica.impl.ob.ek;
import com.yandex.metrica.impl.ob.el;
import com.yandex.metrica.impl.ob.ep;
import com.yandex.metrica.impl.ob.x;
import java.util.ArrayList;
import java.util.List;
@Deprecated
public class DeviceInfo {
    public static final Object a = new Object();
    public static volatile DeviceInfo b;
    public final String appPlatform;
    public final String deviceRootStatus;
    public final List<String> deviceRootStatusMarkers;
    public final String deviceType;
    public String locale;
    public final String manufacturer;
    public final String model;
    public final String osVersion;
    public final String platform;
    public final String platformDeviceId;
    public final float scaleFactor;
    public final int screenDpi;
    public final int screenHeight;
    public final int screenWidth;

    public class a implements ek<ep> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.yandex.metrica.impl.ob.ej] */
        @Override // com.yandex.metrica.impl.ob.ek
        public void a(ep epVar) {
            DeviceInfo.this.locale = epVar.a;
        }
    }

    @VisibleForTesting
    public DeviceInfo(@NonNull Context context, @NonNull x xVar) {
        String str = xVar.a;
        this.platform = str;
        this.appPlatform = str;
        this.platformDeviceId = xVar.a();
        this.manufacturer = xVar.b;
        this.model = xVar.c;
        this.osVersion = xVar.d;
        x.b bVar = xVar.f;
        this.screenWidth = bVar.a;
        this.screenHeight = bVar.b;
        this.screenDpi = bVar.c;
        this.scaleFactor = bVar.d;
        this.deviceType = xVar.g;
        this.deviceRootStatus = xVar.h;
        this.deviceRootStatusMarkers = new ArrayList(xVar.i);
        this.locale = cg.a(context.getResources().getConfiguration().locale);
        eh.a().a(this, ep.class, el.a(new a()).a());
    }

    public static DeviceInfo getInstance(@NonNull Context context) {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new DeviceInfo(context, x.a(context));
                }
            }
        }
        return b;
    }
}
