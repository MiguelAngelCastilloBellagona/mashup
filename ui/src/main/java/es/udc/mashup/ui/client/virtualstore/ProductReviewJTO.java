package es.udc.mashup.ui.client.virtualstore;

import java.io.Serializable;

public class ProductReviewJTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description = null;
	private String reviewer = null;
	private int score = 0;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
