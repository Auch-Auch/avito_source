package com.otaliastudios.cameraview.video.encoding;

import a2.m.a.d.a.f;
import a2.m.a.d.a.g;
import a2.m.a.d.a.h;
import a2.m.a.d.a.i;
import a2.m.a.d.a.j;
import a2.m.a.d.a.k;
import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.internal.WorkerHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
@RequiresApi(api = 18)
public class MediaEncoderEngine {
    public static final int END_BY_MAX_DURATION = 1;
    public static final int END_BY_MAX_SIZE = 2;
    public static final int END_BY_USER = 0;
    public static final CameraLogger l = CameraLogger.create(MediaEncoderEngine.class.getSimpleName());
    public final List<MediaEncoder> a;
    public MediaMuxer b;
    public int c = 0;
    public int d = 0;
    public boolean e = false;
    public final Controller f = new Controller();
    public final WorkerHandler g = WorkerHandler.get("EncoderEngine");
    public final Object h = new Object();
    public Listener i;
    public int j = 0;
    public int k;

    public class Controller {
        @SuppressLint({"UseSparseArrays"})
        public Map<Integer, Integer> a = new HashMap();

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaEncoderEngine.this.b.start();
                MediaEncoderEngine mediaEncoderEngine = MediaEncoderEngine.this;
                mediaEncoderEngine.e = true;
                Listener listener = mediaEncoderEngine.i;
                if (listener != null) {
                    listener.onEncodingStart();
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaEncoderEngine.this.stop();
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Exception e;
                MediaEncoderEngine mediaEncoderEngine = MediaEncoderEngine.this;
                CameraLogger cameraLogger = MediaEncoderEngine.l;
                Objects.requireNonNull(mediaEncoderEngine);
                MediaEncoderEngine.l.i("end:", "Releasing muxer after all encoders have been released.");
                MediaMuxer mediaMuxer = mediaEncoderEngine.b;
                if (mediaMuxer != null) {
                    try {
                        mediaMuxer.stop();
                        e = null;
                    } catch (Exception e2) {
                        e = e2;
                    }
                    try {
                        mediaEncoderEngine.b.release();
                    } catch (Exception e3) {
                        if (e == null) {
                            e = e3;
                        }
                    }
                    mediaEncoderEngine.b = null;
                } else {
                    e = null;
                }
                CameraLogger cameraLogger2 = MediaEncoderEngine.l;
                cameraLogger2.w("end:", "Dispatching end to listener - reason:", Integer.valueOf(mediaEncoderEngine.j), "error:", e);
                Listener listener = mediaEncoderEngine.i;
                if (listener != null) {
                    listener.onEncodingEnd(mediaEncoderEngine.j, e);
                    mediaEncoderEngine.i = null;
                }
                mediaEncoderEngine.j = 0;
                mediaEncoderEngine.c = 0;
                mediaEncoderEngine.d = 0;
                mediaEncoderEngine.e = false;
                mediaEncoderEngine.g.destroy();
                cameraLogger2.i("end:", "Completed.");
            }
        }

        public Controller() {
        }

        public boolean isStarted() {
            boolean z;
            synchronized (MediaEncoderEngine.this.h) {
                z = MediaEncoderEngine.this.e;
            }
            return z;
        }

        public int notifyStarted(@NonNull MediaFormat mediaFormat) {
            int addTrack;
            synchronized (MediaEncoderEngine.this.h) {
                MediaEncoderEngine mediaEncoderEngine = MediaEncoderEngine.this;
                if (!mediaEncoderEngine.e) {
                    addTrack = mediaEncoderEngine.b.addTrack(mediaFormat);
                    CameraLogger cameraLogger = MediaEncoderEngine.l;
                    cameraLogger.w("notifyStarted:", "Assigned track", Integer.valueOf(addTrack), "to format", mediaFormat.getString("mime"));
                    MediaEncoderEngine mediaEncoderEngine2 = MediaEncoderEngine.this;
                    int i = mediaEncoderEngine2.c + 1;
                    mediaEncoderEngine2.c = i;
                    if (i == mediaEncoderEngine2.a.size()) {
                        cameraLogger.w("notifyStarted:", "All encoders have started.", "Starting muxer and dispatching onEncodingStart().");
                        MediaEncoderEngine.this.g.run(new a());
                    }
                } else {
                    throw new IllegalStateException("Trying to start but muxer started already");
                }
            }
            return addTrack;
        }

        public void notifyStopped(int i) {
            synchronized (MediaEncoderEngine.this.h) {
                CameraLogger cameraLogger = MediaEncoderEngine.l;
                cameraLogger.w("notifyStopped:", "Called for track", Integer.valueOf(i));
                MediaEncoderEngine mediaEncoderEngine = MediaEncoderEngine.this;
                int i2 = mediaEncoderEngine.d + 1;
                mediaEncoderEngine.d = i2;
                if (i2 == mediaEncoderEngine.a.size()) {
                    cameraLogger.w("requestStop:", "All encoders have been stopped.", "Stopping the muxer.");
                    MediaEncoderEngine.this.g.run(new c());
                }
            }
        }

        public void requestStop(int i) {
            synchronized (MediaEncoderEngine.this.h) {
                CameraLogger cameraLogger = MediaEncoderEngine.l;
                cameraLogger.w("requestStop:", "Called for track", Integer.valueOf(i));
                MediaEncoderEngine mediaEncoderEngine = MediaEncoderEngine.this;
                int i2 = mediaEncoderEngine.c - 1;
                mediaEncoderEngine.c = i2;
                if (i2 == 0) {
                    cameraLogger.w("requestStop:", "All encoders have requested a stop.", "Stopping them.");
                    MediaEncoderEngine mediaEncoderEngine2 = MediaEncoderEngine.this;
                    mediaEncoderEngine2.j = mediaEncoderEngine2.k;
                    mediaEncoderEngine2.g.run(new b());
                }
            }
        }

