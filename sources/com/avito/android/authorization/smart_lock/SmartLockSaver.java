package com.avito.android.authorization.smart_lock;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.preferences.Preference;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001aJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command;", "connect", "()Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/Maybe;", "", "connectWithObservables", "command", "run", "(Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command;)Lio/reactivex/rxjava3/core/Maybe;", "", "resultCode", "Landroid/content/Intent;", "data", "handleResult", "(ILandroid/content/Intent;)V", "", "login", Preference.PASSWORD, "save", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Command", "smartlock_release"}, k = 1, mv = {1, 4, 2})
public interface SmartLockSaver {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command;", "Landroid/os/Parcelable;", "<init>", "()V", "Error", "Finish", BaseAnalyticKt.ANALYTIC_ACTION_SAVE, "Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command$Save;", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command$Finish;", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command$Error;", "smartlock_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Command implements Parcelable {

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command$Error;", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "smartlock_release"}, k = 1, mv = {1, 4, 2})
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command$Finish;", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "smartlock_release"}, k = 1, mv = {1, 4, 2})
        public static final class Finish extends Command {
            public static final Parcelable.Creator<Finish> CREATOR = new Creator();
            @NotNull
            public static final Finish INSTANCE = new Finish();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Finish> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Finish createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return Finish.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Finish[] newArray(int i) {
                    return new Finish[i];
                }
            }

            public Finish() {
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
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command$Save;", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver$Command;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getLogin", "()Ljava/lang/String;", "login", AuthSource.BOOKING_ORDER, "getPassword", Preference.PASSWORD, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "smartlock_release"}, k = 1, mv = {1, 4, 2})
        public static final class Save extends Command {
            public static final Parcelable.Creator<Save> CREATOR = new Creator();
            @NotNull
            public final String a;
            @NotNull
            public final String b;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Save> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Save createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Save(parcel.readString(), parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Save[] newArray(int i) {
                    return new Save[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Save(@NotNull String str, @NotNull String str2) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "login");
                Intrinsics.checkNotNullParameter(str2, Preference.PASSWORD);
                this.a = str;
                this.b = str2;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @NotNull
            public final String getLogin() {
                return this.a;
            }

            @NotNull
            public final String getPassword() {
                return this.b;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
                parcel.writeString(this.b);
            }
        }

        public Command() {
        }

        public Command(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {

        public static final class a<T, R> implements Function<Command, Maybe<Unit>> {
            public final /* synthetic */ SmartLockSaver a;

            public a(SmartLockSaver smartLockSaver) {
                this.a = smartLockSaver;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Function
            public Maybe<Unit> apply(Command command) {
                Command command2 = command;
                SmartLockSaver smartLockSaver = this.a;
                Intrinsics.checkNotNullExpressionValue(command2, "it");
                return smartLockSaver.run(command2);
            }
        }

        @NotNull
        public static Observable<Maybe<Unit>> connectWithObservables(@NotNull SmartLockSaver smartLockSaver) {
            Observable<R> map = smartLockSaver.connect().map(new a(smartLockSaver));
            Intrinsics.checkNotNullExpressionValue(map, "connect().map { run(it) }");
            return map;
        }
    }

    @NotNull
    Observable<Command> connect();

    @NotNull
    Observable<Maybe<Unit>> connectWithObservables();

    void handleResult(int i, @Nullable Intent intent);

    @NotNull
    Kundle onSaveState();

    @NotNull
    Maybe<Unit> run(@NotNull Command command);

    void save(@NotNull String str, @NotNull String str2);
}
