package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.ChatViewCard;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.UserMessageItemDescription;
import ru.sravni.android.bankproduct.utils.adapter.BindingImageViewKt;
public class ChatMessageUserItemSravniBindingImpl extends ChatMessageUserItemSravniBinding implements OnClickListener.Listener {
    @Nullable
    public static final SparseIntArray C;
    @Nullable
    public final View.OnClickListener A;
    public long B = -1;
    @NonNull
    public final ConstraintLayout y;
    @NonNull
    public final TextView z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        C = sparseIntArray;
        sparseIntArray.put(R.id.left_guideline, 5);
        sparseIntArray.put(R.id.tvTextMargin, 6);
        sparseIntArray.put(R.id.ivWaitingAnimation, 7);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChatMessageUserItemSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r14, @androidx.annotation.NonNull android.view.View r15) {
        /*
            r13 = this;
            android.util.SparseIntArray r0 = ru.sravni.android.bankproduct.databinding.ChatMessageUserItemSravniBindingImpl.C
            r1 = 8
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r14, r15, r1, r2, r0)
            r1 = 2
            r1 = r0[r1]
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r1 = 7
            r1 = r0[r1]
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r1 = 5
            r1 = r0[r1]
            r9 = r1
            androidx.constraintlayout.widget.Guideline r9 = (androidx.constraintlayout.widget.Guideline) r9
            r1 = 4
            r1 = r0[r1]
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            r1 = 1
            r3 = r0[r1]
            r11 = r3
            ru.sravni.android.bankproduct.utils.WrappedTextView r11 = (ru.sravni.android.bankproduct.utils.WrappedTextView) r11
            r3 = 6
            r3 = r0[r3]
            r12 = r3
            android.widget.Space r12 = (android.widget.Space) r12
            r6 = 0
            r3 = r13
            r4 = r14
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r3 = -1
            r13.B = r3
            android.widget.ImageView r14 = r13.ivStatus
            r14.setTag(r2)
            r14 = 0
            r14 = r0[r14]
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            r13.y = r14
            r14.setTag(r2)
            r14 = 3
            r14 = r0[r14]
            android.widget.TextView r14 = (android.widget.TextView) r14
            r13.z = r14
            r14.setTag(r2)
            android.widget.TextView r14 = r13.tvCreatedTime
            r14.setTag(r2)
            ru.sravni.android.bankproduct.utils.WrappedTextView r14 = r13.tvText
            r14.setTag(r2)
            r13.setRootTag(r15)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r14 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r14.<init>(r13, r1)
            r13.A = r14
            r13.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.ChatMessageUserItemSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        UserMessageItemDescription userMessageItemDescription = this.mMessageDescription;
        if (userMessageItemDescription != null) {
            userMessageItemDescription.onClick();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        int i2;
        String str;
        int i3;
        boolean z2;
        ChatViewCard chatViewCard;
        synchronized (this) {
            j = this.B;
            this.B = 0;
        }
        UserMessageItemDescription userMessageItemDescription = this.mMessageDescription;
        String str2 = null;
        int i4 = 0;
        int i5 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (userMessageItemDescription != null) {
                z2 = userMessageItemDescription.getShouldShowTime();
                i = userMessageItemDescription.getErrorDescriptionVisibility();
                i3 = userMessageItemDescription.getStatusDrawable();
                chatViewCard = userMessageItemDescription.getChatViewCard();
            } else {
                chatViewCard = null;
                z2 = false;
                i = 0;
                i3 = 0;
            }
            if (i5 != 0) {
                j |= z2 ? 8 : 4;
            }
            if (!z2) {
                i4 = 4;
            }
            if (chatViewCard != null) {
                String text = chatViewCard.getText();
                i2 = i4;
                i4 = i3;
                str2 = chatViewCard.getTimeString();
                str = text;
            } else {
                str = null;
                i2 = i4;
                i4 = i3;
            }
        } else {
            str = null;
            i2 = 0;
            i = 0;
        }
        if ((3 & j) != 0) {
            BindingImageViewKt.bindDrawableSource(this.ivStatus, Integer.valueOf(i4));
            this.z.setVisibility(i);
            TextViewBindingAdapter.setText(this.tvCreatedTime, str2);
            this.tvCreatedTime.setVisibility(i2);
            TextViewBindingAdapter.setText(this.tvText, str);
        }
        if ((j & 2) != 0) {
            this.tvText.setOnClickListener(this.A);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.B != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.B = 2;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatMessageUserItemSravniBinding
    public void setMessageDescription(@Nullable UserMessageItemDescription userMessageItemDescription) {
        this.mMessageDescription = userMessageItemDescription;
        synchronized (this) {
            this.B |= 1;
        }
        notifyPropertyChanged(BR.messageDescription);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.messageDescription != i) {
            return false;
        }
        setMessageDescription((UserMessageItemDescription) obj);
        return true;
    }
}
