package com.avito.android.remote.model.messenger.deal_action;

import a2.b.a.a.a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.messenger.PlatformSupport;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.Parcels;
import com.facebook.share.internal.ShareConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.context.ChannelDealAction;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/messenger/deal_action/DealAction;", "Lru/avito/messenger/api/entity/context/ChannelDealAction;", "Landroid/os/Parcelable;", "<init>", "()V", "Action", "None", "Lcom/avito/android/remote/model/messenger/deal_action/DealAction$Action;", "Lcom/avito/android/remote/model/messenger/deal_action/DealAction$None;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class DealAction implements ChannelDealAction, Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\nR\u001a\u0010\"\u001a\u00020\u00168Æ\u0002@\u0006¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b'\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010\u0004¨\u0006,"}, d2 = {"Lcom/avito/android/remote/model/messenger/deal_action/DealAction$Action;", "Lcom/avito/android/remote/model/messenger/deal_action/DealAction;", "", "component1", "()Ljava/lang/String;", "Landroid/net/Uri;", "component2", "()Landroid/net/Uri;", "Lcom/avito/android/remote/model/messenger/PlatformSupport;", "component3", "()Lcom/avito/android/remote/model/messenger/PlatformSupport;", "title", ShareConstants.MEDIA_URI, PlatformActions.PLATFORM_SUPPORT, "copy", "(Ljava/lang/String;Landroid/net/Uri;Lcom/avito/android/remote/model/messenger/PlatformSupport;)Lcom/avito/android/remote/model/messenger/deal_action/DealAction$Action;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/messenger/PlatformSupport;", "getPlatformSupport", "isSupported", "()Z", "isSupported$annotations", "()V", "Landroid/net/Uri;", "getUri", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Lcom/avito/android/remote/model/messenger/PlatformSupport;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Action extends DealAction {
        public static final Parcelable.Creator<Action> CREATOR = new Creator();
        @Nullable
        private final PlatformSupport platformSupport;
        @NotNull
        private final String title;
        @NotNull
        private final Uri uri;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Action> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Action createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Action(parcel.readString(), (Uri) parcel.readParcelable(Action.class.getClassLoader()), parcel.readInt() != 0 ? PlatformSupport.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Action[] newArray(int i) {
                return new Action[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Action(@NotNull String str, @NotNull Uri uri2, @Nullable PlatformSupport platformSupport2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            this.title = str;
            this.uri = uri2;
            this.platformSupport = platformSupport2;
        }

        public static /* synthetic */ Action copy$default(Action action, String str, Uri uri2, PlatformSupport platformSupport2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = action.title;
            }
            if ((i & 2) != 0) {
                uri2 = action.uri;
            }
            if ((i & 4) != 0) {
                platformSupport2 = action.platformSupport;
            }
            return action.copy(str, uri2, platformSupport2);
        }

        public static /* synthetic */ void isSupported$annotations() {
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final Uri component2() {
            return this.uri;
        }

        @Nullable
        public final PlatformSupport component3() {
            return this.platformSupport;
        }

        @NotNull
        public final Action copy(@NotNull String str, @NotNull Uri uri2, @Nullable PlatformSupport platformSupport2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new Action(str, uri2, platformSupport2);
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
            if (!(obj instanceof Action)) {
                return false;
            }
            Action action = (Action) obj;
            return Intrinsics.areEqual(this.title, action.title) && Intrinsics.areEqual(this.uri, action.uri) && Intrinsics.areEqual(this.platformSupport, action.platformSupport);
        }

        @Nullable
        public final PlatformSupport getPlatformSupport() {
            return this.platformSupport;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final Uri getUri() {
            return this.uri;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Uri uri2 = this.uri;
            int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
            PlatformSupport platformSupport2 = this.platformSupport;
            if (platformSupport2 != null) {
                i = platformSupport2.hashCode();
            }
            return hashCode2 + i;
        }

        public final boolean isSupported() {
            List<String> platforms;
            PlatformSupport platformSupport2 = getPlatformSupport();
            if (platformSupport2 == null || (platforms = platformSupport2.getPlatforms()) == null) {
                return true;
            }
            return platforms.contains("android");
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Action(title=");
            L.append(this.title);
            L.append(", uri=");
            L.append(this.uri);
            L.append(", platformSupport=");
            L.append(this.platformSupport);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeParcelable(this.uri, i);
            PlatformSupport platformSupport2 = this.platformSupport;
            if (platformSupport2 != null) {
                parcel.writeInt(1);
                platformSupport2.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Action(String str, Uri uri2, PlatformSupport platformSupport2, int i, j jVar) {
            this(str, uri2, (i & 4) != 0 ? null : platformSupport2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/messenger/deal_action/DealAction$None;", "Lcom/avito/android/remote/model/messenger/deal_action/DealAction;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class None extends DealAction {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<None> CREATOR = Parcels.creator(DealAction$None$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/messenger/deal_action/DealAction$None$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/messenger/deal_action/DealAction$None;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public None() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            return this == obj || (obj instanceof None);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return None.class.hashCode();
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return "DealAction.None()";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@Nullable Parcel parcel, int i) {
        }
    }

    private DealAction() {
    }

    public /* synthetic */ DealAction(j jVar) {
        this();
    }
}
