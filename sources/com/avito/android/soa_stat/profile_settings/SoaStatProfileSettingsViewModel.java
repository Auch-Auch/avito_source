package com.avito.android.soa_stat.profile_settings;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.user_profile.IncomeProfileSettingsResponse;
import com.avito.android.soa_stat.events.SoaStatProfileSettingToggleEvent;
import com.avito.android.ui_components.R;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.text.AttributedTextFormatter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001*B'\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b(\u0010)J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00160$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "", "loadData", "()V", "", "value", "toggleSettingTo", "(Z)V", "Lcom/avito/android/analytics/Analytics;", "i", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory;", g.a, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/text/AttributedTextFormatter;", "h", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel$State;", "e", "Landroidx/lifecycle/LiveData;", "getStateLiveData", "()Landroidx/lifecycle/LiveData;", "stateLiveData", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsInteractor;", "f", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsInteractor;", "interactor", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "c", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "state", "<init>", "(Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/analytics/Analytics;)V", "State", "soa-stat_release"}, k = 1, mv = {1, 4, 2})
public final class SoaStatProfileSettingsViewModel extends ViewModel {
    public final SingleLiveEvent<State> c;
    public final CompositeDisposable d = new CompositeDisposable();
    @NotNull
    public final LiveData<State> e;
    public final SoaStatProfileSettingsInteractor f;
    public final SchedulersFactory g;
    public final AttributedTextFormatter h;
    public final Analytics i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel$State;", "", "<init>", "()V", "Error", "Loaded", "Loading", "ToggleError", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel$State$Loaded;", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel$State$Loading;", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel$State$Error;", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel$State$ToggleError;", "soa-stat_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel$State$Error;", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel$State;", "<init>", "()V", "soa-stat_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends State {
            @NotNull
            public static final Error INSTANCE = new Error();

            public Error() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel$State$Loaded;", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel$State;", "Lcom/avito/android/soa_stat/profile_settings/SoaStatSettingsPageData;", AuthSource.SEND_ABUSE, "Lcom/avito/android/soa_stat/profile_settings/SoaStatSettingsPageData;", "getPageData", "()Lcom/avito/android/soa_stat/profile_settings/SoaStatSettingsPageData;", "pageData", "<init>", "(Lcom/avito/android/soa_stat/profile_settings/SoaStatSettingsPageData;)V", "soa-stat_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends State {
            @NotNull
            public final SoaStatSettingsPageData a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loaded(@NotNull SoaStatSettingsPageData soaStatSettingsPageData) {
                super(null);
                Intrinsics.checkNotNullParameter(soaStatSettingsPageData, "pageData");
                this.a = soaStatSettingsPageData;
            }

