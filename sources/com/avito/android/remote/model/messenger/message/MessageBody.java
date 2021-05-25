package com.avito.android.remote.model.messenger.message;

import a2.b.a.a.a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.CheckResult;
import androidx.annotation.Keep;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.MarkersRequest;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.parse.adapter.UriTypeAdapter;
import com.avito.android.util.preferences.GeoContract;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.plus.PlusShare;
import com.google.common.net.HttpHeaders;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.body.HasRandomId;
import t6.r.a.j;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u000f\u0005\u0006\u0004\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u000e\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody;", "Landroid/os/Parcelable;", "<init>", "()V", "Companion", "AppCall", "Call", "Deleted", "File", "ImageBody", "ImageReference", "Item", "ItemReference", HttpHeaders.LINK, "LocalImage", HttpHeaders.LOCATION, "SystemMessageBody", "Text", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lcom/avito/android/remote/model/messenger/message/MessageBody$ItemReference;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$ImageReference;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Link;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Item;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$ImageBody;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$LocalImage;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Text;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Call;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$AppCall;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$File;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Unknown;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Deleted;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class MessageBody implements Parcelable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String RANDOM_ID = "randomId";

    @Parcelize
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u0000 '2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001'B#\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u0006J0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0006J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010\tR\u0019\u0010\u000b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b$\u0010\u0006¨\u0006("}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$AppCall;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "Lru/avito/messenger/api/entity/body/MessageBody;", "Lru/avito/messenger/api/entity/body/HasRandomId;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Action;", "component2", "()Lcom/avito/android/remote/model/Action;", "component3", "text", "call", MessageBody.RANDOM_ID, "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Action;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$AppCall;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getRandomId", "Lcom/avito/android/remote/model/Action;", "getCall", "getText", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Action;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class AppCall extends MessageBody implements ru.avito.messenger.api.entity.body.MessageBody, HasRandomId {
        @NotNull
        public static final String CALL = "call";
        public static final Parcelable.Creator<AppCall> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String TEXT = "text";
        @NotNull
        public static final String TYPE = "appCall";
        @NotNull
        private final Action call;
        @Nullable
        private final String randomId;
        @NotNull
        private final String text;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$AppCall$Companion;", "", "", "CALL", "Ljava/lang/String;", "TEXT", "TYPE", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<AppCall> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AppCall createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new AppCall(parcel.readString(), (Action) parcel.readParcelable(AppCall.class.getClassLoader()), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AppCall[] newArray(int i) {
                return new AppCall[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AppCall(String str, Action action, String str2, int i, j jVar) {
            this(str, action, (i & 4) != 0 ? null : str2);
        }

        public static /* synthetic */ AppCall copy$default(AppCall appCall, String str, Action action, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = appCall.text;
            }
            if ((i & 2) != 0) {
                action = appCall.call;
            }
            if ((i & 4) != 0) {
                str2 = appCall.getRandomId();
            }
            return appCall.copy(str, action, str2);
        }

        @NotNull
        public final String component1() {
            return this.text;
        }

        @NotNull
        public final Action component2() {
            return this.call;
        }

        @Nullable
        public final String component3() {
            return getRandomId();
        }

        @NotNull
        public final AppCall copy(@NotNull String str, @NotNull Action action, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(action, "call");
            return new AppCall(str, action, str2);
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
            if (!(obj instanceof AppCall)) {
                return false;
            }
            AppCall appCall = (AppCall) obj;
            return Intrinsics.areEqual(this.text, appCall.text) && Intrinsics.areEqual(this.call, appCall.call) && Intrinsics.areEqual(getRandomId(), appCall.getRandomId());
        }

        @NotNull
        public final Action getCall() {
            return this.call;
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

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.text;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Action action = this.call;
            int hashCode2 = (hashCode + (action != null ? action.hashCode() : 0)) * 31;
            String randomId2 = getRandomId();
            if (randomId2 != null) {
                i = randomId2.hashCode();
            }
            return hashCode2 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("AppCall(text=");
            L.append(this.text);
            L.append(", call=");
            L.append(this.call);
            L.append(", randomId=");
            L.append(getRandomId());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.text);
            parcel.writeParcelable(this.call, i);
            parcel.writeString(this.randomId);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AppCall(@NotNull String str, @NotNull Action action, @Nullable String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(action, "call");
            this.text = str;
            this.call = action;
            this.randomId = str2;
        }
    }

    @Parcelize
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\rJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Call;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "", "component1", "()Z", "isIncoming", "copy", "(Z)Lcom/avito/android/remote/model/messenger/message/MessageBody$Call;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "<init>", "(Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Call extends MessageBody {
        public static final Parcelable.Creator<Call> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String TYPE = "missed_call";
        private final boolean isIncoming;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Call$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Call> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Call createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Call(parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Call[] newArray(int i) {
                return new Call[i];
            }
        }

        public Call(boolean z) {
            super(null);
            this.isIncoming = z;
        }

        public static /* synthetic */ Call copy$default(Call call, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = call.isIncoming;
            }
            return call.copy(z);
        }

        public final boolean component1() {
            return this.isIncoming;
        }

        @NotNull
        public final Call copy(boolean z) {
            return new Call(z);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Call) && this.isIncoming == ((Call) obj).isIncoming;
            }
            return true;
        }

        @Override // java.lang.Object
        public int hashCode() {
            boolean z = this.isIncoming;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isIncoming() {
            return this.isIncoming;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.B(a.L("Call(isIncoming="), this.isIncoming, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.isIncoming ? 1 : 0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Companion;", "", "", "RANDOM_ID", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Parcelize
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001!B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001e\u0010\u0006¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Deleted;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "Lru/avito/messenger/api/entity/body/MessageBody;", "Lru/avito/messenger/api/entity/body/HasRandomId;", "", "component1", "()Ljava/lang/String;", "component2", "text", MessageBody.RANDOM_ID, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$Deleted;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getRandomId", "getText", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Deleted extends MessageBody implements ru.avito.messenger.api.entity.body.MessageBody, HasRandomId {
        public static final Parcelable.Creator<Deleted> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String TYPE = "deleted";
        @Nullable
        private final String randomId;
        @NotNull
        private final String text;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Deleted$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Deleted> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Deleted createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Deleted(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Deleted[] newArray(int i) {
                return new Deleted[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Deleted(String str, String str2, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        public static /* synthetic */ Deleted copy$default(Deleted deleted, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deleted.text;
            }
            if ((i & 2) != 0) {
                str2 = deleted.getRandomId();
            }
            return deleted.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.text;
        }

        @Nullable
        public final String component2() {
            return getRandomId();
        }

        @NotNull
        public final Deleted copy(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new Deleted(str, str2);
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
            if (!(obj instanceof Deleted)) {
                return false;
            }
            Deleted deleted = (Deleted) obj;
            return Intrinsics.areEqual(this.text, deleted.text) && Intrinsics.areEqual(getRandomId(), deleted.getRandomId());
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

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.text;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String randomId2 = getRandomId();
            if (randomId2 != null) {
                i = randomId2.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Deleted(text=");
            L.append(this.text);
            L.append(", randomId=");
            L.append(getRandomId());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.text);
            parcel.writeString(this.randomId);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Deleted(@NotNull String str, @Nullable String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
            this.randomId = str2;
        }
    }

    @Parcelize
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001-B5\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0006J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\u0006JF\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b&\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b'\u0010\u0006R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b(\u0010\u0006R\u001c\u0010\u000f\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b*\u0010\n¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$File;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "Lru/avito/messenger/api/entity/body/MessageBody;", "Lru/avito/messenger/api/entity/body/HasRandomId;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "component4", "component5", File.FILE_ID, "name", File.SIZE_IN_BYTES, File.MIME_TYPE, MessageBody.RANDOM_ID, "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$File;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getRandomId", "getFileId", "getName", "getMimeType", "J", "getSizeBytes", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class File extends MessageBody implements ru.avito.messenger.api.entity.body.MessageBody, HasRandomId {
        public static final Parcelable.Creator<File> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String FILE_ID = "fileId";
        @NotNull
        public static final String MIME_TYPE = "mimeType";
        @NotNull
        public static final String NAME = "name";
        @NotNull
        public static final String SIZE_IN_BYTES = "sizeBytes";
        @NotNull
        public static final String TYPE = "file";
        @SerializedName(FILE_ID)
        @NotNull
        private final String fileId;
        @SerializedName(MIME_TYPE)
        @Nullable
        private final String mimeType;
        @SerializedName("name")
        @NotNull
        private final String name;
        @SerializedName(MessageBody.RANDOM_ID)
        @Nullable
        private final String randomId;
        @SerializedName(SIZE_IN_BYTES)
        private final long sizeBytes;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$File$Companion;", "", "", "FILE_ID", "Ljava/lang/String;", "MIME_TYPE", "NAME", "SIZE_IN_BYTES", "TYPE", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<File> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final File createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new File(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final File[] newArray(int i) {
                return new File[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ File(String str, String str2, long j, String str3, String str4, int i, j jVar) {
            this(str, str2, j, str3, (i & 16) != 0 ? null : str4);
        }

        public static /* synthetic */ File copy$default(File file, String str, String str2, long j, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = file.fileId;
            }
            if ((i & 2) != 0) {
                str2 = file.name;
            }
            if ((i & 4) != 0) {
                j = file.sizeBytes;
            }
            if ((i & 8) != 0) {
                str3 = file.mimeType;
            }
            if ((i & 16) != 0) {
                str4 = file.getRandomId();
            }
            return file.copy(str, str2, j, str3, str4);
        }

        @NotNull
        public final String component1() {
            return this.fileId;
        }

        @NotNull
        public final String component2() {
            return this.name;
        }

        public final long component3() {
            return this.sizeBytes;
        }

        @Nullable
        public final String component4() {
            return this.mimeType;
        }

        @Nullable
        public final String component5() {
            return getRandomId();
        }

        @NotNull
        public final File copy(@NotNull String str, @NotNull String str2, long j, @Nullable String str3, @Nullable String str4) {
            Intrinsics.checkNotNullParameter(str, FILE_ID);
            Intrinsics.checkNotNullParameter(str2, "name");
            return new File(str, str2, j, str3, str4);
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
            if (!(obj instanceof File)) {
                return false;
            }
            File file = (File) obj;
            return Intrinsics.areEqual(this.fileId, file.fileId) && Intrinsics.areEqual(this.name, file.name) && this.sizeBytes == file.sizeBytes && Intrinsics.areEqual(this.mimeType, file.mimeType) && Intrinsics.areEqual(getRandomId(), file.getRandomId());
        }

        @NotNull
        public final String getFileId() {
            return this.fileId;
        }

        @Nullable
        public final String getMimeType() {
            return this.mimeType;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @Override // ru.avito.messenger.api.entity.body.HasRandomId
        @Nullable
        public String getRandomId() {
            return this.randomId;
        }

        public final long getSizeBytes() {
            return this.sizeBytes;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.fileId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.name;
            int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + c.a(this.sizeBytes)) * 31;
            String str3 = this.mimeType;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String randomId2 = getRandomId();
            if (randomId2 != null) {
                i = randomId2.hashCode();
            }
            return hashCode3 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("File(fileId=");
            L.append(this.fileId);
            L.append(", name=");
            L.append(this.name);
            L.append(", sizeBytes=");
            L.append(this.sizeBytes);
            L.append(", mimeType=");
            L.append(this.mimeType);
            L.append(", randomId=");
            L.append(getRandomId());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.fileId);
            parcel.writeString(this.name);
            parcel.writeLong(this.sizeBytes);
            parcel.writeString(this.mimeType);
            parcel.writeString(this.randomId);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public File(@NotNull String str, @NotNull String str2, long j, @Nullable String str3, @Nullable String str4) {
            super(null);
            Intrinsics.checkNotNullParameter(str, FILE_ID);
            Intrinsics.checkNotNullParameter(str2, "name");
            this.fileId = str;
            this.name = str2;
            this.sizeBytes = j;
            this.mimeType = str3;
            this.randomId = str4;
        }
    }

    @Parcelize
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$ImageBody;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "Lcom/avito/android/remote/model/Image;", "component1", "()Lcom/avito/android/remote/model/Image;", "image", "copy", "(Lcom/avito/android/remote/model/Image;)Lcom/avito/android/remote/model/messenger/message/MessageBody$ImageBody;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(Lcom/avito/android/remote/model/Image;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ImageBody extends MessageBody {
        public static final Parcelable.Creator<ImageBody> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String TYPE = "image";
        @NotNull
        private final Image image;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$ImageBody$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ImageBody> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ImageBody createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ImageBody((Image) parcel.readParcelable(ImageBody.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ImageBody[] newArray(int i) {
                return new ImageBody[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ImageBody(@NotNull Image image2) {
            super(null);
            Intrinsics.checkNotNullParameter(image2, "image");
            this.image = image2;
        }

        public static /* synthetic */ ImageBody copy$default(ImageBody imageBody, Image image2, int i, Object obj) {
            if ((i & 1) != 0) {
                image2 = imageBody.image;
            }
            return imageBody.copy(image2);
        }

        @NotNull
        public final Image component1() {
            return this.image;
        }

        @NotNull
        public final ImageBody copy(@NotNull Image image2) {
            Intrinsics.checkNotNullParameter(image2, "image");
            return new ImageBody(image2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof ImageBody) && Intrinsics.areEqual(this.image, ((ImageBody) obj).image);
            }
            return true;
        }

        @NotNull
        public final Image getImage() {
            return this.image;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Image image2 = this.image;
            if (image2 != null) {
                return image2.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("ImageBody(image=");
            L.append(this.image);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.image, i);
        }
    }

    @Parcelize
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$ImageReference;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "", "component1", "()Ljava/lang/String;", "imageId", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$ImageReference;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getImageId", "<init>", "(Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ImageReference extends MessageBody {
        public static final Parcelable.Creator<ImageReference> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String TYPE = "image_ref";
        @NotNull
        private final String imageId;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$ImageReference$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ImageReference> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ImageReference createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ImageReference(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ImageReference[] newArray(int i) {
                return new ImageReference[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ImageReference(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "imageId");
            this.imageId = str;
        }

        public static /* synthetic */ ImageReference copy$default(ImageReference imageReference, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = imageReference.imageId;
            }
            return imageReference.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.imageId;
        }

        @NotNull
        public final ImageReference copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "imageId");
            return new ImageReference(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof ImageReference) && Intrinsics.areEqual(this.imageId, ((ImageReference) obj).imageId);
            }
            return true;
        }

        @NotNull
        public final String getImageId() {
            return this.imageId;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.imageId;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.t(a.L("ImageReference(imageId="), this.imageId, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.imageId);
        }
    }

    @Parcelize
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u0000 .2\u00020\u0001:\u0001.BI\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004JT\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b&\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b)\u0010\tR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b*\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b+\u0010\u0004¨\u0006/"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Item;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/avito/android/remote/model/Image;", "component4", "()Lcom/avito/android/remote/model/Image;", "component5", "component6", "id", ChannelContext.Item.USER_ID, "title", "image", "price", "location", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$Item;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getLocation", "getId", "Lcom/avito/android/remote/model/Image;", "getImage", "getPrice", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Item extends MessageBody {
        public static final Parcelable.Creator<Item> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String TYPE = "item";
        @NotNull
        private final String id;
        @Nullable
        private final Image image;
        @Nullable
        private final String location;
        @Nullable
        private final String price;
        @NotNull
        private final String title;
        @Nullable
        private final String userId;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Item$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Item> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Item createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Item(parcel.readString(), parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(Item.class.getClassLoader()), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Item[] newArray(int i) {
                return new Item[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Item(String str, String str2, String str3, Image image2, String str4, String str5, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : image2, (i & 16) != 0 ? null : str4, (i & 32) == 0 ? str5 : null);
        }

        public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, Image image2, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = item.id;
            }
            if ((i & 2) != 0) {
                str2 = item.userId;
            }
            if ((i & 4) != 0) {
                str3 = item.title;
            }
            if ((i & 8) != 0) {
                image2 = item.image;
            }
            if ((i & 16) != 0) {
                str4 = item.price;
            }
            if ((i & 32) != 0) {
                str5 = item.location;
            }
            return item.copy(str, str2, str3, image2, str4, str5);
        }

        @NotNull
        public final String component1() {
            return this.id;
        }

        @Nullable
        public final String component2() {
            return this.userId;
        }

        @NotNull
        public final String component3() {
            return this.title;
        }

        @Nullable
        public final Image component4() {
            return this.image;
        }

        @Nullable
        public final String component5() {
            return this.price;
        }

        @Nullable
        public final String component6() {
            return this.location;
        }

        @NotNull
        public final Item copy(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable Image image2, @Nullable String str4, @Nullable String str5) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str3, "title");
            return new Item(str, str2, str3, image2, str4, str5);
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
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual(this.id, item.id) && Intrinsics.areEqual(this.userId, item.userId) && Intrinsics.areEqual(this.title, item.title) && Intrinsics.areEqual(this.image, item.image) && Intrinsics.areEqual(this.price, item.price) && Intrinsics.areEqual(this.location, item.location);
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final Image getImage() {
            return this.image;
        }

        @Nullable
        public final String getLocation() {
            return this.location;
        }

        @Nullable
        public final String getPrice() {
            return this.price;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getUserId() {
            return this.userId;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.id;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.userId;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.title;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Image image2 = this.image;
            int hashCode4 = (hashCode3 + (image2 != null ? image2.hashCode() : 0)) * 31;
            String str4 = this.price;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.location;
            if (str5 != null) {
                i = str5.hashCode();
            }
            return hashCode5 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Item(id=");
            L.append(this.id);
            L.append(", userId=");
            L.append(this.userId);
            L.append(", title=");
            L.append(this.title);
            L.append(", image=");
            L.append(this.image);
            L.append(", price=");
            L.append(this.price);
            L.append(", location=");
            return a.t(L, this.location, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.userId);
            parcel.writeString(this.title);
            parcel.writeParcelable(this.image, i);
            parcel.writeString(this.price);
            parcel.writeString(this.location);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Item(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable Image image2, @Nullable String str4, @Nullable String str5) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str3, "title");
            this.id = str;
            this.userId = str2;
            this.title = str3;
            this.image = image2;
            this.price = str4;
            this.location = str5;
        }
    }

    @Parcelize
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$ItemReference;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "", "component1", "()Ljava/lang/String;", "itemId", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$ItemReference;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getItemId", "<init>", "(Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ItemReference extends MessageBody {
        public static final Parcelable.Creator<ItemReference> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String TYPE = "item_ref";
        @NotNull
        private final String itemId;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$ItemReference$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ItemReference> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ItemReference createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ItemReference(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ItemReference[] newArray(int i) {
                return new ItemReference[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemReference(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "itemId");
            this.itemId = str;
        }

        public static /* synthetic */ ItemReference copy$default(ItemReference itemReference, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemReference.itemId;
            }
            return itemReference.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.itemId;
        }

        @NotNull
        public final ItemReference copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            return new ItemReference(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof ItemReference) && Intrinsics.areEqual(this.itemId, ((ItemReference) obj).itemId);
            }
            return true;
        }

        @NotNull
        public final String getItemId() {
            return this.itemId;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.itemId;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.t(a.L("ItemReference(itemId="), this.itemId, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.itemId);
        }
    }

    @Parcelize
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002,-B1\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0006J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ<\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0017J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\nR\u0019\u0010\u000f\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010\u000eR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b)\u0010\u0006¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Link;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "Lru/avito/messenger/api/entity/body/MessageBody;", "Lru/avito/messenger/api/entity/body/HasRandomId;", "", "toString", "()Ljava/lang/String;", "component1", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview;", "component2", "()Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview;", "component3", "", "component4", "()Z", "url", "preview", MessageBody.RANDOM_ID, "urlsAreTrusted", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview;Ljava/lang/String;Z)Lcom/avito/android/remote/model/messenger/message/MessageBody$Link;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview;", "getPreview", "Ljava/lang/String;", "getUrl", "Z", "getUrlsAreTrusted", "getRandomId", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview;Ljava/lang/String;Z)V", "Companion", "Preview", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Link extends MessageBody implements ru.avito.messenger.api.entity.body.MessageBody, HasRandomId {
        public static final Parcelable.Creator<Link> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String TYPE = "link";
        @Nullable
        private final Preview preview;
        @Nullable
        private final String randomId;
        @NotNull
        private final String url;
        private final boolean urlsAreTrusted;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Link> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Link createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Link(parcel.readString(), (Preview) parcel.readParcelable(Link.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Link[] newArray(int i) {
                return new Link[i];
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\b¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/Image;", "image", "withImage", "(Lcom/avito/android/remote/model/Image;)Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview;", "", "getImageId", "()Ljava/lang/String;", "imageId", "getImage", "()Lcom/avito/android/remote/model/Image;", "<init>", "()V", "Image", "Snippet", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview$Snippet;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview$Image;", "models_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Preview implements Parcelable {

            @Parcelize
            @Keep
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b6\u00107J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011Jj\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b#\u0010\u001eJ \u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b(\u0010)R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b-\u0010\u0004R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b/\u0010\u0011R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b0\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u00101\u001a\u0004\b2\u0010\tR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u00103\u001a\u0004\b4\u0010\rR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b5\u0010\u0004¨\u00068"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview$Image;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview;", "", "toString", "()Ljava/lang/String;", "component1", "component2", "", "component3", "()Z", "component4", "Lcom/avito/android/remote/model/Image;", "component5", "()Lcom/avito/android/remote/model/Image;", "component6", "", "component7", "()Ljava/lang/Integer;", "component8", "url", "domain", "trusted", "imageId", "image", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, "thumbnailWidth", "thumbnailHeight", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview$Image;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getThumbnailUrl", "getUrl", "getDomain", "Ljava/lang/Integer;", "getThumbnailWidth", "getThumbnailHeight", "Z", "getTrusted", "Lcom/avito/android/remote/model/Image;", "getImage", "getImageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Image extends Preview {
                public static final Parcelable.Creator<Image> CREATOR = new Creator();
                @NotNull
                private final String domain;
                @Nullable
                private final com.avito.android.remote.model.Image image;
                @Nullable
                private final String imageId;
                @Nullable
                private final Integer thumbnailHeight;
                @Nullable
                private final String thumbnailUrl;
                @Nullable
                private final Integer thumbnailWidth;
                private final boolean trusted;
                @NotNull
                private final String url;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Image> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Image createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new Image(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), (com.avito.android.remote.model.Image) parcel.readParcelable(Image.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Image[] newArray(int i) {
                        return new Image[i];
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Image(@NotNull String str, @NotNull String str2, boolean z, @Nullable String str3, @Nullable com.avito.android.remote.model.Image image2, @Nullable String str4, @Nullable Integer num, @Nullable Integer num2) {
                    super(null);
                    Intrinsics.checkNotNullParameter(str, "url");
                    Intrinsics.checkNotNullParameter(str2, "domain");
                    this.url = str;
                    this.domain = str2;
                    this.trusted = z;
                    this.imageId = str3;
                    this.image = image2;
                    this.thumbnailUrl = str4;
                    this.thumbnailWidth = num;
                    this.thumbnailHeight = num2;
                }

                public static /* synthetic */ Image copy$default(Image image2, String str, String str2, boolean z, String str3, com.avito.android.remote.model.Image image3, String str4, Integer num, Integer num2, int i, Object obj) {
                    return image2.copy((i & 1) != 0 ? image2.url : str, (i & 2) != 0 ? image2.domain : str2, (i & 4) != 0 ? image2.trusted : z, (i & 8) != 0 ? image2.getImageId() : str3, (i & 16) != 0 ? image2.getImage() : image3, (i & 32) != 0 ? image2.thumbnailUrl : str4, (i & 64) != 0 ? image2.thumbnailWidth : num, (i & 128) != 0 ? image2.thumbnailHeight : num2);
                }

                @NotNull
                public final String component1() {
                    return this.url;
                }

                @NotNull
                public final String component2() {
                    return this.domain;
                }

                public final boolean component3() {
                    return this.trusted;
                }

                @Nullable
                public final String component4() {
                    return getImageId();
                }

                @Nullable
                public final com.avito.android.remote.model.Image component5() {
                    return getImage();
                }

                @Nullable
                public final String component6() {
                    return this.thumbnailUrl;
                }

                @Nullable
                public final Integer component7() {
                    return this.thumbnailWidth;
                }

                @Nullable
                public final Integer component8() {
                    return this.thumbnailHeight;
                }

                @NotNull
                public final Image copy(@NotNull String str, @NotNull String str2, boolean z, @Nullable String str3, @Nullable com.avito.android.remote.model.Image image2, @Nullable String str4, @Nullable Integer num, @Nullable Integer num2) {
                    Intrinsics.checkNotNullParameter(str, "url");
                    Intrinsics.checkNotNullParameter(str2, "domain");
                    return new Image(str, str2, z, str3, image2, str4, num, num2);
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
                    if (!(obj instanceof Image)) {
                        return false;
                    }
                    Image image2 = (Image) obj;
                    return Intrinsics.areEqual(this.url, image2.url) && Intrinsics.areEqual(this.domain, image2.domain) && this.trusted == image2.trusted && Intrinsics.areEqual(getImageId(), image2.getImageId()) && Intrinsics.areEqual(getImage(), image2.getImage()) && Intrinsics.areEqual(this.thumbnailUrl, image2.thumbnailUrl) && Intrinsics.areEqual(this.thumbnailWidth, image2.thumbnailWidth) && Intrinsics.areEqual(this.thumbnailHeight, image2.thumbnailHeight);
                }

                @NotNull
                public final String getDomain() {
                    return this.domain;
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.Link.Preview
                @Nullable
                public com.avito.android.remote.model.Image getImage() {
                    return this.image;
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.Link.Preview
                @Nullable
                public String getImageId() {
                    return this.imageId;
                }

                @Nullable
                public final Integer getThumbnailHeight() {
                    return this.thumbnailHeight;
                }

                @Nullable
                public final String getThumbnailUrl() {
                    return this.thumbnailUrl;
                }

                @Nullable
                public final Integer getThumbnailWidth() {
                    return this.thumbnailWidth;
                }

                public final boolean getTrusted() {
                    return this.trusted;
                }

                @NotNull
                public final String getUrl() {
                    return this.url;
                }

                @Override // java.lang.Object
                public int hashCode() {
                    String str = this.url;
                    int i = 0;
                    int hashCode = (str != null ? str.hashCode() : 0) * 31;
                    String str2 = this.domain;
                    int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                    boolean z = this.trusted;
                    if (z) {
                        z = true;
                    }
                    int i2 = z ? 1 : 0;
                    int i3 = z ? 1 : 0;
                    int i4 = z ? 1 : 0;
                    int i5 = (hashCode2 + i2) * 31;
                    String imageId2 = getImageId();
                    int hashCode3 = (i5 + (imageId2 != null ? imageId2.hashCode() : 0)) * 31;
                    com.avito.android.remote.model.Image image2 = getImage();
                    int hashCode4 = (hashCode3 + (image2 != null ? image2.hashCode() : 0)) * 31;
                    String str3 = this.thumbnailUrl;
                    int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
                    Integer num = this.thumbnailWidth;
                    int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 31;
                    Integer num2 = this.thumbnailHeight;
                    if (num2 != null) {
                        i = num2.hashCode();
                    }
                    return hashCode6 + i;
                }

                @Override // java.lang.Object
                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Image(\n                        |   url='");
                    L.append(this.url);
                    L.append("',\n                        |   domain='");
                    L.append(this.domain);
                    L.append("',\n                        |   trusted=");
                    L.append(this.trusted);
                    L.append(",\n                        |   imageId=");
                    L.append(getImageId());
                    L.append(",\n                        |   image=");
                    L.append(getImage());
                    L.append(",\n                        |   thumbnailUrl=");
                    L.append(this.thumbnailUrl);
                    L.append(",\n                        |   thumbnailWidth=");
                    L.append(this.thumbnailWidth);
                    L.append(",\n                        |   thumbnailHeight=");
                    return f.trimMargin$default(a.p(L, this.thumbnailHeight, "\n                        |)"), null, 1, null);
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeString(this.url);
                    parcel.writeString(this.domain);
                    parcel.writeInt(this.trusted ? 1 : 0);
                    parcel.writeString(this.imageId);
                    parcel.writeParcelable(this.image, i);
                    parcel.writeString(this.thumbnailUrl);
                    Integer num = this.thumbnailWidth;
                    if (num != null) {
                        a.H0(parcel, 1, num);
                    } else {
                        parcel.writeInt(0);
                    }
                    Integer num2 = this.thumbnailHeight;
                    if (num2 != null) {
                        a.H0(parcel, 1, num2);
                    } else {
                        parcel.writeInt(0);
                    }
                }
            }

            @Parcelize
            @Keep
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bB\u0010CJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b+\u0010&J \u00100\u001a\u00020/2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b0\u00101R\u001b\u0010!\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b!\u00102\u001a\u0004\b3\u0010\u0015R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00102\u001a\u0004\b4\u0010\u0015R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b6\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u00105\u001a\u0004\b7\u0010\u0004R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b9\u0010\u0011R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00105\u001a\u0004\b:\u0010\u0004R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00105\u001a\u0004\b;\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00105\u001a\u0004\b<\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010=\u001a\u0004\b>\u0010\nR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u00105\u001a\u0004\b?\u0010\u0004R\u001b\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u00105\u001a\u0004\b@\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00105\u001a\u0004\bA\u0010\u0004¨\u0006D"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview$Snippet;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview;", "", "toString", "()Ljava/lang/String;", "component1", "component2", "component3", "", "component4", "()Z", "component5", "component6", "component7", "component8", "Lcom/avito/android/remote/model/Image;", "component9", "()Lcom/avito/android/remote/model/Image;", "component10", "", "component11", "()Ljava/lang/Integer;", "component12", "url", "deepLink", "domain", "trusted", "title", MessengerShareContentUtility.SUBTITLE, "description", "imageId", "image", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, "thumbnailWidth", "thumbnailHeight", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/avito/android/remote/model/messenger/message/MessageBody$Link$Preview$Snippet;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getThumbnailWidth", "getThumbnailHeight", "Ljava/lang/String;", "getSubtitle", "getUrl", "Lcom/avito/android/remote/model/Image;", "getImage", "getDeepLink", "getDescription", "getTitle", "Z", "getTrusted", "getImageId", "getThumbnailUrl", "getDomain", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Snippet extends Preview {
                public static final Parcelable.Creator<Snippet> CREATOR = new Creator();
                @Nullable
                private final String deepLink;
                @Nullable
                private final String description;
                @NotNull
                private final String domain;
                @Nullable
                private final com.avito.android.remote.model.Image image;
                @Nullable
                private final String imageId;
                @Nullable
                private final String subtitle;
                @Nullable
                private final Integer thumbnailHeight;
                @Nullable
                private final String thumbnailUrl;
                @Nullable
                private final Integer thumbnailWidth;
                @NotNull
                private final String title;
                private final boolean trusted;
                @NotNull
                private final String url;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Snippet> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Snippet createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new Snippet(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (com.avito.android.remote.model.Image) parcel.readParcelable(Snippet.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Snippet[] newArray(int i) {
                        return new Snippet[i];
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Snippet(@NotNull String str, @Nullable String str2, @NotNull String str3, boolean z, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable com.avito.android.remote.model.Image image2, @Nullable String str8, @Nullable Integer num, @Nullable Integer num2) {
                    super(null);
                    a.Z0(str, "url", str3, "domain", str4, "title");
                    this.url = str;
                    this.deepLink = str2;
                    this.domain = str3;
                    this.trusted = z;
                    this.title = str4;
                    this.subtitle = str5;
                    this.description = str6;
                    this.imageId = str7;
                    this.image = image2;
                    this.thumbnailUrl = str8;
                    this.thumbnailWidth = num;
                    this.thumbnailHeight = num2;
                }

                public static /* synthetic */ Snippet copy$default(Snippet snippet, String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, com.avito.android.remote.model.Image image2, String str8, Integer num, Integer num2, int i, Object obj) {
                    return snippet.copy((i & 1) != 0 ? snippet.url : str, (i & 2) != 0 ? snippet.deepLink : str2, (i & 4) != 0 ? snippet.domain : str3, (i & 8) != 0 ? snippet.trusted : z, (i & 16) != 0 ? snippet.title : str4, (i & 32) != 0 ? snippet.subtitle : str5, (i & 64) != 0 ? snippet.description : str6, (i & 128) != 0 ? snippet.getImageId() : str7, (i & 256) != 0 ? snippet.getImage() : image2, (i & 512) != 0 ? snippet.thumbnailUrl : str8, (i & 1024) != 0 ? snippet.thumbnailWidth : num, (i & 2048) != 0 ? snippet.thumbnailHeight : num2);
                }

                @NotNull
                public final String component1() {
                    return this.url;
                }

                @Nullable
                public final String component10() {
                    return this.thumbnailUrl;
                }

                @Nullable
                public final Integer component11() {
                    return this.thumbnailWidth;
                }

                @Nullable
                public final Integer component12() {
                    return this.thumbnailHeight;
                }

                @Nullable
                public final String component2() {
                    return this.deepLink;
                }

                @NotNull
                public final String component3() {
                    return this.domain;
                }

                public final boolean component4() {
                    return this.trusted;
                }

                @NotNull
                public final String component5() {
                    return this.title;
                }

                @Nullable
                public final String component6() {
                    return this.subtitle;
                }

                @Nullable
                public final String component7() {
                    return this.description;
                }

                @Nullable
                public final String component8() {
                    return getImageId();
                }

                @Nullable
                public final com.avito.android.remote.model.Image component9() {
                    return getImage();
                }

                @NotNull
                public final Snippet copy(@NotNull String str, @Nullable String str2, @NotNull String str3, boolean z, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable com.avito.android.remote.model.Image image2, @Nullable String str8, @Nullable Integer num, @Nullable Integer num2) {
                    Intrinsics.checkNotNullParameter(str, "url");
                    Intrinsics.checkNotNullParameter(str3, "domain");
                    Intrinsics.checkNotNullParameter(str4, "title");
                    return new Snippet(str, str2, str3, z, str4, str5, str6, str7, image2, str8, num, num2);
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
                    if (!(obj instanceof Snippet)) {
                        return false;
                    }
                    Snippet snippet = (Snippet) obj;
                    return Intrinsics.areEqual(this.url, snippet.url) && Intrinsics.areEqual(this.deepLink, snippet.deepLink) && Intrinsics.areEqual(this.domain, snippet.domain) && this.trusted == snippet.trusted && Intrinsics.areEqual(this.title, snippet.title) && Intrinsics.areEqual(this.subtitle, snippet.subtitle) && Intrinsics.areEqual(this.description, snippet.description) && Intrinsics.areEqual(getImageId(), snippet.getImageId()) && Intrinsics.areEqual(getImage(), snippet.getImage()) && Intrinsics.areEqual(this.thumbnailUrl, snippet.thumbnailUrl) && Intrinsics.areEqual(this.thumbnailWidth, snippet.thumbnailWidth) && Intrinsics.areEqual(this.thumbnailHeight, snippet.thumbnailHeight);
                }

                @Nullable
                public final String getDeepLink() {
                    return this.deepLink;
                }

                @Nullable
                public final String getDescription() {
                    return this.description;
                }

                @NotNull
                public final String getDomain() {
                    return this.domain;
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.Link.Preview
                @Nullable
                public com.avito.android.remote.model.Image getImage() {
                    return this.image;
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.Link.Preview
                @Nullable
                public String getImageId() {
                    return this.imageId;
                }

                @Nullable
                public final String getSubtitle() {
                    return this.subtitle;
                }

                @Nullable
                public final Integer getThumbnailHeight() {
                    return this.thumbnailHeight;
                }

                @Nullable
                public final String getThumbnailUrl() {
                    return this.thumbnailUrl;
                }

                @Nullable
                public final Integer getThumbnailWidth() {
                    return this.thumbnailWidth;
                }

                @NotNull
                public final String getTitle() {
                    return this.title;
                }

                public final boolean getTrusted() {
                    return this.trusted;
                }

                @NotNull
                public final String getUrl() {
                    return this.url;
                }

                @Override // java.lang.Object
                public int hashCode() {
                    String str = this.url;
                    int i = 0;
                    int hashCode = (str != null ? str.hashCode() : 0) * 31;
                    String str2 = this.deepLink;
                    int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                    String str3 = this.domain;
                    int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                    boolean z = this.trusted;
                    if (z) {
                        z = true;
                    }
                    int i2 = z ? 1 : 0;
                    int i3 = z ? 1 : 0;
                    int i4 = z ? 1 : 0;
                    int i5 = (hashCode3 + i2) * 31;
                    String str4 = this.title;
                    int hashCode4 = (i5 + (str4 != null ? str4.hashCode() : 0)) * 31;
                    String str5 = this.subtitle;
                    int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
                    String str6 = this.description;
                    int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
                    String imageId2 = getImageId();
                    int hashCode7 = (hashCode6 + (imageId2 != null ? imageId2.hashCode() : 0)) * 31;
                    com.avito.android.remote.model.Image image2 = getImage();
                    int hashCode8 = (hashCode7 + (image2 != null ? image2.hashCode() : 0)) * 31;
                    String str7 = this.thumbnailUrl;
                    int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
                    Integer num = this.thumbnailWidth;
                    int hashCode10 = (hashCode9 + (num != null ? num.hashCode() : 0)) * 31;
                    Integer num2 = this.thumbnailHeight;
                    if (num2 != null) {
                        i = num2.hashCode();
                    }
                    return hashCode10 + i;
                }

                @Override // java.lang.Object
                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Snippet(\n                        |   url='");
                    L.append(this.url);
                    L.append("',\n                        |   deepLink=");
                    L.append(this.deepLink);
                    L.append(",\n                        |   domain='");
                    L.append(this.domain);
                    L.append("',\n                        |   trusted=");
                    L.append(this.trusted);
                    L.append(",\n                        |   title='");
                    L.append(this.title);
                    L.append("',\n                        |   subtitle=");
                    L.append(this.subtitle);
                    L.append(",\n                        |   description=");
                    L.append(this.description);
                    L.append(",\n                        |   imageId=");
                    L.append(getImageId());
                    L.append(",\n                        |   image=");
                    L.append(getImage());
                    L.append(",\n                        |   thumbnailUrl=");
                    L.append(this.thumbnailUrl);
                    L.append(",\n                        |   thumbnailWidth=");
                    L.append(this.thumbnailWidth);
                    L.append(",\n                        |   thumbnailHeight=");
                    return f.trimMargin$default(a.p(L, this.thumbnailHeight, "\n                        |)"), null, 1, null);
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeString(this.url);
                    parcel.writeString(this.deepLink);
                    parcel.writeString(this.domain);
                    parcel.writeInt(this.trusted ? 1 : 0);
                    parcel.writeString(this.title);
                    parcel.writeString(this.subtitle);
                    parcel.writeString(this.description);
                    parcel.writeString(this.imageId);
                    parcel.writeParcelable(this.image, i);
                    parcel.writeString(this.thumbnailUrl);
                    Integer num = this.thumbnailWidth;
                    if (num != null) {
                        a.H0(parcel, 1, num);
                    } else {
                        parcel.writeInt(0);
                    }
                    Integer num2 = this.thumbnailHeight;
                    if (num2 != null) {
                        a.H0(parcel, 1, num2);
                    } else {
                        parcel.writeInt(0);
                    }
                }
            }

            private Preview() {
            }

            @Nullable
            public abstract com.avito.android.remote.model.Image getImage();

            @Nullable
            public abstract String getImageId();

            @NotNull
            public final Preview withImage(@Nullable com.avito.android.remote.model.Image image) {
                if (this instanceof Snippet) {
                    return Snippet.copy$default((Snippet) this, null, null, null, false, null, null, null, null, image, null, null, null, 3839, null);
                }
                if (this instanceof Image) {
                    return Image.copy$default((Image) this, null, null, false, null, image, null, null, null, 239, null);
                }
                throw new NoWhenBranchMatchedException();
            }

            public /* synthetic */ Preview(j jVar) {
                this();
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Link(String str, Preview preview2, String str2, boolean z, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : preview2, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z);
        }

        public static /* synthetic */ Link copy$default(Link link, String str, Preview preview2, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = link.url;
            }
            if ((i & 2) != 0) {
                preview2 = link.preview;
            }
            if ((i & 4) != 0) {
                str2 = link.getRandomId();
            }
            if ((i & 8) != 0) {
                z = link.urlsAreTrusted;
            }
            return link.copy(str, preview2, str2, z);
        }

        @NotNull
        public final String component1() {
            return this.url;
        }

        @Nullable
        public final Preview component2() {
            return this.preview;
        }

        @Nullable
        public final String component3() {
            return getRandomId();
        }

        public final boolean component4() {
            return this.urlsAreTrusted;
        }

        @NotNull
        public final Link copy(@NotNull String str, @Nullable Preview preview2, @Nullable String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new Link(str, preview2, str2, z);
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
            if (!(obj instanceof Link)) {
                return false;
            }
            Link link = (Link) obj;
            return Intrinsics.areEqual(this.url, link.url) && Intrinsics.areEqual(this.preview, link.preview) && Intrinsics.areEqual(getRandomId(), link.getRandomId()) && this.urlsAreTrusted == link.urlsAreTrusted;
        }

        @Nullable
        public final Preview getPreview() {
            return this.preview;
        }

        @Override // ru.avito.messenger.api.entity.body.HasRandomId
        @Nullable
        public String getRandomId() {
            return this.randomId;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public final boolean getUrlsAreTrusted() {
            return this.urlsAreTrusted;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.url;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Preview preview2 = this.preview;
            int hashCode2 = (hashCode + (preview2 != null ? preview2.hashCode() : 0)) * 31;
            String randomId2 = getRandomId();
            if (randomId2 != null) {
                i = randomId2.hashCode();
            }
            int i2 = (hashCode2 + i) * 31;
            boolean z = this.urlsAreTrusted;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return i2 + i3;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Link(\n                |   url='");
            L.append(this.url);
            L.append("',\n                |   preview=");
            L.append(this.preview);
            L.append(",\n                |   randomId=");
            L.append(getRandomId());
            L.append(",\n                |   urlsAreTrusted=");
            return f.trimMargin$default(a.B(L, this.urlsAreTrusted, ",\n                |)"), null, 1, null);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.url);
            parcel.writeParcelable(this.preview, i);
            parcel.writeString(this.randomId);
            parcel.writeInt(this.urlsAreTrusted ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Link(@NotNull String str, @Nullable Preview preview2, @Nullable String str2, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "url");
            this.url = str;
            this.preview = preview2;
            this.randomId = str2;
            this.urlsAreTrusted = z;
        }
    }

    @Parcelize
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010\u0007¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$LocalImage;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "Landroid/net/Uri;", "component1", "()Landroid/net/Uri;", "", "component2", "()Ljava/lang/String;", "", "component3", "()J", "source", "operationId", "uploadId", "copy", "(Landroid/net/Uri;Ljava/lang/String;J)Lcom/avito/android/remote/model/messenger/message/MessageBody$LocalImage;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getUploadId", "Landroid/net/Uri;", "getSource", "Ljava/lang/String;", "getOperationId", "<init>", "(Landroid/net/Uri;Ljava/lang/String;J)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class LocalImage extends MessageBody {
        public static final Parcelable.Creator<LocalImage> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String TYPE = "local_image";
        @NotNull
        private final String operationId;
        @JsonAdapter(UriTypeAdapter.class)
        @NotNull
        private final Uri source;
        private final long uploadId;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$LocalImage$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<LocalImage> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final LocalImage createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new LocalImage((Uri) parcel.readParcelable(LocalImage.class.getClassLoader()), parcel.readString(), parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final LocalImage[] newArray(int i) {
                return new LocalImage[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LocalImage(@NotNull Uri uri, @NotNull String str, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(uri, "source");
            Intrinsics.checkNotNullParameter(str, "operationId");
            this.source = uri;
            this.operationId = str;
            this.uploadId = j;
        }

        public static /* synthetic */ LocalImage copy$default(LocalImage localImage, Uri uri, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = localImage.source;
            }
            if ((i & 2) != 0) {
                str = localImage.operationId;
            }
            if ((i & 4) != 0) {
                j = localImage.uploadId;
            }
            return localImage.copy(uri, str, j);
        }

        @NotNull
        public final Uri component1() {
            return this.source;
        }

        @NotNull
        public final String component2() {
            return this.operationId;
        }

        public final long component3() {
            return this.uploadId;
        }

        @NotNull
        public final LocalImage copy(@NotNull Uri uri, @NotNull String str, long j) {
            Intrinsics.checkNotNullParameter(uri, "source");
            Intrinsics.checkNotNullParameter(str, "operationId");
            return new LocalImage(uri, str, j);
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
            if (!(obj instanceof LocalImage)) {
                return false;
            }
            LocalImage localImage = (LocalImage) obj;
            return Intrinsics.areEqual(this.source, localImage.source) && Intrinsics.areEqual(this.operationId, localImage.operationId) && this.uploadId == localImage.uploadId;
        }

        @NotNull
        public final String getOperationId() {
            return this.operationId;
        }

        @NotNull
        public final Uri getSource() {
            return this.source;
        }

        public final long getUploadId() {
            return this.uploadId;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Uri uri = this.source;
            int i = 0;
            int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
            String str = this.operationId;
            if (str != null) {
                i = str.hashCode();
            }
            return ((hashCode + i) * 31) + c.a(this.uploadId);
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("LocalImage(source=");
            L.append(this.source);
            L.append(", operationId=");
            L.append(this.operationId);
            L.append(", uploadId=");
            return a.l(L, this.uploadId, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.source, i);
            parcel.writeString(this.operationId);
            parcel.writeLong(this.uploadId);
        }
    }

    @Parcelize
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001-B7\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJF\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001c\u0010\u000e\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010\u0006R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\nR\u001c\u0010\u000f\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b(\u0010\nR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b)\u0010\nR\u001c\u0010\r\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b*\u0010\u0006¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "Lru/avito/messenger/api/entity/body/MessageBody;", "Lru/avito/messenger/api/entity/body/HasRandomId;", "", "component1", "()D", "component2", "", "component3", "()Ljava/lang/String;", "component4", "component5", GeoContract.LATITUDE, GeoContract.LONGITUDE, "title", Location.KIND, MessageBody.RANDOM_ID, "copy", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "D", "getLongitude", "Ljava/lang/String;", "getKind", "getTitle", "getRandomId", "getLatitude", "<init>", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Location extends MessageBody implements ru.avito.messenger.api.entity.body.MessageBody, HasRandomId {
        public static final Parcelable.Creator<Location> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String KIND = "kind";
        @NotNull
        public static final String LATITUDE = "lat";
        @NotNull
        public static final String LONGITUDE = "lon";
        @NotNull
        public static final String TITLE = "title";
        @NotNull
        public static final String TYPE = "location";
        @SerializedName(KIND)
        @Nullable
        private final String kind;
        @SerializedName("lat")
        private final double latitude;
        @SerializedName(LONGITUDE)
        private final double longitude;
        @SerializedName(MessageBody.RANDOM_ID)
        @Nullable
        private final String randomId;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Location$Companion;", "", "", "KIND", "Ljava/lang/String;", "LATITUDE", "LONGITUDE", ShareConstants.TITLE, "TYPE", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Location> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Location createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Location(parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Location[] newArray(int i) {
                return new Location[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Location(double d, double d2, String str, String str2, String str3, int i, j jVar) {
            this(d, d2, str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
        }

        public static /* synthetic */ Location copy$default(Location location, double d, double d2, String str, String str2, String str3, int i, Object obj) {
            return location.copy((i & 1) != 0 ? location.latitude : d, (i & 2) != 0 ? location.longitude : d2, (i & 4) != 0 ? location.title : str, (i & 8) != 0 ? location.kind : str2, (i & 16) != 0 ? location.getRandomId() : str3);
        }

        public final double component1() {
            return this.latitude;
        }

        public final double component2() {
            return this.longitude;
        }

        @NotNull
        public final String component3() {
            return this.title;
        }

        @Nullable
        public final String component4() {
            return this.kind;
        }

        @Nullable
        public final String component5() {
            return getRandomId();
        }

        @NotNull
        public final Location copy(double d, double d2, @NotNull String str, @Nullable String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new Location(d, d2, str, str2, str3);
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
            if (!(obj instanceof Location)) {
                return false;
            }
            Location location = (Location) obj;
            return Double.compare(this.latitude, location.latitude) == 0 && Double.compare(this.longitude, location.longitude) == 0 && Intrinsics.areEqual(this.title, location.title) && Intrinsics.areEqual(this.kind, location.kind) && Intrinsics.areEqual(getRandomId(), location.getRandomId());
        }

        @Nullable
        public final String getKind() {
            return this.kind;
        }

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }

        @Override // ru.avito.messenger.api.entity.body.HasRandomId
        @Nullable
        public String getRandomId() {
            return this.randomId;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int a = ((b.a(this.latitude) * 31) + b.a(this.longitude)) * 31;
            String str = this.title;
            int i = 0;
            int hashCode = (a + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.kind;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String randomId2 = getRandomId();
            if (randomId2 != null) {
                i = randomId2.hashCode();
            }
            return hashCode2 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Location(latitude=");
            L.append(this.latitude);
            L.append(", longitude=");
            L.append(this.longitude);
            L.append(", title=");
            L.append(this.title);
            L.append(", kind=");
            L.append(this.kind);
            L.append(", randomId=");
            L.append(getRandomId());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeDouble(this.latitude);
            parcel.writeDouble(this.longitude);
            parcel.writeString(this.title);
            parcel.writeString(this.kind);
            parcel.writeString(this.randomId);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Location(double d, double d2, @NotNull String str, @Nullable String str2, @Nullable String str3) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.latitude = d;
            this.longitude = d2;
            this.title = str;
            this.kind = str2;
            this.randomId = str3;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "Lru/avito/messenger/api/entity/body/MessageBody;", "<init>", "()V", "Platform", "Text", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Text;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Unknown;", "models_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class SystemMessageBody extends MessageBody implements ru.avito.messenger.api.entity.body.MessageBody {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00132\u00020\u0001:\u0004\u0014\u0013\u0015\u0016B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0001\u0002\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody;", "", "getFallbackText", "()Ljava/lang/String;", "fallbackText", "", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "getChunks", "()Ljava/util/List;", Platform.CHUNKS, "getFlow", "flow", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "getContextActions", "()Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", Platform.CONTEXT_ACTIONS, "<init>", "()V", "Companion", "Bubble", "FromAvito", "FromUser", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$FromAvito;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$FromUser;", "models_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Platform extends SystemMessageBody {
            @NotNull
            public static final String CHUNKS = "chunks";
            @NotNull
            public static final String CONTEXT_ACTIONS = "contextActions";
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            public static final String FALLBACK_TEXT = "text";
            @NotNull
            public static final String FLOW = "flow";

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "Landroid/os/Parcelable;", "<init>", "()V", "Companion", "GeoLocation", "Image", "Item", "Text", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$Text;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$Image;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$GeoLocation;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$Item;", "models_release"}, k = 1, mv = {1, 4, 2})
            public static abstract class Bubble implements Parcelable {
                @NotNull
                public static final Companion Companion = new Companion(null);
                @NotNull
                public static final String TYPE_KEY = "type";
                @NotNull
                public static final String VALUE_KEY = "value";

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$Companion;", "", "", "TYPE_KEY", "Ljava/lang/String;", "VALUE_KEY", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
                public static final class Companion {
                    private Companion() {
                    }

                    public /* synthetic */ Companion(j jVar) {
                        this();
                    }
                }

                @Parcelize
                @Keep
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B)\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b'\u0010(J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\n2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0019\u0010\fJ\u0010\u0010\u001a\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001a\u0010\tJ \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0014\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\fR!\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010\u0010R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\u0013¨\u0006*"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$GeoLocation;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "component2", "()[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "component3", "()Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "title", ScreenPublicConstsKt.CONTENT_TYPE_MARKERS, "markersRequest", "copy", "(Ljava/lang/String;[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;)Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$GeoLocation;", "toString", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "getMarkers", "Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "getMarkersRequest", "<init>", "(Ljava/lang/String;[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
                public static final class GeoLocation extends Bubble {
                    public static final Parcelable.Creator<GeoLocation> CREATOR = new Creator();
                    @NotNull
                    public static final Companion Companion = new Companion(null);
                    @NotNull
                    public static final String TYPE = "geo_message";
                    @Nullable
                    private final GeoMarker[] markers;
                    @Nullable
                    private final MarkersRequest markersRequest;
                    @NotNull
                    private final String title;

                    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$GeoLocation$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
                    public static final class Companion {
                        private Companion() {
                        }

                        public /* synthetic */ Companion(j jVar) {
                            this();
                        }
                    }

                    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                    public static class Creator implements Parcelable.Creator<GeoLocation> {
                        @Override // android.os.Parcelable.Creator
                        @NotNull
                        public final GeoLocation createFromParcel(@NotNull Parcel parcel) {
                            GeoMarker[] geoMarkerArr;
                            Intrinsics.checkNotNullParameter(parcel, "in");
                            String readString = parcel.readString();
                            MarkersRequest markersRequest = null;
                            if (parcel.readInt() != 0) {
                                int readInt = parcel.readInt();
                                geoMarkerArr = new GeoMarker[readInt];
                                for (int i = 0; readInt > i; i++) {
                                    geoMarkerArr[i] = GeoMarker.CREATOR.createFromParcel(parcel);
                                }
                            } else {
                                geoMarkerArr = null;
                            }
                            if (parcel.readInt() != 0) {
                                markersRequest = MarkersRequest.CREATOR.createFromParcel(parcel);
                            }
                            return new GeoLocation(readString, geoMarkerArr, markersRequest);
                        }

                        @Override // android.os.Parcelable.Creator
                        @NotNull
                        public final GeoLocation[] newArray(int i) {
                            return new GeoLocation[i];
                        }
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public GeoLocation(@NotNull String str, @Nullable GeoMarker[] geoMarkerArr, @Nullable MarkersRequest markersRequest2) {
                        super(null);
                        Intrinsics.checkNotNullParameter(str, "title");
                        this.title = str;
                        this.markers = geoMarkerArr;
                        this.markersRequest = markersRequest2;
                    }

                    public static /* synthetic */ GeoLocation copy$default(GeoLocation geoLocation, String str, GeoMarker[] geoMarkerArr, MarkersRequest markersRequest2, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = geoLocation.title;
                        }
                        if ((i & 2) != 0) {
                            geoMarkerArr = geoLocation.markers;
                        }
                        if ((i & 4) != 0) {
                            markersRequest2 = geoLocation.markersRequest;
                        }
                        return geoLocation.copy(str, geoMarkerArr, markersRequest2);
                    }

                    @NotNull
                    public final String component1() {
                        return this.title;
                    }

                    @Nullable
                    public final GeoMarker[] component2() {
                        return this.markers;
                    }

                    @Nullable
                    public final MarkersRequest component3() {
                        return this.markersRequest;
                    }

                    @NotNull
                    public final GeoLocation copy(@NotNull String str, @Nullable GeoMarker[] geoMarkerArr, @Nullable MarkersRequest markersRequest2) {
                        Intrinsics.checkNotNullParameter(str, "title");
                        return new GeoLocation(str, geoMarkerArr, markersRequest2);
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
                        if (!(obj instanceof GeoLocation)) {
                            return false;
                        }
                        GeoLocation geoLocation = (GeoLocation) obj;
                        if (!Intrinsics.areEqual(this.title, geoLocation.title)) {
                            return false;
                        }
                        GeoMarker[] geoMarkerArr = this.markers;
                        if (geoMarkerArr != null) {
                            GeoMarker[] geoMarkerArr2 = geoLocation.markers;
                            if (geoMarkerArr2 == null || !Arrays.equals(geoMarkerArr, geoMarkerArr2)) {
                                return false;
                            }
                        } else if (geoLocation.markers != null) {
                            return false;
                        }
                        return !(Intrinsics.areEqual(this.markersRequest, geoLocation.markersRequest) ^ true);
                    }

                    @Nullable
                    public final GeoMarker[] getMarkers() {
                        return this.markers;
                    }

                    @Nullable
                    public final MarkersRequest getMarkersRequest() {
                        return this.markersRequest;
                    }

                    @NotNull
                    public final String getTitle() {
                        return this.title;
                    }

                    @Override // java.lang.Object
                    public int hashCode() {
                        int hashCode = this.title.hashCode() * 31;
                        GeoMarker[] geoMarkerArr = this.markers;
                        int i = 0;
                        int hashCode2 = (hashCode + (geoMarkerArr != null ? Arrays.hashCode(geoMarkerArr) : 0)) * 31;
                        MarkersRequest markersRequest2 = this.markersRequest;
                        if (markersRequest2 != null) {
                            i = markersRequest2.hashCode();
                        }
                        return hashCode2 + i;
                    }

                    @Override // java.lang.Object
                    @NotNull
                    public String toString() {
                        StringBuilder L = a.L("GeoLocation(title=");
                        L.append(this.title);
                        L.append(", markers=");
                        L.append(Arrays.toString(this.markers));
                        L.append(", markersRequest=");
                        L.append(this.markersRequest);
                        L.append(")");
                        return L.toString();
                    }

                    @Override // android.os.Parcelable
                    public void writeToParcel(@NotNull Parcel parcel, int i) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        parcel.writeString(this.title);
                        GeoMarker[] geoMarkerArr = this.markers;
                        if (geoMarkerArr != null) {
                            parcel.writeInt(1);
                            int length = geoMarkerArr.length;
                            parcel.writeInt(length);
                            for (int i2 = 0; length > i2; i2++) {
                                geoMarkerArr[i2].writeToParcel(parcel, 0);
                            }
                        } else {
                            parcel.writeInt(0);
                        }
                        MarkersRequest markersRequest2 = this.markersRequest;
                        if (markersRequest2 != null) {
                            parcel.writeInt(1);
                            markersRequest2.writeToParcel(parcel, 0);
                            return;
                        }
                        parcel.writeInt(0);
                    }
                }

                @Parcelize
                @Keep
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$Image;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "component2", "()Lcom/avito/android/remote/model/Image;", "imageId", "image", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;)Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$Image;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "getImage", "Ljava/lang/String;", "getImageId", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
                public static final class Image extends Bubble {
                    public static final Parcelable.Creator<Image> CREATOR = new Creator();
                    @NotNull
                    public static final Companion Companion = new Companion(null);
                    @NotNull
                    public static final String TYPE = "image";
                    @Nullable
                    private final com.avito.android.remote.model.Image image;
                    @NotNull
                    private final String imageId;

                    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$Image$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
                    public static final class Companion {
                        private Companion() {
                        }

                        public /* synthetic */ Companion(j jVar) {
                            this();
                        }
                    }

                    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                    public static class Creator implements Parcelable.Creator<Image> {
                        @Override // android.os.Parcelable.Creator
                        @NotNull
                        public final Image createFromParcel(@NotNull Parcel parcel) {
                            Intrinsics.checkNotNullParameter(parcel, "in");
                            return new Image(parcel.readString(), (com.avito.android.remote.model.Image) parcel.readParcelable(Image.class.getClassLoader()));
                        }

                        @Override // android.os.Parcelable.Creator
                        @NotNull
                        public final Image[] newArray(int i) {
                            return new Image[i];
                        }
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Image(@NotNull String str, @Nullable com.avito.android.remote.model.Image image2) {
                        super(null);
                        Intrinsics.checkNotNullParameter(str, "imageId");
                        this.imageId = str;
                        this.image = image2;
                    }

                    public static /* synthetic */ Image copy$default(Image image2, String str, com.avito.android.remote.model.Image image3, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = image2.imageId;
                        }
                        if ((i & 2) != 0) {
                            image3 = image2.image;
                        }
                        return image2.copy(str, image3);
                    }

                    @NotNull
                    public final String component1() {
                        return this.imageId;
                    }

                    @Nullable
                    public final com.avito.android.remote.model.Image component2() {
                        return this.image;
                    }

                    @NotNull
                    public final Image copy(@NotNull String str, @Nullable com.avito.android.remote.model.Image image2) {
                        Intrinsics.checkNotNullParameter(str, "imageId");
                        return new Image(str, image2);
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
                        if (!(obj instanceof Image)) {
                            return false;
                        }
                        Image image2 = (Image) obj;
                        return Intrinsics.areEqual(this.imageId, image2.imageId) && Intrinsics.areEqual(this.image, image2.image);
                    }

                    @Nullable
                    public final com.avito.android.remote.model.Image getImage() {
                        return this.image;
                    }

                    @NotNull
                    public final String getImageId() {
                        return this.imageId;
                    }

                    @Override // java.lang.Object
                    public int hashCode() {
                        String str = this.imageId;
                        int i = 0;
                        int hashCode = (str != null ? str.hashCode() : 0) * 31;
                        com.avito.android.remote.model.Image image2 = this.image;
                        if (image2 != null) {
                            i = image2.hashCode();
                        }
                        return hashCode + i;
                    }

                    @Override // java.lang.Object
                    @NotNull
                    public String toString() {
                        StringBuilder L = a.L("Image(imageId=");
                        L.append(this.imageId);
                        L.append(", image=");
                        L.append(this.image);
                        L.append(")");
                        return L.toString();
                    }

                    @Override // android.os.Parcelable
                    public void writeToParcel(@NotNull Parcel parcel, int i) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        parcel.writeString(this.imageId);
                        parcel.writeParcelable(this.image, i);
                    }
                }

                @Parcelize
                @Keep
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u0000 12\u00020\u0001:\u00011BE\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\\\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0019J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b$\u0010%R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b(\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b-\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b.\u0010\u0004¨\u00062"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$Item;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "Lcom/avito/android/remote/model/Image;", "component6", "()Lcom/avito/android/remote/model/Image;", "component7", "id", "title", "priceString", Item.OLD_PRICE_STRING, "locationWithMetro", "imageBySizes", Item.URI_PATH, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$Item;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "getOldPriceString", "Lcom/avito/android/remote/model/Image;", "getImageBySizes", "getPriceString", "getUriPath", "getTitle", "getLocationWithMetro", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
                public static final class Item extends Bubble {
                    public static final Parcelable.Creator<Item> CREATOR = new Creator();
                    @NotNull
                    public static final Companion Companion = new Companion(null);
                    @NotNull
                    public static final String ID = "id";
                    @NotNull
                    public static final String IMAGE_BY_SIZES = "imageBySizes";
                    @NotNull
                    public static final String LOCATION_WITH_METRO = "locationWithMetro";
                    @NotNull
                    public static final String OLD_PRICE_STRING = "oldPriceString";
                    @NotNull
                    public static final String PRICE_STRING = "priceString";
                    @NotNull
                    public static final String TITLE = "title";
                    @NotNull
                    public static final String TYPE = "item";
                    @NotNull
                    public static final String URI_PATH = "uriPath";
                    @NotNull
                    private final String id;
                    @Nullable
                    private final com.avito.android.remote.model.Image imageBySizes;
                    @Nullable
                    private final String locationWithMetro;
                    @Nullable
                    private final String oldPriceString;
                    @NotNull
                    private final String priceString;
                    @NotNull
                    private final String title;
                    @NotNull
                    private final String uriPath;

                    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$Item$Companion;", "", "", "ID", "Ljava/lang/String;", "IMAGE_BY_SIZES", "LOCATION_WITH_METRO", "OLD_PRICE_STRING", "PRICE_STRING", ShareConstants.TITLE, "TYPE", "URI_PATH", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
                    public static final class Companion {
                        private Companion() {
                        }

                        public /* synthetic */ Companion(j jVar) {
                            this();
                        }
                    }

                    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                    public static class Creator implements Parcelable.Creator<Item> {
                        @Override // android.os.Parcelable.Creator
                        @NotNull
                        public final Item createFromParcel(@NotNull Parcel parcel) {
                            Intrinsics.checkNotNullParameter(parcel, "in");
                            return new Item(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (com.avito.android.remote.model.Image) parcel.readParcelable(Item.class.getClassLoader()), parcel.readString());
                        }

                        @Override // android.os.Parcelable.Creator
                        @NotNull
                        public final Item[] newArray(int i) {
                            return new Item[i];
                        }
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Item(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable com.avito.android.remote.model.Image image, @NotNull String str6) {
                        super(null);
                        a.b1(str, "id", str2, "title", str3, "priceString", str6, URI_PATH);
                        this.id = str;
                        this.title = str2;
                        this.priceString = str3;
                        this.oldPriceString = str4;
                        this.locationWithMetro = str5;
                        this.imageBySizes = image;
                        this.uriPath = str6;
                    }

                    public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, String str4, String str5, com.avito.android.remote.model.Image image, String str6, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = item.id;
                        }
                        if ((i & 2) != 0) {
                            str2 = item.title;
                        }
                        if ((i & 4) != 0) {
                            str3 = item.priceString;
                        }
                        if ((i & 8) != 0) {
                            str4 = item.oldPriceString;
                        }
                        if ((i & 16) != 0) {
                            str5 = item.locationWithMetro;
                        }
                        if ((i & 32) != 0) {
                            image = item.imageBySizes;
                        }
                        if ((i & 64) != 0) {
                            str6 = item.uriPath;
                        }
                        return item.copy(str, str2, str3, str4, str5, image, str6);
                    }

                    @NotNull
                    public final String component1() {
                        return this.id;
                    }

                    @NotNull
                    public final String component2() {
                        return this.title;
                    }

                    @NotNull
                    public final String component3() {
                        return this.priceString;
                    }

                    @Nullable
                    public final String component4() {
                        return this.oldPriceString;
                    }

                    @Nullable
                    public final String component5() {
                        return this.locationWithMetro;
                    }

                    @Nullable
                    public final com.avito.android.remote.model.Image component6() {
                        return this.imageBySizes;
                    }

                    @NotNull
                    public final String component7() {
                        return this.uriPath;
                    }

                    @NotNull
                    public final Item copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable com.avito.android.remote.model.Image image, @NotNull String str6) {
                        Intrinsics.checkNotNullParameter(str, "id");
                        Intrinsics.checkNotNullParameter(str2, "title");
                        Intrinsics.checkNotNullParameter(str3, "priceString");
                        Intrinsics.checkNotNullParameter(str6, URI_PATH);
                        return new Item(str, str2, str3, str4, str5, image, str6);
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
                        if (!(obj instanceof Item)) {
                            return false;
                        }
                        Item item = (Item) obj;
                        return Intrinsics.areEqual(this.id, item.id) && Intrinsics.areEqual(this.title, item.title) && Intrinsics.areEqual(this.priceString, item.priceString) && Intrinsics.areEqual(this.oldPriceString, item.oldPriceString) && Intrinsics.areEqual(this.locationWithMetro, item.locationWithMetro) && Intrinsics.areEqual(this.imageBySizes, item.imageBySizes) && Intrinsics.areEqual(this.uriPath, item.uriPath);
                    }

                    @NotNull
                    public final String getId() {
                        return this.id;
                    }

                    @Nullable
                    public final com.avito.android.remote.model.Image getImageBySizes() {
                        return this.imageBySizes;
                    }

                    @Nullable
                    public final String getLocationWithMetro() {
                        return this.locationWithMetro;
                    }

                    @Nullable
                    public final String getOldPriceString() {
                        return this.oldPriceString;
                    }

                    @NotNull
                    public final String getPriceString() {
                        return this.priceString;
                    }

                    @NotNull
                    public final String getTitle() {
                        return this.title;
                    }

                    @NotNull
                    public final String getUriPath() {
                        return this.uriPath;
                    }

                    @Override // java.lang.Object
                    public int hashCode() {
                        String str = this.id;
                        int i = 0;
                        int hashCode = (str != null ? str.hashCode() : 0) * 31;
                        String str2 = this.title;
                        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                        String str3 = this.priceString;
                        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                        String str4 = this.oldPriceString;
                        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
                        String str5 = this.locationWithMetro;
                        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
                        com.avito.android.remote.model.Image image = this.imageBySizes;
                        int hashCode6 = (hashCode5 + (image != null ? image.hashCode() : 0)) * 31;
                        String str6 = this.uriPath;
                        if (str6 != null) {
                            i = str6.hashCode();
                        }
                        return hashCode6 + i;
                    }

                    @Override // java.lang.Object
                    @NotNull
                    public String toString() {
                        StringBuilder L = a.L("Item(id=");
                        L.append(this.id);
                        L.append(", title=");
                        L.append(this.title);
                        L.append(", priceString=");
                        L.append(this.priceString);
                        L.append(", oldPriceString=");
                        L.append(this.oldPriceString);
                        L.append(", locationWithMetro=");
                        L.append(this.locationWithMetro);
                        L.append(", imageBySizes=");
                        L.append(this.imageBySizes);
                        L.append(", uriPath=");
                        return a.t(L, this.uriPath, ")");
                    }

                    @Override // android.os.Parcelable
                    public void writeToParcel(@NotNull Parcel parcel, int i) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        parcel.writeString(this.id);
                        parcel.writeString(this.title);
                        parcel.writeString(this.priceString);
                        parcel.writeString(this.oldPriceString);
                        parcel.writeString(this.locationWithMetro);
                        parcel.writeParcelable(this.imageBySizes, i);
                        parcel.writeString(this.uriPath);
                    }
                }

                @Parcelize
                @Keep
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$Text;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "Lcom/avito/android/remote/model/text/AttributedText;", "component1", "()Lcom/avito/android/remote/model/text/AttributedText;", "text", "copy", "(Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$Text;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getText", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
                public static final class Text extends Bubble {
                    public static final Parcelable.Creator<Text> CREATOR = new Creator();
                    @NotNull
                    public static final Companion Companion = new Companion(null);
                    @NotNull
                    public static final String TYPE = "text";
                    @NotNull
                    private final AttributedText text;

                    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble$Text$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
                    public static final class Companion {
                        private Companion() {
                        }

                        public /* synthetic */ Companion(j jVar) {
                            this();
                        }
                    }

                    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                    public static class Creator implements Parcelable.Creator<Text> {
                        @Override // android.os.Parcelable.Creator
                        @NotNull
                        public final Text createFromParcel(@NotNull Parcel parcel) {
                            Intrinsics.checkNotNullParameter(parcel, "in");
                            return new Text((AttributedText) parcel.readParcelable(Text.class.getClassLoader()));
                        }

                        @Override // android.os.Parcelable.Creator
                        @NotNull
                        public final Text[] newArray(int i) {
                            return new Text[i];
                        }
                    }

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Text(@NotNull AttributedText attributedText) {
                        super(null);
                        Intrinsics.checkNotNullParameter(attributedText, "text");
                        this.text = attributedText;
                    }

                    public static /* synthetic */ Text copy$default(Text text2, AttributedText attributedText, int i, Object obj) {
                        if ((i & 1) != 0) {
                            attributedText = text2.text;
                        }
                        return text2.copy(attributedText);
                    }

                    @NotNull
                    public final AttributedText component1() {
                        return this.text;
                    }

                    @NotNull
                    public final Text copy(@NotNull AttributedText attributedText) {
                        Intrinsics.checkNotNullParameter(attributedText, "text");
                        return new Text(attributedText);
                    }

                    @Override // android.os.Parcelable
                    public int describeContents() {
                        return 0;
                    }

                    @Override // java.lang.Object
                    public boolean equals(@Nullable Object obj) {
                        if (this != obj) {
                            return (obj instanceof Text) && Intrinsics.areEqual(this.text, ((Text) obj).text);
                        }
                        return true;
                    }

                    @NotNull
                    public final AttributedText getText() {
                        return this.text;
                    }

                    @Override // java.lang.Object
                    public int hashCode() {
                        AttributedText attributedText = this.text;
                        if (attributedText != null) {
                            return attributedText.hashCode();
                        }
                        return 0;
                    }

                    @Override // java.lang.Object
                    @NotNull
                    public String toString() {
                        StringBuilder L = a.L("Text(text=");
                        L.append(this.text);
                        L.append(")");
                        return L.toString();
                    }

                    @Override // android.os.Parcelable
                    public void writeToParcel(@NotNull Parcel parcel, int i) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        parcel.writeParcelable(this.text, i);
                    }
                }

                private Bubble() {
                }

                public /* synthetic */ Bubble(j jVar) {
                    this();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Companion;", "", "", "CHUNKS", "Ljava/lang/String;", "CONTEXT_ACTIONS", "FALLBACK_TEXT", "FLOW", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(j jVar) {
                    this();
                }
            }

            @Parcelize
            @Keep
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u0000 ,2\u00020\u0001:\u0001,B9\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004JD\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010\u000bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010\u0004R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010'\u001a\u0004\b(\u0010\bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b)\u0010\u0004¨\u0006-"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$FromAvito;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform;", "", "toString", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "component1", "()Ljava/util/List;", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "component2", "()Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "component3", "component4", Platform.CHUNKS, Platform.CONTEXT_ACTIONS, "flow", "fallbackText", "copy", "(Ljava/util/List;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$FromAvito;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "getContextActions", "Ljava/lang/String;", "getFallbackText", "Ljava/util/List;", "getChunks", "getFlow", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class FromAvito extends Platform {
                public static final Parcelable.Creator<FromAvito> CREATOR = new Creator();
                @NotNull
                public static final Companion Companion = new Companion(null);
                @NotNull
                public static final String TYPE = "system/platform";
                @NotNull
                private final List<Bubble> chunks;
                @Nullable
                private final PlatformActions contextActions;
                @Nullable
                private final String fallbackText;
                @Nullable
                private final String flow;

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$FromAvito$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
                public static final class Companion {
                    private Companion() {
                    }

                    public /* synthetic */ Companion(j jVar) {
                        this();
                    }
                }

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<FromAvito> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final FromAvito createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        int readInt = parcel.readInt();
                        ArrayList arrayList = new ArrayList(readInt);
                        while (readInt != 0) {
                            arrayList.add((Bubble) parcel.readParcelable(FromAvito.class.getClassLoader()));
                            readInt--;
                        }
                        return new FromAvito(arrayList, (PlatformActions) parcel.readParcelable(FromAvito.class.getClassLoader()), parcel.readString(), parcel.readString());
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final FromAvito[] newArray(int i) {
                        return new FromAvito[i];
                    }
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ FromAvito(List list, PlatformActions platformActions, String str, String str2, int i, j jVar) {
                    this(list, (i & 2) != 0 ? null : platformActions, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
                }

                /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.messenger.message.MessageBody$SystemMessageBody$Platform$FromAvito */
                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ FromAvito copy$default(FromAvito fromAvito, List list, PlatformActions platformActions, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = fromAvito.getChunks();
                    }
                    if ((i & 2) != 0) {
                        platformActions = fromAvito.getContextActions();
                    }
                    if ((i & 4) != 0) {
                        str = fromAvito.getFlow();
                    }
                    if ((i & 8) != 0) {
                        str2 = fromAvito.getFallbackText();
                    }
                    return fromAvito.copy(list, platformActions, str, str2);
                }

                @NotNull
                public final List<Bubble> component1() {
                    return getChunks();
                }

                @Nullable
                public final PlatformActions component2() {
                    return getContextActions();
                }

                @Nullable
                public final String component3() {
                    return getFlow();
                }

                @Nullable
                public final String component4() {
                    return getFallbackText();
                }

                @NotNull
                public final FromAvito copy(@NotNull List<? extends Bubble> list, @Nullable PlatformActions platformActions, @Nullable String str, @Nullable String str2) {
                    Intrinsics.checkNotNullParameter(list, Platform.CHUNKS);
                    return new FromAvito(list, platformActions, str, str2);
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
                    if (!(obj instanceof FromAvito)) {
                        return false;
                    }
                    FromAvito fromAvito = (FromAvito) obj;
                    return Intrinsics.areEqual(getChunks(), fromAvito.getChunks()) && Intrinsics.areEqual(getContextActions(), fromAvito.getContextActions()) && Intrinsics.areEqual(getFlow(), fromAvito.getFlow()) && Intrinsics.areEqual(getFallbackText(), fromAvito.getFallbackText());
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform
                @NotNull
                public List<Bubble> getChunks() {
                    return this.chunks;
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform
                @Nullable
                public PlatformActions getContextActions() {
                    return this.contextActions;
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform
                @Nullable
                public String getFallbackText() {
                    return this.fallbackText;
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform
                @Nullable
                public String getFlow() {
                    return this.flow;
                }

                @Override // java.lang.Object
                public int hashCode() {
                    List<Bubble> chunks2 = getChunks();
                    int i = 0;
                    int hashCode = (chunks2 != null ? chunks2.hashCode() : 0) * 31;
                    PlatformActions contextActions2 = getContextActions();
                    int hashCode2 = (hashCode + (contextActions2 != null ? contextActions2.hashCode() : 0)) * 31;
                    String flow2 = getFlow();
                    int hashCode3 = (hashCode2 + (flow2 != null ? flow2.hashCode() : 0)) * 31;
                    String fallbackText2 = getFallbackText();
                    if (fallbackText2 != null) {
                        i = fallbackText2.hashCode();
                    }
                    return hashCode3 + i;
                }

                @Override // java.lang.Object
                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Platform.FromAvito(\n                            |   chunks=[");
                    L.append(getChunks().size());
                    L.append("]:");
                    L.append(getChunks());
                    L.append(",\n                            |   contextActions = ");
                    L.append(getContextActions());
                    L.append(",\n                            |   flow = ");
                    L.append(getFlow());
                    L.append(",\n                            |   fallbackText = ");
                    L.append(getFallbackText());
                    L.append("\n                            |)");
                    return f.trimMargin$default(L.toString(), null, 1, null);
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    Iterator n0 = a.n0(this.chunks, parcel);
                    while (n0.hasNext()) {
                        parcel.writeParcelable((Bubble) n0.next(), i);
                    }
                    parcel.writeParcelable(this.contextActions, i);
                    parcel.writeString(this.flow);
                    parcel.writeString(this.fallbackText);
                }

                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.messenger.message.MessageBody$SystemMessageBody$Platform$Bubble> */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public FromAvito(@NotNull List<? extends Bubble> list, @Nullable PlatformActions platformActions, @Nullable String str, @Nullable String str2) {
                    super(null);
                    Intrinsics.checkNotNullParameter(list, Platform.CHUNKS);
                    this.chunks = list;
                    this.contextActions = platformActions;
                    this.flow = str;
                    this.fallbackText = str2;
                }
            }

            @Parcelize
            @Keep
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u0000 ,2\u00020\u0001:\u0001,B9\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004JD\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\u0004R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b(\u0010\u000bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b)\u0010\u0004¨\u0006-"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$FromUser;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform;", "", "toString", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "component1", "()Ljava/util/List;", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "component2", "()Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "component3", "component4", Platform.CHUNKS, Platform.CONTEXT_ACTIONS, "flow", "fallbackText", "copy", "(Ljava/util/List;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$FromUser;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getFlow", "Ljava/util/List;", "getChunks", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "getContextActions", "getFallbackText", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class FromUser extends Platform {
                public static final Parcelable.Creator<FromUser> CREATOR = new Creator();
                @NotNull
                public static final Companion Companion = new Companion(null);
                @NotNull
                public static final String TYPE = "system/platformFromUser";
                @NotNull
                private final List<Bubble> chunks;
                @Nullable
                private final PlatformActions contextActions;
                @Nullable
                private final String fallbackText;
                @Nullable
                private final String flow;

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$FromUser$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
                public static final class Companion {
                    private Companion() {
                    }

                    public /* synthetic */ Companion(j jVar) {
                        this();
                    }
                }

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<FromUser> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final FromUser createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        int readInt = parcel.readInt();
                        ArrayList arrayList = new ArrayList(readInt);
                        while (readInt != 0) {
                            arrayList.add((Bubble) parcel.readParcelable(FromUser.class.getClassLoader()));
                            readInt--;
                        }
                        return new FromUser(arrayList, (PlatformActions) parcel.readParcelable(FromUser.class.getClassLoader()), parcel.readString(), parcel.readString());
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final FromUser[] newArray(int i) {
                        return new FromUser[i];
                    }
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ FromUser(List list, PlatformActions platformActions, String str, String str2, int i, j jVar) {
                    this(list, (i & 2) != 0 ? null : platformActions, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
                }

                /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.messenger.message.MessageBody$SystemMessageBody$Platform$FromUser */
                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ FromUser copy$default(FromUser fromUser, List list, PlatformActions platformActions, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = fromUser.getChunks();
                    }
                    if ((i & 2) != 0) {
                        platformActions = fromUser.getContextActions();
                    }
                    if ((i & 4) != 0) {
                        str = fromUser.getFlow();
                    }
                    if ((i & 8) != 0) {
                        str2 = fromUser.getFallbackText();
                    }
                    return fromUser.copy(list, platformActions, str, str2);
                }

                @NotNull
                public final List<Bubble> component1() {
                    return getChunks();
                }

                @Nullable
                public final PlatformActions component2() {
                    return getContextActions();
                }

                @Nullable
                public final String component3() {
                    return getFlow();
                }

                @Nullable
                public final String component4() {
                    return getFallbackText();
                }

                @NotNull
                public final FromUser copy(@NotNull List<? extends Bubble> list, @Nullable PlatformActions platformActions, @Nullable String str, @Nullable String str2) {
                    Intrinsics.checkNotNullParameter(list, Platform.CHUNKS);
                    return new FromUser(list, platformActions, str, str2);
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
                    if (!(obj instanceof FromUser)) {
                        return false;
                    }
                    FromUser fromUser = (FromUser) obj;
                    return Intrinsics.areEqual(getChunks(), fromUser.getChunks()) && Intrinsics.areEqual(getContextActions(), fromUser.getContextActions()) && Intrinsics.areEqual(getFlow(), fromUser.getFlow()) && Intrinsics.areEqual(getFallbackText(), fromUser.getFallbackText());
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform
                @NotNull
                public List<Bubble> getChunks() {
                    return this.chunks;
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform
                @Nullable
                public PlatformActions getContextActions() {
                    return this.contextActions;
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform
                @Nullable
                public String getFallbackText() {
                    return this.fallbackText;
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.SystemMessageBody.Platform
                @Nullable
                public String getFlow() {
                    return this.flow;
                }

                @Override // java.lang.Object
                public int hashCode() {
                    List<Bubble> chunks2 = getChunks();
                    int i = 0;
                    int hashCode = (chunks2 != null ? chunks2.hashCode() : 0) * 31;
                    PlatformActions contextActions2 = getContextActions();
                    int hashCode2 = (hashCode + (contextActions2 != null ? contextActions2.hashCode() : 0)) * 31;
                    String flow2 = getFlow();
                    int hashCode3 = (hashCode2 + (flow2 != null ? flow2.hashCode() : 0)) * 31;
                    String fallbackText2 = getFallbackText();
                    if (fallbackText2 != null) {
                        i = fallbackText2.hashCode();
                    }
                    return hashCode3 + i;
                }

                @Override // java.lang.Object
                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Platform.FromUser(\n                            |   chunks=[");
                    L.append(getChunks().size());
                    L.append("]:");
                    L.append(getChunks());
                    L.append(",\n                            |   contextActions = ");
                    L.append(getContextActions());
                    L.append(",\n                            |   flow = ");
                    L.append(getFlow());
                    L.append(",\n                            |   fallbackText = ");
                    L.append(getFallbackText());
                    L.append("\n                            |)");
                    return f.trimMargin$default(L.toString(), null, 1, null);
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    Iterator n0 = a.n0(this.chunks, parcel);
                    while (n0.hasNext()) {
                        parcel.writeParcelable((Bubble) n0.next(), i);
                    }
                    parcel.writeParcelable(this.contextActions, i);
                    parcel.writeString(this.flow);
                    parcel.writeString(this.fallbackText);
                }

                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.messenger.message.MessageBody$SystemMessageBody$Platform$Bubble> */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public FromUser(@NotNull List<? extends Bubble> list, @Nullable PlatformActions platformActions, @Nullable String str, @Nullable String str2) {
                    super(null);
                    Intrinsics.checkNotNullParameter(list, Platform.CHUNKS);
                    this.chunks = list;
                    this.contextActions = platformActions;
                    this.flow = str;
                    this.fallbackText = str2;
                }
            }

            private Platform() {
                super(null);
            }

            @NotNull
            public abstract List<Bubble> getChunks();

            @Nullable
            public abstract PlatformActions getContextActions();

            @Nullable
            public abstract String getFallbackText();

            @Nullable
            public abstract String getFlow();

            public /* synthetic */ Platform(j jVar) {
                this();
            }
        }

        @Parcelize
        @Keep
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Text;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody;", "", "component1", "()Ljava/lang/String;", "text", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Text;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Text extends SystemMessageBody {
            public static final Parcelable.Creator<Text> CREATOR = new Creator();
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            public static final String TYPE = "system/text";
            @NotNull
            private final String text;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Text$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(j jVar) {
                    this();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Text> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Text createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Text(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Text[] newArray(int i) {
                    return new Text[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Text(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "text");
                this.text = str;
            }

            public static /* synthetic */ Text copy$default(Text text2, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = text2.text;
                }
                return text2.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.text;
            }

            @NotNull
            public final Text copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "text");
                return new Text(str);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Text) && Intrinsics.areEqual(this.text, ((Text) obj).text);
                }
                return true;
            }

            @NotNull
            public final String getText() {
                return this.text;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String str = this.text;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return a.t(a.L("Text(text="), this.text, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.text);
            }
        }

        @Parcelize
        @Keep
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\r\u0010\tJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Unknown;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Unknown extends SystemMessageBody {
            public static final Parcelable.Creator<Unknown> CREATOR = new Creator();
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            public static final String TYPE = "system/unknown";

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Unknown$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(j jVar) {
                    this();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Unknown> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Unknown createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return new Unknown();
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Unknown[] newArray(int i) {
                    return new Unknown[i];
                }
            }

            public Unknown() {
                super(null);
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
                return !(Intrinsics.areEqual(Unknown.class, obj != null ? obj.getClass() : null) ^ true);
            }

            @Override // java.lang.Object
            public int hashCode() {
                return Unknown.class.hashCode();
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return "Unknown()";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeInt(1);
            }
        }

        private SystemMessageBody() {
            super(null);
        }

        public /* synthetic */ SystemMessageBody(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Text;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Chunk;", "getChunks", "()Ljava/util/List;", SystemMessageBody.Platform.CHUNKS, "", "getText", "()Ljava/lang/String;", "text", "<init>", "()V", "Chunk", "Reaction", "Regular", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Regular;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Reaction;", "models_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Text extends MessageBody {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Chunk;", "Landroid/os/Parcelable;", "", "getEnd", "()I", "end", "getStart", Tracker.Events.CREATIVE_START, "getLength", "length", "getEndExclusive", "endExclusive", "<init>", "()V", HttpHeaders.LINK, "Plain", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Chunk$Plain;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Chunk$Link;", "models_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Chunk implements Parcelable {

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Chunk$Link;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Chunk;", "", "component1", "()I", "component2", Tracker.Events.CREATIVE_START, "end", "copy", "(II)Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Chunk$Link;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getEnd", "getStart", "<init>", "(II)V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Link extends Chunk {
                public static final Parcelable.Creator<Link> CREATOR = new Creator();
                private final int end;
                private final int start;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Link> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Link createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new Link(parcel.readInt(), parcel.readInt());
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Link[] newArray(int i) {
                        return new Link[i];
                    }
                }

                public Link(int i, int i2) {
                    super(null);
                    this.start = i;
                    this.end = i2;
                }

                public static /* synthetic */ Link copy$default(Link link, int i, int i2, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        i = link.getStart();
                    }
                    if ((i3 & 2) != 0) {
                        i2 = link.getEnd();
                    }
                    return link.copy(i, i2);
                }

                public final int component1() {
                    return getStart();
                }

                public final int component2() {
                    return getEnd();
                }

                @NotNull
                public final Link copy(int i, int i2) {
                    return new Link(i, i2);
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
                    if (!(obj instanceof Link)) {
                        return false;
                    }
                    Link link = (Link) obj;
                    return getStart() == link.getStart() && getEnd() == link.getEnd();
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.Text.Chunk
                public int getEnd() {
                    return this.end;
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.Text.Chunk
                public int getStart() {
                    return this.start;
                }

                @Override // java.lang.Object
                public int hashCode() {
                    return getEnd() + (getStart() * 31);
                }

                @Override // java.lang.Object
                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Link(start=");
                    L.append(getStart());
                    L.append(", end=");
                    L.append(getEnd());
                    L.append(")");
                    return L.toString();
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeInt(this.start);
                    parcel.writeInt(this.end);
                }
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Chunk$Plain;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Chunk;", "", "component1", "()I", "component2", Tracker.Events.CREATIVE_START, "end", "copy", "(II)Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Chunk$Plain;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getStart", "getEnd", "<init>", "(II)V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Plain extends Chunk {
                public static final Parcelable.Creator<Plain> CREATOR = new Creator();
                private final int end;
                private final int start;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Plain> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Plain createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new Plain(parcel.readInt(), parcel.readInt());
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Plain[] newArray(int i) {
                        return new Plain[i];
                    }
                }

                public Plain(int i, int i2) {
                    super(null);
                    this.start = i;
                    this.end = i2;
                }

                public static /* synthetic */ Plain copy$default(Plain plain, int i, int i2, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        i = plain.getStart();
                    }
                    if ((i3 & 2) != 0) {
                        i2 = plain.getEnd();
                    }
                    return plain.copy(i, i2);
                }

                public final int component1() {
                    return getStart();
                }

                public final int component2() {
                    return getEnd();
                }

                @NotNull
                public final Plain copy(int i, int i2) {
                    return new Plain(i, i2);
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
                    if (!(obj instanceof Plain)) {
                        return false;
                    }
                    Plain plain = (Plain) obj;
                    return getStart() == plain.getStart() && getEnd() == plain.getEnd();
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.Text.Chunk
                public int getEnd() {
                    return this.end;
                }

                @Override // com.avito.android.remote.model.messenger.message.MessageBody.Text.Chunk
                public int getStart() {
                    return this.start;
                }

                @Override // java.lang.Object
                public int hashCode() {
                    return getEnd() + (getStart() * 31);
                }

                @Override // java.lang.Object
                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Plain(start=");
                    L.append(getStart());
                    L.append(", end=");
                    L.append(getEnd());
                    L.append(")");
                    return L.toString();
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeInt(this.start);
                    parcel.writeInt(this.end);
                }
            }

            private Chunk() {
            }

            public abstract int getEnd();

            public final int getEndExclusive() {
                return getEnd() + 1;
            }

            public final int getLength() {
                return (getEnd() + 1) - getStart();
            }

            public abstract int getStart();

            public /* synthetic */ Chunk(j jVar) {
                this();
            }
        }

        @Parcelize
        @Keep
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B-\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0006J8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00042\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\f\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010\u0006R$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b$\u0010\nR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b%\u0010\u0006¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Reaction;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Text;", "Lru/avito/messenger/api/entity/body/MessageBody;", "Lru/avito/messenger/api/entity/body/HasRandomId;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Chunk;", "component2", "()Ljava/util/List;", "component3", "text", SystemMessageBody.Platform.CHUNKS, MessageBody.RANDOM_ID, "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Reaction;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getText", "Ljava/util/List;", "getChunks", "getRandomId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Reaction extends Text implements ru.avito.messenger.api.entity.body.MessageBody, HasRandomId {
            public static final Parcelable.Creator<Reaction> CREATOR = new Creator();
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            public static final String TEXT = "text";
            @NotNull
            public static final String TYPE = "text/reaction";
            @Nullable
            private final List<Chunk> chunks;
            @SerializedName(MessageBody.RANDOM_ID)
            @Nullable
            private final String randomId;
            @SerializedName("text")
            @NotNull
            private final String text;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Reaction$Companion;", "", "", "TEXT", "Ljava/lang/String;", "TYPE", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(j jVar) {
                    this();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Reaction> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Reaction createFromParcel(@NotNull Parcel parcel) {
                    ArrayList arrayList;
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        int readInt = parcel.readInt();
                        arrayList = new ArrayList(readInt);
                        while (readInt != 0) {
                            arrayList.add((Chunk) parcel.readParcelable(Reaction.class.getClassLoader()));
                            readInt--;
                        }
                    } else {
                        arrayList = null;
                    }
                    return new Reaction(readString, arrayList, parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Reaction[] newArray(int i) {
                    return new Reaction[i];
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Reaction(String str, List list, String str2, int i, j jVar) {
                this(str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.messenger.message.MessageBody$Text$Reaction */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Reaction copy$default(Reaction reaction, String str, List list, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = reaction.getText();
                }
                if ((i & 2) != 0) {
                    list = reaction.getChunks();
                }
                if ((i & 4) != 0) {
                    str2 = reaction.getRandomId();
                }
                return reaction.copy(str, list, str2);
            }

            @NotNull
            public final String component1() {
                return getText();
            }

            @Nullable
            public final List<Chunk> component2() {
                return getChunks();
            }

            @Nullable
            public final String component3() {
                return getRandomId();
            }

            @NotNull
            public final Reaction copy(@NotNull String str, @Nullable List<? extends Chunk> list, @Nullable String str2) {
                Intrinsics.checkNotNullParameter(str, "text");
                return new Reaction(str, list, str2);
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
                if (!(obj instanceof Reaction)) {
                    return false;
                }
                Reaction reaction = (Reaction) obj;
                return Intrinsics.areEqual(getText(), reaction.getText()) && Intrinsics.areEqual(getChunks(), reaction.getChunks()) && Intrinsics.areEqual(getRandomId(), reaction.getRandomId());
            }

            @Override // com.avito.android.remote.model.messenger.message.MessageBody.Text
            @Nullable
            public List<Chunk> getChunks() {
                return this.chunks;
            }

            @Override // ru.avito.messenger.api.entity.body.HasRandomId
            @Nullable
            public String getRandomId() {
                return this.randomId;
            }

            @Override // com.avito.android.remote.model.messenger.message.MessageBody.Text
            @NotNull
            public String getText() {
                return this.text;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String text2 = getText();
                int i = 0;
                int hashCode = (text2 != null ? text2.hashCode() : 0) * 31;
                List<Chunk> chunks2 = getChunks();
                int hashCode2 = (hashCode + (chunks2 != null ? chunks2.hashCode() : 0)) * 31;
                String randomId2 = getRandomId();
                if (randomId2 != null) {
                    i = randomId2.hashCode();
                }
                return hashCode2 + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("Reaction(text=");
                L.append(getText());
                L.append(", chunks=");
                L.append(getChunks());
                L.append(", randomId=");
                L.append(getRandomId());
                L.append(")");
                return L.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.text);
                List<Chunk> list = this.chunks;
                if (list != null) {
                    Iterator l0 = a.l0(parcel, 1, list);
                    while (l0.hasNext()) {
                        parcel.writeParcelable((Chunk) l0.next(), i);
                    }
                } else {
                    parcel.writeInt(0);
                }
                parcel.writeString(this.randomId);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.messenger.message.MessageBody$Text$Chunk> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Reaction(@NotNull String str, @Nullable List<? extends Chunk> list, @Nullable String str2) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "text");
                this.text = str;
                this.chunks = list;
                this.randomId = str2;
            }
        }

        @Parcelize
        @Keep
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u0000 +2\u00020\u0001:\u0001+B=\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJH\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0016J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b \u0010!R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010\u0004R$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\u0007R!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b&\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b(\u0010\f¨\u0006,"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Regular;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Text;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Chunk;", "component3", "", "component4", "()Z", "text", "suggestedTemplates", SystemMessageBody.Platform.CHUNKS, "urlsAreTrusted", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Z)Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Regular;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getText", "Ljava/util/List;", "getChunks", "getSuggestedTemplates", "Z", "getUrlsAreTrusted", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Regular extends Text {
            public static final Parcelable.Creator<Regular> CREATOR = new Creator();
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            public static final String TYPE = "text";
            @Nullable
            private final List<Chunk> chunks;
            @Nullable
            private final List<String> suggestedTemplates;
            @NotNull
            private final String text;
            private final boolean urlsAreTrusted;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Text$Regular$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(j jVar) {
                    this();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Regular> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Regular createFromParcel(@NotNull Parcel parcel) {
                    ArrayList arrayList;
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    String readString = parcel.readString();
                    ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                    if (parcel.readInt() != 0) {
                        int readInt = parcel.readInt();
                        arrayList = new ArrayList(readInt);
                        while (readInt != 0) {
                            arrayList.add((Chunk) parcel.readParcelable(Regular.class.getClassLoader()));
                            readInt--;
                        }
                    } else {
                        arrayList = null;
                    }
                    return new Regular(readString, createStringArrayList, arrayList, parcel.readInt() != 0);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Regular[] newArray(int i) {
                    return new Regular[i];
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Regular(String str, List list, List list2, boolean z, int i, j jVar) {
                this(str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? false : z);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.messenger.message.MessageBody$Text$Regular */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Regular copy$default(Regular regular, String str, List list, List list2, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = regular.getText();
                }
                if ((i & 2) != 0) {
                    list = regular.suggestedTemplates;
                }
                if ((i & 4) != 0) {
                    list2 = regular.getChunks();
                }
                if ((i & 8) != 0) {
                    z = regular.urlsAreTrusted;
                }
                return regular.copy(str, list, list2, z);
            }

            @NotNull
            public final String component1() {
                return getText();
            }

            @Nullable
            public final List<String> component2() {
                return this.suggestedTemplates;
            }

            @Nullable
            public final List<Chunk> component3() {
                return getChunks();
            }

            public final boolean component4() {
                return this.urlsAreTrusted;
            }

            @NotNull
            public final Regular copy(@NotNull String str, @Nullable List<String> list, @Nullable List<? extends Chunk> list2, boolean z) {
                Intrinsics.checkNotNullParameter(str, "text");
                return new Regular(str, list, list2, z);
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
                if (!(obj instanceof Regular)) {
                    return false;
                }
                Regular regular = (Regular) obj;
                return Intrinsics.areEqual(getText(), regular.getText()) && Intrinsics.areEqual(this.suggestedTemplates, regular.suggestedTemplates) && Intrinsics.areEqual(getChunks(), regular.getChunks()) && this.urlsAreTrusted == regular.urlsAreTrusted;
            }

            @Override // com.avito.android.remote.model.messenger.message.MessageBody.Text
            @Nullable
            public List<Chunk> getChunks() {
                return this.chunks;
            }

            @Nullable
            public final List<String> getSuggestedTemplates() {
                return this.suggestedTemplates;
            }

            @Override // com.avito.android.remote.model.messenger.message.MessageBody.Text
            @NotNull
            public String getText() {
                return this.text;
            }

            public final boolean getUrlsAreTrusted() {
                return this.urlsAreTrusted;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String text2 = getText();
                int i = 0;
                int hashCode = (text2 != null ? text2.hashCode() : 0) * 31;
                List<String> list = this.suggestedTemplates;
                int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
                List<Chunk> chunks2 = getChunks();
                if (chunks2 != null) {
                    i = chunks2.hashCode();
                }
                int i2 = (hashCode2 + i) * 31;
                boolean z = this.urlsAreTrusted;
                if (z) {
                    z = true;
                }
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = z ? 1 : 0;
                return i2 + i3;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("Regular(text=");
                L.append(getText());
                L.append(", suggestedTemplates=");
                L.append(this.suggestedTemplates);
                L.append(", chunks=");
                L.append(getChunks());
                L.append(", urlsAreTrusted=");
                return a.B(L, this.urlsAreTrusted, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.text);
                parcel.writeStringList(this.suggestedTemplates);
                List<Chunk> list = this.chunks;
                if (list != null) {
                    Iterator l0 = a.l0(parcel, 1, list);
                    while (l0.hasNext()) {
                        parcel.writeParcelable((Chunk) l0.next(), i);
                    }
                } else {
                    parcel.writeInt(0);
                }
                parcel.writeInt(this.urlsAreTrusted ? 1 : 0);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.remote.model.messenger.message.MessageBody$Text$Chunk> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Regular(@NotNull String str, @Nullable List<String> list, @Nullable List<? extends Chunk> list2, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "text");
                this.text = str;
                this.suggestedTemplates = list;
                this.chunks = list2;
                this.urlsAreTrusted = z;
            }
        }

        private Text() {
            super(null);
        }

        @Nullable
        public abstract List<Chunk> getChunks();

        @NotNull
        public abstract String getText();

        public /* synthetic */ Text(j jVar) {
            this();
        }
    }

    @Parcelize
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u001b\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001e\u0010\u0007¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Unknown;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "", "fallbackText", "withFallbackText", "(Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$Unknown;", "component1", "()Ljava/lang/String;", "component2", "type", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody$Unknown;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getFallbackText", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unknown extends MessageBody {
        public static final Parcelable.Creator<Unknown> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String TYPE = "unknown";
        @Nullable
        private final String fallbackText;
        @NotNull
        private final String type;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/message/MessageBody$Unknown$Companion;", "", "", "TYPE", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Unknown> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Unknown createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Unknown(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Unknown[] newArray(int i) {
                return new Unknown[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Unknown(String str, String str2, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        public static /* synthetic */ Unknown copy$default(Unknown unknown, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknown.type;
            }
            if ((i & 2) != 0) {
                str2 = unknown.fallbackText;
            }
            return unknown.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.type;
        }

        @Nullable
        public final String component2() {
            return this.fallbackText;
        }

        @NotNull
        public final Unknown copy(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "type");
            return new Unknown(str, str2);
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
            if (!(obj instanceof Unknown)) {
                return false;
            }
            Unknown unknown = (Unknown) obj;
            return Intrinsics.areEqual(this.type, unknown.type) && Intrinsics.areEqual(this.fallbackText, unknown.fallbackText);
        }

        @Nullable
        public final String getFallbackText() {
            return this.fallbackText;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.type;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.fallbackText;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Unknown(type=");
            L.append(this.type);
            L.append(", fallbackText=");
            return a.t(L, this.fallbackText, ")");
        }

        @CheckResult
        @NotNull
        public final Unknown withFallbackText(@Nullable String str) {
            return new Unknown(this.type, str);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.type);
            parcel.writeString(this.fallbackText);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Unknown(@NotNull String str, @Nullable String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "type");
            this.type = str;
            this.fallbackText = str2;
        }
    }

    private MessageBody() {
    }

    public /* synthetic */ MessageBody(j jVar) {
        this();
    }
}
