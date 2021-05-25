package com.avito.android.developments_catalog.items.description;

import android.os.Parcelable;
import com.avito.android.advert_core.advert.DescriptionListener;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/developments_catalog/items/description/DescriptionView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "description", "Landroid/os/Parcelable;", "state", "Lcom/avito/android/advert_core/advert/DescriptionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showDescription", "(Ljava/lang/String;Landroid/os/Parcelable;Lcom/avito/android/advert_core/advert/DescriptionListener;)V", "onSaveState", "()Landroid/os/Parcelable;", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface DescriptionView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull DescriptionView descriptionView) {
            ItemView.DefaultImpls.onUnbind(descriptionView);
        }
    }

    @Nullable
    Parcelable onSaveState();

    void showDescription(@NotNull String str, @Nullable Parcelable parcelable, @NotNull DescriptionListener descriptionListener);
}
