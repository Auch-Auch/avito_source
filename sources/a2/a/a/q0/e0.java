package a2.a.a.q0;

import com.avito.android.extended_profile.ExtendedProfileViewModelImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class e0<T> implements Consumer<String> {
    public final /* synthetic */ ExtendedProfileViewModelImpl a;

    public e0(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        this.a = extendedProfileViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        ExtendedProfileViewModelImpl extendedProfileViewModelImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        ExtendedProfileViewModelImpl.access$updateViewedStatus(extendedProfileViewModelImpl, str2);
    }
}
