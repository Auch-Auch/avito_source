package com.google.firebase.crashlytics.internal.stacktrace;
public class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy {
    public final int a;
    public final StackTraceTrimmingStrategy[] b;
    public final MiddleOutStrategy c;

    public MiddleOutFallbackStrategy(int i, StackTraceTrimmingStrategy... stackTraceTrimmingStrategyArr) {
        this.a = i;
        this.b = stackTraceTrimmingStrategyArr;
        this.c = new MiddleOutStrategy(i);
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.a) {
            return stackTraceElementArr;
        }
        StackTraceTrimmingStrategy[] stackTraceTrimmingStrategyArr = this.b;
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (StackTraceTrimmingStrategy stackTraceTrimmingStrategy : stackTraceTrimmingStrategyArr) {
            if (stackTraceElementArr2.length <= this.a) {
                break;
            }
            stackTraceElementArr2 = stackTraceTrimmingStrategy.getTrimmedStackTrace(stackTraceElementArr);
        }
        return stackTraceElementArr2.length > this.a ? this.c.getTrimmedStackTrace(stackTraceElementArr2) : stackTraceElementArr2;
    }
}
