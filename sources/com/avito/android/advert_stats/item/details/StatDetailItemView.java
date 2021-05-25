package com.avito.android.advert_stats.item.details;

import com.avito.android.image_loader.Picture;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00118&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert_stats/item/details/StatDetailItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "", "drawableResId", "setImageDrawable", "(I)V", "hidePicture", "()V", "", "text", "setText", "(Ljava/lang/String;)V", "", "isHidden", "iconEnabled", "setHidden", "(ZZ)V", "isStatusView", "()Z", "setStatusView", "(Z)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public interface StatDetailItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull StatDetailItemView statDetailItemView) {
            ItemView.DefaultImpls.onUnbind(statDetailItemView);
        }
    }

    void hidePicture();

    boolean isStatusView();

    void setHidden(boolean z, boolean z2);

    void setImageDrawable(int i);

    void setPicture(@NotNull Picture picture);

    void setStatusView(boolean z);

    void setText(@NotNull String str);
}
