package com.yandex.mobile.ads;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.List;
import java.util.Map;
public final class AdRequest {
    @Nullable
    private final String a;
    @Nullable
    private final String b;
    @Nullable
    private final String c;
    @Nullable
    private final List<String> d;
    @Nullable
    private final Location e;
    @Nullable
    private final Map<String, String> f;

    public static final class Builder {
        @Nullable
        private String a;
        @Nullable
        private String b;
        @Nullable
        private Location c;
        @Nullable
        private String d;
        @Nullable
        private List<String> e;
        @Nullable
        private Map<String, String> f;

        @NonNull
        public final AdRequest build() {
            return new AdRequest(this, (byte) 0);
        }

        @NonNull
        public final Builder withAge(@NonNull String str) {
            this.a = str;
            return this;
        }

        @NonNull
        public final Builder withContextQuery(@NonNull String str) {
            this.d = str;
            return this;
        }

        @NonNull
        public final Builder withContextTags(@NonNull List<String> list) {
            this.e = list;
            return this;
        }

        @NonNull
        public final Builder withGender(@NonNull String str) {
            this.b = str;
            return this;
        }

        @NonNull
        public final Builder withLocation(@NonNull Location location) {
            this.c = location;
            return this;
        }

        @NonNull
        public final Builder withParameters(@NonNull Map<String, String> map) {
            this.f = map;
            return this;
        }
    }

    public /* synthetic */ AdRequest(Builder builder, byte b2) {
        this(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AdRequest.class == obj.getClass()) {
            AdRequest adRequest = (AdRequest) obj;
            String str = this.a;
            if (str == null ? adRequest.a != null : !str.equals(adRequest.a)) {
                return false;
            }
            String str2 = this.b;
            if (str2 == null ? adRequest.b != null : !str2.equals(adRequest.b)) {
                return false;
            }
            String str3 = this.c;
            if (str3 == null ? adRequest.c != null : !str3.equals(adRequest.c)) {
                return false;
            }
            List<String> list = this.d;
            if (list == null ? adRequest.d != null : !list.equals(adRequest.d)) {
                return false;
            }
            Map<String, String> map = this.f;
            Map<String, String> map2 = adRequest.f;
            if (map != null) {
                return map.equals(map2);
            }
            if (map2 == null) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final String getAge() {
        return this.a;
    }

    @Nullable
    public final String getContextQuery() {
        return this.c;
    }

    @Nullable
    public final List<String> getContextTags() {
        return this.d;
    }

    @Nullable
    public final String getGender() {
        return this.b;
    }

    @Nullable
    public final Location getLocation() {
        return this.e;
    }

    @Nullable
    public final Map<String, String> getParameters() {
        return this.f;
    }

    public final int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<String> list = this.d;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        Map<String, String> map = this.f;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode4 + i;
    }

    private AdRequest(@NonNull Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.d;
        this.d = builder.e;
        this.e = builder.c;
        this.f = builder.f;
    }
}
