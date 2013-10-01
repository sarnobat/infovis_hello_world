import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.HttpServer;

public class Server {
	@Path("helloworld")
	public static class HelloWorldResource { // Must be public

		@GET
		@Path("data")
		@Produces("application/json")
		public Response json(
		// TODO: @QueryParam("rootId") Integer iRootId
		) throws JSONException {
			System.out.println("1");
			try {
				JSONArray json = new JSONArray();
				node1: {
					JSONObject node1 = new JSONObject();
					node1.put("id", "graphnode16");
					JSONObject node1Data = new JSONObject();
					node1Data.put('$' + "color", "#C74243");
					node1Data.put('$' + "type", "star");
					node1Data.put('$' + "dim", 17);
					node1.put("data", node1Data);
					JSONArray node1Adjacencies = new JSONArray();
					JSONObject adjacency1 = new JSONObject();
					adjacency1.put("nodeTo", "graphnode17");
					JSONObject adjacency2 = new JSONObject();
					adjacency2 .put("nodeTo", "graphnode18");
					node1Adjacencies .put(adjacency1);
					node1Adjacencies .put(adjacency2);
					node1.put("adjacencies", node1Adjacencies);
					json.put(node1);
				}
				node2: {
					JSONObject node2 = new JSONObject();
					node2.put("id", "graphnode18");
					JSONObject node1Data = new JSONObject();
					node1Data.put('$' + "color", "blue");
					node1Data.put('$' + "type", "square");
					node1Data.put('$' + "dim", 7);
					node2.put("data", node1Data);
					json.put(node2);
				}
				JSONArray jsonLiteral = new JSONArray(
						"[{				'id'			: 	'graphnode16','data'			:	{										'"
								+ ""
								+ '$'
								+ "color'		:	'#C74243',										'"
								+ ""
								+ '$'
								+ "type'			:	'star',										'"
								+ ""
								+ '$'
								+ "dim'			: 	17									},				'adjacencies'	:	[										{											'nodeTo'	:	'graphnode17',										},										{											'nodeTo'	:	'graphnode18',										}],},{	'id'			: 	'graphnode18',	'data'			:	{										'"
								+ "" + '$' + "color'		:	'blue',										'"
								+ "" + '$' + "type'			:	'square',										'"
								+ "" + '$' + "dim'			: 	7									},			}		]");

				System.out.println("2");
				if (!json.toString().equals(jsonLiteral.toString())) {
					// throw new RuntimeException();
				}
				System.out.println("3");
				return Response.ok().header("Access-Control-Allow-Origin", "*")
						.entity(json.toString()).type("application/json")
						.build();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	public static void main(String[] args) throws URISyntaxException {
		HttpServer server = JdkHttpServerFactory.createHttpServer(new URI(
				"http://localhost:9099/"), new ResourceConfig(
				HelloWorldResource.class));
	}
}