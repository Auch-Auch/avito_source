package a2.m.a.d.a;

import com.otaliastudios.cameraview.video.encoding.MediaEncoder;
import java.util.concurrent.atomic.AtomicInteger;
public class h implements Runnable {
    public final /* synthetic */ AtomicInteger a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ MediaEncoder d;

    public h(MediaEncoder mediaEncoder, AtomicInteger atomicInteger, String str, Object obj) {
        this.d = mediaEncoder;
        this.a = atomicInteger;
        this.b = str;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaEncoder.o.v(this.d.b, "Notify was called. Executing. pendingEvents:", Integer.valueOf(this.a.intValue()));
        this.d.onEvent(this.b, this.c);
        this.a.decrementAndGet();
    }
}
