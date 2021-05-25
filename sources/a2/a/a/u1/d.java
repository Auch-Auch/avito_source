package a2.a.a.u1;

import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenterImpl;
import com.avito.android.util.SnackBarCallbackType;
import com.google.android.material.snackbar.Snackbar;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<SnackBarCallbackType> {
    public final /* synthetic */ LocationPermissionDialogPresenterImpl a;

    public d(LocationPermissionDialogPresenterImpl locationPermissionDialogPresenterImpl) {
        this.a = locationPermissionDialogPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(SnackBarCallbackType snackBarCallbackType) {
        LocationPermissionDialogPresenter.Subscriber subscriber;
        SnackBarCallbackType snackBarCallbackType2 = snackBarCallbackType;
        if (snackBarCallbackType2 == SnackBarCallbackType.ACTION_CLICK && (subscriber = this.a.c) != null) {
            subscriber.onClickLocationSnackbar();
        }
        if (snackBarCallbackType2 == SnackBarCallbackType.CLOSE) {
            ((Snackbar) LocationPermissionDialogPresenterImpl.access$getSnackbar$p(this.a).getValue()).dismiss();
        }
    }
}
