package es.udc.mashup.reviewprovider;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;

import es.udc.mashup.virtualstore.service.ProductReviewTO;
import es.udc.mashup.virtualstore.service.ProductTO;
import es.udc.ws.util.exceptions.ServiceException;

public class ReviewProviderFacebookImplementation implements ReviewProvider {

	private static final long serialVersionUID = 1L;

	private static final String apiUrl = "https://graph.facebook.com/";
	private static final String facebookId = "780165292079936";
	private static final String Acces_TOKKEN = "CAAGWXSaA4MsBAHCUV829NFDV4aDJPFscXqR6noamRIIKDFRFIuJCOWAYntQSPXsUOphBXqIw8n0H41GB9tXDKMlgF9DmXQsHXU6m3zQUcEO81NYx99PuhHWpkd9c6RQrJQEwaqkB6bYPBaacLt9cARHS4MWeuayG6JZC3vpwZC1i5nb2HQ6dEgvMLZByoZCmmxfKg3mWBZBT1ph7mWqzG";

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

			}
		} catch (Exception ex) {

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
