package com.avito.android.shop.write_seller;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.shop.remote.ShopsApi;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/shop/write_seller/WriteSellerInteractorImpl;", "Lcom/avito/android/shop/write_seller/WriteSellerInteractor;", "", "shopId", "fromName", "fromMail", "message", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/SuccessResult;", "sendShopFeedback", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/shop/remote/ShopsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/shop/remote/ShopsApi;", "api", "<init>", "(Lcom/avito/android/shop/remote/ShopsApi;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class WriteSellerInteractorImpl implements WriteSellerInteractor {
    public final ShopsApi a;

    public WriteSellerInteractorImpl(@NotNull ShopsApi shopsApi) {
        Intrinsics.checkNotNullParameter(shopsApi, "api");
        this.a = shopsApi;
    }

    @Override // com.avito.android.shop.write_seller.WriteSellerInteractor
    @NotNull
    public Observable<SuccessResult> sendShopFeedback(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        a.b1(str, "shopId", str2, "fromName", str3, "fromMail", str4, "message");
        return this.a.sendShopFeedback(str, str2, str3, str4);
    }
}
