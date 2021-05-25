package com.google.android.exoplayer2.source.dash;

import a2.j.b.b.u0.d;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
public final class PlayerEmsgHandler implements Handler.Callback {
    public final Allocator a;
    public final PlayerEmsgCallback b;
    public final EventMessageDecoder c = new EventMessageDecoder();
    public final Handler d = Util.createHandler(this);
    public final TreeMap<Long, Long> e = new TreeMap<>();
    public DashManifest f;
    public long g;
    public long h = C.TIME_UNSET;
    public long i = C.TIME_UNSET;
    public boolean j;
    public boolean k;

    public interface PlayerEmsgCallback {
        void onDashManifestPublishTimeExpired(long j);

        void onDashManifestRefreshRequested();
    }

    public final class PlayerTrackEmsgHandler implements TrackOutput {
        public final SampleQueue a;
        public final FormatHolder b = new FormatHolder();
        public final MetadataInputBuffer c = new MetadataInputBuffer();

        public PlayerTrackEmsgHandler(Allocator allocator) {
            this.a = new SampleQueue(allocator, PlayerEmsgHandler.this.d.getLooper(), DrmSessionManager.DUMMY);
        }

        @Nullable
        public final MetadataInputBuffer a() {
            this.c.clear();
            if (this.a.read(this.b, this.c, false, false, 0) != -4) {
                return null;
            }
            this.c.flip();
            return this.c;
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(Format format) {
            this.a.format(format);
        }

        public boolean maybeRefreshManifestBeforeLoadingNextChunk(long j) {
            PlayerEmsgHandler playerEmsgHandler = PlayerEmsgHandler.this;
            DashManifest dashManifest = playerEmsgHandler.f;
            boolean z = false;
            if (!dashManifest.dynamic) {
                return false;
            }
            if (playerEmsgHandler.j) {
                return true;
            }
            Map.Entry<Long, Long> ceilingEntry = playerEmsgHandler.e.ceilingEntry(Long.valueOf(dashManifest.publishTimeMs));
            if (ceilingEntry != null && ceilingEntry.getValue().longValue() < j) {
                long longValue = ceilingEntry.getKey().longValue();
                playerEmsgHandler.g = longValue;
                playerEmsgHandler.b.onDashManifestPublishTimeExpired(longValue);
                z = true;
            }
            if (!z) {
                return z;
            }
            playerEmsgHandler.a();
            return z;
        }

        public boolean maybeRefreshManifestOnLoadingError(Chunk chunk) {
            PlayerEmsgHandler playerEmsgHandler = PlayerEmsgHandler.this;
            if (playerEmsgHandler.f.dynamic) {
                if (playerEmsgHandler.j) {
                    return true;
                }
                long j = playerEmsgHandler.h;
                if (j != C.TIME_UNSET && j < chunk.startTimeUs) {
                    playerEmsgHandler.a();
                    return true;
                }
            }
            return false;
        }

        public void onChunkLoadCompleted(Chunk chunk) {
            PlayerEmsgHandler playerEmsgHandler = PlayerEmsgHandler.this;
            long j = playerEmsgHandler.h;
            if (j != C.TIME_UNSET || chunk.endTimeUs > j) {
                playerEmsgHandler.h = chunk.endTimeUs;
            }
        }

        public void release() {
            this.a.release();
        }

        public int sampleData(ExtractorInput extractorInput, int i, boolean z) throws IOException, InterruptedException {
            return this.a.sampleData(extractorInput, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ int sampleData(DataReader dataReader, int i, boolean z) {
            return d.$default$sampleData(this, dataReader, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long j, int i, int i2, int i3, @Nullable TrackOutput.CryptoData cryptoData) {
            long j2;
            this.a.sampleMetadata(j, i, i2, i3, cryptoData);
            while (this.a.isReady(false)) {
                MetadataInputBuffer a3 = a();
                if (a3 != null) {
                    long j3 = a3.timeUs;
                    EventMessage eventMessage = (EventMessage) PlayerEmsgHandler.this.c.decode(a3).get(0);
                    if (PlayerEmsgHandler.isPlayerEmsgEvent(eventMessage.schemeIdUri, eventMessage.value)) {
                        try {
                            j2 = Util.parseXsDateTime(Util.fromUtf8Bytes(eventMessage.messageData));
                        } catch (ParserException unused) {
                            j2 = -9223372036854775807L;
                        }
                        if (j2 != C.TIME_UNSET) {
                            a aVar = new a(j3, j2);
                            Handler handler = PlayerEmsgHandler.this.d;
                            handler.sendMessage(handler.obtainMessage(1, aVar));
                        }
                    }
                }
            }
            this.a.discardToRead();
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(ParsableByteArray parsableByteArray, int i) {
            this.a.sampleData(parsableByteArray, i);
        }
    }

    public static final class a {
        public final long a;
        public final long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    public PlayerEmsgHandler(DashManifest dashManifest, PlayerEmsgCallback playerEmsgCallback, Allocator allocator) {
        this.f = dashManifest;
        this.b = playerEmsgCallback;
        this.a = allocator;
    }

    public static boolean isPlayerEmsgEvent(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || ExifInterface.GPS_MEASUREMENT_2D.equals(str2) || ExifInterface.GPS_MEASUREMENT_3D.equals(str2));
    }

    public final void a() {
        long j2 = this.i;
        if (j2 == C.TIME_UNSET || j2 != this.h) {
            this.j = true;
            this.i = this.h;
            this.b.onDashManifestRefreshRequested();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.k) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        long j2 = aVar.a;
        long j3 = aVar.b;
        Long l = this.e.get(Long.valueOf(j3));
        if (l == null) {
            this.e.put(Long.valueOf(j3), Long.valueOf(j2));
        } else if (l.longValue() > j2) {
            this.e.put(Long.valueOf(j3), Long.valueOf(j2));
        }
        return true;
    }

    public PlayerTrackEmsgHandler newPlayerTrackEmsgHandler() {
        return new PlayerTrackEmsgHandler(this.a);
    }

    public void release() {
        this.k = true;
        this.d.removeCallbacksAndMessages(null);
    }

    public void updateManifest(DashManifest dashManifest) {
        this.j = false;
        this.g = C.TIME_UNSET;
        this.f = dashManifest;
        Iterator<Map.Entry<Long, Long>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().longValue() < this.f.publishTimeMs) {
                it.remove();
            }
        }
    }
}
