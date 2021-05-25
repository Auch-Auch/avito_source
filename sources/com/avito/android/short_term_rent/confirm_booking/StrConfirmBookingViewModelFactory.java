package com.avito.android.short_term_rent.confirm_booking;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.short_term_rent.analytics.NonFatalAnalyticsTracker;
import com.avito.android.short_term_rent.analytics.StrAnalyticsTracker;
import com.avito.android.short_term_rent.confirm_booking.utils.StrConfirmBookingResourceProvider;
import com.avito.android.short_term_rent.confirm_booking.utils.StrContactsTreeConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010#\u001a\u00020\f\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b4\u00105J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u000eR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "", "c", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/short_term_rent/analytics/NonFatalAnalyticsTracker;", "l", "Lcom/avito/android/short_term_rent/analytics/NonFatalAnalyticsTracker;", "nonFatalAnalyticsTracker", "d", "checkInDate", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingResourceProvider;", "j", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingResourceProvider;", "resourceProvider", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverter;", "k", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverter;", "contactsTreeConverter", "Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;", g.a, "Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;", "analyticsTracker", "e", "checkOutDate", "", "f", "I", "guestsCount", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractor;", "interactor", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "h", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "elementConverter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "i", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "<init>", "(Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractor;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingResourceProvider;Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverter;Lcom/avito/android/short_term_rent/analytics/NonFatalAnalyticsTracker;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrConfirmBookingViewModelFactory implements ViewModelProvider.Factory {
    public final StrConfirmBookingInteractor a;
    public final SchedulersFactory b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final StrAnalyticsTracker g;
    public final CategoryParametersElementConverter h;
    public final AttributedTextFormatter i;
    public final StrConfirmBookingResourceProvider j;
    public final StrContactsTreeConverter k;
    public final NonFatalAnalyticsTracker l;

    public StrConfirmBookingViewModelFactory(@NotNull StrConfirmBookingInteractor strConfirmBookingInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull String str, @NotNull String str2, @NotNull String str3, int i2, @NotNull StrAnalyticsTracker strAnalyticsTracker, @NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull StrConfirmBookingResourceProvider strConfirmBookingResourceProvider, @NotNull StrContactsTreeConverter strContactsTreeConverter, @NotNull NonFatalAnalyticsTracker nonFatalAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(strConfirmBookingInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "checkInDate");
        Intrinsics.checkNotNullParameter(str3, "checkOutDate");
        Intrinsics.checkNotNullParameter(strAnalyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "elementConverter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(strConfirmBookingResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(strContactsTreeConverter, "contactsTreeConverter");
        Intrinsics.checkNotNullParameter(nonFatalAnalyticsTracker, "nonFatalAnalyticsTracker");
        this.a = strConfirmBookingInteractor;
        this.b = schedulersFactory;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = i2;
        this.g = strAnalyticsTracker;
        this.h = categoryParametersElementConverter;
        this.i = attributedTextFormatter;
        this.j = strConfirmBookingResourceProvider;
        this.k = strContactsTreeConverter;
        this.l = nonFatalAnalyticsTracker;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(StrConfirmBookingViewModelImpl.class)) {
            return new StrConfirmBookingViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
