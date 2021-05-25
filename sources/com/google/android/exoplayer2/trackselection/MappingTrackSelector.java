package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
public abstract class MappingTrackSelector extends TrackSelector {
    @Nullable
    public MappedTrackInfo c;

    @Nullable
    public final MappedTrackInfo getCurrentMappedTrackInfo() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final void onSelectionActivated(@Nullable Object obj) {
        this.c = (MappedTrackInfo) obj;
    }

    public abstract Pair<RendererConfiguration[], TrackSelection[]> selectTracks(MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2) throws ExoPlaybackException;

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        int[] iArr;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        int[] iArr2 = new int[(rendererCapabilitiesArr.length + 1)];
        int length = rendererCapabilitiesArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr3 = new int[(rendererCapabilitiesArr.length + 1)][][];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = trackGroupArray2.length;
            trackGroupArr[i2] = new TrackGroup[i3];
            iArr3[i2] = new int[i3][];
        }
        int length2 = rendererCapabilitiesArr.length;
        int[] iArr4 = new int[length2];
        for (int i4 = 0; i4 < length2; i4++) {
            iArr4[i4] = rendererCapabilitiesArr[i4].supportsMixedMimeTypeAdaptation();
        }
        int i5 = 0;
        while (i5 < trackGroupArray2.length) {
            TrackGroup trackGroup = trackGroupArray2.get(i5);
            boolean z = MimeTypes.getTrackType(trackGroup.getFormat(i).sampleMimeType) == 4;
            int length3 = rendererCapabilitiesArr.length;
            int i6 = 0;
            int i7 = 0;
            boolean z2 = true;
            while (i6 < rendererCapabilitiesArr.length) {
                RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i6];
                int i8 = 0;
                while (i < trackGroup.length) {
                    i8 = Math.max(i8, rendererCapabilities.supportsFormat(trackGroup.getFormat(i)) & 7);
                    i++;
                }
                boolean z3 = iArr2[i6] == 0;
                if (i8 > i7 || (i8 == i7 && z && !z2 && z3)) {
                    z2 = z3;
                    i7 = i8;
                    length3 = i6;
                }
                i6++;
                i = 0;
            }
            if (length3 == rendererCapabilitiesArr.length) {
                iArr = new int[trackGroup.length];
            } else {
                RendererCapabilities rendererCapabilities2 = rendererCapabilitiesArr[length3];
                int[] iArr5 = new int[trackGroup.length];
                for (int i9 = 0; i9 < trackGroup.length; i9++) {
                    iArr5[i9] = rendererCapabilities2.supportsFormat(trackGroup.getFormat(i9));
                }
                iArr = iArr5;
            }
            int i10 = iArr2[length3];
            trackGroupArr[length3][i10] = trackGroup;
            iArr3[length3][i10] = iArr;
            iArr2[length3] = iArr2[length3] + 1;
            i5++;
            trackGroupArray2 = trackGroupArray;
            i = 0;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr.length];
        String[] strArr = new String[rendererCapabilitiesArr.length];
        int[] iArr6 = new int[rendererCapabilitiesArr.length];
        for (int i11 = 0; i11 < rendererCapabilitiesArr.length; i11++) {
            int i12 = iArr2[i11];
            trackGroupArrayArr[i11] = new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[i11], i12));
            iArr3[i11] = (int[][]) Util.nullSafeArrayCopy(iArr3[i11], i12);
            strArr[i11] = rendererCapabilitiesArr[i11].getName();
            iArr6[i11] = rendererCapabilitiesArr[i11].getTrackType();
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(strArr, iArr6, trackGroupArrayArr, iArr4, iArr3, new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[rendererCapabilitiesArr.length], iArr2[rendererCapabilitiesArr.length])));
        Pair<RendererConfiguration[], TrackSelection[]> selectTracks = selectTracks(mappedTrackInfo, iArr3, iArr4);
        return new TrackSelectorResult((RendererConfiguration[]) selectTracks.first, (TrackSelection[]) selectTracks.second, mappedTrackInfo);
    }

    public static final class MappedTrackInfo {
        public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
        public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
        public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
        public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;
        public final int a;
        public final String[] b;
        public final int[] c;
        public final TrackGroupArray[] d;
        public final int[] e;
        public final int[][][] f;
        public final TrackGroupArray g;
        @Deprecated
        public final int length;

        public MappedTrackInfo(String[] strArr, int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.b = strArr;
            this.c = iArr;
            this.d = trackGroupArrayArr;
            this.f = iArr3;
            this.e = iArr2;
            this.g = trackGroupArray;
            int length2 = iArr.length;
            this.a = length2;
            this.length = length2;
        }

        public int getAdaptiveSupport(int i, int i2, boolean z) {
            int i3 = this.d[i].get(i2).length;
            int[] iArr = new int[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int trackSupport = getTrackSupport(i, i2, i5);
                if (trackSupport == 4 || (z && trackSupport == 3)) {
                    iArr[i4] = i5;
                    i4++;
                }
            }
            return getAdaptiveSupport(i, i2, Arrays.copyOf(iArr, i4));
        }

        public int getRendererCount() {
            return this.a;
        }

        public String getRendererName(int i) {
            return this.b[i];
        }

        public int getRendererSupport(int i) {
            int[][] iArr = this.f[i];
            int i2 = 0;
            for (int[] iArr2 : iArr) {
                for (int i3 : iArr2) {
                    int i4 = i3 & 7;
                    int i5 = 2;
                    if (i4 == 0 || i4 == 1 || i4 == 2) {
                        i5 = 1;
                    } else if (i4 != 3) {
                        if (i4 == 4) {
                            return 3;
                        }
                        throw new IllegalStateException();
                    }
                    i2 = Math.max(i2, i5);
                }
            }
            return i2;
        }

        public int getRendererType(int i) {
            return this.c[i];
        }

        @Deprecated
        public int getTrackFormatSupport(int i, int i2, int i3) {
            return getTrackSupport(i, i2, i3);
        }

        public TrackGroupArray getTrackGroups(int i) {
            return this.d[i];
        }

        public int getTrackSupport(int i, int i2, int i3) {
            return this.f[i][i2][i3] & 7;
        }

        @Deprecated
        public int getTrackTypeRendererSupport(int i) {
            return getTypeSupport(i);
        }

        public int getTypeSupport(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.a; i3++) {
                if (this.c[i3] == i) {
                    i2 = Math.max(i2, getRendererSupport(i3));
                }
            }
            return i2;
        }

        @Deprecated
        public TrackGroupArray getUnassociatedTrackGroups() {
            return getUnmappedTrackGroups();
        }

        public TrackGroupArray getUnmappedTrackGroups() {
            return this.g;
        }

        public int getAdaptiveSupport(int i, int i2, int[] iArr) {
            int i3 = 0;
            String str = null;
            boolean z = false;
            int i4 = 0;
            int i5 = 16;
            while (i3 < iArr.length) {
                String str2 = this.d[i].get(i2).getFormat(iArr[i3]).sampleMimeType;
                int i6 = i4 + 1;
                if (i4 == 0) {
                    str = str2;
                } else {
                    z |= !Util.areEqual(str, str2);
                }
                i5 = Math.min(i5, this.f[i][i2][i3] & 24);
                i3++;
                i4 = i6;
            }
            return z ? Math.min(i5, this.e[i]) : i5;
        }
    }
}
