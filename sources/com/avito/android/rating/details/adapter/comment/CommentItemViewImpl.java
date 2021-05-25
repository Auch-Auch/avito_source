package com.avito.android.rating.details.adapter.comment;

import android.app.Activity;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.rating.RatingBar;
import com.avito.android.rating.R;
import com.avito.android.remote.model.Sort;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.tns_gallery.TnsGalleryView;
import com.avito.android.tns_gallery.TnsGalleryViewImpl;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010a\u001a\u000204\u0012\f\u0010d\u001a\b\u0012\u0004\u0012\u00020c0b\u0012\u0006\u0010f\u001a\u00020e\u0012\u0006\u0010h\u001a\u00020g¢\u0006\u0004\bi\u0010jJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u0007J\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u0007J\u0019\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b!\u0010\u0007J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0011H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b%\u0010\u000fJ\u0019\u0010&\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b&\u0010\u000fJ\u0017\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0004\b(\u0010\u0007J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0003H\u0016¢\u0006\u0004\b*\u0010\u0007J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b+\u0010\u0007R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010;\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010.R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u00102R\u0016\u0010C\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010.R\u0016\u0010E\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010.R\u0016\u0010G\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010.R\u0016\u0010I\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010.R\u0016\u0010K\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u00102R\u001c\u0010Q\u001a\u00020L8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010.R\u0016\u0010Y\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010.R\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_¨\u0006k"}, d2 = {"Lcom/avito/android/rating/details/adapter/comment/CommentItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/rating/details/adapter/comment/CommentItemView;", "", "name", "", "setName", "(Ljava/lang/CharSequence;)V", "", "score", "setRating", "(Ljava/lang/Float;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "message", "", PanelStateKt.PANEL_EXPANDED, "setMessage", "(Ljava/lang/CharSequence;Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setExpandClickListener", "(Lkotlin/jvm/functions/Function0;)V", "expandMessage", "()V", "collapseMessage", "item", "setItem", Sort.DATE, "setPublicationDate", "stage", "setStage", "show", "showReply", "(Z)V", "setReplyUserAvatar", "setReplyShopAvatar", "title", "setReplyTitle", "text", "setReplyText", "setReplyDate", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "nameView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "u", "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarView", "Landroid/view/View;", "w", "Landroid/view/View;", "messageExpandView", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "publicationDateSpace", VKApiConst.VERSION, "messageView", "Landroidx/recyclerview/widget/RecyclerView;", "B", "Landroidx/recyclerview/widget/RecyclerView;", "gallery", ExifInterface.LONGITUDE_EAST, "replyShopAvatar", "F", "replyTitle", "x", "publicationDateView", "z", "stageView", "y", "itemTitleView", "D", "replyUserAvatar", "Lcom/avito/android/tns_gallery/TnsGalleryView;", "J", "Lcom/avito/android/tns_gallery/TnsGalleryView;", "getGalleryView", "()Lcom/avito/android/tns_gallery/TnsGalleryView;", "galleryView", "Lcom/avito/android/lib/design/rating/RatingBar;", "t", "Lcom/avito/android/lib/design/rating/RatingBar;", "ratingView", "H", "replyDate", "G", "replyText", "", "I", "reviewMaxLines", "Landroid/view/ViewGroup;", "C", "Landroid/view/ViewGroup;", "replyContainer", "view", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "imageClicks", "Landroid/app/Activity;", "activity", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/view/View;Lio/reactivex/rxjava3/functions/Consumer;Landroid/app/Activity;Lcom/avito/android/Features;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class CommentItemViewImpl extends BaseViewHolder implements CommentItemView {
    public final View A;
    public final RecyclerView B;
    public final ViewGroup C;
    public final SimpleDraweeView D;
    public final SimpleDraweeView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final int I;
    @NotNull
    public final TnsGalleryView J;
    public final TextView s;
    public final RatingBar t;
    public final SimpleDraweeView u;
    public final TextView v;
    public final View w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CommentItemViewImpl a;
        public final /* synthetic */ boolean b;

        public b(CommentItemViewImpl commentItemViewImpl, boolean z) {
            this.a = commentItemViewImpl;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Layout layout = this.a.v.getLayout();
            if (layout != null) {
                int lineCount = layout.getLineCount();
                if (!(!(lineCount > 0 && layout.getEllipsisCount(lineCount + -1) == 0 && lineCount <= this.a.I)) || this.b) {
                    this.a.expandMessage();
                } else {
                    this.a.collapseMessage();
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentItemViewImpl(@NotNull View view, @NotNull Consumer<TnsGalleryItemClickAction> consumer, @NotNull Activity activity, @NotNull Features features) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(consumer, "imageClicks");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(features, "features");
        View findViewById = view.findViewById(R.id.name);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.rating);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.rating.RatingBar");
        this.t = (RatingBar) findViewById2;
        View findViewById3 = view.findViewById(R.id.avatar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.u = (SimpleDraweeView) findViewById3;
        View findViewById4 = view.findViewById(R.id.message);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.expand_message);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.w = findViewById5;
        View findViewById6 = view.findViewById(R.id.publication_date);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.x = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.item);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.y = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.stage_title);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.z = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.publication_date_space);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.View");
        this.A = findViewById9;
        View findViewById10 = view.findViewById(R.id.images);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById10;
        this.B = recyclerView;
        View findViewById11 = view.findViewById(R.id.reply_container);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById11;
        this.C = viewGroup;
        View findViewById12 = viewGroup.findViewById(R.id.reply_user_avatar);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.D = (SimpleDraweeView) findViewById12;
        View findViewById13 = viewGroup.findViewById(R.id.reply_shop_avatar);
        Objects.requireNonNull(findViewById13, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.E = (SimpleDraweeView) findViewById13;
        View findViewById14 = viewGroup.findViewById(R.id.reply_title);
        Objects.requireNonNull(findViewById14, "null cannot be cast to non-null type android.widget.TextView");
        this.F = (TextView) findViewById14;
        View findViewById15 = viewGroup.findViewById(R.id.reply_text);
        Objects.requireNonNull(findViewById15, "null cannot be cast to non-null type android.widget.TextView");
        this.G = (TextView) findViewById15;
        View findViewById16 = viewGroup.findViewById(R.id.reply_date);
        Objects.requireNonNull(findViewById16, "null cannot be cast to non-null type android.widget.TextView");
        this.H = (TextView) findViewById16;
        this.I = view.getResources().getInteger(R.integer.review_max_lines);
        this.J = new TnsGalleryViewImpl(recyclerView, consumer, activity, features, null, 16, null);
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void collapseMessage() {
        this.v.setMaxLines(this.I - 1);
        Views.show(this.w);
        this.v.setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void expandMessage() {
        this.v.setMaxLines(Integer.MAX_VALUE);
        this.v.setEllipsize(null);
        Views.hide(this.w);
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    @NotNull
    public TnsGalleryView getGalleryView() {
        return this.J;
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void setAvatar(@Nullable Picture picture) {
        SimpleDraweeViewsKt.loadPicture$default(this.u, picture, null, null, 6, null);
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void setExpandClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.w.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void setItem(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.y, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void setMessage(@Nullable CharSequence charSequence, boolean z2) {
        TextViews.bindText$default(this.v, charSequence, false, 2, null);
        this.v.post(new b(this, z2));
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void setName(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "name");
        this.s.setText(charSequence);
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void setPublicationDate(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.x, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void setRating(@Nullable Float f) {
        this.t.setRating(f != null ? f.floatValue() : 0.0f);
        Views.setVisible(this.t, f != null);
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void setReplyDate(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, Sort.DATE);
        this.H.setText(charSequence);
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void setReplyShopAvatar(@Nullable Picture picture) {
        Views.hide(this.D);
        Views.show(this.E);
        SimpleDraweeViewsKt.loadPicture$default(this.E, picture, null, null, 6, null);
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void setReplyText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.G.setText(charSequence);
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void setReplyTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.F.setText(charSequence);
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void setReplyUserAvatar(@Nullable Picture picture) {
        Views.hide(this.E);
        Views.show(this.D);
        SimpleDraweeViewsKt.loadPicture$default(this.D, picture, null, null, 6, null);
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void setStage(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.z, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.details.adapter.comment.CommentItemView
    public void showReply(boolean z2) {
        Views.setVisible(this.A, !z2);
        Views.setVisible(this.C, z2);
    }
}
