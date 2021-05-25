package com.facebook.internal;

import android.graphics.Bitmap;
public class ImageResponse {
    public ImageRequest a;
    public Exception b;
    public boolean c;
    public Bitmap d;

    public ImageResponse(ImageRequest imageRequest, Exception exc, boolean z, Bitmap bitmap) {
        this.a = imageRequest;
        this.b = exc;
        this.d = bitmap;
        this.c = z;
    }

    public Bitmap getBitmap() {
        return this.d;
    }

    public Exception getError() {
        return this.b;
    }

    public ImageRequest getRequest() {
        return this.a;
    }

    public boolean isCachedRedirect() {
        return this.c;
    }
}
