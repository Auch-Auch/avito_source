package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;
public class SeekBarPreference extends Preference {
    public int R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    public SeekBar W;
    public TextView X;
    public boolean Y;
    public boolean Z;
    public boolean a0;
    public SeekBar.OnSeekBarChangeListener b0;
    public View.OnKeyListener c0;

    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.a0 || !seekBarPreference.V) {
                    seekBarPreference.f(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.g(i + seekBarPreference2.S);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.V = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.V = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.S != seekBarPreference.R) {
                seekBarPreference.f(seekBar);
            }
        }
    }

    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SeekBar seekBar;
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.Y && (i == 21 || i == 22)) || i == 23 || i == 66 || (seekBar = seekBarPreference.W) == null) {
                return false;
            }
            return seekBar.onKeyDown(i, keyEvent);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.b0 = new a();
        this.c0 = new b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SeekBarPreference, i, i2);
        this.S = obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_min, 0);
        setMax(obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_android_max, 100));
        setSeekBarIncrement(obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_seekBarIncrement, 0));
        this.Y = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_adjustable, true);
        this.Z = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_showSeekBarValue, false);
        this.a0 = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_updatesContinuously, false);
        obtainStyledAttributes.recycle();
    }

    public final void e(int i, boolean z) {
        int i2 = this.S;
        if (i < i2) {
            i = i2;
        }
        int i3 = this.T;
        if (i > i3) {
            i = i3;
        }
        if (i != this.R) {
            this.R = i;
            g(i);
            persistInt(i);
            if (z) {
                notifyChanged();
            }
        }
    }

    public void f(SeekBar seekBar) {
        int progress = seekBar.getProgress() + this.S;
        if (progress == this.R) {
            return;
        }
        if (callChangeListener(Integer.valueOf(progress))) {
            e(progress, false);
            return;
        }
        seekBar.setProgress(this.R - this.S);
        g(this.R);
    }

    public void g(int i) {
        TextView textView = this.X;
        if (textView != null) {
            textView.setText(String.valueOf(i));
        }
    }

    public int getMax() {
        return this.T;
    }

    public int getMin() {
        return this.S;
    }

    public final int getSeekBarIncrement() {
        return this.U;
    }

    public boolean getShowSeekBarValue() {
        return this.Z;
    }

    public boolean getUpdatesContinuously() {
        return this.a0;
    }

    public int getValue() {
        return this.R;
    }

    public boolean isAdjustable() {
        return this.Y;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        preferenceViewHolder.itemView.setOnKeyListener(this.c0);
        this.W = (SeekBar) preferenceViewHolder.findViewById(R.id.seekbar);
        TextView textView = (TextView) preferenceViewHolder.findViewById(R.id.seekbar_value);
        this.X = textView;
        if (this.Z) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.X = null;
        }
        SeekBar seekBar = this.W;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(this.b0);
            this.W.setMax(this.T - this.S);
            int i = this.U;
            if (i != 0) {
                this.W.setKeyProgressIncrement(i);
            } else {
                this.U = this.W.getKeyProgressIncrement();
            }
            this.W.setProgress(this.R - this.S);
            g(this.R);
            this.W.setEnabled(isEnabled());
        }
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    @Override // androidx.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable.getClass().equals(c.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.R = cVar.a;
        this.S = cVar.b;
        this.T = cVar.c;
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        c cVar = new c(onSaveInstanceState);
        cVar.a = this.R;
        cVar.b = this.S;
        cVar.c = this.T;
        return cVar;
    }

    @Override // androidx.preference.Preference
    public void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        setValue(getPersistedInt(((Integer) obj).intValue()));
    }

    public void setAdjustable(boolean z) {
        this.Y = z;
    }

    public final void setMax(int i) {
        int i2 = this.S;
        if (i < i2) {
            i = i2;
        }
        if (i != this.T) {
            this.T = i;
            notifyChanged();
        }
    }

    public void setMin(int i) {
        int i2 = this.T;
        if (i > i2) {
            i = i2;
        }
        if (i != this.S) {
            this.S = i;
            notifyChanged();
        }
    }

    public final void setSeekBarIncrement(int i) {
        if (i != this.U) {
            this.U = Math.min(this.T - this.S, Math.abs(i));
            notifyChanged();
        }
    }

    public void setShowSeekBarValue(boolean z) {
        this.Z = z;
        notifyChanged();
    }

    public void setUpdatesContinuously(boolean z) {
        this.a0 = z;
    }

    public void setValue(int i) {
        e(i, true);
    }

    public static class c extends Preference.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public int a;
        public int b;
        public int c;

        public static class a implements Parcelable.Creator<c> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public c[] newArray(int i) {
                return new c[i];
            }
        }

        public c(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarPreferenceStyle);
    }

    public SeekBarPreference(Context context) {
        this(context, null);
    }
}
