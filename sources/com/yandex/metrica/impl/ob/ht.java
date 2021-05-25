package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import org.json.JSONObject;
public class ht extends hu {
    public ht(fe feVar) {
        super(feVar);
    }

    private void b() {
        a().o();
        a().z().a();
    }

    @Override // com.yandex.metrica.impl.ob.hq
    public boolean a(@NonNull aa aaVar) {
        String e = aaVar.e();
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(e);
            if (!"open".equals(jSONObject.optString("type")) || !a(jSONObject.optString("link"))) {
                return false;
            }
            b();
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean a(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    String[] split = queryParameter.split("&");
                    for (String str2 : split) {
                        int indexOf = str2.indexOf("=");
                        if (indexOf >= 0 && "reattribution".equals(Uri.decode(str2.substring(0, indexOf))) && "1".equals(Uri.decode(str2.substring(indexOf + 1)))) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
