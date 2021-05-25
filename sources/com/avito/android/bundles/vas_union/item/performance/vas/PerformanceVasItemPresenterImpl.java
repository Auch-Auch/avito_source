package com.avito.android.bundles.vas_union.item.performance.vas;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.image_loader.AvitoPictureKt;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nRD\u0010\u0011\u001a0\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0017\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000b¢\u0006\u0002\b\u000e0\u000b¢\u0006\u0002\b\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasItemPresenterImpl;", "Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasItemPresenter;", "Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasItemView;", "view", "Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasItemView;Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasItem;I)V", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "Lcom/avito/android/deep_linking/links/DeepLink;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/subjects/PublishSubject;", "deeplinkRelay", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getDeeplinkClicks", "()Lio/reactivex/rxjava3/core/Observable;", "deeplinkClicks", "<init>", "()V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class PerformanceVasItemPresenterImpl implements PerformanceVasItemPresenter {
    public final PublishSubject<DeepLink> a;
    @NotNull
    public final Observable<DeepLink> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PerformanceVasItemPresenterImpl a;
        public final /* synthetic */ PerformanceVasItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PerformanceVasItemPresenterImpl performanceVasItemPresenterImpl, PerformanceVasItem performanceVasItem) {
            super(0);
            this.a = performanceVasItemPresenterImpl;
            this.b = performanceVasItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.onNext(this.b.getDeepLink());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public PerformanceVasItemPresenterImpl() {
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

    public void bindView(@NotNull PerformanceVasItemView performanceVasItemView, @NotNull PerformanceVasItem performanceVasItem, int i) {
        Intrinsics.checkNotNullParameter(performanceVasItemView, "view");
        Intrinsics.checkNotNullParameter(performanceVasItem, "item");
        performanceVasItemView.setTitle(performanceVasItem.getTitle());
        performanceVasItemView.setPrice(performanceVasItem.getPrice());
        performanceVasItemView.setOldPrice(performanceVasItem.getOldPrice());
        performanceVasItemView.setPicture(AvitoPictureKt.pictureOf$default(performanceVasItem.getIcon(), true, 0.0f, 0.0f, null, 28, null));
        performanceVasItemView.setClickListener(new a(this, performanceVasItem));
    }
}
