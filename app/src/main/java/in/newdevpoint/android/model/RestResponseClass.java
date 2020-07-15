package in.newdevpoint.android.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestResponseClass {

    private List<String> messages = null;
    private List<Result> result = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
 
