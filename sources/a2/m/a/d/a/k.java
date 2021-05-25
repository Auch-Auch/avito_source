package a2.m.a.d.a;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.video.encoding.EncoderThread;
import com.otaliastudios.cameraview.video.encoding.MediaEncoder;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;
import com.otaliastudios.cameraview.video.encoding.OutputBuffer;
import com.otaliastudios.cameraview.video.encoding.VideoConfig;
import java.io.IOException;
@RequiresApi(api = 18)
public abstract class k<C extends VideoConfig> extends MediaEncoder {
    public static final CameraLogger q = CameraLogger.create(k.class.getSimpleName());
    public C mConfig;
    public int mFrameNumber = -1;
    public Surface mSurface;
    public boolean p = false;

    public k(@NonNull C c) {
        super("VideoEncoder");
        this.mConfig = c;
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    public int getEncodedBitRate() {
        return this.mConfig.bitRate;
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @EncoderThread
    public void onPrepare(@NonNull MediaEncoderEngine.Controller controller, long j) {
        C c = this.mConfig;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(c.mimeType, c.width, c.height);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", this.mConfig.bitRate);
        createVideoFormat.setInteger("frame-rate", this.mConfig.frameRate);
        createVideoFormat.setInteger("i-frame-interval", 1);
        createVideoFormat.setInteger("rotation-degrees", this.mConfig.rotation);
        try {
            C c2 = this.mConfig;
            String str = c2.encoder;
            if (str != null) {
                this.mMediaCodec = MediaCodec.createByCodecName(str);
            } else {
                this.mMediaCodec = MediaCodec.createEncoderByType(c2.mimeType);
            }
            this.mMediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.mSurface = this.mMediaCodec.createInputSurface();
            this.mMediaCodec.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @EncoderThread
    public void onStart() {
        this.mFrameNumber = 0;
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @EncoderThread
    public void onStop() {
        q.i("onStop", "setting mFrameNumber to 1 and signaling the end of input stream.");
        this.mFrameNumber = -1;
        this.mMediaCodec.signalEndOfInputStream();
        drainOutput(true);
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    public void onWriteOutput(@NonNull j jVar, @NonNull OutputBuffer outputBuffer) {
        if (!this.p) {
            CameraLogger cameraLogger = q;
            cameraLogger.w("onWriteOutput:", "sync frame not found yet. Checking.");
            if ((outputBuffer.info.flags & 1) == 1) {
                cameraLogger.w("onWriteOutput:", "SYNC FRAME FOUND!");
                this.p = true;
                super.onWriteOutput(jVar, outputBuffer);
                return;
            }
            cameraLogger.w("onWriteOutput:", "DROPPING FRAME and requesting a sync frame soon.");
            Bundle bundle = new Bundle();
            bundle.putInt("request-sync", 0);
            this.mMediaCodec.setParameters(bundle);
            jVar.recycle(outputBuffer);
            return;
        }
        super.onWriteOutput(jVar, outputBuffer);
    }

    public boolean shouldRenderFrame(long j) {
        if (j == 0 || this.mFrameNumber < 0 || hasReachedMaxLength()) {
            return false;
        }
        this.mFrameNumber++;
        return true;
    }
}
