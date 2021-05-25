package com.avito.android.notification_center.landing.recommends;

import com.avito.android.Features;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.notification_center.landing.recommends.item.advert.NotificationCenterLandingRecommendsAdvertItem;
import com.avito.android.notification_center.landing.recommends.item.header.NotificationCenterLandingRecommendsHeaderItem;
import com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItem;
import com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingRecommends;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.util.rx3.InteropKt;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsConverterImpl;", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsConverter;", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends;", "data", "Lio/reactivex/Observable;", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends;)Lio/reactivex/Observable;", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "favoriteStatusResolver", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "viewedStatusResolver", "<init>", "(Lcom/avito/android/serp/adapter/FavoriteStatusResolver;Lcom/avito/android/serp/adapter/ViewedStatusResolver;Lcom/avito/android/Features;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingRecommendsConverterImpl implements NotificationCenterLandingRecommendsConverter {
    public final FavoriteStatusResolver a;
    public final ViewedStatusResolver b;
    public final Features c;

    /* compiled from: java-style lambda group */
    public static final class a<T, R> implements Function<List<? extends Item>, ObservableSource<? extends List<? extends Item>>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public final ObservableSource<? extends List<? extends Item>> apply(List<? extends Item> list) {
            int i = this.a;
            if (i == 0) {
                List<? extends Item> list2 = list;
                Intrinsics.checkNotNullParameter(list2, "it");
                return InteropKt.toV2(((NotificationCenterLandingRecommendsConverterImpl) this.b).a.resolve(list2));
            } else if (i == 1) {
                List<? extends Item> list3 = list;
                Intrinsics.checkNotNullParameter(list3, "it");
                return InteropKt.toV2(((NotificationCenterLandingRecommendsConverterImpl) this.b).b.resolve(list3));
            } else {
                throw null;
            }
        }
    }

    public static final class b<V> implements Callable<List<? extends Item>> {
        public final /* synthetic */ NotificationCenterLandingRecommendsConverterImpl a;
        public final /* synthetic */ NotificationCenterLandingRecommends b;

        public b(NotificationCenterLandingRecommendsConverterImpl notificationCenterLandingRecommendsConverterImpl, NotificationCenterLandingRecommends notificationCenterLandingRecommends) {
            this.a = notificationCenterLandingRecommendsConverterImpl;
            this.b = notificationCenterLandingRecommends;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends Item> call() {
            return NotificationCenterLandingRecommendsConverterImpl.access$convert(this.a, this.b);
        }
    }

    @Inject
    public NotificationCenterLandingRecommendsConverterImpl(@NotNull FavoriteStatusResolver favoriteStatusResolver, @NotNull ViewedStatusResolver viewedStatusResolver, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(favoriteStatusResolver, "favoriteStatusResolver");
        Intrinsics.checkNotNullParameter(viewedStatusResolver, "viewedStatusResolver");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = favoriteStatusResolver;
        this.b = viewedStatusResolver;
        this.c = features;
    }

    public static final List access$convert(NotificationCenterLandingRecommendsConverterImpl notificationCenterLandingRecommendsConverterImpl, NotificationCenterLandingRecommends notificationCenterLandingRecommends) {
        Objects.requireNonNull(notificationCenterLandingRecommendsConverterImpl);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NotificationCenterLandingRecommendsHeaderItem("header_0", notificationCenterLandingRecommends.getImage(), notificationCenterLandingRecommends.getTitle(), notificationCenterLandingRecommends.getDescription()));
        int i = 0;
        for (T t : notificationCenterLandingRecommends.getElements()) {
            if (t instanceof NotificationCenterLandingRecommends.Element.Advert) {
                i++;
                T t2 = t;
                String id = t2.getId();
                Image image = t2.getImage();
                String title = t2.getTitle();
                String price = t2.getPrice();
                String priceWithoutDiscount = notificationCenterLandingRecommendsConverterImpl.c.getAdvertPriceWithDiscount().invoke().booleanValue() ? t2.getPriceWithoutDiscount() : null;
                String location = t2.getLocation();
                String distance = t2.getDistance();
                String address = t2.getAddress();
                boolean isFavorite = t2.isFavorite();
                DeepLink deepLink = t2.getDeepLink();
                if (!(deepLink instanceof AdvertDetailsLink)) {
                    deepLink = null;
                }
                AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
                arrayList.add(new NotificationCenterLandingRecommendsAdvertItem(id, image, title, price, priceWithoutDiscount, location, distance, address, isFavorite, advertDetailsLink != null ? advertDetailsLink.getContext() : null, false, 1024, null));
            } else if (t instanceof NotificationCenterLandingRecommends.Element.Title) {
                i++;
                T t3 = t;
                arrayList.add(new NotificationCenterLandingRecommendsTitleItem(a2.b.a.a.a.M2("title_", i), t3.getTitle(), t3.getAction().getTitle()));
            }
        }
        arrayList.add(new NotificationCenterLandingRecommendsReviewItem(a2.b.a.a.a.M2("review_", i + 1)));
        return arrayList;
    }

    @Override // com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsConverter
    @NotNull
    public Observable<List<Item>> convert(@NotNull NotificationCenterLandingRecommends notificationCenterLandingRecommends) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingRecommends, "data");
        Observable<List<Item>> flatMap = Observable.fromCallable(new b(this, notificationCenterLandingRecommends)).flatMap(new a(0, this)).flatMap(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "Observable.fromCallable …lver.resolve(it).toV2() }");
        return flatMap;
    }
}
