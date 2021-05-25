package a2.a.a.k;

import com.avito.android.remote.model.AppRaterSession;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<AppRaterSession, Boolean> {
    public final /* synthetic */ long a;

    public b(long j) {
        this.a = j;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Boolean apply(AppRaterSession appRaterSession) {
        AppRaterSession appRaterSession2 = appRaterSession;
        Intrinsics.checkNotNullParameter(appRaterSession2, "it");
        return Boolean.valueOf(this.a - appRaterSession2.getLastShowTimestamp() > 10368000000L);
    }
}
