package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by sam on 12/10/16.
 */
public class SimpleBean {
    private String customer_name;
    private String name;
    private long id;

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "customer_name='" + customer_name + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public static void main(String args[]) throws IOException {
        String json = "[{\"customer_name\":\"Toyota Onboarding\",\"name\":\"12444 / Toyota - CRM (Acxiom)\",\"id\":34926},{\"customer_name\":\"Lane Bryant\",\"name\":\"12212\",\"id\":124156},{\"customer_name\":\"Toyota Onboarding\",\"name\":\"Toyota - CRM (Acxiom) - Sizmek\",\"id\":189689}]";
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleBean[] simpleBeens = objectMapper.readValue(json.getBytes(), SimpleBean[].class);
        System.out.println(simpleBeens.length);
        for (SimpleBean bean : simpleBeens) {
            System.out.println(bean);
        }

    }
}
