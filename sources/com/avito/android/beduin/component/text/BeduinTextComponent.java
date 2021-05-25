package com.avito.android.beduin.component.text;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.beduin.action.BeduinOpenDeeplinkAction;
import com.avito.android.beduin.action.BeduinOpenLinkAction;
import com.avito.android.beduin.core.ComponentsContext;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.beduin.core.action.BeduinActionType;
import com.avito.android.beduin.core.common.BeduinApiTypeName;
import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.beduin.util.TextViewsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.deep_linking.links.OnUrlClickListener;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.lib.design.text_view.AvitoTextView;
import com.avito.android.lib.util.ContextsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.TextViews;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@BeduinApiTypeName(types = {"text", "textWithIcon", "attributedText", "attributedTextWithIcon"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/beduin/component/text/BeduinTextComponent;", "Lcom/avito/android/beduin/core/component/BeduinComponent;", "Lcom/avito/android/beduin/component/text/BeduinTextModel;", "Lcom/avito/android/lib/design/text_view/AvitoTextView;", "Landroid/view/ViewGroup;", "parent", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "createView", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;)Lcom/avito/android/lib/design/text_view/AvitoTextView;", "view", "Lcom/avito/android/beduin/core/ComponentsContext;", "ctx", "", "updateWithData", "(Lcom/avito/android/lib/design/text_view/AvitoTextView;Lcom/avito/android/beduin/core/ComponentsContext;)V", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "c", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "getActionHandler", "()Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "actionHandler", AuthSource.BOOKING_ORDER, "Lcom/avito/android/beduin/component/text/BeduinTextModel;", "getModel", "()Lcom/avito/android/beduin/component/text/BeduinTextModel;", "setModel", "(Lcom/avito/android/beduin/component/text/BeduinTextModel;)V", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "<init>", "(Lcom/avito/android/beduin/component/text/BeduinTextModel;Lcom/avito/android/beduin/core/action/BeduinActionHandler;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinTextComponent extends BeduinComponent<BeduinTextModel, AvitoTextView> {
    @NotNull
    public BeduinTextModel b;
    @NotNull
    public final BeduinActionHandler c;

    public static final class a implements OnDeepLinkClickListener {
        public final /* synthetic */ BeduinTextComponent a;

        public a(AvitoTextView avitoTextView, BeduinTextComponent beduinTextComponent) {
            this.a = beduinTextComponent;
        }

        @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
        public final void onDeepLinkClick(@NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a.getActionHandler().handle(new BeduinOpenDeeplinkAction(BeduinActionType.ON_CLICK, deepLink));
        }
    }

    public static final class b implements OnUrlClickListener {
        public final /* synthetic */ BeduinTextComponent a;

        public b(AvitoTextView avitoTextView, BeduinTextComponent beduinTextComponent) {
            this.a = beduinTextComponent;
        }

        @Override // com.avito.android.deep_linking.links.OnUrlClickListener
        public final boolean onUrlClick(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return this.a.getActionHandler().handle(new BeduinOpenLinkAction(BeduinActionType.ON_CLICK, str));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ BeduinTextComponent a;

        public c(BeduinTextComponent beduinTextComponent) {
            this.a = beduinTextComponent;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.handleClick();
        }
    }

    public BeduinTextComponent(@NotNull BeduinTextModel beduinTextModel, @NotNull BeduinActionHandler beduinActionHandler) {
        Intrinsics.checkNotNullParameter(beduinTextModel, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        Intrinsics.checkNotNullParameter(beduinActionHandler, "actionHandler");
        this.b = beduinTextModel;
        this.c = beduinActionHandler;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public BeduinActionHandler getActionHandler() {
        return this.c;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public AvitoTextView createView(@NotNull ViewGroup viewGroup, @NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        AvitoTextView avitoTextView = new AvitoTextView(context, null, 0, 0, 14, null);
        avitoTextView.setId(View.generateViewId());
        avitoTextView.setLayoutParams(layoutParams);
        return avitoTextView;
    }

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    @NotNull
    public BeduinTextModel getModel() {
        return this.b;
    }

    public void setModel(@NotNull BeduinTextModel beduinTextModel) {
        Intrinsics.checkNotNullParameter(beduinTextModel, "<set-?>");
        this.b = beduinTextModel;
    }

    public void updateWithData(@NotNull AvitoTextView avitoTextView, @NotNull ComponentsContext componentsContext) {
        Intrinsics.checkNotNullParameter(avitoTextView, "view");
        Intrinsics.checkNotNullParameter(componentsContext, "ctx");
        avitoTextView.setTag(getModel().getId());
        Context context = avitoTextView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        avitoTextView.setTextAppearance(ContextsKt.getTextStyleByAttrName(context, getModel().getStyle()));
        TextViewsKt.setAlignment(avitoTextView, getModel().getAlignment());
        if (getModel().getText() != null) {
            TextViews.bindText$default(avitoTextView, getModel().getText(), false, 2, null);
            avitoTextView.setMovementMethod(null);
        } else {
            AttributedText attributedText = getModel().getAttributedText();
            if (attributedText != null) {
                attributedText.setOnDeepLinkClickListener(new a(avitoTextView, this));
                attributedText.setOnUrlClickListener(new b(avitoTextView, this));
                com.avito.android.util.text.TextViewsKt.bindAttributedText$default(avitoTextView, attributedText, null, 2, null);
                avitoTextView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        TextViewsKt.bindIcon(avitoTextView, getModel().getLocalIcon(), getModel().getBase64Icon(), getModel().getIconPosition());
        avitoTextView.setOnClickListener(new c(this));
    }
}
