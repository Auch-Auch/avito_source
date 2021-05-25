package com.avito.android.short_term_rent.start_booking;

import a2.g.r.g;
import android.content.Intent;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.StrBookingCalculateDetailsResponse;
import com.avito.android.remote.model.StrBookingDisclaimer;
import com.avito.android.short_term_rent.analytics.StrAnalyticsTracker;
import com.avito.android.short_term_rent.confirm_booking.event.ConfirmBookingEvent;
import com.avito.android.short_term_rent.start_booking.items.disclaimer.DisclaimerItem;
import com.avito.android.short_term_rent.start_booking.items.enter_departure.SelectItem;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCount;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountItem;
import com.avito.android.short_term_rent.start_booking.items.summary.SummaryItem;
import com.avito.android.short_term_rent.start_booking.items.summary.loading.SummaryLoadingItem;
import com.avito.android.short_term_rent.start_booking.utils.StrStartBookingResourceProvider;
import com.avito.android.short_term_rent.utils.StrDateUtilsKt;
import com.avito.android.str.StrCalendarActivityInteractionConstants;
import com.avito.android.util.ListUtils;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002Bc\u0012\u0006\u0010i\u001a\u00020f\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010M\u001a\u000200\u0012\u0006\u0010G\u001a\u000200\u0012\u0006\u0010o\u001a\u00020n\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010?\u001a\u00020<\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\b\u0010(\u001a\u0004\u0018\u00010&\u0012\u0006\u0010p\u001a\u00020\u000e¢\u0006\u0004\bq\u0010rJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0014\u0010\tJ\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\tJ\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\tJ\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\tJ\u001d\u0010$\u001a\u00020\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0017H\u0002¢\u0006\u0004\b$\u0010%J'\u0010)\u001a\u00020\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b)\u0010*R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010,\u001a\u0004\b-\u0010.R\"\u00102\u001a\b\u0012\u0004\u0012\u0002000+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010,\u001a\u0004\b1\u0010.R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u000208078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R(\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u00170@8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010G\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010FR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\"0\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010:R\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010W\u001a\b\u0012\u0004\u0012\u00020T0+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bU\u0010,\u001a\u0004\bV\u0010.R\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010ZR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010aR8\u0010e\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u000200\u0012\u0006\u0012\u0004\u0018\u00010&\u0012\u0006\u0012\u0004\u0018\u00010&0b0+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bc\u0010,\u001a\u0004\bd\u0010.R\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010l\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bm\u0010a¨\u0006s"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "onNextButtonClicked", "()V", "", "count", "onGuestsCountClick", "(I)V", "", "success", "Landroid/content/Intent;", "data", "onDatesSelected", "(ZLandroid/content/Intent;)V", "onCleared", "onClick", "onClear", "", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCount;", "guestsCounts", "()Ljava/util/List;", "Landroid/os/Bundle;", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onRestoreInstanceState", "onAuthCompleted", "c", "Lcom/avito/conveyor_item/Item;", "newItems", "e", "(Ljava/util/List;)V", "Ljava/util/Date;", "checkInDate", "checkOutDate", "d", "(Ljava/util/Date;Ljava/util/Date;)V", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getAuthScreenChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "authScreenChanges", "", "getErrorMessageChanges", "errorMessageChanges", "Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;", "r", "Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;", "analyticsTracker", "", "Lkotlin/ranges/IntRange;", "h", "Ljava/util/List;", "groups", "Lcom/avito/android/util/text/AttributedTextFormatter;", "t", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "getGroupsChanges", "()Landroidx/lifecycle/MutableLiveData;", "groupsChanges", VKApiConst.Q, "Ljava/lang/String;", "source", "Lcom/avito/android/util/SchedulersFactory;", "o", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "p", BookingInfoActivity.EXTRA_ITEM_ID, "i", "items", "Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingResourceProvider;", "s", "Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingResourceProvider;", "resourceProvider", "Lcom/avito/android/short_term_rent/confirm_booking/event/ConfirmBookingEvent;", "f", "getNextButtonClicks", "nextButtonClicks", "Lio/reactivex/disposables/Disposable;", "j", "Lio/reactivex/disposables/Disposable;", "authorizedDisposable", "k", "calculateDisposable", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/konveyor/adapter/AdapterPresenter;", VKApiConst.VERSION, "Ljava/util/Date;", "Lkotlin/Triple;", g.a, "getSelectDatesChanges", "selectDatesChanges", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingInteractor;", "n", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingInteractor;", "interactor", "l", "Ljava/lang/Integer;", "guestsCount", "u", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "showCalendar", "<init>", "(Lcom/avito/android/short_term_rent/start_booking/StrStartBookingInteractor;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingResourceProvider;Lcom/avito/android/util/text/AttributedTextFormatter;Ljava/util/Date;Ljava/util/Date;Z)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrStartBookingViewModelImpl extends ViewModel implements StrStartBookingViewModel {
    @NotNull
    public final MutableLiveData<List<IntRange>> c = new MutableLiveData<>();
    @NotNull
    public final SingleLiveEvent<String> d = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Unit> e = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<ConfirmBookingEvent> f = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Triple<String, Date, Date>> g = new SingleLiveEvent<>();
    public final List<IntRange> h;
    public List<? extends Item> i;
    public Disposable j;
    public Disposable k;
    public Integer l;
    public AdapterPresenter m;
    public final StrStartBookingInteractor n;
    public final SchedulersFactory o;
    public final String p;
    public final String q;
    public final StrAnalyticsTracker r;
    public final StrStartBookingResourceProvider s;
    public final AttributedTextFormatter t;
    public Date u;
    public Date v;

    public static final class a<T> implements Predicate<Boolean> {
        public final /* synthetic */ StrStartBookingViewModelImpl a;

        public a(StrStartBookingViewModelImpl strStartBookingViewModelImpl) {
            this.a = strStartBookingViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "authorized");
            if (bool2.booleanValue()) {
                this.a.r.trackShowStartBookingScreenEvent(this.a.q);
            }
            return !bool2.booleanValue();
        }
    }

    public static final class b<T> implements Consumer<Boolean> {
        public final /* synthetic */ StrStartBookingViewModelImpl a;

        public b(StrStartBookingViewModelImpl strStartBookingViewModelImpl) {
            this.a = strStartBookingViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            this.a.getAuthScreenChanges().setValue(Unit.INSTANCE);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class d<T> implements Consumer<LoadingState<? super StrBookingCalculateDetailsResponse>> {
        public final /* synthetic */ StrStartBookingViewModelImpl a;

        public d(StrStartBookingViewModelImpl strStartBookingViewModelImpl) {
            this.a = strStartBookingViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super StrBookingCalculateDetailsResponse> loadingState) {
            LoadingState<? super StrBookingCalculateDetailsResponse> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                StrStartBookingViewModelImpl.access$onCalculationsLoaded(this.a, (StrBookingCalculateDetailsResponse) ((LoadingState.Loaded) loadingState2).getData());
            } else if (loadingState2 instanceof LoadingState.Loading) {
                StrStartBookingViewModelImpl.access$onCalculationsLoading(this.a);
            } else if (loadingState2 instanceof LoadingState.Error) {
                StrStartBookingViewModelImpl.access$onCalculationsLoadingError(this.a, ((LoadingState.Error) loadingState2).getError());
            }
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ StrStartBookingViewModelImpl a;

        public e(StrStartBookingViewModelImpl strStartBookingViewModelImpl) {
            this.a = strStartBookingViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            StrStartBookingViewModelImpl.access$removeCalculationDetails(this.a);
            this.a.getErrorMessageChanges().setValue(this.a.s.getErrorOccurred());
        }
    }

    public StrStartBookingViewModelImpl(@NotNull StrStartBookingInteractor strStartBookingInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull String str, @NotNull String str2, @NotNull AccountStateProvider accountStateProvider, @NotNull StrAnalyticsTracker strAnalyticsTracker, @NotNull StrStartBookingResourceProvider strStartBookingResourceProvider, @NotNull AttributedTextFormatter attributedTextFormatter, @Nullable Date date, @Nullable Date date2, boolean z) {
        Intrinsics.checkNotNullParameter(strStartBookingInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "source");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(strAnalyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(strStartBookingResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.n = strStartBookingInteractor;
        this.o = schedulersFactory;
        this.p = str;
        this.q = str2;
        this.r = strAnalyticsTracker;
        this.s = strStartBookingResourceProvider;
        this.t = attributedTextFormatter;
        this.u = date;
        this.v = date2;
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        this.i = CollectionsKt__CollectionsKt.emptyList();
        this.j = InteropKt.toV2(accountStateProvider.currentAuthorized()).subscribeOn(schedulersFactory.io()).filter(new a(this)).observeOn(schedulersFactory.mainThread()).subscribe(new b(this), c.a);
        List<? extends Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.i);
        mutableList.add(0, new SelectItem(String.valueOf(0), strStartBookingResourceProvider.getEnterDepartureHint(), null, 4, null));
        arrayList.add(0, new IntRange(0, 0));
        AdapterPresenter adapterPresenter = this.m;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(mutableList, adapterPresenter);
        }
        this.i = mutableList;
        this.l = Integer.valueOf(((GuestsCount) ListUtils.second(guestsCounts())).getCount());
        List<? extends Item> mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) this.i);
        mutableList2.add(1, new GuestsCountItem(String.valueOf(1), this.l));
        arrayList.add(1, new IntRange(1, 1));
        AdapterPresenter adapterPresenter2 = this.m;
        if (adapterPresenter2 != null) {
            a2.b.a.a.a.s1(mutableList2, adapterPresenter2);
        }
        this.i = mutableList2;
        getGroupsChanges().setValue(arrayList);
        if (!(this.u == null || this.v == null)) {
            c();
            d(this.u, this.v);
        }
        if (z) {
            onClick();
        }
    }

    public static final void access$onCalculationsLoaded(StrStartBookingViewModelImpl strStartBookingViewModelImpl, StrBookingCalculateDetailsResponse strBookingCalculateDetailsResponse) {
        List<? extends Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) strStartBookingViewModelImpl.i);
        StrStartBookingViewModelKt.cutToEnd(mutableList, 2);
        StrStartBookingViewModelKt.cutToEnd(strStartBookingViewModelImpl.h, 2);
        int i2 = 0;
        for (T t2 : strBookingCalculateDetailsResponse.getCalculations()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t3 = t2;
            String valueOf = String.valueOf(i2 + 2);
            CharSequence formatIgnoreColors = strStartBookingViewModelImpl.t.formatIgnoreColors(t3.getTitle());
            Intrinsics.checkNotNull(formatIgnoreColors);
            CharSequence formatIgnoreColors2 = strStartBookingViewModelImpl.t.formatIgnoreColors(t3.getDescription());
            Intrinsics.checkNotNull(formatIgnoreColors2);
            mutableList.add(new SummaryItem(valueOf, formatIgnoreColors, formatIgnoreColors2));
            i2 = i3;
        }
        strStartBookingViewModelImpl.h.add(new IntRange(2, (strBookingCalculateDetailsResponse.getCalculations().size() + 2) - 1));
        StrBookingDisclaimer disclaimer = strBookingCalculateDetailsResponse.getDisclaimer();
        if (disclaimer != null) {
            int size = strBookingCalculateDetailsResponse.getCalculations().size() + 2;
            mutableList.add(size, new DisclaimerItem(String.valueOf(size), disclaimer.getText()));
        }
        strStartBookingViewModelImpl.getGroupsChanges().setValue(strStartBookingViewModelImpl.h);
        strStartBookingViewModelImpl.e(mutableList);
    }

    public static final void access$onCalculationsLoading(StrStartBookingViewModelImpl strStartBookingViewModelImpl) {
        List<? extends Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) strStartBookingViewModelImpl.i);
        StrStartBookingViewModelKt.cutToEnd(mutableList, 2);
        StrStartBookingViewModelKt.cutToEnd(strStartBookingViewModelImpl.h, 2);
        mutableList.add(2, new SummaryLoadingItem(String.valueOf(2)));
        strStartBookingViewModelImpl.h.add(new IntRange(2, 2));
        strStartBookingViewModelImpl.getGroupsChanges().setValue(strStartBookingViewModelImpl.h);
        AdapterPresenter adapterPresenter = strStartBookingViewModelImpl.m;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(mutableList, adapterPresenter);
        }
        strStartBookingViewModelImpl.i = mutableList;
    }

    public static final void access$onCalculationsLoadingError(StrStartBookingViewModelImpl strStartBookingViewModelImpl, TypedError typedError) {
        List<? extends Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) strStartBookingViewModelImpl.i);
        StrStartBookingViewModelKt.cutToEnd(mutableList, 2);
        strStartBookingViewModelImpl.e(mutableList);
        if (typedError instanceof ErrorWithMessage) {
            strStartBookingViewModelImpl.getErrorMessageChanges().setValue(((ErrorWithMessage) typedError).getMessage());
        }
    }

    public static final void access$removeCalculationDetails(StrStartBookingViewModelImpl strStartBookingViewModelImpl) {
        List<? extends Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) strStartBookingViewModelImpl.i);
        StrStartBookingViewModelKt.cutToEnd(mutableList, 2);
        strStartBookingViewModelImpl.e(mutableList);
    }

    public final void c() {
        Date date = this.u;
        Date date2 = this.v;
        Integer num = this.l;
        if (date != null && date2 != null && num != null) {
            Disposable disposable = this.k;
            if (disposable != null) {
                disposable.dispose();
            }
            this.k = this.n.getBookingCalculateDetails(StrDateUtilsKt.convertToStrDate(date), StrDateUtilsKt.convertToStrDate(date2), num.intValue(), this.p).observeOn(this.o.mainThread()).subscribe(new d(this), new e(this));
        }
    }

    public final void d(Date date, Date date2) {
        String str;
        List<? extends Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.i);
        mutableList.remove(0);
        if (date == null || date2 == null) {
            str = null;
        } else {
            str = StrDateUtilsKt.convertStrDateToDMMMM(date) + " – " + StrDateUtilsKt.convertStrDateToDMMMM(date2);
        }
        mutableList.add(0, new SelectItem(String.valueOf(0), this.s.getEnterDepartureHint(), str));
        AdapterPresenter adapterPresenter = this.m;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(mutableList, adapterPresenter);
        }
        this.i = mutableList;
    }

    public final void e(List<? extends Item> list) {
        AdapterPresenter adapterPresenter = this.m;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(list, adapterPresenter);
        }
        this.i = list;
    }

    @Override // com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountsProvider
    @NotNull
    public List<GuestsCount> guestsCounts() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new GuestsCount[]{new GuestsCount(1, "1"), new GuestsCount(2, ExifInterface.GPS_MEASUREMENT_2D), new GuestsCount(3, ExifInterface.GPS_MEASUREMENT_3D), new GuestsCount(4, "4"), new GuestsCount(5, "5+")});
    }

    @Override // com.avito.android.short_term_rent.start_booking.StrStartBookingViewModel
    public void onAuthCompleted() {
        this.r.trackShowStartBookingScreenEvent(this.q);
    }

    @Override // com.avito.android.short_term_rent.start_booking.items.enter_departure.SelectItemClearListenter
    public void onClear() {
        this.u = null;
        this.v = null;
        List<? extends Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.i);
        mutableList.remove(0);
        mutableList.add(0, new SelectItem(String.valueOf(0), this.s.getEnterDepartureHint(), null, 4, null));
        StrStartBookingViewModelKt.cutToEnd(mutableList, 2);
        AdapterPresenter adapterPresenter = this.m;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(mutableList, adapterPresenter);
        }
        this.i = mutableList;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.k;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }

    @Override // com.avito.android.short_term_rent.start_booking.items.enter_departure.SelectItemClickListenter
    public void onClick() {
        this.r.trackShowCalendarEvent();
        getSelectDatesChanges().setValue(new Triple<>(this.p, this.u, this.v));
    }

    @Override // com.avito.android.short_term_rent.start_booking.StrStartBookingViewModel
    public void onDatesSelected(boolean z, @Nullable Intent intent) {
        if (z) {
            if (intent != null) {
                Date date = (Date) intent.getSerializableExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_IN_DATE);
                if (date != null) {
                    Date date2 = (Date) intent.getSerializableExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE);
                    if (date2 != null) {
                        this.u = date;
                        this.v = date2;
                        c();
                    } else {
                        throw new IllegalArgumentException("Data does not contain check out date");
                    }
                } else {
                    throw new IllegalArgumentException("Data does not contain check in date");
                }
            }
            d(this.u, this.v);
            return;
        }
        getErrorMessageChanges().setValue(this.s.getChooseDatesErrorOccurred());
    }

    @Override // com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountClickListener
    public void onGuestsCountClick(int i2) {
        this.l = Integer.valueOf(i2);
        List<? extends Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.i);
        mutableList.remove(1);
        mutableList.add(1, new GuestsCountItem(String.valueOf(1), this.l));
        AdapterPresenter adapterPresenter = this.m;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(mutableList, adapterPresenter);
        }
        this.i = mutableList;
        c();
        this.r.trackSelectGuestsCountEvent();
    }

    @Override // com.avito.android.short_term_rent.start_booking.StrStartBookingViewModel
    public void onNextButtonClicked() {
        Date date = this.u;
        Date date2 = this.v;
        Integer num = this.l;
        if (date == null || date2 == null || num == null) {
            getErrorMessageChanges().setValue(this.s.getFillParams());
        } else {
            getNextButtonClicks().setValue(new ConfirmBookingEvent(this.p, StrDateUtilsKt.convertToStrDate(date), StrDateUtilsKt.convertToStrDate(date2), num.intValue()));
        }
    }

    @Override // com.avito.android.short_term_rent.start_booking.StrStartBookingViewModel
    public void onRestoreInstanceState(@NotNull Bundle bundle) {
        Date date;
        Intrinsics.checkNotNullParameter(bundle, "outState");
        Serializable serializable = bundle.getSerializable("bundle_check_in_date");
        if (serializable != null) {
            this.u = (Date) serializable;
        }
        Serializable serializable2 = bundle.getSerializable("bundle_check_out_date");
        if (serializable2 != null) {
            this.v = (Date) serializable2;
        }
        Date date2 = this.u;
        if (!(date2 == null || (date = this.v) == null)) {
            d(date2, date);
        }
        int i2 = bundle.getInt("bundle_guests_count");
        this.l = Integer.valueOf(i2);
        onGuestsCountClick(i2);
    }

    @Override // com.avito.android.short_term_rent.start_booking.StrStartBookingViewModel
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        Date date = this.u;
        if (date != null) {
            bundle.putSerializable("bundle_check_in_date", date);
        }
        Date date2 = this.v;
        if (date2 != null) {
            bundle.putSerializable("bundle_check_out_date", date2);
        }
        Integer num = this.l;
        if (num != null) {
            bundle.putInt("bundle_guests_count", num.intValue());
        }
    }

    @Override // com.avito.android.short_term_rent.start_booking.StrStartBookingViewModel
    public void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.m = adapterPresenter;
        adapterPresenter.onDataSourceChanged(new ListDataSource(this.i));
    }

    @Override // com.avito.android.short_term_rent.start_booking.StrStartBookingViewModel
    @NotNull
    public SingleLiveEvent<Unit> getAuthScreenChanges() {
        return this.e;
    }

    @Override // com.avito.android.short_term_rent.start_booking.StrStartBookingViewModel
    @NotNull
    public SingleLiveEvent<String> getErrorMessageChanges() {
        return this.d;
    }

    @Override // com.avito.android.short_term_rent.start_booking.StrStartBookingViewModel
    @NotNull
    public MutableLiveData<List<IntRange>> getGroupsChanges() {
        return this.c;
    }

    @Override // com.avito.android.short_term_rent.start_booking.StrStartBookingViewModel
    @NotNull
    public SingleLiveEvent<ConfirmBookingEvent> getNextButtonClicks() {
        return this.f;
    }

    @Override // com.avito.android.short_term_rent.start_booking.StrStartBookingViewModel
    @NotNull
    public SingleLiveEvent<Triple<String, Date, Date>> getSelectDatesChanges() {
        return this.g;
    }
}
