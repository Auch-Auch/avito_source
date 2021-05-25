package net.gotev.uploadservice.data;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0019\b\b\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BBO\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u0012\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b@\u0010AJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0005Jf\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b \u0010\bJ\u0010\u0010!\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b!\u0010\rJ\u001a\u0010$\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b&\u0010\rJ \u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b+\u0010,R\u0019\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\rR\u0019\u0010\u001d\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0005R)\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0015R\u0019\u0010\u0017\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\bR\u0019\u0010\u0019\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b9\u00107\u001a\u0004\b:\u0010\bR\u0019\u0010\u001b\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u0010R\u0019\u0010\u0018\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b>\u00107\u001a\u0004\b?\u0010\b¨\u0006C"}, d2 = {"Lnet/gotev/uploadservice/data/UploadTaskParameters;", "Landroid/os/Parcelable;", "Lnet/gotev/uploadservice/persistence/Persistable;", "Lnet/gotev/uploadservice/persistence/PersistableData;", "toPersistableData", "()Lnet/gotev/uploadservice/persistence/PersistableData;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()I", "", "component5", "()Z", "Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/data/UploadFile;", "Lkotlin/collections/ArrayList;", "component6", "()Ljava/util/ArrayList;", "component7", "taskClass", "id", "serverUrl", "maxRetries", "autoDeleteSuccessfullyUploadedFiles", "files", "additionalParameters", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/util/ArrayList;Lnet/gotev/uploadservice/persistence/PersistableData;)Lnet/gotev/uploadservice/data/UploadTaskParameters;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "I", "getMaxRetries", g.a, "Lnet/gotev/uploadservice/persistence/PersistableData;", "getAdditionalParameters", "f", "Ljava/util/ArrayList;", "getFiles", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTaskClass", "c", "getServerUrl", "e", "Z", "getAutoDeleteSuccessfullyUploadedFiles", AuthSource.BOOKING_ORDER, "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/util/ArrayList;Lnet/gotev/uploadservice/persistence/PersistableData;)V", "Companion", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class UploadTaskParameters implements Parcelable, Persistable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    public final int d;
    public final boolean e;
    @NotNull
    public final ArrayList<UploadFile> f;
    @NotNull
    public final PersistableData g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lnet/gotev/uploadservice/data/UploadTaskParameters$Companion;", "Lnet/gotev/uploadservice/persistence/Persistable$Creator;", "Lnet/gotev/uploadservice/data/UploadTaskParameters;", "Lnet/gotev/uploadservice/persistence/PersistableData;", "data", "createFromPersistableData", "(Lnet/gotev/uploadservice/persistence/PersistableData;)Lnet/gotev/uploadservice/data/UploadTaskParameters;", "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion implements Persistable.Creator<UploadTaskParameters> {
        public Companion() {
        }

        public Companion(j jVar) {
        }

        @Override // net.gotev.uploadservice.persistence.Persistable.Creator
        @NotNull
        public UploadTaskParameters createFromPersistableData(@NotNull PersistableData persistableData) {
            Intrinsics.checkNotNullParameter(persistableData, "data");
            String string = persistableData.getString("taskClass");
            String string2 = persistableData.getString("id");
            String string3 = persistableData.getString("serverUrl");
            int i = persistableData.getInt("maxRetries");
            boolean z = persistableData.getBoolean("autoDeleteFiles");
            List<PersistableData> arrayData = persistableData.getArrayData("files");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(arrayData, 10));
            Iterator<T> it = arrayData.iterator();
            while (it.hasNext()) {
                arrayList.add(UploadFile.Companion.createFromPersistableData((PersistableData) it.next()));
            }
            return new UploadTaskParameters(string, string2, string3, i, z, new ArrayList(arrayList), persistableData.getData("params"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            boolean z = parcel.readInt() != 0;
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add((UploadFile) UploadFile.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new UploadTaskParameters(readString, readString2, readString3, readInt, z, arrayList, (PersistableData) parcel.readParcelable(UploadTaskParameters.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i) {
            return new UploadTaskParameters[i];
        }
    }

    public UploadTaskParameters(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, boolean z, @NotNull ArrayList<UploadFile> arrayList, @NotNull PersistableData persistableData) {
        Intrinsics.checkNotNullParameter(str, "taskClass");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "serverUrl");
        Intrinsics.checkNotNullParameter(arrayList, "files");
        Intrinsics.checkNotNullParameter(persistableData, "additionalParameters");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = z;
        this.f = arrayList;
        this.g = persistableData;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: net.gotev.uploadservice.data.UploadTaskParameters */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UploadTaskParameters copy$default(UploadTaskParameters uploadTaskParameters, String str, String str2, String str3, int i, boolean z, ArrayList arrayList, PersistableData persistableData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = uploadTaskParameters.a;
        }
        if ((i2 & 2) != 0) {
            str2 = uploadTaskParameters.b;
        }
        if ((i2 & 4) != 0) {
            str3 = uploadTaskParameters.c;
        }
        if ((i2 & 8) != 0) {
            i = uploadTaskParameters.d;
        }
        if ((i2 & 16) != 0) {
            z = uploadTaskParameters.e;
        }
        if ((i2 & 32) != 0) {
            arrayList = uploadTaskParameters.f;
        }
        if ((i2 & 64) != 0) {
            persistableData = uploadTaskParameters.g;
        }
        return uploadTaskParameters.copy(str, str2, str3, i, z, arrayList, persistableData);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    @NotNull
    public final ArrayList<UploadFile> component6() {
        return this.f;
    }

    @NotNull
    public final PersistableData component7() {
        return this.g;
    }

    @NotNull
    public final UploadTaskParameters copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, boolean z, @NotNull ArrayList<UploadFile> arrayList, @NotNull PersistableData persistableData) {
        Intrinsics.checkNotNullParameter(str, "taskClass");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "serverUrl");
        Intrinsics.checkNotNullParameter(arrayList, "files");
        Intrinsics.checkNotNullParameter(persistableData, "additionalParameters");
        return new UploadTaskParameters(str, str2, str3, i, z, arrayList, persistableData);
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
        if (!(obj instanceof UploadTaskParameters)) {
            return false;
        }
        UploadTaskParameters uploadTaskParameters = (UploadTaskParameters) obj;
        return Intrinsics.areEqual(this.a, uploadTaskParameters.a) && Intrinsics.areEqual(this.b, uploadTaskParameters.b) && Intrinsics.areEqual(this.c, uploadTaskParameters.c) && this.d == uploadTaskParameters.d && this.e == uploadTaskParameters.e && Intrinsics.areEqual(this.f, uploadTaskParameters.f) && Intrinsics.areEqual(this.g, uploadTaskParameters.g);
    }

    @NotNull
    public final PersistableData getAdditionalParameters() {
        return this.g;
    }

    public final boolean getAutoDeleteSuccessfullyUploadedFiles() {
        return this.e;
    }

    @NotNull
    public final ArrayList<UploadFile> getFiles() {
        return this.f;
    }

    @NotNull
    public final String getId() {
        return this.b;
    }

    public final int getMaxRetries() {
        return this.d;
    }

    @NotNull
    public final String getServerUrl() {
        return this.c;
    }

    @NotNull
    public final String getTaskClass() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.d) * 31;
        boolean z = this.e;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode3 + i2) * 31;
        ArrayList<UploadFile> arrayList = this.f;
        int hashCode4 = (i5 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        PersistableData persistableData = this.g;
        if (persistableData != null) {
            i = persistableData.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // net.gotev.uploadservice.persistence.Persistable
    @NotNull
    public PersistableData toPersistableData() {
        PersistableData persistableData = new PersistableData();
        persistableData.putString("taskClass", this.a);
        persistableData.putString("id", this.b);
        persistableData.putString("serverUrl", this.c);
        persistableData.putInt("maxRetries", this.d);
        persistableData.putBoolean("autoDeleteFiles", this.e);
        ArrayList<UploadFile> arrayList = this.f;
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().toPersistableData());
        }
        persistableData.putArrayData("files", arrayList2);
        persistableData.putData("params", this.g);
        return persistableData;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("UploadTaskParameters(taskClass=");
        L.append(this.a);
        L.append(", id=");
        L.append(this.b);
        L.append(", serverUrl=");
        L.append(this.c);
        L.append(", maxRetries=");
        L.append(this.d);
        L.append(", autoDeleteSuccessfullyUploadedFiles=");
        L.append(this.e);
        L.append(", files=");
        L.append(this.f);
        L.append(", additionalParameters=");
        L.append(this.g);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e ? 1 : 0);
        ArrayList<UploadFile> arrayList = this.f;
        parcel.writeInt(arrayList.size());
        for (UploadFile uploadFile : arrayList) {
            uploadFile.writeToParcel(parcel, 0);
        }
        parcel.writeParcelable(this.g, i);
    }
}
