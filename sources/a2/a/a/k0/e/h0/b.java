package a2.a.a.k0.e.h0;

import androidx.lifecycle.Observer;
import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsDialog;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
public final class b<T> implements Observer<Pair<? extends String, ? extends Boolean>> {
    public final /* synthetic */ DeliveryRdsEditContactsDialog a;

    public b(DeliveryRdsEditContactsDialog deliveryRdsEditContactsDialog) {
        this.a = deliveryRdsEditContactsDialog;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Pair<? extends String, ? extends Boolean> pair) {
        Pair<? extends String, ? extends Boolean> pair2 = pair;
        SnackbarExtensionsKt.showSnackbar$default(this.a, (String) pair2.component1(), 0, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, ((Boolean) pair2.component2()).booleanValue() ? SnackbarType.ERROR : SnackbarType.DEFAULT, 126, (Object) null);
    }
}
