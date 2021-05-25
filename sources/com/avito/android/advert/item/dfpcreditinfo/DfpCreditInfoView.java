package com.avito.android.advert.item.dfpcreditinfo;

import android.net.Uri;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton;
import com.avito.android.advert.item.dfpcreditinfo.calculator.Type;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJg\u0010)\u001a\u00020\u00062\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00020\u001f2\u0006\u0010\"\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020 0#2\b\u0010%\u001a\u0004\u0018\u00010\u00022\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00020\u001f2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H&¢\u0006\u0004\b)\u0010*J'\u0010-\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0002H&¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0004H&¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0006H&¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0006H&¢\u0006\u0004\b3\u00102J\u0019\u00105\u001a\u00020\u00062\b\b\u0002\u00104\u001a\u00020\u0004H&¢\u0006\u0004\b5\u0010\u0018J\u000f\u00106\u001a\u00020\u0006H&¢\u0006\u0004\b6\u00102¨\u00067"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfoView;", "", "", "title", "", "isBig", "", "setTitle", "(Ljava/lang/String;Z)V", "text", "isMedium", "setText", "setTitleWithPrice", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "setIcon", "(Landroid/net/Uri;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;)V", "force", "dismissDialog", "(Z)V", "showLegalInfoDialog", "(Ljava/lang/String;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/calculator/Type;", "type", "initializeCalculator", "(Lcom/avito/android/advert/item/dfpcreditinfo/calculator/Type;)V", "Lkotlin/Pair;", "", "initialPayment", FirebaseAnalytics.Param.TERM, "", "terms", "inputHint", "loan", "monthlyPayment", "percent", "setCalculatorData", "(Lkotlin/Pair;ILjava/util/List;Ljava/lang/String;Lkotlin/Pair;Ljava/lang/String;Ljava/lang/String;)V", ShareConstants.WEB_DIALOG_PARAM_PRIVACY, "privacyLink", "showButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isEditing", "()Z", "clearFocus", "()V", "hideContent", "isShowTopDivider", "showAdContent", "showStubContent", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface DfpCreditInfoView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void showAdContent$default(DfpCreditInfoView dfpCreditInfoView, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                dfpCreditInfoView.showAdContent(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAdContent");
        }
    }

    void clearFocus();

    void dismissDialog(boolean z);

    void hideContent();

    void initializeCalculator(@NotNull Type type);

    boolean isEditing();

    void setCalculatorData(@NotNull Pair<Integer, String> pair, int i, @NotNull List<Integer> list, @Nullable String str, @NotNull Pair<Integer, String> pair2, @NotNull String str2, @NotNull String str3);

    void setIcon(@Nullable Uri uri);

    void setListener(@NotNull DfpCreditButton.Listener listener);

    void setText(@NotNull String str, boolean z);

    void setTitle(@NotNull String str, boolean z);

    void setTitleWithPrice(@NotNull String str, @NotNull String str2);

    void showAdContent(boolean z);

    void showButton(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void showLegalInfoDialog(@NotNull String str);

    void showStubContent();
}
