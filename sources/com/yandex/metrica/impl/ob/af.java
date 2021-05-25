package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
public class af implements bz {
    @NonNull
    private final a a;

    public static class a {

        /* renamed from: com.yandex.metrica.impl.ob.af$a$a  reason: collision with other inner class name */
        public static class C0337a {
            @NonNull
            public final String a;

            public C0337a(@NonNull String str) {
                this.a = str;
            }
        }

        public C0337a a(@Nullable byte[] bArr) {
            try {
                if (!dl.a(bArr)) {
                    return new C0337a(new JSONObject(new String(bArr, "UTF-8")).optString("status"));
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public af() {
        this(new a());
    }

    @Override // com.yandex.metrica.impl.ob.bz
    public boolean a(int i, @Nullable byte[] bArr, @Nullable Map<String, List<String>> map) {
        a.C0337a a3;
        if (200 != i || (a3 = this.a.a(bArr)) == null) {
            return false;
        }
        return "accepted".equals(a3.a);
    }

    @VisibleForTesting
    public af(@NonNull a aVar) {
        this.a = aVar;
    }
}
