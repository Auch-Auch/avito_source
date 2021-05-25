package a2.j.b.b.v0;

import android.media.MediaCodec;
import android.media.MediaFormat;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.IntArrayQueue;
import java.util.ArrayDeque;
@RequiresApi(21)
public final class k extends MediaCodec.Callback {
    public final IntArrayQueue a = new IntArrayQueue();
    public final IntArrayQueue b = new IntArrayQueue();
    public final ArrayDeque<MediaCodec.BufferInfo> c = new ArrayDeque<>();
    public final ArrayDeque<MediaFormat> d = new ArrayDeque<>();
    @Nullable
    public MediaFormat e;
    @Nullable
    public MediaFormat f;
    @Nullable
    public IllegalStateException g;

    public int a(MediaCodec.BufferInfo bufferInfo) {
        if (this.b.isEmpty()) {
            return -1;
        }
        int remove = this.b.remove();
        if (remove >= 0) {
            MediaCodec.BufferInfo remove2 = this.c.remove();
            bufferInfo.set(remove2.offset, remove2.size, remove2.presentationTimeUs, remove2.flags);
        } else if (remove == -2) {
            this.e = this.d.remove();
        }
        return remove;
    }

    public void b() {
        this.f = this.d.isEmpty() ? null : this.d.getLast();
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.g = null;
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        this.g = codecException;
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        this.a.add(i);
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        MediaFormat mediaFormat = this.f;
        if (mediaFormat != null) {
            this.b.add(-2);
            this.d.add(mediaFormat);
            this.f = null;
        }
        this.b.add(i);
        this.c.add(bufferInfo);
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        this.b.add(-2);
        this.d.add(mediaFormat);
        this.f = null;
    }
}
