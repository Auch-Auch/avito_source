package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.my.target.common.models.ImageData;
import org.json.JSONObject;
public class dr {
    @NonNull
    public final bp a;
    @NonNull
    public final a b;
    @NonNull
    public final Context c;
    @NonNull
    public final dn d;
    public boolean e = true;

    public dr(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        this.a = bpVar;
        this.b = aVar;
        this.c = context;
        this.d = dn.c(bpVar, aVar, context);
    }

    @NonNull
    public static dr e(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        return new dr(bpVar, aVar, context);
    }

    public final void a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        if (this.e) {
            dh.M(str).N(str2).v(this.b.getSlotId()).P(str3).O(this.a.getUrl()).v(this.c);
        }
    }

    public final void b(@NonNull JSONObject jSONObject, @NonNull ca caVar) {
        this.d.a(jSONObject, caVar);
        this.e = caVar.isLogErrors();
        caVar.setAllowBackButton(jSONObject.optBoolean("allowBackButton", caVar.isAllowBackButton()));
        caVar.setAllowCloseDelay((float) jSONObject.optDouble("allowCloseDelay", (double) caVar.getAllowCloseDelay()));
        String optString = jSONObject.optString("close_icon_hd");
        if (!TextUtils.isEmpty(optString)) {
            caVar.setCloseIcon(ImageData.newImageData(optString));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x018e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x018b  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.my.target.ca c(@androidx.annotation.NonNull org.json.JSONObject r12, @androidx.annotation.Nullable java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 788
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.dr.c(org.json.JSONObject, java.lang.String):com.my.target.ca");
    }
}
