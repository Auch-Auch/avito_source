package com.avito.android.publish.category_suggest.di;

import a2.b.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsInteractor;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsInteractorImpl;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsViewModelFactory;
import com.avito.android.publish.select.blueprints.CheckableItemBlueprint;
import com.avito.android.publish.select.blueprints.CheckableItemBlueprintImpl;
import com.avito.android.publish.select.blueprints.CheckableItemPresenter;
import com.avito.android.publish.select.blueprints.CheckableItemPresenterImpl;
import com.avito.android.publish.wizard.blueprint.WizardItemBlueprint;
import com.avito.android.publish.wizard.blueprint.WizardItemBlueprintImpl;
import com.avito.android.publish.wizard.blueprint.WizardItemPresenter;
import com.avito.android.publish.wizard.blueprint.WizardItemPresenterImpl;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Module;
import dagger.Provides;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010;J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001d\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u001eH\u0007¢\u0006\u0004\b#\u0010$J\u001f\u0010*\u001a\u00020'2\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\"H\u0001¢\u0006\u0004\b(\u0010)J\u0017\u0010/\u001a\u00020,2\u0006\u0010+\u001a\u00020'H\u0001¢\u0006\u0004\b-\u0010.J#\u00103\u001a\u0006\u0012\u0002\b\u0003022\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020'H\u0007¢\u0006\u0004\b3\u00104J*\u00108\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u000306¢\u0006\u0002\b7052\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/avito/android/publish/category_suggest/di/CategoriesSuggestionsModule;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsInteractor;", "interactor", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModelFactory;", "providerViewModuleFactory", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsInteractor;Lcom/avito/android/publish/analytics/PublishEventTracker;)Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModelFactory;", "Lcom/avito/android/remote/PublishApi;", "api", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "categoryParametersConverter", "Lcom/avito/android/Features;", "features", "providerInteractor", "(Lcom/avito/android/remote/PublishApi;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/Features;)Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsInteractor;", "Lcom/avito/android/publish/wizard/blueprint/WizardItemPresenter;", "wizardItemPresenter", "Lcom/avito/android/publish/wizard/blueprint/WizardItemBlueprint;", "provideCategoryItemBluePrint$publish_release", "(Lcom/avito/android/publish/wizard/blueprint/WizardItemPresenter;)Lcom/avito/android/publish/wizard/blueprint/WizardItemBlueprint;", "provideCategoryItemBluePrint", "provideWizardItemPresenter$publish_release", "()Lcom/avito/android/publish/wizard/blueprint/WizardItemPresenter;", "provideWizardItemPresenter", "Lcom/avito/android/publish/select/blueprints/CheckableItemPresenter;", "provideCheckableItemPresenter", "()Lcom/avito/android/publish/select/blueprints/CheckableItemPresenter;", "presenter", "Lcom/avito/android/publish/select/blueprints/CheckableItemBlueprint;", "provideCheckableItemBlueprint", "(Lcom/avito/android/publish/select/blueprints/CheckableItemPresenter;)Lcom/avito/android/publish/select/blueprints/CheckableItemBlueprint;", "categoryItemBlueprint", "checkableItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$publish_release", "(Lcom/avito/android/publish/wizard/blueprint/WizardItemBlueprint;Lcom/avito/android/publish/select/blueprints/CheckableItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", GeoContract.PROVIDER, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$publish_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "adapterPresenter", "itemBinder", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "provideItemPresentersSet", "(Lcom/avito/android/publish/wizard/blueprint/WizardItemPresenter;)Ljava/util/Set;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class CategoriesSuggestionsModule {
    @Provides
    @NotNull
    @PerFragment
    public final RecyclerView.Adapter<?> provideAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$publish_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, GeoContract.PROVIDER, itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final WizardItemBlueprint provideCategoryItemBluePrint$publish_release(@NotNull WizardItemPresenter wizardItemPresenter) {
        Intrinsics.checkNotNullParameter(wizardItemPresenter, "wizardItemPresenter");
        return new WizardItemBlueprintImpl(wizardItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final CheckableItemBlueprint provideCheckableItemBlueprint(@NotNull CheckableItemPresenter checkableItemPresenter) {
        Intrinsics.checkNotNullParameter(checkableItemPresenter, "presenter");
        return new CheckableItemBlueprintImpl(checkableItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final CheckableItemPresenter provideCheckableItemPresenter() {
        return new CheckableItemPresenterImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideItemBinder$publish_release(@NotNull WizardItemBlueprint wizardItemBlueprint, @NotNull CheckableItemBlueprint checkableItemBlueprint) {
        Intrinsics.checkNotNullParameter(wizardItemBlueprint, "categoryItemBlueprint");
        Intrinsics.checkNotNullParameter(checkableItemBlueprint, "checkableItemBlueprint");
        return new ItemBinder.Builder().registerItem(checkableItemBlueprint).registerItem(wizardItemBlueprint).build();
    }

    @Provides
    @NotNull
    @PerFragment
    public final Set<ItemPresenter<?, ?>> provideItemPresentersSet(@NotNull WizardItemPresenter wizardItemPresenter) {
        Intrinsics.checkNotNullParameter(wizardItemPresenter, "wizardItemPresenter");
        return x.setOf(wizardItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final WizardItemPresenter provideWizardItemPresenter$publish_release() {
        return new WizardItemPresenterImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final CategoriesSuggestionsInteractor providerInteractor(@NotNull PublishApi publishApi, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(publishApi, "api");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "categoryParametersConverter");
        Intrinsics.checkNotNullParameter(features, "features");
        return new CategoriesSuggestionsInteractorImpl(publishApi, publishAnalyticsDataProvider, categoryParametersConverter, features);
    }

    @Provides
    @PerFragment
    @NotNull
    public final CategoriesSuggestionsViewModelFactory providerViewModuleFactory(@NotNull SchedulersFactory schedulersFactory, @NotNull CategoriesSuggestionsInteractor categoriesSuggestionsInteractor, @NotNull PublishEventTracker publishEventTracker) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(categoriesSuggestionsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(publishEventTracker, "publishEventTracker");
        return new CategoriesSuggestionsViewModelFactory(categoriesSuggestionsInteractor, schedulersFactory, publishEventTracker);
    }
}
