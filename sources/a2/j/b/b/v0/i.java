package a2.j.b.b.v0;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
public final class i extends DecoderInputBuffer {
    public final DecoderInputBuffer c = new DecoderInputBuffer(2);
    public boolean d;
    public long e;
    public int f;
    public int g;

    public i() {
        super(2);
        clear();
    }

    public void b() {
        super.clear();
        this.f = 0;
        this.e = C.TIME_UNSET;
        this.timeUs = C.TIME_UNSET;
        if (this.d) {
            f(this.c);
            this.d = false;
        }
    }

    public void c() {
        super.clear();
        this.f = 0;
        this.e = C.TIME_UNSET;
        this.timeUs = C.TIME_UNSET;
        this.c.clear();
        this.d = false;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer, com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        this.f = 0;
        this.e = C.TIME_UNSET;
        this.timeUs = C.TIME_UNSET;
        this.c.clear();
        this.d = false;
        this.g = 32;
    }

    public boolean d() {
        return this.f == 0;
    }

    public boolean e() {
        ByteBuffer byteBuffer;
        return this.f >= this.g || ((byteBuffer = this.data) != null && byteBuffer.position() >= 3072000) || this.d;
    }

    public final void f(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer = decoderInputBuffer.data;
        if (byteBuffer != null) {
            decoderInputBuffer.flip();
            ensureSpaceForWrite(byteBuffer.remaining());
            this.data.put(byteBuffer);
        }
        if (decoderInputBuffer.isEndOfStream()) {
            setFlags(4);
        }
        if (decoderInputBuffer.isDecodeOnly()) {
            setFlags(Integer.MIN_VALUE);
        }
        if (decoderInputBuffer.isKeyFrame()) {
            setFlags(1);
        }
        int i = this.f + 1;
        this.f = i;
        long j = decoderInputBuffer.timeUs;
        this.timeUs = j;
        if (i == 1) {
            this.e = j;
        }
        decoderInputBuffer.clear();
    }
}
