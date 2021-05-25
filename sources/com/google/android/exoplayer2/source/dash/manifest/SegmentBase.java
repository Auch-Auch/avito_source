package com.google.android.exoplayer2.source.dash.manifest;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
public abstract class SegmentBase {
    @Nullable
    public final RangedUri a;
    public final long b;
    public final long c;

    public static abstract class MultiSegmentBase extends SegmentBase {
        public final long d;
        public final long e;
        @Nullable
        public final List<SegmentTimelineElement> f;

        public MultiSegmentBase(@Nullable RangedUri rangedUri, long j, long j2, long j3, long j4, @Nullable List<SegmentTimelineElement> list) {
            super(rangedUri, j, j2);
            this.d = j3;
            this.e = j4;
            this.f = list;
        }

        public long getFirstSegmentNum() {
            return this.d;
        }

        public abstract int getSegmentCount(long j);

        public final long getSegmentDurationUs(long j, long j2) {
            List<SegmentTimelineElement> list = this.f;
            if (list != null) {
                return (list.get((int) (j - this.d)).b * 1000000) / this.b;
            }
            int segmentCount = getSegmentCount(j2);
            if (segmentCount == -1 || j != (getFirstSegmentNum() + ((long) segmentCount)) - 1) {
                return (this.e * 1000000) / this.b;
            }
            return j2 - getSegmentTimeUs(j);
        }

        public long getSegmentNum(long j, long j2) {
            long firstSegmentNum = getFirstSegmentNum();
            long segmentCount = (long) getSegmentCount(j2);
            if (segmentCount == 0) {
                return firstSegmentNum;
            }
            if (this.f == null) {
                long j3 = (j / ((this.e * 1000000) / this.b)) + this.d;
                if (j3 < firstSegmentNum) {
                    return firstSegmentNum;
                }
                return segmentCount == -1 ? j3 : Math.min(j3, (firstSegmentNum + segmentCount) - 1);
            }
            long j4 = (segmentCount + firstSegmentNum) - 1;
            long j5 = firstSegmentNum;
            while (j5 <= j4) {
                long j6 = ((j4 - j5) / 2) + j5;
                int i = (getSegmentTimeUs(j6) > j ? 1 : (getSegmentTimeUs(j6) == j ? 0 : -1));
                if (i < 0) {
                    j5 = j6 + 1;
                } else if (i <= 0) {
                    return j6;
                } else {
                    j4 = j6 - 1;
                }
            }
            return j5 == firstSegmentNum ? j5 : j4;
        }

        public final long getSegmentTimeUs(long j) {
            long j2;
            List<SegmentTimelineElement> list = this.f;
            if (list != null) {
                j2 = list.get((int) (j - this.d)).a - this.c;
            } else {
                j2 = (j - this.d) * this.e;
            }
            return Util.scaleLargeTimestamp(j2, 1000000, this.b);
        }

        public abstract RangedUri getSegmentUrl(Representation representation, long j);

        public boolean isExplicit() {
            return this.f != null;
        }
    }

    public static class SegmentList extends MultiSegmentBase {
        @Nullable
        public final List<RangedUri> g;

        public SegmentList(RangedUri rangedUri, long j, long j2, long j3, long j4, @Nullable List<SegmentTimelineElement> list, @Nullable List<RangedUri> list2) {
            super(rangedUri, j, j2, j3, j4, list);
            this.g = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getSegmentCount(long j) {
            return this.g.size();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, long j) {
            return this.g.get((int) (j - this.d));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public boolean isExplicit() {
            return true;
        }
    }

    public static class SegmentTemplate extends MultiSegmentBase {
        @Nullable
        public final UrlTemplate g;
        @Nullable
        public final UrlTemplate h;
        public final long i;

        public SegmentTemplate(RangedUri rangedUri, long j, long j2, long j3, long j4, long j5, @Nullable List<SegmentTimelineElement> list, @Nullable UrlTemplate urlTemplate, @Nullable UrlTemplate urlTemplate2) {
            super(rangedUri, j, j2, j3, j5, list);
            this.g = urlTemplate;
            this.h = urlTemplate2;
            this.i = j4;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase
        @Nullable
        public RangedUri getInitialization(Representation representation) {
            UrlTemplate urlTemplate = this.g;
            if (urlTemplate == null) {
                return SegmentBase.super.getInitialization(representation);
            }
            Format format = representation.format;
            return new RangedUri(urlTemplate.buildUri(format.id, 0, format.bitrate, 0), 0, -1);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getSegmentCount(long j) {
            List<SegmentTimelineElement> list = this.f;
            if (list != null) {
                return list.size();
            }
            long j2 = this.i;
            if (j2 != -1) {
                return (int) ((j2 - this.d) + 1);
            }
            if (j != C.TIME_UNSET) {
                return (int) Util.ceilDivide(j, (this.e * 1000000) / this.b);
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public RangedUri getSegmentUrl(Representation representation, long j) {
            long j2;
            List<SegmentTimelineElement> list = this.f;
            if (list != null) {
                j2 = list.get((int) (j - this.d)).a;
            } else {
                j2 = (j - this.d) * this.e;
            }
            UrlTemplate urlTemplate = this.h;
            Format format = representation.format;
            return new RangedUri(urlTemplate.buildUri(format.id, j, format.bitrate, j2), 0, -1);
        }
    }

    public static class SegmentTimelineElement {
        public final long a;
        public final long b;

        public SegmentTimelineElement(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SegmentTimelineElement segmentTimelineElement = (SegmentTimelineElement) obj;
            if (this.a == segmentTimelineElement.a && this.b == segmentTimelineElement.b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((int) this.a) * 31) + ((int) this.b);
        }
    }

    public SegmentBase(@Nullable RangedUri rangedUri, long j, long j2) {
        this.a = rangedUri;
        this.b = j;
        this.c = j2;
    }

    @Nullable
    public RangedUri getInitialization(Representation representation) {
        return this.a;
    }

    public long getPresentationTimeOffsetUs() {
        return Util.scaleLargeTimestamp(this.c, 1000000, this.b);
    }

    public static class SingleSegmentBase extends SegmentBase {
        public final long d;
        public final long e;

        public SingleSegmentBase(@Nullable RangedUri rangedUri, long j, long j2, long j3, long j4) {
            super(rangedUri, j, j2);
            this.d = j3;
            this.e = j4;
        }

        @Nullable
        public RangedUri getIndex() {
            long j = this.e;
            if (j <= 0) {
                return null;
            }
            return new RangedUri(null, this.d, j);
        }

        public SingleSegmentBase() {
            this(null, 1, 0, 0, 0);
        }
    }
}
