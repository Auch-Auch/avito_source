package com.avito.android.extended_profile.adapter.header;

import com.avito.android.image_loader.Picture;
import com.avito.android.public_profile.ui.SubscribeButtonsView;
import com.avito.android.public_profile.ui.SubscriptionsCounterView;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u001b\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0016\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0019\u0010\u0010J\u001f\u0010\u001c\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/extended_profile/adapter/header/HeaderItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/public_profile/ui/SubscriptionsCounterView;", "Lcom/avito/android/public_profile/ui/SubscribeButtonsView;", "Lcom/avito/android/image_loader/Picture;", "avatar", "", "showAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "type", "setUserIconType", "(Lcom/avito/android/remote/model/advert_details/UserIconType;)V", "", "name", "showName", "(Ljava/lang/CharSequence;)V", "", "score", "text", "", "clickable", "showRating", "(Ljava/lang/Float;Ljava/lang/CharSequence;Z)V", MessengerShareContentUtility.SUBTITLE, "showSubtitle", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "Lio/reactivex/rxjava3/core/Observable;", "getAvatarClicks", "()Lio/reactivex/rxjava3/core/Observable;", "avatarClicks", "getRatingClicks", "ratingClicks", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public interface HeaderItemView extends ItemView, SubscriptionsCounterView, SubscribeButtonsView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull HeaderItemView headerItemView) {
            ItemView.DefaultImpls.onUnbind(headerItemView);
        }

        public static /* synthetic */ void showAvatar$default(HeaderItemView headerItemView, Picture picture, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    picture = null;
                }
                headerItemView.showAvatar(picture);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAvatar");
        }
    }

    @NotNull
    Observable<Unit> getAvatarClicks();

    @NotNull
    Observable<Unit> getRatingClicks();

    void setUnbindListener(@Nullable Function0<Unit> function0);

    void setUserIconType(@NotNull UserIconType userIconType);

    void showAvatar(@Nullable Picture picture);

    void showName(@Nullable CharSequence charSequence);

    void showRating(@Nullable Float f, @Nullable CharSequence charSequence, boolean z);

    void showSubtitle(@Nullable CharSequence charSequence);
}
