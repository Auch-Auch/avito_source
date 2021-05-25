package a2.s.a.a;

import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
public class d extends VKRequest.VKRequestListener {
    public final Object a = new Object();
    public VKRequest.VKRequestListener b;
    public volatile boolean c = false;

    public d(VKRequest.VKRequestListener vKRequestListener) {
        this.b = vKRequestListener;
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onComplete(VKResponse vKResponse) {
        synchronized (this.a) {
            try {
                this.b.onComplete(vKResponse);
            } catch (Exception unused) {
            }
            this.c = true;
            this.a.notifyAll();
        }
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onError(VKError vKError) {
        synchronized (this.a) {
            try {
                this.b.onError(vKError);
            } catch (Exception unused) {
            }
            this.c = true;
            this.a.notifyAll();
        }
    }
}
