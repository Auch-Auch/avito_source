package com.avito.android.beduin.container.spread;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.beduin.core.ComponentsContext;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.beduin.core.common.BeduinApiTypeName;
import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.beduin.core.container.BeduinContainer;
import com.avito.android.beduin.core.model.container.BeduinContainerPriority;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ViewSizeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@BeduinApiTypeName(types = {"spreadContainer"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BA\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012(\u0010\u001d\u001a$\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00120\u00170\u0015j\u0002`\u0018\u0012\u0006\u0010\"\u001a\u00020\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R>\u0010\u001d\u001a$\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00120\u00170\u0015j\u0002`\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/avito/android/beduin/container/spread/BeduinSpreadContainer;", "Lcom/avito/android/beduin/core/container/BeduinContainer;", "Lcom/avito/android/beduin/container/spread/BeduinSpreadContainerModel;", "Lcom/avito/android/beduin/container/spread/BeduinSpreadLayout;", "Landroid/view/ViewGroup;", "parent", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "createView", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;)Lcom/avito/android/beduin/container/spread/BeduinSpreadLayout;", "view", "Lcom/avito/android/beduin/core/ComponentsContext;", "ctx", "", "updateWithData", "(Lcom/avito/android/beduin/container/spread/BeduinSpreadLayout;Lcom/avito/android/beduin/core/ComponentsContext;)V", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "Landroid/view/View;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/beduin/core/model/container/component/BeduinModel;Landroid/view/ViewGroup;Lcom/avito/android/beduin/core/ComponentsContext;)Landroid/view/View;", "Lkotlin/Function2;", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "Lcom/avito/android/beduin/core/component/BeduinComponent;", "Lcom/avito/android/beduin/core/container/BeduinChildResolver;", "c", "Lkotlin/jvm/functions/Function2;", "getChildResolver", "()Lkotlin/jvm/functions/Function2;", "childResolver", "d", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "getActionHandler", "()Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "actionHandler", AuthSource.BOOKING_ORDER, "Lcom/avito/android/beduin/container/spread/BeduinSpreadContainerModel;", "getModel", "()Lcom/avito/android/beduin/container/spread/BeduinSpreadContainerModel;", "setModel", "(Lcom/avito/android/beduin/container/spread/BeduinSpreadContainerModel;)V", "<init>", "(Lcom/avito/android/beduin/container/spread/BeduinSpreadContainerModel;Lkotlin/jvm/functions/Function2;Lcom/avito/android/beduin/core/action/BeduinActionHandler;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinSpreadContainer extends BeduinContainer<BeduinSpreadContainerModel, BeduinSpreadLayout> {
    @NotNull
    public BeduinSpreadContainerModel b;
    @NotNull
    public final Function2<BeduinModel, BeduinActionHandler, BeduinComponent<BeduinModel, View>> c;
    @NotNull
    public final BeduinActionHandler d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BeduinSpreadContainer a;
        public final /* synthetic */ ComponentsContext b;

        public a(BeduinSpreadContainer beduinSpreadContainer, BeduinSpreadLayout beduinSpreadLayout, ComponentsContext componentsContext) {
            this.a = beduinSpreadContainer;
            this.b = componentsContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.handleClick();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<? super com.avito.android.beduin.core.model.container.component.BeduinModel, ? super com.avito.android.beduin.core.action.BeduinActionHandler, ? extends com.avito.android.beduin.core.component.BeduinComponent<com.avito.android.beduin.core.model.container.component.BeduinModel, android.view.View>> */
    /* JADX WARN: Multi-variable type inference failed */
    public BeduinSpreadContainer(@NotNull BeduinSpreadContainerModel beduinSpreadContainerModel, @NotNull Function2<? super BeduinModel, ? super BeduinActionHandler, ? extends BeduinComponent<BeduinModel, View>> function2, @NotNull BeduinActionHandler beduinActionHandler) {
        Intrinsics.checkNotNullParameter(beduinSpreadContainerModel, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        Intrinsics.checkNotNullParameter(function2, "childResolver");
        Intrinsics.checkNotNullParameter(beduinActionHandler, "actionHandler");
        this.b = beduinSpreadContainerModel;
        this.c = function2;
        this.d = beduinActionHandler;
    }

    public final View a(BeduinModel beduinModel, ViewGroup viewGroup, ComponentsContext componentsContext) {
        BeduinComponent<BeduinModel, View> invoke = getChildResolver().invoke(beduinModel, getActionHandler());
        View createView = invoke.createView(viewGroup, new ViewGroup.LayoutParams(-2, -2));
        if (createView.getId() == -1) {
            createView.setId(View.generateViewId());
        }
        invoke.updateWithData(createView, componentsContext);
        return createView;
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
    public BeduinSpreadLayout createView(@NotNull ViewGroup viewGroup, @NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        BeduinSpreadLayout beduinSpreadLayout = new BeduinSpreadLayout(context, null, 0, 6, null);
        beduinSpreadLayout.setId(View.generateViewId());
        beduinSpreadLayout.setLayoutParams(layoutParams);
        return beduinSpreadLayout;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public BeduinSpreadContainerModel getModel() {
        return this.b;
    }

    public void setModel(@NotNull BeduinSpreadContainerModel beduinSpreadContainerModel) {
        Intrinsics.checkNotNullParameter(beduinSpreadContainerModel, "<set-?>");
        this.b = beduinSpreadContainerModel;
    }

    public void updateWithData(@NotNull BeduinSpreadLayout beduinSpreadLayout, @NotNull ComponentsContext componentsContext) {
        Intrinsics.checkNotNullParameter(beduinSpreadLayout, "view");
        Intrinsics.checkNotNullParameter(componentsContext, "ctx");
        beduinSpreadLayout.setTag(getModel().getId());
        setupBasics(beduinSpreadLayout);
        List<BeduinModel> leftChildren = getModel().getLeftChildren();
        if (leftChildren == null) {
            leftChildren = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(leftChildren, 10));
        Iterator<T> it = leftChildren.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next(), beduinSpreadLayout, componentsContext));
        }
        beduinSpreadLayout.setLeftChildren(arrayList);
        List<BeduinModel> rightChildren = getModel().getRightChildren();
        if (rightChildren == null) {
            rightChildren = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(rightChildren, 10));
        Iterator<T> it2 = rightChildren.iterator();
        while (it2.hasNext()) {
            arrayList2.add(a(it2.next(), beduinSpreadLayout, componentsContext));
        }
        beduinSpreadLayout.setRightChildren(arrayList2);
        Integer interItemSpacing = getModel().getInterItemSpacing();
        boolean z = false;
        beduinSpreadLayout.setInterItemSpacingPx(interItemSpacing != null ? ViewSizeKt.getDp(interItemSpacing.intValue()) : 0);
        if (getModel().getPriority() != BeduinContainerPriority.RIGHT) {
            z = true;
        }
        beduinSpreadLayout.setLeftPriority(z);
        beduinSpreadLayout.setOnClickListener(new a(this, beduinSpreadLayout, componentsContext));
    }
}
