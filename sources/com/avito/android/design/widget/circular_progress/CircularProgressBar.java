package com.avito.android.design.widget.circular_progress;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.avito.android.design.widget.circular_progress.CircularProgressDrawable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\b\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J&\u0010\u000e\u001a\u00020\u00022\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\b\f¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/avito/android/design/widget/circular_progress/CircularProgressBar;", "Landroid/widget/ProgressBar;", "", "restartProgress", "()V", "Lkotlin/Function1;", "Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "progressiveStop", "(Lkotlin/jvm/functions/Function1;)V", "stop", "Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable$Builder;", "Lkotlin/ExtensionFunctionType;", "updateStatement", "updateDrawable", AuthSource.SEND_ABUSE, "()Lcom/avito/android/design/widget/circular_progress/CircularProgressDrawable;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CircularProgressBar extends ProgressBar {

    public static final class a extends Lambda implements Function1<CircularProgressDrawable, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(CircularProgressDrawable circularProgressDrawable) {
            Intrinsics.checkNotNullParameter(circularProgressDrawable, "it");
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    public CircularProgressBar(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public CircularProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CircularProgressBar(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.cpbStyle : i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.design.widget.circular_progress.CircularProgressBar */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void progressiveStop$default(CircularProgressBar circularProgressBar, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = a.a;
        }
        circularProgressBar.progressiveStop(function1);
    }

    public final CircularProgressDrawable a() {
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null && (indeterminateDrawable instanceof CircularProgressDrawable)) {
            return (CircularProgressDrawable) indeterminateDrawable;
        }
        throw new RuntimeException("The drawable is not a CircularProgressDrawable");
    }

    public final void progressiveStop(@NotNull Function1<? super CircularProgressDrawable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        a().progressiveStop(function1);
    }

    public final void restartProgress() {
        a().start();
    }

    public final void stop() {
        a().stop();
    }

    public final void updateDrawable(@NotNull Function1<? super CircularProgressDrawable.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "updateStatement");
        CircularProgressDrawable a3 = a();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        CircularProgressDrawable.Builder newBuilder = a3.newBuilder(context, isInEditMode());
        function1.invoke(newBuilder);
        CircularProgressDrawable build = newBuilder.build();
        build.setBounds(a3.getBounds());
        setIndeterminateDrawable(build);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CircularProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        if (isInEditMode()) {
            setIndeterminateDrawable(new CircularProgressDrawable.Builder(context, true).build());
            return;
        }
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircularProgressBar, i, R.style.Widget_Avito_CircularProgressBar_Light);
        try {
            int color = obtainStyledAttributes.getColor(R.styleable.CircularProgressBar_cpb_color, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.white));
            float dimension = obtainStyledAttributes.getDimension(R.styleable.CircularProgressBar_cpb_stroke_width, resources.getDimension(R.dimen.cpb_default_stroke_width));
            int i2 = R.styleable.CircularProgressBar_cpb_sweep_speed;
            String string = resources.getString(R.string.cpb_default_sweep_speed);
            Intrinsics.checkNotNullExpressionValue(string, "res.getString(R.string.cpb_default_sweep_speed)");
            float f = obtainStyledAttributes.getFloat(i2, Float.parseFloat(string));
            int i3 = R.styleable.CircularProgressBar_cpb_rotation_speed;
            String string2 = resources.getString(R.string.cpb_default_rotation_speed);
            Intrinsics.checkNotNullExpressionValue(string2, "res.getString(R.string.cpb_default_rotation_speed)");
            float f2 = obtainStyledAttributes.getFloat(i3, Float.parseFloat(string2));
            boolean z = false;
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CircularProgressBar_cpb_colors, 0);
            int integer = obtainStyledAttributes.getInteger(R.styleable.CircularProgressBar_cpb_min_sweep_angle, resources.getInteger(R.integer.cpb_default_min_sweep_angle));
            int integer2 = obtainStyledAttributes.getInteger(R.styleable.CircularProgressBar_cpb_max_sweep_angle, resources.getInteger(R.integer.cpb_default_max_sweep_angle));
            int[] intArray = resourceId != 0 ? resources.getIntArray(resourceId) : null;
            CircularProgressDrawable.Builder maxSweepAngle = new CircularProgressDrawable.Builder(context, false, 2, null).sweepSpeed(f).rotationSpeed(f2).strokeWidth(dimension).minSweepAngle(integer).maxSweepAngle(integer2);
            if (intArray != null) {
                if (true ^ (intArray.length == 0 ? true : z)) {
                    maxSweepAngle.colors(intArray);
                    setIndeterminateDrawable(maxSweepAngle.build());
                }
            }
            maxSweepAngle.color(color);
            setIndeterminateDrawable(maxSweepAngle.build());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
