package a2.a.a.e2.d0.e;

import com.avito.android.publish.slots.contact_info.ContactInfoSlotWrapper;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class e<T, R> implements Function<Unit, ObservableSource<? extends LoadingState<? super SuccessResult>>> {
    public final /* synthetic */ ContactInfoSlotWrapper a;

    public e(ContactInfoSlotWrapper contactInfoSlotWrapper) {
        this.a = contactInfoSlotWrapper;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends LoadingState<? super SuccessResult>> apply(Unit unit) {
        return this.a.a();
    }
}
