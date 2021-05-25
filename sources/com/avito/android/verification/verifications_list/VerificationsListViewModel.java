package com.avito.android.verification.verifications_list;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.VerificationOptionsListResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.verification.VerificationResourceProvider;
import com.avito.android.verification.verifications_list.list.VerificationOptionItem;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00029:B'\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b7\u00108J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00148\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00150/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u0006;"}, d2 = {"Lcom/avito/android/verification/verifications_list/VerificationsListViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onViewCreated", "()V", "loadVerificationsList", "refreshVerificationsList", "Lcom/avito/android/verification/verifications_list/list/VerificationOptionItem;", "option", "onVerificationOptionClicked", "(Lcom/avito/android/verification/verifications_list/list/VerificationOptionItem;)V", "onCleared", "Lio/reactivex/rxjava3/disposables/Disposable;", "c", "Lio/reactivex/rxjava3/disposables/Disposable;", "listDisposable", "", "f", "Z", "invalidated", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$RouterAction;", "h", "Landroidx/lifecycle/LiveData;", "getRouterAction", "()Landroidx/lifecycle/LiveData;", "routerAction", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$State;", "d", "Landroidx/lifecycle/MutableLiveData;", "screenStateLiveData", "Lcom/avito/android/verification/verifications_list/VerificationOptionsListConverter;", "l", "Lcom/avito/android/verification/verifications_list/VerificationOptionsListConverter;", "converter", "Lcom/avito/android/verification/VerificationResourceProvider;", "k", "Lcom/avito/android/verification/VerificationResourceProvider;", "resourceProvider", g.a, "getScreenState", "screenState", "Lcom/avito/android/verification/verifications_list/VerificationsListInteractor;", "i", "Lcom/avito/android/verification/verifications_list/VerificationsListInteractor;", "interactor", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "e", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routerActionLiveData", "Lcom/avito/android/util/SchedulersFactory3;", "j", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/verification/verifications_list/VerificationsListInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/verification/VerificationResourceProvider;Lcom/avito/android/verification/verifications_list/VerificationOptionsListConverter;)V", "RouterAction", "State", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationsListViewModel extends ViewModel {
    public Disposable c;
    public final MutableLiveData<State> d;
    public final SingleLiveEvent<RouterAction> e;
    public boolean f;
    @NotNull
    public final LiveData<State> g;
    @NotNull
    public final LiveData<RouterAction> h;
    public final VerificationsListInteractor i;
    public final SchedulersFactory3 j;
    public final VerificationResourceProvider k;
    public final VerificationOptionsListConverter l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$RouterAction;", "", "<init>", "()V", "ToVerificationStatus", "Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$RouterAction$ToVerificationStatus;", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RouterAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$RouterAction$ToVerificationStatus;", "Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$RouterAction;", "", "component1", "()Ljava/lang/String;", "type", "copy", "(Ljava/lang/String;)Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$RouterAction$ToVerificationStatus;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getType", "<init>", "(Ljava/lang/String;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
        public static final class ToVerificationStatus extends RouterAction {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ToVerificationStatus(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "type");
                this.a = str;
            }

            public static /* synthetic */ ToVerificationStatus copy$default(ToVerificationStatus toVerificationStatus, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = toVerificationStatus.a;
                }
                return toVerificationStatus.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final ToVerificationStatus copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "type");
                return new ToVerificationStatus(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof ToVerificationStatus) && Intrinsics.areEqual(this.a, ((ToVerificationStatus) obj).a);
                }
                return true;
            }

            @NotNull
            public final String getType() {
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
                return a2.b.a.a.a.t(a2.b.a.a.a.L("ToVerificationStatus(type="), this.a, ")");
            }
        }

        public RouterAction() {
        }

        public RouterAction(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$State;", "", "<init>", "()V", "Error", "Loaded", "Loading", "Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$State$Loaded;", "Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$State$Loading;", "Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$State$Error;", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$State$Error;", "Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$State;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$State$Error;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends State {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.a = str;
            }

            public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.a;
                }
                return error.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final Error copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "message");
                return new Error(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Error) && Intrinsics.areEqual(this.a, ((Error) obj).a);
                }
                return true;
            }

            @NotNull
            public final String getMessage() {
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
                return a2.b.a.a.a.t(a2.b.a.a.a.L("Error(message="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$State$Loaded;", "Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$State;", "Lcom/avito/android/verification/verifications_list/VerificationListScreenData;", "component1", "()Lcom/avito/android/verification/verifications_list/VerificationListScreenData;", "screenData", "copy", "(Lcom/avito/android/verification/verifications_list/VerificationListScreenData;)Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$State$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/verification/verifications_list/VerificationListScreenData;", "getScreenData", "<init>", "(Lcom/avito/android/verification/verifications_list/VerificationListScreenData;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends State {
            @NotNull
            public final VerificationListScreenData a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loaded(@NotNull VerificationListScreenData verificationListScreenData) {
                super(null);
                Intrinsics.checkNotNullParameter(verificationListScreenData, "screenData");
                this.a = verificationListScreenData;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, VerificationListScreenData verificationListScreenData, int i, Object obj) {
                if ((i & 1) != 0) {
                    verificationListScreenData = loaded.a;
                }
                return loaded.copy(verificationListScreenData);
            }

            @NotNull
            public final VerificationListScreenData component1() {
                return this.a;
            }

            @NotNull
            public final Loaded copy(@NotNull VerificationListScreenData verificationListScreenData) {
                Intrinsics.checkNotNullParameter(verificationListScreenData, "screenData");
                return new Loaded(verificationListScreenData);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Loaded) && Intrinsics.areEqual(this.a, ((Loaded) obj).a);
                }
                return true;
            }

            @NotNull
            public final VerificationListScreenData getScreenData() {
                return this.a;
            }

            public int hashCode() {
                VerificationListScreenData verificationListScreenData = this.a;
                if (verificationListScreenData != null) {
                    return verificationListScreenData.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Loaded(screenData=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$State$Loading;", "Lcom/avito/android/verification/verifications_list/VerificationsListViewModel$State;", "<init>", "()V", "verification_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends State {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<LoadingState<? super VerificationOptionsListResult>> {
        public final /* synthetic */ VerificationsListViewModel a;

        public a(VerificationsListViewModel verificationsListViewModel) {
            this.a = verificationsListViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super VerificationOptionsListResult> loadingState) {
            LoadingState<? super VerificationOptionsListResult> loadingState2 = loadingState;
            MutableLiveData mutableLiveData = this.a.d;
            VerificationsListViewModel verificationsListViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            mutableLiveData.setValue(VerificationsListViewModel.access$toScreenState(verificationsListViewModel, loadingState2));
        }
    }

    public static final class b<T> implements Consumer<LoadingState<? super VerificationOptionsListResult>> {
        public final /* synthetic */ VerificationsListViewModel a;

        public b(VerificationsListViewModel verificationsListViewModel) {
            this.a = verificationsListViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super VerificationOptionsListResult> loadingState) {
            LoadingState<? super VerificationOptionsListResult> loadingState2 = loadingState;
            MutableLiveData mutableLiveData = this.a.d;
            VerificationsListViewModel verificationsListViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            mutableLiveData.setValue(VerificationsListViewModel.access$toScreenState(verificationsListViewModel, loadingState2));
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ VerificationsListViewModel a;

        public c(VerificationsListViewModel verificationsListViewModel) {
            this.a = verificationsListViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.d.setValue(new State.Error(this.a.k.getDefaultVerificationsListErrorMessage()));
        }
    }

    public VerificationsListViewModel(@NotNull VerificationsListInteractor verificationsListInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull VerificationResourceProvider verificationResourceProvider, @NotNull VerificationOptionsListConverter verificationOptionsListConverter) {
        Intrinsics.checkNotNullParameter(verificationsListInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(verificationResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(verificationOptionsListConverter, "converter");
        this.i = verificationsListInteractor;
        this.j = schedulersFactory3;
        this.k = verificationResourceProvider;
        this.l = verificationOptionsListConverter;
        MutableLiveData<State> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        SingleLiveEvent<RouterAction> singleLiveEvent = new SingleLiveEvent<>();
        this.e = singleLiveEvent;
        this.g = mutableLiveData;
        this.h = singleLiveEvent;
        loadVerificationsList();
    }

    public static final State access$toScreenState(VerificationsListViewModel verificationsListViewModel, LoadingState loadingState) {
        State error;
        String str;
        Objects.requireNonNull(verificationsListViewModel);
        if (loadingState instanceof LoadingState.Loading) {
            return State.Loading.INSTANCE;
        }
        if (loadingState instanceof LoadingState.Loaded) {
            error = new State.Loaded(verificationsListViewModel.l.convert((VerificationOptionsListResult) ((LoadingState.Loaded) loadingState).getData()));
        } else if (loadingState instanceof LoadingState.Error) {
            TypedError error2 = ((LoadingState.Error) loadingState).getError();
            if (error2 instanceof ErrorWithMessage.NetworkError) {
                str = verificationsListViewModel.k.getNetworkErrorMessage();
            } else if (error2 instanceof ErrorWithMessage.Unknown) {
                str = ((ErrorWithMessage.Unknown) error2).getMessage();
            } else {
                str = verificationsListViewModel.k.getDefaultVerificationsListErrorMessage();
            }
            error = new State.Error(str);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return error;
    }

    @NotNull
    public final LiveData<RouterAction> getRouterAction() {
        return this.h;
    }

    @NotNull
    public final LiveData<State> getScreenState() {
        return this.g;
    }

    public final void loadVerificationsList() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = this.i.getVerificationsList().startWith(Observable.just(LoadingState.Loading.INSTANCE)).observeOn(this.j.mainThread()).subscribe(new a(this));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void onVerificationOptionClicked(@NotNull VerificationOptionItem verificationOptionItem) {
        Intrinsics.checkNotNullParameter(verificationOptionItem, "option");
        this.f = true;
        this.e.setValue(new RouterAction.ToVerificationStatus(verificationOptionItem.getType()));
    }

    public final void onViewCreated() {
        if (this.f) {
            this.f = false;
            loadVerificationsList();
        }
    }

    public final void refreshVerificationsList() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = this.i.getVerificationsList().observeOn(this.j.mainThread()).subscribe(new b(this), new c(this));
    }
}
