package com.avito.android.remote.cart.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001aBK\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/cart/model/DeleteItemResponse;", "", "", "Lcom/avito/android/remote/cart/model/DeleteItemResponse$Store;", "stores", "Ljava/util/List;", "getStores", "()Ljava/util/List;", "", "screenTitle", "Ljava/lang/String;", "getScreenTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/cart/model/Action;", "actions", "getActions", "Lcom/avito/android/remote/cart/model/Price;", "updatedPrices", "getUpdatedPrices", "Lcom/avito/android/remote/cart/model/Banner;", "banner", "Lcom/avito/android/remote/cart/model/Banner;", "getBanner", "()Lcom/avito/android/remote/cart/model/Banner;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/cart/model/Banner;Ljava/util/List;Ljava/util/List;)V", "Store", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class DeleteItemResponse {
    @SerializedName("actions")
    @Nullable
    private final List<Action> actions;
    @SerializedName("banner")
    @Nullable
    private final Banner banner;
    @SerializedName("title")
    @Nullable
    private final String screenTitle;
    @SerializedName("stores")
    @Nullable
    private final List<Store> stores;
    @SerializedName("updatedPrices")
    @Nullable
    private final List<Price> updatedPrices;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/cart/model/DeleteItemResponse$Store;", "", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "id", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
    public static final class Store {
        @SerializedName("errorMessage")
        @Nullable
        private final String errorMessage;
        @SerializedName("storeId")
        @NotNull
        private final String id;

        public Store(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            this.id = str;
            this.errorMessage = str2;
        }

        @Nullable
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.cart.model.Action> */
    /* JADX WARN: Multi-variable type inference failed */
    public DeleteItemResponse(@Nullable String str, @Nullable List<? extends Action> list, @Nullable Banner banner2, @Nullable List<Store> list2, @Nullable List<Price> list3) {
        this.screenTitle = str;
        this.actions = list;
        this.banner = banner2;
        this.stores = list2;
        this.updatedPrices = list3;
    }

    @Nullable
    public final List<Action> getActions() {
        return this.actions;
    }

    @Nullable
    public final Banner getBanner() {
        return this.banner;
    }

    @Nullable
    public final String getScreenTitle() {
        return this.screenTitle;
    }

    @Nullable
    public final List<Store> getStores() {
        return this.stores;
    }

    @Nullable
    public final List<Price> getUpdatedPrices() {
        return this.updatedPrices;
    }
}
