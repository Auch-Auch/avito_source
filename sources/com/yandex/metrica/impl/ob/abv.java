package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.i;
import org.json.JSONObject;
public class abv {

    public enum a {
        LOGIN("login"),
        LOGOUT("logout"),
        SWITCH("switch"),
        UPDATE("update");
        
        private String e;

        private a(String str) {
            this.e = str;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.e;
        }
    }

    public static i a(String str) {
        i iVar = new i();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                iVar.a(jSONObject.optString("UserInfo.UserId", null));
                iVar.b(jSONObject.optString("UserInfo.Type", null));
                iVar.a(abc.a(jSONObject.optJSONObject("UserInfo.Options")));
            } catch (Throwable unused) {
            }
        }
        return iVar;
    }

    public static String a(a aVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("action", aVar.toString());
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
