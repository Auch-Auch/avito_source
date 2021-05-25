package a2.m.a.d.a;

import com.otaliastudios.cameraview.video.encoding.MediaEncoder;
public class g implements Runnable {
    public final /* synthetic */ MediaEncoder a;

    public g(MediaEncoder mediaEncoder) {
        this.a = mediaEncoder;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaEncoder mediaEncoder = this.a;
        int i = mediaEncoder.a;
        if (i < 2 || i >= 3) {
            MediaEncoder.o.e(mediaEncoder.b, "Wrong state while starting. Aborting.", Integer.valueOf(i));
            return;
        }
        mediaEncoder.b(3);
        MediaEncoder.o.w(this.a.b, "Start was called. Executing.");
        this.a.onStart();
    }
}
