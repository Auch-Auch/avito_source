package com.google.common.net;

import com.avito.android.lib.design.input.FormatterType;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.Immutable;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Immutable
@Beta
@GwtCompatible
public final class InternetDomainName {
    public static final CharMatcher e = CharMatcher.anyOf(".。．｡");
    public static final Splitter f = Splitter.on((char) FormatterType.defaultDecimalSeparator);
    public static final Joiner g = Joiner.on((char) FormatterType.defaultDecimalSeparator);
    public static final CharMatcher h;
    public static final CharMatcher i;
    public final String a;
    public final ImmutableList<String> b;
    public final int c;
    public final int d;

    static {
        CharMatcher anyOf = CharMatcher.anyOf("-_");
        h = anyOf;
        i = CharMatcher.javaLetterOrDigit().or(anyOf);
    }

    public InternetDomainName(String str) {
        String lowerCase = Ascii.toLowerCase(e.replaceFrom(str, FormatterType.defaultDecimalSeparator));
        boolean z = true;
        lowerCase = lowerCase.endsWith(".") ? lowerCase.substring(0, lowerCase.length() - 1) : lowerCase;
        Preconditions.checkArgument(lowerCase.length() <= 253, "Domain name too long: '%s':", lowerCase);
        this.a = lowerCase;
        ImmutableList<String> copyOf = ImmutableList.copyOf(f.split(lowerCase));
        this.b = copyOf;
        Preconditions.checkArgument(copyOf.size() <= 127, "Domain has too many parts: '%s'", lowerCase);
        int size = copyOf.size() - 1;
        if (c(copyOf.get(size), true)) {
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (!c(copyOf.get(i2), false)) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        z = false;
        Preconditions.checkArgument(z, "Not a valid domain name: '%s'", lowerCase);
        this.c = b(Optional.absent());
        this.d = b(Optional.of(PublicSuffixType.REGISTRY));
    }

    public static boolean c(String str, boolean z) {
        if (str.length() >= 1 && str.length() <= 63) {
            if (!i.matchesAllOf(CharMatcher.ascii().retainFrom(str))) {
                return false;
            }
            CharMatcher charMatcher = h;
            if (!charMatcher.matches(str.charAt(0)) && !charMatcher.matches(str.charAt(str.length() - 1))) {
                return !z || !CharMatcher.digit().matches(str.charAt(0));
            }
        }
        return false;
    }

    public static InternetDomainName from(String str) {
        return new InternetDomainName((String) Preconditions.checkNotNull(str));
    }

    public static boolean isValid(String str) {
        try {
            from(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public final InternetDomainName a(int i2) {
        Joiner joiner = g;
        ImmutableList<String> immutableList = this.b;
        return from(joiner.join(immutableList.subList(i2, immutableList.size())));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        if ((r8.isPresent() ? r8.equals(r3) : r3.isPresent()) != false) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(com.google.common.base.Optional<com.google.thirdparty.publicsuffix.PublicSuffixType> r8) {
        /*
            r7 = this;
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r7.b
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x0008:
            if (r2 >= r0) goto L_0x0075
            com.google.common.base.Joiner r3 = com.google.common.net.InternetDomainName.g
            com.google.common.collect.ImmutableList<java.lang.String> r4 = r7.b
            com.google.common.collect.ImmutableList r4 = r4.subList(r2, r0)
            java.lang.String r3 = r3.join(r4)
            com.google.common.collect.ImmutableMap<java.lang.String, com.google.thirdparty.publicsuffix.PublicSuffixType> r4 = com.google.thirdparty.publicsuffix.PublicSuffixPatterns.EXACT
            java.lang.Object r4 = r4.get(r3)
            com.google.common.base.Optional r4 = com.google.common.base.Optional.fromNullable(r4)
            boolean r5 = r8.isPresent()
            if (r5 == 0) goto L_0x002b
            boolean r4 = r8.equals(r4)
            goto L_0x002f
        L_0x002b:
            boolean r4 = r4.isPresent()
        L_0x002f:
            if (r4 == 0) goto L_0x0032
            return r2
        L_0x0032:
            com.google.common.collect.ImmutableMap<java.lang.String, com.google.thirdparty.publicsuffix.PublicSuffixType> r4 = com.google.thirdparty.publicsuffix.PublicSuffixPatterns.EXCLUDED
            boolean r4 = r4.containsKey(r3)
            r5 = 1
            if (r4 == 0) goto L_0x003d
            int r2 = r2 + r5
            return r2
        L_0x003d:
            com.google.common.base.Splitter r4 = com.google.common.net.InternetDomainName.f
            r6 = 2
            com.google.common.base.Splitter r4 = r4.limit(r6)
            java.util.List r3 = r4.splitToList(r3)
            int r4 = r3.size()
            if (r4 != r6) goto L_0x006e
            com.google.common.collect.ImmutableMap<java.lang.String, com.google.thirdparty.publicsuffix.PublicSuffixType> r4 = com.google.thirdparty.publicsuffix.PublicSuffixPatterns.UNDER
            java.lang.Object r3 = r3.get(r5)
            java.lang.Object r3 = r4.get(r3)
            com.google.common.base.Optional r3 = com.google.common.base.Optional.fromNullable(r3)
            boolean r4 = r8.isPresent()
            if (r4 == 0) goto L_0x0067
            boolean r3 = r8.equals(r3)
            goto L_0x006b
        L_0x0067:
            boolean r3 = r3.isPresent()
        L_0x006b:
            if (r3 == 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r5 = 0
        L_0x006f:
            if (r5 == 0) goto L_0x0072
            return r2
        L_0x0072:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x0075:
            r8 = -1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.net.InternetDomainName.b(com.google.common.base.Optional):int");
    }

    public InternetDomainName child(String str) {
        return from(((String) Preconditions.checkNotNull(str)) + "." + this.a);
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InternetDomainName) {
            return this.a.equals(((InternetDomainName) obj).a);
        }
        return false;
    }

    public boolean hasParent() {
        return this.b.size() > 1;
    }

    public boolean hasPublicSuffix() {
        return this.c != -1;
    }

    public boolean hasRegistrySuffix() {
        return this.d != -1;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean isPublicSuffix() {
        return this.c == 0;
    }

    public boolean isRegistrySuffix() {
        return this.d == 0;
    }

    public boolean isTopDomainUnderRegistrySuffix() {
        return this.d == 1;
    }

    public boolean isTopPrivateDomain() {
        return this.c == 1;
    }

    public boolean isUnderPublicSuffix() {
        return this.c > 0;
    }

    public boolean isUnderRegistrySuffix() {
        return this.d > 0;
    }

    public InternetDomainName parent() {
        Preconditions.checkState(hasParent(), "Domain '%s' has no parent", this.a);
        return a(1);
    }

    public ImmutableList<String> parts() {
        return this.b;
    }

    public InternetDomainName publicSuffix() {
        if (hasPublicSuffix()) {
            return a(this.c);
        }
        return null;
    }

    public InternetDomainName registrySuffix() {
        if (hasRegistrySuffix()) {
            return a(this.d);
        }
        return null;
    }

    public String toString() {
        return this.a;
    }

    public InternetDomainName topDomainUnderRegistrySuffix() {
        if (isTopDomainUnderRegistrySuffix()) {
            return this;
        }
        Preconditions.checkState(isUnderRegistrySuffix(), "Not under a registry suffix: %s", this.a);
        return a(this.d - 1);
    }

    public InternetDomainName topPrivateDomain() {
        if (isTopPrivateDomain()) {
            return this;
        }
        Preconditions.checkState(isUnderPublicSuffix(), "Not under a public suffix: %s", this.a);
        return a(this.c - 1);
    }
}
