package a2.s.a.b;

import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKImageOperation;
import com.vk.sdk.dialogs.VKShareDialogDelegate;
import java.util.Objects;
public class b implements Runnable {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar = this.a;
        VKShareDialogDelegate vKShareDialogDelegate = cVar.c;
        String str = cVar.a;
        int i = cVar.b + 1;
        Objects.requireNonNull(vKShareDialogDelegate);
        if (i <= 10) {
            VKImageOperation vKImageOperation = new VKImageOperation(str);
            vKImageOperation.setImageOperationListener(new c(vKShareDialogDelegate, str, i));
            VKHttpClient.enqueueOperation(vKImageOperation);
        }
    }
}
