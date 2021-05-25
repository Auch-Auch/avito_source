package x6.f;

import androidx.annotation.Nullable;
import org.webrtc.CalledByNative;
import org.webrtc.VideoCodecInfo;
import org.webrtc.VideoDecoder;
import org.webrtc.VideoDecoderFactory;
/* compiled from: VideoDecoderFactory */
public final /* synthetic */ class r0 {
    @Nullable
    @Deprecated
    public static VideoDecoder $default$createDecoder(VideoDecoderFactory _this, String str) {
        throw new UnsupportedOperationException("Deprecated and not implemented.");
    }

    @CalledByNative
    public static VideoCodecInfo[] $default$getSupportedCodecs(VideoDecoderFactory videoDecoderFactory) {
        return new VideoCodecInfo[0];
    }

    @Nullable
    @CalledByNative
    public static VideoDecoder $default$createDecoder(VideoDecoderFactory _this, VideoCodecInfo videoCodecInfo) {
        return _this.createDecoder(videoCodecInfo.getName());
    }
}
