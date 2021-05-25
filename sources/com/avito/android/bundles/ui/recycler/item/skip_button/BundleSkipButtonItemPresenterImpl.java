package com.avito.android.bundles.ui.recycler.item.skip_button;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010RD\u0010\u0017\u001a0\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\f0\f \u0013*\u0017\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\f0\f\u0018\u00010\u0012¢\u0006\u0002\b\u00140\u0012¢\u0006\u0002\b\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItemPresenterImpl;", "Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItemPresenter;", "Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItemView;", "view", "Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItemView;Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItem;I)V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getDeeplinkClicks", "()Lio/reactivex/rxjava3/core/Observable;", "deeplinkClicks", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/subjects/PublishSubject;", "deeplinkRelay", "<init>", "()V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class BundleSkipButtonItemPresenterImpl implements BundleSkipButtonItemPresenter {
    public final PublishSubject<DeepLink> a;
    @NotNull
    public final Observable<DeepLink> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BundleSkipButtonItemPresenterImpl a;
        public final /* synthetic */ BundleSkipButtonItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BundleSkipButtonItemPresenterImpl bundleSkipButtonItemPresenterImpl, BundleSkipButtonItem bundleSkipButtonItem) {
            super(0);
            this.a = bundleSkipButtonItemPresenterImpl;
            this.b = bundleSkipButtonItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.onNext(this.b.getAction().getDeepLink());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public BundleSkipButtonItemPresenterImpl() {
        PublishSubject<DeepLink> create = PublishSubject.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "deeplinkRelay");
        this.b = create;
    }

    @Override // com.avito.android.deep_linking.DeeplinkClickStreamProvider3
    @NotNull
    public Observable<DeepLink> getDeeplinkClicks() {
        return this.b;
    }

    public void bindView(@NotNull BundleSkipButtonItemView bundleSkipButtonItemView, @NotNull BundleSkipButtonItem bundleSkipButtonItem, int i) {
        Intrinsics.checkNotNullParameter(bundleSkipButtonItemView, "view");
        Intrinsics.checkNotNullParameter(bundleSkipButtonItem, "item");
        bundleSkipButtonItemView.setTitle(bundleSkipButtonItem.getAction().getTitle());
        bundleSkipButtonItemView.setButtonClickListener(new a(this, bundleSkipButtonItem));
    }
}
