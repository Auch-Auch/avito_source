package com.avito.android.advert.item.description;

import android.os.Parcelable;
import com.avito.android.advert_core.advert.DescriptionListener;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionItem;", "item", "Lcom/avito/android/advert_core/advert/DescriptionListener;", "expandListener", "", "showDescription", "(Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionItem;Lcom/avito/android/advert_core/advert/DescriptionListener;)V", "applyClosedAdvert", "()V", "Landroid/os/Parcelable;", "onSaveState", "()Landroid/os/Parcelable;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsDescriptionView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsDescriptionView advertDetailsDescriptionView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsDescriptionView);
        }
    }

    void applyClosedAdvert();

    @Nullable
    Parcelable onSaveState();

    void showDescription(@Nullable AdvertDetailsDescriptionItem advertDetailsDescriptionItem, @Nullable DescriptionListener descriptionListener);
}
