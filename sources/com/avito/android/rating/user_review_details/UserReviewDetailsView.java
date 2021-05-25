package com.avito.android.rating.user_review_details;

import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.Sort;
import com.avito.android.tns_gallery.TnsGalleryView;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0015\u0010\u000bJ\u0019\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0017\u0010\u000bJ\u0019\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0019\u0010\u000bJ\u0019\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u001b\u0010\u000bJ\u0019\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H&¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0003H&¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\u0003H&¢\u0006\u0004\b#\u0010!J\u0017\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u001cH&¢\u0006\u0004\b%\u0010\u001fJ\u0019\u0010&\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b&\u0010\u0013J\u0019\u0010(\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b(\u0010\u000bJ\u0019\u0010)\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b)\u0010\u000bJ\u0019\u0010*\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b*\u0010\u0013J\u0017\u0010+\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b+\u0010\u000bR\u0016\u0010/\u001a\u00020,8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/avito/android/rating/user_review_details/UserReviewDetailsView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "profileClicks", "deleteClicks", "", "name", "setRecipientName", "(Ljava/lang/CharSequence;)V", "", "score", "setRating", "(Ljava/lang/Float;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setRecipientAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "message", "setMessage", "item", "setItem", Sort.DATE, "setPublicationDate", "stage", "setStage", "", "rejectMessage", "setRejectMessage", "(Ljava/lang/String;)V", "showProgress", "()V", "hideProgress", "showError", "reviewStatus", "setReviewStatus", "setRecipientShopAvatar", "text", "setRecipientReply", "setRecipientReplyDate", "setUserAvatar", "setUserName", "Lcom/avito/android/tns_gallery/TnsGalleryView;", "getGalleryView", "()Lcom/avito/android/tns_gallery/TnsGalleryView;", "galleryView", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface UserReviewDetailsView {
    @NotNull
    Observable<Unit> deleteClicks();

    @NotNull
    TnsGalleryView getGalleryView();

    void hideProgress();

    @NotNull
    Observable<Unit> navigationClicks();

    @NotNull
    Observable<Unit> profileClicks();

    void setItem(@Nullable CharSequence charSequence);

    void setMessage(@Nullable CharSequence charSequence);

    void setPublicationDate(@Nullable CharSequence charSequence);

    void setRating(@Nullable Float f);

    void setRecipientAvatar(@Nullable Picture picture);

    void setRecipientName(@NotNull CharSequence charSequence);

    void setRecipientReply(@Nullable CharSequence charSequence);

    void setRecipientReplyDate(@Nullable CharSequence charSequence);

    void setRecipientShopAvatar(@Nullable Picture picture);

    void setRejectMessage(@Nullable String str);

    void setReviewStatus(@NotNull String str);

    void setStage(@Nullable CharSequence charSequence);

    void setUserAvatar(@Nullable Picture picture);

    void setUserName(@NotNull CharSequence charSequence);

    void showError();

    void showProgress();
}
