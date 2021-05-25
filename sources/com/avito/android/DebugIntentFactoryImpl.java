package com.avito.android;

import android.content.Context;
import android.content.Intent;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/DebugIntentFactoryImpl;", "Lcom/avito/android/DebugIntentFactory;", "Landroid/content/Intent;", "debugIntent", "()Landroid/content/Intent;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "avito-release_release"}, k = 1, mv = {1, 4, 2})
public final class DebugIntentFactoryImpl implements DebugIntentFactory {
    @Inject
    public DebugIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.avito.android.DebugIntentFactory
    @Nullable
    public Intent debugIntent() {
        return null;
    }
}
