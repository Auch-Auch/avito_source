package com.google.android.exoplayer2.source.hls;

import a2.j.b.b.u0.d;
import a2.j.b.b.z0.w.e;
import a2.j.b.b.z0.w.f;
import a2.j.b.b.z0.w.g;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
public final class HlsSampleStreamWrapper implements Loader.Callback<Chunk>, Loader.ReleaseCallback, SequenceableLoader, ExtractorOutput, SampleQueue.UpstreamFormatChangedListener {
    public static final Set<Integer> V = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 4)));
    public boolean A;
    public int B;
    public Format C;
    @Nullable
    public Format D;
    public boolean E;
    public TrackGroupArray F;
    public Set<TrackGroup> G;
    public int[] H;
    public int I;
    public boolean J;
    public boolean[] K;
    public boolean[] L;
    public long M;
    public long N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public long S;
    @Nullable
    public DrmInitData T;
    public int U;
    public final int a;
    public final Callback b;
    public final HlsChunkSource c;
    public final Allocator d;
    @Nullable
    public final Format e;
    public final DrmSessionManager<?> f;
    public final LoadErrorHandlingPolicy g;
    public final Loader h = new Loader("Loader:HlsSampleStreamWrapper");
    public final MediaSourceEventListener.EventDispatcher i;
    public final int j;
    public final HlsChunkSource.HlsChunkHolder k = new HlsChunkSource.HlsChunkHolder();
    public final ArrayList<f> l;
    public final List<f> m;
    public final Runnable n;
    public final Runnable o;
    public final Handler p;
    public final ArrayList<g> q;
    public final Map<String, DrmInitData> r;
    public b[] s;
    public int[] t = new int[0];
    public Set<Integer> u;
    public SparseIntArray v;
    public TrackOutput w;
    public int x;
    public int y;
    public boolean z;

    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void onPlaylistRefreshRequired(Uri uri);

        void onPrepared();
    }

    public static class a implements TrackOutput {
        public static final Format g = Format.createSampleFormat(null, MimeTypes.APPLICATION_ID3, Long.MAX_VALUE);
        public static final Format h = Format.createSampleFormat(null, MimeTypes.APPLICATION_EMSG, Long.MAX_VALUE);
        public final EventMessageDecoder a = new EventMessageDecoder();
        public final TrackOutput b;
        public final Format c;
        public Format d;
        public byte[] e;
        public int f;

        public a(TrackOutput trackOutput, int i) {
            this.b = trackOutput;
            if (i == 1) {
                this.c = g;
            } else if (i == 3) {
                this.c = h;
            } else {
                throw new IllegalArgumentException(a2.b.a.a.a.m2(33, "Unknown metadataType: ", i));
            }
            this.e = new byte[0];
            this.f = 0;
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(Format format) {
            this.d = format;
            this.b.format(this.c);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ int sampleData(DataReader dataReader, int i, boolean z) {
            return d.$default$sampleData(this, dataReader, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(ParsableByteArray parsableByteArray, int i) {
            int i2 = this.f + i;
            byte[] bArr = this.e;
            if (bArr.length < i2) {
                this.e = Arrays.copyOf(bArr, (i2 / 2) + i2);
            }
            parsableByteArray.readBytes(this.e, this.f, i);
            this.f += i;
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long j, int i, int i2, int i3, @Nullable TrackOutput.CryptoData cryptoData) {
            Assertions.checkNotNull(this.d);
            int i4 = this.f - i3;
            ParsableByteArray parsableByteArray = new ParsableByteArray(Arrays.copyOfRange(this.e, i4 - i2, i4));
            byte[] bArr = this.e;
            System.arraycopy(bArr, i4, bArr, 0, i3);
            this.f = i3;
            if (!Util.areEqual(this.d.sampleMimeType, this.c.sampleMimeType)) {
                if (MimeTypes.APPLICATION_EMSG.equals(this.d.sampleMimeType)) {
                    EventMessage decode = this.a.decode(parsableByteArray);
                    Format wrappedMetadataFormat = decode.getWrappedMetadataFormat();
                    if (!(wrappedMetadataFormat != null && Util.areEqual(this.c.sampleMimeType, wrappedMetadataFormat.sampleMimeType))) {
                        Log.w("EmsgUnwrappingTrackOutput", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.c.sampleMimeType, decode.getWrappedMetadataFormat()));
                        return;
                    }
                    parsableByteArray = new ParsableByteArray((byte[]) Assertions.checkNotNull(decode.getWrappedMetadataBytes()));
                } else {
                    String valueOf = String.valueOf(this.d.sampleMimeType);
                    Log.w("EmsgUnwrappingTrackOutput", valueOf.length() != 0 ? "Ignoring sample for unsupported format: ".concat(valueOf) : new String("Ignoring sample for unsupported format: "));
                    return;
                }
            }
            int bytesLeft = parsableByteArray.bytesLeft();
            this.b.sampleData(parsableByteArray, bytesLeft);
            this.b.sampleMetadata(j, i, bytesLeft, i3, cryptoData);
        }
    }

    public static final class b extends SampleQueue {
        public final Map<String, DrmInitData> J;
        @Nullable
        public DrmInitData K;

        public b(Allocator allocator, Looper looper, DrmSessionManager<?> drmSessionManager, Map<String, DrmInitData> map) {
            super(allocator, looper, drmSessionManager);
            this.J = map;
        }

        @Override // com.google.android.exoplayer2.source.SampleQueue
        public Format getAdjustedUpstreamFormat(Format format) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.K;
            if (drmInitData2 == null) {
                drmInitData2 = format.drmInitData;
            }
            if (!(drmInitData2 == null || (drmInitData = this.J.get(drmInitData2.schemeType)) == null)) {
                drmInitData2 = drmInitData;
            }
            Metadata metadata = format.metadata;
            if (metadata != null) {
                int length = metadata.length();
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    }
                    Metadata.Entry entry = metadata.get(i2);
                    if ((entry instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) entry).owner)) {
                        break;
                    }
                    i2++;
                }
                if (i2 != -1) {
                    if (length != 1) {
                        Metadata.Entry[] entryArr = new Metadata.Entry[(length - 1)];
                        while (i < length) {
                            if (i != i2) {
                                entryArr[i < i2 ? i : i - 1] = metadata.get(i);
                            }
                            i++;
                        }
                        metadata = new Metadata(entryArr);
                    }
                }
                return super.getAdjustedUpstreamFormat(format.copyWithAdjustments(drmInitData2, metadata));
            }
            metadata = null;
            return super.getAdjustedUpstreamFormat(format.copyWithAdjustments(drmInitData2, metadata));
        }
    }

    public HlsSampleStreamWrapper(int i2, Callback callback, HlsChunkSource hlsChunkSource, Map<String, DrmInitData> map, Allocator allocator, long j2, @Nullable Format format, DrmSessionManager<?> drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, int i3) {
        this.a = i2;
        this.b = callback;
        this.c = hlsChunkSource;
        this.r = map;
        this.d = allocator;
        this.e = format;
        this.f = drmSessionManager;
        this.g = loadErrorHandlingPolicy;
        this.i = eventDispatcher;
        this.j = i3;
        Set<Integer> set = V;
        this.u = new HashSet(set.size());
        this.v = new SparseIntArray(set.size());
        this.s = new b[0];
        this.L = new boolean[0];
        this.K = new boolean[0];
        ArrayList<f> arrayList = new ArrayList<>();
        this.l = arrayList;
        this.m = Collections.unmodifiableList(arrayList);
        this.q = new ArrayList<>();
        this.n = new Runnable() { // from class: a2.j.b.b.z0.w.b
            @Override // java.lang.Runnable
            public final void run() {
                HlsSampleStreamWrapper.this.h();
            }
        };
        this.o = new Runnable() { // from class: a2.j.b.b.z0.w.a
            @Override // java.lang.Runnable
            public final void run() {
                HlsSampleStreamWrapper hlsSampleStreamWrapper = HlsSampleStreamWrapper.this;
                hlsSampleStreamWrapper.z = true;
                hlsSampleStreamWrapper.h();
            }
        };
        this.p = new Handler();
        this.M = j2;
        this.N = j2;
    }

    public static DummyTrackOutput b(int i2, int i3) {
        Log.w("HlsSampleStreamWrapper", a2.b.a.a.a.p2(54, "Unmapped track with id ", i2, " of type ", i3));
        return new DummyTrackOutput();
    }

    public static Format d(@Nullable Format format, Format format2, boolean z2) {
        if (format == null) {
            return format2;
        }
        int i2 = z2 ? format.bitrate : -1;
        int i3 = format.channelCount;
        if (i3 == -1) {
            i3 = format2.channelCount;
        }
        String codecsOfType = Util.getCodecsOfType(format.codecs, MimeTypes.getTrackType(format2.sampleMimeType));
        String mediaMimeType = MimeTypes.getMediaMimeType(codecsOfType);
        if (mediaMimeType == null) {
            mediaMimeType = format2.sampleMimeType;
        }
        return format2.copyWithContainerInfo(format.id, format.label, mediaMimeType, codecsOfType, format.metadata, i2, format.width, format.height, i3, format.selectionFlags, format.language);
    }

    public static int f(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 3 ? 0 : 1;
        }
        return 3;
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    public final void a() {
        Assertions.checkState(this.A);
        Assertions.checkNotNull(this.F);
        Assertions.checkNotNull(this.G);
    }

    public final TrackGroupArray c(TrackGroup[] trackGroupArr) {
        for (int i2 = 0; i2 < trackGroupArr.length; i2++) {
            TrackGroup trackGroup = trackGroupArr[i2];
            Format[] formatArr = new Format[trackGroup.length];
            for (int i3 = 0; i3 < trackGroup.length; i3++) {
                Format format = trackGroup.getFormat(i3);
                DrmInitData drmInitData = format.drmInitData;
                if (drmInitData != null) {
                    format = format.copyWithExoMediaCryptoType(this.f.getExoMediaCryptoType(drmInitData));
                }
                formatArr[i3] = format;
            }
            trackGroupArr[i2] = new TrackGroup(formatArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j2) {
        List<f> list;
        long max;
        int i2;
        HlsChunkSource.HlsChunkHolder hlsChunkHolder;
        boolean z2;
        long j3;
        HlsMediaPlaylist hlsMediaPlaylist;
        Uri uri;
        byte[] bArr;
        byte[] bArr2;
        a2.j.b.b.z0.w.d dVar;
        HlsChunkSource.HlsChunkHolder hlsChunkHolder2;
        boolean z3;
        DataSpec dataSpec;
        DataSource dataSource;
        HlsExtractorFactory hlsExtractorFactory;
        boolean z4;
        ParsableByteArray parsableByteArray;
        Id3Decoder id3Decoder;
        Extractor extractor;
        String str;
        if (this.Q || this.h.isLoading() || this.h.hasFatalError()) {
            return false;
        }
        if (g()) {
            list = Collections.emptyList();
            max = this.N;
        } else {
            list = this.m;
            f e2 = e();
            if (e2.x) {
                max = e2.endTimeUs;
            } else {
                max = Math.max(this.M, e2.startTimeUs);
            }
        }
        HlsChunkSource hlsChunkSource = this.c;
        boolean z5 = this.A || !list.isEmpty();
        HlsChunkSource.HlsChunkHolder hlsChunkHolder3 = this.k;
        Objects.requireNonNull(hlsChunkSource);
        f fVar = null;
        if (!list.isEmpty()) {
            fVar = (f) a2.b.a.a.a.j2(list, 1);
        }
        if (fVar == null) {
            i2 = -1;
        } else {
            i2 = hlsChunkSource.h.indexOf(fVar.trackFormat);
        }
        long j4 = max - j2;
        long j5 = hlsChunkSource.q;
        long j6 = (j5 > C.TIME_UNSET ? 1 : (j5 == C.TIME_UNSET ? 0 : -1)) != 0 ? j5 - j2 : -9223372036854775807L;
        if (fVar == null || hlsChunkSource.o) {
            z2 = z5;
            hlsChunkHolder = hlsChunkHolder3;
        } else {
            long durationUs = fVar.getDurationUs();
            z2 = z5;
            hlsChunkHolder = hlsChunkHolder3;
            j4 = Math.max(0L, j4 - durationUs);
            if (j6 != C.TIME_UNSET) {
                j6 = Math.max(0L, j6 - durationUs);
            }
        }
        int i3 = i2;
        hlsChunkSource.p.updateSelectedTrack(j2, j4, j6, list, hlsChunkSource.a(fVar, max));
        int selectedIndexInTrackGroup = hlsChunkSource.p.getSelectedIndexInTrackGroup();
        boolean z7 = i3 != selectedIndexInTrackGroup;
        Uri uri2 = hlsChunkSource.e[selectedIndexInTrackGroup];
        if (!hlsChunkSource.g.isSnapshotValid(uri2)) {
            hlsChunkHolder.playlistUrl = uri2;
            hlsChunkSource.r &= uri2.equals(hlsChunkSource.n);
            hlsChunkSource.n = uri2;
        } else {
            HlsMediaPlaylist playlistSnapshot = hlsChunkSource.g.getPlaylistSnapshot(uri2, true);
            Assertions.checkNotNull(playlistSnapshot);
            hlsChunkSource.o = playlistSnapshot.hasIndependentSegments;
            if (playlistSnapshot.hasEndTag) {
                j3 = C.TIME_UNSET;
            } else {
                j3 = playlistSnapshot.getEndTimeUs() - hlsChunkSource.g.getInitialStartTimeUs();
            }
            hlsChunkSource.q = j3;
            long initialStartTimeUs = playlistSnapshot.startTimeUs - hlsChunkSource.g.getInitialStartTimeUs();
            long b2 = hlsChunkSource.b(fVar, z7, playlistSnapshot, initialStartTimeUs, max);
            if (b2 >= playlistSnapshot.mediaSequence || fVar == null || !z7) {
                i3 = selectedIndexInTrackGroup;
                hlsMediaPlaylist = playlistSnapshot;
                uri = uri2;
            } else {
                uri = hlsChunkSource.e[i3];
                hlsMediaPlaylist = hlsChunkSource.g.getPlaylistSnapshot(uri, true);
                Assertions.checkNotNull(hlsMediaPlaylist);
                initialStartTimeUs = hlsMediaPlaylist.startTimeUs - hlsChunkSource.g.getInitialStartTimeUs();
                b2 = fVar.getNextChunkIndex();
            }
            long j7 = hlsMediaPlaylist.mediaSequence;
            if (b2 < j7) {
                hlsChunkSource.m = new BehindLiveWindowException();
            } else {
                int i4 = (int) (b2 - j7);
                int size = hlsMediaPlaylist.segments.size();
                if (i4 >= size) {
                    if (!hlsMediaPlaylist.hasEndTag) {
                        hlsChunkHolder.playlistUrl = uri;
                        hlsChunkSource.r &= uri.equals(hlsChunkSource.n);
                        hlsChunkSource.n = uri;
                    } else if (z2 || size == 0) {
                        hlsChunkHolder.endOfStream = true;
                    } else {
                        i4 = size - 1;
                    }
                }
                hlsChunkSource.r = false;
                Uri uri3 = null;
                hlsChunkSource.n = null;
                HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(i4);
                HlsMediaPlaylist.Segment segment2 = segment.initializationSegment;
                Uri resolveToUri = (segment2 == null || (str = segment2.fullSegmentEncryptionKeyUri) == null) ? null : UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, str);
                Chunk c2 = hlsChunkSource.c(resolveToUri, i3);
                hlsChunkHolder.chunk = c2;
                if (c2 == null) {
                    String str2 = segment.fullSegmentEncryptionKeyUri;
                    if (str2 != null) {
                        uri3 = UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, str2);
                    }
                    Chunk c3 = hlsChunkSource.c(uri3, i3);
                    hlsChunkHolder.chunk = c3;
                    if (c3 == null) {
                        HlsExtractorFactory hlsExtractorFactory2 = hlsChunkSource.a;
                        DataSource dataSource2 = hlsChunkSource.b;
                        Format format = hlsChunkSource.f[i3];
                        List<Format> list2 = hlsChunkSource.i;
                        int selectionReason = hlsChunkSource.p.getSelectionReason();
                        Object selectionData = hlsChunkSource.p.getSelectionData();
                        boolean z8 = hlsChunkSource.k;
                        TimestampAdjusterProvider timestampAdjusterProvider = hlsChunkSource.d;
                        e eVar = hlsChunkSource.j;
                        Objects.requireNonNull(eVar);
                        if (uri3 == null) {
                            bArr = null;
                        } else {
                            bArr = eVar.a.get(uri3);
                        }
                        e eVar2 = hlsChunkSource.j;
                        Objects.requireNonNull(eVar2);
                        if (resolveToUri == null) {
                            bArr2 = null;
                        } else {
                            bArr2 = eVar2.a.get(resolveToUri);
                        }
                        PositionHolder positionHolder = f.y;
                        HlsMediaPlaylist.Segment segment3 = hlsMediaPlaylist.segments.get(i4);
                        DataSpec dataSpec2 = new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment3.url), segment3.byterangeOffset, segment3.byterangeLength, null);
                        boolean z9 = bArr != null;
                        byte[] b3 = z9 ? f.b((String) Assertions.checkNotNull(segment3.encryptionIV)) : null;
                        if (bArr != null) {
                            Assertions.checkNotNull(b3);
                            dVar = new a2.j.b.b.z0.w.d(dataSource2, bArr, b3);
                        } else {
                            dVar = dataSource2;
                        }
                        HlsMediaPlaylist.Segment segment4 = segment3.initializationSegment;
                        if (segment4 != null) {
                            boolean z10 = bArr2 != null;
                            byte[] b4 = z10 ? f.b((String) Assertions.checkNotNull(segment4.encryptionIV)) : null;
                            hlsChunkHolder2 = hlsChunkHolder;
                            hlsExtractorFactory = hlsExtractorFactory2;
                            DataSpec dataSpec3 = new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment4.url), segment4.byterangeOffset, segment4.byterangeLength, null);
                            if (bArr2 != null) {
                                Assertions.checkNotNull(b4);
                                dataSource2 = new a2.j.b.b.z0.w.d(dataSource2, bArr2, b4);
                            }
                            dataSource = dataSource2;
                            z3 = z10;
                            dataSpec = dataSpec3;
                        } else {
                            hlsExtractorFactory = hlsExtractorFactory2;
                            hlsChunkHolder2 = hlsChunkHolder;
                            dataSource = null;
                            dataSpec = null;
                            z3 = false;
                        }
                        long j8 = initialStartTimeUs + segment3.relativeStartTimeUs;
                        long j9 = j8 + segment3.durationUs;
                        int i5 = hlsMediaPlaylist.discontinuitySequence + segment3.relativeDiscontinuitySequence;
                        if (fVar != null) {
                            Id3Decoder id3Decoder2 = fVar.n;
                            ParsableByteArray parsableByteArray2 = fVar.o;
                            boolean z11 = !uri.equals(fVar.c) || !fVar.x;
                            id3Decoder = id3Decoder2;
                            parsableByteArray = parsableByteArray2;
                            z4 = z11;
                            extractor = (!fVar.s || fVar.b != i5 || z11) ? null : fVar.r;
                        } else {
                            id3Decoder = new Id3Decoder();
                            parsableByteArray = new ParsableByteArray(10);
                            extractor = null;
                            z4 = false;
                        }
                        hlsChunkHolder2.chunk = new f(hlsExtractorFactory, dVar, dataSpec2, format, z9, dataSource, dataSpec, z3, uri, list2, selectionReason, selectionData, j8, j9, hlsMediaPlaylist.mediaSequence + ((long) i4), i5, segment3.hasGapTag, z8, timestampAdjusterProvider.getAdjuster(i5), segment3.drmInitData, extractor, id3Decoder, parsableByteArray, z4);
                    }
                }
            }
        }
        HlsChunkSource.HlsChunkHolder hlsChunkHolder4 = this.k;
        boolean z12 = hlsChunkHolder4.endOfStream;
        Chunk chunk = hlsChunkHolder4.chunk;
        Uri uri4 = hlsChunkHolder4.playlistUrl;
        hlsChunkHolder4.clear();
        if (z12) {
            this.N = C.TIME_UNSET;
            this.Q = true;
            return true;
        } else if (chunk != null) {
            if (chunk instanceof f) {
                this.N = C.TIME_UNSET;
                f fVar2 = (f) chunk;
                fVar2.t = this;
                int i6 = fVar2.a;
                boolean z13 = fVar2.j;
                this.U = i6;
                for (b bVar : this.s) {
                    bVar.sourceId(i6);
                }
                if (z13) {
                    for (b bVar2 : this.s) {
                        bVar2.splice();
                    }
                }
                this.l.add(fVar2);
                this.C = fVar2.trackFormat;
            }
            this.i.loadStarted(chunk.dataSpec, chunk.type, this.a, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.h.startLoading(chunk, this, this.g.getMinimumLoadableRetryCount(chunk.type)));
            return true;
        } else if (uri4 == null) {
            return false;
        } else {
            this.b.onPlaylistRefreshRequired(uri4);
            return false;
        }
    }

    public final f e() {
        ArrayList<f> arrayList = this.l;
        return arrayList.get(arrayList.size() - 1);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.R = true;
        this.p.post(this.o);
    }

    public final boolean g() {
        return this.N != C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        if (this.Q) {
            return Long.MIN_VALUE;
        }
        if (g()) {
            return this.N;
        }
        long j2 = this.M;
        f e2 = e();
        if (!e2.x) {
            if (this.l.size() > 1) {
                ArrayList<f> arrayList = this.l;
                e2 = arrayList.get(arrayList.size() - 2);
            } else {
                e2 = null;
            }
        }
        if (e2 != null) {
            j2 = Math.max(j2, e2.endTimeUs);
        }
        if (this.z) {
            for (b bVar : this.s) {
                j2 = Math.max(j2, bVar.getLargestQueuedTimestampUs());
            }
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (g()) {
            return this.N;
        }
        if (this.Q) {
            return Long.MIN_VALUE;
        }
        return e().endTimeUs;
    }

    public final void h() {
        if (!this.E && this.H == null && this.z) {
            boolean z2 = false;
            for (b bVar : this.s) {
                if (bVar.getUpstreamFormat() == null) {
                    return;
                }
            }
            TrackGroupArray trackGroupArray = this.F;
            if (trackGroupArray != null) {
                int i2 = trackGroupArray.length;
                int[] iArr = new int[i2];
                this.H = iArr;
                Arrays.fill(iArr, -1);
                for (int i3 = 0; i3 < i2; i3++) {
                    int i4 = 0;
                    while (true) {
                        b[] bVarArr = this.s;
                        if (i4 >= bVarArr.length) {
                            break;
                        }
                        Format upstreamFormat = bVarArr[i4].getUpstreamFormat();
                        Format format = this.F.get(i3).getFormat(0);
                        String str = upstreamFormat.sampleMimeType;
                        String str2 = format.sampleMimeType;
                        int trackType = MimeTypes.getTrackType(str);
                        if (trackType == 3 ? Util.areEqual(str, str2) && ((!MimeTypes.APPLICATION_CEA608.equals(str) && !MimeTypes.APPLICATION_CEA708.equals(str)) || upstreamFormat.accessibilityChannel == format.accessibilityChannel) : trackType == MimeTypes.getTrackType(str2)) {
                            this.H[i3] = i4;
                            break;
                        }
                        i4++;
                    }
                }
                Iterator<g> it = this.q.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                return;
            }
            int length = this.s.length;
            int i5 = 0;
            int i6 = 6;
            int i7 = -1;
            while (true) {
                int i8 = 2;
                if (i5 >= length) {
                    break;
                }
                String str3 = this.s[i5].getUpstreamFormat().sampleMimeType;
                if (!MimeTypes.isVideo(str3)) {
                    if (MimeTypes.isAudio(str3)) {
                        i8 = 1;
                    } else {
                        i8 = MimeTypes.isText(str3) ? 3 : 6;
                    }
                }
                if (f(i8) > f(i6)) {
                    i7 = i5;
                    i6 = i8;
                } else if (i8 == i6 && i7 != -1) {
                    i7 = -1;
                }
                i5++;
            }
            TrackGroup trackGroup = this.c.h;
            int i9 = trackGroup.length;
            this.I = -1;
            this.H = new int[length];
            for (int i10 = 0; i10 < length; i10++) {
                this.H[i10] = i10;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[length];
            for (int i11 = 0; i11 < length; i11++) {
                Format upstreamFormat2 = this.s[i11].getUpstreamFormat();
                if (i11 == i7) {
                    Format[] formatArr = new Format[i9];
                    if (i9 == 1) {
                        formatArr[0] = upstreamFormat2.copyWithManifestFormatInfo(trackGroup.getFormat(0));
                    } else {
                        for (int i12 = 0; i12 < i9; i12++) {
                            formatArr[i12] = d(trackGroup.getFormat(i12), upstreamFormat2, true);
                        }
                    }
                    trackGroupArr[i11] = new TrackGroup(formatArr);
                    this.I = i11;
                } else {
                    trackGroupArr[i11] = new TrackGroup(d((i6 != 2 || !MimeTypes.isAudio(upstreamFormat2.sampleMimeType)) ? null : this.e, upstreamFormat2, false));
                }
            }
            this.F = c(trackGroupArr);
            if (this.G == null) {
                z2 = true;
            }
            Assertions.checkState(z2);
            this.G = Collections.emptySet();
            this.A = true;
            this.b.onPrepared();
        }
    }

    public void i() throws IOException {
        this.h.maybeThrowError();
        HlsChunkSource hlsChunkSource = this.c;
        IOException iOException = hlsChunkSource.m;
        if (iOException == null) {
            Uri uri = hlsChunkSource.n;
            if (uri != null && hlsChunkSource.r) {
                hlsChunkSource.g.maybeThrowPlaylistRefreshError(uri);
                return;
            }
            return;
        }
        throw iOException;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.h.isLoading();
    }

    /* renamed from: j */
    public void onLoadCanceled(Chunk chunk, long j2, long j3, boolean z2) {
        this.i.loadCanceled(chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), chunk.type, this.a, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j2, j3, chunk.bytesLoaded());
        if (!z2) {
            o();
            if (this.B > 0) {
                this.b.onContinueLoadingRequested(this);
            }
        }
    }

    /* renamed from: k */
    public void onLoadCompleted(Chunk chunk, long j2, long j3) {
        HlsChunkSource hlsChunkSource = this.c;
        Objects.requireNonNull(hlsChunkSource);
        if (chunk instanceof HlsChunkSource.a) {
            HlsChunkSource.a aVar = (HlsChunkSource.a) chunk;
            hlsChunkSource.l = aVar.getDataHolder();
            hlsChunkSource.j.a(aVar.dataSpec.uri, (byte[]) Assertions.checkNotNull(aVar.c));
        }
        this.i.loadCompleted(chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), chunk.type, this.a, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j2, j3, chunk.bytesLoaded());
        if (!this.A) {
            continueLoading(this.M);
        } else {
            this.b.onContinueLoadingRequested(this);
        }
    }

    /* renamed from: l */
    public Loader.LoadErrorAction onLoadError(Chunk chunk, long j2, long j3, IOException iOException, int i2) {
        boolean z2;
        Loader.LoadErrorAction loadErrorAction;
        long bytesLoaded = chunk.bytesLoaded();
        boolean z3 = chunk instanceof f;
        long blacklistDurationMsFor = this.g.getBlacklistDurationMsFor(chunk.type, j3, iOException, i2);
        boolean z4 = false;
        if (blacklistDurationMsFor != C.TIME_UNSET) {
            HlsChunkSource hlsChunkSource = this.c;
            TrackSelection trackSelection = hlsChunkSource.p;
            z2 = trackSelection.blacklist(trackSelection.indexOf(hlsChunkSource.h.indexOf(chunk.trackFormat)), blacklistDurationMsFor);
        } else {
            z2 = false;
        }
        if (z2) {
            if (z3 && bytesLoaded == 0) {
                ArrayList<f> arrayList = this.l;
                if (arrayList.remove(arrayList.size() - 1) == chunk) {
                    z4 = true;
                }
                Assertions.checkState(z4);
                if (this.l.isEmpty()) {
                    this.N = this.M;
                }
            }
            loadErrorAction = Loader.DONT_RETRY;
        } else {
            long retryDelayMsFor = this.g.getRetryDelayMsFor(chunk.type, j3, iOException, i2);
            if (retryDelayMsFor != C.TIME_UNSET) {
                loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
            } else {
                loadErrorAction = Loader.DONT_RETRY_FATAL;
            }
        }
        this.i.loadError(chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), chunk.type, this.a, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j2, j3, bytesLoaded, iOException, !loadErrorAction.isRetry());
        if (z2) {
            if (!this.A) {
                continueLoading(this.M);
            } else {
                this.b.onContinueLoadingRequested(this);
            }
        }
        return loadErrorAction;
    }

    public void m(TrackGroup[] trackGroupArr, int i2, int... iArr) {
        this.F = c(trackGroupArr);
        this.G = new HashSet();
        for (int i3 : iArr) {
            this.G.add(this.F.get(i3));
        }
        this.I = i2;
        Handler handler = this.p;
        Callback callback = this.b;
        Objects.requireNonNull(callback);
        handler.post(new Runnable() { // from class: a2.j.b.b.z0.w.c
            @Override // java.lang.Runnable
            public final void run() {
                HlsSampleStreamWrapper.Callback.this.onPrepared();
            }
        });
        this.A = true;
    }

    public int n(int i2, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z2) {
        Format format;
        if (g()) {
            return -3;
        }
        int i3 = 0;
        if (!this.l.isEmpty()) {
            int i4 = 0;
            while (true) {
                boolean z3 = true;
                if (i4 >= this.l.size() - 1) {
                    break;
                }
                int i5 = this.l.get(i4).a;
                int length = this.s.length;
                int i6 = 0;
                while (true) {
                    if (i6 < length) {
                        if (this.K[i6] && this.s[i6].peekSourceId() == i5) {
                            z3 = false;
                            break;
                        }
                        i6++;
                    } else {
                        break;
                    }
                }
                if (!z3) {
                    break;
                }
                i4++;
            }
            Util.removeRange(this.l, 0, i4);
            f fVar = this.l.get(0);
            Format format2 = fVar.trackFormat;
            if (!format2.equals(this.D)) {
                this.i.downstreamFormatChanged(this.a, format2, fVar.trackSelectionReason, fVar.trackSelectionData, fVar.startTimeUs);
            }
            this.D = format2;
        }
        int read = this.s[i2].read(formatHolder, decoderInputBuffer, z2, this.Q, this.M);
        if (read == -5) {
            Format format3 = (Format) Assertions.checkNotNull(formatHolder.format);
            if (i2 == this.y) {
                int peekSourceId = this.s[i2].peekSourceId();
                while (i3 < this.l.size() && this.l.get(i3).a != peekSourceId) {
                    i3++;
                }
                if (i3 < this.l.size()) {
                    format = this.l.get(i3).trackFormat;
                } else {
                    format = (Format) Assertions.checkNotNull(this.C);
                }
                format3 = format3.copyWithManifestFormatInfo(format);
            }
            formatHolder.format = format3;
        }
        return read;
    }

    public final void o() {
        for (b bVar : this.s) {
            bVar.reset(this.O);
        }
        this.O = false;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        for (b bVar : this.s) {
            bVar.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format) {
        this.p.post(this.n);
    }

    public boolean p(long j2, boolean z2) {
        boolean z3;
        this.M = j2;
        if (g()) {
            this.N = j2;
            return true;
        }
        if (this.z && !z2) {
            int length = this.s.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z3 = true;
                    break;
                } else if (this.s[i2].seekTo(j2, false) || (!this.L[i2] && this.J)) {
                    i2++;
                }
            }
            z3 = false;
            if (z3) {
                return false;
            }
        }
        this.N = j2;
        this.Q = false;
        this.l.clear();
        if (this.h.isLoading()) {
            this.h.cancelLoading();
        } else {
            this.h.clearFatalError();
            o();
        }
        return true;
    }

    public void q(long j2) {
        if (this.S != j2) {
            this.S = j2;
            for (b bVar : this.s) {
                bVar.setSampleOffsetUs(j2);
            }
        }
    }

    public int r(int i2, long j2) {
        if (g()) {
            return 0;
        }
        b bVar = this.s[i2];
        if (!this.Q || j2 <= bVar.getLargestQueuedTimestampUs()) {
            return bVar.advanceTo(j2);
        }
        return bVar.advanceToEnd();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j2) {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.google.android.exoplayer2.extractor.DummyTrackOutput] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.extractor.TrackOutput track(int r8, int r9) {
        /*
        // Method dump skipped, instructions count: 243
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.track(int, int):com.google.android.exoplayer2.extractor.TrackOutput");
    }
}
