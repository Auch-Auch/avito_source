package com.yandex.mobile.ads.video;

import com.yandex.mobile.ads.impl.tw;
import com.yandex.mobile.ads.impl.tx;
public final class VideoAdError {
    private final int a;
    private final String b;
    private final String c;

    public interface Code {
    }

    private VideoAdError(int i, String str) {
        this(i, str, (byte) 0);
    }

    public static VideoAdError createConnectionError(String str) {
        return new VideoAdError(2, str);
    }

    public static VideoAdError createInternalError(tx txVar) {
        return new VideoAdError(1, "Internal error. Failed to parse response");
    }

    public static final VideoAdError createNoAdError(tw twVar) {
        return new VideoAdError(3, twVar.getMessage());
    }

    public static VideoAdError createRetriableError(String str) {
        return new VideoAdError(4, str);
    }

    public final int getCode() {
        return this.a;
    }

    public final String getDescription() {
        return this.b;
    }

    public final String getRawResponse() {
        return this.c;
    }

    private VideoAdError(int i, String str, byte b2) {
        this.a = i;
        this.b = str;
        this.c = null;
    }

    public static VideoAdError createInternalError(String str) {
        return new VideoAdError(1, str);
    }
}
