package es.udc.mashup.reviewprovider;

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
	public List<ProductTO> searchReviews(List<ProductTO> products) throws ServiceException {
		
		//GetMethod method = new GetMethod(apiUrl+facebookId+"/feed?fields=id,message,comments{from,likes{id},message}&access_token="+Acces_TOKKEN);
		
		GetMethod method = new GetMethod(apiUrl+facebookId+"/feed");
		
		method.setQueryString(new NameValuePair[] {new NameValuePair("fields","id,message,comments{from,likes{id},message}"),
				new NameValuePair("access_token",Acces_TOKKEN)});
		
		try{
			HttpClient client = new HttpClient();
			int statusCode = client.executeMethod(method);
			
			if(statusCode == HttpStatus.SC_OK) {
				String jsonTxt = method.getResponseBodyAsString();
				System.out.println(jsonTxt);
				
				JSONObject json = (JSONObject) JSONSerializer.toJSON(jsonTxt);
				String data = json.getString("data");
				System.out.println(data);
				JSONArray jsondata = json.getJSONArray("data");
				System.out.println(jsondata.size());
				for(int i=0;i<jsondata.size();i++) {
					JSONObject jsonmessage = jsondata.getJSONObject(i);
					System.out.println(jsonmessage.getString("message"));
					System.out.println(jsonmessage.getString("comments"));
					
					JSONObject comment = jsonmessage.getJSONObject("comments");
					
					JSONArray comments = comment.getJSONArray("data");
					System.out.println(comments.size());
					for(int j=0;j<comments.size();j++) {
						JSONObject jsoncoments = jsondata.getJSONObject(j);
						System.out.println(jsoncoments);
						
					}
					
					
				}
				
				
			}
			else {
				
			}
		} catch (Exception ex) {
			
		} finally {
			method.releaseConnection();
		}
		
		return null;
	}

	@Override
	public ProductReviewTO searchReview(ProductTO product)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addReview(ProductTO product, ProductReviewTO productReviewTO)
			throws ServiceException {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		ReviewProviderFacebookImplementation n =  new ReviewProviderFacebookImplementation();
		n.searchReviews(null);
	}
}
