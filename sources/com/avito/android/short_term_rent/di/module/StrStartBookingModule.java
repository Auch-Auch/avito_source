package com.avito.android.short_term_rent.di.module;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.recycler.data_aware.SimpleEqualityComparator;
import com.avito.android.short_term_rent.analytics.StrAnalyticsTracker;
import com.avito.android.short_term_rent.di.qualifier.AdvertId;
import com.avito.android.short_term_rent.di.qualifier.CheckInDate;
import com.avito.android.short_term_rent.di.qualifier.CheckOutDate;
import com.avito.android.short_term_rent.di.qualifier.ShowCalendar;
import com.avito.android.short_term_rent.start_booking.StrStartBookingInteractor;
import com.avito.android.short_term_rent.start_booking.StrStartBookingInteractorImpl;
import com.avito.android.short_term_rent.start_booking.StrStartBookingViewModel;
import com.avito.android.short_term_rent.start_booking.StrStartBookingViewModelFactory;
import com.avito.android.short_term_rent.start_booking.StrStartBookingViewModelImpl;
import com.avito.android.short_term_rent.start_booking.items.disclaimer.DisclaimerItemBlueprint;
import com.avito.android.short_term_rent.start_booking.items.disclaimer.DisclaimerItemPresenter;
import com.avito.android.short_term_rent.start_booking.items.enter_departure.SelectItemBlueprint;
import com.avito.android.short_term_rent.start_booking.items.enter_departure.SelectItemClearListenter;
import com.avito.android.short_term_rent.start_booking.items.enter_departure.SelectItemClickListenter;
import com.avito.android.short_term_rent.start_booking.items.enter_departure.SelectItemPresenter;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountBluePrint;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountClickListener;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountItemPresenter;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountItemPresenterImpl;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountsProvider;
import com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemBlueprint;
import com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemPresenter;
import com.avito.android.short_term_rent.start_booking.items.summary.loading.SummaryLoadingItemBlueprint;
import com.avito.android.short_term_rent.start_booking.items.summary.loading.SummaryLoadingItemPresenter;
import com.avito.android.short_term_rent.start_booking.utils.StrStartBookingContentsComparator;
import com.avito.android.short_term_rent.start_booking.utils.StrStartBookingResourceProvider;
import com.avito.android.short_term_rent.start_booking.utils.StrStartBookingResourceProviderImpl;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.Objects;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004\u0001\u0001B\u000b\b\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010 \u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010%\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020!H\u0001¢\u0006\u0004\b#\u0010$J\u0017\u0010*\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020&H\u0001¢\u0006\u0004\b(\u0010)J\u000f\u0010-\u001a\u00020&H\u0001¢\u0006\u0004\b+\u0010,J\u001f\u00100\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010/\u001a\u00020.H\u0007¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\u00192\u0006\u0010/\u001a\u00020.H\u0001¢\u0006\u0004\b2\u00103J\u0017\u00108\u001a\u0002052\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b6\u00107J\u0017\u0010<\u001a\u0002092\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b:\u0010;J+\u0010B\u001a\u00020?2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002050\b2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002090\bH\u0001¢\u0006\u0004\b@\u0010AJ\u0017\u0010F\u001a\u00020C2\u0006\u0010\r\u001a\u00020?H\u0001¢\u0006\u0004\bD\u0010EJ\u000f\u0010J\u001a\u00020GH\u0001¢\u0006\u0004\bH\u0010IJ\u0017\u0010N\u001a\u00020K2\u0006\u0010\r\u001a\u00020GH\u0001¢\u0006\u0004\bL\u0010MJ\u000f\u0010R\u001a\u00020OH\u0001¢\u0006\u0004\bP\u0010QJ\u0017\u0010V\u001a\u00020S2\u0006\u0010\r\u001a\u00020OH\u0001¢\u0006\u0004\bT\u0010UJ\u000f\u0010Z\u001a\u00020WH\u0001¢\u0006\u0004\bX\u0010YJ\u0017\u0010^\u001a\u00020[2\u0006\u0010\r\u001a\u00020WH\u0001¢\u0006\u0004\b\\\u0010]J7\u0010f\u001a\u00020.2\u0006\u0010_\u001a\u00020C2\u0006\u0010`\u001a\u00020\u00102\u0006\u0010a\u001a\u00020K2\u0006\u0010b\u001a\u00020S2\u0006\u0010c\u001a\u00020[H\u0001¢\u0006\u0004\bd\u0010eJ\u001f\u0010m\u001a\u00020\u00022\u0006\u0010h\u001a\u00020g2\u0006\u0010j\u001a\u00020iH\u0001¢\u0006\u0004\bk\u0010lJz\u0010\u0001\u001a\u00020i2\u0006\u0010o\u001a\u00020n2\u0006\u0010q\u001a\u00020p2\b\b\u0001\u0010s\u001a\u00020r2\b\b\u0001\u0010t\u001a\u00020r2\u0006\u0010v\u001a\u00020u2\u0006\u0010x\u001a\u00020w2\u0006\u0010z\u001a\u00020y2\u0006\u0010|\u001a\u00020{2\n\b\u0001\u0010~\u001a\u0004\u0018\u00010}2\n\b\u0001\u0010\u001a\u0004\u0018\u00010}2\n\b\u0001\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/short_term_rent/di/module/StrStartBookingModule;", "", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;", "viewModel", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountClickListener;", "provideGuestCountClickListener$short_term_rent_release", "(Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;)Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountClickListener;", "provideGuestCountClickListener", "Ldagger/Lazy;", "clickListener", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountItemPresenter;", "provideGuestCountItemPresenter", "(Ldagger/Lazy;)Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountItemPresenter;", "presenter", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountsProvider;", GeoContract.PROVIDER, "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountBluePrint;", "provideGuestsCountBluePrint$short_term_rent_release", "(Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountItemPresenter;Ldagger/Lazy;)Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountBluePrint;", "provideGuestsCountBluePrint", "provideGuestsCountsProvider$short_term_rent_release", "(Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;)Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountsProvider;", "provideGuestsCountsProvider", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter$short_term_rent_release", "(Landroidx/recyclerview/widget/ListUpdateCallback;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "provideListUpdateCallback$short_term_rent_release", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateCallback", "Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingContentsComparator;", "contentsComparator", "provideDiffCalculator$short_term_rent_release", "(Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingContentsComparator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "provideContentsComparator$short_term_rent_release", "()Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingContentsComparator;", "provideContentsComparator", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "provideRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideAdapterPresenter$short_term_rent_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemClickListenter;", "provideSelectItemClickConsumer$short_term_rent_release", "(Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;)Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemClickListenter;", "provideSelectItemClickConsumer", "Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemClearListenter;", "provideSelectItemClearConsumer$short_term_rent_release", "(Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;)Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemClearListenter;", "provideSelectItemClearConsumer", "clickConsumer", "clearConsumer", "Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemPresenter;", "provideSelectItemPresenter$short_term_rent_release", "(Ldagger/Lazy;Ldagger/Lazy;)Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemPresenter;", "provideSelectItemPresenter", "Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemBlueprint;", "provideSelectItemBlueprint$short_term_rent_release", "(Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemPresenter;)Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemBlueprint;", "provideSelectItemBlueprint", "Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemPresenter;", "provideSummaryItemPresenter$short_term_rent_release", "()Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemPresenter;", "provideSummaryItemPresenter", "Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemBlueprint;", "provideSummaryItemBlueprint$short_term_rent_release", "(Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemPresenter;)Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemBlueprint;", "provideSummaryItemBlueprint", "Lcom/avito/android/short_term_rent/start_booking/items/summary/loading/SummaryLoadingItemPresenter;", "provideSummaryLoadingItemPresenter$short_term_rent_release", "()Lcom/avito/android/short_term_rent/start_booking/items/summary/loading/SummaryLoadingItemPresenter;", "provideSummaryLoadingItemPresenter", "Lcom/avito/android/short_term_rent/start_booking/items/summary/loading/SummaryLoadingItemBlueprint;", "provideSummaryLoadingItemBlueprint$short_term_rent_release", "(Lcom/avito/android/short_term_rent/start_booking/items/summary/loading/SummaryLoadingItemPresenter;)Lcom/avito/android/short_term_rent/start_booking/items/summary/loading/SummaryLoadingItemBlueprint;", "provideSummaryLoadingItemBlueprint", "Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemPresenter;", "provideDisclaimerItemPresenter$short_term_rent_release", "()Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemPresenter;", "provideDisclaimerItemPresenter", "Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemBlueprint;", "provideDisclaimerItemBlueprint$short_term_rent_release", "(Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemPresenter;)Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemBlueprint;", "provideDisclaimerItemBlueprint", "selectItemBlueprint", "guestsCountBluePrint", "summaryBluePrint", "summaryLoadingBluePrint", "disclaimerItemBlueprint", "provideItemBinder$short_term_rent_release", "(Lcom/avito/android/short_term_rent/start_booking/items/enter_departure/SelectItemBlueprint;Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountBluePrint;Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemBlueprint;Lcom/avito/android/short_term_rent/start_booking/items/summary/loading/SummaryLoadingItemBlueprint;Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModelFactory;", "viewModelFactory", "provideStrStartBookingViewModel$short_term_rent_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModelFactory;)Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;", "provideStrStartBookingViewModel", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingInteractorImpl;", "interactor", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "", BookingInfoActivity.EXTRA_ITEM_ID, "source", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;", "analyticsTracker", "Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingResourceProvider;", "resourceProvider", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Ljava/util/Date;", "checkInDate", "checkOutDate", "", "showCalendar", "provideStrStartBookingViewModelFactory$short_term_rent_release", "(Lcom/avito/android/short_term_rent/start_booking/StrStartBookingInteractorImpl;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingResourceProvider;Lcom/avito/android/util/text/AttributedTextFormatter;Ljava/util/Date;Ljava/util/Date;Z)Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModelFactory;", "provideStrStartBookingViewModelFactory", "<init>", "()V", "Dependencies", "Source", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class, AttributedTextFormatterModule.class, StrAnalyticsTrackerModule.class})
public final class StrStartBookingModule {
    @NotNull
    public static final StrStartBookingModule INSTANCE = new StrStartBookingModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/short_term_rent/di/module/StrStartBookingModule$Dependencies;", "", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingInteractorImpl;", "interactor", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingInteractor;", "bindsStrStartBookingInteractor", "(Lcom/avito/android/short_term_rent/start_booking/StrStartBookingInteractorImpl;)Lcom/avito/android/short_term_rent/start_booking/StrStartBookingInteractor;", "Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingResourceProvider;", "bindsStrStartBookingResourceProvider", "(Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingResourceProviderImpl;)Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingResourceProvider;", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        StrStartBookingInteractor bindsStrStartBookingInteractor(@NotNull StrStartBookingInteractorImpl strStartBookingInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        StrStartBookingResourceProvider bindsStrStartBookingResourceProvider(@NotNull StrStartBookingResourceProviderImpl strStartBookingResourceProviderImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/short_term_rent/di/module/StrStartBookingModule$Source;", "", "<init>", "()V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface Source {
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$short_term_rent_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final StrStartBookingContentsComparator provideContentsComparator$short_term_rent_release() {
        return new StrStartBookingContentsComparator();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DataAwareAdapterPresenter provideDataAwareAdapterPresenter$short_term_rent_release(@NotNull ListUpdateCallback listUpdateCallback, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(listUpdateCallback, "updateCallback");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        Factory create = InstanceFactory.create(listUpdateCallback);
        Objects.requireNonNull(create, "null cannot be cast to non-null type dagger.internal.InstanceFactory<androidx.recyclerview.widget.ListUpdateCallback>");
        return new DataAwareAdapterPresenterImpl((InstanceFactory) create, adapterPresenter, diffCalculator);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DiffCalculator provideDiffCalculator$short_term_rent_release(@NotNull StrStartBookingContentsComparator strStartBookingContentsComparator) {
        Intrinsics.checkNotNullParameter(strStartBookingContentsComparator, "contentsComparator");
        return new SimpleDiffCalculator(strStartBookingContentsComparator, new SimpleEqualityComparator(), true, null, 8, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DisclaimerItemBlueprint provideDisclaimerItemBlueprint$short_term_rent_release(@NotNull DisclaimerItemPresenter disclaimerItemPresenter) {
        Intrinsics.checkNotNullParameter(disclaimerItemPresenter, "presenter");
        return new DisclaimerItemBlueprint(disclaimerItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DisclaimerItemPresenter provideDisclaimerItemPresenter$short_term_rent_release() {
        return new DisclaimerItemPresenter();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final GuestsCountClickListener provideGuestCountClickListener$short_term_rent_release(@NotNull StrStartBookingViewModel strStartBookingViewModel) {
        Intrinsics.checkNotNullParameter(strStartBookingViewModel, "viewModel");
        return strStartBookingViewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final GuestsCountItemPresenter provideGuestCountItemPresenter(@NotNull Lazy<GuestsCountClickListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "clickListener");
        return new GuestsCountItemPresenterImpl(lazy);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final GuestsCountBluePrint provideGuestsCountBluePrint$short_term_rent_release(@NotNull GuestsCountItemPresenter guestsCountItemPresenter, @NotNull Lazy<GuestsCountsProvider> lazy) {
        Intrinsics.checkNotNullParameter(guestsCountItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(lazy, GeoContract.PROVIDER);
        return new GuestsCountBluePrint(guestsCountItemPresenter, lazy);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final GuestsCountsProvider provideGuestsCountsProvider$short_term_rent_release(@NotNull StrStartBookingViewModel strStartBookingViewModel) {
        Intrinsics.checkNotNullParameter(strStartBookingViewModel, "viewModel");
        return strStartBookingViewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$short_term_rent_release(@NotNull SelectItemBlueprint selectItemBlueprint, @NotNull GuestsCountBluePrint guestsCountBluePrint, @NotNull SummaryItemBlueprint summaryItemBlueprint, @NotNull SummaryLoadingItemBlueprint summaryLoadingItemBlueprint, @NotNull DisclaimerItemBlueprint disclaimerItemBlueprint) {
        Intrinsics.checkNotNullParameter(selectItemBlueprint, "selectItemBlueprint");
        Intrinsics.checkNotNullParameter(guestsCountBluePrint, "guestsCountBluePrint");
        Intrinsics.checkNotNullParameter(summaryItemBlueprint, "summaryBluePrint");
        Intrinsics.checkNotNullParameter(summaryLoadingItemBlueprint, "summaryLoadingBluePrint");
        Intrinsics.checkNotNullParameter(disclaimerItemBlueprint, "disclaimerItemBlueprint");
        return new ItemBinder.Builder().registerItem(selectItemBlueprint).registerItem(guestsCountBluePrint).registerItem(summaryItemBlueprint).registerItem(summaryLoadingItemBlueprint).registerItem(disclaimerItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ListUpdateCallback provideListUpdateCallback$short_term_rent_release(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        return simpleRecyclerAdapter;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SelectItemBlueprint provideSelectItemBlueprint$short_term_rent_release(@NotNull SelectItemPresenter selectItemPresenter) {
        Intrinsics.checkNotNullParameter(selectItemPresenter, "presenter");
        return new SelectItemBlueprint(selectItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SelectItemClearListenter provideSelectItemClearConsumer$short_term_rent_release(@NotNull StrStartBookingViewModel strStartBookingViewModel) {
        Intrinsics.checkNotNullParameter(strStartBookingViewModel, "viewModel");
        return strStartBookingViewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SelectItemClickListenter provideSelectItemClickConsumer$short_term_rent_release(@NotNull StrStartBookingViewModel strStartBookingViewModel) {
        Intrinsics.checkNotNullParameter(strStartBookingViewModel, "viewModel");
        return strStartBookingViewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SelectItemPresenter provideSelectItemPresenter$short_term_rent_release(@NotNull Lazy<SelectItemClickListenter> lazy, @NotNull Lazy<SelectItemClearListenter> lazy2) {
        Intrinsics.checkNotNullParameter(lazy, "clickConsumer");
        Intrinsics.checkNotNullParameter(lazy2, "clearConsumer");
        return new SelectItemPresenter(lazy, lazy2);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final StrStartBookingViewModel provideStrStartBookingViewModel$short_term_rent_release(@NotNull Fragment fragment, @NotNull StrStartBookingViewModelFactory strStartBookingViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(strStartBookingViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, strStartBookingViewModelFactory).get(StrStartBookingViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (StrStartBookingViewModel) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final StrStartBookingViewModelFactory provideStrStartBookingViewModelFactory$short_term_rent_release(@NotNull StrStartBookingInteractorImpl strStartBookingInteractorImpl, @NotNull SchedulersFactory schedulersFactory, @AdvertId @NotNull String str, @Source @NotNull String str2, @NotNull AccountStateProvider accountStateProvider, @NotNull StrAnalyticsTracker strAnalyticsTracker, @NotNull StrStartBookingResourceProvider strStartBookingResourceProvider, @NotNull AttributedTextFormatter attributedTextFormatter, @CheckInDate @Nullable Date date, @CheckOutDate @Nullable Date date2, @ShowCalendar boolean z) {
        Intrinsics.checkNotNullParameter(strStartBookingInteractorImpl, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "source");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(strAnalyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(strStartBookingResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        return new StrStartBookingViewModelFactory(strStartBookingInteractorImpl, schedulersFactory, str, str2, accountStateProvider, strAnalyticsTracker, strStartBookingResourceProvider, attributedTextFormatter, date, date2, z);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SummaryItemBlueprint provideSummaryItemBlueprint$short_term_rent_release(@NotNull SummaryItemPresenter summaryItemPresenter) {
        Intrinsics.checkNotNullParameter(summaryItemPresenter, "presenter");
        return new SummaryItemBlueprint(summaryItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SummaryItemPresenter provideSummaryItemPresenter$short_term_rent_release() {
        return new SummaryItemPresenter();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SummaryLoadingItemBlueprint provideSummaryLoadingItemBlueprint$short_term_rent_release(@NotNull SummaryLoadingItemPresenter summaryLoadingItemPresenter) {
        Intrinsics.checkNotNullParameter(summaryLoadingItemPresenter, "presenter");
        return new SummaryLoadingItemBlueprint(summaryLoadingItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SummaryLoadingItemPresenter provideSummaryLoadingItemPresenter$short_term_rent_release() {
        return new SummaryLoadingItemPresenter();
    }
}
