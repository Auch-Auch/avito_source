package a2.s.a.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.httpClient.VKImageOperation;
import com.vk.sdk.dialogs.VKShareDialogDelegate;
public class c extends VKImageOperation.VKImageOperationListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ VKShareDialogDelegate c;

    public c(VKShareDialogDelegate vKShareDialogDelegate, String str, int i) {
        this.c = vKShareDialogDelegate;
        this.a = str;
        this.b = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.vk.sdk.api.httpClient.VKAbstractOperation, java.lang.Object] */
    @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
    public void onComplete(VKImageOperation vKImageOperation, Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        if (bitmap2 == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new b(this), 1000);
        } else {
            this.c.d(bitmap2);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.vk.sdk.api.httpClient.VKAbstractOperation, com.vk.sdk.api.VKError] */
    @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
    public void onError(VKImageOperation vKImageOperation, VKError vKError) {
    }
}
