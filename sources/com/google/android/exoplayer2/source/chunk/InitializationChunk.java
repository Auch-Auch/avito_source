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
public final class InitializationChunk extends Chunk {
    public final ChunkExtractor a;
    public ChunkExtractor.TrackOutputProvider b;
    public long c;
    public volatile boolean d;

    public InitializationChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, @Nullable Object obj, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, 2, format, i, obj, C.TIME_UNSET, C.TIME_UNSET);
        this.a = chunkExtractor;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        this.d = true;
    }

    public void init(ChunkExtractor.TrackOutputProvider trackOutputProvider) {
        this.b = trackOutputProvider;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws IOException {
        if (this.c == 0) {
            this.a.init(this.b, C.TIME_UNSET, C.TIME_UNSET);
        }
        try {
            DataSpec subrange = this.dataSpec.subrange(this.c);
            StatsDataSource statsDataSource = this.dataSource;
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(statsDataSource, subrange.position, statsDataSource.open(subrange));
            do {
                try {
                    if (this.d) {
                        break;
                    }
                } catch (Throwable th) {
                    this.c = defaultExtractorInput.getPosition() - this.dataSpec.position;
                    throw th;
                }
            } while (this.a.read(defaultExtractorInput));
            this.c = defaultExtractorInput.getPosition() - this.dataSpec.position;
        } finally {
            Util.closeQuietly(this.dataSource);
        }
    }
}
