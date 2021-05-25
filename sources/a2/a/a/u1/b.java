package a2.a.a.u1;

import android.view.View;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<Boolean> {
    public final /* synthetic */ LocationPermissionDialogPresenterImpl a;
    public final /* synthetic */ View b;

    public b(LocationPermissionDialogPresenterImpl locationPermissionDialogPresenterImpl, View view) {
        this.a = locationPermissionDialogPresenterImpl;
        this.b = view;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullExpressionValue(bool2, "it");
        if (bool2.booleanValue()) {
            LocationPermissionDialogPresenter.Subscriber subscriber = this.a.c;
            if (subscriber != null) {
                LocationPermissionDialogPresenter.Subscriber.DefaultImpls.onLocationNotFound$default(subscriber, null, 1, null);
                return;
            }
            return;
        }
        LocationPermissionDialogPresenterImpl.access$showSnackbar(this.a, this.b);
    }
}
