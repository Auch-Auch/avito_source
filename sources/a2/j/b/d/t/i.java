package a2.j.b.d.t;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.timepicker.ChipTextInputComboView;
public class i implements TextView.OnEditorActionListener, View.OnKeyListener {
    public final ChipTextInputComboView a;
    public final ChipTextInputComboView b;
    public final f c;
    public boolean d = false;

    public i(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, f fVar) {
        this.a = chipTextInputComboView;
        this.b = chipTextInputComboView2;
        this.c = fVar;
    }

    public final void a(int i) {
        boolean z = true;
        this.b.setChecked(i == 12);
        ChipTextInputComboView chipTextInputComboView = this.a;
        if (i != 10) {
            z = false;
        }
        chipTextInputComboView.setChecked(z);
        this.c.f = i;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z = i == 5;
        if (z) {
            a(12);
        }
        return z;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.d) {
            return false;
        }
        boolean z = true;
        this.d = true;
        EditText editText = (EditText) view;
        if (this.c.f == 12) {
            if (i == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
                a(10);
                this.d = false;
                return z;
            }
        } else {
            Editable text = editText.getText();
            if (text != null) {
                if (i >= 7 && i <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
                    a(12);
                    this.d = false;
                    return z;
                }
            }
        }
        z = false;
        this.d = false;
        return z;
    }
}
