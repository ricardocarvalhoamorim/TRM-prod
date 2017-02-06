package com.adneom.trm.domain;

import java.io.Serializable;
/**
 * SQL Date is used since no time is necessary.
 */
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mission")
public class Mission implements Serializable {

	private static final long serialVersionUID = -2012004661376613812L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="start_date")
	private Date startDate;
	
	// @JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="end_date")
	private Date endDate;
	
	private String role;
	
	@Column(name="selling_price")
	private Integer sellingPrice;

	private String country;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "consultant_id")
	private Consultant consultant;
	
	private int cost;
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Integer sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getClientName() {
		return getClient().getName();
	}
	
	public Integer getClientId() {
		return getClient().getId();
	}
	
	public Consultant getConsultant() {
		return consultant;
	}

	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}

	public Integer getConsultantId() {
		return getConsultant().getId();
	}
	
	public Integer getBusinessManagerId() {
		return getConsultant().getBusinessManagerId();
	}

	public Integer getMargin() {
		return Math.round(getSellingPrice() - getCost());
	}
	
	public Integer getMarginPercentage() {
		return Math.round(getMargin() * 100 / getCost()); 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (! (obj instanceof Mission)) {
			return false;
		}
		Mission other = (Mission) obj;
		return this.getId().equals(other.getId());
	}
	
	//Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getId().hashCode();
        return result;
    }
}
