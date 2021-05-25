package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UnknownNull;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;
public abstract class CompositeMediaSource<T> extends BaseMediaSource {
    public final HashMap<T, b> g = new HashMap<>();
    @Nullable
    public Handler h;
    @Nullable
    public TransferListener i;

    /* JADX WARN: Field signature parse error: a */
    public final class a implements MediaSourceEventListener, DrmSessionEventListener {
        @UnknownNull
        public final Object a;
        public MediaSourceEventListener.EventDispatcher b;
        public DrmSessionEventListener.EventDispatcher c;

        /* JADX WARN: Failed to parse method signature: (TT)V */
        public a(@UnknownNull Object obj) {
            this.b = CompositeMediaSource.this.createEventDispatcher(null);
            this.c = CompositeMediaSource.this.createDrmEventDispatcher(null);
            this.a = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.exoplayer2.source.CompositeMediaSource */
        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.google.android.exoplayer2.source.CompositeMediaSource */
        /* JADX WARN: Multi-variable type inference failed */
        public final boolean a(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodId2;
            if (mediaPeriodId != null) {
                mediaPeriodId2 = CompositeMediaSource.this.getMediaPeriodIdForChildMediaPeriodId(this.a, mediaPeriodId);
                if (mediaPeriodId2 == null) {
                    return false;
                }
            } else {
                mediaPeriodId2 = null;
            }
            int windowIndexForChildWindowIndex = CompositeMediaSource.this.getWindowIndexForChildWindowIndex(this.a, i);
            MediaSourceEventListener.EventDispatcher eventDispatcher = this.b;
            if (eventDispatcher.windowIndex != windowIndexForChildWindowIndex || !Util.areEqual(eventDispatcher.mediaPeriodId, mediaPeriodId2)) {
                this.b = CompositeMediaSource.this.createEventDispatcher(windowIndexForChildWindowIndex, mediaPeriodId2, 0);
            }
            DrmSessionEventListener.EventDispatcher eventDispatcher2 = this.c;
            if (eventDispatcher2.windowIndex == windowIndexForChildWindowIndex && Util.areEqual(eventDispatcher2.mediaPeriodId, mediaPeriodId2)) {
                return true;
            }
            this.c = CompositeMediaSource.this.createDrmEventDispatcher(windowIndexForChildWindowIndex, mediaPeriodId2);
            return true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.exoplayer2.source.CompositeMediaSource */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.android.exoplayer2.source.CompositeMediaSource */
        /* JADX WARN: Multi-variable type inference failed */
        public final MediaLoadData b(MediaLoadData mediaLoadData) {
            long mediaTimeForChildMediaTime = CompositeMediaSource.this.getMediaTimeForChildMediaTime(this.a, mediaLoadData.mediaStartTimeMs);
            long mediaTimeForChildMediaTime2 = CompositeMediaSource.this.getMediaTimeForChildMediaTime(this.a, mediaLoadData.mediaEndTimeMs);
            if (mediaTimeForChildMediaTime == mediaLoadData.mediaStartTimeMs && mediaTimeForChildMediaTime2 == mediaLoadData.mediaEndTimeMs) {
                return mediaLoadData;
            }
            return new MediaLoadData(mediaLoadData.dataType, mediaLoadData.trackType, mediaLoadData.trackFormat, mediaLoadData.trackSelectionReason, mediaLoadData.trackSelectionData, mediaTimeForChildMediaTime, mediaTimeForChildMediaTime2);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onDownstreamFormatChanged(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.b.downstreamFormatChanged(b(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysLoaded(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.c.drmKeysLoaded();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysRemoved(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.c.drmKeysRemoved();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmKeysRestored(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.c.drmKeysRestored();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionAcquired(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.c.drmSessionAcquired();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionManagerError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            if (a(i, mediaPeriodId)) {
                this.c.drmSessionManagerError(exc);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void onDrmSessionReleased(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (a(i, mediaPeriodId)) {
                this.c.drmSessionReleased();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCanceled(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.b.loadCanceled(loadEventInfo, b(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCompleted(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.b.loadCompleted(loadEventInfo, b(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            if (a(i, mediaPeriodId)) {
                this.b.loadError(loadEventInfo, b(mediaLoadData), iOException, z);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadStarted(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.b.loadStarted(loadEventInfo, b(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onUpstreamDiscarded(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (a(i, mediaPeriodId)) {
                this.b.upstreamDiscarded(b(mediaLoadData));
            }
        }
    }

    public static final class b {
        public final MediaSource a;
        public final MediaSource.MediaSourceCaller b;
        public final MediaSourceEventListener c;

        public b(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, MediaSourceEventListener mediaSourceEventListener) {
            this.a = mediaSource;
            this.b = mediaSourceCaller;
            this.c = mediaSourceEventListener;
        }
    }

    public final void disableChildSource(@UnknownNull T t) {
        b bVar = (b) Assertions.checkNotNull(this.g.get(t));
        bVar.a.disable(bVar.b);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @CallSuper
    public void disableInternal() {
        for (b bVar : this.g.values()) {
            bVar.a.disable(bVar.b);
        }
    }

    public final void enableChildSource(@UnknownNull T t) {
        b bVar = (b) Assertions.checkNotNull(this.g.get(t));
        bVar.a.enable(bVar.b);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @CallSuper
    public void enableInternal() {
        for (b bVar : this.g.values()) {
            bVar.a.enable(bVar.b);
        }
    }

    @Nullable
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(@UnknownNull T t, MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    public long getMediaTimeForChildMediaTime(@UnknownNull T t, long j) {
        return j;
    }

    public int getWindowIndexForChildWindowIndex(@UnknownNull T t, int i2) {
        return i2;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    @CallSuper
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        for (b bVar : this.g.values()) {
            bVar.a.maybeThrowSourceInfoRefreshError();
        }
    }

    public abstract void onChildSourceInfoRefreshed(@UnknownNull T t, MediaSource mediaSource, Timeline timeline);

    public final void prepareChildSource(@UnknownNull T t, MediaSource mediaSource) {
        Assertions.checkArgument(!this.g.containsKey(t));
        MediaSource.MediaSourceCaller aVar = new MediaSource.MediaSourceCaller(t) { // from class: a2.j.b.b.z0.a
            public final /* synthetic */ Object b;

            {
                this.b = r2;
            }

            @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
            public final void onSourceInfoRefreshed(MediaSource mediaSource2, Timeline timeline) {
                CompositeMediaSource.this.onChildSourceInfoRefreshed(this.b, mediaSource2, timeline);
            }
        };
        a aVar2 = new a(t);
        this.g.put(t, new b(mediaSource, aVar, aVar2));
        mediaSource.addEventListener((Handler) Assertions.checkNotNull(this.h), aVar2);
        mediaSource.addDrmEventListener((Handler) Assertions.checkNotNull(this.h), aVar2);
        mediaSource.prepareSource(aVar, this.i);
        if (!isEnabled()) {
            mediaSource.disable(aVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @CallSuper
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.i = transferListener;
        this.h = Util.createHandlerForCurrentLooper();
    }

    public final void releaseChildSource(@UnknownNull T t) {
        b bVar = (b) Assertions.checkNotNull(this.g.remove(t));
        bVar.a.releaseSource(bVar.b);
        bVar.a.removeEventListener(bVar.c);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    @CallSuper
    public void releaseSourceInternal() {
        for (b bVar : this.g.values()) {
            bVar.a.releaseSource(bVar.b);
            bVar.a.removeEventListener(bVar.c);
        }
        this.g.clear();
    }
}
