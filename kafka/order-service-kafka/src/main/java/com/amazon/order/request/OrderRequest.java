package com.amazon.order.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderRequest {
	private String itemName;
	private String description;
	private String status;
}
