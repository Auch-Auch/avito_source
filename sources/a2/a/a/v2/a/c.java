package a2.a.a.v2.a;

import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingInteractorImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Map<String, ? extends String>, LoadingState<? super Map<String, ? extends String>>> {
    public final /* synthetic */ StrConfirmBookingInteractorImpl a;

    public c(StrConfirmBookingInteractorImpl strConfirmBookingInteractorImpl) {
        this.a = strConfirmBookingInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public LoadingState<? super Map<String, ? extends String>> apply(Map<String, ? extends String> map) {
        Map<String, ? extends String> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "it");
        return StrConfirmBookingInteractorImpl.access$toLoadedObservable(this.a, map2);
    }
}
