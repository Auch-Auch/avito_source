package ru.avito.component.stories;

import a2.b.a.a.a;
import android.view.View;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.Story;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarousel;
import ru.avito.component.stories.single.StoryCarouselItem;
import t6.n.e;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014¢\u0006\u0004\b\u000b\u0010\u0007R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lru/avito/component/stories/StoriesCarousel;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarousel;", "", "Lcom/avito/android/remote/model/Story;", "stories", "", "setStories", "(Ljava/util/List;)V", "", "Lcom/avito/konveyor/blueprint/Item;", "items", "collectData", AuthSource.OPEN_CHANNEL_LIST, "Ljava/util/List;", "Landroid/view/View;", "view", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class StoriesCarousel extends ImageCarousel {
    public List<Story> m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoriesCarousel(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        super(view, adapterPresenter, itemBinder, null, false, Integer.valueOf(Views.dpToPx(view, 8)), null, 64, null);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarousel
    public void collectData(@NotNull List<Item> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        List<Story> list2 = this.m;
        if (list2 != null) {
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            for (T t : list2) {
                String I2 = a.I2("UUID.randomUUID().toString()");
                Picture pictureOf$default = AvitoPictureKt.pictureOf$default(t.getImage(), false, 0.0f, 0.0f, null, 28, null);
                Color backgroundColor = t.getBackgroundColor();
                String title = t.getTitle();
                Boolean isViewed = t.isViewed();
                arrayList.add(new StoryCarouselItem(I2, pictureOf$default, backgroundColor, title, isViewed != null ? isViewed.booleanValue() : false));
            }
            h.addAll(list, arrayList);
        }
    }

    public final void setStories(@NotNull List<Story> list) {
        Intrinsics.checkNotNullParameter(list, "stories");
        this.m = list;
        updateDataSource();
    }
}
