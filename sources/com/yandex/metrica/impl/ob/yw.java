package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.google.common.net.HttpHeaders;
import com.sumsub.sns.core.common.SNSConstants;
import com.yandex.metrica.impl.ob.abc;
import com.yandex.metrica.impl.ob.ve;
import com.yandex.metrica.impl.ob.yx;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
public class yw {
    @NonNull
    private final yv a;
    @NonNull
    private final yl b;
    @NonNull
    private final yk c;
    @NonNull
    private final yq d;
    @NonNull
    private final yt e;
    @NonNull
    private final ys f;
    @NonNull
    private final yp g;
    @NonNull
    private final yu h;
    @NonNull
    private final ym i;
    @NonNull
    private final yn j;
    @NonNull
    private final yo k;
    @NonNull
    private final yr l;
    @NonNull
    private final oe m;
    @NonNull
    private final yz n;
    @NonNull
    private final yy o;

    public yw() {
        this(new yv(), new yl(), new yk(), new yq(), new yt(), new ys(), new yp(), new yu(), new ym(), new yn(), new yo(), new yr(), new oe(), new yz(), new yy());
    }

    private void b(@NonNull yx yxVar, @NonNull abc.a aVar) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = aVar.optJSONObject("locale");
        String str = "";
        if (!(optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("country")) == null || !optJSONObject.optBoolean("reliable", false))) {
            str = optJSONObject.optString("value", str);
        }
        yxVar.g(str);
    }

    private void c(@NonNull yx yxVar, @NonNull abc.a aVar) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3 = aVar.optJSONObject("queries");
        if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("list")) != null && (optJSONObject2 = optJSONObject.optJSONObject("sdk_list")) != null) {
            yxVar.a(optJSONObject2.optString("url", null));
        }
    }

    private void d(@NonNull yx yxVar, @NonNull abc.a aVar) {
        ve.a.j jVar = new ve.a.j();
        JSONObject optJSONObject = aVar.optJSONObject("stat_sending");
        if (optJSONObject != null) {
            jVar.b = abw.a(abc.a(optJSONObject, "disabled_reporting_interval_seconds"), TimeUnit.SECONDS, jVar.b);
        }
        yxVar.a(this.m.a(jVar));
    }

    private void e(yx yxVar, abc.a aVar) throws JSONException {
        JSONObject optJSONObject = ((JSONObject) aVar.a("distribution_customization", new JSONObject())).optJSONObject("clids");
        if (optJSONObject != null) {
            a(yxVar, optJSONObject);
        }
    }

    public yx a(byte[] bArr) {
        yx yxVar = new yx();
        try {
            abc.a aVar = new abc.a(new String(bArr, "UTF-8"));
            a(yxVar, aVar);
            c(yxVar, aVar);
            e(yxVar, aVar);
            b(yxVar, aVar);
            b(yxVar, (JSONObject) aVar);
            d(yxVar, aVar);
            this.c.a(yxVar, aVar);
            this.b.a(yxVar, aVar);
            this.d.a(yxVar, aVar);
            this.e.a(yxVar, aVar);
            this.f.a(yxVar, aVar);
            this.g.a(yxVar, aVar);
            this.h.a(yxVar, aVar);
            this.i.a(yxVar, aVar);
            this.j.a(yxVar, aVar);
            this.k.a(yxVar, aVar);
            this.l.a(yxVar, aVar);
            this.a.a(yxVar, aVar);
            this.n.a(yxVar, aVar);
            yxVar.a(this.o.a(aVar, "ui_event_sending"));
            yxVar.b(this.o.a(aVar, "ui_collecting_for_bridge"));
            yxVar.a(yx.a.OK);
            return yxVar;
        } catch (Throwable unused) {
            yx yxVar2 = new yx();
            yxVar2.a(yx.a.BAD);
            return yxVar2;
        }
    }

    @VisibleForTesting
    public yw(@NonNull yv yvVar, @NonNull yl ylVar, @NonNull yk ykVar, @NonNull yq yqVar, @NonNull yt ytVar, @NonNull ys ysVar, @NonNull yp ypVar, @NonNull yu yuVar, @NonNull ym ymVar, @NonNull yn ynVar, @NonNull yo yoVar, @NonNull yr yrVar, @NonNull oe oeVar, @NonNull yz yzVar, @NonNull yy yyVar) {
        this.a = yvVar;
        this.b = ylVar;
        this.c = ykVar;
        this.d = yqVar;
        this.e = ytVar;
        this.f = ysVar;
        this.g = ypVar;
        this.h = yuVar;
        this.i = ymVar;
        this.j = ynVar;
        this.k = yoVar;
        this.l = yrVar;
        this.m = oeVar;
        this.n = yzVar;
        this.o = yyVar;
    }

    private void b(yx yxVar, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("time");
        if (optJSONObject != null) {
            try {
                yxVar.a(Long.valueOf(optJSONObject.getLong("max_valid_difference_seconds")));
            } catch (Throwable unused) {
            }
        }
    }

    private void a(@NonNull yx yxVar, @NonNull abc.a aVar) {
        String str;
        JSONObject optJSONObject = aVar.optJSONObject(SNSConstants.Preference.KEY_DEVICE_ID);
        String str2 = "";
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("hash");
            str2 = optJSONObject.optString("value");
            str = optString;
        } else {
            str = str2;
        }
        yxVar.d(str2);
        yxVar.e(str);
    }

    private void a(yx yxVar, JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null && optJSONObject.has("value")) {
                hashMap.put(next, optJSONObject.getString("value"));
            }
        }
        yxVar.f(abq.a(hashMap));
    }

    public static Long a(@Nullable Map<String, List<String>> map) {
        if (!dl.a((Map) map)) {
            List<String> list = map.get(HttpHeaders.DATE);
            if (!dl.a((Collection) list)) {
                try {
                    return Long.valueOf(new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z", Locale.US).parse(list.get(0)).getTime());
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }
}
