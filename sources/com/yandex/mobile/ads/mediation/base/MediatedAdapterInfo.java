package com.yandex.mobile.ads.mediation.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class MediatedAdapterInfo {
    @Nullable
    private final String a;
    @Nullable
    private final String b;
    @Nullable
    private final String c;

    public static final class Builder {
        @Nullable
        private String a;
        @Nullable
        private String b;
        @Nullable
        private String c;

        @NonNull
        public final MediatedAdapterInfo build() {
            return new MediatedAdapterInfo(this);
        }

        @NonNull
        public final Builder setAdapterVersion(@NonNull String str) {
            this.a = str;
            return this;
        }

        @NonNull
        public final Builder setNetworkName(@NonNull String str) {
            this.b = str;
            return this;
        }

        @NonNull
        public final Builder setNetworkSdkVersion(@NonNull String str) {
            this.c = str;
            return this;
        }
    }

    @Nullable
    public final String getAdapterVersion() {
        return this.a;
    }

    @Nullable
    public final String getNetworkName() {
        return this.b;
    }

    @Nullable
    public final String getNetworkSdkVersion() {
        return this.c;
    }

    private MediatedAdapterInfo(@NonNull Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
    }
}
