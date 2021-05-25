package com.avito.android.ui.view;

import a2.a.a.g3.b.b;
import a2.a.a.g3.b.c;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.avito.android.remote.model.Entity;
import com.avito.android.ui.adapter.NameIdAdapter;
import com.avito.android.ui.view.FieldView;
import com.avito.android.ui_components.R;
import com.avito.android.util.DialogUtils;
import com.avito.android.util.Entities;
import com.avito.android.util.Keyboards;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.avito.konveyor.util.DataSources;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Deprecated
public abstract class BaseSelectView<T> extends RelativeLayout implements View.OnClickListener, FieldView<T> {
    public TextView a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public int e;
    public boolean f;
    public FieldView.OnFieldValueChangeListener g;
    public boolean h = false;
    public CharSequence i;
    public ColorStateList j;
    public ColorStateList k;
    @Nullable
    public T l;
    @Nullable
    public T m;
    @Nullable
    public Selector n;
    public CharSequence o;
    @Nullable
    public ImageView p;

    public static class DialogMultiSelector extends EntitySelector<List<? extends Entity>> {
        public Dialog c;

        public class a implements DialogInterface.OnMultiChoiceClickListener {
            public final /* synthetic */ boolean[] a;

            public a(DialogMultiSelector dialogMultiSelector, boolean[] zArr) {
                this.a = zArr;
            }

            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                boolean[] zArr = this.a;
                if (i < zArr.length) {
                    zArr[i] = z;
                }
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public final /* synthetic */ boolean[] a;
            public final /* synthetic */ DataSource b;
            public final /* synthetic */ FieldView c;

            public b(DialogMultiSelector dialogMultiSelector, boolean[] zArr, DataSource dataSource, FieldView fieldView) {
                this.a = zArr;
                this.b = dataSource;
                this.c = fieldView;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: com.avito.android.ui.view.FieldView */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ArrayList arrayList = new ArrayList();
                int length = this.a.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.a[i2]) {
                        arrayList.add((Entity) this.b.getItem(i2));
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
                this.c.setValue(arrayList, true);
            }
        }

        public class c implements DialogInterface.OnClickListener {
            public final /* synthetic */ FieldView a;

            public c(DialogMultiSelector dialogMultiSelector, FieldView fieldView) {
                this.a = fieldView;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.setValue(null, true);
            }
        }

        public DialogMultiSelector(Context context) {
            super(context);
        }

        @Override // com.avito.android.ui.view.BaseSelectView.Selector
        public void hide() {
            DialogUtils.dismissDialog(this.c);
        }

        @Override // com.avito.android.ui.view.BaseSelectView.Selector
        public void show(FieldView<List<? extends Entity>> fieldView) {
            List<? extends Entity> value = fieldView.getValue();
            DataSource<? extends Entity<?>> items = getItems();
            int count = items.getCount();
            CharSequence[] charSequenceArr = new CharSequence[count];
            boolean[] zArr = new boolean[count];
            for (int i = 0; i < count; i++) {
                Entity entity = (Entity) items.getItem(i);
                charSequenceArr[i] = entity.getName();
                zArr[i] = false;
                if (value != null) {
                    Iterator<? extends Entity> it = value.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Entities.areEqual(entity, (Entity) it.next())) {
                                zArr[i] = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            DialogUtils.dismissDialog(this.c);
            this.c = DialogUtils.showMultiChoiceDialog(getContext(), charSequenceArr, zArr, new a(this, zArr), new b(this, zArr, items, fieldView), new c(this, fieldView));
        }
    }

    public static class DialogSelector extends EntitySelector<Entity> {
        public Dialog c;

        public class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ FieldView a;
            public final /* synthetic */ DataSource b;

            public a(DialogSelector dialogSelector, FieldView fieldView, DataSource dataSource) {
                this.a = fieldView;
                this.b = dataSource;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.avito.android.ui.view.FieldView */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Entity entity = (Entity) this.a.getValue();
                if (this.b.getCount() > i) {
                    Entity entity2 = (Entity) this.b.getItem(i);
                    if (!Entities.areEqual(entity, entity2)) {
                        this.a.setValue(entity2);
                    }
                }
            }
        }

        public DialogSelector(Context context) {
            super(context);
        }

        public NameIdAdapter createAdapter(DataSource<? extends Entity<?>> dataSource) {
            return new NameIdAdapter(dataSource);
        }

        @Override // com.avito.android.ui.view.BaseSelectView.Selector
        public void hide() {
            DialogUtils.dismissDialog(this.c);
        }

        @Override // com.avito.android.ui.view.BaseSelectView.Selector
        public void show(FieldView<Entity> fieldView) {
            DataSource<? extends Entity<?>> items = getItems();
            int indexOf = DataSources.indexOf(items, fieldView.getValue());
            NameIdAdapter createAdapter = createAdapter(items);
            DialogUtils.dismissDialog(this.c);
            this.c = DialogUtils.showSingleChoiceDialog(getContext(), createAdapter, indexOf, new a(this, fieldView, items));
        }
    }

