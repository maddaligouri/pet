import java.util.List;

/**
 * SwaggerOperation
 */
public class SwaggerOperation {

    private String name;
    private String endpoint;
    private String method;
    private List<SwaggerParameter> parameters; 

    public void setName(String name ) {
        this.name = name;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setParameters(List<SwaggerParameter> parameters) {
        this.parameters = parameters;
    }

    public String getMethod() {
        return this.method;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public List<SwaggerParameter> getParameters() {
        return this.parameters;
    }

    public String getName() {
        return this.name;
    }
}