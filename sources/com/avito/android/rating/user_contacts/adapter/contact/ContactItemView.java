package com.avito.android.rating.user_contacts.adapter.contact;

import com.avito.android.image_loader.Picture;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\u0006J\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011H&¢\u0006\u0004\b\u0015\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u00042\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "name", "", "setContactName", "(Ljava/lang/String;)V", "Lcom/avito/android/image_loader/Picture;", "image", "setItemImage", "(Lcom/avito/android/image_loader/Picture;)V", "title", "setItemTitle", "price", "setItemPrice", "resetRating", "()V", "Lio/reactivex/rxjava3/core/Observable;", "removeClicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "ratingClicks", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface ContactItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ContactItemView contactItemView) {
            ItemView.DefaultImpls.onUnbind(contactItemView);
        }
    }

    @NotNull
    Observable<Integer> ratingClicks();

    @NotNull
    Observable<Unit> removeClicks();

    void resetRating();

    void setContactName(@Nullable String str);

    void setItemImage(@Nullable Picture picture);

    void setItemPrice(@Nullable String str);

    void setItemTitle(@Nullable String str);

    void setUnbindListener(@Nullable Function0<Unit> function0);
}
