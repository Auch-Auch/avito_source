package a2.g.p.a;

import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.ValueDescriptor;
public class d implements ValueDescriptor<CountingMemoryCache.b<K, V>> {
    public final /* synthetic */ ValueDescriptor a;

    public d(CountingMemoryCache countingMemoryCache, ValueDescriptor valueDescriptor) {
        this.a = valueDescriptor;
    }

    @Override // com.facebook.imagepipeline.cache.ValueDescriptor
    public int getSizeInBytes(Object obj) {
        return this.a.getSizeInBytes(((CountingMemoryCache.b) obj).b.get());
    }
}
