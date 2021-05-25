package net.gotev.uploadservice.data;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.browser.trusted.sharing.ShareTarget;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import net.gotev.uploadservice.persistence.Persistable;
import net.gotev.uploadservice.persistence.PersistableData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\b\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B;\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b5\u00106J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJD\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\t2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0017\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b$\u0010%R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010-R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010'\u001a\u0004\b/\u0010\u000fR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u000b\"\u0004\b3\u00104¨\u00068"}, d2 = {"Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "Landroid/os/Parcelable;", "Lnet/gotev/uploadservice/persistence/Persistable;", "Lnet/gotev/uploadservice/persistence/PersistableData;", "toPersistableData", "()Lnet/gotev/uploadservice/persistence/PersistableData;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/data/NameValue;", "component3", "()Ljava/util/ArrayList;", "component4", "method", "usesFixedLengthStreamingMode", "requestHeaders", "requestParameters", "copy", "(Ljava/lang/String;ZLjava/util/ArrayList;Ljava/util/ArrayList;)Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Ljava/util/ArrayList;", "getRequestParameters", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMethod", "setMethod", "(Ljava/lang/String;)V", "c", "getRequestHeaders", AuthSource.BOOKING_ORDER, "Z", "getUsesFixedLengthStreamingMode", "setUsesFixedLengthStreamingMode", "(Z)V", "<init>", "(Ljava/lang/String;ZLjava/util/ArrayList;Ljava/util/ArrayList;)V", "Companion", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class HttpUploadTaskParameters implements Parcelable, Persistable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    @NotNull
    public String a;
    public boolean b;
    @NotNull
    public final ArrayList<NameValue> c;
    @NotNull
    public final ArrayList<NameValue> d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b*\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lnet/gotev/uploadservice/data/HttpUploadTaskParameters$Companion;", "Lnet/gotev/uploadservice/persistence/Persistable$Creator;", "Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "Lnet/gotev/uploadservice/persistence/PersistableData;", "data", "createFromPersistableData", "(Lnet/gotev/uploadservice/persistence/PersistableData;)Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "", "Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/data/NameValue;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "(Ljava/util/List;)Ljava/util/ArrayList;", "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion implements Persistable.Creator<HttpUploadTaskParameters> {
        public Companion() {
        }

        public final ArrayList<NameValue> a(List<? extends PersistableData> list) {
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(NameValue.Companion.createFromPersistableData((PersistableData) it.next()));
            }
            return new ArrayList<>(arrayList);
        }

        public Companion(j jVar) {
        }

        @Override // net.gotev.uploadservice.persistence.Persistable.Creator
        @NotNull
        public HttpUploadTaskParameters createFromPersistableData(@NotNull PersistableData persistableData) {
            ArrayList<NameValue> arrayList;
            ArrayList<NameValue> arrayList2;
            Intrinsics.checkNotNullParameter(persistableData, "data");
            String string = persistableData.getString("method");
            boolean z = persistableData.getBoolean("fixedLength");
            try {
                arrayList = a(persistableData.getArrayData("headers"));
            } catch (Throwable unused) {
                arrayList = new ArrayList<>();
            }
            try {
                arrayList2 = a(persistableData.getArrayData("params"));
            } catch (Throwable unused2) {
                arrayList2 = new ArrayList<>();
            }
            return new HttpUploadTaskParameters(string, z, arrayList, arrayList2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            boolean z = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((NameValue) NameValue.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add((NameValue) NameValue.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new HttpUploadTaskParameters(readString, z, arrayList, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i) {
            return new HttpUploadTaskParameters[i];
        }
    }

    public HttpUploadTaskParameters() {
        this(null, false, null, null, 15, null);
    }

    public HttpUploadTaskParameters(@NotNull String str, boolean z, @NotNull ArrayList<NameValue> arrayList, @NotNull ArrayList<NameValue> arrayList2) {
        Intrinsics.checkNotNullParameter(str, "method");
        Intrinsics.checkNotNullParameter(arrayList, "requestHeaders");
        Intrinsics.checkNotNullParameter(arrayList2, "requestParameters");
        this.a = str;
        this.b = z;
        this.c = arrayList;
        this.d = arrayList2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: net.gotev.uploadservice.data.HttpUploadTaskParameters */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpUploadTaskParameters copy$default(HttpUploadTaskParameters httpUploadTaskParameters, String str, boolean z, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = httpUploadTaskParameters.a;
        }
        if ((i & 2) != 0) {
            z = httpUploadTaskParameters.b;
        }
        if ((i & 4) != 0) {
            arrayList = httpUploadTaskParameters.c;
        }
        if ((i & 8) != 0) {
            arrayList2 = httpUploadTaskParameters.d;
        }
        return httpUploadTaskParameters.copy(str, z, arrayList, arrayList2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final boolean component2() {
        return this.b;
    }

    @NotNull
    public final ArrayList<NameValue> component3() {
        return this.c;
    }

    @NotNull
    public final ArrayList<NameValue> component4() {
        return this.d;
    }

    @NotNull
    public final HttpUploadTaskParameters copy(@NotNull String str, boolean z, @NotNull ArrayList<NameValue> arrayList, @NotNull ArrayList<NameValue> arrayList2) {
        Intrinsics.checkNotNullParameter(str, "method");
        Intrinsics.checkNotNullParameter(arrayList, "requestHeaders");
        Intrinsics.checkNotNullParameter(arrayList2, "requestParameters");
        return new HttpUploadTaskParameters(str, z, arrayList, arrayList2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpUploadTaskParameters)) {
            return false;
        }
        HttpUploadTaskParameters httpUploadTaskParameters = (HttpUploadTaskParameters) obj;
        return Intrinsics.areEqual(this.a, httpUploadTaskParameters.a) && this.b == httpUploadTaskParameters.b && Intrinsics.areEqual(this.c, httpUploadTaskParameters.c) && Intrinsics.areEqual(this.d, httpUploadTaskParameters.d);
    }

    @NotNull
    public final String getMethod() {
        return this.a;
    }

    @NotNull
    public final ArrayList<NameValue> getRequestHeaders() {
        return this.c;
    }

    @NotNull
    public final ArrayList<NameValue> getRequestParameters() {
        return this.d;
    }

    public final boolean getUsesFixedLengthStreamingMode() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.b;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode + i2) * 31;
        ArrayList<NameValue> arrayList = this.c;
        int hashCode2 = (i5 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        ArrayList<NameValue> arrayList2 = this.d;
        if (arrayList2 != null) {
            i = arrayList2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setMethod(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }

    public final void setUsesFixedLengthStreamingMode(boolean z) {
        this.b = z;
    }

    @Override // net.gotev.uploadservice.persistence.Persistable
    @NotNull
    public PersistableData toPersistableData() {
        PersistableData persistableData = new PersistableData();
        persistableData.putString("method", this.a);
        persistableData.putBoolean("fixedLength", this.b);
        ArrayList<NameValue> arrayList = this.c;
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().toPersistableData());
        }
        persistableData.putArrayData("headers", arrayList2);
        ArrayList<NameValue> arrayList3 = this.d;
        ArrayList arrayList4 = new ArrayList(e.collectionSizeOrDefault(arrayList3, 10));
        Iterator<T> it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(it2.next().toPersistableData());
        }
        persistableData.putArrayData("params", arrayList4);
        return persistableData;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("HttpUploadTaskParameters(method=");
        L.append(this.a);
        L.append(", usesFixedLengthStreamingMode=");
        L.append(this.b);
        L.append(", requestHeaders=");
        L.append(this.c);
        L.append(", requestParameters=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeInt(this.b ? 1 : 0);
        ArrayList<NameValue> arrayList = this.c;
        parcel.writeInt(arrayList.size());
        for (NameValue nameValue : arrayList) {
            nameValue.writeToParcel(parcel, 0);
        }
        ArrayList<NameValue> arrayList2 = this.d;
        parcel.writeInt(arrayList2.size());
        for (NameValue nameValue2 : arrayList2) {
            nameValue2.writeToParcel(parcel, 0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HttpUploadTaskParameters(String str, boolean z, ArrayList arrayList, ArrayList arrayList2, int i, j jVar) {
        this((i & 1) != 0 ? ShareTarget.METHOD_POST : str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? new ArrayList(5) : arrayList, (i & 8) != 0 ? new ArrayList(5) : arrayList2);
    }
}
