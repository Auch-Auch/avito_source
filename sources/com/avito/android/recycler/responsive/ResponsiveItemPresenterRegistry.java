package com.avito.android.recycler.responsive;

import androidx.exifinterface.media.ExifInterface;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J9\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/recycler/responsive/ResponsiveItemPresenterRegistry;", "", "Lcom/avito/konveyor/blueprint/ItemView;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/lang/Class;", "viewType", "Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;", "itemPresenter", "", "register", "(Ljava/lang/Class;Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;)V", "unregister", "(Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;)V", "recycler_release"}, k = 1, mv = {1, 4, 2})
public interface ResponsiveItemPresenterRegistry {
    <V extends ItemView> void register(@NotNull Class<V> cls, @NotNull ResponsiveItemPresenter<? super V, ?> responsiveItemPresenter);

    void unregister(@NotNull ResponsiveItemPresenter<?, ?> responsiveItemPresenter);
}
