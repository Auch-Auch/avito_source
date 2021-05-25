package com.avito.android.notification_center.landing.unified;

import com.avito.android.Features;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItem;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonItem;
import com.avito.android.notification_center.landing.unified.description.UnifiedDescriptionItem;
import com.avito.android.notification_center.landing.unified.divider.UnifiedDividerItem;
import com.avito.android.notification_center.landing.unified.image.UnifiedImageItem;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonItem;
import com.avito.android.notification_center.landing.unified.space.UnifiedSpaceItem;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleItem;
import com.avito.android.notification_center.landing.unified.title.UnifiedTitleItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.notification_center.landing.unified.NotificationCenterLandingField;
import com.avito.android.remote.model.notification_center.landing.unified.NotificationCenterLandingUnified;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.util.rx3.InteropKt;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/NotificationsCenterLandingUnifiedConverterImpl;", "Lcom/avito/android/notification_center/landing/unified/NotificationsCenterLandingUnifiedConverter;", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingUnified;", "data", "Lio/reactivex/Observable;", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingUnified;)Lio/reactivex/Observable;", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "favoriteStatusResolver", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "stringId", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "c", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "viewedStatusResolver", "<init>", "(Lcom/avito/android/serp/adapter/FavoriteStatusResolver;Lcom/avito/android/serp/adapter/ViewedStatusResolver;Lcom/avito/android/Features;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationsCenterLandingUnifiedConverterImpl implements NotificationsCenterLandingUnifiedConverter {
    public final String a = "";
    public final FavoriteStatusResolver b;
    public final ViewedStatusResolver c;
    public final Features d;

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
                return InteropKt.toV2(((NotificationsCenterLandingUnifiedConverterImpl) this.b).b.resolve(list2));
            } else if (i == 1) {
                List<? extends Item> list3 = list;
                Intrinsics.checkNotNullParameter(list3, "it");
                return InteropKt.toV2(((NotificationsCenterLandingUnifiedConverterImpl) this.b).c.resolve(list3));
            } else {
                throw null;
            }
        }
    }

    public static final class b<V> implements Callable<List<? extends Item>> {
        public final /* synthetic */ NotificationsCenterLandingUnifiedConverterImpl a;
        public final /* synthetic */ NotificationCenterLandingUnified b;

        public b(NotificationsCenterLandingUnifiedConverterImpl notificationsCenterLandingUnifiedConverterImpl, NotificationCenterLandingUnified notificationCenterLandingUnified) {
            this.a = notificationsCenterLandingUnifiedConverterImpl;
            this.b = notificationCenterLandingUnified;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends Item> call() {
            return NotificationsCenterLandingUnifiedConverterImpl.access$convert(this.a, this.b);
        }
    }

    @Inject
    public NotificationsCenterLandingUnifiedConverterImpl(@NotNull FavoriteStatusResolver favoriteStatusResolver, @NotNull ViewedStatusResolver viewedStatusResolver, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(favoriteStatusResolver, "favoriteStatusResolver");
        Intrinsics.checkNotNullParameter(viewedStatusResolver, "viewedStatusResolver");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = favoriteStatusResolver;
        this.c = viewedStatusResolver;
        this.d = features;
    }

    public static final List access$convert(NotificationsCenterLandingUnifiedConverterImpl notificationsCenterLandingUnifiedConverterImpl, NotificationCenterLandingUnified notificationCenterLandingUnified) {
        Object obj;
        Objects.requireNonNull(notificationsCenterLandingUnifiedConverterImpl);
        List<NotificationCenterLandingField> fields = notificationCenterLandingUnified.getFields();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(fields, 10));
        for (T t : fields) {
            if (t instanceof NotificationCenterLandingField.Button) {
                T t2 = t;
                obj = new UnifiedButtonItem(notificationsCenterLandingUnifiedConverterImpl.a, t2.getAction().getDeepLink(), t2.getAnalyticParams(), t2.getAction().getTitle());
            } else if (t instanceof NotificationCenterLandingField.Description) {
                obj = new UnifiedDescriptionItem(notificationsCenterLandingUnifiedConverterImpl.a, t.getDescription());
            } else if (t instanceof NotificationCenterLandingField.Divider) {
                obj = new UnifiedDividerItem(notificationsCenterLandingUnifiedConverterImpl.a);
            } else if (t instanceof NotificationCenterLandingField.Image) {
                obj = new UnifiedImageItem(notificationsCenterLandingUnifiedConverterImpl.a, t.getImage());
            } else {
                String str = null;
                if (t instanceof NotificationCenterLandingField.Item) {
                    T t3 = t;
                    String id = t3.getId();
                    boolean isFavorite = t3.isFavorite();
                    DeepLink deepLink = t3.getDeepLink();
                    if (!(deepLink instanceof AdvertDetailsLink)) {
                        deepLink = null;
                    }
                    AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
                    String context = advertDetailsLink != null ? advertDetailsLink.getContext() : null;
                    DeepLink deepLink2 = t3.getDeepLink();
                    Image image = t3.getImage();
                    Map<String, String> analyticParams = t3.getAnalyticParams();
                    String address = t3.getAddress();
                    String distance = t3.getDistance();
                    String location = t3.getLocation();
                    String price = t3.getPrice();
                    if (notificationsCenterLandingUnifiedConverterImpl.d.getAdvertPriceWithDiscount().invoke().booleanValue()) {
                        str = t3.getPriceWithoutDiscount();
                    }
                    obj = new UnifiedAdvertItem(id, isFavorite, context, false, deepLink2, image, analyticParams, address, distance, location, price, str, t3.getTitle());
                } else if (t instanceof NotificationCenterLandingField.PairButton) {
                    T t4 = t;
                    obj = new UnifiedPairButtonItem(notificationsCenterLandingUnifiedConverterImpl.a, t4.getFirst().getAction().getDeepLink(), t4.getSecond().getAction().getDeepLink(), t4.getFirst().getAnalyticParams(), t4.getSecond().getAnalyticParams(), t4.getFirst().getAction().getTitle(), t4.getSecond().getAction().getTitle());
                } else if (t instanceof NotificationCenterLandingField.Space) {
                    obj = new UnifiedSpaceItem(notificationsCenterLandingUnifiedConverterImpl.a);
                } else if (t instanceof NotificationCenterLandingField.Subtitle) {
                    T t5 = t;
                    String str2 = notificationsCenterLandingUnifiedConverterImpl.a;
                    Action action = t5.getAction();
                    DeepLink deepLink3 = action != null ? action.getDeepLink() : null;
                    Map<String, String> analyticParams2 = t5.getAnalyticParams();
                    Action action2 = t5.getAction();
                    if (action2 != null) {
                        str = action2.getTitle();
                    }
                    obj = new UnifiedSubtitleItem(str2, deepLink3, analyticParams2, str, t5.getTitle());
                } else if (t instanceof NotificationCenterLandingField.Title) {
                    obj = new UnifiedTitleItem(notificationsCenterLandingUnifiedConverterImpl.a, t.getTitle());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationsCenterLandingUnifiedConverter
    @NotNull
    public Observable<List<Item>> convert(@NotNull NotificationCenterLandingUnified notificationCenterLandingUnified) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingUnified, "data");
        Observable<List<Item>> flatMap = Observable.fromCallable(new b(this, notificationCenterLandingUnified)).flatMap(new a(0, this)).flatMap(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "Observable.fromCallable …lver.resolve(it).toV2() }");
        return flatMap;
    }
}
