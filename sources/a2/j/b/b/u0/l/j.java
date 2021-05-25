package a2.j.b.b.u0.l;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
public final class j {
    public final int a;
    public final TimestampAdjuster b = new TimestampAdjuster(0);
    public final ParsableByteArray c = new ParsableByteArray();
    public boolean d;
    public boolean e;
    public boolean f;
    public long g = C.TIME_UNSET;
    public long h = C.TIME_UNSET;
    public long i = C.TIME_UNSET;

    public j(int i2) {
        this.a = i2;
    }

    public final int a(ExtractorInput extractorInput) {
        this.c.reset(Util.EMPTY_BYTE_ARRAY);
        this.d = true;
        extractorInput.resetPeekPosition();
        return 0;
    }
}
