package com.google.android.exoplayer2.source;

import a2.j.b.b.u0.d;
import a2.j.b.b.z0.s;
import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
public class SampleQueue implements TrackOutput {
    public boolean A;
    @Nullable
    public Format B;
    @Nullable
    public Format C;
    @Nullable
    public Format D;
    public int E;
    public boolean F;
    public boolean G;
    public long H;
    public boolean I;
    public final s a;
    public final a b = new a();
    public final Looper c;
    public final DrmSessionManager d;
    public final DrmSessionEventListener.EventDispatcher e;
    @Nullable
    public UpstreamFormatChangedListener f;
    @Nullable
    public Format g;
    @Nullable
    public DrmSession h;
    public int i = 1000;
    public int[] j = new int[1000];
    public long[] k = new long[1000];
    public int[] l = new int[1000];
    public int[] m = new int[1000];
    public long[] n = new long[1000];
    public TrackOutput.CryptoData[] o = new TrackOutput.CryptoData[1000];
    public Format[] p = new Format[1000];
    public int q;
    public int r;
    public int s;
    public int t;
    public long u = Long.MIN_VALUE;
    public long v = Long.MIN_VALUE;
    public long w = Long.MIN_VALUE;
    public boolean x;
    public boolean y = true;
    public boolean z = true;

    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public static final class a {
        public int a;
        public long b;
        @Nullable
        public TrackOutput.CryptoData c;
    }

    public SampleQueue(Allocator allocator, Looper looper, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.c = looper;
        this.d = drmSessionManager;
        this.e = eventDispatcher;
        this.a = new s(allocator);
    }

    public final int a(long j2) {
        int i2 = this.q;
        int f2 = f(i2 - 1);
        while (i2 > this.t && this.n[f2] >= j2) {
            i2--;
            f2--;
            if (f2 == -1) {
                f2 = this.i - 1;
            }
        }
        return i2;
    }

    public final long b(int i2) {
        this.v = Math.max(this.v, e(i2));
        int i3 = this.q - i2;
        this.q = i3;
        this.r += i2;
        int i4 = this.s + i2;
        this.s = i4;
        int i5 = this.i;
        if (i4 >= i5) {
            this.s = i4 - i5;
        }
        int i6 = this.t - i2;
        this.t = i6;
        if (i6 < 0) {
            this.t = 0;
        }
        if (i3 != 0) {
            return this.k[this.s];
        }
        int i7 = this.s;
        if (i7 != 0) {
            i5 = i7;
        }
        int i8 = i5 - 1;
        return this.k[i8] + ((long) this.l[i8]);
    }

    public final long c(int i2) {
        int writeIndex = getWriteIndex() - i2;
        boolean z2 = false;
        Assertions.checkArgument(writeIndex >= 0 && writeIndex <= this.q - this.t);
        int i3 = this.q - writeIndex;
        this.q = i3;
        this.w = Math.max(this.v, e(i3));
        if (writeIndex == 0 && this.x) {
            z2 = true;
        }
        this.x = z2;
        int i4 = this.q;
        if (i4 == 0) {
            return 0;
        }
        int f2 = f(i4 - 1);
        return this.k[f2] + ((long) this.l[f2]);
    }

    public final int d(int i2, int i3, long j2, boolean z2) {
        int i4 = -1;
        for (int i5 = 0; i5 < i3; i5++) {
            long[] jArr = this.n;
            if (jArr[i2] > j2) {
                return i4;
            }
            if (!z2 || (this.m[i2] & 1) != 0) {
                if (jArr[i2] == j2) {
                    return i5;
                }
                i4 = i5;
            }
            i2++;
            if (i2 == this.i) {
                i2 = 0;
            }
        }
        return i4;
    }

    public synchronized long discardSampleMetadataToRead() {
        int i2 = this.t;
        if (i2 == 0) {
            return -1;
        }
        return b(i2);
    }

    public final void discardTo(long j2, boolean z2, boolean z3) {
        long j3;
        int i2;
        s sVar = this.a;
        synchronized (this) {
            int i3 = this.q;
            j3 = -1;
            if (i3 != 0) {
                long[] jArr = this.n;
                int i4 = this.s;
                if (j2 >= jArr[i4]) {
                    if (z3 && (i2 = this.t) != i3) {
                        i3 = i2 + 1;
                    }
                    int d2 = d(i4, i3, j2, z2);
                    if (d2 != -1) {
                        j3 = b(d2);
                    }
                }
            }
        }
        sVar.b(j3);
    }

