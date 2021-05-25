package com.avito.android.profile_phones.add_phone;

import a2.b.a.a.a;
import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\u000f\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\tH&¢\u0006\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel;", "", "", "onCloseClicked", "()V", "", "phone", "onContinueClicked", "(Ljava/lang/String;)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$ScreenState;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$RoutingAction;", "navigation", "RoutingAction", "ScreenState", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public interface AddPhoneViewModel {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$RoutingAction;", "", "<init>", "()V", "GoBack", "GoByDeeplink", "GoToPhoneConfirmation", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$RoutingAction$GoBack;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$RoutingAction$GoToPhoneConfirmation;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$RoutingAction$GoByDeeplink;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RoutingAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$RoutingAction$GoBack;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$RoutingAction;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class GoBack extends RoutingAction {
            @NotNull
            public static final GoBack INSTANCE = new GoBack();

            public GoBack() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$RoutingAction$GoByDeeplink;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$RoutingAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$RoutingAction$GoByDeeplink;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class GoByDeeplink extends RoutingAction {
            @NotNull
            public final DeepLink a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public GoByDeeplink(@NotNull DeepLink deepLink) {
                super(null);
                Intrinsics.checkNotNullParameter(deepLink, "deeplink");
                this.a = deepLink;
            }

            public static /* synthetic */ GoByDeeplink copy$default(GoByDeeplink goByDeeplink, DeepLink deepLink, int i, Object obj) {
                if ((i & 1) != 0) {
                    deepLink = goByDeeplink.a;
                }
                return goByDeeplink.copy(deepLink);
            }

            @NotNull
            public final DeepLink component1() {
                return this.a;
            }

            @NotNull
            public final GoByDeeplink copy(@NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(deepLink, "deeplink");
                return new GoByDeeplink(deepLink);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof GoByDeeplink) && Intrinsics.areEqual(this.a, ((GoByDeeplink) obj).a);
                }
                return true;
            }

            @NotNull
            public final DeepLink getDeeplink() {
                return this.a;
            }

            public int hashCode() {
                DeepLink deepLink = this.a;
                if (deepLink != null) {
                    return deepLink.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a.m(a.L("GoByDeeplink(deeplink="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\n¨\u0006\""}, d2 = {"Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$RoutingAction$GoToPhoneConfirmation;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$RoutingAction;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "component3", "()J", "phone", "codeLength", "timeout", "copy", "(Ljava/lang/String;IJ)Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$RoutingAction$GoToPhoneConfirmation;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", AuthSource.BOOKING_ORDER, "I", "getCodeLength", "c", "J", "getTimeout", "<init>", "(Ljava/lang/String;IJ)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class GoToPhoneConfirmation extends RoutingAction {
            @NotNull
            public final String a;
            public final int b;
            public final long c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public GoToPhoneConfirmation(@NotNull String str, int i, long j) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "phone");
                this.a = str;
                this.b = i;
                this.c = j;
            }

            public static /* synthetic */ GoToPhoneConfirmation copy$default(GoToPhoneConfirmation goToPhoneConfirmation, String str, int i, long j, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = goToPhoneConfirmation.a;
                }
                if ((i2 & 2) != 0) {
                    i = goToPhoneConfirmation.b;
                }
                if ((i2 & 4) != 0) {
                    j = goToPhoneConfirmation.c;
                }
                return goToPhoneConfirmation.copy(str, i, j);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            public final int component2() {
                return this.b;
            }

            public final long component3() {
                return this.c;
            }

            @NotNull
            public final GoToPhoneConfirmation copy(@NotNull String str, int i, long j) {
                Intrinsics.checkNotNullParameter(str, "phone");
                return new GoToPhoneConfirmation(str, i, j);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof GoToPhoneConfirmation)) {
                    return false;
                }
                GoToPhoneConfirmation goToPhoneConfirmation = (GoToPhoneConfirmation) obj;
                return Intrinsics.areEqual(this.a, goToPhoneConfirmation.a) && this.b == goToPhoneConfirmation.b && this.c == goToPhoneConfirmation.c;
            }

            public final int getCodeLength() {
                return this.b;
            }

            @NotNull
            public final String getPhone() {
                return this.a;
            }

            public final long getTimeout() {
                return this.c;
            }

            public int hashCode() {
                String str = this.a;
                return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + c.a(this.c);
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("GoToPhoneConfirmation(phone=");
                L.append(this.a);
                L.append(", codeLength=");
                L.append(this.b);
                L.append(", timeout=");
                return a.l(L, this.c, ")");
            }
        }

        public RoutingAction() {
        }

        public RoutingAction(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$ScreenState;", "", "<init>", "()V", "Error", "Loading", "Ok", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$ScreenState$Ok;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$ScreenState$Loading;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$ScreenState$Error;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ScreenState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$ScreenState$Error;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$ScreenState;", "", "component1", "()Ljava/lang/String;", "text", "copy", "(Ljava/lang/String;)Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$ScreenState$Error;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ScreenState {
            @Nullable
            public final String a;

            public Error(@Nullable String str) {
                super(null);
                this.a = str;
            }

            public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.a;
                }
                return error.copy(str);
            }

            @Nullable
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final Error copy(@Nullable String str) {
                return new Error(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Error) && Intrinsics.areEqual(this.a, ((Error) obj).a);
                }
                return true;
            }

            @Nullable
            public final String getText() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a.t(a.L("Error(text="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$ScreenState$Loading;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$ScreenState;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ScreenState {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$ScreenState$Ok;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$ScreenState;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class Ok extends ScreenState {
            @NotNull
            public static final Ok INSTANCE = new Ok();

            public Ok() {
                super(null);
            }
        }

        public ScreenState() {
        }

        public ScreenState(j jVar) {
        }
    }

    @NotNull
    LiveData<RoutingAction> navigation();

    void onCloseClicked();

    void onContinueClicked(@NotNull String str);

    @NotNull
    LiveData<ScreenState> screenState();
}
