package com.avito.android.select;

import a2.g.r.g;
import android.os.Bundle;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.select.SelectDialogPresenter;
import com.avito.android.select.SelectDialogRouter;
import com.avito.android.util.Bundles;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.n.y;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B`\b\u0007\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u00100\u001a\u00020-\u0012\b\u0010R\u001a\u0004\u0018\u00010\u0014\u0012\u001b\b\u0002\u0010Q\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030N¢\u0006\u0002\bO0G\u0012\u0006\u0010@\u001a\u00020=¢\u0006\u0004\bS\u0010TJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010#\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0 \u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010$R\"\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0 0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u00103R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\"\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0 0G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010'R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010JR\u0016\u0010M\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR)\u0010Q\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030N¢\u0006\u0002\bO0G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010'¨\u0006U"}, d2 = {"Lcom/avito/android/select/SelectDialogPresenterImpl;", "Lcom/avito/android/select/SelectDialogPresenter;", "", AuthSource.BOOKING_ORDER, "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/select/SelectDialogView;", "view", "attachView", "(Lcom/avito/android/select/SelectDialogView;)V", "detachView", "Lcom/avito/android/select/SelectDialogRouter;", "router", "attachRouter", "(Lcom/avito/android/select/SelectDialogRouter;)V", "detachRouter", "Lcom/avito/android/select/VariantItem;", "item", "onItemClicked", "(Lcom/avito/android/select/VariantItem;)V", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "Lio/reactivex/rxjava3/disposables/Disposable;", "h", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "", "c", "Ljava/lang/String;", "query", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "d", "Ljava/util/List;", "lastData", "Lcom/avito/android/select/SelectDialogRouter;", "", "e", "Ljava/util/Set;", "selectedItems", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "l", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/select/Arguments;", "o", "Lcom/avito/android/select/Arguments;", "arguments", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "j", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/select/SelectDialogInteractor;", "k", "Lcom/avito/android/select/SelectDialogInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/Features;", VKApiConst.Q, "Lcom/avito/android/Features;", "features", "i", "itemDisposables", "Lcom/avito/android/select/SelectDialogPresenter$ResourceProvider;", "n", "Lcom/avito/android/select/SelectDialogPresenter$ResourceProvider;", "resourceProvider", "", "f", "startSelectedItems", "Lcom/avito/android/select/SelectDialogView;", g.a, "Lcom/avito/android/select/VariantItem;", "clearVariant", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "p", "itemPresenters", "savedState", "<init>", "(Lcom/avito/android/select/SelectDialogInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/select/SelectDialogPresenter$ResourceProvider;Lcom/avito/android/select/Arguments;Landroid/os/Bundle;Ljava/util/Set;Lcom/avito/android/Features;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectDialogPresenterImpl implements SelectDialogPresenter {
    public SelectDialogView a;
    public SelectDialogRouter b;
    public String c;
    public List<? extends ParcelableEntity<String>> d;
    public final Set<ParcelableEntity<String>> e;
    public final Set<ParcelableEntity<String>> f;
    public final VariantItem g;
    public Disposable h;
    public final CompositeDisposable i;
    public final CompositeDisposable j;
    public final SelectDialogInteractor k;
    public final AdapterPresenter l;
    public final SchedulersFactory3 m;
    public final SelectDialogPresenter.ResourceProvider n;
    public final Arguments o;
    public final Set<ItemPresenter<?, ?>> p;
    public final Features q;

    public static final class a<T> implements Consumer<List<? extends ParcelableEntity<String>>> {
        public final /* synthetic */ SelectDialogPresenterImpl a;

        public a(SelectDialogPresenterImpl selectDialogPresenterImpl) {
            this.a = selectDialogPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends ParcelableEntity<String>> list) {
            this.a.d = list;
            SelectDialogPresenterImpl.access$showVariants(this.a);
        }
    }

    @Inject
    public SelectDialogPresenterImpl(@NotNull SelectDialogInteractor selectDialogInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SelectDialogPresenter.ResourceProvider resourceProvider, @NotNull Arguments arguments, @Nullable Bundle bundle, @NotNull Set<ItemPresenter<?, ?>> set, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(selectDialogInteractor, "interactor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(set, "itemPresenters");
        Intrinsics.checkNotNullParameter(features, "features");
        this.k = selectDialogInteractor;
        this.l = adapterPresenter;
        this.m = schedulersFactory3;
        this.n = resourceProvider;
        this.o = arguments;
        this.p = set;
        this.q = features;
        this.c = "";
        TreeSet treeSet = new TreeSet(SelectDialogPresenterKt.access$getCOMPARATOR$p());
        this.e = treeSet;
        this.f = CollectionsKt___CollectionsKt.toSet(arguments.getSelected());
        this.g = new VariantItem(SelectDialogPresenterKt.access$getCLEAR_VARIANT_ID$p(), resourceProvider.getClearItemTitle(), null, null, false, null, false, 108, null);
        this.i = new CompositeDisposable();
        this.j = new CompositeDisposable();
        if (bundle != null) {
            this.c = String.valueOf(bundle.getCharSequence("query"));
            List parcelableList = Bundles.getParcelableList(bundle, "selected_items_ids");
            treeSet.addAll(parcelableList == null ? CollectionsKt__CollectionsKt.emptyList() : parcelableList);
            return;
        }
        treeSet.addAll(arguments.getSelected());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f5, code lost:
        if ((r10 == null || r10.length() == 0) != false) goto L_0x00f7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00db  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$showVariants(com.avito.android.select.SelectDialogPresenterImpl r14) {
        /*
        // Method dump skipped, instructions count: 410
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.select.SelectDialogPresenterImpl.access$showVariants(com.avito.android.select.SelectDialogPresenterImpl):void");
    }

    public final void a() {
        Disposable disposable = this.h;
        if (disposable != null) {
            disposable.dispose();
        }
        this.h = this.k.filter(this.c).subscribeOn(this.m.io()).observeOn(this.m.mainThread()).subscribe(new a(this));
    }

    @Override // com.avito.android.select.SelectDialogPresenter
    public void attachRouter(@NotNull SelectDialogRouter selectDialogRouter) {
        Intrinsics.checkNotNullParameter(selectDialogRouter, "router");
        this.b = selectDialogRouter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r0 == false) goto L_0x003c;
     */
    @Override // com.avito.android.select.SelectDialogPresenter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attachView(@org.jetbrains.annotations.NotNull com.avito.android.select.SelectDialogView r8) {
        /*
        // Method dump skipped, instructions count: 439
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.select.SelectDialogPresenterImpl.attachView(com.avito.android.select.SelectDialogView):void");
    }

    public final void b() {
        SelectDialogView selectDialogView = this.a;
        boolean z = true;
        if (selectDialogView != null) {
            selectDialogView.setSubmitButtonEnabled(!Intrinsics.areEqual(this.e, this.f));
        }
        SelectDialogView selectDialogView2 = this.a;
        if (selectDialogView2 != null) {
            if (this.e.size() <= 0) {
                z = false;
            }
            selectDialogView2.setClearActionEnabled(z);
        }
    }

    @Override // com.avito.android.select.SelectDialogPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.select.SelectDialogPresenter
    public void detachView() {
        this.i.clear();
        this.j.clear();
        Disposable disposable = this.h;
        if (disposable != null) {
            disposable.dispose();
        }
        this.h = null;
        this.a = null;
    }

    @Override // com.avito.android.select.VariantItemPresenter.Listener
    public void onItemClicked(@NotNull VariantItem variantItem) {
        Intrinsics.checkNotNullParameter(variantItem, "item");
        SelectDialogView selectDialogView = this.a;
        if (selectDialogView != null) {
            selectDialogView.hideKeyboard();
        }
        String stringId = variantItem.getStringId();
        ParcelableEntity<String> parcelableEntity = null;
        if (Intrinsics.areEqual(stringId, SelectDialogPresenterKt.access$getCLEAR_VARIANT_ID$p())) {
            this.e.clear();
            SelectDialogRouter selectDialogRouter = this.b;
            if (selectDialogRouter != null) {
                SelectDialogRouter.DefaultImpls.onSelected$default(selectDialogRouter, CollectionsKt__CollectionsKt.emptyList(), null, 2, null);
                return;
            }
            return;
        }
        List<? extends ParcelableEntity<String>> list = this.d;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (Intrinsics.areEqual((String) next.getId(), stringId)) {
                    parcelableEntity = next;
                    break;
                }
            }
            parcelableEntity = parcelableEntity;
        }
        if (parcelableEntity == null) {
            return;
        }
        if (this.o.getMultiSelect()) {
            variantItem.setSelected(!variantItem.getSelected());
            if (this.e.contains(parcelableEntity)) {
                this.e.remove(parcelableEntity);
            } else {
                this.e.add(parcelableEntity);
            }
            b();
            return;
        }
        this.e.clear();
        this.e.add(parcelableEntity);
        SelectDialogRouter selectDialogRouter2 = this.b;
        if (selectDialogRouter2 != null) {
            selectDialogRouter2.onSelected(d.listOf(parcelableEntity), variantItem.getSectionTitle());
        }
    }

    @Override // com.avito.android.select.SelectDialogPresenter
    @NotNull
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("query", this.c);
        Bundles.putParcelableList(bundle, "selected_items_ids", CollectionsKt___CollectionsKt.toList(this.e));
        return bundle;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectDialogPresenterImpl(SelectDialogInteractor selectDialogInteractor, AdapterPresenter adapterPresenter, SchedulersFactory3 schedulersFactory3, SelectDialogPresenter.ResourceProvider resourceProvider, Arguments arguments, Bundle bundle, Set set, Features features, int i2, j jVar) {
        this(selectDialogInteractor, adapterPresenter, schedulersFactory3, resourceProvider, arguments, bundle, (i2 & 64) != 0 ? y.emptySet() : set, features);
    }
}
