package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableSet;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public class BaseProducerContext implements ProducerContext {
    public static final Set<String> INITIAL_KEYS = ImmutableSet.of((Object[]) new String[]{"id", ProducerContext.ExtraKeys.SOURCE_URI});
    public final ImageRequest a;
    public final String b;
    @Nullable
    public final String c;
    public final ProducerListener2 d;
    public final Object e;
    public final ImageRequest.RequestLevel f;
    public final Map<String, Object> g;
    @GuardedBy("this")
    public boolean h;
    @GuardedBy("this")
    public Priority i;
    @GuardedBy("this")
    public boolean j;
    @GuardedBy("this")
    public boolean k;
    @GuardedBy("this")
    public final List<ProducerContextCallbacks> l;
    public final ImagePipelineConfig m;
    public EncodedImageOrigin n;

    public BaseProducerContext(ImageRequest imageRequest, String str, ProducerListener2 producerListener2, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfig imagePipelineConfig) {
        this(imageRequest, str, null, producerListener2, obj, requestLevel, z, z2, priority, imagePipelineConfig);
    }

    public static void callOnCancellationRequested(@Nullable List<ProducerContextCallbacks> list) {
        if (list != null) {
            for (ProducerContextCallbacks producerContextCallbacks : list) {
                producerContextCallbacks.onCancellationRequested();
            }
        }
    }

    public static void callOnIsIntermediateResultExpectedChanged(@Nullable List<ProducerContextCallbacks> list) {
        if (list != null) {
            for (ProducerContextCallbacks producerContextCallbacks : list) {
                producerContextCallbacks.onIsIntermediateResultExpectedChanged();
            }
        }
    }

    public static void callOnIsPrefetchChanged(@Nullable List<ProducerContextCallbacks> list) {
        if (list != null) {
            for (ProducerContextCallbacks producerContextCallbacks : list) {
                producerContextCallbacks.onIsPrefetchChanged();
            }
        }
    }

    public static void callOnPriorityChanged(@Nullable List<ProducerContextCallbacks> list) {
        if (list != null) {
            for (ProducerContextCallbacks producerContextCallbacks : list) {
                producerContextCallbacks.onPriorityChanged();
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void addCallbacks(ProducerContextCallbacks producerContextCallbacks) {
        boolean z;
        synchronized (this) {
            this.l.add(producerContextCallbacks);
            z = this.k;
        }
        if (z) {
            producerContextCallbacks.onCancellationRequested();
        }
    }

    public void cancel() {
        callOnCancellationRequested(cancelNoCallbacks());
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> cancelNoCallbacks() {
        if (this.k) {
            return null;
        }
        this.k = true;
        return new ArrayList(this.l);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public Object getCallerContext() {
        return this.e;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public EncodedImageOrigin getEncodedImageOrigin() {
        return this.n;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    @Nullable
    public <T> T getExtra(String str) {
        return (T) this.g.get(str);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public Map<String, Object> getExtras() {
        return this.g;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public String getId() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImagePipelineConfig getImagePipelineConfig() {
        return this.m;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImageRequest getImageRequest() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        return this.f;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized Priority getPriority() {
        return this.i;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ProducerListener2 getProducerListener() {
        return this.d;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    @Nullable
    public String getUiComponentId() {
        return this.c;
    }

    public synchronized boolean isCancelled() {
        return this.k;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized boolean isIntermediateResultExpected() {
        return this.j;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized boolean isPrefetch() {
        return this.h;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void putExtras(@Nullable Map<String, ?> map) {
        if (map != null) {
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                setExtra(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void putOriginExtra(@Nullable String str, @Nullable String str2) {
        this.g.put("origin", str);
        this.g.put(ProducerContext.ExtraKeys.ORIGIN_SUBCATEGORY, str2);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void setEncodedImageOrigin(EncodedImageOrigin encodedImageOrigin) {
        this.n = encodedImageOrigin;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void setExtra(String str, @Nullable Object obj) {
        if (!INITIAL_KEYS.contains(str)) {
            this.g.put(str, obj);
        }
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setIsIntermediateResultExpectedNoCallbacks(boolean z) {
        if (z == this.j) {
            return null;
        }
        this.j = z;
        return new ArrayList(this.l);
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setIsPrefetchNoCallbacks(boolean z) {
        if (z == this.h) {
            return null;
        }
        this.h = z;
        return new ArrayList(this.l);
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setPriorityNoCallbacks(Priority priority) {
        if (priority == this.i) {
            return null;
        }
        this.i = priority;
        return new ArrayList(this.l);
    }

    public BaseProducerContext(ImageRequest imageRequest, String str, @Nullable String str2, ProducerListener2 producerListener2, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfig imagePipelineConfig) {
        Object obj2;
        this.n = EncodedImageOrigin.NOT_SET;
        this.a = imageRequest;
        this.b = str;
        HashMap hashMap = new HashMap();
        this.g = hashMap;
        hashMap.put("id", str);
        if (imageRequest == null) {
            obj2 = "null-request";
        } else {
            obj2 = imageRequest.getSourceUri();
        }
        hashMap.put(ProducerContext.ExtraKeys.SOURCE_URI, obj2);
        this.c = str2;
        this.d = producerListener2;
        this.e = obj;
        this.f = requestLevel;
        this.h = z;
        this.i = priority;
        this.j = z2;
        this.k = false;
        this.l = new ArrayList();
        this.m = imagePipelineConfig;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    @Nullable
    public <E> E getExtra(String str, E e2) {
        E e3 = (E) this.g.get(str);
        return e3 == null ? e2 : e3;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void putOriginExtra(@Nullable String str) {
        putOriginExtra(str, "default");
    }
}
