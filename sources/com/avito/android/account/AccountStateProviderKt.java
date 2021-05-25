package com.avito.android.account;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/account/AccountStateProvider;", "Lio/reactivex/rxjava3/core/Observable;", "", "firstNotBlankUserId", "(Lcom/avito/android/account/AccountStateProvider;)Lio/reactivex/rxjava3/core/Observable;", "account-storage_release"}, k = 2, mv = {1, 4, 2})
public final class AccountStateProviderKt {
    @NotNull
    public static final Observable<String> firstNotBlankUserId(@NotNull AccountStateProvider accountStateProvider) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "$this$firstNotBlankUserId");
        Observable<String> take = accountStateProvider.userId().filter(AccountStateProviderKt$firstNotBlankUserId$1.INSTANCE).take(1);
        Intrinsics.checkNotNullExpressionValue(take, "userId()\n        .filter…lank() }\n        .take(1)");
        return take;
    }
}
