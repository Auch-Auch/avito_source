package com.avito.android.search.filter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.avito.android.component.check_box.CheckBox;
import com.avito.android.component.check_box.CheckBoxImpl;
import com.avito.android.search.filter.R;
import com.avito.android.search.filter.adapter.InlineMultiselectItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ3\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/avito/android/search/filter/adapter/InlineMultiselectItemViewImpl;", "Lcom/avito/android/search/filter/adapter/InlineMultiselectItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "removeOptions", "()V", "", "isChecked", "Lkotlin/Function1;", "checkListener", "addOption", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "Lru/avito/component/text/Text;", "s", "Lru/avito/component/text/Text;", "Landroid/widget/LinearLayout;", "t", "Landroid/widget/LinearLayout;", "container", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "u", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class InlineMultiselectItemViewImpl extends BaseViewHolder implements InlineMultiselectItemView {
    public final Text s;
    public final LinearLayout t;
    public final LayoutInflater u;

    public static final class a extends Lambda implements Function2<CheckBox, Boolean, Unit> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, boolean z, Function1 function1) {
            super(2);
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(CheckBox checkBox, Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(checkBox, "<anonymous parameter 0>");
            this.a.invoke(Boolean.valueOf(booleanValue));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InlineMultiselectItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.s = new TextImpl(findViewById);
        View findViewById2 = view.findViewById(R.id.container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.t = (LinearLayout) findViewById2;
        this.u = LayoutInflater.from(view.getContext());
    }

    @Override // com.avito.android.search.filter.adapter.InlineMultiselectItemView
    public void addOption(@NotNull String str, boolean z, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function1, "checkListener");
        View inflate = this.u.inflate(com.avito.android.ui_components.R.layout.check_box, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        CheckBoxImpl checkBoxImpl = new CheckBoxImpl(inflate, false, 2, null);
        checkBoxImpl.setTitle(str);
        checkBoxImpl.setChecked(z);
        checkBoxImpl.setOnCheckedChangeListener(new a(str, z, function1));
        this.t.addView(inflate);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        InlineMultiselectItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.search.filter.adapter.InlineMultiselectItemView
    public void removeOptions() {
        this.t.removeAllViews();
    }

    @Override // com.avito.android.search.filter.adapter.InlineMultiselectItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }
}
