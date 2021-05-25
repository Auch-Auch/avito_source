package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
public final class SingleSampleMediaChunk extends BaseMediaChunk {
    public final int c;
    public final Format d;
    public long e;
    public boolean f;

    public SingleSampleMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, @Nullable Object obj, long j, long j2, long j3, int i2, Format format2) {
        super(dataSource, dataSpec, format, i, obj, j, j2, C.TIME_UNSET, C.TIME_UNSET, j3);
        this.c = i2;
        this.d = format2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.f;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws IOException {
        BaseMediaChunkOutput output = getOutput();
        output.setSampleOffsetUs(0);
        TrackOutput track = output.track(0, this.c);
        track.format(this.d);
        try {
            long open = this.dataSource.open(this.dataSpec.subrange(this.e));
            if (open != -1) {
                open += this.e;
            }
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.dataSource, this.e, open);
            for (int i = 0; i != -1; i = track.sampleData((DataReader) defaultExtractorInput, Integer.MAX_VALUE, true)) {
                this.e += (long) i;
            }
            track.sampleMetadata(this.startTimeUs, 1, (int) this.e, 0, null);
            Util.closeQuietly(this.dataSource);
            this.f = true;
        } catch (Throwable th) {
            Util.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
