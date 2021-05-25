package com.avito.android.tariff.fees_methods.items;

import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.HighDemandIcon;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0012\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/tariff/fees_methods/items/FeeMethodItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "hidePicture", "()V", "", "title", "setTitle", "(Ljava/lang/String;)V", "", "description", "setDescription", "(Ljava/lang/CharSequence;)V", "price", "setPrice", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "isNeedTooShow", "showHighDemandIcon", "(Z)V", "Lcom/avito/android/remote/model/HighDemandIcon;", "priceIcon", "setIcon", "(Lcom/avito/android/remote/model/HighDemandIcon;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface FeeMethodItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull FeeMethodItemView feeMethodItemView) {
            ItemView.DefaultImpls.onUnbind(feeMethodItemView);
        }
    }

    void hidePicture();

    void setDescription(@Nullable CharSequence charSequence);

    void setIcon(@Nullable HighDemandIcon highDemandIcon);

    void setOnClickListener(@NotNull Function0<Unit> function0);

    void setPicture(@NotNull Picture picture);

    void setPrice(@Nullable CharSequence charSequence);

    void setTitle(@NotNull String str);

    void showHighDemandIcon(boolean z);
}
