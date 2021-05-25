package com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterItemPresenterImpl;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterItemPresenter;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterItemView;", "view", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterFormItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterItemView;Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterFormItem;I)V", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", "presenter", "<init>", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalSearchFilterItemPresenterImpl implements VerticalSearchFilterItemPresenter {
    public final VerticalFilterPresenter a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ VerticalSearchFilterItemPresenterImpl a;
        public final /* synthetic */ VerticalSearchFilterFormItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(VerticalSearchFilterItemPresenterImpl verticalSearchFilterItemPresenterImpl, VerticalSearchFilterFormItem verticalSearchFilterFormItem) {
            super(0);
            this.a = verticalSearchFilterItemPresenterImpl;
            this.b = verticalSearchFilterFormItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Filter filter = this.b.getFilter();
            if (filter != null) {
                this.a.a.onFilterClick(filter);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public VerticalSearchFilterItemPresenterImpl(@NotNull VerticalFilterPresenter verticalFilterPresenter) {
        Intrinsics.checkNotNullParameter(verticalFilterPresenter, "presenter");
        this.a = verticalFilterPresenter;
    }

    public void bindView(@NotNull VerticalSearchFilterItemView verticalSearchFilterItemView, @NotNull VerticalSearchFilterFormItem verticalSearchFilterFormItem, int i) {
        String str;
        InlineFilterValue value;
        Intrinsics.checkNotNullParameter(verticalSearchFilterItemView, "view");
        Intrinsics.checkNotNullParameter(verticalSearchFilterFormItem, "item");
        Filter filter = verticalSearchFilterFormItem.getFilter();
        if (filter == null || (str = filter.getDisplayTitle()) == null) {
            Filter filter2 = verticalSearchFilterFormItem.getFilter();
            str = filter2 != null ? filter2.getTitle() : null;
        }
        if (str == null) {
            str = "";
        }
        Filter filter3 = verticalSearchFilterFormItem.getFilter();
        boolean z = true;
        verticalSearchFilterItemView.setText(str, (filter3 == null || (value = filter3.getValue()) == null || value.isEmpty()) ? false : true);
        verticalSearchFilterItemView.setOnClickListener(new a(this, verticalSearchFilterFormItem));
        if (!verticalSearchFilterFormItem.isEnabled() || verticalSearchFilterFormItem.getFilter() == null) {
            z = false;
        }
        verticalSearchFilterItemView.setIsEnabled(z);
    }
}
