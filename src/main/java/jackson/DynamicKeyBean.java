package jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by sam on 12/10/16.
 */
public class DynamicKeyBean {
    @JsonProperty("value_name")
    private String valueName;
    @JsonProperty("field_name")
    private String fieldName;

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "DynamicKeyBean{" +
                "valueName='" + valueName + '\'' +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }

    public static void main(String args[]) throws IOException {
        String json = "{\"1163673678\": {\"value_name\": \"1\",\"field_name\": \"SSLA_SOC_FY17_TakataRecall_Corolla03_08\"},\"1163674426\": {\"value_name\": \"1\",\"field_name\": \"value2\"},\"1163674534\": {\"value_name\": \"1\",\"field_name\": \"value\"}}";
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<Map<String, DynamicKeyBean>> typeReference = new TypeReference<Map<String, DynamicKeyBean>>(){};
        Map<String, DynamicKeyBean> response = objectMapper.readValue(json.getBytes(), typeReference);
        Set<Map.Entry<String, DynamicKeyBean>> entries = response.entrySet();
        for(Map.Entry<String, DynamicKeyBean> entry : entries) {
            System.out.println("Key : " + entry.getKey());
            System.out.println("Value : " + entry.getValue());
        }
    }
}