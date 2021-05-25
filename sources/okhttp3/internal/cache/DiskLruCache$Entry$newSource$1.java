package okhttp3.internal.cache;

import kotlin.Metadata;
import kotlin.Unit;
import okhttp3.internal.cache.DiskLruCache;
import okio.ForwardingSource;
import okio.Source;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"okhttp3/internal/cache/DiskLruCache$Entry$newSource$1", "Lokio/ForwardingSource;", "", "close", "()V", "", "closed", "Z", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class DiskLruCache$Entry$newSource$1 extends ForwardingSource {
    public final /* synthetic */ Source $fileSource;
    private boolean closed;
    public final /* synthetic */ DiskLruCache.Entry this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Entry$newSource$1(DiskLruCache.Entry entry, Source source, Source source2) {
        super(source2);
        this.this$0 = entry;
        this.$fileSource = source;
    }

    @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        if (!this.closed) {
            this.closed = true;
            synchronized (this.this$0.this$0) {
                DiskLruCache.Entry entry = this.this$0;
                entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount$okhttp() - 1);
                if (this.this$0.getLockingSourceCount$okhttp() == 0 && this.this$0.getZombie$okhttp()) {
                    DiskLruCache.Entry entry2 = this.this$0;
                    entry2.this$0.removeEntry$okhttp(entry2);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
