package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.TypedArrayUtils;
public abstract class DialogPreference extends Preference {
    public CharSequence R;
    public CharSequence S;
    public Drawable T;
    public CharSequence U;
    public CharSequence V;
    public int W;

    public interface TargetFragment {
        @Nullable
        <T extends Preference> T findPreference(@NonNull CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DialogPreference, i, i2);
        String string = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.DialogPreference_dialogTitle, R.styleable.DialogPreference_android_dialogTitle);
        this.R = string;
        if (string == null) {
            this.R = getTitle();
        }
        this.S = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.DialogPreference_dialogMessage, R.styleable.DialogPreference_android_dialogMessage);
        this.T = TypedArrayUtils.getDrawable(obtainStyledAttributes, R.styleable.DialogPreference_dialogIcon, R.styleable.DialogPreference_android_dialogIcon);
        this.U = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.DialogPreference_positiveButtonText, R.styleable.DialogPreference_android_positiveButtonText);
        this.V = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.DialogPreference_negativeButtonText, R.styleable.DialogPreference_android_negativeButtonText);
        this.W = TypedArrayUtils.getResourceId(obtainStyledAttributes, R.styleable.DialogPreference_dialogLayout, R.styleable.DialogPreference_android_dialogLayout, 0);
        obtainStyledAttributes.recycle();
    }

    public Drawable getDialogIcon() {
        return this.T;
    }

    public int getDialogLayoutResource() {
        return this.W;
    }

    public CharSequence getDialogMessage() {
        return this.S;
    }

    public CharSequence getDialogTitle() {
        return this.R;
    }

    public CharSequence getNegativeButtonText() {
        return this.V;
    }

    public CharSequence getPositiveButtonText() {
        return this.U;
    }

    @Override // androidx.preference.Preference
    public void onClick() {
        getPreferenceManager().showDialog(this);
    }

    public void setDialogIcon(Drawable drawable) {
        this.T = drawable;
    }

    public void setDialogLayoutResource(int i) {
        this.W = i;
    }

    public void setDialogMessage(CharSequence charSequence) {
        this.S = charSequence;
    }

    public void setDialogTitle(CharSequence charSequence) {
        this.R = charSequence;
    }

    public void setNegativeButtonText(CharSequence charSequence) {
        this.V = charSequence;
    }

    public void setPositiveButtonText(CharSequence charSequence) {
        this.U = charSequence;
    }

    public void setDialogIcon(int i) {
        this.T = AppCompatResources.getDrawable(getContext(), i);
    }

    public void setDialogMessage(int i) {
        setDialogMessage(getContext().getString(i));
    }

    public void setDialogTitle(int i) {
        setDialogTitle(getContext().getString(i));
    }

    public void setNegativeButtonText(int i) {
        setNegativeButtonText(getContext().getString(i));
    }

    public void setPositiveButtonText(int i) {
        setPositiveButtonText(getContext().getString(i));
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.dialogPreferenceStyle, 16842897));
    }

    public DialogPreference(Context context) {
        this(context, null);
    }
}
