package com.avito.android.profile.edit.avatar;

import android.net.Uri;
import com.avito.android.krop.util.Transformation;
import com.avito.android.profile.edit.refactoring.avatar.ProfileAvatar;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.funktionale.option.Option;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/profile/edit/avatar/AvatarInteractor;", "", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/krop/util/Transformation;", "transformation", "Lio/reactivex/Observable;", "Lcom/avito/android/profile/edit/refactoring/avatar/ProfileAvatar;", "wrapAvatar", "(Landroid/net/Uri;Lcom/avito/android/krop/util/Transformation;)Lio/reactivex/Observable;", "Lorg/funktionale/option/Option;", "loadAvatar", "()Lio/reactivex/Observable;", "avatar", "", "updateAvatar", "(Lcom/avito/android/profile/edit/refactoring/avatar/ProfileAvatar;)Lio/reactivex/Observable;", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface AvatarInteractor {
    @NotNull
    Observable<Option<ProfileAvatar>> loadAvatar();

    @NotNull
    Observable<Unit> updateAvatar(@Nullable ProfileAvatar profileAvatar);

    @NotNull
    Observable<ProfileAvatar> wrapAvatar(@NotNull Uri uri, @Nullable Transformation transformation);
}
