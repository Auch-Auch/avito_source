package com.avito.android.str_calendar.seller.edit;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001a¨\u0006$"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/SellerBaseCalendarParametersViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;", g.a, "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;", "resourceProvider", "", "c", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverter;", "d", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverter;", "parametersConverter", "Ljava/util/Date;", "e", "Ljava/util/Date;", "startDate", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractor;", "interactor", "f", "endDate", "<init>", "(Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractor;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverter;Ljava/util/Date;Ljava/util/Date;Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerBaseCalendarParametersViewModelFactory implements ViewModelProvider.Factory {
    public final SellerCalendarParametersInteractor a;
    public final SchedulersFactory b;
    public final String c;
    public final SellerCalendarParametersConverter d;
    public final Date e;
    public final Date f;
    public final SellerCalendarParamsResourceProvider g;

    public SellerBaseCalendarParametersViewModelFactory(@NotNull SellerCalendarParametersInteractor sellerCalendarParametersInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull String str, @NotNull SellerCalendarParametersConverter sellerCalendarParametersConverter, @Nullable Date date, @Nullable Date date2, @NotNull SellerCalendarParamsResourceProvider sellerCalendarParamsResourceProvider) {
        Intrinsics.checkNotNullParameter(sellerCalendarParametersInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(sellerCalendarParametersConverter, "parametersConverter");
        Intrinsics.checkNotNullParameter(sellerCalendarParamsResourceProvider, "resourceProvider");
        this.a = sellerCalendarParametersInteractor;
        this.b = schedulersFactory;
        this.c = str;
        this.d = sellerCalendarParametersConverter;
        this.e = date;
        this.f = date2;
        this.g = sellerCalendarParamsResourceProvider;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(SellerCalendarParametersViewModelImpl.class)) {
            return new SellerCalendarParametersViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
