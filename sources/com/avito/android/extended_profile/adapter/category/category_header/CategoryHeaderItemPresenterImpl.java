package com.avito.android.extended_profile.adapter.category.category_header;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItemPresenterImpl;", "Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItemPresenter;", "Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItemView;", "view", "Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItemView;Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/extended_profile/adapter/action/ExtendedProfileItemAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clicksConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryHeaderItemPresenterImpl implements CategoryHeaderItemPresenter {
    public final Consumer<ExtendedProfileItemAction> a;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ CategoryHeaderItemPresenterImpl a;
        public final /* synthetic */ CategoryHeaderItem b;

        public a(CategoryHeaderItemPresenterImpl categoryHeaderItemPresenterImpl, CategoryHeaderItem categoryHeaderItem) {
            this.a = categoryHeaderItemPresenterImpl;
            this.b = categoryHeaderItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            if (this.b.isCollapsible() && !this.b.isLoading()) {
                this.a.a.accept(new CategoryHeaderAction(this.b.getCategory()));
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CategoryHeaderItemView a;
        public final /* synthetic */ Disposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CategoryHeaderItemView categoryHeaderItemView, Disposable disposable) {
            super(0);
            this.a = categoryHeaderItemView;
            this.b = disposable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setUnbindListener(null);
            this.b.dispose();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public CategoryHeaderItemPresenterImpl(@NotNull Consumer<ExtendedProfileItemAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull CategoryHeaderItemView categoryHeaderItemView, @NotNull CategoryHeaderItem categoryHeaderItem, int i) {
        Intrinsics.checkNotNullParameter(categoryHeaderItemView, "view");
        Intrinsics.checkNotNullParameter(categoryHeaderItem, "item");
        categoryHeaderItemView.showTitle(categoryHeaderItem.getTitle());
        categoryHeaderItemView.setCollapsible(categoryHeaderItem.isCollapsible());
        if (categoryHeaderItem.isLoading()) {
            categoryHeaderItemView.showProgress();
        } else {
            categoryHeaderItemView.setCollapsed(categoryHeaderItem.isCollapsed(), categoryHeaderItem.getShowAnimation());
            categoryHeaderItem.setShowAnimation(false);
        }
        categoryHeaderItemView.setUnbindListener(new b(categoryHeaderItemView, categoryHeaderItemView.getClicks().subscribe(new a(this, categoryHeaderItem))));
    }
}
