package com.avito.android;

import com.avito.android.categories.remote.CategoriesApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Category;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000e\u001a\u0004\u0018\u00010\u0004*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/CategoriesInteractorImpl;", "Lcom/avito/android/CategoriesInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/Category;", "getCategories", "()Lio/reactivex/rxjava3/core/Observable;", "", "categoryId", "getCategoryById", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "getCategoryByIdImmediately", "(Ljava/lang/String;)Lcom/avito/android/remote/model/Category;", "id", AuthSource.SEND_ABUSE, "(Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/remote/model/Category;", "Lcom/avito/android/categories/remote/CategoriesApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/categories/remote/CategoriesApi;", "categoriesApi", "Ljava/util/List;", "categories", "<init>", "(Lcom/avito/android/categories/remote/CategoriesApi;)V", "categories_release"}, k = 1, mv = {1, 4, 2})
public final class CategoriesInteractorImpl implements CategoriesInteractor {
    public List<Category> a;
    public final CategoriesApi b;

    public static final class a<T> implements Consumer<List<? extends Category>> {
        public final /* synthetic */ CategoriesInteractorImpl a;

        public a(CategoriesInteractorImpl categoriesInteractorImpl) {
            this.a = categoriesInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends Category> list) {
            this.a.a = list;
        }
    }

    public static final class b<T, R> implements Function<List<? extends Category>, Category> {
        public final /* synthetic */ CategoriesInteractorImpl a;
        public final /* synthetic */ String b;

        public b(CategoriesInteractorImpl categoriesInteractorImpl, String str) {
            this.a = categoriesInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Category apply(List<? extends Category> list) {
            return this.a.a(list, this.b);
        }
    }

    @Inject
    public CategoriesInteractorImpl(@NotNull CategoriesApi categoriesApi) {
        Intrinsics.checkNotNullParameter(categoriesApi, "categoriesApi");
        this.b = categoriesApi;
    }

    public final Category a(List<Category> list, String str) {
        T t = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (Intrinsics.areEqual(next.getId(), str)) {
                t = next;
                break;
            }
        }
        return t;
    }

    @Override // com.avito.android.CategoriesInteractor
    @NotNull
    public Observable<List<Category>> getCategories() {
        List<Category> list = this.a;
        if (list != null) {
            Observable<List<Category>> just = Observable.just(list);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            if (just != null) {
                return just;
            }
        }
        Observable<List<Category>> doOnNext = this.b.getCategories().doOnNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "categoriesApi.getCategor…nNext { categories = it }");
        return doOnNext;
    }

    @Override // com.avito.android.CategoriesInteractor
    @NotNull
    public Observable<Category> getCategoryById(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "categoryId");
        Observable<R> map = getCategories().map(new b(this, str));
        Intrinsics.checkNotNullExpressionValue(map, "getCategories()\n        …it.findById(categoryId) }");
        return map;
    }

    @Override // com.avito.android.CategoriesInteractor
    @Nullable
    public Category getCategoryByIdImmediately(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "categoryId");
        return a(this.a, str);
    }
}
