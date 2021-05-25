package com.avito.android.shop.write_seller;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00148V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/shop/write_seller/WriteSellerPresenterResourceProviderImpl;", "Lcom/avito/android/shop/write_seller/WriteSellerPresenterResourceProvider;", "", "getMessageSuccessfullySent", "()Ljava/lang/String;", "messageSuccessfullySent", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "", "getFeedbackEmailMaxLength", "()I", "feedbackEmailMaxLength", "getExceedingMessageLengthError", "exceedingMessageLengthError", "getWriteEmail", "writeEmail", "getInputCorrectEmail", "inputCorrectEmail", "Landroid/graphics/drawable/Drawable;", "getIcAbBackNormal", "()Landroid/graphics/drawable/Drawable;", "icAbBackNormal", "<init>", "(Landroid/content/Context;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class WriteSellerPresenterResourceProviderImpl implements WriteSellerPresenterResourceProvider {
    public final Context a;

    public WriteSellerPresenterResourceProviderImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerPresenterResourceProvider
    @NotNull
    public String getExceedingMessageLengthError() {
        String string = this.a.getString(R.string.exceeding_message_length_error);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ing_message_length_error)");
        return string;
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerPresenterResourceProvider
    public int getFeedbackEmailMaxLength() {
        return this.a.getResources().getInteger(R.integer.feedback_email_max_length);
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerPresenterResourceProvider
    @NotNull
    public Drawable getIcAbBackNormal() {
        Drawable drawable = this.a.getDrawable(com.avito.android.ui_components.R.drawable.ic_back_24_blue);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerPresenterResourceProvider
    @NotNull
    public String getInputCorrectEmail() {
        String string = this.a.getString(R.string.input_correct_email);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.input_correct_email)");
        return string;
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerPresenterResourceProvider
    @NotNull
    public String getMessageSuccessfullySent() {
        String string = this.a.getString(R.string.message_successfully_sent);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…essage_successfully_sent)");
        return string;
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerPresenterResourceProvider
    @NotNull
    public String getWriteEmail() {
        String string = this.a.getString(R.string.write_email);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.write_email)");
        return string;
    }
}
