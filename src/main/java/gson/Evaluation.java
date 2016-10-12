
package gson;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Evaluation {

    private String operator;
    private String value;
    private String type;

    /**
     *
     * @return
     *     The operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     *
     * @param operator
     *     The operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     *
     * @return
     *     The value
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     *     The value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     *
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(operator).append(value).append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Evaluation) == false) {
            return false;
        }
        Evaluation rhs = ((Evaluation) other);
        return new EqualsBuilder().append(operator, rhs.operator).append(value, rhs.value).append(type, rhs.type).isEquals();
    }

}
