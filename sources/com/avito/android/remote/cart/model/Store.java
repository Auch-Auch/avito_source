package com.avito.android.remote.cart.model;

import a2.b.a.a.a;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.text.AttributedText;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0013B1\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/cart/model/Store;", "", "", "Lcom/avito/android/remote/cart/model/Store$Item;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "id", "getId", "errorMessage", "getErrorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Item", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class Store {
    @SerializedName("errorMessage")
    @Nullable
    private final String errorMessage;
    @SerializedName("storeId")
    @NotNull
    private final String id;
    @SerializedName("items")
    @Nullable
    private final List<Item> items;
    @SerializedName("name")
    @NotNull
    private final String name;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u001eBE\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/cart/model/Store$Item;", "", "Lcom/avito/android/remote/model/text/AttributedText;", "itemsLeft", "Lcom/avito/android/remote/model/text/AttributedText;", "getItemsLeft", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/cart/model/Store$Item$Stepper;", "stepper", "Lcom/avito/android/remote/cart/model/Store$Item$Stepper;", "getStepper", "()Lcom/avito/android/remote/cart/model/Store$Item$Stepper;", "price", "getPrice", "pricePerPiece", "getPricePerPiece", "title", "getTitle", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/cart/model/Store$Item$Stepper;Lcom/avito/android/remote/model/text/AttributedText;)V", "Stepper", "cart_release"}, k = 1, mv = {1, 4, 2})
    public static final class Item {
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("image")
        @Nullable
        private final Image image;
        @SerializedName("itemsLeft")
        @Nullable
        private final AttributedText itemsLeft;
        @SerializedName("price")
        @NotNull
        private final AttributedText price;
        @SerializedName("pricePerPiece")
        @Nullable
        private final AttributedText pricePerPiece;
        @SerializedName("stepper")
        @NotNull
        private final Stepper stepper;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/cart/model/Store$Item$Stepper;", "", "", "component1", "()I", "component2", "availableQuantity", FirebaseAnalytics.Param.QUANTITY, "copy", "(II)Lcom/avito/android/remote/cart/model/Store$Item$Stepper;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getQuantity", "getAvailableQuantity", "<init>", "(II)V", "cart_release"}, k = 1, mv = {1, 4, 2})
        public static final class Stepper {
            @SerializedName("availableQuantity")
            private final int availableQuantity;
            @SerializedName(FirebaseAnalytics.Param.QUANTITY)
            private final int quantity;

            public Stepper(int i, int i2) {
                this.availableQuantity = i;
                this.quantity = i2;
            }

            public static /* synthetic */ Stepper copy$default(Stepper stepper, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = stepper.availableQuantity;
                }
                if ((i3 & 2) != 0) {
                    i2 = stepper.quantity;
                }
                return stepper.copy(i, i2);
            }

            public final int component1() {
                return this.availableQuantity;
            }

            public final int component2() {
                return this.quantity;
            }

            @NotNull
            public final Stepper copy(int i, int i2) {
                return new Stepper(i, i2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Stepper)) {
                    return false;
                }
                Stepper stepper = (Stepper) obj;
                return this.availableQuantity == stepper.availableQuantity && this.quantity == stepper.quantity;
            }

            public final int getAvailableQuantity() {
                return this.availableQuantity;
            }

            public final int getQuantity() {
                return this.quantity;
            }

            public int hashCode() {
                return (this.availableQuantity * 31) + this.quantity;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Stepper(availableQuantity=");
                L.append(this.availableQuantity);
                L.append(", quantity=");
                return a.j(L, this.quantity, ")");
            }
        }

        public Item(@NotNull String str, @Nullable Image image2, @NotNull String str2, @NotNull AttributedText attributedText, @Nullable AttributedText attributedText2, @NotNull Stepper stepper2, @Nullable AttributedText attributedText3) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(attributedText, "price");
            Intrinsics.checkNotNullParameter(stepper2, "stepper");
            this.id = str;
            this.image = image2;
            this.title = str2;
            this.price = attributedText;
            this.itemsLeft = attributedText2;
            this.stepper = stepper2;
            this.pricePerPiece = attributedText3;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final Image getImage() {
            return this.image;
        }

        @Nullable
        public final AttributedText getItemsLeft() {
            return this.itemsLeft;
        }

        @NotNull
        public final AttributedText getPrice() {
            return this.price;
        }

        @Nullable
        public final AttributedText getPricePerPiece() {
            return this.pricePerPiece;
        }

        @NotNull
        public final Stepper getStepper() {
            return this.stepper;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }
    }

    public Store(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable List<Item> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.id = str;
        this.name = str2;
        this.errorMessage = str3;
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

    @NotNull
    public final String getName() {
        return this.name;
    }
}
