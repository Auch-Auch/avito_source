package com.google.android.exoplayer2.source.ads;

import a2.b.a.a.a;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import org.spongycastle.pqc.math.linearalgebra.Matrix;
public final class AdPlaybackState {
    public static final int AD_STATE_AVAILABLE = 1;
    public static final int AD_STATE_ERROR = 4;
    public static final int AD_STATE_PLAYED = 3;
    public static final int AD_STATE_SKIPPED = 2;
    public static final int AD_STATE_UNAVAILABLE = 0;
    public static final AdPlaybackState NONE = new AdPlaybackState(new long[0]);
    public final int adGroupCount;
    public final long[] adGroupTimesUs;
    public final AdGroup[] adGroups;
    public final long adResumePositionUs;
    public final long contentDurationUs;

    public static final class AdGroup {
        public final int count;
        public final long[] durationsUs;
        public final int[] states;
        public final Uri[] uris;

        public AdGroup() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        @CheckResult
        public static long[] a(long[] jArr, int i) {
            int length = jArr.length;
            int max = Math.max(i, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, (long) C.TIME_UNSET);
            return copyOf;
        }

        @CheckResult
        public static int[] b(int[] iArr, int i) {
            int length = iArr.length;
            int max = Math.max(i, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AdGroup.class != obj.getClass()) {
                return false;
            }
            AdGroup adGroup = (AdGroup) obj;
            if (this.count != adGroup.count || !Arrays.equals(this.uris, adGroup.uris) || !Arrays.equals(this.states, adGroup.states) || !Arrays.equals(this.durationsUs, adGroup.durationsUs)) {
                return false;
            }
            return true;
        }

        public int getFirstAdIndexToPlay() {
            return getNextAdIndexToPlay(-1);
        }

        public int getNextAdIndexToPlay(int i) {
            int i2 = i + 1;
            while (true) {
                int[] iArr = this.states;
                if (i2 >= iArr.length || iArr[i2] == 0 || iArr[i2] == 1) {
                    break;
                }
                i2++;
            }
            return i2;
        }

        public boolean hasUnplayedAds() {
            return this.count == -1 || getFirstAdIndexToPlay() < this.count;
        }

        public int hashCode() {
            int hashCode = Arrays.hashCode(this.states);
            return Arrays.hashCode(this.durationsUs) + ((hashCode + (((this.count * 31) + Arrays.hashCode(this.uris)) * 31)) * 31);
        }

        @CheckResult
        public AdGroup withAdCount(int i) {
            return new AdGroup(i, b(this.states, i), (Uri[]) Arrays.copyOf(this.uris, i), a(this.durationsUs, i));
        }

        @CheckResult
        public AdGroup withAdDurationsUs(long[] jArr) {
            Assertions.checkArgument(this.count == -1 || jArr.length <= this.uris.length);
            int length = jArr.length;
            Uri[] uriArr = this.uris;
            if (length < uriArr.length) {
                jArr = a(jArr, uriArr.length);
            }
            return new AdGroup(this.count, this.states, this.uris, jArr);
        }

        @CheckResult
        public AdGroup withAdState(int i, int i2) {
            int i3 = this.count;
            boolean z = false;
            Assertions.checkArgument(i3 == -1 || i2 < i3);
            int[] b = b(this.states, i2 + 1);
            if (b[i2] == 0 || b[i2] == 1 || b[i2] == i) {
                z = true;
            }
            Assertions.checkArgument(z);
            long[] jArr = this.durationsUs;
            if (jArr.length != b.length) {
                jArr = a(jArr, b.length);
            }
            Uri[] uriArr = this.uris;
            if (uriArr.length != b.length) {
                uriArr = (Uri[]) Arrays.copyOf(uriArr, b.length);
            }
            b[i2] = i;
            return new AdGroup(this.count, b, uriArr, jArr);
        }

        @CheckResult
        public AdGroup withAdUri(Uri uri, int i) {
            int[] b = b(this.states, i + 1);
            long[] jArr = this.durationsUs;
            if (jArr.length != b.length) {
                jArr = a(jArr, b.length);
            }
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.uris, b.length);
            uriArr[i] = uri;
            b[i] = 1;
            return new AdGroup(this.count, b, uriArr, jArr);
        }

