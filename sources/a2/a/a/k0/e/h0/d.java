package a2.a.a.k0.e.h0;

import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsViewModelImpl;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<Throwable> {
    public final /* synthetic */ DeliveryRdsEditContactsViewModelImpl a;

    public d(DeliveryRdsEditContactsViewModelImpl deliveryRdsEditContactsViewModelImpl) {
        this.a = deliveryRdsEditContactsViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error("DeliveryContacts", th);
        DeliveryRdsEditContactsViewModelImpl.access$showUnknownError(this.a);
    }
}
