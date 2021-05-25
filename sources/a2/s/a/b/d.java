package a2.s.a.b;

import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKWallPostResult;
import com.vk.sdk.dialogs.VKShareDialogBuilder;
import com.vk.sdk.dialogs.VKShareDialogDelegate;
public class d extends VKRequest.VKRequestListener {
    public final /* synthetic */ VKShareDialogDelegate a;

    public d(VKShareDialogDelegate vKShareDialogDelegate) {
        this.a = vKShareDialogDelegate;
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onComplete(VKResponse vKResponse) {
        VKShareDialogDelegate.b(this.a, false);
        VKWallPostResult vKWallPostResult = (VKWallPostResult) vKResponse.parsedModel;
        VKShareDialogBuilder.VKShareDialogListener vKShareDialogListener = this.a.j;
        if (vKShareDialogListener != null) {
            vKShareDialogListener.onVkShareComplete(vKWallPostResult.post_id);
        }
        this.a.k.dismissAllowingStateLoss();
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onError(VKError vKError) {
        VKShareDialogDelegate.b(this.a, false);
        VKShareDialogBuilder.VKShareDialogListener vKShareDialogListener = this.a.j;
        if (vKShareDialogListener != null) {
            vKShareDialogListener.onVkShareError(vKError);
        }
    }
}
