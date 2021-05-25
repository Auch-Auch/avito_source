package com.avito.android.ui.view;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
public class CheckableImageView extends AppCompatImageView implements Checkable {
    public static final int[] f = {16842912};
    public boolean c;
    public boolean d;
    public OnCheckedChangeListener e;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(CheckableImageView checkableImageView, boolean z);
    }

    public static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public boolean a;

        public class a implements Parcelable.Creator<b> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("CompoundButton.SavedState{");
            L.append(Integer.toHexString(System.identityHashCode(this)));
            L.append(" checked=");
            return a2.b.a.a.a.B(L, this.a, "}");
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.a));
        }

        public b(Parcel parcel, a aVar) {
            super(parcel);
            this.a = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    public CheckableImageView(Context context) {
        super(context);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.c;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            ImageView.mergeDrawableStates(onCreateDrawableState, f);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setChecked(bVar.a);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.a = isChecked();
        return bVar;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        setChecked(z, true);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.e = onCheckedChangeListener;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.c);
    }

    public CheckableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.c != z) {
            this.c = z;
            refreshDrawableState();
            if (z2 && !this.d) {
                this.d = true;
                OnCheckedChangeListener onCheckedChangeListener = this.e;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(this, this.c);
                }
                this.d = false;
            }
        }
    }
}
