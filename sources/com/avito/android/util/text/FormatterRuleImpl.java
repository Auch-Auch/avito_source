package com.avito.android.util.text;

import a2.b.a.a.a;
import android.content.Context;
import android.text.Editable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.deep_linking.links.OnUrlClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.text.Attribute;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.text.DateAttribute;
import com.avito.android.remote.model.text.DeepLinkAttribute;
import com.avito.android.remote.model.text.FontAttribute;
import com.avito.android.remote.model.text.FontParameter;
import com.avito.android.remote.model.text.LinkAttribute;
import com.avito.android.remote.model.text.UnknownAttribute;
import com.avito.android.util.DeepLinkSpan;
import com.avito.android.util.UrlSpan;
import com.avito.android.util.color.ColorFormatter;
import com.avito.android.util.text_style.TextStyleData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJS\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u0012*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/util/text/FormatterRuleImpl;", "Lcom/avito/android/util/text/FormatterRule;", "Landroid/content/Context;", "context", "Lcom/avito/android/util/text_style/TextStyleData;", "textStyleData", "", "ignoreColors", "Landroid/text/Editable;", "editable", "", FirebaseAnalytics.Param.INDEX, "", "key", "Lcom/avito/android/remote/model/text/Attribute;", "attribute", "Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", "", "apply", "(Landroid/content/Context;Lcom/avito/android/util/text_style/TextStyleData;ZLandroid/text/Editable;ILjava/lang/String;Lcom/avito/android/remote/model/text/Attribute;Lcom/avito/android/remote/model/text/AttributedText;)V", "Landroid/text/style/CharacterStyle;", AuthSource.SEND_ABUSE, "(Landroid/content/Context;Lcom/avito/android/util/text_style/TextStyleData;)Landroid/text/style/CharacterStyle;", "Lcom/avito/android/util/text/FormatterRuleImpl$SpanPlacement;", "spanPlacement", AuthSource.BOOKING_ORDER, "(Landroid/text/Editable;Lcom/avito/android/util/text/FormatterRuleImpl$SpanPlacement;)V", "<init>", "()V", "SpanPlacement", "text-formatters_release"}, k = 1, mv = {1, 4, 2})
public final class FormatterRuleImpl implements FormatterRule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/avito/android/util/text/FormatterRuleImpl$SpanPlacement;", "", "Landroid/text/style/CharacterStyle;", "component1", "()Landroid/text/style/CharacterStyle;", "", "component2", "()I", "component3", "span", "from", "to", "copy", "(Landroid/text/style/CharacterStyle;II)Lcom/avito/android/util/text/FormatterRuleImpl$SpanPlacement;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "I", "getTo", AuthSource.BOOKING_ORDER, "getFrom", AuthSource.SEND_ABUSE, "Landroid/text/style/CharacterStyle;", "getSpan", "<init>", "(Landroid/text/style/CharacterStyle;II)V", "text-formatters_release"}, k = 1, mv = {1, 4, 2})
    public static final class SpanPlacement {
        @NotNull
        public final CharacterStyle a;
        public final int b;
        public final int c;

        public SpanPlacement(@NotNull CharacterStyle characterStyle, int i, int i2) {
            Intrinsics.checkNotNullParameter(characterStyle, "span");
            this.a = characterStyle;
            this.b = i;
            this.c = i2;
        }

        public static /* synthetic */ SpanPlacement copy$default(SpanPlacement spanPlacement, CharacterStyle characterStyle, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                characterStyle = spanPlacement.a;
            }
            if ((i3 & 2) != 0) {
                i = spanPlacement.b;
            }
            if ((i3 & 4) != 0) {
                i2 = spanPlacement.c;
            }
            return spanPlacement.copy(characterStyle, i, i2);
        }

        @NotNull
        public final CharacterStyle component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        public final int component3() {
            return this.c;
        }

        @NotNull
        public final SpanPlacement copy(@NotNull CharacterStyle characterStyle, int i, int i2) {
            Intrinsics.checkNotNullParameter(characterStyle, "span");
            return new SpanPlacement(characterStyle, i, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpanPlacement)) {
                return false;
            }
            SpanPlacement spanPlacement = (SpanPlacement) obj;
            return Intrinsics.areEqual(this.a, spanPlacement.a) && this.b == spanPlacement.b && this.c == spanPlacement.c;
        }

        public final int getFrom() {
            return this.b;
        }

        @NotNull
        public final CharacterStyle getSpan() {
            return this.a;
        }

        public final int getTo() {
            return this.c;
        }

        public int hashCode() {
            CharacterStyle characterStyle = this.a;
            return ((((characterStyle != null ? characterStyle.hashCode() : 0) * 31) + this.b) * 31) + this.c;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("SpanPlacement(span=");
            L.append(this.a);
            L.append(", from=");
            L.append(this.b);
            L.append(", to=");
            return a.j(L, this.c, ")");
        }
    }

    public final CharacterStyle a(Context context, TextStyleData textStyleData) {
        int linkStyle = textStyleData != null ? textStyleData.getLinkStyle() : 0;
        if (context == null || linkStyle == 0) {
            return null;
        }
        return new AvitoTextAppearanceSpan(context, linkStyle);
    }

    @Override // com.avito.android.util.text.FormatterRule
    public void apply(@Nullable Context context, @Nullable TextStyleData textStyleData, boolean z, @NotNull Editable editable, int i, @NotNull String str, @NotNull Attribute attribute, @NotNull AttributedText attributedText) {
        T t;
        String str2;
        CharacterStyle characterStyle;
        Integer paragraphSpacing;
        Intrinsics.checkNotNullParameter(editable, "editable");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(attributedText, "attributedText");
        boolean z2 = false;
        if (attribute instanceof DeepLinkAttribute) {
            editable.replace(i, str.length() + i, attribute.getTitle());
            CharacterStyle a = a(context, textStyleData);
            if (a != null) {
                b(editable, new SpanPlacement(a, i, attribute.getTitle().length() + i));
            }
            DeepLink deepLink = ((DeepLinkAttribute) attribute).getDeepLink();
            FormatterRuleImpl$apply$1 formatterRuleImpl$apply$1 = new OnDeepLinkClickListener(attributedText) { // from class: com.avito.android.util.text.FormatterRuleImpl$apply$1
                public final /* synthetic */ AttributedText a;

                {
                    this.a = r1;
                }

                @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
                public void onDeepLinkClick(@NotNull DeepLink deepLink2) {
                    Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
                    OnDeepLinkClickListener onDeepLinkClickListener = this.a.getOnDeepLinkClickListener();
                    if (onDeepLinkClickListener != null) {
                        onDeepLinkClickListener.onDeepLinkClick(deepLink2);
                    }
                }
            };
            if (textStyleData == null || textStyleData.getTextColorLink() != null) {
                z2 = true;
            }
            b(editable, new SpanPlacement(new DeepLinkSpan(deepLink, formatterRuleImpl$apply$1, z2), i, attribute.getTitle().length() + i));
        } else if (attribute instanceof LinkAttribute) {
            editable.replace(i, str.length() + i, attribute.getTitle());
            CharacterStyle a3 = a(context, textStyleData);
            if (a3 != null) {
                b(editable, new SpanPlacement(a3, i, attribute.getTitle().length() + i));
            }
            String url = ((LinkAttribute) attribute).getUrl();
            OnUrlClickListener onUrlClickListener = attributedText.getOnUrlClickListener();
            if (textStyleData == null || textStyleData.getTextColorLink() != null) {
                z2 = true;
            }
            b(editable, new SpanPlacement(new UrlSpan(url, onUrlClickListener, z2), i, attribute.getTitle().length() + i));
        } else if (attribute instanceof FontAttribute) {
            FontAttribute fontAttribute = (FontAttribute) attribute;
            Iterator<T> it = fontAttribute.getParameters().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (t instanceof FontParameter.UseParagraphingParameter) {
                    break;
                }
            }
            if (t != null) {
                str2 = m.replace$default(attribute.getTitle(), "\n", "\n\n", false, 4, (Object) null);
            } else {
                str2 = attribute.getTitle();
            }
            editable.replace(i, str.length() + i, str2);
            int length = str2.length() + i;
            ArrayList arrayList = new ArrayList();
            List<FontParameter> parameters = fontAttribute.getParameters();
            if (z) {
                ArrayList arrayList2 = new ArrayList();
                for (T t2 : parameters) {
                    if (!(t2 instanceof FontParameter.ColorParameter)) {
                        arrayList2.add(t2);
                    }
                }
                parameters = arrayList2;
            }
            for (T t3 : parameters) {
                if (t3 instanceof FontParameter.StyleParameter) {
                    String style = t3.getStyle();
                    arrayList.add(new SpanPlacement(new StyleSpan((style.hashCode() == 3029637 && style.equals("bold")) ? 1 : 0), i, length));
                } else if (t3 instanceof FontParameter.ColorParameter) {
                    ColorFormatter colorFormatter = ColorFormatter.INSTANCE;
                    T t4 = t3;
                    String colorKey = t4.getColorKey();
                    int value = t4.getColor().getValue();
                    Color colorDark = t4.getColorDark();
                    if (colorDark == null) {
                        colorDark = t4.getColor();
                    }
                    arrayList.add(new SpanPlacement(new ForegroundColorSpan(colorFormatter.formatColor(context, colorKey, value, colorDark.getValue())), i, length));
                } else if (t3 instanceof FontParameter.TextStyleParameter) {
                    Integer styleId = TextStyleAttributeFormatter.INSTANCE.getStyleId(context, t3);
                    if (styleId != null) {
                        int intValue = styleId.intValue();
                        if (context != null) {
                            arrayList.add(new SpanPlacement(new AvitoTextAppearanceSpan(context, intValue), i, length));
                        }
                    }
                } else if (t3 instanceof FontParameter.StrikethroughParameter) {
                    arrayList.add(new SpanPlacement(new StrikethroughSpan(), i, length));
                } else if (t3 instanceof FontParameter.UseParagraphingParameter) {
                    Matcher matcher = Pattern.compile("\n\n").matcher(str2);
                    Intrinsics.checkNotNullExpressionValue(matcher, "Pattern\n                …          .matcher(title)");
                    if (t3 instanceof FontParameter.ParagraphSpacingRelativeParameter) {
                        characterStyle = new RelativeSizeSpan(t3.getValue());
                    } else if (textStyleData == null || (paragraphSpacing = textStyleData.getParagraphSpacing()) == null) {
                        characterStyle = new RelativeSizeSpan(1.0f);
                    } else {
                        characterStyle = new AbsoluteSizeSpan(paragraphSpacing.intValue());
                    }
                    while (matcher.find()) {
                        arrayList.add(new SpanPlacement(characterStyle, matcher.start() + 1, matcher.end()));
                    }
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                b(editable, (SpanPlacement) it2.next());
            }
        } else if (attribute instanceof DateAttribute) {
            DateAttribute dateAttribute = (DateAttribute) attribute;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateAttribute.getFormat(), Locale.getDefault());
            Long timestamp = dateAttribute.getTimestamp();
            editable.replace(i, str.length() + i, simpleDateFormat.format(new Date((timestamp != null ? timestamp.longValue() : 0) * 1000)));
        } else {
            boolean z3 = attribute instanceof UnknownAttribute;
        }
    }

    public final void b(Editable editable, SpanPlacement spanPlacement) {
        editable.setSpan(spanPlacement.getSpan(), spanPlacement.getFrom(), spanPlacement.getTo(), 0);
    }
}
