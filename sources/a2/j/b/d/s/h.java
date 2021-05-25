package a2.j.b.d.s;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Objects;
public class h extends m {
    public final TextWatcher d = new a();
    public final View.OnFocusChangeListener e = new b();
    public final TextInputLayout.AccessibilityDelegate f = new c(this.a);
    public final TextInputLayout.OnEditTextAttachedListener g = new d();
    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.OnEndIconChangedListener h = new e();
    public boolean i = false;
    public boolean j = false;
    public long k = Long.MAX_VALUE;
    public StateListDrawable l;
    public MaterialShapeDrawable m;
    @Nullable
    public AccessibilityManager n;
    public ValueAnimator o;
    public ValueAnimator p;

    public class a extends TextWatcherAdapter {

        /* renamed from: a2.j.b.d.s.h$a$a  reason: collision with other inner class name */
        public class RunnableC0048a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView a;

            public RunnableC0048a(AutoCompleteTextView autoCompleteTextView) {
                this.a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.a.isPopupShowing();
                h.g(h.this, isPopupShowing);
                h.this.i = isPopupShowing;
            }
        }

        public a() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView e = h.e(h.this.a.getEditText());
            if (h.this.n.isTouchExplorationEnabled() && h.f(e) && !h.this.c.hasFocus()) {
                e.dismissDropDown();
            }
            e.post(new RunnableC0048a(e));
        }
    }

    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            h.this.a.setEndIconActivated(z);
            if (!z) {
                h.g(h.this, false);
                h.this.i = false;
            }
        }
    }

    public class c extends TextInputLayout.AccessibilityDelegate {
        public c(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!h.f(h.this.a.getEditText())) {
                accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
            }
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView e2 = h.e(h.this.a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && h.this.n.isTouchExplorationEnabled() && !h.f(h.this.a.getEditText())) {
                h.h(h.this, e2);
            }
        }
    }

    public class d implements TextInputLayout.OnEditTextAttachedListener {
        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
            AutoCompleteTextView e = h.e(textInputLayout.getEditText());
            h hVar = h.this;
            int boxBackgroundMode = hVar.a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                e.setDropDownBackgroundDrawable(hVar.m);
            } else if (boxBackgroundMode == 1) {
                e.setDropDownBackgroundDrawable(hVar.l);
            }
            h hVar2 = h.this;
            Objects.requireNonNull(hVar2);
            boolean z = false;
            if (!(e.getKeyListener() != null)) {
                int boxBackgroundMode2 = hVar2.a.getBoxBackgroundMode();
                MaterialShapeDrawable boxBackground = hVar2.a.getBoxBackground();
                int color = MaterialColors.getColor(e, R.attr.colorControlHighlight);
                int[][] iArr = {new int[]{16842919}, new int[0]};
                if (boxBackgroundMode2 == 2) {
                    int color2 = MaterialColors.getColor(e, R.attr.colorSurface);
                    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(boxBackground.getShapeAppearanceModel());
                    int layer = MaterialColors.layer(color, color2, 0.1f);
                    materialShapeDrawable.setFillColor(new ColorStateList(iArr, new int[]{layer, 0}));
                    materialShapeDrawable.setTint(color2);
                    ColorStateList colorStateList = new ColorStateList(iArr, new int[]{layer, color2});
                    MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(boxBackground.getShapeAppearanceModel());
                    materialShapeDrawable2.setTint(-1);
                    ViewCompat.setBackground(e, new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable, materialShapeDrawable2), boxBackground}));
                } else if (boxBackgroundMode2 == 1) {
                    int boxBackgroundColor = hVar2.a.getBoxBackgroundColor();
                    ViewCompat.setBackground(e, new RippleDrawable(new ColorStateList(iArr, new int[]{MaterialColors.layer(color, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground));
                }
            }
            h hVar3 = h.this;
            Objects.requireNonNull(hVar3);
            e.setOnTouchListener(new j(hVar3, e));
            e.setOnFocusChangeListener(hVar3.e);
            e.setOnDismissListener(new k(hVar3));
            e.setThreshold(0);
            e.removeTextChangedListener(h.this.d);
            e.addTextChangedListener(h.this.d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (e.getKeyListener() != null) {
                z = true;
            }
            if (!z) {
                ViewCompat.setImportantForAccessibility(h.this.c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(h.this.f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    public class e implements TextInputLayout.OnEndIconChangedListener {

        public class a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView a;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.removeTextChangedListener(h.this.d);
            }
        }

        public e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i == 3) {
                autoCompleteTextView.post(new a(autoCompleteTextView));
                if (autoCompleteTextView.getOnFocusChangeListener() == h.this.e) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.h(h.this, (AutoCompleteTextView) h.this.a.getEditText());
        }
    }

    public h(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static AutoCompleteTextView e(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public static boolean f(EditText editText) {
        return editText.getKeyListener() != null;
    }

    public static void g(h hVar, boolean z) {
        if (hVar.j != z) {
            hVar.j = z;
            hVar.p.cancel();
            hVar.o.start();
        }
    }

    public static void h(h hVar, AutoCompleteTextView autoCompleteTextView) {
        Objects.requireNonNull(hVar);
        if (autoCompleteTextView != null) {
            if (hVar.j()) {
                hVar.i = false;
            }
            if (!hVar.i) {
                boolean z = hVar.j;
                boolean z2 = !z;
                if (z != z2) {
                    hVar.j = z2;
                    hVar.p.cancel();
                    hVar.o.start();
                }
                if (hVar.j) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            hVar.i = false;
        }
    }

    @Override // a2.j.b.d.s.m
    public void a() {
        float dimensionPixelOffset = (float) this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = (float) this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable i2 = i(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable i3 = i(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.m = i2;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.l = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, i2);
        this.l.addState(new int[0], i3);
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, R.drawable.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new f());
        this.a.addOnEditTextAttachedListener(this.g);
        this.a.addOnEndIconChangedListener(this.h);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration((long) 67);
        ofFloat.addUpdateListener(new i(this));
        this.p = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration((long) 50);
        ofFloat2.addUpdateListener(new i(this));
        this.o = ofFloat2;
        ofFloat2.addListener(new l(this));
        this.n = (AccessibilityManager) this.b.getSystemService("accessibility");
    }

    @Override // a2.j.b.d.s.m
    public boolean b(int i2) {
        return i2 != 0;
    }

    @Override // a2.j.b.d.s.m
    public boolean d() {
        return true;
    }

    public final MaterialShapeDrawable i(float f2, float f3, float f4, int i2) {
        ShapeAppearanceModel build = ShapeAppearanceModel.builder().setTopLeftCornerSize(f2).setTopRightCornerSize(f2).setBottomLeftCornerSize(f3).setBottomRightCornerSize(f3).build();
        MaterialShapeDrawable createWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(this.b, f4);
        createWithElevationOverlay.setShapeAppearanceModel(build);
        createWithElevationOverlay.setPadding(0, i2, 0, i2);
        return createWithElevationOverlay;
    }

    public final boolean j() {
        long currentTimeMillis = System.currentTimeMillis() - this.k;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }
}
