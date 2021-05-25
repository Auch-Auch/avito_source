package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public final class PatternFilenameFilter implements FilenameFilter {
    public final Pattern a;

    public PatternFilenameFilter(String str) {
        this(Pattern.compile(str));
    }

    @Override // java.io.FilenameFilter
    public boolean accept(@NullableDecl File file, String str) {
        return this.a.matcher(str).matches();
    }

    public PatternFilenameFilter(Pattern pattern) {
        this.a = (Pattern) Preconditions.checkNotNull(pattern);
    }
}
