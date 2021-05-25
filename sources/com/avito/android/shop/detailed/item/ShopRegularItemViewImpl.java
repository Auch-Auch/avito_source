package com.avito.android.shop.detailed.item;

import android.content.res.Resources;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.Features;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.list_item.ListItem;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.public_profile.ui.SubscribeButtonsView;
import com.avito.android.public_profile.ui.SubscribeButtonsViewImpl;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.shop.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.ViewTreeObservers;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u001d\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u0019\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\bJ%\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bH\u0016¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bH\u0016¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bH\u0016¢\u0006\u0004\b'\u0010&J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010\fJ\u0017\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010\fJ\u001f\u0010+\u001a\u00020\u00062\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001bH\u0016¢\u0006\u0004\b+\u0010&J\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\bJ\u001d\u0010.\u001a\u00020\u00062\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bH\u0016¢\u0006\u0004\b.\u0010&J\u0010\u0010/\u001a\u00020\u0006H\u0001¢\u0006\u0004\b/\u0010\bJ\u001e\u00100\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bH\u0001¢\u0006\u0004\b0\u0010&J\u0018\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u000201H\u0001¢\u0006\u0004\b3\u00104J\u0018\u00105\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\tH\u0001¢\u0006\u0004\b5\u0010\fJ\u0010\u00106\u001a\u00020\u0006H\u0001¢\u0006\u0004\b6\u0010\bJ\u0018\u00107\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\tH\u0001¢\u0006\u0004\b7\u0010\fJ\u0010\u00108\u001a\u00020\u0006H\u0001¢\u0006\u0004\b8\u0010\bJ\u0010\u00109\u001a\u00020\u0006H\u0001¢\u0006\u0004\b9\u0010\bJ,\u0010:\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001bH\u0001¢\u0006\u0004\b:\u0010\u001eJ,\u0010;\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001bH\u0001¢\u0006\u0004\b;\u0010\u001eJ\u0010\u0010<\u001a\u00020\u0006H\u0001¢\u0006\u0004\b<\u0010\bJ\u0010\u0010>\u001a\u00020=H\u0001¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020=H\u0001¢\u0006\u0004\b@\u0010?J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060AH\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0006H\u0001¢\u0006\u0004\bD\u0010\bJ\u0010\u0010E\u001a\u00020=H\u0001¢\u0006\u0004\bE\u0010?J\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00060AH\u0001¢\u0006\u0004\bF\u0010CJ\u0010\u0010G\u001a\u00020\u0006H\u0001¢\u0006\u0004\bG\u0010\bJ\u0018\u0010I\u001a\u00020\u00062\u0006\u0010H\u001a\u00020=H\u0001¢\u0006\u0004\bI\u0010JJ\u0018\u0010L\u001a\u00020\u00062\u0006\u0010K\u001a\u00020=H\u0001¢\u0006\u0004\bL\u0010JJ\u0018\u0010M\u001a\u00020\u00062\u0006\u0010K\u001a\u00020=H\u0001¢\u0006\u0004\bM\u0010JJ \u0010P\u001a\u00020\u00062\u0006\u0010N\u001a\u00020=2\u0006\u0010O\u001a\u00020=H\u0001¢\u0006\u0004\bP\u0010QJ\u0018\u0010R\u001a\u00020\u00062\u0006\u0010K\u001a\u00020=H\u0001¢\u0006\u0004\bR\u0010JJ\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00060SH\u0001¢\u0006\u0004\bT\u0010UJ&\u0010X\u001a\u00020\u00062\u0006\u0010W\u001a\u00020V2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bH\u0001¢\u0006\u0004\bX\u0010YJZ\u0010c\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010Z\u001a\u00020 2\b\u0010[\u001a\u0004\u0018\u00010\t2\u0006\u0010\\\u001a\u00020 2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b2\u0006\u0010^\u001a\u00020 2\u0006\u0010`\u001a\u00020_2\u0006\u0010b\u001a\u00020aH\u0001¢\u0006\u0004\bc\u0010dJ\u0018\u0010e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\tH\u0001¢\u0006\u0004\be\u0010\fJ\u0016\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00060AH\u0001¢\u0006\u0004\bf\u0010CR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010m\u001a\u00020=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u001e\u0010p\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u001c\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00060A8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\bu\u0010CR\u001e\u0010{\u001a\n x*\u0004\u0018\u00010w0w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u001e\u0010\u001a\n x*\u0004\u0018\u00010|0|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010sR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020=8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010lR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0007\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopRegularItemViewImpl;", "Lcom/avito/android/shop/detailed/item/ShopRegularItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/shop/detailed/item/RatingView;", "Lcom/avito/android/shop/detailed/item/VerificationView;", "Lcom/avito/android/public_profile/ui/SubscribeButtonsView;", "", "t", "()V", "", "name", "setName", "(Ljava/lang/String;)V", "Lcom/avito/android/image_loader/Picture;", "logo", "setLogo", "(Lcom/avito/android/image_loader/Picture;)V", "category", "setCategory", "description", "setDescription", "expandDescription", "collapseDescription", "expandContacts", "clearContacts", "hideContactsButton", "location", "Lkotlin/Function0;", "clickListener", "showLocation", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "text", "", "icon", "addContactCell", "(Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDescriptionListener", "(Lkotlin/jvm/functions/Function0;)V", "setExpandContactsClickListener", "setDescriptionHandlerButtonName", "title", "setAwards", "setUnbindListener", "onUnbind", "onClick", "setAwardsOnClickListener", "hideRatingScore", "setRatingClickListener", "", "score", "setRatingScore", "(F)V", "setRatingTextActive", "setRatingTextInactive", "setRatingTextNonActionable", "showRatingScore", "showRatings", "setExternalVerification", "setInternalVerification", "showVerification", "", "canShowSnackbar", "()Z", "closeSubscriptionSettings", "Lio/reactivex/rxjava3/core/Observable;", "dismissEvents", "()Lio/reactivex/rxjava3/core/Observable;", "hideSubscribeButton", "isMenuShowing", "notificationClicks", "openSubscriptionSettings", "isActivated", "setNotificationActivated", "(Z)V", "isLoading", "setNotificationLoading", "setSubscribeLoading", "isSubscribed", "isEnabled", "setSubscribed", "(ZZ)V", "setUnsubscribeLoading", "Lio/reactivex/rxjava3/core/Maybe;", "showEnableNotificationDialog", "()Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;", "errorDialog", "showErrorDialog", "(Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;Lkotlin/jvm/functions/Function0;)V", "textResId", "actionText", "actionTextResId", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "type", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", "showSubscribeButton", "unsubscribeClicks", "Lcom/avito/android/lib/design/list_item/ListItem;", "y", "Lcom/avito/android/lib/design/list_item/ListItem;", "awardsView", "G", "Z", "descriptionExpanded", "H", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/ViewGroup;", "C", "Landroid/view/ViewGroup;", "contactsContainer", "getSubscribeButtonClicks", "subscribeButtonClicks", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "s", "Landroid/content/res/Resources;", "resources", "Landroid/view/LayoutInflater;", "D", "Landroid/view/LayoutInflater;", "layoutInflater", "Landroid/view/View;", "B", "Landroid/view/View;", "showContactsButton", "Landroid/widget/TextView;", "z", "Landroid/widget/TextView;", "descriptionHandle", ExifInterface.LONGITUDE_EAST, "I", "maxLines", VKApiConst.VERSION, "categoryView", "x", "awardsContainer", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "locationView", "F", "hasAwards", "u", "nameView", "w", "descriptionView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "logoView", "view", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/view/View;Lcom/avito/android/Features;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopRegularItemViewImpl extends BaseViewHolder implements ShopRegularItemView, RatingView, VerificationView, SubscribeButtonsView {
    public final TextView A;
    public final View B;
    public final ViewGroup C;
    public final LayoutInflater D;
    public final int E;
    public boolean F;
    public boolean G;
    public Function0<Unit> H;
    public final /* synthetic */ RatingViewImpl I;
    public final /* synthetic */ VerificationViewImpl J;
    public final /* synthetic */ SubscribeButtonsViewImpl K;
    public final Resources s;
    public final SimpleDraweeView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final ViewGroup x;
    public final ListItem y;
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

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
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

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public d(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public e(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopRegularItemViewImpl(@NotNull View view, @NotNull Features features) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(features, "features");
        this.I = new RatingViewImpl(view, features);
        this.J = new VerificationViewImpl(view);
        this.K = new SubscribeButtonsViewImpl(view, null, 2, null);
        this.s = view.getResources();
        View findViewById = view.findViewById(R.id.logo);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.t = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.name);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.category);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.w = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.awards_container);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.ViewGroup");
        this.x = (ViewGroup) findViewById5;
        View findViewById6 = view.findViewById(R.id.awards_button);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.avito.android.lib.design.list_item.ListItem");
        this.y = (ListItem) findViewById6;
        View findViewById7 = view.findViewById(R.id.description_handle);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.z = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.location);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.A = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.show_contacts);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.View");
        this.B = findViewById9;
        View findViewById10 = view.findViewById(R.id.contacts_container);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.view.ViewGroup");
        this.C = (ViewGroup) findViewById10;
        this.D = LayoutInflater.from(view.getContext());
        this.E = view.getResources().getInteger(com.avito.android.ui_components.R.integer.shop_detailed_description_max_count);
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void addContactCell(@NotNull String str, int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, "clickListener");
        View inflate = this.D.inflate(R.layout.shop_contact_item, this.C, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        this.C.addView(textView);
        textView.setText(str);
        textView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        textView.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.lib.design.snackbar.util.OptionalSnackbarElementView
    public boolean canShowSnackbar() {
        return this.K.canShowSnackbar();
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void clearContacts() {
        this.C.removeAllViews();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public boolean closeSubscriptionSettings() {
        return this.K.closeSubscriptionSettings();
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void collapseDescription() {
        this.w.setMaxLines(this.s.getInteger(com.avito.android.ui_components.R.integer.shop_detailed_description_max_count));
        this.w.setEllipsize(TextUtils.TruncateAt.END);
        this.w.setTextIsSelectable(false);
        this.G = false;
        Views.hide(this.x);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> dismissEvents() {
        return this.K.dismissEvents();
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void expandContacts() {
        Views.hide(this.B);
        Views.show(this.C);
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void expandDescription() {
        this.w.setMaxLines(Integer.MAX_VALUE);
        this.w.setTextIsSelectable(true);
        this.w.setEllipsize(null);
        this.G = true;
        t();
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    @NotNull
    public Observable<Unit> getSubscribeButtonClicks() {
        return this.K.getSubscribeButtonClicks();
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void hideContactsButton() {
        Views.hide(this.B);
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void hideRatingScore() {
        this.I.hideRatingScore();
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void hideSubscribeButton() {
        this.K.hideSubscribeButton();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public boolean isMenuShowing() {
        return this.K.isMenuShowing();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> notificationClicks() {
        return this.K.notificationClicks();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.H;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void openSubscriptionSettings() {
        this.K.openSubscriptionSettings();
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void setAwards(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.y.setTitle(str);
        this.F = true;
        t();
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void setAwardsOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.y.setOnClickListener(new b(function0));
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void setCategory(@Nullable String str) {
        TextViews.bindText$default(this.v, str, false, 2, null);
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void setDescription(@Nullable String str) {
        TextViews.bindText$default(this.w, str, false, 2, null);
        this.w.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.avito.android.shop.detailed.item.ShopRegularItemViewImpl$setDescription$1
            public final /* synthetic */ ShopRegularItemViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int lineCount;
                ViewTreeObserver viewTreeObserver = this.a.w.getViewTreeObserver();
                Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "descriptionView.viewTreeObserver");
                ViewTreeObservers.removeGlobalLayoutListener(viewTreeObserver, this);
                Layout layout = this.a.w.getLayout();
                if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) == 0 && lineCount <= this.a.E) {
                    Views.hide(this.a.z);
                    this.a.G = true;
                    this.a.t();
                }
            }
        });
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void setDescriptionHandlerButtonName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.z.setText(str);
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void setDescriptionListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.z.setOnClickListener(new c(function0));
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void setExpandContactsClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.B.setOnClickListener(new d(function0));
    }

    @Override // com.avito.android.shop.detailed.item.VerificationView
    public void setExternalVerification(@Nullable String str, @Nullable Function0<Unit> function0) {
        this.J.setExternalVerification(str, function0);
    }

    @Override // com.avito.android.shop.detailed.item.VerificationView
    public void setInternalVerification(@Nullable String str, @Nullable Function0<Unit> function0) {
        this.J.setInternalVerification(str, function0);
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void setLogo(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "logo");
        a2.b.a.a.a.L0(this.t, picture);
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setNotificationActivated(boolean z2) {
        this.K.setNotificationActivated(z2);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setNotificationLoading(boolean z2) {
        this.K.setNotificationLoading(z2);
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.I.setRatingClickListener(function0);
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingScore(float f) {
        this.I.setRatingScore(f);
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingTextActive(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.I.setRatingTextActive(str);
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingTextInactive() {
        this.I.setRatingTextInactive();
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingTextNonActionable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.I.setRatingTextNonActionable(str);
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void setSubscribeLoading(boolean z2) {
        this.K.setSubscribeLoading(z2);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setSubscribed(boolean z2, boolean z3) {
        this.K.setSubscribed(z2, z3);
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.H = function0;
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setUnsubscribeLoading(boolean z2) {
        this.K.setUnsubscribeLoading(z2);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Maybe<Unit> showEnableNotificationDialog() {
        return this.K.showEnableNotificationDialog();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void showErrorDialog(@NotNull ErrorResult.ErrorDialog errorDialog, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(errorDialog, "errorDialog");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.K.showErrorDialog(errorDialog, function0);
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemView
    public void showLocation(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "location");
        Intrinsics.checkNotNullParameter(function0, "clickListener");
        TextViews.bindText$default(this.A, str, false, 2, null);
        this.A.setOnClickListener(new e(function0));
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void showRatingScore() {
        this.I.showRatingScore();
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void showRatings() {
        this.I.showRatings();
    }

    @Override // com.avito.android.lib.design.snackbar.util.SnackbarElementView
    public void showSnackbar(@NotNull String str, int i, @Nullable String str2, int i2, @Nullable Function0<Unit> function0, int i3, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        this.K.showSnackbar(str, i, str2, i2, function0, i3, snackbarPosition, snackbarType);
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void showSubscribeButton(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.K.showSubscribeButton(str);
    }

    @Override // com.avito.android.shop.detailed.item.VerificationView
    public void showVerification() {
        this.J.showVerification();
    }

    public final void t() {
        if (!this.F || !this.G) {
            Views.hide(this.x);
        } else {
            Views.show(this.x);
        }
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> unsubscribeClicks() {
        return this.K.unsubscribeClicks();
    }
}
