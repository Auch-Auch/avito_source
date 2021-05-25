package com.avito.android.safedeal.profile_settings.di;

import a2.b.a.a.a;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.di.PerFragment;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModel;
import com.avito.android.safedeal.profile_settings.konveyor.ProfileDeliverySettingsContentsComparator;
import com.avito.android.safedeal.profile_settings.konveyor.list_item.ListItemBlueprint;
import com.avito.android.safedeal.profile_settings.konveyor.list_item.ListItemPresenter;
import com.avito.android.safedeal.profile_settings.konveyor.list_item.ListItemPresenterImpl;
import com.avito.android.safedeal.profile_settings.konveyor.skeleton.SkeletonBlueprint;
import com.avito.android.safedeal.profile_settings.konveyor.skeleton.SkeletonPresenter;
import com.avito.android.safedeal.profile_settings.konveyor.skeleton.SkeletonPresenterImpl;
import com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemBlueprint;
import com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemPresenter;
import com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItemPresenterImpl;
import com.avito.android.safedeal.profile_settings.konveyor.text.TextItemBlueprint;
import com.avito.android.safedeal.profile_settings.konveyor.text.TextItemPresenter;
import com.avito.android.safedeal.profile_settings.konveyor.text.TextItemPresenterImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u00015B\t\b\u0002¢\u0006\u0004\b3\u00104J'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010(\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b&\u0010'J\u0017\u0010.\u001a\u00020+2\u0006\u0010*\u001a\u00020)H\u0001¢\u0006\u0004\b,\u0010-J\u0017\u00102\u001a\u00020/2\u0006\u0010*\u001a\u00020)H\u0001¢\u0006\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/di/ProfileDeliverySettingsBlueprintsModule;", "", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter$safedeal_release", "(Landroidx/recyclerview/widget/ListUpdateCallback;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsContentsComparator;", "contentsComparator", "provideDiffCalculator$safedeal_release", "(Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsContentsComparator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "provideListUpdateCallback$safedeal_release", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateCallback", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "provideRecyclerAdapter$safedeal_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "provideSimpleAdapterPresenter$safedeal_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideSimpleAdapterPresenter", "Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItemBlueprint;", "switcherItemBlueprint", "Lcom/avito/android/safedeal/profile_settings/konveyor/text/TextItemBlueprint;", "textItemBlueprint", "Lcom/avito/android/safedeal/profile_settings/konveyor/skeleton/SkeletonBlueprint;", "skeletonBlueprint", "Lcom/avito/android/safedeal/profile_settings/konveyor/list_item/ListItemBlueprint;", "listItemBlueprint", "provideItemBinder$safedeal_release", "(Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItemBlueprint;Lcom/avito/android/safedeal/profile_settings/konveyor/text/TextItemBlueprint;Lcom/avito/android/safedeal/profile_settings/konveyor/skeleton/SkeletonBlueprint;Lcom/avito/android/safedeal/profile_settings/konveyor/list_item/ListItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsViewModel;", "viewModel", "Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItemPresenter;", "provideSwitcherItemPresenter$safedeal_release", "(Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsViewModel;)Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItemPresenter;", "provideSwitcherItemPresenter", "Lcom/avito/android/safedeal/profile_settings/konveyor/list_item/ListItemPresenter;", "provideListItemPresenter$safedeal_release", "(Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsViewModel;)Lcom/avito/android/safedeal/profile_settings/konveyor/list_item/ListItemPresenter;", "provideListItemPresenter", "<init>", "()V", "Declarations", "safedeal_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class ProfileDeliverySettingsBlueprintsModule {
    @NotNull
    public static final ProfileDeliverySettingsBlueprintsModule INSTANCE = new ProfileDeliverySettingsBlueprintsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H!¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH!¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/di/ProfileDeliverySettingsBlueprintsModule$Declarations;", "", "Lcom/avito/android/safedeal/profile_settings/konveyor/text/TextItemPresenterImpl;", "presenter", "Lcom/avito/android/safedeal/profile_settings/konveyor/text/TextItemPresenter;", "bindTextItemPresenter$safedeal_release", "(Lcom/avito/android/safedeal/profile_settings/konveyor/text/TextItemPresenterImpl;)Lcom/avito/android/safedeal/profile_settings/konveyor/text/TextItemPresenter;", "bindTextItemPresenter", "Lcom/avito/android/safedeal/profile_settings/konveyor/skeleton/SkeletonPresenterImpl;", "Lcom/avito/android/safedeal/profile_settings/konveyor/skeleton/SkeletonPresenter;", "bindSkeletonItemPresenter$safedeal_release", "(Lcom/avito/android/safedeal/profile_settings/konveyor/skeleton/SkeletonPresenterImpl;)Lcom/avito/android/safedeal/profile_settings/konveyor/skeleton/SkeletonPresenter;", "bindSkeletonItemPresenter", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public static abstract class Declarations {
        @PerFragment
        @Binds
        @NotNull
        public abstract SkeletonPresenter bindSkeletonItemPresenter$safedeal_release(@NotNull SkeletonPresenterImpl skeletonPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        public abstract TextItemPresenter bindTextItemPresenter$safedeal_release(@NotNull TextItemPresenterImpl textItemPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DataAwareAdapterPresenter provideDataAwareAdapterPresenter$safedeal_release(@NotNull ListUpdateCallback listUpdateCallback, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
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
    public static final DiffCalculator provideDiffCalculator$safedeal_release(@NotNull ProfileDeliverySettingsContentsComparator profileDeliverySettingsContentsComparator) {
        Intrinsics.checkNotNullParameter(profileDeliverySettingsContentsComparator, "contentsComparator");
        return new SimpleDiffCalculator(profileDeliverySettingsContentsComparator, null, true, null, 10, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$safedeal_release(@NotNull SwitcherItemBlueprint switcherItemBlueprint, @NotNull TextItemBlueprint textItemBlueprint, @NotNull SkeletonBlueprint skeletonBlueprint, @NotNull ListItemBlueprint listItemBlueprint) {
        Intrinsics.checkNotNullParameter(switcherItemBlueprint, "switcherItemBlueprint");
        Intrinsics.checkNotNullParameter(textItemBlueprint, "textItemBlueprint");
        Intrinsics.checkNotNullParameter(skeletonBlueprint, "skeletonBlueprint");
        Intrinsics.checkNotNullParameter(listItemBlueprint, "listItemBlueprint");
        return new ItemBinder.Builder().registerItem(textItemBlueprint).registerItem(switcherItemBlueprint).registerItem(skeletonBlueprint).registerItem(listItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ListItemPresenter provideListItemPresenter$safedeal_release(@NotNull ProfileDeliverySettingsViewModel profileDeliverySettingsViewModel) {
        Intrinsics.checkNotNullParameter(profileDeliverySettingsViewModel, "viewModel");
        return new ListItemPresenterImpl(profileDeliverySettingsViewModel.getDeepLinkClicks());
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ListUpdateCallback provideListUpdateCallback$safedeal_release(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        return simpleRecyclerAdapter;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter provideRecyclerAdapter$safedeal_release(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideSimpleAdapterPresenter$safedeal_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SwitcherItemPresenter provideSwitcherItemPresenter$safedeal_release(@NotNull ProfileDeliverySettingsViewModel profileDeliverySettingsViewModel) {
        Intrinsics.checkNotNullParameter(profileDeliverySettingsViewModel, "viewModel");
        return new SwitcherItemPresenterImpl(profileDeliverySettingsViewModel.getDeepLinkClicks(), profileDeliverySettingsViewModel.getSwitcherClicks(), profileDeliverySettingsViewModel.getSwitcherLoadingStateObservable());
    }
}
