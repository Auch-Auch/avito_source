package com.avito.android.component.message_suggest_panel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.avito.android.component.message_suggest_element.MessageSuggestElementImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b$\u0010%J#\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0010R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/component/message_suggest_panel/MessageSuggestPanelImpl;", "Lcom/avito/android/component/message_suggest_panel/MessageSuggestPanel;", "Lkotlin/Function1;", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setOnCloseClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "items", "setItems", "(Ljava/util/List;)V", "hide", "()V", "show", "conceal", AuthSource.SEND_ABUSE, "Ljava/util/List;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function1;", "itemClickListener", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "container", "Landroid/widget/ImageButton;", "d", "Landroid/widget/ImageButton;", "closeButton", "Landroid/view/View;", "e", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class MessageSuggestPanelImpl implements MessageSuggestPanel {
    public List<String> a = CollectionsKt__CollectionsKt.emptyList();
    public Function1<? super String, Unit> b = a.a;
    public final LinearLayout c;
    public final ImageButton d;
    public final View e;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            Intrinsics.checkNotNullParameter(str, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public MessageSuggestPanelImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.e = view;
        View findViewById = view.findViewById(R.id.message_suggest_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.c = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.message_suggest_close_btn);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageButton");
        this.d = (ImageButton) findViewById2;
    }

    @Override // com.avito.android.component.message_suggest_panel.MessageSuggestPanel
    public void conceal() {
        Views.conceal(this.e);
    }

    @Override // com.avito.android.component.message_suggest_panel.MessageSuggestPanel
    public void hide() {
        Views.hide(this.e);
    }

    @Override // com.avito.android.component.message_suggest_panel.MessageSuggestPanel
    public void setItems(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        if (!Intrinsics.areEqual(this.a, list)) {
            this.a = list;
            LinearLayout linearLayout = this.c;
            linearLayout.removeViews(0, linearLayout.getChildCount() - 1);
            for (T t : list) {
                View inflate = LayoutInflater.from(this.c.getContext()).inflate(R.layout.message_suggest_element, (ViewGroup) this.c, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
                ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.message_suggest_panel_elements_horizontal_margin);
                marginLayoutParams.rightMargin = dimensionPixelSize;
                marginLayoutParams.leftMargin = dimensionPixelSize;
                MessageSuggestElementImpl messageSuggestElementImpl = new MessageSuggestElementImpl(inflate);
                messageSuggestElementImpl.setText(t);
                messageSuggestElementImpl.setOnClickListener(new a2.a.a.a.e.a(this, t));
                LinearLayout linearLayout2 = this.c;
                linearLayout2.addView(inflate, linearLayout2.getChildCount() - 1, marginLayoutParams);
            }
        }
    }

    @Override // com.avito.android.component.message_suggest_panel.MessageSuggestPanel
    public void setOnCloseClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d.setOnClickListener(new b(function0));
    }

    @Override // com.avito.android.component.message_suggest_panel.MessageSuggestPanel
    public void setOnItemClickListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = function1;
    }

    @Override // com.avito.android.component.message_suggest_panel.MessageSuggestPanel
    public void show() {
        Views.show(this.e);
    }
}
