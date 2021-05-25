package com.avito.android.similar_adverts.di;

import a2.b.a.a.a;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.AdvertItemModule;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleContentsComparator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.section.di.SectionAdvertItemsModule;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.skeleton.SkeletonItem;
import com.avito.android.serp.adapter.skeleton.SkeletonPresenter;
import com.avito.android.serp.adapter.skeleton.SkeletonPresenterImpl;
import com.avito.android.serp.adapter.skeleton.SkeletonView;
import com.avito.android.similar_adverts.SimilarAdvertsViewModel;
import com.avito.android.similar_adverts.adapter.SimilarAdvertBlueprint;
import com.avito.android.similar_adverts.adapter.SimilarAdvertBlueprintImpl;
import com.avito.android.similar_adverts.adapter.SimilarSkeletonAdvertBlueprint;
import com.avito.android.similar_adverts.adapter.SimilarTitleWithActionBlueprint;
import com.avito.android.similar_adverts.adapter.skeleton_title.SimilarSkeletonTitleBlueprint;
import com.avito.android.similar_adverts.adapter.skeleton_title.SimilarSkeletonTitlePresenter;
import com.avito.android.similar_adverts.adapter.skeleton_title.SimilarSkeletonTitlePresenterImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b#\u0010$J/\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0018\u001a\u00020\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\nH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\nH\u0001¢\u0006\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/avito/android/similar_adverts/di/SimilarAdvertsBlueprintsModule;", "", "Lcom/avito/android/similar_adverts/adapter/SimilarAdvertBlueprint;", "similarAdvertBlueprint", "Lcom/avito/android/similar_adverts/adapter/SimilarTitleWithActionBlueprint;", "similarTitleWithActionBlueprint", "Lcom/avito/android/similar_adverts/adapter/SimilarSkeletonAdvertBlueprint;", "similarSkeletonAdvertBlueprint", "Lcom/avito/android/similar_adverts/adapter/skeleton_title/SimilarSkeletonTitleBlueprint;", "similarSkeletonTitleBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$similar_adverts_release", "(Lcom/avito/android/similar_adverts/adapter/SimilarAdvertBlueprint;Lcom/avito/android/similar_adverts/adapter/SimilarTitleWithActionBlueprint;Lcom/avito/android/similar_adverts/adapter/SimilarSkeletonAdvertBlueprint;Lcom/avito/android/similar_adverts/adapter/skeleton_title/SimilarSkeletonTitleBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Ldagger/Lazy;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter$similar_adverts_release", "(Ldagger/Lazy;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "provideDiffCalculator$similar_adverts_release", "()Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideAdapterPresenter$similar_adverts_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "<init>", "()V", "Declarations", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, SectionAdvertItemsModule.class, AdvertItemModule.class})
public final class SimilarAdvertsBlueprintsModule {
    @NotNull
    public static final SimilarAdvertsBlueprintsModule INSTANCE = new SimilarAdvertsBlueprintsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\r\u001a\u00020\u0016H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u001cH'¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/similar_adverts/di/SimilarAdvertsBlueprintsModule$Declarations;", "", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "bindListUpdateCallback", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "Lcom/avito/android/similar_adverts/SimilarAdvertsViewModel;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/serp/adapter/AdvertItemListener;", "bindsAdvertItemClickListener", "(Lcom/avito/android/similar_adverts/SimilarAdvertsViewModel;)Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/similar_adverts/adapter/SimilarAdvertBlueprintImpl;", "similarAdvertBlueprintImpl", "Lcom/avito/android/similar_adverts/adapter/SimilarAdvertBlueprint;", "bindSimilarAdvertBlueprintImpl", "(Lcom/avito/android/similar_adverts/adapter/SimilarAdvertBlueprintImpl;)Lcom/avito/android/similar_adverts/adapter/SimilarAdvertBlueprint;", "Lcom/avito/android/serp/adapter/skeleton/SkeletonPresenterImpl;", "presenter", "Lcom/avito/android/serp/adapter/skeleton/SkeletonPresenter;", "bindSkeletonPresenter", "(Lcom/avito/android/serp/adapter/skeleton/SkeletonPresenterImpl;)Lcom/avito/android/serp/adapter/skeleton/SkeletonPresenter;", "Lcom/avito/android/similar_adverts/adapter/SimilarSkeletonAdvertBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/skeleton/SkeletonView;", "Lcom/avito/android/serp/adapter/skeleton/SkeletonItem;", "bindSimilarAdvertSkeletonBlueprintImpl", "(Lcom/avito/android/similar_adverts/adapter/SimilarSkeletonAdvertBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/similar_adverts/adapter/skeleton_title/SimilarSkeletonTitlePresenterImpl;", "Lcom/avito/android/similar_adverts/adapter/skeleton_title/SimilarSkeletonTitlePresenter;", "bindSkeletonTitlePresenter", "(Lcom/avito/android/similar_adverts/adapter/skeleton_title/SimilarSkeletonTitlePresenterImpl;)Lcom/avito/android/similar_adverts/adapter/skeleton_title/SimilarSkeletonTitlePresenter;", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        ListUpdateCallback bindListUpdateCallback(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter);

        @PerFragment
        @Binds
        @NotNull
        SimilarAdvertBlueprint bindSimilarAdvertBlueprintImpl(@NotNull SimilarAdvertBlueprintImpl similarAdvertBlueprintImpl);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<SkeletonView, SkeletonItem> bindSimilarAdvertSkeletonBlueprintImpl(@NotNull SimilarSkeletonAdvertBlueprint similarSkeletonAdvertBlueprint);

        @PerFragment
        @Binds
        @NotNull
        SkeletonPresenter bindSkeletonPresenter(@NotNull SkeletonPresenterImpl skeletonPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SimilarSkeletonTitlePresenter bindSkeletonTitlePresenter(@NotNull SimilarSkeletonTitlePresenterImpl similarSkeletonTitlePresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertItemListener bindsAdvertItemClickListener(@NotNull SimilarAdvertsViewModel similarAdvertsViewModel);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$similar_adverts_release(@NotNull SimilarAdvertBlueprint similarAdvertBlueprint, @NotNull SimilarTitleWithActionBlueprint similarTitleWithActionBlueprint, @NotNull SimilarSkeletonAdvertBlueprint similarSkeletonAdvertBlueprint, @NotNull SimilarSkeletonTitleBlueprint similarSkeletonTitleBlueprint) {
        Intrinsics.checkNotNullParameter(similarAdvertBlueprint, "similarAdvertBlueprint");
        Intrinsics.checkNotNullParameter(similarTitleWithActionBlueprint, "similarTitleWithActionBlueprint");
        Intrinsics.checkNotNullParameter(similarSkeletonAdvertBlueprint, "similarSkeletonAdvertBlueprint");
        Intrinsics.checkNotNullParameter(similarSkeletonTitleBlueprint, "similarSkeletonTitleBlueprint");
        return new ItemBinder.Builder().registerItem(similarAdvertBlueprint).registerItem(similarTitleWithActionBlueprint).registerItem(similarSkeletonAdvertBlueprint).registerItem(similarSkeletonTitleBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$similar_adverts_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @NotNull
    @PerFragment
    public final DataAwareAdapterPresenter provideDataAwareAdapterPresenter$similar_adverts_release(@NotNull Lazy<ListUpdateCallback> lazy, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(lazy, "updateCallback");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        return new DataAwareAdapterPresenterImpl(lazy, adapterPresenter, diffCalculator);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DiffCalculator provideDiffCalculator$similar_adverts_release() {
        return new SimpleDiffCalculator(new SimpleContentsComparator(), null, true, null, 10, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }
}
