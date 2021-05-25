package com.avito.android.publish.start_publish.di;

import a2.b.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.di.PerFragment;
import com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemBlueprint;
import com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemBlueprintImpl;
import com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemPresenter;
import com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemPresenterImpl;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/avito/android/publish/start_publish/di/StartPublishSheetModule;", "", "Lcom/avito/konveyor/ItemBinder;", GeoContract.PROVIDER, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$publish_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "adapterPresenter", "itemBinder", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemBlueprint;", "itemBlueprint", "provideItemBinder$publish_release", "(Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "<init>", "()V", "Declarations", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class StartPublishSheetModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/publish/start_publish/di/StartPublishSheetModule$Declarations;", "", "Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemBlueprintImpl;", "itemBlueprint", "Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemBlueprint;", "bindItemBlueprint", "(Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemBlueprintImpl;)Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemBlueprint;", "Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemPresenterImpl;", "itemPresenter", "Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemPresenter;", "bindItemPresenter", "(Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemPresenterImpl;)Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemPresenter;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        CategoryShortcutItemBlueprint bindItemBlueprint(@NotNull CategoryShortcutItemBlueprintImpl categoryShortcutItemBlueprintImpl);

        @PerFragment
        @Binds
        @NotNull
        CategoryShortcutItemPresenter bindItemPresenter(@NotNull CategoryShortcutItemPresenterImpl categoryShortcutItemPresenterImpl);
    }

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
    public final ItemBinder provideItemBinder$publish_release(@NotNull CategoryShortcutItemBlueprint categoryShortcutItemBlueprint) {
        Intrinsics.checkNotNullParameter(categoryShortcutItemBlueprint, "itemBlueprint");
        return new ItemBinder.Builder().registerItem(categoryShortcutItemBlueprint).build();
    }
}
