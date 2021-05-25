package com.avito.android.publish.premoderation;

import a2.a.a.e2.y.e;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.avito.android.component.radio_button.RadioButton;
import com.avito.android.component.radio_button.RadioButtonImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001cB)\b\u0017\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ?\u0010\n\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/avito/android/publish/premoderation/SelectListWidget;", "Landroid/widget/LinearLayout;", "", "Lcom/avito/android/publish/premoderation/SelectListWidget$Data;", "items", "checkedItem", "Lkotlin/Function2;", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValues", "(Ljava/util/List;Lcom/avito/android/publish/premoderation/SelectListWidget$Data;Lkotlin/jvm/functions/Function2;)V", "Lcom/avito/android/component/radio_button/RadioButton;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/component/radio_button/RadioButton;", "lastSelected", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "radioButtons", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Data", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class SelectListWidget extends LinearLayout {
    public final List<RadioButton> a;
    public RadioButton b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/premoderation/SelectListWidget$Data;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "c", "getItemId", "itemId", AuthSource.SEND_ABUSE, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Data {
        @NotNull
        public final String a;
        @Nullable
        public final String b;
        @NotNull
        public final String c;

        public Data(@NotNull String str, @Nullable String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str3, "itemId");
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @NotNull
        public final String getItemId() {
            return this.c;
        }

        @Nullable
        public final String getSubtitle() {
            return this.b;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }
    }

    @JvmOverloads
    @SuppressLint({"NewApi"})
    public SelectListWidget(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    @SuppressLint({"NewApi"})
    public SelectListWidget(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @JvmOverloads
    @SuppressLint({"NewApi"})
    public SelectListWidget(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ArrayList();
        setOrientation(1);
    }

    public final void setValues(@NotNull List<Data> list, @Nullable Data data, @NotNull Function2<? super Data, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.a.size() != list.size()) {
            this.a.clear();
            removeAllViews();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.radio_button, (ViewGroup) null);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                View findViewById = inflate.findViewById(R.id.radio_button);
                Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.RadioButton");
                ((android.widget.RadioButton) findViewById).setSaveEnabled(false);
                RadioButtonImpl radioButtonImpl = new RadioButtonImpl(inflate);
                addView(inflate);
                this.a.add(radioButtonImpl);
            }
        }
        for (Pair pair : CollectionsKt___CollectionsKt.zip(list, this.a)) {
            Data data2 = (Data) pair.component1();
            RadioButton radioButton = (RadioButton) pair.component2();
            boolean areEqual = Intrinsics.areEqual(data != null ? data.getItemId() : null, data2.getItemId());
            radioButton.setTitle(data2.getTitle());
            radioButton.setSubtitle(data2.getSubtitle());
            if (areEqual) {
                radioButton.setChecked(areEqual);
                this.b = radioButton;
            }
            radioButton.setOnCheckedChangeListener(new e(this, radioButton, function2, data2));
        }
        if (data != null) {
            function2.invoke(data, Boolean.TRUE);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectListWidget(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