    public final void discardToEnd() {
        long j2;
        s sVar = this.a;
        synchronized (this) {
            int i2 = this.q;
            if (i2 == 0) {
                j2 = -1;
            } else {
                j2 = b(i2);
            }
        }
        sVar.b(j2);
    }

    public final void discardToRead() {
        this.a.b(discardSampleMetadataToRead());
    }

    public final void discardUpstreamFrom(long j2) {
        if (this.q != 0) {
            Assertions.checkArgument(j2 > getLargestReadTimestampUs());
            discardUpstreamSamples(this.r + a(j2));
        }
    }

    public final void discardUpstreamSamples(int i2) {
        s sVar = this.a;
        long c2 = c(i2);
        sVar.g = c2;
        if (c2 != 0) {
            s.a aVar = sVar.d;
            if (c2 != aVar.a) {
                while (sVar.g > aVar.b) {
                    aVar = aVar.e;
                }
                s.a aVar2 = aVar.e;
                sVar.a(aVar2);
                s.a aVar3 = new s.a(aVar.b, sVar.b);
                aVar.e = aVar3;
                if (sVar.g == aVar.b) {
                    aVar = aVar3;
                }
                sVar.f = aVar;
                if (sVar.e == aVar2) {
                    sVar.e = aVar3;
                    return;
                }
                return;
            }
        }
        sVar.a(sVar.d);
        s.a aVar4 = new s.a(sVar.g, sVar.b);
        sVar.d = aVar4;
        sVar.e = aVar4;
        sVar.f = aVar4;
    }

    public final long e(int i2) {
        long j2 = Long.MIN_VALUE;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int f2 = f(i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = Math.max(j2, this.n[f2]);
            if ((this.m[f2] & 1) != 0) {
                break;
            }
            f2--;
            if (f2 == -1) {
                f2 = this.i - 1;
            }
        }
        return j2;
    }

    public final int f(int i2) {
        int i3 = this.s + i2;
        int i4 = this.i;
        return i3 < i4 ? i3 : i3 - i4;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void format(Format format) {
        Format adjustedUpstreamFormat = getAdjustedUpstreamFormat(format);
        boolean z2 = false;
        this.A = false;
        this.B = format;
        synchronized (this) {
            this.z = false;
            if (!Util.areEqual(adjustedUpstreamFormat, this.C)) {
                if (Util.areEqual(adjustedUpstreamFormat, this.D)) {
                    this.C = this.D;
                } else {
                    this.C = adjustedUpstreamFormat;
                }
                Format format2 = this.C;
                this.F = MimeTypes.allSamplesAreSyncSamples(format2.sampleMimeType, format2.codecs);
                this.G = false;
                z2 = true;
            }
        }
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.f;
        if (upstreamFormatChangedListener != null && z2) {
            upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedUpstreamFormat);
        }
    }

    public final boolean g() {
        return this.t != this.q;
    }

