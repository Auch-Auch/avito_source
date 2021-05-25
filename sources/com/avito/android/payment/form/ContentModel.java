package com.avito.android.payment.form;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/avito/android/payment/form/ContentModel;", "", "", "c", "Ljava/lang/String;", "getSubmitText", "()Ljava/lang/String;", "submitText", AuthSource.SEND_ABUSE, "getTitle", "title", "Lcom/avito/android/remote/model/text/AttributedText;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/text/AttributedText;", "getInformation", "()Lcom/avito/android/remote/model/text/AttributedText;", "information", "d", "getPaymentSessionId", "paymentSessionId", "e", "getMethodSignature", "methodSignature", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class ContentModel {
    @NotNull
    public final String a;
    @NotNull
    public final AttributedText b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;

    public ContentModel(@NotNull String str, @NotNull AttributedText attributedText, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(attributedText, "information");
        Intrinsics.checkNotNullParameter(str2, "submitText");
        Intrinsics.checkNotNullParameter(str3, "paymentSessionId");
        Intrinsics.checkNotNullParameter(str4, "methodSignature");
        this.a = str;
        this.b = attributedText;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    @NotNull
    public final AttributedText getInformation() {
        return this.b;
    }

    @NotNull
    public final String getMethodSignature() {
        return this.e;
    }

    @NotNull
    public final String getPaymentSessionId() {
        return this.d;
    }

    @NotNull
    public final String getSubmitText() {
        return this.c;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }
}
