package com.avito.android.search.filter.adapter;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.search.filter.FiltersChangeProvider;
import com.avito.android.ui_components.R;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/search/filter/adapter/DisplayTypeSelectPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeView;", "Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeView;Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/category_parameters/ParameterElement$Select;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "changeConsumer", "Lcom/avito/android/search/filter/FiltersChangeProvider;", "changeProvider", "<init>", "(Lcom/avito/android/search/filter/FiltersChangeProvider;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class DisplayTypeSelectPresenter implements ItemPresenter<ChangeDisplayTypeView, ParameterElement.Select.Flat> {
    public final Consumer<ParameterElement.Select> a;

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
        public final /* synthetic */ DisplayTypeSelectPresenter a;
        public final /* synthetic */ ParameterElement.Select.Flat b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DisplayTypeSelectPresenter displayTypeSelectPresenter, ParameterElement.Select.Flat flat) {
            super(1);
            this.a = displayTypeSelectPresenter;
            this.b = flat;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            T t;
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "selectedValue");
            ParameterElement.Select.Flat flat = this.b;
            Iterator<T> it = flat.getValues().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual(t.getStringId(), str2)) {
                    break;
                }
            }
            flat.setSelectedValue(t);
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public DisplayTypeSelectPresenter(@NotNull FiltersChangeProvider filtersChangeProvider) {
        Intrinsics.checkNotNullParameter(filtersChangeProvider, "changeProvider");
        this.a = filtersChangeProvider.getSelectChangeConsumer();
    }

    public void bindView(@NotNull ChangeDisplayTypeView changeDisplayTypeView, @NotNull ParameterElement.Select.Flat flat, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(changeDisplayTypeView, "view");
        Intrinsics.checkNotNullParameter(flat, "item");
        changeDisplayTypeView.setTitle(flat.getTitle());
        changeDisplayTypeView.removeOptions();
        for (T t : flat.getValues()) {
            String stringId = t.getStringId();
            SerpDisplayType fromString = SerpDisplayType.Companion.fromString(t.getStringId());
            if (fromString != null) {
                int ordinal = fromString.ordinal();
                if (ordinal == 0) {
                    i2 = R.drawable.grid_selector;
                } else if (ordinal == 1) {
                    i2 = R.drawable.list_selector;
                } else if (ordinal == 2) {
                    i2 = R.drawable.list_selector;
                } else if (ordinal == 3) {
                    i2 = R.drawable.list_selector;
                }
                changeDisplayTypeView.addOption(stringId, i2, Intrinsics.areEqual(t, flat.getSelectedValue()));
            }
        }
        changeDisplayTypeView.setOnOptionSelectedListener(new a(this, flat));
    }
}
