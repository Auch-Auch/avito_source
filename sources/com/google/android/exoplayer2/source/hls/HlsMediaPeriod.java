package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
public final class HlsMediaPeriod implements MediaPeriod, HlsSampleStreamWrapper.Callback, HlsPlaylistTracker.PlaylistEventListener {
    public final HlsExtractorFactory a;
    public final HlsPlaylistTracker b;
    public final HlsDataSourceFactory c;
    @Nullable
    public final TransferListener d;
    public final DrmSessionManager<?> e;
    public final LoadErrorHandlingPolicy f;
    public final MediaSourceEventListener.EventDispatcher g;
    public final Allocator h;
    public final IdentityHashMap<SampleStream, Integer> i = new IdentityHashMap<>();
    public final TimestampAdjusterProvider j = new TimestampAdjusterProvider();
    public final CompositeSequenceableLoaderFactory k;
    public final boolean l;
    public final int m;
    public final boolean n;
    @Nullable
    public MediaPeriod.Callback o;
    public int p;
    public TrackGroupArray q;
    public HlsSampleStreamWrapper[] r = new HlsSampleStreamWrapper[0];
    public HlsSampleStreamWrapper[] s = new HlsSampleStreamWrapper[0];
    public int[][] t = new int[0][];
    public SequenceableLoader u;
    public boolean v;

    public HlsMediaPeriod(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, @Nullable TransferListener transferListener, DrmSessionManager<?> drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, boolean z, int i2, boolean z2) {
        this.a = hlsExtractorFactory;
        this.b = hlsPlaylistTracker;
        this.c = hlsDataSourceFactory;
        this.d = transferListener;
        this.e = drmSessionManager;
        this.f = loadErrorHandlingPolicy;
        this.g = eventDispatcher;
        this.h = allocator;
        this.k = compositeSequenceableLoaderFactory;
        this.l = z;
        this.m = i2;
        this.n = z2;
        this.u = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(new SequenceableLoader[0]);
        eventDispatcher.mediaPeriodCreated();
    }

    public static Format d(Format format, @Nullable Format format2, boolean z) {
        String str;
        int i2;
        int i3;
        int i4;
        Metadata metadata;
        String str2;
        String str3;
        if (format2 != null) {
            String str4 = format2.codecs;
            Metadata metadata2 = format2.metadata;
            int i5 = format2.channelCount;
            int i6 = format2.selectionFlags;
            int i7 = format2.roleFlags;
            String str5 = format2.language;
            str3 = format2.label;
            str2 = str4;
            metadata = metadata2;
            i4 = i5;
            i3 = i6;
            i2 = i7;
            str = str5;
        } else {
            String codecsOfType = Util.getCodecsOfType(format.codecs, 1);
            Metadata metadata3 = format.metadata;
            if (z) {
                int i8 = format.channelCount;
                str2 = codecsOfType;
                i4 = i8;
                i3 = format.selectionFlags;
                metadata = metadata3;
                i2 = format.roleFlags;
                str = format.language;
                str3 = format.label;
            } else {
                str2 = codecsOfType;
                str3 = null;
                str = null;
                metadata = metadata3;
                i4 = -1;
                i3 = 0;
                i2 = 0;
            }
        }
        return Format.createAudioContainerFormat(format.id, str3, format.containerMimeType, MimeTypes.getMediaMimeType(str2), str2, metadata, z ? format.bitrate : -1, i4, -1, null, i3, i2, str);
    }

