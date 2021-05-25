package com.google.android.exoplayer2.source.hls;

import a2.j.b.b.z0.w.e;
import a2.j.b.b.z0.w.f;
import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
public class HlsChunkSource {
    public final HlsExtractorFactory a;
    public final DataSource b;
    public final DataSource c;
    public final TimestampAdjusterProvider d;
    public final Uri[] e;
    public final Format[] f;
    public final HlsPlaylistTracker g;
    public final TrackGroup h;
    @Nullable
    public final List<Format> i;
    public final e j = new e(4);
    public boolean k;
    public byte[] l = Util.EMPTY_BYTE_ARRAY;
    @Nullable
    public IOException m;
    @Nullable
    public Uri n;
    public boolean o;
    public TrackSelection p;
    public long q = C.TIME_UNSET;
    public boolean r;

    public static final class HlsChunkHolder {
        @Nullable
        public Chunk chunk;
        public boolean endOfStream;
        @Nullable
        public Uri playlistUrl;

        public HlsChunkHolder() {
            clear();
        }

        public void clear() {
            this.chunk = null;
            this.endOfStream = false;
            this.playlistUrl = null;
        }
    }

    public static final class a extends DataChunk {
        public byte[] c;

        public a(DataSource dataSource, DataSpec dataSpec, Format format, int i, @Nullable Object obj, byte[] bArr) {
            super(dataSource, dataSpec, 3, format, i, obj, bArr);
        }

        @Override // com.google.android.exoplayer2.source.chunk.DataChunk
        public void consume(byte[] bArr, int i) {
            this.c = Arrays.copyOf(bArr, i);
        }
    }

    public static final class b extends BaseMediaChunkIterator {
        public final HlsMediaPlaylist d;
        public final long e;

        public b(HlsMediaPlaylist hlsMediaPlaylist, long j, int i) {
            super((long) i, (long) (hlsMediaPlaylist.segments.size() - 1));
            this.d = hlsMediaPlaylist;
            this.e = j;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            checkInBounds();
            HlsMediaPlaylist.Segment segment = this.d.segments.get((int) getCurrentIndex());
            return this.e + segment.relativeStartTimeUs + segment.durationUs;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.e + this.d.segments.get((int) getCurrentIndex()).relativeStartTimeUs;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public DataSpec getDataSpec() {
            checkInBounds();
            HlsMediaPlaylist.Segment segment = this.d.segments.get((int) getCurrentIndex());
            return new DataSpec(UriUtil.resolveToUri(this.d.baseUri, segment.url), segment.byterangeOffset, segment.byterangeLength, null);
        }
    }

    public static final class c extends BaseTrackSelection {
        public int d;

        public c(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.d = indexOf(trackGroup.getFormat(0));
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectedIndex() {
            return this.d;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        @Nullable
        public Object getSelectionData() {
            return null;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectionReason() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (isBlacklisted(this.d, elapsedRealtime)) {
                for (int i = this.length - 1; i >= 0; i--) {
                    if (!isBlacklisted(i, elapsedRealtime)) {
                        this.d = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }
    }

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, Format[] formatArr, HlsDataSourceFactory hlsDataSourceFactory, @Nullable TransferListener transferListener, TimestampAdjusterProvider timestampAdjusterProvider, @Nullable List<Format> list) {
        this.a = hlsExtractorFactory;
        this.g = hlsPlaylistTracker;
        this.e = uriArr;
        this.f = formatArr;
        this.d = timestampAdjusterProvider;
        this.i = list;
        DataSource createDataSource = hlsDataSourceFactory.createDataSource(1);
        this.b = createDataSource;
        if (transferListener != null) {
            createDataSource.addTransferListener(transferListener);
        }
        this.c = hlsDataSourceFactory.createDataSource(3);
        this.h = new TrackGroup(formatArr);
        int[] iArr = new int[uriArr.length];
        for (int i2 = 0; i2 < uriArr.length; i2++) {
            iArr[i2] = i2;
        }
        this.p = new c(this.h, iArr);
    }

    public MediaChunkIterator[] a(@Nullable f fVar, long j2) {
        int indexOf = fVar == null ? -1 : this.h.indexOf(fVar.trackFormat);
        int length = this.p.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        for (int i2 = 0; i2 < length; i2++) {
            int indexInTrackGroup = this.p.getIndexInTrackGroup(i2);
            Uri uri = this.e[indexInTrackGroup];
            if (!this.g.isSnapshotValid(uri)) {
                mediaChunkIteratorArr[i2] = MediaChunkIterator.EMPTY;
            } else {
                HlsMediaPlaylist playlistSnapshot = this.g.getPlaylistSnapshot(uri, false);
                Assertions.checkNotNull(playlistSnapshot);
                long initialStartTimeUs = playlistSnapshot.startTimeUs - this.g.getInitialStartTimeUs();
                long b2 = b(fVar, indexInTrackGroup != indexOf, playlistSnapshot, initialStartTimeUs, j2);
                long j3 = playlistSnapshot.mediaSequence;
                if (b2 < j3) {
                    mediaChunkIteratorArr[i2] = MediaChunkIterator.EMPTY;
                } else {
                    mediaChunkIteratorArr[i2] = new b(playlistSnapshot, initialStartTimeUs, (int) (b2 - j3));
                }
            }
        }
        return mediaChunkIteratorArr;
    }

    public final long b(@Nullable f fVar, boolean z, HlsMediaPlaylist hlsMediaPlaylist, long j2, long j3) {
        long j4;
        long j5;
        if (fVar != null && !z) {
            return fVar.getNextChunkIndex();
        }
        long j6 = hlsMediaPlaylist.durationUs + j2;
        if (fVar != null && !this.o) {
            j3 = fVar.startTimeUs;
        }
        if (hlsMediaPlaylist.hasEndTag || j3 < j6) {
            j5 = (long) Util.binarySearchFloor((List<? extends Comparable<? super Long>>) hlsMediaPlaylist.segments, Long.valueOf(j3 - j2), true, !this.g.isLive() || fVar == null);
            j4 = hlsMediaPlaylist.mediaSequence;
        } else {
            j5 = hlsMediaPlaylist.mediaSequence;
            j4 = (long) hlsMediaPlaylist.segments.size();
        }
        return j5 + j4;
    }

    @Nullable
    public final Chunk c(@Nullable Uri uri, int i2) {
        if (uri == null) {
            return null;
        }
        byte[] remove = this.j.a.remove(Assertions.checkNotNull(uri));
        if (remove != null) {
            this.j.a(uri, remove);
            return null;
        }
        return new a(this.c, new DataSpec(uri, 0, -1, null, 1), this.f[i2], this.p.getSelectionReason(), this.p.getSelectionData(), this.l);
    }
}
