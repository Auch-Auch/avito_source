package com.avito.android.blueprints.publish;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.item_temporary.R;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.InputExtensionsKt;
import com.avito.android.lib.design.input.InputField;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.category_parameters.TextParameterDisplayingType;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.Keyboards;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010V\u001a\u00020<¢\u0006\u0004\bW\u0010XJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0007J\u0019\u0010\u0014\u001a\u00020\u00052\b\b\u0001\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ#\u0010\"\u001a\u00020\u00052\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010\u001eJ#\u0010%\u001a\u00020\u00052\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050 H\u0016¢\u0006\u0004\b%\u0010#J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u001eJ\u0017\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010\u001eJ\u0017\u0010,\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b,\u0010*J\u000f\u0010-\u001a\u00020\u0005H\u0016¢\u0006\u0004\b-\u0010\u001eJ\u001d\u0010/\u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050.H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0019H\u0016¢\u0006\u0004\b2\u0010\u001cJ\u000f\u00103\u001a\u00020\u0005H\u0016¢\u0006\u0004\b3\u0010\u001eR\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001e\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010AR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010>¨\u0006Y"}, d2 = {"Lcom/avito/android/blueprints/publish/VehicleRegNumberInputViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/blueprints/publish/VehicleRegNumberInputItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "message", "setErrorState", "(Ljava/lang/CharSequence;)V", "setWarningState", "setNormalState", "number", "setNumber", "region", "setRegion", "", "colorRes", "setBackgroundColor", "(I)V", "Lcom/avito/android/remote/model/Color;", "color", "(Lcom/avito/android/remote/model/Color;)V", "", "isEmpty", "setIsEmpty", "(Z)V", "showKeyboardForNumber", "()V", "showKeyboardForRegion", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnNumberChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "removeOnNumberChangedListener", "setOnRegionChangedListener", "removeOnRegionChangedListener", "Landroid/text/TextWatcher;", "textWatcher", "setNumberTextWatcher", "(Landroid/text/TextWatcher;)V", "removeNumberTextWatcher", "setRegionTextWatcher", "removeRegionTextWatcher", "Lkotlin/Function0;", "setOnUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "enabled", "setEnabled", "onUnbind", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "s", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "container", "Landroid/view/ViewGroup;", "t", "Landroid/view/ViewGroup;", TextParameterDisplayingType.TYPE_VEHICLE_REG_NUMBER, "Landroid/view/View;", "x", "Landroid/view/View;", "divider", "z", "Landroid/text/TextWatcher;", "regionTextWatcher", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlin/jvm/functions/Function0;", "unbindListener", "Lcom/avito/android/blueprints/publish/RestrictedSelectionEditText;", "u", "Lcom/avito/android/blueprints/publish/RestrictedSelectionEditText;", "numberInput", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "y", "numberTextWatcher", "Lcom/avito/android/lib/design/input/InputField;", VKApiConst.VERSION, "Lcom/avito/android/lib/design/input/InputField;", "regionInput", "w", "border", "view", "<init>", "(Landroid/view/View;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class VehicleRegNumberInputViewHolder extends BaseViewHolder implements VehicleRegNumberInputItemView {
    public Function0<Unit> A;
    public final ComponentContainer s;
    public final ViewGroup t;
    public final RestrictedSelectionEditText u;
    public final InputField v;
    public final View w;
    public final View x;
    public TextWatcher y;
    public TextWatcher z;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                Keyboards.showKeyboard$default(((VehicleRegNumberInputViewHolder) this.b).u, 0, 1, null);
            } else if (i == 1) {
                Keyboards.showKeyboard$default(((VehicleRegNumberInputViewHolder) this.b).v, 0, 1, null);
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function1 function1) {
            super(1);
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.a.invoke(str2);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Function1 function1) {
            super(1);
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.a.invoke(str2);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VehicleRegNumberInputViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.component_container.ComponentContainer");
        ComponentContainer componentContainer = (ComponentContainer) findViewById;
        this.s = componentContainer;
        View findViewById2 = componentContainer.findViewById(R.id.vehicle_reg_number);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        this.t = viewGroup;
        View findViewById3 = viewGroup.findViewById(R.id.number);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.blueprints.publish.RestrictedSelectionEditText");
        this.u = (RestrictedSelectionEditText) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.region);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.input.InputField");
        this.v = (InputField) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.border);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.w = findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.divider);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.x = findViewById6;
        view.findViewById(R.id.number_container).setOnClickListener(new a(0, this));
        view.findViewById(R.id.region_container).setOnClickListener(new a(1, this));
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    @NotNull
    public Context getContext() {
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        return context;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.A;
        if (function0 != null) {
            function0.invoke();
        }
        this.A = null;
        removeNumberTextWatcher();
        removeRegionTextWatcher();
        Keyboards.hideKeyboard$default(this.s, false, 1, null);
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void removeNumberTextWatcher() {
        RestrictedSelectionEditText restrictedSelectionEditText = this.u;
        TextWatcher textWatcher = this.y;
        if (textWatcher != null) {
            restrictedSelectionEditText.removeTextChangedListener(textWatcher);
        }
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void removeOnNumberChangedListener() {
        removeNumberTextWatcher();
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void removeOnRegionChangedListener() {
        removeRegionTextWatcher();
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void removeRegionTextWatcher() {
        InputField inputField = this.v;
        TextWatcher textWatcher = this.z;
        if (textWatcher != null) {
            inputField.removeTextChangedListener(textWatcher);
        }
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setBackgroundColor(@ColorRes int i) {
        setBackgroundColor(new Color(ContextCompat.getColor(getContext(), i)));
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setEnabled(boolean z2) {
        if (!z2) {
            setNumber(null);
            setRegion(null);
            setIsEmpty(true);
            setBackgroundColor(com.avito.android.lib.design.avito.R.color.expected_avito_constant_gray_2);
        }
        this.s.setEnabled(z2);
        this.u.setEnabled(z2);
        this.v.setEnabled(z2);
        this.u.setFocusable(z2);
        this.v.setFocusable(z2);
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setErrorState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showErrorForAll$default(this.s, charSequence, null, 2, null);
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setIsEmpty(boolean z2) {
        int i;
        Drawable mutate;
        Drawable drawable = getContext().getDrawable(R.drawable.border_vehicle_reg_number);
        Context context = getContext();
        if (z2) {
            i = com.avito.android.lib.design.avito.R.color.expected_avito_constant_gray_12;
        } else {
            i = com.avito.android.lib.design.avito.R.color.expected_avito_constant_gray_76;
        }
        ColorStateList colorStateList = ContextCompat.getColorStateList(context, i);
        this.w.setBackground((drawable == null || (mutate = drawable.mutate()) == null) ? null : DrawablesKt.wrapForTinting(mutate, colorStateList));
        Drawable mutate2 = this.x.getBackground().mutate();
        Intrinsics.checkNotNullExpressionValue(mutate2, "divider.background.mutate()");
        DrawablesKt.wrapForTinting(mutate2, colorStateList);
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setNormalState(@Nullable CharSequence charSequence) {
        this.s.showNormalForAll(charSequence);
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setNumber(@Nullable String str) {
        this.u.setText(str);
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setNumberTextWatcher(@NotNull TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "textWatcher");
        this.y = textWatcher;
        this.u.addTextChangedListener(textWatcher);
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setOnNumberChangedListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.y = InputExtensionsKt.addTextChangedListener(this.u, new b(function1));
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setOnRegionChangedListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.z = InputExtensionsKt.addTextChangedListener(this.v, new c(function1));
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setOnUnbindListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.A = function0;
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setRegion(@Nullable String str) {
        this.v.setText(str);
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setRegionTextWatcher(@NotNull TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "textWatcher");
        this.z = textWatcher;
        this.v.addTextChangedListener(textWatcher);
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setWarningState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showWarningForAll$default(this.s, charSequence, null, 2, null);
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void showKeyboardForNumber() {
        this.u.requestFocus();
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void showKeyboardForRegion() {
        this.v.requestFocus();
    }

    @Override // com.avito.android.blueprints.publish.VehicleRegNumberInputItemView
    public void setBackgroundColor(@NotNull Color color) {
        Drawable mutate;
        Intrinsics.checkNotNullParameter(color, "color");
        Drawable drawable = getContext().getDrawable(R.drawable.background_vehicle_reg_number);
        this.t.setBackground((drawable == null || (mutate = drawable.mutate()) == null) ? null : DrawablesKt.wrapForTinting(mutate, color.getValue()));
    }
}
