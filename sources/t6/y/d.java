package t6.y;

import a2.b.a.a.a;
import kotlin.jvm.JvmField;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
public final class d {
    @JvmField
    @NotNull
    public static final Regex a;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append("(\\p{Digit}+)");
        sb.append("(\\.)?(");
        sb.append("(\\p{Digit}+)");
        sb.append("?)(");
        a.n1(sb, "[eE][+-]?(\\p{Digit}+)", ")?)|", "(\\.(", "(\\p{Digit}+)");
        a.n1(sb, ")(", "[eE][+-]?(\\p{Digit}+)", ")?)|", "((");
        sb.append("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))");
        sb.append(")[pP][+-]?");
        sb.append("(\\p{Digit}+)");
        sb.append(')');
        a = new Regex(a.e3("[\\x00-\\x20]*[+-]?(NaN|Infinity|((", sb.toString(), ")[fFdD]?))[\\x00-\\x20]*"));
    }
}
