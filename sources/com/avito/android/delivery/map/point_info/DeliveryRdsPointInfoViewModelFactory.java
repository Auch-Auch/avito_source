package com.avito.android.delivery.map.point_info;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.delivery.di.qualifier.AdvertId;
import com.avito.android.delivery.di.qualifier.AnalyticsAdvertId;
import com.avito.android.delivery.di.qualifier.CartFlag;
import com.avito.android.delivery.di.qualifier.CartItems;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BW\b\u0007\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\b\u0001\u0010\u000f\u001a\u00020\f\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b$\u0010%J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", "f", "Ljava/lang/String;", "cartItems", "", "e", "Z", "isCart", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoResourceProvider;", g.a, "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoResourceProvider;", "resourceProvider", "d", "analyticsAdvertId", "c", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/analytics/Analytics;", "h", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoInteractor;", "interactor", "<init>", "(Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoInteractor;Lcom/avito/android/util/SchedulersFactory3;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoResourceProvider;Lcom/avito/android/analytics/Analytics;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsPointInfoViewModelFactory implements ViewModelProvider.Factory {
    public final DeliveryRdsPointInfoInteractor a;
    public final SchedulersFactory3 b;
    public final String c;
    public final String d;
    public final boolean e;
    public final String f;
    public final DeliveryRdsPointInfoResourceProvider g;
    public final Analytics h;

    @Inject
    public DeliveryRdsPointInfoViewModelFactory(@NotNull DeliveryRdsPointInfoInteractor deliveryRdsPointInfoInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @AdvertId @Nullable String str, @AnalyticsAdvertId @Nullable String str2, @CartFlag boolean z, @CartItems @Nullable String str3, @NotNull DeliveryRdsPointInfoResourceProvider deliveryRdsPointInfoResourceProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(deliveryRdsPointInfoInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryRdsPointInfoResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = deliveryRdsPointInfoInteractor;
        this.b = schedulersFactory3;
        this.c = str;
        this.d = str2;
        this.e = z;
        this.f = str3;
        this.g = deliveryRdsPointInfoResourceProvider;
        this.h = analytics;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(DeliveryRdsPointInfoViewModelImpl.class)) {
            return new DeliveryRdsPointInfoViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
