package com.avito.android.deep_linking.links;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002.-B3\u0012\u0006\u0010%\u001a\u00020 \u0012\b\b\u0002\u0010\u001f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b+\u0010,J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0019\u0010%\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010*\u001a\u00020\n8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b&\u0010\u001a\u0012\u0004\b(\u0010)\u001a\u0004\b'\u0010\u001c¨\u0006/"}, d2 = {"Lcom/avito/android/deep_linking/links/PhoneManagementLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "", g.a, "Ljava/util/List;", "getReplacingPhones", "()Ljava/util/List;", "setReplacingPhones", "(Ljava/util/List;)V", "replacingPhones", "f", "I", "getAdvertCount", "()I", "setAdvertCount", "(I)V", "advertCount", "e", "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "setPhone", "(Ljava/lang/String;)V", "phone", "Lcom/avito/android/deep_linking/links/PhoneManagementLink$ActionType;", "d", "Lcom/avito/android/deep_linking/links/PhoneManagementLink$ActionType;", "getActionType", "()Lcom/avito/android/deep_linking/links/PhoneManagementLink$ActionType;", "actionType", "c", "getPath", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "<init>", "(Lcom/avito/android/deep_linking/links/PhoneManagementLink$ActionType;Ljava/lang/String;ILjava/util/List;)V", "Companion", "ActionType", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneManagementLink extends DeepLink {
    public static final Parcelable.Creator<PhoneManagementLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/phone/management";
    @NotNull
    public final String c;
    @NotNull
    public final ActionType d;
    @NotNull
    public String e;
    public int f;
    @NotNull
    public List<String> g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/deep_linking/links/PhoneManagementLink$ActionType;", "", "<init>", "(Ljava/lang/String;I)V", "REPLACE", "REPLACE_AND_DELETE", "DELETE", "SET_TO_ALL", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum ActionType {
        REPLACE,
        REPLACE_AND_DELETE,
        DELETE,
        SET_TO_ALL
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/links/PhoneManagementLink$Companion;", "", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PhoneManagementLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneManagementLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PhoneManagementLink((ActionType) Enum.valueOf(ActionType.class, parcel.readString()), parcel.readString(), parcel.readInt(), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneManagementLink[] newArray(int i) {
            return new PhoneManagementLink[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhoneManagementLink(ActionType actionType, String str, int i, List list, int i2, j jVar) {
        this(actionType, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @NotNull
    public final ActionType getActionType() {
        return this.d;
    }

    public final int getAdvertCount() {
        return this.f;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @NotNull
    public final String getPhone() {
        return this.e;
    }

    @NotNull
    public final List<String> getReplacingPhones() {
        return this.g;
    }

    public final void setAdvertCount(int i) {
        this.f = i;
    }

    public final void setPhone(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public final void setReplacingPhones(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.g = list;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.d.name());
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeStringList(this.g);
    }

    public PhoneManagementLink(@NotNull ActionType actionType, @NotNull String str, int i, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(list, "replacingPhones");
        this.d = actionType;
        this.e = str;
        this.f = i;
        this.g = list;
        this.c = PATH;
    }
}
