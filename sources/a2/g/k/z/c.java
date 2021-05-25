package a2.g.k.z;

import com.facebook.appevents.integrity.IntegrityManager;
public final class c implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        IntegrityManager.enable();
    }
}
