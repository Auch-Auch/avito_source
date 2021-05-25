package com.avito.android.profile_phones.phones_list;

import a2.b.a.a.a;
import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H&¢\u0006\u0004\b\u0016\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel;", "", "", "refresh", "()V", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;", "phone", "onPhoneClicked", "(Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ListState;", "phoneItemsState", "()Landroidx/lifecycle/LiveData;", "", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Action;", "action", "handlePhoneAction", "(Ljava/lang/String;Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Action;)V", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction;", "routingActions", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "snackbars", "message", "onPhoneActionSuccess", "(Ljava/lang/String;)V", "onAppBarActionClick", "ErrorType", "ListState", "RoutingAction", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public interface PhonesListViewModel {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ErrorType;", "", "<init>", "()V", "ListLoadingError", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ErrorType$ListLoadingError;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ErrorType {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ErrorType$ListLoadingError;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ErrorType;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class ListLoadingError extends ErrorType {
            @NotNull
            public static final ListLoadingError INSTANCE = new ListLoadingError();

            public ListLoadingError() {
                super(null);
            }
        }

        public ErrorType() {
        }

        public ErrorType(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ListState;", "", "<init>", "()V", "Error", "Loaded", "Loading", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ListState$Loading;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ListState$Error;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ListState$Loaded;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ListState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ListState$Error;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ListState;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ErrorType;", "component1", "()Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ErrorType;", "type", "copy", "(Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ErrorType;)Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ListState$Error;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ErrorType;", "getType", "<init>", "(Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ErrorType;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ListState {
            @NotNull
            public final ErrorType a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull ErrorType errorType) {
                super(null);
                Intrinsics.checkNotNullParameter(errorType, "type");
                this.a = errorType;
            }

            public static /* synthetic */ Error copy$default(Error error, ErrorType errorType, int i, Object obj) {
                if ((i & 1) != 0) {
                    errorType = error.a;
                }
                return error.copy(errorType);
            }

            @NotNull
            public final ErrorType component1() {
                return this.a;
            }

            @NotNull
            public final Error copy(@NotNull ErrorType errorType) {
                Intrinsics.checkNotNullParameter(errorType, "type");
                return new Error(errorType);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Error) && Intrinsics.areEqual(this.a, ((Error) obj).a);
                }
                return true;
            }

            @NotNull
            public final ErrorType getType() {
                return this.a;
            }

            public int hashCode() {
                ErrorType errorType = this.a;
                if (errorType != null) {
                    return errorType.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Error(type=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ListState$Loaded;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ListState;", "", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;", "component1", "()Ljava/util/List;", "list", "copy", "(Ljava/util/List;)Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ListState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getList", "<init>", "(Ljava/util/List;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends ListState {
            @NotNull
            public final List<PhoneListItem> a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loaded(@NotNull List<PhoneListItem> list) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "list");
                this.a = list;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.profile_phones.phones_list.PhonesListViewModel$ListState$Loaded */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.a;
                }
                return loaded.copy(list);
            }

            @NotNull
            public final List<PhoneListItem> component1() {
                return this.a;
            }

            @NotNull
            public final Loaded copy(@NotNull List<PhoneListItem> list) {
                Intrinsics.checkNotNullParameter(list, "list");
                return new Loaded(list);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Loaded) && Intrinsics.areEqual(this.a, ((Loaded) obj).a);
                }
                return true;
            }

            @NotNull
            public final List<PhoneListItem> getList() {
                return this.a;
            }

            public int hashCode() {
                List<PhoneListItem> list = this.a;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a.w(a.L("Loaded(list="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ListState$Loading;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$ListState;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ListState {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        public ListState() {
        }

        public ListState(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction;", "", "<init>", "()V", "OpenActionByDeepLink", "OpenActionsSheet", "OpenPhoneAddScreen", "OpenVerificationStatusStubDialog", "OpenVerificationStubDialog", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction$OpenVerificationStubDialog;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction$OpenVerificationStatusStubDialog;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction$OpenActionByDeepLink;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction$OpenPhoneAddScreen;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction$OpenActionsSheet;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RoutingAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction$OpenActionByDeepLink;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction$OpenActionByDeepLink;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class OpenActionByDeepLink extends RoutingAction {
            @NotNull
            public final DeepLink a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OpenActionByDeepLink(@NotNull DeepLink deepLink) {
                super(null);
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                this.a = deepLink;
            }

            public static /* synthetic */ OpenActionByDeepLink copy$default(OpenActionByDeepLink openActionByDeepLink, DeepLink deepLink, int i, Object obj) {
                if ((i & 1) != 0) {
                    deepLink = openActionByDeepLink.a;
                }
                return openActionByDeepLink.copy(deepLink);
            }

            @NotNull
            public final DeepLink component1() {
                return this.a;
            }

            @NotNull
            public final OpenActionByDeepLink copy(@NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                return new OpenActionByDeepLink(deepLink);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof OpenActionByDeepLink) && Intrinsics.areEqual(this.a, ((OpenActionByDeepLink) obj).a);
                }
                return true;
            }

            @NotNull
            public final DeepLink getDeepLink() {
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
                return a.m(a.L("OpenActionByDeepLink(deepLink="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction$OpenActionsSheet;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Action;", "component2", "()Ljava/util/List;", "phone", "actions", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction$OpenActionsSheet;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getActions", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class OpenActionsSheet extends RoutingAction {
            @NotNull
            public final String a;
            @NotNull
            public final List<PhoneListItem.Action> b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OpenActionsSheet(@NotNull String str, @NotNull List<PhoneListItem.Action> list) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "phone");
                Intrinsics.checkNotNullParameter(list, "actions");
                this.a = str;
                this.b = list;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.profile_phones.phones_list.PhonesListViewModel$RoutingAction$OpenActionsSheet */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ OpenActionsSheet copy$default(OpenActionsSheet openActionsSheet, String str, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = openActionsSheet.a;
                }
                if ((i & 2) != 0) {
                    list = openActionsSheet.b;
                }
                return openActionsSheet.copy(str, list);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final List<PhoneListItem.Action> component2() {
                return this.b;
            }

            @NotNull
            public final OpenActionsSheet copy(@NotNull String str, @NotNull List<PhoneListItem.Action> list) {
                Intrinsics.checkNotNullParameter(str, "phone");
                Intrinsics.checkNotNullParameter(list, "actions");
                return new OpenActionsSheet(str, list);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OpenActionsSheet)) {
                    return false;
                }
                OpenActionsSheet openActionsSheet = (OpenActionsSheet) obj;
                return Intrinsics.areEqual(this.a, openActionsSheet.a) && Intrinsics.areEqual(this.b, openActionsSheet.b);
            }

            @NotNull
            public final List<PhoneListItem.Action> getActions() {
                return this.b;
            }

            @NotNull
            public final String getPhone() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                List<PhoneListItem.Action> list = this.b;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("OpenActionsSheet(phone=");
                L.append(this.a);
                L.append(", actions=");
                return a.w(L, this.b, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction$OpenPhoneAddScreen;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class OpenPhoneAddScreen extends RoutingAction {
            @NotNull
            public static final OpenPhoneAddScreen INSTANCE = new OpenPhoneAddScreen();

            public OpenPhoneAddScreen() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction$OpenVerificationStatusStubDialog;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction;", "", "component1", "()Ljava/lang/String;", "phone", "copy", "(Ljava/lang/String;)Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction$OpenVerificationStatusStubDialog;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", "<init>", "(Ljava/lang/String;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class OpenVerificationStatusStubDialog extends RoutingAction {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OpenVerificationStatusStubDialog(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "phone");
                this.a = str;
            }

            public static /* synthetic */ OpenVerificationStatusStubDialog copy$default(OpenVerificationStatusStubDialog openVerificationStatusStubDialog, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = openVerificationStatusStubDialog.a;
                }
                return openVerificationStatusStubDialog.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final OpenVerificationStatusStubDialog copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "phone");
                return new OpenVerificationStatusStubDialog(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof OpenVerificationStatusStubDialog) && Intrinsics.areEqual(this.a, ((OpenVerificationStatusStubDialog) obj).a);
                }
                return true;
            }

            @NotNull
            public final String getPhone() {
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
                return a.t(a.L("OpenVerificationStatusStubDialog(phone="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction$OpenVerificationStubDialog;", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModel$RoutingAction;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class OpenVerificationStubDialog extends RoutingAction {
            @NotNull
            public static final OpenVerificationStubDialog INSTANCE = new OpenVerificationStubDialog();

            public OpenVerificationStubDialog() {
                super(null);
            }
        }

        public RoutingAction() {
        }

        public RoutingAction(j jVar) {
        }
    }

    void handlePhoneAction(@NotNull String str, @NotNull PhoneListItem.Action action);

    void onAppBarActionClick();

    void onPhoneActionSuccess(@Nullable String str);

    void onPhoneClicked(@NotNull PhoneListItem phoneListItem);

    @NotNull
    LiveData<ListState> phoneItemsState();

    void refresh();

    @NotNull
    SingleLiveEvent<RoutingAction> routingActions();

    @NotNull
    SingleLiveEvent<String> snackbars();
}
