package com.avito.android.autoteka_details;

import android.content.Context;
import android.content.Intent;
import com.avito.android.AutotekaDetailsIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetailsIntentFactoryImpl;", "Lcom/avito/android/AutotekaDetailsIntentFactory;", "", "id", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "autotekaDetails", "utmQuery", "Landroid/content/Intent;", "autotekaDetailsIntent", "(Ljava/lang/String;Lcom/avito/android/remote/model/AutotekaDetailsResponse;Ljava/lang/String;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaDetailsIntentFactoryImpl implements AutotekaDetailsIntentFactory {
    public final Context a;

    @Inject
    public AutotekaDetailsIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.AutotekaDetailsIntentFactory
    @NotNull
    public Intent autotekaDetailsIntent(@NotNull String str, @Nullable AutotekaDetailsResponse autotekaDetailsResponse, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        return AutotekaDetailsActivityKt.createAutotekaDetailsIntent(this.a, str, autotekaDetailsResponse, str2);
    }
}
