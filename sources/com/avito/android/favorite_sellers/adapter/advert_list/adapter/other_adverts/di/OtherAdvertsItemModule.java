package com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.di;

import com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.OtherAdvertsItemBlueprint;
import com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.OtherAdvertsItemPresenter;
import com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.OtherAdvertsItemPresenterImpl;
import com.avito.android.favorite_sellers.adapter.advert_list.di.ForAdvertList;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/di/OtherAdvertsItemModule;", "", "<init>", "()V", "Declarations", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class OtherAdvertsItemModule {
    @NotNull
    public static final OtherAdvertsItemModule INSTANCE = new OtherAdvertsItemModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/di/OtherAdvertsItemModule$Declarations;", "", "Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindBlueprint", "(Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItemPresenterImpl;", "presenter", "Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItemPresenter;", "bindPresenter", "(Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItemPresenterImpl;)Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItemPresenter;", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @ForAdvertList
        ItemBlueprint<?, ?> bindBlueprint(@NotNull OtherAdvertsItemBlueprint otherAdvertsItemBlueprint);

        @Binds
        @NotNull
        OtherAdvertsItemPresenter bindPresenter(@NotNull OtherAdvertsItemPresenterImpl otherAdvertsItemPresenterImpl);
    }
}
