package com.avito.android.autodeal_details;

import android.content.Context;
import android.content.Intent;
import com.avito.android.AutoDealDetailsIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/autodeal_details/AutoDealDetailsIntentFactoryImpl;", "Lcom/avito/android/AutoDealDetailsIntentFactory;", "", "url", "Landroid/content/Intent;", "autoDealDetails", "(Ljava/lang/String;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutoDealDetailsIntentFactoryImpl implements AutoDealDetailsIntentFactory {
    public final Context a;

    @Inject
    public AutoDealDetailsIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.AutoDealDetailsIntentFactory
    @NotNull
    public Intent autoDealDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return AutoDealDetailsActivityKt.createAutoDealDetails(this.a, str);
    }
}
