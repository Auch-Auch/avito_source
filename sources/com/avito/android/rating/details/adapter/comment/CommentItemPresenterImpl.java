package com.avito.android.rating.details.adapter.comment;

import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.rating.details.adapter.comment.CommentItem;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.TnsGalleryImage;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/rating/details/adapter/comment/CommentItemPresenterImpl;", "Lcom/avito/android/rating/details/adapter/comment/CommentItemPresenter;", "Lcom/avito/android/rating/details/adapter/comment/CommentItemView;", "view", "Lcom/avito/android/rating/details/adapter/comment/CommentItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/rating/details/adapter/comment/CommentItemView;Lcom/avito/android/rating/details/adapter/comment/CommentItem;I)V", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class CommentItemPresenterImpl implements CommentItemPresenter {

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CommentItemView a;
        public final /* synthetic */ CommentItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CommentItemView commentItemView, CommentItem commentItem) {
            super(0);
            this.a = commentItemView;
            this.b = commentItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.setExpanded(true);
            this.a.expandMessage();
            return Unit.INSTANCE;
        }
    }

    public void bindView(@NotNull CommentItemView commentItemView, @NotNull CommentItem commentItem, int i) {
        Intrinsics.checkNotNullParameter(commentItemView, "view");
        Intrinsics.checkNotNullParameter(commentItem, "item");
        commentItemView.setName(commentItem.getName());
        commentItemView.setRating(commentItem.getScore());
        commentItemView.setStage(commentItem.getStage());
        Image avatar = commentItem.getAvatar();
        Picture picture = null;
        commentItemView.setAvatar(avatar != null ? AvitoPictureKt.pictureOf$default(avatar, true, 0.0f, 0.0f, null, 28, null) : null);
        commentItemView.setMessage(commentItem.getMessage(), commentItem.getExpanded());
        commentItemView.setPublicationDate(commentItem.getPublicationDate());
        commentItemView.setItem(commentItem.getItem());
        boolean z = true;
        commentItemView.showReply(commentItem.getReply() != null);
        CommentItem.Reply reply = commentItem.getReply();
        if (reply != null) {
            Image avatar2 = reply.getAvatar();
            if (avatar2 != null) {
                picture = AvitoPictureKt.pictureOf$default(avatar2, true, 0.0f, 0.0f, null, 28, null);
            }
            if (reply.isShop()) {
                commentItemView.setReplyShopAvatar(picture);
            } else {
                commentItemView.setReplyUserAvatar(picture);
            }
            commentItemView.setReplyTitle(reply.getTitle());
            commentItemView.setReplyText(reply.getText());
            commentItemView.setReplyDate(reply.getAnswerDate());
        }
        commentItemView.setExpandClickListener(new a(commentItemView, commentItem));
        List<TnsGalleryImage> images = commentItem.getImages();
        if (images != null && !images.isEmpty()) {
            z = false;
        }
        if (z) {
            commentItemView.getGalleryView().hideGallery();
        } else {
            commentItemView.getGalleryView().showGallery(commentItem.getImages());
        }
    }
}
