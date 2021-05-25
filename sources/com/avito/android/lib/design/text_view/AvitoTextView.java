package com.avito.android.lib.design.text_view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.avito.android.lib.design.R;
import com.avito.android.lib.util.inflater.AvitoLayoutInflater;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.text_style.TextStyleData;
import com.avito.android.util.text_style.TextStyleDataProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB1\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\t\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/avito/android/lib/design/text_view/AvitoTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/avito/android/util/text_style/TextStyleDataProvider;", "Lcom/avito/android/util/text_style/TextStyleData;", "getTextStyleData", "()Lcom/avito/android/util/text_style/TextStyleData;", "", "resId", "", "setTextAppearance", "(I)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;I)V", AuthSource.SEND_ABUSE, "()V", "Landroid/util/AttributeSet;", "attrs", "defStyleRes", AuthSource.BOOKING_ORDER, "(Landroid/util/AttributeSet;I)Lcom/avito/android/util/text_style/TextStyleData;", "e", "Lcom/avito/android/util/text_style/TextStyleData;", "textStyleData", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"CustomViewStyleable"})
public class AvitoTextView extends AppCompatTextView implements TextStyleDataProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final AvitoLayoutInflater.FactoryData f;
    public TextStyleData e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/lib/design/text_view/AvitoTextView$Companion;", "", "Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;", "factory", "Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;", "getFactory", "()Lcom/avito/android/lib/util/inflater/AvitoLayoutInflater$FactoryData;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final AvitoLayoutInflater.FactoryData getFactory() {
            return AvitoTextView.f;
        }

        public Companion(j jVar) {
        }
    }

    static {
        AvitoLayoutInflater avitoLayoutInflater = AvitoLayoutInflater.INSTANCE;
        f = avitoLayoutInflater.create(avitoLayoutInflater.getTEXT_VIEW(), a.g);
    }

    @JvmOverloads
    public AvitoTextView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public AvitoTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public AvitoTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AvitoTextView(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 16842884 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public final void a() {
        Integer lineHeight = this.e.getLineHeight();
        if (lineHeight != null) {
            setLineHeight(lineHeight.intValue());
        }
    }

    @SuppressLint({"CustomColorsKotlin"})
    public final TextStyleData b(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TextView, 0, i);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.TextView_linkStyle, 0);
        int i2 = R.styleable.TextView_lineHeight;
        Integer num = null;
        Integer valueOf = obtainStyledAttributes.hasValue(i2) ? Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(i2, 0)) : null;
        int i3 = R.styleable.TextView_paragraphSpacing;
        Integer valueOf2 = obtainStyledAttributes.hasValue(i3) ? Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(i3, 0)) : null;
        int i4 = R.styleable.TextView_android_textColorLink;
        if (obtainStyledAttributes.hasValue(i4)) {
            num = Integer.valueOf(obtainStyledAttributes.getColor(i4, 0));
        }
        obtainStyledAttributes.recycle();
        return new TextStyleData(resourceId, valueOf, valueOf2, num);
    }

    @Override // com.avito.android.util.text_style.TextStyleDataProvider
    @NotNull
    public TextStyleData getTextStyleData() {
        return this.e;
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        this.e = b(null, i);
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AvitoTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = b(null, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextView, i, i2);
        this.e = b(attributeSet, obtainStyledAttributes.getResourceId(R.styleable.TextView_android_textAppearance, 0));
        a();
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@Nullable Context context, int i) {
        super.setTextAppearance(context, i);
        this.e = b(null, i);
        a();
    }
}
