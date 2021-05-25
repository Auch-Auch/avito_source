package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
public final class MaskingMediaSource extends CompositeMediaSource<Void> {
    public final MediaSource j;
    public final boolean k;
    public final Timeline.Window l;
    public final Timeline.Period m;
    public a n;
    @Nullable
    public MaskingMediaPeriod o;
    public boolean p;
    public boolean q;
    public boolean r;

    @VisibleForTesting
    public static final class PlaceholderTimeline extends Timeline {
        public final MediaItem a;

        public PlaceholderTimeline(MediaItem mediaItem) {
            this.a = mediaItem;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            return obj == a.c ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            Object obj = null;
            Integer num = z ? 0 : null;
            if (z) {
                obj = a.c;
            }
            return period.set(num, obj, 0, C.TIME_UNSET, 0);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object getUidOfPeriod(int i) {
            return a.c;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            window.set(Timeline.Window.SINGLE_WINDOW_UID, this.a, null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, false, true, false, 0, C.TIME_UNSET, 0, 0, 0);
            window.isPlaceholder = true;
            return window;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }
    }

    public static final class a extends ForwardingTimeline {
        public static final Object c = new Object();
        @Nullable
        public final Object a;
        @Nullable
        public final Object b;

        public a(Timeline timeline, @Nullable Object obj, @Nullable Object obj2) {
            super(timeline);
            this.a = obj;
            this.b = obj2;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            Object obj2;
            Timeline timeline = this.timeline;
            if (c.equals(obj) && (obj2 = this.b) != null) {
                obj = obj2;
            }
            return timeline.getIndexOfPeriod(obj);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            this.timeline.getPeriod(i, period, z);
            if (Util.areEqual(period.uid, this.b) && z) {
                period.uid = c;
            }
            return period;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Object getUidOfPeriod(int i) {
            Object uidOfPeriod = this.timeline.getUidOfPeriod(i);
            return Util.areEqual(uidOfPeriod, this.b) ? c : uidOfPeriod;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            this.timeline.getWindow(i, window, j);
            if (Util.areEqual(window.uid, this.a)) {
                window.uid = Timeline.Window.SINGLE_WINDOW_UID;
            }
            return window;
        }
    }

