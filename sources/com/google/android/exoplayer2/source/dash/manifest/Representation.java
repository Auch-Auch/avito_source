package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import java.util.Collections;
import java.util.List;
public abstract class Representation {
    public static final long REVISION_ID_DEFAULT = -1;
    public final RangedUri a;
    public final String baseUrl;
    public final Format format;
    public final List<Descriptor> inbandEventStreams;
    public final long presentationTimeOffsetUs;
    public final long revisionId;

    public static class MultiSegmentRepresentation extends Representation implements DashSegmentIndex {
        public final SegmentBase.MultiSegmentBase b;

        public MultiSegmentRepresentation(long j, Format format, String str, SegmentBase.MultiSegmentBase multiSegmentBase, @Nullable List<Descriptor> list) {
            super(j, format, str, multiSegmentBase, list, null);
            this.b = multiSegmentBase;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public String getCacheKey() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getDurationUs(long j, long j2) {
            return this.b.getSegmentDurationUs(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getFirstSegmentNum() {
            return this.b.getFirstSegmentNum();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public DashSegmentIndex getIndex() {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public RangedUri getIndexUri() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public int getSegmentCount(long j) {
            return this.b.getSegmentCount(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getSegmentNum(long j, long j2) {
            return this.b.getSegmentNum(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public RangedUri getSegmentUrl(long j) {
            return this.b.getSegmentUrl(this, j);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getTimeUs(long j) {
            return this.b.getSegmentTimeUs(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public boolean isExplicit() {
            return this.b.isExplicit();
        }
    }

    public static class SingleSegmentRepresentation extends Representation {
        @Nullable
        public final String b;
        @Nullable
        public final RangedUri c;
        public final long contentLength;
        @Nullable
        public final a2.j.b.b.z0.v.d.a d;
        public final Uri uri;

        public SingleSegmentRepresentation(long j, Format format, String str, SegmentBase.SingleSegmentBase singleSegmentBase, @Nullable List<Descriptor> list, @Nullable String str2, long j2) {
            super(j, format, str, singleSegmentBase, list, null);
            a2.j.b.b.z0.v.d.a aVar;
            this.uri = Uri.parse(str);
            RangedUri index = singleSegmentBase.getIndex();
            this.c = index;
            this.b = str2;
            this.contentLength = j2;
            if (index != null) {
                aVar = null;
            } else {
                aVar = new a2.j.b.b.z0.v.d.a(new RangedUri(null, 0, j2));
            }
            this.d = aVar;
        }

        public static SingleSegmentRepresentation newInstance(long j, Format format, String str, long j2, long j3, long j4, long j5, List<Descriptor> list, @Nullable String str2, long j6) {
            return new SingleSegmentRepresentation(j, format, str, new SegmentBase.SingleSegmentBase(new RangedUri(null, j2, (j3 - j2) + 1), 1, 0, j4, (j5 - j4) + 1), list, str2, j6);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public String getCacheKey() {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public DashSegmentIndex getIndex() {
            return this.d;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public RangedUri getIndexUri() {
            return this.c;
        }
    }

    public Representation(long j, Format format2, String str, SegmentBase segmentBase, List list, a aVar) {
        List<Descriptor> list2;
        this.revisionId = j;
        this.format = format2;
        this.baseUrl = str;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.inbandEventStreams = list2;
        this.a = segmentBase.getInitialization(this);
        this.presentationTimeOffsetUs = segmentBase.getPresentationTimeOffsetUs();
    }

    public static Representation newInstance(long j, Format format2, String str, SegmentBase segmentBase) {
        return newInstance(j, format2, str, segmentBase, null);
    }

    @Nullable
    public abstract String getCacheKey();

    @Nullable
    public abstract DashSegmentIndex getIndex();

    @Nullable
    public abstract RangedUri getIndexUri();

    @Nullable
    public RangedUri getInitializationUri() {
        return this.a;
    }

    public static Representation newInstance(long j, Format format2, String str, SegmentBase segmentBase, @Nullable List<Descriptor> list) {
        return newInstance(j, format2, str, segmentBase, list, null);
    }

    public static Representation newInstance(long j, Format format2, String str, SegmentBase segmentBase, @Nullable List<Descriptor> list, @Nullable String str2) {
        if (segmentBase instanceof SegmentBase.SingleSegmentBase) {
            return new SingleSegmentRepresentation(j, format2, str, (SegmentBase.SingleSegmentBase) segmentBase, list, str2, -1);
        }
        if (segmentBase instanceof SegmentBase.MultiSegmentBase) {
            return new MultiSegmentRepresentation(j, format2, str, (SegmentBase.MultiSegmentBase) segmentBase, list);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }
}
