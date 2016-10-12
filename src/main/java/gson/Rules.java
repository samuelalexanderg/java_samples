
package gson;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Rules {

    private List<Rule> rule = new ArrayList<Rule>();

    /**
     *
     * @return
     *     The rule
     */
    public List<Rule> getRule() {
        return rule;
    }

    /**
     *
     * @param rule
     *     The rule
     */
    public void setRule(List<Rule> rule) {
        this.rule = rule;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rule).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Rules) == false) {
            return false;
        }
        Rules rhs = ((Rules) other);
        return new EqualsBuilder().append(rule, rhs.rule).isEquals();
    }

}
