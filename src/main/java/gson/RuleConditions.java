
package gson;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RuleConditions {

    @SerializedName("rule_condition")
    private List<RuleCondition> ruleCondition = new ArrayList<RuleCondition>();

    /**
     *
     * @return
     *     The ruleCondition
     */
    public List<RuleCondition> getRuleCondition() {
        return ruleCondition;
    }

    /**
     *
     * @param ruleCondition
     *     The rule_condition
     */
    public void setRuleCondition(List<RuleCondition> ruleCondition) {
        this.ruleCondition = ruleCondition;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(ruleCondition).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RuleConditions) == false) {
            return false;
        }
        RuleConditions rhs = ((RuleConditions) other);
        return new EqualsBuilder().append(ruleCondition, rhs.ruleCondition).isEquals();
    }

}
