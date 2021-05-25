package com.avito.android.publish.premoderation;

import com.avito.android.publish.premoderation.SelectListWidget;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CategoryModel;
import com.avito.android.remote.model.adverts.AdvertProactiveModerationResult;
import com.avito.android.util.Kundle;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u0012\u0012\b\u0010'\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b(\u0010)J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u0014*\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/publish/premoderation/WrongCategoryPresenterImpl;", "Lcom/avito/android/publish/premoderation/WrongCategoryPresenter;", "Lcom/avito/android/publish/premoderation/WrongCategoryView;", "view", "", "attachView", "(Lcom/avito/android/publish/premoderation/WrongCategoryView;)V", "detachView", "()V", "Lcom/avito/android/publish/premoderation/WrongCategoryRouter;", "router", "attachRouter", "(Lcom/avito/android/publish/premoderation/WrongCategoryRouter;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "saveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/remote/model/CategoryModel;", "", "customSubtitle", "Lcom/avito/android/publish/premoderation/SelectListWidget$Data;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/CategoryModel;Ljava/lang/String;)Lcom/avito/android/publish/premoderation/SelectListWidget$Data;", "Lcom/avito/android/publish/premoderation/WrongCategoryView;", "c", "Ljava/lang/String;", "selectedWizardId", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$WrongCategorySuggest;", "e", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$WrongCategorySuggest;", "wrongCategoryData", "f", "selectedCategorySubtitle", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/premoderation/WrongCategoryRouter;", "state", "<init>", "(Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$WrongCategorySuggest;Ljava/lang/String;Lcom/avito/android/util/Kundle;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class WrongCategoryPresenterImpl implements WrongCategoryPresenter {
    public WrongCategoryView a;
    public WrongCategoryRouter b;
    public String c;
    public final CompositeDisposable d;
    public final AdvertProactiveModerationResult.WrongCategorySuggest e;
    public final String f;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(String str) {
            int i = this.a;
            T t = null;
            if (i == 0) {
                String str2 = str;
                if (Intrinsics.areEqual(str2, ((WrongCategoryPresenterImpl) this.b).e.getSelectedCategory().getNavigation().toString())) {
                    WrongCategoryRouter wrongCategoryRouter = ((WrongCategoryPresenterImpl) this.b).b;
                    if (wrongCategoryRouter != null) {
                        wrongCategoryRouter.skipWrongCategory();
                        return;
                    }
                    return;
                }
                WrongCategoryRouter wrongCategoryRouter2 = ((WrongCategoryPresenterImpl) this.b).b;
                if (wrongCategoryRouter2 != null) {
                    Iterator<T> it = ((WrongCategoryPresenterImpl) this.b).e.getCategories().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        T next = it.next();
                        if (Intrinsics.areEqual(next.getNavigation().toString(), str2)) {
                            t = next;
                            break;
                        }
                    }
                    wrongCategoryRouter2.changeWrongCategory(t);
                }
            } else if (i == 1) {
                ((WrongCategoryPresenterImpl) this.b).c = str;
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ WrongCategoryPresenterImpl a;

        public b(WrongCategoryPresenterImpl wrongCategoryPresenterImpl) {
            this.a = wrongCategoryPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            WrongCategoryRouter wrongCategoryRouter = this.a.b;
            if (wrongCategoryRouter != null) {
                wrongCategoryRouter.closeWrongCategory();
            }
        }
    }

    public static final class c<T> implements Consumer<String> {
        public final /* synthetic */ WrongCategoryPresenterImpl a;

        public c(WrongCategoryPresenterImpl wrongCategoryPresenterImpl) {
            this.a = wrongCategoryPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            WrongCategoryView wrongCategoryView = this.a.a;
            if (wrongCategoryView != null) {
                wrongCategoryView.continueButtonAvailability(true);
            }
        }
    }

    public WrongCategoryPresenterImpl(@NotNull AdvertProactiveModerationResult.WrongCategorySuggest wrongCategorySuggest, @NotNull String str, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(wrongCategorySuggest, "wrongCategoryData");
        Intrinsics.checkNotNullParameter(str, "selectedCategorySubtitle");
        this.e = wrongCategorySuggest;
        this.f = str;
        this.c = kundle != null ? kundle.getString("selected_wizard_id") : null;
        this.d = new CompositeDisposable();
    }

    public final SelectListWidget.Data a(CategoryModel categoryModel, String str) {
        String str2;
        String description = categoryModel.getDescription();
        if (description == null || description.length() == 0) {
            str2 = categoryModel.getTitle();
        } else {
            str2 = categoryModel.getTitle() + " · " + categoryModel.getDescription();
        }
        return new SelectListWidget.Data(str2, str, categoryModel.getNavigation().toString());
    }

    @Override // com.avito.android.publish.premoderation.WrongCategoryPresenter
    public void attachRouter(@NotNull WrongCategoryRouter wrongCategoryRouter) {
        Intrinsics.checkNotNullParameter(wrongCategoryRouter, "router");
        this.b = wrongCategoryRouter;
    }

    @Override // com.avito.android.publish.premoderation.WrongCategoryPresenter
    public void attachView(@NotNull WrongCategoryView wrongCategoryView) {
        SelectListWidget.Data data;
        SelectListWidget.Data data2;
        T t;
        Intrinsics.checkNotNullParameter(wrongCategoryView, "view");
        this.a = wrongCategoryView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = wrongCategoryView.backClicks().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.backClicks()\n      …gCategory()\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Observable<R> withLatestFrom = wrongCategoryView.continueButtonClicks().withLatestFrom(wrongCategoryView.categoryWizardIdSelection(), new BiFunction<Unit, String, R>() { // from class: com.avito.android.publish.premoderation.WrongCategoryPresenterImpl$attachView$$inlined$withLatestFrom$1
            @Override // io.reactivex.functions.BiFunction
            public final R apply(Unit unit, String str) {
                return (R) str;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        Disposable subscribe2 = withLatestFrom.subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.continueButtonClick…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = wrongCategoryView.categoryWizardIdSelection().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.categoryWizardIdSel…edWizardId = categoryId }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.d;
        Disposable subscribe4 = wrongCategoryView.categoryWizardIdSelection().firstOrError().subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.categoryWizardIdSel…bility(isEnable = true) }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        wrongCategoryView.continueButtonAvailability(false);
        AdvertProactiveModerationResult.WrongCategorySuggest wrongCategorySuggest = this.e;
        List<CategoryModel> categories = wrongCategorySuggest.getCategories();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(categories, 10));
        Iterator<T> it = categories.iterator();
        while (true) {
            data = null;
            if (!it.hasNext()) {
                break;
            }
            arrayList.add(a(it.next(), null));
        }
        List<SelectListWidget.Data> plus = CollectionsKt___CollectionsKt.plus((Collection<? extends SelectListWidget.Data>) arrayList, a(wrongCategorySuggest.getSelectedCategory(), this.f));
        if (Intrinsics.areEqual(wrongCategorySuggest.getSelectedCategory().getNavigation().toString(), this.c)) {
            data2 = a(wrongCategorySuggest.getSelectedCategory(), null);
        } else if (wrongCategorySuggest.getCategories().size() == 1) {
            data2 = a((CategoryModel) CollectionsKt___CollectionsKt.single((List<? extends Object>) wrongCategorySuggest.getCategories()), null);
        } else {
            Iterator<T> it2 = wrongCategorySuggest.getCategories().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t = null;
                    break;
                }
                t = it2.next();
                if (Intrinsics.areEqual(t.getNavigation().toString(), this.c)) {
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                data = a(t2, null);
            }
            data2 = data;
        }
        WrongCategoryView wrongCategoryView2 = this.a;
        if (wrongCategoryView2 != null) {
            wrongCategoryView2.fillCategoryList(plus, data2);
        }
    }

    @Override // com.avito.android.publish.premoderation.WrongCategoryPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.publish.premoderation.WrongCategoryPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.publish.premoderation.WrongCategoryPresenter
    @NotNull
    public Kundle saveState() {
        return new Kundle().putString("selected_wizard_id", this.c);
    }
}
