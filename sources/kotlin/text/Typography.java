package kotlin.text;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0002\b+\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b+\u0010,R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0016\u0010\u0018\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0016\u0010\u001a\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0016\u0010\u001c\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0016\u0010\u001d\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0016\u0010\u001e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0016\u0010\u001f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u0004R\u0016\u0010 \u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u0004R\u0016\u0010!\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\u0004R\u0016\u0010\"\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010\u0004R\u0016\u0010#\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u0004R\u0016\u0010$\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b$\u0010\u0004R\u0016\u0010%\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b%\u0010\u0004R\u0016\u0010&\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b&\u0010\u0004R\u0016\u0010'\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b'\u0010\u0004R\u0016\u0010(\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b(\u0010\u0004R\u0016\u0010)\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b)\u0010\u0004R\u0016\u0010*\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b*\u0010\u0004¨\u0006-"}, d2 = {"Lkotlin/text/Typography;", "", "", "almostEqual", "C", "times", "leftSingleQuote", "lowDoubleQuote", "leftDoubleQuote", "copyright", "notEqual", "middleDot", "euro", "rightSingleQuote", "doubleDagger", "registered", "lessOrEqual", "prime", "dagger", "tm", "greaterOrEqual", "section", "amp", "less", "half", "ndash", "dollar", "bullet", "ellipsis", "lowSingleQuote", "rightDoubleQuote", "pound", "degree", "doublePrime", "plusMinus", "cent", "paragraph", "mdash", ShareConstants.WEB_DIALOG_PARAM_QUOTE, "leftGuillemete", "greater", "nbsp", "rightGuillemete", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class Typography {
    @NotNull
    public static final Typography INSTANCE = new Typography();
    public static final char almostEqual = 8776;
    public static final char amp = '&';
    public static final char bullet = 8226;
    public static final char cent = 162;
    public static final char copyright = 169;

    /* renamed from: dagger  reason: collision with root package name */
    public static final char f62dagger = 8224;
    public static final char degree = 176;
    public static final char dollar = '$';
    public static final char doubleDagger = 8225;
    public static final char doublePrime = 8243;
    public static final char ellipsis = 8230;
    public static final char euro = 8364;
    public static final char greater = '>';
    public static final char greaterOrEqual = 8805;
    public static final char half = 189;
    public static final char leftDoubleQuote = 8220;
    public static final char leftGuillemete = 171;
    public static final char leftSingleQuote = 8216;
    public static final char less = '<';
    public static final char lessOrEqual = 8804;
    public static final char lowDoubleQuote = 8222;
    public static final char lowSingleQuote = 8218;
    public static final char mdash = 8212;
    public static final char middleDot = 183;
    public static final char nbsp = 160;
    public static final char ndash = 8211;
    public static final char notEqual = 8800;
    public static final char paragraph = 182;
    public static final char plusMinus = 177;
    public static final char pound = 163;
    public static final char prime = 8242;
    public static final char quote = '\"';
    public static final char registered = 174;
    public static final char rightDoubleQuote = 8221;
    public static final char rightGuillemete = 187;
    public static final char rightSingleQuote = 8217;
    public static final char section = 167;
    public static final char times = 215;
    public static final char tm = 8482;
}
