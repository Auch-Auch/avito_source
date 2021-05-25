package com.avito.android.rating.review_details;

import androidx.annotation.StringRes;
import com.avito.android.image_loader.Picture;
import com.avito.android.ratings.ReviewReplyStatus;
import com.avito.android.remote.model.Sort;
import com.avito.android.tns_gallery.TnsGalleryView;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u001b\u0010\u0012J\u0019\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u001d\u0010\u0012J\u0019\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u001f\u0010\u0012J\u0019\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b!\u0010\u0012J\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0007H&¢\u0006\u0004\b#\u0010\nJ\u0019\u0010$\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0004\b$\u0010\u001aJ\u0019\u0010%\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0004\b%\u0010\u001aJ\u0017\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u000fH&¢\u0006\u0004\b'\u0010\u0012J\u0017\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u000fH&¢\u0006\u0004\b)\u0010\u0012J-\u0010.\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010,\u001a\u0004\u0018\u00010\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000fH&¢\u0006\u0004\b0\u0010\u0012J\u0019\u00103\u001a\u00020\u00032\b\b\u0001\u00102\u001a\u000201H&¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0007H&¢\u0006\u0004\b5\u0010\nR\u0016\u00109\u001a\u0002068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Lcom/avito/android/rating/review_details/ReviewDetailsView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "actionClicks", "", "isLoading", "setLoading", "(Z)V", "", "message", "showSnackbar", "(Ljava/lang/String;)V", "", "name", "setName", "(Ljava/lang/CharSequence;)V", "", "score", "setRating", "(Ljava/lang/Float;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "setMessage", "item", "setItem", Sort.DATE, "setPublicationDate", "stage", "setStage", "show", "showReply", "setReplyUserAvatar", "setReplyShopAvatar", "title", "setReplyTitle", "text", "setReplyText", "Lcom/avito/android/ratings/ReviewReplyStatus;", "replyStatus", "statusText", "rejectedMessage", "setReplyStatus", "(Lcom/avito/android/ratings/ReviewReplyStatus;Ljava/lang/String;Ljava/lang/String;)V", "setReplyDate", "", "resId", "setButtonText", "(I)V", "showButton", "Lcom/avito/android/tns_gallery/TnsGalleryView;", "getGalleryView", "()Lcom/avito/android/tns_gallery/TnsGalleryView;", "galleryView", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface ReviewDetailsView {
    @NotNull
    Observable<Unit> actionClicks();

    @NotNull
    TnsGalleryView getGalleryView();

    @NotNull
    Observable<Unit> navigationClicks();

    void setAvatar(@Nullable Picture picture);

    void setButtonText(@StringRes int i);

    void setItem(@Nullable CharSequence charSequence);

    void setLoading(boolean z);

    void setMessage(@Nullable CharSequence charSequence);

    void setName(@NotNull CharSequence charSequence);

    void setPublicationDate(@Nullable CharSequence charSequence);

    void setRating(@Nullable Float f);

    void setReplyDate(@NotNull CharSequence charSequence);

    void setReplyShopAvatar(@Nullable Picture picture);

    void setReplyStatus(@Nullable ReviewReplyStatus reviewReplyStatus, @Nullable String str, @Nullable String str2);

    void setReplyText(@NotNull CharSequence charSequence);

    void setReplyTitle(@NotNull CharSequence charSequence);

    void setReplyUserAvatar(@Nullable Picture picture);

    void setStage(@Nullable CharSequence charSequence);

    void showButton(boolean z);

    void showReply(boolean z);

    void showSnackbar(@NotNull String str);
}
