import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.ResourceFactory;

public class Utils {

    public static String getCountry(String code) {
        if (code != null && !code.equals("")) {
            ParameterizedSparqlString qs = new ParameterizedSparqlString("" +
                    "select ?country where {\n" +
                    "  ?country <http://www.wikidata.org/prop/direct/P297> ?code\n" +
                    "}");

            Literal codeLiteral = ResourceFactory.createPlainLiteral(code.toUpperCase());
            qs.setParam("code", codeLiteral);

            QueryExecution exec = QueryExecutionFactory.sparqlService(" https://query.wikidata.org/bigdata/namespace/wdq/sparql", qs.asQuery());
            ResultSet results = exec.execSelect();

            // At least one result, so we take that one.
            if (results.hasNext()) {
                return results.next().get("country").toString();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
