package com.avito.android.abuse.category;

import a2.g.r.g;
import com.avito.android.abuse.category.AbuseCategoryPresenter;
import com.avito.android.abuse.category.item.AbuseCategoryItem;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.abuse.AbuseCategoriesResult;
import com.avito.android.remote.model.abuse.AbuseCategory;
import com.avito.android.util.Collections;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BC\b\u0007\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010:\u001a\u000207\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0010J\u001d\u0010\u001a\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006>"}, d2 = {"Lcom/avito/android/abuse/category/AbuseCategoryPresenterImpl;", "Lcom/avito/android/abuse/category/AbuseCategoryPresenter;", "Lcom/avito/android/abuse/category/AbuseCategoryView;", "view", "", "attachView", "(Lcom/avito/android/abuse/category/AbuseCategoryView;)V", "Lcom/avito/android/abuse/category/AbuseCategoryPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/abuse/category/AbuseCategoryPresenter$Router;)V", "", VKApiConst.POSITION, "onItemClick", "(I)V", "detachView", "()V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onBackPressed", AuthSource.BOOKING_ORDER, "", "Lcom/avito/android/remote/model/abuse/AbuseCategory;", "categories", AuthSource.SEND_ABUSE, "(Ljava/util/List;)V", "Lcom/avito/android/abuse/category/AbuseCategoryView;", "Lcom/avito/android/util/ErrorFormatter;", "i", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Ldagger/Lazy;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", g.a, "Ldagger/Lazy;", "adapterPresenter", "Lcom/avito/android/abuse/category/CategoriesList;", "d", "Lcom/avito/android/abuse/category/CategoriesList;", "currentList", "", "e", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/abuse/category/AbuseCategoryPresenter$Router;", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/abuse/category/AbuseCategoryInteractor;", "f", "Lcom/avito/android/abuse/category/AbuseCategoryInteractor;", "interactor", "state", "<init>", "(Ljava/lang/String;Lcom/avito/android/abuse/category/AbuseCategoryInteractor;Ldagger/Lazy;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/ErrorFormatter;Lcom/avito/android/util/Kundle;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AbuseCategoryPresenterImpl implements AbuseCategoryPresenter {
    public AbuseCategoryView a;
    public AbuseCategoryPresenter.Router b;
    public final CompositeDisposable c;
    public CategoriesList d;
    public final String e;
    public final AbuseCategoryInteractor f;
    public final Lazy<AdapterPresenter> g;
    public final SchedulersFactory3 h;
    public final ErrorFormatter i;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((AbuseCategoryPresenterImpl) this.b).onBackPressed();
            } else if (i == 1) {
                ((AbuseCategoryPresenterImpl) this.b).b();
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Disposable> {
        public final /* synthetic */ AbuseCategoryPresenterImpl a;

        public b(AbuseCategoryPresenterImpl abuseCategoryPresenterImpl) {
            this.a = abuseCategoryPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            AbuseCategoryView abuseCategoryView = this.a.a;
            if (abuseCategoryView != null) {
                abuseCategoryView.showLoading();
            }
        }
    }

    public static final class c<T> implements Consumer<AbuseCategoriesResult> {
        public final /* synthetic */ AbuseCategoryPresenterImpl a;

        public c(AbuseCategoryPresenterImpl abuseCategoryPresenterImpl) {
            this.a = abuseCategoryPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AbuseCategoriesResult abuseCategoriesResult) {
            List<AbuseCategory> categories = abuseCategoriesResult.getCategories();
            this.a.d = new CategoriesList(null, categories);
            this.a.a(categories);
            AbuseCategoryView abuseCategoryView = this.a.a;
            if (abuseCategoryView != null) {
                abuseCategoryView.showContent();
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ AbuseCategoryPresenterImpl a;

        public d(AbuseCategoryPresenterImpl abuseCategoryPresenterImpl) {
            this.a = abuseCategoryPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.util.ErrorFormatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            AbuseCategoryView abuseCategoryView = this.a.a;
            if (abuseCategoryView != null) {
                abuseCategoryView.showError(this.a.i.format(th2));
            }
        }
    }

    @Inject
    public AbuseCategoryPresenterImpl(@NotNull String str, @NotNull AbuseCategoryInteractor abuseCategoryInteractor, @NotNull Lazy<AdapterPresenter> lazy, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorFormatter errorFormatter, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(abuseCategoryInteractor, "interactor");
        Intrinsics.checkNotNullParameter(lazy, "adapterPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        this.e = str;
        this.f = abuseCategoryInteractor;
        this.g = lazy;
        this.h = schedulersFactory3;
        this.i = errorFormatter;
        this.c = new CompositeDisposable();
        this.d = kundle != null ? (CategoriesList) kundle.getParcelable("categories_stack") : null;
    }

    public final void a(List<AbuseCategory> list) {
        boolean z;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            arrayList.add(new AbuseCategoryItem(String.valueOf(next.getId()), next.getTitle(), !Collections.isNullOrEmpty(next.getSubcategories())));
        }
        this.g.get().onDataSourceChanged(new ListDataSource(arrayList));
        CategoriesList categoriesList = this.d;
        if ((categoriesList != null ? categoriesList.getParent() : null) == null) {
            z = false;
        }
        AbuseCategoryView abuseCategoryView = this.a;
        if (abuseCategoryView != null) {
            abuseCategoryView.notifyDataChanged();
            if (z) {
                abuseCategoryView.showBackIcon();
            } else {
                abuseCategoryView.showCloseIcon();
            }
        }
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryPresenter
    public void attachRouter(@NotNull AbuseCategoryPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryPresenter
    public void attachView(@NotNull AbuseCategoryView abuseCategoryView) {
        Intrinsics.checkNotNullParameter(abuseCategoryView, "view");
        this.a = abuseCategoryView;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = abuseCategoryView.backClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.backClicks().subscr…onBackPressed()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = abuseCategoryView.retryClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.retryClicks().subsc…oadCategories()\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CategoriesList categoriesList = this.d;
        List<AbuseCategory> categories = categoriesList != null ? categoriesList.getCategories() : null;
        if (categories != null) {
            a(categories);
        } else {
            b();
        }
    }

    public final void b() {
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.f.getAbuseCategories(this.e).observeOn(this.h.mainThread()).doOnSubscribe(new b(this)).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getAbuseCateg…ormat(it))\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryPresenter
    public void detachView() {
        this.c.clear();
        this.a = null;
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryPresenter
    public void onBackPressed() {
        CategoriesList categoriesList = this.d;
        CategoriesList parent = categoriesList != null ? categoriesList.getParent() : null;
        if (parent != null) {
            this.d = parent;
            a(parent.getCategories());
            return;
        }
        AbuseCategoryPresenter.Router router = this.b;
        if (router != null) {
            router.leaveScreen();
        }
    }

    @Override // com.avito.android.abuse.category.item.AbuseCategoryItemClickListener
    public void onItemClick(int i2) {
        List<AbuseCategory> categories;
        CategoriesList categoriesList = this.d;
        if (categoriesList != null && (categories = categoriesList.getCategories()) != null && categories.size() > i2) {
            AbuseCategory abuseCategory = categories.get(i2);
            List<AbuseCategory> subcategories = abuseCategory.getSubcategories();
            if (subcategories == null || !(!subcategories.isEmpty())) {
                AbuseCategoryPresenter.Router router = this.b;
                if (router != null) {
                    router.showAbuseDetailsScreen(abuseCategory.getId());
                    return;
                }
                return;
            }
            this.d = new CategoriesList(this.d, subcategories);
            a(subcategories);
        }
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("categories_stack", this.d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AbuseCategoryPresenterImpl(String str, AbuseCategoryInteractor abuseCategoryInteractor, Lazy lazy, SchedulersFactory3 schedulersFactory3, ErrorFormatter errorFormatter, Kundle kundle, int i2, j jVar) {
        this(str, abuseCategoryInteractor, lazy, schedulersFactory3, errorFormatter, (i2 & 32) != 0 ? null : kundle);
    }
}
