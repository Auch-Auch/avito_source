package com.avito.android.short_term_rent.hotels;

import a2.a.a.v2.b.h;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.hotels.Adults;
import com.avito.android.remote.model.hotels.Children;
import com.avito.android.remote.model.hotels.Dates;
import com.avito.android.remote.model.hotels.HotelsFilters;
import com.avito.android.remote.model.hotels.HotelsFiltersResult;
import com.avito.android.remote.model.hotels.HotelsLocation;
import com.avito.android.short_term_rent.analytics.event.HotelsFindButtonClickEvent;
import com.avito.android.short_term_rent.analytics.event.HotelsFindEvent;
import com.avito.android.short_term_rent.hotels.data.BookingPeople;
import com.avito.android.short_term_rent.hotels.data.FiltersData;
import com.avito.android.short_term_rent.hotels.data.FiltersDataKt;
import com.avito.android.short_term_rent.hotels.data.HotelsCalendarRestrictions;
import com.avito.android.short_term_rent.hotels.data.HotelsRepository;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx3.Flowables;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001=B)\u0012\b\u00106\u001a\u0004\u0018\u000103\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b;\u0010<J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006>"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/HotelsViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction;", "routingActions", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/short_term_rent/hotels/HotelsView;", "hotelsView", "", "init", "(Lcom/avito/android/short_term_rent/hotels/HotelsView;)V", "Lcom/avito/android/str_calendar/utils/DateRange;", "selectedValue", "datesChanged", "(Lcom/avito/android/str_calendar/utils/DateRange;)V", "Lcom/avito/android/remote/model/hotels/HotelsLocation;", "location", "locationChanged", "(Lcom/avito/android/remote/model/hotels/HotelsLocation;)V", "Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", "people", "guestsChanged", "(Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;)V", "onCleared", "()V", "c", "Lcom/avito/android/analytics/Analytics;", "k", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/short_term_rent/hotels/HotelsView;", "view", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", g.a, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/util/SchedulersFactory3;", "j", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/model/hotels/HotelsFiltersResult;", "e", "Lcom/avito/android/remote/model/hotels/HotelsFiltersResult;", "initialData", "Lcom/avito/android/short_term_rent/hotels/data/FiltersData;", "f", "Lcom/avito/android/short_term_rent/hotels/data/FiltersData;", "filtersData", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "", "h", "Ljava/lang/String;", "marker", "Lcom/avito/android/short_term_rent/hotels/data/HotelsRepository;", "i", "Lcom/avito/android/short_term_rent/hotels/data/HotelsRepository;", "repository", "<init>", "(Ljava/lang/String;Lcom/avito/android/short_term_rent/hotels/data/HotelsRepository;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;)V", "RoutingAction", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsViewModel extends ViewModel {
    public HotelsView c;
    public final CompositeDisposable d = new CompositeDisposable();
    public HotelsFiltersResult e;
    public FiltersData f;
    public final SingleLiveEvent<RoutingAction> g = new SingleLiveEvent<>();
    public final String h;
    public final HotelsRepository i;
    public final SchedulersFactory3 j;
    public final Analytics k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction;", "", "<init>", "()V", "Back", "OpenCalendar", "OpenDeepLink", "OpenGuestsDialog", "OpenLocationDialog", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction$Back;", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction$OpenCalendar;", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction$OpenLocationDialog;", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction$OpenGuestsDialog;", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction$OpenDeepLink;", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RoutingAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction$Back;", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction;", "<init>", "()V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
        public static final class Back extends RoutingAction {
            @NotNull
            public static final Back INSTANCE = new Back();

            public Back() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction$OpenCalendar;", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction;", "Lcom/avito/android/short_term_rent/hotels/data/HotelsCalendarRestrictions;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/short_term_rent/hotels/data/HotelsCalendarRestrictions;", "getRestrictions", "()Lcom/avito/android/short_term_rent/hotels/data/HotelsCalendarRestrictions;", "restrictions", "Lcom/avito/android/str_calendar/utils/DateRange;", AuthSource.SEND_ABUSE, "Lcom/avito/android/str_calendar/utils/DateRange;", "getSelected", "()Lcom/avito/android/str_calendar/utils/DateRange;", "selected", "<init>", "(Lcom/avito/android/str_calendar/utils/DateRange;Lcom/avito/android/short_term_rent/hotels/data/HotelsCalendarRestrictions;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
        public static final class OpenCalendar extends RoutingAction {
            @NotNull
            public final DateRange a;
            @Nullable
            public final HotelsCalendarRestrictions b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OpenCalendar(@NotNull DateRange dateRange, @Nullable HotelsCalendarRestrictions hotelsCalendarRestrictions) {
                super(null);
                Intrinsics.checkNotNullParameter(dateRange, "selected");
                this.a = dateRange;
                this.b = hotelsCalendarRestrictions;
            }

            @Nullable
            public final HotelsCalendarRestrictions getRestrictions() {
                return this.b;
            }

            @NotNull
            public final DateRange getSelected() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction$OpenDeepLink;", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "link", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
        public static final class OpenDeepLink extends RoutingAction {
            @NotNull
            public final DeepLink a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OpenDeepLink(@NotNull DeepLink deepLink) {
                super(null);
                Intrinsics.checkNotNullParameter(deepLink, "link");
                this.a = deepLink;
            }

            @NotNull
            public final DeepLink getLink() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction$OpenGuestsDialog;", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction;", "Lcom/avito/android/remote/model/hotels/Adults;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/hotels/Adults;", "getAdults", "()Lcom/avito/android/remote/model/hotels/Adults;", "adults", "Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", AuthSource.SEND_ABUSE, "Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", "getSelected", "()Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", "selected", "Lcom/avito/android/remote/model/hotels/Children;", "c", "Lcom/avito/android/remote/model/hotels/Children;", "getChildren", "()Lcom/avito/android/remote/model/hotels/Children;", "children", "<init>", "(Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;Lcom/avito/android/remote/model/hotels/Adults;Lcom/avito/android/remote/model/hotels/Children;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
        public static final class OpenGuestsDialog extends RoutingAction {
            @NotNull
            public final BookingPeople a;
            @NotNull
            public final Adults b;
            @NotNull
            public final Children c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OpenGuestsDialog(@NotNull BookingPeople bookingPeople, @NotNull Adults adults, @NotNull Children children) {
                super(null);
                Intrinsics.checkNotNullParameter(bookingPeople, "selected");
                Intrinsics.checkNotNullParameter(adults, "adults");
                Intrinsics.checkNotNullParameter(children, "children");
                this.a = bookingPeople;
                this.b = adults;
                this.c = children;
            }

            @NotNull
            public final Adults getAdults() {
                return this.b;
            }

            @NotNull
            public final Children getChildren() {
                return this.c;
            }

            @NotNull
            public final BookingPeople getSelected() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction$OpenLocationDialog;", "Lcom/avito/android/short_term_rent/hotels/HotelsViewModel$RoutingAction;", "", "Lcom/avito/android/remote/model/hotels/HotelsLocation;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getPreselected", "()Ljava/util/List;", "preselected", "<init>", "(Ljava/util/List;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
        public static final class OpenLocationDialog extends RoutingAction {
            @NotNull
            public final List<HotelsLocation> a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OpenLocationDialog(@NotNull List<HotelsLocation> list) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "preselected");
                this.a = list;
            }

            @NotNull
            public final List<HotelsLocation> getPreselected() {
                return this.a;
            }
        }

        public RoutingAction() {
        }

        public RoutingAction(j jVar) {
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Unit unit) {
            HotelsFilters filters;
            Dates dates;
            FiltersData filtersData;
            int i = this.a;
            if (i == 0) {
                ((HotelsViewModel) this.b).c();
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((HotelsViewModel) this.b).g.postValue(RoutingAction.Back.INSTANCE);
                return Unit.INSTANCE;
            } else if (i != 2) {
                HotelsCalendarRestrictions hotelsCalendarRestrictions = null;
                if (i == 3) {
                    FiltersData filtersData2 = ((HotelsViewModel) this.b).f;
                    if (filtersData2 != null) {
                        HotelsFiltersResult hotelsFiltersResult = ((HotelsViewModel) this.b).e;
                        if (!(hotelsFiltersResult == null || (filters = hotelsFiltersResult.getFilters()) == null || (dates = filters.getDates()) == null)) {
                            hotelsCalendarRestrictions = new HotelsCalendarRestrictions(FiltersDataKt.toRestrictionsRange(dates), dates.getMaxLength());
                        }
                        ((HotelsViewModel) this.b).g.postValue(new RoutingAction.OpenCalendar(filtersData2.getDates(), hotelsCalendarRestrictions));
                    }
                    return Unit.INSTANCE;
                } else if (i == 4) {
                    HotelsFiltersResult hotelsFiltersResult2 = ((HotelsViewModel) this.b).e;
                    if (hotelsFiltersResult2 != null) {
                        ((HotelsViewModel) this.b).g.postValue(new RoutingAction.OpenLocationDialog(hotelsFiltersResult2.getDefaultLocations()));
                    }
                    return Unit.INSTANCE;
                } else if (i == 5) {
                    HotelsFiltersResult hotelsFiltersResult3 = ((HotelsViewModel) this.b).e;
                    if (!(hotelsFiltersResult3 == null || (filtersData = ((HotelsViewModel) this.b).f) == null)) {
                        ((HotelsViewModel) this.b).g.postValue(new RoutingAction.OpenGuestsDialog(filtersData.getPeople(), hotelsFiltersResult3.getFilters().getAdults(), hotelsFiltersResult3.getFilters().getChildren()));
                    }
                    return Unit.INSTANCE;
                } else {
                    throw null;
                }
            } else {
                HotelsViewModel.access$find((HotelsViewModel) this.b);
                return Unit.INSTANCE;
            }
        }
    }

    public static final class b<T> implements Consumer<HotelsFiltersResult> {
        public final /* synthetic */ HotelsViewModel a;

        public b(HotelsViewModel hotelsViewModel) {
            this.a = hotelsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(HotelsFiltersResult hotelsFiltersResult) {
            HotelsView hotelsView;
            HotelsFiltersResult hotelsFiltersResult2 = hotelsFiltersResult;
            this.a.e = hotelsFiltersResult2;
            HotelsView hotelsView2 = this.a.c;
            if (hotelsView2 != null) {
                hotelsView2.fillFormWithData(hotelsFiltersResult2.getTitle(), hotelsFiltersResult2.getInformation(), hotelsFiltersResult2.getDiscountBanner());
            }
            this.a.f = new FiltersData(null, FiltersDataKt.toDateRange(hotelsFiltersResult2.getFilters().getDates()), new BookingPeople(hotelsFiltersResult2.getFilters().getAdults().getValue(), new ArrayList()));
            FiltersData filtersData = this.a.f;
            if (!(filtersData == null || (hotelsView = this.a.c) == null)) {
                hotelsView.fillFiltersWithData(filtersData);
            }
            HotelsView hotelsView3 = this.a.c;
            if (hotelsView3 != null) {
                hotelsView3.showContent();
            }
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ HotelsViewModel a;

        public c(HotelsViewModel hotelsViewModel) {
            this.a = hotelsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            HotelsView hotelsView = this.a.c;
            if (hotelsView != null) {
                hotelsView.showRetry();
            }
            Logs.error("Can't load hotels initial data", th2);
        }
    }

    public HotelsViewModel(@Nullable String str, @NotNull HotelsRepository hotelsRepository, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(hotelsRepository, "repository");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.h = str;
        this.i = hotelsRepository;
        this.j = schedulersFactory3;
        this.k = analytics;
    }

    public static final void access$find(HotelsViewModel hotelsViewModel) {
        HotelsLocation location;
        FiltersData filtersData = hotelsViewModel.f;
        if (filtersData == null || filtersData.getLocation() == null) {
            HotelsView hotelsView = hotelsViewModel.c;
            if (hotelsView != null) {
                hotelsView.showLocationError();
                return;
            }
            return;
        }
        FiltersData filtersData2 = hotelsViewModel.f;
        if (filtersData2 != null && (location = filtersData2.getLocation()) != null) {
            int adults = filtersData2.getPeople().getAdults();
            DateRange dates = filtersData2.getDates();
            Map<String, String> fieldMap = FiltersDataKt.toFieldMap(filtersData2);
            hotelsViewModel.k.track(new HotelsFindButtonClickEvent(location, adults, dates));
            hotelsViewModel.k.track(new HotelsFindEvent(fieldMap));
            CompositeDisposable compositeDisposable = hotelsViewModel.d;
            Disposable subscribe = hotelsViewModel.i.submitHotelsSearch(hotelsViewModel.h, filtersData2).subscribeOn(hotelsViewModel.j.io()).observeOn(hotelsViewModel.j.mainThread()).subscribe(new a2.a.a.v2.b.g(hotelsViewModel), new h(hotelsViewModel));
            Intrinsics.checkNotNullExpressionValue(subscribe, "repository.submitHotelsS…kBar()\n                })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void c() {
        HotelsView hotelsView = this.c;
        if (hotelsView != null) {
            hotelsView.showProgress();
        }
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.i.getInitialScreenData().subscribeOn(this.j.io()).observeOn(this.j.mainThread()).subscribe(new b(this), new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getInitialScr…\", it)\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void datesChanged(@Nullable DateRange dateRange) {
        HotelsFilters filters;
        Dates dates;
        DateRange dateRange2;
        HotelsView hotelsView;
        HotelsFiltersResult hotelsFiltersResult = this.e;
        if (hotelsFiltersResult != null && (filters = hotelsFiltersResult.getFilters()) != null && (dates = filters.getDates()) != null && (dateRange2 = FiltersDataKt.toDateRange(dates)) != null) {
            if (dateRange == null) {
                dateRange = dateRange2;
            }
            FiltersData filtersData = this.f;
            if (filtersData != null) {
                filtersData.setDates(dateRange);
            }
            FiltersData filtersData2 = this.f;
            if (filtersData2 != null && (hotelsView = this.c) != null) {
                hotelsView.fillFiltersWithData(filtersData2);
            }
        }
    }

    public final void guestsChanged(@Nullable BookingPeople bookingPeople) {
        HotelsFilters filters;
        Adults adults;
        HotelsView hotelsView;
        HotelsFiltersResult hotelsFiltersResult = this.e;
        if (hotelsFiltersResult != null && (filters = hotelsFiltersResult.getFilters()) != null && (adults = filters.getAdults()) != null) {
            BookingPeople bookingPeople2 = new BookingPeople(adults.getValue(), new ArrayList());
            if (bookingPeople == null) {
                bookingPeople = bookingPeople2;
            }
            FiltersData filtersData = this.f;
            if (filtersData != null) {
                filtersData.setPeople(bookingPeople);
            }
            FiltersData filtersData2 = this.f;
            if (filtersData2 != null && (hotelsView = this.c) != null) {
                hotelsView.fillFiltersWithData(filtersData2);
            }
        }
    }

    public final void init(@NotNull HotelsView hotelsView) {
        Intrinsics.checkNotNullParameter(hotelsView, "hotelsView");
        this.c = hotelsView;
        CompositeDisposable compositeDisposable = this.d;
        Observable<Unit> retryLoadingClicks = hotelsView.retryLoadingClicks();
        BackpressureStrategy backpressureStrategy = BackpressureStrategy.DROP;
        DisposableKt.plusAssign(compositeDisposable, Flowables.subscribeOnNext(a2.b.a.a.a.Z1(this.j, retryLoadingClicks.toFlowable(backpressureStrategy), "hotelsView.retryLoadingC…(schedulers.mainThread())"), new a(0, this)));
        DisposableKt.plusAssign(this.d, Flowables.subscribeOnNext(a2.b.a.a.a.Z1(this.j, hotelsView.upButtonClicks().toFlowable(backpressureStrategy), "hotelsView.upButtonClick…(schedulers.mainThread())"), new a(1, this)));
        DisposableKt.plusAssign(this.d, Flowables.subscribeOnNext(a2.b.a.a.a.Z1(this.j, hotelsView.findButtonClicks().toFlowable(backpressureStrategy), "hotelsView.findButtonCli…(schedulers.mainThread())"), new a(2, this)));
        DisposableKt.plusAssign(this.d, Flowables.subscribeOnNext(a2.b.a.a.a.Z1(this.j, hotelsView.dateFilterClicks().toFlowable(backpressureStrategy), "hotelsView.dateFilterCli…(schedulers.mainThread())"), new a(3, this)));
        DisposableKt.plusAssign(this.d, Flowables.subscribeOnNext(a2.b.a.a.a.Z1(this.j, hotelsView.locationFilterClicks().toFlowable(backpressureStrategy), "hotelsView.locationFilte…(schedulers.mainThread())"), new a(4, this)));
        DisposableKt.plusAssign(this.d, Flowables.subscribeOnNext(a2.b.a.a.a.Z1(this.j, hotelsView.guestsFilterClicks().toFlowable(backpressureStrategy), "hotelsView.guestsFilterC…(schedulers.mainThread())"), new a(5, this)));
        HotelsFiltersResult hotelsFiltersResult = this.e;
        if (hotelsFiltersResult == null) {
            c();
            return;
        }
        HotelsView hotelsView2 = this.c;
        if (hotelsView2 != null) {
            hotelsView2.fillFormWithData(hotelsFiltersResult.getTitle(), hotelsFiltersResult.getInformation(), hotelsFiltersResult.getDiscountBanner());
        }
    }

    public final void locationChanged(@Nullable HotelsLocation hotelsLocation) {
        HotelsView hotelsView;
        FiltersData filtersData = this.f;
        if (filtersData != null) {
            filtersData.setLocation(hotelsLocation);
        }
        FiltersData filtersData2 = this.f;
        if (filtersData2 != null && (hotelsView = this.c) != null) {
            hotelsView.fillFiltersWithData(filtersData2);
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.d.dispose();
        this.c = null;
        super.onCleared();
    }

    @NotNull
    public final LiveData<RoutingAction> routingActions() {
        return this.g;
    }
}
