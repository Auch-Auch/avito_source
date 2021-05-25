package com.avito.android.ui.view;

import androidx.annotation.Nullable;
public interface FieldView<T> {

    public interface OnFieldValueChangeListener<T> {
        void onFieldValueChanged(FieldView fieldView, @Nullable T t);
    }

    void clearError();

    @Nullable
    T getValue();

    void highlightError(@Nullable String str);

    @Override // com.avito.android.ui.view.FieldView
    void setEnabled(boolean z);

    void setOnFieldValueChangedListener(OnFieldValueChangeListener<? extends T> onFieldValueChangeListener);

    void setOnFieldValueChangedListener(OnFieldValueChangeListener<? extends T> onFieldValueChangeListener, boolean z);

    void setTitle(CharSequence charSequence);

    void setValue(@Nullable T t);

    void setValue(@Nullable T t, boolean z);
}
