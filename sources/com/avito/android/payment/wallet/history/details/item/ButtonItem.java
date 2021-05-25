package com.avito.android.payment.wallet.history.details.item;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.history.Receipt;
import com.avito.konveyor.blueprint.Item;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R=\u0010)\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\"0\u001f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0007¨\u0006/"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/item/ButtonItem;", "Lcom/avito/konveyor/blueprint/Item;", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/payment/history/Receipt;", "component3", "()Lcom/avito/android/remote/model/payment/history/Receipt;", "id", ShareConstants.FEED_CAPTION_PARAM, "receipt", "copy", "(JLjava/lang/String;Lcom/avito/android/remote/model/payment/history/Receipt;)Lcom/avito/android/payment/wallet/history/details/item/ButtonItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Lcom/avito/android/remote/model/payment/history/Receipt;", "getReceipt", AuthSource.BOOKING_ORDER, "J", "getId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "getOnShowReceiptButtonClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnShowReceiptButtonClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onShowReceiptButtonClickListener", "c", "Ljava/lang/String;", "getCaption", "<init>", "(JLjava/lang/String;Lcom/avito/android/remote/model/payment/history/Receipt;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonItem implements Item {
    @NotNull
    public Function1<? super Receipt, Unit> a;
    public final long b;
    @NotNull
    public final String c;
    @NotNull
    public final Receipt d;

    public static final class a extends Lambda implements Function1<Receipt, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Receipt receipt) {
            Intrinsics.checkNotNullParameter(receipt, "it");
            return Unit.INSTANCE;
        }
    }

    public ButtonItem(long j, @NotNull String str, @NotNull Receipt receipt) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.FEED_CAPTION_PARAM);
        Intrinsics.checkNotNullParameter(receipt, "receipt");
        this.b = j;
        this.c = str;
        this.d = receipt;
        this.a = a.a;
    }

    public static /* synthetic */ ButtonItem copy$default(ButtonItem buttonItem, long j, String str, Receipt receipt, int i, Object obj) {
        if ((i & 1) != 0) {
            j = buttonItem.getId();
        }
        if ((i & 2) != 0) {
            str = buttonItem.c;
        }
        if ((i & 4) != 0) {
            receipt = buttonItem.d;
        }
        return buttonItem.copy(j, str, receipt);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final String component2() {
        return this.c;
    }

    @NotNull
    public final Receipt component3() {
        return this.d;
    }

    @NotNull
    public final ButtonItem copy(long j, @NotNull String str, @NotNull Receipt receipt) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.FEED_CAPTION_PARAM);
        Intrinsics.checkNotNullParameter(receipt, "receipt");
        return new ButtonItem(j, str, receipt);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonItem)) {
            return false;
        }
        ButtonItem buttonItem = (ButtonItem) obj;
        return getId() == buttonItem.getId() && Intrinsics.areEqual(this.c, buttonItem.c) && Intrinsics.areEqual(this.d, buttonItem.d);
    }

    @NotNull
    public final String getCaption() {
        return this.c;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.b;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.avito.android.remote.model.payment.history.Receipt, kotlin.Unit>, kotlin.jvm.functions.Function1<com.avito.android.remote.model.payment.history.Receipt, kotlin.Unit> */
    @NotNull
    public final Function1<Receipt, Unit> getOnShowReceiptButtonClickListener() {
        return this.a;
    }

    @NotNull
    public final Receipt getReceipt() {
        return this.d;
    }

    public int hashCode() {
        int a3 = c.a(getId()) * 31;
        String str = this.c;
        int i = 0;
        int hashCode = (a3 + (str != null ? str.hashCode() : 0)) * 31;
        Receipt receipt = this.d;
        if (receipt != null) {
            i = receipt.hashCode();
        }
        return hashCode + i;
    }

    public final void setOnShowReceiptButtonClickListener(@NotNull Function1<? super Receipt, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.a = function1;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("ButtonItem(id=");
        L.append(getId());
        L.append(", caption=");
        L.append(this.c);
        L.append(", receipt=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ButtonItem(long j, String str, Receipt receipt, int i, j jVar) {
        this((i & 1) != 0 ? 0 : j, str, receipt);
    }
}
