package a2.a.a.k3;

import com.avito.android.user_favorites.UserFavoritesInteractorImpl;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Integer, String> {
    public final /* synthetic */ UserFavoritesInteractorImpl a;

    public c(UserFavoritesInteractorImpl userFavoritesInteractorImpl) {
        this.a = userFavoritesInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public String apply(Integer num) {
        Integer num2 = num;
        UserFavoritesInteractorImpl userFavoritesInteractorImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(num2, "counter");
        return UserFavoritesInteractorImpl.access$toCounterString(userFavoritesInteractorImpl, num2.intValue());
    }
}
