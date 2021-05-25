package com.avito.android.brandspace.items.marketplace.banner;

import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UniversalColor;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/banner/BannerItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "", "text", "setTitle", "(Ljava/lang/String;)V", "setDescription", "setUptitle", "Lcom/avito/android/remote/model/UniversalColor;", "color", "setBackground", "(Lcom/avito/android/remote/model/UniversalColor;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface BannerItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull BannerItemView bannerItemView) {
            ItemView.DefaultImpls.onUnbind(bannerItemView);
        }
    }

    void setBackground(@NotNull UniversalColor universalColor);

    void setDescription(@NotNull String str);

    void setImage(@NotNull Image image);

    void setTitle(@NotNull String str);

    void setUptitle(@NotNull String str);
}
