package com.avito.android.profile.edit.refactoring.avatar;

import android.os.Parcelable;
import com.avito.android.image_loader.Picture;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/avatar/ProfileAvatar;", "Landroid/os/Parcelable;", "Lcom/avito/android/image_loader/Picture;", "getPicture", "()Lcom/avito/android/image_loader/Picture;", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileAvatar extends Parcelable {
    @NotNull
    Picture getPicture();
}
