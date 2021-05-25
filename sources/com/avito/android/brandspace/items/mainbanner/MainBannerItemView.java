package com.avito.android.brandspace.items.mainbanner;

import android.view.View;
import com.avito.android.remote.model.Image;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J?\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/brandspace/items/mainbanner/MainBannerItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "title", "description", "actionText", "Landroid/view/View$OnClickListener;", "clickListener", "", "bind", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface MainBannerItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MainBannerItemView mainBannerItemView) {
            ItemView.DefaultImpls.onUnbind(mainBannerItemView);
        }
    }

    void bind(@NotNull Image image, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable View.OnClickListener onClickListener);
}
