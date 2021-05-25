package com.sumsub.sns.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.sumsub.sns.core.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSAutoCompleteTextView;", "Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;", "", "enoughToFilter", "()Z", "", "showDropDown", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SNSAutoCompleteTextView extends MaterialAutoCompleteTextView {
    @JvmOverloads
    public SNSAutoCompleteTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public SNSAutoCompleteTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSAutoCompleteTextView(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.sns_SNSAutoCompleteTextViewStyle : i);
    }

    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        return true;
    }

    @Override // com.google.android.material.textfield.MaterialAutoCompleteTextView, android.widget.AutoCompleteTextView
    public void showDropDown() {
        postDelayed(new Runnable(this) { // from class: com.sumsub.sns.core.widget.SNSAutoCompleteTextView$showDropDown$$inlined$postDelayed$1
            public final /* synthetic */ SNSAutoCompleteTextView a;

            {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SNSAutoCompleteTextView.access$showDropDown$s1957764882(this.a);
            }
        }, 200);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SNSAutoCompleteTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
