package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.TESTS})
public class MaterialStyledDatePickerDialog extends DatePickerDialog {
    @StyleRes
    public static final int c = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;
    @NonNull
    public final Drawable a;
    @NonNull
    public final Rect b;

    public MaterialStyledDatePickerDialog(@NonNull Context context) {
        this(context, 0);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.a);
        getWindow().getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(this, this.b));
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, int i) {
        this(context, i, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        this(context, 0, onDateSetListener, i, i2, i3);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, int i, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        super(context, i, onDateSetListener, i2, i3, i4);
        Context context2 = getContext();
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(getContext(), R.attr.colorSurface, getClass().getCanonicalName());
        int i5 = c;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, null, 16843612, i5);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        Rect dialogBackgroundInsets = MaterialDialogs.getDialogBackgroundInsets(context2, 16843612, i5);
        this.b = dialogBackgroundInsets;
        this.a = MaterialDialogs.insetDrawable(materialShapeDrawable, dialogBackgroundInsets);
    }
}
