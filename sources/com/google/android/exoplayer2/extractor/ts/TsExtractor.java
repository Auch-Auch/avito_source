package com.google.android.exoplayer2.extractor.ts;

import a2.j.b.b.u0.l.e;
import a2.j.b.b.u0.l.i;
import a2.j.b.b.u0.l.j;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class TsExtractor implements Extractor {
    public static final int DEFAULT_TIMESTAMP_SEARCH_BYTES = 112800;
    public static final ExtractorsFactory FACTORY = e.a;
    public static final int MODE_HLS = 2;
    public static final int MODE_MULTI_PMT = 0;
    public static final int MODE_SINGLE_PMT = 1;
    public static final int TS_PACKET_SIZE = 188;
    public static final int TS_STREAM_TYPE_AAC_ADTS = 15;
    public static final int TS_STREAM_TYPE_AAC_LATM = 17;
    public static final int TS_STREAM_TYPE_AC3 = 129;
    public static final int TS_STREAM_TYPE_AC4 = 172;
    public static final int TS_STREAM_TYPE_AIT = 257;
    public static final int TS_STREAM_TYPE_DTS = 138;
    public static final int TS_STREAM_TYPE_DVBSUBS = 89;
    public static final int TS_STREAM_TYPE_E_AC3 = 135;
    public static final int TS_STREAM_TYPE_H262 = 2;
    public static final int TS_STREAM_TYPE_H263 = 16;
    public static final int TS_STREAM_TYPE_H264 = 27;
    public static final int TS_STREAM_TYPE_H265 = 36;
    public static final int TS_STREAM_TYPE_HDMV_DTS = 130;
    public static final int TS_STREAM_TYPE_ID3 = 21;
    public static final int TS_STREAM_TYPE_MPA = 3;
    public static final int TS_STREAM_TYPE_MPA_LSF = 4;
    public static final int TS_STREAM_TYPE_SPLICE_INFO = 134;
    public static final int TS_SYNC_BYTE = 71;
    public final int a;
    public final int b;
    public final List<TimestampAdjuster> c;
    public final ParsableByteArray d;
    public final SparseIntArray e;
    public final TsPayloadReader.Factory f;
    public final SparseArray<TsPayloadReader> g;
    public final SparseBooleanArray h;
    public final SparseBooleanArray i;
    public final j j;
    public i k;
    public ExtractorOutput l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public TsPayloadReader q;
    public int r;
    public int s;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public class a implements SectionPayloadReader {
        public final ParsableBitArray a = new ParsableBitArray(new byte[4]);

        public a() {
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void consume(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.readUnsignedByte() == 0 && (parsableByteArray.readUnsignedByte() & 128) != 0) {
                parsableByteArray.skipBytes(6);
                int bytesLeft = parsableByteArray.bytesLeft() / 4;
                for (int i = 0; i < bytesLeft; i++) {
                    parsableByteArray.readBytes(this.a, 4);
                    int readBits = this.a.readBits(16);
                    this.a.skipBits(3);
                    if (readBits == 0) {
                        this.a.skipBits(13);
                    } else {
                        int readBits2 = this.a.readBits(13);
                        if (TsExtractor.this.g.get(readBits2) == null) {
                            TsExtractor tsExtractor = TsExtractor.this;
                            tsExtractor.g.put(readBits2, new SectionReader(new b(readBits2)));
                            TsExtractor.this.m++;
                        }
                    }
                }
                TsExtractor tsExtractor2 = TsExtractor.this;
                if (tsExtractor2.a != 2) {
                    tsExtractor2.g.remove(0);
                }
            }
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    public class b implements SectionPayloadReader {
        public final ParsableBitArray a = new ParsableBitArray(new byte[5]);
        public final SparseArray<TsPayloadReader> b = new SparseArray<>();
        public final SparseIntArray c = new SparseIntArray();
        public final int d;

        public b(int i) {
            this.d = i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0143, code lost:
            if (r25.readUnsignedByte() == r13) goto L_0x0145;
         */
        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void consume(com.google.android.exoplayer2.util.ParsableByteArray r25) {
            /*
            // Method dump skipped, instructions count: 707
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.TsExtractor.b.consume(com.google.android.exoplayer2.util.ParsableByteArray):void");
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    public TsExtractor() {
        this(0);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.l = extractorOutput;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v2, resolved type: android.util.SparseBooleanArray */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput r19, com.google.android.exoplayer2.extractor.PositionHolder r20) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 707
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.TsExtractor.read(com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.extractor.PositionHolder):int");
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        i iVar;
        Assertions.checkState(this.a != 2);
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            TimestampAdjuster timestampAdjuster = this.c.get(i2);
            if ((timestampAdjuster.getTimestampOffsetUs() == C.TIME_UNSET) || !(timestampAdjuster.getTimestampOffsetUs() == 0 || timestampAdjuster.getFirstSampleTimestampUs() == j3)) {
                timestampAdjuster.reset();
                timestampAdjuster.setFirstSampleTimestampUs(j3);
            }
        }
        if (!(j3 == 0 || (iVar = this.k) == null)) {
            iVar.setSeekTargetUs(j3);
        }
        this.d.reset(0);
        this.e.clear();
        for (int i3 = 0; i3 < this.g.size(); i3++) {
            this.g.valueAt(i3).seek();
        }
        this.r = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        boolean z;
        byte[] data = this.d.getData();
        extractorInput.peekFully(data, 0, 940);
        for (int i2 = 0; i2 < 188; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= 5) {
                    z = true;
                    break;
                } else if (data[(i3 * 188) + i2] != 71) {
                    z = false;
                    break;
                } else {
                    i3++;
                }
            }
            if (z) {
                extractorInput.skipFully(i2);
                return true;
            }
        }
        return false;
    }

    public TsExtractor(int i2) {
        this(1, i2, (int) DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    public TsExtractor(int i2, int i3, int i4) {
        this(i2, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(i3), i4);
    }

    public TsExtractor(int i2, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory) {
        this(i2, timestampAdjuster, factory, DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    public TsExtractor(int i2, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory, int i3) {
        TsPayloadReader.Factory factory2 = (TsPayloadReader.Factory) Assertions.checkNotNull(factory);
        this.f = factory2;
        this.b = i3;
        this.a = i2;
        if (i2 == 1 || i2 == 2) {
            this.c = Collections.singletonList(timestampAdjuster);
        } else {
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            arrayList.add(timestampAdjuster);
        }
        this.d = new ParsableByteArray(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.h = sparseBooleanArray;
        this.i = new SparseBooleanArray();
        SparseArray<TsPayloadReader> sparseArray = new SparseArray<>();
        this.g = sparseArray;
        this.e = new SparseIntArray();
        this.j = new j(i3);
        this.s = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray<TsPayloadReader> createInitialPayloadReaders = factory2.createInitialPayloadReaders();
        int size = createInitialPayloadReaders.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.g.put(createInitialPayloadReaders.keyAt(i4), createInitialPayloadReaders.valueAt(i4));
        }
        this.g.put(0, new SectionReader(new a()));
        this.q = null;
    }
}
