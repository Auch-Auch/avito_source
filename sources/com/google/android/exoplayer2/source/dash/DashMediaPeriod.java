package com.google.android.exoplayer2.source.dash;

import a2.b.a.a.a;
import a2.j.b.b.z0.v.c;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Descriptor;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public final class DashMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>>, ChunkSampleStream.ReleaseCallback<DashChunkSource> {
    public static final Pattern w = Pattern.compile("CC([1-4])=(.+)");
    public final int a;
    public final DashChunkSource.Factory b;
    @Nullable
    public final TransferListener c;
    public final DrmSessionManager<?> d;
    public final LoadErrorHandlingPolicy e;
    public final long f;
    public final LoaderErrorThrower g;
    public final Allocator h;
    public final TrackGroupArray i;
    public final TrackGroupInfo[] j;
    public final CompositeSequenceableLoaderFactory k;
    public final PlayerEmsgHandler l;
    public final IdentityHashMap<ChunkSampleStream<DashChunkSource>, PlayerEmsgHandler.PlayerTrackEmsgHandler> m = new IdentityHashMap<>();
    public final MediaSourceEventListener.EventDispatcher n;
    @Nullable
    public MediaPeriod.Callback o;
    public ChunkSampleStream<DashChunkSource>[] p = new ChunkSampleStream[0];
    public c[] q = new c[0];
    public SequenceableLoader r;
    public DashManifest s;
    public int t;
    public List<EventStream> u;
    public boolean v;

    public static final class TrackGroupInfo {
        public final int[] a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface TrackGroupCategory {
        }

        public TrackGroupInfo(int i, int i2, int[] iArr, int i3, int i4, int i5, int i6) {
            this.b = i;
            this.a = iArr;
            this.c = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.d = i6;
        }
    }

    public DashMediaPeriod(int i2, DashManifest dashManifest, int i3, DashChunkSource.Factory factory, @Nullable TransferListener transferListener, DrmSessionManager<?> drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, long j2, LoaderErrorThrower loaderErrorThrower, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback) {
        boolean z;
        Format[] formatArr;
        Format[] formatArr2;
        this.a = i2;
        this.s = dashManifest;
        this.t = i3;
        this.b = factory;
        this.c = transferListener;
        this.d = drmSessionManager;
        this.e = loadErrorHandlingPolicy;
        this.n = eventDispatcher;
        this.f = j2;
        this.g = loaderErrorThrower;
        this.h = allocator;
        this.k = compositeSequenceableLoaderFactory;
        this.l = new PlayerEmsgHandler(dashManifest, playerEmsgCallback, allocator);
        this.r = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.p);
        Period period = dashManifest.getPeriod(i3);
        List<EventStream> list = period.eventStreams;
        this.u = list;
        List<AdaptationSet> list2 = period.adaptationSets;
        int[][] f2 = f(list2);
        int length = f2.length;
        boolean[] zArr = new boolean[length];
        Format[][] formatArr3 = new Format[length][];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int[] iArr = f2[i5];
            int length2 = iArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length2) {
                    z = false;
                    break;
                }
                List<Representation> list3 = list2.get(iArr[i6]).representations;
                for (int i7 = 0; i7 < list3.size(); i7++) {
                    if (!list3.get(i7).inbandEventStreams.isEmpty()) {
                        z = true;
                        break;
                    }
                }
                i6++;
            }
            if (z) {
                zArr[i5] = true;
                i4++;
            }
            int[] iArr2 = f2[i5];
            int length3 = iArr2.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length3) {
                    formatArr = new Format[0];
                    break;
                }
                int i9 = iArr2[i8];
                AdaptationSet adaptationSet = list2.get(i9);
                List<Descriptor> list4 = list2.get(i9).accessibilityDescriptors;
                int i10 = 0;
                while (i10 < list4.size()) {
                    Descriptor descriptor = list4.get(i10);
                    if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri)) {
                        String str = descriptor.value;
                        String str2 = null;
                        if (str != null) {
                            String[] split = Util.split(str, ";");
                            formatArr = new Format[split.length];
                            int i11 = 0;
                            while (true) {
                                if (i11 >= split.length) {
                                    break;
                                }
                                Matcher matcher = w.matcher(split[i11]);
                                if (!matcher.matches()) {
                                    formatArr2 = new Format[]{a(adaptationSet.id, str2, -1)};
                                    break;
                                }
                                formatArr[i11] = a(adaptationSet.id, matcher.group(2), Integer.parseInt(matcher.group(1)));
                                i11++;
                                split = split;
                                str2 = null;
                            }
                        } else {
                            formatArr2 = new Format[]{a(adaptationSet.id, null, -1)};
                        }
                        formatArr = formatArr2;
                    } else {
                        i10++;
                        length3 = length3;
                    }
                }
                i8++;
                iArr2 = iArr2;
            }
            formatArr3[i5] = formatArr;
            if (formatArr3[i5].length != 0) {
                i4++;
            }
        }
        int size = list.size() + i4 + length;
        TrackGroup[] trackGroupArr = new TrackGroup[size];
        TrackGroupInfo[] trackGroupInfoArr = new TrackGroupInfo[size];
        b(list, trackGroupArr, trackGroupInfoArr, c(drmSessionManager, list2, f2, length, zArr, formatArr3, trackGroupArr, trackGroupInfoArr));
        Pair create = Pair.create(new TrackGroupArray(trackGroupArr), trackGroupInfoArr);
        this.i = (TrackGroupArray) create.first;
        this.j = (TrackGroupInfo[]) create.second;
        eventDispatcher.mediaPeriodCreated();
    }

    public static Format a(int i2, String str, int i3) {
        String m2 = i3 != -1 ? a.m2(12, ":", i3) : "";
        StringBuilder sb = new StringBuilder(a.q0(m2, 18));
        sb.append(i2);
        sb.append(":cea608");
        sb.append(m2);
        return Format.createTextSampleFormat(sb.toString(), MimeTypes.APPLICATION_CEA608, null, -1, 0, str, i3, null, Long.MAX_VALUE, null);
    }

    public static void b(List<EventStream> list, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr, int i2) {
        int i3 = 0;
        while (i3 < list.size()) {
            trackGroupArr[i2] = new TrackGroup(Format.createSampleFormat(list.get(i3).id(), MimeTypes.APPLICATION_EMSG, null, -1, null));
            trackGroupInfoArr[i2] = new TrackGroupInfo(4, 2, new int[0], -1, -1, -1, i3);
            i3++;
            i2++;
        }
    }

    public static int c(DrmSessionManager<?> drmSessionManager, List<AdaptationSet> list, int[][] iArr, int i2, boolean[] zArr, Format[][] formatArr, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr) {
        int i3;
        int i4;
        int i5;
        List<AdaptationSet> list2 = list;
        char c2 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i2) {
            int[] iArr2 = iArr[i6];
            ArrayList arrayList = new ArrayList();
            for (int i8 : iArr2) {
                arrayList.addAll(list2.get(i8).representations);
            }
            int size = arrayList.size();
            Format[] formatArr2 = new Format[size];
            for (int i9 = 0; i9 < size; i9++) {
                Format format = ((Representation) arrayList.get(i9)).format;
                DrmInitData drmInitData = format.drmInitData;
                if (drmInitData != null) {
                    format = format.copyWithExoMediaCryptoType(drmSessionManager.getExoMediaCryptoType(drmInitData));
                }
                formatArr2[i9] = format;
            }
            AdaptationSet adaptationSet = list2.get(iArr2[c2]);
            int i10 = i7 + 1;
            if (zArr[i6]) {
                i3 = i10;
                i10++;
            } else {
                i3 = -1;
            }
            if (formatArr[i6].length != 0) {
                i5 = i10;
                i4 = i10 + 1;
            } else {
                i4 = i10;
                i5 = -1;
            }
            trackGroupArr[i7] = new TrackGroup(formatArr2);
            trackGroupInfoArr[i7] = new TrackGroupInfo(adaptationSet.type, 0, iArr2, i7, i3, i5, -1);
            if (i3 != -1) {
                int i11 = adaptationSet.id;
                StringBuilder sb = new StringBuilder(16);
                sb.append(i11);
                sb.append(":emsg");
                trackGroupArr[i3] = new TrackGroup(Format.createSampleFormat(sb.toString(), MimeTypes.APPLICATION_EMSG, null, -1, null));
                trackGroupInfoArr[i3] = new TrackGroupInfo(4, 1, iArr2, i7, -1, -1, -1);
            }
            if (i5 != -1) {
                trackGroupArr[i5] = new TrackGroup(formatArr[i6]);
                trackGroupInfoArr[i5] = new TrackGroupInfo(3, 1, iArr2, i7, -1, -1, -1);
            }
            i6++;
            list2 = list;
            i7 = i4;
            c2 = 0;
        }
        return i7;
    }

    @Nullable
    public static Descriptor e(List<Descriptor> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if (str.equals(descriptor.schemeIdUri)) {
                return descriptor;
            }
        }
        return null;
    }

    public static int[][] f(List<AdaptationSet> list) {
        int i2;
        Descriptor e2;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i3 = 0; i3 < size; i3++) {
            sparseIntArray.put(list.get(i3).id, i3);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i3));
            arrayList.add(arrayList2);
            sparseArray.put(i3, arrayList2);
        }
        for (int i4 = 0; i4 < size; i4++) {
            AdaptationSet adaptationSet = list.get(i4);
            Descriptor e3 = e(adaptationSet.essentialProperties, "http://dashif.org/guidelines/trickmode");
            if (e3 == null) {
                e3 = e(adaptationSet.supplementalProperties, "http://dashif.org/guidelines/trickmode");
            }
            if (e3 == null || (i2 = sparseIntArray.get(Integer.parseInt(e3.value), -1)) == -1) {
                i2 = i4;
            }
            if (i2 == i4 && (e2 = e(adaptationSet.supplementalProperties, "urn:mpeg:dash:adaptation-set-switching:2016")) != null) {
                for (String str : Util.split(e2.value, ",")) {
                    int i5 = sparseIntArray.get(Integer.parseInt(str), -1);
                    if (i5 != -1) {
                        i2 = Math.min(i2, i5);
                    }
                }
            }
            if (i2 != i4) {
                List list2 = (List) sparseArray.get(i4);
                List list3 = (List) sparseArray.get(i2);
                list3.addAll(list2);
                sparseArray.put(i4, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i6 = 0; i6 < size2; i6++) {
            iArr[i6] = Util.toArray((List) arrayList.get(i6));
            Arrays.sort(iArr[i6]);
        }
        return iArr;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j2) {
        return this.r.continueLoading(j2);
    }

    public final ChunkSampleStream<DashChunkSource> d(TrackGroupInfo trackGroupInfo, TrackSelection trackSelection, long j2) {
        int i2;
        TrackGroup trackGroup;
        TrackGroup trackGroup2;
        int i3;
        int i4 = trackGroupInfo.f;
        boolean z = i4 != -1;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = null;
        if (z) {
            trackGroup = this.i.get(i4);
            i2 = 1;
        } else {
            trackGroup = null;
            i2 = 0;
        }
        int i5 = trackGroupInfo.g;
        boolean z2 = i5 != -1;
        if (z2) {
            trackGroup2 = this.i.get(i5);
            i2 += trackGroup2.length;
        } else {
            trackGroup2 = null;
        }
        Format[] formatArr = new Format[i2];
        int[] iArr = new int[i2];
        if (z) {
            formatArr[0] = trackGroup.getFormat(0);
            iArr[0] = 4;
            i3 = 1;
        } else {
            i3 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            for (int i6 = 0; i6 < trackGroup2.length; i6++) {
                formatArr[i3] = trackGroup2.getFormat(i6);
                iArr[i3] = 3;
                arrayList.add(formatArr[i3]);
                i3++;
            }
        }
        if (this.s.dynamic && z) {
            playerTrackEmsgHandler = this.l.newPlayerTrackEmsgHandler();
        }
        ChunkSampleStream<DashChunkSource> chunkSampleStream = new ChunkSampleStream<>(trackGroupInfo.b, iArr, formatArr, this.b.createDashChunkSource(this.g, this.s, this.t, trackGroupInfo.a, trackSelection, trackGroupInfo.b, this.f, z, arrayList, playerTrackEmsgHandler, this.c), this, this.h, j2, this.d, this.e, this.n);
        synchronized (this) {
            this.m.put(chunkSampleStream, playerTrackEmsgHandler);
        }
        return chunkSampleStream;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j2, boolean z) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.p) {
            chunkSampleStream.discardBuffer(j2, z);
        }
    }

    public final int g(int i2, int[] iArr) {
        int i3 = iArr[i2];
        if (i3 == -1) {
            return -1;
        }
        int i4 = this.j[i3].e;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int i6 = iArr[i5];
            if (i6 == i4 && this.j[i6].c == 0) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j2, SeekParameters seekParameters) {
        ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArr = this.p;
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : chunkSampleStreamArr) {
            if (chunkSampleStream.primaryTrackType == 2) {
                return chunkSampleStream.getAdjustedSeekPositionUs(j2, seekParameters);
            }
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.r.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.r.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public List<StreamKey> getStreamKeys(List<TrackSelection> list) {
        List<AdaptationSet> list2 = this.s.getPeriod(this.t).adaptationSets;
        ArrayList arrayList = new ArrayList();
        for (TrackSelection trackSelection : list) {
            TrackGroupInfo trackGroupInfo = this.j[this.i.indexOf(trackSelection.getTrackGroup())];
            if (trackGroupInfo.c == 0) {
                int[] iArr = trackGroupInfo.a;
                int length = trackSelection.length();
                int[] iArr2 = new int[length];
                for (int i2 = 0; i2 < trackSelection.length(); i2++) {
                    iArr2[i2] = trackSelection.getIndexInTrackGroup(i2);
                }
                Arrays.sort(iArr2);
                int size = list2.get(iArr[0]).representations.size();
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < length; i5++) {
                    int i6 = iArr2[i5];
                    while (true) {
                        int i7 = i4 + size;
                        if (i6 < i7) {
                            break;
                        }
                        i3++;
                        size = list2.get(iArr[i3]).representations.size();
                        i4 = i7;
                    }
                    arrayList.add(new StreamKey(this.t, iArr[i3], i6 - i4));
                }
            }
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.i;
    }

    public void h() {
        this.l.release();
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.p) {
            chunkSampleStream.release(this);
        }
        this.o = null;
        this.n.mediaPeriodReleased();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.r.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        this.g.maybeThrowError();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.source.SequenceableLoader] */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        this.o.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback
    public synchronized void onSampleStreamReleased(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        PlayerEmsgHandler.PlayerTrackEmsgHandler remove = this.m.remove(chunkSampleStream);
        if (remove != null) {
            remove.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j2) {
        this.o = callback;
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (this.v) {
            return C.TIME_UNSET;
        }
        this.n.readingStarted();
        this.v = true;
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j2) {
        this.r.reevaluateBuffer(j2);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j2) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.p) {
            chunkSampleStream.seekToUs(j2);
        }
        for (c cVar : this.q) {
            cVar.a(j2);
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        int[] iArr = new int[trackSelectionArr.length];
        for (int i2 = 0; i2 < trackSelectionArr.length; i2++) {
            if (trackSelectionArr[i2] != null) {
                iArr[i2] = this.i.indexOf(trackSelectionArr[i2].getTrackGroup());
            } else {
                iArr[i2] = -1;
            }
        }
        for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
            if (trackSelectionArr[i3] == null || !zArr[i3]) {
                if (sampleStreamArr[i3] instanceof ChunkSampleStream) {
                    ((ChunkSampleStream) sampleStreamArr[i3]).release(this);
                } else if (sampleStreamArr[i3] instanceof ChunkSampleStream.EmbeddedSampleStream) {
                    ((ChunkSampleStream.EmbeddedSampleStream) sampleStreamArr[i3]).release();
                }
                sampleStreamArr[i3] = null;
            }
        }
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i4 >= trackSelectionArr.length) {
                break;
            }
            if ((sampleStreamArr[i4] instanceof EmptySampleStream) || (sampleStreamArr[i4] instanceof ChunkSampleStream.EmbeddedSampleStream)) {
                int g2 = g(i4, iArr);
                if (g2 == -1) {
                    z = sampleStreamArr[i4] instanceof EmptySampleStream;
                } else if (!(sampleStreamArr[i4] instanceof ChunkSampleStream.EmbeddedSampleStream) || ((ChunkSampleStream.EmbeddedSampleStream) sampleStreamArr[i4]).parent != sampleStreamArr[g2]) {
                    z = false;
                }
                if (!z) {
                    if (sampleStreamArr[i4] instanceof ChunkSampleStream.EmbeddedSampleStream) {
                        ((ChunkSampleStream.EmbeddedSampleStream) sampleStreamArr[i4]).release();
                    }
                    sampleStreamArr[i4] = null;
                }
            }
            i4++;
        }
        for (int i5 = 0; i5 < trackSelectionArr.length; i5++) {
            TrackSelection trackSelection = trackSelectionArr[i5];
            if (trackSelection != null) {
                if (sampleStreamArr[i5] == null) {
                    zArr2[i5] = true;
                    TrackGroupInfo trackGroupInfo = this.j[iArr[i5]];
                    int i6 = trackGroupInfo.c;
                    if (i6 == 0) {
                        sampleStreamArr[i5] = d(trackGroupInfo, trackSelection, j2);
                    } else if (i6 == 2) {
                        sampleStreamArr[i5] = new c(this.u.get(trackGroupInfo.d), trackSelection.getTrackGroup().getFormat(0), this.s.dynamic);
                    }
                } else if (sampleStreamArr[i5] instanceof ChunkSampleStream) {
                    ((DashChunkSource) ((ChunkSampleStream) sampleStreamArr[i5]).getChunkSource()).updateTrackSelection(trackSelection);
                }
            }
        }
        for (int i7 = 0; i7 < trackSelectionArr.length; i7++) {
            if (sampleStreamArr[i7] == null && trackSelectionArr[i7] != null) {
                TrackGroupInfo trackGroupInfo2 = this.j[iArr[i7]];
                if (trackGroupInfo2.c == 1) {
                    int g3 = g(i7, iArr);
                    if (g3 == -1) {
                        sampleStreamArr[i7] = new EmptySampleStream();
                    } else {
                        sampleStreamArr[i7] = ((ChunkSampleStream) sampleStreamArr[g3]).selectEmbeddedTrack(j2, trackGroupInfo2.b);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SampleStream sampleStream : sampleStreamArr) {
            if (sampleStream instanceof ChunkSampleStream) {
                arrayList.add((ChunkSampleStream) sampleStream);
            } else if (sampleStream instanceof c) {
                arrayList2.add((c) sampleStream);
            }
        }
        ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArr = new ChunkSampleStream[arrayList.size()];
        this.p = chunkSampleStreamArr;
        arrayList.toArray(chunkSampleStreamArr);
        c[] cVarArr = new c[arrayList2.size()];
        this.q = cVarArr;
        arrayList2.toArray(cVarArr);
        this.r = this.k.createCompositeSequenceableLoader(this.p);
        return j2;
    }
}
