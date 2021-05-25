package com.google.android.exoplayer2.source;

import a2.j.b.b.z0.n;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
public abstract class BaseMediaSource implements MediaSource {
    public final ArrayList<MediaSource.MediaSourceCaller> a = new ArrayList<>(1);
    public final HashSet<MediaSource.MediaSourceCaller> b = new HashSet<>(1);
    public final MediaSourceEventListener.EventDispatcher c = new MediaSourceEventListener.EventDispatcher();
    public final DrmSessionEventListener.EventDispatcher d = new DrmSessionEventListener.EventDispatcher();
    @Nullable
    public Looper e;
    @Nullable
    public Timeline f;

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void addDrmEventListener(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(drmSessionEventListener);
        this.d.addEventListener(handler, drmSessionEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(mediaSourceEventListener);
        this.c.addEventListener(handler, mediaSourceEventListener);
    }

    public final DrmSessionEventListener.EventDispatcher createDrmEventDispatcher(@Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.d.withParameters(0, mediaPeriodId);
    }

    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(@Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.c.withParameters(0, mediaPeriodId, 0);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void disable(MediaSource.MediaSourceCaller mediaSourceCaller) {
        boolean z = !this.b.isEmpty();
        this.b.remove(mediaSourceCaller);
        if (z && this.b.isEmpty()) {
            disableInternal();
        }
    }

    public void disableInternal() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void enable(MediaSource.MediaSourceCaller mediaSourceCaller) {
        Assertions.checkNotNull(this.e);
        boolean isEmpty = this.b.isEmpty();
        this.b.add(mediaSourceCaller);
        if (isEmpty) {
            enableInternal();
        }
    }

    public void enableInternal() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public /* synthetic */ Timeline getInitialTimeline() {
        return n.$default$getInitialTimeline(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public /* synthetic */ Object getTag() {
        return n.$default$getTag(this);
    }

    public final boolean isEnabled() {
        return !this.b.isEmpty();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public /* synthetic */ boolean isSingleWindow() {
        return n.$default$isSingleWindow(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void prepareSource(MediaSource.MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.e;
        Assertions.checkArgument(looper == null || looper == myLooper);
        Timeline timeline = this.f;
        this.a.add(mediaSourceCaller);
        if (this.e == null) {
            this.e = myLooper;
            this.b.add(mediaSourceCaller);
            prepareSourceInternal(transferListener);
        } else if (timeline != null) {
            enable(mediaSourceCaller);
            mediaSourceCaller.onSourceInfoRefreshed(this, timeline);
        }
    }

    public abstract void prepareSourceInternal(@Nullable TransferListener transferListener);

    public final void refreshSourceInfo(Timeline timeline) {
        this.f = timeline;
        Iterator<MediaSource.MediaSourceCaller> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onSourceInfoRefreshed(this, timeline);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void releaseSource(MediaSource.MediaSourceCaller mediaSourceCaller) {
        this.a.remove(mediaSourceCaller);
        if (this.a.isEmpty()) {
            this.e = null;
            this.f = null;
            this.b.clear();
            releaseSourceInternal();
            return;
        }
        disable(mediaSourceCaller);
    }

    public abstract void releaseSourceInternal();

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void removeDrmEventListener(DrmSessionEventListener drmSessionEventListener) {
        this.d.removeEventListener(drmSessionEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
        this.c.removeEventListener(mediaSourceEventListener);
    }

    public final DrmSessionEventListener.EventDispatcher createDrmEventDispatcher(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.d.withParameters(i, mediaPeriodId);
    }

    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(MediaSource.MediaPeriodId mediaPeriodId, long j) {
        Assertions.checkNotNull(mediaPeriodId);
        return this.c.withParameters(0, mediaPeriodId, j);
    }

    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, long j) {
        return this.c.withParameters(i, mediaPeriodId, j);
    }
}
