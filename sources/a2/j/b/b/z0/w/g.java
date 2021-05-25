package a2.j.b.b.z0.w;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.SampleQueueMappingException;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
public final class g implements SampleStream {
    public final int a;
    public final HlsSampleStreamWrapper b;
    public int c = -1;

    public g(HlsSampleStreamWrapper hlsSampleStreamWrapper, int i) {
        this.b = hlsSampleStreamWrapper;
        this.a = i;
    }

    public void a() {
        Assertions.checkArgument(this.c == -1);
        HlsSampleStreamWrapper hlsSampleStreamWrapper = this.b;
        int i = this.a;
        hlsSampleStreamWrapper.a();
        Assertions.checkNotNull(hlsSampleStreamWrapper.H);
        int i2 = hlsSampleStreamWrapper.H[i];
        if (i2 != -1) {
            boolean[] zArr = hlsSampleStreamWrapper.K;
            if (!zArr[i2]) {
                zArr[i2] = true;
                this.c = i2;
            }
        } else if (hlsSampleStreamWrapper.G.contains(hlsSampleStreamWrapper.F.get(i))) {
            i2 = -3;
            this.c = i2;
        }
        i2 = -2;
        this.c = i2;
    }

    public final boolean b() {
        int i = this.c;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        if (this.c != -3) {
            if (!b()) {
                return false;
            }
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.b;
            if (!(!hlsSampleStreamWrapper.g() && hlsSampleStreamWrapper.s[this.c].isReady(hlsSampleStreamWrapper.Q))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws IOException {
        int i = this.c;
        if (i == -2) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.b;
            hlsSampleStreamWrapper.a();
            throw new SampleQueueMappingException(hlsSampleStreamWrapper.F.get(this.a).getFormat(0).sampleMimeType);
        } else if (i == -1) {
            this.b.i();
        } else if (i != -3) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper2 = this.b;
            hlsSampleStreamWrapper2.i();
            hlsSampleStreamWrapper2.s[i].maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (this.c == -3) {
            decoderInputBuffer.addFlag(4);
            return -4;
        } else if (b()) {
            return this.b.n(this.c, formatHolder, decoderInputBuffer, z);
        } else {
            return -3;
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j) {
        if (b()) {
            return this.b.r(this.c, j);
        }
        return 0;
    }
}
