package com.avito.android.shop.detailed.item;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.Features;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.public_profile.ui.SubscribeButtonsView;
import com.avito.android.public_profile.ui.SubscribeButtonsViewImpl;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.Sort;
import com.avito.android.shop.R;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.TextViews;
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
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u001d\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\nJ%\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\nJ%\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0016¢\u0006\u0004\b\u001f\u0010\u0017J/\u0010#\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020!2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0016¢\u0006\u0004\b#\u0010$J\u001d\u0010%\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010\u0019J\u001f\u0010(\u001a\u00020\b2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014H\u0016¢\u0006\u0004\b(\u0010&J\u000f\u0010)\u001a\u00020\bH\u0016¢\u0006\u0004\b)\u0010\u0019J\u0010\u0010*\u001a\u00020\bH\u0001¢\u0006\u0004\b*\u0010\u0019J\u001e\u0010+\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0001¢\u0006\u0004\b+\u0010&J\u0018\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b.\u0010/J\u0018\u00100\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0001¢\u0006\u0004\b0\u0010\nJ\u0010\u00101\u001a\u00020\bH\u0001¢\u0006\u0004\b1\u0010\u0019J\u0018\u00102\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0001¢\u0006\u0004\b2\u0010\nJ\u0010\u00103\u001a\u00020\bH\u0001¢\u0006\u0004\b3\u0010\u0019J\u0010\u00104\u001a\u00020\bH\u0001¢\u0006\u0004\b4\u0010\u0019J,\u00106\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014H\u0001¢\u0006\u0004\b6\u0010\u0017J,\u00107\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014H\u0001¢\u0006\u0004\b7\u0010\u0017J\u0010\u00108\u001a\u00020\bH\u0001¢\u0006\u0004\b8\u0010\u0019J\u0010\u0010:\u001a\u000209H\u0001¢\u0006\u0004\b:\u0010;J\u0010\u0010<\u001a\u000209H\u0001¢\u0006\u0004\b<\u0010;J\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020\b0=H\u0001¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020\bH\u0001¢\u0006\u0004\b@\u0010\u0019J\u0010\u0010A\u001a\u000209H\u0001¢\u0006\u0004\bA\u0010;J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0=H\u0001¢\u0006\u0004\bB\u0010?J\u0010\u0010C\u001a\u00020\bH\u0001¢\u0006\u0004\bC\u0010\u0019J\u0018\u0010E\u001a\u00020\b2\u0006\u0010D\u001a\u000209H\u0001¢\u0006\u0004\bE\u0010FJ\u0018\u0010H\u001a\u00020\b2\u0006\u0010G\u001a\u000209H\u0001¢\u0006\u0004\bH\u0010FJ\u0018\u0010I\u001a\u00020\b2\u0006\u0010G\u001a\u000209H\u0001¢\u0006\u0004\bI\u0010FJ \u0010L\u001a\u00020\b2\u0006\u0010J\u001a\u0002092\u0006\u0010K\u001a\u000209H\u0001¢\u0006\u0004\bL\u0010MJ\u0018\u0010N\u001a\u00020\b2\u0006\u0010G\u001a\u000209H\u0001¢\u0006\u0004\bN\u0010FJ\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020\b0OH\u0001¢\u0006\u0004\bP\u0010QJ&\u0010T\u001a\u00020\b2\u0006\u0010S\u001a\u00020R2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0001¢\u0006\u0004\bT\u0010UJZ\u0010_\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010V\u001a\u00020!2\b\u0010W\u001a\u0004\u0018\u00010\u00062\u0006\u0010X\u001a\u00020!2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00142\u0006\u0010Z\u001a\u00020!2\u0006\u0010\\\u001a\u00020[2\u0006\u0010^\u001a\u00020]H\u0001¢\u0006\u0004\b_\u0010`J\u0018\u0010a\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0001¢\u0006\u0004\ba\u0010\nJ\u0016\u0010b\u001a\b\u0012\u0004\u0012\u00020\b0=H\u0001¢\u0006\u0004\bb\u0010?R\u001e\u0010e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u001c\u0010k\u001a\b\u0012\u0004\u0012\u00020\b0=8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\bj\u0010?R\u001e\u0010p\u001a\n m*\u0004\u0018\u00010l0l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010hR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010|\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010hR\u0017\u0010\u0001\u001a\u00020}8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010R\u0018\u0010\u0001\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010hR\u0018\u0010\u0001\u001a\u00020}8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010¨\u0006\u0001"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopGoldItemViewImpl;", "Lcom/avito/android/shop/detailed/item/ShopGoldItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/shop/detailed/item/RatingView;", "Lcom/avito/android/shop/detailed/item/VerificationView;", "Lcom/avito/android/public_profile/ui/SubscribeButtonsView;", "", "name", "", "setName", "(Ljava/lang/String;)V", "Lcom/avito/android/image_loader/Picture;", "logo", "setLogo", "(Lcom/avito/android/image_loader/Picture;)V", Sort.DATE, "setCreationDate", "category", "setCategory", "text", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDescription", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "expandContacts", "()V", "collapseContacts", "clearContacts", "setContactsHandlerName", "location", "clickListener", "showLocation", "", "", "icon", "addContactCell", "(Ljava/lang/CharSequence;ILkotlin/jvm/functions/Function0;)V", "setContactsHandlerListener", "(Lkotlin/jvm/functions/Function0;)V", "hideContactsButton", "setUnbindListener", "onUnbind", "hideRatingScore", "setRatingClickListener", "", "score", "setRatingScore", "(F)V", "setRatingTextActive", "setRatingTextInactive", "setRatingTextNonActionable", "showRatingScore", "showRatings", "title", "setExternalVerification", "setInternalVerification", "showVerification", "", "canShowSnackbar", "()Z", "closeSubscriptionSettings", "Lio/reactivex/rxjava3/core/Observable;", "dismissEvents", "()Lio/reactivex/rxjava3/core/Observable;", "hideSubscribeButton", "isMenuShowing", "notificationClicks", "openSubscriptionSettings", "isActivated", "setNotificationActivated", "(Z)V", "isLoading", "setNotificationLoading", "setSubscribeLoading", "isSubscribed", "isEnabled", "setSubscribed", "(ZZ)V", "setUnsubscribeLoading", "Lio/reactivex/rxjava3/core/Maybe;", "showEnableNotificationDialog", "()Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;", "errorDialog", "showErrorDialog", "(Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;Lkotlin/jvm/functions/Function0;)V", "textResId", "actionText", "actionTextResId", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "type", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", "showSubscribeButton", "unsubscribeClicks", "B", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/widget/TextView;", "w", "Landroid/widget/TextView;", "locationView", "getSubscribeButtonClicks", "subscribeButtonClicks", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/LayoutInflater;", "layoutInflater", "y", "creationDate", "Landroid/view/ViewGroup;", "z", "Landroid/view/ViewGroup;", "contactsContainer", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "logoView", "t", "nameView", "Lru/avito/component/button/Button;", "x", "Lru/avito/component/button/Button;", "showContactsButton", "u", "categoryView", VKApiConst.VERSION, "showDescription", "Landroid/view/View;", "view", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/view/View;Lcom/avito/android/Features;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopGoldItemViewImpl extends BaseViewHolder implements ShopGoldItemView, RatingView, VerificationView, SubscribeButtonsView {
    public final LayoutInflater A;
    public Function0<Unit> B;
    public final /* synthetic */ RatingViewImpl C;
    public final /* synthetic */ VerificationViewImpl D;
    public final /* synthetic */ SubscribeButtonsViewImpl E;
    public final SimpleDraweeView s;
    public final TextView t;
    public final TextView u;
    public final Button v;
    public final TextView w;
    public final Button x;
    public final TextView y;
    public final ViewGroup z;

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

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function0 function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Function0 function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.invoke();
            return Unit.INSTANCE;
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopGoldItemViewImpl(@NotNull View view, @NotNull Features features) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(features, "features");
        this.C = new RatingViewImpl(view, features);
        this.D = new VerificationViewImpl(view);
        this.E = new SubscribeButtonsViewImpl(view, null, 2, null);
        View findViewById = view.findViewById(R.id.logo);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.name);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.category);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.show_description);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.v = new ButtonImpl(findViewById4);
        View findViewById5 = view.findViewById(R.id.location);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.w = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.show_contacts);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.x = new ButtonImpl(findViewById6);
        View findViewById7 = view.findViewById(R.id.creation_date);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.y = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.contacts_container);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.ViewGroup");
        this.z = (ViewGroup) findViewById8;
        this.A = LayoutInflater.from(view.getContext());
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemView
    public void addContactCell(@Nullable CharSequence charSequence, int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "clickListener");
        View inflate = this.A.inflate(R.layout.shop_contact_item, this.z, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        this.z.addView(textView);
        textView.setText(charSequence);
        textView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        textView.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.lib.design.snackbar.util.OptionalSnackbarElementView
    public boolean canShowSnackbar() {
        return this.E.canShowSnackbar();
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemView
    public void clearContacts() {
        this.z.removeAllViews();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public boolean closeSubscriptionSettings() {
        return this.E.closeSubscriptionSettings();
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemView
    public void collapseContacts() {
        Views.hide(this.z);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> dismissEvents() {
        return this.E.dismissEvents();
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemView
    public void expandContacts() {
        Views.show(this.z);
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    @NotNull
    public Observable<Unit> getSubscribeButtonClicks() {
        return this.E.getSubscribeButtonClicks();
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemView
    public void hideContactsButton() {
        ButtonsKt.hide(this.x);
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void hideRatingScore() {
        this.C.hideRatingScore();
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void hideSubscribeButton() {
        this.E.hideSubscribeButton();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public boolean isMenuShowing() {
        return this.E.isMenuShowing();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> notificationClicks() {
        return this.E.notificationClicks();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.B;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void openSubscriptionSettings() {
        this.E.openSubscriptionSettings();
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemView
    public void setCategory(@Nullable String str) {
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemView
    public void setContactsHandlerListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.x.setClickListener(new b(function0));
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemView
    public void setContactsHandlerName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.x.setText(str);
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemView
    public void setCreationDate(@Nullable String str) {
        TextViews.bindText$default(this.y, str, false, 2, null);
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemView
    public void setDescription(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v.setText(str);
        ButtonsKt.show(this.v);
        this.v.setClickListener(new c(function0));
    }

    @Override // com.avito.android.shop.detailed.item.VerificationView
    public void setExternalVerification(@Nullable String str, @Nullable Function0<Unit> function0) {
        this.D.setExternalVerification(str, function0);
    }

    @Override // com.avito.android.shop.detailed.item.VerificationView
    public void setInternalVerification(@Nullable String str, @Nullable Function0<Unit> function0) {
        this.D.setInternalVerification(str, function0);
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemView
    public void setLogo(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "logo");
        Views.show(this.s);
        a2.b.a.a.a.L0(this.s, picture);
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemView
    public void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setNotificationActivated(boolean z2) {
        this.E.setNotificationActivated(z2);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setNotificationLoading(boolean z2) {
        this.E.setNotificationLoading(z2);
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.C.setRatingClickListener(function0);
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingScore(float f) {
        this.C.setRatingScore(f);
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingTextActive(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.C.setRatingTextActive(str);
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingTextInactive() {
        this.C.setRatingTextInactive();
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void setRatingTextNonActionable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.C.setRatingTextNonActionable(str);
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void setSubscribeLoading(boolean z2) {
        this.E.setSubscribeLoading(z2);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setSubscribed(boolean z2, boolean z3) {
        this.E.setSubscribed(z2, z3);
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.B = function0;
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setUnsubscribeLoading(boolean z2) {
        this.E.setUnsubscribeLoading(z2);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Maybe<Unit> showEnableNotificationDialog() {
        return this.E.showEnableNotificationDialog();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void showErrorDialog(@NotNull ErrorResult.ErrorDialog errorDialog, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(errorDialog, "errorDialog");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.E.showErrorDialog(errorDialog, function0);
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemView
    public void showLocation(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "location");
        Intrinsics.checkNotNullParameter(function0, "clickListener");
        Views.show(this.w);
        this.w.setText(str);
        this.w.setOnClickListener(new d(function0));
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void showRatingScore() {
        this.C.showRatingScore();
    }

    @Override // com.avito.android.shop.detailed.item.RatingView
    public void showRatings() {
        this.C.showRatings();
    }

    @Override // com.avito.android.lib.design.snackbar.util.SnackbarElementView
    public void showSnackbar(@NotNull String str, int i, @Nullable String str2, int i2, @Nullable Function0<Unit> function0, int i3, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        this.E.showSnackbar(str, i, str2, i2, function0, i3, snackbarPosition, snackbarType);
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void showSubscribeButton(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.E.showSubscribeButton(str);
    }

    @Override // com.avito.android.shop.detailed.item.VerificationView
    public void showVerification() {
        this.D.showVerification();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> unsubscribeClicks() {
        return this.E.unsubscribeClicks();
    }
}
