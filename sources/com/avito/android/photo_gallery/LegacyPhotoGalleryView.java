package com.avito.android.photo_gallery;

import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.advert.AdvertCoreView;
import com.avito.android.advert_core.call_methods.AdvertCallMethodsDialogFragment;
import com.avito.android.advert_core.call_methods.CallMethods;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudDialog;
import com.avito.android.advert_core.contactbar.feedback.FeedbackDialog;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.lastclick.LastClick;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Formatter;
import com.avito.android.util.ToastsKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010C\u001a\u00020A\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00060/\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u00020#0/\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010<\u001a\u000209¢\u0006\u0004\bP\u0010QJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u0017\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J9\u0010-\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010\u00062\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020#0/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u00060/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00101R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006R"}, d2 = {"Lcom/avito/android/photo_gallery/LegacyPhotoGalleryView;", "Lcom/avito/android/advert_core/advert/AdvertCoreView;", "", "attach", "()V", "detach", "", BookingInfoActivity.EXTRA_ITEM_ID, "showContactAccessPackage", "(Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "source", "showPhoneCallConfirmation", "(Lcom/avito/android/deep_linking/links/PhoneLink;Ljava/lang/String;)V", "showAntiFraudCheckList", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "state", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showFeedback", "(Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Listener;)V", "getFeedbackState", "()Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "", "isFeedbackSent", "clearFeedbackState", "(Z)V", "dismissProgress", "showProgress", "showSellerNotifiedAboutCall", "Lcom/avito/android/advert_core/call_methods/CallMethods;", "callMethods", "showCallMethods", "(Lcom/avito/android/advert_core/call_methods/CallMethods;)V", "", "e", "showError", "(Ljava/lang/Throwable;)V", "text", "actionTitle", "Lkotlin/Function0;", "action", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "displayMessage", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/avito/android/lib/design/snackbar/SnackbarPosition;)V", "Lcom/avito/android/util/Formatter;", g.a, "Lcom/avito/android/util/Formatter;", "errorFormatter", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "h", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "contactsPresenter", "f", "phoneNumberFormatter", "Lcom/avito/android/photo_gallery/LegacyPhotoGalleryRouter;", "i", "Lcom/avito/android/photo_gallery/LegacyPhotoGalleryRouter;", "router", "Landroidx/fragment/app/FragmentManager;", "d", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/avito/android/util/DialogRouter;", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Landroid/app/Dialog;", AuthSource.SEND_ABUSE, "Landroid/app/Dialog;", "progressDialog", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "Landroidx/appcompat/app/AlertDialog;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/app/AlertDialog;", "phoneCallDialog", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Lcom/avito/android/util/DialogRouter;Lcom/avito/android/util/Formatter;Lcom/avito/android/util/Formatter;Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;Lcom/avito/android/photo_gallery/LegacyPhotoGalleryRouter;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyPhotoGalleryView implements AdvertCoreView {
    public Dialog a;
    public AlertDialog b;
    public final Context c;
    public final FragmentManager d;
    public final DialogRouter e;
    public final Formatter<String> f;
    public final Formatter<Throwable> g;
    public final AdvertContactsPresenter h;
    public final LegacyPhotoGalleryRouter i;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ LegacyPhotoGalleryView a;
        public final /* synthetic */ PhoneLink b;
        public final /* synthetic */ String c;

        public a(LegacyPhotoGalleryView legacyPhotoGalleryView, PhoneLink phoneLink, String str) {
            this.a = legacyPhotoGalleryView;
            this.b = phoneLink;
            this.c = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            LastClick.Updater.update();
            this.a.h.onPhoneCallConfirmed(this.b, this.c);
        }
    }

    public static final class b implements DialogInterface.OnDismissListener {
        public final /* synthetic */ LegacyPhotoGalleryView a;

        public b(LegacyPhotoGalleryView legacyPhotoGalleryView) {
            this.a = legacyPhotoGalleryView;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.a.h.onPhoneCallDismissed();
            LastClick.Updater.update();
        }
    }

    public LegacyPhotoGalleryView(@NotNull Context context, @NotNull FragmentManager fragmentManager, @NotNull DialogRouter dialogRouter, @NotNull Formatter<String> formatter, @NotNull Formatter<Throwable> formatter2, @NotNull AdvertContactsPresenter advertContactsPresenter, @NotNull LegacyPhotoGalleryRouter legacyPhotoGalleryRouter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberFormatter");
        Intrinsics.checkNotNullParameter(formatter2, "errorFormatter");
        Intrinsics.checkNotNullParameter(advertContactsPresenter, "contactsPresenter");
        Intrinsics.checkNotNullParameter(legacyPhotoGalleryRouter, "router");
        this.c = context;
        this.d = fragmentManager;
        this.e = dialogRouter;
        this.f = formatter;
        this.g = formatter2;
        this.h = advertContactsPresenter;
        this.i = legacyPhotoGalleryRouter;
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void attach() {
        AdvertCallMethodsDialogFragment advertCallMethodsDialogFragment = (AdvertCallMethodsDialogFragment) this.d.findFragmentByTag("call_methods_dlg");
        if (advertCallMethodsDialogFragment != null) {
            advertCallMethodsDialogFragment.setCallback(this.h);
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertFeedbackView
    public void clearFeedbackState(boolean z) {
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void detach() {
        AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AdvertCallMethodsDialogFragment advertCallMethodsDialogFragment = (AdvertCallMethodsDialogFragment) this.d.findFragmentByTag("call_methods_dlg");
        if (advertCallMethodsDialogFragment != null) {
            advertCallMethodsDialogFragment.setCallback(null);
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void dismissProgress() {
        Dialog dialog = this.a;
        if (dialog != null) {
            if (dialog != null) {
                dialog.dismiss();
            }
            this.a = null;
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void displayMessage(@NotNull String str, @Nullable String str2, @Nullable Function0<Unit> function0, @NotNull SnackbarPosition snackbarPosition) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        ToastsKt.showToast$default(this.c, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.advert_core.advert.AdvertFeedbackView
    @Nullable
    public FeedbackDialog.State getFeedbackState() {
        return null;
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void showAntiFraudCheckList() {
        new AntiFraudDialog(this.c, this.h).show();
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void showCallMethods(@NotNull CallMethods callMethods) {
        Intrinsics.checkNotNullParameter(callMethods, "callMethods");
        AdvertCallMethodsDialogFragment newInstance = AdvertCallMethodsDialogFragment.Companion.newInstance(callMethods);
        newInstance.setCallback(this.h);
        newInstance.show(this.d, "call_methods_dlg");
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void showContactAccessPackage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.i.showContactAccessPackage(str);
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void showError(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        ToastsKt.showToast$default(this.c, this.g.format(th), 0, 2, (Object) null);
    }

    @Override // com.avito.android.advert_core.advert.AdvertFeedbackView
    public void showFeedback(@NotNull FeedbackDialog.State state, @NotNull FeedbackDialog.Listener listener) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void showPhoneCallConfirmation(@NotNull PhoneLink phoneLink, @NotNull String str) {
        Intrinsics.checkNotNullParameter(phoneLink, "phoneLink");
        Intrinsics.checkNotNullParameter(str, "source");
        AlertDialog alertDialog = this.b;
        if (alertDialog == null || !alertDialog.isShowing()) {
            AlertDialog create = new AlertDialog.Builder(this.c).setTitle(R.string.phone).setMessage(this.f.format(phoneLink.getPhone())).setPositiveButton(com.avito.android.ui_components.R.string.call, new a(this, phoneLink, str)).setOnDismissListener(new b(this)).create();
            this.b = create;
            if (create != null) {
                create.show();
            }
            this.h.onPhoneCallShown(str);
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void showProgress() {
        if (this.a == null) {
            this.a = this.e.showSimpleWaitingDialog();
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void showSellerNotifiedAboutCall() {
        Context context = this.c;
        String string = context.getResources().getString(R.string.advert_seller_notified_about_call);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…ller_notified_about_call)");
        ToastsKt.showToast$default(context, string, 0, 2, (Object) null);
    }
}
