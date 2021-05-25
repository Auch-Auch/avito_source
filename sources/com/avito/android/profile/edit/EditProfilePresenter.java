package com.avito.android.profile.edit;

import android.net.Uri;
import com.avito.android.krop.util.Transformation;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.NameIdEntity;
import com.avito.android.util.Kundle;
import com.facebook.share.internal.ShareConstants;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ#\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H&¢\u0006\u0004\b\u001f\u0010\b¨\u0006!"}, d2 = {"Lcom/avito/android/profile/edit/EditProfilePresenter;", "", "Lcom/avito/android/profile/edit/EditProfileView;", "view", "", "attachView", "(Lcom/avito/android/profile/edit/EditProfileView;)V", "detachView", "()V", "Lcom/avito/android/profile/edit/EditProfilePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/edit/EditProfilePresenter$Router;)V", "detachRouter", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/krop/util/Transformation;", "transformation", "onAvatarSelected", "(Landroid/net/Uri;Lcom/avito/android/krop/util/Transformation;)V", "Lcom/avito/android/remote/model/Location;", "location", "onLocationSelected", "(Lcom/avito/android/remote/model/Location;)V", "Lcom/avito/android/remote/model/NameIdEntity;", "entity", "onSubLocationSelected", "(Lcom/avito/android/remote/model/NameIdEntity;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onBackPressed", "Router", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface EditProfilePresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onAvatarSelected$default(EditProfilePresenter editProfilePresenter, Uri uri, Transformation transformation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    transformation = null;
                }
                editProfilePresenter.onAvatarSelected(uri, transformation);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAvatarSelected");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\f\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/profile/edit/EditProfilePresenter$Router;", "", "Lcom/avito/android/remote/model/Location;", "location", "", "openLocationScreen", "(Lcom/avito/android/remote/model/Location;)V", "", "title", "", "Lcom/avito/android/remote/model/NameIdEntity;", "items", "selectedItem", "openSubLocationScreen", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/NameIdEntity;)V", "openCameraScreen", "()V", "phoneNumber", "openPhoneVerificationScreen", "(Ljava/lang/String;)V", "", "changesSaved", "close", "(Z)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static /* synthetic */ void close$default(Router router, boolean z, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        z = false;
                    }
                    router.close(z);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
        }

        void close(boolean z);

        void openCameraScreen();

        void openLocationScreen(@Nullable Location location);

        void openPhoneVerificationScreen(@NotNull String str);

        void openSubLocationScreen(@NotNull String str, @NotNull List<NameIdEntity> list, @Nullable NameIdEntity nameIdEntity);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull EditProfileView editProfileView);

    void detachRouter();

    void detachView();

    void onAvatarSelected(@NotNull Uri uri, @Nullable Transformation transformation);

    void onBackPressed();

    void onLocationSelected(@NotNull Location location);

    @NotNull
    Kundle onSaveState();

    void onSubLocationSelected(@NotNull NameIdEntity nameIdEntity);
}
