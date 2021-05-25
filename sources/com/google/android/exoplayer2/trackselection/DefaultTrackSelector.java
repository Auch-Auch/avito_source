package com.google.android.exoplayer2.trackselection;

import a2.j.b.b.b1.b;
import a2.j.b.b.b1.c;
import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
public class DefaultTrackSelector extends MappingTrackSelector {
    public static final int[] g = new int[0];
    public static final Ordering<Integer> h = Ordering.from(c.a);
    public static final Ordering<Integer> i = Ordering.from(b.a);
    public final TrackSelection.Factory d;
    public final AtomicReference<Parameters> e;
    public boolean f;

    public static final class AudioTrackScore implements Comparable<AudioTrackScore> {
        @Nullable
        public final String a;
        public final Parameters b;
        public final boolean c;
        public final int d;
        public final int e;
        public final int f;
        public final boolean g;
        public final int h;
        public final int i;
        public final boolean isWithinConstraints;
        public final int j;

        public AudioTrackScore(Format format, Parameters parameters, int i2) {
            this.b = parameters;
            this.a = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(format.language);
            int i3 = 0;
            this.c = DefaultTrackSelector.isSupported(i2, false);
            this.d = DefaultTrackSelector.getFormatLanguageScore(format, parameters.preferredAudioLanguage, false);
            boolean z = true;
            this.g = (format.selectionFlags & 1) != 0;
            int i4 = format.channelCount;
            this.h = i4;
            this.i = format.sampleRate;
            int i5 = format.bitrate;
            this.j = i5;
            if ((i5 != -1 && i5 > parameters.maxAudioBitrate) || (i4 != -1 && i4 > parameters.maxAudioChannelCount)) {
                z = false;
            }
            this.isWithinConstraints = z;
            String[] systemLanguageCodes = Util.getSystemLanguageCodes();
            int i6 = Integer.MAX_VALUE;
            int i7 = 0;
            while (true) {
                if (i7 >= systemLanguageCodes.length) {
                    break;
                }
                int formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, systemLanguageCodes[i7], false);
                if (formatLanguageScore > 0) {
                    i6 = i7;
                    i3 = formatLanguageScore;
                    break;
                }
                i7++;
            }
            this.e = i6;
            this.f = i3;
        }

