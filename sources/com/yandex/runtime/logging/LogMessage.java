package com.yandex.runtime.logging;

import androidx.annotation.NonNull;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class LogMessage implements Serializable {
    private LogLevel level;
    private String message;
    private String scope;
    private long time;
    private String verboseInfo;

    public enum LogLevel {
        ERROR,
        WARNING,
        INFO,
        DEBUG
    }

    public LogMessage(long j, @NonNull LogLevel logLevel, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        if (logLevel == null) {
            throw new IllegalArgumentException("Required field \"level\" cannot be null");
        } else if (str == null) {
            throw new IllegalArgumentException("Required field \"scope\" cannot be null");
        } else if (str2 == null) {
            throw new IllegalArgumentException("Required field \"message\" cannot be null");
        } else if (str3 != null) {
            this.time = j;
            this.level = logLevel;
            this.scope = str;
            this.message = str2;
            this.verboseInfo = str3;
        } else {
            throw new IllegalArgumentException("Required field \"verboseInfo\" cannot be null");
        }
    }

    @NonNull
    public LogLevel getLevel() {
        return this.level;
    }

    @NonNull
    public String getMessage() {
        return this.message;
    }

    @NonNull
    public String getScope() {
        return this.scope;
    }

    public long getTime() {
        return this.time;
    }

    @NonNull
    public String getVerboseInfo() {
        return this.verboseInfo;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.time = archive.add(this.time);
        this.level = (LogLevel) archive.add((Archive) this.level, false, (Class<Archive>) LogLevel.class);
        this.scope = archive.add(this.scope, false);
        this.message = archive.add(this.message, false);
        this.verboseInfo = archive.add(this.verboseInfo, false);
    }

    public LogMessage() {
    }
}
