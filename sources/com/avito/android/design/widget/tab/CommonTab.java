package com.avito.android.design.widget.tab;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b\u0016\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u001b\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/avito/android/design/widget/tab/CommonTab;", "Lcom/avito/android/design/widget/tab/Tab;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "label", AuthSource.SEND_ABUSE, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public class CommonTab implements Tab, Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<CommonTab> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    @Nullable
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/design/widget/tab/CommonTab$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/design/widget/tab/CommonTab;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, CommonTab> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CommonTab invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new CommonTab(a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readString());
        }
    }

    public CommonTab(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a = str;
        this.b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.design.widget.tab.Tab
    @Nullable
    public String getLabel() {
        return this.b;
    }

    @Override // com.avito.android.design.widget.tab.Tab
    @NotNull
    public String getTitle() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(getTitle());
        parcel.writeString(getLabel());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommonTab(String str, String str2, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : str2);
    }
}
