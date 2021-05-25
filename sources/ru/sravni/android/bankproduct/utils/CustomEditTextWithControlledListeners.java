package ru.sravni.android.bankproduct.utils;

import android.content.Context;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0014\u0010\u0018B!\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u001aJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/utils/CustomEditTextWithControlledListeners;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/text/TextWatcher;", "watcher", "", "addTextChangedListener", "(Landroid/text/TextWatcher;)V", "removeTextChangedListener", "removeAllListeners", "()V", "", "type", "setInputType", "(I)V", "", "d", "Ljava/util/List;", "listenersList", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class CustomEditTextWithControlledListeners extends AppCompatEditText {
    public final List<TextWatcher> d = new ArrayList();
    public HashMap e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomEditTextWithControlledListeners(@NotNull Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "ctx");
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        View view = (View) this.e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.e.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // android.widget.TextView
    public void addTextChangedListener(@Nullable TextWatcher textWatcher) {
        super.addTextChangedListener(textWatcher);
        if (textWatcher != null) {
            this.d.add(textWatcher);
        }
    }

    public final void removeAllListeners() {
        for (TextWatcher textWatcher : CollectionsKt___CollectionsKt.toList(this.d)) {
            removeTextChangedListener(textWatcher);
        }
    }

    @Override // android.widget.TextView
    public void removeTextChangedListener(@Nullable TextWatcher textWatcher) {
        super.removeTextChangedListener(textWatcher);
        List<TextWatcher> list = this.d;
        if (list != null) {
            TypeIntrinsics.asMutableCollection(list).remove(textWatcher);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @Override // android.widget.TextView
    public void setInputType(int i) {
        super.setInputType(i);
        if (i == 2) {
            setKeyListener(DigitsKeyListener.getInstance("0123456789 -.()[]"));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomEditTextWithControlledListeners(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomEditTextWithControlledListeners(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
    }
}
