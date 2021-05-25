package com.avito.android.serp.adapter.location_notification;

import com.avito.android.di.module.LocationNotificationClick;
import com.avito.android.di.module.LocationNotificationVisibility;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.jakewharton.rxrelay3.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u000e\b\u0001\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemPresenterImpl;", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemPresenter;", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemView;", "view", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemView;Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem;I)V", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationActionData;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/Relay;", "clickConsumer", AuthSource.BOOKING_ORDER, "showConsumer", "<init>", "(Lcom/jakewharton/rxrelay3/Relay;Lcom/jakewharton/rxrelay3/Relay;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class LocationNotificationItemPresenterImpl implements LocationNotificationItemPresenter {
    public final Relay<LocationNotificationActionData> a;
    public final Relay<LocationNotificationActionData> b;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public a(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r9v4, resolved type: com.jakewharton.rxrelay3.Relay */
        /* JADX DEBUG: Multi-variable search result rejected for r9v9, resolved type: com.jakewharton.rxrelay3.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((LocationNotificationItemPresenterImpl) this.b).a.accept(new LocationNotificationActionData(((LocationNotificationItem) this.c).getGeoSessionId(), true, ((LocationNotificationItem) this.c).getTooltipType(), 0, 8, null));
            } else if (i == 1) {
                ((LocationNotificationItemPresenterImpl) this.b).b.accept(new LocationNotificationActionData(((LocationNotificationItem) this.c).getGeoSessionId(), false, ((LocationNotificationItem) this.c).getTooltipType(), 0, 8, null));
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Throwable> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public static final b d = new b(2);
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error(th);
            } else if (i == 1) {
                Logs.error(th);
            } else if (i == 2) {
                Logs.error(th);
            } else {
                throw null;
            }
        }
    }

    public static final class c<T> implements Consumer<Integer> {
        public final /* synthetic */ LocationNotificationItemPresenterImpl a;
        public final /* synthetic */ LocationNotificationItem b;

        public c(LocationNotificationItemPresenterImpl locationNotificationItemPresenterImpl, LocationNotificationItem locationNotificationItem) {
            this.a = locationNotificationItemPresenterImpl;
            this.b = locationNotificationItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay3.Relay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            Relay relay = this.a.a;
            String geoSessionId = this.b.getGeoSessionId();
            Intrinsics.checkNotNullExpressionValue(num2, "adapterPosition");
            relay.accept(new LocationNotificationActionData(geoSessionId, false, this.b.getTooltipType(), num2.intValue()));
        }
    }

    @Inject
    public LocationNotificationItemPresenterImpl(@LocationNotificationClick @NotNull Relay<LocationNotificationActionData> relay, @LocationNotificationVisibility @NotNull Relay<LocationNotificationActionData> relay2) {
        Intrinsics.checkNotNullParameter(relay, "clickConsumer");
        Intrinsics.checkNotNullParameter(relay2, "showConsumer");
        this.a = relay;
        this.b = relay2;
    }

    public void bindView(@NotNull LocationNotificationItemView locationNotificationItemView, @NotNull LocationNotificationItem locationNotificationItem, int i) {
        Intrinsics.checkNotNullParameter(locationNotificationItemView, "view");
        Intrinsics.checkNotNullParameter(locationNotificationItem, "item");
        locationNotificationItemView.setTitleText(locationNotificationItem.getTitle());
        locationNotificationItemView.setChangeText(locationNotificationItem.getChangeText());
        locationNotificationItemView.setConfirmText(locationNotificationItem.getConfirmText());
        locationNotificationItemView.getChangeClicks().subscribe(new a(0, this, locationNotificationItem), b.b);
        locationNotificationItemView.getConfirmClicks().subscribe(new c(this, locationNotificationItem), b.c);
        locationNotificationItemView.getVisibilityCallback().subscribe(new a(1, this, locationNotificationItem), b.d);
    }
}
