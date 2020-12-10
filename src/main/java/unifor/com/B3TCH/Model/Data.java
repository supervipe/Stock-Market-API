package unifor.com.B3TCH.Model;

import java.util.Map;

public class Data {

    private String by;
    private Boolean valid_key;
    private Map<String, Map<String, Object>> results;

    private String execution_time;
    private String from_cache;

    public Map<String, Map<String, Object>> getResults() {
        return results;
    }
}