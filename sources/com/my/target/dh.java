package com.my.target;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.ServerProtocol;
import com.my.target.common.MyTargetVersion;
import com.sumsub.sns.core.common.SNSConstants;
import java.nio.charset.Charset;
import java.util.Objects;
import org.json.JSONObject;
public class dh {
    @VisibleForTesting
    public static boolean eZ = true;
    @NonNull
    public final String a;
    @NonNull
    public final String b;
    @Nullable
    public String c;
    public int d;
    @Nullable
    public String e;
    @Nullable
    public String f;

    public class a implements Runnable {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            dh dhVar = dh.this;
            Objects.requireNonNull(dhVar);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, "myTarget");
                jSONObject.put("sdkver", MyTargetVersion.VERSION);
                jSONObject.put("os", SNSConstants.PLATFORM);
                jSONObject.put("osver", Build.VERSION.RELEASE);
                jSONObject.put("type", dhVar.b);
                jSONObject.put("name", dhVar.a);
                String str = dhVar.c;
                if (str != null) {
                    jSONObject.put("message", str);
                }
                int i = dhVar.d;
                if (i > 0) {
                    jSONObject.put("slot", i);
                }
                String str2 = dhVar.e;
                if (str2 != null) {
                    jSONObject.put("url", str2);
                }
                String str3 = dhVar.f;
                if (str3 != null) {
                    jSONObject.put("bannerId", str3);
                }
            } catch (Throwable unused) {
            }
            String jSONObject2 = jSONObject.toString();
            a2.b.a.a.a.U0("send message to log:\n ", jSONObject2);
            if (dh.eZ) {
                dd.cH().L(Base64.encodeToString(jSONObject2.getBytes(Charset.forName("UTF-8")), 0)).f("https://ad.mail.ru/sdk/log/", this.a);
            }
        }
    }

    public dh(@NonNull String str, @NonNull String str2) {
        this.a = str;
        this.b = str2;
    }

    @NonNull
    public static dh M(@NonNull String str) {
        return new dh(str, "error");
    }

    @NonNull
    public dh N(@Nullable String str) {
        this.c = str;
        return this;
    }

    @NonNull
    public dh O(@Nullable String str) {
        this.e = str;
        return this;
    }

    @NonNull
    public dh P(@Nullable String str) {
        this.f = str;
        return this;
    }

    @NonNull
    public dh v(int i) {
        this.d = i;
        return this;
    }

    public void v(@NonNull Context context) {
        af.b(new a(context));
    }
}
