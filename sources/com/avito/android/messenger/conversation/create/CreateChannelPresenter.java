package com.avito.android.messenger.conversation.create;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.LiveData;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.conversation.ChannelActivityArguments;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "params", "", "createChannel", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;)V", "retry", "", "success", "onAuthResult", "(Z)V", "onPhoneVerificationResult", "Landroidx/lifecycle/LiveData;", "getStartLoginScreenLiveData", "()Landroidx/lifecycle/LiveData;", "startLoginScreenLiveData", "getStartPhoneVerificationLiveData", "startPhoneVerificationLiveData", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface CreateChannelPresenter extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "Landroid/os/Parcelable;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "getCreateParams", "()Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "createParams", "<init>", "()V", "Created", "Empty", "Error", "Waiting", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Empty;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Waiting;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Created;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State implements Parcelable {

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Created;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "component1", "()Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "", "component2", "()Ljava/lang/String;", "createParams", "channelId", "copy", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Created;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getChannelId", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "getCreateParams", "<init>", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Created extends State {
            public static final Parcelable.Creator<Created> CREATOR = new Creator();
            @NotNull
            public final ChannelActivityArguments.Create a;
            @NotNull
            public final String b;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Created> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Created createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Created((ChannelActivityArguments.Create) parcel.readParcelable(Created.class.getClassLoader()), parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Created[] newArray(int i) {
                    return new Created[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Created(@NotNull ChannelActivityArguments.Create create, @NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(create, "createParams");
                Intrinsics.checkNotNullParameter(str, "channelId");
                this.a = create;
                this.b = str;
            }

            public static /* synthetic */ Created copy$default(Created created, ChannelActivityArguments.Create create, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    create = created.getCreateParams();
                }
                if ((i & 2) != 0) {
                    str = created.b;
                }
                return created.copy(create, str);
            }

            @NotNull
            public final ChannelActivityArguments.Create component1() {
                return getCreateParams();
            }

            @NotNull
            public final String component2() {
                return this.b;
            }

            @NotNull
            public final Created copy(@NotNull ChannelActivityArguments.Create create, @NotNull String str) {
                Intrinsics.checkNotNullParameter(create, "createParams");
                Intrinsics.checkNotNullParameter(str, "channelId");
                return new Created(create, str);
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
                if (!(obj instanceof Created)) {
                    return false;
                }
                Created created = (Created) obj;
                return Intrinsics.areEqual(getCreateParams(), created.getCreateParams()) && Intrinsics.areEqual(this.b, created.b);
            }

            @NotNull
            public final String getChannelId() {
                return this.b;
            }

            @Override // com.avito.android.messenger.conversation.create.CreateChannelPresenter.State
            @NotNull
            public ChannelActivityArguments.Create getCreateParams() {
                return this.a;
            }

            @Override // java.lang.Object
            public int hashCode() {
                ChannelActivityArguments.Create createParams = getCreateParams();
                int i = 0;
                int hashCode = (createParams != null ? createParams.hashCode() : 0) * 31;
                String str = this.b;
                if (str != null) {
                    i = str.hashCode();
                }
                return hashCode + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("Created(createParams=");
                L.append(getCreateParams());
                L.append(", channelId=");
                return a.t(L, this.b, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeParcelable(this.a, i);
                parcel.writeString(this.b);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Empty;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "getCreateParams", "()Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "createParams", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            public static final Parcelable.Creator<Empty> CREATOR = new Creator();
            @NotNull
            public static final Empty INSTANCE = new Empty();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Empty> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Empty createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return Empty.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Empty[] newArray(int i) {
                    return new Empty[i];
                }
            }

            public Empty() {
                super(null);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // com.avito.android.messenger.conversation.create.CreateChannelPresenter.State
            @Nullable
            public ChannelActivityArguments.Create getCreateParams() {
                return null;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeInt(1);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\t\n\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "createParams", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "getCreateParams", "()Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "<init>", "()V", "AuthRequired", "Forbidden", "Network", "PhoneVerificationRequired", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error$AuthRequired;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error$Forbidden;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error$PhoneVerificationRequired;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error$Network;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error$Unknown;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Error extends State {

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error$AuthRequired;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class AuthRequired extends Error {
                public static final Parcelable.Creator<AuthRequired> CREATOR = new Creator();
                @NotNull
                public static final AuthRequired INSTANCE = new AuthRequired();

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<AuthRequired> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final AuthRequired createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        if (parcel.readInt() != 0) {
                            return AuthRequired.INSTANCE;
                        }
                        return null;
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final AuthRequired[] newArray(int i) {
                        return new AuthRequired[i];
                    }
                }

                public AuthRequired() {
                    super(null);
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeInt(1);
                }
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error$Forbidden;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Forbidden extends Error {
                public static final Parcelable.Creator<Forbidden> CREATOR = new Creator();
                @NotNull
                public static final Forbidden INSTANCE = new Forbidden();

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Forbidden> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Forbidden createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        if (parcel.readInt() != 0) {
                            return Forbidden.INSTANCE;
                        }
                        return null;
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Forbidden[] newArray(int i) {
                        return new Forbidden[i];
                    }
                }

                public Forbidden() {
                    super(null);
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeInt(1);
                }
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error$Network;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Network extends Error {
                public static final Parcelable.Creator<Network> CREATOR = new Creator();
                @NotNull
                public static final Network INSTANCE = new Network();

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Network> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Network createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        if (parcel.readInt() != 0) {
                            return Network.INSTANCE;
                        }
                        return null;
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Network[] newArray(int i) {
                        return new Network[i];
                    }
                }

                public Network() {
                    super(null);
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeInt(1);
                }
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error$PhoneVerificationRequired;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class PhoneVerificationRequired extends Error {
                public static final Parcelable.Creator<PhoneVerificationRequired> CREATOR = new Creator();
                @NotNull
                public static final PhoneVerificationRequired INSTANCE = new PhoneVerificationRequired();

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<PhoneVerificationRequired> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final PhoneVerificationRequired createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        if (parcel.readInt() != 0) {
                            return PhoneVerificationRequired.INSTANCE;
                        }
                        return null;
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final PhoneVerificationRequired[] newArray(int i) {
                        return new PhoneVerificationRequired[i];
                    }
                }

                public PhoneVerificationRequired() {
                    super(null);
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeInt(1);
                }
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error$Unknown;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Unknown extends Error {
                public static final Parcelable.Creator<Unknown> CREATOR = new Creator();
                @NotNull
                public static final Unknown INSTANCE = new Unknown();

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Unknown> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Unknown createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        if (parcel.readInt() != 0) {
                            return Unknown.INSTANCE;
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

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeInt(1);
                }
            }

            public Error() {
                super(null);
            }

            @Override // com.avito.android.messenger.conversation.create.CreateChannelPresenter.State
            @Nullable
            public ChannelActivityArguments.Create getCreateParams() {
                return null;
            }

            public Error(j jVar) {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Waiting;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "<init>", "()V", "Auth", "CreateChannel", "PhoneVerification", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Waiting$Auth;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Waiting$PhoneVerification;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Waiting$CreateChannel;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Waiting extends State {

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Waiting$Auth;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Waiting;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "component1", "()Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "createParams", "copy", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;)Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Waiting$Auth;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "getCreateParams", "<init>", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Auth extends Waiting {
                public static final Parcelable.Creator<Auth> CREATOR = new Creator();
                @NotNull
                public final ChannelActivityArguments.Create a;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Auth> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Auth createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new Auth((ChannelActivityArguments.Create) parcel.readParcelable(Auth.class.getClassLoader()));
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Auth[] newArray(int i) {
                        return new Auth[i];
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Auth(@NotNull ChannelActivityArguments.Create create) {
                    super(null);
                    Intrinsics.checkNotNullParameter(create, "createParams");
                    this.a = create;
                }

                public static /* synthetic */ Auth copy$default(Auth auth, ChannelActivityArguments.Create create, int i, Object obj) {
                    if ((i & 1) != 0) {
                        create = auth.getCreateParams();
                    }
                    return auth.copy(create);
                }

                @NotNull
                public final ChannelActivityArguments.Create component1() {
                    return getCreateParams();
                }

                @NotNull
                public final Auth copy(@NotNull ChannelActivityArguments.Create create) {
                    Intrinsics.checkNotNullParameter(create, "createParams");
                    return new Auth(create);
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                @Override // java.lang.Object
                public boolean equals(@Nullable Object obj) {
                    if (this != obj) {
                        return (obj instanceof Auth) && Intrinsics.areEqual(getCreateParams(), ((Auth) obj).getCreateParams());
                    }
                    return true;
                }

                @Override // com.avito.android.messenger.conversation.create.CreateChannelPresenter.State
                @NotNull
                public ChannelActivityArguments.Create getCreateParams() {
                    return this.a;
                }

                @Override // java.lang.Object
                public int hashCode() {
                    ChannelActivityArguments.Create createParams = getCreateParams();
                    if (createParams != null) {
                        return createParams.hashCode();
                    }
                    return 0;
                }

                @Override // java.lang.Object
                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Auth(createParams=");
                    L.append(getCreateParams());
                    L.append(")");
                    return L.toString();
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeParcelable(this.a, i);
                }
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Waiting$CreateChannel;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Waiting;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "component1", "()Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "createParams", "copy", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;)Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Waiting$CreateChannel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "getCreateParams", "<init>", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class CreateChannel extends Waiting {
                public static final Parcelable.Creator<CreateChannel> CREATOR = new Creator();
                @NotNull
                public final ChannelActivityArguments.Create a;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<CreateChannel> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final CreateChannel createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new CreateChannel((ChannelActivityArguments.Create) parcel.readParcelable(CreateChannel.class.getClassLoader()));
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final CreateChannel[] newArray(int i) {
                        return new CreateChannel[i];
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public CreateChannel(@NotNull ChannelActivityArguments.Create create) {
                    super(null);
                    Intrinsics.checkNotNullParameter(create, "createParams");
                    this.a = create;
                }

                public static /* synthetic */ CreateChannel copy$default(CreateChannel createChannel, ChannelActivityArguments.Create create, int i, Object obj) {
                    if ((i & 1) != 0) {
                        create = createChannel.getCreateParams();
                    }
                    return createChannel.copy(create);
                }

                @NotNull
                public final ChannelActivityArguments.Create component1() {
                    return getCreateParams();
                }

                @NotNull
                public final CreateChannel copy(@NotNull ChannelActivityArguments.Create create) {
                    Intrinsics.checkNotNullParameter(create, "createParams");
                    return new CreateChannel(create);
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                @Override // java.lang.Object
                public boolean equals(@Nullable Object obj) {
                    if (this != obj) {
                        return (obj instanceof CreateChannel) && Intrinsics.areEqual(getCreateParams(), ((CreateChannel) obj).getCreateParams());
                    }
                    return true;
                }

                @Override // com.avito.android.messenger.conversation.create.CreateChannelPresenter.State
                @NotNull
                public ChannelActivityArguments.Create getCreateParams() {
                    return this.a;
                }

                @Override // java.lang.Object
                public int hashCode() {
                    ChannelActivityArguments.Create createParams = getCreateParams();
                    if (createParams != null) {
                        return createParams.hashCode();
                    }
                    return 0;
                }

                @Override // java.lang.Object
                @NotNull
                public String toString() {
                    StringBuilder L = a.L("CreateChannel(createParams=");
                    L.append(getCreateParams());
                    L.append(")");
                    return L.toString();
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeParcelable(this.a, i);
                }
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Waiting$PhoneVerification;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Waiting;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "component1", "()Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "createParams", "copy", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;)Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State$Waiting$PhoneVerification;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "getCreateParams", "<init>", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class PhoneVerification extends Waiting {
                public static final Parcelable.Creator<PhoneVerification> CREATOR = new Creator();
                @NotNull
                public final ChannelActivityArguments.Create a;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<PhoneVerification> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final PhoneVerification createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new PhoneVerification((ChannelActivityArguments.Create) parcel.readParcelable(PhoneVerification.class.getClassLoader()));
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final PhoneVerification[] newArray(int i) {
                        return new PhoneVerification[i];
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public PhoneVerification(@NotNull ChannelActivityArguments.Create create) {
                    super(null);
                    Intrinsics.checkNotNullParameter(create, "createParams");
                    this.a = create;
                }

                public static /* synthetic */ PhoneVerification copy$default(PhoneVerification phoneVerification, ChannelActivityArguments.Create create, int i, Object obj) {
                    if ((i & 1) != 0) {
                        create = phoneVerification.getCreateParams();
                    }
                    return phoneVerification.copy(create);
                }

                @NotNull
                public final ChannelActivityArguments.Create component1() {
                    return getCreateParams();
                }

                @NotNull
                public final PhoneVerification copy(@NotNull ChannelActivityArguments.Create create) {
                    Intrinsics.checkNotNullParameter(create, "createParams");
                    return new PhoneVerification(create);
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                @Override // java.lang.Object
                public boolean equals(@Nullable Object obj) {
                    if (this != obj) {
                        return (obj instanceof PhoneVerification) && Intrinsics.areEqual(getCreateParams(), ((PhoneVerification) obj).getCreateParams());
                    }
                    return true;
                }

                @Override // com.avito.android.messenger.conversation.create.CreateChannelPresenter.State
                @NotNull
                public ChannelActivityArguments.Create getCreateParams() {
                    return this.a;
                }

                @Override // java.lang.Object
                public int hashCode() {
                    ChannelActivityArguments.Create createParams = getCreateParams();
                    if (createParams != null) {
                        return createParams.hashCode();
                    }
                    return 0;
                }

                @Override // java.lang.Object
                @NotNull
                public String toString() {
                    StringBuilder L = a.L("PhoneVerification(createParams=");
                    L.append(getCreateParams());
                    L.append(")");
                    return L.toString();
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeParcelable(this.a, i);
                }
            }

            public Waiting() {
                super(null);
            }

            public Waiting(j jVar) {
                super(null);
            }
        }

        public State() {
        }

        @Nullable
        public abstract ChannelActivityArguments.Create getCreateParams();

        public State(j jVar) {
        }
    }

    void createChannel(@NotNull ChannelActivityArguments.Create create);

    @NotNull
    LiveData<Unit> getStartLoginScreenLiveData();

    @NotNull
    LiveData<Unit> getStartPhoneVerificationLiveData();

    void onAuthResult(boolean z);

    void onPhoneVerificationResult(boolean z);

    void retry(@NotNull ChannelActivityArguments.Create create);
}
