package a2.a.a.k0.e.h0;

import androidx.lifecycle.Observer;
import com.avito.android.delivery.summary.ChangeAction;
import com.avito.android.delivery.summary.EditContactsListener;
import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsDialog;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Observer<ChangeAction.EditContacts> {
    public final /* synthetic */ DeliveryRdsEditContactsDialog a;

    public a(DeliveryRdsEditContactsDialog deliveryRdsEditContactsDialog) {
        this.a = deliveryRdsEditContactsDialog;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ChangeAction.EditContacts editContacts) {
        ChangeAction.EditContacts editContacts2 = editContacts;
        EditContactsListener editContactsListener = this.a.a;
        if (editContactsListener != null) {
            Intrinsics.checkNotNullExpressionValue(editContacts2, "action");
            editContactsListener.editContacts(editContacts2);
        }
        this.a.dismiss();
    }
}
