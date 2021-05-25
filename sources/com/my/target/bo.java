package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
import java.util.List;
public class bo {
    @NonNull
    public final ImageData a;
    @NonNull
    public final String b;
    @Nullable
    public List<a> c;

    public static class a {
        @Nullable
        public final String B;
        @Nullable
        public final String dn;

        /* renamed from: do  reason: not valid java name */
        public final boolean f11do;
        @NonNull
        public final String name;

        public a(@NonNull String str, @Nullable String str2, @Nullable String str3, boolean z) {
            this.name = str;
            this.dn = str2;
            this.B = str3;
            this.f11do = z;
        }

        @NonNull
        public static a a(@NonNull String str, @Nullable String str2, @Nullable String str3, boolean z) {
            return new a(str, str2, str3, z);
        }
    }

    public bo(@NonNull ImageData imageData, @NonNull String str) {
        this.a = imageData;
        this.b = str;
    }

    @NonNull
    public static bo a(@NonNull ImageData imageData, @NonNull String str) {
        return new bo(imageData, str);
    }

    @NonNull
    public String aW() {
        return this.b;
    }

    @Nullable
    public List<a> aX() {
        return this.c;
    }

    public void b(@Nullable List<a> list) {
        this.c = list;
    }

    @NonNull
    public ImageData getIcon() {
        return this.a;
    }
}
