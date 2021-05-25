package com.avito.android.delivery.summary;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.Features;
import com.avito.android.SummaryState;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.delivery.di.qualifier.CartFlag;
import com.avito.android.delivery.di.qualifier.PayOrderId;
import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractor;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bi\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010+\u001a\u00020(\u0012\n\b\u0001\u00103\u001a\u0004\u0018\u000100\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\u0010/\u001a\u0004\u0018\u00010,\u0012\b\b\u0001\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b4\u00105J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryResourceProvider;", g.a, "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryResourceProvider;", "resourceProvider", "Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;", "h", "Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;", "contactsFieldsInteractor", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryInteractor;", "c", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryInteractor;", "interactor", "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;", "f", "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;", "converter", "", "j", "Z", "isCart", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "k", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/SummaryState;", "i", "Lcom/avito/android/SummaryState;", "summaryState", "", "e", "Ljava/lang/String;", "payOrderId", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;Lcom/avito/android/delivery/summary/DeliveryRdsSummaryInteractor;Lcom/avito/android/util/SchedulersFactory3;Ljava/lang/String;Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;Lcom/avito/android/delivery/summary/DeliveryRdsSummaryResourceProvider;Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;Lcom/avito/android/SummaryState;ZLcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsSummaryViewModelFactory implements ViewModelProvider.Factory {
    public final Analytics a;
    public final Features b;
    public final DeliveryRdsSummaryInteractor c;
    public final SchedulersFactory3 d;
    public final String e;
    public final DeliveryRdsSummaryItemsConverter f;
    public final DeliveryRdsSummaryResourceProvider g;
    public final DeliveryRdsContactsFieldsInteractor h;
    public final SummaryState i;
    public final boolean j;
    public final BaseScreenPerformanceTracker k;

    @Inject
    public DeliveryRdsSummaryViewModelFactory(@NotNull Analytics analytics, @NotNull Features features, @NotNull DeliveryRdsSummaryInteractor deliveryRdsSummaryInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @PayOrderId @Nullable String str, @NotNull DeliveryRdsSummaryItemsConverter deliveryRdsSummaryItemsConverter, @NotNull DeliveryRdsSummaryResourceProvider deliveryRdsSummaryResourceProvider, @NotNull DeliveryRdsContactsFieldsInteractor deliveryRdsContactsFieldsInteractor, @Nullable SummaryState summaryState, @CartFlag boolean z, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(deliveryRdsSummaryInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryRdsSummaryItemsConverter, "converter");
        Intrinsics.checkNotNullParameter(deliveryRdsSummaryResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(deliveryRdsContactsFieldsInteractor, "contactsFieldsInteractor");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        this.a = analytics;
        this.b = features;
        this.c = deliveryRdsSummaryInteractor;
        this.d = schedulersFactory3;
        this.e = str;
        this.f = deliveryRdsSummaryItemsConverter;
        this.g = deliveryRdsSummaryResourceProvider;
        this.h = deliveryRdsContactsFieldsInteractor;
        this.i = summaryState;
        this.j = z;
        this.k = baseScreenPerformanceTracker;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(DeliveryRdsSummaryViewModelImpl.class)) {
            return new DeliveryRdsSummaryViewModelImpl(this.a, this.b, this.c, this.h, this.d, this.e, this.f, this.g, this.i, this.j, this.k);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
