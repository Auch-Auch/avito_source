package ru.sravni.android.bankproduct.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.SuggestInfo;
public class SuggestItemSravniBindingImpl extends SuggestItemSravniBinding {
    public long A = -1;
    @NonNull
    public final LinearLayout y;
    @NonNull
    public final View z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SuggestItemSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r10, @androidx.annotation.NonNull android.view.View r11) {
        /*
            r9 = this;
            r0 = 4
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r10, r11, r0, r1, r1)
            r2 = 2
            r2 = r0[r2]
            r7 = r2
            android.widget.TextView r7 = (android.widget.TextView) r7
            r2 = 1
            r2 = r0[r2]
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6 = 0
            r3 = r9
            r4 = r10
            r5 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r2 = -1
            r9.A = r2
            r10 = 0
            r10 = r0[r10]
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            r9.y = r10
            r10.setTag(r1)
            r10 = 3
            r10 = r0[r10]
            android.view.View r10 = (android.view.View) r10
            r9.z = r10
            r10.setTag(r1)
            android.widget.TextView r10 = r9.tvSubText
            r10.setTag(r1)
            android.widget.TextView r10 = r9.tvSuggestText
            r10.setTag(r1)
            r9.setRootTag(r11)
            r9.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.SuggestItemSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r19 = this;
            r1 = r19
            monitor-enter(r19)
            long r2 = r1.A     // Catch:{ all -> 0x007c }
            r4 = 0
            r1.A = r4     // Catch:{ all -> 0x007c }
            monitor-exit(r19)     // Catch:{ all -> 0x007c }
            java.lang.Boolean r0 = r1.mFirstItem
            ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.SuggestInfo r6 = r1.mSuggestInfo
            r7 = 5
            long r9 = r2 & r7
            r11 = 8
            r12 = 0
            int r13 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x002c
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox(r0)
            if (r13 == 0) goto L_0x0027
            if (r0 == 0) goto L_0x0024
            r9 = 64
            goto L_0x0026
        L_0x0024:
            r9 = 32
        L_0x0026:
            long r2 = r2 | r9
        L_0x0027:
            if (r0 == 0) goto L_0x002c
            r0 = 8
            goto L_0x002d
        L_0x002c:
            r0 = 0
        L_0x002d:
            r9 = 6
            long r13 = r2 & r9
            r15 = 0
            int r16 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x005c
            if (r6 == 0) goto L_0x0045
            java.lang.String r15 = r6.getSuggest()
            boolean r13 = r6.getHasExtraSuggest()
            java.lang.String r6 = r6.getExtraSuggest()
            goto L_0x0047
        L_0x0045:
            r6 = r15
            r13 = 0
        L_0x0047:
            if (r16 == 0) goto L_0x0052
            if (r13 == 0) goto L_0x004e
            r16 = 16
            goto L_0x0050
        L_0x004e:
            r16 = 8
        L_0x0050:
            long r2 = r2 | r16
        L_0x0052:
            if (r13 == 0) goto L_0x0055
            r11 = 0
        L_0x0055:
            r12 = r11
            r18 = r15
            r15 = r6
            r6 = r18
            goto L_0x005d
        L_0x005c:
            r6 = r15
        L_0x005d:
            long r7 = r7 & r2
            int r11 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0067
            android.view.View r7 = r1.z
            r7.setVisibility(r0)
        L_0x0067:
            long r2 = r2 & r9
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x007b
            android.widget.TextView r0 = r1.tvSubText
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r15)
            android.widget.TextView r0 = r1.tvSubText
            r0.setVisibility(r12)
            android.widget.TextView r0 = r1.tvSuggestText
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r6)
        L_0x007b:
            return
        L_0x007c:
            r0 = move-exception
            monitor-exit(r19)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.SuggestItemSravniBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.A != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.A = 4;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.SuggestItemSravniBinding
    public void setFirstItem(@Nullable Boolean bool) {
        this.mFirstItem = bool;
        synchronized (this) {
            this.A |= 1;
        }
        notifyPropertyChanged(BR.firstItem);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.SuggestItemSravniBinding
    public void setSuggestInfo(@Nullable SuggestInfo suggestInfo) {
        this.mSuggestInfo = suggestInfo;
        synchronized (this) {
            this.A |= 2;
        }
        notifyPropertyChanged(BR.suggestInfo);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.firstItem == i) {
            setFirstItem((Boolean) obj);
        } else if (BR.suggestInfo != i) {
            return false;
        } else {
            setSuggestInfo((SuggestInfo) obj);
        }
        return true;
    }
}
