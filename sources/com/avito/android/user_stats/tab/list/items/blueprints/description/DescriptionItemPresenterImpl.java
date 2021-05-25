package com.avito.android.user_stats.tab.list.items.blueprints.description;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_stats.tab.list.items.DescriptionItem;
import com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionItemPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nRD\u0010\u0011\u001a0\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0017\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000b¢\u0006\u0002\b\u000e0\u000b¢\u0006\u0002\b\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenterImpl;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemView;", "view", "Lcom/avito/android/user_stats/tab/list/items/DescriptionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemView;Lcom/avito/android/user_stats/tab/list/items/DescriptionItem;I)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter$DescriptionClickDetails;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "linkClicksRelay", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getLinkClicksObservable", "()Lio/reactivex/rxjava3/core/Observable;", "linkClicksObservable", "<init>", "()V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class DescriptionItemPresenterImpl implements DescriptionItemPresenter {
    public final PublishRelay<DescriptionItemPresenter.DescriptionClickDetails> a;
    @NotNull
    public final Observable<DescriptionItemPresenter.DescriptionClickDetails> b;

    public static final class a implements OnDeepLinkClickListener {
        public final /* synthetic */ DescriptionItemPresenterImpl a;
        public final /* synthetic */ DescriptionItem b;

        public a(DescriptionItemPresenterImpl descriptionItemPresenterImpl, DescriptionItem descriptionItem) {
            this.a = descriptionItemPresenterImpl;
            this.b = descriptionItem;
        }

        @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
        public final void onDeepLinkClick(@NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a.a.accept(new DescriptionItemPresenter.DescriptionClickDetails(deepLink, this.b.getFromType()));
        }
    }

    @Inject
    public DescriptionItemPresenterImpl() {
        PublishRelay<DescriptionItemPresenter.DescriptionClickDetails> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "linkClicksRelay");
        this.b = create;
    }

    @Override // com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionItemPresenter
    @NotNull
    public Observable<DescriptionItemPresenter.DescriptionClickDetails> getLinkClicksObservable() {
        return this.b;
    }

    public void bindView(@NotNull DescriptionItemView descriptionItemView, @NotNull DescriptionItem descriptionItem, int i) {
        Intrinsics.checkNotNullParameter(descriptionItemView, "view");
        Intrinsics.checkNotNullParameter(descriptionItem, "item");
        descriptionItem.getText().setOnDeepLinkClickListener(new a(this, descriptionItem));
        descriptionItemView.setText(descriptionItem.getText());
    }
}
