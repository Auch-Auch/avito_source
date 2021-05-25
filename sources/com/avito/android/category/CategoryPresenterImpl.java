package com.avito.android.category;

import a2.a.a.c0.d;
import a2.g.r.g;
import android.content.res.Resources;
import androidx.annotation.AttrRes;
import com.avito.android.category.CategoryPresenter;
import com.avito.android.category.Element;
import com.avito.android.category.analytics.CategoryAnalyticsInteractor;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CategorySearch;
import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.MainSearchResult;
import com.avito.android.remote.model.ShopSearch;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010K\u001a\u00020H\u0012\b\u0010P\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bQ\u0010RJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001d\u0010\u0018J\u000f\u0010\u001e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001e\u0010\u0018J\u000f\u0010\u001f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001f\u0010\u0018J#\u0010$\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\rH\u0002¢\u0006\u0004\b&\u0010\u0018R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010(R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R(\u00104\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0006\u0012\u0004\u0018\u00010\"\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020>0=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010(R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u00028\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\bL\u0010+R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010NR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010O¨\u0006S"}, d2 = {"Lcom/avito/android/category/CategoryPresenterImpl;", "Lcom/avito/android/category/CategoryPresenter;", "", "getCount", "()I", VKApiConst.POSITION, "", "getItemId", "(I)J", "getItemViewType", "(I)I", "Lcom/avito/android/category/BaseViewHolder;", "holder", "", "bindView", "(Lcom/avito/android/category/BaseViewHolder;I)V", "Lcom/avito/android/category/CategoryPresenterState;", "getState", "()Lcom/avito/android/category/CategoryPresenterState;", "Lcom/avito/android/category/CategoryView;", "view", "attachView", "(Lcom/avito/android/category/CategoryView;)V", "detachView", "()V", "Lcom/avito/android/category/CategoryPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/category/CategoryPresenter$Router;)V", "detachRouter", "onRetryClick", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Location;", "location", "", "categoryId", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/Location;Ljava/lang/String;)V", "c", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "categoryDisposable", g.a, "I", "blueTextColorAttr", "Lcom/avito/android/category/CategoryInteractor;", "k", "Lcom/avito/android/category/CategoryInteractor;", "interactor", "Lkotlin/Pair;", "f", "Lkotlin/Pair;", "cachedRequestData", "Lcom/avito/android/category/analytics/CategoryAnalyticsInteractor;", "l", "Lcom/avito/android/category/analytics/CategoryAnalyticsInteractor;", "categoryAnalyticsInteractor", "Lcom/avito/android/category/CategoryArguments;", "i", "Lcom/avito/android/category/CategoryArguments;", "arguments", "", "Lcom/avito/android/category/ListElement;", "e", "Ljava/util/List;", MessengerShareContentUtility.ELEMENTS, "d", "deeplinkDisposable", "Landroid/content/res/Resources;", "j", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "h", "regularTextColorAttr", "Lcom/avito/android/category/CategoryView;", "Lcom/avito/android/category/CategoryPresenter$Router;", "categoryPresenterState", "<init>", "(Lcom/avito/android/category/CategoryArguments;Landroid/content/res/Resources;Lcom/avito/android/category/CategoryInteractor;Lcom/avito/android/category/analytics/CategoryAnalyticsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/category/CategoryPresenterState;)V", "category_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryPresenterImpl implements CategoryPresenter {
    public CategoryView a;
    public CategoryPresenter.Router b;
    public Disposable c;
    public Disposable d;
    public List<ListElement> e;
    public Pair<Location, String> f;
    @AttrRes
    public final int g;
    @AttrRes
    public final int h;
    public final CategoryArguments i;
    public final Resources j;
    public final CategoryInteractor k;
    public final CategoryAnalyticsInteractor l;
    public final SchedulersFactory3 m;

    public static final class a<T> implements Consumer<TypedResult<DeepLinkResponse>> {
        public final /* synthetic */ CategoryPresenterImpl a;

        public a(CategoryPresenterImpl categoryPresenterImpl) {
            this.a = categoryPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<DeepLinkResponse> typedResult) {
            CategoryView categoryView;
            TypedResult<DeepLinkResponse> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                this.a.f = null;
                CategoryPresenter.Router router = this.a.b;
                if (router != null) {
                    router.followDeepLink(((DeepLinkResponse) ((TypedResult.OfResult) typedResult2).getResult()).getDeepLink(), this.a.l.getParent());
                }
            } else if ((typedResult2 instanceof TypedResult.OfError) && (categoryView = this.a.a) != null) {
                categoryView.showRetry();
            }
        }
    }

    public static final class b<T> implements Consumer<MainSearchResult> {
        public final /* synthetic */ CategoryPresenterImpl a;

        public b(CategoryPresenterImpl categoryPresenterImpl) {
            this.a = categoryPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(MainSearchResult mainSearchResult) {
            MainSearchResult mainSearchResult2 = mainSearchResult;
            CategoryPresenterImpl.access$setupPresenter(this.a, mainSearchResult2.getCategories(), mainSearchResult2.getShop());
            CategoryView categoryView = this.a.a;
            if (categoryView != null) {
                categoryView.showContent();
            }
            if (this.a.i.isFirstStart$category_release()) {
                this.a.l.sendCategoryOpened();
                this.a.i.setFirstStart$category_release(false);
            }
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ CategoryPresenterImpl a;

        public c(CategoryPresenterImpl categoryPresenterImpl) {
            this.a = categoryPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            CategoryView categoryView = this.a.a;
            if (categoryView != null) {
                categoryView.showRetry();
            }
        }
    }

    @Inject
    public CategoryPresenterImpl(@NotNull CategoryArguments categoryArguments, @NotNull Resources resources, @NotNull CategoryInteractor categoryInteractor, @NotNull CategoryAnalyticsInteractor categoryAnalyticsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @Nullable CategoryPresenterState categoryPresenterState) {
        List<ListElement> arrayList;
        List<ListElement> elements;
        Intrinsics.checkNotNullParameter(categoryArguments, "arguments");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(categoryInteractor, "interactor");
        Intrinsics.checkNotNullParameter(categoryAnalyticsInteractor, "categoryAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.i = categoryArguments;
        this.j = resources;
        this.k = categoryInteractor;
        this.l = categoryAnalyticsInteractor;
        this.m = schedulersFactory3;
        this.e = (categoryPresenterState == null || (elements = categoryPresenterState.getElements()) == null || (arrayList = CollectionsKt___CollectionsKt.toMutableList(elements)) == null) ? new ArrayList<>() : arrayList;
        this.f = categoryPresenterState != null ? categoryPresenterState.cachedRequest() : null;
        this.g = R.attr.blue;
        this.h = R.attr.black;
    }

    public static final void access$addChildren(CategoryPresenterImpl categoryPresenterImpl, Element.Category category) {
        int indexOf;
        Objects.requireNonNull(categoryPresenterImpl);
        if (!category.getChildren().isEmpty() && (indexOf = categoryPresenterImpl.e.indexOf(category)) != -1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Element.Subcategory(category.getId(), category.getName(), category.getId(), false, true, 8, null));
            for (CategorySearch categorySearch : category.getChildren()) {
                arrayList.add(new Element.Subcategory(categorySearch.getId(), categorySearch.getName(), category.getId(), false, false, 24, null));
            }
            ((Element.Subcategory) CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList)).setLastChild(true);
            int i2 = indexOf + 1;
            categoryPresenterImpl.e.addAll(i2, arrayList);
            CategoryView categoryView = categoryPresenterImpl.a;
            if (categoryView != null) {
                categoryView.itemChanged(indexOf);
            }
            CategoryView categoryView2 = categoryPresenterImpl.a;
            if (categoryView2 != null) {
                categoryView2.itemRangeInserted(i2, arrayList.size());
            }
            categoryPresenterImpl.c();
        }
    }

    public static final Location access$getSavedLocationIfNull(CategoryPresenterImpl categoryPresenterImpl) {
        Location location = categoryPresenterImpl.i.getLocation();
        return location != null ? location : categoryPresenterImpl.k.getLocation();
    }

    public static final void access$removeChildren(CategoryPresenterImpl categoryPresenterImpl, Element.Category category) {
        ListIterator<ListElement> listIterator = categoryPresenterImpl.e.listIterator();
        int indexOf = categoryPresenterImpl.e.indexOf(category);
        int i2 = 0;
        while (listIterator.hasNext()) {
            ListElement next = listIterator.next();
            if ((next instanceof Element.Subcategory) && Intrinsics.areEqual(((Element.Subcategory) next).getParentId(), category.getId())) {
                listIterator.remove();
                i2++;
            }
        }
        CategoryView categoryView = categoryPresenterImpl.a;
        if (categoryView != null) {
            categoryView.itemRangeRemoved(indexOf + 1, i2);
        }
        CategoryView categoryView2 = categoryPresenterImpl.a;
        if (categoryView2 != null) {
            categoryView2.itemChanged(indexOf);
        }
        CategoryView categoryView3 = categoryPresenterImpl.a;
        if (categoryView3 != null) {
            categoryView3.itemChanged(indexOf + i2 + 1);
        }
        categoryPresenterImpl.c();
    }

    public static final void access$sendCategoryClick(CategoryPresenterImpl categoryPresenterImpl, String str, String str2) {
        categoryPresenterImpl.l.sendCategoryClick(str, str2);
    }

    public static final void access$sendShopClick(CategoryPresenterImpl categoryPresenterImpl) {
        categoryPresenterImpl.l.sendShopClick();
    }

    public static final void access$setupPresenter(CategoryPresenterImpl categoryPresenterImpl, List list, ShopSearch shopSearch) {
        Objects.requireNonNull(categoryPresenterImpl);
        if (list != null) {
            List<ListElement> list2 = categoryPresenterImpl.e;
            list2.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CategorySearch categorySearch = (CategorySearch) it.next();
                List<CategorySearch> children = categorySearch.getChildren();
                String parentId = categorySearch.getParentId();
                if (children == null && parentId == null) {
                    list2.add(new Element.Header(categorySearch.getName(), categorySearch.getId()));
                } else if (children != null) {
                    list2.add(new Element.Category(categorySearch.getId(), categorySearch.getName(), children, false, Intrinsics.areEqual((CategorySearch) CollectionsKt___CollectionsKt.last((List<? extends Object>) list), categorySearch)));
                } else if (parentId != null) {
                    list2.add(new Element.Subcategory(categorySearch.getId(), categorySearch.getName(), parentId, false, false, 24, null));
                }
            }
            if (shopSearch != null) {
                list2.add(new Element.Shops(shopSearch.getTitle(), shopSearch.getDeepLink(), shopSearch.getDescription()));
            }
            CategoryView categoryView = categoryPresenterImpl.a;
            if (categoryView != null) {
                categoryView.dataChanged();
            }
            categoryPresenterImpl.c();
        }
    }

    public final void a(Location location, String str) {
        if (location != null) {
            CategoryView categoryView = this.a;
            if (categoryView != null) {
                categoryView.showProgress();
            }
            this.f = new Pair<>(location, str);
            this.d = this.k.loadSerpDeeplink(location, str).subscribeOn(this.m.io()).observeOn(this.m.mainThread()).subscribe(new a(this));
        }
    }

    @Override // com.avito.android.category.CategoryPresenter
    public void attachRouter(@NotNull CategoryPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.category.CategoryPresenter
    public void attachView(@NotNull CategoryView categoryView) {
        Intrinsics.checkNotNullParameter(categoryView, "view");
        this.a = categoryView;
        if (this.e.isEmpty()) {
            b();
            return;
        }
        Pair<Location, String> pair = this.f;
        if (pair != null) {
            a(pair.component1(), pair.component2());
            return;
        }
        CategoryView categoryView2 = this.a;
        if (categoryView2 != null) {
            categoryView2.showContent();
        }
        c();
    }

    public final void b() {
        CategoryView categoryView = this.a;
        if (categoryView != null) {
            categoryView.showProgress();
        }
        this.c = this.k.loadMainSearch(this.i.getLocation()).subscribeOn(this.m.io()).observeOn(this.m.mainThread()).subscribe(new b(this), new c(this));
    }

    @Override // com.avito.android.category.CategoryItemPresenter
    public void bindView(@NotNull BaseViewHolder baseViewHolder, int i2) {
        Element.Subcategory subcategory;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Element.Shops shops = null;
        Element.Header header = null;
        Element.Category category = null;
        T t = null;
        if (baseViewHolder instanceof HeaderViewHolder) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) baseViewHolder;
            if (this.e.get(i2) instanceof Element.Header) {
                Object obj = this.e.get(i2);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.category.Element.Header");
                header = (Element.Header) obj;
            }
            if (header != null) {
                headerViewHolder.setText(header.getName());
                headerViewHolder.setHeaderClickListener(new a2.a.a.c0.b(this, header));
            }
        } else if (baseViewHolder instanceof CategoryViewHolder) {
            CategoryViewHolder categoryViewHolder = (CategoryViewHolder) baseViewHolder;
            if (this.e.get(i2) instanceof Element.Category) {
                Object obj2 = this.e.get(i2);
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type com.avito.android.category.Element.Category");
                category = (Element.Category) obj2;
            }
            if (category != null) {
                if (category.isChildrenVisible()) {
                    categoryViewHolder.setTextColor(this.g);
                    categoryViewHolder.setArrowCollapsed(false);
                } else {
                    categoryViewHolder.setTextColor(this.h);
                    categoryViewHolder.setArrowCollapsed(true);
                }
                if (i2 > 0) {
                    int i3 = i2 - 1;
                    if ((this.e.get(i3) instanceof Element.Category) || (this.e.get(i3) instanceof Element.Header)) {
                        z2 = true;
                        if (z2 || !category.isChildrenVisible()) {
                            categoryViewHolder.setDividerVisibility(false);
                        } else {
                            categoryViewHolder.setDividerVisibility(true);
                        }
                        categoryViewHolder.setText(category.getName());
                        categoryViewHolder.setArrowVisibility(!category.getChildren().isEmpty());
                        categoryViewHolder.setCategoryClickListener(new a2.a.a.c0.a(this, category, i2));
                    }
                }
                z2 = false;
                if (z2) {
                }
                categoryViewHolder.setDividerVisibility(false);
                categoryViewHolder.setText(category.getName());
                categoryViewHolder.setArrowVisibility(!category.getChildren().isEmpty());
                categoryViewHolder.setCategoryClickListener(new a2.a.a.c0.a(this, category, i2));
            }
        } else if (baseViewHolder instanceof SubcategoryViewHolder) {
            SubcategoryViewHolder subcategoryViewHolder = (SubcategoryViewHolder) baseViewHolder;
            if (this.e.get(i2) instanceof Element.Subcategory) {
                Object obj3 = this.e.get(i2);
                Objects.requireNonNull(obj3, "null cannot be cast to non-null type com.avito.android.category.Element.Subcategory");
                subcategory = (Element.Subcategory) obj3;
            } else {
                subcategory = null;
            }
            if (subcategory != null) {
                String parentId = subcategory.getParentId();
                Iterator<T> it = this.e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    T t2 = next;
                    if (!(t2 instanceof Element.Category) || !Intrinsics.areEqual(t2.getId(), parentId)) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        t = next;
                        break;
                    }
                }
                T t3 = t;
                subcategoryViewHolder.setTextColor(this.h);
                if (subcategory.isFictive()) {
                    subcategoryViewHolder.setText(this.j.getString(R.string.all_subcategories));
                } else {
                    subcategoryViewHolder.setText(subcategory.getName());
                }
                subcategoryViewHolder.setSubcategoryClickListener(new d(this, subcategory, t3));
                if (subcategory.isLastChild()) {
                    if (!(t3 != null ? t3.isLastCategory() : false)) {
                        subcategoryViewHolder.setDividerVisibility(true);
                        return;
                    }
                }
                subcategoryViewHolder.setDividerVisibility(false);
            }
        } else if (baseViewHolder instanceof ShopsViewHolder) {
            ShopsViewHolder shopsViewHolder = (ShopsViewHolder) baseViewHolder;
            if (this.e.get(i2) instanceof Element.Shops) {
                Object obj4 = this.e.get(i2);
                Objects.requireNonNull(obj4, "null cannot be cast to non-null type com.avito.android.category.Element.Shops");
                shops = (Element.Shops) obj4;
            }
            if (shops != null) {
                shopsViewHolder.setTitle(shops.getName());
                shopsViewHolder.setSubtitle(shops.getDescription());
                shopsViewHolder.setOnClickListener(new a2.a.a.c0.c(this, shops));
            }
        }
    }

    public final void c() {
        boolean z = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.e) instanceof Element.Shops;
        CategoryView categoryView = this.a;
        if (categoryView != null) {
            categoryView.showBackgroundForRange(new IntRange(0, this.e.size() - (z ? 2 : 1)));
        }
    }

    @Override // com.avito.android.category.CategoryPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.category.CategoryPresenter
    public void detachView() {
        this.a = null;
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.d;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }

    @Override // com.avito.android.category.CategoryItemPresenter
    public int getCount() {
        return this.e.size();
    }

    @Override // com.avito.android.category.CategoryItemPresenter
    public long getItemId(int i2) {
        return (long) this.e.get(i2).hashCode();
    }

    @Override // com.avito.android.category.CategoryItemPresenter
    public int getItemViewType(int i2) {
        ListElement listElement = this.e.get(i2);
        if (listElement instanceof Element.Header) {
            return 0;
        }
        if (listElement instanceof Element.Category) {
            return 1;
        }
        if (listElement instanceof Element.Subcategory) {
            return 2;
        }
        return listElement instanceof Element.Shops ? 3 : -1;
    }

    @Override // com.avito.android.category.CategoryPresenter
    @NotNull
    public CategoryPresenterState getState() {
        List<ListElement> list = this.e;
        Pair<Location, String> pair = this.f;
        String str = null;
        Location first = pair != null ? pair.getFirst() : null;
        Pair<Location, String> pair2 = this.f;
        if (pair2 != null) {
            str = pair2.getSecond();
        }
        return new CategoryPresenterState(list, first, str);
    }

    @Override // com.avito.android.category.CategoryPresenter
    public void onRetryClick() {
        Pair<Location, String> pair = this.f;
        if (pair != null) {
            a(pair.component1(), pair.component2());
        } else {
            b();
        }
    }
}
