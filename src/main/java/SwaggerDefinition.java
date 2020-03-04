import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * SwaggerDefinition
 */
public class SwaggerDefinition {

    
    public static List<SwaggerOperation> getDefinitions(String endpoint) {
       
        List<SwaggerOperation> operations = new ArrayList<>();

        try {

            ObjectMapper mapper = new ObjectMapper();
            Client client = ClientBuilder.newClient();
            Response response = client
              .target(endpoint)
              .request(MediaType.APPLICATION_JSON)
              .get();
    
            String json = response.readEntity(String.class);

            // convert JSON string to Map
            JsonNode map = mapper.readTree(json);
            JsonNode nodePath = map.get("paths");
            JsonNode nodeDefinitions = map.get("definitions");
            String basePath = map.get("basePath").asText();
            String host = map.get("host").asText();

            Map<String, Object> paths = mapper.convertValue(nodePath, Map.class);
            Map<String, Object> definitions = mapper.convertValue(nodeDefinitions, Map.class);

            for (Map.Entry<String, Object> entryEndpoint : paths.entrySet()) {

                String url = entryEndpoint.getKey();

                Map<String, Object> actions = mapper.convertValue(entryEndpoint.getValue(), Map.class);

                for (Map.Entry<String, Object> entryAction: actions.entrySet()) {

                    Map<String, Object> resource = mapper.convertValue(entryAction.getValue(), Map.class);

                    String summary = null;
                    String description = null;
                    String operationId = null;
                    List<SwaggerParameter> swaggerParameters = new ArrayList<>();

                    for (Map.Entry<String, Object> entryResourceItem: resource.entrySet()) {

                        if (entryResourceItem.getKey().equals("summary")) {
                            summary = (String)entryResourceItem.getValue();
                        }

                        if (entryResourceItem.getKey().equals("description")) {
                            description = (String)entryResourceItem.getValue();
                        }

                        if (entryResourceItem.getKey().equals("operationId")) {
                            operationId = (String)entryResourceItem.getValue();
                        }

                        if (entryResourceItem.getKey().equals("parameters")) {
                            List<Object> parameters = (ArrayList<Object>)entryResourceItem.getValue();
                            
                            for (Object node : parameters) {
                                
                                Map<String, Object> prop = mapper.convertValue(node, Map.class);

                                String name = (String)prop.get("name");
                                String in = (String)prop.get("in");
                                String type = (String)prop.get("type");
                                Boolean required = (Boolean)prop.get("required");
                                Object schema = prop.get("schema");

                                SwaggerParameter swaggerParameter = null;
                                if (in.equals("path") && required) {
                                    swaggerParameter = new SwaggerParameter(); 
                                    swaggerParameter.setName(name);
                                    swaggerParameter.setType(type);
                                    swaggerParameter.setIsPath();
                                    swaggerParameters.add(swaggerParameter);
                                }

                                if (in.equals("body") && required) {

                                    if (schema != null) {
                                        Map<String, Object> schemaProp = mapper.convertValue(schema, Map.class);
                                        String ref = (String)schemaProp.get("$ref");
                                        if (ref != null) {
                                            String[] keys = ref.split("/");
                                            String key = keys[keys.length - 1];
                                            Map<String, Object> object = mapper.convertValue(definitions.get(key), Map.class);
                                            Map<String, Object> objectProps = mapper.convertValue(object.get("properties"), Map.class);

                                            String propKey = null;
                                            String propType = null;

                                            for (Map.Entry<String, Object> entryObjProp: objectProps.entrySet())  {
                                                propKey = entryObjProp.getKey();
                                                propType = (String)mapper.convertValue(entryObjProp.getValue(), Map.class).get("type");
                                                
                                                swaggerParameter = new SwaggerParameter(); 
                                                swaggerParameter.setName(propKey);
                                                swaggerParameter.setType(propType);

                                                List<Object> enumValue = (ArrayList<Object>)mapper.convertValue(entryObjProp.getValue(), Map.class).get("enum");
                                            
                                                if (enumValue != null) {
                                                    String defaultValue = (String)enumValue.get(0);
                                                    swaggerParameter.setDefaultValue(defaultValue);
                                                }

                                                swaggerParameters.add(swaggerParameter);
                                            }
                                        }
                                      
    
                                    }
                                    
                                }

                                if (in.equals("formData") && required) {
                                    swaggerParameter = new SwaggerParameter(); 
                                    swaggerParameter.setName(name);
                                    swaggerParameter.setType(type);
                                    swaggerParameters.add(swaggerParameter);
                                }

                                if (in.equals("query") && required) {

                                    if (type.equals("array")) {
                                        Map<String, Object> items = mapper.convertValue(prop.get("items"), Map.class);

                                        swaggerParameter = new SwaggerParameter(); 
                                        swaggerParameter.setName(name);
                                        swaggerParameter.setType("query");

                                        List<Object> enumValue = (ArrayList<Object>)items.get("enum");

                                        if (enumValue != null) {
                                            String defaultValue = (String)enumValue.get(0);
                                            swaggerParameter.setDefaultValue(defaultValue);
                                        }

                                    }
                                   
                                }
                            }
                        }
                        

                    }   

                    String testName = "test_" + operationId;

                    SwaggerOperation operation = new SwaggerOperation();

                    operation.setName(testName);
                    operation.setEndpoint("https://" + host + basePath + url);
                    operation.setMethod(entryAction.getKey());
                    operation.setParameters(swaggerParameters);

                    operations.add(operation);

                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        return operations;
    }

    public static List<?> convertObjectToList(Object obj) {
        List<?> list = new ArrayList<>();
        if (obj.getClass().isArray()) {
            list = Arrays.asList((Object[])obj);
        } else if (obj instanceof Collection) {
            list = new ArrayList<>((Collection<?>)obj);
        }
        return list;
    }

}