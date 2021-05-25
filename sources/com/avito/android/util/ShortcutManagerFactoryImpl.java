package com.avito.android.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ShortcutManager;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/util/ShortcutManagerFactoryImpl;", "Lcom/avito/android/util/ShortcutManagerFactory;", "Landroid/content/pm/ShortcutManager;", "createShortcutManager", "()Landroid/content/pm/ShortcutManager;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutManagerFactoryImpl implements ShortcutManagerFactory {
    public final Context a;

    public ShortcutManagerFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.util.ShortcutManagerFactory
    @TargetApi(25)
    @NotNull
    public ShortcutManager createShortcutManager() {
        Object systemService = this.a.getSystemService("shortcut");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.pm.ShortcutManager");
        return (ShortcutManager) systemService;
    }
}
