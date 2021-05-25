package com.avito.android.util.text;

import android.content.Context;
import android.text.Editable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Logs;
import com.avito.android.util.TemplateFormatter;
import com.avito.android.util.text_style.TextStyleData;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0012¢\u0006\u0004\b\u001d\u0010\u001eB\t\b\u0017¢\u0006\u0004\b\u001d\u0010\u001fJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J#\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\nJ-\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\rJ7\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/avito/android/util/text/AttributedTextFormatterImpl;", "Lcom/avito/android/util/text/AttributedTextFormatter;", "Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", "", "formatIgnoreColors", "(Lcom/avito/android/remote/model/text/AttributedText;)Ljava/lang/CharSequence;", "format", "Landroid/content/Context;", "context", "(Landroid/content/Context;Lcom/avito/android/remote/model/text/AttributedText;)Ljava/lang/CharSequence;", "Lcom/avito/android/util/text_style/TextStyleData;", "textStyleData", "(Landroid/content/Context;Lcom/avito/android/util/text_style/TextStyleData;Lcom/avito/android/remote/model/text/AttributedText;)Ljava/lang/CharSequence;", "", "ignoreColors", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/text/AttributedText;Landroid/content/Context;Lcom/avito/android/util/text_style/TextStyleData;Z)Ljava/lang/CharSequence;", "Lkotlin/Function1;", "c", "Lkotlin/jvm/functions/Function1;", "onError", "Lcom/avito/android/util/TemplateFormatter;", "Lcom/avito/android/util/TemplateFormatter;", "templateFormatter", "Lcom/avito/android/util/text/FormatterRule;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/text/FormatterRule;", "rule", "<init>", "(Lcom/avito/android/util/text/FormatterRule;Lkotlin/jvm/functions/Function1;)V", "()V", "text-formatters_release"}, k = 1, mv = {1, 4, 2})
public final class AttributedTextFormatterImpl implements AttributedTextFormatter {
    public final TemplateFormatter a;
    public final FormatterRule b;
    public final Function1<CharSequence, CharSequence> c;

    public static final class a extends Lambda implements Function1<CharSequence, CharSequence> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "it");
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.CharSequence, ? extends java.lang.CharSequence> */
    /* JADX WARN: Multi-variable type inference failed */
    public AttributedTextFormatterImpl(@NotNull FormatterRule formatterRule, @NotNull Function1<? super CharSequence, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(formatterRule, "rule");
        Intrinsics.checkNotNullParameter(function1, "onError");
        this.b = formatterRule;
        this.c = function1;
        this.a = new TemplateFormatter();
    }

    public final CharSequence a(AttributedText attributedText, Context context, TextStyleData textStyleData, boolean z) {
        if (attributedText == null) {
            return null;
        }
        CharSequence format = this.a.format(attributedText.getText(), new TemplateFormatter.Visitor(this, attributedText, context, textStyleData, z) { // from class: com.avito.android.util.text.AttributedTextFormatterImpl$privateFormat$charSequence$1
            public final /* synthetic */ AttributedTextFormatterImpl a;
            public final /* synthetic */ AttributedText b;
            public final /* synthetic */ Context c;
            public final /* synthetic */ TextStyleData d;
            public final /* synthetic */ boolean e;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            @Override // com.avito.android.util.TemplateFormatter.Visitor
            public void visit(@NotNull Editable editable, @NotNull String str, int i, int i2) {
                T t;
                Intrinsics.checkNotNullParameter(editable, "editable");
                Intrinsics.checkNotNullParameter(str, "template");
                String obj = editable.subSequence(i, i2).toString();
                Iterator<T> it = this.b.getAttributes().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (Intrinsics.areEqual(t.getName(), str)) {
                        break;
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    this.a.b.apply(this.c, this.d, this.e, editable, i, obj, t2, this.b);
                }
            }
        });
        if (!StringsKt__StringsKt.contains$default(format, (CharSequence) "{{", false, 2, (Object) null) && !StringsKt__StringsKt.contains$default(format, (CharSequence) "}}", false, 2, (Object) null)) {
            return format;
        }
        Logs.debug$default("AttributedTextFormatter", "Unsupported format: " + format, null, 4, null);
        return this.c.invoke(format);
    }

    @Override // com.avito.android.util.text.AttributedTextFormatter
    @Nullable
    public CharSequence format(@Nullable AttributedText attributedText) {
        return a(attributedText, null, null, false);
    }

    @Override // com.avito.android.util.text.AttributedTextFormatter
    @Nullable
    public CharSequence formatIgnoreColors(@Nullable AttributedText attributedText) {
        return a(attributedText, null, null, true);
    }

    @Override // com.avito.android.util.text.AttributedTextFormatter
    @Nullable
    public CharSequence format(@NotNull Context context, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(attributedText, context, null, false);
    }

    @Inject
    public AttributedTextFormatterImpl() {
        this(new FormatterRuleImpl(), a.a);
    }

    @Override // com.avito.android.util.text.AttributedTextFormatter
    @Nullable
    public CharSequence format(@NotNull Context context, @Nullable TextStyleData textStyleData, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(attributedText, context, textStyleData, false);
    }
}
