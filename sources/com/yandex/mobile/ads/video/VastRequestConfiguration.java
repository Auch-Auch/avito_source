package com.yandex.mobile.ads.video;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.tm;
import com.yandex.mobile.ads.video.models.vmap.AdBreak;
import java.util.Map;
public final class VastRequestConfiguration {
    @NonNull
    private final AdBreak a;
    @Nullable
    private final Map<String, String> b;

    public static final class Builder {
        @NonNull
        private final AdBreak a;
        @Nullable
        private Map<String, String> b;

        public Builder(@NonNull AdBreak adBreak) {
            this.a = adBreak;
            tm.a(adBreak, "AdBreak");
        }

        public final VastRequestConfiguration build() {
            return new VastRequestConfiguration(this, (byte) 0);
        }

        @NonNull
        public final Builder setParameters(@NonNull Map<String, String> map) {
            this.b = map;
            return this;
        }
    }

    public /* synthetic */ VastRequestConfiguration(Builder builder, byte b2) {
        this(builder);
    }

    @NonNull
    public final AdBreak getAdBreak() {
        return this.a;
    }

    @Nullable
    public final Map<String, String> getParameters() {
        return this.b;
    }

    private VastRequestConfiguration(@NonNull Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
    }
}
