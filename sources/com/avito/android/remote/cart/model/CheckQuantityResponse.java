package com.avito.android.remote.cart.model;

import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001aBI\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/cart/model/CheckQuantityResponse;", "", "", "Lcom/avito/android/remote/cart/model/CheckQuantityResponse$Store;", "stores", "Ljava/util/List;", "getStores", "()Ljava/util/List;", "Lcom/avito/android/remote/cart/model/Action;", "actions", "getActions", "", "screenTitle", "Ljava/lang/String;", "getScreenTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/cart/model/Banner;", "banner", "Lcom/avito/android/remote/cart/model/Banner;", "getBanner", "()Lcom/avito/android/remote/cart/model/Banner;", "Lcom/avito/android/remote/cart/model/Price;", "updatedPrices", "getUpdatedPrices", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/cart/model/Banner;Ljava/util/List;Ljava/util/List;)V", "Store", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class CheckQuantityResponse {
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
    @NotNull
    private final List<Price> updatedPrices;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/cart/model/CheckQuantityResponse$Store;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "errorMessage", "getErrorMessage", "", "Lcom/avito/android/remote/cart/model/CheckQuantityResponse$Store$Item;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Item", "cart_release"}, k = 1, mv = {1, 4, 2})
    public static final class Store {
        @SerializedName("errorMessage")
        @Nullable
        private final String errorMessage;
        @SerializedName("storeId")
        @NotNull
        private final String id;
        @SerializedName("items")
        @Nullable
        private final List<Item> items;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/cart/model/CheckQuantityResponse$Store$Item;", "", "Lcom/avito/android/remote/model/text/AttributedText;", "itemsLeft", "Lcom/avito/android/remote/model/text/AttributedText;", "getItemsLeft", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "", "availableQuantity", "I", "getAvailableQuantity", "()I", "price", "getPrice", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;ILcom/avito/android/remote/model/text/AttributedText;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
        public static final class Item {
            @SerializedName("availableQuantity")
            private final int availableQuantity;
            @SerializedName("itemId")
            @NotNull
            private final String id;
            @SerializedName("itemsLeft")
            @Nullable
            private final AttributedText itemsLeft;
            @SerializedName("price")
            @NotNull
            private final AttributedText price;

            public Item(@NotNull String str, @NotNull AttributedText attributedText, int i, @Nullable AttributedText attributedText2) {
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(attributedText, "price");
                this.id = str;
                this.price = attributedText;
                this.availableQuantity = i;
                this.itemsLeft = attributedText2;
            }

            public final int getAvailableQuantity() {
                return this.availableQuantity;
            }

            @NotNull
            public final String getId() {
                return this.id;
            }

            @Nullable
            public final AttributedText getItemsLeft() {
                return this.itemsLeft;
            }

            @NotNull
            public final AttributedText getPrice() {
                return this.price;
            }
        }

        public Store(@NotNull String str, @Nullable String str2, @Nullable List<Item> list) {
            Intrinsics.checkNotNullParameter(str, "id");
            this.id = str;
            this.errorMessage = str2;
            this.items = list;
        }

        @Nullable
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final List<Item> getItems() {
            return this.items;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.cart.model.Action> */
    /* JADX WARN: Multi-variable type inference failed */
    public CheckQuantityResponse(@Nullable String str, @Nullable List<? extends Action> list, @Nullable Banner banner2, @Nullable List<Store> list2, @NotNull List<Price> list3) {
        Intrinsics.checkNotNullParameter(list3, "updatedPrices");
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

    @NotNull
    public final List<Price> getUpdatedPrices() {
        return this.updatedPrices;
    }
}
