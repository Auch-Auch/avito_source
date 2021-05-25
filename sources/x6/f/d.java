package x6.f;

import org.webrtc.Camera2Session;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
public final /* synthetic */ class d implements VideoSink {
    public final /* synthetic */ Camera2Session.CaptureSessionCallback a;

    public /* synthetic */ d(Camera2Session.CaptureSessionCallback captureSessionCallback) {
        this.a = captureSessionCallback;
    }

    @Override // org.webrtc.VideoSink
    public final void onFrame(VideoFrame videoFrame) {
        this.a.b(videoFrame);
    }
}
