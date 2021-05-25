package com.avito.android.extended_profile.adapter.header;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.extended_profile.R;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.rating.RatingBar;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.public_profile.remote.model.ProfileCounter;
import com.avito.android.public_profile.ui.SubscribeButtonsView;
import com.avito.android.public_profile.ui.SubscribeButtonsViewImpl;
import com.avito.android.public_profile.ui.SubscriptionsCounterView;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.android.util.Contexts;
import com.avito.android.util.FloatsKt;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010u\u001a\u00020t¢\u0006\u0004\bv\u0010wJ\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J+\u0010\u0019\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00072\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010!H\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010%\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010!H\u0001¢\u0006\u0004\b%\u0010$J\u0010\u0010&\u001a\u00020\u0017H\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0017H\u0001¢\u0006\u0004\b(\u0010'J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070)H\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0007H\u0001¢\u0006\u0004\b,\u0010 J\u0010\u0010-\u001a\u00020\u0017H\u0001¢\u0006\u0004\b-\u0010'J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070)H\u0001¢\u0006\u0004\b.\u0010+J\u0010\u0010/\u001a\u00020\u0007H\u0001¢\u0006\u0004\b/\u0010 J\u0018\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0017H\u0001¢\u0006\u0004\b1\u00102J\u0018\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0017H\u0001¢\u0006\u0004\b4\u00102J\u0018\u00105\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0017H\u0001¢\u0006\u0004\b5\u00102J \u00108\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0017H\u0001¢\u0006\u0004\b8\u00109J\u0018\u0010:\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0017H\u0001¢\u0006\u0004\b:\u00102J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00070;H\u0001¢\u0006\u0004\b<\u0010=J&\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020>2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bH\u0001¢\u0006\u0004\b@\u0010AJZ\u0010L\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020B2\u0006\u0010D\u001a\u00020C2\b\u0010E\u001a\u0004\u0018\u00010B2\u0006\u0010F\u001a\u00020C2\u000e\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b2\u0006\u0010H\u001a\u00020C2\u0006\u0010J\u001a\u00020I2\u0006\u0010\u000b\u001a\u00020KH\u0001¢\u0006\u0004\bL\u0010MJ\u0018\u0010N\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020BH\u0001¢\u0006\u0004\bN\u0010OJ\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00070)H\u0001¢\u0006\u0004\bP\u0010+R\u001e\u0010U\u001a\n R*\u0004\u0018\u00010Q0Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u001e\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u001c\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00070)8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\ba\u0010+R\"\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00070)8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010+R\u0016\u0010h\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010\\R\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\"\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070)8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bm\u0010d\u001a\u0004\bn\u0010+R\u0016\u0010q\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010\\R\u0016\u0010s\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010\\¨\u0006x"}, d2 = {"Lcom/avito/android/extended_profile/adapter/header/HeaderItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/extended_profile/adapter/header/HeaderItemView;", "Lcom/avito/android/public_profile/ui/SubscriptionsCounterView;", "Lcom/avito/android/public_profile/ui/SubscribeButtonsView;", "Lcom/avito/android/image_loader/Picture;", "avatar", "", "showAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "type", "setUserIconType", "(Lcom/avito/android/remote/model/advert_details/UserIconType;)V", "", "name", "showName", "(Ljava/lang/CharSequence;)V", MessengerShareContentUtility.SUBTITLE, "showSubtitle", "", "score", "text", "", "clickable", "showRating", "(Ljava/lang/Float;Ljava/lang/CharSequence;Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Lcom/avito/android/public_profile/remote/model/ProfileCounter;", "counter", "bindSubscribersCounter", "(Lcom/avito/android/public_profile/remote/model/ProfileCounter;)V", "bindSubscriptionsCounter", "canShowSnackbar", "()Z", "closeSubscriptionSettings", "Lio/reactivex/rxjava3/core/Observable;", "dismissEvents", "()Lio/reactivex/rxjava3/core/Observable;", "hideSubscribeButton", "isMenuShowing", "notificationClicks", "openSubscriptionSettings", "isActivated", "setNotificationActivated", "(Z)V", "isLoading", "setNotificationLoading", "setSubscribeLoading", "isSubscribed", "isEnabled", "setSubscribed", "(ZZ)V", "setUnsubscribeLoading", "Lio/reactivex/rxjava3/core/Maybe;", "showEnableNotificationDialog", "()Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;", "errorDialog", "showErrorDialog", "(Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;Lkotlin/jvm/functions/Function0;)V", "", "", "textResId", "actionText", "actionTextResId", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", "showSubscribeButton", "(Ljava/lang/String;)V", "unsubscribeClicks", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "s", "Landroid/content/Context;", "context", "Lcom/avito/android/lib/design/rating/RatingBar;", "x", "Lcom/avito/android/lib/design/rating/RatingBar;", "ratingScoreView", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "nameView", "z", "Lkotlin/jvm/functions/Function0;", "unbindListener", "getSubscribeButtonClicks", "subscribeButtonClicks", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lio/reactivex/rxjava3/core/Observable;", "getAvatarClicks", "avatarClicks", "w", "ratingNumberView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "t", "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarView", "B", "getRatingClicks", "ratingClicks", VKApiConst.VERSION, "subtitleView", "y", "ratingTextView", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderItemViewImpl extends BaseViewHolder implements HeaderItemView, SubscriptionsCounterView, SubscribeButtonsView {
    @NotNull
    public final Observable<Unit> A;
    @NotNull
    public final Observable<Unit> B;
    public final /* synthetic */ SubscriptionsCounterViewImpl C;
    public final /* synthetic */ SubscribeButtonsViewImpl D;
    public final Context s;
    public final SimpleDraweeView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final RatingBar x;
    public final TextView y;
    public Function0<Unit> z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            UserIconType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            UserIconType userIconType = UserIconType.SHOP;
            iArr[2] = 1;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeaderItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.C = new SubscriptionsCounterViewImpl(view);
        this.D = new SubscribeButtonsViewImpl(view, null, 2, null);
        this.s = view.getContext();
        View findViewById = view.findViewById(R.id.avatar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById;
        this.t = simpleDraweeView;
        View findViewById2 = view.findViewById(R.id.name);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.rating_number);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById4;
        this.w = textView;
        View findViewById5 = view.findViewById(R.id.rating_score);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.rating.RatingBar");
        RatingBar ratingBar = (RatingBar) findViewById5;
        this.x = ratingBar;
        View findViewById6 = view.findViewById(R.id.rating_text);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById6;
        this.y = textView2;
        this.A = RxView.clicks(simpleDraweeView);
        Observable<Unit> mergeWith = RxView.clicks(textView).mergeWith(RxView.clicks(ratingBar)).mergeWith(RxView.clicks(textView2));
        Intrinsics.checkNotNullExpressionValue(mergeWith, "ratingNumberView.clicks(…(ratingTextView.clicks())");
        this.B = mergeWith;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsCounterView
    public void bindSubscribersCounter(@Nullable ProfileCounter profileCounter) {
        this.C.bindSubscribersCounter(profileCounter);
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsCounterView
    public void bindSubscriptionsCounter(@Nullable ProfileCounter profileCounter) {
        this.C.bindSubscriptionsCounter(profileCounter);
    }

    @Override // com.avito.android.lib.design.snackbar.util.OptionalSnackbarElementView
    public boolean canShowSnackbar() {
        return this.D.canShowSnackbar();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public boolean closeSubscriptionSettings() {
        return this.D.closeSubscriptionSettings();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> dismissEvents() {
        return this.D.dismissEvents();
    }

    @Override // com.avito.android.extended_profile.adapter.header.HeaderItemView
    @NotNull
    public Observable<Unit> getAvatarClicks() {
        return this.A;
    }

    @Override // com.avito.android.extended_profile.adapter.header.HeaderItemView
    @NotNull
    public Observable<Unit> getRatingClicks() {
        return this.B;
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    @NotNull
    public Observable<Unit> getSubscribeButtonClicks() {
        return this.D.getSubscribeButtonClicks();
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void hideSubscribeButton() {
        this.D.hideSubscribeButton();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public boolean isMenuShowing() {
        return this.D.isMenuShowing();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> notificationClicks() {
        return this.D.notificationClicks();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.z;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void openSubscriptionSettings() {
        this.D.openSubscriptionSettings();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setNotificationActivated(boolean z2) {
        this.D.setNotificationActivated(z2);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setNotificationLoading(boolean z2) {
        this.D.setNotificationLoading(z2);
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void setSubscribeLoading(boolean z2) {
        this.D.setSubscribeLoading(z2);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setSubscribed(boolean z2, boolean z3) {
        this.D.setSubscribed(z2, z3);
    }

    @Override // com.avito.android.extended_profile.adapter.header.HeaderItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.z = function0;
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setUnsubscribeLoading(boolean z2) {
        this.D.setUnsubscribeLoading(z2);
    }

    @Override // com.avito.android.extended_profile.adapter.header.HeaderItemView
    public void setUserIconType(@NotNull UserIconType userIconType) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(userIconType, "type");
        if (userIconType.ordinal() != 2) {
            drawable = null;
        } else {
            Drawable drawable2 = ContextCompat.getDrawable(this.s, com.avito.android.ui_components.R.drawable.ic_shop_48);
            Context context = this.s;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            drawable = Contexts.getTintedDrawable(drawable2, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28));
        }
        ((GenericDraweeHierarchy) this.t.getHierarchy()).setPlaceholderImage(drawable);
    }

    @Override // com.avito.android.extended_profile.adapter.header.HeaderItemView
    public void showAvatar(@Nullable Picture picture) {
        SimpleDraweeViewsKt.loadPicture$default(this.t, picture, null, null, 6, null);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Maybe<Unit> showEnableNotificationDialog() {
        return this.D.showEnableNotificationDialog();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void showErrorDialog(@NotNull ErrorResult.ErrorDialog errorDialog, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(errorDialog, "errorDialog");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.D.showErrorDialog(errorDialog, function0);
    }

    @Override // com.avito.android.extended_profile.adapter.header.HeaderItemView
    public void showName(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.u, charSequence, false, 2, null);
    }

    @Override // com.avito.android.extended_profile.adapter.header.HeaderItemView
    public void showRating(@Nullable Float f, @Nullable CharSequence charSequence, boolean z2) {
        int i;
        boolean z3 = true;
        boolean z4 = f != null;
        Views.setVisible(this.w, z4);
        Views.setVisible(this.x, z4);
        TextView textView = this.w;
        String str = null;
        if (f != null) {
            str = FloatsKt.formatWithSeparator$default(f.floatValue(), null, 0, 3, null);
        }
        textView.setText(str);
        this.x.setFloatingRatingIsEnabled(true);
        this.x.setRating(f != null ? f.floatValue() : 0.0f);
        if (charSequence == null) {
            z3 = false;
        }
        Views.setVisible(this.y, z3);
        this.y.setText(charSequence != null ? charSequence : "");
        TextView textView2 = this.y;
        Context context = this.s;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (charSequence != null) {
            i = z2 ? com.avito.android.lib.design.R.attr.blue : com.avito.android.lib.design.R.attr.black;
        } else {
            i = com.avito.android.lib.design.R.attr.gray28;
        }
        textView2.setTextColor(Contexts.getColorByAttr(context, i));
    }

    @Override // com.avito.android.lib.design.snackbar.util.SnackbarElementView
    public void showSnackbar(@NotNull String str, int i, @Nullable String str2, int i2, @Nullable Function0<Unit> function0, int i3, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        this.D.showSnackbar(str, i, str2, i2, function0, i3, snackbarPosition, snackbarType);
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void showSubscribeButton(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.D.showSubscribeButton(str);
    }

    @Override // com.avito.android.extended_profile.adapter.header.HeaderItemView
    public void showSubtitle(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.v, charSequence, false, 2, null);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> unsubscribeClicks() {
        return this.D.unsubscribeClicks();
    }
}
