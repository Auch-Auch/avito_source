package a2.a.a.b3.c.b;

import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersInteractorImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<Map<String, ? extends String>, LoadingState<? super Map<String, ? extends String>>> {
    public final /* synthetic */ SellerCalendarParametersInteractorImpl a;

    public e(SellerCalendarParametersInteractorImpl sellerCalendarParametersInteractorImpl) {
        this.a = sellerCalendarParametersInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public LoadingState<? super Map<String, ? extends String>> apply(Map<String, ? extends String> map) {
        Map<String, ? extends String> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "it");
        return SellerCalendarParametersInteractorImpl.access$toLoadedObservable(this.a, map2);
    }
}
