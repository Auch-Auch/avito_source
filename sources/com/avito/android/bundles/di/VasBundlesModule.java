package com.avito.android.bundles.di;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.bundles.VasBundlesConverter;
import com.avito.android.bundles.VasBundlesConverterImpl;
import com.avito.android.bundles.repository.VasBundlesRepository;
import com.avito.android.bundles.repository.VasBundlesRepositoryImpl;
import com.avito.android.bundles.ui.recycler.VasBundleContentComparator;
import com.avito.android.bundles.ui.recycler.item.benefit.BundleBenefitItemBlueprint;
import com.avito.android.bundles.viewmodel.VasBundlesViewModel;
import com.avito.android.di.PerFragment;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.recycler.data_aware.SimpleEqualityComparator;
import com.avito.android.recycler.di.DetectMoves;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"H\u0001¢\u0006\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/avito/android/bundles/di/VasBundlesModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/avito/android/bundles/viewmodel/VasBundlesViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/bundles/viewmodel/VasBundlesViewModel;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideSimpleRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter$vas_bundles_release", "(Landroidx/recyclerview/widget/ListUpdateCallback;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "contentsComparator", "provideDiffCalculator", "(Lcom/avito/android/recycler/data_aware/ContentsComparator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "", "provideDetectMoves", "()Z", "provideBundleBenefitAdapterPresenter$vas_bundles_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideBundleBenefitAdapterPresenter", "Lcom/avito/android/bundles/ui/recycler/item/benefit/BundleBenefitItemBlueprint;", "benefitBlueprint", "provideBundleBenefitItemBinder$vas_bundles_release", "(Lcom/avito/android/bundles/ui/recycler/item/benefit/BundleBenefitItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideBundleBenefitItemBinder", "<init>", "()V", "Declarations", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AttributedTextFormatterModule.class})
public final class VasBundlesModule {
    @NotNull
    public static final VasBundlesModule INSTANCE = new VasBundlesModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/bundles/di/VasBundlesModule$Declarations;", "", "Lcom/avito/android/bundles/di/VasBundlesViewModelFactory;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideBundlesViewModelFactory", "(Lcom/avito/android/bundles/di/VasBundlesViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/bundles/VasBundlesConverterImpl;", "converter", "Lcom/avito/android/bundles/VasBundlesConverter;", "provideVasBundlesConverter", "(Lcom/avito/android/bundles/VasBundlesConverterImpl;)Lcom/avito/android/bundles/VasBundlesConverter;", "Lcom/avito/android/bundles/repository/VasBundlesRepositoryImpl;", "bundlesRepositoryImpl", "Lcom/avito/android/bundles/repository/VasBundlesRepository;", "provideBundlesRepository", "(Lcom/avito/android/bundles/repository/VasBundlesRepositoryImpl;)Lcom/avito/android/bundles/repository/VasBundlesRepository;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/ListUpdateCallback;", "bindListUpdateCallback", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "Lcom/avito/android/bundles/ui/recycler/VasBundleContentComparator;", "contentsComparator", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "bindContentsComparator", "(Lcom/avito/android/bundles/ui/recycler/VasBundleContentComparator;)Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "bindRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        ContentsComparator bindContentsComparator(@NotNull VasBundleContentComparator vasBundleContentComparator);

        @PerFragment
        @Binds
        @NotNull
        ListUpdateCallback bindListUpdateCallback(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter);

        @Binds
        @NotNull
        @PerFragment
        RecyclerView.Adapter<BaseViewHolder> bindRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter);

        @PerFragment
        @Binds
        @NotNull
        VasBundlesRepository provideBundlesRepository(@NotNull VasBundlesRepositoryImpl vasBundlesRepositoryImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideBundlesViewModelFactory(@NotNull VasBundlesViewModelFactory vasBundlesViewModelFactory);

        @PerFragment
        @Binds
        @NotNull
        VasBundlesConverter provideVasBundlesConverter(@NotNull VasBundlesConverterImpl vasBundlesConverterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DataAwareAdapterPresenter provideDataAwareAdapterPresenter$vas_bundles_release(@NotNull ListUpdateCallback listUpdateCallback, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(listUpdateCallback, "updateCallback");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        Factory create = InstanceFactory.create(listUpdateCallback);
        Objects.requireNonNull(create, "null cannot be cast to non-null type dagger.internal.InstanceFactory<androidx.recyclerview.widget.ListUpdateCallback>");
        return new DataAwareAdapterPresenterImpl((InstanceFactory) create, adapterPresenter, diffCalculator);
    }

    @Provides
    @JvmStatic
    @PerFragment
    @DetectMoves
    public static final boolean provideDetectMoves() {
        return false;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DiffCalculator provideDiffCalculator(@NotNull ContentsComparator contentsComparator) {
        Intrinsics.checkNotNullParameter(contentsComparator, "contentsComparator");
        return new SimpleDiffCalculator(contentsComparator, new SimpleEqualityComparator(), true, null, 8, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter provideSimpleRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final VasBundlesViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "factory");
        ViewModel viewModel = new ViewModelProvider(fragment, factory).get(VasBundlesViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…lesViewModel::class.java)");
        return (VasBundlesViewModel) viewModel;
    }

    @Provides
    @BundleBenefitAdapterPresenter
    @NotNull
    @PerFragment
    public final AdapterPresenter provideBundleBenefitAdapterPresenter$vas_bundles_release(@BundleBenefitItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @BundleBenefitItemBinder
    @Provides
    @NotNull
    @PerFragment
    public final ItemBinder provideBundleBenefitItemBinder$vas_bundles_release(@NotNull BundleBenefitItemBlueprint bundleBenefitItemBlueprint) {
        Intrinsics.checkNotNullParameter(bundleBenefitItemBlueprint, "benefitBlueprint");
        return new ItemBinder.Builder().registerItem(bundleBenefitItemBlueprint).build();
    }
}
