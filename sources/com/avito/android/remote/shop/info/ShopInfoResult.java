package com.avito.android.remote.shop.info;

import com.avito.android.remote.auth.AuthSource;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/shop/info/ShopInfoResult;", "", "<init>", "()V", "NotFound", "Ok", "Lcom/avito/android/remote/shop/info/ShopInfoResult$Ok;", "Lcom/avito/android/remote/shop/info/ShopInfoResult$NotFound;", "shop_release"}, k = 1, mv = {1, 4, 2})
public abstract class ShopInfoResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/shop/info/ShopInfoResult$NotFound;", "Lcom/avito/android/remote/shop/info/ShopInfoResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
    public static final class NotFound extends ShopInfoResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotFound(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/shop/info/ShopInfoResult$Ok;", "Lcom/avito/android/remote/shop/info/ShopInfoResult;", "Lcom/avito/android/remote/shop/info/ShopInfo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/shop/info/ShopInfo;", "getInfo", "()Lcom/avito/android/remote/shop/info/ShopInfo;", "info", "<init>", "(Lcom/avito/android/remote/shop/info/ShopInfo;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends ShopInfoResult {
        @NotNull
        public final ShopInfo a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull ShopInfo shopInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(shopInfo, "info");
            this.a = shopInfo;
        }

        @NotNull
        public final ShopInfo getInfo() {
            return this.a;
        }
    }

    public ShopInfoResult() {
    }

    public ShopInfoResult(j jVar) {
    }
}
