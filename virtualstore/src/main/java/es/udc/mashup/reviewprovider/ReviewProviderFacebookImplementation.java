package es.udc.mashup.reviewprovider;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;

import es.udc.mashup.productprovider.ProductProviderServiceFactory;
import es.udc.mashup.virtualstore.service.ProductReviewTO;
import es.udc.mashup.virtualstore.service.ProductTO;
import es.udc.ws.util.exceptions.ServiceException;

public class ReviewProviderFacebookImplementation implements ReviewProvider {

	private static final long serialVersionUID = 1L;

	private static final String CONFIGURATION_FILE = "FacebookProvider.properties";
	
	private String apiUrl;
	private String facebookId;
	private String Acces_TOKKEN;
	
	public ReviewProviderFacebookImplementation() {
		Properties properties = new Properties();
		InputStream inputStream = ProductProviderServiceFactory.class.getClassLoader().getResourceAsStream(CONFIGURATION_FILE);

		try {
			properties.load(inputStream);
		} catch (IOException e1) {
			System.out.println("File not found: " + CONFIGURATION_FILE);
		}
		try {
			this.apiUrl = properties.getProperty("apiUrl");
			this.facebookId = properties.getProperty("facebookId");
			this.Acces_TOKKEN = properties.getProperty("Acces_TOKKEN");
		} catch (Exception e) {
			System.out.println("Config File ERROR");
		}
		
	}
	
	@Override
	public Hashtable<String,List<Review>> searchReviews(List<String> products) throws ServiceException {
		
		Hashtable<String,List<Review>> respuesta = new Hashtable<String,List<Review>>();
		
		GetMethod method = new GetMethod(apiUrl + facebookId + "/feed");

		method.setQueryString(new NameValuePair[] { new NameValuePair("fields", "id,message,comments{from,likes{id},message}"),
				new NameValuePair("access_token", Acces_TOKKEN) });
		
		try {
			HttpClient client = new HttpClient();
			int statusCode = client.executeMethod(method);

			if (statusCode == HttpStatus.SC_OK) {
				String jsonTxt = method.getResponseBodyAsString();

				JSONObject json = (JSONObject) JSONSerializer.toJSON(jsonTxt);
				
				if (!json.isEmpty()) {
					JSONArray muro = json.getJSONArray("data");

					for (int i = 0; i < muro.size(); i++) {
						JSONObject producto = muro.getJSONObject(i);
						JSONObject commentariosaux = producto.getJSONObject("comments");
						if (!commentariosaux.isEmpty()) {
							JSONArray commentarios = commentariosaux.getJSONArray("data");

							for (int x = 0; x < products.size(); x++) {
								String productname = products.get(x);
								
								

								if (productname.compareToIgnoreCase(producto.getString("message")) == 0) {
									
									List<Review> productReviws =  new ArrayList<Review>();
									respuesta.put(productname, productReviws);
									
									for (int j = 0; j < commentarios.size(); j++) {

										JSONObject comentario = commentarios.getJSONObject(j);
										JSONObject from = comentario.getJSONObject("from");

										Review review = new Review();

										review.setReviewer(from.getString("name"));
										review.setDescription(comentario.getString("message"));

										JSONObject likesaux = comentario.getJSONObject("likes");

										if (!likesaux.isEmpty()) {
											JSONArray likes = likesaux.getJSONArray("data");

											for (int k = 0; k < likes.size(); k++) {

												String likeid = likes.getJSONObject(k).getString("id");
												if (likeid.compareTo(from.getString("id")) == 0)
													review.setScore(1);
											}
										}
										productReviws.add(review);
									}
								}
							}
						}
					}
				}
			} else {
				System.out.println("StatusCode not OK");
			}
		} catch (Exception ex) {
			System.out.println("Fallo en la conexión : " + ex.getMessage());
		} finally {
			method.releaseConnection();
		}
		
		return respuesta;
	}
	
	public List<ProductTO> searchReviews2(List<ProductTO> products) throws ServiceException {

		GetMethod method = new GetMethod(apiUrl + facebookId + "/feed");

		method.setQueryString(new NameValuePair[] { new NameValuePair("fields", "id,message,comments{from,likes{id},message}"),
				new NameValuePair("access_token", Acces_TOKKEN) });

		try {
			HttpClient client = new HttpClient();
			int statusCode = client.executeMethod(method);

			if (statusCode == HttpStatus.SC_OK) {
				String jsonTxt = method.getResponseBodyAsString();

				JSONObject json = (JSONObject) JSONSerializer.toJSON(jsonTxt);
				if (!json.isEmpty()) {
					JSONArray muro = json.getJSONArray("data");

					for (int i = 0; i < muro.size(); i++) {
						JSONObject producto = muro.getJSONObject(i);
						JSONObject commentariosaux = producto.getJSONObject("comments");
						if (!commentariosaux.isEmpty()) {
							JSONArray commentarios = commentariosaux.getJSONArray("data");

							for (int x = 0; x < products.size(); x++) {
								ProductTO p = products.get(x);

								if (p.getName().compareToIgnoreCase(producto.getString("message")) == 0) {

									for (int j = 0; j < commentarios.size(); j++) {

										JSONObject comentario = commentarios.getJSONObject(j);
										JSONObject from = comentario.getJSONObject("from");

										ProductReviewTO review = new ProductReviewTO();

										review.setReviewer(from.getString("name"));
										review.setDescription(comentario.getString("message"));

										JSONObject likesaux = comentario.getJSONObject("likes");

										if (!likesaux.isEmpty()) {
											JSONArray likes = likesaux.getJSONArray("data");

											for (int k = 0; k < likes.size(); k++) {

												String likeid = likes.getJSONObject(k).getString("id");
												if (likeid.compareTo(from.getString("id")) == 0)
													review.setScore(1);

											}
										}
										p.addReview(review);
									}
								}
							}
						}
					}
				}
			} else {

			}
		} catch (Exception ex) {

		} finally {
			method.releaseConnection();
		}

		return null;
	}

	public static void main(String[] args) {
		ReviewProviderFacebookImplementation n = new ReviewProviderFacebookImplementation();
		n.searchReviews2(null);
	}


}
