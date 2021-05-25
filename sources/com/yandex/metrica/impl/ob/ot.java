package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.metrica.impl.ob.x;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
public class ot {
    private final String a;
    private final String b;
    private final String c;
    private final Point d;

    @SuppressLint({"NewApi", "HardwareIds", "ObsoleteSdkInt"})
    public ot(@NonNull Context context, @Nullable String str, @NonNull so soVar) {
        this.a = Build.MANUFACTURER;
        this.b = Build.MODEL;
        this.c = a(context, str, soVar);
        x.b bVar = x.a(context).f;
        this.d = new Point(bVar.a, bVar.b);
    }

    @NonNull
    @SuppressLint({"HardwareIds", "ObsoleteSdkInt", "MissingPermission", "NewApi"})
    private String a(@NonNull Context context, @Nullable String str, @NonNull so soVar) {
        if (dl.a(28)) {
            if (soVar.d(context)) {
                try {
                    return Build.getSerial();
                } catch (Throwable unused) {
                }
            }
            return (String) abw.b(str, "");
        } else if (dl.a(8)) {
            return Build.SERIAL;
        } else {
            return (String) abw.b(str, "");
        }
    }

    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("manufacturer", this.a);
        jSONObject.put(VerticalFilterCloseDialogEventKt.MODEL_DIALOG, this.b);
        jSONObject.put("serial", this.c);
        jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.d.x);
        jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.d.y);
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ot otVar = (ot) obj;
        String str = this.a;
        if (str == null ? otVar.a != null : !str.equals(otVar.a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? otVar.b != null : !str2.equals(otVar.b)) {
            return false;
        }
        Point point = this.d;
        Point point2 = otVar.d;
        if (point != null) {
            return point.equals(point2);
        }
        if (point2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Point point = this.d;
        if (point != null) {
            i = point.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder L = a.L("DeviceSnapshot{mManufacturer='");
        a.k1(L, this.a, '\'', ", mModel='");
        a.k1(L, this.b, '\'', ", mSerial='");
        a.k1(L, this.c, '\'', ", mScreenSize=");
        L.append(this.d);
        L.append('}');
        return L.toString();
    }

    public ot(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        this.a = jSONObject.getString("manufacturer");
        this.b = jSONObject.getString(VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        this.c = jSONObject.getString("serial");
        this.d = new Point(jSONObject.getInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY), jSONObject.getInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
    }

    @NonNull
    public String a() {
        return this.c;
    }
}
