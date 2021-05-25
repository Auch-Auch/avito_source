package com.avito.android.app_rater;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/app_rater/AppRaterSessionContract;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getLAST_SHOW_TIMESTAMP", "()Ljava/lang/String;", "LAST_SHOW_TIMESTAMP", "<init>", "()V", "app-rater_release"}, k = 1, mv = {1, 4, 2})
public final class AppRaterSessionContract {
    @NotNull
    public static final AppRaterSessionContract INSTANCE = new AppRaterSessionContract();
    @NotNull
    public static final String a = a.c3("app_rater_", "last_show_seller");

    @NotNull
    public final String getLAST_SHOW_TIMESTAMP() {
        return a;
    }
}
