package com.directv.serviceable.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.directv.serviceable.domain.Address;
import com.directv.serviceable.utils.LoggerUtils;

@RequestMapping("/check")
@Controller
public class AddressController {
	
	@RequestMapping
	public void check(@RequestParam String zip, Model model) throws Exception {
		LoggerUtils.debug(this.getClass(), "called check");
		
		Address address = new Address();
		address.setStreetNum("2260");
		address.setStreet("East Imperial");
		address.setUnit("");
		address.setStateCode("CA");
		address.setZip("90245");
		model.addAttribute("check", address);
	}
	
}
