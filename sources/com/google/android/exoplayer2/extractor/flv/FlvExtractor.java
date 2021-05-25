package com.google.android.exoplayer2.extractor.flv;

import a2.j.b.b.u0.g.a;
import a2.j.b.b.u0.g.b;
import a2.j.b.b.u0.g.c;
import a2.j.b.b.u0.g.d;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
public final class FlvExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = a.a;
    public final ParsableByteArray a = new ParsableByteArray(4);
    public final ParsableByteArray b = new ParsableByteArray(9);
    public final ParsableByteArray c = new ParsableByteArray(11);
    public final ParsableByteArray d = new ParsableByteArray();
    public final c e = new c();
    public ExtractorOutput f;
    public int g = 1;
    public boolean h;
    public long i;
    public int j;
    public int k;
    public int l;
    public long m;
    public boolean n;
    public b o;
    public d p;

    public final ParsableByteArray a(ExtractorInput extractorInput) throws IOException {
        if (this.l > this.d.capacity()) {
            ParsableByteArray parsableByteArray = this.d;
            parsableByteArray.reset(new byte[Math.max(parsableByteArray.capacity() * 2, this.l)], 0);
        } else {
            this.d.setPosition(0);
        }
        this.d.setLimit(this.l);
        extractorInput.readFully(this.d.getData(), 0, this.l);
        return this.d;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f = extractorOutput;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ce A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0009 A[SYNTHETIC] */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput r17, com.google.android.exoplayer2.extractor.PositionHolder r18) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 398
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.flv.FlvExtractor.read(com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.extractor.PositionHolder):int");
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        if (j2 == 0) {
            this.g = 1;
            this.h = false;
        } else {
            this.g = 3;
        }
        this.j = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        extractorInput.peekFully(this.a.getData(), 0, 3);
        this.a.setPosition(0);
        if (this.a.readUnsignedInt24() != 4607062) {
            return false;
        }
        extractorInput.peekFully(this.a.getData(), 0, 2);
        this.a.setPosition(0);
        if ((this.a.readUnsignedShort() & 250) != 0) {
            return false;
        }
        extractorInput.peekFully(this.a.getData(), 0, 4);
        this.a.setPosition(0);
        int readInt = this.a.readInt();
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(readInt);
        extractorInput.peekFully(this.a.getData(), 0, 4);
        this.a.setPosition(0);
        if (this.a.readInt() == 0) {
            return true;
        }
        return false;
    }
}
