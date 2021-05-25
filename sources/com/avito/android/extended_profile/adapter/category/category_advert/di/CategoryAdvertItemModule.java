package com.avito.android.extended_profile.adapter.category.category_advert.di;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.di.PerFragment;
import com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemBlueprint;
import com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemPresenter;
import com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemPresenterImpl;
import com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemBlueprint;
import com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemPresenter;
import com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_advert/di/CategoryAdvertItemModule;", "", "Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "provideGalleryRatio", "()Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "provideRecycledViewPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "<init>", "()V", "Declarations", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class CategoryAdvertItemModule {
    @NotNull
    public static final CategoryAdvertItemModule INSTANCE = new CategoryAdvertItemModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_advert/di/CategoryAdvertItemModule$Declarations;", "", "Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindListBlueprint", "(Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemPresenterImpl;", "presenter", "Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemPresenter;", "bindListPresenter", "(Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemPresenterImpl;)Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemPresenter;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/grid/CategoryAdvertGridItemBlueprint;", "bindGridBlueprint", "(Lcom/avito/android/extended_profile/adapter/category/category_advert/grid/CategoryAdvertGridItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/grid/CategoryAdvertGridItemPresenterImpl;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/grid/CategoryAdvertGridItemPresenter;", "bindGridPresenter", "(Lcom/avito/android/extended_profile/adapter/category/category_advert/grid/CategoryAdvertGridItemPresenterImpl;)Lcom/avito/android/extended_profile/adapter/category/category_advert/grid/CategoryAdvertGridItemPresenter;", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindGridBlueprint(@NotNull CategoryAdvertGridItemBlueprint categoryAdvertGridItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        CategoryAdvertGridItemPresenter bindGridPresenter(@NotNull CategoryAdvertGridItemPresenterImpl categoryAdvertGridItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindListBlueprint(@NotNull CategoryAdvertListItemBlueprint categoryAdvertListItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        CategoryAdvertListItemPresenter bindListPresenter(@NotNull CategoryAdvertListItemPresenterImpl categoryAdvertListItemPresenterImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final GalleryRatio provideGalleryRatio() {
        return new GalleryRatio(0.32f, 1.3333334f, 0.0f, 0.0f, 12, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final RecyclerView.RecycledViewPool provideRecycledViewPool() {
        return new RecyclerView.RecycledViewPool();
    }
}
