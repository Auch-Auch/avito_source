package com.avito.android.recycler.responsive;

import androidx.exifinterface.media.ExifInterface;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0000*\u00020\u0001*\n\b\u0001\u0010\u0004 \u0000*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemView;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/avito/conveyor_item/Item;", "I", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "view", "", VKApiConst.POSITION, "", "viewAttached", "(Lcom/avito/konveyor/blueprint/ItemView;I)V", "viewDetached", "recycler_release"}, k = 1, mv = {1, 4, 2})
public interface ResponsiveItemPresenter<V extends ItemView, I extends Item> extends ItemPresenter<V, I> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static <V extends ItemView, I extends Item> void viewAttached(@NotNull ResponsiveItemPresenter<? super V, ? super I> responsiveItemPresenter, @NotNull V v, int i) {
            Intrinsics.checkNotNullParameter(v, "view");
        }

        public static <V extends ItemView, I extends Item> void viewDetached(@NotNull ResponsiveItemPresenter<? super V, ? super I> responsiveItemPresenter, @NotNull V v, int i) {
            Intrinsics.checkNotNullParameter(v, "view");
        }
    }

    void viewAttached(@NotNull V v, int i);

    void viewDetached(@NotNull V v, int i);
}
