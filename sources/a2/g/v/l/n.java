package a2.g.v.l;

import com.facebook.share.internal.VideoUploader;
public class n implements Runnable {
    public final /* synthetic */ VideoUploader.e a;

    public n(VideoUploader.e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoUploader.e eVar = this.a;
        eVar.b(eVar.b + 1);
    }
}
