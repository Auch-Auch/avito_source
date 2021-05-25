package com.avito.android.select.bottom_sheet.blueprints;

import com.avito.android.remote.model.Image;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "", "isChecked", "setChecked", "(Z)V", "enable", "enableMultiselect", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public interface CheckableItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void enableMultiselect(@NotNull CheckableItemView checkableItemView, boolean z) {
        }

        public static void onUnbind(@NotNull CheckableItemView checkableItemView) {
            ItemView.DefaultImpls.onUnbind(checkableItemView);
        }

        public static void setImage(@NotNull CheckableItemView checkableItemView, @Nullable Image image) {
        }

        public static void setSubtitle(@NotNull CheckableItemView checkableItemView, @Nullable String str) {
        }
    }

    void enableMultiselect(boolean z);

    void setChecked(boolean z);

    void setImage(@Nullable Image image);

    void setOnClickListener(@NotNull Function0<Unit> function0);

    void setSubtitle(@Nullable String str);

    void setTitle(@NotNull String str);
}
