package com.avito.android.rating.review_details;

import a2.g.r.g;
import android.app.Activity;
import android.content.Context;
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
import com.avito.android.ratings.ReviewReplyStatus;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.tns_gallery.TnsGalleryView;
import com.avito.android.tns_gallery.TnsGalleryViewImpl;
import com.avito.android.util.Contexts;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B.\u0012\u0006\u0010g\u001a\u00020d\u0012\f\u0010z\u001a\b\u0012\u0004\u0012\u00020y0x\u0012\u0006\u0010|\u001a\u00020{\u0012\u0006\u0010~\u001a\u00020}¢\u0006\u0005\b\u0010\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u0012J\u0019\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u0012J\u0019\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001f\u0010\u0012J\u0019\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b!\u0010\u0012J\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\nJ\u0019\u0010$\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b$\u0010\u001aJ\u0019\u0010%\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b%\u0010\u001aJ\u0017\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u000fH\u0016¢\u0006\u0004\b'\u0010\u0012J\u0017\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u000fH\u0016¢\u0006\u0004\b)\u0010\u0012J-\u0010.\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010,\u001a\u0004\u0018\u00010\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b0\u0010\u0012J\u0017\u00103\u001a\u00020\u00032\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b5\u0010\nR\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u00108R\u0016\u0010C\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u00108R\u0016\u0010E\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010>R\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010>R\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u00108R\u001c\u0010[\u001a\u00020V8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u00108R\u0016\u0010c\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u00108R\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010i\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u00108R\u0016\u0010k\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u00108R\u0016\u0010m\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010HR\u0016\u0010o\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u00108R\u0016\u0010q\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u00108R\u0016\u0010u\u001a\u00020r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010H¨\u0006\u0001"}, d2 = {"Lcom/avito/android/rating/review_details/ReviewDetailsViewImpl;", "Lcom/avito/android/rating/review_details/ReviewDetailsView;", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "actionClicks", "", "isLoading", "setLoading", "(Z)V", "", "message", "showSnackbar", "(Ljava/lang/String;)V", "", "name", "setName", "(Ljava/lang/CharSequence;)V", "", "score", "setRating", "(Ljava/lang/Float;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "setMessage", "item", "setItem", Sort.DATE, "setPublicationDate", "stage", "setStage", "show", "showReply", "setReplyUserAvatar", "setReplyShopAvatar", "title", "setReplyTitle", "text", "setReplyText", "Lcom/avito/android/ratings/ReviewReplyStatus;", "replyStatus", "statusText", "rejectedMessage", "setReplyStatus", "(Lcom/avito/android/ratings/ReviewReplyStatus;Ljava/lang/String;Ljava/lang/String;)V", "setReplyDate", "", "resId", "setButtonText", "(I)V", "showButton", "Landroid/widget/TextView;", g.a, "Landroid/widget/TextView;", "messageView", "c", "nameView", "Landroid/view/ViewGroup;", "j", "Landroid/view/ViewGroup;", "replyDeclinedContainer", "k", "replyDeclinedText", "h", "publicationDateView", "i", "replyContainer", "Lcom/facebook/drawee/view/SimpleDraweeView;", AuthSource.BOOKING_ORDER, "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarView", "Lcom/avito/android/lib/design/button/Button;", "t", "Lcom/avito/android/lib/design/button/Button;", "actionButton", AuthSource.OPEN_CHANNEL_LIST, "replyUserContainer", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "s", "replyDate", "Lcom/avito/android/tns_gallery/TnsGalleryView;", VKApiConst.VERSION, "Lcom/avito/android/tns_gallery/TnsGalleryView;", "getGalleryView", "()Lcom/avito/android/tns_gallery/TnsGalleryView;", "galleryView", "Lcom/avito/android/lib/design/rating/RatingBar;", "e", "Lcom/avito/android/lib/design/rating/RatingBar;", "ratingView", "l", "replyDeclinedMessage", "p", "replyTitle", "Landroid/view/View;", "w", "Landroid/view/View;", "view", "d", "itemTitleView", "f", "stageView", "o", "replyShopAvatar", VKApiConst.Q, "replyModerationText", "r", "replyText", "Landroidx/recyclerview/widget/RecyclerView;", "u", "Landroidx/recyclerview/widget/RecyclerView;", "gallery", "n", "replyUserAvatar", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "imageClicks", "Landroid/app/Activity;", "activity", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/view/View;Lio/reactivex/rxjava3/functions/Consumer;Landroid/app/Activity;Lcom/avito/android/Features;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewDetailsViewImpl implements ReviewDetailsView {
    public final Toolbar a;
    public final SimpleDraweeView b;
    public final TextView c;
    public final TextView d;
    public final RatingBar e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final ViewGroup i;
    public final ViewGroup j;
    public final TextView k;
    public final TextView l;
    public final ViewGroup m;
    public final SimpleDraweeView n;
    public final SimpleDraweeView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final Button t;
    public final RecyclerView u;
    @NotNull
    public final TnsGalleryView v;
    public final View w;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ReviewReplyStatus.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[2] = 2;
        }
    }

    public ReviewDetailsViewImpl(@NotNull View view, @NotNull Consumer<TnsGalleryItemClickAction> consumer, @NotNull Activity activity, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(consumer, "imageClicks");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(features, "features");
        this.w = view;
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.a = toolbar;
        View findViewById2 = view.findViewById(R.id.avatar);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.b = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(R.id.name);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.item);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.rating);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.rating.RatingBar");
        this.e = (RatingBar) findViewById5;
        View findViewById6 = view.findViewById(R.id.stage_title);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.message);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.g = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.publication_date);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.h = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.reply_container);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById9;
        this.i = viewGroup;
        View findViewById10 = viewGroup.findViewById(R.id.reply_declined_container);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.view.ViewGroup");
        this.j = (ViewGroup) findViewById10;
        View findViewById11 = viewGroup.findViewById(R.id.reply_declined_text);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
        this.k = (TextView) findViewById11;
        View findViewById12 = viewGroup.findViewById(R.id.reply_declined_message);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type android.widget.TextView");
        this.l = (TextView) findViewById12;
        View findViewById13 = viewGroup.findViewById(R.id.reply_user_container);
        Objects.requireNonNull(findViewById13, "null cannot be cast to non-null type android.view.ViewGroup");
        this.m = (ViewGroup) findViewById13;
        View findViewById14 = viewGroup.findViewById(R.id.reply_user_avatar);
        Objects.requireNonNull(findViewById14, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.n = (SimpleDraweeView) findViewById14;
        View findViewById15 = viewGroup.findViewById(R.id.reply_shop_avatar);
        Objects.requireNonNull(findViewById15, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.o = (SimpleDraweeView) findViewById15;
        View findViewById16 = viewGroup.findViewById(R.id.reply_title);
        Objects.requireNonNull(findViewById16, "null cannot be cast to non-null type android.widget.TextView");
        this.p = (TextView) findViewById16;
        View findViewById17 = viewGroup.findViewById(R.id.reply_moderation_text);
        Objects.requireNonNull(findViewById17, "null cannot be cast to non-null type android.widget.TextView");
        this.q = (TextView) findViewById17;
        View findViewById18 = viewGroup.findViewById(R.id.reply_text);
        Objects.requireNonNull(findViewById18, "null cannot be cast to non-null type android.widget.TextView");
        this.r = (TextView) findViewById18;
        View findViewById19 = viewGroup.findViewById(R.id.reply_date);
        Objects.requireNonNull(findViewById19, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById19;
        View findViewById20 = view.findViewById(R.id.action_button);
        Objects.requireNonNull(findViewById20, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.t = (Button) findViewById20;
        View findViewById21 = view.findViewById(R.id.images);
        Objects.requireNonNull(findViewById21, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById21;
        this.u = recyclerView;
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        this.v = new TnsGalleryViewImpl(recyclerView, consumer, activity, features, null, 16, null);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    @NotNull
    public Observable<Unit> actionClicks() {
        return RxView.clicks(this.t);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    @NotNull
    public TnsGalleryView getGalleryView() {
        return this.v;
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return RxToolbar.navigationClicks(this.a);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setAvatar(@Nullable Picture picture) {
        SimpleDraweeViewsKt.loadPicture$default(this.b, picture, null, null, 6, null);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setButtonText(int i2) {
        this.t.setText(i2);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setItem(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.d, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setLoading(boolean z) {
        this.t.setLoading(z);
        this.t.setClickable(!z);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setMessage(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.g, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setName(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "name");
        this.c.setText(charSequence);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setPublicationDate(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.h, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setRating(@Nullable Float f2) {
        this.e.setRating(f2 != null ? f2.floatValue() : 0.0f);
        Views.setVisible(this.e, f2 != null);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setReplyDate(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, Sort.DATE);
        this.s.setText(charSequence);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setReplyShopAvatar(@Nullable Picture picture) {
        Views.hide(this.n);
        Views.show(this.o);
        SimpleDraweeViewsKt.loadPicture$default(this.o, picture, null, null, 6, null);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setReplyStatus(@Nullable ReviewReplyStatus reviewReplyStatus, @Nullable String str, @Nullable String str2) {
        if (reviewReplyStatus != null) {
            int ordinal = reviewReplyStatus.ordinal();
            if (ordinal == 0) {
                Views.hide(this.m);
                Views.hide(this.j);
                TextViews.bindText$default(this.q, str, false, 2, null);
                TextView textView = this.r;
                Context context = this.w.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                textView.setTextColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48));
                return;
            } else if (ordinal == 2) {
                Views.hide(this.q);
                Views.show(this.m);
                Views.setVisible(this.j, (str == null && str2 == null) ? false : true);
                TextViews.bindText$default(this.k, str, false, 2, null);
                TextViews.bindText$default(this.l, str2, false, 2, null);
                TextView textView2 = this.r;
                Context context2 = this.w.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "view.context");
                textView2.setTextColor(Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.gray48));
                return;
            }
        }
        Views.hide(this.j);
        Views.hide(this.q);
        Views.show(this.m);
        TextView textView3 = this.r;
        Context context3 = this.w.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "view.context");
        textView3.setTextColor(Contexts.getColorByAttr(context3, 16842806));
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setReplyText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.r.setText(charSequence);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setReplyTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.p.setText(charSequence);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setReplyUserAvatar(@Nullable Picture picture) {
        Views.hide(this.o);
        Views.show(this.n);
        SimpleDraweeViewsKt.loadPicture$default(this.n, picture, null, null, 6, null);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void setStage(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.f, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void showButton(boolean z) {
        Views.setVisible(this.t, z);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void showReply(boolean z) {
        Views.setVisible(this.i, z);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsView
    public void showSnackbar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.w, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
