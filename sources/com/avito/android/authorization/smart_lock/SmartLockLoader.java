package com.avito.android.authorization.smart_lock;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.account.Credentials;
import com.avito.android.authorization.auth.tracker.check.CheckTrackerModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.google.android.gms.auth.api.credentials.Credential;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aH&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command;", "connect", "()Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/account/Credentials$PasswordCredentials;", "connectWithObservables", "command", "run", "(Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command;)Lio/reactivex/rxjava3/core/Maybe;", "", "resultCode", "Landroid/content/Intent;", "data", "", "handleResult", "(ILandroid/content/Intent;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "skipSingleAccountConfirmation", "load", "(Z)V", "Lio/reactivex/rxjava3/core/Single;", CheckTrackerModule.NAME, "()Lio/reactivex/rxjava3/core/Single;", "Command", "smartlock_release"}, k = 1, mv = {1, 4, 2})
public interface SmartLockLoader {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command;", "Landroid/os/Parcelable;", "<init>", "()V", "Cancel", "Confirm", "Error", "Finish", "Load", "Wait", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command$Load;", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command$Confirm;", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command$Finish;", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command$Error;", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command$Cancel;", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command$Wait;", "smartlock_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Command implements Parcelable {

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command$Cancel;", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "smartlock_release"}, k = 1, mv = {1, 4, 2})
        public static final class Cancel extends Command {
            public static final Parcelable.Creator<Cancel> CREATOR = new Creator();
            @NotNull
            public static final Cancel INSTANCE = new Cancel();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Cancel> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Cancel createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return Cancel.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Cancel[] newArray(int i) {
                    return new Cancel[i];
                }
            }

            public Cancel() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command$Confirm;", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/google/android/gms/auth/api/credentials/Credential;", AuthSource.SEND_ABUSE, "Lcom/google/android/gms/auth/api/credentials/Credential;", "getCredential", "()Lcom/google/android/gms/auth/api/credentials/Credential;", "credential", "<init>", "(Lcom/google/android/gms/auth/api/credentials/Credential;)V", "smartlock_release"}, k = 1, mv = {1, 4, 2})
        public static final class Confirm extends Command {
            public static final Parcelable.Creator<Confirm> CREATOR = new Creator();
            @NotNull
            public final Credential a;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Confirm> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Confirm createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Confirm((Credential) parcel.readParcelable(Confirm.class.getClassLoader()));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Confirm[] newArray(int i) {
                    return new Confirm[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Confirm(@NotNull Credential credential) {
                super(null);
                Intrinsics.checkNotNullParameter(credential, "credential");
                this.a = credential;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @NotNull
            public final Credential getCredential() {
                return this.a;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeParcelable(this.a, i);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command$Error;", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "smartlock_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends Command {
            public static final Parcelable.Creator<Error> CREATOR = new Creator();
            @NotNull
            public final String a;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Error> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Error createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Error(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Error[] newArray(int i) {
                    return new Error[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.a = str;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @NotNull
            public final String getMessage() {
                return this.a;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command$Finish;", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/google/android/gms/auth/api/credentials/Credential;", AuthSource.SEND_ABUSE, "Lcom/google/android/gms/auth/api/credentials/Credential;", "getCredential", "()Lcom/google/android/gms/auth/api/credentials/Credential;", "credential", "<init>", "(Lcom/google/android/gms/auth/api/credentials/Credential;)V", "smartlock_release"}, k = 1, mv = {1, 4, 2})
        public static final class Finish extends Command {
            public static final Parcelable.Creator<Finish> CREATOR = new Creator();
            @NotNull
            public final Credential a;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Finish> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Finish createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Finish((Credential) parcel.readParcelable(Finish.class.getClassLoader()));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Finish[] newArray(int i) {
                    return new Finish[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Finish(@NotNull Credential credential) {
                super(null);
                Intrinsics.checkNotNullParameter(credential, "credential");
                this.a = credential;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @NotNull
            public final Credential getCredential() {
                return this.a;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeParcelable(this.a, i);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command$Load;", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Z", "getSkipSingleAccountConfirmation", "()Z", "skipSingleAccountConfirmation", "<init>", "(Z)V", "smartlock_release"}, k = 1, mv = {1, 4, 2})
        public static final class Load extends Command {
            public static final Parcelable.Creator<Load> CREATOR = new Creator();
            public final boolean a;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Load> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Load createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Load(parcel.readInt() != 0);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Load[] newArray(int i) {
                    return new Load[i];
                }
            }

            public Load() {
                this(false, 1, null);
            }

            public Load(boolean z) {
                super(null);
                this.a = z;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public final boolean getSkipSingleAccountConfirmation() {
                return this.a;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeInt(this.a ? 1 : 0);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Load(boolean z, int i, j jVar) {
                this((i & 1) != 0 ? false : z);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command$Wait;", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader$Command;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "smartlock_release"}, k = 1, mv = {1, 4, 2})
        public static final class Wait extends Command {
            public static final Parcelable.Creator<Wait> CREATOR = new Creator();
            @NotNull
            public static final Wait INSTANCE = new Wait();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Wait> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Wait createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return Wait.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Wait[] newArray(int i) {
                    return new Wait[i];
                }
            }

            public Wait() {
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

        public Command() {
        }

        public Command(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {

        public static final class a<T, R> implements Function<Command, Maybe<Credentials.PasswordCredentials>> {
            public final /* synthetic */ SmartLockLoader a;

            public a(SmartLockLoader smartLockLoader) {
                this.a = smartLockLoader;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Function
            public Maybe<Credentials.PasswordCredentials> apply(Command command) {
                Command command2 = command;
                SmartLockLoader smartLockLoader = this.a;
                Intrinsics.checkNotNullExpressionValue(command2, "it");
                return smartLockLoader.run(command2);
            }
        }

        @NotNull
        public static Observable<Maybe<Credentials.PasswordCredentials>> connectWithObservables(@NotNull SmartLockLoader smartLockLoader) {
            Observable<R> map = smartLockLoader.connect().map(new a(smartLockLoader));
            Intrinsics.checkNotNullExpressionValue(map, "connect().map { run(it) }");
            return map;
        }

        public static /* synthetic */ void load$default(SmartLockLoader smartLockLoader, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                smartLockLoader.load(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: load");
        }
    }

    @NotNull
    Single<Boolean> check();

    @NotNull
    Observable<Command> connect();

    @NotNull
    Observable<Maybe<Credentials.PasswordCredentials>> connectWithObservables();

    void handleResult(int i, @Nullable Intent intent);

    void load(boolean z);

    @NotNull
    Kundle onSaveState();

    @NotNull
    Maybe<Credentials.PasswordCredentials> run(@NotNull Command command);
}
