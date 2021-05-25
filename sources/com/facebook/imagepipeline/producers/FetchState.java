package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import javax.annotation.Nullable;
public class FetchState {
    public final Consumer<EncodedImage> a;
    public final ProducerContext b;
    public long c = 0;
    public int d;
    @Nullable
    public BytesRange e;

    public FetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.a = consumer;
        this.b = producerContext;
    }

    public Consumer<EncodedImage> getConsumer() {
        return this.a;
    }

    public ProducerContext getContext() {
        return this.b;
    }

    public String getId() {
        return this.b.getId();
    }

    public long getLastIntermediateResultTimeMs() {
        return this.c;
    }

    public ProducerListener2 getListener() {
        return this.b.getProducerListener();
    }

    public int getOnNewResultStatusFlags() {
        return this.d;
    }

    @Nullable
    public BytesRange getResponseBytesRange() {
        return this.e;
    }

    public Uri getUri() {
        return this.b.getImageRequest().getSourceUri();
    }

    public void setLastIntermediateResultTimeMs(long j) {
        this.c = j;
    }

    public void setOnNewResultStatusFlags(int i) {
        this.d = i;
    }

    public void setResponseBytesRange(BytesRange bytesRange) {
        this.e = bytesRange;
    }
}
