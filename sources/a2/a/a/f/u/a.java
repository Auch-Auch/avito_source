package a2.a.a.f.u;

import com.avito.android.advert.badge_details.BadgeDetailsPresenterImpl;
import com.avito.android.remote.model.advert_badge_bar.BadgeDetailsResponse;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<LoadingState<? super BadgeDetailsResponse>> {
    public final /* synthetic */ BadgeDetailsPresenterImpl a;

    public a(BadgeDetailsPresenterImpl badgeDetailsPresenterImpl) {
        this.a = badgeDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super BadgeDetailsResponse> loadingState) {
        LoadingState<? super BadgeDetailsResponse> loadingState2 = loadingState;
        BadgeDetailsPresenterImpl badgeDetailsPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        BadgeDetailsPresenterImpl.access$handleLoadingState(badgeDetailsPresenterImpl, loadingState2);
    }
}
