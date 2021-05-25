package com.google.android.exoplayer2.source.chunk;

import a2.j.b.b.u0.d;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
public final class BundledChunkExtractor implements ExtractorOutput, ChunkExtractor {
    public static final PositionHolder j = new PositionHolder();
    public final Extractor a;
    public final int b;
    public final Format c;
    public final SparseArray<a> d = new SparseArray<>();
    public boolean e;
    @Nullable
    public ChunkExtractor.TrackOutputProvider f;
    public long g;
    public SeekMap h;
    public Format[] i;

    public static final class a implements TrackOutput {
        public final int a;
        public final int b;
        @Nullable
        public final Format c;
        public final DummyTrackOutput d = new DummyTrackOutput();
        public Format e;
        public TrackOutput f;
        public long g;

        public a(int i, int i2, @Nullable Format format) {
            this.a = i;
            this.b = i2;
            this.c = format;
        }

        public void a(@Nullable ChunkExtractor.TrackOutputProvider trackOutputProvider, long j) {
            if (trackOutputProvider == null) {
                this.f = this.d;
                return;
            }
            this.g = j;
            TrackOutput track = trackOutputProvider.track(this.a, this.b);
            this.f = track;
            Format format = this.e;
            if (format != null) {
                track.format(format);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(Format format) {
            Format format2 = this.c;
            if (format2 != null) {
                format = format.withManifestFormatInfo(format2);
            }
            this.e = format;
            ((TrackOutput) Util.castNonNull(this.f)).format(this.e);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ int sampleData(DataReader dataReader, int i, boolean z) {
            return d.$default$sampleData(this, dataReader, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int sampleData(DataReader dataReader, int i, boolean z, int i2) throws IOException {
            return ((TrackOutput) Util.castNonNull(this.f)).sampleData(dataReader, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ void sampleData(ParsableByteArray parsableByteArray, int i) {
            d.$default$sampleData(this, parsableByteArray, i);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long j, int i, int i2, int i3, @Nullable TrackOutput.CryptoData cryptoData) {
            long j2 = this.g;
            if (j2 != C.TIME_UNSET && j >= j2) {
                this.f = this.d;
            }
            ((TrackOutput) Util.castNonNull(this.f)).sampleMetadata(j, i, i2, i3, cryptoData);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
            ((TrackOutput) Util.castNonNull(this.f)).sampleData(parsableByteArray, i);
        }
    }

    public BundledChunkExtractor(Extractor extractor, int i2, Format format) {
        this.a = extractor;
        this.b = i2;
        this.c = format;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        Format[] formatArr = new Format[this.d.size()];
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            formatArr[i2] = (Format) Assertions.checkStateNotNull(this.d.valueAt(i2).e);
        }
        this.i = formatArr;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    @Nullable
    public ChunkIndex getChunkIndex() {
        SeekMap seekMap = this.h;
        if (seekMap instanceof ChunkIndex) {
            return (ChunkIndex) seekMap;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    @Nullable
    public Format[] getSampleFormats() {
        return this.i;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public void init(@Nullable ChunkExtractor.TrackOutputProvider trackOutputProvider, long j2, long j3) {
        this.f = trackOutputProvider;
        this.g = j3;
        if (!this.e) {
            this.a.init(this);
            if (j2 != C.TIME_UNSET) {
                this.a.seek(0, j2);
            }
            this.e = true;
            return;
        }
        Extractor extractor = this.a;
        if (j2 == C.TIME_UNSET) {
            j2 = 0;
        }
        extractor.seek(0, j2);
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            this.d.valueAt(i2).a(trackOutputProvider, j3);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public boolean read(ExtractorInput extractorInput) throws IOException {
        int read = this.a.read(extractorInput, j);
        Assertions.checkState(read != 1);
        if (read == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public void release() {
        this.a.release();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        this.h = seekMap;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int i2, int i3) {
        a aVar = this.d.get(i2);
        if (aVar == null) {
            Assertions.checkState(this.i == null);
            aVar = new a(i2, i3, i3 == this.b ? this.c : null);
            aVar.a(this.f, this.g);
            this.d.put(i2, aVar);
        }
        return aVar;
    }
}
