package com.avito.android.component.profile_toolbar;

import androidx.appcompat.widget.Toolbar;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.advert_details.UserIconType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/avito/android/component/profile_toolbar/ProfileToolbar;", "", "", "name", "", "setName", "(Ljava/lang/CharSequence;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "userIconType", "setUserIconType", "(Lcom/avito/android/remote/model/advert_details/UserIconType;)V", "", "isVisible", "withAnimation", "setContentVisible", "(ZZ)V", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "toolbar", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileToolbar {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void setContentVisible$default(ProfileToolbar profileToolbar, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z2 = true;
                }
                profileToolbar.setContentVisible(z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setContentVisible");
        }
    }

    @NotNull
    Toolbar getToolbar();

    void setAvatar(@Nullable Picture picture);

    void setContentVisible(boolean z, boolean z2);

    void setName(@Nullable CharSequence charSequence);

    void setUserIconType(@NotNull UserIconType userIconType);
}
