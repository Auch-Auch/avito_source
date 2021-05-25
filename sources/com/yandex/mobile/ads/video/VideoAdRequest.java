package com.yandex.mobile.ads.video;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.ie;
import com.yandex.mobile.ads.impl.tm;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import com.yandex.mobile.ads.video.models.blocksinfo.BlocksInfo;
import java.util.List;
public final class VideoAdRequest {
    @NonNull
    private final Context a;
    @NonNull
    private final BlocksInfo b;
    @NonNull
    private final String c;
    @NonNull
    private final String d;
    @NonNull
    private final String e;
    @NonNull
    private final Charset f;
    @Nullable
    private final RequestListener<List<VideoAd>> g;
    private final int h;
    private final int i;
    private final int j;
    @Nullable
    private final String k;
    @Nullable
    private final String l;
    @Nullable
    private final String m;
    @Nullable
    private final String n;
    @Nullable
    private final String o;
    @Nullable
    private final String p;
    @Nullable
    private final String q;
    @Nullable
    private final String r;

    public static final class Builder {
        @NonNull
        private final Context a;
        @NonNull
        private final BlocksInfo b;
        @NonNull
        private final String c;
        @NonNull
        private final String d;
        @NonNull
        private final String e;
        @Nullable
        private final RequestListener<List<VideoAd>> f;
        private int g = -1;
        private int h = -1;
        private int i = -1;
        @Nullable
        private Charset j;
        @Nullable
        private String k;
        @Nullable
        private String l;
        @Nullable
        private String m;
        @Nullable
        private String n;
        @Nullable
        private String o;
        @Nullable
        private String p;
        @Nullable
        private String q;
        @Nullable
        private String r;

        public Builder(@NonNull Context context, @NonNull BlocksInfo blocksInfo, @Nullable RequestListener<List<VideoAd>> requestListener, @NonNull String str, @NonNull String str2, @NonNull String str3) {
            this.a = context.getApplicationContext();
            this.b = blocksInfo;
            this.f = requestListener;
            this.c = str;
            this.d = str2;
            this.e = str3;
            tm.a(blocksInfo, "BlocksInfo");
            tm.a(str3, "BlockId");
            tm.a(str, "TargetRef");
            tm.a(str2, "PageRef");
        }

        public final VideoAdRequest build() {
            return new VideoAdRequest(this, (byte) 0);
        }

        public final Builder setCharset(@Nullable Charset charset) {
            this.j = charset;
            return this;
        }

        public final Builder setContentId(String str) {
            this.k = str;
            return this;
        }

        public final Builder setContentName(String str) {
            this.l = str;
            return this;
        }

        public final Builder setExtendedParams(String str) {
            this.r = str;
            return this;
        }

        public final Builder setGenreIds(@Nullable List<String> list) {
            this.o = ie.a(list);
            return this;
        }

        public final Builder setGenreNames(@Nullable List<String> list) {
            this.p = ie.a(list);
            return this;
        }

        public final Builder setMaxBitrate(int i2) {
            this.g = i2;
            return this;
        }

        public final Builder setPlayerSize(int i2, int i3) {
            this.h = i2;
            this.i = i3;
            return this;
        }

        public final Builder setPublisherId(@Nullable String str) {
            this.m = str;
            return this;
        }

        public final Builder setPublisherName(@Nullable String str) {
            this.n = str;
            return this;
        }

        public final Builder setTagsList(@Nullable List<String> list) {
            this.q = ie.a(list);
            return this;
        }
    }

    public enum Charset {
        UTF_8("utf8"),
        CP_1251("cp1251"),
        KOI_8R("koi8r"),
        KOI_8U("koi8u");
        
        private final String e;

        private Charset(String str) {
            this.e = str;
        }

        public final String getValue() {
            return this.e;
        }
    }

    public /* synthetic */ VideoAdRequest(Builder builder, byte b2) {
        this(builder);
    }

    private static String a(int i2) {
        if (i2 >= 0) {
            return Integer.toString(i2);
        }
        return null;
    }

    @NonNull
    public final String getBlockId() {
        return this.c;
    }

    @NonNull
    public final BlocksInfo getBlocksInfo() {
        return this.b;
    }

    @NonNull
    public final Charset getCharset() {
        return this.f;
    }

    @NonNull
    public final Context getContext() {
        return this.a;
    }

    @Nullable
    public final String getExtParams() {
        return this.r;
    }

    @Nullable
    public final String getGenreId() {
        return this.o;
    }

    @Nullable
    public final String getGenreName() {
        return this.p;
    }

    public final String getMaxBitrate() {
        return a(this.h);
    }

    @NonNull
    public final String getPageRef() {
        return this.e;
    }

    public final String getPlayerHeightPix() {
        return a(this.j);
    }

    public final String getPlayerWidthPix() {
        return a(this.i);
    }

    @Nullable
    public final String getPublisherId() {
        return this.m;
    }

    @Nullable
    public final String getPublisherName() {
        return this.n;
    }

    @Nullable
    public final RequestListener<List<VideoAd>> getRequestListener() {
        return this.g;
    }

    @Nullable
    public final String getTagsList() {
        return this.q;
    }

    @NonNull
    public final String getTargetRef() {
        return this.d;
    }

    @Nullable
    public final String getVideoContentId() {
        return this.k;
    }

    @Nullable
    public final String getVideoContentName() {
        return this.l;
    }

    private VideoAdRequest(Builder builder) {
        this.a = builder.a;
        this.g = builder.f;
        this.b = builder.b;
        this.c = builder.e;
        this.d = builder.c;
        this.e = builder.d;
        this.f = builder.j != null ? builder.j : Charset.UTF_8;
        this.i = builder.h;
        this.j = builder.i;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.n = builder.n;
        this.h = builder.g;
        this.o = builder.o;
        this.p = builder.p;
        this.q = builder.q;
        this.r = builder.r;
    }
}
