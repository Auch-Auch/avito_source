package ru.avito.component.shortcut_navigation_bar.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation_bar.adapter.RubricatorItemView;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorItemViewImpl;", "Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorCategory;", "category", "", "text", "", "setContent", "(Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorCategory;Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "title", "", VKApiConst.VERSION, "Z", "withLargeIcon", "Landroid/view/View;", "u", "Landroid/view/View;", "view", "Landroid/widget/ImageView;", "t", "Landroid/widget/ImageView;", "icon", "<init>", "(Landroid/view/View;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class RubricatorItemViewImpl extends BaseViewHolder implements RubricatorItemView {
    public final TextView s;
    public final ImageView t;
    public final View u;
    public final boolean v;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RubricatorItemViewImpl(@NotNull View view, boolean z) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = view;
        this.v = z;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.t = (ImageView) findViewById2;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        RubricatorItemView.DefaultImpls.onUnbind(this);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.adapter.RubricatorItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.u.setOnClickListener(new a(function0));
    }

    @Override // ru.avito.component.shortcut_navigation_bar.adapter.RubricatorItemView
    public void setContent(@NotNull RubricatorCategory rubricatorCategory, @NotNull String str) {
        int i;
        Intrinsics.checkNotNullParameter(rubricatorCategory, "category");
        Intrinsics.checkNotNullParameter(str, "text");
        if (this.v) {
            i = rubricatorCategory.getLargeIconResId();
        } else {
            i = rubricatorCategory.getSmallIconResId();
        }
        ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = null;
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams3 != null && this.v) {
            layoutParams2 = layoutParams3;
        }
        if (i > 0) {
            if (layoutParams2 != null) {
                layoutParams2.gravity = 48;
            }
            ImageView imageView = this.t;
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), i));
            Views.show(this.t);
        } else {
            if (layoutParams2 != null) {
                layoutParams2.gravity = 17;
            }
            Views.hide(this.t);
        }
        this.s.setText(str);
    }
}
