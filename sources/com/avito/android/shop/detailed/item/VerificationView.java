package com.avito.android.shop.detailed.item;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J+\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/shop/detailed/item/VerificationView;", "", "", "title", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setInternalVerification", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "setExternalVerification", "showVerification", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface VerificationView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.shop.detailed.item.VerificationView */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setExternalVerification$default(VerificationView verificationView, String str, Function0 function0, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    function0 = null;
                }
                verificationView.setExternalVerification(str, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setExternalVerification");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.shop.detailed.item.VerificationView */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setInternalVerification$default(VerificationView verificationView, String str, Function0 function0, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    function0 = null;
                }
                verificationView.setInternalVerification(str, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setInternalVerification");
        }
    }

    void setExternalVerification(@Nullable String str, @Nullable Function0<Unit> function0);

    void setInternalVerification(@Nullable String str, @Nullable Function0<Unit> function0);

    void showVerification();
}
