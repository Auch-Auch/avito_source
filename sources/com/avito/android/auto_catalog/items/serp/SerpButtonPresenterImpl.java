package com.avito.android.auto_catalog.items.serp;

import com.avito.android.auto_catalog.AutoCatalogPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/auto_catalog/items/serp/SerpButtonPresenterImpl;", "Lcom/avito/android/auto_catalog/items/serp/SerpButtonPresenter;", "Lcom/avito/android/auto_catalog/items/serp/SerpButtonView;", "view", "Lcom/avito/android/auto_catalog/items/serp/SerpButtonItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/auto_catalog/items/serp/SerpButtonView;Lcom/avito/android/auto_catalog/items/serp/SerpButtonItem;I)V", "Lcom/avito/android/auto_catalog/AutoCatalogPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/auto_catalog/AutoCatalogPresenter;", "presenter", "<init>", "(Lcom/avito/android/auto_catalog/AutoCatalogPresenter;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class SerpButtonPresenterImpl implements SerpButtonPresenter {
    public final AutoCatalogPresenter a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SerpButtonPresenterImpl a;
        public final /* synthetic */ SerpButtonItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SerpButtonPresenterImpl serpButtonPresenterImpl, SerpButtonItem serpButtonItem) {
            super(0);
            this.a = serpButtonPresenterImpl;
            this.b = serpButtonItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.onSerpButtonClick(this.b.isZeroSerp());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public SerpButtonPresenterImpl(@NotNull AutoCatalogPresenter autoCatalogPresenter) {
        Intrinsics.checkNotNullParameter(autoCatalogPresenter, "presenter");
        this.a = autoCatalogPresenter;
    }

    public void bindView(@NotNull SerpButtonView serpButtonView, @NotNull SerpButtonItem serpButtonItem, int i) {
        Intrinsics.checkNotNullParameter(serpButtonView, "view");
        Intrinsics.checkNotNullParameter(serpButtonItem, "item");
        serpButtonView.setButton(serpButtonItem.getText(), new a(this, serpButtonItem));
    }
}