    public interface Selector<T> {
        void hide();

        void show(FieldView<T> fieldView);
    }

    public static class SimpleSelector<T> implements Selector<T> {
        @Override // com.avito.android.ui.view.BaseSelectView.Selector
        public void hide() {
        }

        @Override // com.avito.android.ui.view.BaseSelectView.Selector
        public void show(FieldView<T> fieldView) {
        }
    }

    public BaseSelectView(Context context) {
        super(context);
        c(context, null);
    }

    private CharSequence getValueHint() {
        if (TextUtils.isEmpty(this.o)) {
            return this.i;
        }
        return this.o;
    }

    private void setIcon(Drawable drawable) {
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            this.p.setVisibility(drawable == null ? 8 : 0);
        }
    }

    public final boolean a() {
        T t;
        if (this.f) {
            if ((this.l != null) && isEnabled() && ((t = this.m) == null || !t.equals(this.l))) {
                return true;
            }
        }
        return false;
    }

    public final void b() {
        ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).rightMargin = 0;
        this.c.requestLayout();
        this.d.setVisibility(4);
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BaseSelectView);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.BaseSelectView_android_layout, R.layout.select_view);
        this.f = obtainStyledAttributes.getBoolean(R.styleable.BaseSelectView_removable, false);
        this.i = obtainStyledAttributes.getText(R.styleable.BaseSelectView_android_title);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.BaseSelectView_android_icon);
        this.o = obtainStyledAttributes.getText(R.styleable.BaseSelectView_emptyText);
        this.j = obtainStyledAttributes.getColorStateList(R.styleable.BaseSelectView_emptyTextColor);
        this.k = obtainStyledAttributes.getColorStateList(R.styleable.BaseSelectView_android_textColor);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(resourceId, (ViewGroup) this, true);
        this.a = (TextView) findViewById(R.id.floating_label);
        this.b = (TextView) findViewById(R.id.error_label);
        this.c = (TextView) findViewById(R.id.value_label);
        this.d = (ImageView) findViewById(R.id.close_icon);
        this.p = (ImageView) findViewById(R.id.icon);
        Resources resources = getResources();
        this.e = (int) (resources.getDimension(R.dimen.filter_spinner_icon_size) + resources.getDimension(R.dimen.card_padding));
        b();
        this.c.setText(getValueHint());
        ColorStateList colorStateList = this.j;
        if (colorStateList != null) {
            this.c.setTextColor(colorStateList);
        }
        if (drawable != null) {
            setIcon(drawable);
        }
        this.d.setOnClickListener(this);
        this.c.setOnClickListener(this);
    }

    @Override // com.avito.android.ui.view.FieldView
    public void clearError() {
        this.c.setBackgroundResource(R.drawable.bg_spinner_states);
        this.b.setVisibility(8);
        this.b.setText((CharSequence) null);
    }

    public void clearValue() {
        T t = this.m;
        if (t != null) {
            setValue(t, true);
            b();
            return;
        }
        setValue(null);
    }

    public final void d() {
        ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).rightMargin = this.e;
        this.c.requestLayout();
        this.d.setVisibility(0);
    }

    public final void e() {
        if (!TextUtils.isEmpty(this.o)) {
            this.a.setText(this.i);
            ColorStateList colorStateList = this.k;
            if (colorStateList != null) {
                this.c.setTextColor(colorStateList);
            }
            T t = this.l;
            if (t == null) {
                this.c.setText(this.o);
            } else {
                this.c.setText(getValueLabel(t));
            }
        } else if (this.l == null) {
            this.a.setText((CharSequence) null);
            this.c.setText(this.i);
            ColorStateList colorStateList2 = this.j;
            if (colorStateList2 != null) {
                this.c.setTextColor(colorStateList2);
            }
        } else {
            this.a.setText(this.i);
            this.c.setText(getValueLabel(this.l));
            ColorStateList colorStateList3 = this.k;
            if (colorStateList3 != null) {
                this.c.setTextColor(colorStateList3);
            }
        }
    }

    @Nullable
    public Selector<? extends T> getSelector() {
        return this.n;
    }

    @Override // com.avito.android.ui.view.FieldView
    @Nullable
    public T getValue() {
        return this.l;
    }

    public abstract String getValueLabel(@NonNull T t);

    public boolean hasSelector() {
        return this.n != null;
    }

    @Override // com.avito.android.ui.view.FieldView
    public void highlightError(String str) {
        if (TextUtils.isEmpty(str)) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
        }
        this.c.setBackgroundResource(R.drawable.bg_spinner_error_states);
        this.b.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.close_icon) {
            TextView textView = this.c;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(layoutParams.rightMargin, 0);
            ofInt.setDuration(150L);
            ofInt.addUpdateListener(new c(this, layoutParams, textView));
            this.d.setVisibility(4);
            ofInt.start();
            clearValue();
        } else if (id == R.id.value_label && this.n != null) {
            Keyboards.hideKeyboard(this);
            this.n.show(this);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof a) {
            a aVar = (a) parcelable;
            super.onRestoreInstanceState(aVar.getSuperState());
            this.a.onRestoreInstanceState(aVar.a);
            this.c.onRestoreInstanceState(aVar.b);
            this.b.onRestoreInstanceState(aVar.c);
            FieldView.OnFieldValueChangeListener onFieldValueChangeListener = this.g;
            if (onFieldValueChangeListener != null && this.h) {
                onFieldValueChangeListener.onFieldValueChanged(this, getValue());
            }
        } else {
            super.onRestoreInstanceState(parcelable);
        }
        if (this.b.getVisibility() == 0 || !TextUtils.isEmpty(this.b.getText())) {
            highlightError(this.b.getText().toString());
        }
        if (a()) {
            d();
        } else {
            b();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.a = this.a.onSaveInstanceState();
        aVar.b = this.c.onSaveInstanceState();
        aVar.c = this.b.onSaveInstanceState();
        return aVar;
    }

    public void setClosable(boolean z) {
        this.f = z;
    }

    public void setEmptyValue(@NonNull T t) {
        this.m = t;
    }

    @Override // android.view.View, com.avito.android.ui.view.FieldView
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.c.setEnabled(z);
        this.d.setEnabled(z);
        if (!a()) {
            b();
        } else if (this.d.getVisibility() != 0) {
            d();
        }
    }

    @Override // com.avito.android.ui.view.FieldView
    public void setOnFieldValueChangedListener(FieldView.OnFieldValueChangeListener<? extends T> onFieldValueChangeListener) {
        this.g = onFieldValueChangeListener;
    }

    public void setSelector(@Nullable Selector<? extends T> selector) {
        Selector selector2 = this.n;
        if (selector2 != null) {
            selector2.hide();
        }
        this.n = selector;
    }

    @Override // com.avito.android.ui.view.FieldView
    public void setTitle(CharSequence charSequence) {
        this.i = charSequence;
        e();
    }

    @Override // com.avito.android.ui.view.FieldView
    public void setValue(@Nullable T t) {
        setValue(t, true);
    }

    public static abstract class EntitySelector<T> implements Selector<T> {
        public final Context a;
        @NonNull
        public DataSource<? extends Entity<?>> b = DataSources.emptyDataSource();

        public EntitySelector(Context context) {
            this.a = context;
        }

        public Context getContext() {
            return this.a;
        }

        @NonNull
        public DataSource<? extends Entity<?>> getItems() {
            return this.b;
        }

        public void setItems(@NonNull DataSource<? extends Entity<?>> dataSource) {
            hide();
            this.b = dataSource;
        }

        @Deprecated
        public void setItems(@Nullable List<? extends Entity<?>> list) {
            setItems(list != null ? new ListDataSource<>(list) : DataSources.emptyDataSource());
        }
    }

    @Override // com.avito.android.ui.view.FieldView
    public void setOnFieldValueChangedListener(FieldView.OnFieldValueChangeListener<? extends T> onFieldValueChangeListener, boolean z) {
        setOnFieldValueChangedListener(onFieldValueChangeListener);
        this.h = z;
    }

    @Override // com.avito.android.ui.view.FieldView
    public void setValue(@Nullable T t, boolean z) {
        boolean z2;
        FieldView.OnFieldValueChangeListener onFieldValueChangeListener;
        T t2 = this.l;
        if (t2 == null && t == null) {
            z2 = true;
        } else {
            z2 = (t2 == null) ^ (t == null) ? false : t.equals(t2);
        }
        if (!z2) {
            this.l = t;
            clearError();
            if (z && (onFieldValueChangeListener = this.g) != null) {
                onFieldValueChangeListener.onFieldValueChanged(this, t);
            }
        }
        if (t == null) {
            b();
        }
        e();
        if (!a()) {
            b();
        } else if (z) {
            TextView textView = this.c;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            int i2 = layoutParams.rightMargin;
            if (i2 <= 0) {
                ValueAnimator ofInt = ValueAnimator.ofInt(i2, this.e);
                ofInt.setDuration(150L);
                ofInt.addUpdateListener(new a2.a.a.g3.b.a(this, layoutParams, textView));
                ofInt.addListener(new b(this));
                ofInt.start();
            }
        } else {
            d();
        }
    }

    public void setTitle(@StringRes int i2) {
        setTitle(getResources().getString(i2));
    }

    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0162a();
        public Parcelable a;
        public Parcelable b;
        public Parcelable c;

        /* renamed from: com.avito.android.ui.view.BaseSelectView$a$a  reason: collision with other inner class name */
        public class C0162a implements Parcelable.Creator<a> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public a[] newArray(int i) {
                return new a[i];
            }
        }

        public a(Parcel parcel) {
            super(parcel);
            this.a = parcel.readParcelable(TextView.class.getClassLoader());
            this.b = parcel.readParcelable(TextView.class.getClassLoader());
            this.c = parcel.readParcelable(TextView.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.a, 0);
            parcel.writeParcelable(this.b, 0);
            parcel.writeParcelable(this.c, 0);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public BaseSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public BaseSelectView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context, attributeSet);
    }
}
