package com.avito.android.publish.select.di;

import a2.b.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.di.PerFragment;
import com.avito.android.publish.select.SelectViewModelFactory;
import com.avito.android.publish.select.blueprints.CheckableItemBlueprint;
import com.avito.android.publish.select.blueprints.CheckableItemBlueprintImpl;
import com.avito.android.publish.select.blueprints.CheckableItemPresenter;
import com.avito.android.publish.select.blueprints.CheckableItemPresenterImpl;
import com.avito.android.select.title.TitleItemPresenter;
import com.avito.android.select.title.TitleItemPresenterImpl;
import com.avito.android.select.title.TitleItemViewBlueprint;
import com.avito.android.select.title.TitleItemViewBlueprintImpl;
import com.avito.android.util.SchedulersFactory;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010 \u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e¢\u0006\u0002\b\u001f0\u001d2\u0006\u0010\u001c\u001a\u00020\u0012H\u0007¢\u0006\u0004\b \u0010!J\u000f\u0010%\u001a\u00020\"H\u0001¢\u0006\u0004\b#\u0010$J\u0017\u0010(\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\"H\u0001¢\u0006\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/publish/select/di/SelectModule;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/publish/select/SelectViewModelFactory;", "provideSelectViewModelFactory", "(Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/publish/select/SelectViewModelFactory;", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/android/publish/select/blueprints/CheckableItemBlueprint;", "checkableItemBlueprint", "Lcom/avito/android/select/title/TitleItemViewBlueprint;", "titleItemViewBlueprint", "provideItemBinder", "(Lcom/avito/android/publish/select/blueprints/CheckableItemBlueprint;Lcom/avito/android/select/title/TitleItemViewBlueprint;)Lcom/avito/konveyor/ItemBinder;", "Lcom/avito/android/publish/select/blueprints/CheckableItemPresenter;", "provideCheckableItemPresenter", "()Lcom/avito/android/publish/select/blueprints/CheckableItemPresenter;", "presenter", "provideCheckableItemBlueprint", "(Lcom/avito/android/publish/select/blueprints/CheckableItemPresenter;)Lcom/avito/android/publish/select/blueprints/CheckableItemBlueprint;", "adapterPresenter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "checkableItemPresenter", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "provideItemPresentersSet", "(Lcom/avito/android/publish/select/blueprints/CheckableItemPresenter;)Ljava/util/Set;", "Lcom/avito/android/select/title/TitleItemPresenter;", "provideTitleItemPresenter$publish_release", "()Lcom/avito/android/select/title/TitleItemPresenter;", "provideTitleItemPresenter", "provideTitleItemViewBlueprint$publish_release", "(Lcom/avito/android/select/title/TitleItemPresenter;)Lcom/avito/android/select/title/TitleItemViewBlueprint;", "provideTitleItemViewBlueprint", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class SelectModule {
    @Provides
    @NotNull
    @PerFragment
    public final RecyclerView.Adapter<?> provideAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
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
    public final ItemBinder provideItemBinder(@NotNull CheckableItemBlueprint checkableItemBlueprint, @NotNull TitleItemViewBlueprint titleItemViewBlueprint) {
        Intrinsics.checkNotNullParameter(checkableItemBlueprint, "checkableItemBlueprint");
        Intrinsics.checkNotNullParameter(titleItemViewBlueprint, "titleItemViewBlueprint");
        return new ItemBinder.Builder().registerItem(checkableItemBlueprint).registerItem(titleItemViewBlueprint).build();
    }

    @Provides
    @NotNull
    @PerFragment
    public final Set<ItemPresenter<?, ?>> provideItemPresentersSet(@NotNull CheckableItemPresenter checkableItemPresenter) {
        Intrinsics.checkNotNullParameter(checkableItemPresenter, "checkableItemPresenter");
        return x.setOf(checkableItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SelectViewModelFactory provideSelectViewModelFactory(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new SelectViewModelFactory(schedulersFactory);
    }

    @Provides
    @PerFragment
    @NotNull
    public final TitleItemPresenter provideTitleItemPresenter$publish_release() {
        return new TitleItemPresenterImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final TitleItemViewBlueprint provideTitleItemViewBlueprint$publish_release(@NotNull TitleItemPresenter titleItemPresenter) {
        Intrinsics.checkNotNullParameter(titleItemPresenter, "presenter");
        return new TitleItemViewBlueprintImpl(titleItemPresenter);
    }
}
