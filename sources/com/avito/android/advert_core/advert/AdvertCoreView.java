package com.avito.android.advert_core.advert;

import com.avito.android.advert_core.call_methods.CallMethods;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ?\u0010!\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001d2\b\b\u0002\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/avito/android/advert_core/advert/AdvertCoreView;", "Lcom/avito/android/advert_core/advert/AdvertFeedbackView;", "", "attach", "()V", "detach", "", BookingInfoActivity.EXTRA_ITEM_ID, "showContactAccessPackage", "(Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "source", "showPhoneCallConfirmation", "(Lcom/avito/android/deep_linking/links/PhoneLink;Ljava/lang/String;)V", "showAntiFraudCheckList", "dismissProgress", "showProgress", "showSellerNotifiedAboutCall", "Lcom/avito/android/advert_core/call_methods/CallMethods;", "callMethods", "showCallMethods", "(Lcom/avito/android/advert_core/call_methods/CallMethods;)V", "", "e", "showError", "(Ljava/lang/Throwable;)V", "text", "actionTitle", "Lkotlin/Function0;", "action", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "displayMessage", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/avito/android/lib/design/snackbar/SnackbarPosition;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertCoreView extends AdvertFeedbackView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.avito.android.advert_core.advert.AdvertCoreView */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void displayMessage$default(AdvertCoreView advertCoreView, String str, String str2, Function0 function0, SnackbarPosition snackbarPosition, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    function0 = null;
                }
                if ((i & 8) != 0) {
                    snackbarPosition = SnackbarPosition.OVERLAY_VIEW_TOP;
                }
                advertCoreView.displayMessage(str, str2, function0, snackbarPosition);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: displayMessage");
        }
    }

    void attach();

    void detach();

    void dismissProgress();

    void displayMessage(@NotNull String str, @Nullable String str2, @Nullable Function0<Unit> function0, @NotNull SnackbarPosition snackbarPosition);

    void showAntiFraudCheckList();

    void showCallMethods(@NotNull CallMethods callMethods);

    void showContactAccessPackage(@NotNull String str);

    void showError(@NotNull Throwable th);

    void showPhoneCallConfirmation(@NotNull PhoneLink phoneLink, @NotNull String str);

    void showProgress();

    void showSellerNotifiedAboutCall();
}
