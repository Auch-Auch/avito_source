package a2.a.a.c2.f;

import com.avito.android.profile_phones.phones_list.PhonesListViewModelImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class k<T> implements Consumer<Long> {
    public final /* synthetic */ PhonesListViewModelImpl a;
    public final /* synthetic */ String b;

    public k(PhonesListViewModelImpl phonesListViewModelImpl, String str) {
        this.a = phonesListViewModelImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Long l) {
        this.a.e.postValue(this.b);
    }
}
