package repo.sundq.light.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.netty.handler.codec.http.HttpMethod;
import repo.sundq.light.json.HttpJsonResult;
import repo.sundq.light.persistent.jpa.Company;
import repo.sundq.light.persistent.jpa.CompanyRepository;

/**
 * 
 * @author ksun
 * @date 2018年6月3日
 */

@RestController
@RequestMapping("/company")
public class HttpCompanyController {
	private Logger logger = LoggerFactory.getLogger(HttpCompanyController.class);
	
	@Autowired
	private CompanyRepository dao_company;
	
	@RequestMapping(value="/getbyid/{id}", produces="application/json;charset=utf-8")
	public HttpJsonResult getCompany(@PathVariable int id) {
		Optional<Company> company = dao_company.findById(id);
		if(company.isPresent()) {
			return HttpJsonResult.build(200, "OK", company.get());			
		} else {
			return HttpJsonResult.build(404, "NOT FOUND", null);	
		}
	}
	
	@RequestMapping(value="/list", produces="application/json;charset=utf-8")
	public HttpJsonResult getAllCompanies() {
		List<Company> companies = dao_company.findAll();
		return HttpJsonResult.build(200, "OK", companies);
	}
	
	@RequestMapping(value="/replace", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public HttpJsonResult replaceCompany(@RequestBody Company company) {
		
		return HttpJsonResult.build(200, "OK", null);
	}
}
