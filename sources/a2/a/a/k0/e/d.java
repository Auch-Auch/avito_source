package a2.a.a.k0.e;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import com.avito.android.delivery.summary.DeliveryRdsSummaryFragment;
import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsDialog;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Observer<DeliverySummaryRds.ContactsGroup> {
    public final /* synthetic */ DeliveryRdsSummaryFragment a;

    public d(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment) {
        this.a = deliveryRdsSummaryFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeliverySummaryRds.ContactsGroup contactsGroup) {
        DeliverySummaryRds.ContactsGroup contactsGroup2 = contactsGroup;
        DialogFragment dialogFragment = this.a.d;
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
        DeliveryRdsSummaryFragment deliveryRdsSummaryFragment = this.a;
        DeliveryRdsEditContactsDialog.Companion companion = DeliveryRdsEditContactsDialog.Companion;
        Intrinsics.checkNotNullExpressionValue(contactsGroup2, "contactsGroup");
        deliveryRdsSummaryFragment.d = companion.createInstance(contactsGroup2);
        DialogFragment dialogFragment2 = this.a.d;
        if (dialogFragment2 != null) {
            dialogFragment2.show(this.a.getChildFragmentManager(), (String) null);
        }
    }
}
