package com.avito.android.user_adverts.root_screen.adverts_host;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.LandingShownEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.IncomeInfo;
import com.avito.android.ui_components.R;
import com.avito.android.user_adverts.events.SoaInfoWasShownEvent;
import com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet.SoaInfoDialogData;
import com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet.SoaInfoInteractor;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.text.AttributedTextFormatter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001<B/\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u00106\u001a\u000203¢\u0006\u0004\b:\u0010;J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010$R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001f\u00109\u001a\b\u0012\u0004\u0012\u00020'0\f8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u000f\u001a\u0004\b8\u0010\u0011¨\u0006="}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostViewModel;", "Landroidx/lifecycle/ViewModel;", "", "init", "()V", "openSoaInfoDialog", "closeSoaInfoDialog", "onCleared", "", "showInfo", "c", "(Z)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostViewModel$State;", "f", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "state", "Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoDialogData;", "h", "Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoDialogData;", "soaInfoData", "Lcom/avito/android/analytics/Analytics;", "l", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoInteractor;", "i", "Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoInteractor;", "soaInfoInteractor", "Lcom/avito/android/util/text/AttributedTextFormatter;", "k", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "stateLiveData", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "", "d", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "messageLiveData", "Lio/reactivex/disposables/Disposable;", "e", "Lio/reactivex/disposables/Disposable;", "soaInfoDisposable", "Lcom/avito/android/util/SchedulersFactory;", "j", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", g.a, "getMessage", "message", "<init>", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/account/AccountStateProvider;)V", "State", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsHostViewModel extends ViewModel {
    public final MutableLiveData<State> c;
    public final SingleLiveEvent<Integer> d;
    public Disposable e;
    @NotNull
    public final LiveData<State> f;
    @NotNull
    public final LiveData<Integer> g;
    public SoaInfoDialogData h;
    public final SoaInfoInteractor i;
    public final SchedulersFactory j;
    public final AttributedTextFormatter k;
    public final Analytics l;
    public final AccountStateProvider m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostViewModel$State;", "", "Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoDialogData;", "component1", "()Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoDialogData;", "data", "copy", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoDialogData;)Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostViewModel$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoDialogData;", "getData", "<init>", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoDialogData;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @Nullable
        public final SoaInfoDialogData a;

        public State() {
            this(null, 1, null);
        }

        public State(@Nullable SoaInfoDialogData soaInfoDialogData) {
            this.a = soaInfoDialogData;
        }

        public static /* synthetic */ State copy$default(State state, SoaInfoDialogData soaInfoDialogData, int i, Object obj) {
            if ((i & 1) != 0) {
                soaInfoDialogData = state.a;
            }
            return state.copy(soaInfoDialogData);
        }

        @Nullable
        public final SoaInfoDialogData component1() {
            return this.a;
        }

        @NotNull
        public final State copy(@Nullable SoaInfoDialogData soaInfoDialogData) {
            return new State(soaInfoDialogData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof State) && Intrinsics.areEqual(this.a, ((State) obj).a);
            }
            return true;
        }

        @Nullable
        public final SoaInfoDialogData getData() {
            return this.a;
        }

        public int hashCode() {
            SoaInfoDialogData soaInfoDialogData = this.a;
            if (soaInfoDialogData != null) {
                return soaInfoDialogData.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("State(data=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ State(SoaInfoDialogData soaInfoDialogData, int i, j jVar) {
            this((i & 1) != 0 ? null : soaInfoDialogData);
        }
    }

    public static final class a<T> implements Consumer<LoadingState<? super IncomeInfo>> {
        public final /* synthetic */ UserAdvertsHostViewModel a;
        public final /* synthetic */ boolean b;

        public a(UserAdvertsHostViewModel userAdvertsHostViewModel, boolean z) {
            this.a = userAdvertsHostViewModel;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v6, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX DEBUG: Multi-variable search result rejected for r6v15, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super IncomeInfo> loadingState) {
            LoadingState<? super IncomeInfo> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                this.a.h = new SoaInfoDialogData(((IncomeInfo) loaded.getData()).getTitle(), this.a.k.format(((IncomeInfo) loaded.getData()).getAttributedText()), ((IncomeInfo) loaded.getData()).getConfirmTitle(), ((IncomeInfo) loaded.getData()).getImage());
                if (this.b) {
                    MutableLiveData mutableLiveData = this.a.c;
                    SoaInfoDialogData soaInfoDialogData = this.a.h;
                    Intrinsics.checkNotNull(soaInfoDialogData);
                    mutableLiveData.setValue(new State(soaInfoDialogData));
                }
            } else if ((loadingState2 instanceof LoadingState.Error) && this.b) {
                if (((LoadingState.Error) loadingState2).getError() instanceof ErrorResult.NetworkIOError) {
                    this.a.d.setValue(Integer.valueOf(R.string.connection_problem));
                } else {
                    this.a.d.setValue(Integer.valueOf(com.avito.android.user_adverts.R.string.my_adverts_default_error));
                }
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("load soa info error", th);
        }
    }

    public UserAdvertsHostViewModel(@NotNull SoaInfoInteractor soaInfoInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull Analytics analytics, @NotNull AccountStateProvider accountStateProvider) {
        Intrinsics.checkNotNullParameter(soaInfoInteractor, "soaInfoInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatus");
        this.i = soaInfoInteractor;
        this.j = schedulersFactory;
        this.k = attributedTextFormatter;
        this.l = analytics;
        this.m = accountStateProvider;
        MutableLiveData<State> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        SingleLiveEvent<Integer> singleLiveEvent = new SingleLiveEvent<>();
        this.d = singleLiveEvent;
        this.f = mutableLiveData;
        this.g = singleLiveEvent;
    }

    public final void c(boolean z) {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e = this.i.getSoaInfo().observeOn(this.j.mainThread()).subscribe(new a(this, z), b.a);
    }

    public final void closeSoaInfoDialog() {
        this.c.setValue(new State(null));
    }

    @NotNull
    public final LiveData<Integer> getMessage() {
        return this.g;
    }

    @NotNull
    public final LiveData<State> getState() {
        return this.f;
    }

    public final void init() {
        if (this.h == null) {
            c(false);
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onCleared();
    }

    public final void openSoaInfoDialog() {
        String currentUserId = this.m.getCurrentUserId();
        if (currentUserId != null) {
            this.l.track(new SoaInfoWasShownEvent(currentUserId));
        }
        this.l.track(new LandingShownEvent(UserAdvertsHostPresenterKt.PAGETYPE_SOLD_ITEMS_LANDING));
        SoaInfoDialogData soaInfoDialogData = this.h;
        if (soaInfoDialogData == null) {
            c(true);
        } else if (soaInfoDialogData != null) {
            this.c.setValue(new State(soaInfoDialogData));
        }
    }
}
