package com.avito.android.user_advert.advert.switcher_block;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SimpleMessageResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.user_advert.advert.MyAdvertDetailsItem;
import com.avito.android.user_advert.advert.switcher_block.SwitcherState;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Disposables;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B/\u0012\u0006\u0010T\u001a\u00020&\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010F\u001a\u00020C¢\u0006\u0004\bU\u0010VJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0005H$¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u0016*\u00020\u0016H\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001c\u0010\u0015R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010 R$\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010 \u001a\u0004\b*\u0010+R.\u00105\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010-8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020:0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010 R\"\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010 \u001a\u0004\b>\u0010+R\"\u0010B\u001a\b\u0012\u0004\u0012\u00020:0\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b@\u0010 \u001a\u0004\bA\u0010+R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010S¨\u0006W"}, d2 = {"Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockViewModel;", "Lcom/avito/android/user_advert/advert/switcher_block/AdvertLoadListener;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;", "advert", "", "onAdvertLoaded", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;)V", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Switcher;", "getSwitcher", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;)Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Switcher;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "attachDeepLinkListener", "(Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;)V", "detachDeepLinkListener", "()V", "", "newValue", "onSwitchChanged", "(Z)V", "isCurrentSwitchValue", "(Z)Z", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherInfo;", "f", "Landroidx/lifecycle/MutableLiveData;", "dataChangesLiveData", "Lcom/avito/android/util/SchedulersFactory3;", "n", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", "e", "errorsLiveData", "h", "getErrors", "()Landroidx/lifecycle/MutableLiveData;", "errors", "Lcom/avito/android/user_advert/advert/switcher_block/UserAdvertSource;", "value", "k", "Lcom/avito/android/user_advert/advert/switcher_block/UserAdvertSource;", "getUserAdvertSource", "()Lcom/avito/android/user_advert/advert/switcher_block/UserAdvertSource;", "setUserAdvertSource", "(Lcom/avito/android/user_advert/advert/switcher_block/UserAdvertSource;)V", "userAdvertSource", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "o", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherState;", g.a, "switcherStateLiveData", "i", "getDataChanges", "dataChanges", "j", "getSwitcherState", "switcherState", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockResourceProvider;", "p", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockResourceProvider;", "resourceProvider", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "d", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "deepLinkListener", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherChangeStateInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherChangeStateInteractor;", "interactor", "l", "Ljava/lang/String;", "itemId", "<init>", "(Ljava/lang/String;Lcom/avito/android/user_advert/advert/switcher_block/SwitcherChangeStateInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockResourceProvider;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public abstract class SwitcherBlockViewModelImpl extends ViewModel implements SwitcherBlockViewModel, AdvertLoadListener, OnDeepLinkClickListener {
    public final CompositeDisposable c = new CompositeDisposable();
    public OnDeepLinkClickListener d;
    public final MutableLiveData<String> e;
    public final MutableLiveData<SwitcherInfo> f;
    public final MutableLiveData<SwitcherState> g;
    @NotNull
    public final MutableLiveData<String> h;
    @NotNull
    public final MutableLiveData<SwitcherInfo> i;
    @NotNull
    public final MutableLiveData<SwitcherState> j;
    @Nullable
    public UserAdvertSource k;
    public final String l;
    public final SwitcherChangeStateInteractor m;
    public final SchedulersFactory3 n;
    public final TypedErrorThrowableConverter o;
    public final SwitcherBlockResourceProvider p;

    public static final class a<T, R> implements Function<TypedResult<SimpleMessageResult>, LoadingState<? super SimpleMessageResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SimpleMessageResult> apply(TypedResult<SimpleMessageResult> typedResult) {
            TypedResult<SimpleMessageResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super SimpleMessageResult>> {
        public final /* synthetic */ SwitcherBlockViewModelImpl a;

        public b(SwitcherBlockViewModelImpl switcherBlockViewModelImpl) {
            this.a = switcherBlockViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SimpleMessageResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.o;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class c<T> implements Consumer<LoadingState<? super SimpleMessageResult>> {
        public final /* synthetic */ SwitcherBlockViewModelImpl a;
        public final /* synthetic */ boolean b;

        public c(SwitcherBlockViewModelImpl switcherBlockViewModelImpl, boolean z) {
            this.a = switcherBlockViewModelImpl;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super SimpleMessageResult> loadingState) {
            LoadingState<? super SimpleMessageResult> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                this.a.getSwitcherState().setValue(SwitcherState.Progress.INSTANCE);
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                UserAdvertSource userAdvertSource = this.a.getUserAdvertSource();
                if (userAdvertSource != null) {
                    userAdvertSource.updateSwitcherValue(new a2.a.a.h3.a.h1.a(this.a), this.b);
                }
                this.a.getSwitcherState().setValue(new SwitcherState.Specified(this.b));
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.getErrors().setValue(SwitcherBlockViewModelKt.access$errorMessageByDesiredSwitcherValue(this.a.p, this.b));
                this.a.getSwitcherState().setValue(new SwitcherState.Specified(!this.b));
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ SwitcherBlockViewModelImpl a;
        public final /* synthetic */ boolean b;

        public d(SwitcherBlockViewModelImpl switcherBlockViewModelImpl, boolean z) {
            this.a = switcherBlockViewModelImpl;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to update autopublish switch state", th);
            this.a.getErrors().setValue(SwitcherBlockViewModelKt.access$errorMessageByDesiredSwitcherValue(this.a.p, this.b));
            this.a.getSwitcherState().setValue(new SwitcherState.Specified(!this.b));
        }
    }

    public SwitcherBlockViewModelImpl(@NotNull String str, @NotNull SwitcherChangeStateInteractor switcherChangeStateInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SwitcherBlockResourceProvider switcherBlockResourceProvider) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(switcherChangeStateInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(switcherBlockResourceProvider, "resourceProvider");
        this.l = str;
        this.m = switcherChangeStateInteractor;
        this.n = schedulersFactory3;
        this.o = typedErrorThrowableConverter;
        this.p = switcherBlockResourceProvider;
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.e = mutableLiveData;
        MutableLiveData<SwitcherInfo> mutableLiveData2 = new MutableLiveData<>();
        this.f = mutableLiveData2;
        MutableLiveData<SwitcherState> mutableLiveData3 = new MutableLiveData<>();
        this.g = mutableLiveData3;
        this.h = mutableLiveData;
        this.i = mutableLiveData2;
        this.j = mutableLiveData3;
    }

    public final void attachDeepLinkListener(@NotNull OnDeepLinkClickListener onDeepLinkClickListener) {
        Intrinsics.checkNotNullParameter(onDeepLinkClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d = onDeepLinkClickListener;
    }

    public final void detachDeepLinkListener() {
        this.d = null;
    }

    @Nullable
    public abstract MyAdvertDetails.Switcher getSwitcher(@NotNull MyAdvertDetailsItem myAdvertDetailsItem);

    @Nullable
    public final UserAdvertSource getUserAdvertSource() {
        return this.k;
    }

    public final boolean isCurrentSwitchValue(boolean z) {
        SwitcherState value = getSwitcherState().getValue();
        return (value instanceof SwitcherState.Specified) && ((SwitcherState.Specified) value).isChecked() == z;
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.AdvertLoadListener
    public void onAdvertLoaded(@NotNull MyAdvertDetailsItem myAdvertDetailsItem) {
        Intrinsics.checkNotNullParameter(myAdvertDetailsItem, "advert");
        getErrors().setValue(null);
        MyAdvertDetails.Switcher switcher = getSwitcher(myAdvertDetailsItem);
        if (switcher != null) {
            AttributedText subtitle = switcher.getSubtitle();
            if (subtitle != null) {
                subtitle.setOnDeepLinkClickListener(this);
            }
            getDataChanges().setValue(new SwitcherInfo(switcher.getTitle(), switcher.getSubtitle()));
            Boolean value = switcher.getValue();
            if (value != null) {
                getSwitcherState().setValue(new SwitcherState.Specified(value.booleanValue()));
            }
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.c.clear();
        UserAdvertSource userAdvertSource = this.k;
        if (userAdvertSource != null) {
            userAdvertSource.removeAdvertLoadListener(this);
        }
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        OnDeepLinkClickListener onDeepLinkClickListener = this.d;
        if (onDeepLinkClickListener != null) {
            onDeepLinkClickListener.onDeepLinkClick(deepLink);
        }
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.SwitcherBlockViewModel
    public void onSwitchChanged(boolean z) {
        if (!isCurrentSwitchValue(z)) {
            getErrors().setValue(null);
            CompositeDisposable compositeDisposable = this.c;
            Disposable subscribe = this.m.setSwitcherEnabled(this.l, z).map(a.a).onErrorReturn(new b(this)).toObservable().startWithItem((R) LoadingState.Loading.INSTANCE).subscribeOn(this.n.io()).observeOn(this.n.mainThread()).subscribe(new c(this, z), new d(this, z));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.setSwitcherEn…          }\n            )");
            Disposables.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void setUserAdvertSource(@Nullable UserAdvertSource userAdvertSource) {
        if (userAdvertSource != null) {
            userAdvertSource.addAdvertLoadListener(this);
        }
        this.k = userAdvertSource;
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.SwitcherBlockViewModel
    @NotNull
    public MutableLiveData<SwitcherInfo> getDataChanges() {
        return this.i;
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.SwitcherBlockViewModel
    @NotNull
    public MutableLiveData<String> getErrors() {
        return this.h;
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.SwitcherBlockViewModel
    @NotNull
    public MutableLiveData<SwitcherState> getSwitcherState() {
        return this.j;
    }
}
