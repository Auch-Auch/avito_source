package com.avito.android.user_advert.soa_with_price.di;

import a2.b.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.di.PerFragment;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceArguments;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceResourceProvider;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceResourceProviderImpl;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceViewModelFactory;
import com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemBlueprint;
import com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemBlueprintImpl;
import com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemPresenter;
import com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemPresenterImpl;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/di/CloseReasonSheetDialogModule;", "", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$user_advert_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemBlueprint;", "closeReasonItemBlueprint", "provideItemBinder$user_advert_release", "(Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "adapterPresenter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "provideRecyclerAdapter$user_advert_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideRecyclerAdapter", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceArguments;", "arguments", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceResourceProvider;", "resourceProvider", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceViewModelFactory;", "provideViewModelFactory$user_advert_release", "(Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceArguments;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceResourceProvider;)Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceViewModelFactory;", "provideViewModelFactory", "<init>", "()V", "Declarations", "user-advert_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AttributedTextFormatterModule.class})
public final class CloseReasonSheetDialogModule {
    @NotNull
    public static final CloseReasonSheetDialogModule INSTANCE = new CloseReasonSheetDialogModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/di/CloseReasonSheetDialogModule$Declarations;", "", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceResourceProvider;", "bindSoaWithPriceResourceProvider", "(Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceResourceProviderImpl;)Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceResourceProvider;", "Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemPresenterImpl;", "presenter", "Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemPresenter;", "bindCloseReasonItemPresenter", "(Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemPresenterImpl;)Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemPresenter;", "Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemBlueprintImpl;", "blueprint", "Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemBlueprint;", "bindCloseReasonItemBlueprint", "(Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemBlueprintImpl;)Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemBlueprint;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        CloseReasonItemBlueprint bindCloseReasonItemBlueprint(@NotNull CloseReasonItemBlueprintImpl closeReasonItemBlueprintImpl);

        @PerFragment
        @Binds
        @NotNull
        CloseReasonItemPresenter bindCloseReasonItemPresenter(@NotNull CloseReasonItemPresenterImpl closeReasonItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SoaWithPriceResourceProvider bindSoaWithPriceResourceProvider(@NotNull SoaWithPriceResourceProviderImpl soaWithPriceResourceProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$user_advert_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$user_advert_release(@NotNull CloseReasonItemBlueprint closeReasonItemBlueprint) {
        Intrinsics.checkNotNullParameter(closeReasonItemBlueprint, "closeReasonItemBlueprint");
        return new ItemBinder.Builder().registerItem(closeReasonItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final RecyclerView.Adapter<BaseViewHolder> provideRecyclerAdapter$user_advert_release(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SoaWithPriceViewModelFactory provideViewModelFactory$user_advert_release(@NotNull SoaWithPriceArguments soaWithPriceArguments, @NotNull SchedulersFactory schedulersFactory, @NotNull SoaWithPriceResourceProvider soaWithPriceResourceProvider) {
        Intrinsics.checkNotNullParameter(soaWithPriceArguments, "arguments");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(soaWithPriceResourceProvider, "resourceProvider");
        return new SoaWithPriceViewModelFactory(soaWithPriceArguments.getReasons(), schedulersFactory, soaWithPriceResourceProvider);
    }
}
