package com.avito.android.lib.design.list_item;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.widget.Checkable;
import android.widget.CompoundButton;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.list_item.CompoundButtonListItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u000201B\u0013\b\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b(\u0010)B\u001d\b\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b(\u0010,B%\b\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b(\u0010/J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH$¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\u00020\r8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u00062"}, d2 = {"Lcom/avito/android/lib/design/list_item/CompoundButtonListItem;", "Lcom/avito/android/lib/design/list_item/BaseListItem;", "Landroid/widget/Checkable;", "", "performClick", "()Z", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onBindCheckedChangeListener", "(Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;)V", "addOnCheckedChangeListener", "removeOnCheckedChangeListener", "enabled", "setToggleByClickEnabled", "(Z)V", "l", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;", "getOnCheckedChangeListener", "()Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;", "onCheckedChangeListener", "", "j", "Ljava/util/List;", "listeners", "k", "Z", "toggleByClick", "Landroid/widget/CompoundButton;", "getButtonView", "()Landroid/widget/CompoundButton;", "buttonView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OnCheckedChangeListener", "SavedState", "components_release"}, k = 1, mv = {1, 4, 2})
public abstract class CompoundButtonListItem extends BaseListItem implements Checkable {
    public final List<OnCheckedChangeListener> j;
    public boolean k;
    @NotNull
    public final OnCheckedChangeListener l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;", "", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem;", "view", "", "isChecked", "", "onCheckedChanged", "(Lcom/avito/android/lib/design/list_item/CompoundButtonListItem;Z)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface OnCheckedChangeListener {
        void onCheckedChanged(@NotNull CompoundButtonListItem compoundButtonListItem, boolean z);
    }

    public CompoundButtonListItem(@Nullable Context context) {
        this(context, null);
    }

    public final void addOnCheckedChangeListener(@NotNull OnCheckedChangeListener onCheckedChangeListener) {
        Intrinsics.checkNotNullParameter(onCheckedChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.j.add(onCheckedChangeListener);
        onBindCheckedChangeListener(this.l);
    }

    @Nullable
    public abstract CompoundButton getButtonView();

    @NotNull
    public final OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.l;
    }

    public abstract void onBindCheckedChangeListener(@NotNull OnCheckedChangeListener onCheckedChangeListener);

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            CompoundButton buttonView = getButtonView();
            if (buttonView != null) {
                buttonView.onRestoreInstanceState(savedState.getCompoundButtonState());
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    @NotNull
    public Parcelable onSaveInstanceState() {
        CompoundButton buttonView = getButtonView();
        Parcelable onSaveInstanceState = buttonView != null ? buttonView.onSaveInstanceState() : null;
        Parcelable onSaveInstanceState2 = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState2);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState2, "super.onSaveInstanceState()!!");
        return new SavedState(onSaveInstanceState, onSaveInstanceState2);
    }

    @Override // android.view.View
    public boolean performClick() {
        CompoundButton buttonView;
        if (this.k && (buttonView = getButtonView()) != null) {
            buttonView.performClick();
        }
        return super.performClick();
    }

    public final void removeOnCheckedChangeListener(@NotNull OnCheckedChangeListener onCheckedChangeListener) {
        Intrinsics.checkNotNullParameter(onCheckedChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.j.remove(onCheckedChangeListener);
    }

    public final void setToggleByClickEnabled(boolean z) {
        this.k = z;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0013J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$SavedState;", "Landroid/view/AbsSavedState;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/os/Parcelable;", AuthSource.SEND_ABUSE, "Landroid/os/Parcelable;", "getCompoundButtonState", "()Landroid/os/Parcelable;", "compoundButtonState", "parcel", "<init>", "(Landroid/os/Parcel;)V", "superState", "(Landroid/os/Parcelable;Landroid/os/Parcelable;)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends AbsSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @Nullable
        public final Parcelable a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, SavedState> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public SavedState invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new SavedState(parcel2);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcel parcel) {
            super(parcel);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.a = parcel.readParcelable(CompoundButtonListItem.class.getClassLoader());
        }

        @Nullable
        public final Parcelable getCompoundButtonState() {
            return this.a;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@Nullable Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            if (parcel != null) {
                parcel.writeParcelable(this.a, i);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@Nullable Parcelable parcelable, @NotNull Parcelable parcelable2) {
            super(parcelable2);
            Intrinsics.checkNotNullParameter(parcelable2, "superState");
            this.a = parcelable;
        }
    }

    public CompoundButtonListItem(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CompoundButtonListItem(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = new ArrayList();
        this.k = true;
        this.l = new OnCheckedChangeListener(this) { // from class: com.avito.android.lib.design.list_item.CompoundButtonListItem$onCheckedChangeListener$1
            public final /* synthetic */ CompoundButtonListItem a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.lib.design.list_item.CompoundButtonListItem.OnCheckedChangeListener
            public void onCheckedChanged(@NotNull CompoundButtonListItem compoundButtonListItem, boolean z) {
                Intrinsics.checkNotNullParameter(compoundButtonListItem, "view");
                for (CompoundButtonListItem.OnCheckedChangeListener onCheckedChangeListener : this.a.j) {
                    onCheckedChangeListener.onCheckedChanged(compoundButtonListItem, z);
                }
            }
        };
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButtonListItem, i, 0);
        this.k = obtainStyledAttributes.getBoolean(R.styleable.CompoundButtonListItem_listItem_toggleByClick, true);
        obtainStyledAttributes.recycle();
    }
}
