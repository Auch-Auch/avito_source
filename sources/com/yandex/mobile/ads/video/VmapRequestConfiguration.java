package com.yandex.mobile.ads.video;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.mobile.ads.impl.tm;
public final class VmapRequestConfiguration {
    @NonNull
    private final String a;
    @NonNull
    private final String b;

    public static final class Builder {
        @NonNull
        private final String a;
        @NonNull
        private String b = "0";

        public Builder(@NonNull String str) {
            this.a = str;
            tm.a(str, "PageId");
        }

        public final VmapRequestConfiguration build() {
            return new VmapRequestConfiguration(this, (byte) 0);
        }

        public final Builder setCategory(@NonNull String str) {
            if (!TextUtils.isEmpty(str)) {
                this.b = str;
                return this;
            }
            throw new IllegalArgumentException("Passed categoryId is empty");
        }
    }

    public /* synthetic */ VmapRequestConfiguration(Builder builder, byte b2) {
        this(builder);
    }

    @NonNull
    public final String getCategoryId() {
        return this.a;
    }

    @NonNull
    public final String getPageId() {
        return this.b;
    }

    private VmapRequestConfiguration(@NonNull Builder builder) {
        this.a = builder.b;
        this.b = builder.a;
    }
}
