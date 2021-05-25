package a2.j.b.b.u0.k;

import a2.j.b.b.u0.k.h;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.VorbisUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
public final class i extends h {
    @Nullable
    public a n;
    public int o;
    public boolean p;
    @Nullable
    public VorbisUtil.VorbisIdHeader q;
    @Nullable
    public VorbisUtil.CommentHeader r;

    public static final class a {
        public final VorbisUtil.VorbisIdHeader a;
        public final byte[] b;
        public final VorbisUtil.Mode[] c;
        public final int d;

        public a(VorbisUtil.VorbisIdHeader vorbisIdHeader, VorbisUtil.CommentHeader commentHeader, byte[] bArr, VorbisUtil.Mode[] modeArr, int i) {
            this.a = vorbisIdHeader;
            this.b = bArr;
            this.c = modeArr;
            this.d = i;
        }
    }

    @Override // a2.j.b.b.u0.k.h
    public void b(long j) {
        this.g = j;
        int i = 0;
        this.p = j != 0;
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.q;
        if (vorbisIdHeader != null) {
            i = vorbisIdHeader.blockSize0;
        }
        this.o = i;
    }

    @Override // a2.j.b.b.u0.k.h
    public long c(ParsableByteArray parsableByteArray) {
        int i;
        int i2 = 0;
        if ((parsableByteArray.getData()[0] & 1) == 1) {
            return -1;
        }
        byte b = parsableByteArray.getData()[0];
        a aVar = this.n;
        if (!aVar.c[(b >> 1) & (255 >>> (8 - aVar.d))].blockFlag) {
            i = aVar.a.blockSize0;
        } else {
            i = aVar.a.blockSize1;
        }
        if (this.p) {
            i2 = (this.o + i) / 4;
        }
        long j = (long) i2;
        if (parsableByteArray.capacity() < parsableByteArray.limit() + 4) {
            parsableByteArray.reset(Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit() + 4));
        } else {
            parsableByteArray.setLimit(parsableByteArray.limit() + 4);
        }
        byte[] data = parsableByteArray.getData();
        data[parsableByteArray.limit() - 4] = (byte) ((int) (j & 255));
        data[parsableByteArray.limit() - 3] = (byte) ((int) ((j >>> 8) & 255));
        data[parsableByteArray.limit() - 2] = (byte) ((int) ((j >>> 16) & 255));
        data[parsableByteArray.limit() - 1] = (byte) ((int) ((j >>> 24) & 255));
        this.p = true;
        this.o = i;
        return j;
    }

    @Override // a2.j.b.b.u0.k.h
    public boolean d(ParsableByteArray parsableByteArray, long j, h.b bVar) throws IOException {
        if (this.n != null) {
            return false;
        }
        a aVar = null;
        if (this.q == null) {
            this.q = VorbisUtil.readVorbisIdentificationHeader(parsableByteArray);
        } else if (this.r == null) {
            this.r = VorbisUtil.readVorbisCommentHeader(parsableByteArray);
        } else {
            byte[] bArr = new byte[parsableByteArray.limit()];
            System.arraycopy(parsableByteArray.getData(), 0, bArr, 0, parsableByteArray.limit());
            VorbisUtil.Mode[] readVorbisModes = VorbisUtil.readVorbisModes(parsableByteArray, this.q.channels);
            aVar = new a(this.q, this.r, bArr, readVorbisModes, VorbisUtil.iLog(readVorbisModes.length - 1));
        }
        this.n = aVar;
        if (aVar == null) {
            return true;
        }
        VorbisUtil.VorbisIdHeader vorbisIdHeader = aVar.a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(vorbisIdHeader.data);
        arrayList.add(this.n.b);
        bVar.a = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_VORBIS).setAverageBitrate(vorbisIdHeader.bitrateNominal).setPeakBitrate(vorbisIdHeader.bitrateMaximum).setChannelCount(vorbisIdHeader.channels).setSampleRate(vorbisIdHeader.sampleRate).setInitializationData(arrayList).build();
        return true;
    }

    @Override // a2.j.b.b.u0.k.h
    public void e(boolean z) {
        super.e(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }
}
