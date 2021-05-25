package com.avito.android.public_profile.ui;

import android.view.View;
import com.avito.android.lib.design.snackbar.util.SnackbarElementView;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UserDialog;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\u000e\u0010\u000bJ+\u0010\u0014\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0017\u0010\u000bJ\u0019\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0019\u0010\u000bJ#\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H&¢\u0006\u0004\b \u0010\u0007J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b#\u0010$J\u001d\u0010'\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050%H&¢\u0006\u0004\b'\u0010(J\u001d\u0010)\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050%H&¢\u0006\u0004\b)\u0010(J\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050*H&¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0005H&¢\u0006\u0004\b-\u0010\u0007J\u000f\u0010.\u001a\u00020\u0005H&¢\u0006\u0004\b.\u0010\u0007J\u0017\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\bH&¢\u0006\u0004\b0\u0010\u000bJ\u0017\u00101\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\bH&¢\u0006\u0004\b1\u0010\u000bJ5\u00108\u001a\u00020\u00052\u0006\u00103\u001a\u0002022\n\b\u0002\u00104\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105H&¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0005H&¢\u0006\u0004\b:\u0010\u0007J\u000f\u0010;\u001a\u00020\u0005H&¢\u0006\u0004\b;\u0010\u0007J\u000f\u0010<\u001a\u00020\u0005H&¢\u0006\u0004\b<\u0010\u0007¨\u0006="}, d2 = {"Lcom/avito/android/public_profile/ui/PublicProfileView;", "Lcom/avito/android/public_profile/ui/SubscriptionsCounterView;", "Lcom/avito/android/public_profile/ui/SubscribeButtonsView;", "Lcom/avito/android/public_profile/ui/SubscriptionsContainerView;", "Lcom/avito/android/lib/design/snackbar/util/SnackbarElementView;", "", "showProgress", "()V", "", "error", "showError", "(Ljava/lang/String;)V", "showContent", "name", "showName", "", "score", "text", "", "clickable", "showRating", "(Ljava/lang/Float;Ljava/lang/String;Z)V", MessengerShareContentUtility.SUBTITLE, "showSubtitle", "value", "showConnections", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "type", "Lcom/avito/android/remote/model/Image;", "avatar", "showAvatar", "(Lcom/avito/android/remote/model/advert_details/UserIconType;Lcom/avito/android/remote/model/Image;)V", "onTabsChanged", "", "activeTab", "setActiveTab", "(I)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRatingClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setAvatarClickListener", "Lio/reactivex/rxjava3/core/Observable;", "shareButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "showShareButton", "hideShareButton", "message", "showUserBanned", "showUserRemoved", "Lcom/avito/android/remote/model/UserDialog;", "dialog", "actionTitle", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Landroid/view/View;", "action", "showBlockedAdvertsAlertBanner", "(Lcom/avito/android/remote/model/UserDialog;Ljava/lang/String;Lcom/jakewharton/rxrelay3/PublishRelay;)V", "hideBlockedAdvertsAlertBanner", "showAdverts", "hideAdverts", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public interface PublicProfileView extends SubscriptionsCounterView, SubscribeButtonsView, SubscriptionsContainerView, SnackbarElementView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void showAvatar$default(PublicProfileView publicProfileView, UserIconType userIconType, Image image, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    image = null;
                }
                publicProfileView.showAvatar(userIconType, image);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAvatar");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.avito.android.public_profile.ui.PublicProfileView */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void showBlockedAdvertsAlertBanner$default(PublicProfileView publicProfileView, UserDialog userDialog, String str, PublishRelay publishRelay, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                if ((i & 4) != 0) {
                    publishRelay = null;
                }
                publicProfileView.showBlockedAdvertsAlertBanner(userDialog, str, publishRelay);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showBlockedAdvertsAlertBanner");
        }
    }

    void hideAdverts();

    void hideBlockedAdvertsAlertBanner();

    void hideShareButton();

    void onTabsChanged();

    void setActiveTab(int i);

    void setAvatarClickListener(@NotNull Function0<Unit> function0);

    void setRatingClickListener(@NotNull Function0<Unit> function0);

    @NotNull
    Observable<Unit> shareButtonClicks();

    void showAdverts();

    void showAvatar(@NotNull UserIconType userIconType, @Nullable Image image);

    void showBlockedAdvertsAlertBanner(@NotNull UserDialog userDialog, @Nullable String str, @Nullable PublishRelay<View> publishRelay);

    void showConnections(@Nullable String str);

    @Override // com.avito.android.public_profile.ui.SubscriptionsContainerView
    void showContent();

    void showError(@NotNull String str);

    void showName(@NotNull String str);

    void showProgress();

    void showRating(@Nullable Float f, @Nullable String str, boolean z);

    void showShareButton();

    void showSubtitle(@Nullable String str);

    void showUserBanned(@NotNull String str);

    void showUserRemoved(@NotNull String str);
}
