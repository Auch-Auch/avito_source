package com.avito.android.notification_center.landing.unified.advert;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.FavorableItem;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertPresenterImpl;", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertPresenter;", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItemView;", "view", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItemView;Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItem;I)V", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/serp/adapter/FavorableItem;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/Relay;", "favoriteClickConsumer", AuthSource.SEND_ABUSE, "clickConsumer", "<init>", "(Lcom/jakewharton/rxrelay2/Relay;Lcom/jakewharton/rxrelay2/Relay;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class UnifiedAdvertPresenterImpl implements UnifiedAdvertPresenter {
    public final Relay<UnifiedAdvertItem> a;
    public final Relay<FavorableItem> b;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((UnifiedAdvertPresenterImpl) this.b).a.accept((UnifiedAdvertItem) this.c);
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((UnifiedAdvertPresenterImpl) this.b).b.accept((UnifiedAdvertItem) this.c);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ UnifiedAdvertItemView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(UnifiedAdvertItemView unifiedAdvertItemView) {
            super(0);
            this.a = unifiedAdvertItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setClickListener(null);
            this.a.setFavoriteClickListener(null);
            this.a.setUnbindListener(null);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public UnifiedAdvertPresenterImpl(@NotNull Relay<UnifiedAdvertItem> relay, @NotNull Relay<FavorableItem> relay2) {
        Intrinsics.checkNotNullParameter(relay, "clickConsumer");
        Intrinsics.checkNotNullParameter(relay2, "favoriteClickConsumer");
        this.a = relay;
        this.b = relay2;
    }

    public void bindView(@NotNull UnifiedAdvertItemView unifiedAdvertItemView, @NotNull UnifiedAdvertItem unifiedAdvertItem, int i) {
        Intrinsics.checkNotNullParameter(unifiedAdvertItemView, "view");
        Intrinsics.checkNotNullParameter(unifiedAdvertItem, "item");
        unifiedAdvertItemView.setAddress(unifiedAdvertItem.getAddress());
        unifiedAdvertItemView.setDistance(unifiedAdvertItem.getDistance());
        unifiedAdvertItemView.setImage(unifiedAdvertItem.getImage());
        unifiedAdvertItemView.setIsFavorite(unifiedAdvertItem.isFavorite());
        unifiedAdvertItemView.setIsViewed(unifiedAdvertItem.isViewed());
        unifiedAdvertItemView.setLocation(unifiedAdvertItem.getLocation());
        unifiedAdvertItemView.setPrice(unifiedAdvertItem.getPrice());
        unifiedAdvertItemView.setAdvertPriceWithoutDiscount(unifiedAdvertItem.getPriceWithoutDiscount());
        unifiedAdvertItemView.setTitle(unifiedAdvertItem.getTitle());
        unifiedAdvertItemView.setClickListener(new a(0, this, unifiedAdvertItem));
        unifiedAdvertItemView.setFavoriteClickListener(new a(1, this, unifiedAdvertItem));
        unifiedAdvertItemView.setUnbindListener(new b(unifiedAdvertItemView));
    }
}
