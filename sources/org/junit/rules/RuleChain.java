package org.junit.rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
public class RuleChain implements TestRule {
    public static final RuleChain b = new RuleChain(Collections.emptyList());
    public List<TestRule> a;

    public RuleChain(List<TestRule> list) {
        this.a = list;
    }

    public static RuleChain emptyRuleChain() {
        return b;
    }

    public static RuleChain outerRule(TestRule testRule) {
        return emptyRuleChain().around(testRule);
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return new RunRules(statement, this.a, description);
    }

    public RuleChain around(TestRule testRule) {
        Objects.requireNonNull(testRule, "The enclosed rule must not be null");
        ArrayList arrayList = new ArrayList();
        arrayList.add(testRule);
        arrayList.addAll(this.a);
        return new RuleChain(arrayList);
    }
}
