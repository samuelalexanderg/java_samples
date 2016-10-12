
package gson;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class Rule {

    private String id;
    private String desc;
    @SerializedName("rule_conditions")
    private RuleConditions ruleConditions;
    private String action;

    /**
     *
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     *
     * @param desc
     *     The desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     *
     * @return
     *     The ruleConditions
     */
    public RuleConditions getRuleConditions() {
        return ruleConditions;
    }

    /**
     *
     * @param ruleConditions
     *     The rule_conditions
     */
    public void setRuleConditions(RuleConditions ruleConditions) {
        this.ruleConditions = ruleConditions;
    }

    /**
     *
     * @return
     *     The action
     */
    public String getAction() {
        return action;
    }

    /**
     *
     * @param action
     *     The action
     */
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(desc).append(ruleConditions).append(action).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Rule) == false) {
            return false;
        }
        Rule rhs = ((Rule) other);
        return new EqualsBuilder().append(id, rhs.id).append(desc, rhs.desc).append(ruleConditions, rhs.ruleConditions).append(action, rhs.action).isEquals();
    }

}
