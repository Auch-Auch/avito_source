package a2.j.b.b.a1;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
public final class b extends SubtitleOutputBuffer {
    public final OutputBuffer.Owner<SubtitleOutputBuffer> c;

    public b(OutputBuffer.Owner<SubtitleOutputBuffer> owner) {
        this.c = owner;
    }

    @Override // com.google.android.exoplayer2.decoder.OutputBuffer
    public final void release() {
        this.c.releaseOutputBuffer(this);
    }
}
