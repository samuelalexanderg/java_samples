
package gson;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class RuleCondition {

    private String field;
    private Evaluation evaluation;

    /**
     *
     * @return
     *     The field
     */
    public String getField() {
        return field;
    }

    /**
     *
     * @param field
     *     The field
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     *
     * @return
     *     The evaluation
     */
    public Evaluation getEvaluation() {
        return evaluation;
    }

    /**
     *
     * @param evaluation
     *     The evaluation
     */
    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(field).append(evaluation).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RuleCondition) == false) {
            return false;
        }
        RuleCondition rhs = ((RuleCondition) other);
        return new EqualsBuilder().append(field, rhs.field).append(evaluation, rhs.evaluation).isEquals();
    }

}
