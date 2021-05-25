package com.avito.android.basket_legacy.utils;

import a2.g.r.g;
import android.content.res.Resources;
import com.avito.android.basket.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0019\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\"\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010%\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010(\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006¨\u0006-"}, d2 = {"Lcom/avito/android/basket_legacy/utils/StringProviderImpl;", "Lcom/avito/android/basket_legacy/utils/StringProvider;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getVasTitle", "()Ljava/lang/String;", "vasTitle", AuthSource.BOOKING_ORDER, "getPackagesTitle", "packagesTitle", "f", "getPayButtonText", "payButtonText", "c", "getSingleFeeTitle", "singleFeeTitle", "j", "getOfferTitle", "offerTitle", "h", "getDisclaimerTitle", "disclaimerTitle", "e", "getContinueButtonText", "continueButtonText", "d", "getTotalTemplate", "totalTemplate", "i", "getFeesAgreementPlaceholder", "feesAgreementPlaceholder", "k", "getContinueWithoutVasText", "continueWithoutVasText", "l", "getReturnToAdvertText", "returnToAdvertText", g.a, "getPackageFeePrice", "packageFeePrice", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class StringProviderImpl implements StringProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    @NotNull
    public final String g;
    @NotNull
    public final String h;
    @NotNull
    public final String i;
    @NotNull
    public final String j;
    @NotNull
    public final String k;
    @NotNull
    public final String l;

    @Inject
    public StringProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.vas_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.vas_title)");
        this.a = string;
        String string2 = resources.getString(R.string.packages_title);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.packages_title)");
        this.b = string2;
        String string3 = resources.getString(R.string.single_fee_title);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.single_fee_title)");
        this.c = string3;
        String string4 = resources.getString(R.string.total);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.string.total)");
        this.d = string4;
        String string5 = resources.getString(R.string.button_continue);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.string.button_continue)");
        this.e = string5;
        String string6 = resources.getString(R.string.button_choose_payment_method);
        Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(R.st…on_choose_payment_method)");
        this.f = string6;
        String string7 = resources.getString(R.string.package_fee_count);
        Intrinsics.checkNotNullExpressionValue(string7, "resources.getString(R.string.package_fee_count)");
        this.g = string7;
        String string8 = resources.getString(R.string.basket_fees_agreement_title);
        Intrinsics.checkNotNullExpressionValue(string8, "resources.getString(R.st…ket_fees_agreement_title)");
        this.h = string8;
        String string9 = resources.getString(R.string.basket_fees_agreement_placeholder);
        Intrinsics.checkNotNullExpressionValue(string9, "resources.getString(R.st…es_agreement_placeholder)");
        this.i = string9;
        String string10 = resources.getString(com.avito.android.ui_components.R.string.read_offer);
        Intrinsics.checkNotNullExpressionValue(string10, "resources.getString(ui_R.string.read_offer)");
        this.j = string10;
        String string11 = resources.getString(R.string.basket_proceed_without_vas);
        Intrinsics.checkNotNullExpressionValue(string11, "resources.getString(R.st…sket_proceed_without_vas)");
        this.k = string11;
        String string12 = resources.getString(R.string.basket_return_to_advert);
        Intrinsics.checkNotNullExpressionValue(string12, "resources.getString(R.st….basket_return_to_advert)");
        this.l = string12;
    }

    @Override // com.avito.android.basket_legacy.utils.StringProvider
    @NotNull
    public String getContinueButtonText() {
        return this.e;
    }

    @Override // com.avito.android.basket_legacy.utils.StringProvider
    @NotNull
    public String getContinueWithoutVasText() {
        return this.k;
    }

    @Override // com.avito.android.basket_legacy.utils.StringProvider
    @NotNull
    public String getDisclaimerTitle() {
        return this.h;
    }

    @Override // com.avito.android.basket_legacy.utils.StringProvider
    @NotNull
    public String getFeesAgreementPlaceholder() {
        return this.i;
    }

    @Override // com.avito.android.basket_legacy.utils.StringProvider
    @NotNull
    public String getOfferTitle() {
        return this.j;
    }

    @Override // com.avito.android.basket_legacy.utils.StringProvider
    @NotNull
    public String getPackageFeePrice() {
        return this.g;
    }

    @Override // com.avito.android.basket_legacy.utils.StringProvider
    @NotNull
    public String getPackagesTitle() {
        return this.b;
    }

    @Override // com.avito.android.basket_legacy.utils.StringProvider
    @NotNull
    public String getPayButtonText() {
        return this.f;
    }

    @Override // com.avito.android.basket_legacy.utils.StringProvider
    @NotNull
    public String getReturnToAdvertText() {
        return this.l;
    }

    @Override // com.avito.android.basket_legacy.utils.StringProvider
    @NotNull
    public String getSingleFeeTitle() {
        return this.c;
    }

    @Override // com.avito.android.basket_legacy.utils.StringProvider
    @NotNull
    public String getTotalTemplate() {
        return this.d;
    }

    @Override // com.avito.android.basket_legacy.utils.StringProvider
    @NotNull
    public String getVasTitle() {
        return this.a;
    }
}
