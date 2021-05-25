package a2.j.b.b.z0.v;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
public final class c implements SampleStream {
    public final Format a;
    public final EventMessageEncoder b = new EventMessageEncoder();
    public long[] c;
    public boolean d;
    public EventStream e;
    public boolean f;
    public int g;
    public long h = C.TIME_UNSET;

    public c(EventStream eventStream, Format format, boolean z) {
        this.a = format;
        this.e = eventStream;
        this.c = eventStream.presentationTimesUs;
        b(eventStream, z);
    }

    public void a(long j) {
        boolean z = true;
        int binarySearchCeil = Util.binarySearchCeil(this.c, j, true, false);
        this.g = binarySearchCeil;
        if (!this.d || binarySearchCeil != this.c.length) {
            z = false;
        }
        if (!z) {
            j = C.TIME_UNSET;
        }
        this.h = j;
    }

    public void b(EventStream eventStream, boolean z) {
        int i = this.g;
        long j = i == 0 ? -9223372036854775807L : this.c[i - 1];
        this.d = z;
        this.e = eventStream;
        long[] jArr = eventStream.presentationTimesUs;
        this.c = jArr;
        long j2 = this.h;
        if (j2 != C.TIME_UNSET) {
            a(j2);
        } else if (j != C.TIME_UNSET) {
            this.g = Util.binarySearchCeil(jArr, j, false, false);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws IOException {
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (z || !this.f) {
            formatHolder.format = this.a;
            this.f = true;
            return -5;
        }
        int i = this.g;
        if (i != this.c.length) {
            this.g = i + 1;
            byte[] encode = this.b.encode(this.e.events[i]);
            if (encode == null) {
                return -3;
            }
            decoderInputBuffer.ensureSpaceForWrite(encode.length);
            decoderInputBuffer.data.put(encode);
            decoderInputBuffer.timeUs = this.c[i];
            decoderInputBuffer.setFlags(1);
            return -4;
        } else if (this.d) {
            return -3;
        } else {
            decoderInputBuffer.setFlags(4);
            return -4;
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j) {
        int max = Math.max(this.g, Util.binarySearchCeil(this.c, j, true, false));
        int i = max - this.g;
        this.g = max;
        return i;
    }
}
