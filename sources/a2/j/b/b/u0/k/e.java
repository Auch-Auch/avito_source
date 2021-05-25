package a2.j.b.b.u0.k;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
public final class e {
    public int a;
    public int b;
    public long c;
    public int d;
    public int e;
    public int f;
    public final int[] g = new int[255];
    public final ParsableByteArray h = new ParsableByteArray(255);

    public boolean a(ExtractorInput extractorInput, boolean z) throws IOException {
        boolean z2;
        b();
        this.h.reset(27);
        try {
            z2 = extractorInput.peekFully(this.h.getData(), 0, 27, z);
        } catch (EOFException e2) {
            if (z) {
                z2 = false;
            } else {
                throw e2;
            }
        }
        if (!z2 || this.h.readUnsignedInt() != 1332176723) {
            return false;
        }
        int readUnsignedByte = this.h.readUnsignedByte();
        this.a = readUnsignedByte;
        if (readUnsignedByte == 0) {
            this.b = this.h.readUnsignedByte();
            this.c = this.h.readLittleEndianLong();
            this.h.readLittleEndianUnsignedInt();
            this.h.readLittleEndianUnsignedInt();
            this.h.readLittleEndianUnsignedInt();
            int readUnsignedByte2 = this.h.readUnsignedByte();
            this.d = readUnsignedByte2;
            this.e = readUnsignedByte2 + 27;
            this.h.reset(readUnsignedByte2);
            extractorInput.peekFully(this.h.getData(), 0, this.d);
            for (int i = 0; i < this.d; i++) {
                this.g[i] = this.h.readUnsignedByte();
                this.f += this.g[i];
            }
            return true;
        } else if (z) {
            return false;
        } else {
            throw new ParserException("unsupported bit stream revision");
        }
    }

    public void b() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    public boolean c(ExtractorInput extractorInput, long j) throws IOException {
        int i;
        boolean z;
        Assertions.checkArgument(extractorInput.getPosition() == extractorInput.getPeekPosition());
        while (true) {
            i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
            if (i != 0 && extractorInput.getPosition() + 4 >= j) {
                break;
            }
            try {
                z = extractorInput.peekFully(this.h.getData(), 0, 4, true);
            } catch (EOFException unused) {
                z = false;
            }
            if (!z) {
                break;
            }
            this.h.reset(4);
            if (this.h.readUnsignedInt() == 1332176723) {
                extractorInput.resetPeekPosition();
                return true;
            }
            extractorInput.skipFully(1);
        }
        do {
            if (i != 0 && extractorInput.getPosition() >= j) {
                break;
            }
        } while (extractorInput.skip(1) != -1);
        return false;
    }
}
