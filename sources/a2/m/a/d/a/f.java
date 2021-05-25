package a2.m.a.d.a;

import com.otaliastudios.cameraview.video.encoding.MediaEncoder;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;
public class f implements Runnable {
    public final /* synthetic */ MediaEncoderEngine.Controller a;
    public final /* synthetic */ long b;
    public final /* synthetic */ MediaEncoder c;

    public f(MediaEncoder mediaEncoder, MediaEncoderEngine.Controller controller, long j) {
        this.c = mediaEncoder;
        this.a = controller;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaEncoder.o.i(this.c.b, "Prepare was called. Executing.");
        this.c.b(1);
        this.c.onPrepare(this.a, this.b);
        this.c.b(2);
    }
}
