package com.avito.android.lib.util.inflater;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.avito.android.lib.util.inflater.AvitoLayoutInflater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/avito/android/lib/util/inflater/AvitoLayoutInflater$Factory$Companion$invoke$1", "Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$Factory;", "Landroid/view/View;", "parent", "", "name", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "onCreateView", "(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", "components_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoLayoutInflater$Factory$Companion$invoke$1 implements AvitoLayoutInflater.Factory {
    public final /* synthetic */ Function4 $func;

    public AvitoLayoutInflater$Factory$Companion$invoke$1(Function4 function4) {
        this.$func = function4;
    }

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
        return (View) this.$func.invoke(view, str, context, attributeSet);
    }
}
