package com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite_sellers.action.DeepLinkAction;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.section.item.SectionItemWidthProvider;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItemPresenterImpl;", "Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItemPresenter;", "Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItemView;", "view", "Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItemView;Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clicksConsumer", "Lcom/avito/android/section/item/SectionItemWidthProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/section/item/SectionItemWidthProvider;", "widthProvider", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;Lcom/avito/android/section/item/SectionItemWidthProvider;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class OtherAdvertsItemPresenterImpl implements OtherAdvertsItemPresenter {
    public final Consumer<FavoriteSellersItemAction> a;
    public final SectionItemWidthProvider b;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ DeepLink a;
        public final /* synthetic */ OtherAdvertsItemView b;
        public final /* synthetic */ OtherAdvertsItemPresenterImpl c;

        public a(DeepLink deepLink, OtherAdvertsItemView otherAdvertsItemView, CompositeDisposable compositeDisposable, OtherAdvertsItemPresenterImpl otherAdvertsItemPresenterImpl, OtherAdvertsItem otherAdvertsItem) {
            this.a = deepLink;
            this.b = otherAdvertsItemView;
            this.c = otherAdvertsItemPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.c.a.accept(new DeepLinkAction(this.a));
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ OtherAdvertsItemView a;
        public final /* synthetic */ CompositeDisposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(OtherAdvertsItemView otherAdvertsItemView, CompositeDisposable compositeDisposable) {
            super(0);
            this.a = otherAdvertsItemView;
            this.b = compositeDisposable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setUnbindListener(null);
            this.b.clear();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public OtherAdvertsItemPresenterImpl(@NotNull Consumer<FavoriteSellersItemAction> consumer, @NotNull SectionItemWidthProvider sectionItemWidthProvider) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        Intrinsics.checkNotNullParameter(sectionItemWidthProvider, "widthProvider");
        this.a = consumer;
        this.b = sectionItemWidthProvider;
    }

    public void bindView(@NotNull OtherAdvertsItemView otherAdvertsItemView, @NotNull OtherAdvertsItem otherAdvertsItem, int i) {
        Intrinsics.checkNotNullParameter(otherAdvertsItemView, "view");
        Intrinsics.checkNotNullParameter(otherAdvertsItem, "item");
        otherAdvertsItemView.setTitle(otherAdvertsItem.getTitle());
        otherAdvertsItemView.setSubtitle(otherAdvertsItem.getSubtitle());
        otherAdvertsItemView.setWidth(this.b.getWidthBySpanCount(otherAdvertsItem.getSpanCount()));
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        otherAdvertsItemView.setUnbindListener(new b(otherAdvertsItemView, compositeDisposable));
        DeepLink deepLink = otherAdvertsItem.getDeepLink();
        if (deepLink != null) {
            Disposable subscribe = otherAdvertsItemView.clicks().subscribe(new a(deepLink, otherAdvertsItemView, compositeDisposable, this, otherAdvertsItem));
            Intrinsics.checkNotNullExpressionValue(subscribe, "clicks().subscribe {\n   …pLink))\n                }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }
}
