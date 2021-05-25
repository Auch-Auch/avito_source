package com.redmadrobot.inputmask.helper;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.redmadrobot.inputmask.helper.Compiler;
import com.redmadrobot.inputmask.model.CaretString;
import com.redmadrobot.inputmask.model.Next;
import com.redmadrobot.inputmask.model.Notation;
import com.redmadrobot.inputmask.model.State;
import com.redmadrobot.inputmask.model.state.EOLState;
import com.redmadrobot.inputmask.model.state.FixedState;
import com.redmadrobot.inputmask.model.state.FreeState;
import com.redmadrobot.inputmask.model.state.OptionalValueState;
import com.redmadrobot.inputmask.model.state.ValueState;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 &2\u00020\u0001:\u0003\u0015&'B\u001d\u0012\u0006\u0010\"\u001a\u00020\n\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b#\u0010$B\u0011\b\u0016\u0012\u0006\u0010\"\u001a\u00020\n¢\u0006\u0004\b#\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u000fJ\r\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u000fJ!\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010 ¨\u0006("}, d2 = {"Lcom/redmadrobot/inputmask/helper/Mask;", "", "Lcom/redmadrobot/inputmask/model/CaretString;", "text", "Lcom/redmadrobot/inputmask/helper/Mask$Result;", "apply", "(Lcom/redmadrobot/inputmask/model/CaretString;)Lcom/redmadrobot/inputmask/helper/Mask$Result;", "Lcom/redmadrobot/inputmask/helper/CaretStringIterator;", "makeIterator", "(Lcom/redmadrobot/inputmask/model/CaretString;)Lcom/redmadrobot/inputmask/helper/CaretStringIterator;", "", InternalConstsKt.PLACEHOLDER, "()Ljava/lang/String;", "", "acceptableTextLength", "()I", "totalTextLength", "acceptableValueLength", "totalValueLength", "Lcom/redmadrobot/inputmask/model/State;", "state", AuthSource.SEND_ABUSE, "(Lcom/redmadrobot/inputmask/model/State;Ljava/lang/String;)Ljava/lang/String;", "", AuthSource.BOOKING_ORDER, "(Lcom/redmadrobot/inputmask/model/State;)Z", "", "Lcom/redmadrobot/inputmask/model/Notation;", "Ljava/util/List;", "getCustomNotations", "()Ljava/util/List;", "customNotations", "Lcom/redmadrobot/inputmask/model/State;", "initialState", "format", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "(Ljava/lang/String;)V", "Factory", "Result", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public class Mask {
    public static final Factory Factory = new Factory(null);
    public static final Map<String, Mask> c = new HashMap();
    public final State a;
    @NotNull
    public final List<Notation> b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Mask$Factory;", "", "", "format", "", "Lcom/redmadrobot/inputmask/model/Notation;", "customNotations", "Lcom/redmadrobot/inputmask/helper/Mask;", "getOrCreate", "(Ljava/lang/String;Ljava/util/List;)Lcom/redmadrobot/inputmask/helper/Mask;", "", "isValid", "(Ljava/lang/String;Ljava/util/List;)Z", "", "cache", "Ljava/util/Map;", "<init>", "()V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
    public static final class Factory {
        public Factory() {
        }

        @NotNull
        public final Mask getOrCreate(@NotNull String str, @NotNull List<Notation> list) {
            Intrinsics.checkParameterIsNotNull(str, "format");
            Intrinsics.checkParameterIsNotNull(list, "customNotations");
            Mask mask = (Mask) Mask.c.get(str);
            if (mask != null) {
                return mask;
            }
            Mask mask2 = new Mask(str, list);
            Mask.c.put(str, mask2);
            return mask2;
        }

        public final boolean isValid(@NotNull String str, @NotNull List<Notation> list) {
            Intrinsics.checkParameterIsNotNull(str, "format");
            Intrinsics.checkParameterIsNotNull(list, "customNotations");
            try {
                new Mask(str, list);
                return true;
            } catch (Compiler.FormatError unused) {
                return false;
            }
        }

        public Factory(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b'\u0010(J\r\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ8\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0016\u0010\tJ\u0010\u0010\u0017\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\fJ\u001a\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0011\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\tR\u0019\u0010\u0012\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\fR\u0019\u0010\u0013\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0006¨\u0006)"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Mask$Result;", "", "reversed", "()Lcom/redmadrobot/inputmask/helper/Mask$Result;", "Lcom/redmadrobot/inputmask/model/CaretString;", "component1", "()Lcom/redmadrobot/inputmask/model/CaretString;", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "", "component4", "()Z", "formattedText", "extractedValue", "affinity", Tracker.Events.CREATIVE_COMPLETE, "copy", "(Lcom/redmadrobot/inputmask/model/CaretString;Ljava/lang/String;IZ)Lcom/redmadrobot/inputmask/helper/Mask$Result;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getExtractedValue", "c", "I", "getAffinity", "d", "Z", "getComplete", AuthSource.SEND_ABUSE, "Lcom/redmadrobot/inputmask/model/CaretString;", "getFormattedText", "<init>", "(Lcom/redmadrobot/inputmask/model/CaretString;Ljava/lang/String;IZ)V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
    public static final class Result {
        @NotNull
        public final CaretString a;
        @NotNull
        public final String b;
        public final int c;
        public final boolean d;

        public Result(@NotNull CaretString caretString, @NotNull String str, int i, boolean z) {
            Intrinsics.checkParameterIsNotNull(caretString, "formattedText");
            Intrinsics.checkParameterIsNotNull(str, "extractedValue");
            this.a = caretString;
            this.b = str;
            this.c = i;
            this.d = z;
        }

        @NotNull
        public static /* synthetic */ Result copy$default(Result result, CaretString caretString, String str, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                caretString = result.a;
            }
            if ((i2 & 2) != 0) {
                str = result.b;
            }
            if ((i2 & 4) != 0) {
                i = result.c;
            }
            if ((i2 & 8) != 0) {
                z = result.d;
            }
            return result.copy(caretString, str, i, z);
        }

        @NotNull
        public final CaretString component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        public final int component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        @NotNull
        public final Result copy(@NotNull CaretString caretString, @NotNull String str, int i, boolean z) {
            Intrinsics.checkParameterIsNotNull(caretString, "formattedText");
            Intrinsics.checkParameterIsNotNull(str, "extractedValue");
            return new Result(caretString, str, i, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Result) {
                    Result result = (Result) obj;
                    if (Intrinsics.areEqual(this.a, result.a) && Intrinsics.areEqual(this.b, result.b)) {
                        if (this.c == result.c) {
                            if (this.d == result.d) {
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public final int getAffinity() {
            return this.c;
        }

        public final boolean getComplete() {
            return this.d;
        }

        @NotNull
        public final String getExtractedValue() {
            return this.b;
        }

        @NotNull
        public final CaretString getFormattedText() {
            return this.a;
        }

        public int hashCode() {
            CaretString caretString = this.a;
            int i = 0;
            int hashCode = (caretString != null ? caretString.hashCode() : 0) * 31;
            String str = this.b;
            if (str != null) {
                i = str.hashCode();
            }
            int i2 = (((hashCode + i) * 31) + this.c) * 31;
            boolean z = this.d;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return i2 + i3;
        }

        @NotNull
        public final Result reversed() {
            CaretString reversed = this.a.reversed();
            String str = this.b;
            if (str != null) {
                return new Result(reversed, StringsKt___StringsKt.reversed(str).toString(), this.c, this.d);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Result(formattedText=");
            L.append(this.a);
            L.append(", extractedValue=");
            L.append(this.b);
            L.append(", affinity=");
            L.append(this.c);
            L.append(", complete=");
            return a2.b.a.a.a.B(L, this.d, ")");
        }
    }

    public static final class a extends Stack<Next> {
        @Nullable
        public Next a(@Nullable Next next) {
            if (next != null) {
                return (Next) super.push(next);
            }
            removeAllElements();
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Vector, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof Next : true) {
                return super.contains((Next) obj);
            }
            return false;
        }

        @Override // java.util.List, java.util.Vector, java.util.AbstractList
        public final /* bridge */ int indexOf(Object obj) {
            if (obj != null ? obj instanceof Next : true) {
                return super.indexOf((Next) obj);
            }
            return -1;
        }

        @Override // java.util.List, java.util.Vector, java.util.AbstractList
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj != null ? obj instanceof Next : true) {
                return super.lastIndexOf((Next) obj);
            }
            return -1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.util.Stack
        public Next push(Next next) {
            Next next2 = next;
            if (next2 != null) {
                return (Next) super.push(next2);
            }
            removeAllElements();
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Vector, java.util.Collection
        public final /* bridge */ boolean remove(Object obj) {
            if (obj != null ? obj instanceof Next : true) {
                return super.remove((Next) obj);
            }
            return false;
        }
    }

    public Mask(@NotNull String str, @NotNull List<Notation> list) {
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(list, "customNotations");
        this.b = list;
        this.a = new Compiler(list).compile(str);
    }

    public final String a(State state, String str) {
        if (state == null || (state instanceof EOLState)) {
            return str;
        }
        if (state instanceof FixedState) {
            State child = state.getChild();
            StringBuilder L = a2.b.a.a.a.L(str);
            L.append(((FixedState) state).getOwnCharacter());
            return a(child, L.toString());
        } else if (state instanceof FreeState) {
            State child2 = state.getChild();
            StringBuilder L2 = a2.b.a.a.a.L(str);
            L2.append(((FreeState) state).getOwnCharacter());
            return a(child2, L2.toString());
        } else if (state instanceof OptionalValueState) {
            OptionalValueState optionalValueState = (OptionalValueState) state;
            OptionalValueState.StateType type = optionalValueState.getType();
            if (type instanceof OptionalValueState.StateType.AlphaNumeric) {
                State child3 = state.getChild();
                return a(child3, str + "-");
            } else if (type instanceof OptionalValueState.StateType.Literal) {
                State child4 = state.getChild();
                return a(child4, str + AuthSource.SEND_ABUSE);
            } else if (type instanceof OptionalValueState.StateType.Numeric) {
                State child5 = state.getChild();
                return a(child5, str + "0");
            } else if (type instanceof OptionalValueState.StateType.Custom) {
                State child6 = state.getChild();
                StringBuilder L3 = a2.b.a.a.a.L(str);
                L3.append(((OptionalValueState.StateType.Custom) optionalValueState.getType()).getCharacter());
                return a(child6, L3.toString());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!(state instanceof ValueState)) {
            return str;
        } else {
            ValueState valueState = (ValueState) state;
            ValueState.StateType type2 = valueState.getType();
            if (type2 instanceof ValueState.StateType.AlphaNumeric) {
                State child7 = state.getChild();
                return a(child7, str + "-");
            } else if (type2 instanceof ValueState.StateType.Literal) {
                State child8 = state.getChild();
                return a(child8, str + AuthSource.SEND_ABUSE);
            } else if (type2 instanceof ValueState.StateType.Numeric) {
                State child9 = state.getChild();
                return a(child9, str + "0");
            } else if (type2 instanceof ValueState.StateType.Ellipsis) {
                return str;
            } else {
                if (type2 instanceof ValueState.StateType.Custom) {
                    State child10 = state.getChild();
                    StringBuilder L4 = a2.b.a.a.a.L(str);
                    L4.append(((ValueState.StateType.Custom) valueState.getType()).getCharacter());
                    return a(child10, L4.toString());
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final int acceptableTextLength() {
        State state = this.a;
        int i = 0;
        while (state != null && !(state instanceof EOLState)) {
            if ((state instanceof FixedState) || (state instanceof FreeState) || (state instanceof ValueState)) {
                i++;
            }
            state = state.getChild();
        }
        return i;
    }

    public final int acceptableValueLength() {
        State state = this.a;
        int i = 0;
        while (state != null && !(state instanceof EOLState)) {
            if ((state instanceof FixedState) || (state instanceof ValueState)) {
                i++;
            }
            state = state.getChild();
        }
        return i;
    }

    @NotNull
    public Result apply(@NotNull CaretString caretString) {
        Next autocomplete;
        Intrinsics.checkParameterIsNotNull(caretString, "text");
        CaretStringIterator makeIterator = makeIterator(caretString);
        int caretPosition = caretString.getCaretPosition();
        State state = this.a;
        a aVar = new a();
        boolean insertionAffectsCaret = makeIterator.insertionAffectsCaret();
        boolean deletionAffectsCaret = makeIterator.deletionAffectsCaret();
        Character next = makeIterator.next();
        int i = 0;
        String str = "";
        String str2 = str;
        while (next != null) {
            Next accept = state.accept(next.charValue());
            if (accept != null) {
                if (deletionAffectsCaret) {
                    aVar.a(state.autocomplete());
                }
                state = accept.getState();
                StringBuilder L = a2.b.a.a.a.L(str);
                Character insert = accept.getInsert();
                if (insert == null) {
                    insert = "";
                }
                L.append(insert);
                str = L.toString();
                StringBuilder L2 = a2.b.a.a.a.L(str2);
                Character value = accept.getValue();
                if (value == null) {
                    value = "";
                }
                L2.append(value);
                str2 = L2.toString();
                if (accept.getPass()) {
                    insertionAffectsCaret = makeIterator.insertionAffectsCaret();
                    deletionAffectsCaret = makeIterator.deletionAffectsCaret();
                    next = makeIterator.next();
                    i++;
                } else if (insertionAffectsCaret && accept.getInsert() != null) {
                    caretPosition++;
                }
            } else {
                if (deletionAffectsCaret) {
                    caretPosition--;
                }
                insertionAffectsCaret = makeIterator.insertionAffectsCaret();
                deletionAffectsCaret = makeIterator.deletionAffectsCaret();
                next = makeIterator.next();
            }
            i--;
        }
        while (caretString.getCaretGravity().getAutocomplete() && insertionAffectsCaret && (autocomplete = state.autocomplete()) != null) {
            state = autocomplete.getState();
            StringBuilder L3 = a2.b.a.a.a.L(str);
            Character insert2 = autocomplete.getInsert();
            if (insert2 == null) {
                insert2 = "";
            }
            L3.append(insert2);
            str = L3.toString();
            StringBuilder L4 = a2.b.a.a.a.L(str2);
            Character value2 = autocomplete.getValue();
            if (value2 == null) {
                value2 = "";
            }
            L4.append(value2);
            str2 = L4.toString();
            if (autocomplete.getInsert() != null) {
                caretPosition++;
            }
        }
        while (caretString.getCaretGravity().getAutoskip() && !aVar.empty()) {
            Object pop = aVar.pop();
            Intrinsics.checkExpressionValueIsNotNull(pop, "autocompletionStack.pop()");
            Next next2 = (Next) pop;
            if (str.length() == caretPosition) {
                if (next2.getInsert() != null) {
                    Character insert3 = next2.getInsert();
                    char last = StringsKt___StringsKt.last(str);
                    if (insert3 != null && insert3.charValue() == last) {
                        caretPosition--;
                        str = StringsKt___StringsKt.dropLast(str, 1);
                    }
                }
                if (next2.getValue() != null) {
                    Character value3 = next2.getValue();
                    char last2 = StringsKt___StringsKt.last(str2);
                    if (value3 != null && value3.charValue() == last2) {
                        str2 = StringsKt___StringsKt.dropLast(str2, 1);
                    }
                }
            } else if (next2.getInsert() != null) {
                caretPosition--;
            }
        }
        return new Result(new CaretString(str, caretPosition, caretString.getCaretGravity()), str2, i, b(state));
    }

    public final boolean b(State state) {
        if (state instanceof EOLState) {
            return true;
        }
        if (state instanceof ValueState) {
            return ((ValueState) state).isElliptical();
        }
        if (state instanceof FixedState) {
            return false;
        }
        return b(state.nextState());
    }

    @NotNull
    public final List<Notation> getCustomNotations() {
        return this.b;
    }

    @NotNull
    public CaretStringIterator makeIterator(@NotNull CaretString caretString) {
        Intrinsics.checkParameterIsNotNull(caretString, "text");
        return new CaretStringIterator(caretString, 0, 2, null);
    }

    @NotNull
    public final String placeholder() {
        return a(this.a, "");
    }

    public final int totalTextLength() {
        State state = this.a;
        int i = 0;
        while (state != null && !(state instanceof EOLState)) {
            if ((state instanceof FixedState) || (state instanceof FreeState) || (state instanceof ValueState) || (state instanceof OptionalValueState)) {
                i++;
            }
            state = state.getChild();
        }
        return i;
    }

    public final int totalValueLength() {
        State state = this.a;
        int i = 0;
        while (state != null && !(state instanceof EOLState)) {
            if ((state instanceof FixedState) || (state instanceof ValueState) || (state instanceof OptionalValueState)) {
                i++;
            }
            state = state.getChild();
        }
        return i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Mask(@NotNull String str) {
        this(str, CollectionsKt__CollectionsKt.emptyList());
        Intrinsics.checkParameterIsNotNull(str, "format");
    }
}
