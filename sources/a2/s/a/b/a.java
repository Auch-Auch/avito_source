package a2.s.a.b;

import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiPhoto;
import com.vk.sdk.api.model.VKApiPhotoSize;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.dialogs.VKShareDialogBuilder;
import com.vk.sdk.dialogs.VKShareDialogDelegate;
import java.util.Iterator;
public class a extends VKRequest.VKRequestListener {
    public final /* synthetic */ VKShareDialogDelegate a;

    public a(VKShareDialogDelegate vKShareDialogDelegate) {
        this.a = vKShareDialogDelegate;
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onComplete(VKResponse vKResponse) {
        Iterator it = ((VKPhotoArray) vKResponse.parsedModel).iterator();
        while (it.hasNext()) {
            VKApiPhoto vKApiPhoto = (VKApiPhoto) it.next();
            if (vKApiPhoto.src.getByType(VKApiPhotoSize.Q) != null) {
                VKShareDialogDelegate.a(this.a, vKApiPhoto.src.getByType(VKApiPhotoSize.Q));
            } else if (vKApiPhoto.src.getByType(VKApiPhotoSize.P) != null) {
                VKShareDialogDelegate.a(this.a, vKApiPhoto.src.getByType(VKApiPhotoSize.P));
            } else if (vKApiPhoto.src.getByType(VKApiPhotoSize.M) != null) {
                VKShareDialogDelegate.a(this.a, vKApiPhoto.src.getByType(VKApiPhotoSize.M));
            }
        }
    }

    @Override // com.vk.sdk.api.VKRequest.VKRequestListener
    public void onError(VKError vKError) {
        VKShareDialogBuilder.VKShareDialogListener vKShareDialogListener = this.a.j;
        if (vKShareDialogListener != null) {
            vKShareDialogListener.onVkShareError(vKError);
        }
    }
}
