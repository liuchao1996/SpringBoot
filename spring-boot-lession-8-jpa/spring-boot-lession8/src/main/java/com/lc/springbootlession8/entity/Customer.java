package com.lc.springbootlession8.entity;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.lc.springbootlession8.entity.listener.CustomerListener;

@Entity
@Access(value = AccessType.FIELD)
@Table(name = "customers")
//监听器
@EntityListeners(value = {CustomerListener.class})
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 64)
	private String name;
	
	@OneToOne
	private CreditCard card;
	
	@ManyToOne
	private Store store;
	
	@ManyToMany
	private List<Book> books;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", card=" + card + ", store=" + store + ", books=" + books
				+ "]";
	}
	
	
}
