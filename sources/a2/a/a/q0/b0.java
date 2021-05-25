package a2.a.a.q0;

import com.avito.android.extended_profile.ExtendedProfileViewModelImpl;
import com.avito.android.public_profile.remote.model.PublicUserProfile;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b0<T> implements Consumer<LoadingState<? super PublicUserProfile>> {
    public final /* synthetic */ ExtendedProfileViewModelImpl a;

    public b0(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        this.a = extendedProfileViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super PublicUserProfile> loadingState) {
        LoadingState<? super PublicUserProfile> loadingState2 = loadingState;
        ExtendedProfileViewModelImpl extendedProfileViewModelImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        ExtendedProfileViewModelImpl.access$trackProfileFlow(extendedProfileViewModelImpl, loadingState2);
    }
}
