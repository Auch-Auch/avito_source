package a2.d.a.d.d.a;

import android.media.MediaDataSource;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import java.nio.ByteBuffer;
public class b extends MediaDataSource {
    public final /* synthetic */ ByteBuffer a;

    public b(VideoDecoder.d dVar, ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        return (long) this.a.limit();
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) {
        if (j >= ((long) this.a.limit())) {
            return -1;
        }
        this.a.position((int) j);
        int min = Math.min(i2, this.a.remaining());
        this.a.get(bArr, i, min);
        return min;
    }
}
