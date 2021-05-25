package com.avito.android.contact_access;

import com.avito.android.dialog.advert_details.IncompleteRegisterRouter;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/avito/android/contact_access/ContactAccessServiceFragment$setIncompleteRegisterRouter$incompleteRegisterRouter$1", "Lcom/avito/android/dialog/advert_details/IncompleteRegisterRouter;", "", "onContinueSelected", "()V", "onCancel", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public final class ContactAccessServiceFragment$setIncompleteRegisterRouter$incompleteRegisterRouter$1 implements IncompleteRegisterRouter {
    public final /* synthetic */ ContactAccessServiceFragment a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public ContactAccessServiceFragment$setIncompleteRegisterRouter$incompleteRegisterRouter$1(ContactAccessServiceFragment contactAccessServiceFragment) {
        this.a = contactAccessServiceFragment;
    }

    @Override // com.avito.android.dialog.advert_details.IncompleteRegisterRouter
    public void onCancel() {
        this.a.close();
    }

    @Override // com.avito.android.dialog.advert_details.IncompleteRegisterRouter
    public void onContinueSelected() {
        this.a.startActivityForResult(this.a.getActivityIntentFactory().createConfirmRegisterIntent(), 2);
    }
}
