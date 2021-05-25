package a2.j.b.b.u0.h;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
public final class d {
    public final ParsableByteArray a = new ParsableByteArray(8);
    public int b;

    public final long a(ExtractorInput extractorInput) throws IOException {
        int i = 0;
        extractorInput.peekFully(this.a.getData(), 0, 1);
        int i2 = this.a.getData()[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        extractorInput.peekFully(this.a.getData(), 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.a.getData()[i] & 255) + (i5 << 8);
        }
        this.b = i4 + 1 + this.b;
        return (long) i5;
    }
}
