package com.avito.android.theme_settings.item.theme_checkmark;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.lib.design.toggle.Checkmark;
import com.avito.android.settings.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u001d\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/theme_settings/item/theme_checkmark/ThemeCheckmarkItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/theme_settings/item/theme_checkmark/ThemeCheckmarkItemView;", "", "checked", "", "setChecked", "(Z)V", "enabled", "setEnabled", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "view", "Lcom/avito/android/lib/design/toggle/Checkmark;", "u", "Lcom/avito/android/lib/design/toggle/Checkmark;", "checkmarkView", "Landroid/widget/ImageView;", "t", "Landroid/widget/ImageView;", "imageView", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "<init>", "(Landroid/view/View;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class ThemeCheckmarkItemViewImpl extends BaseViewHolder implements ThemeCheckmarkItemView {
    public final TextView s;
    public final ImageView t;
    public final Checkmark u;
    public final View v;

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
    public ThemeCheckmarkItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.v = view;
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.image)");
        this.t = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.checkmark);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.checkmark)");
        this.u = (Checkmark) findViewById3;
    }

    @Override // com.avito.android.theme_settings.item.theme_checkmark.ThemeCheckmarkItemView
    public void setChecked(boolean z) {
        this.u.setChecked(z);
    }

    @Override // com.avito.android.theme_settings.item.theme_checkmark.ThemeCheckmarkItemView
    public void setEnabled(boolean z) {
        this.s.setEnabled(z);
        this.t.setEnabled(z);
        this.u.setEnabled(z);
        this.v.setEnabled(z);
        this.v.setAlpha(z ? 1.0f : 0.4f);
    }

    @Override // com.avito.android.theme_settings.item.theme_checkmark.ThemeCheckmarkItemView
    public void setImage(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.t.setImageDrawable(drawable);
    }

    @Override // com.avito.android.theme_settings.item.theme_checkmark.ThemeCheckmarkItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.theme_settings.item.theme_checkmark.ThemeCheckmarkItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }
}
