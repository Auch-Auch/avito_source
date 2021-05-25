package com.avito.android.version_conflict;

import android.content.Context;
import android.content.Intent;
import com.avito.android.VersionConflictIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/version_conflict/VersionConflictIntentFactoryImpl;", "Lcom/avito/android/VersionConflictIntentFactory;", "", "validateVersionStatus", "Landroid/content/Intent;", "resolveAppVersionConflictActivity", "(I)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "version-conflict_release"}, k = 1, mv = {1, 4, 2})
public final class VersionConflictIntentFactoryImpl implements VersionConflictIntentFactory {
    @NotNull
    public final Context a;

    @Inject
    public VersionConflictIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @NotNull
    public final Context getContext() {
        return this.a;
    }

    @Override // com.avito.android.VersionConflictIntentFactory
    @NotNull
    public Intent resolveAppVersionConflictActivity(int i) {
        return ResolveAppVersionConflictActivityKt.createResolveAppVersionConflictActivityIntent(this.a, i);
    }
}
