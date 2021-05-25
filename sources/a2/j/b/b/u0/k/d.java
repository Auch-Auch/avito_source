package a2.j.b.b.u0.k;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;
public final class d {
    public final e a = new e();
    public final ParsableByteArray b = new ParsableByteArray(new byte[65025], 0);
    public int c = -1;
    public int d;
    public boolean e;

    public final int a(int i) {
        int i2;
        int i3 = 0;
        this.d = 0;
        do {
            int i4 = this.d;
            int i5 = i + i4;
            e eVar = this.a;
            if (i5 >= eVar.d) {
                break;
            }
            int[] iArr = eVar.g;
            this.d = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public boolean b(ExtractorInput extractorInput) throws IOException {
        int i;
        Assertions.checkState(extractorInput != null);
        if (this.e) {
            this.e = false;
            this.b.reset(0);
        }
        while (!this.e) {
            if (this.c < 0) {
                if (!this.a.c(extractorInput, -1) || !this.a.a(extractorInput, true)) {
                    return false;
                }
                e eVar = this.a;
                int i2 = eVar.e;
                if ((eVar.b & 1) == 1 && this.b.limit() == 0) {
                    i2 += a(0);
                    i = this.d + 0;
                } else {
                    i = 0;
                }
                extractorInput.skipFully(i2);
                this.c = i;
            }
            int a3 = a(this.c);
            int i3 = this.c + this.d;
            if (a3 > 0) {
                if (this.b.capacity() < this.b.limit() + a3) {
                    ParsableByteArray parsableByteArray = this.b;
                    parsableByteArray.reset(Arrays.copyOf(parsableByteArray.getData(), this.b.limit() + a3), this.b.limit());
                }
                extractorInput.readFully(this.b.getData(), this.b.limit(), a3);
                ParsableByteArray parsableByteArray2 = this.b;
                parsableByteArray2.setLimit(parsableByteArray2.limit() + a3);
                this.e = this.a.g[i3 + -1] != 255;
            }
            if (i3 == this.a.d) {
                i3 = -1;
            }
            this.c = i3;
        }
        return true;
    }
}
