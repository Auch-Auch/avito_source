package com.avito.android.remote.orders.model;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001d\u001a\u00020\r\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010\u0012\u0006\u0010 \u001a\u00020\u0015¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0012J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017Jv\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\r2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00102\b\b\u0002\u0010 \u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u001c\u0010\u0019\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b,\u0010\u0007R\u001c\u0010\u001a\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b-\u0010\u0007R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b/\u0010\u0012R\u001c\u0010 \u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u00100\u001a\u0004\b1\u0010\u0017R\u001c\u0010\u001c\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b2\u0010\u0007R\u001c\u0010\u001b\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\b4\u0010\u000bR\u001c\u0010\u0018\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u00105\u001a\u0004\b6\u0010\u0004R\u001c\u0010\u001d\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b8\u0010\u000fR\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010.\u001a\u0004\b9\u0010\u0012¨\u0006<"}, d2 = {"Lcom/avito/android/remote/orders/model/OrderData;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "component3", "Lcom/avito/android/deep_linking/links/DeepLink;", "component4", "()Lcom/avito/android/deep_linking/links/DeepLink;", "component5", "Lcom/avito/android/remote/orders/model/OrderStatus;", "component6", "()Lcom/avito/android/remote/orders/model/OrderStatus;", "", "component7", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Image;", "component8", "Lcom/avito/android/remote/model/ParametrizedEvent;", "component9", "()Lcom/avito/android/remote/model/ParametrizedEvent;", AnalyticFieldsName.orderId, "title", Sort.DATE, "deepLink", "price", "status", "items", "images", "clickEvent", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/orders/model/OrderStatus;Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/ParametrizedEvent;)Lcom/avito/android/remote/orders/model/OrderData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "getDate", "Ljava/util/List;", "getItems", "Lcom/avito/android/remote/model/ParametrizedEvent;", "getClickEvent", "getPrice", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "Ljava/lang/String;", "getOrderId", "Lcom/avito/android/remote/orders/model/OrderStatus;", "getStatus", "getImages", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/orders/model/OrderStatus;Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/ParametrizedEvent;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrderData {
    @SerializedName("onSelectEvent")
    @NotNull
    private final ParametrizedEvent clickEvent;
    @SerializedName(Sort.DATE)
    @NotNull
    private final AttributedText date;
    @SerializedName("deepLink")
    @NotNull
    private final DeepLink deepLink;
    @SerializedName("images")
    @NotNull
    private final List<Image> images;
    @SerializedName("items")
    @NotNull
    private final List<AttributedText> items;
    @SerializedName(AnalyticFieldsName.orderId)
    @NotNull
    private final String orderId;
    @SerializedName("price")
    @NotNull
    private final AttributedText price;
    @SerializedName("status")
    @NotNull
    private final OrderStatus status;
    @SerializedName("title")
    @NotNull
    private final AttributedText title;

    public OrderData(@NotNull String str, @NotNull AttributedText attributedText, @NotNull AttributedText attributedText2, @NotNull DeepLink deepLink2, @NotNull AttributedText attributedText3, @NotNull OrderStatus orderStatus, @NotNull List<AttributedText> list, @NotNull List<Image> list2, @NotNull ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        Intrinsics.checkNotNullParameter(attributedText, "title");
        Intrinsics.checkNotNullParameter(attributedText2, Sort.DATE);
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        Intrinsics.checkNotNullParameter(attributedText3, "price");
        Intrinsics.checkNotNullParameter(orderStatus, "status");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(list2, "images");
        Intrinsics.checkNotNullParameter(parametrizedEvent, "clickEvent");
        this.orderId = str;
        this.title = attributedText;
        this.date = attributedText2;
        this.deepLink = deepLink2;
        this.price = attributedText3;
        this.status = orderStatus;
        this.items = list;
        this.images = list2;
        this.clickEvent = parametrizedEvent;
    }

    public static /* synthetic */ OrderData copy$default(OrderData orderData, String str, AttributedText attributedText, AttributedText attributedText2, DeepLink deepLink2, AttributedText attributedText3, OrderStatus orderStatus, List list, List list2, ParametrizedEvent parametrizedEvent, int i, Object obj) {
        return orderData.copy((i & 1) != 0 ? orderData.orderId : str, (i & 2) != 0 ? orderData.title : attributedText, (i & 4) != 0 ? orderData.date : attributedText2, (i & 8) != 0 ? orderData.deepLink : deepLink2, (i & 16) != 0 ? orderData.price : attributedText3, (i & 32) != 0 ? orderData.status : orderStatus, (i & 64) != 0 ? orderData.items : list, (i & 128) != 0 ? orderData.images : list2, (i & 256) != 0 ? orderData.clickEvent : parametrizedEvent);
    }

    @NotNull
    public final String component1() {
        return this.orderId;
    }

    @NotNull
    public final AttributedText component2() {
        return this.title;
    }

    @NotNull
    public final AttributedText component3() {
        return this.date;
    }

    @NotNull
    public final DeepLink component4() {
        return this.deepLink;
    }

    @NotNull
    public final AttributedText component5() {
        return this.price;
    }

    @NotNull
    public final OrderStatus component6() {
        return this.status;
    }

    @NotNull
    public final List<AttributedText> component7() {
        return this.items;
    }

    @NotNull
    public final List<Image> component8() {
        return this.images;
    }

    @NotNull
    public final ParametrizedEvent component9() {
        return this.clickEvent;
    }

    @NotNull
    public final OrderData copy(@NotNull String str, @NotNull AttributedText attributedText, @NotNull AttributedText attributedText2, @NotNull DeepLink deepLink2, @NotNull AttributedText attributedText3, @NotNull OrderStatus orderStatus, @NotNull List<AttributedText> list, @NotNull List<Image> list2, @NotNull ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        Intrinsics.checkNotNullParameter(attributedText, "title");
        Intrinsics.checkNotNullParameter(attributedText2, Sort.DATE);
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        Intrinsics.checkNotNullParameter(attributedText3, "price");
        Intrinsics.checkNotNullParameter(orderStatus, "status");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(list2, "images");
        Intrinsics.checkNotNullParameter(parametrizedEvent, "clickEvent");
        return new OrderData(str, attributedText, attributedText2, deepLink2, attributedText3, orderStatus, list, list2, parametrizedEvent);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderData)) {
            return false;
        }
        OrderData orderData = (OrderData) obj;
        return Intrinsics.areEqual(this.orderId, orderData.orderId) && Intrinsics.areEqual(this.title, orderData.title) && Intrinsics.areEqual(this.date, orderData.date) && Intrinsics.areEqual(this.deepLink, orderData.deepLink) && Intrinsics.areEqual(this.price, orderData.price) && Intrinsics.areEqual(this.status, orderData.status) && Intrinsics.areEqual(this.items, orderData.items) && Intrinsics.areEqual(this.images, orderData.images) && Intrinsics.areEqual(this.clickEvent, orderData.clickEvent);
    }

    @NotNull
    public final ParametrizedEvent getClickEvent() {
        return this.clickEvent;
    }

    @NotNull
    public final AttributedText getDate() {
        return this.date;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @NotNull
    public final List<Image> getImages() {
        return this.images;
    }

    @NotNull
    public final List<AttributedText> getItems() {
        return this.items;
    }

    @NotNull
    public final String getOrderId() {
        return this.orderId;
    }

    @NotNull
    public final AttributedText getPrice() {
        return this.price;
    }

    @NotNull
    public final OrderStatus getStatus() {
        return this.status;
    }

    @NotNull
    public final AttributedText getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.orderId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AttributedText attributedText = this.title;
        int hashCode2 = (hashCode + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
        AttributedText attributedText2 = this.date;
        int hashCode3 = (hashCode2 + (attributedText2 != null ? attributedText2.hashCode() : 0)) * 31;
        DeepLink deepLink2 = this.deepLink;
        int hashCode4 = (hashCode3 + (deepLink2 != null ? deepLink2.hashCode() : 0)) * 31;
        AttributedText attributedText3 = this.price;
        int hashCode5 = (hashCode4 + (attributedText3 != null ? attributedText3.hashCode() : 0)) * 31;
        OrderStatus orderStatus = this.status;
        int hashCode6 = (hashCode5 + (orderStatus != null ? orderStatus.hashCode() : 0)) * 31;
        List<AttributedText> list = this.items;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        List<Image> list2 = this.images;
        int hashCode8 = (hashCode7 + (list2 != null ? list2.hashCode() : 0)) * 31;
        ParametrizedEvent parametrizedEvent = this.clickEvent;
        if (parametrizedEvent != null) {
            i = parametrizedEvent.hashCode();
        }
        return hashCode8 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OrderData(orderId=");
        L.append(this.orderId);
        L.append(", title=");
        L.append(this.title);
        L.append(", date=");
        L.append(this.date);
        L.append(", deepLink=");
        L.append(this.deepLink);
        L.append(", price=");
        L.append(this.price);
        L.append(", status=");
        L.append(this.status);
        L.append(", items=");
        L.append(this.items);
        L.append(", images=");
        L.append(this.images);
        L.append(", clickEvent=");
        L.append(this.clickEvent);
        L.append(")");
        return L.toString();
    }
}
