package a2.a.a.c2.a;

import com.avito.android.profile_phones.add_phone.AddPhoneViewModel;
import com.avito.android.profile_phones.add_phone.AddPhoneViewModelImpl;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class l<T> implements Consumer<Throwable> {
    public final /* synthetic */ AddPhoneViewModelImpl a;

    public l(AddPhoneViewModelImpl addPhoneViewModelImpl) {
        this.a = addPhoneViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        this.a.d.postValue(new AddPhoneViewModel.ScreenState.Error(null));
        Logs.error("Failed to request phone code", th);
    }
}
