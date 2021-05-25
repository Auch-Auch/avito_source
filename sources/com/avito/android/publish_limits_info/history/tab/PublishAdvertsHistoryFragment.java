package com.avito.android.publish_limits_info.history.tab;

import a2.a.a.f2.a.b.a;
import a2.a.a.f2.a.b.b;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.publish_limits_info.R;
import com.avito.android.publish_limits_info.history.tab.di.DaggerPublishAdvertsHistoryComponent;
import com.avito.android.publish_limits_info.history.tab.di.PublishAdvertsHistoryDependencies;
import com.avito.android.publish_limits_info.history.tab.info.InfoItemPresenter;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.FragmentsKt;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\bB\u0010CJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R5\u0010<\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030:¢\u0006\u0002\b;098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/publish_limits_info/history/tab/ExtraInfoClickListener;", "extraInfoClickedListener", "Lcom/avito/android/publish_limits_info/history/tab/ExtraInfoClickListener;", "getExtraInfoClickedListener", "()Lcom/avito/android/publish_limits_info/history/tab/ExtraInfoClickListener;", "setExtraInfoClickedListener", "(Lcom/avito/android/publish_limits_info/history/tab/ExtraInfoClickListener;)V", "Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryProvider;", "advertsProvider", "Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryProvider;", "getAdvertsProvider", "()Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryProvider;", "setAdvertsProvider", "(Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryProvider;)V", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Ljava/util/Set;", "getItemPresenterSet", "()Ljava/util/Set;", "setItemPresenterSet", "(Ljava/util/Set;)V", "<init>", "()V", "Companion", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class PublishAdvertsHistoryFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public SimpleRecyclerAdapter adapter;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public PublishAdvertsHistoryProvider advertsProvider;
    public RecyclerView c;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ExtraInfoClickListener extraInfoClickedListener;
    @Inject
    public Set<ItemPresenter<?, ?>> itemPresenterSet;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryFragment$Companion;", "", "", "shortcut", "Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryFragment;", "create", "(Ljava/lang/String;)Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryFragment;", "<init>", "()V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.a = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putString("shortcut", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final PublishAdvertsHistoryFragment create(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "shortcut");
            return (PublishAdvertsHistoryFragment) FragmentsKt.arguments$default(new PublishAdvertsHistoryFragment(), 0, new a(str), 1, null);
        }

        public Companion(j jVar) {
        }
    }

    public static final void access$openDeeplink(PublishAdvertsHistoryFragment publishAdvertsHistoryFragment, DeepLink deepLink) {
        DeepLinkIntentFactory deepLinkIntentFactory2 = publishAdvertsHistoryFragment.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            publishAdvertsHistoryFragment.startActivity(intent);
        }
    }

    @NotNull
    public final SimpleRecyclerAdapter getAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return simpleRecyclerAdapter;
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
    public final PublishAdvertsHistoryProvider getAdvertsProvider() {
        PublishAdvertsHistoryProvider publishAdvertsHistoryProvider = this.advertsProvider;
        if (publishAdvertsHistoryProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertsProvider");
        }
        return publishAdvertsHistoryProvider;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final ExtraInfoClickListener getExtraInfoClickedListener() {
        ExtraInfoClickListener extraInfoClickListener = this.extraInfoClickedListener;
        if (extraInfoClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extraInfoClickedListener");
        }
        return extraInfoClickListener;
    }

    @NotNull
    public final Set<ItemPresenter<?, ?>> getItemPresenterSet() {
        Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
        }
        return set;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.publish_adverts_history_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.c = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycler");
        }
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(simpleRecyclerAdapter);
        String string = requireArguments().getString("shortcut");
        if (string != null) {
            AdapterPresenter adapterPresenter2 = this.adapterPresenter;
            if (adapterPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
            }
            PublishAdvertsHistoryProvider publishAdvertsHistoryProvider = this.advertsProvider;
            if (publishAdvertsHistoryProvider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertsProvider");
            }
            adapterPresenter2.onDataSourceChanged(new ListDataSource(publishAdvertsHistoryProvider.getAdvertsShortcut(string)));
            RecyclerView recyclerView2 = this.c;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycler");
            }
            RecyclerView.Adapter adapter2 = recyclerView2.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyDataSetChanged();
            }
            Set<ItemPresenter<?, ?>> set = this.itemPresenterSet;
            if (set == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemPresenterSet");
            }
            for (T t : set) {
                if (t instanceof InfoItemPresenter) {
                    t.getDeeplinkClicks().throttleFirst(100, TimeUnit.MILLISECONDS).subscribe(new a(this, string), b.a);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void setAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.adapter = simpleRecyclerAdapter;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAdvertsProvider(@NotNull PublishAdvertsHistoryProvider publishAdvertsHistoryProvider) {
        Intrinsics.checkNotNullParameter(publishAdvertsHistoryProvider, "<set-?>");
        this.advertsProvider = publishAdvertsHistoryProvider;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setExtraInfoClickedListener(@NotNull ExtraInfoClickListener extraInfoClickListener) {
        Intrinsics.checkNotNullParameter(extraInfoClickListener, "<set-?>");
        this.extraInfoClickedListener = extraInfoClickListener;
    }

    public final void setItemPresenterSet(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.itemPresenterSet = set;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        DaggerPublishAdvertsHistoryComponent.factory().create((PublishAdvertsHistoryDependencies) FragmentsKt.activityComponent(this)).inject(this);
        return true;
    }
}
