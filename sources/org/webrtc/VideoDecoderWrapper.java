package org.webrtc;

import org.webrtc.VideoDecoder;
import org.webrtc.VideoDecoderWrapper;
import org.webrtc.VideoFrame;
public class VideoDecoderWrapper {
    @CalledByNative
    public static VideoDecoder.Callback createDecoderCallback(long j) {
        return new VideoDecoder.Callback(j) { // from class: x6.f.b0
            public final /* synthetic */ long a;

            {
                this.a = r1;
            }

            @Override // org.webrtc.VideoDecoder.Callback
            public final void onDecodedFrame(VideoFrame videoFrame, Integer num, Integer num2) {
                VideoDecoderWrapper.a(this.a, videoFrame, num, null);
            }
        };
    }

    /* access modifiers changed from: private */
    public static native void nativeOnDecodedFrame(long j, VideoFrame videoFrame, Integer num, Integer num2);
}
