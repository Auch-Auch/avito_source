package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Base64;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import java.net.Socket;
import java.util.HashMap;
import org.json.JSONException;
public class xb extends xd {
    @NonNull
    private xs c;
    @NonNull
    private xc d;

    public xb(@NonNull Socket socket, @NonNull Uri uri, @NonNull xg xgVar, @NonNull xs xsVar, @NonNull xc xcVar) {
        super(socket, uri, xgVar);
        this.c = xsVar;
        this.d = xcVar;
    }

    @Override // com.yandex.metrica.impl.ob.xd
    public void a() {
        if (this.c.b.equals(this.b.getQueryParameter("t"))) {
            try {
                byte[] b = b();
                a("HTTP/1.1 200 OK", new HashMap<String, String>(b) { // from class: com.yandex.metrica.impl.ob.xb.1
                    public final /* synthetic */ byte[] a;

                    {
                        this.a = r3;
                        put("Content-Type", "text/plain; charset=utf-8");
                        put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                        put(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, ShareTarget.METHOD_GET);
                        put(HttpHeaders.CONTENT_LENGTH, String.valueOf(r3.length));
                    }
                }, b);
            } catch (Throwable unused) {
            }
        } else {
            this.a.a("request_with_wrong_token");
        }
    }

    public byte[] b() throws JSONException {
        return Base64.encode(new acf().a(this.d.a().getBytes()), 0);
    }
}
