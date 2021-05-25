package com.avito.android.lib.util.inflater;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.text_view.AvitoTextView;
import com.avito.android.lib.util.inflater.AvitoLayoutInflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ3\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/lib/util/inflater/AvitoLayoutInflaterFactory;", "Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$Factory;", "Landroid/view/View;", "parent", "", "name", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "onCreateView", "(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoLayoutInflaterFactory implements AvitoLayoutInflater.Factory {
    @Override // com.avito.android.lib.util.inflater.AvitoLayoutInflater.Factory, android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NotNull String str, @NotNull Context context, @NotNull AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        return AvitoLayoutInflater.Factory.DefaultImpls.onCreateView(this, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View view, @NotNull String str, @NotNull Context context, @NotNull AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        AvitoLayoutInflater avitoLayoutInflater = AvitoLayoutInflater.INSTANCE;
        if (Intrinsics.areEqual(str, avitoLayoutInflater.getAVITO_BUTTON())) {
            return Button.Companion.getFactory().onCreateView(view, str, context, attributeSet);
        }
        if (Intrinsics.areEqual(str, avitoLayoutInflater.getINPUT())) {
            return Input.Companion.getFactory().onCreateView(view, str, context, attributeSet);
        }
        if (Intrinsics.areEqual(str, avitoLayoutInflater.getTEXT_VIEW())) {
            return AvitoTextView.Companion.getFactory().onCreateView(view, str, context, attributeSet);
        }
        return null;
    }
}
