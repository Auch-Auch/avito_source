package com.avito.android.advert_core.contactbar.feedback;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.avito.android.advert_core.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.bottom_sheet.RightCrossHeaderKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.input.InputExtensionsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\u001f !B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog;", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "", "onDetachedFromWindow", "()V", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "getState", "()Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Listener;", VKApiConst.VERSION, "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/reactivex/rxjava3/disposables/Disposable;", "t", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "Lcom/avito/android/lib/design/input/Input;", "s", "Lcom/avito/android/lib/design/input/Input;", "getInput", "()Lcom/avito/android/lib/design/input/Input;", "setInput", "(Lcom/avito/android/lib/design/input/Input;)V", "input", "u", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "state", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Listener;)V", "Listener", "Source", "State", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class FeedbackDialog extends BottomSheetDialog {
    @Nullable
    public Input s;
    public Disposable t;
    public final State u;
    public final Listener v;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Listener;", "", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;", "source", "", "onFeedbackClose", "(Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;)V", "", "feedback", "onFeedbackSend", "(Ljava/lang/String;Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onFeedbackClose(@Nullable Source source);

        void onFeedbackSend(@NotNull String str, @Nullable Source source);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTextValue", "()Ljava/lang/String;", "textValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "RENTALS_SURVEY", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public enum Source {
        RENTALS_SURVEY("rentals_survey");
        
        @NotNull
        public final String a;

        /* access modifiers changed from: public */
        Source(String str) {
            this.a = str;
        }

        @NotNull
        public final String getTextValue() {
            return this.a;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJP\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u000f\u001a\u00020\u00022\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0003\u0010\u0012\u001a\u00020\u00022\b\b\u0003\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0017\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0011\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\tR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u000eR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010,\u001a\u0004\b/\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010,\u001a\u0004\b4\u0010\u0004¨\u00067"}, d2 = {"Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "Landroid/os/Parcelable;", "", "component1", "()I", "component2", "()Ljava/lang/Integer;", "", "component3", "()Ljava/lang/String;", "component4", "component5", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;", "component6", "()Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;", "title", "subTitle", "userText", "userTextHint", "buttonText", "feedbackSource", "copy", "(ILjava/lang/Integer;Ljava/lang/String;IILcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;)Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/lang/String;", "getUserText", "f", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;", "getFeedbackSource", AuthSource.SEND_ABUSE, "I", "getTitle", "d", "getUserTextHint", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getSubTitle", "e", "getButtonText", "<init>", "(ILjava/lang/Integer;Ljava/lang/String;IILcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new Creator();
        public final int a;
        @Nullable
        public final Integer b;
        @NotNull
        public final String c;
        public final int d;
        public final int e;
        @Nullable
        public final Source f;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new State(parcel.readInt(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (Source) Enum.valueOf(Source.class, parcel.readString()) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State[] newArray(int i) {
                return new State[i];
            }
        }

        public State(@StringRes int i, @StringRes @Nullable Integer num, @NotNull String str, @StringRes int i2, @StringRes int i3, @Nullable Source source) {
            Intrinsics.checkNotNullParameter(str, "userText");
            this.a = i;
            this.b = num;
            this.c = str;
            this.d = i2;
            this.e = i3;
            this.f = source;
        }

        public static /* synthetic */ State copy$default(State state, int i, Integer num, String str, int i2, int i3, Source source, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = state.a;
            }
            if ((i4 & 2) != 0) {
                num = state.b;
            }
            if ((i4 & 4) != 0) {
                str = state.c;
            }
            if ((i4 & 8) != 0) {
                i2 = state.d;
            }
            if ((i4 & 16) != 0) {
                i3 = state.e;
            }
            if ((i4 & 32) != 0) {
                source = state.f;
            }
            return state.copy(i, num, str, i2, i3, source);
        }

        public final int component1() {
            return this.a;
        }

        @Nullable
        public final Integer component2() {
            return this.b;
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        public final int component4() {
            return this.d;
        }

        public final int component5() {
            return this.e;
        }

        @Nullable
        public final Source component6() {
            return this.f;
        }

        @NotNull
        public final State copy(@StringRes int i, @StringRes @Nullable Integer num, @NotNull String str, @StringRes int i2, @StringRes int i3, @Nullable Source source) {
            Intrinsics.checkNotNullParameter(str, "userText");
            return new State(i, num, str, i2, i3, source);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return this.a == state.a && Intrinsics.areEqual(this.b, state.b) && Intrinsics.areEqual(this.c, state.c) && this.d == state.d && this.e == state.e && Intrinsics.areEqual(this.f, state.f);
        }

        public final int getButtonText() {
            return this.e;
        }

        @Nullable
        public final Source getFeedbackSource() {
            return this.f;
        }

        @Nullable
        public final Integer getSubTitle() {
            return this.b;
        }

        public final int getTitle() {
            return this.a;
        }

        @NotNull
        public final String getUserText() {
            return this.c;
        }

        public final int getUserTextHint() {
            return this.d;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i = this.a * 31;
            Integer num = this.b;
            int i2 = 0;
            int hashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
            String str = this.c;
            int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.d) * 31) + this.e) * 31;
            Source source = this.f;
            if (source != null) {
                i2 = source.hashCode();
            }
            return hashCode2 + i2;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("State(title=");
            L.append(this.a);
            L.append(", subTitle=");
            L.append(this.b);
            L.append(", userText=");
            L.append(this.c);
            L.append(", userTextHint=");
            L.append(this.d);
            L.append(", buttonText=");
            L.append(this.e);
            L.append(", feedbackSource=");
            L.append(this.f);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.a);
            Integer num = this.b;
            if (num != null) {
                a2.b.a.a.a.H0(parcel, 1, num);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            Source source = this.f;
            if (source != null) {
                parcel.writeInt(1);
                parcel.writeString(source.name());
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ State(int i, Integer num, String str, int i2, int i3, Source source, int i4, j jVar) {
            this(i, num, str, i2, i3, (i4 & 32) != 0 ? null : source);
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FeedbackDialog a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FeedbackDialog feedbackDialog) {
            super(0);
            this.a = feedbackDialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Input input = this.a.getInput();
            if (input != null) {
                Keyboards.hideKeyboardWithAttempt$default(input, 0, 10, 1, null);
            }
            this.a.v.onFeedbackClose(this.a.u.getFeedbackSource());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedbackDialog(@NotNull Context context, @NotNull State state, @NotNull Listener listener) {
        super(context, R.style.FeedbackDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.u = state;
        this.v = listener;
        RightCrossHeaderKt.setRightCrossHeader(this, context.getText(state.getTitle()), true, true);
        setContentView(R.layout.no_call_feedback_content, new Function1<View, Unit>(this) { // from class: com.avito.android.advert_core.contactbar.feedback.FeedbackDialog.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(View view) {
                View view2 = view;
                Intrinsics.checkNotNullParameter(view2, "p1");
                FeedbackDialog.access$onViewInflate((FeedbackDialog) this.receiver, view2);
                return Unit.INSTANCE;
            }
        });
        setSkipCollapsed(true);
        setCanceledOnTouchOutside(true);
        setFitContentPeekHeight(true);
        setOnCloseListener(new b(this));
    }

    public static final void access$onViewInflate(FeedbackDialog feedbackDialog, View view) {
        InitialValueObservable<CharSequence> textChanges;
        Observable v3;
        Objects.requireNonNull(feedbackDialog);
        Button button = (Button) view.findViewById(R.id.no_call_feedback_button);
        button.setOnClickListener(new a2.a.a.g.e.i.a(feedbackDialog));
        button.setText(feedbackDialog.u.getButtonText());
        Input input = (Input) view.findViewById(R.id.no_call_feedback_input);
        feedbackDialog.s = input;
        Disposable disposable = null;
        if (input != null) {
            Input.setText$default(input, feedbackDialog.u.getUserText(), false, 2, null);
        }
        Input input2 = feedbackDialog.s;
        if (input2 != null) {
            input2.setHint(feedbackDialog.u.getUserTextHint());
        }
        TextView textView = (TextView) view.findViewById(R.id.no_call_feedback_title);
        if (feedbackDialog.u.getSubTitle() != null) {
            textView.setText(feedbackDialog.u.getSubTitle().intValue());
        } else {
            Views.hide(textView);
        }
        Input input3 = feedbackDialog.s;
        if (!(input3 == null || (textChanges = InputExtensionsKt.textChanges(input3)) == null || (v3 = InteropKt.toV3(textChanges)) == null)) {
            disposable = v3.subscribe(new a2.a.a.g.e.i.b(button));
        }
        feedbackDialog.t = disposable;
    }

    @Nullable
    public final Input getInput() {
        return this.s;
    }

    @NotNull
    public final State getState() {
        State state = this.u;
        Input input = this.s;
        String deformattedText = input != null ? input.getDeformattedText() : null;
        if (deformattedText == null) {
            deformattedText = "";
        }
        return State.copy$default(state, 0, null, deformattedText, 0, 0, null, 59, null);
    }

    @Override // com.avito.android.lib.design.bottom_sheet.BottomSheetDialog, android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable disposable = this.t;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void setInput(@Nullable Input input) {
        this.s = input;
    }
}
