package a2.a.a.e2.d0.e;

import com.avito.android.publish.slots.contact_info.ContactInfoSlotWrapper;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<Throwable, LoadingState<? super SuccessResult>> {
    public final /* synthetic */ ContactInfoSlotWrapper a;

    public f(ContactInfoSlotWrapper contactInfoSlotWrapper) {
        this.a = contactInfoSlotWrapper;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super SuccessResult> apply(Throwable th) {
        Throwable th2 = th;
        Logs.error("Failed to register user", th2);
        TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.g;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
    }
}
