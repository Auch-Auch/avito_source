package com.avito.android.beduin.component.button;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.beduin.core.ComponentsContext;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.beduin.core.common.BeduinApiTypeName;
import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.beduin.core.model.icon.IconPosition;
import com.avito.android.beduin.util.ImageUtilKt;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.util.ContextsKt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@BeduinApiTypeName(types = {PhonePageSourceKt.PHONE_SOURCE_BUTTON})
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/beduin/component/button/BeduinButtonComponent;", "Lcom/avito/android/beduin/core/component/BeduinComponent;", "Lcom/avito/android/beduin/component/button/BeduinButtonModel;", "Lcom/avito/android/lib/design/button/Button;", "Landroid/view/ViewGroup;", "parent", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "createView", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;)Lcom/avito/android/lib/design/button/Button;", "view", "Lcom/avito/android/beduin/core/ComponentsContext;", "ctx", "", "updateWithData", "(Lcom/avito/android/lib/design/button/Button;Lcom/avito/android/beduin/core/ComponentsContext;)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/beduin/component/button/BeduinButtonModel;", "getModel", "()Lcom/avito/android/beduin/component/button/BeduinButtonModel;", "setModel", "(Lcom/avito/android/beduin/component/button/BeduinButtonModel;)V", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "c", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "getActionHandler", "()Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "actionHandler", "<init>", "(Lcom/avito/android/beduin/component/button/BeduinButtonModel;Lcom/avito/android/beduin/core/action/BeduinActionHandler;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinButtonComponent extends BeduinComponent<BeduinButtonModel, Button> {
    @NotNull
    public BeduinButtonModel b;
    @NotNull
    public final BeduinActionHandler c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            IconPosition.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            IconPosition iconPosition = IconPosition.LEFT;
            iArr[0] = 1;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BeduinButtonComponent a;

        public a(BeduinButtonComponent beduinButtonComponent) {
            this.a = beduinButtonComponent;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.handleClick();
        }
    }

    public BeduinButtonComponent(@NotNull BeduinButtonModel beduinButtonModel, @NotNull BeduinActionHandler beduinActionHandler) {
        Intrinsics.checkNotNullParameter(beduinButtonModel, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        Intrinsics.checkNotNullParameter(beduinActionHandler, "actionHandler");
        this.b = beduinButtonModel;
        this.c = beduinActionHandler;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public BeduinActionHandler getActionHandler() {
        return this.c;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public Button createView(@NotNull ViewGroup viewGroup, @NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        Button button = new Button(context);
        button.setId(View.generateViewId());
        button.setLayoutParams(layoutParams);
        return button;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public BeduinButtonModel getModel() {
        return this.b;
    }

    public void setModel(@NotNull BeduinButtonModel beduinButtonModel) {
        Intrinsics.checkNotNullParameter(beduinButtonModel, "<set-?>");
        this.b = beduinButtonModel;
    }

    public void updateWithData(@NotNull Button button, @NotNull ComponentsContext componentsContext) {
        Intrinsics.checkNotNullParameter(button, "view");
        Intrinsics.checkNotNullParameter(componentsContext, "ctx");
        button.setTag(getModel().getId());
        button.setText(getModel().getTitle());
        button.setAppearanceFromAttr(ContextsKt.getButtonStyleByAttrName(getModel().getStyle()));
        Boolean isEnabled = getModel().isEnabled();
        button.setEnabled(isEnabled != null ? isEnabled.booleanValue() : true);
        Drawable loadIcon = ImageUtilKt.loadIcon(button.getContext(), getModel().getLocalIcon(), getModel().getBase64Icon());
        if (loadIcon != null) {
            IconPosition iconPosition = getModel().getIconPosition();
            if (iconPosition != null && iconPosition.ordinal() == 0) {
                button.setImageDrawable(loadIcon, null, false);
            } else {
                button.setImageDrawable(null, loadIcon, false);
            }
        }
        button.setOnClickListener(new a(this));
    }
}
