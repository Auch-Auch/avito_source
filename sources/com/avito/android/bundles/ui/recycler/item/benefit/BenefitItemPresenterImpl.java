package com.avito.android.bundles.ui.recycler.item.benefit;

import android.view.View;
import com.avito.android.Features;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nRD\u0010\u0011\u001a0\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0017\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000b¢\u0006\u0002\b\u000e0\u000b¢\u0006\u0002\b\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/bundles/ui/recycler/item/benefit/BenefitItemPresenterImpl;", "Lcom/avito/android/bundles/ui/recycler/item/benefit/BenefitItemPresenter;", "Lcom/avito/android/bundles/ui/recycler/item/benefit/BenefitItemView;", "view", "Lcom/avito/android/bundles/ui/recycler/item/benefit/BundleBenefitItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/bundles/ui/recycler/item/benefit/BenefitItemView;Lcom/avito/android/bundles/ui/recycler/item/benefit/BundleBenefitItem;I)V", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "Lcom/avito/android/deep_linking/links/DeepLink;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/subjects/PublishSubject;", "deeplinkRelay", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getDeeplinkClicks", "()Lio/reactivex/rxjava3/core/Observable;", "deeplinkClicks", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class BenefitItemPresenterImpl implements BenefitItemPresenter {
    public final PublishSubject<DeepLink> a;
    @NotNull
    public final Observable<DeepLink> b;
    @NotNull
    public final Features c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BenefitItemPresenterImpl a;
        public final /* synthetic */ BundleBenefitItem b;
        public final /* synthetic */ BenefitItemView c;

        public a(BenefitItemPresenterImpl benefitItemPresenterImpl, BundleBenefitItem bundleBenefitItem, BenefitItemView benefitItemView) {
            this.a = benefitItemPresenterImpl;
            this.b = bundleBenefitItem;
            this.c = benefitItemView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.a.onNext(this.b.getDeepLink());
        }
    }

    @Inject
    public BenefitItemPresenterImpl(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.c = features;
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

    @NotNull
    public final Features getFeatures() {
        return this.c;
    }

    public void bindView(@NotNull BenefitItemView benefitItemView, @NotNull BundleBenefitItem bundleBenefitItem, int i) {
        Intrinsics.checkNotNullParameter(benefitItemView, "view");
        Intrinsics.checkNotNullParameter(bundleBenefitItem, "item");
        benefitItemView.setIcon(bundleBenefitItem.getBenefitIcon());
        benefitItemView.setText(bundleBenefitItem.getText(), bundleBenefitItem.getBadge());
        if (!this.c.getClickableBundlesBenefits().invoke().booleanValue() || bundleBenefitItem.getDeepLink() == null || (bundleBenefitItem.getDeepLink() instanceof NoMatchLink)) {
            benefitItemView.removeOnClickListener();
        } else {
            benefitItemView.setOnClickListener(new a(this, bundleBenefitItem, benefitItemView));
        }
    }
}
