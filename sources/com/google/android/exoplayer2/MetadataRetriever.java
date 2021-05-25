package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
public final class MetadataRetriever {

    public static final class b {
        public final MediaSourceFactory a;
        public final HandlerThread b;
        public final Handler c;
        public final SettableFuture<TrackGroupArray> d = SettableFuture.create();

        public final class a implements Handler.Callback {
            public final C0185a a = new C0185a();
            public MediaSource b;
            public MediaPeriod c;

            /* renamed from: com.google.android.exoplayer2.MetadataRetriever$b$a$a  reason: collision with other inner class name */
            public final class C0185a implements MediaSource.MediaSourceCaller {
                public final C0186a a = new C0186a(null);
                public final Allocator b = new DefaultAllocator(true, 65536);
                public boolean c;

                /* renamed from: com.google.android.exoplayer2.MetadataRetriever$b$a$a$a  reason: collision with other inner class name */
                public final class C0186a implements MediaPeriod.Callback {
                    public C0186a(a aVar) {
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.source.SequenceableLoader] */
                    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
                    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
                        b.this.c.obtainMessage(2).sendToTarget();
                    }

                    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
                    public void onPrepared(MediaPeriod mediaPeriod) {
                        b.this.d.set(mediaPeriod.getTrackGroups());
                        b.this.c.obtainMessage(3).sendToTarget();
                    }
                }

                public C0185a() {
                }

                @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
                public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
                    if (!this.c) {
                        this.c = true;
                        a.this.c = mediaSource.createPeriod(new MediaSource.MediaPeriodId(timeline.getUidOfPeriod(0)), this.b, 0);
                        a.this.c.prepare(this.a, 0);
                    }
                }
            }

            public a() {
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    MediaSource createMediaSource = b.this.a.createMediaSource((MediaItem) message.obj);
                    this.b = createMediaSource;
                    createMediaSource.prepareSource(this.a, null);
                    b.this.c.sendEmptyMessage(1);
                    return true;
                } else if (i == 1) {
                    try {
                        MediaPeriod mediaPeriod = this.c;
                        if (mediaPeriod == null) {
                            ((MediaSource) Assertions.checkNotNull(this.b)).maybeThrowSourceInfoRefreshError();
                        } else {
                            mediaPeriod.maybeThrowPrepareError();
                        }
                        b.this.c.sendEmptyMessageDelayed(1, 100);
                    } catch (Exception e) {
                        b.this.d.setException(e);
                        b.this.c.obtainMessage(3).sendToTarget();
                    }
                    return true;
                } else if (i == 2) {
                    ((MediaPeriod) Assertions.checkNotNull(this.c)).continueLoading(0);
                    return true;
                } else if (i != 3) {
                    return false;
                } else {
                    if (this.c != null) {
                        ((MediaSource) Assertions.checkNotNull(this.b)).releasePeriod(this.c);
                    }
                    ((MediaSource) Assertions.checkNotNull(this.b)).releaseSource(this.a);
                    b.this.c.removeCallbacksAndMessages(null);
                    b.this.b.quit();
                    return true;
                }
            }
        }

        public b(MediaSourceFactory mediaSourceFactory) {
            this.a = mediaSourceFactory;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:MetadataRetriever");
            this.b = handlerThread;
            handlerThread.start();
            this.c = Util.createHandler(handlerThread.getLooper(), new a());
        }
    }

    public static ListenableFuture<TrackGroupArray> retrieveMetadata(Context context, MediaItem mediaItem) {
        return retrieveMetadata(new DefaultMediaSourceFactory(context), mediaItem);
    }

    public static ListenableFuture<TrackGroupArray> retrieveMetadata(MediaSourceFactory mediaSourceFactory, MediaItem mediaItem) {
        b bVar = new b(mediaSourceFactory);
        bVar.c.obtainMessage(0, mediaItem).sendToTarget();
        return bVar.d;
    }
}
