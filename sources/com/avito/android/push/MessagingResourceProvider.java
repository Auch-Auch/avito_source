package com.avito.android.push;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0006R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/push/MessagingResourceProvider;", "", "", "getTitle", "()Ljava/lang/String;", "title", "Impl", "push_release"}, k = 1, mv = {1, 4, 2})
public interface MessagingResourceProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/push/MessagingResourceProvider$Impl;", "Lcom/avito/android/push/MessagingResourceProvider;", "", "getTitle", "()Ljava/lang/String;", "title", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "push_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements MessagingResourceProvider {
        @NotNull
        public final Context a;

        public Impl(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = context;
        }

        @NotNull
        public final Context getContext() {
            return this.a;
        }

        @Override // com.avito.android.push.MessagingResourceProvider
        @NotNull
        public String getTitle() {
            return this.a.getApplicationInfo().loadLabel(this.a.getPackageManager()).toString();
        }
    }

    @NotNull
    String getTitle();
}
