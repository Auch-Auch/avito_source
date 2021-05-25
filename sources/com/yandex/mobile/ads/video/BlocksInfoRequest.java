package com.yandex.mobile.ads.video;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.mobile.ads.impl.tm;
import com.yandex.mobile.ads.video.models.blocksinfo.BlocksInfo;
public final class BlocksInfoRequest {
    @NonNull
    private final Context a;
    @NonNull
    private final String b;
    @NonNull
    private final String c;
    @Nullable
    private final RequestListener<BlocksInfo> d;

    public static final class Builder {
        @NonNull
        private final Context a;
        @NonNull
        private final String b;
        @Nullable
        private final RequestListener<BlocksInfo> c;
        @NonNull
        private String d = "0";

        public Builder(@NonNull Context context, @NonNull String str, @Nullable RequestListener<BlocksInfo> requestListener) {
            this.a = context.getApplicationContext();
            this.b = str;
            this.c = requestListener;
            tm.a(str, "PageId");
        }

        public final BlocksInfoRequest build() {
            return new BlocksInfoRequest(this, (byte) 0);
        }

        public final Builder setCategory(@NonNull String str) {
            if (!TextUtils.isEmpty(str)) {
                this.d = str;
                return this;
            }
            throw new IllegalArgumentException("categoryId is empty");
        }
    }

    public /* synthetic */ BlocksInfoRequest(Builder builder, byte b2) {
        this(builder);
    }

    @NonNull
    public final String getCategoryId() {
        return this.c;
    }

    @NonNull
    public final Context getContext() {
        return this.a;
    }

    @NonNull
    public final String getPartnerId() {
        return this.b;
    }

    @Nullable
    public final RequestListener<BlocksInfo> getRequestListener() {
        return this.d;
    }

    private BlocksInfoRequest(@NonNull Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.d;
        this.d = builder.c;
    }
}
