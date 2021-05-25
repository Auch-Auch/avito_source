package com.avito.android.rating.user_review_details;

import a2.g.r.g;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.rating.RatingBar;
import com.avito.android.rating.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.tns_gallery.TnsGalleryView;
import com.avito.android.tns_gallery.TnsGalleryViewImpl;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jakewharton.rxbinding4.appcompat.RxToolbar;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010]\u001a\u00020J\u0012\f\u0010r\u001a\b\u0012\u0004\u0012\u00020q0p\u0012\u0006\u0010t\u001a\u00020s\u0012\u0006\u0010v\u001a\u00020u¢\u0006\u0004\bw\u0010xJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\u0019\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0017\u0010\u000bJ\u0019\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u0019\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u001b\u0010\u000bJ\u0019\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\u0003H\u0016¢\u0006\u0004\b#\u0010!J\u0017\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u001cH\u0016¢\u0006\u0004\b%\u0010\u001fJ\u0019\u0010&\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b&\u0010\u0013J\u0019\u0010(\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b(\u0010\u000bJ\u0019\u0010)\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b)\u0010\u000bJ\u0019\u0010*\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b*\u0010\u0013J\u0017\u0010+\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b+\u0010\u000bR\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010.R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010.R\u0016\u0010=\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u00108R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010.R\u0016\u0010I\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010.R\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u00102R\u0016\u0010Q\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010.R\u0016\u0010S\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010.R\u0016\u0010U\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u00102R\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010.R\u0016\u0010]\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010LR\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u001c\u0010g\u001a\u00020b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0016\u0010i\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010.R\u0016\u0010k\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u00108R\u0016\u0010m\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010.R\u0016\u0010o\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010.¨\u0006y"}, d2 = {"Lcom/avito/android/rating/user_review_details/UserReviewDetailsViewImpl;", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsView;", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "profileClicks", "deleteClicks", "", "name", "setRecipientName", "(Ljava/lang/CharSequence;)V", "", "score", "setRating", "(Ljava/lang/Float;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setRecipientAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "message", "setMessage", "item", "setItem", Sort.DATE, "setPublicationDate", "stage", "setStage", "", "rejectMessage", "setRejectMessage", "(Ljava/lang/String;)V", "showProgress", "()V", "hideProgress", "showError", "reviewStatus", "setReviewStatus", "setRecipientShopAvatar", "text", "setRecipientReply", "setRecipientReplyDate", "setUserAvatar", "setUserName", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "replyText", "Lcom/facebook/drawee/view/SimpleDraweeView;", "e", "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarView", "c", "reviewStatusView", "Landroid/view/ViewGroup;", "o", "Landroid/view/ViewGroup;", "replyContainer", "t", "replyDate", "k", "rejectCard", "Landroidx/recyclerview/widget/RecyclerView;", "n", "Landroidx/recyclerview/widget/RecyclerView;", "gallery", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "f", "messageView", "u", "replyModerationText", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "replyDeclinedContainer", VKApiConst.Q, "replyShopAvatar", "j", "rejectMessageView", "r", "replyTitle", "p", "replyUserAvatar", "Lcom/avito/android/lib/design/rating/RatingBar;", "d", "Lcom/avito/android/lib/design/rating/RatingBar;", "ratingView", AuthSource.BOOKING_ORDER, "nameView", "x", "view", "Lcom/avito/android/lib/design/button/Button;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/lib/design/button/Button;", "deleteReviewButton", "Lcom/avito/android/tns_gallery/TnsGalleryView;", "w", "Lcom/avito/android/tns_gallery/TnsGalleryView;", "getGalleryView", "()Lcom/avito/android/tns_gallery/TnsGalleryView;", "galleryView", "i", "stageView", "l", "profileContainer", g.a, "publicationDateView", "h", "itemTitleView", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "imageClicks", "Landroid/app/Activity;", "activity", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/view/View;Lio/reactivex/rxjava3/functions/Consumer;Landroid/app/Activity;Lcom/avito/android/Features;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserReviewDetailsViewImpl implements UserReviewDetailsView {
    public final Toolbar a;
    public final TextView b;
    public final TextView c;
    public final RatingBar d;
    public final SimpleDraweeView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final ViewGroup k;
    public final ViewGroup l;
    public final Button m;
    public final RecyclerView n;
    public final ViewGroup o;
    public final SimpleDraweeView p;
    public final SimpleDraweeView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final View v;
    @NotNull
    public final TnsGalleryView w;
    public final View x;

    public UserReviewDetailsViewImpl(@NotNull View view, @NotNull Consumer<TnsGalleryItemClickAction> consumer, @NotNull Activity activity, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(consumer, "imageClicks");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(features, "features");
        this.x = view;
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.a = toolbar;
        View findViewById2 = view.findViewById(R.id.name);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.message_status_text);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.rating);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.rating.RatingBar");
        this.d = (RatingBar) findViewById4;
        View findViewById5 = view.findViewById(R.id.avatar);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.e = (SimpleDraweeView) findViewById5;
        View findViewById6 = view.findViewById(R.id.message);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.publication_date);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.g = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.item);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.h = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.stage_title);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
        this.i = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.reject_message);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.widget.TextView");
        this.j = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.reject_card);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.view.ViewGroup");
        this.k = (ViewGroup) findViewById11;
        View findViewById12 = view.findViewById(R.id.reply_user_container);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type android.view.ViewGroup");
        this.l = (ViewGroup) findViewById12;
        View findViewById13 = view.findViewById(R.id.action_button);
        Objects.requireNonNull(findViewById13, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById13;
        this.m = button;
        View findViewById14 = view.findViewById(R.id.images);
        Objects.requireNonNull(findViewById14, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById14;
        this.n = recyclerView;
        View findViewById15 = view.findViewById(R.id.reply_container);
        Objects.requireNonNull(findViewById15, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById15;
        this.o = viewGroup;
        View findViewById16 = viewGroup.findViewById(R.id.reply_user_avatar);
        Objects.requireNonNull(findViewById16, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.p = (SimpleDraweeView) findViewById16;
        View findViewById17 = viewGroup.findViewById(R.id.reply_shop_avatar);
        Objects.requireNonNull(findViewById17, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.q = (SimpleDraweeView) findViewById17;
        View findViewById18 = viewGroup.findViewById(R.id.reply_title);
        Objects.requireNonNull(findViewById18, "null cannot be cast to non-null type android.widget.TextView");
        this.r = (TextView) findViewById18;
        View findViewById19 = viewGroup.findViewById(R.id.reply_text);
        Objects.requireNonNull(findViewById19, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById19;
        View findViewById20 = viewGroup.findViewById(R.id.reply_date);
        Objects.requireNonNull(findViewById20, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById20;
        View findViewById21 = viewGroup.findViewById(R.id.reply_moderation_text);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "replyContainer.findViewB…id.reply_moderation_text)");
        TextView textView = (TextView) findViewById21;
        this.u = textView;
        View findViewById22 = viewGroup.findViewById(R.id.reply_declined_container);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "replyContainer.findViewB…reply_declined_container)");
        this.v = findViewById22;
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24_black);
        button.setText(R.string.delete_review);
        Views.show(viewGroup);
        Views.hide(textView);
        Views.hide(findViewById22);
        this.w = new TnsGalleryViewImpl(recyclerView, consumer, activity, features, null, 16, null);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    @NotNull
    public Observable<Unit> deleteClicks() {
        return RxView.clicks(this.m);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    @NotNull
    public TnsGalleryView getGalleryView() {
        return this.w;
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void hideProgress() {
        this.m.setLoading(false);
        this.m.setClickable(true);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return RxToolbar.navigationClicks(this.a);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    @NotNull
    public Observable<Unit> profileClicks() {
        return RxView.clicks(this.l);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void setItem(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.h, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void setMessage(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.f, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void setPublicationDate(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.g, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void setRating(@Nullable Float f2) {
        this.d.setRating(f2 != null ? f2.floatValue() : 0.0f);
        Views.setVisible(this.d, f2 != null);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void setRecipientAvatar(@Nullable Picture picture) {
        Views.hide(this.q);
        Views.show(this.p);
        SimpleDraweeViewsKt.loadPicture$default(this.p, picture, null, null, 6, null);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void setRecipientName(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "name");
        this.r.setText(charSequence);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void setRecipientReply(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.s, charSequence, false, 2, null);
        Views.changePadding$default(this.s, 0, 0, 0, 0, 13, null);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void setRecipientReplyDate(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.t, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void setRecipientShopAvatar(@Nullable Picture picture) {
        Views.hide(this.p);
        Views.show(this.q);
        SimpleDraweeViewsKt.loadPicture$default(this.q, picture, null, null, 6, null);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void setRejectMessage(@Nullable String str) {
        this.j.setText(str);
        Views.setVisible(this.k, str != null);
        TextView textView = this.f;
        Views.changePadding$default(textView, 0, textView.getResources().getDimensionPixelOffset(R.dimen.user_review_text_padding_regular), 0, 0, 13, null);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void setReviewStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reviewStatus");
        TextViews.bindText$default(this.c, str, false, 2, null);
        Views.changePadding$default(this.f, 0, 0, 0, 0, 13, null);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void setStage(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.i, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void setUserAvatar(@Nullable Picture picture) {
        SimpleDraweeViewsKt.loadPicture$default(this.e, picture, null, null, 6, null);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void setUserName(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "name");
        this.b.setText(charSequence);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void showError() {
        Views.showSnackBar$default(this.x, R.string.review_delete_error, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsView
    public void showProgress() {
        this.m.setLoading(true);
        this.m.setClickable(false);
    }
}
