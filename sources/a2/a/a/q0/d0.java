package a2.a.a.q0;

import com.avito.android.extended_profile.ExtendedProfileViewModelImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class d0<T> implements Consumer<Throwable> {
    public final /* synthetic */ ExtendedProfileViewModelImpl a;

    public d0(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        this.a = extendedProfileViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        ExtendedProfileViewModelImpl extendedProfileViewModelImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        ExtendedProfileViewModelImpl.access$handleLoadProfileError(extendedProfileViewModelImpl, th2);
    }
}
