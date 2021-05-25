package com.avito.android.util;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068W@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/util/PreNougatDataDirectoryProvider;", "Lcom/avito/android/util/DataDirectoryProvider;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Ljava/io/File;", "getDataDir", "()Ljava/io/File;", "dataDir", "<init>", "(Landroid/content/Context;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class PreNougatDataDirectoryProvider implements DataDirectoryProvider {
    public final Context a;

    public PreNougatDataDirectoryProvider(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.util.DataDirectoryProvider
    @SuppressLint({"SdCardPath"})
    @NotNull
    public File getDataDir() {
        StringBuilder L = a.L("/data/data/");
        L.append(this.a.getPackageName());
        return new File(L.toString());
    }
}
