package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
public class dn {
    @NonNull
    public final Context a;
    @NonNull
    public final bp b;
    @NonNull
    public final a c;
    @NonNull
    public final eb d;
    @Nullable
    public String e;
    public boolean f = true;

    public dn(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        this.b = bpVar;
        this.c = aVar;
        this.a = context;
        this.d = eb.k(bpVar, aVar, context);
    }

    @NonNull
    public static dn c(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        return new dn(bpVar, aVar, context);
    }

    @Nullable
    public static String e(@NonNull JSONObject jSONObject) {
        String str;
        String optString = jSONObject.optString("src", "");
        if (!TextUtils.isEmpty(optString)) {
            str = hz.ag(optString);
            if (str != null) {
                return str;
            }
        } else {
            str = null;
        }
        String optString2 = jSONObject.optString("source", "");
        return !TextUtils.isEmpty(optString2) ? ip.decode(optString2) : str;
    }

    @Nullable
    public static String g(@Nullable String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            StringBuilder sb = new StringBuilder(str2);
            if (sb.length() > 0) {
                Matcher matcher = Pattern.compile("<script\\s+[^>]*\\bsrc\\s*=\\s*(\\\\?[\\\"\\'])mraid\\.js\\1[^>]*>\\s*<\\/script>\\n*", 2).matcher(str2);
                if (matcher.find()) {
                    int start = matcher.start();
                    sb.delete(start, matcher.end());
                    sb.insert(start, "<script src=\"" + str + "\"></script>");
                    return sb.toString();
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02c2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x025a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(@androidx.annotation.NonNull org.json.JSONObject r20, @androidx.annotation.NonNull com.my.target.by r21) {
        /*
        // Method dump skipped, instructions count: 892
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.dn.a(org.json.JSONObject, com.my.target.by):void");
    }

    public final void b(@NonNull String str, @NonNull String str2) {
        if (this.f) {
            dh.M(str).N(str2).v(this.c.getSlotId()).P(this.e).O(this.b.getUrl()).v(this.a);
        }
    }
}