    @CallSuper
    public Format getAdjustedUpstreamFormat(Format format) {
        return (this.H == 0 || format.subsampleOffsetUs == Long.MAX_VALUE) ? format : format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.H).build();
    }

    public final int getFirstIndex() {
        return this.r;
    }

    public final synchronized long getFirstTimestampUs() {
        return this.q == 0 ? Long.MIN_VALUE : this.n[this.s];
    }

    public final synchronized long getLargestQueuedTimestampUs() {
        return this.w;
    }

    public final synchronized long getLargestReadTimestampUs() {
        return Math.max(this.v, e(this.t));
    }

    public final int getReadIndex() {
        return this.r + this.t;
    }

    public final synchronized int getSkipCount(long j2, boolean z2) {
        int f2 = f(this.t);
        if (g()) {
            if (j2 >= this.n[f2]) {
                if (j2 <= this.w || !z2) {
                    int d2 = d(f2, this.q - this.t, j2, true);
                    if (d2 == -1) {
                        return 0;
                    }
                    return d2;
                }
                return this.q - this.t;
            }
        }
        return 0;
    }

    @Nullable
    public final synchronized Format getUpstreamFormat() {
        return this.z ? null : this.C;
    }

    public final int getWriteIndex() {
        return this.r + this.q;
    }

    public final boolean h(int i2) {
        DrmSession drmSession = this.h;
        return drmSession == null || drmSession.getState() == 4 || ((this.m[i2] & 1073741824) == 0 && this.h.playClearSamplesWithoutKeys());
    }

    public final void i(Format format, FormatHolder formatHolder) {
        DrmInitData drmInitData;
        Format format2 = this.g;
        boolean z2 = format2 == null;
        if (z2) {
            drmInitData = null;
        } else {
            drmInitData = format2.drmInitData;
        }
        this.g = format;
        DrmInitData drmInitData2 = format.drmInitData;
        formatHolder.format = format.copyWithExoMediaCryptoType(this.d.getExoMediaCryptoType(format));
        formatHolder.drmSession = this.h;
        if (z2 || !Util.areEqual(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.h;
            DrmSession acquireSession = this.d.acquireSession(this.c, this.e, format);
            this.h = acquireSession;
            formatHolder.drmSession = acquireSession;
            if (drmSession != null) {
                drmSession.release(this.e);
            }
        }
    }

    public final void invalidateUpstreamFormatAdjustment() {
        this.A = true;
    }

    public final synchronized boolean isLastSampleQueued() {
        return this.x;
    }

    @CallSuper
    public synchronized boolean isReady(boolean z2) {
        Format format;
        boolean z3 = true;
        if (!g()) {
            if (!z2 && !this.x && ((format = this.C) == null || format == this.g)) {
                z3 = false;
            }
            return z3;
        }
        int f2 = f(this.t);
        if (this.p[f2] != this.g) {
            return true;
        }
        return h(f2);
    }

    public final synchronized void j() {
        this.t = 0;
        s sVar = this.a;
        sVar.e = sVar.d;
    }

    @CallSuper
    public void maybeThrowError() throws IOException {
        DrmSession drmSession = this.h;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) Assertions.checkNotNull(this.h.getError()));
        }
    }

    public final synchronized int peekSourceId() {
        return g() ? this.j[f(this.t)] : this.E;
    }

    @CallSuper
    public void preRelease() {
        discardToEnd();
        DrmSession drmSession = this.h;
        if (drmSession != null) {
            drmSession.release(this.e);
            this.h = null;
            this.g = null;
        }
    }

    @CallSuper
    public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z2, boolean z3) {
        int i2;
        int i3;
        int i4;
        a aVar = this.b;
        synchronized (this) {
            decoderInputBuffer.waitingForKeys = false;
            i3 = -5;
            if (!g()) {
                if (!z3) {
                    if (!this.x) {
                        Format format = this.C;
                        if (format != null && (z2 || format != this.g)) {
                            i((Format) Assertions.checkNotNull(format), formatHolder);
                        }
                    }
                }
                decoderInputBuffer.setFlags(4);
                i3 = -4;
            } else {
                int f2 = f(this.t);
                if (z2 || this.p[f2] != this.g) {
                    i(this.p[f2], formatHolder);
                } else if (!h(f2)) {
                    decoderInputBuffer.waitingForKeys = true;
                } else {
                    decoderInputBuffer.setFlags(this.m[f2]);
                    long j2 = this.n[f2];
                    decoderInputBuffer.timeUs = j2;
                    if (j2 < this.u) {
                        decoderInputBuffer.addFlag(Integer.MIN_VALUE);
                    }
                    if (!decoderInputBuffer.isFlagsOnly()) {
                        aVar.a = this.l[f2];
                        aVar.b = this.k[f2];
                        aVar.c = this.o[f2];
                        this.t++;
                    }
                    i3 = -4;
                }
            }
            i3 = -3;
        }
        if (i3 == -4 && !decoderInputBuffer.isEndOfStream() && !decoderInputBuffer.isFlagsOnly()) {
            s sVar = this.a;
            a aVar2 = this.b;
            Objects.requireNonNull(sVar);
            if (decoderInputBuffer.isEncrypted()) {
                long j3 = aVar2.b;
                sVar.c.reset(1);
                sVar.f(j3, sVar.c.getData(), 1);
                long j4 = j3 + 1;
                byte b2 = sVar.c.getData()[0];
                boolean z4 = (b2 & 128) != 0;
                int i5 = b2 & Byte.MAX_VALUE;
                CryptoInfo cryptoInfo = decoderInputBuffer.cryptoInfo;
                byte[] bArr = cryptoInfo.iv;
                if (bArr == null) {
                    cryptoInfo.iv = new byte[16];
                } else {
                    Arrays.fill(bArr, (byte) 0);
                }
                sVar.f(j4, cryptoInfo.iv, i5);
                long j5 = j4 + ((long) i5);
                if (z4) {
                    sVar.c.reset(2);
                    sVar.f(j5, sVar.c.getData(), 2);
                    j5 += 2;
                    i4 = sVar.c.readUnsignedShort();
                } else {
                    i4 = 1;
                }
                int[] iArr = cryptoInfo.numBytesOfClearData;
                if (iArr == null || iArr.length < i4) {
                    iArr = new int[i4];
                }
                int[] iArr2 = cryptoInfo.numBytesOfEncryptedData;
                if (iArr2 == null || iArr2.length < i4) {
                    iArr2 = new int[i4];
                }
                if (z4) {
                    int i6 = i4 * 6;
                    sVar.c.reset(i6);
                    sVar.f(j5, sVar.c.getData(), i6);
                    j5 += (long) i6;
                    sVar.c.setPosition(0);
                    for (i2 = 0; i2 < i4; i2++) {
                        iArr[i2] = sVar.c.readUnsignedShort();
                        iArr2[i2] = sVar.c.readUnsignedIntToInt();
                    }
                } else {
                    iArr[0] = 0;
                    iArr2[0] = aVar2.a - ((int) (j5 - aVar2.b));
                }
                TrackOutput.CryptoData cryptoData = (TrackOutput.CryptoData) Util.castNonNull(aVar2.c);
                cryptoInfo.set(i4, iArr, iArr2, cryptoData.encryptionKey, cryptoInfo.iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
                long j6 = aVar2.b;
                int i7 = (int) (j5 - j6);
                aVar2.b = j6 + ((long) i7);
                aVar2.a -= i7;
            }
            if (decoderInputBuffer.hasSupplementalData()) {
                sVar.c.reset(4);
                sVar.f(aVar2.b, sVar.c.getData(), 4);
                int readUnsignedIntToInt = sVar.c.readUnsignedIntToInt();
                aVar2.b += 4;
                aVar2.a -= 4;
                decoderInputBuffer.ensureSpaceForWrite(readUnsignedIntToInt);
                sVar.e(aVar2.b, decoderInputBuffer.data, readUnsignedIntToInt);
                aVar2.b += (long) readUnsignedIntToInt;
                int i8 = aVar2.a - readUnsignedIntToInt;
                aVar2.a = i8;
                decoderInputBuffer.resetSupplementalData(i8);
                sVar.e(aVar2.b, decoderInputBuffer.supplementalData, aVar2.a);
            } else {
                decoderInputBuffer.ensureSpaceForWrite(aVar2.a);
                sVar.e(aVar2.b, decoderInputBuffer.data, aVar2.a);
            }
        }
        return i3;
    }

    @CallSuper
    public void release() {
        reset(true);
        DrmSession drmSession = this.h;
        if (drmSession != null) {
            drmSession.release(this.e);
            this.h = null;
            this.g = null;
        }
    }

    public final void reset() {
        reset(false);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public /* synthetic */ int sampleData(DataReader dataReader, int i2, boolean z2) {
        return d.$default$sampleData(this, dataReader, i2, z2);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final int sampleData(DataReader dataReader, int i2, boolean z2, int i3) throws IOException {
        s sVar = this.a;
        int d2 = sVar.d(i2);
        s.a aVar = sVar.f;
        int read = dataReader.read(aVar.d.data, aVar.a(sVar.g), d2);
        if (read != -1) {
            sVar.c(read);
            return read;
        } else if (z2) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public /* synthetic */ void sampleData(ParsableByteArray parsableByteArray, int i2) {
        d.$default$sampleData(this, parsableByteArray, i2);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long j2, int i2, int i3, int i4, @Nullable TrackOutput.CryptoData cryptoData) {
        boolean z2;
        if (this.A) {
            format((Format) Assertions.checkStateNotNull(this.B));
        }
        int i5 = i2 & 1;
        boolean z3 = i5 != 0;
        if (this.y) {
            if (z3) {
                this.y = false;
            } else {
                return;
            }
        }
        long j3 = j2 + this.H;
        if (this.F) {
            if (j3 >= this.u) {
                if (i5 == 0) {
                    if (!this.G) {
                        StringBuilder L = a2.b.a.a.a.L("Overriding unexpected non-sync sample for format: ");
                        L.append(this.C);
                        L.toString();
                        this.G = true;
                    }
                    i2 |= 1;
                }
            } else {
                return;
            }
        }
        if (this.I) {
            if (z3) {
                synchronized (this) {
                    if (this.q == 0) {
                        z2 = j3 > this.v;
                    } else if (getLargestReadTimestampUs() >= j3) {
                        z2 = false;
                    } else {
                        c(this.r + a(j3));
                        z2 = true;
                    }
                }
                if (z2) {
                    this.I = false;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        long j4 = (this.a.g - ((long) i3)) - ((long) i4);
        synchronized (this) {
            int i6 = this.q;
            if (i6 > 0) {
                int f2 = f(i6 - 1);
                Assertions.checkArgument(this.k[f2] + ((long) this.l[f2]) <= j4);
            }
            this.x = (536870912 & i2) != 0;
            this.w = Math.max(this.w, j3);
            int f3 = f(this.q);
            this.n[f3] = j3;
            long[] jArr = this.k;
            jArr[f3] = j4;
            this.l[f3] = i3;
            this.m[f3] = i2;
            this.o[f3] = cryptoData;
            Format[] formatArr = this.p;
            Format format = this.C;
            formatArr[f3] = format;
            this.j[f3] = this.E;
            this.D = format;
            int i7 = this.q + 1;
            this.q = i7;
            int i8 = this.i;
            if (i7 == i8) {
                int i9 = i8 + 1000;
                int[] iArr = new int[i9];
                long[] jArr2 = new long[i9];
                long[] jArr3 = new long[i9];
                int[] iArr2 = new int[i9];
                int[] iArr3 = new int[i9];
                TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i9];
                Format[] formatArr2 = new Format[i9];
                int i10 = this.s;
                int i11 = i8 - i10;
                System.arraycopy(jArr, i10, jArr2, 0, i11);
                System.arraycopy(this.n, this.s, jArr3, 0, i11);
                System.arraycopy(this.m, this.s, iArr2, 0, i11);
                System.arraycopy(this.l, this.s, iArr3, 0, i11);
                System.arraycopy(this.o, this.s, cryptoDataArr, 0, i11);
                System.arraycopy(this.p, this.s, formatArr2, 0, i11);
                System.arraycopy(this.j, this.s, iArr, 0, i11);
                int i12 = this.s;
                System.arraycopy(this.k, 0, jArr2, i11, i12);
                System.arraycopy(this.n, 0, jArr3, i11, i12);
                System.arraycopy(this.m, 0, iArr2, i11, i12);
                System.arraycopy(this.l, 0, iArr3, i11, i12);
                System.arraycopy(this.o, 0, cryptoDataArr, i11, i12);
                System.arraycopy(this.p, 0, formatArr2, i11, i12);
                System.arraycopy(this.j, 0, iArr, i11, i12);
                this.k = jArr2;
                this.n = jArr3;
                this.m = iArr2;
                this.l = iArr3;
                this.o = cryptoDataArr;
                this.p = formatArr2;
                this.j = iArr;
                this.s = 0;
                this.i = i9;
            }
        }
    }

    public final synchronized boolean seekTo(int i2) {
        j();
        int i3 = this.r;
        if (i2 >= i3) {
            if (i2 <= this.q + i3) {
                this.u = Long.MIN_VALUE;
                this.t = i2 - i3;
                return true;
            }
        }
        return false;
    }

    public final void setSampleOffsetUs(long j2) {
        if (this.H != j2) {
            this.H = j2;
            invalidateUpstreamFormatAdjustment();
        }
    }

    public final void setStartTimeUs(long j2) {
        this.u = j2;
    }

    public final void setUpstreamFormatChangeListener(@Nullable UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.f = upstreamFormatChangedListener;
    }

    public final synchronized void skip(int i2) {
        boolean z2;
        if (i2 >= 0) {
            try {
                if (this.t + i2 <= this.q) {
                    z2 = true;
                    Assertions.checkArgument(z2);
                    this.t += i2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z2 = false;
        Assertions.checkArgument(z2);
        this.t += i2;
    }

    public final void sourceId(int i2) {
        this.E = i2;
    }

    public final void splice() {
        this.I = true;
    }

    @CallSuper
    public void reset(boolean z2) {
        s sVar = this.a;
        sVar.a(sVar.d);
        s.a aVar = new s.a(0, sVar.b);
        sVar.d = aVar;
        sVar.e = aVar;
        sVar.f = aVar;
        sVar.g = 0;
        sVar.a.trim();
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.y = true;
        this.u = Long.MIN_VALUE;
        this.v = Long.MIN_VALUE;
        this.w = Long.MIN_VALUE;
        this.x = false;
        this.D = null;
        if (z2) {
            this.B = null;
            this.C = null;
            this.z = true;
        }
    }

    public final synchronized boolean seekTo(long j2, boolean z2) {
        j();
        int f2 = f(this.t);
        if (g() && j2 >= this.n[f2]) {
            if (j2 <= this.w || z2) {
                int d2 = d(f2, this.q - this.t, j2, true);
                if (d2 == -1) {
                    return false;
                }
                this.u = j2;
                this.t += d2;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void sampleData(ParsableByteArray parsableByteArray, int i2, int i3) {
        s sVar = this.a;
        Objects.requireNonNull(sVar);
        while (i2 > 0) {
            int d2 = sVar.d(i2);
            s.a aVar = sVar.f;
            parsableByteArray.readBytes(aVar.d.data, aVar.a(sVar.g), d2);
            i2 -= d2;
            sVar.c(d2);
        }
    }
}
