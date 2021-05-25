package com.avito.android.profile_phones.phone_action.view_model;

import a2.b.a.a.a;
import androidx.lifecycle.LiveData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002H&¢\u0006\u0004\b\u000f\u0010\u0005J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002H&¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\nH&¢\u0006\u0004\b\u0012\u0010\fJ#\u0010\u0016\u001a\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00140\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel;", "", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$Navigation;", "navigation", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$ScreenState;", "screenState", "", "errors", "", "onSubmitButtonClick", "()V", "onCloseButtonClick", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$PhoneInputState;", "phoneInputState", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$PhonesList;", "phonesListState", "onInputClick", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "phones", "onSelected", "(Ljava/util/List;)V", "Navigation", "PhoneInputState", "PhonesList", "ScreenState", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneActionViewModel {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$Navigation;", "", "<init>", "()V", "FinishWithCancel", "FinishWithSuccess", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$Navigation$FinishWithSuccess;", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$Navigation$FinishWithCancel;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Navigation {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$Navigation$FinishWithCancel;", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$Navigation;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class FinishWithCancel extends Navigation {
            @NotNull
            public static final FinishWithCancel INSTANCE = new FinishWithCancel();

            public FinishWithCancel() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$Navigation$FinishWithSuccess;", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$Navigation;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class FinishWithSuccess extends Navigation {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public FinishWithSuccess(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.a = str;
            }

            @NotNull
            public final String getMessage() {
                return this.a;
            }
        }

        public Navigation() {
        }

        public Navigation(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$PhoneInputState;", "", "<init>", "()V", "Input", "NoInput", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$PhoneInputState$Input;", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$PhoneInputState$NoInput;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class PhoneInputState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$PhoneInputState$Input;", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$PhoneInputState;", "", "c", "Ljava/lang/String;", "getValueText", "()Ljava/lang/String;", "valueText", AuthSource.SEND_ABUSE, "getPlaceholderText", "placeholderText", AuthSource.BOOKING_ORDER, "getMotivationText", "motivationText", "d", "getErrorText", "errorText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class Input extends PhoneInputState {
            @NotNull
            public final String a;
            @NotNull
            public final String b;
            @Nullable
            public final String c;
            @Nullable
            public final String d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Input(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "placeholderText");
                Intrinsics.checkNotNullParameter(str2, "motivationText");
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = str4;
            }

            @Nullable
            public final String getErrorText() {
                return this.d;
            }

            @NotNull
            public final String getMotivationText() {
                return this.b;
            }

            @NotNull
            public final String getPlaceholderText() {
                return this.a;
            }

            @Nullable
            public final String getValueText() {
                return this.c;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$PhoneInputState$NoInput;", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$PhoneInputState;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class NoInput extends PhoneInputState {
            @NotNull
            public static final NoInput INSTANCE = new NoInput();

            public NoInput() {
                super(null);
            }
        }

        public PhoneInputState() {
        }

        public PhoneInputState(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R%\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$PhonesList;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "Lcom/avito/android/remote/model/ParcelableEntity;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getPhones", "()Ljava/util/List;", "phones", "c", "Lcom/avito/android/remote/model/ParcelableEntity;", "getSelectedPhone", "()Lcom/avito/android/remote/model/ParcelableEntity;", "selectedPhone", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/ParcelableEntity;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static final class PhonesList {
        @NotNull
        public final String a;
        @NotNull
        public final List<ParcelableEntity<String>> b;
        @Nullable
        public final ParcelableEntity<String> c;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.ParcelableEntity<java.lang.String>> */
        /* JADX WARN: Multi-variable type inference failed */
        public PhonesList(@NotNull String str, @NotNull List<? extends ParcelableEntity<String>> list, @Nullable ParcelableEntity<String> parcelableEntity) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "phones");
            this.a = str;
            this.b = list;
            this.c = parcelableEntity;
        }

        @NotNull
        public final List<ParcelableEntity<String>> getPhones() {
            return this.b;
        }

        @Nullable
        public final ParcelableEntity<String> getSelectedPhone() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$ScreenState;", "", "<init>", "()V", "Initial", "Loading", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$ScreenState$Initial;", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$ScreenState$Loading;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ScreenState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$ScreenState$Initial;", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$ScreenState;", "", "c", "Ljava/lang/String;", "getButtonText", "()Ljava/lang/String;", "buttonText", AuthSource.SEND_ABUSE, "getTitle", "title", AuthSource.BOOKING_ORDER, "getMessage", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class Initial extends ScreenState {
            @NotNull
            public final String a;
            @NotNull
            public final String b;
            @NotNull
            public final String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Initial(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                super(null);
                a.Z0(str, "title", str2, "message", str3, "buttonText");
                this.a = str;
                this.b = str2;
                this.c = str3;
            }

            @NotNull
            public final String getButtonText() {
                return this.c;
            }

            @NotNull
            public final String getMessage() {
                return this.b;
            }

            @NotNull
            public final String getTitle() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$ScreenState$Loading;", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$ScreenState;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ScreenState {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        public ScreenState() {
        }

        public ScreenState(j jVar) {
        }
    }

    @NotNull
    LiveData<String> errors();

    @NotNull
    LiveData<Navigation> navigation();

    void onCloseButtonClick();

    void onInputClick();

    void onSelected(@NotNull List<? extends ParcelableEntity<String>> list);

    void onSubmitButtonClick();

    @NotNull
    LiveData<PhoneInputState> phoneInputState();

    @NotNull
    LiveData<PhonesList> phonesListState();

    @NotNull
    LiveData<ScreenState> screenState();
}
