package a2.j.b.b.u0.k;

import a2.j.b.b.u0.k.h;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import okio.Utf8;
public final class g extends h {
    public static final byte[] o = {79, 112, 117, 115, 72, 101, 97, 100};
    public boolean n;

    @Override // a2.j.b.b.u0.k.h
    public long c(ParsableByteArray parsableByteArray) {
        byte[] data = parsableByteArray.getData();
        int i = data[0] & 255;
        int i2 = i & 3;
        int i3 = 2;
        if (i2 == 0) {
            i3 = 1;
        } else if (!(i2 == 1 || i2 == 2)) {
            i3 = data[1] & Utf8.REPLACEMENT_BYTE;
        }
        int i4 = i >> 3;
        int i5 = i4 & 3;
        return a(((long) i3) * ((long) (i4 >= 16 ? 2500 << i5 : i4 >= 12 ? 10000 << (i5 & 1) : i5 == 3 ? 60000 : 10000 << i5)));
    }

    @Override // a2.j.b.b.u0.k.h
    public boolean d(ParsableByteArray parsableByteArray, long j, h.b bVar) {
        boolean z = true;
        if (!this.n) {
            byte[] copyOf = Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit());
            int channelCount = OpusUtil.getChannelCount(copyOf);
            bVar.a = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_OPUS).setChannelCount(channelCount).setSampleRate(OpusUtil.SAMPLE_RATE).setInitializationData(OpusUtil.buildInitializationData(copyOf)).build();
            this.n = true;
            return true;
        }
        if (parsableByteArray.readInt() != 1332770163) {
            z = false;
        }
        parsableByteArray.setPosition(0);
        return z;
    }

    @Override // a2.j.b.b.u0.k.h
    public void e(boolean z) {
        super.e(z);
        if (z) {
            this.n = false;
        }
    }
}
