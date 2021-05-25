package com.avito.android.profile.tfa;

import android.app.Application;
import android.content.Intent;
import com.avito.android.TfaIntentFactory;
import com.avito.android.profile.tfa.settings.TfaSettingsActivityKt;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/profile/tfa/TfaIntentFactoryImpl;", "Lcom/avito/android/TfaIntentFactory;", "", "isEnabled", "", "warning", "Landroid/content/Intent;", "tfaSettingsIntent", "(ZLjava/lang/String;)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class TfaIntentFactoryImpl implements TfaIntentFactory {
    @NotNull
    public final Application a;

    @Inject
    public TfaIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @NotNull
    public final Application getContext() {
        return this.a;
    }

    @Override // com.avito.android.TfaIntentFactory
    @NotNull
    public Intent tfaSettingsIntent(boolean z, @Nullable String str) {
        return TfaSettingsActivityKt.createTfaSettingsActivityIntent(this.a, z, str);
    }
}
