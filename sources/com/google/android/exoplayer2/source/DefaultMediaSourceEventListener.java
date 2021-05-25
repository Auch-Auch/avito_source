package com.google.android.exoplayer2.source;

import a2.j.b.b.z0.o;
import com.google.android.exoplayer2.source.MediaSource;
import java.io.IOException;
@Deprecated
public abstract class DefaultMediaSourceEventListener implements MediaSourceEventListener {
    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        o.$default$onDownstreamFormatChanged(this, i, mediaPeriodId, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        o.$default$onLoadCanceled(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        o.$default$onLoadCompleted(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        o.$default$onLoadError(this, i, mediaPeriodId, loadEventInfo, mediaLoadData, iOException, z);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        o.$default$onLoadStarted(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        o.$default$onUpstreamDiscarded(this, i, mediaPeriodId, mediaLoadData);
    }
}
