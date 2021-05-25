package com.avito.android.rating.user_reviews;

import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H&¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u0003H&¢\u0006\u0004\b\u0011\u0010\u0007J\u000f\u0010\u0012\u001a\u00020\u0003H&¢\u0006\u0004\b\u0012\u0010\u0007J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0013\u0010\u000bJ\u001f\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H&¢\u0006\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/avito/android/rating/user_reviews/UserReviewsView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "notifyItemsChanged", "()V", "", VKApiConst.POSITION, "notifyItemRemoved", "(I)V", "", "message", "showSnackbar", "(Ljava/lang/String;)V", "showReviewDeletedMessage", "showToolbar", "updateItems", "scrollToPosition", "title", "showUserDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "closeUserDialog", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface UserReviewsView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull UserReviewsView userReviewsView) {
            ItemView.DefaultImpls.onUnbind(userReviewsView);
        }
    }

    void closeUserDialog();

    @NotNull
    Observable<Unit> navigationClicks();

    void notifyItemRemoved(int i);

    void notifyItemsChanged();

    void scrollToPosition(int i);

    void showReviewDeletedMessage();

    void showSnackbar(@NotNull String str);

    void showToolbar();

    void showUserDialog(@NotNull String str, @NotNull String str2);

    void updateItems();
}
