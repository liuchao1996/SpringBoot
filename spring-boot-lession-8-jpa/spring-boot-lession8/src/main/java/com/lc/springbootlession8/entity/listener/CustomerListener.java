package com.lc.springbootlession8.entity.listener;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/**
 * 客户持久化监听器
 * @author qq165
 *
 */
public class CustomerListener {

	/**
	 * 存储之前
	 * @param source
	 */
	@PrePersist
	public void prePersist(Object source) {
		System.out.println("@PrePersist"+source);
	}
	
	/**
	 * 存储之后
	 * @param source
	 */
	@PostPersist
	public void postPersist(Object source) {
		System.out.println("@PostPersist"+source);
	}
}
