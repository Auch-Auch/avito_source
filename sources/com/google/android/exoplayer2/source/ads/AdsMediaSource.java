package com.google.android.exoplayer2.source.ads;

import a2.j.b.b.z0.u.d;
import a2.j.b.b.z0.u.g;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
public final class AdsMediaSource extends CompositeMediaSource<MediaSource.MediaPeriodId> {
    public static final MediaSource.MediaPeriodId u = new MediaSource.MediaPeriodId(new Object());
    public final MediaSource j;
    public final MediaSourceFactory k;
    public final AdsLoader l;
    public final AdsLoader.AdViewProvider m;
    @Nullable
    public final DataSpec n;
    public final Handler o;
    public final Timeline.Period p;
    @Nullable
    public c q;
    @Nullable
    public Timeline r;
    @Nullable
    public AdPlaybackState s;
    public a[][] t;

    public static final class AdLoadException extends IOException {
        public static final int TYPE_AD = 0;
        public static final int TYPE_AD_GROUP = 1;
        public static final int TYPE_ALL_ADS = 2;
        public static final int TYPE_UNEXPECTED = 3;
        public final int type;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        public AdLoadException(int i, Exception exc) {
            super(exc);
            this.type = i;
        }

        public static AdLoadException createForAd(Exception exc) {
            return new AdLoadException(0, exc);
        }

        public static AdLoadException createForAdGroup(Exception exc, int i) {
            return new AdLoadException(1, new IOException(a2.b.a.a.a.M2("Failed to load ad group ", i), exc));
        }

        public static AdLoadException createForAllAds(Exception exc) {
            return new AdLoadException(2, exc);
        }

        public static AdLoadException createForUnexpected(RuntimeException runtimeException) {
            return new AdLoadException(3, runtimeException);
        }

        public RuntimeException getRuntimeExceptionForUnexpected() {
            Assertions.checkState(this.type == 3);
            return (RuntimeException) Assertions.checkNotNull(getCause());
        }
    }

    public final class a {
        public final MediaSource a;
        public final List<MaskingMediaPeriod> b = new ArrayList();
        public Timeline c;

        public a(MediaSource mediaSource) {
            this.a = mediaSource;
        }
    }

    public final class b implements MaskingMediaPeriod.PrepareListener {
        public final Uri a;

        public b(Uri uri) {
            this.a = uri;
        }

        @Override // com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener
        public void onPrepareComplete(MediaSource.MediaPeriodId mediaPeriodId) {
            AdsMediaSource.this.o.post(new a2.j.b.b.z0.u.c(this, mediaPeriodId));
        }

        @Override // com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener
        public void onPrepareError(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException) {
            AdsMediaSource adsMediaSource = AdsMediaSource.this;
            MediaSource.MediaPeriodId mediaPeriodId2 = AdsMediaSource.u;
            adsMediaSource.createEventDispatcher(mediaPeriodId).loadError(new LoadEventInfo(LoadEventInfo.getNewId(), new DataSpec(this.a), SystemClock.elapsedRealtime()), 6, (IOException) AdLoadException.createForAd(iOException), true);
            AdsMediaSource.this.o.post(new a2.j.b.b.z0.u.b(this, mediaPeriodId, iOException));
        }
    }

    public final class c implements AdsLoader.EventListener {
        public final Handler a = Util.createHandlerForCurrentLooper();
        public volatile boolean b;

