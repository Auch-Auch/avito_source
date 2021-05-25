package com.avito.android.messenger.map.search;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.messenger.R;
import com.avito.android.messenger.analytics.MessengerGeoSearchLocationPick;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView;
import com.avito.android.messenger.map.search.GeoSearchPresenter;
import com.avito.android.messenger.map.search.GeoSearchView;
import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItem;
import com.avito.android.messenger.map.search.di.DaggerGeoSearchFragmentComponent;
import com.avito.android.messenger.map.search.di.GeoSearchFragmentComponent;
import com.avito.android.messenger.map.search.di.GeoSearchFragmentDependencies;
import com.avito.android.messenger.map.search.di.GeoSearchFragmentModule;
import com.avito.android.remote.model.messenger.geo.GeoPoint;
import com.avito.android.remote.model.messenger.geo.GeoSearchSuggest;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.ActionBarUtils;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.Keyboards;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.f;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\bC\u0010\u0010J-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b*\u0010\u001aR\u0016\u0010/\u001a\u00020,8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X.¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010=\u001a\u00020<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "Lcom/avito/android/remote/model/messenger/geo/GeoPoint;", g.a, "Lcom/avito/android/remote/model/messenger/geo/GeoPoint;", "centerPoint", "h", "itemLocation", "", "d", "Ljava/lang/String;", "channelId", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter;", "presenter", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter;", "getPresenter", "()Lcom/avito/android/messenger/map/search/GeoSearchPresenter;", "setPresenter", "(Lcom/avito/android/messenger/map/search/GeoSearchPresenter;)V", "e", "initialQuery", "Lcom/avito/android/messenger/map/search/GeoSearchView;", "c", "Lcom/avito/android/messenger/map/search/GeoSearchView;", "geoSearchView", "Lio/reactivex/disposables/CompositeDisposable;", "j", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "", "i", "Z", "firstStart", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "f", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "defaultState", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "<init>", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class GeoSearchFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "GeoSearchFragment";
    @Inject
    public AdapterPresenter adapterPresenter;
    public GeoSearchView c;
    public String d;
    public String e;
    public GeoSearchPresenter.State f;
    public GeoPoint g;
    public GeoPoint h;
    public boolean i;
    @Inject
    public ItemBinder itemBinder;
    public final CompositeDisposable j = new CompositeDisposable();
    @Inject
    public GeoSearchPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J4\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchFragment$Companion;", "", "", "channelId", "initialQuery", "Lcom/avito/android/remote/model/messenger/geo/GeoPoint;", "centerPoint", "itemLocation", "Lcom/avito/android/messenger/map/search/GeoSearchFragment;", "invoke", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/geo/GeoPoint;Lcom/avito/android/remote/model/messenger/geo/GeoPoint;)Lcom/avito/android/messenger/map/search/GeoSearchFragment;", "KEY_CENTER_POINT", "Ljava/lang/String;", "KEY_CHANNEL_ID", "KEY_INITIAL_QUERY", "KEY_ITEM_LOCATION", "TAG", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ GeoPoint c;
            public final /* synthetic */ GeoPoint d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, GeoPoint geoPoint, GeoPoint geoPoint2) {
                super(1);
                this.a = str;
                this.b = str2;
                this.c = geoPoint;
                this.d = geoPoint2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putString("channel_id", this.a);
                bundle2.putString("initial_query", this.b);
                GeoPoint geoPoint = this.c;
                if (geoPoint != null) {
                    bundle2.putParcelable(GeoSearchFragmentModule.CENTER_POINT, geoPoint);
                }
                GeoPoint geoPoint2 = this.d;
                if (geoPoint2 != null) {
                    bundle2.putParcelable(GeoSearchFragmentModule.ITEM_LOCATION, geoPoint2);
                }
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final GeoSearchFragment invoke(@NotNull String str, @NotNull String str2, @Nullable GeoPoint geoPoint, @Nullable GeoPoint geoPoint2) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(str2, "initialQuery");
            return (GeoSearchFragment) FragmentsKt.arguments(new GeoSearchFragment(), 4, new a(str, str2, geoPoint, geoPoint2));
        }

        public Companion(j jVar) {
        }
    }

    public static final /* synthetic */ String access$getChannelId$p(GeoSearchFragment geoSearchFragment) {
        String str = geoSearchFragment.d;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        return str;
    }

    public static final /* synthetic */ GeoSearchPresenter.State access$getDefaultState$p(GeoSearchFragment geoSearchFragment) {
        GeoSearchPresenter.State state = geoSearchFragment.f;
        if (state == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultState");
        }
        return state;
    }

    public static final /* synthetic */ GeoSearchView access$getGeoSearchView$p(GeoSearchFragment geoSearchFragment) {
        GeoSearchView geoSearchView = geoSearchFragment.c;
        if (geoSearchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("geoSearchView");
        }
        return geoSearchView;
    }

    public static final /* synthetic */ String access$getInitialQuery$p(GeoSearchFragment geoSearchFragment) {
        String str = geoSearchFragment.e;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialQuery");
        }
        return str;
    }

    public static final GeoSearchSuggest access$toSuggest(GeoSearchFragment geoSearchFragment, GeoSearchSuggestItem geoSearchSuggestItem) {
        Objects.requireNonNull(geoSearchFragment);
        return new GeoSearchSuggest(geoSearchSuggestItem.getLatitude(), geoSearchSuggestItem.getLongitude(), geoSearchSuggestItem.getKind(), geoSearchSuggestItem.getTitle(), geoSearchSuggestItem.getName(), geoSearchSuggestItem.getDescription(), Boolean.valueOf(Intrinsics.areEqual(geoSearchSuggestItem.getAddressType(), MessengerGeoSearchLocationPick.ITEM_SUGGEST)));
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final GeoSearchPresenter getPresenter() {
        GeoSearchPresenter geoSearchPresenter = this.presenter;
        if (geoSearchPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return geoSearchPresenter;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.messenger_geo_search_fragment, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Disposable subscribe = getPresenter().getStateObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<GeoSearchPresenter.State>() { // from class: com.avito.android.messenger.map.search.GeoSearchFragment$bindView$1
            public final void accept(GeoSearchPresenter.State state) {
                GeoSearchView access$getGeoSearchView$p = GeoSearchFragment.access$getGeoSearchView$p(GeoSearchFragment.this);
                Intrinsics.checkNotNullExpressionValue(state, "viewState");
                access$getGeoSearchView$p.render(state);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "presenter.stateObservabl…(viewState)\n            }");
        DisposableKt.addTo(subscribe, this.j);
        getPresenter().getSendSuggestStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.map.search.GeoSearchFragment$bindView$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    FragmentActivity activity = GeoSearchFragment.this.getActivity();
                    if (activity != null) {
                        activity.setResult(-1, new Intent().putExtra(GeoSearchFragmentKt.EXTRA_SELECTED_SUGGEST, new GeoSearchSuggest(t2.getLatitude(), t2.getLongitude(), t2.getKind(), t2.getTitle(), t2.getName(), t2.getDescription(), Boolean.valueOf(Intrinsics.areEqual(t2.getAddressType(), MessengerGeoSearchLocationPick.ITEM_SUGGEST)))));
                        Keyboards.hideKeyboard(activity);
                        activity.finish();
                    }
                }
            }
        });
        getPresenter().getSetQueryStream().observe(getViewLifecycleOwner(), new Observer<T>() { // from class: com.avito.android.messenger.map.search.GeoSearchFragment$bindView$$inlined$observeNotNull$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    GeoSearchFragment.access$getGeoSearchView$p(GeoSearchFragment.this).setQuery(t);
                }
            }
        });
        Disposable subscribe2 = access$getGeoSearchView$p(this).getQueryStream().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() { // from class: com.avito.android.messenger.map.search.GeoSearchFragment$bindView$4
            public final void accept(String str) {
                GeoSearchPresenter presenter2 = GeoSearchFragment.this.getPresenter();
                Intrinsics.checkNotNullExpressionValue(str, "query");
                presenter2.queryChanged(str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe2, "geoSearchView.queryStrea…nged(query)\n            }");
        DisposableKt.addTo(subscribe2, this.j);
        if (this.i && (!m.isBlank(access$getInitialQuery$p(this)))) {
            access$getGeoSearchView$p(this).setQuery(access$getInitialQuery$p(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.j.clear();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        GeoPoint geoPoint = null;
        String string = arguments != null ? arguments.getString("channel_id") : null;
        Intrinsics.checkNotNull(string);
        this.d = string;
        Bundle arguments2 = getArguments();
        this.g = arguments2 != null ? (GeoPoint) arguments2.getParcelable(GeoSearchFragmentModule.CENTER_POINT) : null;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            geoPoint = (GeoPoint) arguments3.getParcelable(GeoSearchFragmentModule.ITEM_LOCATION);
        }
        this.h = geoPoint;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str = arguments4.getString("initial_query")) == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "arguments?.getString(KEY_INITIAL_QUERY) ?: \"\"");
        this.e = str;
        this.f = new GeoSearchPresenter.State(str) { // from class: com.avito.android.messenger.map.search.GeoSearchFragment$onViewCreated$1
            @NotNull
            public final String a;
            @NotNull
            public final GeoSearchView.ListState.Empty b = GeoSearchView.ListState.Empty.INSTANCE;
            @NotNull
            public final ConnectionErrorIndicatorView.State.Hidden c = ConnectionErrorIndicatorView.State.Hidden.INSTANCE;
            @NotNull
            public final Loading.Empty<List<GeoSearchSuggestItem>> d = new Loading.Empty<>();
            @NotNull
            public final List<GeoSearchSuggestItem> e = CollectionsKt__CollectionsKt.emptyList();

            {
                this.a = r1;
            }

            @Override // com.avito.android.messenger.map.search.GeoSearchPresenter.State
            @NotNull
            public List<GeoSearchSuggestItem> getFavoritePlaces() {
                return this.e;
            }

            @Override // com.avito.android.messenger.map.search.GeoSearchView.State
            @NotNull
            public String getQuery() {
                return this.a;
            }

            @Override // com.avito.android.messenger.map.search.GeoSearchView.State
            public boolean getSearchIsInProgress() {
                return false;
            }

            @Override // com.avito.android.messenger.map.search.GeoSearchPresenter.State
            @NotNull
            public String toString() {
                StringBuilder L = a.L("GeoSearchPresenter.State(\n        |   query=");
                L.append(getQuery());
                L.append(",\n        |   listState=");
                L.append(getListState());
                L.append(",\n        |   searchIsInProgress=");
                L.append(getSearchIsInProgress());
                L.append(",\n        |   connectionErrorIndicatorState=");
                L.append(getConnectionErrorIndicatorState());
                L.append(",\n        |   searchSuggests=");
                L.append(getSearchSuggests());
                L.append(",\n        |   favoritePlaces=");
                L.append(getFavoritePlaces());
                L.append("\n        |)");
                return f.trimMargin$default(L.toString(), null, 1, null);
            }

            @Override // com.avito.android.messenger.map.search.GeoSearchView.State
            @NotNull
            public ConnectionErrorIndicatorView.State.Hidden getConnectionErrorIndicatorState() {
                return this.c;
            }

            @Override // com.avito.android.messenger.map.search.GeoSearchView.State
            @NotNull
            public GeoSearchView.ListState.Empty getListState() {
                return this.b;
            }

            @Override // com.avito.android.messenger.map.search.GeoSearchPresenter.State
            @NotNull
            public Loading.Empty<List<GeoSearchSuggestItem>> getSearchSuggests() {
                return this.d;
            }
        };
        GeoSearchFragmentComponent.Builder bindChannelId = DaggerGeoSearchFragmentComponent.builder().bindFragment(this).bindChannelId(access$getChannelId$p(this));
        String string2 = getResources().getString(R.string.messenger_geo_search_error_indicator_message);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…_error_indicator_message)");
        GeoSearchFragmentComponent.Builder bindErrorIndicatorMessage = bindChannelId.bindErrorIndicatorMessage(string2);
        String string3 = getResources().getString(R.string.messenger_geo_search_error_indicator_action_name);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…or_indicator_action_name)");
        bindErrorIndicatorMessage.bindErrorIndicatorActionName(string3).bindCenterPoint(this.g).bindItemLocation(this.h).bindDefaultState(access$getDefaultState$p(this)).dependencies((GeoSearchFragmentDependencies) ComponentDependenciesKt.getDependencies(GeoSearchFragmentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).module(GeoSearchFragmentModule.INSTANCE).build().inject(this);
        View findViewById = view.findViewById(R.id.messenger_geo_search_toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        setSupportActionBar((Toolbar) findViewById);
        ActionBarUtils.INSTANCE.setActionBarTitle(FragmentsKt.getSupportActionBar(this), "");
        FragmentsKt.getSupportActionBar(this).setHomeAsUpIndicator(com.avito.android.ui_components.R.drawable.ic_back_24);
        boolean z = false;
        FragmentsKt.getSupportActionBar(this).setDisplayShowTitleEnabled(false);
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        this.c = new GeoSearchViewImpl(view, adapterPresenter2, itemBinder2);
        if (bundle == null) {
            z = true;
        }
        this.i = z;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull GeoSearchPresenter geoSearchPresenter) {
        Intrinsics.checkNotNullParameter(geoSearchPresenter, "<set-?>");
        this.presenter = geoSearchPresenter;
    }
}
