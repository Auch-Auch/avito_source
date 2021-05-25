package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
public class du {
    @NonNull
    public final a a;
    @NonNull
    public final bp b;
    @NonNull
    public final a c;
    @NonNull
    public final Context d;
    @NonNull
    public final eb e;

    public interface a {
        @Nullable
        cn b(@NonNull JSONObject jSONObject, @NonNull bp bpVar, @NonNull a aVar, @NonNull Context context);
    }

    public du(@NonNull a aVar, @NonNull bp bpVar, @NonNull a aVar2, @NonNull Context context) {
        this.a = aVar;
        this.b = bpVar;
        this.c = aVar2;
        this.d = context;
        this.e = eb.k(bpVar, aVar2, context);
    }

    @NonNull
    public static du a(@NonNull a aVar, @NonNull bp bpVar, @NonNull a aVar2, @NonNull Context context) {
        return new du(aVar, bpVar, aVar2, context);
    }

    public final void b(@NonNull String str, @NonNull String str2) {
        dh.M(str).N(str2).v(this.c.getSlotId()).O(this.b.getUrl()).v(this.d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011c A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.my.target.cl i(@androidx.annotation.NonNull org.json.JSONObject r15) {
        /*
        // Method dump skipped, instructions count: 296
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.du.i(org.json.JSONObject):com.my.target.cl");
    }
}
