package a2.a.a.q0;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.extended_profile.ExtendedProfileViewModelImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class y<T> implements Consumer<DeepLink> {
    public final /* synthetic */ ExtendedProfileViewModelImpl a;

    public y(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        this.a = extendedProfileViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        ExtendedProfileViewModelImpl.access$hideProgressAsDialog(this.a);
        ExtendedProfileViewModelImpl extendedProfileViewModelImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
        extendedProfileViewModelImpl.handleDeepLink(deepLink2);
    }
}
