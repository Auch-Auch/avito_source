package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import java.io.File;
import javax.annotation.Nullable;
public class DiskCacheConfig {
    public final int a;
    public final String b;
    public final Supplier<File> c;
    public final long d;
    public final long e;
    public final long f;
    public final EntryEvictionComparatorSupplier g;
    public final CacheErrorLogger h;
    public final CacheEventListener i;
    public final DiskTrimmableRegistry j;
    public final Context k;
    public final boolean l;

    public static class Builder {
        public int a = 1;
        public String b = "image_cache";
        public Supplier<File> c;
        public long d = 41943040;
        public long e = 10485760;
        public long f = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        public EntryEvictionComparatorSupplier g = new DefaultEntryEvictionComparatorSupplier();
        public CacheErrorLogger h;
        public CacheEventListener i;
        public DiskTrimmableRegistry j;
        public boolean k;
        @Nullable
        public final Context l;

        public Builder(Context context, a aVar) {
            this.l = context;
        }

        public DiskCacheConfig build() {
            return new DiskCacheConfig(this);
        }

        public Builder setBaseDirectoryName(String str) {
            this.b = str;
            return this;
        }

        public Builder setBaseDirectoryPath(File file) {
            this.c = Suppliers.of(file);
            return this;
        }

        public Builder setBaseDirectoryPathSupplier(Supplier<File> supplier) {
            this.c = supplier;
            return this;
        }

        public Builder setCacheErrorLogger(CacheErrorLogger cacheErrorLogger) {
            this.h = cacheErrorLogger;
            return this;
        }

        public Builder setCacheEventListener(CacheEventListener cacheEventListener) {
            this.i = cacheEventListener;
            return this;
        }

        public Builder setDiskTrimmableRegistry(DiskTrimmableRegistry diskTrimmableRegistry) {
            this.j = diskTrimmableRegistry;
            return this;
        }

        public Builder setEntryEvictionComparatorSupplier(EntryEvictionComparatorSupplier entryEvictionComparatorSupplier) {
            this.g = entryEvictionComparatorSupplier;
            return this;
        }

        public Builder setIndexPopulateAtStartupEnabled(boolean z) {
            this.k = z;
            return this;
        }

        public Builder setMaxCacheSize(long j2) {
            this.d = j2;
            return this;
        }

        public Builder setMaxCacheSizeOnLowDiskSpace(long j2) {
            this.e = j2;
            return this;
        }

        public Builder setMaxCacheSizeOnVeryLowDiskSpace(long j2) {
            this.f = j2;
            return this;
        }

        public Builder setVersion(int i2) {
            this.a = i2;
            return this;
        }
    }

    public class a implements Supplier<File> {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.facebook.common.internal.Supplier
        public File get() {
            return DiskCacheConfig.this.k.getApplicationContext().getCacheDir();
        }
    }

    public DiskCacheConfig(Builder builder) {
        Context context = builder.l;
        this.k = context;
        Preconditions.checkState((builder.c == null && context == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
        if (builder.c == null && context != null) {
            builder.c = new a();
        }
        this.a = builder.a;
        this.b = (String) Preconditions.checkNotNull(builder.b);
        this.c = (Supplier) Preconditions.checkNotNull(builder.c);
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = (EntryEvictionComparatorSupplier) Preconditions.checkNotNull(builder.g);
        CacheErrorLogger cacheErrorLogger = builder.h;
        this.h = cacheErrorLogger == null ? NoOpCacheErrorLogger.getInstance() : cacheErrorLogger;
        CacheEventListener cacheEventListener = builder.i;
        this.i = cacheEventListener == null ? NoOpCacheEventListener.getInstance() : cacheEventListener;
        DiskTrimmableRegistry diskTrimmableRegistry = builder.j;
        this.j = diskTrimmableRegistry == null ? NoOpDiskTrimmableRegistry.getInstance() : diskTrimmableRegistry;
        this.l = builder.k;
    }

    public static Builder newBuilder(@Nullable Context context) {
        return new Builder(context, null);
    }

    public String getBaseDirectoryName() {
        return this.b;
    }

    public Supplier<File> getBaseDirectoryPathSupplier() {
        return this.c;
    }

    public CacheErrorLogger getCacheErrorLogger() {
        return this.h;
    }

    public CacheEventListener getCacheEventListener() {
        return this.i;
    }

    public Context getContext() {
        return this.k;
    }

    public long getDefaultSizeLimit() {
        return this.d;
    }

    public DiskTrimmableRegistry getDiskTrimmableRegistry() {
        return this.j;
    }

    public EntryEvictionComparatorSupplier getEntryEvictionComparatorSupplier() {
        return this.g;
    }

    public boolean getIndexPopulateAtStartupEnabled() {
        return this.l;
    }

    public long getLowDiskSpaceSizeLimit() {
        return this.e;
    }

    public long getMinimumSizeLimit() {
        return this.f;
    }

    public int getVersion() {
        return this.a;
    }
}
