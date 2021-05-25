package com.avito.android.advert.item.safedeal;

import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/avito/android/deep_linking/links/DeepLink;", "redirect", "", "invoke", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class AdvertSafeDealPresenterImpl$followDeepLink$2 extends Lambda implements Function1<DeepLink, Unit> {
    public final /* synthetic */ AdvertSafeDealPresenterImpl a;
    public final /* synthetic */ Function0 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertSafeDealPresenterImpl$followDeepLink$2(AdvertSafeDealPresenterImpl advertSafeDealPresenterImpl, Function0 function0) {
        super(1);
        this.a = advertSafeDealPresenterImpl;
        this.b = function0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DeepLink deepLink) {
        invoke(deepLink);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "redirect");
        AdvertSafeDealPresenter.Router router = this.a.e;
        if (router != null) {
            router.followSafeDealDeepLink(deepLink);
            this.b.invoke();
        }
    }
}
