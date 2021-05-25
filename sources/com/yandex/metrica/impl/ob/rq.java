package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.preferences.GeoContract;
import com.yandex.metrica.impl.ob.p;
import com.yandex.metrica.impl.ob.qm;
import org.json.JSONObject;
public class rq {
    @Nullable
    public static String a(@NonNull rb rbVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("collection_mode", rbVar.a.a());
            jSONObject.put("lat", rbVar.c().getLatitude());
            jSONObject.put(MessageBody.Location.LONGITUDE, rbVar.c().getLongitude());
            jSONObject.putOpt("timestamp", Long.valueOf(rbVar.c().getTime()));
            jSONObject.putOpt("receive_timestamp", Long.valueOf(rbVar.b()));
            jSONObject.put("receive_elapsed_realtime_seconds", rbVar.d());
            jSONObject.putOpt("precision", rbVar.c().hasAccuracy() ? Float.valueOf(rbVar.c().getAccuracy()) : null);
            jSONObject.putOpt("direction", rbVar.c().hasBearing() ? Float.valueOf(rbVar.c().getBearing()) : null);
            jSONObject.putOpt("speed", rbVar.c().hasSpeed() ? Float.valueOf(rbVar.c().getSpeed()) : null);
            jSONObject.putOpt("altitude", rbVar.c().hasAltitude() ? Double.valueOf(rbVar.c().getAltitude()) : null);
            jSONObject.putOpt(GeoContract.PROVIDER, dh.c(rbVar.c().getProvider(), null));
            jSONObject.put("charge_type", rbVar.e().a());
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public static qk b(long j, @NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            qk qkVar = new qk();
            try {
                qkVar.a(Long.valueOf(j));
                JSONObject jSONObject = new JSONObject(str);
                qkVar.a(jSONObject.optLong("timestamp", 0));
                qkVar.b(jSONObject.optLong("elapsed_realtime_seconds", 0));
                qkVar.b(jSONObject.optJSONArray("cell_info"));
                qkVar.a(jSONObject.optJSONArray("wifi_info"));
                qkVar.a(p.a.EnumC0340a.a(Integer.valueOf(jSONObject.optInt("charge_type", Integer.MIN_VALUE))));
                qkVar.a(qm.a.a(jSONObject.optString("collection_mode")));
            } catch (Throwable unused) {
            }
            return qkVar;
        } catch (Throwable unused2) {
            return null;
        }
    }

    @Nullable
    public static rb a(long j, @NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            long optLong = jSONObject.optLong("receive_timestamp", 0);
            long optLong2 = jSONObject.optLong("receive_elapsed_realtime_seconds", 0);
            qm.a a = qm.a.a(jSONObject.optString("collection_mode"));
            Location location = new Location(jSONObject.optString(GeoContract.PROVIDER, null));
            location.setLongitude(jSONObject.optDouble(MessageBody.Location.LONGITUDE, 0.0d));
            location.setLatitude(jSONObject.optDouble("lat", 0.0d));
            location.setTime(jSONObject.optLong("timestamp", 0));
            location.setAccuracy((float) jSONObject.optDouble("precision", 0.0d));
            location.setBearing((float) jSONObject.optDouble("direction", 0.0d));
            location.setSpeed((float) jSONObject.optDouble("speed", 0.0d));
            location.setAltitude(jSONObject.optDouble("altitude", 0.0d));
            return new rb(a, optLong, optLong2, location, p.a.EnumC0340a.a(Integer.valueOf(jSONObject.optInt("charge_type", Integer.MIN_VALUE))), Long.valueOf(j));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public static String a(@NonNull qk qkVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timestamp", qkVar.b());
            jSONObject.put("elapsed_realtime_seconds", qkVar.e());
            jSONObject.putOpt("wifi_info", qkVar.c());
            jSONObject.putOpt("cell_info", qkVar.d());
            if (qkVar.f() != null) {
                jSONObject.put("charge_type", qkVar.f().a());
            }
            if (qkVar.g() != null) {
                jSONObject.put("collection_mode", qkVar.g().a());
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
