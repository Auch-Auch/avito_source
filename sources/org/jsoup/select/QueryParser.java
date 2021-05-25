package org.jsoup.select;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.parser.TokenQueue;
import org.jsoup.select.Evaluator;
import org.jsoup.select.Selector;
import x6.b.c.a;
import x6.b.c.b;
public class QueryParser {
    public static final String[] d = {",", ">", "+", "~", " "};
    public static final String[] e = {"=", "!=", "^=", "$=", "*=", "~="};
    public static final Pattern f = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);
    public static final Pattern g = Pattern.compile("([+-])?(\\d+)");
    public TokenQueue a;
    public String b;
    public List<Evaluator> c = new ArrayList();

    public QueryParser(String str) {
        Validate.notEmpty(str);
        String trim = str.trim();
        this.b = trim;
        this.a = new TokenQueue(trim);
    }

    public static Evaluator parse(String str) {
        try {
            return new QueryParser(str).g();
        } catch (IllegalArgumentException e2) {
            throw new Selector.SelectorParseException(e2.getMessage(), new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(char r10) {
        /*
        // Method dump skipped, instructions count: 316
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.QueryParser.a(char):void");
    }

    public final int b() {
        String trim = this.a.chompTo(")").trim();
        Validate.isTrue(StringUtil.isNumeric(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    public final void c(boolean z) {
        this.a.consume(z ? ":containsOwn" : ":contains");
        String unescape = TokenQueue.unescape(this.a.chompBalanced('(', ')'));
        Validate.notEmpty(unescape, ":contains(text) query must not be empty");
        if (z) {
            this.c.add(new Evaluator.ContainsOwnText(unescape));
        } else {
            this.c.add(new Evaluator.ContainsText(unescape));
        }
    }

    public final void d(boolean z, boolean z2) {
        String normalize = Normalizer.normalize(this.a.chompTo(")"));
        Matcher matcher = f.matcher(normalize);
        Matcher matcher2 = g.matcher(normalize);
        int i = 2;
        int i2 = 0;
        if ("odd".equals(normalize)) {
            i2 = 1;
        } else if (!"even".equals(normalize)) {
            if (matcher.matches()) {
                int parseInt = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                if (matcher.group(4) != null) {
                    i2 = Integer.parseInt(matcher.group(4).replaceFirst("^\\+", ""));
                }
                i = parseInt;
            } else if (matcher2.matches()) {
                i2 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i = 0;
            } else {
                throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", normalize);
            }
        }
        if (z2) {
            if (z) {
                this.c.add(new Evaluator.IsNthLastOfType(i, i2));
            } else {
                this.c.add(new Evaluator.IsNthOfType(i, i2));
            }
        } else if (z) {
            this.c.add(new Evaluator.IsNthLastChild(i, i2));
        } else {
            this.c.add(new Evaluator.IsNthChild(i, i2));
        }
    }

    public final void e() {
        if (this.a.matchChomp("#")) {
            String consumeCssIdentifier = this.a.consumeCssIdentifier();
            Validate.notEmpty(consumeCssIdentifier);
            this.c.add(new Evaluator.Id(consumeCssIdentifier));
        } else if (this.a.matchChomp(".")) {
            String consumeCssIdentifier2 = this.a.consumeCssIdentifier();
            Validate.notEmpty(consumeCssIdentifier2);
            this.c.add(new Evaluator.Class(consumeCssIdentifier2.trim()));
        } else if (this.a.matchesWord() || this.a.matches("*|")) {
            String normalize = Normalizer.normalize(this.a.consumeElementSelector());
            Validate.notEmpty(normalize);
            if (normalize.startsWith("*|")) {
                this.c.add(new a.b(new Evaluator.Tag(normalize), new Evaluator.TagEndsWith(normalize.replace("*|", ":"))));
                return;
            }
            if (normalize.contains("|")) {
                normalize = normalize.replace("|", ":");
            }
            this.c.add(new Evaluator.Tag(normalize));
        } else if (this.a.matches("[")) {
            TokenQueue tokenQueue = new TokenQueue(this.a.chompBalanced('[', ']'));
            String consumeToAny = tokenQueue.consumeToAny(e);
            Validate.notEmpty(consumeToAny);
            tokenQueue.consumeWhitespace();
            if (tokenQueue.isEmpty()) {
                if (consumeToAny.startsWith("^")) {
                    this.c.add(new Evaluator.AttributeStarting(consumeToAny.substring(1)));
                } else {
                    this.c.add(new Evaluator.Attribute(consumeToAny));
                }
            } else if (tokenQueue.matchChomp("=")) {
                this.c.add(new Evaluator.AttributeWithValue(consumeToAny, tokenQueue.remainder()));
            } else if (tokenQueue.matchChomp("!=")) {
                this.c.add(new Evaluator.AttributeWithValueNot(consumeToAny, tokenQueue.remainder()));
            } else if (tokenQueue.matchChomp("^=")) {
                this.c.add(new Evaluator.AttributeWithValueStarting(consumeToAny, tokenQueue.remainder()));
            } else if (tokenQueue.matchChomp("$=")) {
                this.c.add(new Evaluator.AttributeWithValueEnding(consumeToAny, tokenQueue.remainder()));
            } else if (tokenQueue.matchChomp("*=")) {
                this.c.add(new Evaluator.AttributeWithValueContaining(consumeToAny, tokenQueue.remainder()));
            } else if (tokenQueue.matchChomp("~=")) {
                this.c.add(new Evaluator.AttributeWithValueMatching(consumeToAny, Pattern.compile(tokenQueue.remainder())));
            } else {
                throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.b, tokenQueue.remainder());
            }
        } else if (this.a.matchChomp("*")) {
            this.c.add(new Evaluator.AllElements());
        } else if (this.a.matchChomp(":lt(")) {
            this.c.add(new Evaluator.IndexLessThan(b()));
        } else if (this.a.matchChomp(":gt(")) {
            this.c.add(new Evaluator.IndexGreaterThan(b()));
        } else if (this.a.matchChomp(":eq(")) {
            this.c.add(new Evaluator.IndexEquals(b()));
        } else if (this.a.matches(":has(")) {
            this.a.consume(":has");
            String chompBalanced = this.a.chompBalanced('(', ')');
            Validate.notEmpty(chompBalanced, ":has(el) subselect must not be empty");
            this.c.add(new b.a(parse(chompBalanced)));
        } else if (this.a.matches(":contains(")) {
            c(false);
        } else if (this.a.matches(":containsOwn(")) {
            c(true);
        } else if (this.a.matches(":containsData(")) {
            this.a.consume(":containsData");
            String unescape = TokenQueue.unescape(this.a.chompBalanced('(', ')'));
            Validate.notEmpty(unescape, ":containsData(text) query must not be empty");
            this.c.add(new Evaluator.ContainsData(unescape));
        } else if (this.a.matches(":matches(")) {
            f(false);
        } else if (this.a.matches(":matchesOwn(")) {
            f(true);
        } else if (this.a.matches(":not(")) {
            this.a.consume(":not");
            String chompBalanced2 = this.a.chompBalanced('(', ')');
            Validate.notEmpty(chompBalanced2, ":not(selector) subselect must not be empty");
            this.c.add(new b.d(parse(chompBalanced2)));
        } else if (this.a.matchChomp(":nth-child(")) {
            d(false, false);
        } else if (this.a.matchChomp(":nth-last-child(")) {
            d(true, false);
        } else if (this.a.matchChomp(":nth-of-type(")) {
            d(false, true);
        } else if (this.a.matchChomp(":nth-last-of-type(")) {
            d(true, true);
        } else if (this.a.matchChomp(":first-child")) {
            this.c.add(new Evaluator.IsFirstChild());
        } else if (this.a.matchChomp(":last-child")) {
            this.c.add(new Evaluator.IsLastChild());
        } else if (this.a.matchChomp(":first-of-type")) {
            this.c.add(new Evaluator.IsFirstOfType());
        } else if (this.a.matchChomp(":last-of-type")) {
            this.c.add(new Evaluator.IsLastOfType());
        } else if (this.a.matchChomp(":only-child")) {
            this.c.add(new Evaluator.IsOnlyChild());
        } else if (this.a.matchChomp(":only-of-type")) {
            this.c.add(new Evaluator.IsOnlyOfType());
        } else if (this.a.matchChomp(":empty")) {
            this.c.add(new Evaluator.IsEmpty());
        } else if (this.a.matchChomp(":root")) {
            this.c.add(new Evaluator.IsRoot());
        } else if (this.a.matchChomp(":matchText")) {
            this.c.add(new Evaluator.MatchText());
        } else {
            throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.b, this.a.remainder());
        }
    }

    public final void f(boolean z) {
        this.a.consume(z ? ":matchesOwn" : ":matches");
        String chompBalanced = this.a.chompBalanced('(', ')');
        Validate.notEmpty(chompBalanced, ":matches(regex) query must not be empty");
        if (z) {
            this.c.add(new Evaluator.MatchesOwn(Pattern.compile(chompBalanced)));
        } else {
            this.c.add(new Evaluator.Matches(Pattern.compile(chompBalanced)));
        }
    }

    public Evaluator g() {
        this.a.consumeWhitespace();
        if (this.a.matchesAny(d)) {
            this.c.add(new b.g());
            a(this.a.consume());
        } else {
            e();
        }
        while (!this.a.isEmpty()) {
            boolean consumeWhitespace = this.a.consumeWhitespace();
            if (this.a.matchesAny(d)) {
                a(this.a.consume());
            } else if (consumeWhitespace) {
                a(' ');
            } else {
                e();
            }
        }
        if (this.c.size() == 1) {
            return this.c.get(0);
        }
        return new a.C0691a(this.c);
    }
}