            @NotNull
            public final SoaStatSettingsPageData getPageData() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel$State$Loading;", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel$State;", "<init>", "()V", "soa-stat_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends State {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel$State$ToggleError;", "Lcom/avito/android/soa_stat/profile_settings/SoaStatProfileSettingsViewModel$State;", "", AuthSource.BOOKING_ORDER, "I", "getTextResId", "()I", "textResId", "Lcom/avito/android/soa_stat/profile_settings/SoaStatSettingsPageData;", AuthSource.SEND_ABUSE, "Lcom/avito/android/soa_stat/profile_settings/SoaStatSettingsPageData;", "getPageData", "()Lcom/avito/android/soa_stat/profile_settings/SoaStatSettingsPageData;", "pageData", "<init>", "(Lcom/avito/android/soa_stat/profile_settings/SoaStatSettingsPageData;I)V", "soa-stat_release"}, k = 1, mv = {1, 4, 2})
        public static final class ToggleError extends State {
            @NotNull
            public final SoaStatSettingsPageData a;
            public final int b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ToggleError(@NotNull SoaStatSettingsPageData soaStatSettingsPageData, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(soaStatSettingsPageData, "pageData");
                this.a = soaStatSettingsPageData;
                this.b = i;
            }

            @NotNull
            public final SoaStatSettingsPageData getPageData() {
                return this.a;
            }

            public final int getTextResId() {
                return this.b;
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<LoadingState<? super IncomeProfileSettingsResponse>> {
        public final /* synthetic */ SoaStatProfileSettingsViewModel a;

        public a(SoaStatProfileSettingsViewModel soaStatProfileSettingsViewModel) {
            this.a = soaStatProfileSettingsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r10v4, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX DEBUG: Multi-variable search result rejected for r10v6, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super IncomeProfileSettingsResponse> loadingState) {
            LoadingState<? super IncomeProfileSettingsResponse> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                SingleLiveEvent singleLiveEvent = this.a.c;
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                String title = ((IncomeProfileSettingsResponse) loaded.getData()).getEnableField().getTitle();
                CharSequence format = this.a.h.format(((IncomeProfileSettingsResponse) loaded.getData()).getBody().getAttributedText());
                Intrinsics.checkNotNull(format);
                singleLiveEvent.setValue(new State.Loaded(new SoaStatSettingsPageData(title, format, ((IncomeProfileSettingsResponse) loaded.getData()).getBody().getImage(), Boolean.valueOf(((IncomeProfileSettingsResponse) loaded.getData()).getEnableField().getValue()), true)));
            } else if (loadingState2 instanceof LoadingState.Loading) {
                this.a.c.setValue(State.Loading.INSTANCE);
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.c.setValue(State.Error.INSTANCE);
            }
        }
    }

    public static final class b<T> implements Consumer<LoadingState<? super Unit>> {
        public final /* synthetic */ SoaStatProfileSettingsViewModel a;
        public final /* synthetic */ boolean b;

        public b(SoaStatProfileSettingsViewModel soaStatProfileSettingsViewModel, boolean z) {
            this.a = soaStatProfileSettingsViewModel;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r11v4, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX DEBUG: Multi-variable search result rejected for r11v6, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super Unit> loadingState) {
            LoadingState<? super Unit> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                this.a.c.setValue(new State.Loaded(new SoaStatSettingsPageData(null, null, null, null, false, 15, null)));
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                this.a.c.setValue(new State.Loaded(new SoaStatSettingsPageData(null, null, null, null, true, 15, null)));
            } else if (loadingState2 instanceof LoadingState.Error) {
                SoaStatProfileSettingsViewModel.access$proceedError(this.a, (LoadingState.Error) loadingState2, !this.b);
            }
        }
    }

    public SoaStatProfileSettingsViewModel(@NotNull SoaStatProfileSettingsInteractor soaStatProfileSettingsInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(soaStatProfileSettingsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.f = soaStatProfileSettingsInteractor;
        this.g = schedulersFactory;
        this.h = attributedTextFormatter;
        this.i = analytics;
        SingleLiveEvent<State> singleLiveEvent = new SingleLiveEvent<>();
        this.c = singleLiveEvent;
        this.e = singleLiveEvent;
    }

    public static final void access$proceedError(SoaStatProfileSettingsViewModel soaStatProfileSettingsViewModel, LoadingState.Error error, boolean z) {
        Objects.requireNonNull(soaStatProfileSettingsViewModel);
        SoaStatSettingsPageData soaStatSettingsPageData = new SoaStatSettingsPageData(null, null, null, Boolean.valueOf(z), true, 7, null);
        if (error.getError() instanceof ErrorResult.NetworkIOError) {
            soaStatProfileSettingsViewModel.c.setValue(new State.ToggleError(soaStatSettingsPageData, R.string.connection_problem));
        } else {
            soaStatProfileSettingsViewModel.c.setValue(new State.ToggleError(soaStatSettingsPageData, com.avito.android.soa_stat.R.string.default_error));
        }
    }

    @NotNull
    public final LiveData<State> getStateLiveData() {
        return this.e;
    }

    public final void loadData() {
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.f.getSoaStatSetting().observeOn(this.g.mainThread()).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor\n            .…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void toggleSettingTo(boolean z) {
        this.i.track(new SoaStatProfileSettingToggleEvent(z));
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.f.toggleSettingTo(z).observeOn(this.g.mainThread()).subscribe(new b(this, z));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor\n            .…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
