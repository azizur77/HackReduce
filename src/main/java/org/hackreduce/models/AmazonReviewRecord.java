package org.hackreduce.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.hadoop.io.Text;

public class AmazonReviewRecord {
	private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("MMMMM d, yyyy");
	Logger LOG = Logger.getLogger(AmazonReviewRecord.class.getName());

	private String productID;
	private String reviewID;
	private Date reviewDate;
	private int usefulCount;
	private int totalCount;
	private float rating;
	private String text;
	
	public AmazonReviewRecord(String line) {
		try {
			String[] data = line.split("\\t");
			setProductID(data[0]);
			setReviewID(data[1]);
			try {
				setReviewDate(SIMPLE_DATE_FORMAT.parse(data[2]));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			setUsefulCount(Integer.parseInt(data[3]));
			setTotalCount(Integer.parseInt(data[4]));
			setRating(Float.valueOf(data[5]));
			setText(data[6]);
		}
		catch (Exception e) {
			setProductID("-1");
			setReviewDate(null);
		}
	}

	public AmazonReviewRecord(Text inputText) throws IllegalArgumentException {
		this(inputText.toString());
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getReviewID() {
		return reviewID;
	}
	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getUsefulCount() {
		return usefulCount;
	}
	public void setUsefulCount(int usefulCount) {
		this.usefulCount = usefulCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