        @CheckResult
        public AdGroup withAllAdsSkipped() {
            if (this.count == -1) {
                return new AdGroup(0, new int[0], new Uri[0], new long[0]);
            }
            int[] iArr = this.states;
            int length = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr, length);
            for (int i = 0; i < length; i++) {
                if (copyOf[i] == 1 || copyOf[i] == 0) {
                    copyOf[i] = 2;
                }
            }
            return new AdGroup(length, copyOf, this.uris, this.durationsUs);
        }

        public AdGroup(int i, int[] iArr, Uri[] uriArr, long[] jArr) {
            Assertions.checkArgument(iArr.length == uriArr.length);
            this.count = i;
            this.states = iArr;
            this.uris = uriArr;
            this.durationsUs = jArr;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    public AdPlaybackState(long... jArr) {
        int length = jArr.length;
        this.adGroupCount = length;
        this.adGroupTimesUs = Arrays.copyOf(jArr, length);
        this.adGroups = new AdGroup[length];
        for (int i = 0; i < length; i++) {
            this.adGroups[i] = new AdGroup();
        }
        this.adResumePositionUs = 0;
        this.contentDurationUs = C.TIME_UNSET;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdPlaybackState.class != obj.getClass()) {
            return false;
        }
        AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
        if (this.adGroupCount == adPlaybackState.adGroupCount && this.adResumePositionUs == adPlaybackState.adResumePositionUs && this.contentDurationUs == adPlaybackState.contentDurationUs && Arrays.equals(this.adGroupTimesUs, adPlaybackState.adGroupTimesUs) && Arrays.equals(this.adGroups, adPlaybackState.adGroups)) {
            return true;
        }
        return false;
    }

    public int getAdGroupIndexAfterPositionUs(long j, long j2) {
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        if (j2 != C.TIME_UNSET && j >= j2) {
            return -1;
        }
        int i = 0;
        while (true) {
            long[] jArr = this.adGroupTimesUs;
            if (i >= jArr.length || jArr[i] == Long.MIN_VALUE || (j < jArr[i] && this.adGroups[i].hasUnplayedAds())) {
                break;
            }
            i++;
        }
        if (i < this.adGroupTimesUs.length) {
            return i;
        }
        return -1;
    }

    public int getAdGroupIndexForPositionUs(long j, long j2) {
        int length = this.adGroupTimesUs.length - 1;
        while (length >= 0) {
            boolean z = false;
            if (j != Long.MIN_VALUE) {
                long j3 = this.adGroupTimesUs[length];
                if (j3 != Long.MIN_VALUE ? j < j3 : !(j2 != C.TIME_UNSET && j >= j2)) {
                    z = true;
                }
            }
            if (!z) {
                break;
            }
            length--;
        }
        if (length < 0 || !this.adGroups[length].hasUnplayedAds()) {
            return -1;
        }
        return length;
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.adGroupTimesUs);
        return Arrays.hashCode(this.adGroups) + ((hashCode + (((((this.adGroupCount * 31) + ((int) this.adResumePositionUs)) * 31) + ((int) this.contentDurationUs)) * 31)) * 31);
    }

    public boolean isAdInErrorState(int i, int i2) {
        AdGroup adGroup;
        int i3;
        AdGroup[] adGroupArr = this.adGroups;
        if (i < adGroupArr.length && (i3 = (adGroup = adGroupArr[i]).count) != -1 && i2 < i3 && adGroup.states[i2] == 4) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder L = a.L("AdPlaybackState(adResumePositionUs=");
        L.append(this.adResumePositionUs);
        L.append(", adGroups=[");
        for (int i = 0; i < this.adGroups.length; i++) {
            L.append("adGroup(timeUs=");
            L.append(this.adGroupTimesUs[i]);
            L.append(", ads=[");
            for (int i2 = 0; i2 < this.adGroups[i].states.length; i2++) {
                L.append("ad(state=");
                int i3 = this.adGroups[i].states[i2];
                if (i3 == 0) {
                    L.append('_');
                } else if (i3 == 1) {
                    L.append(Matrix.MATRIX_TYPE_RANDOM_REGULAR);
                } else if (i3 == 2) {
                    L.append('S');
                } else if (i3 == 3) {
                    L.append('P');
                } else if (i3 != 4) {
                    L.append('?');
                } else {
                    L.append('!');
                }
                L.append(", durationUs=");
                L.append(this.adGroups[i].durationsUs[i2]);
                L.append(')');
                if (i2 < this.adGroups[i].states.length - 1) {
                    L.append(", ");
                }
            }
            L.append("])");
            if (i < this.adGroups.length - 1) {
                L.append(", ");
            }
        }
        L.append("])");
        return L.toString();
    }

    @CheckResult
    public AdPlaybackState withAdCount(int i, int i2) {
        Assertions.checkArgument(i2 > 0);
        AdGroup[] adGroupArr = this.adGroups;
        if (adGroupArr[i].count == i2) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i] = this.adGroups[i].withAdCount(i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withAdDurationsUs(long[][] jArr) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        for (int i = 0; i < this.adGroupCount; i++) {
            adGroupArr2[i] = adGroupArr2[i].withAdDurationsUs(jArr[i]);
        }
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withAdLoadError(int i, int i2) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i] = adGroupArr2[i].withAdState(4, i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withAdResumePositionUs(long j) {
        if (this.adResumePositionUs == j) {
            return this;
        }
        return new AdPlaybackState(this.adGroupTimesUs, this.adGroups, j, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withAdUri(int i, int i2, Uri uri) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i] = adGroupArr2[i].withAdUri(uri, i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withContentDurationUs(long j) {
        if (this.contentDurationUs == j) {
            return this;
        }
        return new AdPlaybackState(this.adGroupTimesUs, this.adGroups, this.adResumePositionUs, j);
    }

    @CheckResult
    public AdPlaybackState withPlayedAd(int i, int i2) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i] = adGroupArr2[i].withAdState(3, i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withSkippedAd(int i, int i2) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i] = adGroupArr2[i].withAdState(2, i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withSkippedAdGroup(int i) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i] = adGroupArr2[i].withAllAdsSkipped();
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState(long[] jArr, AdGroup[] adGroupArr, long j, long j2) {
        this.adGroupCount = adGroupArr.length;
        this.adGroupTimesUs = jArr;
        this.adGroups = adGroupArr;
        this.adResumePositionUs = j;
        this.contentDurationUs = j2;
    }
}
