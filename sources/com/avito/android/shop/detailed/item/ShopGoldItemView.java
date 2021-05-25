package com.avito.android.shop.detailed.item;

import androidx.annotation.DrawableRes;
import com.avito.android.image_loader.Picture;
import com.avito.android.public_profile.ui.SubscribeButtonsView;
import com.avito.android.remote.model.Sort;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u000f\u0010\tJ%\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u0007H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H&¢\u0006\u0004\b\u0018\u0010\u0017J%\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H&¢\u0006\u0004\b\u001b\u0010\u0014J\u0019\u0010\u001d\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u001d\u0010\tJ\u000f\u0010\u001e\u001a\u00020\u0007H&¢\u0006\u0004\b\u001e\u0010\u0017J1\u0010\"\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u001f2\b\b\u0001\u0010!\u001a\u00020 2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H&¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H&¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0007H&¢\u0006\u0004\b&\u0010\u0017J\u001f\u0010'\u001a\u00020\u00072\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011H&¢\u0006\u0004\b'\u0010%¨\u0006("}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopGoldItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/shop/detailed/item/RatingView;", "Lcom/avito/android/shop/detailed/item/VerificationView;", "Lcom/avito/android/public_profile/ui/SubscribeButtonsView;", "", "name", "", "setName", "(Ljava/lang/String;)V", "Lcom/avito/android/image_loader/Picture;", "logo", "setLogo", "(Lcom/avito/android/image_loader/Picture;)V", "category", "setCategory", "text", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDescription", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "setContactsHandlerName", "expandContacts", "()V", "collapseContacts", "location", "clickListener", "showLocation", Sort.DATE, "setCreationDate", "clearContacts", "", "", "icon", "addContactCell", "(Ljava/lang/CharSequence;ILkotlin/jvm/functions/Function0;)V", "setContactsHandlerListener", "(Lkotlin/jvm/functions/Function0;)V", "hideContactsButton", "setUnbindListener", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopGoldItemView extends ItemView, RatingView, VerificationView, SubscribeButtonsView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ShopGoldItemView shopGoldItemView) {
            ItemView.DefaultImpls.onUnbind(shopGoldItemView);
        }
    }

    void addContactCell(@Nullable CharSequence charSequence, @DrawableRes int i, @NotNull Function0<Unit> function0);

    void clearContacts();

    void collapseContacts();

    void expandContacts();

    void hideContactsButton();

    void setCategory(@Nullable String str);

    void setContactsHandlerListener(@NotNull Function0<Unit> function0);

    void setContactsHandlerName(@NotNull String str);

    void setCreationDate(@Nullable String str);

    void setDescription(@NotNull String str, @NotNull Function0<Unit> function0);

    void setLogo(@NotNull Picture picture);

    void setName(@NotNull String str);

    void setUnbindListener(@Nullable Function0<Unit> function0);

    void showLocation(@NotNull String str, @NotNull Function0<Unit> function0);
}
