package a2.j.b.d.s;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.textfield.TextInputLayout;
public class a extends m {
    public final TextWatcher d = new C0046a();
    public final View.OnFocusChangeListener e = new b();
    public final TextInputLayout.OnEditTextAttachedListener f = new c();
    public final TextInputLayout.OnEndIconChangedListener g = new d();
    public AnimatorSet h;
    public ValueAnimator i;

    /* renamed from: a2.j.b.d.s.a$a  reason: collision with other inner class name */
    public class C0046a implements TextWatcher {
        public C0046a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            if (a.this.a.getSuffixText() == null) {
                a.this.e(editable.length() > 0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            boolean z2 = true;
            boolean z3 = !TextUtils.isEmpty(((EditText) view).getText());
            a aVar = a.this;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.e(z2);
        }
    }

    public class c implements TextInputLayout.OnEditTextAttachedListener {
        public c() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
            if ((r0.getText().length() > 0) != false) goto L_0x001d;
         */
        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onEditTextAttached(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout r5) {
            /*
                r4 = this;
                android.widget.EditText r0 = r5.getEditText()
                boolean r1 = r0.hasFocus()
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L_0x001c
                android.text.Editable r1 = r0.getText()
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0018
                r1 = 1
                goto L_0x0019
            L_0x0018:
                r1 = 0
            L_0x0019:
                if (r1 == 0) goto L_0x001c
                goto L_0x001d
            L_0x001c:
                r2 = 0
            L_0x001d:
                r5.setEndIconVisible(r2)
                r5.setEndIconCheckable(r3)
                a2.j.b.d.s.a r5 = a2.j.b.d.s.a.this
                android.view.View$OnFocusChangeListener r5 = r5.e
                r0.setOnFocusChangeListener(r5)
                a2.j.b.d.s.a r5 = a2.j.b.d.s.a.this
                android.text.TextWatcher r5 = r5.d
                r0.removeTextChangedListener(r5)
                a2.j.b.d.s.a r5 = a2.j.b.d.s.a.this
                android.text.TextWatcher r5 = r5.d
                r0.addTextChangedListener(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.b.d.s.a.c.onEditTextAttached(com.google.android.material.textfield.TextInputLayout):void");
        }
    }

    public class d implements TextInputLayout.OnEndIconChangedListener {

        /* renamed from: a2.j.b.d.s.a$d$a  reason: collision with other inner class name */
        public class RunnableC0047a implements Runnable {
            public final /* synthetic */ EditText a;

            public RunnableC0047a(EditText editText) {
                this.a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.removeTextChangedListener(a.this.d);
            }
        }

        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i == 2) {
                editText.post(new RunnableC0047a(editText));
                if (editText.getOnFocusChangeListener() == a.this.e) {
                    editText.setOnFocusChangeListener(null);
                }
            }
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.a.refreshEndIconDrawableState();
        }
    }

    public a(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // a2.j.b.d.s.m
    public void a() {
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, R.drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.a.setEndIconOnClickListener(new e());
        this.a.addOnEditTextAttachedListener(this.f);
        this.a.addOnEndIconChangedListener(this.g);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new e(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(100L);
        ofFloat2.addUpdateListener(new d(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.h = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.h.addListener(new b(this));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration(100L);
        ofFloat3.addUpdateListener(new d(this));
        this.i = ofFloat3;
        ofFloat3.addListener(new c(this));
    }

    @Override // a2.j.b.d.s.m
    public void c(boolean z) {
        if (this.a.getSuffixText() != null) {
            e(z);
        }
    }

    public final void e(boolean z) {
        boolean z2 = this.a.isEndIconVisible() == z;
        if (z && !this.h.isRunning()) {
            this.i.cancel();
            this.h.start();
            if (z2) {
                this.h.end();
            }
        } else if (!z) {
            this.h.cancel();
            this.i.start();
            if (z2) {
                this.i.end();
            }
        }
    }
}
