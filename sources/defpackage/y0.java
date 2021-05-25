package defpackage;

import com.avito.android.home.HomePresenter;
import com.avito.android.home.HomePresenterImpl;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.remote.model.Location;
import com.avito.android.serp.adapter.location_notification.LocationNotificationActionData;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItem;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: y0  reason: default package */
public final class y0<T> implements Consumer<LocationNotificationActionData> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public y0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(LocationNotificationActionData locationNotificationActionData) {
        String id;
        HomePresenter.Router router;
        String str;
        String id2;
        Location fallbackLocation;
        int i = this.a;
        String str2 = "";
        String str3 = null;
        if (i == 0) {
            LocationNotificationActionData locationNotificationActionData2 = locationNotificationActionData;
            LocationAnalyticsInteractor locationAnalyticsInteractor = ((HomePresenterImpl) this.b).L;
            String geoSessionId = locationNotificationActionData2.getGeoSessionId();
            boolean isChange = locationNotificationActionData2.isChange();
            Location location = ((HomePresenterImpl) this.b).g.getLocation();
            String id3 = location != null ? location.getId() : null;
            LocationNotificationItem.TooltipType type = locationNotificationActionData2.getType();
            if (type != null) {
                str3 = type.getValue();
            }
            if (str3 != null) {
                str2 = str3;
            }
            locationAnalyticsInteractor.trackLocationNotificationSubmitted(geoSessionId, isChange, id3, str2);
            if (locationNotificationActionData2.isChange()) {
                Location location2 = ((HomePresenterImpl) this.b).g.getLocation();
                if (location2 != null && (id = location2.getId()) != null && (router = ((HomePresenterImpl) this.b).c) != null) {
                    router.showLocationsListScreen(id, locationNotificationActionData2.getGeoSessionId());
                    return;
                }
                return;
            }
            Intrinsics.checkNotNullExpressionValue(locationNotificationActionData2, "data");
            HomePresenterImpl.access$onLocationNotificationRemoved((HomePresenterImpl) this.b, locationNotificationActionData2);
        } else if (i == 1) {
            LocationNotificationActionData locationNotificationActionData3 = locationNotificationActionData;
            LocationNotificationItem.TooltipType type2 = locationNotificationActionData3 != null ? locationNotificationActionData3.getType() : null;
            if (type2 == LocationNotificationItem.TooltipType.CHANGE && (fallbackLocation = ((HomePresenterImpl) this.b).g.getFallbackLocation()) != null) {
                str3 = fallbackLocation.getId();
            }
            LocationAnalyticsInteractor locationAnalyticsInteractor2 = ((HomePresenterImpl) this.b).L;
            String geoSessionId2 = locationNotificationActionData3.getGeoSessionId();
            if (type2 == null || (str = type2.getValue()) == null) {
                str = str2;
            }
            Location location3 = ((HomePresenterImpl) this.b).g.getLocation();
            if (!(location3 == null || (id2 = location3.getId()) == null)) {
                str2 = id2;
            }
            locationAnalyticsInteractor2.trackLocationNotificationWasShown(geoSessionId2, str, str3, str2);
        } else {
            throw null;
        }
    }
}
