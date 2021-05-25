package ru.sravni.android.bankproduct.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.BindingMessageAdapterKt;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.SravniMessageItemDescription;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.ViewHolderMessageStatusEnum;
public class ChatMessageSravniItemSravniBindingImpl extends ChatMessageSravniItemSravniBinding {
    @Nullable
    public static final SparseIntArray A;
    @NonNull
    public final ConstraintLayout y;
    public long z = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        A = sparseIntArray;
        sparseIntArray.put(R.id.right_guideline, 8);
        sparseIntArray.put(R.id.flCreatedTime, 9);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChatMessageSravniItemSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r18, @androidx.annotation.NonNull android.view.View r19) {
        /*
            r17 = this;
            r13 = r17
            r14 = r19
            android.util.SparseIntArray r0 = ru.sravni.android.bankproduct.databinding.ChatMessageSravniItemSravniBindingImpl.A
            r1 = 10
            r15 = 0
            r2 = r18
            java.lang.Object[] r16 = androidx.databinding.ViewDataBinding.mapBindings(r2, r14, r1, r15, r0)
            r0 = 2
            r0 = r16[r0]
            r4 = r0
            ru.sravni.android.bankproduct.utils.WrappedTextView r4 = (ru.sravni.android.bankproduct.utils.WrappedTextView) r4
            r0 = 9
            r0 = r16[r0]
            r5 = r0
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            r0 = 4
            r0 = r16[r0]
            r6 = r0
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r0 = 5
            r0 = r16[r0]
            r7 = r0
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r0 = 6
            r0 = r16[r0]
            r8 = r0
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r0 = 1
            r0 = r16[r0]
            r9 = r0
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r0 = 3
            r0 = r16[r0]
            r10 = r0
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            r0 = 8
            r0 = r16[r0]
            r11 = r0
            androidx.constraintlayout.widget.Guideline r11 = (androidx.constraintlayout.widget.Guideline) r11
            r0 = 7
            r0 = r16[r0]
            r12 = r0
            android.widget.TextView r12 = (android.widget.TextView) r12
            r3 = 0
            r0 = r17
            r1 = r18
            r2 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = -1
            r13.z = r0
            ru.sravni.android.bankproduct.utils.WrappedTextView r0 = r13.chatMessage
            r0.setTag(r15)
            android.widget.ImageView r0 = r13.imgFirstPoint
            r0.setTag(r15)
            android.widget.ImageView r0 = r13.imgSecondPoint
            r0.setTag(r15)
            android.widget.ImageView r0 = r13.imgThirdPoint
            r0.setTag(r15)
            android.widget.ImageView r0 = r13.ivBotFace
            r0.setTag(r15)
            android.widget.LinearLayout r0 = r13.llWritingBot
            r0.setTag(r15)
            r0 = 0
            r0 = r16[r0]
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r13.y = r0
            r0.setTag(r15)
            android.widget.TextView r0 = r13.tvCreatedTime
            r0.setTag(r15)
            r13.setRootTag(r14)
            r17.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.ChatMessageSravniItemSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        String str2;
        synchronized (this) {
            j = this.z;
            this.z = 0;
        }
        SravniMessageItemDescription sravniMessageItemDescription = this.mMessageDescription;
        String str3 = null;
        ViewHolderMessageStatusEnum viewHolderMessageStatusEnum = null;
        int i5 = ((j & 20) > 0 ? 1 : ((j & 20) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (sravniMessageItemDescription != null) {
                z4 = sravniMessageItemDescription.getMessageTimeVisible();
                z3 = sravniMessageItemDescription.getIconFaceVisible();
                viewHolderMessageStatusEnum = sravniMessageItemDescription.getStatus();
                str = sravniMessageItemDescription.getMessageTime();
                str2 = sravniMessageItemDescription.getText();
            } else {
                str2 = null;
                str = null;
                z4 = false;
                z3 = false;
            }
            if (i5 != 0) {
                j |= z4 ? 64 : 32;
            }
            if ((j & 20) != 0) {
                j |= z3 ? 1024 : 512;
            }
            int i6 = 8;
            int i7 = z4 ? 0 : 8;
            i3 = z3 ? 0 : 4;
            boolean z5 = true;
            boolean z7 = viewHolderMessageStatusEnum == ViewHolderMessageStatusEnum.SUCCESS;
            if (viewHolderMessageStatusEnum != ViewHolderMessageStatusEnum.WAITING) {
                z5 = false;
            }
            if ((j & 20) != 0) {
                j |= z7 ? 256 : 128;
            }
            if ((j & 20) != 0) {
                j |= z5 ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            if (z7) {
                i6 = 0;
            }
            str3 = str2;
            z2 = z5;
            i = i7;
            i4 = z5 ? 0 : 4;
            i2 = i6;
        } else {
            str = null;
            z2 = false;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((j & 20) != 0) {
            TextViewBindingAdapter.setText(this.chatMessage, str3);
            this.chatMessage.setVisibility(i2);
            BindingMessageAdapterKt.bindVisibleWaiting(this.imgFirstPoint, z2);
            BindingMessageAdapterKt.bindVisibleWaiting(this.imgSecondPoint, z2);
            BindingMessageAdapterKt.bindVisibleWaiting(this.imgThirdPoint, z2);
            this.ivBotFace.setVisibility(i3);
            this.llWritingBot.setVisibility(i4);
            TextViewBindingAdapter.setText(this.tvCreatedTime, str);
            this.tvCreatedTime.setVisibility(i);
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
            this.z = 16;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatMessageSravniItemSravniBinding
    public void setIsAnimationActive(@Nullable Boolean bool) {
        this.mIsAnimationActive = bool;
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatMessageSravniItemSravniBinding
    public void setIsNextMessageFromBot(@Nullable Boolean bool) {
        this.mIsNextMessageFromBot = bool;
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatMessageSravniItemSravniBinding
    public void setMessage(@Nullable String str) {
        this.mMessage = str;
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatMessageSravniItemSravniBinding
    public void setMessageDescription(@Nullable SravniMessageItemDescription sravniMessageItemDescription) {
        this.mMessageDescription = sravniMessageItemDescription;
        synchronized (this) {
            this.z |= 4;
        }
        notifyPropertyChanged(BR.messageDescription);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.isAnimationActive == i) {
            setIsAnimationActive((Boolean) obj);
        } else if (BR.message == i) {
            setMessage((String) obj);
        } else if (BR.messageDescription == i) {
            setMessageDescription((SravniMessageItemDescription) obj);
        } else if (BR.isNextMessageFromBot != i) {
            return false;
        } else {
            setIsNextMessageFromBot((Boolean) obj);
        }
        return true;
    }
}
