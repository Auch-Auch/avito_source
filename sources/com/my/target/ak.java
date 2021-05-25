package com.my.target;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ag;
import java.lang.ref.WeakReference;
public final class ak extends ag {
    public int e;
    @Nullable
    public a f;

    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9;
            int i10;
            int i11;
            int i12;
            int i13;
            WeakReference<fo> weakReference = ak.this.d;
            fo foVar = weakReference != null ? weakReference.get() : null;
            if (foVar != null) {
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                int measuredWidth2 = foVar.getMeasuredWidth();
                int measuredHeight2 = foVar.getMeasuredHeight();
                int i14 = ak.this.e;
                if (i14 != 1) {
                    if (i14 == 2) {
                        int paddingLeft = (measuredWidth - measuredWidth2) - view.getPaddingLeft();
                        i13 = (measuredHeight - view.getPaddingBottom()) - measuredHeight2;
                        i11 = measuredWidth - view.getPaddingRight();
                        i12 = measuredHeight - view.getPaddingBottom();
                        i10 = paddingLeft;
                    } else if (i14 == 3) {
                        int paddingLeft2 = view.getPaddingLeft();
                        i13 = (measuredHeight - view.getPaddingBottom()) - measuredHeight2;
                        i12 = measuredHeight - view.getPaddingBottom();
                        i10 = paddingLeft2;
                        i11 = measuredWidth2 + view.getPaddingLeft();
                    } else if (i14 != 4) {
                        i10 = (measuredWidth - measuredWidth2) - view.getPaddingLeft();
                        i9 = view.getPaddingTop();
                        i11 = measuredWidth - view.getPaddingRight();
                        i12 = view.getPaddingTop() + measuredHeight2;
                    } else {
                        return;
                    }
                    i9 = i13;
                } else {
                    i10 = view.getPaddingLeft();
                    int paddingTop = view.getPaddingTop();
                    int paddingLeft3 = measuredWidth2 + view.getPaddingLeft();
                    i12 = view.getPaddingTop() + measuredHeight2;
                    i9 = paddingTop;
                    i11 = paddingLeft3;
                }
                foVar.layout(i10, i9, i11, i12);
            }
        }
    }

    public ak(@Nullable bo boVar) {
        super(boVar);
        if (boVar != null) {
            this.f = new a();
        }
    }

    public static ak b(@Nullable bo boVar) {
        return new ak(boVar);
    }

    public void a(@NonNull View view) {
        super.unregister();
        a aVar = this.f;
        if (aVar != null) {
            view.removeOnLayoutChangeListener(aVar);
        }
    }

    public void a(@NonNull ViewGroup viewGroup, @Nullable fo foVar, @NonNull ag.b bVar, int i) {
        this.e = i;
        if (this.a != null) {
            if (foVar == null) {
                Context context = viewGroup.getContext();
                fo foVar2 = new fo(context);
                io.a(foVar2, "ad_choices");
                int c = io.c(2, context);
                foVar2.setPadding(c, c, c, c);
                foVar = foVar2;
            }
            if (foVar.getParent() == null) {
                try {
                    viewGroup.addView(foVar);
                } catch (Throwable th) {
                    a2.b.a.a.a.q1(th, a2.b.a.a.a.L("Unable to add AdChoices View: "));
                }
            }
            if (i != 4) {
                viewGroup.addOnLayoutChangeListener(this.f);
            }
            super.a(foVar, bVar);
        } else if (foVar != null) {
            b(foVar);
        }
    }
}
