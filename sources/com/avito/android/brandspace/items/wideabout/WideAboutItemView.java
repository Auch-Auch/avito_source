package com.avito.android.brandspace.items.wideabout;

import com.avito.android.brandspace.remote.model.BrandspaceAboutParagraphElement;
import com.avito.android.remote.model.Image;
import com.avito.konveyor.blueprint.ItemView;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/brandspace/items/wideabout/WideAboutItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "Lcom/avito/android/remote/model/Image;", "image", "", "Lcom/avito/android/brandspace/remote/model/BrandspaceAboutParagraphElement;", "paragraphs", "", "bind", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/util/List;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface WideAboutItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull WideAboutItemView wideAboutItemView) {
            ItemView.DefaultImpls.onUnbind(wideAboutItemView);
        }
    }

    void bind(@Nullable String str, @Nullable Image image, @NotNull List<BrandspaceAboutParagraphElement> list);
}
