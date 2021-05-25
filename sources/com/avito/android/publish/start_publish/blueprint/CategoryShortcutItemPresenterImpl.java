package com.avito.android.publish.start_publish.blueprint;

import com.avito.android.lib.design.avito.R;
import com.avito.android.publish.start_publish.StartPublishSheet;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fRD\u0010\u0016\u001a0\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00040\u0004 \u0012*\u0017\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0011¢\u0006\u0002\b\u00130\u0011¢\u0006\u0002\b\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemPresenterImpl;", "Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemPresenter;", "Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemView;", "view", "Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData$CategoryShortcutItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemView;Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData$CategoryShortcutItem;I)V", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getItemClickObservable", "()Lio/reactivex/rxjava3/core/Observable;", "itemClickObservable", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "itemClickStream", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryShortcutItemPresenterImpl implements CategoryShortcutItemPresenter {
    public final PublishRelay<StartPublishSheet.SheetData.CategoryShortcutItem> a;
    @NotNull
    public final Observable<StartPublishSheet.SheetData.CategoryShortcutItem> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CategoryShortcutItemPresenterImpl a;
        public final /* synthetic */ StartPublishSheet.SheetData.CategoryShortcutItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CategoryShortcutItemPresenterImpl categoryShortcutItemPresenterImpl, StartPublishSheet.SheetData.CategoryShortcutItem categoryShortcutItem) {
            super(0);
            this.a = categoryShortcutItemPresenterImpl;
            this.b = categoryShortcutItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public CategoryShortcutItemPresenterImpl() {
        PublishRelay<StartPublishSheet.SheetData.CategoryShortcutItem> create = PublishRelay.create();
        this.a = create;
        Observable<StartPublishSheet.SheetData.CategoryShortcutItem> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "itemClickStream.hide()");
        this.b = hide;
    }

    @Override // com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemPresenter
    @NotNull
    public Observable<StartPublishSheet.SheetData.CategoryShortcutItem> getItemClickObservable() {
        return this.b;
    }

    public void bindView(@NotNull CategoryShortcutItemView categoryShortcutItemView, @NotNull StartPublishSheet.SheetData.CategoryShortcutItem categoryShortcutItem, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(categoryShortcutItemView, "view");
        Intrinsics.checkNotNullParameter(categoryShortcutItem, "item");
        categoryShortcutItemView.setTitle(categoryShortcutItem.getTitle());
        Integer categoryId = categoryShortcutItem.getNavigation().getCategoryId();
        if (categoryId != null && categoryId.intValue() == 1) {
            i2 = R.drawable.avito_ic_auto_24;
        } else if (categoryId != null && categoryId.intValue() == 4) {
            i2 = R.drawable.avito_ic_realty_24;
        } else if (categoryId != null && categoryId.intValue() == 110) {
            i2 = com.avito.android.publish.R.drawable.ic_jobs_category;
        } else if (categoryId != null && categoryId.intValue() == 113) {
            i2 = R.drawable.avito_ic_scissors_24;
        } else {
            i2 = com.avito.android.publish.R.drawable.ic_general_category;
        }
        categoryShortcutItemView.setIcon(i2);
        categoryShortcutItemView.setOnItemClickListener(new a(this, categoryShortcutItem));
    }
}
