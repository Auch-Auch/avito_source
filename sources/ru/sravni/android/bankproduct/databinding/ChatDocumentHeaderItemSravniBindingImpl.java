package ru.sravni.android.bankproduct.databinding;

import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.domain.chat.entity.MessageDomain;
import ru.sravni.android.bankproduct.utils.adapter.BindingViewKt;
public class ChatDocumentHeaderItemSravniBindingImpl extends ChatDocumentHeaderItemSravniBinding {
    @NonNull
    public final LinearLayout y;
    public long z = -1;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChatDocumentHeaderItemSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r11, @androidx.annotation.NonNull android.view.View r12) {
        /*
            r10 = this;
            r0 = 4
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r11, r12, r0, r1, r1)
            r2 = 1
            r2 = r0[r2]
            r7 = r2
            androidx.cardview.widget.CardView r7 = (androidx.cardview.widget.CardView) r7
            r2 = 3
            r2 = r0[r2]
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            r2 = 2
            r2 = r0[r2]
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            r6 = 0
            r3 = r10
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r2 = -1
            r10.z = r2
            androidx.cardview.widget.CardView r11 = r10.cvIconHeader
            r11.setTag(r1)
            r11 = 0
            r11 = r0[r11]
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            r10.y = r11
            r11.setTag(r1)
            android.widget.TextView r11 = r10.tvHeader
            r11.setTag(r1)
            android.widget.TextView r11 = r10.tvIconHeader
            r11.setTag(r1)
            r10.setRootTag(r12)
            r10.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.ChatDocumentHeaderItemSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        int i2;
        synchronized (this) {
            j = this.z;
            this.z = 0;
        }
        String str = null;
        String str2 = this.mTitle;
        MessageDomain.HeaderInfoLogo headerInfoLogo = this.mHeaderInfoLogo;
        int i3 = 0;
        int i4 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (headerInfoLogo != null) {
                int fontColor = headerInfoLogo.getFontColor();
                String iconTitle = headerInfoLogo.getIconTitle();
                int backgroundColor = headerInfoLogo.getBackgroundColor();
                i2 = fontColor;
                str = iconTitle;
                i = backgroundColor;
            } else {
                i2 = 0;
                i = 0;
            }
            boolean z2 = str != null;
            if (i4 != 0) {
                j |= z2 ? 16 : 8;
            }
            if (!z2) {
                i3 = 8;
            }
        } else {
            i2 = 0;
            i = 0;
        }
        if ((6 & j) != 0) {
            this.cvIconHeader.setVisibility(i3);
            BindingViewKt.bindSetBackgroundColorToCardView(this.cvIconHeader, i);
            TextViewBindingAdapter.setText(this.tvIconHeader, str);
            this.tvIconHeader.setTextColor(i2);
        }
        if ((j & 5) != 0) {
            TextViewBindingAdapter.setText(this.tvHeader, str2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.z != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.z = 4;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatDocumentHeaderItemSravniBinding
    public void setHeaderInfoLogo(@Nullable MessageDomain.HeaderInfoLogo headerInfoLogo) {
        this.mHeaderInfoLogo = headerInfoLogo;
        synchronized (this) {
            this.z |= 2;
        }
        notifyPropertyChanged(BR.headerInfoLogo);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatDocumentHeaderItemSravniBinding
    public void setTitle(@Nullable String str) {
        this.mTitle = str;
        synchronized (this) {
            this.z |= 1;
        }
        notifyPropertyChanged(BR.title);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.title == i) {
            setTitle((String) obj);
        } else if (BR.headerInfoLogo != i) {
            return false;
        } else {
            setHeaderInfoLogo((MessageDomain.HeaderInfoLogo) obj);
        }
        return true;
    }
}
