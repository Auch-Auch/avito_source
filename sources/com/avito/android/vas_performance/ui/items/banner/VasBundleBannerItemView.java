package com.avito.android.vas_performance.ui.items.banner;

import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.UniversalImage;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/vas_performance/ui/items/banner/VasBundleBannerItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setText", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/UniversalColor;", "color", "setBackgroundColor", "(Lcom/avito/android/remote/model/UniversalColor;)V", "Lcom/avito/android/remote/model/UniversalImage;", "image", "setImage", "(Lcom/avito/android/remote/model/UniversalImage;)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public interface VasBundleBannerItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull VasBundleBannerItemView vasBundleBannerItemView) {
            ItemView.DefaultImpls.onUnbind(vasBundleBannerItemView);
        }
    }

    void setBackgroundColor(@NotNull UniversalColor universalColor);

    void setImage(@Nullable UniversalImage universalImage);

    void setText(@NotNull String str);
}
