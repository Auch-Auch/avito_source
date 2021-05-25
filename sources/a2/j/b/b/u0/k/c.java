package a2.j.b.b.u0.k;

import a2.j.b.b.u0.k.h;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
public final class c extends h {
    @Nullable
    public FlacStreamMetadata n;
    @Nullable
    public a o;

    public static final class a implements f {
        public FlacStreamMetadata a;
        public FlacStreamMetadata.SeekTable b;
        public long c = -1;
        public long d = -1;

        public a(FlacStreamMetadata flacStreamMetadata, FlacStreamMetadata.SeekTable seekTable) {
            this.a = flacStreamMetadata;
            this.b = seekTable;
        }

        @Override // a2.j.b.b.u0.k.f
        public SeekMap a() {
            Assertions.checkState(this.c != -1);
            return new FlacSeekTableSeekMap(this.a, this.c);
        }

        @Override // a2.j.b.b.u0.k.f
        public void b(long j) {
            long[] jArr = this.b.pointSampleNumbers;
            this.d = jArr[Util.binarySearchFloor(jArr, j, true, true)];
        }

        @Override // a2.j.b.b.u0.k.f
        public long read(ExtractorInput extractorInput) {
            long j = this.d;
            if (j < 0) {
                return -1;
            }
            long j2 = -(j + 2);
            this.d = -1;
            return j2;
        }
    }

    @Override // a2.j.b.b.u0.k.h
    public long c(ParsableByteArray parsableByteArray) {
        if (!(parsableByteArray.getData()[0] == -1)) {
            return -1;
        }
        int i = (parsableByteArray.getData()[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            parsableByteArray.skipBytes(4);
            parsableByteArray.readUtf8EncodedLong();
        }
        int readFrameBlockSizeSamplesFromKey = FlacFrameReader.readFrameBlockSizeSamplesFromKey(parsableByteArray, i);
        parsableByteArray.setPosition(0);
        return (long) readFrameBlockSizeSamplesFromKey;
    }

    @Override // a2.j.b.b.u0.k.h
    public boolean d(ParsableByteArray parsableByteArray, long j, h.b bVar) {
        byte[] data = parsableByteArray.getData();
        FlacStreamMetadata flacStreamMetadata = this.n;
        if (flacStreamMetadata == null) {
            FlacStreamMetadata flacStreamMetadata2 = new FlacStreamMetadata(data, 17);
            this.n = flacStreamMetadata2;
            bVar.a = flacStreamMetadata2.getFormat(Arrays.copyOfRange(data, 9, parsableByteArray.limit()), null);
        } else if ((data[0] & Byte.MAX_VALUE) == 3) {
            FlacStreamMetadata.SeekTable readSeekTableMetadataBlock = FlacMetadataReader.readSeekTableMetadataBlock(parsableByteArray);
            FlacStreamMetadata copyWithSeekTable = flacStreamMetadata.copyWithSeekTable(readSeekTableMetadataBlock);
            this.n = copyWithSeekTable;
            this.o = new a(copyWithSeekTable, readSeekTableMetadataBlock);
        } else {
            if (data[0] == -1) {
                a aVar = this.o;
                if (aVar != null) {
                    aVar.c = j;
                    bVar.b = aVar;
                }
                return false;
            }
        }
        return true;
    }

    @Override // a2.j.b.b.u0.k.h
    public void e(boolean z) {
        super.e(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }
}
