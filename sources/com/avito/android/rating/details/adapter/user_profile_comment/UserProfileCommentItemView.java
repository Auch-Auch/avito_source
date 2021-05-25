package com.avito.android.rating.details.adapter.user_profile_comment;

import com.avito.android.image_loader.Picture;
import com.avito.android.ratings.ReviewReplyStatus;
import com.avito.android.remote.model.Sort;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.tns_gallery.TnsGalleryView;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0012\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u001c\u0010\u0017J\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0010H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b!\u0010\u0006J\u0019\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b#\u0010\u0006J\u0019\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b%\u0010\u0006J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0010H&¢\u0006\u0004\b'\u0010\u001fJ\u0019\u0010(\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b(\u0010\u000eJ\u0019\u0010)\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b)\u0010\u000eJ\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0002H&¢\u0006\u0004\b+\u0010\u0006J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0002H&¢\u0006\u0004\b-\u0010\u0006J#\u00101\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0002H&¢\u0006\u0004\b3\u0010\u0006J\u001f\u00106\u001a\u00020\u00042\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000104H&¢\u0006\u0004\b6\u00107J\u001d\u00108\u001a\u00020\u00042\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000404H&¢\u0006\u0004\b8\u00107J\u000f\u00109\u001a\u00020\u0004H&¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0004H&¢\u0006\u0004\b;\u0010:R\u0016\u0010?\u001a\u00020<8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lcom/avito/android/rating/details/adapter/user_profile_comment/UserProfileCommentItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "name", "", "setName", "(Ljava/lang/CharSequence;)V", "", "score", "setRating", "(Ljava/lang/Float;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "message", "", PanelStateKt.PANEL_EXPANDED, "setMessage", "(Ljava/lang/CharSequence;Z)V", "Lcom/avito/android/rating/details/adapter/user_profile_comment/ReviewStatus;", "reviewStatus", "setMessageColorByStatus", "(Lcom/avito/android/rating/details/adapter/user_profile_comment/ReviewStatus;)V", "", "reviewStatusText", "setReviewStatus", "(Ljava/lang/String;)V", "setReviewStatusColor", "isVisible", "setReviewStatusVisibility", "(Z)V", "item", "setItem", Sort.DATE, "setPublicationDate", "stage", "setStage", "show", "showReply", "setReplyUserAvatar", "setReplyShopAvatar", "title", "setReplyTitle", "text", "setReplyText", "Lcom/avito/android/ratings/ReviewReplyStatus;", "replyStatus", "statusText", "setReplyStatus", "(Lcom/avito/android/ratings/ReviewReplyStatus;Ljava/lang/String;)V", "setReplyDate", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setExpandClickListener", "expandMessage", "()V", "collapseMessage", "Lcom/avito/android/tns_gallery/TnsGalleryView;", "getGalleryView", "()Lcom/avito/android/tns_gallery/TnsGalleryView;", "galleryView", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface UserProfileCommentItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull UserProfileCommentItemView userProfileCommentItemView) {
            ItemView.DefaultImpls.onUnbind(userProfileCommentItemView);
        }
    }

    void collapseMessage();

    void expandMessage();

    @NotNull
    TnsGalleryView getGalleryView();

    void setAvatar(@Nullable Picture picture);

    void setExpandClickListener(@NotNull Function0<Unit> function0);

    void setItem(@Nullable CharSequence charSequence);

    void setMessage(@Nullable CharSequence charSequence, boolean z);

    void setMessageColorByStatus(@NotNull ReviewStatus reviewStatus);

    void setName(@NotNull CharSequence charSequence);

    void setOnClickListener(@Nullable Function0<Unit> function0);

    void setPublicationDate(@Nullable CharSequence charSequence);

    void setRating(@Nullable Float f);

    void setReplyDate(@NotNull CharSequence charSequence);

    void setReplyShopAvatar(@Nullable Picture picture);

    void setReplyStatus(@Nullable ReviewReplyStatus reviewReplyStatus, @Nullable String str);

    void setReplyText(@NotNull CharSequence charSequence);

    void setReplyTitle(@NotNull CharSequence charSequence);

    void setReplyUserAvatar(@Nullable Picture picture);

    void setReviewStatus(@Nullable String str);

    void setReviewStatusColor(@NotNull ReviewStatus reviewStatus);

    void setReviewStatusVisibility(boolean z);

    void setStage(@Nullable CharSequence charSequence);

    void showReply(boolean z);
}
