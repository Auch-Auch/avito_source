package com.avito.android.component.user_hat;

import androidx.annotation.AttrRes;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.R;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u0006J7\u0010\u0012\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u00042\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020\u00042\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001cH&¢\u0006\u0004\b \u0010\u001f¨\u0006!"}, d2 = {"Lcom/avito/android/component/user_hat/UserHat;", "", "", "name", "", "setName", "(Ljava/lang/CharSequence;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "description", "setDescription", "", "score", "", "enableFloatingRating", "text", "", "textColorAttr", "setRating", "(Ljava/lang/Float;ZLjava/lang/CharSequence;I)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "userIconType", "setUserIconType", "(Lcom/avito/android/remote/model/advert_details/UserIconType;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRatingClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setAvatarClickListener", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface UserHat {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void setRating$default(UserHat userHat, Float f, boolean z, CharSequence charSequence, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    charSequence = null;
                }
                if ((i2 & 8) != 0) {
                    i = R.attr.blue;
                }
                userHat.setRating(f, z, charSequence, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRating");
        }
    }

    void setAvatar(@Nullable Picture picture);

    void setAvatarClickListener(@Nullable Function0<Unit> function0);

    void setDescription(@Nullable CharSequence charSequence);

    void setName(@Nullable CharSequence charSequence);

    void setRating(@Nullable Float f, boolean z, @Nullable CharSequence charSequence, @AttrRes int i);

    void setRatingClickListener(@Nullable Function0<Unit> function0);

    void setSubtitle(@Nullable CharSequence charSequence);

    void setUserIconType(@NotNull UserIconType userIconType);
}
