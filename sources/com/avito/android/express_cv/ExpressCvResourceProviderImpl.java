package com.avito.android.express_cv;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/avito/android/express_cv/ExpressCvResourceProviderImpl;", "Lcom/avito/android/express_cv/ExpressCvResourceProvider;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getProvideValidationErrorMessage", "()Ljava/lang/String;", "provideValidationErrorMessage", "d", "getNewCvDescription", "newCvDescription", "e", "getActivatedCvDescription", "activatedCvDescription", "c", "getActivatedCvDialogTitle", "activatedCvDialogTitle", AuthSource.BOOKING_ORDER, "getNewCvDialogTitle", "newCvDialogTitle", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class ExpressCvResourceProviderImpl implements ExpressCvResourceProvider {
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

    public ExpressCvResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.pretend_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.pretend_error)");
        this.a = string;
        String string2 = resources.getString(R.string.cv_created_title);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.cv_created_title)");
        this.b = string2;
        String string3 = resources.getString(R.string.cv_activated_title);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.cv_activated_title)");
        this.c = string3;
        String string4 = resources.getString(R.string.cv_created_description);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…g.cv_created_description)");
        this.d = string4;
        String string5 = resources.getString(R.string.cv_activated_description);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.st…cv_activated_description)");
        this.e = string5;
    }

    @Override // com.avito.android.express_cv.ExpressCvResourceProvider
    @NotNull
    public String getActivatedCvDescription() {
        return this.e;
    }

    @Override // com.avito.android.express_cv.ExpressCvResourceProvider
    @NotNull
    public String getActivatedCvDialogTitle() {
        return this.c;
    }

    @Override // com.avito.android.express_cv.ExpressCvResourceProvider
    @NotNull
    public String getNewCvDescription() {
        return this.d;
    }

    @Override // com.avito.android.express_cv.ExpressCvResourceProvider
    @NotNull
    public String getNewCvDialogTitle() {
        return this.b;
    }

    @Override // com.avito.android.express_cv.ExpressCvResourceProvider
    @NotNull
    public String getProvideValidationErrorMessage() {
        return this.a;
    }
}
