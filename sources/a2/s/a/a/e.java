package a2.s.a.a;

import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.VKUploadBase;
import com.vk.sdk.api.httpClient.VKAbstractOperation;
public class e extends VKRequest.VKRequestListener {
    public final /* synthetic */ VKUploadBase.b.C0322b.a a;

    public e(VKUploadBase.b.C0322b.a aVar) {
        this.a = aVar;
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onComplete(VKResponse vKResponse) {
        VKRequest.VKRequestListener vKRequestListener = VKUploadBase.this.requestListener;
        if (vKRequestListener != null) {
            vKRequestListener.onComplete(vKResponse);
        }
        VKUploadBase.b.this.setState(VKAbstractOperation.VKOperationState.Finished);
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onError(VKError vKError) {
        VKRequest.VKRequestListener vKRequestListener = VKUploadBase.this.requestListener;
        if (vKRequestListener != null) {
            vKRequestListener.onError(vKError);
        }
    }
}
