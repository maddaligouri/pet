import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {

    private Integer id;
    private String name;
    private String status;

    public Pet() {
        
    }

    public Pet(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
}