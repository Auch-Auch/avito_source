package a2.m.a.d.a;

import com.otaliastudios.cameraview.video.encoding.MediaEncoder;
public class i implements Runnable {
    public final /* synthetic */ MediaEncoder a;

    public i(MediaEncoder mediaEncoder) {
        this.a = mediaEncoder;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaEncoder.o.w(this.a.b, "Stop was called. Executing.");
        this.a.onStop();
    }
}
