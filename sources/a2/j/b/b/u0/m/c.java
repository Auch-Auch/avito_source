package a2.j.b.b.u0.m;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
public final class c {
    public final int a;
    public final long b;

    public c(int i, long j) {
        this.a = i;
        this.b = j;
    }

    public static c a(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException {
        extractorInput.peekFully(parsableByteArray.getData(), 0, 8);
        parsableByteArray.setPosition(0);
        return new c(parsableByteArray.readInt(), parsableByteArray.readLittleEndianUnsignedInt());
    }
}
