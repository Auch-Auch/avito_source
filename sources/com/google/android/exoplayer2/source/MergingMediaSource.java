package com.google.android.exoplayer2.source;

import a2.j.b.b.z0.q;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public final class MergingMediaSource extends CompositeMediaSource<Integer> {
    public static final MediaItem r = new MediaItem.Builder().setMediaId("MergingMediaSource").build();
    public final boolean j;
    public final MediaSource[] k;
    public final Timeline[] l;
    public final ArrayList<MediaSource> m;
    public final CompositeSequenceableLoaderFactory n;
    public int o;
    public long[][] p;
    @Nullable
    public IllegalMergeException q;

    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalMergeException(int i) {
            this.reason = i;
        }
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        int length = this.k.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        int indexOfPeriod = this.l[0].getIndexOfPeriod(mediaPeriodId.periodUid);
        for (int i = 0; i < length; i++) {
            mediaPeriodArr[i] = this.k[i].createPeriod(mediaPeriodId.copyWithPeriodUid(this.l[i].getUidOfPeriod(indexOfPeriod)), allocator, j2 - this.p[indexOfPeriod][i]);
        }
        return new q(this.n, this.p[indexOfPeriod], mediaPeriodArr);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        MediaSource[] mediaSourceArr = this.k;
        return mediaSourceArr.length > 0 ? mediaSourceArr[0].getMediaItem() : r;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @Nullable
    @Deprecated
    public Object getTag() {
        MediaSource[] mediaSourceArr = this.k;
        if (mediaSourceArr.length > 0) {
            return mediaSourceArr[0].getTag();
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalMergeException illegalMergeException = this.q;
        if (illegalMergeException == null) {
            super.maybeThrowSourceInfoRefreshError();
            return;
        }
        throw illegalMergeException;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        for (int i = 0; i < this.k.length; i++) {
            prepareChildSource(Integer.valueOf(i), this.k[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        MediaPeriod mediaPeriod2;
        q qVar = (q) mediaPeriod;
        int i = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.k;
            if (i < mediaSourceArr.length) {
                MediaSource mediaSource = mediaSourceArr[i];
                MediaPeriod[] mediaPeriodArr = qVar.a;
                if (mediaPeriodArr[i] instanceof q.a) {
                    mediaPeriod2 = ((q.a) mediaPeriodArr[i]).a;
                } else {
                    mediaPeriod2 = mediaPeriodArr[i];
                }
                mediaSource.releasePeriod(mediaPeriod2);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        Arrays.fill(this.l, (Object) null);
        this.o = -1;
        this.q = null;
        this.m.clear();
        Collections.addAll(this.m, this.k);
    }

    public MergingMediaSource(boolean z, MediaSource... mediaSourceArr) {
        this(z, new DefaultCompositeSequenceableLoaderFactory(), mediaSourceArr);
    }

    @Nullable
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() == 0) {
            return mediaPeriodId;
        }
        return null;
    }

    public void onChildSourceInfoRefreshed(Integer num, MediaSource mediaSource, Timeline timeline) {
        if (this.q == null) {
            if (this.o == -1) {
                this.o = timeline.getPeriodCount();
            } else if (timeline.getPeriodCount() != this.o) {
                this.q = new IllegalMergeException(0);
                return;
            }
            if (this.p.length == 0) {
                int i = this.o;
                int[] iArr = new int[2];
                iArr[1] = this.l.length;
                iArr[0] = i;
                this.p = (long[][]) Array.newInstance(long.class, iArr);
            }
            this.m.remove(mediaSource);
            this.l[num.intValue()] = timeline;
            if (this.m.isEmpty()) {
                if (this.j) {
                    Timeline.Period period = new Timeline.Period();
                    for (int i2 = 0; i2 < this.o; i2++) {
                        long j2 = -this.l[0].getPeriod(i2, period).getPositionInWindowUs();
                        int i3 = 1;
                        while (true) {
                            Timeline[] timelineArr = this.l;
                            if (i3 >= timelineArr.length) {
                                break;
                            }
                            this.p[i2][i3] = j2 - (-timelineArr[i3].getPeriod(i2, period).getPositionInWindowUs());
                            i3++;
                        }
                    }
                }
                refreshSourceInfo(this.l[0]);
            }
        }
    }

    public MergingMediaSource(boolean z, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, MediaSource... mediaSourceArr) {
        this.j = z;
        this.k = mediaSourceArr;
        this.n = compositeSequenceableLoaderFactory;
        this.m = new ArrayList<>(Arrays.asList(mediaSourceArr));
        this.o = -1;
        this.l = new Timeline[mediaSourceArr.length];
        this.p = new long[0][];
    }
}
