package com.avito.android.beduin.component.spacing;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import com.avito.android.beduin.core.ComponentsContext;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.beduin.core.common.BeduinApiTypeName;
import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ViewSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@BeduinApiTypeName(types = {"spacing"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/beduin/component/spacing/BeduinSpacingComponent;", "Lcom/avito/android/beduin/core/component/BeduinComponent;", "Lcom/avito/android/beduin/component/spacing/BeduinSpacingModel;", "Landroid/widget/Space;", "Landroid/view/ViewGroup;", "parent", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "createView", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;)Landroid/widget/Space;", "view", "Lcom/avito/android/beduin/core/ComponentsContext;", "ctx", "", "updateWithData", "(Landroid/widget/Space;Lcom/avito/android/beduin/core/ComponentsContext;)V", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "c", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "getActionHandler", "()Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "actionHandler", AuthSource.BOOKING_ORDER, "Lcom/avito/android/beduin/component/spacing/BeduinSpacingModel;", "getModel", "()Lcom/avito/android/beduin/component/spacing/BeduinSpacingModel;", "setModel", "(Lcom/avito/android/beduin/component/spacing/BeduinSpacingModel;)V", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "<init>", "(Lcom/avito/android/beduin/component/spacing/BeduinSpacingModel;Lcom/avito/android/beduin/core/action/BeduinActionHandler;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinSpacingComponent extends BeduinComponent<BeduinSpacingModel, Space> {
    @NotNull
    public BeduinSpacingModel b;
    @NotNull
    public final BeduinActionHandler c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BeduinSpacingComponent a;

        public a(BeduinSpacingComponent beduinSpacingComponent) {
            this.a = beduinSpacingComponent;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.handleClick();
        }
    }

    public BeduinSpacingComponent(@NotNull BeduinSpacingModel beduinSpacingModel, @NotNull BeduinActionHandler beduinActionHandler) {
        Intrinsics.checkNotNullParameter(beduinSpacingModel, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        Intrinsics.checkNotNullParameter(beduinActionHandler, "actionHandler");
        this.b = beduinSpacingModel;
        this.c = beduinActionHandler;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public BeduinActionHandler getActionHandler() {
        return this.c;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public Space createView(@NotNull ViewGroup viewGroup, @NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Space space = new Space(viewGroup.getContext());
        space.setId(View.generateViewId());
        space.setLayoutParams(layoutParams);
        return space;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public BeduinSpacingModel getModel() {
        return this.b;
    }

    public void setModel(@NotNull BeduinSpacingModel beduinSpacingModel) {
        Intrinsics.checkNotNullParameter(beduinSpacingModel, "<set-?>");
        this.b = beduinSpacingModel;
    }

    public void updateWithData(@NotNull Space space, @NotNull ComponentsContext componentsContext) {
        Intrinsics.checkNotNullParameter(space, "view");
        Intrinsics.checkNotNullParameter(componentsContext, "ctx");
        ViewGroup.LayoutParams layoutParams = space.getLayoutParams();
        Integer width = getModel().getWidth();
        int i = -1;
        layoutParams.width = width != null ? ViewSizeKt.getDp(width.intValue()) : -1;
        ViewGroup.LayoutParams layoutParams2 = space.getLayoutParams();
        Integer height = getModel().getHeight();
        if (height != null) {
            i = ViewSizeKt.getDp(height.intValue());
        }
        layoutParams2.height = i;
        space.setOnClickListener(new a(this));
    }
}
