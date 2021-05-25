package com.facebook.imagepipeline.image;

import android.net.Uri;
import javax.annotation.Nullable;
public class OriginalEncodedImageInfo {
    public static final OriginalEncodedImageInfo EMPTY = new OriginalEncodedImageInfo();
    @Nullable
    public final Uri a;
    @Nullable
    public final EncodedImageOrigin b;
    @Nullable
    public final Object c;
    public final int d;
    public final int e;
    public final int f;

    public OriginalEncodedImageInfo() {
        this.a = null;
        this.b = EncodedImageOrigin.NOT_SET;
        this.c = null;
        this.d = -1;
        this.e = -1;
        this.f = -1;
    }

    @Nullable
    public Object getCallerContext() {
        return this.c;
    }

    public int getHeight() {
        return this.e;
    }

    public EncodedImageOrigin getOrigin() {
        return this.b;
    }

    public int getSize() {
        return this.f;
    }

    @Nullable
    public Uri getUri() {
        return this.a;
    }

    public int getWidth() {
        return this.d;
    }

    public OriginalEncodedImageInfo(Uri uri, EncodedImageOrigin encodedImageOrigin, @Nullable Object obj, int i, int i2, int i3) {
        this.a = uri;
        this.b = encodedImageOrigin;
        this.c = obj;
        this.d = i;
        this.e = i2;
        this.f = i3;
    }
}
