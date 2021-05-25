package com.avito.android.component.toggle_list_element;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.LinearLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b(\u0010)J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0013\u001a\u00020\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/component/toggle_list_element/ToggleListElementImpl;", "Lcom/avito/android/component/toggle_list_element/ToggleListElement;", "", "title", "", "setTitle", "(I)V", "", "(Ljava/lang/String;)V", "removeOptions", "()V", "id", "icon", "", "isSelected", "addOption", "(Ljava/lang/String;IZ)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnOptionSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/view/View;", "e", "Landroid/view/View;", "view", "Landroid/widget/LinearLayout;", AuthSource.BOOKING_ORDER, "Landroid/widget/LinearLayout;", "containerView", "c", "Lkotlin/jvm/functions/Function1;", "optionSelectedListener", "Lru/avito/component/text/Text;", AuthSource.SEND_ABUSE, "Lru/avito/component/text/Text;", "titleView", "Landroid/widget/Checkable;", "d", "Landroid/widget/Checkable;", "lastChecked", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ToggleListElementImpl implements ToggleListElement {
    public final Text a;
    public final LinearLayout b;
    public Function1<? super String, Unit> c;
    public Checkable d;
    public final View e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ToggleListElementImpl a;
        public final /* synthetic */ CheckableImageButton b;
        public final /* synthetic */ String c;

        public a(ToggleListElementImpl toggleListElementImpl, CheckableImageButton checkableImageButton, String str) {
            this.a = toggleListElementImpl;
            this.b = checkableImageButton;
            this.c = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ToggleListElementImpl.access$selectButton(this.a, this.b);
            Function1 function1 = this.a.c;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(this.c);
            }
        }
    }

    public ToggleListElementImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.e = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = new TextImpl(findViewById);
        View findViewById2 = view.findViewById(R.id.container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.b = (LinearLayout) findViewById2;
    }

    public static final void access$selectButton(ToggleListElementImpl toggleListElementImpl, CheckableImageButton checkableImageButton) {
        Checkable checkable = toggleListElementImpl.d;
        if (checkable != null) {
            checkable.setChecked(false);
        }
        toggleListElementImpl.d = checkableImageButton;
        if (checkableImageButton != null) {
            checkableImageButton.setChecked(true);
        }
    }

    @Override // com.avito.android.component.toggle_list_element.ToggleListElement
    public void addOption(@NotNull String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        View inflate = LayoutInflater.from(this.e.getContext()).inflate(R.layout.toggle_list_element_option, (ViewGroup) this.b, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.google.android.material.internal.CheckableImageButton");
        CheckableImageButton checkableImageButton = (CheckableImageButton) inflate;
        checkableImageButton.setImageResource(i);
        checkableImageButton.setOnClickListener(new a(this, checkableImageButton, str));
        this.b.addView(checkableImageButton);
        if (z) {
            Checkable checkable = this.d;
            if (checkable != null) {
                checkable.setChecked(false);
            }
            this.d = checkableImageButton;
            checkableImageButton.setChecked(true);
        }
    }

    @Override // com.avito.android.component.toggle_list_element.ToggleListElement
    public void removeOptions() {
        this.b.removeAllViews();
    }

    @Override // com.avito.android.component.toggle_list_element.ToggleListElement
    public void setOnOptionSelectedListener(@Nullable Function1<? super String, Unit> function1) {
        this.c = function1;
    }

    @Override // com.avito.android.component.toggle_list_element.ToggleListElement
    public void setTitle(int i) {
        this.a.setText(i);
    }

    @Override // com.avito.android.component.toggle_list_element.ToggleListElement
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a.setText(str);
    }
}
