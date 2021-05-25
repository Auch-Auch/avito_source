package com.avito.android.basket_legacy.item;

import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/basket_legacy/item/BasketItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "price", "setPrice", "oldPrice", "setOldPrice", "Lcom/avito/android/image_loader/Picture;", "picture", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "", "cancelable", "setCancelable", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCrossClickListener", "(Lkotlin/jvm/functions/Function0;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public interface BasketItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull BasketItemView basketItemView) {
            ItemView.DefaultImpls.onUnbind(basketItemView);
        }
    }

    void setCancelable(boolean z);

    void setCrossClickListener(@NotNull Function0<Unit> function0);

    void setOldPrice(@Nullable AttributedText attributedText);

    void setPicture(@NotNull Picture picture);

    void setPrice(@NotNull AttributedText attributedText);

    void setSubtitle(@Nullable AttributedText attributedText);

    void setTitle(@NotNull String str);
}
