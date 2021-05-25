package a7.c.a.a.n.f;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import ru.sravni.android.bankproduct.domain.profile.entity.UpdateFieldAccount;
public final class g<T, R> implements Function<T, R> {
    public static final g a = new g();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        Intrinsics.checkParameterIsNotNull((ResponseBody) obj, "it");
        return new UpdateFieldAccount();
    }
}
