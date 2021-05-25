package net.gotev.uploadservice.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.android.parcel.Parcelize;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.persistence.Persistable;
import net.gotev.uploadservice.persistence.PersistableData;
import net.gotev.uploadservice.schemehandlers.SchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.c;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\b\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b5\u00106J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00062\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR#\u0010'\u001a\u00020 8F@\u0006X\u0002¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010&\u001a\u0004\b#\u0010$R*\u0010.\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00168F@FX\u000e¢\u0006\u0012\u0012\u0004\b-\u0010&\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\bR%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\t8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u000b¨\u00068"}, d2 = {"Lnet/gotev/uploadservice/data/UploadFile;", "Landroid/os/Parcelable;", "Lnet/gotev/uploadservice/persistence/Persistable;", "Lnet/gotev/uploadservice/persistence/PersistableData;", "toPersistableData", "()Lnet/gotev/uploadservice/persistence/PersistableData;", "", "component1", "()Ljava/lang/String;", "Ljava/util/LinkedHashMap;", "component2", "()Ljava/util/LinkedHashMap;", MessageMetaInfo.COLUMN_PATH, "properties", "copy", "(Ljava/lang/String;Ljava/util/LinkedHashMap;)Lnet/gotev/uploadservice/data/UploadFile;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getHandler", "()Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "getHandler$annotations", "()V", "handler", "value", "getSuccessfullyUploaded", "()Z", "setSuccessfullyUploaded", "(Z)V", "getSuccessfullyUploaded$annotations", "successfullyUploaded", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPath", "c", "Ljava/util/LinkedHashMap;", "getProperties", "<init>", "(Ljava/lang/String;Ljava/util/LinkedHashMap;)V", "Companion", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class UploadFile implements Parcelable, Persistable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final Lazy a;
    @NotNull
    public final String b;
    @NotNull
    public final LinkedHashMap<String, String> c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lnet/gotev/uploadservice/data/UploadFile$Companion;", "Lnet/gotev/uploadservice/persistence/Persistable$Creator;", "Lnet/gotev/uploadservice/data/UploadFile;", "Lnet/gotev/uploadservice/persistence/PersistableData;", "data", "createFromPersistableData", "(Lnet/gotev/uploadservice/persistence/PersistableData;)Lnet/gotev/uploadservice/data/UploadFile;", "", "successfulUpload", "Ljava/lang/String;", "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion implements Persistable.Creator<UploadFile> {
        public Companion() {
        }

        public Companion(j jVar) {
        }

        @Override // net.gotev.uploadservice.persistence.Persistable.Creator
        @NotNull
        public UploadFile createFromPersistableData(@NotNull PersistableData persistableData) {
            Intrinsics.checkNotNullParameter(persistableData, "data");
            String string = persistableData.getString(MessageMetaInfo.COLUMN_PATH);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Bundle bundle = persistableData.getData("props").toBundle();
            Set<String> keySet = bundle.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "bundle.keySet()");
            for (T t : keySet) {
                String string2 = bundle.getString(t);
                Intrinsics.checkNotNull(string2);
                linkedHashMap.put(t, string2);
            }
            Unit unit = Unit.INSTANCE;
            return new UploadFile(string, linkedHashMap);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            while (readInt != 0) {
                readInt = a2.b.a.a.a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
            }
            return new UploadFile(readString, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i) {
            return new UploadFile[i];
        }
    }

    public static final class a extends Lambda implements Function0<SchemeHandler> {
        public final /* synthetic */ UploadFile a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(UploadFile uploadFile) {
            super(0);
            this.a = uploadFile;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public SchemeHandler invoke() {
            return UploadServiceConfig.getSchemeHandler(this.a.getPath());
        }
    }

    @JvmOverloads
    public UploadFile(@NotNull String str) {
        this(str, null, 2, null);
    }

    @JvmOverloads
    public UploadFile(@NotNull String str, @NotNull LinkedHashMap<String, String> linkedHashMap) {
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        Intrinsics.checkNotNullParameter(linkedHashMap, "properties");
        this.b = str;
        this.c = linkedHashMap;
        this.a = c.lazy(new a(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: net.gotev.uploadservice.data.UploadFile */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UploadFile copy$default(UploadFile uploadFile, String str, LinkedHashMap linkedHashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadFile.b;
        }
        if ((i & 2) != 0) {
            linkedHashMap = uploadFile.c;
        }
        return uploadFile.copy(str, linkedHashMap);
    }

    public static /* synthetic */ void getHandler$annotations() {
    }

    public static /* synthetic */ void getSuccessfullyUploaded$annotations() {
    }

    @NotNull
    public final String component1() {
        return this.b;
    }

    @NotNull
    public final LinkedHashMap<String, String> component2() {
        return this.c;
    }

    @NotNull
    public final UploadFile copy(@NotNull String str, @NotNull LinkedHashMap<String, String> linkedHashMap) {
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        Intrinsics.checkNotNullParameter(linkedHashMap, "properties");
        return new UploadFile(str, linkedHashMap);
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
        if (!(obj instanceof UploadFile)) {
            return false;
        }
        UploadFile uploadFile = (UploadFile) obj;
        return Intrinsics.areEqual(this.b, uploadFile.b) && Intrinsics.areEqual(this.c, uploadFile.c);
    }

    @NotNull
    public final SchemeHandler getHandler() {
        return (SchemeHandler) this.a.getValue();
    }

    @NotNull
    public final String getPath() {
        return this.b;
    }

    @NotNull
    public final LinkedHashMap<String, String> getProperties() {
        return this.c;
    }

    public final boolean getSuccessfullyUploaded() {
        String str = this.c.get("successful_upload");
        if (str != null) {
            return Boolean.parseBoolean(str);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.b;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        LinkedHashMap<String, String> linkedHashMap = this.c;
        if (linkedHashMap != null) {
            i = linkedHashMap.hashCode();
        }
        return hashCode + i;
    }

    public final void setSuccessfullyUploaded(boolean z) {
        this.c.put("successful_upload", String.valueOf(z));
    }

    @Override // net.gotev.uploadservice.persistence.Persistable
    @NotNull
    public PersistableData toPersistableData() {
        PersistableData persistableData = new PersistableData();
        persistableData.putString(MessageMetaInfo.COLUMN_PATH, this.b);
        PersistableData persistableData2 = new PersistableData();
        Set<Map.Entry<String, String>> entrySet = this.c.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "properties.entries");
        for (T t : entrySet) {
            String str = (String) t.getKey();
            String str2 = (String) t.getValue();
            Intrinsics.checkNotNullExpressionValue(str, "propKey");
            Intrinsics.checkNotNullExpressionValue(str2, "propVal");
            persistableData2.putString(str, str2);
        }
        persistableData.putData("props", persistableData2);
        return persistableData;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("UploadFile(path=");
        L.append(this.b);
        L.append(", properties=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.b);
        LinkedHashMap<String, String> linkedHashMap = this.c;
        parcel.writeInt(linkedHashMap.size());
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadFile(String str, LinkedHashMap linkedHashMap, int i, j jVar) {
        this(str, (i & 2) != 0 ? new LinkedHashMap() : linkedHashMap);
    }
}
