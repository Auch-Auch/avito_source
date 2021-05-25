package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.os.BuildCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public final class GlideBuilder {
    public final Map<Class<?>, TransitionOptions<?, ?>> a = new ArrayMap();
    public Engine b;
    public BitmapPool c;
    public ArrayPool d;
    public MemoryCache e;
    public GlideExecutor f;
    public GlideExecutor g;
    public DiskCache.Factory h;
    public MemorySizeCalculator i;
    public ConnectivityMonitorFactory j;
    public int k = 4;
    public Glide.RequestOptionsFactory l = new a(this);
    @Nullable
    public RequestManagerRetriever.RequestManagerFactory m;
    public GlideExecutor n;
    public boolean o;
    @Nullable
    public List<RequestListener<Object>> p;
    public boolean q;
    public boolean r;

    public class a implements Glide.RequestOptionsFactory {
        public a(GlideBuilder glideBuilder) {
        }

        @Override // com.bumptech.glide.Glide.RequestOptionsFactory
        @NonNull
        public RequestOptions build() {
            return new RequestOptions();
        }
    }

    public class b implements Glide.RequestOptionsFactory {
        public final /* synthetic */ RequestOptions a;

        public b(GlideBuilder glideBuilder, RequestOptions requestOptions) {
            this.a = requestOptions;
        }

        @Override // com.bumptech.glide.Glide.RequestOptionsFactory
        @NonNull
        public RequestOptions build() {
            RequestOptions requestOptions = this.a;
            return requestOptions != null ? requestOptions : new RequestOptions();
        }
    }

    @NonNull
    public GlideBuilder addGlobalRequestListener(@NonNull RequestListener<Object> requestListener) {
        if (this.p == null) {
            this.p = new ArrayList();
        }
        this.p.add(requestListener);
        return this;
    }

    @NonNull
    public GlideBuilder setAnimationExecutor(@Nullable GlideExecutor glideExecutor) {
        this.n = glideExecutor;
        return this;
    }

    @NonNull
    public GlideBuilder setArrayPool(@Nullable ArrayPool arrayPool) {
        this.d = arrayPool;
        return this;
    }

    @NonNull
    public GlideBuilder setBitmapPool(@Nullable BitmapPool bitmapPool) {
        this.c = bitmapPool;
        return this;
    }

    @NonNull
    public GlideBuilder setConnectivityMonitorFactory(@Nullable ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.j = connectivityMonitorFactory;
        return this;
    }

    @NonNull
    public GlideBuilder setDefaultRequestOptions(@Nullable RequestOptions requestOptions) {
        return setDefaultRequestOptions(new b(this, requestOptions));
    }

    @NonNull
    public <T> GlideBuilder setDefaultTransitionOptions(@NonNull Class<T> cls, @Nullable TransitionOptions<?, T> transitionOptions) {
        this.a.put(cls, transitionOptions);
        return this;
    }

    @NonNull
    public GlideBuilder setDiskCache(@Nullable DiskCache.Factory factory) {
        this.h = factory;
        return this;
    }

    @NonNull
    public GlideBuilder setDiskCacheExecutor(@Nullable GlideExecutor glideExecutor) {
        this.g = glideExecutor;
        return this;
    }

    public GlideBuilder setImageDecoderEnabledForBitmaps(boolean z) {
        if (!BuildCompat.isAtLeastQ()) {
            return this;
        }
        this.r = z;
        return this;
    }

    @NonNull
    public GlideBuilder setIsActiveResourceRetentionAllowed(boolean z) {
        this.o = z;
        return this;
    }

    @NonNull
    public GlideBuilder setLogLevel(int i2) {
        if (i2 < 2 || i2 > 6) {
            throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        this.k = i2;
        return this;
    }

    public GlideBuilder setLogRequestOrigins(boolean z) {
        this.q = z;
        return this;
    }

    @NonNull
    public GlideBuilder setMemoryCache(@Nullable MemoryCache memoryCache) {
        this.e = memoryCache;
        return this;
    }

    @NonNull
    public GlideBuilder setMemorySizeCalculator(@NonNull MemorySizeCalculator.Builder builder) {
        return setMemorySizeCalculator(builder.build());
    }

    @Deprecated
    public GlideBuilder setResizeExecutor(@Nullable GlideExecutor glideExecutor) {
        return setSourceExecutor(glideExecutor);
    }

    @NonNull
    public GlideBuilder setSourceExecutor(@Nullable GlideExecutor glideExecutor) {
        this.f = glideExecutor;
        return this;
    }

    @NonNull
    public GlideBuilder setDefaultRequestOptions(@NonNull Glide.RequestOptionsFactory requestOptionsFactory) {
        this.l = (Glide.RequestOptionsFactory) Preconditions.checkNotNull(requestOptionsFactory);
        return this;
    }

    @NonNull
    public GlideBuilder setMemorySizeCalculator(@Nullable MemorySizeCalculator memorySizeCalculator) {
        this.i = memorySizeCalculator;
        return this;
    }
}
