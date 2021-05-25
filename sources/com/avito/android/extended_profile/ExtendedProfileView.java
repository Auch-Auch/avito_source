package com.avito.android.extended_profile;

import android.os.Parcelable;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.extended_profile.ExtendedProfileViewSingleLiveEvent;
import com.avito.android.lib.design.snackbar.util.SnackbarElementView;
import com.avito.android.remote.model.Image;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileView;", "Lcom/avito/android/lib/design/snackbar/util/SnackbarElementView;", "Lcom/avito/android/extended_profile/ExtendedProfileViewModel;", "viewModel", "", "observe", "(Lcom/avito/android/extended_profile/ExtendedProfileViewModel;)V", "clear", "()V", "Router", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public interface ExtendedProfileView extends SnackbarElementView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010 \u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileView$Router;", "", "", "Lcom/avito/android/remote/model/Image;", "images", "", VKApiConst.POSITION, "", "openFullScreenGallery", "(Ljava/util/List;I)V", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$AdvertDetailsOpenEvent;", "event", "openAdvertDetails", "(Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$AdvertDetailsOpenEvent;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "title", "text", "openShareDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "leaveScreen", "()V", "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "phoneLink", "call", "(Lcom/avito/android/deep_linking/links/PhoneLink$Call;)V", "source", "Landroid/os/Parcelable;", AuthParamsKt.KEY_SUCCESS_AUTH_RESULT_DATA, "openAuthScreen", "(Ljava/lang/String;Landroid/os/Parcelable;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void call(@NotNull PhoneLink.Call call);

        void followDeepLink(@NotNull DeepLink deepLink);

        void leaveScreen();

        void openAdvertDetails(@NotNull ExtendedProfileViewSingleLiveEvent.AdvertDetailsOpenEvent advertDetailsOpenEvent);

        void openAuthScreen(@Nullable String str, @Nullable Parcelable parcelable);

        void openFullScreenGallery(@NotNull List<Image> list, int i);

        void openShareDialog(@NotNull String str, @NotNull String str2);
    }

    void clear();

    void observe(@NotNull ExtendedProfileViewModel extendedProfileViewModel);
}
