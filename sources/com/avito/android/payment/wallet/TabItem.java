package com.avito.android.payment.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.ui.adapter.tab.BaseTabItem;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/avito/android/payment/wallet/TabItem;", "Lcom/avito/android/ui/adapter/tab/BaseTabItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "title", "shortcut", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class TabItem extends BaseTabItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<TabItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/payment/wallet/TabItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/payment/wallet/TabItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, TabItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public TabItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new TabItem(a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabItem(@NotNull String str, @NotNull String str2) {
        super(str, null, str2);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "shortcut");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(getTitle());
        parcel.writeString(getShortcut());
    }
}
