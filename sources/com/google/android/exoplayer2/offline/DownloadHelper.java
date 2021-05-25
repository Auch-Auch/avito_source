package com.google.android.exoplayer2.offline;

import a2.j.b.b.f1.k;
import a2.j.b.b.x0.f;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseIntArray;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
public final class DownloadHelper {
    @Deprecated
    public static final DefaultTrackSelector.Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS;
    public static final DefaultTrackSelector.Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT;
    @Deprecated
    public static final DefaultTrackSelector.Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT;
    public final MediaItem.PlaybackProperties a;
    @Nullable
    public final MediaSource b;
    public final DefaultTrackSelector c;
    public final RendererCapabilities[] d;
    public final SparseIntArray e = new SparseIntArray();
    public final Handler f;
    public final Timeline.Window g;
    public boolean h;
    public Callback i;
    public e j;
    public TrackGroupArray[] k;
    public MappingTrackSelector.MappedTrackInfo[] l;
    public List<TrackSelection>[][] m;
    public List<TrackSelection>[][] n;

    public interface Callback {
        void onPrepareError(DownloadHelper downloadHelper, IOException iOException);

        void onPrepared(DownloadHelper downloadHelper);
    }

    public static class LiveContentUnsupportedException extends IOException {
    }

    public class a implements VideoRendererEventListener {
        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onDroppedFrames(int i, long j) {
            k.$default$onDroppedFrames(this, i, j);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onRenderedFirstFrame(Surface surface) {
            k.$default$onRenderedFirstFrame(this, surface);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onVideoDecoderInitialized(String str, long j, long j2) {
            k.$default$onVideoDecoderInitialized(this, str, j, j2);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onVideoDisabled(DecoderCounters decoderCounters) {
            k.$default$onVideoDisabled(this, decoderCounters);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onVideoEnabled(DecoderCounters decoderCounters) {
            k.$default$onVideoEnabled(this, decoderCounters);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onVideoFrameProcessingOffset(long j, int i) {
            k.$default$onVideoFrameProcessingOffset(this, j, i);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onVideoInputFormatChanged(Format format) {
            k.$default$onVideoInputFormatChanged(this, format);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onVideoSizeChanged(int i, int i2, int i3, float f) {
            k.$default$onVideoSizeChanged(this, i, i2, i3, f);
        }
    }

    public class b implements AudioRendererEventListener {
        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioDecoderInitialized(String str, long j, long j2) {
            a2.j.b.b.r0.k.$default$onAudioDecoderInitialized(this, str, j, j2);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioDisabled(DecoderCounters decoderCounters) {
            a2.j.b.b.r0.k.$default$onAudioDisabled(this, decoderCounters);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioEnabled(DecoderCounters decoderCounters) {
            a2.j.b.b.r0.k.$default$onAudioEnabled(this, decoderCounters);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioInputFormatChanged(Format format) {
            a2.j.b.b.r0.k.$default$onAudioInputFormatChanged(this, format);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioPositionAdvancing(long j) {
            a2.j.b.b.r0.k.$default$onAudioPositionAdvancing(this, j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioSessionId(int i) {
            a2.j.b.b.r0.k.$default$onAudioSessionId(this, i);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioUnderrun(int i, long j, long j2) {
            a2.j.b.b.r0.k.$default$onAudioUnderrun(this, i, j, j2);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
            a2.j.b.b.r0.k.$default$onSkipSilenceEnabledChanged(this, z);
        }
    }

    public static final class c extends BaseTrackSelection {

        public static final class a implements TrackSelection.Factory {
            public a(a aVar) {
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
            public TrackSelection[] createTrackSelections(TrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter) {
                c cVar;
                TrackSelection[] trackSelectionArr = new TrackSelection[definitionArr.length];
                for (int i = 0; i < definitionArr.length; i++) {
                    if (definitionArr[i] == null) {
                        cVar = null;
                    } else {
                        cVar = new c(definitionArr[i].group, definitionArr[i].tracks);
                    }
                    trackSelectionArr[i] = cVar;
                }
                return trackSelectionArr;
            }
        }

        public c(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectedIndex() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        @Nullable
        public Object getSelectionData() {
            return null;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectionReason() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        }
    }

    public static final class d implements BandwidthMeter {
        public d(a aVar) {
        }

        @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
        public void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
        }

        @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
        public long getBitrateEstimate() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
        @Nullable
        public TransferListener getTransferListener() {
            return null;
        }

        @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
        public void removeEventListener(BandwidthMeter.EventListener eventListener) {
        }
    }

    public static final class e implements MediaSource.MediaSourceCaller, MediaPeriod.Callback, Handler.Callback {
        public final MediaSource a;
        public final DownloadHelper b;
        public final Allocator c = new DefaultAllocator(true, 65536);
        public final ArrayList<MediaPeriod> d = new ArrayList<>();
        public final Handler e = Util.createHandlerForCurrentOrMainLooper(new a2.j.b.b.x0.d(this));
        public final HandlerThread f;
        public final Handler g;
        public Timeline h;
        public MediaPeriod[] i;
        public boolean j;

        public e(MediaSource mediaSource, DownloadHelper downloadHelper) {
            this.a = mediaSource;
            this.b = downloadHelper;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadHelper");
            this.f = handlerThread;
            handlerThread.start();
            Handler createHandler = Util.createHandler(handlerThread.getLooper(), this);
            this.g = createHandler;
            createHandler.sendEmptyMessage(0);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 0) {
                int i3 = 0;
                if (i2 == 1) {
                    try {
                        if (this.i == null) {
                            this.a.maybeThrowSourceInfoRefreshError();
                        } else {
                            while (i3 < this.d.size()) {
                                this.d.get(i3).maybeThrowPrepareError();
                                i3++;
                            }
                        }
                        this.g.sendEmptyMessageDelayed(1, 100);
                    } catch (IOException e2) {
                        this.e.obtainMessage(1, e2).sendToTarget();
                    }
                    return true;
                } else if (i2 == 2) {
                    MediaPeriod mediaPeriod = (MediaPeriod) message.obj;
                    if (this.d.contains(mediaPeriod)) {
                        mediaPeriod.continueLoading(0);
                    }
                    return true;
                } else if (i2 != 3) {
                    return false;
                } else {
                    MediaPeriod[] mediaPeriodArr = this.i;
                    if (mediaPeriodArr != null) {
                        int length = mediaPeriodArr.length;
                        while (i3 < length) {
                            this.a.releasePeriod(mediaPeriodArr[i3]);
                            i3++;
                        }
                    }
                    this.a.releaseSource(this);
                    this.g.removeCallbacksAndMessages(null);
                    this.f.quit();
                    return true;
                }
            } else {
                this.a.prepareSource(this, null);
                this.g.sendEmptyMessage(1);
                return true;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.source.SequenceableLoader] */
        @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
        public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
            MediaPeriod mediaPeriod2 = mediaPeriod;
            if (this.d.contains(mediaPeriod2)) {
                this.g.obtainMessage(2, mediaPeriod2).sendToTarget();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
        public void onPrepared(MediaPeriod mediaPeriod) {
            this.d.remove(mediaPeriod);
            if (this.d.isEmpty()) {
                this.g.removeMessages(1);
                this.e.sendEmptyMessage(0);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
        public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
            MediaPeriod[] mediaPeriodArr;
            if (this.h == null) {
                if (timeline.getWindow(0, new Timeline.Window()).isLive) {
                    this.e.obtainMessage(1, new LiveContentUnsupportedException()).sendToTarget();
                    return;
                }
                this.h = timeline;
                this.i = new MediaPeriod[timeline.getPeriodCount()];
                int i2 = 0;
                while (true) {
                    mediaPeriodArr = this.i;
                    if (i2 >= mediaPeriodArr.length) {
                        break;
                    }
                    MediaPeriod createPeriod = this.a.createPeriod(new MediaSource.MediaPeriodId(timeline.getUidOfPeriod(i2)), this.c, 0);
                    this.i[i2] = createPeriod;
                    this.d.add(createPeriod);
                    i2++;
                }
                for (MediaPeriod mediaPeriod : mediaPeriodArr) {
                    mediaPeriod.prepare(this, 0);
                }
            }
        }
    }

    static {
        DefaultTrackSelector.Parameters build = DefaultTrackSelector.Parameters.DEFAULT_WITHOUT_CONTEXT.buildUpon().setForceHighestSupportedBitrate(true).build();
        DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT = build;
        DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT = build;
        DEFAULT_TRACK_SELECTOR_PARAMETERS = build;
    }

    public DownloadHelper(MediaItem mediaItem, @Nullable MediaSource mediaSource, DefaultTrackSelector.Parameters parameters, RendererCapabilities[] rendererCapabilitiesArr) {
        this.a = (MediaItem.PlaybackProperties) Assertions.checkNotNull(mediaItem.playbackProperties);
        this.b = mediaSource;
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(parameters, new c.a(null));
        this.c = defaultTrackSelector;
        this.d = rendererCapabilitiesArr;
        defaultTrackSelector.init(a2.j.b.b.x0.e.a, new d(null));
        this.f = Util.createHandlerForCurrentOrMainLooper();
        this.g = new Timeline.Window();
    }

    public static MediaSource createMediaSource(DownloadRequest downloadRequest, DataSource.Factory factory) {
        return createMediaSource(downloadRequest, factory, null);
    }

    @Deprecated
    public static DownloadHelper forDash(Context context, Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forDash(uri, factory, renderersFactory, null, getDefaultTrackSelectorParameters(context));
    }

    @Deprecated
    public static DownloadHelper forHls(Context context, Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forHls(uri, factory, renderersFactory, null, getDefaultTrackSelectorParameters(context));
    }

    public static DownloadHelper forMediaItem(Context context, MediaItem mediaItem) {
        MediaItem.PlaybackProperties playbackProperties = (MediaItem.PlaybackProperties) Assertions.checkNotNull(mediaItem.playbackProperties);
        Assertions.checkArgument(Util.inferContentTypeForUriAndMimeType(playbackProperties.uri, playbackProperties.mimeType) == 3);
        return forMediaItem(mediaItem, getDefaultTrackSelectorParameters(context), null, null, null);
    }

    @Deprecated
    public static DownloadHelper forProgressive(Context context, Uri uri) {
        return forMediaItem(context, new MediaItem.Builder().setUri(uri).build());
    }

    @Deprecated
    public static DownloadHelper forSmoothStreaming(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forSmoothStreaming(uri, factory, renderersFactory, null, DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT);
    }

    public static DefaultTrackSelector.Parameters getDefaultTrackSelectorParameters(Context context) {
        return DefaultTrackSelector.Parameters.getDefaults(context).buildUpon().setForceHighestSupportedBitrate(true).build();
    }

    public static RendererCapabilities[] getRendererCapabilities(RenderersFactory renderersFactory) {
        Renderer[] createRenderers = renderersFactory.createRenderers(Util.createHandlerForCurrentOrMainLooper(), new a(), new b(), f.a, a2.j.b.b.x0.a.a);
        RendererCapabilities[] rendererCapabilitiesArr = new RendererCapabilities[createRenderers.length];
        for (int i2 = 0; i2 < createRenderers.length; i2++) {
            rendererCapabilitiesArr[i2] = createRenderers[i2].getCapabilities();
        }
        return rendererCapabilitiesArr;
    }

    @RequiresNonNull({"trackGroupArrays", "trackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline"})
    public final TrackSelectorResult a(int i2) {
        boolean z;
        try {
            TrackSelectorResult selectTracks = this.c.selectTracks(this.d, this.k[i2], new MediaSource.MediaPeriodId(this.j.h.getUidOfPeriod(i2)), this.j.h);
            for (int i3 = 0; i3 < selectTracks.length; i3++) {
                TrackSelection trackSelection = selectTracks.selections.get(i3);
                if (trackSelection != null) {
                    List<TrackSelection> list = this.m[i2][i3];
                    int i4 = 0;
                    while (true) {
                        if (i4 >= list.size()) {
                            z = false;
                            break;
                        }
                        TrackSelection trackSelection2 = list.get(i4);
                        if (trackSelection2.getTrackGroup() == trackSelection.getTrackGroup()) {
                            this.e.clear();
                            for (int i5 = 0; i5 < trackSelection2.length(); i5++) {
                                this.e.put(trackSelection2.getIndexInTrackGroup(i5), 0);
                            }
                            for (int i6 = 0; i6 < trackSelection.length(); i6++) {
                                this.e.put(trackSelection.getIndexInTrackGroup(i6), 0);
                            }
                            int[] iArr = new int[this.e.size()];
                            for (int i7 = 0; i7 < this.e.size(); i7++) {
                                iArr[i7] = this.e.keyAt(i7);
                            }
                            list.set(i4, new c(trackSelection2.getTrackGroup(), iArr));
                            z = true;
                        } else {
                            i4++;
                        }
                    }
                    if (!z) {
                        list.add(trackSelection);
                    }
                }
            }
            return selectTracks;
        } catch (ExoPlaybackException e2) {
            throw new UnsupportedOperationException(e2);
        }
    }

    public void addAudioLanguagesToSelection(String... strArr) {
        Assertions.checkState(this.h);
        for (int i2 = 0; i2 < this.l.length; i2++) {
            DefaultTrackSelector.ParametersBuilder buildUpon = DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT.buildUpon();
            MappingTrackSelector.MappedTrackInfo mappedTrackInfo = this.l[i2];
            int rendererCount = mappedTrackInfo.getRendererCount();
            for (int i3 = 0; i3 < rendererCount; i3++) {
                if (mappedTrackInfo.getRendererType(i3) != 1) {
                    buildUpon.setRendererDisabled(i3, true);
                }
            }
            for (String str : strArr) {
                buildUpon.setPreferredAudioLanguage(str);
                addTrackSelection(i2, buildUpon.build());
            }
        }
    }

    public void addTextLanguagesToSelection(boolean z, String... strArr) {
        Assertions.checkState(this.h);
        for (int i2 = 0; i2 < this.l.length; i2++) {
            DefaultTrackSelector.ParametersBuilder buildUpon = DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT.buildUpon();
            MappingTrackSelector.MappedTrackInfo mappedTrackInfo = this.l[i2];
            int rendererCount = mappedTrackInfo.getRendererCount();
            for (int i3 = 0; i3 < rendererCount; i3++) {
                if (mappedTrackInfo.getRendererType(i3) != 3) {
                    buildUpon.setRendererDisabled(i3, true);
                }
            }
            buildUpon.setSelectUndeterminedTextLanguage(z);
            for (String str : strArr) {
                buildUpon.setPreferredTextLanguage(str);
                addTrackSelection(i2, buildUpon.build());
            }
        }
    }

    public void addTrackSelection(int i2, DefaultTrackSelector.Parameters parameters) {
        Assertions.checkState(this.h);
        this.c.setParameters(parameters);
        a(i2);
    }

    public void addTrackSelectionForSingleRenderer(int i2, int i3, DefaultTrackSelector.Parameters parameters, List<DefaultTrackSelector.SelectionOverride> list) {
        Assertions.checkState(this.h);
        DefaultTrackSelector.ParametersBuilder buildUpon = parameters.buildUpon();
        int i4 = 0;
        while (i4 < this.l[i2].getRendererCount()) {
            buildUpon.setRendererDisabled(i4, i4 != i3);
            i4++;
        }
        if (list.isEmpty()) {
            addTrackSelection(i2, buildUpon.build());
            return;
        }
        TrackGroupArray trackGroups = this.l[i2].getTrackGroups(i3);
        for (int i5 = 0; i5 < list.size(); i5++) {
            buildUpon.setSelectionOverride(i3, trackGroups, list.get(i5));
            addTrackSelection(i2, buildUpon.build());
        }
    }

    public void clearTrackSelections(int i2) {
        Assertions.checkState(this.h);
        for (int i3 = 0; i3 < this.d.length; i3++) {
            this.m[i2][i3].clear();
        }
    }

    public DownloadRequest getDownloadRequest(@Nullable byte[] bArr) {
        return getDownloadRequest(this.a.uri.toString(), bArr);
    }

    @Nullable
    public Object getManifest() {
        if (this.b == null) {
            return null;
        }
        Assertions.checkState(this.h);
        if (this.j.h.getWindowCount() > 0) {
            return this.j.h.getWindow(0, this.g).manifest;
        }
        return null;
    }

    public MappingTrackSelector.MappedTrackInfo getMappedTrackInfo(int i2) {
        Assertions.checkState(this.h);
        return this.l[i2];
    }

    public int getPeriodCount() {
        if (this.b == null) {
            return 0;
        }
        Assertions.checkState(this.h);
        return this.k.length;
    }

    public TrackGroupArray getTrackGroups(int i2) {
        Assertions.checkState(this.h);
        return this.k[i2];
    }

    public List<TrackSelection> getTrackSelections(int i2, int i3) {
        Assertions.checkState(this.h);
        return this.n[i2][i3];
    }

    public void prepare(Callback callback) {
        Assertions.checkState(this.i == null);
        this.i = callback;
        MediaSource mediaSource = this.b;
        if (mediaSource != null) {
            this.j = new e(mediaSource, this);
        } else {
            this.f.post(new Runnable(callback) { // from class: a2.j.b.b.x0.g
                public final /* synthetic */ DownloadHelper.Callback b;

                {
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    DownloadHelper downloadHelper = DownloadHelper.this;
                    DownloadHelper.Callback callback2 = this.b;
                    Objects.requireNonNull(downloadHelper);
                    callback2.onPrepared(downloadHelper);
                }
            });
        }
    }

    public void release() {
        e eVar = this.j;
        if (eVar != null && !eVar.j) {
            eVar.j = true;
            eVar.g.sendEmptyMessage(3);
        }
    }

    public void replaceTrackSelections(int i2, DefaultTrackSelector.Parameters parameters) {
        clearTrackSelections(i2);
        addTrackSelection(i2, parameters);
    }

    public static MediaSource createMediaSource(DownloadRequest downloadRequest, DataSource.Factory factory, @Nullable DrmSessionManager drmSessionManager) {
        return new DefaultMediaSourceFactory(factory, ExtractorsFactory.EMPTY).setDrmSessionManager(drmSessionManager).createMediaSource(downloadRequest.toMediaItem());
    }

    @Deprecated
    public static DownloadHelper forProgressive(Context context, Uri uri, @Nullable String str) {
        return forMediaItem(context, new MediaItem.Builder().setUri(uri).setCustomCacheKey(str).build());
    }

    @Deprecated
    public static DownloadHelper forSmoothStreaming(Context context, Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forSmoothStreaming(uri, factory, renderersFactory, null, getDefaultTrackSelectorParameters(context));
    }

    public DownloadRequest getDownloadRequest(String str, @Nullable byte[] bArr) {
        DownloadRequest.Builder mimeType = new DownloadRequest.Builder(str, this.a.uri).setMimeType(this.a.mimeType);
        MediaItem.DrmConfiguration drmConfiguration = this.a.drmConfiguration;
        DownloadRequest.Builder data = mimeType.setKeySetId(drmConfiguration != null ? drmConfiguration.getKeySetId() : null).setCustomCacheKey(this.a.customCacheKey).setData(bArr);
        if (this.b == null) {
            return data.build();
        }
        Assertions.checkState(this.h);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = this.m.length;
        for (int i2 = 0; i2 < length; i2++) {
            arrayList2.clear();
            int length2 = this.m[i2].length;
            for (int i3 = 0; i3 < length2; i3++) {
                arrayList2.addAll(this.m[i2][i3]);
            }
            arrayList.addAll(this.j.i[i2].getStreamKeys(arrayList2));
        }
        return data.setStreamKeys(arrayList).build();
    }

    @Deprecated
    public static DownloadHelper forDash(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager drmSessionManager, DefaultTrackSelector.Parameters parameters) {
        return forMediaItem(new MediaItem.Builder().setUri(uri).setMimeType(MimeTypes.APPLICATION_MPD).build(), parameters, renderersFactory, factory, drmSessionManager);
    }

    @Deprecated
    public static DownloadHelper forHls(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager drmSessionManager, DefaultTrackSelector.Parameters parameters) {
        return forMediaItem(new MediaItem.Builder().setUri(uri).setMimeType(MimeTypes.APPLICATION_M3U8).build(), parameters, renderersFactory, factory, drmSessionManager);
    }

    @Deprecated
    public static DownloadHelper forSmoothStreaming(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager drmSessionManager, DefaultTrackSelector.Parameters parameters) {
        return forMediaItem(new MediaItem.Builder().setUri(uri).setMimeType(MimeTypes.APPLICATION_SS).build(), parameters, renderersFactory, factory, drmSessionManager);
    }

    public static DownloadHelper forMediaItem(Context context, MediaItem mediaItem, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory) {
        return forMediaItem(mediaItem, getDefaultTrackSelectorParameters(context), renderersFactory, factory, null);
    }

    public static DownloadHelper forMediaItem(MediaItem mediaItem, DefaultTrackSelector.Parameters parameters, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory) {
        return forMediaItem(mediaItem, parameters, renderersFactory, factory, null);
    }

    public static DownloadHelper forMediaItem(MediaItem mediaItem, DefaultTrackSelector.Parameters parameters, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory, @Nullable DrmSessionManager drmSessionManager) {
        MediaSource mediaSource;
        MediaItem.PlaybackProperties playbackProperties = (MediaItem.PlaybackProperties) Assertions.checkNotNull(mediaItem.playbackProperties);
        boolean z = true;
        boolean z2 = Util.inferContentTypeForUriAndMimeType(playbackProperties.uri, playbackProperties.mimeType) == 3;
        if (!z2 && factory == null) {
            z = false;
        }
        Assertions.checkArgument(z);
        if (z2) {
            mediaSource = null;
        } else {
            mediaSource = new DefaultMediaSourceFactory((DataSource.Factory) Util.castNonNull(factory), ExtractorsFactory.EMPTY).setDrmSessionManager(drmSessionManager).createMediaSource(mediaItem);
        }
        return new DownloadHelper(mediaItem, mediaSource, parameters, renderersFactory != null ? getRendererCapabilities(renderersFactory) : new RendererCapabilities[0]);
    }
}
