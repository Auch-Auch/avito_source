package a2.j.b.b.u0.i;

import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.mp3.Seeker;
public final class c extends ConstantBitrateSeekMap implements Seeker {
    public c(long j, long j2, MpegAudioUtil.Header header) {
        super(j, j2, header.bitrate, header.frameSize);
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        return getTimeUsAtPosition(j);
    }
}
