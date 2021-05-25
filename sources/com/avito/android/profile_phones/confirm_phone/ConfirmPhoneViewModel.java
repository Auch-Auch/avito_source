package com.avito.android.profile_phones.confirm_phone;

import androidx.lifecycle.LiveData;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH&¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH&¢\u0006\u0004\b\u0012\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel;", "", "", "onBackClicked", "()V", "Lio/reactivex/rxjava3/core/Observable;", "", "inputChanges", "subscribeToInputChanges", "(Lio/reactivex/rxjava3/core/Observable;)V", "onNewCodeClicked", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$ScreenState;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$CodeRequestState;", "codeRequestState", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$RoutingAction;", "navigation", "CodeRequestState", "RoutingAction", "ScreenState", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public interface ConfirmPhoneViewModel {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$CodeRequestState;", "", "<init>", "()V", "CodeRequestDone", "CodeRequestEnabled", "CodeRequestInProgress", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$CodeRequestState$CodeRequestEnabled;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$CodeRequestState$CodeRequestInProgress;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$CodeRequestState$CodeRequestDone;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class CodeRequestState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$CodeRequestState$CodeRequestDone;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$CodeRequestState;", "", AuthSource.BOOKING_ORDER, "I", "getCodeLength", "()I", "codeLength", "", AuthSource.SEND_ABUSE, "J", "getTimeoutSeconds", "()J", "timeoutSeconds", "<init>", "(JI)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class CodeRequestDone extends CodeRequestState {
            public final long a;
            public final int b;

            public CodeRequestDone(long j, int i) {
                super(null);
                this.a = j;
                this.b = i;
            }

            public final int getCodeLength() {
                return this.b;
            }

            public final long getTimeoutSeconds() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$CodeRequestState$CodeRequestEnabled;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$CodeRequestState;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class CodeRequestEnabled extends CodeRequestState {
            @NotNull
            public static final CodeRequestEnabled INSTANCE = new CodeRequestEnabled();

            public CodeRequestEnabled() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$CodeRequestState$CodeRequestInProgress;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$CodeRequestState;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class CodeRequestInProgress extends CodeRequestState {
            @NotNull
            public static final CodeRequestInProgress INSTANCE = new CodeRequestInProgress();

            public CodeRequestInProgress() {
                super(null);
            }
        }

        public CodeRequestState() {
        }

        public CodeRequestState(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$RoutingAction;", "", "<init>", "()V", "GoBack", "GoToPhonesList", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$RoutingAction$GoBack;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$RoutingAction$GoToPhonesList;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RoutingAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$RoutingAction$GoBack;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$RoutingAction;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class GoBack extends RoutingAction {
            @NotNull
            public static final GoBack INSTANCE = new GoBack();

            public GoBack() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$RoutingAction$GoToPhonesList;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$RoutingAction;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "phone", "<init>", "(Ljava/lang/String;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class GoToPhonesList extends RoutingAction {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public GoToPhonesList(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "phone");
                this.a = str;
            }

            @NotNull
            public final String getPhone() {
                return this.a;
            }
        }

        public RoutingAction() {
        }

        public RoutingAction(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$ScreenState;", "", "<init>", "()V", "InputError", "Progress", "Ready", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$ScreenState$Ready;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$ScreenState$Progress;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$ScreenState$InputError;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ScreenState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$ScreenState$InputError;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$ScreenState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class InputError extends ScreenState {
            @Nullable
            public final String a;

            public InputError(@Nullable String str) {
                super(null);
                this.a = str;
            }

            @Nullable
            public final String getMessage() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$ScreenState$Progress;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$ScreenState;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class Progress extends ScreenState {
            @NotNull
            public static final Progress INSTANCE = new Progress();

            public Progress() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$ScreenState$Ready;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$ScreenState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "phone", "<init>", "(Ljava/lang/String;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class Ready extends ScreenState {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Ready(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "phone");
                this.a = str;
            }

            @NotNull
            public final String getPhone() {
                return this.a;
            }
        }

        public ScreenState() {
        }

        public ScreenState(j jVar) {
        }
    }

    @NotNull
    LiveData<CodeRequestState> codeRequestState();

    @NotNull
    LiveData<RoutingAction> navigation();

    void onBackClicked();

    void onNewCodeClicked();

    @NotNull
    LiveData<ScreenState> screenState();

    void subscribeToInputChanges(@NotNull Observable<CharSequence> observable);
}
