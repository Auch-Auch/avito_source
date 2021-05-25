package com.my.target;

import a2.b.a.a.a;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.my.target.common.models.ImageData;
import org.json.JSONObject;
public class ds {
    @NonNull
    public final bp a;
    @NonNull
    public final a b;
    @NonNull
    public final Context c;
    public boolean d = true;

    public ds(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        this.a = bpVar;
        this.b = aVar;
        this.c = context;
    }

    @NonNull
    public static ds f(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        return new ds(bpVar, aVar, context);
    }

    public final void a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        if (this.d) {
            dh.M(str2).N(str).P(str3).v(this.b.getSlotId()).O(this.a.getUrl()).v(this.c);
        }
    }

    @Nullable
    public final ImageData b(@NonNull JSONObject jSONObject, @NonNull String str) {
        String str2;
        String optString = jSONObject.optString("imageLink");
        if (TextUtils.isEmpty(optString)) {
            str2 = "InterstitialAdImageBanner no imageLink for image";
        } else {
            int optInt = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            int optInt2 = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            if (optInt > 0 && optInt2 > 0) {
                return ImageData.newImageData(optString, optInt, optInt2);
            }
            str2 = a.R2("InterstitialAdImageBanner  image has wrong dimensions, w = ", optInt, ", h = ", optInt2);
        }
        a(str2, "Required field", str);
        return null;
    }
}