    public MaskingMediaSource(MediaSource mediaSource, boolean z) {
        this.j = mediaSource;
        this.k = z && mediaSource.isSingleWindow();
        this.l = new Timeline.Window();
        this.m = new Timeline.Period();
        Timeline initialTimeline = mediaSource.getInitialTimeline();
        if (initialTimeline != null) {
            this.n = new a(initialTimeline, null, null);
            this.r = true;
            return;
        }
        this.n = new a(new PlaceholderTimeline(mediaSource.getMediaItem()), Timeline.Window.SINGLE_WINDOW_UID, a.c);
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    public final void a(long j2) {
        MaskingMediaPeriod maskingMediaPeriod = this.o;
        int indexOfPeriod = this.n.getIndexOfPeriod(maskingMediaPeriod.id.periodUid);
        if (indexOfPeriod != -1) {
            long j3 = this.n.getPeriod(indexOfPeriod, this.m).durationUs;
            if (j3 != C.TIME_UNSET && j2 >= j3) {
                j2 = Math.max(0L, j3 - 1);
            }
            maskingMediaPeriod.overridePreparePositionUs(j2);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.j.getMediaItem();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @Nullable
    @Deprecated
    public Object getTag() {
        return this.j.getTag();
    }

    public Timeline getTimeline() {
        return this.n;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        if (!this.k) {
            this.p = true;
            prepareChildSource(null, this.j);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).releasePeriod();
        if (mediaPeriod == this.o) {
            this.o = null;
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.q = false;
        this.p = false;
        super.releaseSourceInternal();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MaskingMediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(this.j, mediaPeriodId, allocator, j2);
        if (this.q) {
            Object obj = mediaPeriodId.periodUid;
            if (this.n.b != null && obj.equals(a.c)) {
                obj = this.n.b;
            }
            maskingMediaPeriod.createPeriod(mediaPeriodId.copyWithPeriodUid(obj));
        } else {
            this.o = maskingMediaPeriod;
            if (!this.p) {
                this.p = true;
                prepareChildSource(null, this.j);
            }
        }
        return maskingMediaPeriod;
    }

    @Nullable
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void r2, MediaSource.MediaPeriodId mediaPeriodId) {
        Object obj = mediaPeriodId.periodUid;
        Object obj2 = this.n.b;
        if (obj2 != null && obj2.equals(obj)) {
            obj = a.c;
        }
        return mediaPeriodId.copyWithPeriodUid(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onChildSourceInfoRefreshed(java.lang.Void r12, com.google.android.exoplayer2.source.MediaSource r13, com.google.android.exoplayer2.Timeline r14) {
        /*
            r11 = this;
            boolean r12 = r11.q
            if (r12 == 0) goto L_0x001e
            com.google.android.exoplayer2.source.MaskingMediaSource$a r12 = r11.n
            com.google.android.exoplayer2.source.MaskingMediaSource$a r13 = new com.google.android.exoplayer2.source.MaskingMediaSource$a
            java.lang.Object r0 = r12.a
            java.lang.Object r12 = r12.b
            r13.<init>(r14, r0, r12)
            r11.n = r13
            com.google.android.exoplayer2.source.MaskingMediaPeriod r12 = r11.o
            if (r12 == 0) goto L_0x00ae
            long r12 = r12.getPreparePositionOverrideUs()
            r11.a(r12)
            goto L_0x00ae
        L_0x001e:
            boolean r12 = r14.isEmpty()
            if (r12 == 0) goto L_0x0042
            boolean r12 = r11.r
            if (r12 == 0) goto L_0x0034
            com.google.android.exoplayer2.source.MaskingMediaSource$a r12 = r11.n
            com.google.android.exoplayer2.source.MaskingMediaSource$a r13 = new com.google.android.exoplayer2.source.MaskingMediaSource$a
            java.lang.Object r0 = r12.a
            java.lang.Object r12 = r12.b
            r13.<init>(r14, r0, r12)
            goto L_0x003e
        L_0x0034:
            java.lang.Object r12 = com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID
            java.lang.Object r13 = com.google.android.exoplayer2.source.MaskingMediaSource.a.c
            com.google.android.exoplayer2.source.MaskingMediaSource$a r0 = new com.google.android.exoplayer2.source.MaskingMediaSource$a
            r0.<init>(r14, r12, r13)
            r13 = r0
        L_0x003e:
            r11.n = r13
            goto L_0x00ae
        L_0x0042:
            r12 = 0
            com.google.android.exoplayer2.Timeline$Window r13 = r11.l
            r14.getWindow(r12, r13)
            com.google.android.exoplayer2.Timeline$Window r12 = r11.l
            long r12 = r12.getDefaultPositionUs()
            com.google.android.exoplayer2.source.MaskingMediaPeriod r0 = r11.o
            if (r0 == 0) goto L_0x005e
            long r0 = r0.getPreparePositionUs()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x005e
            r9 = r0
            goto L_0x005f
        L_0x005e:
            r9 = r12
        L_0x005f:
            com.google.android.exoplayer2.Timeline$Window r6 = r11.l
            java.lang.Object r12 = r6.uid
            com.google.android.exoplayer2.Timeline$Period r7 = r11.m
            r8 = 0
            r5 = r14
            android.util.Pair r13 = r5.getPeriodPosition(r6, r7, r8, r9)
            java.lang.Object r0 = r13.first
            java.lang.Object r13 = r13.second
            java.lang.Long r13 = (java.lang.Long) r13
            long r1 = r13.longValue()
            boolean r13 = r11.r
            if (r13 == 0) goto L_0x0085
            com.google.android.exoplayer2.source.MaskingMediaSource$a r12 = r11.n
            com.google.android.exoplayer2.source.MaskingMediaSource$a r13 = new com.google.android.exoplayer2.source.MaskingMediaSource$a
            java.lang.Object r0 = r12.a
            java.lang.Object r12 = r12.b
            r13.<init>(r14, r0, r12)
            goto L_0x008a
        L_0x0085:
            com.google.android.exoplayer2.source.MaskingMediaSource$a r13 = new com.google.android.exoplayer2.source.MaskingMediaSource$a
            r13.<init>(r14, r12, r0)
        L_0x008a:
            r11.n = r13
            com.google.android.exoplayer2.source.MaskingMediaPeriod r12 = r11.o
            if (r12 == 0) goto L_0x00ae
            r11.a(r1)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r12 = r12.id
            java.lang.Object r13 = r12.periodUid
            com.google.android.exoplayer2.source.MaskingMediaSource$a r14 = r11.n
            java.lang.Object r14 = r14.b
            if (r14 == 0) goto L_0x00a9
            java.lang.Object r14 = com.google.android.exoplayer2.source.MaskingMediaSource.a.c
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00a9
            com.google.android.exoplayer2.source.MaskingMediaSource$a r13 = r11.n
            java.lang.Object r13 = r13.b
        L_0x00a9:
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r12 = r12.copyWithPeriodUid(r13)
            goto L_0x00af
        L_0x00ae:
            r12 = 0
        L_0x00af:
            r13 = 1
            r11.r = r13
            r11.q = r13
            com.google.android.exoplayer2.source.MaskingMediaSource$a r13 = r11.n
            r11.refreshSourceInfo(r13)
            if (r12 == 0) goto L_0x00c6
            com.google.android.exoplayer2.source.MaskingMediaPeriod r13 = r11.o
            java.lang.Object r13 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r13)
            com.google.android.exoplayer2.source.MaskingMediaPeriod r13 = (com.google.android.exoplayer2.source.MaskingMediaPeriod) r13
            r13.createPeriod(r12)
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.MaskingMediaSource.onChildSourceInfoRefreshed(java.lang.Void, com.google.android.exoplayer2.source.MediaSource, com.google.android.exoplayer2.Timeline):void");
    }
}
