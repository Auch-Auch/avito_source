package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
public class DiskLruCacheFactory implements DiskCache.Factory {
    public final long a;
    public final CacheDirectoryGetter b;

    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    public class a implements CacheDirectoryGetter {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            return new File(this.a);
        }
    }

    public class b implements CacheDirectoryGetter {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            return new File(this.a, this.b);
        }
    }

    public DiskLruCacheFactory(String str, long j) {
        this(new a(str), j);
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File cacheDirectory = this.b.getCacheDirectory();
        if (cacheDirectory == null) {
            return null;
        }
        if (cacheDirectory.mkdirs() || (cacheDirectory.exists() && cacheDirectory.isDirectory())) {
            return DiskLruCacheWrapper.create(cacheDirectory, this.a);
        }
        return null;
    }

    public DiskLruCacheFactory(String str, String str2, long j) {
        this(new b(str, str2), j);
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j) {
        this.a = j;
        this.b = cacheDirectoryGetter;
    }
}
