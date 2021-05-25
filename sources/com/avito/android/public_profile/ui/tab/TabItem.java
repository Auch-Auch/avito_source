package com.avito.android.public_profile.ui.tab;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.ui.adapter.tab.BaseTabItem;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB+\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/avito/android/public_profile/ui/tab/TabItem;", "Lcom/avito/android/ui/adapter/tab/BaseTabItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "d", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "e", "Ljava/lang/Integer;", "getCount", "()Ljava/lang/Integer;", "count", g.a, "getShortcut", "shortcut", "f", "getPlaceholder", InternalConstsKt.PLACEHOLDER, "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class TabItem extends BaseTabItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<TabItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String d;
    @Nullable
    public final Integer e;
    @Nullable
    public final String f;
    @NotNull
    public final String g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/public_profile/ui/tab/TabItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/public_profile/ui/tab/TabItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
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
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            Object readValue = parcel2.readValue(Integer.class.getClassLoader());
            String str = null;
            if (!(readValue instanceof Integer)) {
                readValue = null;
            }
            Integer num = (Integer) readValue;
            Object readValue2 = parcel2.readValue(String.class.getClassLoader());
            if (readValue2 instanceof String) {
                str = readValue2;
            }
            return new TabItem(u2, num, str, a2.b.a.a.a.u2(parcel2, "readString()!!"));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabItem(@NotNull String str, @Nullable Integer num, @Nullable String str2, @NotNull String str3) {
        super(str, num, str3);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str3, "shortcut");
        this.d = str;
        this.e = num;
        this.f = str2;
        this.g = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.ui.adapter.tab.BaseTabItem
    @Nullable
    public Integer getCount() {
        return this.e;
    }

    @Nullable
    public final String getPlaceholder() {
        return this.f;
    }

    @Override // com.avito.android.ui.adapter.tab.BaseTabItem
    @NotNull
    public String getShortcut() {
        return this.g;
    }

    @Override // com.avito.android.ui.adapter.tab.BaseTabItem, com.avito.android.design.widget.tab.Tab
    @NotNull
    public String getTitle() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(getTitle());
        ParcelsKt.writeNullableValue(parcel, getCount());
        ParcelsKt.writeNullableValue(parcel, this.f);
        parcel.writeString(getShortcut());
    }
}
