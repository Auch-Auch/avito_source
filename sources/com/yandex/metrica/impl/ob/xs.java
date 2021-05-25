package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.avito.android.social.AppleSignInManagerKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class xs {
    public final long a;
    public final String b;
    public final List<Integer> c;
    public final long d;
    public final int e;

    public xs(long j, @NonNull String str, @NonNull List<Integer> list, long j2, int i) {
        this.a = j;
        this.b = str;
        this.c = Collections.unmodifiableList(list);
        this.d = j2;
        this.e = i;
    }

    @Nullable
    public static xs a(@Nullable String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            return new xs(jSONObject.getLong("seconds_to_live"), jSONObject.getString(AppleSignInManagerKt.EXTRA_APPLE_TOKEN), a(jSONObject.getJSONArray("ports")), jSONObject.getLong("first_delay_seconds"), jSONObject.getInt("launch_delay_seconds"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        xs xsVar = (xs) obj;
        if (this.a != xsVar.a || this.d != xsVar.d || this.e != xsVar.e) {
            return false;
        }
        String str = this.b;
        if (str == null ? xsVar.b != null : !str.equals(xsVar.b)) {
            return false;
        }
        List<Integer> list = this.c;
        List<Integer> list2 = xsVar.c;
        if (list != null) {
            return list.equals(list2);
        }
        if (list2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<Integer> list = this.c;
        if (list != null) {
            i2 = list.hashCode();
        }
        long j2 = this.d;
        return ((((hashCode + i2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.e;
    }

    public String toString() {
        StringBuilder L = a.L("SocketConfig{secondsToLive=");
        L.append(this.a);
        L.append(", token='");
        a.k1(L, this.b, '\'', ", ports=");
        L.append(this.c);
        L.append(", firstDelaySeconds=");
        L.append(this.d);
        L.append(", launchDelaySeconds=");
        return a.i(L, this.e, '}');
    }

    private static ArrayList<Integer> a(JSONArray jSONArray) throws JSONException {
        ArrayList<Integer> arrayList = new ArrayList<>(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
        }
        return arrayList;
    }
}
