package com.avito.android.social;

import android.app.Activity;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u001aJ?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J-\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/avito/android/social/SignInManager;", "Lcom/avito/android/social/IsSocialNetwork;", "", "request", "result", "Landroid/content/Intent;", "data", "Lkotlin/Function1;", "Lcom/avito/android/social/SignInManager$Result;", "", "callback", "", "handleActivityResult", "(IILandroid/content/Intent;Lkotlin/jvm/functions/Function1;)Z", "hasToken", "()Z", "", "getToken", "()Ljava/lang/String;", "getEmail", "Landroid/app/Activity;", "activity", "login", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)V", "logout", "()V", "Result", "social_release"}, k = 1, mv = {1, 4, 2})
public interface SignInManager extends IsSocialNetwork {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @Nullable
        public static String getEmail(@NotNull SignInManager signInManager) {
            return null;
        }

        public static boolean hasToken(@NotNull SignInManager signInManager) {
            String token = signInManager.getToken();
            return !(token == null || token.length() == 0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/social/SignInManager$Result;", "", "<init>", "()V", "Cancel", "Error", "Success", "Lcom/avito/android/social/SignInManager$Result$Success;", "Lcom/avito/android/social/SignInManager$Result$Error;", "Lcom/avito/android/social/SignInManager$Result$Cancel;", "social_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Result {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/social/SignInManager$Result$Cancel;", "Lcom/avito/android/social/SignInManager$Result;", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
        public static final class Cancel extends Result {
            @NotNull
            public static final Cancel INSTANCE = new Cancel();

            public Cancel() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/social/SignInManager$Result$Error;", "Lcom/avito/android/social/SignInManager$Result;", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends Result {
            @NotNull
            public static final Error INSTANCE = new Error();

            public Error() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/social/SignInManager$Result$Success;", "Lcom/avito/android/social/SignInManager$Result;", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
        public static final class Success extends Result {
            @NotNull
            public static final Success INSTANCE = new Success();

            public Success() {
                super(null);
            }
        }

        public Result() {
        }

        public Result(j jVar) {
        }
    }

    @Nullable
    String getEmail();

    @Nullable
    String getToken();

    boolean handleActivityResult(int i, int i2, @Nullable Intent intent, @Nullable Function1<? super Result, Unit> function1);

    boolean hasToken();

    void login(@NotNull Activity activity, @Nullable Function1<? super Result, Unit> function1);

    void logout();
}
