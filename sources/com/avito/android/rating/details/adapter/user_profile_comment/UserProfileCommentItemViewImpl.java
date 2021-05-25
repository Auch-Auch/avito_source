package com.avito.android.rating.details.adapter.user_profile_comment;

import android.app.Activity;
import android.content.Context;
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
import com.avito.android.ratings.ReviewReplyStatus;
import com.avito.android.remote.model.Sort;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.tns_gallery.TnsGalleryView;
import com.avito.android.tns_gallery.TnsGalleryViewImpl;
import com.avito.android.util.Contexts;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010x\u001a\u00020c\u0012\f\u0010{\u001a\b\u0012\u0004\u0012\u00020z0y\u0012\u0006\u0010}\u001a\u00020|\u0012\u0006\u0010\u001a\u00020~¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u001d\u0010\u001a\u001a\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b$\u0010\u001fJ\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0011H\u0016¢\u0006\u0004\b&\u0010'J\u0019\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b)\u0010\u0007J\u0019\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b+\u0010\u0007J\u0019\u0010-\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b-\u0010\u0007J\u0017\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0011H\u0016¢\u0006\u0004\b/\u0010'J\u0019\u00100\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b0\u0010\u000fJ\u0019\u00101\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b1\u0010\u000fJ\u0017\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0003H\u0016¢\u0006\u0004\b3\u0010\u0007J\u0017\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0003H\u0016¢\u0006\u0004\b5\u0010\u0007J#\u00109\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u0001062\b\u00108\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0003H\u0016¢\u0006\u0004\b;\u0010\u0007J\u001f\u0010<\u001a\u00020\u00052\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018H\u0016¢\u0006\u0004\b<\u0010\u001bR\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010D\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010?R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010?R\u0016\u0010L\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010?R\u0016\u0010N\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010?R\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010?R\u0016\u0010Z\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010?R\u0016\u0010\\\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010GR\u0016\u0010^\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010?R\u0016\u0010`\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010GR\u0016\u0010b\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010?R\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010?R\u0016\u0010j\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010UR\u0016\u0010m\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010KR\u001c\u0010s\u001a\u00020n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010v¨\u0006\u0001"}, d2 = {"Lcom/avito/android/rating/details/adapter/user_profile_comment/UserProfileCommentItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/rating/details/adapter/user_profile_comment/UserProfileCommentItemView;", "", "name", "", "setName", "(Ljava/lang/CharSequence;)V", "", "score", "setRating", "(Ljava/lang/Float;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "message", "", PanelStateKt.PANEL_EXPANDED, "setMessage", "(Ljava/lang/CharSequence;Z)V", "expandMessage", "()V", "collapseMessage", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setExpandClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/rating/details/adapter/user_profile_comment/ReviewStatus;", "reviewStatus", "setMessageColorByStatus", "(Lcom/avito/android/rating/details/adapter/user_profile_comment/ReviewStatus;)V", "", "reviewStatusText", "setReviewStatus", "(Ljava/lang/String;)V", "setReviewStatusColor", "isVisible", "setReviewStatusVisibility", "(Z)V", "item", "setItem", Sort.DATE, "setPublicationDate", "stage", "setStage", "show", "showReply", "setReplyUserAvatar", "setReplyShopAvatar", "title", "setReplyTitle", "text", "setReplyText", "Lcom/avito/android/ratings/ReviewReplyStatus;", "replyStatus", "statusText", "setReplyStatus", "(Lcom/avito/android/ratings/ReviewReplyStatus;Ljava/lang/String;)V", "setReplyDate", "setOnClickListener", "Landroid/widget/TextView;", "z", "Landroid/widget/TextView;", "itemTitleView", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "stageView", "s", "nameView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "G", "Lcom/facebook/drawee/view/SimpleDraweeView;", "replyShopAvatar", "K", "replyDate", "I", "replyText", "H", "replyTitle", "Landroidx/recyclerview/widget/RecyclerView;", "C", "Landroidx/recyclerview/widget/RecyclerView;", "gallery", "Landroid/view/ViewGroup;", "D", "Landroid/view/ViewGroup;", "replyContainer", "x", "messageStatusTextView", "w", "messageExpandView", "u", "avatarView", "y", "publicationDateView", "F", "replyUserAvatar", "J", "replyStatusText", "Landroid/view/View;", "B", "Landroid/view/View;", "publicationDateSpace", VKApiConst.VERSION, "messageView", ExifInterface.LONGITUDE_EAST, "replyUserContainer", "", "L", "reviewMaxLines", "Lcom/avito/android/tns_gallery/TnsGalleryView;", "M", "Lcom/avito/android/tns_gallery/TnsGalleryView;", "getGalleryView", "()Lcom/avito/android/tns_gallery/TnsGalleryView;", "galleryView", "Lcom/avito/android/lib/design/rating/RatingBar;", "t", "Lcom/avito/android/lib/design/rating/RatingBar;", "ratingView", "view", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "imageClicks", "Landroid/app/Activity;", "activity", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/view/View;Lio/reactivex/rxjava3/functions/Consumer;Landroid/app/Activity;Lcom/avito/android/Features;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserProfileCommentItemViewImpl extends BaseViewHolder implements UserProfileCommentItemView {
    public final TextView A;
    public final View B;
    public final RecyclerView C;
    public final ViewGroup D;
    public final ViewGroup E;
    public final SimpleDraweeView F;
    public final SimpleDraweeView G;
    public final TextView H;
    public final TextView I;
    public final TextView J;
    public final TextView K;
    public final int L;
    @NotNull
    public final TnsGalleryView M;
    public final TextView s;
    public final RatingBar t;
    public final SimpleDraweeView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            ReviewStatus.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            iArr[3] = 2;
            ReviewStatus.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[2] = 1;
        }
    }

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
        public final /* synthetic */ UserProfileCommentItemViewImpl a;
        public final /* synthetic */ boolean b;

        public b(UserProfileCommentItemViewImpl userProfileCommentItemViewImpl, boolean z) {
            this.a = userProfileCommentItemViewImpl;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Layout layout = this.a.v.getLayout();
            if (layout != null) {
                int lineCount = layout.getLineCount();
                if (!(!(lineCount > 0 && layout.getEllipsisCount(lineCount + -1) == 0 && lineCount <= this.a.L)) || this.b) {
                    this.a.expandMessage();
                } else {
                    this.a.collapseMessage();
                }
            }
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public c(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserProfileCommentItemViewImpl(@NotNull View view, @NotNull Consumer<TnsGalleryItemClickAction> consumer, @NotNull Activity activity, @NotNull Features features) {
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
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.w = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.message_status_text);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.x = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.publication_date);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.y = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.item);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.z = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.stage_title);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
        this.A = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.publication_date_space);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.view.View");
        this.B = findViewById10;
        View findViewById11 = view.findViewById(R.id.images);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById11;
        this.C = recyclerView;
        View findViewById12 = view.findViewById(R.id.reply_container);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById12;
        this.D = viewGroup;
        View findViewById13 = viewGroup.findViewById(R.id.reply_user_container);
        Objects.requireNonNull(findViewById13, "null cannot be cast to non-null type android.view.ViewGroup");
        this.E = (ViewGroup) findViewById13;
        View findViewById14 = viewGroup.findViewById(R.id.reply_user_avatar);
        Objects.requireNonNull(findViewById14, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.F = (SimpleDraweeView) findViewById14;
        View findViewById15 = viewGroup.findViewById(R.id.reply_shop_avatar);
        Objects.requireNonNull(findViewById15, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.G = (SimpleDraweeView) findViewById15;
        View findViewById16 = viewGroup.findViewById(R.id.reply_title);
        Objects.requireNonNull(findViewById16, "null cannot be cast to non-null type android.widget.TextView");
        this.H = (TextView) findViewById16;
        View findViewById17 = viewGroup.findViewById(R.id.reply_text);
        Objects.requireNonNull(findViewById17, "null cannot be cast to non-null type android.widget.TextView");
        this.I = (TextView) findViewById17;
        View findViewById18 = viewGroup.findViewById(R.id.reply_status_text);
        Objects.requireNonNull(findViewById18, "null cannot be cast to non-null type android.widget.TextView");
        this.J = (TextView) findViewById18;
        View findViewById19 = viewGroup.findViewById(R.id.reply_date);
        Objects.requireNonNull(findViewById19, "null cannot be cast to non-null type android.widget.TextView");
        this.K = (TextView) findViewById19;
        this.L = view.getResources().getInteger(R.integer.review_max_lines);
        this.M = new TnsGalleryViewImpl(recyclerView, consumer, activity, features, null, 16, null);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void collapseMessage() {
        this.v.setMaxLines(this.L - 1);
        Views.show(this.w);
        this.v.setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void expandMessage() {
        this.v.setMaxLines(Integer.MAX_VALUE);
        this.v.setEllipsize(null);
        Views.hide(this.w);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    @NotNull
    public TnsGalleryView getGalleryView() {
        return this.M;
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setAvatar(@Nullable Picture picture) {
        SimpleDraweeViewsKt.loadPicture$default(this.u, picture, null, null, 6, null);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setExpandClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.w.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setItem(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.z, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setMessage(@Nullable CharSequence charSequence, boolean z2) {
        this.v.setMaxLines(this.L - 1);
        TextViews.bindText$default(this.v, charSequence, false, 2, null);
        this.v.post(new b(this, z2));
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setMessageColorByStatus(@NotNull ReviewStatus reviewStatus) {
        int i;
        Intrinsics.checkNotNullParameter(reviewStatus, "reviewStatus");
        int ordinal = reviewStatus.ordinal();
        if (ordinal == 2) {
            Context context = this.v.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "messageView.context");
            i = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48);
        } else if (ordinal != 3) {
            Context context2 = this.v.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "messageView.context");
            i = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.black);
        } else {
            Context context3 = this.v.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "messageView.context");
            i = Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.gray48);
        }
        this.v.setTextColor(i);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setName(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "name");
        this.s.setText(charSequence);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setOnClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.itemView.setOnClickListener(null);
        } else {
            this.itemView.setOnClickListener(new c(function0));
        }
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setPublicationDate(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.y, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setRating(@Nullable Float f) {
        this.t.setRating(f != null ? f.floatValue() : 0.0f);
        Views.setVisible(this.t, f != null);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setReplyDate(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, Sort.DATE);
        this.K.setText(charSequence);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setReplyShopAvatar(@Nullable Picture picture) {
        Views.hide(this.F);
        Views.show(this.G);
        SimpleDraweeViewsKt.loadPicture$default(this.G, picture, null, null, 6, null);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setReplyStatus(@Nullable ReviewReplyStatus reviewReplyStatus, @Nullable String str) {
        if (reviewReplyStatus == null || reviewReplyStatus == ReviewReplyStatus.ACTIVE || str == null) {
            Views.hide(this.J);
            Views.show(this.E);
            TextView textView = this.I;
            View view = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "itemView");
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            textView.setTextColor(Contexts.getColorByAttr(context, 16842806));
            return;
        }
        Views.hide(this.E);
        this.J.setText(str);
        TextView textView2 = this.J;
        View view2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        Context context2 = view2.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
        textView2.setTextColor(Contexts.getColorByAttr(context2, reviewReplyStatus == ReviewReplyStatus.MODERATION ? com.avito.android.lib.design.R.attr.black : com.avito.android.lib.design.R.attr.red));
        Views.show(this.J);
        TextView textView3 = this.I;
        View view3 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view3, "itemView");
        Context context3 = view3.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "itemView.context");
        textView3.setTextColor(Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.gray48));
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setReplyText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.I.setText(charSequence);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setReplyTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.H.setText(charSequence);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setReplyUserAvatar(@Nullable Picture picture) {
        Views.hide(this.G);
        Views.show(this.F);
        SimpleDraweeViewsKt.loadPicture$default(this.F, picture, null, null, 6, null);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setReviewStatus(@Nullable String str) {
        TextViews.bindText$default(this.x, str, false, 2, null);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setReviewStatusColor(@NotNull ReviewStatus reviewStatus) {
        int i;
        Intrinsics.checkNotNullParameter(reviewStatus, "reviewStatus");
        if (reviewStatus.ordinal() != 2) {
            Context context = this.v.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "messageView.context");
            i = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.black);
        } else {
            Context context2 = this.v.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "messageView.context");
            i = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.red);
        }
        this.x.setTextColor(i);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setReviewStatusVisibility(boolean z2) {
        Views.setVisible(this.x, z2);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void setStage(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.A, charSequence, false, 2, null);
    }

    @Override // com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView
    public void showReply(boolean z2) {
        Views.setVisible(this.B, !z2);
        Views.setVisible(this.D, z2);
    }
}
