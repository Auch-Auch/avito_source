package com.my.target;

import a2.b.a.a.a;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.avito.android.remote.abuse.AbuseSendingResult;
import java.lang.reflect.Field;
import java.net.HttpCookie;
import org.json.JSONObject;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
public class dk {
    @Nullable
    public HttpCookie a(@NonNull String str) {
        HttpCookie httpCookie;
        Throwable th;
        try {
            JSONObject jSONObject = new JSONObject(str);
            httpCookie = new HttpCookie(jSONObject.getString("name"), jSONObject.optString("value"));
            try {
                httpCookie.setComment(jSONObject.optString(AbuseSendingResult.COMMENT));
                httpCookie.setCommentURL(jSONObject.optString("commentUrl"));
                httpCookie.setDomain(jSONObject.optString("domain"));
                httpCookie.setMaxAge((long) jSONObject.optInt("maxage"));
                httpCookie.setPath(jSONObject.optString(MessageMetaInfo.COLUMN_PATH));
                httpCookie.setPortlist(jSONObject.optString("portlist"));
                httpCookie.setVersion(jSONObject.optInt("version"));
                httpCookie.setSecure(jSONObject.optBoolean("secure"));
                httpCookie.setDiscard(jSONObject.optBoolean("discard"));
                if (Build.VERSION.SDK_INT >= 24) {
                    httpCookie.setHttpOnly(jSONObject.optBoolean("httpOnly"));
                } else {
                    try {
                        Field declaredField = httpCookie.getClass().getDeclaredField("httpOnly");
                        declaredField.setAccessible(true);
                        declaredField.set(httpCookie, Boolean.valueOf(jSONObject.optBoolean("httpOnly")));
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                a.q1(th, a.L("Exception decoding cookie"));
                return httpCookie;
            }
        } catch (Throwable th3) {
            th = th3;
            httpCookie = null;
            a.q1(th, a.L("Exception decoding cookie"));
            return httpCookie;
        }
        return httpCookie;
    }
}
