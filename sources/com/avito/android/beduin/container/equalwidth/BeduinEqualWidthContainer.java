package com.avito.android.beduin.container.equalwidth;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.avito.android.beduin.core.ComponentsContext;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.beduin.core.common.BeduinApiTypeName;
import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.beduin.core.container.BeduinContainer;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@BeduinApiTypeName(types = {"equalWidthContainer"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BA\u0012\u0006\u0010&\u001a\u00020\u0002\u0012(\u0010\u001a\u001a$\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u00130\u0010j\u0002`\u0015\u0012\u0006\u0010\u001f\u001a\u00020\u0012¢\u0006\u0004\b'\u0010(J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR>\u0010\u001a\u001a$\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u00130\u0010j\u0002`\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/beduin/container/equalwidth/BeduinEqualWidthContainer;", "Lcom/avito/android/beduin/core/container/BeduinContainer;", "Lcom/avito/android/beduin/container/equalwidth/BeduinEqualWidthContainerModel;", "Landroid/widget/LinearLayout;", "Landroid/view/ViewGroup;", "parent", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "createView", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;)Landroid/widget/LinearLayout;", "view", "Lcom/avito/android/beduin/core/ComponentsContext;", "ctx", "", "updateWithData", "(Landroid/widget/LinearLayout;Lcom/avito/android/beduin/core/ComponentsContext;)V", "Lkotlin/Function2;", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "Lcom/avito/android/beduin/core/component/BeduinComponent;", "Landroid/view/View;", "Lcom/avito/android/beduin/core/container/BeduinChildResolver;", "c", "Lkotlin/jvm/functions/Function2;", "getChildResolver", "()Lkotlin/jvm/functions/Function2;", "childResolver", "d", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "getActionHandler", "()Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "actionHandler", AuthSource.BOOKING_ORDER, "Lcom/avito/android/beduin/container/equalwidth/BeduinEqualWidthContainerModel;", "getModel", "()Lcom/avito/android/beduin/container/equalwidth/BeduinEqualWidthContainerModel;", "setModel", "(Lcom/avito/android/beduin/container/equalwidth/BeduinEqualWidthContainerModel;)V", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "<init>", "(Lcom/avito/android/beduin/container/equalwidth/BeduinEqualWidthContainerModel;Lkotlin/jvm/functions/Function2;Lcom/avito/android/beduin/core/action/BeduinActionHandler;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinEqualWidthContainer extends BeduinContainer<BeduinEqualWidthContainerModel, LinearLayout> {
    @NotNull
    public BeduinEqualWidthContainerModel b;
    @NotNull
    public final Function2<BeduinModel, BeduinActionHandler, BeduinComponent<BeduinModel, View>> c;
    @NotNull
    public final BeduinActionHandler d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BeduinEqualWidthContainer a;
        public final /* synthetic */ ComponentsContext b;

        public a(BeduinEqualWidthContainer beduinEqualWidthContainer, ComponentsContext componentsContext) {
            this.a = beduinEqualWidthContainer;
            this.b = componentsContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.handleClick();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<? super com.avito.android.beduin.core.model.container.component.BeduinModel, ? super com.avito.android.beduin.core.action.BeduinActionHandler, ? extends com.avito.android.beduin.core.component.BeduinComponent<com.avito.android.beduin.core.model.container.component.BeduinModel, android.view.View>> */
    /* JADX WARN: Multi-variable type inference failed */
    public BeduinEqualWidthContainer(@NotNull BeduinEqualWidthContainerModel beduinEqualWidthContainerModel, @NotNull Function2<? super BeduinModel, ? super BeduinActionHandler, ? extends BeduinComponent<BeduinModel, View>> function2, @NotNull BeduinActionHandler beduinActionHandler) {
        Intrinsics.checkNotNullParameter(beduinEqualWidthContainerModel, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        Intrinsics.checkNotNullParameter(function2, "childResolver");
        Intrinsics.checkNotNullParameter(beduinActionHandler, "actionHandler");
        this.b = beduinEqualWidthContainerModel;
        this.c = function2;
        this.d = beduinActionHandler;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public BeduinActionHandler getActionHandler() {
        return this.d;
    }

    @Override // com.avito.android.beduin.core.container.BeduinContainer
    @NotNull
    public Function2<BeduinModel, BeduinActionHandler, BeduinComponent<BeduinModel, View>> getChildResolver() {
        return this.c;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public LinearLayout createView(@NotNull ViewGroup viewGroup, @NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setId(View.generateViewId());
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        return linearLayout;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public BeduinEqualWidthContainerModel getModel() {
        return this.b;
    }

    public void setModel(@NotNull BeduinEqualWidthContainerModel beduinEqualWidthContainerModel) {
        Intrinsics.checkNotNullParameter(beduinEqualWidthContainerModel, "<set-?>");
        this.b = beduinEqualWidthContainerModel;
    }

    public void updateWithData(@NotNull LinearLayout linearLayout, @NotNull ComponentsContext componentsContext) {
        Intrinsics.checkNotNullParameter(linearLayout, "view");
        Intrinsics.checkNotNullParameter(componentsContext, "ctx");
        linearLayout.setTag(getModel().getId());
        setupBasics(linearLayout);
        int size = getModel().getChildren().size();
        int i = 0;
        for (T t : getModel().getChildren()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            BeduinComponent<BeduinModel, View> invoke = getChildResolver().invoke(t, getActionHandler());
            View createView = invoke.createView(linearLayout, new LinearLayout.LayoutParams(0, -2, 1.0f / ((float) size)));
            Integer interItemSpacing = getModel().getInterItemSpacing();
            if (interItemSpacing != null) {
                int intValue = interItemSpacing.intValue();
                if (i != 0) {
                    Views.changeMargin$default(createView, ViewSizeKt.getDp(intValue), 0, 0, 0, 14, null);
                }
            }
            linearLayout.addView(createView);
            invoke.updateWithData(createView, componentsContext);
            i = i2;
        }
        linearLayout.setOnClickListener(new a(this, componentsContext));
    }
}
