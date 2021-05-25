package com.avito.android.search.filter.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.search.filter.FiltersChangeProvider;
import com.avito.android.ui_components.R;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/search/filter/adapter/ChangeDisplayTypePresenterImpl;", "Lcom/avito/android/search/filter/adapter/ChangeDisplayTypePresenter;", "Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeView;", "view", "Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeView;Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "changeConsumer", "Lcom/avito/android/search/filter/FiltersChangeProvider;", "changeProvider", "<init>", "(Lcom/avito/android/search/filter/FiltersChangeProvider;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class ChangeDisplayTypePresenterImpl implements ChangeDisplayTypePresenter {
    public final Consumer<ChangeDisplayTypeItem> a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SerpDisplayType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            SerpDisplayType serpDisplayType = SerpDisplayType.Grid;
            iArr[0] = 1;
            SerpDisplayType serpDisplayType2 = SerpDisplayType.List;
            iArr[1] = 2;
            SerpDisplayType serpDisplayType3 = SerpDisplayType.Rich;
            iArr[2] = 3;
            SerpDisplayType serpDisplayType4 = SerpDisplayType.Vacancy;
            iArr[3] = 4;
        }
    }

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ ChangeDisplayTypePresenterImpl a;
        public final /* synthetic */ ChangeDisplayTypeItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ChangeDisplayTypePresenterImpl changeDisplayTypePresenterImpl, ChangeDisplayTypeItem changeDisplayTypeItem) {
            super(1);
            this.a = changeDisplayTypePresenterImpl;
            this.b = changeDisplayTypeItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.b.setDisplayType(SerpDisplayType.valueOf(str2));
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ChangeDisplayTypePresenterImpl(@NotNull FiltersChangeProvider filtersChangeProvider) {
        Intrinsics.checkNotNullParameter(filtersChangeProvider, "changeProvider");
        this.a = filtersChangeProvider.getDisplayTypeChangeConsumer();
    }

    public void bindView(@NotNull ChangeDisplayTypeView changeDisplayTypeView, @NotNull ChangeDisplayTypeItem changeDisplayTypeItem, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(changeDisplayTypeView, "view");
        Intrinsics.checkNotNullParameter(changeDisplayTypeItem, "item");
        changeDisplayTypeView.setTitle(changeDisplayTypeItem.getTitle());
        changeDisplayTypeView.removeOptions();
        SerpDisplayType[] defaultValues = SerpDisplayType.Companion.defaultValues();
        for (SerpDisplayType serpDisplayType : defaultValues) {
            String name = serpDisplayType.name();
            int ordinal = serpDisplayType.ordinal();
            boolean z = true;
            if (ordinal == 0) {
                i2 = R.drawable.grid_selector;
            } else if (ordinal == 1) {
                i2 = R.drawable.list_selector;
            } else if (ordinal == 2) {
                i2 = R.drawable.list_selector;
            } else if (ordinal == 3) {
                i2 = R.drawable.list_selector;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (serpDisplayType != changeDisplayTypeItem.getDisplayType()) {
                z = false;
            }
            changeDisplayTypeView.addOption(name, i2, z);
        }
        changeDisplayTypeView.setOnOptionSelectedListener(new a(this, changeDisplayTypeItem));
    }
}
