package com.rd.draw.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
public class PositionSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<PositionSavedState> CREATOR = new a();
    public int a;
    public int b;
    public int c;

    public static class a implements Parcelable.Creator<PositionSavedState> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public PositionSavedState createFromParcel(Parcel parcel) {
            return new PositionSavedState(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public PositionSavedState[] newArray(int i) {
            return new PositionSavedState[i];
        }
    }

    public PositionSavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public int getLastSelectedPosition() {
        return this.c;
    }

    public int getSelectedPosition() {
        return this.a;
    }

    public int getSelectingPosition() {
        return this.b;
    }

    public void setLastSelectedPosition(int i) {
        this.c = i;
    }

    public void setSelectedPosition(int i) {
        this.a = i;
    }

    public void setSelectingPosition(int i) {
        this.b = i;
    }

    @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }

    public PositionSavedState(Parcel parcel, a aVar) {
        super(parcel);
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
    }
}
