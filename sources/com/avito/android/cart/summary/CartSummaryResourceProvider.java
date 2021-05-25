package com.avito.android.cart.summary;

import android.content.res.Resources;
import com.avito.android.cart.R;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.common.util.UriUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryResourceProvider;", "", "", "d", "Ljava/lang/String;", "getCheckQuantityErrorMsg", "()Ljava/lang/String;", "checkQuantityErrorMsg", "c", "getItemDeletionErrorMsg", "itemDeletionErrorMsg", AuthSource.BOOKING_ORDER, "getCartDataIsCorruptedMessage", "cartDataIsCorruptedMessage", AuthSource.SEND_ABUSE, "getGeneralErrorMessage", "generalErrorMessage", "Landroid/content/res/Resources;", UriUtil.LOCAL_RESOURCE_SCHEME, "<init>", "(Landroid/content/res/Resources;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class CartSummaryResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;

    @Inject
    public CartSummaryResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, UriUtil.LOCAL_RESOURCE_SCHEME);
        String string = resources.getString(R.string.cart_general_error_message);
        Intrinsics.checkNotNullExpressionValue(string, "res.getString(R.string.cart_general_error_message)");
        this.a = string;
        String string2 = resources.getString(R.string.cart_data_corrupted);
        Intrinsics.checkNotNullExpressionValue(string2, "res.getString(R.string.cart_data_corrupted)");
        this.b = string2;
        String string3 = resources.getString(R.string.cart_item_deletion_error_message);
        Intrinsics.checkNotNullExpressionValue(string3, "res.getString(R.string.c…m_deletion_error_message)");
        this.c = string3;
        String string4 = resources.getString(R.string.cart_check_item_quantity_error_message);
        Intrinsics.checkNotNullExpressionValue(string4, "res.getString(R.string.c…m_quantity_error_message)");
        this.d = string4;
    }

    @NotNull
    public final String getCartDataIsCorruptedMessage() {
        return this.b;
    }

    @NotNull
    public final String getCheckQuantityErrorMsg() {
        return this.d;
    }

    @NotNull
    public final String getGeneralErrorMessage() {
        return this.a;
    }

    @NotNull
    public final String getItemDeletionErrorMsg() {
        return this.c;
    }
}
