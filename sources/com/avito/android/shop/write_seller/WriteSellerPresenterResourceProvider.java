package com.avito.android.shop.write_seller;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0011\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0013\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/shop/write_seller/WriteSellerPresenterResourceProvider;", "", "", "getFeedbackEmailMaxLength", "()I", "feedbackEmailMaxLength", "Landroid/graphics/drawable/Drawable;", "getIcAbBackNormal", "()Landroid/graphics/drawable/Drawable;", "icAbBackNormal", "", "getInputCorrectEmail", "()Ljava/lang/String;", "inputCorrectEmail", "getWriteEmail", "writeEmail", "getExceedingMessageLengthError", "exceedingMessageLengthError", "getMessageSuccessfullySent", "messageSuccessfullySent", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface WriteSellerPresenterResourceProvider {
    @NotNull
    String getExceedingMessageLengthError();

    int getFeedbackEmailMaxLength();

    @NotNull
    Drawable getIcAbBackNormal();

    @NotNull
    String getInputCorrectEmail();

    @NotNull
    String getMessageSuccessfullySent();

    @NotNull
    String getWriteEmail();
}
