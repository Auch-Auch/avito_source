package com.avito.android.remote.marketplace;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.remote.model.ModelSpecifications;
import com.avito.android.remote.model.advert_badge_bar.AdvertBadgeBar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\bH\u0010IJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001e\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001e\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001e\u00105\u001a\u0004\u0018\u0001048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001e\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001e\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001e\u0010D\u001a\u0004\u0018\u00010C8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G¨\u0006J"}, d2 = {"Lcom/avito/android/remote/marketplace/AdvertMarketPlace;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/marketplace/InStock;", "inStockTexts", "Lcom/avito/android/remote/marketplace/InStock;", "getInStockTexts", "()Lcom/avito/android/remote/marketplace/InStock;", "Lcom/avito/android/remote/marketplace/AdvertQuantity;", FirebaseAnalytics.Param.QUANTITY, "Lcom/avito/android/remote/marketplace/AdvertQuantity;", "getQuantity", "()Lcom/avito/android/remote/marketplace/AdvertQuantity;", "", "Lcom/avito/android/remote/marketplace/SpecificationItem;", "mainSpecifications", "Ljava/util/List;", "getMainSpecifications", "()Ljava/util/List;", "Lcom/avito/android/remote/model/AdvertAction$Buy;", "buyAction", "Lcom/avito/android/remote/model/AdvertAction$Buy;", "getBuyAction", "()Lcom/avito/android/remote/model/AdvertAction$Buy;", "Lcom/avito/android/remote/model/AdvertAction$Cart;", "cartAction", "Lcom/avito/android/remote/model/AdvertAction$Cart;", "getCartAction", "()Lcom/avito/android/remote/model/AdvertAction$Cart;", "Lcom/avito/android/remote/model/ModelSpecifications;", "specifications", "Lcom/avito/android/remote/model/ModelSpecifications;", "getSpecifications", "()Lcom/avito/android/remote/model/ModelSpecifications;", "Lcom/avito/android/remote/marketplace/FAQ;", "faq", "Lcom/avito/android/remote/marketplace/FAQ;", "getFaq", "()Lcom/avito/android/remote/marketplace/FAQ;", "Lcom/avito/android/remote/marketplace/Delivery;", "delivery", "Lcom/avito/android/remote/marketplace/Delivery;", "getDelivery", "()Lcom/avito/android/remote/marketplace/Delivery;", "Lcom/avito/android/remote/marketplace/InfoBanner;", "infoBanner", "Lcom/avito/android/remote/marketplace/InfoBanner;", "getInfoBanner", "()Lcom/avito/android/remote/marketplace/InfoBanner;", "Lcom/avito/android/remote/model/AdvertAction$Messenger;", "chatAction", "Lcom/avito/android/remote/model/AdvertAction$Messenger;", "getChatAction", "()Lcom/avito/android/remote/model/AdvertAction$Messenger;", "Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeBar;", "badgeBar", "Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeBar;", "getBadgeBar", "()Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeBar;", "", "hideDiscountPercent", "Ljava/lang/Boolean;", "getHideDiscountPercent", "()Ljava/lang/Boolean;", "<init>", "(Lcom/avito/android/remote/model/AdvertAction$Buy;Lcom/avito/android/remote/model/AdvertAction$Cart;Lcom/avito/android/remote/model/ModelSpecifications;Lcom/avito/android/remote/marketplace/FAQ;Lcom/avito/android/remote/marketplace/InfoBanner;Lcom/avito/android/remote/marketplace/Delivery;Ljava/util/List;Lcom/avito/android/remote/marketplace/InStock;Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeBar;Ljava/lang/Boolean;Lcom/avito/android/remote/marketplace/AdvertQuantity;Lcom/avito/android/remote/model/AdvertAction$Messenger;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertMarketPlace implements Parcelable {
    public static final Parcelable.Creator<AdvertMarketPlace> CREATOR = new Creator();
    @SerializedName("badgeBar")
    @Nullable
    private final AdvertBadgeBar badgeBar;
    @SerializedName("buyButton")
    @Nullable
    private final AdvertAction.Buy buyAction;
    @SerializedName("cartButton")
    @Nullable
    private final AdvertAction.Cart cartAction;
    @SerializedName("startChatButton")
    @Nullable
    private final AdvertAction.Messenger chatAction;
    @SerializedName("delivery")
    @Nullable
    private final Delivery delivery;
    @SerializedName("faq")
    @Nullable
    private final FAQ faq;
    @SerializedName("hideDiscountPercent")
    @Nullable
    private final Boolean hideDiscountPercent;
    @SerializedName("inStockTexts")
    @Nullable
    private final InStock inStockTexts;
    @SerializedName("infoBanner")
    @Nullable
    private final InfoBanner infoBanner;
    @SerializedName("mainSpecifications")
    @Nullable
    private final List<SpecificationItem> mainSpecifications;
    @SerializedName(FirebaseAnalytics.Param.QUANTITY)
    @Nullable
    private final AdvertQuantity quantity;
    @SerializedName("specifications")
    @Nullable
    private final ModelSpecifications specifications;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertMarketPlace> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertMarketPlace createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            AdvertAction.Buy buy = (AdvertAction.Buy) parcel.readParcelable(AdvertMarketPlace.class.getClassLoader());
            AdvertAction.Cart cart = (AdvertAction.Cart) parcel.readParcelable(AdvertMarketPlace.class.getClassLoader());
            ModelSpecifications modelSpecifications = (ModelSpecifications) parcel.readParcelable(AdvertMarketPlace.class.getClassLoader());
            FAQ createFromParcel = parcel.readInt() != 0 ? FAQ.CREATOR.createFromParcel(parcel) : null;
            InfoBanner createFromParcel2 = parcel.readInt() != 0 ? InfoBanner.CREATOR.createFromParcel(parcel) : null;
            Delivery createFromParcel3 = parcel.readInt() != 0 ? Delivery.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(SpecificationItem.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            InStock createFromParcel4 = parcel.readInt() != 0 ? InStock.CREATOR.createFromParcel(parcel) : null;
            AdvertBadgeBar createFromParcel5 = parcel.readInt() != 0 ? AdvertBadgeBar.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new AdvertMarketPlace(buy, cart, modelSpecifications, createFromParcel, createFromParcel2, createFromParcel3, arrayList, createFromParcel4, createFromParcel5, bool, parcel.readInt() != 0 ? AdvertQuantity.CREATOR.createFromParcel(parcel) : null, (AdvertAction.Messenger) parcel.readParcelable(AdvertMarketPlace.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertMarketPlace[] newArray(int i) {
            return new AdvertMarketPlace[i];
        }
    }

    public AdvertMarketPlace(@Nullable AdvertAction.Buy buy, @Nullable AdvertAction.Cart cart, @Nullable ModelSpecifications modelSpecifications, @Nullable FAQ faq2, @Nullable InfoBanner infoBanner2, @Nullable Delivery delivery2, @Nullable List<SpecificationItem> list, @Nullable InStock inStock, @Nullable AdvertBadgeBar advertBadgeBar, @Nullable Boolean bool, @Nullable AdvertQuantity advertQuantity, @Nullable AdvertAction.Messenger messenger) {
        this.buyAction = buy;
        this.cartAction = cart;
        this.specifications = modelSpecifications;
        this.faq = faq2;
        this.infoBanner = infoBanner2;
        this.delivery = delivery2;
        this.mainSpecifications = list;
        this.inStockTexts = inStock;
        this.badgeBar = advertBadgeBar;
        this.hideDiscountPercent = bool;
        this.quantity = advertQuantity;
        this.chatAction = messenger;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AdvertBadgeBar getBadgeBar() {
        return this.badgeBar;
    }

    @Nullable
    public final AdvertAction.Buy getBuyAction() {
        return this.buyAction;
    }

    @Nullable
    public final AdvertAction.Cart getCartAction() {
        return this.cartAction;
    }

    @Nullable
    public final AdvertAction.Messenger getChatAction() {
        return this.chatAction;
    }

    @Nullable
    public final Delivery getDelivery() {
        return this.delivery;
    }

    @Nullable
    public final FAQ getFaq() {
        return this.faq;
    }

    @Nullable
    public final Boolean getHideDiscountPercent() {
        return this.hideDiscountPercent;
    }

    @Nullable
    public final InStock getInStockTexts() {
        return this.inStockTexts;
    }

    @Nullable
    public final InfoBanner getInfoBanner() {
        return this.infoBanner;
    }

    @Nullable
    public final List<SpecificationItem> getMainSpecifications() {
        return this.mainSpecifications;
    }

    @Nullable
    public final AdvertQuantity getQuantity() {
        return this.quantity;
    }

    @Nullable
    public final ModelSpecifications getSpecifications() {
        return this.specifications;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.buyAction, i);
        parcel.writeParcelable(this.cartAction, i);
        parcel.writeParcelable(this.specifications, i);
        FAQ faq2 = this.faq;
        if (faq2 != null) {
            parcel.writeInt(1);
            faq2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        InfoBanner infoBanner2 = this.infoBanner;
        if (infoBanner2 != null) {
            parcel.writeInt(1);
            infoBanner2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Delivery delivery2 = this.delivery;
        if (delivery2 != null) {
            parcel.writeInt(1);
            delivery2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        List<SpecificationItem> list = this.mainSpecifications;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((SpecificationItem) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        InStock inStock = this.inStockTexts;
        if (inStock != null) {
            parcel.writeInt(1);
            inStock.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        AdvertBadgeBar advertBadgeBar = this.badgeBar;
        if (advertBadgeBar != null) {
            parcel.writeInt(1);
            advertBadgeBar.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.hideDiscountPercent;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        AdvertQuantity advertQuantity = this.quantity;
        if (advertQuantity != null) {
            parcel.writeInt(1);
            advertQuantity.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.chatAction, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertMarketPlace(AdvertAction.Buy buy, AdvertAction.Cart cart, ModelSpecifications modelSpecifications, FAQ faq2, InfoBanner infoBanner2, Delivery delivery2, List list, InStock inStock, AdvertBadgeBar advertBadgeBar, Boolean bool, AdvertQuantity advertQuantity, AdvertAction.Messenger messenger, int i, j jVar) {
        this(buy, cart, modelSpecifications, faq2, infoBanner2, delivery2, list, inStock, (i & 256) != 0 ? null : advertBadgeBar, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? null : advertQuantity, (i & 2048) != 0 ? null : messenger);
    }
}
