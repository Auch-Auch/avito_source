package com.avito.android.tariff.fees_methods.di;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.di.PerFragment;
import com.avito.android.publish_limits_info.item.LimitsInfoItemBlueprint;
import com.avito.android.publish_limits_info.item.LimitsInfoItemPresenter;
import com.avito.android.publish_limits_info.item.LimitsInfoItemPresenterImpl;
import com.avito.android.tariff.edit_info.di.MicroCategoryAdapterPresenter;
import com.avito.android.tariff.edit_info.di.MicroCategoryItemBinder;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemBlueprint;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemPresenter;
import com.avito.android.tariff.edit_info.item.edit_package.micro_category.MicroCategoryItemPresenterImpl;
import com.avito.android.tariff.fees_methods.items.FeeMethodBlueprint;
import com.avito.android.tariff.fees_methods.items.FeeMethodPresenter;
import com.avito.android.tariff.fees_methods.items.bar.BarItemBlueprint;
import com.avito.android.tariff.fees_methods.items.bar.BarItemPresenter;
import com.avito.android.tariff.fees_methods.items.description.FeeDescriptionItemBlueprint;
import com.avito.android.tariff.fees_methods.items.description.FeeDescriptionItemPresenter;
import com.avito.android.tariff.fees_methods.items.high_demand.HighDemandBlueprint;
import com.avito.android.tariff.fees_methods.items.high_demand.HighDemandPresenter;
import com.avito.android.tariff.fees_methods.items.high_demand.HighDemandPresenterImpl;
import com.avito.android.tariff.fees_methods.items.tariff_package.FeeMethodPackageBlueprint;
import com.avito.android.tariff.fees_methods.items.tariff_package.FeeMethodPackagePresenter;
import com.avito.android.tariff.fees_methods.items.tariff_package.FeeMethodPackagePresenterImpl;
import com.avito.android.tariff.fees_methods.items.title.FeeTitleItemBlueprint;
import com.avito.android.tariff.fees_methods.items.title.FeeTitleItemPresenter;
import com.avito.android.tariff.fees_methods.limits_info.LimitsInfoItemLayoutProvider;
import com.avito.android.tariff.fees_methods.limits_info.PaidPublishLimitsInfoRepository;
import com.avito.android.tariff.fees_methods.limits_info.PaidPublishLimitsInfoRepositoryImpl;
import com.avito.android.tariff.fees_methods.recycler.FeeMethodsViewTypeProvider;
import com.avito.android.tariff.fees_methods.recycler.FeeMethodsViewTypeProviderImpl;
import com.avito.android.tariff.fees_methods.recycler.PaddingDecoration;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsConverter;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsConverterImpl;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsRepository;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsRepositoryImpl;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModel;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModelFactory;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModelImpl;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewTypeProvider;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0017\u001a\u00020\t2\u0019\u0010\u0014\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012¢\u0006\u0002\b\u00130\u0011H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u001a\u001a\u00020\r2\b\b\u0001\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/avito/android/tariff/fees_methods/di/FeeMethodsModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsViewModel;", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/blueprint/ViewTypeProvider;", "viewTypeProvider", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$tariff_release", "(Lcom/avito/konveyor/ItemBinder;Lcom/avito/konveyor/blueprint/ViewTypeProvider;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "provideItemBinder$tariff_release", "(Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "provideMicroCategoryAdapterPresenter$tariff_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideMicroCategoryAdapterPresenter", "Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemBlueprint;", "microCategoryItemBlueprint", "provideMicroCategoryItemBinder$tariff_release", "(Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideMicroCategoryItemBinder", "<init>", "()V", "Declarations", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class FeeMethodsModule {
    @NotNull
    public static final FeeMethodsModule INSTANCE = new FeeMethodsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00172\u0006\u0010\u0016\u001a\u00020\u0015H'¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00172\u0006\u0010\u0016\u001a\u00020\u001fH'¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u00020\"H'¢\u0006\u0004\b#\u0010$J\u0017\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%H'¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00172\u0006\u0010\u0016\u001a\u00020'H'¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u00020,H'¢\u0006\u0004\b-\u0010.J\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/H'¢\u0006\u0004\b2\u00103J\u001f\u00105\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00172\u0006\u0010\u0016\u001a\u000204H'¢\u0006\u0004\b5\u00106J\u001f\u00108\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u000207H'¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020;2\u0006\u0010&\u001a\u00020:H'¢\u0006\u0004\b<\u0010=J\u001f\u0010>\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00172\u0006\u0010\u0016\u001a\u00020;H'¢\u0006\u0004\b>\u0010?J\u001f\u0010A\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u00020@H'¢\u0006\u0004\bA\u0010BJ\u001f\u0010D\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00172\u0006\u0010\u0016\u001a\u00020CH'¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020C2\u0006\u0010&\u001a\u00020FH'¢\u0006\u0004\bG\u0010HJ\u001f\u0010J\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u00020IH'¢\u0006\u0004\bJ\u0010KJ\u0017\u0010N\u001a\u00020M2\u0006\u0010&\u001a\u00020LH'¢\u0006\u0004\bN\u0010OJ\u001f\u0010Q\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00172\u0006\u0010\u0016\u001a\u00020PH'¢\u0006\u0004\bQ\u0010RJ\u001f\u0010T\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u00020SH'¢\u0006\u0004\bT\u0010UJ\u0017\u0010Y\u001a\u00020X2\u0006\u0010W\u001a\u00020VH'¢\u0006\u0004\bY\u0010ZJ\u0017\u0010\\\u001a\u00020[2\u0006\u0010W\u001a\u00020XH'¢\u0006\u0004\b\\\u0010]J\u0017\u0010a\u001a\u00020`2\u0006\u0010_\u001a\u00020^H'¢\u0006\u0004\ba\u0010b¨\u0006c"}, d2 = {"Lcom/avito/android/tariff/fees_methods/di/FeeMethodsModule$Declarations;", "", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsRepositoryImpl;", "tariffRepository", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsRepository;", "provideRepository", "(Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsRepositoryImpl;)Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsRepository;", "Lcom/avito/android/tariff/fees_methods/limits_info/PaidPublishLimitsInfoRepositoryImpl;", "Lcom/avito/android/tariff/fees_methods/limits_info/PaidPublishLimitsInfoRepository;", "provideLimitsRepository", "(Lcom/avito/android/tariff/fees_methods/limits_info/PaidPublishLimitsInfoRepositoryImpl;)Lcom/avito/android/tariff/fees_methods/limits_info/PaidPublishLimitsInfoRepository;", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsConverterImpl;", "converter", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsConverter;", "provideConverter", "(Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsConverterImpl;)Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsConverter;", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/tariff/fees_methods/items/title/FeeTitleItemPresenter;", "itemPresenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideTitleItemPresenter", "(Lcom/avito/android/tariff/fees_methods/items/title/FeeTitleItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/fees_methods/items/title/FeeTitleItemBlueprint;", "itemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideTitleItemBlueprint", "(Lcom/avito/android/tariff/fees_methods/items/title/FeeTitleItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/fees_methods/items/description/FeeDescriptionItemPresenter;", "provideDescriptionItemPresenter", "(Lcom/avito/android/tariff/fees_methods/items/description/FeeDescriptionItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/fees_methods/items/description/FeeDescriptionItemBlueprint;", "provideDescriptionItemBlueprint", "(Lcom/avito/android/tariff/fees_methods/items/description/FeeDescriptionItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenterImpl;", "presenter", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenter;", "bindsLimitsInfoItemPresenter", "(Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenterImpl;)Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenter;", "provideLimitsItemPresenter", "(Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemBlueprint;", "provideLimitsItemBlueprint", "(Lcom/avito/android/publish_limits_info/item/LimitsInfoItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/fees_methods/limits_info/LimitsInfoItemLayoutProvider;", GeoContract.PROVIDER, "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemBlueprint$LayoutProvider;", "bindLimitsItemLayoutProvider", "(Lcom/avito/android/tariff/fees_methods/limits_info/LimitsInfoItemLayoutProvider;)Lcom/avito/android/publish_limits_info/item/LimitsInfoItemBlueprint$LayoutProvider;", "Lcom/avito/android/tariff/fees_methods/items/FeeMethodPresenter;", "provideFeeMethodPresenter", "(Lcom/avito/android/tariff/fees_methods/items/FeeMethodPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/fees_methods/items/FeeMethodBlueprint;", "provideFeeMethodBlueprint", "(Lcom/avito/android/tariff/fees_methods/items/FeeMethodBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandPresenterImpl;", "Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandPresenter;", "bindHighDemandPresenter", "(Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandPresenterImpl;)Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandPresenter;", "provideHighDemandPresenter", "(Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandBlueprint;", "provideHighDemandBlueprint", "(Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackagePresenter;", "provideFeeMethodPackagePresenter", "(Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackagePresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackagePresenterImpl;", "provideFeeMethodPackagePresenterImpl", "(Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackagePresenterImpl;)Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackagePresenter;", "Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackageBlueprint;", "provideFeeMethodPackageItemBlueprint", "(Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackageBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemPresenterImpl;", "Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemPresenter;", "bindMicroCategoryPresenterImpl", "(Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemPresenterImpl;)Lcom/avito/android/tariff/edit_info/item/edit_package/micro_category/MicroCategoryItemPresenter;", "Lcom/avito/android/tariff/fees_methods/items/bar/BarItemPresenter;", "provideBarItemPresenter", "(Lcom/avito/android/tariff/fees_methods/items/bar/BarItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/fees_methods/items/bar/BarItemBlueprint;", "provideBarItemBlueprint", "(Lcom/avito/android/tariff/fees_methods/items/bar/BarItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/fees_methods/recycler/FeeMethodsViewTypeProviderImpl;", "feeMethodsViewTypeProvider", "Lcom/avito/android/tariff/fees_methods/recycler/FeeMethodsViewTypeProvider;", "provideViewTypeProviderImpl", "(Lcom/avito/android/tariff/fees_methods/recycler/FeeMethodsViewTypeProviderImpl;)Lcom/avito/android/tariff/fees_methods/recycler/FeeMethodsViewTypeProvider;", "Lcom/avito/konveyor/blueprint/ViewTypeProvider;", "provideViewTypeProvider", "(Lcom/avito/android/tariff/fees_methods/recycler/FeeMethodsViewTypeProvider;)Lcom/avito/konveyor/blueprint/ViewTypeProvider;", "Lcom/avito/android/tariff/fees_methods/recycler/PaddingDecoration;", "paddingDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "provideItemDecoration", "(Lcom/avito/android/tariff/fees_methods/recycler/PaddingDecoration;)Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "tariff_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        HighDemandPresenter bindHighDemandPresenter(@NotNull HighDemandPresenterImpl highDemandPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        LimitsInfoItemBlueprint.LayoutProvider bindLimitsItemLayoutProvider(@NotNull LimitsInfoItemLayoutProvider limitsInfoItemLayoutProvider);

        @PerFragment
        @Binds
        @NotNull
        MicroCategoryItemPresenter bindMicroCategoryPresenterImpl(@NotNull MicroCategoryItemPresenterImpl microCategoryItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        LimitsInfoItemPresenter bindsLimitsInfoItemPresenter(@NotNull LimitsInfoItemPresenterImpl limitsInfoItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideBarItemBlueprint(@NotNull BarItemBlueprint barItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideBarItemPresenter(@NotNull BarItemPresenter barItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        FeeMethodsConverter provideConverter(@NotNull FeeMethodsConverterImpl feeMethodsConverterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideDescriptionItemBlueprint(@NotNull FeeDescriptionItemBlueprint feeDescriptionItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideDescriptionItemPresenter(@NotNull FeeDescriptionItemPresenter feeDescriptionItemPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideFeeMethodBlueprint(@NotNull FeeMethodBlueprint feeMethodBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideFeeMethodPackageItemBlueprint(@NotNull FeeMethodPackageBlueprint feeMethodPackageBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideFeeMethodPackagePresenter(@NotNull FeeMethodPackagePresenter feeMethodPackagePresenter);

        @PerFragment
        @Binds
        @NotNull
        FeeMethodPackagePresenter provideFeeMethodPackagePresenterImpl(@NotNull FeeMethodPackagePresenterImpl feeMethodPackagePresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideFeeMethodPresenter(@NotNull FeeMethodPresenter feeMethodPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideHighDemandBlueprint(@NotNull HighDemandBlueprint highDemandBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideHighDemandPresenter(@NotNull HighDemandPresenter highDemandPresenter);

        @PerFragment
        @Binds
        @NotNull
        RecyclerView.ItemDecoration provideItemDecoration(@NotNull PaddingDecoration paddingDecoration);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideLimitsItemBlueprint(@NotNull LimitsInfoItemBlueprint limitsInfoItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideLimitsItemPresenter(@NotNull LimitsInfoItemPresenter limitsInfoItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        PaidPublishLimitsInfoRepository provideLimitsRepository(@NotNull PaidPublishLimitsInfoRepositoryImpl paidPublishLimitsInfoRepositoryImpl);

        @PerFragment
        @Binds
        @NotNull
        FeeMethodsRepository provideRepository(@NotNull FeeMethodsRepositoryImpl feeMethodsRepositoryImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideTitleItemBlueprint(@NotNull FeeTitleItemBlueprint feeTitleItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideTitleItemPresenter(@NotNull FeeTitleItemPresenter feeTitleItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull FeeMethodsViewModelFactory feeMethodsViewModelFactory);

        @PerFragment
        @Binds
        @NotNull
        ViewTypeProvider provideViewTypeProvider(@NotNull FeeMethodsViewTypeProvider feeMethodsViewTypeProvider);

        @PerFragment
        @Binds
        @NotNull
        FeeMethodsViewTypeProvider provideViewTypeProviderImpl(@NotNull FeeMethodsViewTypeProviderImpl feeMethodsViewTypeProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$tariff_release(@NotNull ItemBinder itemBinder, @NotNull ViewTypeProvider viewTypeProvider) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(viewTypeProvider, "viewTypeProvider");
        return new SimpleAdapterPresenter(viewTypeProvider, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$tariff_release(@NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder = builder.registerItem(it.next());
        }
        return builder.build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final FeeMethodsViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, factory).get(FeeMethodsViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (FeeMethodsViewModel) viewModel;
    }

    @Provides
    @NotNull
    @PerFragment
    @MicroCategoryAdapterPresenter
    public final AdapterPresenter provideMicroCategoryAdapterPresenter$tariff_release(@MicroCategoryItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @NotNull
    @MicroCategoryItemBinder
    @PerFragment
    public final ItemBinder provideMicroCategoryItemBinder$tariff_release(@NotNull MicroCategoryItemBlueprint microCategoryItemBlueprint) {
        Intrinsics.checkNotNullParameter(microCategoryItemBlueprint, "microCategoryItemBlueprint");
        return new ItemBinder.Builder().registerItem(microCategoryItemBlueprint).build();
    }
}