        public void write(@NonNull j jVar, @NonNull OutputBuffer outputBuffer) {
            int i;
            Integer num = this.a.get(Integer.valueOf(outputBuffer.trackIndex));
            Map<Integer, Integer> map = this.a;
            Integer valueOf = Integer.valueOf(outputBuffer.trackIndex);
            if (num == null) {
                i = 1;
            } else {
                num = Integer.valueOf(num.intValue() + 1);
                i = num.intValue();
            }
            map.put(valueOf, Integer.valueOf(i));
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(outputBuffer.info.presentationTimeUs / 1000);
            CameraLogger cameraLogger = MediaEncoderEngine.l;
            cameraLogger.v("write:", "Writing into muxer -", "track:", Integer.valueOf(outputBuffer.trackIndex), "presentation:", Long.valueOf(outputBuffer.info.presentationTimeUs), "readable:", instance.get(13) + ":" + instance.get(14), "count:", num);
            MediaEncoderEngine.this.b.writeSampleData(outputBuffer.trackIndex, outputBuffer.data, outputBuffer.info);
            jVar.recycle(outputBuffer);
        }
    }

    public interface Listener {
        @EncoderThread
        void onEncodingEnd(int i, @Nullable Exception exc);

        @EncoderThread
        void onEncodingStart();

        @EncoderThread
        void onEncodingStop();
    }

    public MediaEncoderEngine(@NonNull File file, @NonNull k kVar, @Nullable AudioMediaEncoder audioMediaEncoder, int i2, long j2, @Nullable Listener listener) {
        ArrayList<MediaEncoder> arrayList = new ArrayList();
        this.a = arrayList;
        this.i = listener;
        arrayList.add(kVar);
        if (audioMediaEncoder != null) {
            arrayList.add(audioMediaEncoder);
        }
        try {
            this.b = new MediaMuxer(file.toString(), 0);
            int i3 = 0;
            for (MediaEncoder mediaEncoder : arrayList) {
                i3 += mediaEncoder.getEncodedBitRate();
            }
            long j3 = (j2 / ((long) (i3 / 8))) * 1000 * 1000;
            long j4 = ((long) i2) * 1000;
            int i4 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i4 > 0 && i2 > 0) {
                this.k = j3 < j4 ? 2 : 1;
                j3 = Math.min(j3, j4);
            } else if (i4 > 0) {
                this.k = 2;
            } else if (i2 > 0) {
                this.k = 1;
                j3 = j4;
            } else {
                j3 = Long.MAX_VALUE;
            }
            l.w("Computed a max duration of", Float.valueOf(((float) j3) / 1000000.0f));
            for (MediaEncoder mediaEncoder2 : this.a) {
                Controller controller = this.f;
                int i5 = mediaEncoder2.a;
                if (i5 >= 1) {
                    MediaEncoder.o.e(mediaEncoder2.b, "Wrong state while preparing. Aborting.", Integer.valueOf(i5));
                } else {
                    mediaEncoder2.c = controller;
                    mediaEncoder2.f = new MediaCodec.BufferInfo();
                    mediaEncoder2.i = j3;
                    WorkerHandler workerHandler = WorkerHandler.get(mediaEncoder2.b);
                    mediaEncoder2.mWorker = workerHandler;
                    workerHandler.getThread().setPriority(10);
                    MediaEncoder.o.i(mediaEncoder2.b, "Prepare was called. Posting.");
                    mediaEncoder2.mWorker.post(new f(mediaEncoder2, controller, j3));
                }
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Nullable
    public AudioMediaEncoder getAudioEncoder() {
        if (this.a.size() > 1) {
            return (AudioMediaEncoder) this.a.get(1);
        }
        return null;
    }

    @NonNull
    public k getVideoEncoder() {
        return (k) this.a.get(0);
    }

    public final void notify(String str, Object obj) {
        l.v("Passing event to encoders:", str);
        for (MediaEncoder mediaEncoder : this.a) {
            if (!mediaEncoder.h.containsKey(str)) {
                mediaEncoder.h.put(str, new AtomicInteger(0));
            }
            AtomicInteger atomicInteger = mediaEncoder.h.get(str);
            atomicInteger.incrementAndGet();
            MediaEncoder.o.v(mediaEncoder.b, "Notify was called. Posting. pendingEvents:", Integer.valueOf(atomicInteger.intValue()));
            mediaEncoder.mWorker.post(new h(mediaEncoder, atomicInteger, str, obj));
        }
    }

    public final void start() {
        l.i("Passing event to encoders:", "START");
        for (MediaEncoder mediaEncoder : this.a) {
            MediaEncoder.o.w(mediaEncoder.b, "Start was called. Posting.");
            mediaEncoder.mWorker.post(new g(mediaEncoder));
        }
    }

    public final void stop() {
        l.i("Passing event to encoders:", "STOP");
        for (MediaEncoder mediaEncoder : this.a) {
            int i2 = mediaEncoder.a;
            if (i2 >= 6) {
                MediaEncoder.o.e(mediaEncoder.b, "Wrong state while stopping. Aborting.", Integer.valueOf(i2));
            } else {
                mediaEncoder.b(6);
                MediaEncoder.o.w(mediaEncoder.b, "Stop was called. Posting.");
                mediaEncoder.mWorker.post(new i(mediaEncoder));
            }
        }
        Listener listener = this.i;
        if (listener != null) {
            listener.onEncodingStop();
        }
    }
}
