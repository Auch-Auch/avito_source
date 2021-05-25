package com.avito.android.payment.wallet.history.details.item;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.konveyor.blueprint.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\"\u001a\u00020\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/item/AdvertItem;", "Lcom/avito/konveyor/blueprint/Item;", "", "c", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "", g.a, "Ljava/util/List;", "getServicesValue", "()Ljava/util/List;", "servicesValue", AuthSource.BOOKING_ORDER, "getTitle", "title", "f", "getServicesKey", "servicesKey", "d", "getAmount", "amount", "Lcom/avito/android/remote/model/Image;", "e", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/util/List;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertItem implements Item {
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @NotNull
    public final Image e;
    @NotNull
    public final String f;
    @NotNull
    public final List<String> g;

    public AdvertItem(long j, @NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull Image image, @NotNull String str4, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(str4, "servicesKey");
        Intrinsics.checkNotNullParameter(list, "servicesValue");
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = image;
        this.f = str4;
        this.g = list;
    }

    @Nullable
    public final String getAmount() {
        return this.d;
    }

    @NotNull
    public final String getDescription() {
        return this.c;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final Image getImage() {
        return this.e;
    }

    @NotNull
    public final String getServicesKey() {
        return this.f;
    }

    @NotNull
    public final List<String> getServicesValue() {
        return this.g;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertItem(long j, String str, String str2, String str3, Image image, String str4, List list, int i, j jVar) {
        this((i & 1) != 0 ? 0 : j, str, str2, str3, image, str4, list);
    }
}
