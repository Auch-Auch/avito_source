package ru.avito.messenger.api.entity.body;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b \u0010!J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0016\u0010\nJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0012\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\r¨\u0006#"}, d2 = {"Lru/avito/messenger/api/entity/body/MsgSystem;", "Lru/avito/messenger/api/entity/body/MessageBody;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "Lcom/google/gson/JsonElement;", "component2", "()Lcom/google/gson/JsonElement;", "text", "payload", "copy", "(Ljava/lang/String;Lcom/google/gson/JsonElement;)Lru/avito/messenger/api/entity/body/MsgSystem;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/google/gson/JsonElement;", "getPayload", "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;Lcom/google/gson/JsonElement;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MsgSystem implements MessageBody {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<MsgSystem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final Gson a = new Gson();
    @SerializedName("payload")
    @NotNull
    private final JsonElement payload;
    @SerializedName("text")
    @NotNull
    private final String text;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lru/avito/messenger/api/entity/body/MsgSystem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lru/avito/messenger/api/entity/body/MsgSystem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/google/gson/Gson;", "GSON", "Lcom/google/gson/Gson;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, MsgSystem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public MsgSystem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            Gson gson = MsgSystem.a;
            String readString = parcel2.readString();
            Intrinsics.checkNotNull(readString);
            Intrinsics.checkNotNullExpressionValue(readString, "readString()!!");
            Object fromJson = gson.fromJson(readString, (Class<Object>) JsonElement.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson<T>(jsonString, T::class.java)");
            return new MsgSystem(u2, (JsonElement) fromJson);
        }
    }

    public MsgSystem(@NotNull String str, @NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(jsonElement, "payload");
        this.text = str;
        this.payload = jsonElement;
    }

    public static /* synthetic */ MsgSystem copy$default(MsgSystem msgSystem, String str, JsonElement jsonElement, int i, Object obj) {
        if ((i & 1) != 0) {
            str = msgSystem.text;
        }
        if ((i & 2) != 0) {
            jsonElement = msgSystem.payload;
        }
        return msgSystem.copy(str, jsonElement);
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    @NotNull
    public final JsonElement component2() {
        return this.payload;
    }

    @NotNull
    public final MsgSystem copy(@NotNull String str, @NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(jsonElement, "payload");
        return new MsgSystem(str, jsonElement);
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
        if (!(obj instanceof MsgSystem)) {
            return false;
        }
        MsgSystem msgSystem = (MsgSystem) obj;
        return Intrinsics.areEqual(this.text, msgSystem.text) && Intrinsics.areEqual(this.payload, msgSystem.payload);
    }

    @NotNull
    public final JsonElement getPayload() {
        return this.payload;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.text;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        JsonElement jsonElement = this.payload;
        if (jsonElement != null) {
            i = jsonElement.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("MsgSystem(text=");
        L.append(this.text);
        L.append(", payload=");
        L.append(this.payload);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.text);
        parcel.writeString(a.toJson(this.payload));
    }
}
