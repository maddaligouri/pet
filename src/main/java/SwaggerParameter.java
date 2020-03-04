/**
 * SwaggerParameter
 */
public class SwaggerParameter {

    private String name;
    private String type;
    private String defaultValue;
    private Boolean isPath; 

    public SwaggerParameter() {
        super();
        this.isPath = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsPath() {
        this.isPath = true;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public Boolean getIsPath(){
        return this.isPath;
    }

    public String getDefaultValue(){
        return this.defaultValue;
    }
}