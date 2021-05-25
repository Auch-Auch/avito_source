package com.avito.android.basket.checkout.viewmodel;

import com.avito.android.remote.model.CheckoutCommitResult;
import com.avito.android.remote.model.CheckoutContentsResult;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/basket/checkout/viewmodel/CheckoutRepository;", "", "", "checkoutContext", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/CheckoutContentsResult;", "getCheckoutContents", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "slugs", "Lcom/avito/android/remote/model/CheckoutCommitResult;", "commitCheckout", "(Ljava/lang/String;Ljava/util/Set;)Lio/reactivex/Observable;", "basket_release"}, k = 1, mv = {1, 4, 2})
public interface CheckoutRepository {
    @NotNull
    Observable<LoadingState<CheckoutCommitResult>> commitCheckout(@NotNull String str, @NotNull Set<String> set);

    @NotNull
    Observable<LoadingState<CheckoutContentsResult>> getCheckoutContents(@NotNull String str);
}