    public final void a(long j2, List<HlsMasterPlaylist.Rendition> list, List<HlsSampleStreamWrapper> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2).name;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z = true;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if (Util.areEqual(str, list.get(i3).name)) {
                        HlsMasterPlaylist.Rendition rendition = list.get(i3);
                        arrayList3.add(Integer.valueOf(i3));
                        arrayList.add(rendition.url);
                        arrayList2.add(rendition.format);
                        z &= rendition.format.codecs != null;
                    }
                }
                HlsSampleStreamWrapper c2 = c(1, (Uri[]) arrayList.toArray((Uri[]) Util.castNonNullTypeArray(new Uri[0])), (Format[]) arrayList2.toArray(new Format[0]), null, Collections.emptyList(), map, j2);
                list3.add(Util.toArray(arrayList3));
                list2.add(c2);
                if (this.l && z) {
                    c2.m(new TrackGroup[]{new TrackGroup((Format[]) arrayList2.toArray(new Format[0]))}, 0, new int[0]);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist r30, long r31, java.util.List<com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper> r33, java.util.List<int[]> r34, java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> r35) {
        /*
        // Method dump skipped, instructions count: 470
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaPeriod.b(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist, long, java.util.List, java.util.List, java.util.Map):void");
    }

    public final HlsSampleStreamWrapper c(int i2, Uri[] uriArr, Format[] formatArr, @Nullable Format format, @Nullable List<Format> list, Map<String, DrmInitData> map, long j2) {
        return new HlsSampleStreamWrapper(i2, this, new HlsChunkSource(this.a, this.b, uriArr, formatArr, this.c, this.d, this.j, list), map, this.h, j2, format, this.e, this.f, this.g, this.m);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j2) {
        if (this.q != null) {
            return this.u.continueLoading(j2);
        }
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.r;
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : hlsSampleStreamWrapperArr) {
            if (!hlsSampleStreamWrapper.A) {
                hlsSampleStreamWrapper.continueLoading(hlsSampleStreamWrapper.M);
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j2, boolean z) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.s;
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : hlsSampleStreamWrapperArr) {
            if (hlsSampleStreamWrapper.z && !hlsSampleStreamWrapper.g()) {
                int length = hlsSampleStreamWrapper.s.length;
                for (int i2 = 0; i2 < length; i2++) {
                    hlsSampleStreamWrapper.s[i2].discardTo(j2, z, hlsSampleStreamWrapper.K[i2]);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j2, SeekParameters seekParameters) {
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.u.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.u.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public List<StreamKey> getStreamKeys(List<TrackSelection> list) {
        TrackGroupArray trackGroupArray;
        int[] iArr;
        int i2;
        HlsMediaPeriod hlsMediaPeriod = this;
        HlsMasterPlaylist hlsMasterPlaylist = (HlsMasterPlaylist) Assertions.checkNotNull(hlsMediaPeriod.b.getMasterPlaylist());
        int i3 = !hlsMasterPlaylist.variants.isEmpty();
        int length = hlsMediaPeriod.r.length - hlsMasterPlaylist.subtitles.size();
        int i4 = 0;
        if (i3 != 0) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper = hlsMediaPeriod.r[0];
            iArr = hlsMediaPeriod.t[0];
            hlsSampleStreamWrapper.a();
            trackGroupArray = hlsSampleStreamWrapper.F;
            i2 = hlsSampleStreamWrapper.I;
        } else {
            iArr = new int[0];
            trackGroupArray = TrackGroupArray.EMPTY;
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        boolean z2 = false;
        for (TrackSelection trackSelection : list) {
            TrackGroup trackGroup = trackSelection.getTrackGroup();
            int indexOf = trackGroupArray.indexOf(trackGroup);
            if (indexOf == -1) {
                int i5 = i3;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = hlsMediaPeriod.r;
                    if (i5 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    }
                    HlsSampleStreamWrapper hlsSampleStreamWrapper2 = hlsSampleStreamWrapperArr[i5];
                    hlsSampleStreamWrapper2.a();
                    if (hlsSampleStreamWrapper2.F.indexOf(trackGroup) != -1) {
                        int i6 = i5 < length ? 1 : 2;
                        int[] iArr2 = hlsMediaPeriod.t[i5];
                        for (int i7 = 0; i7 < trackSelection.length(); i7++) {
                            arrayList.add(new StreamKey(i6, iArr2[trackSelection.getIndexInTrackGroup(i7)]));
                        }
                    } else {
                        i5++;
                        hlsMediaPeriod = this;
                    }
                }
            } else if (indexOf == i2) {
                for (int i8 = 0; i8 < trackSelection.length(); i8++) {
                    arrayList.add(new StreamKey(i4, iArr[trackSelection.getIndexInTrackGroup(i8)]));
                }
                z2 = true;
            } else {
                z = true;
            }
            hlsMediaPeriod = this;
            i4 = 0;
        }
        if (z && !z2) {
            int i9 = iArr[0];
            int i10 = hlsMasterPlaylist.variants.get(iArr[0]).format.bitrate;
            for (int i11 = 1; i11 < iArr.length; i11++) {
                int i12 = hlsMasterPlaylist.variants.get(iArr[i11]).format.bitrate;
                if (i12 < i10) {
                    i9 = iArr[i11];
                    i10 = i12;
                }
            }
            arrayList.add(new StreamKey(0, i9));
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return (TrackGroupArray) Assertions.checkNotNull(this.q);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.u.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.r;
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : hlsSampleStreamWrapperArr) {
            hlsSampleStreamWrapper.i();
            if (hlsSampleStreamWrapper.Q && !hlsSampleStreamWrapper.A) {
                throw new ParserException("Loading finished before preparation is complete.");
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public void onPlaylistChanged() {
        this.o.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public boolean onPlaylistError(Uri uri, long j2) {
        boolean z;
        int indexOf;
        boolean z2 = true;
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.r) {
            HlsChunkSource hlsChunkSource = hlsSampleStreamWrapper.c;
            int i2 = 0;
            while (true) {
                Uri[] uriArr = hlsChunkSource.e;
                if (i2 >= uriArr.length) {
                    i2 = -1;
                    break;
                } else if (uriArr[i2].equals(uri)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!(i2 == -1 || (indexOf = hlsChunkSource.p.indexOf(i2)) == -1)) {
                hlsChunkSource.r |= uri.equals(hlsChunkSource.n);
                if (j2 != C.TIME_UNSET && !hlsChunkSource.p.blacklist(indexOf, j2)) {
                    z = false;
                    z2 &= z;
                }
            }
            z = true;
            z2 &= z;
        }
        this.o.onContinueLoadingRequested(this);
        return z2;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
    public void onPlaylistRefreshRequired(Uri uri) {
        this.b.refreshPlaylist(uri);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
    public void onPrepared() {
        int i2 = this.p - 1;
        this.p = i2;
        if (i2 <= 0) {
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.r;
            int i3 = 0;
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper : hlsSampleStreamWrapperArr) {
                hlsSampleStreamWrapper.a();
                i3 += hlsSampleStreamWrapper.F.length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i3];
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.r;
            int i4 = 0;
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper2 : hlsSampleStreamWrapperArr2) {
                hlsSampleStreamWrapper2.a();
                int i5 = hlsSampleStreamWrapper2.F.length;
                int i6 = 0;
                while (i6 < i5) {
                    hlsSampleStreamWrapper2.a();
                    trackGroupArr[i4] = hlsSampleStreamWrapper2.F.get(i6);
                    i6++;
                    i4++;
                }
            }
            this.q = new TrackGroupArray(trackGroupArr);
            this.o.onPrepared(this);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0062 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$PlaylistEventListener, com.google.android.exoplayer2.source.hls.HlsMediaPeriod] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.HashMap] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback r19, long r20) {
        /*
        // Method dump skipped, instructions count: 279
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaPeriod.prepare(com.google.android.exoplayer2.source.MediaPeriod$Callback, long):void");
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (this.v) {
            return C.TIME_UNSET;
        }
        this.g.readingStarted();
        this.v = true;
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j2) {
        this.u.reevaluateBuffer(j2);
    }

    public void release() {
        this.b.removeListener(this);
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.r;
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : hlsSampleStreamWrapperArr) {
            if (hlsSampleStreamWrapper.A) {
                for (HlsSampleStreamWrapper.b bVar : hlsSampleStreamWrapper.s) {
                    bVar.preRelease();
                }
            }
            hlsSampleStreamWrapper.h.release(hlsSampleStreamWrapper);
            hlsSampleStreamWrapper.p.removeCallbacksAndMessages(null);
            hlsSampleStreamWrapper.E = true;
            hlsSampleStreamWrapper.q.clear();
        }
        this.o = null;
        this.g.mediaPeriodReleased();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j2) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.s;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean p2 = hlsSampleStreamWrapperArr[0].p(j2, false);
            int i2 = 1;
            while (true) {
                HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.s;
                if (i2 >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i2].p(j2, p2);
                i2++;
            }
            if (p2) {
                this.j.reset();
            }
        }
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x025e  */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] r37, boolean[] r38, com.google.android.exoplayer2.source.SampleStream[] r39, boolean[] r40, long r41) {
        /*
        // Method dump skipped, instructions count: 812
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaPeriod.selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long):long");
    }

    public void onContinueLoadingRequested(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.o.onContinueLoadingRequested(this);
    }
}
