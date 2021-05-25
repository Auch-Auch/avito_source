package com.google.android.exoplayer2.extractor.ogg;

import a2.j.b.b.u0.k.a;
import a2.j.b.b.u0.k.c;
import a2.j.b.b.u0.k.d;
import a2.j.b.b.u0.k.e;
import a2.j.b.b.u0.k.g;
import a2.j.b.b.u0.k.h;
import a2.j.b.b.u0.k.i;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.VorbisUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
public class OggExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = a.a;
    public ExtractorOutput a;
    public h b;
    public boolean c;

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    public final boolean a(ExtractorInput extractorInput) throws IOException {
        boolean z;
        boolean z2;
        e eVar = new e();
        if (eVar.a(extractorInput, true) && (eVar.b & 2) == 2) {
            int min = Math.min(eVar.f, 8);
            ParsableByteArray parsableByteArray = new ParsableByteArray(min);
            extractorInput.peekFully(parsableByteArray.getData(), 0, min);
            parsableByteArray.setPosition(0);
            if (parsableByteArray.bytesLeft() >= 5 && parsableByteArray.readUnsignedByte() == 127 && parsableByteArray.readUnsignedInt() == 1179402563) {
                this.b = new c();
            } else {
                parsableByteArray.setPosition(0);
                try {
                    z = VorbisUtil.verifyVorbisHeaderCapturePattern(1, parsableByteArray, true);
                } catch (ParserException unused) {
                    z = false;
                }
                if (z) {
                    this.b = new i();
                } else {
                    parsableByteArray.setPosition(0);
                    int bytesLeft = parsableByteArray.bytesLeft();
                    byte[] bArr = g.o;
                    if (bytesLeft < bArr.length) {
                        z2 = false;
                    } else {
                        byte[] bArr2 = new byte[bArr.length];
                        parsableByteArray.readBytes(bArr2, 0, bArr.length);
                        z2 = Arrays.equals(bArr2, bArr);
                    }
                    if (z2) {
                        this.b = new g();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.a = extractorOutput;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x017e  */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput r20, com.google.android.exoplayer2.extractor.PositionHolder r21) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 413
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ogg.OggExtractor.read(com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.extractor.PositionHolder):int");
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        h hVar = this.b;
        if (hVar != null) {
            d dVar = hVar.a;
            dVar.a.b();
            dVar.b.reset(0);
            dVar.c = -1;
            dVar.e = false;
            if (j == 0) {
                hVar.e(!hVar.l);
            } else if (hVar.h != 0) {
                long j3 = (((long) hVar.i) * j2) / 1000000;
                hVar.e = j3;
                hVar.d.b(j3);
                hVar.h = 2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        try {
            return a(extractorInput);
        } catch (ParserException unused) {
            return false;
        }
    }
}
