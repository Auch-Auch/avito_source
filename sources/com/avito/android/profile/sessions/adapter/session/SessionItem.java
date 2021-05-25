package com.avito.android.profile.sessions.adapter.session;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.profile.sessions.adapter.SessionsListItem;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001%B9\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR!\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001a\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001d\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u001b\u0010!\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/profile/sessions/adapter/session/SessionItem;", "Lcom/avito/android/profile/sessions/adapter/SessionsListItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/profile/sessions/adapter/session/SessionItem$Action;", "d", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "actions", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", AuthSource.BOOKING_ORDER, "getSubtitle", MessengerShareContentUtility.SUBTITLE, "c", "getStringId", "stringId", "", "e", "Ljava/lang/Boolean;", "isCurrent", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "Action", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionItem implements SessionsListItem {
    public static final Parcelable.Creator<SessionItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @Nullable
    public final List<Action> d;
    @Nullable
    public final Boolean e;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001&B)\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/avito/android/profile/sessions/adapter/session/SessionItem$Action;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "d", "Z", "isLoading", "()Z", "setLoading", "(Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "Lcom/avito/android/profile/sessions/adapter/session/SessionItem$Action$Type;", "c", "Lcom/avito/android/profile/sessions/adapter/session/SessionItem$Action$Type;", "getType", "()Lcom/avito/android/profile/sessions/adapter/session/SessionItem$Action$Type;", "type", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/profile/sessions/adapter/session/SessionItem$Action$Type;Z)V", "Type", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Action implements Parcelable {
        public static final Parcelable.Creator<Action> CREATOR = new Creator();
        @NotNull
        public final String a;
        @NotNull
        public final DeepLink b;
        @NotNull
        public final Type c;
        public boolean d;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Action> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Action createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Action(parcel.readString(), (DeepLink) parcel.readParcelable(Action.class.getClassLoader()), (Type) Enum.valueOf(Type.class, parcel.readString()), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Action[] newArray(int i) {
                return new Action[i];
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/profile/sessions/adapter/session/SessionItem$Action$Type;", "", "<init>", "(Ljava/lang/String;I)V", "ALARM", "LOGOUT", "profile_release"}, k = 1, mv = {1, 4, 2})
        public enum Type {
            ALARM,
            LOGOUT
        }

        public Action(@NotNull String str, @NotNull DeepLink deepLink, @NotNull Type type, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(deepLink, "deeplink");
            Intrinsics.checkNotNullParameter(type, "type");
            this.a = str;
            this.b = deepLink;
            this.c = type;
            this.d = z;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final DeepLink getDeeplink() {
            return this.b;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        @NotNull
        public final Type getType() {
            return this.c;
        }

        public final boolean isLoading() {
            return this.d;
        }

        public final void setLoading(boolean z) {
            this.d = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeParcelable(this.b, i);
            parcel.writeString(this.c.name());
            parcel.writeInt(this.d ? 1 : 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Action(String str, DeepLink deepLink, Type type, boolean z, int i, j jVar) {
            this(str, deepLink, type, (i & 8) != 0 ? false : z);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SessionItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SessionItem createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Action.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new SessionItem(readString, readString2, readString3, arrayList, bool);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SessionItem[] newArray(int i) {
            return new SessionItem[i];
        }
    }

    public SessionItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable List<Action> list, @Nullable Boolean bool) {
        a.Z0(str, "title", str2, MessengerShareContentUtility.SUBTITLE, str3, "stringId");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
        this.e = bool;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<Action> getActions() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SessionsListItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @NotNull
    public final String getSubtitle() {
        return this.b;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    @Nullable
    public final Boolean isCurrent() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        List<Action> list = this.d;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((Action) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.e;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
    }
}
