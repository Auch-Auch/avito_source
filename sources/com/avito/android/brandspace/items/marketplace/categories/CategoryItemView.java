package com.avito.android.brandspace.items.marketplace.categories;

import android.view.View;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UniversalColor;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/categories/CategoryItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "setPreviewImage", "(Lcom/avito/android/remote/model/Image;)V", "", "text", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/UniversalColor;", "color", "setBackgroundColor", "(Lcom/avito/android/remote/model/UniversalColor;)V", "Landroid/view/View$OnClickListener;", "clickListener", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface CategoryItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull CategoryItemView categoryItemView) {
            ItemView.DefaultImpls.onUnbind(categoryItemView);
        }
    }

    void setBackgroundColor(@NotNull UniversalColor universalColor);

    void setOnClickListener(@NotNull View.OnClickListener onClickListener);

    void setPreviewImage(@NotNull Image image);

    void setTitle(@NotNull String str);
}
