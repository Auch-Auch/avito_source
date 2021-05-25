package com.google.android.exoplayer2.extractor.mp4;

import a2.j.b.b.u0.j.e;
import a2.j.b.b.u0.j.g;
import a2.j.b.b.u0.j.j;
import a2.j.b.b.u0.j.k;
import a2.j.b.b.u0.j.l;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
public class FragmentedMp4Extractor implements Extractor {
    public static final ExtractorsFactory FACTORY = a2.j.b.b.u0.j.a.a;
    public static final int FLAG_ENABLE_EMSG_TRACK = 4;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
    public static final byte[] I = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final Format J = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_EMSG).build();
    public int A;
    public int B;
    public int C;
    public boolean D;
    public ExtractorOutput E;
    public TrackOutput[] F;
    public TrackOutput[] G;
    public boolean H;
    public final int a;
    @Nullable
    public final Track b;
    public final List<Format> c;
    public final SparseArray<b> d;
    public final ParsableByteArray e;
    public final ParsableByteArray f;
    public final ParsableByteArray g;
    public final byte[] h;
    public final ParsableByteArray i;
    @Nullable
    public final TimestampAdjuster j;
    public final EventMessageEncoder k;
    public final ParsableByteArray l;
    public final ArrayDeque<e.a> m;
    public final ArrayDeque<a> n;
    @Nullable
    public final TrackOutput o;
    public int p;
    public int q;
    public long r;
    public int s;
    @Nullable
    public ParsableByteArray t;
    public long u;
    public int v;
    public long w;
    public long x;
    public long y;
    @Nullable
    public b z;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class a {
        public final long a;
        public final int b;

        public a(long j, int i) {
            this.a = j;
            this.b = i;
        }
    }

    public static final class b {
        public final TrackOutput a;
        public final k b = new k();
        public final ParsableByteArray c = new ParsableByteArray();
        public l d;
        public g e;
        public int f;
        public int g;
        public int h;
        public int i;
        public final ParsableByteArray j = new ParsableByteArray(1);
        public final ParsableByteArray k = new ParsableByteArray();
        public boolean l;

        public b(TrackOutput trackOutput, l lVar, g gVar) {
            this.a = trackOutput;
            this.d = lVar;
            this.e = gVar;
            this.d = lVar;
            this.e = gVar;
            trackOutput.format(lVar.a.format);
            e();
        }

        public long a() {
            if (!this.l) {
                return this.d.c[this.f];
            }
            return this.b.f[this.h];
        }

        @Nullable
        public TrackEncryptionBox b() {
            if (!this.l) {
                return null;
            }
            int i2 = ((g) Util.castNonNull(this.b.a)).a;
            TrackEncryptionBox trackEncryptionBox = this.b.n;
            if (trackEncryptionBox == null) {
                trackEncryptionBox = this.d.a.getSampleDescriptionEncryptionBox(i2);
            }
            if (trackEncryptionBox == null || !trackEncryptionBox.isEncrypted) {
                return null;
            }
            return trackEncryptionBox;
        }

        public boolean c() {
            this.f++;
            if (!this.l) {
                return false;
            }
            int i2 = this.g + 1;
            this.g = i2;
            int[] iArr = this.b.g;
            int i3 = this.h;
            if (i2 != iArr[i3]) {
                return true;
            }
            this.h = i3 + 1;
            this.g = 0;
            return false;
        }

        public int d(int i2, int i3) {
            ParsableByteArray parsableByteArray;
            TrackEncryptionBox b2 = b();
            if (b2 == null) {
                return 0;
            }
            int i4 = b2.perSampleIvSize;
            if (i4 != 0) {
                parsableByteArray = this.b.o;
            } else {
                byte[] bArr = (byte[]) Util.castNonNull(b2.defaultInitializationVector);
                this.k.reset(bArr, bArr.length);
                ParsableByteArray parsableByteArray2 = this.k;
                i4 = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            k kVar = this.b;
            boolean z = kVar.l && kVar.m[this.f];
            boolean z2 = z || i3 != 0;
            this.j.getData()[0] = (byte) ((z2 ? 128 : 0) | i4);
            this.j.setPosition(0);
            this.a.sampleData(this.j, 1, 1);
            this.a.sampleData(parsableByteArray, i4, 1);
            if (!z2) {
                return i4 + 1;
            }
            if (!z) {
                this.c.reset(8);
                byte[] data = this.c.getData();
                data[0] = 0;
                data[1] = 1;
                data[2] = (byte) ((i3 >> 8) & 255);
                data[3] = (byte) (i3 & 255);
                data[4] = (byte) ((i2 >> 24) & 255);
                data[5] = (byte) ((i2 >> 16) & 255);
                data[6] = (byte) ((i2 >> 8) & 255);
                data[7] = (byte) (i2 & 255);
                this.a.sampleData(this.c, 8, 1);
                return i4 + 1 + 8;
            }
            ParsableByteArray parsableByteArray3 = this.b.o;
            int readUnsignedShort = parsableByteArray3.readUnsignedShort();
            parsableByteArray3.skipBytes(-2);
            int i5 = (readUnsignedShort * 6) + 2;
            if (i3 != 0) {
                this.c.reset(i5);
                byte[] data2 = this.c.getData();
                parsableByteArray3.readBytes(data2, 0, i5);
                int i6 = (((data2[2] & 255) << 8) | (data2[3] & 255)) + i3;
                data2[2] = (byte) ((i6 >> 8) & 255);
                data2[3] = (byte) (i6 & 255);
                parsableByteArray3 = this.c;
            }
            this.a.sampleData(parsableByteArray3, i5, 1);
            return i4 + 1 + i5;
        }

        public void e() {
            k kVar = this.b;
            kVar.d = 0;
            kVar.q = 0;
            kVar.r = false;
            kVar.l = false;
            kVar.p = false;
            kVar.n = null;
            this.f = 0;
            this.h = 0;
            this.g = 0;
            this.i = 0;
            this.l = false;
        }
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    public static int a(int i2) throws ParserException {
        if (i2 >= 0) {
            return i2;
        }
        throw new ParserException(a2.b.a.a.a.M2("Unexpected negtive value: ", i2));
    }

    @Nullable
    public static DrmInitData d(List<e.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            e.b bVar = list.get(i2);
            if (bVar.a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] data = bVar.b.getData();
                UUID parseUuid = PsshAtomUtil.parseUuid(data);
                if (parseUuid == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(parseUuid, "video/mp4", data));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    public static void e(ParsableByteArray parsableByteArray, int i2, k kVar) throws ParserException {
        parsableByteArray.setPosition(i2 + 8);
        int readInt = parsableByteArray.readInt() & ViewCompat.MEASURED_SIZE_MASK;
        if ((readInt & 1) == 0) {
            boolean z2 = (readInt & 2) != 0;
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (readUnsignedIntToInt == 0) {
                Arrays.fill(kVar.m, 0, kVar.e, false);
            } else if (readUnsignedIntToInt == kVar.e) {
                Arrays.fill(kVar.m, 0, readUnsignedIntToInt, z2);
                kVar.o.reset(parsableByteArray.bytesLeft());
                kVar.l = true;
                kVar.p = true;
                parsableByteArray.readBytes(kVar.o.getData(), 0, kVar.o.limit());
                kVar.o.setPosition(0);
                kVar.p = false;
            } else {
                StringBuilder M = a2.b.a.a.a.M("Senc sample count ", readUnsignedIntToInt, " is different from fragment sample count");
                M.append(kVar.e);
                throw new ParserException(M.toString());
            }
        } else {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
    }

    public final void b() {
        this.p = 0;
        this.s = 0;
    }

    public final g c(SparseArray<g> sparseArray, int i2) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (g) Assertions.checkNotNull(sparseArray.get(i2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:149:0x03b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(long r48) throws com.google.android.exoplayer2.ParserException {
        /*
        // Method dump skipped, instructions count: 1961
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.f(long):void");
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        int i2;
        this.E = extractorOutput;
        b();
        TrackOutput[] trackOutputArr = new TrackOutput[2];
        this.F = trackOutputArr;
        TrackOutput trackOutput = this.o;
        if (trackOutput != null) {
            trackOutputArr[0] = trackOutput;
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i3 = 100;
        if ((this.a & 4) != 0) {
            trackOutputArr[i2] = this.E.track(100, 4);
            i3 = 101;
            i2++;
        }
        TrackOutput[] trackOutputArr2 = (TrackOutput[]) Util.nullSafeArrayCopy(this.F, i2);
        this.F = trackOutputArr2;
        for (TrackOutput trackOutput2 : trackOutputArr2) {
            trackOutput2.format(J);
        }
        this.G = new TrackOutput[this.c.size()];
        int i4 = 0;
        while (i4 < this.G.length) {
            TrackOutput track = this.E.track(i3, 3);
            track.format(this.c.get(i4));
            this.G[i4] = track;
            i4++;
            i3++;
        }
        Track track2 = this.b;
        if (track2 != null) {
            this.d.put(0, new b(extractorOutput.track(0, track2.type), new l(this.b, new long[0], new int[0], 0, new long[0], new int[0], 0), new g(0, 0, 0, 0)));
            this.E.endTracks();
        }
    }

    @Nullable
    public Track modifyTrack(@Nullable Track track) {
        return track;
    }

    /* JADX WARNING: Removed duplicated region for block: B:330:0x02d8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x077d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x077f A[SYNTHETIC] */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput r29, com.google.android.exoplayer2.extractor.PositionHolder r30) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1938
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.read(com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.extractor.PositionHolder):int");
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        int size = this.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.d.valueAt(i2).e();
        }
        this.n.clear();
        this.v = 0;
        this.w = j3;
        this.m.clear();
        b();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return j.a(extractorInput, true);
    }

    public FragmentedMp4Extractor(int i2) {
        this(i2, null);
    }

    public FragmentedMp4Extractor(int i2, @Nullable TimestampAdjuster timestampAdjuster) {
        this(i2, timestampAdjuster, null, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i2, @Nullable TimestampAdjuster timestampAdjuster, @Nullable Track track) {
        this(i2, timestampAdjuster, track, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i2, @Nullable TimestampAdjuster timestampAdjuster, @Nullable Track track, List<Format> list) {
        this(i2, timestampAdjuster, track, list, null);
    }

    public FragmentedMp4Extractor(int i2, @Nullable TimestampAdjuster timestampAdjuster, @Nullable Track track, List<Format> list, @Nullable TrackOutput trackOutput) {
        this.a = i2 | (track != null ? 8 : 0);
        this.j = timestampAdjuster;
        this.b = track;
        this.c = Collections.unmodifiableList(list);
        this.o = trackOutput;
        this.k = new EventMessageEncoder();
        this.l = new ParsableByteArray(16);
        this.e = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.f = new ParsableByteArray(5);
        this.g = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.h = bArr;
        this.i = new ParsableByteArray(bArr);
        this.m = new ArrayDeque<>();
        this.n = new ArrayDeque<>();
        this.d = new SparseArray<>();
        this.x = C.TIME_UNSET;
        this.w = C.TIME_UNSET;
        this.y = C.TIME_UNSET;
        this.E = ExtractorOutput.PLACEHOLDER;
        this.F = new TrackOutput[0];
        this.G = new TrackOutput[0];
    }
}
