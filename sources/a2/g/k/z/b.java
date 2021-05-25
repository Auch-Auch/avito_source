package a2.g.k.z;

import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
public final class b implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        SuggestedEventsManager.enable();
    }
}
