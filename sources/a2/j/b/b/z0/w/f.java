package a2.j.b.b.z0.w;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
public final class f extends MediaChunk {
    public static final PositionHolder y = new PositionHolder();
    public static final AtomicInteger z = new AtomicInteger();
    public final int a;
    public final int b;
    public final Uri c;
    @Nullable
    public final DataSource d;
    @Nullable
    public final DataSpec e;
    @Nullable
    public final Extractor f;
    public final boolean g;
    public final boolean h;
    public final TimestampAdjuster i;
    public final boolean j;
    public final HlsExtractorFactory k;
    @Nullable
    public final List<Format> l;
    @Nullable
    public final DrmInitData m;
    public final Id3Decoder n;
    public final ParsableByteArray o;
    public final boolean p;
    public final boolean q;
    public Extractor r;
    public boolean s;
    public HlsSampleStreamWrapper t;
    public int u;
    public boolean v;
    public volatile boolean w;
    public boolean x;

    public f(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, DataSpec dataSpec, Format format, boolean z2, @Nullable DataSource dataSource2, @Nullable DataSpec dataSpec2, boolean z3, Uri uri, @Nullable List<Format> list, int i2, @Nullable Object obj, long j2, long j3, long j4, int i3, boolean z4, boolean z5, TimestampAdjuster timestampAdjuster, @Nullable DrmInitData drmInitData, @Nullable Extractor extractor, Id3Decoder id3Decoder, ParsableByteArray parsableByteArray, boolean z7) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, j4);
        this.p = z2;
        this.b = i3;
        this.e = dataSpec2;
        this.d = dataSource2;
        this.v = dataSpec2 != null;
        this.q = z3;
        this.c = uri;
        this.g = z5;
        this.i = timestampAdjuster;
        this.h = z4;
        this.k = hlsExtractorFactory;
        this.l = list;
        this.m = drmInitData;
        this.f = extractor;
        this.n = id3Decoder;
        this.o = parsableByteArray;
        this.j = z7;
        this.a = z.getAndIncrement();
    }

    public static byte[] b(String str) {
        if (Util.toLowerInvariant(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    @RequiresNonNull({"output"})
    public final void a(DataSource dataSource, DataSpec dataSpec, boolean z2) throws IOException, InterruptedException {
        DataSpec dataSpec2;
        boolean z3;
        int i2 = 0;
        if (z2) {
            z3 = this.u != 0;
            dataSpec2 = dataSpec;
        } else {
            dataSpec2 = dataSpec.subrange((long) this.u);
            z3 = false;
        }
        try {
            DefaultExtractorInput c2 = c(dataSource, dataSpec2);
            if (z3) {
                c2.skipFully(this.u);
            }
            while (i2 == 0) {
                try {
                    if (this.w) {
                        break;
                    }
                    i2 = this.r.read(c2, y);
                } catch (Throwable th) {
                    this.u = (int) (c2.getPosition() - dataSpec.absoluteStreamPosition);
                    throw th;
                }
            }
            this.u = (int) (c2.getPosition() - dataSpec.absoluteStreamPosition);
        } finally {
            Util.closeQuietly(dataSource);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e5  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"extractor"})
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.exoplayer2.extractor.DefaultExtractorInput c(com.google.android.exoplayer2.upstream.DataSource r17, com.google.android.exoplayer2.upstream.DataSpec r18) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 288
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.z0.w.f.c(com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.DataSpec):com.google.android.exoplayer2.extractor.DefaultExtractorInput");
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        this.w = true;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.x;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws IOException, InterruptedException {
        Extractor extractor;
        Assertions.checkNotNull(this.t);
        if (this.r == null && (extractor = this.f) != null) {
            this.r = extractor;
            this.s = true;
            this.v = false;
        }
        if (this.v) {
            Assertions.checkNotNull(this.d);
            Assertions.checkNotNull(this.e);
            a(this.d, this.e, this.q);
            this.u = 0;
            this.v = false;
        }
        if (!this.w) {
            if (!this.h) {
                if (!this.g) {
                    this.i.waitUntilInitialized();
                } else if (this.i.getFirstSampleTimestampUs() == Long.MAX_VALUE) {
                    this.i.setFirstSampleTimestampUs(this.startTimeUs);
                }
                a(this.dataSource, this.dataSpec, this.p);
            }
            this.x = true;
        }
    }
}
