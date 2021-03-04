package com.yc.sn.web;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("sn-cart")
public interface ICartAction {

}
