package org.webrtc;

import androidx.annotation.Nullable;
import org.webrtc.EncodedImage;
import org.webrtc.VideoEncoder;
import org.webrtc.VideoEncoderWrapper;
public class VideoEncoderWrapper {
    @CalledByNative
    public static VideoEncoder.Callback createEncoderCallback(long j) {
        return new VideoEncoder.Callback(j) { // from class: x6.f.c0
            public final /* synthetic */ long a;

            {
                this.a = r1;
            }

            @Override // org.webrtc.VideoEncoder.Callback
            public final void onEncodedFrame(EncodedImage encodedImage, VideoEncoder.CodecSpecificInfo codecSpecificInfo) {
                VideoEncoderWrapper.a(this.a, encodedImage, codecSpecificInfo);
            }
        };
    }

    @Nullable
    @CalledByNative
    public static Integer getScalingSettingsHigh(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.high;
    }

    @Nullable
    @CalledByNative
    public static Integer getScalingSettingsLow(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.low;
    }

    @CalledByNative
    public static boolean getScalingSettingsOn(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.on;
    }

    /* access modifiers changed from: private */
    public static native void nativeOnEncodedFrame(long j, EncodedImage encodedImage);
}