        public int compareTo(AudioTrackScore audioTrackScore) {
            Ordering<Integer> ordering;
            Ordering<Integer> ordering2;
            if (!this.isWithinConstraints || !this.c) {
                ordering = DefaultTrackSelector.h.reverse();
            } else {
                ordering = DefaultTrackSelector.h;
            }
            ComparisonChain compareFalseFirst = ComparisonChain.start().compareFalseFirst(this.c, audioTrackScore.c).compare(this.d, audioTrackScore.d).compareFalseFirst(this.isWithinConstraints, audioTrackScore.isWithinConstraints);
            Integer valueOf = Integer.valueOf(this.j);
            Integer valueOf2 = Integer.valueOf(audioTrackScore.j);
            if (this.b.forceLowestBitrate) {
                ordering2 = DefaultTrackSelector.h.reverse();
            } else {
                ordering2 = DefaultTrackSelector.i;
            }
            ComparisonChain compare = compareFalseFirst.compare(valueOf, valueOf2, ordering2).compareFalseFirst(this.g, audioTrackScore.g).compare(Integer.valueOf(this.e), Integer.valueOf(audioTrackScore.e), Ordering.natural().reverse()).compare(this.f, audioTrackScore.f).compare(Integer.valueOf(this.h), Integer.valueOf(audioTrackScore.h), ordering).compare(Integer.valueOf(this.i), Integer.valueOf(audioTrackScore.i), ordering);
            Integer valueOf3 = Integer.valueOf(this.j);
            Integer valueOf4 = Integer.valueOf(audioTrackScore.j);
            if (!Util.areEqual(this.a, audioTrackScore.a)) {
                ordering = DefaultTrackSelector.i;
            }
            return compare.compare(valueOf3, valueOf4, ordering).result();
        }
    }

    public static final class OtherTrackScore implements Comparable<OtherTrackScore> {
        public final boolean a;
        public final boolean b;

        public OtherTrackScore(Format format, int i) {
            this.a = (format.selectionFlags & 1) == 0 ? false : true;
            this.b = DefaultTrackSelector.isSupported(i, false);
        }

        public int compareTo(OtherTrackScore otherTrackScore) {
            return ComparisonChain.start().compareFalseFirst(this.b, otherTrackScore.b).compareFalseFirst(this.a, otherTrackScore.a).result();
        }
    }

    public static final class Parameters extends TrackSelectionParameters {
        public static final Parcelable.Creator<Parameters> CREATOR = new a();
        public static final Parameters DEFAULT_WITHOUT_CONTEXT = new ParametersBuilder().build();
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> a;
        public final boolean allowAudioMixedChannelCountAdaptiveness;
        public final boolean allowAudioMixedMimeTypeAdaptiveness;
        public final boolean allowAudioMixedSampleRateAdaptiveness;
        public final boolean allowVideoMixedMimeTypeAdaptiveness;
        public final boolean allowVideoNonSeamlessAdaptiveness;
        public final SparseBooleanArray b;
        public final boolean exceedAudioConstraintsIfNecessary;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final boolean forceHighestSupportedBitrate;
        public final boolean forceLowestBitrate;
        public final int maxAudioBitrate;
        public final int maxAudioChannelCount;
        public final int maxVideoBitrate;
        public final int maxVideoFrameRate;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        public final int minVideoBitrate;
        public final int minVideoFrameRate;
        public final int minVideoHeight;
        public final int minVideoWidth;
        public final int tunnelingAudioSessionId;
        public final int viewportHeight;
        public final boolean viewportOrientationMayChange;
        public final int viewportWidth;

        public class a implements Parcelable.Creator<Parameters> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public Parameters createFromParcel(Parcel parcel) {
                return new Parameters(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public Parameters[] newArray(int i) {
                return new Parameters[i];
            }
        }

        public Parameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, boolean z2, boolean z3, int i9, int i10, boolean z4, @Nullable String str, int i11, int i12, boolean z5, boolean z7, boolean z8, boolean z9, @Nullable String str2, int i13, boolean z10, int i14, boolean z11, boolean z12, boolean z13, int i15, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseBooleanArray sparseBooleanArray) {
            super(str, str2, i13, z10, i14);
            this.maxVideoWidth = i;
            this.maxVideoHeight = i2;
            this.maxVideoFrameRate = i3;
            this.maxVideoBitrate = i4;
            this.minVideoWidth = i5;
            this.minVideoHeight = i6;
            this.minVideoFrameRate = i7;
            this.minVideoBitrate = i8;
            this.exceedVideoConstraintsIfNecessary = z;
            this.allowVideoMixedMimeTypeAdaptiveness = z2;
            this.allowVideoNonSeamlessAdaptiveness = z3;
            this.viewportWidth = i9;
            this.viewportHeight = i10;
            this.viewportOrientationMayChange = z4;
            this.maxAudioChannelCount = i11;
            this.maxAudioBitrate = i12;
            this.exceedAudioConstraintsIfNecessary = z5;
            this.allowAudioMixedMimeTypeAdaptiveness = z7;
            this.allowAudioMixedSampleRateAdaptiveness = z8;
            this.allowAudioMixedChannelCountAdaptiveness = z9;
            this.forceLowestBitrate = z11;
            this.forceHighestSupportedBitrate = z12;
            this.exceedRendererCapabilitiesIfNecessary = z13;
            this.tunnelingAudioSessionId = i15;
            this.a = sparseArray;
            this.b = sparseBooleanArray;
        }

        public static Parameters getDefaults(Context context) {
            return new ParametersBuilder(context).build();
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:67:0x00ce  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0136 A[LOOP:1: B:71:0x00df->B:86:0x0136, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x00dc A[EDGE_INSN: B:94:0x00dc->B:69:0x00dc ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, java.lang.Object
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@androidx.annotation.Nullable java.lang.Object r11) {
            /*
            // Method dump skipped, instructions count: 320
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.equals(java.lang.Object):boolean");
        }

        public final boolean getRendererDisabled(int i) {
            return this.b.get(i);
        }

        @Nullable
        public final SelectionOverride getSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            Map<TrackGroupArray, SelectionOverride> map = this.a.get(i);
            if (map != null) {
                return map.get(trackGroupArray);
            }
            return null;
        }

        public final boolean hasSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            Map<TrackGroupArray, SelectionOverride> map = this.a.get(i);
            return map != null && map.containsKey(trackGroupArray);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, java.lang.Object
        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + this.maxVideoBitrate) * 31) + this.minVideoWidth) * 31) + this.minVideoHeight) * 31) + this.minVideoFrameRate) * 31) + this.minVideoBitrate) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoNonSeamlessAdaptiveness ? 1 : 0)) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.maxAudioChannelCount) * 31) + this.maxAudioBitrate) * 31) + (this.exceedAudioConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0)) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + this.tunnelingAudioSessionId;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.maxVideoWidth);
            parcel.writeInt(this.maxVideoHeight);
            parcel.writeInt(this.maxVideoFrameRate);
            parcel.writeInt(this.maxVideoBitrate);
            parcel.writeInt(this.minVideoWidth);
            parcel.writeInt(this.minVideoHeight);
            parcel.writeInt(this.minVideoFrameRate);
            parcel.writeInt(this.minVideoBitrate);
            Util.writeBoolean(parcel, this.exceedVideoConstraintsIfNecessary);
            Util.writeBoolean(parcel, this.allowVideoMixedMimeTypeAdaptiveness);
            Util.writeBoolean(parcel, this.allowVideoNonSeamlessAdaptiveness);
            parcel.writeInt(this.viewportWidth);
            parcel.writeInt(this.viewportHeight);
            Util.writeBoolean(parcel, this.viewportOrientationMayChange);
            parcel.writeInt(this.maxAudioChannelCount);
            parcel.writeInt(this.maxAudioBitrate);
            Util.writeBoolean(parcel, this.exceedAudioConstraintsIfNecessary);
            Util.writeBoolean(parcel, this.allowAudioMixedMimeTypeAdaptiveness);
            Util.writeBoolean(parcel, this.allowAudioMixedSampleRateAdaptiveness);
            Util.writeBoolean(parcel, this.allowAudioMixedChannelCountAdaptiveness);
            Util.writeBoolean(parcel, this.forceLowestBitrate);
            Util.writeBoolean(parcel, this.forceHighestSupportedBitrate);
            Util.writeBoolean(parcel, this.exceedRendererCapabilitiesIfNecessary);
            parcel.writeInt(this.tunnelingAudioSessionId);
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = this.a;
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt = sparseArray.keyAt(i2);
                Map<TrackGroupArray, SelectionOverride> valueAt = sparseArray.valueAt(i2);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry<TrackGroupArray, SelectionOverride> entry : valueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
            }
            parcel.writeSparseBooleanArray(this.b);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public ParametersBuilder buildUpon() {
            return new ParametersBuilder(this, null);
        }

        public Parameters(Parcel parcel) {
            super(parcel);
            this.maxVideoWidth = parcel.readInt();
            this.maxVideoHeight = parcel.readInt();
            this.maxVideoFrameRate = parcel.readInt();
            this.maxVideoBitrate = parcel.readInt();
            this.minVideoWidth = parcel.readInt();
            this.minVideoHeight = parcel.readInt();
            this.minVideoFrameRate = parcel.readInt();
            this.minVideoBitrate = parcel.readInt();
            this.exceedVideoConstraintsIfNecessary = Util.readBoolean(parcel);
            this.allowVideoMixedMimeTypeAdaptiveness = Util.readBoolean(parcel);
            this.allowVideoNonSeamlessAdaptiveness = Util.readBoolean(parcel);
            this.viewportWidth = parcel.readInt();
            this.viewportHeight = parcel.readInt();
            this.viewportOrientationMayChange = Util.readBoolean(parcel);
            this.maxAudioChannelCount = parcel.readInt();
            this.maxAudioBitrate = parcel.readInt();
            this.exceedAudioConstraintsIfNecessary = Util.readBoolean(parcel);
            this.allowAudioMixedMimeTypeAdaptiveness = Util.readBoolean(parcel);
            this.allowAudioMixedSampleRateAdaptiveness = Util.readBoolean(parcel);
            this.allowAudioMixedChannelCountAdaptiveness = Util.readBoolean(parcel);
            this.forceLowestBitrate = Util.readBoolean(parcel);
            this.forceHighestSupportedBitrate = Util.readBoolean(parcel);
            this.exceedRendererCapabilitiesIfNecessary = Util.readBoolean(parcel);
            this.tunnelingAudioSessionId = parcel.readInt();
            int readInt = parcel.readInt();
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                HashMap hashMap = new HashMap(readInt3);
                for (int i2 = 0; i2 < readInt3; i2++) {
                    hashMap.put((TrackGroupArray) Assertions.checkNotNull((TrackGroupArray) parcel.readParcelable(TrackGroupArray.class.getClassLoader())), (SelectionOverride) parcel.readParcelable(SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            this.a = sparseArray;
            this.b = (SparseBooleanArray) Util.castNonNull(parcel.readSparseBooleanArray());
        }
    }

    public static final class ParametersBuilder extends TrackSelectionParameters.Builder {
        public boolean A;
        public boolean B;
        public int C;
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> D;
        public final SparseBooleanArray E;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public boolean n;
        public boolean o;
        public boolean p;
        public int q;
        public int r;
        public boolean s;
        public int t;
        public int u;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public boolean z;

        @Deprecated
        public ParametersBuilder() {
            a();
            this.D = new SparseArray<>();
            this.E = new SparseBooleanArray();
        }

        public final void a() {
            this.f = Integer.MAX_VALUE;
            this.g = Integer.MAX_VALUE;
            this.h = Integer.MAX_VALUE;
            this.i = Integer.MAX_VALUE;
            this.n = true;
            this.o = false;
            this.p = true;
            this.q = Integer.MAX_VALUE;
            this.r = Integer.MAX_VALUE;
            this.s = true;
            this.t = Integer.MAX_VALUE;
            this.u = Integer.MAX_VALUE;
            this.v = true;
            this.w = false;
            this.x = false;
            this.y = false;
            this.z = false;
            this.A = false;
            this.B = true;
            this.C = 0;
        }

        public final ParametersBuilder clearSelectionOverride(int i2, TrackGroupArray trackGroupArray) {
            Map<TrackGroupArray, SelectionOverride> map = this.D.get(i2);
            if (map != null && map.containsKey(trackGroupArray)) {
                map.remove(trackGroupArray);
                if (map.isEmpty()) {
                    this.D.remove(i2);
                }
            }
            return this;
        }

        public final ParametersBuilder clearSelectionOverrides(int i2) {
            Map<TrackGroupArray, SelectionOverride> map = this.D.get(i2);
            if (map != null && !map.isEmpty()) {
                this.D.remove(i2);
            }
            return this;
        }

        public ParametersBuilder clearVideoSizeConstraints() {
            return setMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public ParametersBuilder clearViewportSizeConstraints() {
            return setViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public ParametersBuilder setAllowAudioMixedChannelCountAdaptiveness(boolean z2) {
            this.y = z2;
            return this;
        }

        public ParametersBuilder setAllowAudioMixedMimeTypeAdaptiveness(boolean z2) {
            this.w = z2;
            return this;
        }

        public ParametersBuilder setAllowAudioMixedSampleRateAdaptiveness(boolean z2) {
            this.x = z2;
            return this;
        }

        public ParametersBuilder setAllowVideoMixedMimeTypeAdaptiveness(boolean z2) {
            this.o = z2;
            return this;
        }

        public ParametersBuilder setAllowVideoNonSeamlessAdaptiveness(boolean z2) {
            this.p = z2;
            return this;
        }

        public ParametersBuilder setExceedAudioConstraintsIfNecessary(boolean z2) {
            this.v = z2;
            return this;
        }

        public ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean z2) {
            this.B = z2;
            return this;
        }

        public ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean z2) {
            this.n = z2;
            return this;
        }

        public ParametersBuilder setForceHighestSupportedBitrate(boolean z2) {
            this.A = z2;
            return this;
        }

        public ParametersBuilder setForceLowestBitrate(boolean z2) {
            this.z = z2;
            return this;
        }

        public ParametersBuilder setMaxAudioBitrate(int i2) {
            this.u = i2;
            return this;
        }

        public ParametersBuilder setMaxAudioChannelCount(int i2) {
            this.t = i2;
            return this;
        }

        public ParametersBuilder setMaxVideoBitrate(int i2) {
            this.i = i2;
            return this;
        }

        public ParametersBuilder setMaxVideoFrameRate(int i2) {
            this.h = i2;
            return this;
        }

        public ParametersBuilder setMaxVideoSize(int i2, int i3) {
            this.f = i2;
            this.g = i3;
            return this;
        }

        public ParametersBuilder setMaxVideoSizeSd() {
            return setMaxVideoSize(1279, 719);
        }

        public ParametersBuilder setMinVideoBitrate(int i2) {
            this.m = i2;
            return this;
        }

        public ParametersBuilder setMinVideoFrameRate(int i2) {
            this.l = i2;
            return this;
        }

        public ParametersBuilder setMinVideoSize(int i2, int i3) {
            this.j = i2;
            this.k = i3;
            return this;
        }

        public final ParametersBuilder setRendererDisabled(int i2, boolean z2) {
            if (this.E.get(i2) == z2) {
                return this;
            }
            if (z2) {
                this.E.put(i2, true);
            } else {
                this.E.delete(i2);
            }
            return this;
        }

        public final ParametersBuilder setSelectionOverride(int i2, TrackGroupArray trackGroupArray, @Nullable SelectionOverride selectionOverride) {
            Map<TrackGroupArray, SelectionOverride> map = this.D.get(i2);
            if (map == null) {
                map = new HashMap<>();
                this.D.put(i2, map);
            }
            if (map.containsKey(trackGroupArray) && Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
                return this;
            }
            map.put(trackGroupArray, selectionOverride);
            return this;
        }

        public ParametersBuilder setTunnelingAudioSessionId(int i2) {
            this.C = i2;
            return this;
        }

        public ParametersBuilder setViewportSize(int i2, int i3, boolean z2) {
            this.q = i2;
            this.r = i3;
            this.s = z2;
            return this;
        }

        public ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context context, boolean z2) {
            Point currentDisplayModeSize = Util.getCurrentDisplayModeSize(context);
            return setViewportSize(currentDisplayModeSize.x, currentDisplayModeSize.y, z2);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public Parameters build() {
            return new Parameters(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.a, this.t, this.u, this.v, this.w, this.x, this.y, this.b, this.c, this.d, this.e, this.z, this.A, this.B, this.C, this.D, this.E);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setDisabledTextTrackSelectionFlags(int i2) {
            super.setDisabledTextTrackSelectionFlags(i2);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredAudioLanguage(@Nullable String str) {
            super.setPreferredAudioLanguage(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredTextLanguage(@Nullable String str) {
            super.setPreferredTextLanguage(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            super.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredTextRoleFlags(int i2) {
            super.setPreferredTextRoleFlags(i2);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setSelectUndeterminedTextLanguage(boolean z2) {
            super.setSelectUndeterminedTextLanguage(z2);
            return this;
        }

        public ParametersBuilder(Context context) {
            super(context);
            a();
            this.D = new SparseArray<>();
            this.E = new SparseBooleanArray();
            setViewportSizeToPhysicalDisplaySize(context, true);
        }

        public final ParametersBuilder clearSelectionOverrides() {
            if (this.D.size() == 0) {
                return this;
            }
            this.D.clear();
            return this;
        }

        public ParametersBuilder(Parameters parameters, a aVar) {
            super(parameters);
            this.f = parameters.maxVideoWidth;
            this.g = parameters.maxVideoHeight;
            this.h = parameters.maxVideoFrameRate;
            this.i = parameters.maxVideoBitrate;
            this.j = parameters.minVideoWidth;
            this.k = parameters.minVideoHeight;
            this.l = parameters.minVideoFrameRate;
            this.m = parameters.minVideoBitrate;
            this.n = parameters.exceedVideoConstraintsIfNecessary;
            this.o = parameters.allowVideoMixedMimeTypeAdaptiveness;
            this.p = parameters.allowVideoNonSeamlessAdaptiveness;
            this.q = parameters.viewportWidth;
            this.r = parameters.viewportHeight;
            this.s = parameters.viewportOrientationMayChange;
            this.t = parameters.maxAudioChannelCount;
            this.u = parameters.maxAudioBitrate;
            this.v = parameters.exceedAudioConstraintsIfNecessary;
            this.w = parameters.allowAudioMixedMimeTypeAdaptiveness;
            this.x = parameters.allowAudioMixedSampleRateAdaptiveness;
            this.y = parameters.allowAudioMixedChannelCountAdaptiveness;
            this.z = parameters.forceLowestBitrate;
            this.A = parameters.forceHighestSupportedBitrate;
            this.B = parameters.exceedRendererCapabilitiesIfNecessary;
            this.C = parameters.tunnelingAudioSessionId;
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = parameters.a;
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = new SparseArray<>();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                sparseArray2.put(sparseArray.keyAt(i2), new HashMap(sparseArray.valueAt(i2)));
            }
            this.D = sparseArray2;
            this.E = parameters.b.clone();
        }
    }

    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new a();
        public final int data;
        public final int groupIndex;
        public final int length;
        public final int reason;
        public final int[] tracks;

        public class a implements Parcelable.Creator<SelectionOverride> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public SelectionOverride createFromParcel(Parcel parcel) {
                return new SelectionOverride(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public SelectionOverride[] newArray(int i) {
                return new SelectionOverride[i];
            }
        }

        public SelectionOverride(int i, int... iArr) {
            this(i, iArr, 2, 0);
        }

        public boolean containsTrack(int i) {
            for (int i2 : this.tracks) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SelectionOverride.class != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            if (this.groupIndex == selectionOverride.groupIndex && Arrays.equals(this.tracks, selectionOverride.tracks) && this.reason == selectionOverride.reason && this.data == selectionOverride.data) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return ((((Arrays.hashCode(this.tracks) + (this.groupIndex * 31)) * 31) + this.reason) * 31) + this.data;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.groupIndex);
            parcel.writeInt(this.tracks.length);
            parcel.writeIntArray(this.tracks);
            parcel.writeInt(this.reason);
            parcel.writeInt(this.data);
        }

        public SelectionOverride(int i, int[] iArr, int i2, int i3) {
            this.groupIndex = i;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.tracks = copyOf;
            this.length = iArr.length;
            this.reason = i2;
            this.data = i3;
            Arrays.sort(copyOf);
        }

        public SelectionOverride(Parcel parcel) {
            this.groupIndex = parcel.readInt();
            int readByte = parcel.readByte();
            this.length = readByte;
            int[] iArr = new int[readByte];
            this.tracks = iArr;
            parcel.readIntArray(iArr);
            this.reason = parcel.readInt();
            this.data = parcel.readInt();
        }
    }

    public static final class TextTrackScore implements Comparable<TextTrackScore> {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final int d;
        public final int e;
        public final int f;
        public final boolean g;
        public final boolean isWithinConstraints;

        public TextTrackScore(Format format, Parameters parameters, int i, @Nullable String str) {
            boolean z = false;
            this.a = DefaultTrackSelector.isSupported(i, false);
            int i2 = format.selectionFlags & (~parameters.disabledTextTrackSelectionFlags);
            boolean z2 = (i2 & 1) != 0;
            this.b = z2;
            boolean z3 = (i2 & 2) != 0;
            this.c = z3;
            int formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, parameters.preferredTextLanguage, parameters.selectUndeterminedTextLanguage);
            this.d = formatLanguageScore;
            int bitCount = Integer.bitCount(format.roleFlags & parameters.preferredTextRoleFlags);
            this.e = bitCount;
            this.g = (format.roleFlags & 1088) != 0;
            int formatLanguageScore2 = DefaultTrackSelector.getFormatLanguageScore(format, str, DefaultTrackSelector.normalizeUndeterminedLanguageToNull(str) == null);
            this.f = formatLanguageScore2;
            if (formatLanguageScore > 0 || ((parameters.preferredTextLanguage == null && bitCount > 0) || z2 || (z3 && formatLanguageScore2 > 0))) {
                z = true;
            }
            this.isWithinConstraints = z;
        }

        public int compareTo(TextTrackScore textTrackScore) {
            ComparisonChain compare = ComparisonChain.start().compareFalseFirst(this.a, textTrackScore.a).compare(this.d, textTrackScore.d).compare(this.e, textTrackScore.e).compareFalseFirst(this.b, textTrackScore.b).compare(Boolean.valueOf(this.c), Boolean.valueOf(textTrackScore.c), this.d == 0 ? Ordering.natural() : Ordering.natural().reverse()).compare(this.f, textTrackScore.f);
            if (this.e == 0) {
                compare = compare.compareTrueFirst(this.g, textTrackScore.g);
            }
            return compare.result();
        }
    }

    public static final class VideoTrackScore implements Comparable<VideoTrackScore> {
        public final Parameters a;
        public final boolean b;
        public final boolean c;
        public final int d;
        public final int e;
        public final boolean isWithinMaxConstraints;

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0053, code lost:
            if (r10 < ((float) r8.minVideoFrameRate)) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x005b, code lost:
            if (r10 < r8.minVideoBitrate) goto L_0x005e;
         */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0059  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public VideoTrackScore(com.google.android.exoplayer2.Format r7, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r8, int r9, boolean r10) {
            /*
                r6 = this;
                r6.<init>()
                r6.a = r8
                r0 = 1
                r1 = -1082130432(0xffffffffbf800000, float:-1.0)
                r2 = 0
                r3 = -1
                if (r10 == 0) goto L_0x0033
                int r4 = r7.width
                if (r4 == r3) goto L_0x0014
                int r5 = r8.maxVideoWidth
                if (r4 > r5) goto L_0x0033
            L_0x0014:
                int r4 = r7.height
                if (r4 == r3) goto L_0x001c
                int r5 = r8.maxVideoHeight
                if (r4 > r5) goto L_0x0033
            L_0x001c:
                float r4 = r7.frameRate
                int r5 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                if (r5 == 0) goto L_0x0029
                int r5 = r8.maxVideoFrameRate
                float r5 = (float) r5
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 > 0) goto L_0x0033
            L_0x0029:
                int r4 = r7.bitrate
                if (r4 == r3) goto L_0x0031
                int r5 = r8.maxVideoBitrate
                if (r4 > r5) goto L_0x0033
            L_0x0031:
                r4 = 1
                goto L_0x0034
            L_0x0033:
                r4 = 0
            L_0x0034:
                r6.isWithinMaxConstraints = r4
                if (r10 == 0) goto L_0x005e
                int r10 = r7.width
                if (r10 == r3) goto L_0x0040
                int r4 = r8.minVideoWidth
                if (r10 < r4) goto L_0x005e
            L_0x0040:
                int r10 = r7.height
                if (r10 == r3) goto L_0x0048
                int r4 = r8.minVideoHeight
                if (r10 < r4) goto L_0x005e
            L_0x0048:
                float r10 = r7.frameRate
                int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
                if (r1 == 0) goto L_0x0055
                int r1 = r8.minVideoFrameRate
                float r1 = (float) r1
                int r10 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
                if (r10 < 0) goto L_0x005e
            L_0x0055:
                int r10 = r7.bitrate
                if (r10 == r3) goto L_0x005f
                int r8 = r8.minVideoBitrate
                if (r10 < r8) goto L_0x005e
                goto L_0x005f
            L_0x005e:
                r0 = 0
            L_0x005f:
                r6.b = r0
                boolean r8 = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.isSupported(r9, r2)
                r6.c = r8
                int r8 = r7.bitrate
                r6.d = r8
                int r7 = r7.getPixelCount()
                r6.e = r7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.VideoTrackScore.<init>(com.google.android.exoplayer2.Format, com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters, int, boolean):void");
        }

        public int compareTo(VideoTrackScore videoTrackScore) {
            Ordering<Integer> ordering;
            Ordering<S> reverse = (!this.isWithinMaxConstraints || !this.c) ? DefaultTrackSelector.h.reverse() : (Ordering<S>) DefaultTrackSelector.h;
            ComparisonChain compareFalseFirst = ComparisonChain.start().compareFalseFirst(this.c, videoTrackScore.c).compareFalseFirst(this.isWithinMaxConstraints, videoTrackScore.isWithinMaxConstraints).compareFalseFirst(this.b, videoTrackScore.b);
            Integer valueOf = Integer.valueOf(this.d);
            Integer valueOf2 = Integer.valueOf(videoTrackScore.d);
            if (this.a.forceLowestBitrate) {
                ordering = DefaultTrackSelector.h.reverse();
            } else {
                ordering = DefaultTrackSelector.i;
            }
            return compareFalseFirst.compare(valueOf, valueOf2, ordering).compare(Integer.valueOf(this.e), Integer.valueOf(videoTrackScore.e), reverse).compare(Integer.valueOf(this.d), Integer.valueOf(videoTrackScore.d), reverse).result();
        }
    }

    @Deprecated
    public DefaultTrackSelector() {
        this(Parameters.DEFAULT_WITHOUT_CONTEXT, new AdaptiveTrackSelection.Factory());
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.Integer> a(com.google.android.exoplayer2.source.TrackGroup r12, int r13, int r14, boolean r15) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r12.length
            r0.<init>(r1)
            r1 = 0
            r2 = 0
        L_0x0009:
            int r3 = r12.length
            if (r2 >= r3) goto L_0x0017
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.add(r3)
            int r2 = r2 + 1
            goto L_0x0009
        L_0x0017:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r13 == r2) goto L_0x00a6
            if (r14 != r2) goto L_0x0020
            goto L_0x00a6
        L_0x0020:
            r3 = 0
            r4 = 2147483647(0x7fffffff, float:NaN)
        L_0x0024:
            int r5 = r12.length
            r6 = 1
            if (r3 >= r5) goto L_0x0080
            com.google.android.exoplayer2.Format r5 = r12.getFormat(r3)
            int r7 = r5.width
            if (r7 <= 0) goto L_0x007d
            int r8 = r5.height
            if (r8 <= 0) goto L_0x007d
            if (r15 == 0) goto L_0x0045
            if (r7 <= r8) goto L_0x003b
            r9 = 1
            goto L_0x003c
        L_0x003b:
            r9 = 0
        L_0x003c:
            if (r13 <= r14) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r6 = 0
        L_0x0040:
            if (r9 == r6) goto L_0x0045
            r6 = r13
            r9 = r14
            goto L_0x0047
        L_0x0045:
            r9 = r13
            r6 = r14
        L_0x0047:
            int r10 = r7 * r6
            int r11 = r8 * r9
            if (r10 < r11) goto L_0x0057
            android.graphics.Point r6 = new android.graphics.Point
            int r7 = com.google.android.exoplayer2.util.Util.ceilDivide(r11, r7)
            r6.<init>(r9, r7)
            goto L_0x0061
        L_0x0057:
            android.graphics.Point r7 = new android.graphics.Point
            int r8 = com.google.android.exoplayer2.util.Util.ceilDivide(r10, r8)
            r7.<init>(r8, r6)
            r6 = r7
        L_0x0061:
            int r7 = r5.width
            int r5 = r5.height
            int r8 = r7 * r5
            int r9 = r6.x
            float r9 = (float) r9
            r10 = 1065017672(0x3f7ae148, float:0.98)
            float r9 = r9 * r10
            int r9 = (int) r9
            if (r7 < r9) goto L_0x007d
            int r6 = r6.y
            float r6 = (float) r6
            float r6 = r6 * r10
            int r6 = (int) r6
            if (r5 < r6) goto L_0x007d
            if (r8 >= r4) goto L_0x007d
            r4 = r8
        L_0x007d:
            int r3 = r3 + 1
            goto L_0x0024
        L_0x0080:
            if (r4 == r2) goto L_0x00a6
            int r13 = r0.size()
            int r13 = r13 - r6
        L_0x0087:
            if (r13 < 0) goto L_0x00a6
            java.lang.Object r14 = r0.get(r13)
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            com.google.android.exoplayer2.Format r14 = r12.getFormat(r14)
            int r14 = r14.getPixelCount()
            r15 = -1
            if (r14 == r15) goto L_0x00a0
            if (r14 <= r4) goto L_0x00a3
        L_0x00a0:
            r0.remove(r13)
        L_0x00a3:
            int r13 = r13 + -1
            goto L_0x0087
        L_0x00a6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.a(com.google.android.exoplayer2.source.TrackGroup, int, int, boolean):java.util.List");
    }

    public static boolean b(Format format, @Nullable String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        if ((format.roleFlags & 16384) != 0 || !isSupported(i2, false) || (i2 & i3) == 0) {
            return false;
        }
        if (str != null && !Util.areEqual(format.sampleMimeType, str)) {
            return false;
        }
        int i12 = format.width;
        if (i12 != -1 && (i8 > i12 || i12 > i4)) {
            return false;
        }
        int i13 = format.height;
        if (i13 != -1 && (i9 > i13 || i13 > i5)) {
            return false;
        }
        float f2 = format.frameRate;
        if (f2 != -1.0f && (((float) i10) > f2 || f2 > ((float) i6))) {
            return false;
        }
        int i14 = format.bitrate;
        if (i14 == -1 || (i11 <= i14 && i14 <= i7)) {
            return true;
        }
        return false;
    }

    public static int getFormatLanguageScore(Format format, @Nullable String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(format.language)) {
            return 4;
        }
        String normalizeUndeterminedLanguageToNull = normalizeUndeterminedLanguageToNull(str);
        String normalizeUndeterminedLanguageToNull2 = normalizeUndeterminedLanguageToNull(format.language);
        if (normalizeUndeterminedLanguageToNull2 == null || normalizeUndeterminedLanguageToNull == null) {
            if (!z || normalizeUndeterminedLanguageToNull2 != null) {
                return 0;
            }
            return 1;
        } else if (normalizeUndeterminedLanguageToNull2.startsWith(normalizeUndeterminedLanguageToNull) || normalizeUndeterminedLanguageToNull.startsWith(normalizeUndeterminedLanguageToNull2)) {
            return 3;
        } else {
            if (Util.splitAtFirst(normalizeUndeterminedLanguageToNull2, "-")[0].equals(Util.splitAtFirst(normalizeUndeterminedLanguageToNull, "-")[0])) {
                return 2;
            }
            return 0;
        }
    }

    public static boolean isSupported(int i2, boolean z) {
        int i3 = i2 & 7;
        return i3 == 4 || (z && i3 == 3);
    }

    @Nullable
    public static String normalizeUndeterminedLanguageToNull(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    public ParametersBuilder buildUponParameters() {
        return getParameters().buildUpon();
    }

    public void experimentalAllowMultipleAdaptiveSelections() {
        this.f = true;
    }

    public Parameters getParameters() {
        return this.e.get();
    }

    public TrackSelection.Definition[] selectAllTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        int i2;
        String str;
        int i3;
        String str2;
        AudioTrackScore audioTrackScore;
        int i4;
        int rendererCount = mappedTrackInfo.getRendererCount();
        TrackSelection.Definition[] definitionArr = new TrackSelection.Definition[rendererCount];
        int i5 = 0;
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i2 = 1;
            if (i6 >= rendererCount) {
                break;
            }
            if (2 == mappedTrackInfo.getRendererType(i6)) {
                if (!z) {
                    definitionArr[i6] = selectVideoTrack(mappedTrackInfo.getTrackGroups(i6), iArr[i6], iArr2[i6], parameters, true);
                    z = definitionArr[i6] != null;
                }
                if (mappedTrackInfo.getTrackGroups(i6).length <= 0) {
                    i2 = 0;
                }
                i7 |= i2;
            }
            i6++;
        }
        AudioTrackScore audioTrackScore2 = null;
        String str3 = null;
        int i8 = -1;
        int i9 = 0;
        while (i9 < rendererCount) {
            if (i2 == mappedTrackInfo.getRendererType(i9)) {
                i4 = i8;
                audioTrackScore = audioTrackScore2;
                str2 = str3;
                i3 = i9;
                Pair<TrackSelection.Definition, AudioTrackScore> selectAudioTrack = selectAudioTrack(mappedTrackInfo.getTrackGroups(i9), iArr[i9], iArr2[i9], parameters, this.f || i7 == 0);
                if (selectAudioTrack != null && (audioTrackScore == null || ((AudioTrackScore) selectAudioTrack.second).compareTo(audioTrackScore) > 0)) {
                    if (i4 != -1) {
                        definitionArr[i4] = null;
                    }
                    TrackSelection.Definition definition = (TrackSelection.Definition) selectAudioTrack.first;
                    definitionArr[i3] = definition;
                    str3 = definition.group.getFormat(definition.tracks[0]).language;
                    audioTrackScore2 = (AudioTrackScore) selectAudioTrack.second;
                    i8 = i3;
                    i9 = i3 + 1;
                    i2 = 1;
                }
            } else {
                i4 = i8;
                audioTrackScore = audioTrackScore2;
                str2 = str3;
                i3 = i9;
            }
            i8 = i4;
            audioTrackScore2 = audioTrackScore;
            str3 = str2;
            i9 = i3 + 1;
            i2 = 1;
        }
        String str4 = str3;
        TextTrackScore textTrackScore = null;
        int i10 = -1;
        while (i5 < rendererCount) {
            int rendererType = mappedTrackInfo.getRendererType(i5);
            if (rendererType != 1) {
                if (rendererType != 2) {
                    if (rendererType != 3) {
                        definitionArr[i5] = selectOtherTrack(rendererType, mappedTrackInfo.getTrackGroups(i5), iArr[i5], parameters);
                    } else {
                        str = str4;
                        Pair<TrackSelection.Definition, TextTrackScore> selectTextTrack = selectTextTrack(mappedTrackInfo.getTrackGroups(i5), iArr[i5], parameters, str);
                        if (selectTextTrack != null && (textTrackScore == null || ((TextTrackScore) selectTextTrack.second).compareTo(textTrackScore) > 0)) {
                            if (i10 != -1) {
                                definitionArr[i10] = null;
                            }
                            definitionArr[i5] = (TrackSelection.Definition) selectTextTrack.first;
                            textTrackScore = (TextTrackScore) selectTextTrack.second;
                            i10 = i5;
                        }
                    }
                }
                str = str4;
            } else {
                str = str4;
            }
            i5++;
            str4 = str;
        }
        return definitionArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c8  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<com.google.android.exoplayer2.trackselection.TrackSelection.Definition, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore> selectAudioTrack(com.google.android.exoplayer2.source.TrackGroupArray r17, int[][] r18, int r19, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r20, boolean r21) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
        // Method dump skipped, instructions count: 221
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.selectAudioTrack(com.google.android.exoplayer2.source.TrackGroupArray, int[][], int, com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters, boolean):android.util.Pair");
    }

    @Nullable
    public TrackSelection.Definition selectOtherTrack(int i2, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        OtherTrackScore otherTrackScore = null;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroupArray.length; i4++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < trackGroup2.length; i5++) {
                if (isSupported(iArr2[i5], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    OtherTrackScore otherTrackScore2 = new OtherTrackScore(trackGroup2.getFormat(i5), iArr2[i5]);
                    if (otherTrackScore == null || otherTrackScore2.compareTo(otherTrackScore) > 0) {
                        trackGroup = trackGroup2;
                        i3 = i5;
                        otherTrackScore = otherTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new TrackSelection.Definition(trackGroup, i3);
    }

    @Nullable
    public Pair<TrackSelection.Definition, TextTrackScore> selectTextTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, @Nullable String str) throws ExoPlaybackException {
        int i2 = -1;
        TrackGroup trackGroup = null;
        TextTrackScore textTrackScore = null;
        for (int i3 = 0; i3 < trackGroupArray.length; i3++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < trackGroup2.length; i4++) {
                if (isSupported(iArr2[i4], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    TextTrackScore textTrackScore2 = new TextTrackScore(trackGroup2.getFormat(i4), parameters, iArr2[i4], str);
                    if (textTrackScore2.isWithinConstraints && (textTrackScore == null || textTrackScore2.compareTo(textTrackScore) > 0)) {
                        trackGroup = trackGroup2;
                        i2 = i4;
                        textTrackScore = textTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return Pair.create(new TrackSelection.Definition(trackGroup, i2), (TextTrackScore) Assertions.checkNotNull(textTrackScore));
    }

    @Override // com.google.android.exoplayer2.trackselection.MappingTrackSelector
    public final Pair<RendererConfiguration[], TrackSelection[]> selectTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2) throws ExoPlaybackException {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        Parameters parameters = this.e.get();
        int rendererCount = mappedTrackInfo.getRendererCount();
        TrackSelection.Definition[] selectAllTracks = selectAllTracks(mappedTrackInfo, iArr, iArr2, parameters);
        int i4 = 0;
        while (true) {
            TrackSelection.Definition definition = null;
            if (i4 >= rendererCount) {
                break;
            }
            if (parameters.getRendererDisabled(i4)) {
                selectAllTracks[i4] = null;
            } else {
                TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i4);
                if (parameters.hasSelectionOverride(i4, trackGroups)) {
                    SelectionOverride selectionOverride = parameters.getSelectionOverride(i4, trackGroups);
                    if (selectionOverride != null) {
                        definition = new TrackSelection.Definition(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks, selectionOverride.reason, Integer.valueOf(selectionOverride.data));
                    }
                    selectAllTracks[i4] = definition;
                }
            }
            i4++;
        }
        TrackSelection[] createTrackSelections = this.d.createTrackSelections(selectAllTracks, getBandwidthMeter());
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCount];
        int i5 = 0;
        while (true) {
            i2 = 1;
            if (i5 >= rendererCount) {
                break;
            }
            if (parameters.getRendererDisabled(i5) || (mappedTrackInfo.getRendererType(i5) != 6 && createTrackSelections[i5] == null)) {
                i2 = 0;
            }
            rendererConfigurationArr[i5] = i2 != 0 ? RendererConfiguration.DEFAULT : null;
            i5++;
        }
        int i6 = parameters.tunnelingAudioSessionId;
        if (i6 != 0) {
            int i7 = 0;
            int i8 = -1;
            int i9 = -1;
            while (true) {
                if (i7 >= mappedTrackInfo.getRendererCount()) {
                    i3 = -1;
                    z = true;
                    break;
                }
                int rendererType = mappedTrackInfo.getRendererType(i7);
                TrackSelection trackSelection = createTrackSelections[i7];
                if ((rendererType == i2 || rendererType == 2) && trackSelection != null) {
                    int[][] iArr3 = iArr[i7];
                    int indexOf = mappedTrackInfo.getTrackGroups(i7).indexOf(trackSelection.getTrackGroup());
                    int i10 = 0;
                    while (true) {
                        if (i10 >= trackSelection.length()) {
                            z2 = true;
                            break;
                        } else if ((iArr3[indexOf][trackSelection.getIndexInTrackGroup(i10)] & 32) != 32) {
                            z2 = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                    if (z2) {
                        i3 = -1;
                        if (rendererType == 1) {
                            if (i9 != -1) {
                                break;
                            }
                            i9 = i7;
                            i7++;
                            i2 = 1;
                        } else if (i8 != -1) {
                            break;
                        } else {
                            i8 = i7;
                            i7++;
                            i2 = 1;
                        }
                    }
                }
                i7++;
                i2 = 1;
            }
            z = false;
            if (z && ((i9 == i3 || i8 == i3) ? false : true)) {
                RendererConfiguration rendererConfiguration = new RendererConfiguration(i6);
                rendererConfigurationArr[i9] = rendererConfiguration;
                rendererConfigurationArr[i8] = rendererConfiguration;
            }
        }
        return Pair.create(rendererConfigurationArr, createTrackSelections);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01b9 A[LOOP:0: B:16:0x0025->B:58:0x01b9, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01b3 A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.trackselection.TrackSelection.Definition selectVideoTrack(com.google.android.exoplayer2.source.TrackGroupArray r34, int[][] r35, int r36, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r37, boolean r38) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
        // Method dump skipped, instructions count: 568
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.selectVideoTrack(com.google.android.exoplayer2.source.TrackGroupArray, int[][], int, com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters, boolean):com.google.android.exoplayer2.trackselection.TrackSelection$Definition");
    }

    public void setParameters(Parameters parameters) {
        Assertions.checkNotNull(parameters);
        if (!this.e.getAndSet(parameters).equals(parameters)) {
            invalidate();
        }
    }

    @Deprecated
    public DefaultTrackSelector(TrackSelection.Factory factory) {
        this(Parameters.DEFAULT_WITHOUT_CONTEXT, factory);
    }

    public DefaultTrackSelector(Context context) {
        this(context, new AdaptiveTrackSelection.Factory());
    }

    public DefaultTrackSelector(Context context, TrackSelection.Factory factory) {
        this(Parameters.getDefaults(context), factory);
    }

    public void setParameters(ParametersBuilder parametersBuilder) {
        setParameters(parametersBuilder.build());
    }

    public DefaultTrackSelector(Parameters parameters, TrackSelection.Factory factory) {
        this.d = factory;
        this.e = new AtomicReference<>(parameters);
    }
}
