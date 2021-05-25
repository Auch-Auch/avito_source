package a2.a.a.c2.b;

import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModel;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModelImpl;
import com.avito.android.util.Logs;
import com.avito.android.util.TypedResultException;
import io.reactivex.rxjava3.functions.Consumer;
public final class f<T> implements Consumer<Throwable> {
    public final /* synthetic */ ConfirmPhoneViewModelImpl a;

    public f(ConfirmPhoneViewModelImpl confirmPhoneViewModelImpl) {
        this.a = confirmPhoneViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        if (th2 instanceof TypedResultException) {
            this.a.d.postValue(new ConfirmPhoneViewModel.ScreenState.InputError(((TypedResultException) th2).getMessage()));
        } else {
            Logs.error("Failed to send confirm code", th2);
        }
    }
}
