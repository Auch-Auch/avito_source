package com.avito.android.async_phone;

import com.avito.android.analytics.event.ContactSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/async_phone/AsyncPhoneAuthRouter;", "", "Lcom/avito/android/async_phone/AsyncPhoneItem;", "item", "", "src", "Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "", "showAuth", "(Lcom/avito/android/async_phone/AsyncPhoneItem;Ljava/lang/String;Lcom/avito/android/analytics/event/ContactSource;)V", "(Ljava/lang/String;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface AsyncPhoneAuthRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void showAuth(@NotNull AsyncPhoneAuthRouter asyncPhoneAuthRouter, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "src");
        }
    }

    void showAuth(@NotNull AsyncPhoneItem asyncPhoneItem, @NotNull String str, @NotNull ContactSource contactSource);

    void showAuth(@NotNull String str);
}
