package com.avito.android.advert_stats.item.disclaimer;

import android.net.Uri;
import com.avito.android.advert_stats.ExternalLinkRouter;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR:\u0010\u0013\u001a&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00040\u0004 \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerPresenterImpl;", "Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerPresenter;", "Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerItemView;", "view", "Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerItemView;Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerItem;I)V", "Lcom/avito/android/advert_stats/ExternalLinkRouter;", "c", "Lcom/avito/android/advert_stats/ExternalLinkRouter;", "router", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "closeRelay", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getCloseBannerClicks", "()Lio/reactivex/Observable;", "closeBannerClicks", "<init>", "(Lcom/avito/android/advert_stats/ExternalLinkRouter;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class NewStatisticsBannerPresenterImpl implements NewStatisticsBannerPresenter {
    public final PublishRelay<NewStatisticsBannerItem> a;
    @NotNull
    public final Observable<NewStatisticsBannerItem> b;
    public final ExternalLinkRouter c;

    public static final class a extends Lambda implements Function1<Uri, Unit> {
        public final /* synthetic */ NewStatisticsBannerPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(NewStatisticsBannerPresenterImpl newStatisticsBannerPresenterImpl, NewStatisticsBannerItem newStatisticsBannerItem) {
            super(1);
            this.a = newStatisticsBannerPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, "it");
            this.a.c.openLink(uri2);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NewStatisticsBannerPresenterImpl a;
        public final /* synthetic */ NewStatisticsBannerItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(NewStatisticsBannerPresenterImpl newStatisticsBannerPresenterImpl, NewStatisticsBannerItem newStatisticsBannerItem) {
            super(0);
            this.a = newStatisticsBannerPresenterImpl;
            this.b = newStatisticsBannerItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public NewStatisticsBannerPresenterImpl(@NotNull ExternalLinkRouter externalLinkRouter) {
        Intrinsics.checkNotNullParameter(externalLinkRouter, "router");
        this.c = externalLinkRouter;
        PublishRelay<NewStatisticsBannerItem> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "closeRelay");
        this.b = create;
    }

    @Override // com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerPresenter
    @NotNull
    public Observable<NewStatisticsBannerItem> getCloseBannerClicks() {
        return this.b;
    }

    public void bindView(@NotNull NewStatisticsBannerItemView newStatisticsBannerItemView, @NotNull NewStatisticsBannerItem newStatisticsBannerItem, int i) {
        Intrinsics.checkNotNullParameter(newStatisticsBannerItemView, "view");
        Intrinsics.checkNotNullParameter(newStatisticsBannerItem, "item");
        newStatisticsBannerItemView.setDetailsLink(new a(this, newStatisticsBannerItem));
        newStatisticsBannerItemView.setCloseButtonListener(new b(this, newStatisticsBannerItem));
    }
}