        public c() {
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public /* synthetic */ void onAdClicked() {
            g.$default$onAdClicked(this);
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdLoadError(AdLoadException adLoadException, DataSpec dataSpec) {
            if (!this.b) {
                AdsMediaSource adsMediaSource = AdsMediaSource.this;
                MediaSource.MediaPeriodId mediaPeriodId = AdsMediaSource.u;
                adsMediaSource.createEventDispatcher(null).loadError(new LoadEventInfo(LoadEventInfo.getNewId(), dataSpec, SystemClock.elapsedRealtime()), 6, (IOException) adLoadException, true);
            }
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdPlaybackState(AdPlaybackState adPlaybackState) {
            if (!this.b) {
                this.a.post(new d(this, adPlaybackState));
            }
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public /* synthetic */ void onAdTapped() {
            g.$default$onAdTapped(this);
        }
    }

    @Deprecated
    public AdsMediaSource(MediaSource mediaSource, DataSource.Factory factory, AdsLoader adsLoader, AdsLoader.AdViewProvider adViewProvider) {
        this(mediaSource, new ProgressiveMediaSource.Factory(factory), adsLoader, adViewProvider, (DataSpec) null);
    }

    public final void a() {
        Timeline timeline;
        Timeline timeline2 = this.r;
        AdPlaybackState adPlaybackState = this.s;
        if (adPlaybackState != null && timeline2 != null) {
            long[][] jArr = new long[this.t.length][];
            int i = 0;
            while (true) {
                a[][] aVarArr = this.t;
                if (i >= aVarArr.length) {
                    break;
                }
                jArr[i] = new long[aVarArr[i].length];
                int i2 = 0;
                while (true) {
                    a[][] aVarArr2 = this.t;
                    if (i2 >= aVarArr2[i].length) {
                        break;
                    }
                    a aVar = aVarArr2[i][i2];
                    long[] jArr2 = jArr[i];
                    long j2 = C.TIME_UNSET;
                    if (!(aVar == null || (timeline = aVar.c) == null)) {
                        j2 = timeline.getPeriod(0, AdsMediaSource.this.p).getDurationUs();
                    }
                    jArr2[i2] = j2;
                    i2++;
                }
                i++;
            }
            AdPlaybackState withAdDurationsUs = adPlaybackState.withAdDurationsUs(jArr);
            this.s = withAdDurationsUs;
            if (withAdDurationsUs.adGroupCount != 0) {
                timeline2 = new SinglePeriodAdTimeline(timeline2, this.s);
            }
            refreshSourceInfo(timeline2);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        AdPlaybackState adPlaybackState = (AdPlaybackState) Assertions.checkNotNull(this.s);
        if (adPlaybackState.adGroupCount <= 0 || !mediaPeriodId.isAd()) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(this.j, mediaPeriodId, allocator, j2);
            maskingMediaPeriod.createPeriod(mediaPeriodId);
            return maskingMediaPeriod;
        }
        int i = mediaPeriodId.adGroupIndex;
        int i2 = mediaPeriodId.adIndexInAdGroup;
        Uri uri = (Uri) Assertions.checkNotNull(adPlaybackState.adGroups[i].uris[i2]);
        a[][] aVarArr = this.t;
        if (aVarArr[i].length <= i2) {
            aVarArr[i] = (a[]) Arrays.copyOf(aVarArr[i], i2 + 1);
        }
        a aVar = this.t[i][i2];
        if (aVar == null) {
            MediaSource createMediaSource = this.k.createMediaSource(MediaItem.fromUri(uri));
            a aVar2 = new a(createMediaSource);
            this.t[i][i2] = aVar2;
            prepareChildSource(mediaPeriodId, createMediaSource);
            aVar = aVar2;
        }
        MaskingMediaPeriod maskingMediaPeriod2 = new MaskingMediaPeriod(aVar.a, mediaPeriodId, allocator, j2);
        maskingMediaPeriod2.setPrepareListener(new b(uri));
        aVar.b.add(maskingMediaPeriod2);
        Timeline timeline = aVar.c;
        if (timeline != null) {
            maskingMediaPeriod2.createPeriod(new MediaSource.MediaPeriodId(timeline.getUidOfPeriod(0), mediaPeriodId.windowSequenceNumber));
        }
        return maskingMediaPeriod2;
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

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        c cVar = new c();
        this.q = cVar;
        prepareChildSource(u, this.j);
        this.o.post(new Runnable(cVar) { // from class: a2.j.b.b.z0.u.a
            public final /* synthetic */ AdsMediaSource.c b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AdsMediaSource adsMediaSource = AdsMediaSource.this;
                AdsMediaSource.c cVar2 = this.b;
                DataSpec dataSpec = adsMediaSource.n;
                if (dataSpec != null) {
                    adsMediaSource.l.setAdTagDataSpec(dataSpec);
                }
                adsMediaSource.l.start(cVar2, adsMediaSource.m);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) mediaPeriod;
        MediaSource.MediaPeriodId mediaPeriodId = maskingMediaPeriod.id;
        if (mediaPeriodId.isAd()) {
            a aVar = (a) Assertions.checkNotNull(this.t[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup]);
            aVar.b.remove(maskingMediaPeriod);
            maskingMediaPeriod.releasePeriod();
            if (aVar.b.isEmpty()) {
                releaseChildSource(mediaPeriodId);
                this.t[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup] = null;
                return;
            }
            return;
        }
        maskingMediaPeriod.releasePeriod();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        c cVar = (c) Assertions.checkNotNull(this.q);
        cVar.b = true;
        cVar.a.removeCallbacksAndMessages(null);
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = new a[0][];
        Handler handler = this.o;
        AdsLoader adsLoader = this.l;
        Objects.requireNonNull(adsLoader);
        handler.post(new Runnable() { // from class: a2.j.b.b.z0.u.e
            @Override // java.lang.Runnable
            public final void run() {
                AdsLoader.this.stop();
            }
        });
    }

    @Deprecated
    public AdsMediaSource(MediaSource mediaSource, MediaSourceFactory mediaSourceFactory, AdsLoader adsLoader, AdsLoader.AdViewProvider adViewProvider) {
        this(mediaSource, mediaSourceFactory, adsLoader, adViewProvider, (DataSpec) null);
    }

    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId, MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.isAd() ? mediaPeriodId : mediaPeriodId2;
    }

    public void onChildSourceInfoRefreshed(MediaSource.MediaPeriodId mediaPeriodId, MediaSource mediaSource, Timeline timeline) {
        boolean z = false;
        boolean z2 = true;
        if (mediaPeriodId.isAd()) {
            int i = mediaPeriodId.adGroupIndex;
            a aVar = (a) Assertions.checkNotNull(this.t[i][mediaPeriodId.adIndexInAdGroup]);
            Objects.requireNonNull(aVar);
            if (timeline.getPeriodCount() != 1) {
                z2 = false;
            }
            Assertions.checkArgument(z2);
            if (aVar.c == null) {
                Object uidOfPeriod = timeline.getUidOfPeriod(0);
                for (int i2 = 0; i2 < aVar.b.size(); i2++) {
                    MaskingMediaPeriod maskingMediaPeriod = aVar.b.get(i2);
                    maskingMediaPeriod.createPeriod(new MediaSource.MediaPeriodId(uidOfPeriod, maskingMediaPeriod.id.windowSequenceNumber));
                }
            }
            aVar.c = timeline;
        } else {
            if (timeline.getPeriodCount() == 1) {
                z = true;
            }
            Assertions.checkArgument(z);
            this.r = timeline;
        }
        a();
    }

    public AdsMediaSource(MediaSource mediaSource, DataSpec dataSpec, MediaSourceFactory mediaSourceFactory, AdsLoader adsLoader, AdsLoader.AdViewProvider adViewProvider) {
        this(mediaSource, mediaSourceFactory, adsLoader, adViewProvider, dataSpec);
    }

    public AdsMediaSource(MediaSource mediaSource, MediaSourceFactory mediaSourceFactory, AdsLoader adsLoader, AdsLoader.AdViewProvider adViewProvider, @Nullable DataSpec dataSpec) {
        this.j = mediaSource;
        this.k = mediaSourceFactory;
        this.l = adsLoader;
        this.m = adViewProvider;
        this.n = dataSpec;
        this.o = new Handler(Looper.getMainLooper());
        this.p = new Timeline.Period();
        this.t = new a[0][];
        adsLoader.setSupportedContentTypes(mediaSourceFactory.getSupportedTypes());
    }
}
