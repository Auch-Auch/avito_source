package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.YandexMetricaConfig;
import com.yandex.metrica.impl.interact.CellularNetworkInfo;
import com.yandex.metrica.impl.interact.DeviceInfo;
import com.yandex.metrica.j;
import com.yandex.metrica.p;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;
public class vk {
    @NonNull
    private final vl a;
    @NonNull
    private final act b;
    @NonNull
    private final vg c;
    @NonNull
    private final adw<Context> d;
    @NonNull
    private final adw<String> e;
    @NonNull
    private final a f;

    @Deprecated
    public static class a {
        public qf a(@NonNull Context context, @Nullable LocationManager locationManager) {
            return new qf(context, locationManager, new so(new sj()));
        }
    }

    public vk(@NonNull act act) {
        this(act, new vl());
    }

    public void a(@NonNull Context context, @NonNull Object obj) {
    }

    @Nullable
    public Future<String> b() {
        return this.b.a(new abm<String>() { // from class: com.yandex.metrica.impl.ob.vk.3
            /* renamed from: a */
            public String b() {
                return pe.b().d();
            }
        });
    }

    public void b(@NonNull Context context, @NonNull Object obj) {
    }

    @Nullable
    public Future<Boolean> c() {
        return this.b.a(new abm<Boolean>() { // from class: com.yandex.metrica.impl.ob.vk.4
            /* renamed from: a */
            public Boolean b() {
                return pe.b().e();
            }
        });
    }

    @Nullable
    @Deprecated
    public String d() {
        if (this.a.e()) {
            return this.a.a().j();
        }
        return null;
    }

    @Nullable
    public String e(@NonNull Context context) {
        this.d.a(context);
        return this.a.a(context).i();
    }

    @NonNull
    public String f(@NonNull Context context) {
        this.d.a(context);
        return context.getPackageName();
    }

    @Nullable
    @Deprecated
    public Location g(@NonNull Context context) {
        LocationManager locationManager;
        this.d.a(context);
        try {
            locationManager = (LocationManager) context.getSystemService("location");
        } catch (Throwable unused) {
            locationManager = null;
        }
        return this.f.a(context, locationManager).a();
    }

    public vk(@NonNull act act, @NonNull vl vlVar) {
        this(act, vlVar, new vg(vlVar), new ads(new adr("Context")), new ads(new adr("Event name")), new a());
    }

    @Deprecated
    public void a(final IIdentifierCallback iIdentifierCallback, @NonNull final List<String> list) {
        this.b.a(new abn() { // from class: com.yandex.metrica.impl.ob.vk.1
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() throws Exception {
                if (vk.this.a.e()) {
                    vk.this.a.a().a(iIdentifierCallback, list);
                }
            }
        });
    }

    @NonNull
    public String b(Context context) {
        this.d.a(context);
        return new CellularNetworkInfo(context).getCelluralInfo();
    }

    @Nullable
    public Integer c(Context context) {
        this.d.a(context);
        return cg.c(context);
    }

    public vk(@NonNull act act, @NonNull vl vlVar, @NonNull vg vgVar, @NonNull adw<Context> adw, @NonNull adw<String> adw2, @NonNull a aVar) {
        this.a = vlVar;
        this.b = act;
        this.c = vgVar;
        this.d = adw;
        this.e = adw2;
        this.f = aVar;
    }

    public void a(@NonNull final Context context, @NonNull final IIdentifierCallback iIdentifierCallback, @NonNull final List<String> list) {
        this.d.a(context);
        this.b.a(new abn() { // from class: com.yandex.metrica.impl.ob.vk.2
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() throws Exception {
                vk.this.a.a(context).a(iIdentifierCallback, list);
            }
        });
    }

    @Nullable
    public String d(@NonNull Context context) {
        this.d.a(context);
        return this.a.a(context).j();
    }

    public void e() {
        this.c.a();
        this.b.a(new abn() { // from class: com.yandex.metrica.impl.ob.vk.6
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() throws Exception {
                vk.this.a.f().sendEventsBuffer();
            }
        });
    }

    public boolean a() {
        return this.a.c();
    }

    @NonNull
    public DeviceInfo a(Context context) {
        this.d.a(context);
        return DeviceInfo.getInstance(context);
    }

    public void a(final int i, @NonNull final String str, @Nullable final String str2, @Nullable final Map<String, String> map) {
        this.c.a();
        this.e.a(str);
        this.b.a(new abn() { // from class: com.yandex.metrica.impl.ob.vk.5
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() throws Exception {
                vk.this.a.f().a(i, str, str2, map);
            }
        });
    }

    @NonNull
    public String a(@Nullable String str) {
        return cx.a(str);
    }

    @NonNull
    public String a(int i) {
        return cj.a(i);
    }

    @NonNull
    public YandexMetricaConfig a(@NonNull YandexMetricaConfig yandexMetricaConfig, @NonNull String str) {
        return j.b(yandexMetricaConfig).a(Collections.singletonList(str)).b();
    }

    @NonNull
    public YandexMetricaConfig a(@NonNull YandexMetricaConfig yandexMetricaConfig, @NonNull List<String> list) {
        return j.b(yandexMetricaConfig).a(list).b();
    }

    public void a(@NonNull final Context context, final boolean z) {
        this.d.a(context);
        this.b.a(new abn() { // from class: com.yandex.metrica.impl.ob.vk.7
            @Override // com.yandex.metrica.impl.ob.abn
            public void a() throws Exception {
                vk.this.a.a(context).c(z);
            }
        });
    }

    public void a(@NonNull final p.Ucc ucc, final boolean z) {
        if (!this.a.d()) {
            ucc.onError("Main API key is not activated");
        } else {
            this.b.a(new abn() { // from class: com.yandex.metrica.impl.ob.vk.8
                @Override // com.yandex.metrica.impl.ob.abn
                public void a() throws Exception {
                    vk.this.a.f().a(new aai() { // from class: com.yandex.metrica.impl.ob.vk.8.1
                        @Override // com.yandex.metrica.impl.ob.aai
                        public void a(@NonNull JSONObject jSONObject) {
                            ucc.onResult(jSONObject);
                        }

                        @Override // com.yandex.metrica.impl.ob.aai
                        public void a(@NonNull String str) {
                            ucc.onError(str);
                        }
                    }, z);
                }
            });
        }
    }
}
