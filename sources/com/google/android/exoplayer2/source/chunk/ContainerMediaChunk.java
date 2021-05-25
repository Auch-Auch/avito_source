package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
public class ContainerMediaChunk extends BaseMediaChunk {
    public final int c;
    public final long d;
    public final ChunkExtractor e;
    public long f;
    public volatile boolean g;
    public boolean h;

    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, @Nullable Object obj, long j, long j2, long j3, long j4, long j5, int i2, long j6, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, format, i, obj, j, j2, j3, j4, j5);
        this.c = i2;
        this.d = j6;
        this.e = chunkExtractor;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.g = true;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public long getNextChunkIndex() {
        return this.chunkIndex + ((long) this.c);
    }

    public ChunkExtractor.TrackOutputProvider getTrackOutputProvider(BaseMediaChunkOutput baseMediaChunkOutput) {
        return baseMediaChunkOutput;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.h;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws IOException {
        if (this.f == 0) {
            BaseMediaChunkOutput output = getOutput();
            output.setSampleOffsetUs(this.d);
            ChunkExtractor chunkExtractor = this.e;
            ChunkExtractor.TrackOutputProvider trackOutputProvider = getTrackOutputProvider(output);
            long j = this.clippedStartTimeUs;
            long j2 = j == C.TIME_UNSET ? -9223372036854775807L : j - this.d;
            long j3 = this.clippedEndTimeUs;
            chunkExtractor.init(trackOutputProvider, j2, j3 == C.TIME_UNSET ? -9223372036854775807L : j3 - this.d);
        }
        try {
            DataSpec subrange = this.dataSpec.subrange(this.f);
            StatsDataSource statsDataSource = this.dataSource;
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(statsDataSource, subrange.position, statsDataSource.open(subrange));
            do {
                try {
                    if (this.g) {
                        break;
                    }
                } catch (Throwable th) {
                    this.f = defaultExtractorInput.getPosition() - this.dataSpec.position;
                    throw th;
                }
            } while (this.e.read(defaultExtractorInput));
            this.f = defaultExtractorInput.getPosition() - this.dataSpec.position;
            Util.closeQuietly(this.dataSource);
            this.h = !this.g;
        } catch (Throwable th2) {
            Util.closeQuietly(this.dataSource);
            throw th2;
        }
    }
}
