package com.avito.android.short_term_rent.start_booking;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.short_term_rent.analytics.StrAnalyticsTracker;
import com.avito.android.short_term_rent.start_booking.utils.StrStartBookingResourceProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010/\u001a\u00020&\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b0\u00101J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010(¨\u00062"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;", "f", "Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;", "analyticsTracker", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Ljava/util/Date;", "i", "Ljava/util/Date;", "checkInDate", "", "k", "Z", "showCalendar", "Lcom/avito/android/util/text/AttributedTextFormatter;", "h", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "j", "checkOutDate", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingInteractor;", "interactor", "Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingResourceProvider;", g.a, "Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingResourceProvider;", "resourceProvider", "", "c", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/account/AccountStateProvider;", "e", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "d", "source", "<init>", "(Lcom/avito/android/short_term_rent/start_booking/StrStartBookingInteractor;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingResourceProvider;Lcom/avito/android/util/text/AttributedTextFormatter;Ljava/util/Date;Ljava/util/Date;Z)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrStartBookingViewModelFactory implements ViewModelProvider.Factory {
    public final StrStartBookingInteractor a;
    public final SchedulersFactory b;
    public final String c;
    public final String d;
    public final AccountStateProvider e;
    public final StrAnalyticsTracker f;
    public final StrStartBookingResourceProvider g;
    public final AttributedTextFormatter h;
    public Date i;
    public Date j;
    public final boolean k;

    public StrStartBookingViewModelFactory(@NotNull StrStartBookingInteractor strStartBookingInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull String str, @NotNull String str2, @NotNull AccountStateProvider accountStateProvider, @NotNull StrAnalyticsTracker strAnalyticsTracker, @NotNull StrStartBookingResourceProvider strStartBookingResourceProvider, @NotNull AttributedTextFormatter attributedTextFormatter, @Nullable Date date, @Nullable Date date2, boolean z) {
        Intrinsics.checkNotNullParameter(strStartBookingInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "source");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(strAnalyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(strStartBookingResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.a = strStartBookingInteractor;
        this.b = schedulersFactory;
        this.c = str;
        this.d = str2;
        this.e = accountStateProvider;
        this.f = strAnalyticsTracker;
        this.g = strStartBookingResourceProvider;
        this.h = attributedTextFormatter;
        this.i = date;
        this.j = date2;
        this.k = z;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(StrStartBookingViewModelImpl.class)) {
            return new StrStartBookingViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
