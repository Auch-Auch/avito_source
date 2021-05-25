package a2.a.a.b.g;

import com.avito.android.authorization.phone_proving.PhoneProvingPresenter;
import com.avito.android.authorization.phone_proving.PhoneProvingPresenterImpl;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<DeepLink> {
    public final /* synthetic */ PhoneProvingPresenterImpl a;
    public final /* synthetic */ TypedError b;

    public a(PhoneProvingPresenterImpl phoneProvingPresenterImpl, TypedError typedError) {
        this.a = phoneProvingPresenterImpl;
        this.b = typedError;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        PhoneProvingPresenter.Router router = this.a.b;
        if (router != null) {
            Intrinsics.checkNotNullExpressionValue(deepLink2, "deepLink");
            router.followDeepLink(deepLink2);
        }
        if (!((ErrorResult.ErrorDialog) this.b).getUserDialog().getCancelable()) {
            PhoneProvingPresenterImpl.access$closeScreen(this.a);
        }
    }
}
