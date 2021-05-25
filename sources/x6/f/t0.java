package x6.f;

import org.webrtc.CalledByNative;
import org.webrtc.VideoCodecInfo;
import org.webrtc.VideoEncoderFactory;
/* compiled from: VideoEncoderFactory */
public final /* synthetic */ class t0 {
    @CalledByNative
    public static VideoEncoderFactory.VideoEncoderSelector $default$getEncoderSelector(VideoEncoderFactory videoEncoderFactory) {
        return null;
    }

    @CalledByNative
    public static VideoCodecInfo[] $default$getImplementations(VideoEncoderFactory _this) {
        return _this.getSupportedCodecs();
    }
}
