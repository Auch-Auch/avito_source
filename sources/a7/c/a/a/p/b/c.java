package a7.c.a.a.p.b;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
public final class c<T, R> implements Function<T, R> {
    public static final c a = new c();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        TokenData tokenData = (TokenData) obj;
        Intrinsics.checkParameterIsNotNull(tokenData, "it");
        return new DataContainer(tokenData, null);
    }
}
