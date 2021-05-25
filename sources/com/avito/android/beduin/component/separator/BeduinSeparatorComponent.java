package com.avito.android.beduin.component.separator;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.beduin.core.ComponentsContext;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.beduin.core.common.BeduinApiTypeName;
import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.beduin.core.model.separator.SeparatorStyle;
import com.avito.android.beduin_common.R;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@BeduinApiTypeName(types = {"separator"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/beduin/component/separator/BeduinSeparatorComponent;", "Lcom/avito/android/beduin/core/component/BeduinComponent;", "Lcom/avito/android/beduin/component/separator/BeduinSeparatorModel;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "parent", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "createView", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;)Landroid/view/View;", "view", "Lcom/avito/android/beduin/core/ComponentsContext;", "ctx", "", "updateWithData", "(Landroid/view/View;Lcom/avito/android/beduin/core/ComponentsContext;)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/beduin/component/separator/BeduinSeparatorModel;", "getModel", "()Lcom/avito/android/beduin/component/separator/BeduinSeparatorModel;", "setModel", "(Lcom/avito/android/beduin/component/separator/BeduinSeparatorModel;)V", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "c", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "getActionHandler", "()Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "actionHandler", "<init>", "(Lcom/avito/android/beduin/component/separator/BeduinSeparatorModel;Lcom/avito/android/beduin/core/action/BeduinActionHandler;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinSeparatorComponent extends BeduinComponent<BeduinSeparatorModel, View> {
    @NotNull
    public BeduinSeparatorModel b;
    @NotNull
    public final BeduinActionHandler c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SeparatorStyle.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            SeparatorStyle separatorStyle = SeparatorStyle.LEFT_INSET;
            iArr[1] = 1;
            SeparatorStyle separatorStyle2 = SeparatorStyle.SIDE_INSET;
            iArr[2] = 2;
            SeparatorStyle separatorStyle3 = SeparatorStyle.FULL_WIDTH;
            iArr[0] = 3;
        }
    }

    public BeduinSeparatorComponent(@NotNull BeduinSeparatorModel beduinSeparatorModel, @NotNull BeduinActionHandler beduinActionHandler) {
        Intrinsics.checkNotNullParameter(beduinSeparatorModel, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        Intrinsics.checkNotNullParameter(beduinActionHandler, "actionHandler");
        this.b = beduinSeparatorModel;
        this.c = beduinActionHandler;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public View createView(@NotNull ViewGroup viewGroup, @NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        View view = new View(viewGroup.getContext());
        view.setId(View.generateViewId());
        view.setLayoutParams(layoutParams);
        return view;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public BeduinActionHandler getActionHandler() {
        return this.c;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    public void updateWithData(@NotNull View view, @NotNull ComponentsContext componentsContext) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(componentsContext, "ctx");
        Resources resources = view.getResources();
        Pair pair = new Pair(Integer.valueOf(resources.getDimensionPixelOffset(R.dimen.separator_height)), Integer.valueOf(resources.getDimensionPixelOffset(R.dimen.separator_padding)));
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        view.setBackgroundColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray8));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = intValue;
        int ordinal = getModel().getStyle().ordinal();
        if (ordinal == 0) {
            Views.changeMargin$default(view, 0, 0, 0, 0, 10, null);
            Unit unit = Unit.INSTANCE;
        } else if (ordinal == 1) {
            Views.changeMargin$default(view, intValue2, 0, 0, 0, 10, null);
            Unit unit2 = Unit.INSTANCE;
        } else if (ordinal == 2) {
            Views.changeMargin$default(view, intValue2, 0, intValue2, 0, 10, null);
            Unit unit3 = Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public BeduinSeparatorModel getModel() {
        return this.b;
    }

    public void setModel(@NotNull BeduinSeparatorModel beduinSeparatorModel) {
        Intrinsics.checkNotNullParameter(beduinSeparatorModel, "<set-?>");
        this.b = beduinSeparatorModel;
    }
}
