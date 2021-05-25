package a2.s.a.a;

import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import java.util.ArrayList;
import java.util.Iterator;
public class c implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ VKResponse b;
    public final /* synthetic */ VKRequest c;

    public c(VKRequest vKRequest, boolean z, VKResponse vKResponse) {
        this.c = vKRequest;
        this.a = z;
        this.b = vKResponse;
    }

    @Override // java.lang.Runnable
    public void run() {
        VKRequest.VKRequestListener vKRequestListener;
        ArrayList<VKRequest> arrayList = this.c.g;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<VKRequest> it = this.c.g.iterator();
            while (it.hasNext()) {
                it.next().start();
            }
        }
        if (this.a && (vKRequestListener = this.c.requestListener) != null) {
            vKRequestListener.onComplete(this.b);
        }
    }
}
