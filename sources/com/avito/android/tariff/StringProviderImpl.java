package com.avito.android.tariff;

import android.content.res.Resources;
import com.avito.android.remote.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/tariff/StringProviderImpl;", "Lcom/avito/android/tariff/StringProvider;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUnknownError", "()Ljava/lang/String;", "unknownError", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class StringProviderImpl implements StringProvider {
    @NotNull
    public final String a;

    @Inject
    public StringProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.unknown_server_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ing.unknown_server_error)");
        this.a = string;
    }

    @Override // com.avito.android.tariff.StringProvider
    @NotNull
    public String getUnknownError() {
        return this.a;
    }
}
