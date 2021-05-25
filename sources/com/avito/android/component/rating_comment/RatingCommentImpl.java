package com.avito.android.component.rating_comment;

import a2.g.r.g;
import android.view.View;
import android.widget.TextView;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.rating.RatingBar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.ui_components.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010#\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010\u001e¨\u00060"}, d2 = {"Lcom/avito/android/component/rating_comment/RatingCommentImpl;", "Lcom/avito/android/component/rating_comment/RatingComment;", "", "name", "", "setName", "(Ljava/lang/CharSequence;)V", "", "score", "setRating", "(F)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "message", "setMessage", ErrorBundle.SUMMARY_ENTRY, "setSummary", Sort.DATE, "setPublicationDate", "show", "()V", "hide", "Lcom/avito/android/lib/design/rating/RatingBar;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/rating/RatingBar;", "ratingView", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "messageView", AuthSource.SEND_ABUSE, "nameView", "f", "publicationDateView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "c", "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarView", "Landroid/view/View;", g.a, "Landroid/view/View;", "view", "e", "summaryView", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class RatingCommentImpl implements RatingComment {
    public final TextView a;
    public final RatingBar b;
    public final SimpleDraweeView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final View g;

    public RatingCommentImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.g = view;
        View findViewById = view.findViewById(R.id.name);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.rating);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.rating.RatingBar");
        this.b = (RatingBar) findViewById2;
        View findViewById3 = view.findViewById(R.id.avatar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.c = (SimpleDraweeView) findViewById3;
        View findViewById4 = view.findViewById(R.id.message);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.summary);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.publication_date);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById6;
    }

    @Override // com.avito.android.component.rating_comment.RatingComment
    public void hide() {
        Views.hide(this.g);
    }

    @Override // com.avito.android.component.rating_comment.RatingComment
    public void setAvatar(@Nullable Picture picture) {
        SimpleDraweeViewsKt.loadPicture$default(this.c, picture, null, null, 6, null);
    }

    @Override // com.avito.android.component.rating_comment.RatingComment
    public void setMessage(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.d, charSequence, false, 2, null);
    }

    @Override // com.avito.android.component.rating_comment.RatingComment
    public void setName(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "name");
        this.a.setText(charSequence);
    }

    @Override // com.avito.android.component.rating_comment.RatingComment
    public void setPublicationDate(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.f, charSequence, false, 2, null);
    }

    @Override // com.avito.android.component.rating_comment.RatingComment
    public void setRating(float f2) {
        this.b.setRating(f2);
    }

    @Override // com.avito.android.component.rating_comment.RatingComment
    public void setSummary(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.e, charSequence, false, 2, null);
    }

    @Override // com.avito.android.component.rating_comment.RatingComment
    public void show() {
        Views.show(this.g);
    }
}
