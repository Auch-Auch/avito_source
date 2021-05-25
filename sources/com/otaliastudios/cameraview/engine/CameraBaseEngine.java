package com.otaliastudios.cameraview.engine;

import android.location.Location;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.frame.FrameManager;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.picture.PictureRecorder;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.cameraview.size.SizeSelector;
import com.otaliastudios.cameraview.size.SizeSelectors;
import com.otaliastudios.cameraview.video.VideoRecorder;
import java.io.File;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public abstract class CameraBaseEngine extends CameraEngine {
    public static final int ALLOWED_EV_OPS = 20;
    public static final int ALLOWED_ZOOM_OPS = 20;
    public boolean e;
    public FrameManager f;
    public final Angles g = new Angles();
    @Nullable
    public SizeSelector h;
    public SizeSelector i;
    public SizeSelector j;
    public Facing k;
    public Mode l;
    public Audio m;
    public AudioCodec mAudioCodec;
    public CameraOptions mCameraOptions;
    public Size mCaptureSize;
    public float mExposureCorrectionValue;
    public Flash mFlash;
    public int mFrameProcessingFormat;
    public Size mFrameProcessingSize;
    public boolean mHasFrameProcessors;
    public Hdr mHdr;
    public Location mLocation;
    public PictureFormat mPictureFormat;
    public boolean mPictureMetering;
    public PictureRecorder mPictureRecorder;
    public boolean mPictureSnapshotMetering;
    public boolean mPlaySounds;
    public CameraPreview mPreview;
    public float mPreviewFrameRate;
    public Size mPreviewStreamSize;
    public VideoCodec mVideoCodec;
    public VideoRecorder mVideoRecorder;
    public WhiteBalance mWhiteBalance;
    public float mZoomValue;
    public long n;
    public int o;
    public int p;
    public int q;
    public long r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public Overlay x;

    public class a implements Runnable {
        public final /* synthetic */ Facing a;
        public final /* synthetic */ Facing b;

        public a(Facing facing, Facing facing2) {
            this.a = facing;
            this.b = facing2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CameraBaseEngine.this.collectCameraInfo(this.a)) {
                CameraBaseEngine.this.restart();
                return;
            }
            CameraBaseEngine.this.k = this.b;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraBaseEngine.this.restart();
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ PictureResult.Stub a;
        public final /* synthetic */ boolean b;

        public c(PictureResult.Stub stub, boolean z) {
            this.a = stub;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraEngine.LOG.i("takePicture:", "running. isTakingPicture:", Boolean.valueOf(CameraBaseEngine.this.isTakingPicture()));
            if (!CameraBaseEngine.this.isTakingPicture()) {
                CameraBaseEngine cameraBaseEngine = CameraBaseEngine.this;
                if (cameraBaseEngine.l != Mode.VIDEO) {
                    PictureResult.Stub stub = this.a;
                    stub.isSnapshot = false;
                    stub.location = cameraBaseEngine.mLocation;
                    stub.facing = cameraBaseEngine.k;
                    stub.format = cameraBaseEngine.mPictureFormat;
                    cameraBaseEngine.onTakePicture(stub, this.b);
                    return;
                }
                throw new IllegalStateException("Can't take hq pictures while in VIDEO mode");
            }
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ PictureResult.Stub a;
        public final /* synthetic */ boolean b;

        public d(PictureResult.Stub stub, boolean z) {
            this.a = stub;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraEngine.LOG.i("takePictureSnapshot:", "running. isTakingPicture:", Boolean.valueOf(CameraBaseEngine.this.isTakingPicture()));
            if (!CameraBaseEngine.this.isTakingPicture()) {
                PictureResult.Stub stub = this.a;
                CameraBaseEngine cameraBaseEngine = CameraBaseEngine.this;
                stub.location = cameraBaseEngine.mLocation;
                stub.isSnapshot = true;
                stub.facing = cameraBaseEngine.k;
                stub.format = PictureFormat.JPEG;
                CameraBaseEngine.this.onTakePictureSnapshot(this.a, AspectRatio.of(cameraBaseEngine.h(Reference.OUTPUT)), this.b);
            }
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ File a;
        public final /* synthetic */ VideoResult.Stub b;
        public final /* synthetic */ FileDescriptor c;

        public e(File file, VideoResult.Stub stub, FileDescriptor fileDescriptor) {
            this.a = file;
            this.b = stub;
            this.c = fileDescriptor;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraEngine.LOG.i("takeVideo:", "running. isTakingVideo:", Boolean.valueOf(CameraBaseEngine.this.isTakingVideo()));
            if (!CameraBaseEngine.this.isTakingVideo()) {
                CameraBaseEngine cameraBaseEngine = CameraBaseEngine.this;
                if (cameraBaseEngine.l != Mode.PICTURE) {
                    File file = this.a;
                    if (file != null) {
                        this.b.file = file;
                    } else {
                        FileDescriptor fileDescriptor = this.c;
                        if (fileDescriptor != null) {
                            this.b.fileDescriptor = fileDescriptor;
                        } else {
                            throw new IllegalStateException("file and fileDescriptor are both null.");
                        }
                    }
                    VideoResult.Stub stub = this.b;
                    stub.isSnapshot = false;
                    stub.videoCodec = cameraBaseEngine.mVideoCodec;
                    stub.audioCodec = cameraBaseEngine.mAudioCodec;
                    stub.location = cameraBaseEngine.mLocation;
                    stub.facing = cameraBaseEngine.k;
                    stub.audio = cameraBaseEngine.m;
                    stub.maxSize = cameraBaseEngine.n;
                    stub.maxDuration = cameraBaseEngine.o;
                    stub.videoBitRate = cameraBaseEngine.p;
                    stub.audioBitRate = cameraBaseEngine.q;
                    cameraBaseEngine.onTakeVideo(stub);
                    return;
                }
                throw new IllegalStateException("Can't record video while in PICTURE mode");
            }
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ VideoResult.Stub a;
        public final /* synthetic */ File b;

        public f(VideoResult.Stub stub, File file) {
            this.a = stub;
            this.b = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraEngine.LOG.i("takeVideoSnapshot:", "running. isTakingVideo:", Boolean.valueOf(CameraBaseEngine.this.isTakingVideo()));
            VideoResult.Stub stub = this.a;
            stub.file = this.b;
            stub.isSnapshot = true;
            CameraBaseEngine cameraBaseEngine = CameraBaseEngine.this;
            stub.videoCodec = cameraBaseEngine.mVideoCodec;
            stub.audioCodec = cameraBaseEngine.mAudioCodec;
            stub.location = cameraBaseEngine.mLocation;
            stub.facing = cameraBaseEngine.k;
            stub.videoBitRate = cameraBaseEngine.p;
            stub.audioBitRate = cameraBaseEngine.q;
            stub.audio = cameraBaseEngine.m;
            stub.maxSize = cameraBaseEngine.n;
            stub.maxDuration = cameraBaseEngine.o;
            CameraBaseEngine.this.onTakeVideoSnapshot(this.a, AspectRatio.of(cameraBaseEngine.h(Reference.OUTPUT)));
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraEngine.LOG.i("stopVideo", "running. isTakingVideo?", Boolean.valueOf(CameraBaseEngine.this.isTakingVideo()));
            CameraBaseEngine.this.onStopVideo();
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Size computePreviewStreamSize = CameraBaseEngine.this.computePreviewStreamSize();
            if (computePreviewStreamSize.equals(CameraBaseEngine.this.mPreviewStreamSize)) {
                CameraEngine.LOG.i("onSurfaceChanged:", "The computed preview size is identical. No op.");
                return;
            }
            CameraEngine.LOG.i("onSurfaceChanged:", "Computed a new preview size. Calling onPreviewStreamSizeChanged().");
            CameraBaseEngine cameraBaseEngine = CameraBaseEngine.this;
            cameraBaseEngine.mPreviewStreamSize = computePreviewStreamSize;
            cameraBaseEngine.onPreviewStreamSizeChanged();
        }
    }

    public CameraBaseEngine(@NonNull CameraEngine.Callback callback) {
        super(callback);
        Tasks.forResult(null);
        Tasks.forResult(null);
        Tasks.forResult(null);
        Tasks.forResult(null);
        Tasks.forResult(null);
        Tasks.forResult(null);
        Tasks.forResult(null);
        Tasks.forResult(null);
    }

    @NonNull
    public final Size computeCaptureSize() {
        return computeCaptureSize(this.l);
    }

    @NonNull
    @EngineThread
    public final Size computeFrameProcessingSize() {
        List<Size> frameProcessingAvailableSizes = getFrameProcessingAvailableSizes();
        boolean flip = getAngles().flip(Reference.SENSOR, Reference.VIEW);
        ArrayList arrayList = new ArrayList(frameProcessingAvailableSizes.size());
        for (Size size : frameProcessingAvailableSizes) {
            if (flip) {
                size = size.flip();
            }
            arrayList.add(size);
        }
        AspectRatio of = AspectRatio.of(this.mPreviewStreamSize.getWidth(), this.mPreviewStreamSize.getHeight());
        if (flip) {
            of = of.flip();
        }
        int i2 = this.u;
        int i3 = this.v;
        if (i2 <= 0 || i2 == Integer.MAX_VALUE) {
            i2 = 640;
        }
        if (i3 <= 0 || i3 == Integer.MAX_VALUE) {
            i3 = 640;
        }
        Size size2 = new Size(i2, i3);
        CameraLogger cameraLogger = CameraEngine.LOG;
        cameraLogger.i("computeFrameProcessingSize:", "targetRatio:", of, "targetMaxSize:", size2);
        SizeSelector aspectRatio = SizeSelectors.aspectRatio(of, 0.0f);
        SizeSelector and = SizeSelectors.and(SizeSelectors.maxHeight(size2.getHeight()), SizeSelectors.maxWidth(size2.getWidth()), SizeSelectors.biggest());
        Size size3 = SizeSelectors.or(SizeSelectors.and(aspectRatio, and), and, SizeSelectors.smallest()).select(arrayList).get(0);
        if (arrayList.contains(size3)) {
            if (flip) {
                size3 = size3.flip();
            }
            cameraLogger.i("computeFrameProcessingSize:", "result:", size3, "flip:", Boolean.valueOf(flip));
            return size3;
        }
        throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
    }

    @NonNull
    @EngineThread
    public final Size computePreviewStreamSize() {
        List<Size> previewStreamAvailableSizes = getPreviewStreamAvailableSizes();
        boolean flip = getAngles().flip(Reference.SENSOR, Reference.VIEW);
        ArrayList arrayList = new ArrayList(previewStreamAvailableSizes.size());
        for (Size size : previewStreamAvailableSizes) {
            if (flip) {
                size = size.flip();
            }
            arrayList.add(size);
        }
        Size h2 = h(Reference.VIEW);
        if (h2 != null) {
            AspectRatio of = AspectRatio.of(this.mCaptureSize.getWidth(), this.mCaptureSize.getHeight());
            if (flip) {
                of = of.flip();
            }
            CameraLogger cameraLogger = CameraEngine.LOG;
            cameraLogger.i("computePreviewStreamSize:", "targetRatio:", of, "targetMinSize:", h2);
            SizeSelector and = SizeSelectors.and(SizeSelectors.aspectRatio(of, 0.0f), SizeSelectors.biggest());
            SizeSelector and2 = SizeSelectors.and(SizeSelectors.minHeight(h2.getHeight()), SizeSelectors.minWidth(h2.getWidth()), SizeSelectors.smallest());
            SizeSelector or = SizeSelectors.or(SizeSelectors.and(and, and2), and2, and, SizeSelectors.biggest());
            SizeSelector sizeSelector = this.h;
            if (sizeSelector != null) {
                or = SizeSelectors.or(sizeSelector, or);
            }
            Size size2 = or.select(arrayList).get(0);
            if (arrayList.contains(size2)) {
                if (flip) {
                    size2 = size2.flip();
                }
                cameraLogger.i("computePreviewStreamSize:", "result:", size2, "flip:", Boolean.valueOf(flip));
                return size2;
            }
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        throw new IllegalStateException("targetMinSize should not be null here.");
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public final Angles getAngles() {
        return this.g;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public final Audio getAudio() {
        return this.m;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getAudioBitRate() {
        return this.q;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public final AudioCodec getAudioCodec() {
        return this.mAudioCodec;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final long getAutoFocusResetDelay() {
        return this.r;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @Nullable
    public final CameraOptions getCameraOptions() {
        return this.mCameraOptions;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final float getExposureCorrectionValue() {
        return this.mExposureCorrectionValue;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public final Facing getFacing() {
        return this.k;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public final Flash getFlash() {
        return this.mFlash;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public FrameManager getFrameManager() {
        if (this.f == null) {
            this.f = instantiateFrameManager(this.w);
        }
        return this.f;
    }

    @NonNull
    @EngineThread
    public abstract List<Size> getFrameProcessingAvailableSizes();

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getFrameProcessingFormat() {
        return this.mFrameProcessingFormat;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getFrameProcessingMaxHeight() {
        return this.v;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getFrameProcessingMaxWidth() {
        return this.u;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getFrameProcessingPoolSize() {
        return this.w;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public final Hdr getHdr() {
        return this.mHdr;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @Nullable
    public final Location getLocation() {
        return this.mLocation;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public final Mode getMode() {
        return this.l;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @Nullable
    public final Overlay getOverlay() {
        return this.x;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public final PictureFormat getPictureFormat() {
        return this.mPictureFormat;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean getPictureMetering() {
        return this.mPictureMetering;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @Nullable
    public final Size getPictureSize(@NonNull Reference reference) {
        Size size = this.mCaptureSize;
        if (size == null || this.l == Mode.VIDEO) {
            return null;
        }
        return getAngles().flip(Reference.SENSOR, reference) ? size.flip() : size;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public final SizeSelector getPictureSizeSelector() {
        return this.i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean getPictureSnapshotMetering() {
        return this.mPictureSnapshotMetering;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public final CameraPreview getPreview() {
        return this.mPreview;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final float getPreviewFrameRate() {
        return this.mPreviewFrameRate;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean getPreviewFrameRateExact() {
        return this.e;
    }

    @NonNull
    @EngineThread
    public abstract List<Size> getPreviewStreamAvailableSizes();

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @Nullable
    public final Size getPreviewStreamSize(@NonNull Reference reference) {
        Size size = this.mPreviewStreamSize;
        if (size == null) {
            return null;
        }
        return getAngles().flip(Reference.SENSOR, reference) ? size.flip() : size;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @Nullable
    public final SizeSelector getPreviewStreamSizeSelector() {
        return this.h;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getSnapshotMaxHeight() {
        return this.t;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getSnapshotMaxWidth() {
        return this.s;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @Nullable
    public final Size getUncroppedSnapshotSize(@NonNull Reference reference) {
        Size previewStreamSize = getPreviewStreamSize(reference);
        if (previewStreamSize == null) {
            return null;
        }
        boolean flip = getAngles().flip(reference, Reference.VIEW);
        int i2 = flip ? this.t : this.s;
        int i3 = flip ? this.s : this.t;
        if (i2 <= 0) {
            i2 = Integer.MAX_VALUE;
        }
        if (i3 <= 0) {
            i3 = Integer.MAX_VALUE;
        }
        float f2 = AspectRatio.of(previewStreamSize).toFloat();
        if (AspectRatio.of(i2, i3).toFloat() >= f2) {
            int min = Math.min(previewStreamSize.getHeight(), i3);
            return new Size((int) Math.floor((double) (((float) min) * f2)), min);
        }
        int min2 = Math.min(previewStreamSize.getWidth(), i2);
        return new Size(min2, (int) Math.floor((double) (((float) min2) / f2)));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getVideoBitRate() {
        return this.p;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public final VideoCodec getVideoCodec() {
        return this.mVideoCodec;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getVideoMaxDuration() {
        return this.o;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final long getVideoMaxSize() {
        return this.n;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @Nullable
    public final Size getVideoSize(@NonNull Reference reference) {
        Size size = this.mCaptureSize;
        if (size == null || this.l == Mode.PICTURE) {
            return null;
        }
        return getAngles().flip(Reference.SENSOR, reference) ? size.flip() : size;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public final SizeSelector getVideoSizeSelector() {
        return this.j;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public final WhiteBalance getWhiteBalance() {
        return this.mWhiteBalance;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final float getZoomValue() {
        return this.mZoomValue;
    }

    @Nullable
    public final Size h(@NonNull Reference reference) {
        CameraPreview cameraPreview = this.mPreview;
        if (cameraPreview == null) {
            return null;
        }
        if (getAngles().flip(Reference.VIEW, reference)) {
            return cameraPreview.getSurfaceSize().flip();
        }
        return cameraPreview.getSurfaceSize();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean hasFrameProcessors() {
        return this.mHasFrameProcessors;
    }

    @NonNull
    public abstract FrameManager instantiateFrameManager(int i2);

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean isTakingPicture() {
        return this.mPictureRecorder != null;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean isTakingVideo() {
        VideoRecorder videoRecorder = this.mVideoRecorder;
        return videoRecorder != null && videoRecorder.isRecording();
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder.PictureResultListener
    public void onPictureResult(@Nullable PictureResult.Stub stub, @Nullable Exception exc) {
        this.mPictureRecorder = null;
        if (stub != null) {
            getCallback().dispatchOnPictureTaken(stub);
            return;
        }
        CameraEngine.LOG.e("onPictureResult", "result is null: something went wrong.", exc);
        getCallback().dispatchError(new CameraException(exc, 4));
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder.PictureResultListener
    public void onPictureShutter(boolean z) {
        getCallback().dispatchOnPictureShutter(!z);
    }

    @EngineThread
    public abstract void onPreviewStreamSizeChanged();

    @EngineThread
    public void onStopVideo() {
        VideoRecorder videoRecorder = this.mVideoRecorder;
        if (videoRecorder != null) {
            videoRecorder.stop(false);
        }
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback
    public final void onSurfaceChanged() {
        CameraEngine.LOG.i("onSurfaceChanged:", "Size is", h(Reference.VIEW));
        getOrchestrator().scheduleStateful("surface changed", CameraState.BIND, new h());
    }

    @EngineThread
    public abstract void onTakePicture(@NonNull PictureResult.Stub stub, boolean z);

    @EngineThread
    public abstract void onTakePictureSnapshot(@NonNull PictureResult.Stub stub, @NonNull AspectRatio aspectRatio, boolean z);

    @EngineThread
    public abstract void onTakeVideo(@NonNull VideoResult.Stub stub);

    @EngineThread
    public abstract void onTakeVideoSnapshot(@NonNull VideoResult.Stub stub, @NonNull AspectRatio aspectRatio);

    @Override // com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener
    public void onVideoRecordingEnd() {
        getCallback().dispatchOnVideoRecordingEnd();
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener
    public void onVideoRecordingStart() {
        getCallback().dispatchOnVideoRecordingStart();
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener
    @CallSuper
    public void onVideoResult(@Nullable VideoResult.Stub stub, @Nullable Exception exc) {
        this.mVideoRecorder = null;
        if (stub != null) {
            getCallback().dispatchOnVideoTaken(stub);
            return;
        }
        CameraEngine.LOG.e("onVideoResult", "result is null: something went wrong.", exc);
        getCallback().dispatchError(new CameraException(exc, 5));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setAudio(@NonNull Audio audio) {
        if (this.m != audio) {
            if (isTakingVideo()) {
                CameraEngine.LOG.w("Audio setting was changed while recording. Changes will take place starting from next video");
            }
            this.m = audio;
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setAudioBitRate(int i2) {
        this.q = i2;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setAudioCodec(@NonNull AudioCodec audioCodec) {
        this.mAudioCodec = audioCodec;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setAutoFocusResetDelay(long j2) {
        this.r = j2;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setFacing(@NonNull Facing facing) {
        Facing facing2 = this.k;
        if (facing != facing2) {
            this.k = facing;
            getOrchestrator().scheduleStateful("facing", CameraState.ENGINE, new a(facing, facing2));
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setFrameProcessingMaxHeight(int i2) {
        this.v = i2;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setFrameProcessingMaxWidth(int i2) {
        this.u = i2;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setFrameProcessingPoolSize(int i2) {
        this.w = i2;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setMode(@NonNull Mode mode) {
        if (mode != this.l) {
            this.l = mode;
            getOrchestrator().scheduleStateful("mode", CameraState.ENGINE, new b());
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setOverlay(@Nullable Overlay overlay) {
        this.x = overlay;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setPictureMetering(boolean z) {
        this.mPictureMetering = z;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setPictureSizeSelector(@NonNull SizeSelector sizeSelector) {
        this.i = sizeSelector;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setPictureSnapshotMetering(boolean z) {
        this.mPictureSnapshotMetering = z;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setPreview(@NonNull CameraPreview cameraPreview) {
        CameraPreview cameraPreview2 = this.mPreview;
        if (cameraPreview2 != null) {
            cameraPreview2.setSurfaceCallback(null);
        }
        this.mPreview = cameraPreview;
        cameraPreview.setSurfaceCallback(this);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setPreviewFrameRateExact(boolean z) {
        this.e = z;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setPreviewStreamSizeSelector(@Nullable SizeSelector sizeSelector) {
        this.h = sizeSelector;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setSnapshotMaxHeight(int i2) {
        this.t = i2;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setSnapshotMaxWidth(int i2) {
        this.s = i2;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setVideoBitRate(int i2) {
        this.p = i2;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setVideoCodec(@NonNull VideoCodec videoCodec) {
        this.mVideoCodec = videoCodec;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setVideoMaxDuration(int i2) {
        this.o = i2;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setVideoMaxSize(long j2) {
        this.n = j2;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setVideoSizeSelector(@NonNull SizeSelector sizeSelector) {
        this.j = sizeSelector;
    }

    public final boolean shouldResetAutoFocus() {
        long j2 = this.r;
        return j2 > 0 && j2 != Long.MAX_VALUE;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void stopVideo() {
        getOrchestrator().schedule("stop video", true, (Runnable) new g());
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void takePicture(@NonNull PictureResult.Stub stub) {
        getOrchestrator().scheduleStateful("take picture", CameraState.BIND, new c(stub, this.mPictureMetering));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void takePictureSnapshot(@NonNull PictureResult.Stub stub) {
        getOrchestrator().scheduleStateful("take picture snapshot", CameraState.BIND, new d(stub, this.mPictureSnapshotMetering));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void takeVideo(@NonNull VideoResult.Stub stub, @Nullable File file, @Nullable FileDescriptor fileDescriptor) {
        getOrchestrator().scheduleStateful("take video", CameraState.BIND, new e(file, stub, fileDescriptor));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void takeVideoSnapshot(@NonNull VideoResult.Stub stub, @NonNull File file) {
        getOrchestrator().scheduleStateful("take video snapshot", CameraState.BIND, new f(stub, file));
    }

    @NonNull
    public final Size computeCaptureSize(@NonNull Mode mode) {
        Collection<Size> collection;
        SizeSelector sizeSelector;
        boolean flip = getAngles().flip(Reference.SENSOR, Reference.VIEW);
        if (mode == Mode.PICTURE) {
            sizeSelector = this.i;
            collection = this.mCameraOptions.getSupportedPictureSizes();
        } else {
            sizeSelector = this.j;
            collection = this.mCameraOptions.getSupportedVideoSizes();
        }
        SizeSelector or = SizeSelectors.or(sizeSelector, SizeSelectors.biggest());
        ArrayList arrayList = new ArrayList(collection);
        Size size = or.select(arrayList).get(0);
        if (arrayList.contains(size)) {
            CameraEngine.LOG.i("computeCaptureSize:", "result:", size, "flip:", Boolean.valueOf(flip), "mode:", mode);
            return flip ? size.flip() : size;
        }
        throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
    }
}
