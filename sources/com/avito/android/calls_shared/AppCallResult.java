package com.avito.android.calls_shared;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult;", "Landroid/os/Parcelable;", "<init>", "()V", "Busy", "Declined", "Error", "Hangup", "NotAvailable", "Other", "Timeout", "Lcom/avito/android/calls_shared/AppCallResult$Busy;", "Lcom/avito/android/calls_shared/AppCallResult$Hangup;", "Lcom/avito/android/calls_shared/AppCallResult$Declined;", "Lcom/avito/android/calls_shared/AppCallResult$NotAvailable;", "Lcom/avito/android/calls_shared/AppCallResult$Timeout;", "Lcom/avito/android/calls_shared/AppCallResult$Other;", "Lcom/avito/android/calls_shared/AppCallResult$Error;", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public abstract class AppCallResult implements Parcelable {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Busy;", "Lcom/avito/android/calls_shared/AppCallResult;", "<init>", "()V", "App", "System", "Lcom/avito/android/calls_shared/AppCallResult$Busy$System;", "Lcom/avito/android/calls_shared/AppCallResult$Busy$App;", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Busy extends AppCallResult {

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Busy$App;", "Lcom/avito/android/calls_shared/AppCallResult$Busy;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class App extends Busy {
            public static final Parcelable.Creator<App> CREATOR = new Creator();
            @NotNull
            public static final App INSTANCE = new App();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<App> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final App createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return App.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final App[] newArray(int i) {
                    return new App[i];
                }
            }

            public App() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Busy$System;", "Lcom/avito/android/calls_shared/AppCallResult$Busy;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class System extends Busy {
            public static final Parcelable.Creator<System> CREATOR = new Creator();
            @NotNull
            public static final System INSTANCE = new System();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<System> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final System createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return System.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final System[] newArray(int i) {
                    return new System[i];
                }
            }

            public System() {
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

        public Busy() {
            super(null);
        }

        public Busy(j jVar) {
            super(null);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Declined;", "Lcom/avito/android/calls_shared/AppCallResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Declined extends AppCallResult {
        public static final Parcelable.Creator<Declined> CREATOR = new Creator();
        @NotNull
        public static final Declined INSTANCE = new Declined();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Declined> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Declined createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return Declined.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Declined[] newArray(int i) {
                return new Declined[i];
            }
        }

        public Declined() {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u000b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Error;", "Lcom/avito/android/calls_shared/AppCallResult;", "<init>", "()V", "CantMakeCall", "CantPrepareCall", "ConnectionClosed", "ConnectionFailed", "ForceStopped", "InternalError", "InternalStateError", "LoginFailed", "ReconnectFailed", "Terminated", NativeProtocol.ERROR_UNKNOWN_ERROR, "Lcom/avito/android/calls_shared/AppCallResult$Error$UnknownError;", "Lcom/avito/android/calls_shared/AppCallResult$Error$InternalStateError;", "Lcom/avito/android/calls_shared/AppCallResult$Error$Terminated;", "Lcom/avito/android/calls_shared/AppCallResult$Error$ReconnectFailed;", "Lcom/avito/android/calls_shared/AppCallResult$Error$ConnectionClosed;", "Lcom/avito/android/calls_shared/AppCallResult$Error$ConnectionFailed;", "Lcom/avito/android/calls_shared/AppCallResult$Error$LoginFailed;", "Lcom/avito/android/calls_shared/AppCallResult$Error$CantPrepareCall;", "Lcom/avito/android/calls_shared/AppCallResult$Error$InternalError;", "Lcom/avito/android/calls_shared/AppCallResult$Error$CantMakeCall;", "Lcom/avito/android/calls_shared/AppCallResult$Error$ForceStopped;", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Error extends AppCallResult {

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Error$CantMakeCall;", "Lcom/avito/android/calls_shared/AppCallResult$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class CantMakeCall extends Error {
            public static final Parcelable.Creator<CantMakeCall> CREATOR = new Creator();
            @NotNull
            public static final CantMakeCall INSTANCE = new CantMakeCall();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<CantMakeCall> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final CantMakeCall createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return CantMakeCall.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final CantMakeCall[] newArray(int i) {
                    return new CantMakeCall[i];
                }
            }

            public CantMakeCall() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Error$CantPrepareCall;", "Lcom/avito/android/calls_shared/AppCallResult$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class CantPrepareCall extends Error {
            public static final Parcelable.Creator<CantPrepareCall> CREATOR = new Creator();
            @NotNull
            public static final CantPrepareCall INSTANCE = new CantPrepareCall();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<CantPrepareCall> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final CantPrepareCall createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return CantPrepareCall.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final CantPrepareCall[] newArray(int i) {
                    return new CantPrepareCall[i];
                }
            }

            public CantPrepareCall() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Error$ConnectionClosed;", "Lcom/avito/android/calls_shared/AppCallResult$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class ConnectionClosed extends Error {
            public static final Parcelable.Creator<ConnectionClosed> CREATOR = new Creator();
            @NotNull
            public static final ConnectionClosed INSTANCE = new ConnectionClosed();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<ConnectionClosed> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ConnectionClosed createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return ConnectionClosed.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ConnectionClosed[] newArray(int i) {
                    return new ConnectionClosed[i];
                }
            }

            public ConnectionClosed() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Error$ConnectionFailed;", "Lcom/avito/android/calls_shared/AppCallResult$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class ConnectionFailed extends Error {
            public static final Parcelable.Creator<ConnectionFailed> CREATOR = new Creator();
            @NotNull
            public static final ConnectionFailed INSTANCE = new ConnectionFailed();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<ConnectionFailed> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ConnectionFailed createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return ConnectionFailed.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ConnectionFailed[] newArray(int i) {
                    return new ConnectionFailed[i];
                }
            }

            public ConnectionFailed() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Error$ForceStopped;", "Lcom/avito/android/calls_shared/AppCallResult$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class ForceStopped extends Error {
            public static final Parcelable.Creator<ForceStopped> CREATOR = new Creator();
            @NotNull
            public static final ForceStopped INSTANCE = new ForceStopped();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<ForceStopped> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ForceStopped createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return ForceStopped.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ForceStopped[] newArray(int i) {
                    return new ForceStopped[i];
                }
            }

            public ForceStopped() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Error$InternalError;", "Lcom/avito/android/calls_shared/AppCallResult$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class InternalError extends Error {
            public static final Parcelable.Creator<InternalError> CREATOR = new Creator();
            @NotNull
            public static final InternalError INSTANCE = new InternalError();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<InternalError> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final InternalError createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return InternalError.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final InternalError[] newArray(int i) {
                    return new InternalError[i];
                }
            }

            public InternalError() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Error$InternalStateError;", "Lcom/avito/android/calls_shared/AppCallResult$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class InternalStateError extends Error {
            public static final Parcelable.Creator<InternalStateError> CREATOR = new Creator();
            @NotNull
            public static final InternalStateError INSTANCE = new InternalStateError();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<InternalStateError> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final InternalStateError createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return InternalStateError.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final InternalStateError[] newArray(int i) {
                    return new InternalStateError[i];
                }
            }

            public InternalStateError() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Error$LoginFailed;", "Lcom/avito/android/calls_shared/AppCallResult$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class LoginFailed extends Error {
            public static final Parcelable.Creator<LoginFailed> CREATOR = new Creator();
            @NotNull
            public static final LoginFailed INSTANCE = new LoginFailed();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<LoginFailed> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final LoginFailed createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return LoginFailed.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final LoginFailed[] newArray(int i) {
                    return new LoginFailed[i];
                }
            }

            public LoginFailed() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Error$ReconnectFailed;", "Lcom/avito/android/calls_shared/AppCallResult$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class ReconnectFailed extends Error {
            public static final Parcelable.Creator<ReconnectFailed> CREATOR = new Creator();
            @NotNull
            public static final ReconnectFailed INSTANCE = new ReconnectFailed();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<ReconnectFailed> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ReconnectFailed createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return ReconnectFailed.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ReconnectFailed[] newArray(int i) {
                    return new ReconnectFailed[i];
                }
            }

            public ReconnectFailed() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Error$Terminated;", "Lcom/avito/android/calls_shared/AppCallResult$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class Terminated extends Error {
            public static final Parcelable.Creator<Terminated> CREATOR = new Creator();
            @NotNull
            public static final Terminated INSTANCE = new Terminated();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Terminated> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Terminated createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return Terminated.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Terminated[] newArray(int i) {
                    return new Terminated[i];
                }
            }

            public Terminated() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Error$UnknownError;", "Lcom/avito/android/calls_shared/AppCallResult$Error;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class UnknownError extends Error {
            public static final Parcelable.Creator<UnknownError> CREATOR = new Creator();
            @NotNull
            public static final UnknownError INSTANCE = new UnknownError();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<UnknownError> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final UnknownError createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return UnknownError.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final UnknownError[] newArray(int i) {
                    return new UnknownError[i];
                }
            }

            public UnknownError() {
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

        public Error(j jVar) {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Hangup;", "Lcom/avito/android/calls_shared/AppCallResult;", "<init>", "()V", "HangupCaller", "HangupCallerEarly", "HangupReceiver", "HangupWhileReconnecting", "NonUserHangup", "Lcom/avito/android/calls_shared/AppCallResult$Hangup$NonUserHangup;", "Lcom/avito/android/calls_shared/AppCallResult$Hangup$HangupWhileReconnecting;", "Lcom/avito/android/calls_shared/AppCallResult$Hangup$HangupReceiver;", "Lcom/avito/android/calls_shared/AppCallResult$Hangup$HangupCallerEarly;", "Lcom/avito/android/calls_shared/AppCallResult$Hangup$HangupCaller;", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Hangup extends AppCallResult {

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Hangup$HangupCaller;", "Lcom/avito/android/calls_shared/AppCallResult$Hangup;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class HangupCaller extends Hangup {
            public static final Parcelable.Creator<HangupCaller> CREATOR = new Creator();
            @NotNull
            public static final HangupCaller INSTANCE = new HangupCaller();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<HangupCaller> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final HangupCaller createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return HangupCaller.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final HangupCaller[] newArray(int i) {
                    return new HangupCaller[i];
                }
            }

            public HangupCaller() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Hangup$HangupCallerEarly;", "Lcom/avito/android/calls_shared/AppCallResult$Hangup;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class HangupCallerEarly extends Hangup {
            public static final Parcelable.Creator<HangupCallerEarly> CREATOR = new Creator();
            @NotNull
            public static final HangupCallerEarly INSTANCE = new HangupCallerEarly();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<HangupCallerEarly> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final HangupCallerEarly createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return HangupCallerEarly.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final HangupCallerEarly[] newArray(int i) {
                    return new HangupCallerEarly[i];
                }
            }

            public HangupCallerEarly() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Hangup$HangupReceiver;", "Lcom/avito/android/calls_shared/AppCallResult$Hangup;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class HangupReceiver extends Hangup {
            public static final Parcelable.Creator<HangupReceiver> CREATOR = new Creator();
            @NotNull
            public static final HangupReceiver INSTANCE = new HangupReceiver();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<HangupReceiver> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final HangupReceiver createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return HangupReceiver.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final HangupReceiver[] newArray(int i) {
                    return new HangupReceiver[i];
                }
            }

            public HangupReceiver() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Hangup$HangupWhileReconnecting;", "Lcom/avito/android/calls_shared/AppCallResult$Hangup;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class HangupWhileReconnecting extends Hangup {
            public static final Parcelable.Creator<HangupWhileReconnecting> CREATOR = new Creator();
            @NotNull
            public static final HangupWhileReconnecting INSTANCE = new HangupWhileReconnecting();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<HangupWhileReconnecting> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final HangupWhileReconnecting createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return HangupWhileReconnecting.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final HangupWhileReconnecting[] newArray(int i) {
                    return new HangupWhileReconnecting[i];
                }
            }

            public HangupWhileReconnecting() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Hangup$NonUserHangup;", "Lcom/avito/android/calls_shared/AppCallResult$Hangup;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
        public static final class NonUserHangup extends Hangup {
            public static final Parcelable.Creator<NonUserHangup> CREATOR = new Creator();
            @NotNull
            public static final NonUserHangup INSTANCE = new NonUserHangup();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<NonUserHangup> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final NonUserHangup createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return NonUserHangup.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final NonUserHangup[] newArray(int i) {
                    return new NonUserHangup[i];
                }
            }

            public NonUserHangup() {
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

        public Hangup() {
            super(null);
        }

        public Hangup(j jVar) {
            super(null);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$NotAvailable;", "Lcom/avito/android/calls_shared/AppCallResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class NotAvailable extends AppCallResult {
        public static final Parcelable.Creator<NotAvailable> CREATOR = new Creator();
        @NotNull
        public static final NotAvailable INSTANCE = new NotAvailable();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<NotAvailable> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final NotAvailable createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return NotAvailable.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final NotAvailable[] newArray(int i) {
                return new NotAvailable[i];
            }
        }

        public NotAvailable() {
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Other;", "Lcom/avito/android/calls_shared/AppCallResult;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "code", "message", "copy", "(ILjava/lang/String;)Lcom/avito/android/calls_shared/AppCallResult$Other;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "I", "getCode", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "<init>", "(ILjava/lang/String;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Other extends AppCallResult {
        public static final Parcelable.Creator<Other> CREATOR = new Creator();
        public final int a;
        @Nullable
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Other> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Other createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Other(parcel.readInt(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Other[] newArray(int i) {
                return new Other[i];
            }
        }

        public Other(int i, @Nullable String str) {
            super(null);
            this.a = i;
            this.b = str;
        }

        public static /* synthetic */ Other copy$default(Other other, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = other.a;
            }
            if ((i2 & 2) != 0) {
                str = other.b;
            }
            return other.copy(i, str);
        }

        public final int component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final Other copy(int i, @Nullable String str) {
            return new Other(i, str);
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
            if (!(obj instanceof Other)) {
                return false;
            }
            Other other = (Other) obj;
            return this.a == other.a && Intrinsics.areEqual(this.b, other.b);
        }

        public final int getCode() {
            return this.a;
        }

        @Nullable
        public final String getMessage() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i = this.a * 31;
            String str = this.b;
            return i + (str != null ? str.hashCode() : 0);
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Other(code=");
            L.append(this.a);
            L.append(", message=");
            return a.t(L, this.b, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.a);
            parcel.writeString(this.b);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/AppCallResult$Timeout;", "Lcom/avito/android/calls_shared/AppCallResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Timeout extends AppCallResult {
        public static final Parcelable.Creator<Timeout> CREATOR = new Creator();
        @NotNull
        public static final Timeout INSTANCE = new Timeout();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Timeout> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Timeout createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return Timeout.INSTANCE;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Timeout[] newArray(int i) {
                return new Timeout[i];
            }
        }

        public Timeout() {
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

    public AppCallResult() {
    }

    public AppCallResult(j jVar) {
    }
}
