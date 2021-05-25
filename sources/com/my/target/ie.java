package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.internal.ServerProtocol;
import com.my.target.nativeads.banners.NativeBanner;
import com.my.target.nativeads.banners.NativePromoBanner;
import org.json.JSONException;
import org.json.JSONObject;
public final class ie {

    public static class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ NativePromoBanner b;
        public final /* synthetic */ Context c;

        public a(String str, NativePromoBanner nativePromoBanner, Context context) {
            this.a = str;
            this.b = nativePromoBanner;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ie.c(ie.a(this.a, this.b.getNavigationType(), this.b.getTitle(), this.b.getCtaText(), this.b.getDomain(), this.b.getAgeRestrictions(), this.b.getDisclaimer(), this.b.getDescription(), this.b.getRating(), this.b.getVotes(), this.b.hasVideo()), this.c);
        }
    }

    public static class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ NativeBanner b;
        public final /* synthetic */ Context c;

        public b(String str, NativeBanner nativeBanner, Context context) {
            this.a = str;
            this.b = nativeBanner;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ie.c(ie.a(this.a, this.b.getNavigationType(), this.b.getTitle(), this.b.getCtaText(), this.b.getDomain(), this.b.getAgeRestrictions(), this.b.getDisclaimer(), this.b.getDescription(), this.b.getRating(), this.b.getVotes(), false), this.c);
        }
    }

    @Nullable
    public static String a(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, float f, int i, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("network", str);
            jSONObject.put("navigationType", str2);
            if (b(str3)) {
                jSONObject.put("title", str3);
            }
            if (b(str4)) {
                jSONObject.put("ctaText", str4);
            }
            if (b(str5)) {
                jSONObject.put("domain", str5);
            }
            if (b(str6)) {
                jSONObject.put("ageRestrictions", str6);
            }
            if (b(str7)) {
                jSONObject.put("disclaimer", str7);
            }
            if (f > 0.0f) {
                jSONObject.put("rating", String.valueOf(f));
            }
            if (i > 0) {
                jSONObject.put("votes", String.valueOf(i));
            }
            if (b(str8)) {
                jSONObject.put("description", str8);
            }
            if (z) {
                jSONObject.put("hasVideo", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void a(@NonNull String str, @NonNull NativeBanner nativeBanner, @NonNull Context context) {
        af.b(new b(str, nativeBanner, context));
    }

    public static void a(@NonNull String str, @NonNull NativePromoBanner nativePromoBanner, @NonNull Context context) {
        af.b(new a(str, nativePromoBanner, context));
    }

    public static boolean b(@Nullable String str) {
        return str != null && str.length() > 0;
    }

    public static void c(@Nullable String str, @NonNull Context context) {
        if (str != null) {
            dd.cH().L(hz.ai(str)).f("https://ad.mail.ru/mobile/adcontext", context);
        }
    }
}
