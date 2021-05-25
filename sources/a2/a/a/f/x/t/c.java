package a2.a.a.f.x.t;

import com.avito.android.remote.model.user_profile.Phone;
import com.avito.android.remote.model.user_profile.PhonesList;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
public final class c<T, R> implements Function<PhonesList, List<? extends Phone>> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends Phone> apply(PhonesList phonesList) {
        return phonesList.getPhones();
    }
}
