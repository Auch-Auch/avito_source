package a2.j.b.b.a1.c;

import a2.j.b.b.a1.c.c;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
public abstract class c implements SubtitleDecoder {
    public final ArrayDeque<b> a = new ArrayDeque<>();
    public final ArrayDeque<SubtitleOutputBuffer> b;
    public final PriorityQueue<b> c;
    @Nullable
    public b d;
    public long e;
    public long f;

    public static final class b extends SubtitleInputBuffer implements Comparable<b> {
        public long c;

        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            b bVar2 = bVar;
            if (isEndOfStream() == bVar2.isEndOfStream()) {
                long j = this.timeUs - bVar2.timeUs;
                if (j == 0) {
                    j = this.c - bVar2.c;
                    if (j == 0) {
                        return 0;
                    }
                }
                if (j > 0) {
                    return 1;
                }
            } else if (isEndOfStream()) {
                return 1;
            }
            return -1;
        }

        public b(a aVar) {
        }
    }

    /* renamed from: a2.j.b.b.a1.c.c$c  reason: collision with other inner class name */
    public static final class C0036c extends SubtitleOutputBuffer {
        public OutputBuffer.Owner<C0036c> c;

        public C0036c(OutputBuffer.Owner<C0036c> owner) {
            this.c = owner;
        }

        @Override // com.google.android.exoplayer2.decoder.OutputBuffer
        public final void release() {
            this.c.releaseOutputBuffer(this);
        }
    }

    public c() {
        for (int i = 0; i < 10; i++) {
            this.a.add(new b(null));
        }
        this.b = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.b.add(new C0036c(new OutputBuffer.Owner() { // from class: a2.j.b.b.a1.c.b
                @Override // com.google.android.exoplayer2.decoder.OutputBuffer.Owner
                public final void releaseOutputBuffer(OutputBuffer outputBuffer) {
                    c.this.releaseOutputBuffer((c.C0036c) outputBuffer);
                }
            }));
        }
        this.c = new PriorityQueue<>();
    }

    public final void a(b bVar) {
        bVar.clear();
        this.a.add(bVar);
    }

    public abstract Subtitle createSubtitle();

    public abstract void decode(SubtitleInputBuffer subtitleInputBuffer);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        this.f = 0;
        this.e = 0;
        while (!this.c.isEmpty()) {
            a((b) Util.castNonNull(this.c.poll()));
        }
        b bVar = this.d;
        if (bVar != null) {
            a(bVar);
            this.d = null;
        }
    }

    @Nullable
    public final SubtitleOutputBuffer getAvailableOutputBuffer() {
        return this.b.pollFirst();
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public abstract String getName();

    public final long getPositionUs() {
        return this.e;
    }

    public abstract boolean isNewSubtitleDataAvailable();

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }

    public void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.clear();
        this.b.add(subtitleOutputBuffer);
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j) {
        this.e = j;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        Assertions.checkState(this.d == null);
        if (this.a.isEmpty()) {
            return null;
        }
        b pollFirst = this.a.pollFirst();
        this.d = pollFirst;
        return pollFirst;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        if (this.b.isEmpty()) {
            return null;
        }
        while (!this.c.isEmpty() && ((b) Util.castNonNull(this.c.peek())).timeUs <= this.e) {
            b bVar = (b) Util.castNonNull(this.c.poll());
            if (bVar.isEndOfStream()) {
                SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) Util.castNonNull(this.b.pollFirst());
                subtitleOutputBuffer.addFlag(4);
                a(bVar);
                return subtitleOutputBuffer;
            }
            decode(bVar);
            if (isNewSubtitleDataAvailable()) {
                Subtitle createSubtitle = createSubtitle();
                SubtitleOutputBuffer subtitleOutputBuffer2 = (SubtitleOutputBuffer) Util.castNonNull(this.b.pollFirst());
                subtitleOutputBuffer2.setContent(bVar.timeUs, createSubtitle, Long.MAX_VALUE);
                a(bVar);
                return subtitleOutputBuffer2;
            }
            a(bVar);
        }
        return null;
    }

    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        Assertions.checkArgument(subtitleInputBuffer == this.d);
        b bVar = (b) subtitleInputBuffer;
        if (bVar.isDecodeOnly()) {
            a(bVar);
        } else {
            long j = this.f;
            this.f = 1 + j;
            bVar.c = j;
            this.c.add(bVar);
        }
        this.d = null;
    }
}
