package ru.avito.messenger.api.entity.body;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\b\b\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B#\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b#\u0010$J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J2\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u000bJ\u001a\u0010\u001c\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\"\u0010\u000e¨\u0006&"}, d2 = {"Lru/avito/messenger/api/entity/body/Text;", "Lru/avito/messenger/api/entity/body/MessageBody;", "Lru/avito/messenger/api/entity/body/HasRandomId;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Boolean;", "text", MessageBody.RANDOM_ID, "urlsAreTrusted", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lru/avito/messenger/api/entity/body/Text;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRandomId", "Ljava/lang/Boolean;", "getUrlsAreTrusted", "getText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class Text implements MessageBody, HasRandomId {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Text> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName(MessageBody.RANDOM_ID)
    @Nullable
    private final String randomId;
    @SerializedName("text")
    @NotNull
    private final String text;
    @SerializedName("urlsAreTrusted")
    @Nullable
    private final Boolean urlsAreTrusted;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lru/avito/messenger/api/entity/body/Text$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lru/avito/messenger/api/entity/body/Text;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, Text> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Text invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new Text(a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readString(), Boolean.valueOf(ParcelsKt.readBool(parcel2)));
        }
    }

    public Text(@NotNull String str, @Nullable String str2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.text = str;
        this.randomId = str2;
        this.urlsAreTrusted = bool;
    }

    public static /* synthetic */ Text copy$default(Text text2, String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = text2.text;
        }
        if ((i & 2) != 0) {
            str2 = text2.getRandomId();
        }
        if ((i & 4) != 0) {
            bool = text2.urlsAreTrusted;
        }
        return text2.copy(str, str2, bool);
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    @Nullable
    public final String component2() {
        return getRandomId();
    }

    @Nullable
    public final Boolean component3() {
        return this.urlsAreTrusted;
    }

    @NotNull
    public final Text copy(@NotNull String str, @Nullable String str2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new Text(str, str2, bool);
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
        if (!(obj instanceof Text)) {
            return false;
        }
        Text text2 = (Text) obj;
        return Intrinsics.areEqual(this.text, text2.text) && Intrinsics.areEqual(getRandomId(), text2.getRandomId()) && Intrinsics.areEqual(this.urlsAreTrusted, text2.urlsAreTrusted);
    }

    @Override // ru.avito.messenger.api.entity.body.HasRandomId
    @Nullable
    public String getRandomId() {
        return this.randomId;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final Boolean getUrlsAreTrusted() {
        return this.urlsAreTrusted;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.text;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String randomId2 = getRandomId();
        int hashCode2 = (hashCode + (randomId2 != null ? randomId2.hashCode() : 0)) * 31;
        Boolean bool = this.urlsAreTrusted;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Text(text=");
        L.append(this.text);
        L.append(", randomId=");
        L.append(getRandomId());
        L.append(", urlsAreTrusted=");
        return a2.b.a.a.a.o(L, this.urlsAreTrusted, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.text);
        parcel.writeString(getRandomId());
        Boolean bool = this.urlsAreTrusted;
        ParcelsKt.writeBool(parcel, bool != null ? bool.booleanValue() : false);
    }
}
