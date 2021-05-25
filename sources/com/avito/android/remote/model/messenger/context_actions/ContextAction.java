package com.avito.android.remote.model.messenger.context_actions;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.messenger.ActionConfirmation;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010!\u001a\u00020\n\u0012\u0006\u0010#\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b%\u0010&J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\r\u0010\tJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u00020\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\fR\u001c\u0010!\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\fR\u001c\u0010#\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010\f¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/ContextAction;", "Landroid/os/Parcelable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;", "handler", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;", "getHandler", "()Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;", "Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "confirmation", "Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "getConfirmation", "()Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "analytics", "Ljava/lang/String;", "getAnalytics", "title", "getTitle", "type", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;Lcom/avito/android/remote/model/messenger/ActionConfirmation;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ContextAction implements Parcelable {
    public static final Parcelable.Creator<ContextAction> CREATOR = new Creator();
    @SerializedName("analytics")
    @Nullable
    private final String analytics;
    @SerializedName("confirmation")
    @Nullable
    private final ActionConfirmation confirmation;
    @SerializedName("handler")
    @NotNull
    private final ContextActionHandler handler;
    @SerializedName("text")
    @NotNull
    private final String title;
    @SerializedName("type")
    @NotNull
    private final String type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ContextAction> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContextAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ContextAction(parcel.readString(), parcel.readString(), (ContextActionHandler) parcel.readParcelable(ContextAction.class.getClassLoader()), parcel.readInt() != 0 ? ActionConfirmation.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContextAction[] newArray(int i) {
            return new ContextAction[i];
        }
    }

    public ContextAction(@NotNull String str, @NotNull String str2, @NotNull ContextActionHandler contextActionHandler, @Nullable ActionConfirmation actionConfirmation, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(contextActionHandler, "handler");
        this.title = str;
        this.type = str2;
        this.handler = contextActionHandler;
        this.confirmation = actionConfirmation;
        this.analytics = str3;
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
        if (!(obj instanceof ContextAction)) {
            return false;
        }
        ContextAction contextAction = (ContextAction) obj;
        return !(Intrinsics.areEqual(this.title, contextAction.title) ^ true) && !(Intrinsics.areEqual(this.type, contextAction.type) ^ true) && !(Intrinsics.areEqual(this.handler, contextAction.handler) ^ true) && !(Intrinsics.areEqual(this.confirmation, contextAction.confirmation) ^ true) && !(Intrinsics.areEqual(this.analytics, contextAction.analytics) ^ true);
    }

    @Nullable
    public final String getAnalytics() {
        return this.analytics;
    }

    @Nullable
    public final ActionConfirmation getConfirmation() {
        return this.confirmation;
    }

    @NotNull
    public final ContextActionHandler getHandler() {
        return this.handler;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = (this.handler.hashCode() + a.B0(this.type, this.title.hashCode() * 31, 31)) * 31;
        ActionConfirmation actionConfirmation = this.confirmation;
        int i = 0;
        int hashCode2 = (hashCode + (actionConfirmation != null ? actionConfirmation.hashCode() : 0)) * 31;
        String str = this.analytics;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ContextAction(title='");
        L.append(this.title);
        L.append("', type='");
        L.append(this.type);
        L.append("', handler=");
        L.append(this.handler);
        L.append(')');
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.type);
        parcel.writeParcelable(this.handler, i);
        ActionConfirmation actionConfirmation = this.confirmation;
        if (actionConfirmation != null) {
            parcel.writeInt(1);
            actionConfirmation.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.analytics);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContextAction(String str, String str2, ContextActionHandler contextActionHandler, ActionConfirmation actionConfirmation, String str3, int i, j jVar) {
        this(str, str2, contextActionHandler, (i & 8) != 0 ? null : actionConfirmation, (i & 16) != 0 ? null : str3);
    }
}
