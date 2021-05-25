package com.avito.android.booking.order;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.booking.di.qualifier.ItemId;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BK\b\u0007\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\b\b\u0001\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b(\u0010)J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", "h", "Ljava/lang/String;", "itemId", "Lcom/avito/android/util/SchedulersFactory3;", "f", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "c", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/booking/order/BookingOrderInputValidator;", "e", "Lcom/avito/android/booking/order/BookingOrderInputValidator;", "bookingOrderInputValidator", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/booking/order/BookingOrderResourceProvider;", g.a, "Lcom/avito/android/booking/order/BookingOrderResourceProvider;", "resourceProvider", "Lcom/avito/android/ActivityIntentFactory;", "d", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/booking/order/BookingOrderInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/booking/order/BookingOrderInteractor;", "bookingOrderInteractor", "<init>", "(Lcom/avito/android/booking/order/BookingOrderInteractor;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/booking/order/BookingOrderInputValidator;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/booking/order/BookingOrderResourceProvider;Ljava/lang/String;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingOrderViewModelFactory implements ViewModelProvider.Factory {
    public final BookingOrderInteractor a;
    public final AccountStateProvider b;
    public final DeepLinkIntentFactory c;
    public final ActivityIntentFactory d;
    public final BookingOrderInputValidator e;
    public final SchedulersFactory3 f;
    public final BookingOrderResourceProvider g;
    public final String h;

    @Inject
    public BookingOrderViewModelFactory(@NotNull BookingOrderInteractor bookingOrderInteractor, @NotNull AccountStateProvider accountStateProvider, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull BookingOrderInputValidator bookingOrderInputValidator, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull BookingOrderResourceProvider bookingOrderResourceProvider, @ItemId @NotNull String str) {
        Intrinsics.checkNotNullParameter(bookingOrderInteractor, "bookingOrderInteractor");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(bookingOrderInputValidator, "bookingOrderInputValidator");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(bookingOrderResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.a = bookingOrderInteractor;
        this.b = accountStateProvider;
        this.c = deepLinkIntentFactory;
        this.d = activityIntentFactory;
        this.e = bookingOrderInputValidator;
        this.f = schedulersFactory3;
        this.g = bookingOrderResourceProvider;
        this.h = str;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(BookingOrderViewModelImpl.class)) {
            return new BookingOrderViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
